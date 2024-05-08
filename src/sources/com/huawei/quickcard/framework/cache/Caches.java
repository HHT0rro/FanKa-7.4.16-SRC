package com.huawei.quickcard.framework.cache;

import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.framework.bean.QuickCardBean;
import com.huawei.quickcard.watcher.Expression;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class Caches {

    /* renamed from: c, reason: collision with root package name */
    private static final Caches f33830c = new Caches();

    /* renamed from: a, reason: collision with root package name */
    private final CacheInterface<String, QuickCardBean> f33831a = new a();

    /* renamed from: b, reason: collision with root package name */
    private final CacheInterface<String, Expression> f33832b = new b();

    private Caches() {
    }

    public static Caches get() {
        return f33830c;
    }

    public CacheInterface<String, QuickCardBean> beans() {
        return this.f33831a;
    }

    public CacheInterface<String, Expression> expressions() {
        return this.f33832b;
    }
}
