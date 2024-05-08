package com.huawei.hms.base.log;

import android.content.Context;
import com.huawei.hms.support.log.HMSExtLogger;

/* compiled from: ExtLogNode.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class a implements d {

    /* renamed from: a, reason: collision with root package name */
    private final HMSExtLogger f29612a;

    /* renamed from: b, reason: collision with root package name */
    private d f29613b;

    public a(HMSExtLogger hMSExtLogger) {
        this.f29612a = hMSExtLogger;
    }

    @Override // com.huawei.hms.base.log.d
    public void a(Context context, String str) {
        d dVar = this.f29613b;
        if (dVar != null) {
            dVar.a(context, str);
        }
    }

    @Override // com.huawei.hms.base.log.d
    public void a(d dVar) {
        this.f29613b = dVar;
    }

    @Override // com.huawei.hms.base.log.d
    public void a(String str, int i10, String str2, String str3) {
        HMSExtLogger hMSExtLogger = this.f29612a;
        if (hMSExtLogger != null) {
            if (i10 == 3) {
                hMSExtLogger.d(str2, str3);
            } else if (i10 == 4) {
                hMSExtLogger.i(str2, str3);
            } else if (i10 != 5) {
                hMSExtLogger.e(str2, str3);
            } else {
                hMSExtLogger.w(str2, str3);
            }
        }
        d dVar = this.f29613b;
        if (dVar != null) {
            dVar.a(str, i10, str2, str3);
        }
    }
}
