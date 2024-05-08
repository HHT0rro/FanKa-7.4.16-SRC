package com.alimm.tanx.ui.image.glide.load.data;

import com.alimm.tanx.ui.image.glide.Priority;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface DataFetcher<T> {
    void cancel();

    void cleanup();

    String getId();

    T loadData(Priority priority) throws Exception;
}
