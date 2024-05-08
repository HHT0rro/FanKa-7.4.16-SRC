package com.bumptech.glide.load.model.stream;

import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.UrlUriLoader;
import java.io.InputStream;

@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class HttpUriLoader extends UrlUriLoader<InputStream> {

    @Deprecated
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class Factory extends UrlUriLoader.StreamFactory {
    }

    public HttpUriLoader(ModelLoader<GlideUrl, InputStream> modelLoader) {
        super(modelLoader);
    }
}
