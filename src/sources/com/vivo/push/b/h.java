package com.vivo.push.b;

import android.text.TextUtils;

/* compiled from: MsgArriveCommand.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class h extends com.vivo.push.v {

    /* renamed from: a, reason: collision with root package name */
    private String f46095a;

    /* renamed from: b, reason: collision with root package name */
    private String f46096b;

    public h() {
        super(2013);
    }

    @Override // com.vivo.push.v
    public final void c(com.vivo.push.d dVar) {
        dVar.a("MsgArriveCommand.MSG_TAG", this.f46095a);
        if (TextUtils.isEmpty(this.f46096b)) {
            return;
        }
        dVar.a("MsgArriveCommand.NODE_INFO", this.f46096b);
    }

    @Override // com.vivo.push.v
    public final void d(com.vivo.push.d dVar) {
        this.f46095a = dVar.a("MsgArriveCommand.MSG_TAG");
        this.f46096b = dVar.a("MsgArriveCommand.NODE_INFO");
    }

    public h(String str) {
        this();
        this.f46095a = str;
    }

    public h(String str, String str2) {
        this(str);
        this.f46096b = str2;
    }
}
