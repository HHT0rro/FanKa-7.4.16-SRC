package com.alimm.tanx.ui.image.glide.load.data;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.alimm.tanx.ui.image.glide.Priority;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class LocalUriFetcher<T> implements DataFetcher<T> {
    public static final String TAG = "LocalUriFetcher";
    public final Context context;
    public T data;
    public final Uri uri;

    public LocalUriFetcher(Context context, Uri uri) {
        this.context = context.getApplicationContext();
        this.uri = uri;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.data.DataFetcher
    public void cancel() {
    }

    @Override // com.alimm.tanx.ui.image.glide.load.data.DataFetcher
    public void cleanup() {
        T t2 = this.data;
        if (t2 != null) {
            try {
                close(t2);
            } catch (IOException unused) {
                Log.isLoggable(TAG, 2);
            }
        }
    }

    public abstract void close(T t2) throws IOException;

    @Override // com.alimm.tanx.ui.image.glide.load.data.DataFetcher
    public String getId() {
        return this.uri.toString();
    }

    @Override // com.alimm.tanx.ui.image.glide.load.data.DataFetcher
    public final T loadData(Priority priority) throws Exception {
        T loadResource = loadResource(this.uri, this.context.getContentResolver());
        this.data = loadResource;
        return loadResource;
    }

    public abstract T loadResource(Uri uri, ContentResolver contentResolver) throws FileNotFoundException;
}
