package com.vivo.push.b;

import java.util.ArrayList;
import java.util.List;

/* compiled from: OnTagsReceiveCommand.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class t extends s {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<String> f46124a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<String> f46125b;

    public t(int i10) {
        super(i10);
        this.f46124a = null;
        this.f46125b = null;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("content", this.f46124a);
        dVar.a("error_msg", this.f46125b);
    }

    public final ArrayList<String> d() {
        return this.f46124a;
    }

    public final List<String> e() {
        return this.f46125b;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final String toString() {
        return "OnSetTagsCommand";
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.f46124a = dVar.c("content");
        this.f46125b = dVar.c("error_msg");
    }
}
