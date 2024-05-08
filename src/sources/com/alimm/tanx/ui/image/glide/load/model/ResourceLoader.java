package com.alimm.tanx.ui.image.glide.load.model;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;
import com.alimm.tanx.ui.image.glide.load.data.DataFetcher;
import org.apache.commons.io.IOUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ResourceLoader<T> implements ModelLoader<Integer, T> {
    public static final String TAG = "ResourceLoader";
    public final Resources resources;
    public final ModelLoader<Uri, T> uriLoader;

    public ResourceLoader(Context context, ModelLoader<Uri, T> modelLoader) {
        this(context.getResources(), modelLoader);
    }

    public ResourceLoader(Resources resources, ModelLoader<Uri, T> modelLoader) {
        this.resources = resources;
        this.uriLoader = modelLoader;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoader
    public DataFetcher<T> getResourceFetcher(Integer num, int i10, int i11) {
        Uri uri;
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("android.resource://");
            sb2.append(this.resources.getResourcePackageName(num.intValue()));
            sb2.append(IOUtils.DIR_SEPARATOR_UNIX);
            sb2.append(this.resources.getResourceTypeName(num.intValue()));
            sb2.append(IOUtils.DIR_SEPARATOR_UNIX);
            sb2.append(this.resources.getResourceEntryName(num.intValue()));
            uri = Uri.parse(sb2.toString());
        } catch (Resources.NotFoundException unused) {
            if (Log.isLoggable(TAG, 5)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Received invalid resource id: ");
                sb3.append((Object) num);
            }
            uri = null;
        }
        if (uri != null) {
            return this.uriLoader.getResourceFetcher(uri, i10, i11);
        }
        return null;
    }
}
