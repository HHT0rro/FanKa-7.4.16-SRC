package com.alimm.tanx.ui.image.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import com.alimm.tanx.ui.image.glide.load.Encoder;
import com.alimm.tanx.ui.image.glide.load.ResourceDecoder;
import com.alimm.tanx.ui.image.glide.load.ResourceEncoder;
import com.alimm.tanx.ui.image.glide.load.model.ImageVideoWrapper;
import com.alimm.tanx.ui.image.glide.load.model.ImageVideoWrapperEncoder;
import com.alimm.tanx.ui.image.glide.provider.DataLoadProvider;
import java.io.File;
import java.io.InputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ImageVideoDataLoadProvider implements DataLoadProvider<ImageVideoWrapper, Bitmap> {
    public final ResourceDecoder<File, Bitmap> cacheDecoder;
    public final ResourceEncoder<Bitmap> encoder;
    public final ImageVideoBitmapDecoder sourceDecoder;
    public final ImageVideoWrapperEncoder sourceEncoder;

    public ImageVideoDataLoadProvider(DataLoadProvider<InputStream, Bitmap> dataLoadProvider, DataLoadProvider<ParcelFileDescriptor, Bitmap> dataLoadProvider2) {
        this.encoder = dataLoadProvider.getEncoder();
        this.sourceEncoder = new ImageVideoWrapperEncoder(dataLoadProvider.getSourceEncoder(), dataLoadProvider2.getSourceEncoder());
        this.cacheDecoder = dataLoadProvider.getCacheDecoder();
        this.sourceDecoder = new ImageVideoBitmapDecoder(dataLoadProvider.getSourceDecoder(), dataLoadProvider2.getSourceDecoder());
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
    public ResourceDecoder<ImageVideoWrapper, Bitmap> getSourceDecoder() {
        return this.sourceDecoder;
    }

    @Override // com.alimm.tanx.ui.image.glide.provider.DataLoadProvider
    public Encoder<ImageVideoWrapper> getSourceEncoder() {
        return this.sourceEncoder;
    }
}
