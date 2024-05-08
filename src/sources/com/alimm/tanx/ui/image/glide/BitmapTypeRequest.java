package com.alimm.tanx.ui.image.glide;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import com.alimm.tanx.ui.image.glide.RequestManager;
import com.alimm.tanx.ui.image.glide.load.model.ImageVideoModelLoader;
import com.alimm.tanx.ui.image.glide.load.model.ImageVideoWrapper;
import com.alimm.tanx.ui.image.glide.load.model.ModelLoader;
import com.alimm.tanx.ui.image.glide.load.resource.transcode.BitmapBytesTranscoder;
import com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder;
import com.alimm.tanx.ui.image.glide.provider.FixedLoadProvider;
import java.io.InputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class BitmapTypeRequest<ModelType> extends BitmapRequestBuilder<ModelType, Bitmap> {
    public final ModelLoader<ModelType, ParcelFileDescriptor> fileDescriptorModelLoader;
    public final Glide glide;
    public final RequestManager.OptionsApplier optionsApplier;
    public final ModelLoader<ModelType, InputStream> streamModelLoader;

    public BitmapTypeRequest(GenericRequestBuilder<ModelType, ?, ?, ?> genericRequestBuilder, ModelLoader<ModelType, InputStream> modelLoader, ModelLoader<ModelType, ParcelFileDescriptor> modelLoader2, RequestManager.OptionsApplier optionsApplier) {
        super(buildProvider(genericRequestBuilder.glide, modelLoader, modelLoader2, Bitmap.class, null), Bitmap.class, genericRequestBuilder);
        this.streamModelLoader = modelLoader;
        this.fileDescriptorModelLoader = modelLoader2;
        this.glide = genericRequestBuilder.glide;
        this.optionsApplier = optionsApplier;
    }

    public static <A, R> FixedLoadProvider<A, ImageVideoWrapper, Bitmap, R> buildProvider(Glide glide, ModelLoader<A, InputStream> modelLoader, ModelLoader<A, ParcelFileDescriptor> modelLoader2, Class<R> cls, ResourceTranscoder<Bitmap, R> resourceTranscoder) {
        if (modelLoader == null && modelLoader2 == null) {
            return null;
        }
        if (resourceTranscoder == null) {
            resourceTranscoder = glide.buildTranscoder(Bitmap.class, cls);
        }
        return new FixedLoadProvider<>(new ImageVideoModelLoader(modelLoader, modelLoader2), resourceTranscoder, glide.buildDataProvider(ImageVideoWrapper.class, Bitmap.class));
    }

    public BitmapRequestBuilder<ModelType, byte[]> toBytes() {
        return (BitmapRequestBuilder<ModelType, byte[]>) transcode(new BitmapBytesTranscoder(), byte[].class);
    }

    public <R> BitmapRequestBuilder<ModelType, R> transcode(ResourceTranscoder<Bitmap, R> resourceTranscoder, Class<R> cls) {
        return (BitmapRequestBuilder) this.optionsApplier.apply(new BitmapRequestBuilder(buildProvider(this.glide, this.streamModelLoader, this.fileDescriptorModelLoader, cls, resourceTranscoder), cls, this));
    }

    public BitmapRequestBuilder<ModelType, byte[]> toBytes(Bitmap.CompressFormat compressFormat, int i10) {
        return (BitmapRequestBuilder<ModelType, byte[]>) transcode(new BitmapBytesTranscoder(compressFormat, i10), byte[].class);
    }
}
