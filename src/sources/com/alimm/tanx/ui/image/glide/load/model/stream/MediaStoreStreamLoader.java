package com.alimm.tanx.ui.image.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import com.alimm.tanx.ui.image.glide.load.data.DataFetcher;
import com.alimm.tanx.ui.image.glide.load.data.MediaStoreThumbFetcher;
import com.alimm.tanx.ui.image.glide.load.model.ModelLoader;
import java.io.InputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class MediaStoreStreamLoader implements StreamModelLoader<Uri> {
    public final Context context;
    public final ModelLoader<Uri, InputStream> uriLoader;

    public MediaStoreStreamLoader(Context context, ModelLoader<Uri, InputStream> modelLoader) {
        this.context = context;
        this.uriLoader = modelLoader;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoader
    public DataFetcher<InputStream> getResourceFetcher(Uri uri, int i10, int i11) {
        return new MediaStoreThumbFetcher(this.context, uri, this.uriLoader.getResourceFetcher(uri, i10, i11), i10, i11);
    }
}
