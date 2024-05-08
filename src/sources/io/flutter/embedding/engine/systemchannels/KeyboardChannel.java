package io.flutter.embedding.engine.systemchannels;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.StandardMethodCodec;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class KeyboardChannel {
    public final MethodChannel channel;
    private KeyboardMethodHandler keyboardMethodHandler;

    @NonNull
    public final MethodChannel.MethodCallHandler parsingMethodHandler;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface KeyboardMethodHandler {
        Map<Long, Long> getKeyboardState();
    }

    public KeyboardChannel(@NonNull BinaryMessenger binaryMessenger) {
        MethodChannel.MethodCallHandler methodCallHandler = new MethodChannel.MethodCallHandler() { // from class: io.flutter.embedding.engine.systemchannels.KeyboardChannel.1
            public Map<Long, Long> pressedState = new HashMap();

            @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
            public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
                if (KeyboardChannel.this.keyboardMethodHandler == null) {
                    result.success(this.pressedState);
                    return;
                }
                String str = methodCall.method;
                str.hashCode();
                if (!str.equals("getKeyboardState")) {
                    result.notImplemented();
                    return;
                }
                try {
                    this.pressedState = KeyboardChannel.this.keyboardMethodHandler.getKeyboardState();
                } catch (IllegalStateException e2) {
                    result.error("error", e2.getMessage(), null);
                }
                result.success(this.pressedState);
            }
        };
        this.parsingMethodHandler = methodCallHandler;
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, "flutter/keyboard", StandardMethodCodec.INSTANCE);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(methodCallHandler);
    }

    public void setKeyboardMethodHandler(@Nullable KeyboardMethodHandler keyboardMethodHandler) {
        this.keyboardMethodHandler = keyboardMethodHandler;
    }
}
