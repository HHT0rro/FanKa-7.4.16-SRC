package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.Cif;
import com.xiaomi.push.b2;
import com.xiaomi.push.gh;
import com.xiaomi.push.hq;
import com.xiaomi.push.id;
import com.xiaomi.push.im;
import com.xiaomi.push.ip;
import com.xiaomi.push.jb;
import com.xiaomi.push.jg;
import com.xiaomi.push.k5;
import com.xiaomi.push.n4;
import com.xiaomi.push.o6;
import com.xiaomi.push.service.aq;
import com.xiaomi.push.u4;
import java.nio.ByteBuffer;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class j0 {
    public static n4 a(XMPushService xMPushService, byte[] bArr) {
        im imVar = new im();
        try {
            o6.b(imVar, bArr);
            return b(a0.a(xMPushService), xMPushService, imVar);
        } catch (jg e2) {
            fc.c.k(e2);
            return null;
        }
    }

    public static n4 b(z zVar, Context context, im imVar) {
        try {
            n4 n4Var = new n4();
            n4Var.g(5);
            n4Var.u(zVar.f48360a);
            n4Var.r(e(imVar));
            n4Var.j("SECMSG", "message");
            String str = zVar.f48360a;
            imVar.f451a.f378a = str.substring(0, str.indexOf("@"));
            imVar.f451a.f382c = str.substring(str.indexOf("/") + 1);
            n4Var.l(o6.c(imVar), zVar.f48362c);
            n4Var.k((short) 1);
            fc.c.i("try send mi push message. packagename:" + imVar.f456b + " action:" + ((Object) imVar.f449a));
            return n4Var;
        } catch (NullPointerException e2) {
            fc.c.k(e2);
            return null;
        }
    }

    public static im c(String str, String str2) {
        ip ipVar = new ip();
        ipVar.b(str2);
        ipVar.c("package uninstalled");
        ipVar.a(k5.k());
        ipVar.a(false);
        return d(str, str2, ipVar, hq.Notification);
    }

    public static <T extends jb<T, ?>> im d(String str, String str2, T t2, hq hqVar) {
        byte[] c4 = o6.c(t2);
        im imVar = new im();
        Cif cif = new Cif();
        cif.f377a = 5L;
        cif.f378a = "fakeid";
        imVar.a(cif);
        imVar.a(ByteBuffer.wrap(c4));
        imVar.a(hqVar);
        imVar.b(true);
        imVar.b(str);
        imVar.a(false);
        imVar.a(str2);
        return imVar;
    }

    public static String e(im imVar) {
        Map<String, String> map;
        id idVar = imVar.f450a;
        if (idVar != null && (map = idVar.f368b) != null) {
            String str = map.get("ext_traffic_source_pkg");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return imVar.f456b;
    }

    public static String f(String str) {
        return str + ".permission.MIPUSH_RECEIVE";
    }

    public static void g(XMPushService xMPushService) {
        z a10 = a0.a(xMPushService.getApplicationContext());
        if (a10 != null) {
            aq.b a11 = a0.a(xMPushService.getApplicationContext()).a(xMPushService);
            i(xMPushService, a11);
            aq.c().l(a11);
            j.c(xMPushService).f(new k0("GAID", 172800L, xMPushService, a10));
            j(xMPushService, a10, 172800);
        }
    }

    public static void h(XMPushService xMPushService, im imVar) {
        b2.e(imVar.b(), xMPushService.getApplicationContext(), imVar, -1);
        u4 e2 = xMPushService.e();
        if (e2 == null) {
            throw new gh("try send msg while connection is null.");
        }
        if (!e2.o()) {
            throw new gh("Don't support XMPP connection.");
        }
        n4 b4 = b(a0.a(xMPushService), xMPushService, imVar);
        if (b4 != null) {
            e2.u(b4);
        }
    }

    public static void i(XMPushService xMPushService, aq.b bVar) {
        bVar.h(null);
        bVar.i(new m0(xMPushService));
    }

    public static void j(XMPushService xMPushService, z zVar, int i10) {
        j.c(xMPushService).f(new l0("MSAID", i10, xMPushService, zVar));
    }

    public static void k(XMPushService xMPushService, String str, byte[] bArr) {
        b2.g(str, xMPushService.getApplicationContext(), bArr);
        u4 e2 = xMPushService.e();
        if (e2 == null) {
            throw new gh("try send msg while connection is null.");
        }
        if (!e2.o()) {
            throw new gh("Don't support XMPP connection.");
        }
        n4 a10 = a(xMPushService, bArr);
        if (a10 != null) {
            e2.u(a10);
        } else {
            kc.j0.b(xMPushService, str, bArr, 70000003, "not a valid message");
        }
    }
}
