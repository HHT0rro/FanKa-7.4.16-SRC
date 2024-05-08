package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.xiaomi.push.b2;
import com.xiaomi.push.gh;
import com.xiaomi.push.h5;
import com.xiaomi.push.hq;
import com.xiaomi.push.i4;
import com.xiaomi.push.ia;
import com.xiaomi.push.id;
import com.xiaomi.push.ig;
import com.xiaomi.push.im;
import com.xiaomi.push.ip;
import com.xiaomi.push.j5;
import com.xiaomi.push.k5;
import com.xiaomi.push.n4;
import com.xiaomi.push.n7;
import com.xiaomi.push.o6;
import com.xiaomi.push.service.a;
import com.xiaomi.push.service.aq;
import com.xiaomi.push.y5;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class c0 {
    public static Intent a(byte[] bArr, long j10) {
        im c4 = c(bArr);
        if (c4 == null) {
            return null;
        }
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.putExtra("mipush_payload", bArr);
        intent.putExtra("mrt", Long.toString(j10));
        intent.setPackage(c4.f456b);
        return intent;
    }

    public static im b(Context context, im imVar) {
        ig igVar = new ig();
        igVar.b(imVar.m3003a());
        id m3002a = imVar.m3002a();
        if (m3002a != null) {
            igVar.a(m3002a.m2970a());
            igVar.a(m3002a.m2968a());
            if (!TextUtils.isEmpty(m3002a.m2975b())) {
                igVar.c(m3002a.m2975b());
            }
        }
        igVar.a(o6.a(context, imVar));
        im d10 = j0.d(imVar.b(), imVar.m3003a(), igVar, hq.AckMessage);
        id m2969a = imVar.m3002a().m2969a();
        m2969a.a("mat", Long.toString(System.currentTimeMillis()));
        d10.a(m2969a);
        return d10;
    }

    public static im c(byte[] bArr) {
        im imVar = new im();
        try {
            o6.b(imVar, bArr);
            return imVar;
        } catch (Throwable th) {
            fc.c.k(th);
            return null;
        }
    }

    public static void g(XMPushService xMPushService, im imVar) {
        xMPushService.w(new d0(4, xMPushService, imVar));
    }

    public static void h(XMPushService xMPushService, im imVar, String str) {
        xMPushService.w(new h0(4, xMPushService, imVar, str));
    }

    public static void i(XMPushService xMPushService, im imVar, String str, String str2) {
        xMPushService.w(new i0(4, xMPushService, imVar, str, str2));
    }

    public static void j(XMPushService xMPushService, String str, byte[] bArr, Intent intent) {
        i4 a10;
        String b4;
        String m2970a;
        int i10;
        String str2;
        String str3;
        i4 a11;
        String b10;
        String G;
        String m2970a2;
        String str4;
        im c4 = c(bArr);
        id m3002a = c4.m3002a();
        if (bArr != null) {
            b2.f(c4.b(), xMPushService.getApplicationContext(), null, c4.a(), bArr.length);
        }
        if (s(c4) && m(xMPushService, str)) {
            if (a.O(c4)) {
                i4.a(xMPushService.getApplicationContext()).h(c4.b(), a.G(c4), m3002a.m2970a(), "5");
            }
            r(xMPushService, c4);
            return;
        }
        if (n(c4) && !m(xMPushService, str) && !q(c4)) {
            if (a.O(c4)) {
                i4.a(xMPushService.getApplicationContext()).h(c4.b(), a.G(c4), m3002a.m2970a(), "6");
            }
            t(xMPushService, c4);
            return;
        }
        if ((!a.A(c4) || !com.xiaomi.push.g.j(xMPushService, c4.f456b)) && !l(xMPushService, intent)) {
            if (!com.xiaomi.push.g.j(xMPushService, c4.f456b)) {
                if (a.O(c4)) {
                    i4.a(xMPushService.getApplicationContext()).i(c4.b(), a.G(c4), m3002a.m2970a(), "2");
                }
                g(xMPushService, c4);
                return;
            } else {
                fc.c.i("receive a mipush message, we can see the app, but we can't see the receiver.");
                if (a.O(c4)) {
                    i4.a(xMPushService.getApplicationContext()).i(c4.b(), a.G(c4), m3002a.m2970a(), "3");
                    return;
                }
                return;
            }
        }
        if (hq.Registration == c4.a()) {
            String b11 = c4.b();
            SharedPreferences.Editor edit = xMPushService.getSharedPreferences("pref_registered_pkg_names", 0).edit();
            edit.putString(b11, c4.f452a);
            edit.commit();
            i4.a(xMPushService.getApplicationContext()).g(b11, "E100003", m3002a.m2970a(), 6003, null);
            if (!TextUtils.isEmpty(m3002a.m2970a())) {
                intent.putExtra("messageId", m3002a.m2970a());
                intent.putExtra("eventMessageType", 6000);
            }
        }
        if (a.M(c4)) {
            i4.a(xMPushService.getApplicationContext()).f(c4.b(), a.G(c4), m3002a.m2970a(), 1001, System.currentTimeMillis(), null);
            if (!TextUtils.isEmpty(m3002a.m2970a())) {
                intent.putExtra("messageId", m3002a.m2970a());
                intent.putExtra("eventMessageType", 1000);
            }
        }
        if (a.K(c4)) {
            i4.a(xMPushService.getApplicationContext()).f(c4.b(), a.G(c4), m3002a.m2970a(), 2001, System.currentTimeMillis(), null);
            if (!TextUtils.isEmpty(m3002a.m2970a())) {
                intent.putExtra("messageId", m3002a.m2970a());
                intent.putExtra("eventMessageType", 2000);
            }
        }
        if (a.A(c4)) {
            i4.a(xMPushService.getApplicationContext()).f(c4.b(), a.G(c4), m3002a.m2970a(), 3001, System.currentTimeMillis(), null);
            if (!TextUtils.isEmpty(m3002a.m2970a())) {
                intent.putExtra("messageId", m3002a.m2970a());
                intent.putExtra("eventMessageType", 3000);
            }
        }
        if (m3002a != null && !TextUtils.isEmpty(m3002a.m2978c()) && !TextUtils.isEmpty(m3002a.d()) && m3002a.f366b != 1 && (a.C(m3002a.m2971a()) || !a.y(xMPushService, c4.f456b))) {
            Map<String, String> map = m3002a.f364a;
            String str5 = map != null ? map.get("jobkey") : null;
            if (TextUtils.isEmpty(str5)) {
                str5 = m3002a.m2970a();
            }
            if (kc.b.a(xMPushService, c4.f456b, str5)) {
                i4.a(xMPushService.getApplicationContext()).j(c4.b(), a.G(c4), m3002a.m2970a(), "1:" + str5);
                fc.c.i("drop a duplicate message, key=" + str5);
            } else {
                a.c p10 = a.p(xMPushService, c4, bArr);
                if (p10.f48216b > 0 && !TextUtils.isEmpty(p10.f48215a)) {
                    y5.j(xMPushService, p10.f48215a, p10.f48216b, true, false, System.currentTimeMillis());
                }
                if (!a.A(c4)) {
                    Intent intent2 = new Intent("com.xiaomi.mipush.MESSAGE_ARRIVED");
                    intent2.putExtra("mipush_payload", bArr);
                    intent2.setPackage(c4.f456b);
                    try {
                        List<ResolveInfo> queryBroadcastReceivers = xMPushService.getPackageManager().queryBroadcastReceivers(intent2, 0);
                        if (queryBroadcastReceivers != null && !queryBroadcastReceivers.isEmpty()) {
                            xMPushService.sendBroadcast(intent2, j0.f(c4.f456b));
                        }
                    } catch (Exception unused) {
                        xMPushService.sendBroadcast(intent2, j0.f(c4.f456b));
                        i4.a(xMPushService.getApplicationContext()).i(c4.b(), a.G(c4), m3002a.m2970a(), "1");
                    }
                }
            }
            p(xMPushService, c4);
        } else if ("com.xiaomi.xmsf".contains(c4.f456b) && !c4.m3010b() && m3002a != null && m3002a.m2971a() != null && m3002a.m2971a().containsKey("ab")) {
            p(xMPushService, c4);
            fc.c.m("receive abtest message. ack it." + m3002a.m2970a());
        } else if (o(xMPushService, str, c4, m3002a)) {
            if (m3002a != null && !TextUtils.isEmpty(m3002a.m2970a())) {
                if (a.K(c4)) {
                    a10 = i4.a(xMPushService.getApplicationContext());
                    b4 = c4.b();
                    str3 = a.G(c4);
                    m2970a = m3002a.m2970a();
                    i10 = 2002;
                    str2 = null;
                } else {
                    if (a.A(c4)) {
                        a11 = i4.a(xMPushService.getApplicationContext());
                        b10 = c4.b();
                        G = a.G(c4);
                        m2970a2 = m3002a.m2970a();
                        str4 = "7";
                    } else if (a.M(c4)) {
                        a11 = i4.a(xMPushService.getApplicationContext());
                        b10 = c4.b();
                        G = a.G(c4);
                        m2970a2 = m3002a.m2970a();
                        str4 = "8";
                    } else if (a.N(c4)) {
                        a10 = i4.a(xMPushService.getApplicationContext());
                        b4 = c4.b();
                        m2970a = m3002a.m2970a();
                        i10 = 6004;
                        str2 = null;
                        str3 = "E100003";
                    }
                    a11.h(b10, G, m2970a2, str4);
                }
                a10.g(b4, str3, m2970a, i10, str2);
            }
            xMPushService.sendBroadcast(intent, j0.f(c4.f456b));
        } else {
            i4.a(xMPushService.getApplicationContext()).h(c4.b(), a.G(c4), m3002a.m2970a(), "9");
        }
        if (c4.a() != hq.UnRegistration || "com.xiaomi.xmsf".equals(xMPushService.getPackageName())) {
            return;
        }
        xMPushService.stopSelf();
    }

    public static void k(XMPushService xMPushService, byte[] bArr, long j10) {
        Map<String, String> m2971a;
        im c4 = c(bArr);
        if (c4 == null) {
            return;
        }
        if (TextUtils.isEmpty(c4.f456b)) {
            fc.c.i("receive a mipush message without package name");
            return;
        }
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        Intent a10 = a(bArr, valueOf.longValue());
        String r10 = a.r(c4);
        y5.j(xMPushService, r10, j10, true, true, System.currentTimeMillis());
        id m3002a = c4.m3002a();
        if (m3002a != null) {
            m3002a.a("mrt", Long.toString(valueOf.longValue()));
        }
        hq hqVar = hq.SendMessage;
        String str = "";
        if (hqVar == c4.a() && kc.i0.a(xMPushService).c(c4.f456b) && !a.A(c4)) {
            if (m3002a != null) {
                str = m3002a.m2970a();
                if (a.O(c4)) {
                    i4.a(xMPushService.getApplicationContext()).h(c4.b(), a.G(c4), str, "1");
                }
            }
            fc.c.i("Drop a message for unregistered, msgid=" + str);
            h(xMPushService, c4, c4.f456b);
            return;
        }
        if (hqVar == c4.a() && kc.i0.a(xMPushService).g(c4.f456b) && !a.A(c4)) {
            if (m3002a != null) {
                str = m3002a.m2970a();
                if (a.O(c4)) {
                    i4.a(xMPushService.getApplicationContext()).h(c4.b(), a.G(c4), str, "2");
                }
            }
            fc.c.i("Drop a message for push closed, msgid=" + str);
            h(xMPushService, c4, c4.f456b);
            return;
        }
        if (hqVar == c4.a() && !TextUtils.equals(xMPushService.getPackageName(), "com.xiaomi.xmsf") && !TextUtils.equals(xMPushService.getPackageName(), c4.f456b)) {
            fc.c.i("Receive a message with wrong package name, expect " + xMPushService.getPackageName() + ", received " + c4.f456b);
            i(xMPushService, c4, "unmatched_package", "package should be " + xMPushService.getPackageName() + ", but got " + c4.f456b);
            if (m3002a == null || !a.O(c4)) {
                return;
            }
            i4.a(xMPushService.getApplicationContext()).h(c4.b(), a.G(c4), m3002a.m2970a(), "3");
            return;
        }
        if (m3002a != null && m3002a.m2970a() != null) {
            fc.c.i(String.format("receive a message, appid=%1$s, msgid= %2$s", c4.m3003a(), m3002a.m2970a()));
        }
        if (m3002a != null && (m2971a = m3002a.m2971a()) != null && m2971a.containsKey("hide") && "true".equalsIgnoreCase(m2971a.get("hide"))) {
            p(xMPushService, c4);
            return;
        }
        if (m3002a != null && m3002a.m2971a() != null && m3002a.m2971a().containsKey("__miid")) {
            String str2 = m3002a.m2971a().get("__miid");
            String e2 = n7.e(xMPushService.getApplicationContext());
            if (TextUtils.isEmpty(e2) || !TextUtils.equals(str2, e2)) {
                if (a.O(c4)) {
                    i4.a(xMPushService.getApplicationContext()).h(c4.b(), a.G(c4), m3002a.m2970a(), "4");
                }
                fc.c.i(str2 + " should be login, but got " + e2);
                i(xMPushService, c4, "miid already logout or anther already login", str2 + " should be login, but got " + e2);
                return;
            }
        }
        j(xMPushService, r10, bArr, a10);
    }

    public static boolean l(Context context, Intent intent) {
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 32);
            if (queryBroadcastReceivers != null) {
                if (!queryBroadcastReceivers.isEmpty()) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    public static boolean m(Context context, String str) {
        Intent intent = new Intent("com.xiaomi.mipush.miui.CLICK_MESSAGE");
        intent.setPackage(str);
        Intent intent2 = new Intent("com.xiaomi.mipush.miui.RECEIVE_MESSAGE");
        intent2.setPackage(str);
        PackageManager packageManager = context.getPackageManager();
        try {
            List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 32);
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 32);
            if (queryBroadcastReceivers.isEmpty()) {
                if (queryIntentServices.isEmpty()) {
                    return false;
                }
            }
            return true;
        } catch (Exception e2) {
            fc.c.k(e2);
            return false;
        }
    }

    public static boolean n(im imVar) {
        return "com.xiaomi.xmsf".equals(imVar.f456b) && imVar.m3002a() != null && imVar.m3002a().m2971a() != null && imVar.m3002a().m2971a().containsKey("miui_package_name");
    }

    public static boolean o(XMPushService xMPushService, String str, im imVar, id idVar) {
        boolean z10 = true;
        if (idVar != null && idVar.m2971a() != null && idVar.m2971a().containsKey("__check_alive") && idVar.m2971a().containsKey("__awake")) {
            ip ipVar = new ip();
            ipVar.b(imVar.m3003a());
            ipVar.d(str);
            ipVar.c(ia.AwakeSystemApp.f329a);
            ipVar.a(idVar.m2970a());
            ipVar.f468a = new HashMap();
            boolean g3 = com.xiaomi.push.g.g(xMPushService.getApplicationContext(), str);
            ipVar.f468a.put("app_running", Boolean.toString(g3));
            if (!g3) {
                boolean parseBoolean = Boolean.parseBoolean(idVar.m2971a().get("__awake"));
                ipVar.f468a.put("awaked", Boolean.toString(parseBoolean));
                if (!parseBoolean) {
                    z10 = false;
                }
            }
            try {
                j0.h(xMPushService, j0.d(imVar.b(), imVar.m3003a(), ipVar, hq.Notification));
            } catch (gh e2) {
                fc.c.k(e2);
            }
        }
        return z10;
    }

    public static void p(XMPushService xMPushService, im imVar) {
        xMPushService.w(new e0(4, xMPushService, imVar));
    }

    public static boolean q(im imVar) {
        Map<String, String> m2971a = imVar.m3002a().m2971a();
        return m2971a != null && m2971a.containsKey("notify_effect");
    }

    public static void r(XMPushService xMPushService, im imVar) {
        xMPushService.w(new f0(4, xMPushService, imVar));
    }

    public static boolean s(im imVar) {
        if (imVar.m3002a() == null || imVar.m3002a().m2971a() == null) {
            return false;
        }
        return "1".equals(imVar.m3002a().m2971a().get("obslete_ads_message"));
    }

    public static void t(XMPushService xMPushService, im imVar) {
        xMPushService.w(new g0(4, xMPushService, imVar));
    }

    public void d(Context context, aq.b bVar, boolean z10, int i10, String str) {
        z a10;
        if (z10 || (a10 = a0.a(context)) == null || !"token-expired".equals(str)) {
            return;
        }
        try {
            a0.b(context, a10.f48365f, a10.f48363d, a10.f48364e);
        } catch (IOException | JSONException e2) {
            fc.c.k(e2);
        }
    }

    public void e(XMPushService xMPushService, n4 n4Var, aq.b bVar) {
        try {
            k(xMPushService, n4Var.o(bVar.f48230i), n4Var.s());
        } catch (IllegalArgumentException e2) {
            fc.c.k(e2);
        }
    }

    public void f(XMPushService xMPushService, k5 k5Var, aq.b bVar) {
        if (!(k5Var instanceof j5)) {
            fc.c.i("not a mipush message");
            return;
        }
        j5 j5Var = (j5) k5Var;
        h5 b4 = j5Var.b(com.kuaishou.weapon.p0.t.f36222g);
        if (b4 != null) {
            try {
                k(xMPushService, kc.s.h(kc.s.g(bVar.f48230i, j5Var.l()), b4.k()), y5.b(k5Var.f()));
            } catch (IllegalArgumentException e2) {
                fc.c.k(e2);
            }
        }
    }
}
