package com.vivo.push.b;

import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;

/* compiled from: OnReceiveCommand.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class s extends com.vivo.push.v {

    /* renamed from: a, reason: collision with root package name */
    private String f46122a;

    /* renamed from: b, reason: collision with root package name */
    private int f46123b;

    public s(int i10) {
        super(i10);
        this.f46122a = null;
        this.f46123b = 0;
    }

    @Override // com.vivo.push.v
    public void c(com.vivo.push.d dVar) {
        dVar.a(ExposeManager.UtArgsNames.reqId, this.f46122a);
        dVar.a("status_msg_code", this.f46123b);
    }

    @Override // com.vivo.push.v
    public void d(com.vivo.push.d dVar) {
        this.f46122a = dVar.a(ExposeManager.UtArgsNames.reqId);
        this.f46123b = dVar.b("status_msg_code", this.f46123b);
    }

    public final String h() {
        return this.f46122a;
    }

    public final int i() {
        return this.f46123b;
    }

    @Override // com.vivo.push.v
    public String toString() {
        return "OnReceiveCommand";
    }
}
