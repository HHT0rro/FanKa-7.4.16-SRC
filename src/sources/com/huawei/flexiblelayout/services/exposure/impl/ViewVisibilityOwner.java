package com.huawei.flexiblelayout.services.exposure.impl;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ViewVisibilityOwner {

    /* renamed from: a, reason: collision with root package name */
    private final Lifecycle f28580a;

    /* renamed from: b, reason: collision with root package name */
    private LifecycleObserver f28581b;

    /* renamed from: c, reason: collision with root package name */
    private final List<VisibilityListener> f28582c = new ArrayList();

    public ViewVisibilityOwner(@NonNull Lifecycle lifecycle) {
        this.f28580a = lifecycle;
    }

    public void addVisibilityObserver(@NonNull VisibilityListener visibilityListener) {
        this.f28582c.add(visibilityListener);
        a();
    }

    private void a() {
        if (this.f28581b == null) {
            LifecycleObserver lifecycleObserver = new LifecycleObserver() { // from class: com.huawei.flexiblelayout.services.exposure.impl.ViewVisibilityOwner.1
                @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                public void onDestroy() {
                    ViewVisibilityOwner.this.b();
                }

                @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
                public void onPause() {
                    for (int size = ViewVisibilityOwner.this.f28582c.size() - 1; size >= 0; size--) {
                        ((VisibilityListener) ViewVisibilityOwner.this.f28582c.get(size)).onVisibilityChanged(false);
                    }
                }

                @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
                public void onResume() {
                    for (int size = ViewVisibilityOwner.this.f28582c.size() - 1; size >= 0; size--) {
                        ((VisibilityListener) ViewVisibilityOwner.this.f28582c.get(size)).onVisibilityChanged(true);
                    }
                }
            };
            this.f28581b = lifecycleObserver;
            this.f28580a.addObserver(lifecycleObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        LifecycleObserver lifecycleObserver = this.f28581b;
        if (lifecycleObserver != null) {
            this.f28580a.removeObserver(lifecycleObserver);
            this.f28581b = null;
        }
    }
}
