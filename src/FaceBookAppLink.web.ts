/**
 * This file is added for not breaking react-native-web.
 *
 * fetchUrl should always return undefined if is called on web.
 */
export default {
  fetchUrl: () => Promise.resolve(undefined),
};
