package com.alimm.tanx.ui.image.glide.load.resource.gifbitmap;

import android.graphics.Bitmap;
import com.alimm.tanx.ui.image.glide.load.Encoder;
import com.alimm.tanx.ui.image.glide.load.ResourceDecoder;
import com.alimm.tanx.ui.image.glide.load.ResourceEncoder;
import com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool;
import com.alimm.tanx.ui.image.glide.load.model.ImageVideoWrapper;
import com.alimm.tanx.ui.image.glide.load.resource.file.FileToStreamDecoder;
import com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable;
import com.alimm.tanx.ui.image.glide.provider.DataLoadProvider;
import java.io.File;
import java.io.InputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ImageVideoGifDrawableLoadProvider implements DataLoadProvider<ImageVideoWrapper, GifBitmapWrapper> {
    public final ResourceDecoder<File, GifBitmapWrapper> cacheDecoder;
    public final ResourceEncoder<GifBitmapWrapper> encoder;
    public final ResourceDecoder<ImageVideoWrapper, GifBitmapWrapper> sourceDecoder;
    public final Encoder<ImageVideoWrapper> sourceEncoder;

    public ImageVideoGifDrawableLoadProvider(DataLoadProvider<ImageVideoWrapper, Bitmap> dataLoadProvider, DataLoadProvider<InputStream, GifDrawable> dataLoadProvider2, BitmapPool bitmapPool) {
        GifBitmapWrapperResourceDecoder gifBitmapWrapperResourceDecoder = new GifBitmapWrapperResourceDecoder(dataLoadProvider.getSourceDecoder(), dataLoadProvider2.getSourceDecoder(), bitmapPool);
        this.cacheDecoder = new FileToStreamDecoder(new GifBitmapWrapperStreamResourceDecoder(gifBitmapWrapperResourceDecoder));
        this.sourceDecoder = gifBitmapWrapperResourceDecoder;
        this.encoder = new GifBitmapWrapperResourceEncoder(dataLoadProvider.getEncoder(), dataLoadProvider2.getEncoder());
        this.sourceEncoder = dataLoadProvider.getSourceEncoder();
    }

    @Override // com.alimm.tanx.ui.image.glide.provider.DataLoadProvider
    public ResourceDecoder<File, GifBitmapWrapper> getCacheDecoder() {
        return this.cacheDecoder;
    }

    @Override // com.alimm.tanx.ui.image.glide.provider.DataLoadProvider
    public ResourceEncoder<GifBitmapWrapper> getEncoder() {
        return this.encoder;
    }

    @Override // com.alimm.tanx.ui.image.glide.provider.DataLoadProvider
    public ResourceDecoder<ImageVideoWrapper, GifBitmapWrapper> getSourceDecoder() {
        return this.sourceDecoder;
    }

    @Override // com.alimm.tanx.ui.image.glide.provider.DataLoadProvider
    public Encoder<ImageVideoWrapper> getSourceEncoder() {
        return this.sourceEncoder;
    }
}
