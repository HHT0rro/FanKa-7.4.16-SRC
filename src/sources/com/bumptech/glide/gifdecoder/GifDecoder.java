package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface GifDecoder {
    public static final int STATUS_FORMAT_ERROR = 1;
    public static final int STATUS_OK = 0;
    public static final int STATUS_OPEN_ERROR = 2;
    public static final int STATUS_PARTIAL_DECODE = 3;
    public static final int TOTAL_ITERATION_COUNT_FOREVER = 0;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface BitmapProvider {
        @NonNull
        Bitmap obtain(int i10, int i11, @NonNull Bitmap.Config config);

        @NonNull
        byte[] obtainByteArray(int i10);

        @NonNull
        int[] obtainIntArray(int i10);

        void release(@NonNull Bitmap bitmap);

        void release(@NonNull byte[] bArr);

        void release(@NonNull int[] iArr);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public @interface GifDecodeStatus {
    }

    void advance();

    void clear();

    int getByteSize();

    int getCurrentFrameIndex();

    @NonNull
    ByteBuffer getData();

    int getDelay(int i10);

    int getFrameCount();

    int getHeight();

    @Deprecated
    int getLoopCount();

    int getNetscapeLoopCount();

    int getNextDelay();

    @Nullable
    Bitmap getNextFrame();

    int getStatus();

    int getTotalIterationCount();

    int getWidth();

    int read(@Nullable InputStream inputStream, int i10);

    int read(@Nullable byte[] bArr);

    void resetFrameIndex();

    void setData(@NonNull GifHeader gifHeader, @NonNull ByteBuffer byteBuffer);

    void setData(@NonNull GifHeader gifHeader, @NonNull ByteBuffer byteBuffer, int i10);

    void setData(@NonNull GifHeader gifHeader, @NonNull byte[] bArr);

    void setDefaultBitmapConfig(@NonNull Bitmap.Config config);
}
