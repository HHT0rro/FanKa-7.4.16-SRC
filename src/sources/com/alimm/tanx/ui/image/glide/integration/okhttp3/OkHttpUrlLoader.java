package com.alimm.tanx.ui.image.glide.integration.okhttp3;

import android.content.Context;
import com.alimm.tanx.ui.image.glide.load.data.DataFetcher;
import com.alimm.tanx.ui.image.glide.load.model.GenericLoaderFactory;
import com.alimm.tanx.ui.image.glide.load.model.GlideUrl;
import com.alimm.tanx.ui.image.glide.load.model.ModelLoader;
import com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory;
import com.alimm.tanx.ui.image.glide.load.model.stream.StreamModelLoader;
import java.io.InputStream;
import okhttp3.Call;
import okhttp3.OkHttpClient;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class OkHttpUrlLoader implements StreamModelLoader<GlideUrl> {
    public final Call.Factory client;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class Factory implements ModelLoaderFactory<GlideUrl, InputStream> {
        public static volatile Call.Factory internalClient;
        public Call.Factory client;

        public Factory() {
            this(getInternalClient());
        }

        public static Call.Factory getInternalClient() {
            if (internalClient == null) {
                synchronized (Factory.class) {
                    if (internalClient == null) {
                        internalClient = new OkHttpClient();
                    }
                }
            }
            return internalClient;
        }

        @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory
        public ModelLoader<GlideUrl, InputStream> build(Context context, GenericLoaderFactory genericLoaderFactory) {
            return new OkHttpUrlLoader(this.client);
        }

        @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        public Factory(Call.Factory factory) {
            this.client = factory;
        }
    }

    public OkHttpUrlLoader(Call.Factory factory) {
        this.client = factory;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoader
    public DataFetcher<InputStream> getResourceFetcher(GlideUrl glideUrl, int i10, int i11) {
        return new OkHttpStreamFetcher(this.client, glideUrl);
    }
}
