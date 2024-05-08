package com.huawei.flexiblelayout.services.exposure.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ChainExecutor<P, R> {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final List<Interceptor<P, R>> f28544a = new ArrayList();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class Chain<P, R> {

        /* renamed from: a, reason: collision with root package name */
        @NonNull
        private final P f28545a;

        /* renamed from: b, reason: collision with root package name */
        @NonNull
        private final List<Interceptor<P, R>> f28546b;

        /* renamed from: c, reason: collision with root package name */
        private final int f28547c;

        public Chain(@NonNull P p10, @NonNull List<Interceptor<P, R>> list, int i10) {
            this.f28545a = p10;
            this.f28546b = list;
            this.f28547c = i10;
        }

        @NonNull
        public P getParam() {
            return this.f28545a;
        }

        @Nullable
        public R proceed(@NonNull P p10) {
            if (this.f28547c >= this.f28546b.size()) {
                return null;
            }
            return this.f28546b.get(this.f28547c).intercept(new Chain<>(p10, this.f28546b, this.f28547c + 1));
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface Interceptor<P, R> {
        @Nullable
        R intercept(@NonNull Chain<P, R> chain);
    }

    @NonNull
    public ChainExecutor<P, R> addInterceptor(@NonNull Interceptor<P, R> interceptor) {
        this.f28544a.add(interceptor);
        return this;
    }

    @Nullable
    public R execute(@NonNull P p10) {
        return (R) new Chain(p10, Collections.unmodifiableList(this.f28544a), 0).proceed(p10);
    }
}
