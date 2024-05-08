package com.huawei.flexiblelayout.services.exposure.impl;

import android.util.SparseArray;
import com.huawei.flexiblelayout.card.FLCell;
import com.huawei.flexiblelayout.services.exposure.reusable.ReusableObjectPool;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ExposureEventDispatcher extends FrameEventDispatcher<ExposureEvent> {

    /* renamed from: e, reason: collision with root package name */
    private static final String f28556e = "ExposureEventDispatcher";

    /* renamed from: d, reason: collision with root package name */
    private final CardExposureServiceImpl f28557d;

    public ExposureEventDispatcher(CardExposureServiceImpl cardExposureServiceImpl) {
        this.f28557d = cardExposureServiceImpl;
    }

    @Override // com.huawei.flexiblelayout.services.exposure.impl.FrameEventDispatcher
    public void dispatch() {
        SparseArray clone = this.mPendingEvents.clone();
        this.mPendingEvents.clear();
        for (int i10 = 0; i10 < clone.size(); i10++) {
            this.f28557d.notify((ExposureEvent) clone.valueAt(i10));
        }
        for (int i11 = 0; i11 < clone.size(); i11++) {
            ReusableObjectPool.getInstance().recycle((FrameEvent) clone.valueAt(i11));
        }
    }

    @Override // com.huawei.flexiblelayout.services.exposure.impl.FrameEventDispatcher
    public void a(final ExposureEvent exposureEvent) {
        exposureEvent.f28551b.addOnReadyListener(new FLCell.OnReadyListener() { // from class: com.huawei.flexiblelayout.services.exposure.impl.d
            @Override // com.huawei.flexiblelayout.card.FLCell.OnReadyListener
            public final void onReady(FLCell fLCell) {
                ExposureEventDispatcher.this.a(exposureEvent, fLCell);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(ExposureEvent exposureEvent, FLCell fLCell) {
        super.a((ExposureEventDispatcher) exposureEvent);
    }
}
