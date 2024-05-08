package com.vivo.push.b;

import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;

/* compiled from: OnNotifyArrivedReceiveCommand.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class q extends v {

    /* renamed from: a, reason: collision with root package name */
    public InsideNotificationItem f46120a;

    /* renamed from: b, reason: collision with root package name */
    private String f46121b;

    public q() {
        super(4);
    }

    @Override // com.vivo.push.b.v, com.vivo.push.b.s, com.vivo.push.v
    public final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        String b4 = com.vivo.push.util.v.b(this.f46120a);
        this.f46121b = b4;
        dVar.a("notification_v1", b4);
    }

    public final InsideNotificationItem d() {
        return this.f46120a;
    }

    public final String e() {
        if (!TextUtils.isEmpty(this.f46121b)) {
            return this.f46121b;
        }
        InsideNotificationItem insideNotificationItem = this.f46120a;
        if (insideNotificationItem == null) {
            return null;
        }
        return com.vivo.push.util.v.b(insideNotificationItem);
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final String toString() {
        return "OnNotifyArrivedCommand";
    }

    @Override // com.vivo.push.b.v, com.vivo.push.b.s, com.vivo.push.v
    public final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        String a10 = dVar.a("notification_v1");
        this.f46121b = a10;
        if (TextUtils.isEmpty(a10)) {
            return;
        }
        InsideNotificationItem a11 = com.vivo.push.util.v.a(this.f46121b);
        this.f46120a = a11;
        if (a11 != null) {
            a11.setMsgId(f());
        }
    }
}
