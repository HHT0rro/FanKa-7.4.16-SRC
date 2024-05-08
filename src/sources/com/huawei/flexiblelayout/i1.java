package com.huawei.flexiblelayout;

import android.content.Context;
import com.huawei.flexiblelayout.services.analytics.AnalyticsService;
import com.huawei.flexiblelayout.services.analytics.Record;

/* compiled from: AnalyticsServiceImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class i1 implements AnalyticsService {

    /* renamed from: a, reason: collision with root package name */
    private j1 f28151a;

    public i1(Context context) {
        try {
            this.f28151a = new j1(context);
        } catch (NoClassDefFoundError unused) {
            this.f28151a = null;
        }
    }

    @Override // com.huawei.flexiblelayout.services.analytics.AnalyticsService
    public void report(Record record) {
        j1 j1Var = this.f28151a;
        if (j1Var == null || record == null) {
            return;
        }
        try {
            j1Var.a(record);
        } catch (NoClassDefFoundError unused) {
            this.f28151a = null;
        }
    }
}
