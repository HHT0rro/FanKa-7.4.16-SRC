package io.flutter.view;

import android.graphics.SurfaceTexture;
import android.media.Image;
import android.view.Surface;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface TextureRegistry {

    @Keep
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface ImageConsumer extends TextureEntry {
        Image acquireLatestImage();
    }

    @Keep
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface ImageTextureEntry extends TextureEntry {
        @Override // io.flutter.view.TextureRegistry.TextureEntry
        long id();

        void pushImage(Image image);

        @Override // io.flutter.view.TextureRegistry.TextureEntry
        void release();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface OnFrameConsumedListener {
        void onFrameConsumed();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface OnTrimMemoryListener {
        void onTrimMemory(int i10);
    }

    @Keep
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface SurfaceProducer extends TextureEntry {
        int getHeight();

        Surface getSurface();

        int getWidth();

        @Override // io.flutter.view.TextureRegistry.TextureEntry
        long id();

        @Override // io.flutter.view.TextureRegistry.TextureEntry
        void release();

        void setSize(int i10, int i11);
    }

    @Keep
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface SurfaceTextureEntry extends TextureEntry {
        @Override // io.flutter.view.TextureRegistry.TextureEntry
        long id();

        @Override // io.flutter.view.TextureRegistry.TextureEntry
        void release();

        void setOnFrameConsumedListener(@Nullable OnFrameConsumedListener onFrameConsumedListener);

        void setOnTrimMemoryListener(@Nullable OnTrimMemoryListener onTrimMemoryListener);

        @NonNull
        SurfaceTexture surfaceTexture();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface TextureEntry {
        long id();

        void release();
    }

    @NonNull
    ImageTextureEntry createImageTexture();

    @NonNull
    SurfaceProducer createSurfaceProducer();

    @NonNull
    SurfaceTextureEntry createSurfaceTexture();

    void onTrimMemory(int i10);

    @NonNull
    SurfaceTextureEntry registerSurfaceTexture(@NonNull SurfaceTexture surfaceTexture);
}
