package com.huawei.hms.hatool;

import com.huawei.hianalytics.framework.constant.FrameworkConstant;
import java.util.ArrayList;
import java.util.UUID;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class i1 {

    /* renamed from: a, reason: collision with root package name */
    private String f30132a;

    /* renamed from: b, reason: collision with root package name */
    private String f30133b;

    /* renamed from: c, reason: collision with root package name */
    private String f30134c;

    /* renamed from: d, reason: collision with root package name */
    private String f30135d;

    /* renamed from: e, reason: collision with root package name */
    private long f30136e;

    public i1(String str, String str2, String str3, String str4, long j10) {
        this.f30132a = str;
        this.f30133b = str2;
        this.f30134c = str3;
        this.f30135d = str4;
        this.f30136e = j10;
    }

    public void a() {
        v.c("StreamEventHandler", "Begin to handle stream events...");
        b1 b1Var = new b1();
        b1Var.b(this.f30134c);
        b1Var.d(this.f30133b);
        b1Var.a(this.f30135d);
        b1Var.c(String.valueOf(this.f30136e));
        if (FrameworkConstant.DataType.STRING_OPER.equals(this.f30133b) && z.i(this.f30132a, FrameworkConstant.DataType.STRING_OPER)) {
            p0 a10 = y.a().a(this.f30132a, this.f30136e);
            String a11 = a10.a();
            Boolean valueOf = Boolean.valueOf(a10.b());
            b1Var.f(a11);
            b1Var.e(String.valueOf(valueOf));
        }
        String replace = UUID.randomUUID().toString().replace("-", "");
        ArrayList arrayList = new ArrayList();
        arrayList.add(b1Var);
        new l0(this.f30132a, this.f30133b, q0.g(), arrayList, replace).a();
    }
}
