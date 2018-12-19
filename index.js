const React = require("react");
var { NativeModules, Platform } = require("react-native");

if (Platform.OS === "android") {
  module.exports = NativeModules.RNEmojiCompat;
} else {
  module.exports = console.warn(
    "react-native-emoji-compat is only available on Android"
  );
}
