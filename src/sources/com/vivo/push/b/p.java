package com.vivo.push.b;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;

/* compiled from: OnNotificationClickReceiveCommand.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class p extends com.vivo.push.v {

    /* renamed from: a, reason: collision with root package name */
    private String f46110a;

    /* renamed from: b, reason: collision with root package name */
    private String f46111b;

    /* renamed from: c, reason: collision with root package name */
    private byte[] f46112c;

    /* renamed from: d, reason: collision with root package name */
    private long f46113d;

    /* renamed from: e, reason: collision with root package name */
    private InsideNotificationItem f46114e;

    /* renamed from: f, reason: collision with root package name */
    private String f46115f;

    /* renamed from: g, reason: collision with root package name */
    private String f46116g;

    /* renamed from: h, reason: collision with root package name */
    private Uri f46117h;

    /* renamed from: i, reason: collision with root package name */
    private String f46118i;

    /* renamed from: j, reason: collision with root package name */
    private Bundle f46119j;

    public p(String str, long j10, InsideNotificationItem insideNotificationItem) {
        super(5);
        this.f46110a = str;
        this.f46113d = j10;
        this.f46114e = insideNotificationItem;
    }

    public final void a(Uri uri) {
        this.f46117h = uri;
    }

    public final void b(String str) {
        this.f46115f = str;
    }

    public final void c(String str) {
        this.f46116g = str;
    }

    public final String d() {
        return this.f46110a;
    }

    public final long e() {
        return this.f46113d;
    }

    public final InsideNotificationItem f() {
        return this.f46114e;
    }

    public final String g() {
        return this.f46115f;
    }

    public final String h() {
        return this.f46116g;
    }

    public final String i() {
        return this.f46118i;
    }

    public final Uri j() {
        return this.f46117h;
    }

    public final Bundle k() {
        if (this.f46119j == null) {
            return null;
        }
        Bundle bundle = new Bundle(this.f46119j);
        try {
            bundle.remove("command_type");
            bundle.remove("security_avoid_pull");
            bundle.remove("security_avoid_pull_rsa");
            bundle.remove("security_avoid_rsa_public_key");
            bundle.remove("security_avoid_rsa_public_key");
            bundle.remove("notify_action");
            bundle.remove("notify_componet_pkg");
            bundle.remove("notify_componet_class_name");
            bundle.remove("notification_v1");
            bundle.remove("command");
            bundle.remove("package_name");
            bundle.remove("method");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return bundle;
    }

    @Override // com.vivo.push.v
    public final String toString() {
        return "OnNotificationClickCommand";
    }

    private static Uri e(String str) {
        try {
            return Uri.parse(str);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.vivo.push.v
    public final void c(com.vivo.push.d dVar) {
        dVar.a("package_name", this.f46110a);
        dVar.a("notify_id", this.f46113d);
        dVar.a("notification_v1", com.vivo.push.util.v.b(this.f46114e));
        dVar.a("open_pkg_name", this.f46111b);
        dVar.a("open_pkg_name_encode", this.f46112c);
        dVar.a("notify_action", this.f46115f);
        dVar.a("notify_componet_pkg", this.f46116g);
        dVar.a("notify_componet_class_name", this.f46118i);
        Uri uri = this.f46117h;
        if (uri != null) {
            dVar.a("notify_uri_data", uri.toString());
        }
    }

    public final void d(String str) {
        this.f46118i = str;
    }

    @Override // com.vivo.push.v
    public final void d(com.vivo.push.d dVar) {
        this.f46110a = dVar.a("package_name");
        this.f46113d = dVar.b("notify_id", -1L);
        this.f46111b = dVar.a("open_pkg_name");
        this.f46112c = dVar.b("open_pkg_name_encode");
        this.f46115f = dVar.a("notify_action");
        this.f46116g = dVar.a("notify_componet_pkg");
        this.f46118i = dVar.a("notify_componet_class_name");
        String a10 = dVar.a("notification_v1");
        if (!TextUtils.isEmpty(a10)) {
            this.f46114e = com.vivo.push.util.v.a(a10);
        }
        InsideNotificationItem insideNotificationItem = this.f46114e;
        if (insideNotificationItem != null) {
            insideNotificationItem.setMsgId(this.f46113d);
        }
        String a11 = dVar.a("notify_uri_data");
        if (!TextUtils.isEmpty(a11)) {
            this.f46117h = e(a11);
        }
        this.f46119j = dVar.b();
    }

    public p() {
        super(5);
    }
}
