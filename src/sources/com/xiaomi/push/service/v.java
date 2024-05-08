package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.xiaomi.push.g7;
import com.xiaomi.push.gp;
import com.xiaomi.push.i5;
import com.xiaomi.push.j5;
import com.xiaomi.push.k5;
import com.xiaomi.push.n4;
import com.xiaomi.push.service.aq;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class v {

    /* renamed from: a, reason: collision with root package name */
    public c0 f48332a = new c0();

    public static String c(aq.b bVar) {
        StringBuilder sb2;
        String str;
        if ("9".equals(bVar.f48229h)) {
            sb2 = new StringBuilder();
            sb2.append(bVar.f48222a);
            str = ".permission.MIMC_RECEIVE";
        } else {
            sb2 = new StringBuilder();
            sb2.append(bVar.f48222a);
            str = ".permission.MIPUSH_RECEIVE";
        }
        sb2.append(str);
        return sb2.toString();
    }

    public static void e(Context context, Intent intent, aq.b bVar) {
        if ("com.xiaomi.xmsf".equals(context.getPackageName())) {
            context.sendBroadcast(intent);
        } else {
            context.sendBroadcast(intent, c(bVar));
        }
    }

    public aq.b a(n4 n4Var) {
        Collection<aq.b> f10 = aq.c().f(Integer.toString(n4Var.a()));
        if (f10.isEmpty()) {
            return null;
        }
        Iterator<aq.b> iterator2 = f10.iterator2();
        if (f10.size() == 1) {
            return iterator2.next();
        }
        String y10 = n4Var.y();
        while (iterator2.hasNext()) {
            aq.b next = iterator2.next();
            if (TextUtils.equals(y10, next.f48223b)) {
                return next;
            }
        }
        return null;
    }

    public aq.b b(k5 k5Var) {
        Collection<aq.b> f10 = aq.c().f(k5Var.m());
        if (f10.isEmpty()) {
            return null;
        }
        Iterator<aq.b> iterator2 = f10.iterator2();
        if (f10.size() == 1) {
            return iterator2.next();
        }
        String q10 = k5Var.q();
        String o10 = k5Var.o();
        while (iterator2.hasNext()) {
            aq.b next = iterator2.next();
            if (TextUtils.equals(q10, next.f48223b) || TextUtils.equals(o10, next.f48223b)) {
                return next;
            }
        }
        return null;
    }

    public void d(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.service_started");
        if (g7.j()) {
            intent.addFlags(16777216);
        }
        context.sendBroadcast(intent);
    }

    public void f(Context context, aq.b bVar, int i10) {
        if ("5".equalsIgnoreCase(bVar.f48229h)) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.channel_closed");
        intent.setPackage(bVar.f48222a);
        intent.putExtra(kc.n.f50834p, bVar.f48229h);
        intent.putExtra("ext_reason", i10);
        intent.putExtra(kc.n.f50832n, bVar.f48223b);
        intent.putExtra(kc.n.f50844z, bVar.f48231j);
        if (bVar.f48239r == null || !"9".equals(bVar.f48229h)) {
            e(context, intent, bVar);
            return;
        }
        try {
            bVar.f48239r.send(Message.obtain(null, 17, intent));
        } catch (RemoteException unused) {
            bVar.f48239r = null;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("peer may died: ");
            String str = bVar.f48223b;
            sb2.append(str.substring(str.lastIndexOf(64)));
            fc.c.i(sb2.toString());
        }
    }

    public void g(Context context, aq.b bVar, String str, String str2) {
        if ("5".equalsIgnoreCase(bVar.f48229h)) {
            fc.c.n("mipush kicked by server");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.kicked");
        intent.setPackage(bVar.f48222a);
        intent.putExtra("ext_kick_type", str);
        intent.putExtra("ext_kick_reason", str2);
        intent.putExtra("ext_chid", bVar.f48229h);
        intent.putExtra(kc.n.f50832n, bVar.f48223b);
        intent.putExtra(kc.n.f50844z, bVar.f48231j);
        e(context, intent, bVar);
    }

    public void h(Context context, aq.b bVar, boolean z10, int i10, String str) {
        if ("5".equalsIgnoreCase(bVar.f48229h)) {
            this.f48332a.d(context, bVar, z10, i10, str);
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.channel_opened");
        intent.setPackage(bVar.f48222a);
        intent.putExtra("ext_succeeded", z10);
        if (!z10) {
            intent.putExtra("ext_reason", i10);
        }
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("ext_reason_msg", str);
        }
        intent.putExtra("ext_chid", bVar.f48229h);
        intent.putExtra(kc.n.f50832n, bVar.f48223b);
        intent.putExtra(kc.n.f50844z, bVar.f48231j);
        e(context, intent, bVar);
    }

    public void i(XMPushService xMPushService, String str, n4 n4Var) {
        aq.b a10 = a(n4Var);
        if (a10 == null) {
            fc.c.n("error while notify channel closed! channel " + str + " not registered");
            return;
        }
        if ("5".equalsIgnoreCase(str)) {
            this.f48332a.e(xMPushService, n4Var, a10);
            return;
        }
        String str2 = a10.f48222a;
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.new_msg");
        intent.setPackage(str2);
        intent.putExtra("ext_chid", str);
        intent.putExtra("ext_raw_packet", n4Var.o(a10.f48230i));
        intent.putExtra(kc.n.f50844z, a10.f48231j);
        intent.putExtra(kc.n.f50837s, a10.f48230i);
        if (a10.f48239r != null) {
            try {
                a10.f48239r.send(Message.obtain(null, 17, intent));
                return;
            } catch (RemoteException unused) {
                a10.f48239r = null;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("peer may died: ");
                String str3 = a10.f48223b;
                sb2.append(str3.substring(str3.lastIndexOf(64)));
                fc.c.i(sb2.toString());
            }
        }
        if ("com.xiaomi.xmsf".equals(str2)) {
            return;
        }
        e(xMPushService, intent, a10);
    }

    public void j(XMPushService xMPushService, String str, k5 k5Var) {
        String str2;
        String str3;
        aq.b b4 = b(k5Var);
        if (b4 != null) {
            if ("5".equalsIgnoreCase(str)) {
                this.f48332a.f(xMPushService, k5Var, b4);
                return;
            }
            String str4 = b4.f48222a;
            if (k5Var instanceof j5) {
                str3 = "com.xiaomi.push.new_msg";
            } else if (k5Var instanceof i5) {
                str3 = "com.xiaomi.push.new_iq";
            } else if (k5Var instanceof gp) {
                str3 = "com.xiaomi.push.new_pres";
            } else {
                str2 = "unknown packet type, drop it";
            }
            Intent intent = new Intent();
            intent.setAction(str3);
            intent.setPackage(str4);
            intent.putExtra("ext_chid", str);
            intent.putExtra("ext_packet", k5Var.a());
            intent.putExtra(kc.n.f50844z, b4.f48231j);
            intent.putExtra(kc.n.f50837s, b4.f48230i);
            e(xMPushService, intent, b4);
            return;
        }
        str2 = "error while notify channel closed! channel " + str + " not registered";
        fc.c.n(str2);
    }
}
