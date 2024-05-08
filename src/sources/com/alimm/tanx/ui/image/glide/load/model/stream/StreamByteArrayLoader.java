package com.alimm.tanx.ui.image.glide.load.model.stream;

import android.content.Context;
import com.alimm.tanx.ui.image.glide.load.data.ByteArrayFetcher;
import com.alimm.tanx.ui.image.glide.load.data.DataFetcher;
import com.alimm.tanx.ui.image.glide.load.model.GenericLoaderFactory;
import com.alimm.tanx.ui.image.glide.load.model.ModelLoader;
import com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory;
import java.io.InputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class StreamByteArrayLoader implements StreamModelLoader<byte[]> {

    /* renamed from: id, reason: collision with root package name */
    public final String f4195id;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class Factory implements ModelLoaderFactory<byte[], InputStream> {
        @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory
        public ModelLoader<byte[], InputStream> build(Context context, GenericLoaderFactory genericLoaderFactory) {
            return new StreamByteArrayLoader();
        }

        @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public StreamByteArrayLoader() {
        this.f4195id = "";
    }

    @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoader
    public DataFetcher<InputStream> getResourceFetcher(byte[] bArr, int i10, int i11) {
        return new ByteArrayFetcher(bArr, this.f4195id);
    }

    @Deprecated
    public StreamByteArrayLoader(String str) {
        this.f4195id = str;
    }
}
