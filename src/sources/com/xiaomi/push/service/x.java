package com.xiaomi.push.service;

import com.xiaomi.push.hu;
import com.xiaomi.push.m6;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class x implements m6 {

    /* renamed from: a, reason: collision with root package name */
    public final XMPushService f48355a;

    public x(XMPushService xMPushService) {
        this.f48355a = xMPushService;
    }

    @Override // com.xiaomi.push.m6
    public void a(List<hu> list, String str, String str2) {
        this.f48355a.w(new y(this, 4, str, list, str2));
    }

    public final String d(String str) {
        return "com.xiaomi.xmsf".equals(str) ? "1000271" : this.f48355a.getSharedPreferences("pref_registered_pkg_names", 0).getString(str, null);
    }
}
