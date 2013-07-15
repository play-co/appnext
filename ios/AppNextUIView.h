//
//  AppNextUIView.h
//  AppNextSDK
//
//  Created by administrator on 12/17/12.
//  Copyright (c) 2012 administrator. All rights reserved.
//

#import <UIKit/UIKit.h>
#import <QuartzCore/QuartzCore.h>
#import <AdSupport/ASIdentifierManager.h>
#include <sys/socket.h>
#include <sys/sysctl.h>
#include <net/if.h>
#include <net/if_dl.h>

@protocol NoAdsDelegate <NSObject>

- (void)noAds;

@end

id delegate;
@interface AppNextUIView : UIView

- (AppNextUIView *)newAppNextUIView;
- (void)hidePopup;
- (void)showPopup;
- (void)refreshAds;
- (void)setID:(NSString *)appid;

- (void)setNoAdsDelegate:(id)delegate;


@end
