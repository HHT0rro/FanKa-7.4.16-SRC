package com.alimm.tanx.ui.image.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.ParcelFileDescriptor;
import com.alimm.tanx.ui.image.glide.load.DecodeFormat;
import com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool;
import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class VideoBitmapDecoder implements BitmapDecoder<ParcelFileDescriptor> {
    public static final MediaMetadataRetrieverFactory DEFAULT_FACTORY = new MediaMetadataRetrieverFactory();
    public static final int NO_FRAME = -1;
    public MediaMetadataRetrieverFactory factory;
    public int frame;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class MediaMetadataRetrieverFactory {
        public MediaMetadataRetriever build() {
            return new MediaMetadataRetriever();
        }
    }

    public VideoBitmapDecoder() {
        this(DEFAULT_FACTORY, -1);
    }

    public static int checkValidFrame(int i10) {
        if (i10 >= 0) {
            return i10;
        }
        throw new IllegalArgumentException("Requested frame must be non-negative");
    }

    @Override // com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapDecoder
    public String getId() {
        return "VideoBitmapDecoder.com.alimm.tanx.ui.image.glide.load.resource.bitmap";
    }

    public VideoBitmapDecoder(int i10) {
        this(DEFAULT_FACTORY, checkValidFrame(i10));
    }

    @Override // com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapDecoder
    public Bitmap decode(ParcelFileDescriptor parcelFileDescriptor, BitmapPool bitmapPool, int i10, int i11, DecodeFormat decodeFormat) throws IOException {
        Bitmap frameAtTime;
        MediaMetadataRetriever build = this.factory.build();
        build.setDataSource(parcelFileDescriptor.getFileDescriptor());
        int i12 = this.frame;
        if (i12 >= 0) {
            frameAtTime = build.getFrameAtTime(i12);
        } else {
            frameAtTime = build.getFrameAtTime();
        }
        build.release();
        parcelFileDescriptor.close();
        return frameAtTime;
    }

    public VideoBitmapDecoder(MediaMetadataRetrieverFactory mediaMetadataRetrieverFactory) {
        this.factory = mediaMetadataRetrieverFactory;
        this.frame = -1;
    }

    public VideoBitmapDecoder(MediaMetadataRetrieverFactory mediaMetadataRetrieverFactory, int i10) {
        this.factory = mediaMetadataRetrieverFactory;
        this.frame = i10;
    }
}
