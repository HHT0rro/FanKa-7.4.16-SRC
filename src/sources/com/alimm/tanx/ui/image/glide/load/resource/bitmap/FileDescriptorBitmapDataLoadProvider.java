package com.alimm.tanx.ui.image.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import com.alimm.tanx.ui.image.glide.load.DecodeFormat;
import com.alimm.tanx.ui.image.glide.load.Encoder;
import com.alimm.tanx.ui.image.glide.load.ResourceDecoder;
import com.alimm.tanx.ui.image.glide.load.ResourceEncoder;
import com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool;
import com.alimm.tanx.ui.image.glide.load.resource.NullEncoder;
import com.alimm.tanx.ui.image.glide.load.resource.file.FileToStreamDecoder;
import com.alimm.tanx.ui.image.glide.provider.DataLoadProvider;
import java.io.File;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class FileDescriptorBitmapDataLoadProvider implements DataLoadProvider<ParcelFileDescriptor, Bitmap> {
    public final ResourceDecoder<File, Bitmap> cacheDecoder;
    public final FileDescriptorBitmapDecoder sourceDecoder;
    public final BitmapEncoder encoder = new BitmapEncoder();
    public final Encoder<ParcelFileDescriptor> sourceEncoder = NullEncoder.get();

    public FileDescriptorBitmapDataLoadProvider(BitmapPool bitmapPool, DecodeFormat decodeFormat) {
        this.cacheDecoder = new FileToStreamDecoder(new StreamBitmapDecoder(bitmapPool, decodeFormat));
        this.sourceDecoder = new FileDescriptorBitmapDecoder(bitmapPool, decodeFormat);
    }

    @Override // com.alimm.tanx.ui.image.glide.provider.DataLoadProvider
    public ResourceDecoder<File, Bitmap> getCacheDecoder() {
        return this.cacheDecoder;
    }

    @Override // com.alimm.tanx.ui.image.glide.provider.DataLoadProvider
    public ResourceEncoder<Bitmap> getEncoder() {
        return this.encoder;
    }

    @Override // com.alimm.tanx.ui.image.glide.provider.DataLoadProvider
    public ResourceDecoder<ParcelFileDescriptor, Bitmap> getSourceDecoder() {
        return this.sourceDecoder;
    }

    @Override // com.alimm.tanx.ui.image.glide.provider.DataLoadProvider
    public Encoder<ParcelFileDescriptor> getSourceEncoder() {
        return this.sourceEncoder;
    }
}
