package com.amap.api.col.p0003l;

import android.content.Context;
import com.amap.api.col.p0003l.fu;
import com.amap.api.col.p0003l.hc;
import java.util.List;

/* compiled from: MsgProcessorDelegate.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class hb {

    /* renamed from: a, reason: collision with root package name */
    private Context f6239a;

    /* renamed from: b, reason: collision with root package name */
    private fu f6240b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f6241c = true;

    /* renamed from: d, reason: collision with root package name */
    private String f6242d = "40C27E38DCAD404B5465362914090908";

    /* renamed from: e, reason: collision with root package name */
    private he f6243e = new he("40C27E38DCAD404B5465362914090908");

    public final void a(Context context, boolean z10, String str, String str2, String str3, String[] strArr) {
        try {
            fu a10 = new fu.a(str, str2, str).a(strArr).a(str3).a();
            if (context != null) {
                Context applicationContext = context.getApplicationContext();
                this.f6239a = applicationContext;
                this.f6240b = a10;
                this.f6241c = z10;
                this.f6243e.a(applicationContext, a10);
            }
        } catch (fi unused) {
        }
    }

    public final void a(String str, String str2) {
        List<fu> a10 = this.f6243e.a(this.f6239a);
        hc hcVar = hc.a.f6244a;
        hc.a(this.f6239a, str, str2, a10, this.f6241c, this.f6240b);
    }
}
