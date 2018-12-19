
package com.sara.rnemojicompat;
import android.widget.Toast;
import android.support.text.emoji.EmojiCompat;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import android.support.text.emoji.bundled.BundledEmojiCompatConfig;
import java.util.Map;
import java.util.HashMap;
import javax.annotation.Nullable;
import android.util.Log;
public class RNEmojiCompatModule extends ReactContextBaseJavaModule {

    //    Delete
    private static final String DURATION_SHORT_KEY = "SHORT";
    private static final String DURATION_LONG_KEY = "LONG";
    //    Delete

    private static final String TAG = "MainActivity";

    // [U+1F469] (WOMAN) + [U+200D] (ZERO WIDTH JOINER) + [U+1F4BB] (PERSONAL COMPUTER)
    private static final String WOMAN_TECHNOLOGIST = "\uD83D\uDC69\u200D\uD83D\uDCBB";

    // [U+1F469] (WOMAN) + [U+200D] (ZERO WIDTH JOINER) + [U+1F3A4] (MICROPHONE)
    private static final String WOMAN_SINGER = "\uD83D\uDC69\u200D\uD83C\uDFA4";

    static final String EMOJI = WOMAN_TECHNOLOGIST + " " + WOMAN_SINGER;
    private final ReactApplicationContext reactContext;

    public RNEmojiCompatModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }
    @Override
    public String getName() {
        return "RNEmojiCompat";
    }
    @ReactMethod
    public void initialize() {
        final EmojiCompat.Config config;
            // Use the bundled font for EmojiCompat
            config = new BundledEmojiCompatConfig(reactContext);


        config.setReplaceAll(true)
                .registerInitCallback(new EmojiCompat.InitCallback() {
                    @Override
                    public void onInitialized() {
                        Log.i(TAG, "EmojiCompat initialized");
                    }

                    @Override
                    public void onFailed(@Nullable Throwable throwable) {
                        Log.e(TAG, "EmojiCompat initialization failed", throwable);
                    }
                });

        EmojiCompat.init(config);    }
    @Override
    public Map<String, Object> getConstants() {
        final Map<String, Object> constants = new HashMap<>();
        constants.put(DURATION_SHORT_KEY, Toast.LENGTH_SHORT);
        constants.put(DURATION_LONG_KEY, Toast.LENGTH_LONG);
        return constants;
    }

    @ReactMethod
    public void show(String emoji) {
        initialize();

//        setContentView(R.layout.activity_main);

        // TextView variant provided by EmojiCompat library
//        final TextView emojiTextView = findViewById(R.id.emoji_text_view);
//        emojiTextView.setText(getString(R.string.emoji_text_view, emoji));
//        return emoji;
    }

}