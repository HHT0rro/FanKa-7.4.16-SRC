package com.alimm.tanx.ui.image.glide.load.data;

import android.content.res.AssetManager;
import android.util.Log;
import com.alimm.tanx.ui.image.glide.Priority;
import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class AssetPathFetcher<T> implements DataFetcher<T> {
    public static final String TAG = "AssetUriFetcher";
    public final AssetManager assetManager;
    public final String assetPath;
    public T data;

    public AssetPathFetcher(AssetManager assetManager, String str) {
        this.assetManager = assetManager;
        this.assetPath = str;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.data.DataFetcher
    public void cancel() {
    }

    @Override // com.alimm.tanx.ui.image.glide.load.data.DataFetcher
    public void cleanup() {
        T t2 = this.data;
        if (t2 == null) {
            return;
        }
        try {
            close(t2);
        } catch (IOException unused) {
            Log.isLoggable(TAG, 2);
        }
    }

    public abstract void close(T t2) throws IOException;

    @Override // com.alimm.tanx.ui.image.glide.load.data.DataFetcher
    public String getId() {
        return this.assetPath;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.data.DataFetcher
    public T loadData(Priority priority) throws Exception {
        T loadResource = loadResource(this.assetManager, this.assetPath);
        this.data = loadResource;
        return loadResource;
    }

    public abstract T loadResource(AssetManager assetManager, String str) throws IOException;
}
