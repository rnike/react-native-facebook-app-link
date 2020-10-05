#import "FacebookAppLink.h"
#import <FBSDKCoreKit/FBSDKCoreKit.h>

@implementation FacebookAppLink

RCT_EXPORT_MODULE()

RCT_REMAP_METHOD(fetchUrl,
                 resolver:(RCTPromiseResolveBlock)resolve
                 rejecter:(RCTPromiseRejectBlock)reject)
{
  dispatch_async(dispatch_get_main_queue(), ^{
    [FBSDKAppLinkUtility fetchDeferredAppLink:^(NSURL *url, NSError *error) {
      if (error) {
        reject(@"error", @"Fail to fetch deferred deeplink", error);
      }
      if (url) {
        NSString* appLink = [NSString stringWithFormat:@"%@", url];
        resolve(appLink);
      }
      resolve(nil);
    }];
  });
}

RCT_EXPORT_METHOD(initializeSDK)
{
  [FBSDKSettings setAutoInitEnabled:YES];
  [FBSDKApplicationDelegate initializeSDK:nil];
}

@end
