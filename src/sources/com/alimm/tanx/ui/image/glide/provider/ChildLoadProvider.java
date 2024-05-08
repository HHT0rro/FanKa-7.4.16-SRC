package com.alimm.tanx.ui.image.glide.provider;

import com.alimm.tanx.ui.image.glide.load.Encoder;
import com.alimm.tanx.ui.image.glide.load.ResourceDecoder;
import com.alimm.tanx.ui.image.glide.load.ResourceEncoder;
import com.alimm.tanx.ui.image.glide.load.model.ModelLoader;
import com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder;
import java.io.File;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ChildLoadProvider<A, T, Z, R> implements LoadProvider<A, T, Z, R>, Cloneable {
    public ResourceDecoder<File, Z> cacheDecoder;
    public ResourceEncoder<Z> encoder;
    public final LoadProvider<A, T, Z, R> parent;
    public ResourceDecoder<T, Z> sourceDecoder;
    public Encoder<T> sourceEncoder;
    public ResourceTranscoder<Z, R> transcoder;

    public ChildLoadProvider(LoadProvider<A, T, Z, R> loadProvider) {
        this.parent = loadProvider;
    }

    @Override // com.alimm.tanx.ui.image.glide.provider.DataLoadProvider
    public ResourceDecoder<File, Z> getCacheDecoder() {
        ResourceDecoder<File, Z> resourceDecoder = this.cacheDecoder;
        return resourceDecoder != null ? resourceDecoder : this.parent.getCacheDecoder();
    }

    @Override // com.alimm.tanx.ui.image.glide.provider.DataLoadProvider
    public ResourceEncoder<Z> getEncoder() {
        ResourceEncoder<Z> resourceEncoder = this.encoder;
        return resourceEncoder != null ? resourceEncoder : this.parent.getEncoder();
    }

    @Override // com.alimm.tanx.ui.image.glide.provider.LoadProvider
    public ModelLoader<A, T> getModelLoader() {
        return this.parent.getModelLoader();
    }

    @Override // com.alimm.tanx.ui.image.glide.provider.DataLoadProvider
    public ResourceDecoder<T, Z> getSourceDecoder() {
        ResourceDecoder<T, Z> resourceDecoder = this.sourceDecoder;
        return resourceDecoder != null ? resourceDecoder : this.parent.getSourceDecoder();
    }

    @Override // com.alimm.tanx.ui.image.glide.provider.DataLoadProvider
    public Encoder<T> getSourceEncoder() {
        Encoder<T> encoder = this.sourceEncoder;
        return encoder != null ? encoder : this.parent.getSourceEncoder();
    }

    @Override // com.alimm.tanx.ui.image.glide.provider.LoadProvider
    public ResourceTranscoder<Z, R> getTranscoder() {
        ResourceTranscoder<Z, R> resourceTranscoder = this.transcoder;
        return resourceTranscoder != null ? resourceTranscoder : this.parent.getTranscoder();
    }

    public void setCacheDecoder(ResourceDecoder<File, Z> resourceDecoder) {
        this.cacheDecoder = resourceDecoder;
    }

    public void setEncoder(ResourceEncoder<Z> resourceEncoder) {
        this.encoder = resourceEncoder;
    }

    public void setSourceDecoder(ResourceDecoder<T, Z> resourceDecoder) {
        this.sourceDecoder = resourceDecoder;
    }

    public void setSourceEncoder(Encoder<T> encoder) {
        this.sourceEncoder = encoder;
    }

    public void setTranscoder(ResourceTranscoder<Z, R> resourceTranscoder) {
        this.transcoder = resourceTranscoder;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public ChildLoadProvider<A, T, Z, R> m1955clone() {
        try {
            return (ChildLoadProvider) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }
}
