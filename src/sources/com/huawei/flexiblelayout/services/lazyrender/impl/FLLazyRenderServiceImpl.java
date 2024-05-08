package com.huawei.flexiblelayout.services.lazyrender.impl;

import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.services.lazyrender.FLLazyRenderService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class FLLazyRenderServiceImpl implements FLLazyRenderService {

    /* renamed from: b, reason: collision with root package name */
    private List<FLLazyRenderService.LazyRenderListener> f28616b = Collections.synchronizedList(new ArrayList());

    /* renamed from: a, reason: collision with root package name */
    private FLLazyRenderService.LazyRenderParam f28615a = new FLLazyRenderService.LazyRenderParam();

    @Override // com.huawei.flexiblelayout.services.lazyrender.FLLazyRenderService
    @NonNull
    public FLLazyRenderService.LazyRenderParam getLazyRenderParam() {
        return this.f28615a;
    }

    @Override // com.huawei.flexiblelayout.services.lazyrender.FLLazyRenderService
    public void notifyRender() {
        Iterator<FLLazyRenderService.LazyRenderListener> iterator2 = this.f28616b.iterator2();
        while (iterator2.hasNext()) {
            FLLazyRenderService.LazyRenderListener next = iterator2.next();
            iterator2.remove();
            next.onRender();
        }
    }

    @Override // com.huawei.flexiblelayout.services.lazyrender.FLLazyRenderService
    public void registerLazyRenderListener(@NonNull FLLazyRenderService.LazyRenderListener lazyRenderListener) {
        this.f28616b.add(lazyRenderListener);
    }

    @Override // com.huawei.flexiblelayout.services.lazyrender.FLLazyRenderService
    public void unregisterLazyRenderListener(@NonNull FLLazyRenderService.LazyRenderListener lazyRenderListener) {
        this.f28616b.remove(lazyRenderListener);
    }
}
