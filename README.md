# react-native-facebook-app-link
Easily fetch facebook deferred app link url and handle it without native implementation.

Inspired by [Maftalion](https://github.com/facebook/react-native-fbsdk/issues/648#issuecomment-694480302).

## Installation

```bash
yarn add react-native-fbsdk react-native-facebook-app-link
cd ios
pod install
```
In ```android/build.gradle```, check facebookSdkVersion
```
// android/build.gradle
buildscript {
    ext {
          // facebookSdkVersion should be in 7.0.0 ~ 8.0.0
          facebookSdkVersion = "7.1.0"
           ...
```
Upgrading from old version of fbsdk, you might want to call pod update for iOS.
```
pod update FBSDKShareKit FBSDKLoginKit FBSDKCoreKit
```

## Usage
```javascript
import DeferredDeepLink from 'react-native-facebook-app-link';

const url = await DeferredDeepLink.fetchUrl();

if(url){
  // do whatever with the url.
}
```

## Reference
[Maftalion's answer](https://github.com/facebook/react-native-fbsdk/issues/648#issuecomment-694480302) in react-native-fbsdk issue [#648](https://github.com/facebook/react-native-fbsdk/issues/648)

[FACEBOOK for developers - Add Deep Links to Your App Ad - Step2](https://developers.facebook.com/docs/app-ads/deep-linking)