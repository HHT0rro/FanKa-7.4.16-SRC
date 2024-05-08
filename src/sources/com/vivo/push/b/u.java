package com.vivo.push.b;

/* compiled from: OnUndoMsgReceiveCommand.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class u extends v {

    /* renamed from: a, reason: collision with root package name */
    private long f46126a;

    /* renamed from: b, reason: collision with root package name */
    private int f46127b;

    public u() {
        super(20);
        this.f46126a = -1L;
    }

    @Override // com.vivo.push.b.v, com.vivo.push.b.s, com.vivo.push.v
    public final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("undo_msg_v1", this.f46126a);
        dVar.a("undo_msg_type_v1", this.f46127b);
    }

    public final long d() {
        return this.f46126a;
    }

    public final String e() {
        long j10 = this.f46126a;
        if (j10 != -1) {
            return String.valueOf(j10);
        }
        return null;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final String toString() {
        return "OnUndoMsgCommand";
    }

    @Override // com.vivo.push.b.v, com.vivo.push.b.s, com.vivo.push.v
    public final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.f46126a = dVar.b("undo_msg_v1", this.f46126a);
        this.f46127b = dVar.b("undo_msg_type_v1", 0);
    }
}
