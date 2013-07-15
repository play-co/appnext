#import "PluginManager.h"
#import "AppNextUIView.h"

@interface AppnextPlugin : GCPlugin

@property (nonatomic, retain) AppNextUIView *adView;
@property (nonatomic, retain) NSString *placementID;
@property (nonatomic, retain) TeaLeafAppDelegate *appDelegate;

@end
