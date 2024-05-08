package com.huawei.flexiblelayout.services.exposure.impl;

import android.util.SparseArray;
import android.view.Choreographer;
import com.huawei.flexiblelayout.services.exposure.impl.FrameEvent;
import com.huawei.flexiblelayout.services.exposure.reusable.ReusableObjectPool;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class FrameEventDispatcher<T extends FrameEvent> {

    /* renamed from: c, reason: collision with root package name */
    private static final String f28564c = "FrameEventDispatcher";
    public final SparseArray<T> mPendingEvents = new SparseArray<>();

    /* renamed from: a, reason: collision with root package name */
    public volatile boolean f28565a = false;

    /* renamed from: b, reason: collision with root package name */
    private final Choreographer.FrameCallback f28566b = new Choreographer.FrameCallback() { // from class: com.huawei.flexiblelayout.services.exposure.impl.g
        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long j10) {
            FrameEventDispatcher.this.a(j10);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(long j10) {
        dispatch();
        this.f28565a = false;
    }

    public abstract void dispatch();

    public void a(T t2) {
        int identifier = t2.identifier();
        T t10 = this.mPendingEvents.get(identifier);
        if (t10 != null && t10 != t2) {
            ReusableObjectPool.getInstance().recycle(t10);
        }
        this.mPendingEvents.put(identifier, t2);
        a();
    }

    private void a() {
        if (this.f28565a) {
            return;
        }
        Choreographer.getInstance().postFrameCallback(this.f28566b);
        this.f28565a = true;
    }
}
