package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import com.xiaomi.push.b2;
import com.xiaomi.push.fk;
import com.xiaomi.push.h4;
import com.xiaomi.push.hq;
import com.xiaomi.push.hv;
import com.xiaomi.push.i4;
import com.xiaomi.push.ia;
import com.xiaomi.push.ic;
import com.xiaomi.push.id;
import com.xiaomi.push.ie;
import com.xiaomi.push.ig;
import com.xiaomi.push.ih;
import com.xiaomi.push.il;
import com.xiaomi.push.im;
import com.xiaomi.push.in;
import com.xiaomi.push.io;
import com.xiaomi.push.ip;
import com.xiaomi.push.ir;
import com.xiaomi.push.it;
import com.xiaomi.push.iv;
import com.xiaomi.push.ix;
import com.xiaomi.push.iz;
import com.xiaomi.push.jb;
import com.xiaomi.push.jg;
import com.xiaomi.push.l7;
import com.xiaomi.push.n6;
import com.xiaomi.push.o6;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TimeZone;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class e0 {

    /* renamed from: b, reason: collision with root package name */
    public static e0 f46981b;

    /* renamed from: c, reason: collision with root package name */
    public static Queue<String> f46982c;

    /* renamed from: d, reason: collision with root package name */
    public static Object f46983d = new Object();

    /* renamed from: a, reason: collision with root package name */
    public Context f46984a;

    public e0(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f46984a = applicationContext;
        if (applicationContext == null) {
            this.f46984a = context;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x013b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.content.Intent a(android.content.Context r6, java.lang.String r7, java.util.Map<java.lang.String, java.lang.String> r8) {
        /*
            Method dump skipped, instructions count: 383
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.e0.a(android.content.Context, java.lang.String, java.util.Map):android.content.Intent");
    }

    public static e0 e(Context context) {
        if (f46981b == null) {
            f46981b = new e0(context);
        }
        return f46981b;
    }

    public static boolean o(Context context, String str) {
        synchronized (f46983d) {
            o0.c(context);
            SharedPreferences b4 = o0.b(context);
            if (f46982c == null) {
                String[] split = b4.getString("pref_msg_ids", "").split(",");
                f46982c = new LinkedList();
                for (String str2 : split) {
                    f46982c.add(str2);
                }
            }
            if (f46982c.contains(str)) {
                return true;
            }
            f46982c.add(str);
            if (f46982c.size() > 25) {
                f46982c.poll();
            }
            String d10 = com.xiaomi.push.p0.d(f46982c, ",");
            SharedPreferences.Editor edit = b4.edit();
            edit.putString("pref_msg_ids", d10);
            l7.a(edit);
            return false;
        }
    }

    public PushMessageHandler.a b(Intent intent) {
        String str;
        i4 a10;
        String packageName;
        String str2;
        i4 a11;
        String packageName2;
        String format;
        String action = intent.getAction();
        fc.c.i("receive an intent from server, action=" + action);
        String stringExtra = intent.getStringExtra("mrt");
        if (stringExtra == null) {
            stringExtra = Long.toString(System.currentTimeMillis());
        }
        String stringExtra2 = intent.getStringExtra("messageId");
        int intExtra = intent.getIntExtra("eventMessageType", -1);
        if ("com.xiaomi.mipush.RECEIVE_MESSAGE".equals(action)) {
            byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
            boolean booleanExtra = intent.getBooleanExtra("mipush_notified", false);
            if (byteArrayExtra == null) {
                fc.c.n("receiving an empty message, drop");
                i4.a(this.f46984a).e(this.f46984a.getPackageName(), intent, Constants.VIA_REPORT_TYPE_SET_AVATAR);
                return null;
            }
            im imVar = new im();
            try {
                o6.b(imVar, byteArrayExtra);
                o0 c4 = o0.c(this.f46984a);
                id m3002a = imVar.m3002a();
                hq a12 = imVar.a();
                hq hqVar = hq.SendMessage;
                if (a12 == hqVar && m3002a != null && !c4.u() && !booleanExtra) {
                    m3002a.a("mrt", stringExtra);
                    m3002a.a("mat", Long.toString(System.currentTimeMillis()));
                    if (p(imVar)) {
                        fc.c.l("this is a mina's message, ack later");
                        m3002a.a("__hybrid_message_ts", String.valueOf(m3002a.m2968a()));
                        m3002a.a("__hybrid_device_status", String.valueOf((int) o6.a(this.f46984a, imVar)));
                    } else {
                        r(imVar);
                    }
                }
                if (imVar.a() == hqVar && !imVar.m3010b()) {
                    if (com.xiaomi.push.service.a.A(imVar)) {
                        Object[] objArr = new Object[2];
                        objArr[0] = imVar.b();
                        objArr[1] = m3002a != null ? m3002a.m2970a() : "";
                        fc.c.i(String.format("drop an un-encrypted wake-up messages. %1$s, %2$s", objArr));
                        a11 = i4.a(this.f46984a);
                        packageName2 = this.f46984a.getPackageName();
                        format = String.format("13: %1$s", imVar.b());
                    } else {
                        Object[] objArr2 = new Object[2];
                        objArr2[0] = imVar.b();
                        objArr2[1] = m3002a != null ? m3002a.m2970a() : "";
                        fc.c.i(String.format("drop an un-encrypted messages. %1$s, %2$s", objArr2));
                        a11 = i4.a(this.f46984a);
                        packageName2 = this.f46984a.getPackageName();
                        format = String.format("14: %1$s", imVar.b());
                    }
                    a11.e(packageName2, intent, format);
                    return null;
                }
                if (imVar.a() == hqVar && imVar.m3010b() && com.xiaomi.push.service.a.A(imVar) && (!booleanExtra || m3002a == null || m3002a.m2971a() == null || !m3002a.m2971a().containsKey("notify_effect"))) {
                    Object[] objArr3 = new Object[2];
                    objArr3[0] = imVar.b();
                    objArr3[1] = m3002a != null ? m3002a.m2970a() : "";
                    fc.c.i(String.format("drop a wake-up messages which not has 'notify_effect' attr. %1$s, %2$s", objArr3));
                    i4.a(this.f46984a).e(this.f46984a.getPackageName(), intent, String.format("25: %1$s", imVar.b()));
                    return null;
                }
                if (c4.s() || imVar.f449a == hq.Registration) {
                    if (!c4.s() || !c4.w()) {
                        return c(imVar, booleanExtra, byteArrayExtra, stringExtra2, intExtra);
                    }
                    if (imVar.f449a == hq.UnRegistration) {
                        c4.e();
                        MiPushClient.m(this.f46984a);
                        PushMessageHandler.b();
                    } else {
                        MiPushClient.k0(this.f46984a);
                    }
                } else {
                    if (com.xiaomi.push.service.a.A(imVar)) {
                        return c(imVar, booleanExtra, byteArrayExtra, stringExtra2, intExtra);
                    }
                    fc.c.n("receive message without registration. need re-register!");
                    i4.a(this.f46984a).e(this.f46984a.getPackageName(), intent, "15");
                    g();
                }
            } catch (jg e2) {
                e = e2;
                a10 = i4.a(this.f46984a);
                packageName = this.f46984a.getPackageName();
                str2 = "16";
                a10.e(packageName, intent, str2);
                fc.c.k(e);
                return null;
            } catch (Exception e10) {
                e = e10;
                a10 = i4.a(this.f46984a);
                packageName = this.f46984a.getPackageName();
                str2 = Constants.VIA_REPORT_TYPE_START_GROUP;
                a10.e(packageName, intent, str2);
                fc.c.k(e);
                return null;
            }
        } else {
            if ("com.xiaomi.mipush.ERROR".equals(action)) {
                MiPushCommandMessage miPushCommandMessage = new MiPushCommandMessage();
                im imVar2 = new im();
                try {
                    byte[] byteArrayExtra2 = intent.getByteArrayExtra("mipush_payload");
                    if (byteArrayExtra2 != null) {
                        o6.b(imVar2, byteArrayExtra2);
                    }
                } catch (jg unused) {
                }
                miPushCommandMessage.setCommand(String.valueOf(imVar2.a()));
                miPushCommandMessage.setResultCode(intent.getIntExtra("mipush_error_code", 0));
                miPushCommandMessage.setReason(intent.getStringExtra("mipush_error_msg"));
                fc.c.n("receive a error message. code = " + intent.getIntExtra("mipush_error_code", 0) + ", msg= " + intent.getStringExtra("mipush_error_msg"));
                return miPushCommandMessage;
            }
            if ("com.xiaomi.mipush.MESSAGE_ARRIVED".equals(action)) {
                byte[] byteArrayExtra3 = intent.getByteArrayExtra("mipush_payload");
                if (byteArrayExtra3 == null) {
                    fc.c.n("message arrived: receiving an empty message, drop");
                    return null;
                }
                im imVar3 = new im();
                try {
                    o6.b(imVar3, byteArrayExtra3);
                    o0 c10 = o0.c(this.f46984a);
                    if (com.xiaomi.push.service.a.A(imVar3)) {
                        str = "message arrived: receive ignore reg message, ignore!";
                    } else if (!c10.s()) {
                        str = "message arrived: receive message without registration. need unregister or re-register!";
                    } else {
                        if (!c10.s() || !c10.w()) {
                            return d(imVar3, byteArrayExtra3);
                        }
                        str = "message arrived: app info is invalidated";
                    }
                    fc.c.n(str);
                } catch (jg e11) {
                    e = e11;
                    fc.c.k(e);
                    return null;
                } catch (Exception e12) {
                    e = e12;
                    fc.c.k(e);
                    return null;
                }
            }
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final PushMessageHandler.a c(im imVar, boolean z10, byte[] bArr, String str, int i10) {
        i4 a10;
        String packageName;
        String j10;
        int i11;
        String str2;
        MiPushMessage miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        miPushMessage = null;
        ArrayList arrayList3 = null;
        miPushMessage = null;
        try {
            jb c4 = a0.c(this.f46984a, imVar);
            if (c4 == null) {
                fc.c.n("receiving an un-recognized message. " + ((Object) imVar.f449a));
                i4.a(this.f46984a).i(this.f46984a.getPackageName(), h4.j(i10), str, "18");
                return null;
            }
            hq a11 = imVar.a();
            fc.c.i("processing a message, action=" + ((Object) a11));
            switch (g0.f46996a[a11.ordinal()]) {
                case 1:
                    if (!imVar.m3010b()) {
                        fc.c.n("receiving an un-encrypt message(SendMessage).");
                        return null;
                    }
                    if (o0.c(this.f46984a).u() && !z10) {
                        fc.c.i("receive a message in pause state. drop it");
                        i4.a(this.f46984a).h(this.f46984a.getPackageName(), h4.j(i10), str, Constants.VIA_REPORT_TYPE_SET_AVATAR);
                        return null;
                    }
                    it itVar = (it) c4;
                    ic a12 = itVar.a();
                    if (a12 == null) {
                        fc.c.n("receive an empty message without push content, drop it");
                        i4.a(this.f46984a).i(this.f46984a.getPackageName(), h4.j(i10), str, Constants.VIA_REPORT_TYPE_DATALINE);
                        return null;
                    }
                    if (z10) {
                        if (com.xiaomi.push.service.a.A(imVar)) {
                            MiPushClient.T(this.f46984a, a12.m2962a(), imVar.m3002a(), imVar.f456b, a12.b());
                        } else {
                            MiPushClient.U(this.f46984a, a12.m2962a(), imVar.m3002a(), a12.b());
                        }
                    }
                    if (!z10) {
                        if (!TextUtils.isEmpty(itVar.d()) && MiPushClient.j(this.f46984a, itVar.d()) < 0) {
                            MiPushClient.f(this.f46984a, itVar.d());
                        } else if (!TextUtils.isEmpty(itVar.c()) && MiPushClient.j0(this.f46984a, itVar.c()) < 0) {
                            MiPushClient.i(this.f46984a, itVar.c());
                        }
                    }
                    id idVar = imVar.f450a;
                    String str3 = (idVar == null || idVar.m2971a() == null) ? null : imVar.f450a.f364a.get("jobkey");
                    if (TextUtils.isEmpty(str3)) {
                        str3 = a12.m2962a();
                    }
                    if (z10 || !o(this.f46984a, str3)) {
                        MiPushMessage b4 = p.b(itVar, imVar.m3002a(), z10);
                        if (b4.getPassThrough() == 0 && !z10 && com.xiaomi.push.service.a.C(b4.getExtra())) {
                            com.xiaomi.push.service.a.p(this.f46984a, imVar, bArr);
                            return null;
                        }
                        fc.c.i("receive a message, msgid=" + a12.m2962a() + ", jobkey=" + str3);
                        if (z10 && b4.getExtra() != null && b4.getExtra().containsKey("notify_effect")) {
                            Map<String, String> extra = b4.getExtra();
                            String str4 = extra.get("notify_effect");
                            if (com.xiaomi.push.service.a.A(imVar)) {
                                Intent a13 = a(this.f46984a, imVar.f456b, extra);
                                a13.putExtra("eventMessageType", i10);
                                a13.putExtra("messageId", str);
                                String c10 = a12.c();
                                if (!TextUtils.isEmpty(c10)) {
                                    a13.putExtra("payload", c10);
                                }
                                this.f46984a.startActivity(a13);
                                i4.a(this.f46984a).g(this.f46984a.getPackageName(), h4.j(i10), str, 3006, str4);
                            } else {
                                Context context = this.f46984a;
                                Intent a14 = a(context, context.getPackageName(), extra);
                                if (a14 != null) {
                                    if (!str4.equals(kc.n.f50821c)) {
                                        a14.putExtra("key_message", b4);
                                        a14.putExtra("eventMessageType", i10);
                                        a14.putExtra("messageId", str);
                                    }
                                    this.f46984a.startActivity(a14);
                                    fc.c.i("start activity succ");
                                    i4.a(this.f46984a).g(this.f46984a.getPackageName(), h4.j(i10), str, 1006, str4);
                                    if (str4.equals(kc.n.f50821c)) {
                                        i4.a(this.f46984a).h(this.f46984a.getPackageName(), h4.j(i10), str, Constants.VIA_REPORT_TYPE_JOININ_GROUP);
                                    }
                                }
                            }
                            return null;
                        }
                        miPushMessage = b4;
                    } else {
                        fc.c.i("drop a duplicate message, key=" + str3);
                        i4.a(this.f46984a).j(this.f46984a.getPackageName(), h4.j(i10), str, "2:" + str3);
                    }
                    if (imVar.m3002a() == null && !z10) {
                        m(itVar, imVar);
                    }
                    return miPushMessage;
                case 2:
                    ir irVar = (ir) c4;
                    String str5 = o0.c(this.f46984a).f47054d;
                    if (TextUtils.isEmpty(str5) || !TextUtils.equals(str5, irVar.m3030a())) {
                        fc.c.i("bad Registration result:");
                        i4.a(this.f46984a).i(this.f46984a.getPackageName(), h4.j(i10), str, "21");
                        return null;
                    }
                    o0.c(this.f46984a).f47054d = null;
                    long j11 = irVar.f511a;
                    Context context2 = this.f46984a;
                    if (j11 == 0) {
                        o0.c(context2).o(irVar.f521e, irVar.f522f, irVar.f528l);
                        a10 = i4.a(this.f46984a);
                        packageName = this.f46984a.getPackageName();
                        j10 = h4.j(i10);
                        i11 = 6006;
                        str2 = "1";
                    } else {
                        a10 = i4.a(context2);
                        packageName = this.f46984a.getPackageName();
                        j10 = h4.j(i10);
                        i11 = 6006;
                        str2 = "2";
                    }
                    a10.g(packageName, j10, str, i11, str2);
                    if (!TextUtils.isEmpty(irVar.f521e)) {
                        arrayList3 = new ArrayList();
                        arrayList3.add(irVar.f521e);
                    }
                    MiPushCommandMessage a15 = p.a(fk.COMMAND_REGISTER.f266a, arrayList3, irVar.f511a, irVar.f520d, null);
                    h0.g(this.f46984a).R();
                    return a15;
                case 3:
                    if (((ix) c4).f587a == 0) {
                        o0.c(this.f46984a).e();
                        MiPushClient.m(this.f46984a);
                    }
                    PushMessageHandler.b();
                    return miPushMessage;
                case 4:
                    iv ivVar = (iv) c4;
                    if (ivVar.f562a == 0) {
                        MiPushClient.i(this.f46984a, ivVar.a());
                    }
                    if (!TextUtils.isEmpty(ivVar.a())) {
                        arrayList2 = new ArrayList();
                        arrayList2.add(ivVar.a());
                    }
                    return p.a(fk.COMMAND_SUBSCRIBE_TOPIC.f266a, arrayList2, ivVar.f562a, ivVar.f568d, ivVar.b());
                case 5:
                    iz izVar = (iz) c4;
                    if (izVar.f607a == 0) {
                        MiPushClient.S(this.f46984a, izVar.a());
                    }
                    if (!TextUtils.isEmpty(izVar.a())) {
                        arrayList = new ArrayList();
                        arrayList.add(izVar.a());
                    }
                    return p.a(fk.COMMAND_UNSUBSCRIBE_TOPIC.f266a, arrayList, izVar.f607a, izVar.f613d, izVar.b());
                case 6:
                    b2.f(this.f46984a.getPackageName(), this.f46984a, c4, hq.Command, bArr.length);
                    il ilVar = (il) c4;
                    String a16 = ilVar.a();
                    List<String> m2997a = ilVar.m2997a();
                    if (ilVar.f437a == 0) {
                        if (TextUtils.equals(a16, fk.COMMAND_SET_ACCEPT_TIME.f266a) && m2997a != null && m2997a.size() > 1) {
                            MiPushClient.d(this.f46984a, m2997a.get(0), m2997a.get(1));
                            if ("00:00".equals(m2997a.get(0)) && "00:00".equals(m2997a.get(1))) {
                                o0.c(this.f46984a).j(true);
                            } else {
                                o0.c(this.f46984a).j(false);
                            }
                            m2997a = f(TimeZone.getTimeZone("GMT+08"), TimeZone.getDefault(), m2997a);
                        } else if (TextUtils.equals(a16, fk.COMMAND_SET_ALIAS.f266a) && m2997a != null && m2997a.size() > 0) {
                            MiPushClient.f(this.f46984a, m2997a.get(0));
                        } else if (TextUtils.equals(a16, fk.COMMAND_UNSET_ALIAS.f266a) && m2997a != null && m2997a.size() > 0) {
                            MiPushClient.O(this.f46984a, m2997a.get(0));
                        } else if (TextUtils.equals(a16, fk.COMMAND_SET_ACCOUNT.f266a) && m2997a != null && m2997a.size() > 0) {
                            MiPushClient.e(this.f46984a, m2997a.get(0));
                        } else if (TextUtils.equals(a16, fk.COMMAND_UNSET_ACCOUNT.f266a) && m2997a != null && m2997a.size() > 0) {
                            MiPushClient.N(this.f46984a, m2997a.get(0));
                        } else if (TextUtils.equals(a16, fk.COMMAND_CHK_VDEVID.f266a)) {
                            if (m2997a != null && m2997a.size() > 0) {
                                n6.j(this.f46984a, m2997a.get(0));
                            }
                            return null;
                        }
                    }
                    return p.a(a16, m2997a, ilVar.f437a, ilVar.f445d, ilVar.b());
                case 7:
                    b2.f(this.f46984a.getPackageName(), this.f46984a, c4, hq.Notification, bArr.length);
                    if (c4 instanceof ih) {
                        ih ihVar = (ih) c4;
                        String a17 = ihVar.a();
                        if (ia.DisablePushMessage.f329a.equalsIgnoreCase(ihVar.f414d)) {
                            if (ihVar.f407a == 0) {
                                synchronized (z.class) {
                                    if (z.b(this.f46984a).f(a17)) {
                                        z.b(this.f46984a).h(a17);
                                        z b10 = z.b(this.f46984a);
                                        av avVar = av.DISABLE_PUSH;
                                        if ("syncing".equals(b10.c(avVar))) {
                                            z.b(this.f46984a).d(avVar, "synced");
                                            MiPushClient.o(this.f46984a);
                                            MiPushClient.n(this.f46984a);
                                            PushMessageHandler.b();
                                            h0.g(this.f46984a).I();
                                        }
                                    }
                                }
                            } else if ("syncing".equals(z.b(this.f46984a).c(av.DISABLE_PUSH))) {
                                synchronized (z.class) {
                                    if (z.b(this.f46984a).f(a17)) {
                                        if (z.b(this.f46984a).a(a17) < 10) {
                                            z.b(this.f46984a).g(a17);
                                            h0.g(this.f46984a).D(true, a17);
                                        } else {
                                            z.b(this.f46984a).h(a17);
                                        }
                                    }
                                }
                            }
                        } else if (ia.EnablePushMessage.f329a.equalsIgnoreCase(ihVar.f414d)) {
                            if (ihVar.f407a == 0) {
                                synchronized (z.class) {
                                    if (z.b(this.f46984a).f(a17)) {
                                        z.b(this.f46984a).h(a17);
                                        z b11 = z.b(this.f46984a);
                                        av avVar2 = av.ENABLE_PUSH;
                                        if ("syncing".equals(b11.c(avVar2))) {
                                            z.b(this.f46984a).d(avVar2, "synced");
                                        }
                                    }
                                }
                            } else if ("syncing".equals(z.b(this.f46984a).c(av.ENABLE_PUSH))) {
                                synchronized (z.class) {
                                    if (z.b(this.f46984a).f(a17)) {
                                        if (z.b(this.f46984a).a(a17) < 10) {
                                            z.b(this.f46984a).g(a17);
                                            h0.g(this.f46984a).D(false, a17);
                                        } else {
                                            z.b(this.f46984a).h(a17);
                                        }
                                    }
                                }
                            }
                        } else if (ia.ThirdPartyRegUpdate.f329a.equalsIgnoreCase(ihVar.f414d)) {
                            q(ihVar);
                        } else if (ia.UploadTinyData.f329a.equalsIgnoreCase(ihVar.f414d)) {
                            k(ihVar);
                        }
                        z.b(this.f46984a).h(a17);
                    } else if (c4 instanceof ip) {
                        ip ipVar = (ip) c4;
                        if ("registration id expired".equalsIgnoreCase(ipVar.f473d)) {
                            List<String> v2 = MiPushClient.v(this.f46984a);
                            List<String> w3 = MiPushClient.w(this.f46984a);
                            List<String> x10 = MiPushClient.x(this.f46984a);
                            String u10 = MiPushClient.u(this.f46984a);
                            MiPushClient.H(this.f46984a, ie.RegIdExpired);
                            for (String str6 : v2) {
                                MiPushClient.O(this.f46984a, str6);
                                MiPushClient.X(this.f46984a, str6, null);
                            }
                            for (String str7 : w3) {
                                MiPushClient.S(this.f46984a, str7);
                                MiPushClient.e0(this.f46984a, str7, null);
                            }
                            for (String str8 : x10) {
                                MiPushClient.N(this.f46984a, str8);
                                MiPushClient.a0(this.f46984a, str8, null);
                            }
                            String[] split = u10.split(",");
                            if (split.length == 2) {
                                MiPushClient.M(this.f46984a);
                                MiPushClient.d(this.f46984a, split[0], split[1]);
                            }
                        } else if ("client_info_update_ok".equalsIgnoreCase(ipVar.f473d)) {
                            if (ipVar.m3017a() != null && ipVar.m3017a().containsKey("app_version")) {
                                o0.c(this.f46984a).g(ipVar.m3017a().get("app_version"));
                            }
                        } else if (!ia.AwakeApp.f329a.equalsIgnoreCase(ipVar.f473d)) {
                            try {
                                if (ia.NormalClientConfigUpdate.f329a.equalsIgnoreCase(ipVar.f473d)) {
                                    io ioVar = new io();
                                    o6.b(ioVar, ipVar.m3022a());
                                    kc.k.f(kc.j.d(this.f46984a), ioVar);
                                } else if (ia.CustomClientConfigUpdate.f329a.equalsIgnoreCase(ipVar.f473d)) {
                                    in inVar = new in();
                                    o6.b(inVar, ipVar.m3022a());
                                    kc.k.e(kc.j.d(this.f46984a), inVar);
                                } else if (ia.SyncInfoResult.f329a.equalsIgnoreCase(ipVar.f473d)) {
                                    m0.c(this.f46984a, ipVar);
                                } else if (ia.ForceSync.f329a.equalsIgnoreCase(ipVar.f473d)) {
                                    fc.c.i("receive force sync notification");
                                    m0.d(this.f46984a, false);
                                } else if (ia.CancelPushMessage.f329a.equals(ipVar.f473d)) {
                                    if (ipVar.m3017a() != null) {
                                        int i12 = -2;
                                        if (ipVar.m3017a().containsKey(kc.n.G)) {
                                            String str9 = ipVar.m3017a().get(kc.n.G);
                                            if (!TextUtils.isEmpty(str9)) {
                                                try {
                                                    i12 = Integer.parseInt(str9);
                                                } catch (NumberFormatException e2) {
                                                    e2.printStackTrace();
                                                }
                                            }
                                        }
                                        if (i12 >= -1) {
                                            MiPushClient.p(this.f46984a, i12);
                                        } else {
                                            MiPushClient.q(this.f46984a, ipVar.m3017a().containsKey(kc.n.E) ? ipVar.m3017a().get(kc.n.E) : "", ipVar.m3017a().containsKey(kc.n.F) ? ipVar.m3017a().get(kc.n.F) : "");
                                        }
                                    }
                                } else if (ia.HybridRegisterResult.f329a.equals(ipVar.f473d)) {
                                    ir irVar2 = new ir();
                                    o6.b(irVar2, ipVar.m3022a());
                                    m.a(this.f46984a, irVar2);
                                } else if (ia.HybridUnregisterResult.f329a.equals(ipVar.f473d)) {
                                    ix ixVar = new ix();
                                    o6.b(ixVar, ipVar.m3022a());
                                    m.b(this.f46984a, ixVar);
                                } else if (ia.PushLogUpload.f329a.equals(ipVar.f473d) && ipVar.m3017a() != null && ipVar.m3017a().containsKey("packages")) {
                                    String[] split2 = ipVar.m3017a().get("packages").split(",");
                                    if (TextUtils.equals(this.f46984a.getPackageName(), "com.xiaomi.xmsf")) {
                                        g.f(this.f46984a, true);
                                        i(this.f46984a, split2);
                                    } else {
                                        g.f(this.f46984a, false);
                                    }
                                }
                            } catch (jg e10) {
                                fc.c.k(e10);
                            }
                        } else if (imVar.m3010b() && ipVar.m3017a() != null && ipVar.m3017a().containsKey("awake_info")) {
                            String str10 = ipVar.m3017a().get("awake_info");
                            Context context3 = this.f46984a;
                            z0.e(context3, o0.c(context3).d(), kc.j.d(this.f46984a).a(hv.AwakeInfoUploadWaySwitch.a(), 0), str10);
                        }
                    }
                    return miPushMessage;
                default:
                    return miPushMessage;
            }
        } catch (t e11) {
            fc.c.k(e11);
            l(imVar);
            i4.a(this.f46984a).i(this.f46984a.getPackageName(), h4.j(i10), str, Constants.VIA_ACT_TYPE_NINETEEN);
            return null;
        } catch (jg e12) {
            fc.c.k(e12);
            fc.c.n("receive a message which action string is not valid. is the reg expired?");
            i4.a(this.f46984a).i(this.f46984a.getPackageName(), h4.j(i10), str, "20");
            return null;
        }
    }

    public final PushMessageHandler.a d(im imVar, byte[] bArr) {
        String str;
        jb c4;
        String str2 = null;
        try {
            c4 = a0.c(this.f46984a, imVar);
        } catch (t e2) {
            fc.c.k(e2);
            str = "message arrived: receive a message but decrypt failed. report when click.";
        } catch (jg e10) {
            fc.c.k(e10);
            str = "message arrived: receive a message which action string is not valid. is the reg expired?";
        }
        if (c4 == null) {
            fc.c.n("message arrived: receiving an un-recognized message. " + ((Object) imVar.f449a));
            return null;
        }
        hq a10 = imVar.a();
        fc.c.i("message arrived: processing an arrived message, action=" + ((Object) a10));
        if (g0.f46996a[a10.ordinal()] != 1) {
            return null;
        }
        if (imVar.m3010b()) {
            it itVar = (it) c4;
            ic a11 = itVar.a();
            if (a11 != null) {
                id idVar = imVar.f450a;
                if (idVar != null && idVar.m2971a() != null) {
                    str2 = imVar.f450a.f364a.get("jobkey");
                }
                MiPushMessage b4 = p.b(itVar, imVar.m3002a(), false);
                b4.setArrivedMessage(true);
                fc.c.i("message arrived: receive a message, msgid=" + a11.m2962a() + ", jobkey=" + str2);
                return b4;
            }
            str = "message arrived: receive an empty message without push content, drop it";
        } else {
            str = "message arrived: receiving an un-encrypt message(SendMessage).";
        }
        fc.c.n(str);
        return null;
    }

    public List<String> f(TimeZone timeZone, TimeZone timeZone2, List<String> list) {
        if (timeZone.equals(timeZone2)) {
            return list;
        }
        long rawOffset = ((timeZone.getRawOffset() - timeZone2.getRawOffset()) / 1000) / 60;
        long parseLong = ((((Long.parseLong(list.get(0).split(com.huawei.openalliance.ad.constant.u.bD)[0]) * 60) + Long.parseLong(list.get(0).split(com.huawei.openalliance.ad.constant.u.bD)[1])) - rawOffset) + 1440) % 1440;
        long parseLong2 = ((((Long.parseLong(list.get(1).split(com.huawei.openalliance.ad.constant.u.bD)[0]) * 60) + Long.parseLong(list.get(1).split(com.huawei.openalliance.ad.constant.u.bD)[1])) - rawOffset) + 1440) % 1440;
        ArrayList arrayList = new ArrayList();
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(parseLong / 60), Long.valueOf(parseLong % 60)));
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(parseLong2 / 60), Long.valueOf(parseLong2 % 60)));
        return arrayList;
    }

    public final void g() {
        SharedPreferences sharedPreferences = this.f46984a.getSharedPreferences("mipush_extra", 0);
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - sharedPreferences.getLong("last_reinitialize", 0L)) > 1800000) {
            MiPushClient.H(this.f46984a, ie.PackageUnregistered);
            sharedPreferences.edit().putLong("last_reinitialize", currentTimeMillis).commit();
        }
    }

    public final void h(Context context, PackageInfo packageInfo) {
        ServiceInfo[] serviceInfoArr = packageInfo.services;
        if (serviceInfoArr != null) {
            for (ServiceInfo serviceInfo : serviceInfoArr) {
                if (serviceInfo.exported && serviceInfo.enabled && "com.xiaomi.mipush.sdk.PushMessageHandler".equals(serviceInfo.name) && !context.getPackageName().equals(serviceInfo.packageName)) {
                    try {
                        Intent intent = new Intent();
                        intent.setClassName(serviceInfo.packageName, serviceInfo.name);
                        intent.setAction("com.xiaomi.mipush.sdk.SYNC_LOG");
                        PushMessageHandler.e(context, intent);
                        return;
                    } catch (Throwable unused) {
                        return;
                    }
                }
            }
        }
    }

    public final void i(Context context, String[] strArr) {
        com.xiaomi.push.n.c(context).g(new f0(this, strArr, context));
    }

    public final void k(ih ihVar) {
        String a10 = ihVar.a();
        fc.c.l("receive ack " + a10);
        Map<String, String> m2985a = ihVar.m2985a();
        if (m2985a != null) {
            String str = m2985a.get("real_source");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            fc.c.l("receive ack : messageId = " + a10 + "  realSource = " + str);
            com.xiaomi.push.z0.b(this.f46984a).j(a10, str, Boolean.valueOf(ihVar.f407a == 0));
        }
    }

    public final void l(im imVar) {
        fc.c.i("receive a message but decrypt failed. report now.");
        ip ipVar = new ip(imVar.m3002a().f362a, false);
        ipVar.c(ia.DecryptMessageFail.f329a);
        ipVar.b(imVar.m3003a());
        ipVar.d(imVar.f456b);
        HashMap hashMap = new HashMap();
        ipVar.f468a = hashMap;
        hashMap.put("regid", MiPushClient.D(this.f46984a));
        h0.g(this.f46984a).v(ipVar, hq.Notification, false, null);
    }

    public final void m(it itVar, im imVar) {
        id m3002a = imVar.m3002a();
        ig igVar = new ig();
        igVar.b(itVar.b());
        igVar.a(itVar.m3037a());
        igVar.a(itVar.a().a());
        if (!TextUtils.isEmpty(itVar.c())) {
            igVar.c(itVar.c());
        }
        if (!TextUtils.isEmpty(itVar.d())) {
            igVar.d(itVar.d());
        }
        igVar.a(o6.a(this.f46984a, imVar));
        h0.g(this.f46984a).t(igVar, hq.AckMessage, m3002a);
    }

    public final void n(String str, long j10, d dVar) {
        av a10 = w0.a(dVar);
        if (a10 == null) {
            return;
        }
        if (j10 == 0) {
            synchronized (z.class) {
                if (z.b(this.f46984a).f(str)) {
                    z.b(this.f46984a).h(str);
                    if ("syncing".equals(z.b(this.f46984a).c(a10))) {
                        z.b(this.f46984a).d(a10, "synced");
                    }
                }
            }
            return;
        }
        if (!"syncing".equals(z.b(this.f46984a).c(a10))) {
            z.b(this.f46984a).h(str);
            return;
        }
        synchronized (z.class) {
            if (z.b(this.f46984a).f(str)) {
                if (z.b(this.f46984a).a(str) < 10) {
                    z.b(this.f46984a).g(str);
                    h0.g(this.f46984a).z(str, a10, dVar);
                } else {
                    z.b(this.f46984a).h(str);
                }
            }
        }
    }

    public final boolean p(im imVar) {
        if (!TextUtils.equals("com.miui.hybrid", imVar.b()) && !TextUtils.equals("com.miui.hybrid.loader", imVar.b())) {
            return false;
        }
        Map<String, String> m2971a = imVar.m3002a() == null ? null : imVar.m3002a().m2971a();
        if (m2971a == null) {
            return false;
        }
        String str = m2971a.get("push_server_action");
        return TextUtils.equals(str, "hybrid_message") || TextUtils.equals(str, "platform_message");
    }

    public final void q(ih ihVar) {
        Context context;
        d dVar;
        fc.c.m("ASSEMBLE_PUSH : " + ihVar.toString());
        String a10 = ihVar.a();
        Map<String, String> m2985a = ihVar.m2985a();
        if (m2985a != null) {
            String str = m2985a.get("RegInfo");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (str.contains("brand:" + ah.FCM.name())) {
                fc.c.i("ASSEMBLE_PUSH : receive fcm token sync ack");
                context = this.f46984a;
                dVar = d.ASSEMBLE_PUSH_FCM;
            } else {
                if (str.contains("brand:" + ah.HUAWEI.name())) {
                    fc.c.i("ASSEMBLE_PUSH : receive hw token sync ack");
                    context = this.f46984a;
                    dVar = d.ASSEMBLE_PUSH_HUAWEI;
                } else {
                    if (str.contains("brand:" + ah.OPPO.name())) {
                        fc.c.i("ASSEMBLE_PUSH : receive COS token sync ack");
                        context = this.f46984a;
                        dVar = d.ASSEMBLE_PUSH_COS;
                    } else {
                        if (!str.contains("brand:" + ah.VIVO.name())) {
                            return;
                        }
                        fc.c.i("ASSEMBLE_PUSH : receive FTOS token sync ack");
                        context = this.f46984a;
                        dVar = d.ASSEMBLE_PUSH_FTOS;
                    }
                }
            }
            t0.g(context, dVar, str);
            n(a10, ihVar.f407a, dVar);
        }
    }

    public final void r(im imVar) {
        id m3002a = imVar.m3002a();
        ig igVar = new ig();
        igVar.b(imVar.m3003a());
        igVar.a(m3002a.m2970a());
        igVar.a(m3002a.m2968a());
        if (!TextUtils.isEmpty(m3002a.m2975b())) {
            igVar.c(m3002a.m2975b());
        }
        igVar.a(o6.a(this.f46984a, imVar));
        h0.g(this.f46984a).v(igVar, hq.AckMessage, false, imVar.m3002a());
    }
}
