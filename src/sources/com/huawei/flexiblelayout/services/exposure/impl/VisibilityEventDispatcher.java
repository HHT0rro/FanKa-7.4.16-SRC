package com.huawei.flexiblelayout.services.exposure.impl;

import com.huawei.flexiblelayout.services.exposure.reusable.ReusableObjectPool;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class VisibilityEventDispatcher extends FrameEventDispatcher<VisibilityEvent> {

    /* renamed from: d, reason: collision with root package name */
    private static final String f28587d = "VisibilityEventDispatcher";

    @Override // com.huawei.flexiblelayout.services.exposure.impl.FrameEventDispatcher
    public void dispatch() {
        for (int i10 = 0; i10 < this.mPendingEvents.size(); i10++) {
            VisibilityEvent visibilityEvent = (VisibilityEvent) this.mPendingEvents.valueAt(i10);
            visibilityEvent.f28585b.onVisibilityChanged(visibilityEvent.f28586c);
            ReusableObjectPool.getInstance().recycle(visibilityEvent);
        }
        this.mPendingEvents.clear();
    }
}
