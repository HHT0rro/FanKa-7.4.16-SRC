package com.alimm.tanx.ui.image.glide.load.model;

import android.net.Uri;
import com.alimm.tanx.ui.image.glide.load.data.DataFetcher;
import java.io.File;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class FileLoader<T> implements ModelLoader<File, T> {
    public final ModelLoader<Uri, T> uriLoader;

    public FileLoader(ModelLoader<Uri, T> modelLoader) {
        this.uriLoader = modelLoader;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoader
    public DataFetcher<T> getResourceFetcher(File file, int i10, int i11) {
        return this.uriLoader.getResourceFetcher(Uri.fromFile(file), i10, i11);
    }
}
