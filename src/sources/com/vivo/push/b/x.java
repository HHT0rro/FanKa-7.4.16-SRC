package com.vivo.push.b;

import android.text.TextUtils;
import java.util.HashMap;

/* compiled from: ReporterCommand.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class x extends com.vivo.push.v {

    /* renamed from: a, reason: collision with root package name */
    private HashMap<String, String> f46131a;

    /* renamed from: b, reason: collision with root package name */
    private long f46132b;

    public x() {
        super(2012);
    }

    public final void a(HashMap<String, String> hashMap) {
        this.f46131a = hashMap;
    }

    @Override // com.vivo.push.v
    public final void c(com.vivo.push.d dVar) {
        dVar.a("ReporterCommand.EXTRA_PARAMS", this.f46131a);
        dVar.a("ReporterCommand.EXTRA_REPORTER_TYPE", this.f46132b);
    }

    @Override // com.vivo.push.v
    public final void d(com.vivo.push.d dVar) {
        this.f46131a = (HashMap) dVar.d("ReporterCommand.EXTRA_PARAMS");
        this.f46132b = dVar.b("ReporterCommand.EXTRA_REPORTER_TYPE", this.f46132b);
    }

    @Override // com.vivo.push.v
    public final String toString() {
        return "ReporterCommand（" + this.f46132b + ")";
    }

    public x(long j10) {
        this();
        this.f46132b = j10;
    }

    public final void d() {
        if (this.f46131a == null) {
            com.vivo.push.util.u.d("ReporterCommand", "reportParams is empty");
            return;
        }
        StringBuilder sb2 = new StringBuilder("report message reportType:");
        sb2.append(this.f46132b);
        sb2.append(",msgId:");
        String str = this.f46131a.get("messageID");
        if (TextUtils.isEmpty(str)) {
            str = this.f46131a.get("message_id");
        }
        sb2.append(str);
        com.vivo.push.util.u.d("ReporterCommand", sb2.toString());
    }
}
