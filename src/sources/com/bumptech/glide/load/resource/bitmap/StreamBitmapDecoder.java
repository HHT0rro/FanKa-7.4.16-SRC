package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.util.ExceptionPassthroughInputStream;
import com.bumptech.glide.util.MarkEnforcingInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class StreamBitmapDecoder implements ResourceDecoder<InputStream, Bitmap> {
    private final ArrayPool byteArrayPool;
    private final Downsampler downsampler;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class UntrustedCallbacks implements Downsampler.DecodeCallbacks {
        private final RecyclableBufferedInputStream bufferedStream;
        private final ExceptionPassthroughInputStream exceptionStream;

        public UntrustedCallbacks(RecyclableBufferedInputStream recyclableBufferedInputStream, ExceptionPassthroughInputStream exceptionPassthroughInputStream) {
            this.bufferedStream = recyclableBufferedInputStream;
            this.exceptionStream = exceptionPassthroughInputStream;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks
        public void onDecodeComplete(BitmapPool bitmapPool, Bitmap bitmap) throws IOException {
            IOException exception = this.exceptionStream.getException();
            if (exception != null) {
                if (bitmap != null) {
                    bitmapPool.put(bitmap);
                    throw exception;
                }
                throw exception;
            }
        }

        @Override // com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks
        public void onObtainBounds() {
            this.bufferedStream.fixMarkLimit();
        }
    }

    public StreamBitmapDecoder(Downsampler downsampler, ArrayPool arrayPool) {
        this.downsampler = downsampler;
        this.byteArrayPool = arrayPool;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public Resource<Bitmap> decode(@NonNull InputStream inputStream, int i10, int i11, @NonNull Options options) throws IOException {
        RecyclableBufferedInputStream recyclableBufferedInputStream;
        boolean z10;
        if (inputStream instanceof RecyclableBufferedInputStream) {
            recyclableBufferedInputStream = (RecyclableBufferedInputStream) inputStream;
            z10 = false;
        } else {
            recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, this.byteArrayPool);
            z10 = true;
        }
        ExceptionPassthroughInputStream obtain = ExceptionPassthroughInputStream.obtain(recyclableBufferedInputStream);
        try {
            return this.downsampler.decode(new MarkEnforcingInputStream(obtain), i10, i11, options, new UntrustedCallbacks(recyclableBufferedInputStream, obtain));
        } finally {
            obtain.release();
            if (z10) {
                recyclableBufferedInputStream.release();
            }
        }
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(@NonNull InputStream inputStream, @NonNull Options options) {
        return this.downsampler.handles(inputStream);
    }
}
