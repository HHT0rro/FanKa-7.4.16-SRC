package com.alimm.tanx.ui.image.glide.load.model;

import com.alimm.tanx.ui.image.glide.load.data.DataFetcher;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface ModelLoader<T, Y> {
    DataFetcher<Y> getResourceFetcher(T t2, int i10, int i11);
}
