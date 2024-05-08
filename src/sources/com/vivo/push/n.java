package com.vivo.push;

import com.vivo.push.m;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PushClientManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class n implements IPushActionListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m.a f46273a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f46274b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f46275c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ m f46276d;

    public n(m mVar, m.a aVar, String str, String str2) {
        this.f46276d = mVar;
        this.f46273a = aVar;
        this.f46274b = str;
        this.f46275c = str2;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i10) {
        if (i10 == 0) {
            Object[] b4 = this.f46273a.b();
            if (b4 != null && b4.length != 0) {
                com.vivo.push.restructure.a.a().h().a((String) this.f46273a.b()[0], this.f46274b, this.f46275c);
                return;
            } else {
                com.vivo.push.util.u.a("PushClientManager", "bind app result is null");
                return;
            }
        }
        com.vivo.push.restructure.a.a().h().a("");
    }
}
