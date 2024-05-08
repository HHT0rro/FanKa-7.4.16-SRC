package com.alimm.tanx.ui.image.glide.load.resource.file;

import com.alimm.tanx.ui.image.glide.load.Encoder;
import com.alimm.tanx.ui.image.glide.load.ResourceDecoder;
import com.alimm.tanx.ui.image.glide.load.ResourceEncoder;
import com.alimm.tanx.ui.image.glide.load.engine.Resource;
import com.alimm.tanx.ui.image.glide.load.model.StreamEncoder;
import com.alimm.tanx.ui.image.glide.load.resource.NullResourceEncoder;
import com.alimm.tanx.ui.image.glide.provider.DataLoadProvider;
import java.io.File;
import java.io.InputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class StreamFileDataLoadProvider implements DataLoadProvider<InputStream, File> {
    public static final ErrorSourceDecoder ERROR_DECODER = new ErrorSourceDecoder(null);
    public final ResourceDecoder<File, File> cacheDecoder = new FileDecoder();
    public final Encoder<InputStream> encoder = new StreamEncoder();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class ErrorSourceDecoder implements ResourceDecoder<InputStream, File> {
        public ErrorSourceDecoder() {
        }

        @Override // com.alimm.tanx.ui.image.glide.load.ResourceDecoder
        public String getId() {
            return "";
        }

        public /* synthetic */ ErrorSourceDecoder(AnonymousClass1 anonymousClass1) {
        }

        @Override // com.alimm.tanx.ui.image.glide.load.ResourceDecoder
        public Resource<File> decode(InputStream inputStream, int i10, int i11) {
            throw new Error("You cannot decode a File from an InputStream by default, try either #diskCacheStratey(DiskCacheStrategy.SOURCE) to avoid this call or #decoder(ResourceDecoder) to replace this Decoder");
        }
    }

    @Override // com.alimm.tanx.ui.image.glide.provider.DataLoadProvider
    public ResourceDecoder<File, File> getCacheDecoder() {
        return this.cacheDecoder;
    }

    @Override // com.alimm.tanx.ui.image.glide.provider.DataLoadProvider
    public ResourceEncoder<File> getEncoder() {
        return NullResourceEncoder.get();
    }

    @Override // com.alimm.tanx.ui.image.glide.provider.DataLoadProvider
    public ResourceDecoder<InputStream, File> getSourceDecoder() {
        return ERROR_DECODER;
    }

    @Override // com.alimm.tanx.ui.image.glide.provider.DataLoadProvider
    public Encoder<InputStream> getSourceEncoder() {
        return this.encoder;
    }
}
