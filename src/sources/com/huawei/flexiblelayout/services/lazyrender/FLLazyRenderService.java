package com.huawei.flexiblelayout.services.lazyrender;

import androidx.annotation.NonNull;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface FLLazyRenderService {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface LazyRenderListener {
        void onRender();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class LazyRenderParam {

        /* renamed from: a, reason: collision with root package name */
        private boolean f28614a = false;

        public boolean lazyRender() {
            return this.f28614a;
        }

        public void setLazyRender(boolean z10) {
            this.f28614a = z10;
        }
    }

    @NonNull
    LazyRenderParam getLazyRenderParam();

    void notifyRender();

    void registerLazyRenderListener(@NonNull LazyRenderListener lazyRenderListener);

    void unregisterLazyRenderListener(@NonNull LazyRenderListener lazyRenderListener);
}
