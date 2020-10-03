import { NativeModules } from 'react-native';

let _fetchUrl: Promise<string | undefined>;

const fetchUrl: () => Promise<string | undefined> = () => {
  if (!_fetchUrl) {
    _fetchUrl = new Promise<string | undefined>((resolve, _reject) => {
      NativeModules.DeferredDeepLink.fetchUrl()
        .then((url: string | undefined) => resolve(url))
        .catch((e: any) => {
          console.log('[react-native-deferred-deep-link]: fetch fail', e);
          resolve();
        });
    });
  }

  return _fetchUrl;
};

export default {
  fetchUrl,
};
