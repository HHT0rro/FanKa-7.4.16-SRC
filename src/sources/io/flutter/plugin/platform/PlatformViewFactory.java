package io.flutter.plugin.platform;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.plugin.common.MessageCodec;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class PlatformViewFactory {
    private final MessageCodec<Object> createArgsCodec;

    public PlatformViewFactory(@Nullable MessageCodec<Object> messageCodec) {
        this.createArgsCodec = messageCodec;
    }

    @NonNull
    public abstract PlatformView create(Context context, int i10, @Nullable Object obj);

    @Nullable
    public final MessageCodec<Object> getCreateArgsCodec() {
        return this.createArgsCodec;
    }
}
