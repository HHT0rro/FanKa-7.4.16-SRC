package com.huawei.pnodesupport.impl;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.flexiblelayout.FLContext;
import com.huawei.flexiblelayout.FLEngine;
import com.huawei.flexiblelayout.card.FLCell;
import com.huawei.flexiblelayout.data.FLCardData;
import com.huawei.flexiblelayout.services.exposure.CardExposureService;
import com.huawei.flexiblelayout.services.exposure.impl.AbsExposureHelper;
import com.huawei.flexiblelayout.services.exposure.impl.CardExposureServiceImpl;
import com.huawei.flexiblelayout.services.exposure.impl.ExposureEvent;
import com.huawei.flexiblelayout.services.exposure.impl.ExposureTaskImpl;
import com.huawei.flexiblelayout.services.exposure.reusable.ReusableObjectPool;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: PNodeVisibilityDispatcher.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private final Set<f> f33079a = new HashSet();

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    private final FLContext f33080b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private final CardExposureServiceImpl f33081c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private final AbsExposureHelper f33082d;

    public e(FLContext fLContext) {
        this.f33080b = fLContext;
        this.f33081c = (CardExposureServiceImpl) FLEngine.getInstance(fLContext.getContext()).getService(CardExposureService.class);
        ExposureTaskImpl findTask = ExposureTaskImpl.findTask(fLContext.getFLayout());
        if (findTask != null) {
            this.f33082d = findTask.getHelper();
        } else {
            this.f33082d = null;
        }
    }

    public void a(List<f> list, int i10, int i11, int i12) {
        if (this.f33081c == null) {
            return;
        }
        Iterator<f> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            a(iterator2.next(), i10, i11, i12);
        }
    }

    public void a(f fVar, int i10, int i11, int i12) {
        if (this.f33081c == null || this.f33082d == null) {
            return;
        }
        boolean a10 = a(fVar.b(), i10, i11, i12);
        FLCell<FLCardData> a11 = fVar.a();
        String exposureMode = this.f33082d.getExposureMode(a11.getData());
        if (!a10 && this.f33079a.contains(fVar)) {
            ExposureEvent exposureEvent = (ExposureEvent) ReusableObjectPool.getInstance().acquire(ExposureEvent.class);
            exposureEvent.assign(this.f33080b.getFLayout(), a11, 2, exposureMode);
            this.f33081c.notify(exposureEvent);
            ReusableObjectPool.getInstance().recycle(exposureEvent);
            this.f33079a.remove(fVar);
        }
        if (!a10 || this.f33079a.contains(fVar)) {
            return;
        }
        ExposureEvent exposureEvent2 = (ExposureEvent) ReusableObjectPool.getInstance().acquire(ExposureEvent.class);
        exposureEvent2.assign(this.f33080b.getFLayout(), a11, !TextUtils.equals(exposureMode, "custom") ? 1 : 0, exposureMode);
        this.f33081c.notify(exposureEvent2);
        ReusableObjectPool.getInstance().recycle(exposureEvent2);
        this.f33079a.add(fVar);
    }

    public static boolean a(int i10, int i11, int i12, int i13) {
        if (i11 == 0) {
            return false;
        }
        for (int i14 = i12; i14 < i12 + i13; i14++) {
            if (i10 == i14 % i11) {
                return true;
            }
        }
        return false;
    }
}
