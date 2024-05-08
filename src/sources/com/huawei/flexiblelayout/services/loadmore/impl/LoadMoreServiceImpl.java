package com.huawei.flexiblelayout.services.loadmore.impl;

import com.huawei.flexiblelayout.services.loadmore.LoadMoreListener;
import com.huawei.flexiblelayout.services.loadmore.LoadMoreService;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class LoadMoreServiceImpl implements LoadMoreService {

    /* renamed from: a, reason: collision with root package name */
    private LoadMoreListener f28621a;

    @Override // com.huawei.flexiblelayout.services.loadmore.LoadMoreService
    public LoadMoreListener getLoadMoreListener() {
        return this.f28621a;
    }

    @Override // com.huawei.flexiblelayout.services.loadmore.LoadMoreService
    public void registerLoadMoreListener(LoadMoreListener loadMoreListener) {
        this.f28621a = loadMoreListener;
    }
}
