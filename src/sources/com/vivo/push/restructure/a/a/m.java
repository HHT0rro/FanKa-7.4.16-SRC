package com.vivo.push.restructure.a.a;

import android.text.TextUtils;
import com.vivo.push.util.u;

/* compiled from: NodeReportItem.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final class m {

    /* renamed from: a, reason: collision with root package name */
    private String f46313a;

    /* renamed from: b, reason: collision with root package name */
    private String f46314b;

    public m(com.vivo.push.restructure.a.a aVar, String str) {
        if (aVar != null) {
            this.f46313a = aVar.a();
        }
        this.f46314b = str;
    }

    public final com.vivo.push.b.h a() {
        if (!TextUtils.isEmpty(this.f46313a) && !TextUtils.isEmpty(this.f46314b)) {
            return new com.vivo.push.b.h(this.f46313a, this.f46314b);
        }
        u.a("convertOffLineMsg() error, mMessageID = " + this.f46313a + ", mNodeArrayInfo = " + this.f46314b);
        return null;
    }
}
