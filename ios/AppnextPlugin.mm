#import "AppnextPlugin.h"

@implementation AppnextPlugin

// The plugin must call super dealloc.
- (void) dealloc {
	self.adView = nil;
	self.placementID = nil;

	[super dealloc];
}

// The plugin must call super init.
- (id) init {
	self = [super init];
	if (!self) {
		return nil;
	}

	self.adView = nil;
	self.placementID = nil;

	return self;
}

- (void) initializeWithManifest:(NSDictionary *)manifest appDelegate:(TeaLeafAppDelegate *)appDelegate {
	self.appDelegate = appDelegate;

	@try {
		NSDictionary *ios = [manifest valueForKey:@"ios"];
		self.placementID = [ios valueForKey:@"appnextPlacementID"];

		NSLog(@"{appnext} Initializing with placementID: %@", self.placementID);

		[self performSelectorInBackground:@selector(initAppnext) withObject:nil];
	}
	@catch (NSException *exception) {
		NSLog(@"{appnext} Failure during startup: %@", exception);
	}
}

- (void) initAppnext{
	@try {
		self.adView = [[[[AppNextUIView alloc] init] newAppNextUIView] autorelease];

		[self.adView setID:self.placementID];

		[self performSelectorOnMainThread:@selector(addAppnext) withObject:nil waitUntilDone:NO];
	}
	@catch (NSException *exception) {
		NSLog(@"{appnext} Failure during initAppnext: %@", exception);
	}
}

- (void) addAppnext{
	@try {
		[self.appDelegate.tealeafViewController.view addSubview:self.adView];
	}
	@catch (NSException *exception) {
		NSLog(@"{appnext} Failure during addAppnext: %@", exception);
	}
}

- (void) showInterstitial:(NSDictionary *)jsonObject {
	@try {
		[self.adView showPopup];
	}
	@catch (NSException *exception) {
		NSLog(@"{appnext} Failure during interstitial: %@", exception);
	}
}

@end
