package com.alimm.tanx.ui.image.glide.provider;

import com.alimm.tanx.ui.image.glide.load.Encoder;
import com.alimm.tanx.ui.image.glide.load.ResourceDecoder;
import com.alimm.tanx.ui.image.glide.load.ResourceEncoder;
import com.alimm.tanx.ui.image.glide.load.model.ModelLoader;
import com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder;
import java.io.File;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class FixedLoadProvider<A, T, Z, R> implements LoadProvider<A, T, Z, R> {
    public final DataLoadProvider<T, Z> dataLoadProvider;
    public final ModelLoader<A, T> modelLoader;
    public final ResourceTranscoder<Z, R> transcoder;

    public FixedLoadProvider(ModelLoader<A, T> modelLoader, ResourceTranscoder<Z, R> resourceTranscoder, DataLoadProvider<T, Z> dataLoadProvider) {
        Objects.requireNonNull(modelLoader, "ModelLoader must not be null");
        this.modelLoader = modelLoader;
        Objects.requireNonNull(resourceTranscoder, "Transcoder must not be null");
        this.transcoder = resourceTranscoder;
        Objects.requireNonNull(dataLoadProvider, "DataLoadProvider must not be null");
        this.dataLoadProvider = dataLoadProvider;
    }

    @Override // com.alimm.tanx.ui.image.glide.provider.DataLoadProvider
    public ResourceDecoder<File, Z> getCacheDecoder() {
        return this.dataLoadProvider.getCacheDecoder();
    }

    @Override // com.alimm.tanx.ui.image.glide.provider.DataLoadProvider
    public ResourceEncoder<Z> getEncoder() {
        return this.dataLoadProvider.getEncoder();
    }

    @Override // com.alimm.tanx.ui.image.glide.provider.LoadProvider
    public ModelLoader<A, T> getModelLoader() {
        return this.modelLoader;
    }

    @Override // com.alimm.tanx.ui.image.glide.provider.DataLoadProvider
    public ResourceDecoder<T, Z> getSourceDecoder() {
        return this.dataLoadProvider.getSourceDecoder();
    }

    @Override // com.alimm.tanx.ui.image.glide.provider.DataLoadProvider
    public Encoder<T> getSourceEncoder() {
        return this.dataLoadProvider.getSourceEncoder();
    }

    @Override // com.alimm.tanx.ui.image.glide.provider.LoadProvider
    public ResourceTranscoder<Z, R> getTranscoder() {
        return this.transcoder;
    }
}
