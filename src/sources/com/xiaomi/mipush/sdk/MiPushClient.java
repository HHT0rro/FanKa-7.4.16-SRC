package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.xiaomi.mipush.sdk.n;
import com.xiaomi.push.f4;
import com.xiaomi.push.fk;
import com.xiaomi.push.g4;
import com.xiaomi.push.g7;
import com.xiaomi.push.h4;
import com.xiaomi.push.hq;
import com.xiaomi.push.hv;
import com.xiaomi.push.i7;
import com.xiaomi.push.ia;
import com.xiaomi.push.id;
import com.xiaomi.push.ie;
import com.xiaomi.push.ik;
import com.xiaomi.push.ip;
import com.xiaomi.push.iq;
import com.xiaomi.push.iu;
import com.xiaomi.push.iw;
import com.xiaomi.push.l7;
import com.xiaomi.push.m2;
import com.xiaomi.push.n6;
import com.xiaomi.push.n7;
import com.xiaomi.push.service.receivers.NetworkStatusReceiver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class MiPushClient {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f46946a;

    /* renamed from: b, reason: collision with root package name */
    public static Context f46947b;

    /* renamed from: c, reason: collision with root package name */
    public static long f46948c = System.currentTimeMillis();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class CodeResult {
        private long resultCode = -1;

        public long getResultCode() {
            return this.resultCode;
        }

        public void setResultCode(long j10) {
            this.resultCode = j10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface ICallbackResult<R> {
        void onResult(R r10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class TokenResult {
        private String token = null;
        private long resultCode = -1;

        public long getResultCode() {
            return this.resultCode;
        }

        public String getToken() {
            return this.token;
        }

        public void setResultCode(long j10) {
            this.resultCode = j10;
        }

        public void setToken(String str) {
            this.token = str;
        }
    }

    @Deprecated
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static abstract class a {

        /* renamed from: a, reason: collision with root package name */
        public String f46949a;

        public String a() {
            return this.f46949a;
        }

        public void b(String str, long j10, String str2, List<String> list) {
        }

        public void c(long j10, String str, String str2) {
        }

        public void d(MiPushMessage miPushMessage) {
        }

        public void e(String str, String str2, String str3, boolean z10) {
        }

        public void f(long j10, String str, String str2) {
        }

        public void g(long j10, String str, String str2) {
        }
    }

    public static boolean A(Context context) {
        k(context, "context");
        return q0.e(context).m(d.ASSEMBLE_PUSH_HUAWEI);
    }

    public static boolean B(Context context) {
        k(context, "context");
        return q0.e(context).m(d.ASSEMBLE_PUSH_COS);
    }

    public static boolean C(Context context) {
        return q0.e(context).m(d.ASSEMBLE_PUSH_FTOS);
    }

    public static String D(Context context) {
        if (o0.c(context).s()) {
            return o0.c(context).q();
        }
        return null;
    }

    public static void E(Context context) {
        h4.o(new k());
        gc.a e2 = h4.e(context);
        hc.b.e(context).o("3_7_6");
        hc.a.a(context, e2, new f4(context), new g4(context));
        q.b(context);
        d1.a(context, e2);
        kc.j.d(context).h(new l(100, "perf event job update", context));
    }

    public static void F(Context context, String str, String str2, a aVar, String str3, ICallbackResult iCallbackResult) {
        try {
            fc.c.i("sdk_version = 3_7_6");
            if (aVar != null) {
                PushMessageHandler.m(aVar);
            }
            if (iCallbackResult != null) {
                PushMessageHandler.l(iCallbackResult);
            }
            if (n7.h(f46947b)) {
                x.b(f46947b);
            }
            if (o0.c(f46947b).l(str, str2) || l(f46947b)) {
                boolean z10 = o0.c(f46947b).a() != c.a();
                if (!z10 && !c0(f46947b)) {
                    h0.g(f46947b).l();
                    fc.c.i("Could not send  register message within 5s repeatly .");
                    return;
                }
                if (z10 || !o0.c(f46947b).l(str, str2) || o0.c(f46947b).w()) {
                    String a10 = com.xiaomi.push.p0.a(6);
                    o0.c(f46947b).e();
                    o0.c(f46947b).f(c.a());
                    o0.c(f46947b).i(str, str2, a10);
                    n.a.b().h("com.xiaomi.xmpushsdk.tinydataPending.appId");
                    m(f46947b);
                    iq iqVar = new iq();
                    iqVar.a(kc.m.a());
                    iqVar.b(str);
                    iqVar.e(str2);
                    iqVar.d(f46947b.getPackageName());
                    iqVar.f(a10);
                    Context context2 = f46947b;
                    iqVar.c(com.xiaomi.push.g.e(context2, context2.getPackageName()));
                    Context context3 = f46947b;
                    iqVar.b(com.xiaomi.push.g.a(context3, context3.getPackageName()));
                    iqVar.h("3_7_6");
                    iqVar.a(30706);
                    iqVar.i(n6.C(f46947b));
                    iqVar.a(ie.Init);
                    if (!TextUtils.isEmpty(str3)) {
                        iqVar.g(str3);
                    }
                    if (!g7.k()) {
                        String E = n6.E(f46947b);
                        if (!TextUtils.isEmpty(E)) {
                            iqVar.k(com.xiaomi.push.p0.b(E) + "," + n6.H(f46947b));
                        }
                    }
                    iqVar.j(n6.f());
                    int c4 = n6.c();
                    if (c4 >= 0) {
                        iqVar.c(c4);
                    }
                    h0.g(f46947b).r(iqVar, z10);
                    f46947b.getSharedPreferences("mipush_extra", 4).getBoolean("mipush_registed", true);
                } else {
                    if (1 == p.c(f46947b)) {
                        k(aVar, "callback");
                        aVar.c(0L, null, o0.c(f46947b).q());
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(o0.c(f46947b).q());
                        p.f(f46947b, p.a(fk.COMMAND_REGISTER.f266a, arrayList, 0L, null, null));
                    }
                    h0.g(f46947b).l();
                    if (o0.c(f46947b).k()) {
                        ip ipVar = new ip();
                        ipVar.b(o0.c(f46947b).d());
                        ipVar.c("client_info_update");
                        ipVar.a(kc.m.a());
                        HashMap hashMap = new HashMap();
                        ipVar.f468a = hashMap;
                        Context context4 = f46947b;
                        hashMap.put("app_version", com.xiaomi.push.g.e(context4, context4.getPackageName()));
                        Map<String, String> map = ipVar.f468a;
                        Context context5 = f46947b;
                        map.put("app_version_code", Integer.toString(com.xiaomi.push.g.a(context5, context5.getPackageName())));
                        ipVar.f468a.put("push_sdk_vn", "3_7_6");
                        ipVar.f468a.put("push_sdk_vc", Integer.toString(30706));
                        n6.k(f46947b, ipVar.f468a);
                        String v2 = o0.c(f46947b).v();
                        if (!TextUtils.isEmpty(v2)) {
                            ipVar.f468a.put("deviceid", v2);
                        }
                        h0.g(f46947b).v(ipVar, hq.Notification, false, null);
                    }
                    if (!i7.d(f46947b, "update_devId", false)) {
                        l0();
                        i7.b(f46947b, "update_devId", true);
                    }
                    String z11 = n6.z(f46947b);
                    if (!TextUtils.isEmpty(z11)) {
                        ik ikVar = new ik();
                        ikVar.a(kc.m.a());
                        ikVar.b(str);
                        ikVar.c(fk.COMMAND_CHK_VDEVID.f266a);
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(n6.v(f46947b));
                        arrayList2.add(z11);
                        String str4 = Build.MODEL;
                        if (str4 == null) {
                            str4 = "";
                        }
                        arrayList2.add(str4);
                        String str5 = Build.BOARD;
                        arrayList2.add(str5 != null ? str5 : "");
                        ikVar.a(arrayList2);
                        h0.g(f46947b).v(ikVar, hq.Command, false, null);
                    }
                    if (d0(f46947b) && b0(f46947b)) {
                        ip ipVar2 = new ip();
                        ipVar2.b(o0.c(f46947b).d());
                        ipVar2.c(ia.PullOfflineMessage.f329a);
                        ipVar2.a(kc.m.a());
                        ipVar2.a(false);
                        h0.g(f46947b).w(ipVar2, hq.Notification, false, null, false);
                        g(f46947b);
                    }
                }
                h(f46947b);
                W();
                V(f46947b);
                E(f46947b);
                m0.b(f46947b);
                t();
                if (!f46947b.getPackageName().equals("com.xiaomi.xmsf")) {
                    if (g.b() != null) {
                        g.d(f46947b, g.b());
                    }
                    fc.c.c(2);
                }
                G(context);
            }
        } catch (Throwable th) {
            fc.c.k(th);
        }
    }

    public static void G(Context context) {
        if ("syncing".equals(z.b(f46947b).c(av.DISABLE_PUSH))) {
            r(f46947b);
        }
        if ("syncing".equals(z.b(f46947b).c(av.ENABLE_PUSH))) {
            s(f46947b);
        }
        if ("syncing".equals(z.b(f46947b).c(av.UPLOAD_HUAWEI_TOKEN))) {
            i0(f46947b);
        }
        if ("syncing".equals(z.b(f46947b).c(av.UPLOAD_FCM_TOKEN))) {
            g0(f46947b);
        }
        if ("syncing".equals(z.b(f46947b).c(av.UPLOAD_COS_TOKEN))) {
            f0(context);
        }
        if ("syncing".equals(z.b(f46947b).c(av.UPLOAD_FTOS_TOKEN))) {
            h0(context);
        }
    }

    public static void H(Context context, ie ieVar) {
        if (o0.c(context).s()) {
            String a10 = com.xiaomi.push.p0.a(6);
            String d10 = o0.c(context).d();
            String m10 = o0.c(context).m();
            o0.c(context).e();
            o0.c(context).f(c.a());
            o0.c(context).i(d10, m10, a10);
            iq iqVar = new iq();
            iqVar.a(kc.m.a());
            iqVar.b(d10);
            iqVar.e(m10);
            iqVar.f(a10);
            iqVar.d(context.getPackageName());
            iqVar.c(com.xiaomi.push.g.e(context, context.getPackageName()));
            iqVar.a(ieVar);
            h0.g(context).r(iqVar, false);
        }
    }

    public static void I(Context context) {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            intentFilter.addCategory("android.intent.category.DEFAULT");
            context.getApplicationContext().registerReceiver(new NetworkStatusReceiver(null), intentFilter);
        } catch (Throwable th) {
            fc.c.k(th);
        }
    }

    public static void J(Context context, String str, String str2) {
        K(context, str, str2, new o());
    }

    public static void K(Context context, String str, String str2, o oVar) {
        L(context, str, str2, oVar, null, null);
    }

    public static void L(Context context, String str, String str2, o oVar, String str3, ICallbackResult iCallbackResult) {
        k(context, "context");
        k(str, "appID");
        k(str2, "appToken");
        Context applicationContext = context.getApplicationContext();
        f46947b = applicationContext;
        if (applicationContext == null) {
            f46947b = context;
        }
        Context context2 = f46947b;
        n7.f(context2);
        if (!NetworkStatusReceiver.c()) {
            I(f46947b);
        }
        q0.e(f46947b).g(oVar);
        com.xiaomi.push.n.c(context2).g(new h(str, str2, str3, iCallbackResult));
    }

    public static synchronized void M(Context context) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.remove("accept_time");
            l7.a(edit);
        }
    }

    public static synchronized void N(Context context, String str) {
        synchronized (MiPushClient.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().remove("account_" + str).commit();
        }
    }

    public static synchronized void O(Context context, String str) {
        synchronized (MiPushClient.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().remove("alias_" + str).commit();
        }
    }

    public static synchronized void P(Context context) {
        synchronized (MiPushClient.class) {
            Iterator<String> iterator2 = x(context).iterator2();
            while (iterator2.hasNext()) {
                N(context, iterator2.next());
            }
        }
    }

    public static synchronized void Q(Context context) {
        synchronized (MiPushClient.class) {
            Iterator<String> iterator2 = v(context).iterator2();
            while (iterator2.hasNext()) {
                O(context, iterator2.next());
            }
        }
    }

    public static synchronized void R(Context context) {
        synchronized (MiPushClient.class) {
            Iterator<String> iterator2 = w(context).iterator2();
            while (iterator2.hasNext()) {
                S(context, iterator2.next());
            }
        }
    }

    public static synchronized void S(Context context, String str) {
        synchronized (MiPushClient.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().remove("topic_" + str).commit();
        }
    }

    public static void T(Context context, String str, id idVar, String str2, String str3) {
        ip ipVar = new ip();
        if (TextUtils.isEmpty(str3)) {
            fc.c.n("do not report clicked message");
            return;
        }
        ipVar.b(str3);
        ipVar.c("bar:click");
        ipVar.a(str);
        ipVar.a(false);
        h0.g(context).y(ipVar, hq.Notification, false, true, idVar, true, str2, str3);
    }

    public static void U(Context context, String str, id idVar, String str2) {
        ip ipVar = new ip();
        if (TextUtils.isEmpty(str2)) {
            if (!o0.c(context).p()) {
                fc.c.n("do not report clicked message");
                return;
            }
            str2 = o0.c(context).d();
        }
        ipVar.b(str2);
        ipVar.c("bar:click");
        ipVar.a(str);
        ipVar.a(false);
        h0.g(context).v(ipVar, hq.Notification, false, idVar);
    }

    public static void V(Context context) {
        if (kc.j.d(f46947b).i(hv.DataCollectionSwitch.a(), y())) {
            m2.b().c(new c1(context));
            com.xiaomi.push.n.c(f46947b).h(new i(), 10);
        }
    }

    public static void W() {
        com.xiaomi.push.n.c(f46947b).l(new y(f46947b), kc.j.d(f46947b).a(hv.OcVersionCheckFrequency.a(), RemoteMessageConst.DEFAULT_TTL), 5);
    }

    public static void X(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Y(context, fk.COMMAND_SET_ALIAS.f266a, str, str2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0033, code lost:
    
        com.xiaomi.mipush.sdk.PushMessageHandler.k(r12, r15, r13, 0, null, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x003e, code lost:
    
        com.xiaomi.mipush.sdk.p.f(r12, com.xiaomi.mipush.sdk.p.a(r0.f266a, r6, 0, null, r15));
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a7, code lost:
    
        if (1 == com.xiaomi.mipush.sdk.p.c(r12)) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0031, code lost:
    
        if (1 == com.xiaomi.mipush.sdk.p.c(r12)) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void Y(android.content.Context r12, java.lang.String r13, java.lang.String r14, java.lang.String r15) {
        /*
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            boolean r0 = android.text.TextUtils.isEmpty(r14)
            if (r0 != 0) goto Le
            r6.add(r14)
        Le:
            com.xiaomi.push.fk r0 = com.xiaomi.push.fk.COMMAND_SET_ALIAS
            java.lang.String r1 = r0.f266a
            boolean r1 = r1.equalsIgnoreCase(r13)
            r2 = 1
            if (r1 == 0) goto L4e
            long r3 = java.lang.System.currentTimeMillis()
            long r7 = j(r12, r14)
            long r3 = r3 - r7
            long r3 = java.lang.Math.abs(r3)
            r7 = 86400000(0x5265c00, double:4.2687272E-316)
            int r1 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r1 >= 0) goto L4e
            int r14 = com.xiaomi.mipush.sdk.p.c(r12)
            if (r2 != r14) goto L3e
        L33:
            r3 = 0
            r5 = 0
            r0 = r12
            r1 = r15
            r2 = r13
            com.xiaomi.mipush.sdk.PushMessageHandler.k(r0, r1, r2, r3, r5, r6)
            goto Lc7
        L3e:
            java.lang.String r0 = r0.f266a
            r2 = 0
            r4 = 0
            r1 = r6
            r5 = r15
            com.xiaomi.mipush.sdk.MiPushCommandMessage r13 = com.xiaomi.mipush.sdk.p.a(r0, r1, r2, r4, r5)
            com.xiaomi.mipush.sdk.p.f(r12, r13)
            goto Lc7
        L4e:
            com.xiaomi.push.fk r0 = com.xiaomi.push.fk.COMMAND_UNSET_ALIAS
            java.lang.String r0 = r0.f266a
            boolean r0 = r0.equalsIgnoreCase(r13)
            java.lang.String r1 = " is unseted"
            r3 = 3
            r4 = 0
            if (r0 == 0) goto L85
            long r7 = j(r12, r14)
            int r0 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r0 >= 0) goto L85
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "Don't cancel alias for "
        L6c:
            r12.append(r13)
            java.lang.String r13 = r6.toString()
            java.lang.String r13 = com.xiaomi.push.p0.c(r13, r3)
            r12.append(r13)
            r12.append(r1)
            java.lang.String r12 = r12.toString()
            fc.c.i(r12)
            goto Lc7
        L85:
            com.xiaomi.push.fk r0 = com.xiaomi.push.fk.COMMAND_SET_ACCOUNT
            java.lang.String r7 = r0.f266a
            boolean r7 = r7.equalsIgnoreCase(r13)
            if (r7 == 0) goto Laa
            long r7 = java.lang.System.currentTimeMillis()
            long r9 = c(r12, r14)
            long r7 = r7 - r9
            long r7 = java.lang.Math.abs(r7)
            r9 = 3600000(0x36ee80, double:1.7786363E-317)
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 >= 0) goto Laa
            int r14 = com.xiaomi.mipush.sdk.p.c(r12)
            if (r2 != r14) goto L3e
            goto L33
        Laa:
            com.xiaomi.push.fk r0 = com.xiaomi.push.fk.COMMAND_UNSET_ACCOUNT
            java.lang.String r0 = r0.f266a
            boolean r0 = r0.equalsIgnoreCase(r13)
            if (r0 == 0) goto Lc4
            long r7 = c(r12, r14)
            int r14 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r14 >= 0) goto Lc4
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "Don't cancel account for "
            goto L6c
        Lc4:
            Z(r12, r13, r6, r15)
        Lc7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.MiPushClient.Y(android.content.Context, java.lang.String, java.lang.String, java.lang.String):void");
    }

    public static void Z(Context context, String str, ArrayList<String> arrayList, String str2) {
        if (TextUtils.isEmpty(o0.c(context).d())) {
            return;
        }
        ik ikVar = new ik();
        ikVar.a(kc.m.a());
        ikVar.b(o0.c(context).d());
        ikVar.c(str);
        Iterator<String> iterator2 = arrayList.iterator2();
        while (iterator2.hasNext()) {
            ikVar.m2994a(iterator2.next());
        }
        ikVar.e(str2);
        ikVar.d(context.getPackageName());
        h0.g(context).t(ikVar, hq.Command, null);
    }

    public static void a0(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Y(context, fk.COMMAND_SET_ACCOUNT.f266a, str, str2);
    }

    public static boolean b0(Context context) {
        return Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_pull_notification", -1L)) > com.huawei.openalliance.ad.constant.u.as;
    }

    public static long c(Context context, String str) {
        return context.getSharedPreferences("mipush_extra", 0).getLong("account_" + str, -1L);
    }

    public static boolean c0(Context context) {
        return Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_reg_request", -1L)) > 5000;
    }

    public static synchronized void d(Context context, String str, String str2) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putString("accept_time", str + "," + str2);
            l7.a(edit);
        }
    }

    public static boolean d0(Context context) {
        return h0.g(context).E();
    }

    public static synchronized void e(Context context, String str) {
        synchronized (MiPushClient.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().putLong("account_" + str, System.currentTimeMillis()).commit();
        }
    }

    public static void e0(Context context, String str, String str2) {
        if (TextUtils.isEmpty(o0.c(context).d()) || TextUtils.isEmpty(str)) {
            return;
        }
        if (Math.abs(System.currentTimeMillis() - j0(context, str)) <= 86400000) {
            if (1 == p.c(context)) {
                PushMessageHandler.j(context, str2, 0L, null, str);
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            p.f(context, p.a(fk.COMMAND_SUBSCRIBE_TOPIC.f266a, arrayList, 0L, null, null));
            return;
        }
        iu iuVar = new iu();
        iuVar.a(kc.m.a());
        iuVar.b(o0.c(context).d());
        iuVar.c(str);
        iuVar.d(context.getPackageName());
        iuVar.e(str2);
        h0.g(context).t(iuVar, hq.Subscription, null);
    }

    public static synchronized void f(Context context, String str) {
        synchronized (MiPushClient.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().putLong("alias_" + str, System.currentTimeMillis()).commit();
        }
    }

    public static void f0(Context context) {
        h0.g(context).z(null, av.UPLOAD_COS_TOKEN, d.ASSEMBLE_PUSH_COS);
    }

    public static void g(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.putLong("last_pull_notification", System.currentTimeMillis());
        l7.a(edit);
    }

    public static void g0(Context context) {
        h0.g(context).z(null, av.UPLOAD_FCM_TOKEN, d.ASSEMBLE_PUSH_FCM);
    }

    public static void h(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.putLong("last_reg_request", System.currentTimeMillis());
        l7.a(edit);
    }

    public static void h0(Context context) {
        h0.g(context).z(null, av.UPLOAD_FTOS_TOKEN, d.ASSEMBLE_PUSH_FTOS);
    }

    public static synchronized void i(Context context, String str) {
        synchronized (MiPushClient.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().putLong("topic_" + str, System.currentTimeMillis()).commit();
        }
    }

    public static void i0(Context context) {
        h0.g(context).z(null, av.UPLOAD_HUAWEI_TOKEN, d.ASSEMBLE_PUSH_HUAWEI);
    }

    public static long j(Context context, String str) {
        return context.getSharedPreferences("mipush_extra", 0).getLong("alias_" + str, -1L);
    }

    public static long j0(Context context, String str) {
        return context.getSharedPreferences("mipush_extra", 0).getLong("topic_" + str, -1L);
    }

    public static void k(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw new IllegalArgumentException("param " + str + " is not nullable");
    }

    public static void k0(Context context) {
        t0.h(context);
        kc.j.d(context).e();
        if (o0.c(context).p()) {
            iw iwVar = new iw();
            iwVar.a(kc.m.a());
            iwVar.b(o0.c(context).d());
            iwVar.c(o0.c(context).q());
            iwVar.e(o0.c(context).m());
            iwVar.d(context.getPackageName());
            h0.g(context).s(iwVar);
            PushMessageHandler.b();
            PushMessageHandler.o();
            o0.c(context).n();
            n(context);
            o(context);
            m(context);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004c, code lost:
    
        if (com.xiaomi.push.d0.a(r6).mo2931a() == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0061, code lost:
    
        if (android.text.TextUtils.isEmpty(r4) != false) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean l(android.content.Context r6) {
        /*
            java.lang.String r0 = "android.permission.WRITE_EXTERNAL_STORAGE"
            java.lang.String r1 = "android.permission.READ_PHONE_STATE"
            r2 = 1
            if (r6 == 0) goto L64
            boolean r3 = com.xiaomi.push.g7.f()
            if (r3 != 0) goto L65
            java.lang.String r3 = r6.getPackageName()
            java.lang.String r4 = "com.xiaomi.xmsf"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L1a
            goto L65
        L1a:
            java.lang.String r3 = com.xiaomi.push.n6.p(r6)
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L25
            goto L65
        L25:
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 29
            if (r3 < r4) goto L2c
            goto L65
        L2c:
            android.content.pm.ApplicationInfo r4 = r6.getApplicationInfo()
            int r4 = r4.targetSdkVersion
            r5 = 23
            if (r4 < r5) goto L4f
            if (r3 < r5) goto L4f
            boolean r3 = com.xiaomi.push.h7.a(r6, r1)
            if (r3 != 0) goto L65
            boolean r3 = com.xiaomi.push.h7.a(r6, r0)
            if (r3 != 0) goto L65
            com.xiaomi.push.d0 r3 = com.xiaomi.push.d0.a(r6)
            boolean r3 = r3.mo2931a()
            if (r3 == 0) goto L64
            goto L65
        L4f:
            java.lang.String r3 = com.xiaomi.push.n6.D(r6)
            java.lang.String r4 = com.xiaomi.push.n6.f()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L65
            boolean r3 = android.text.TextUtils.isEmpty(r4)
            if (r3 != 0) goto L64
            goto L65
        L64:
            r2 = 0
        L65:
            if (r2 != 0) goto Lb8
            java.lang.String r3 = "Because of lack of necessary information, mi push can't be initialized"
            fc.c.n(r3)
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            boolean r4 = com.xiaomi.push.h7.a(r6, r1)
            if (r4 != 0) goto L7a
            r3.add(r1)
        L7a:
            boolean r1 = com.xiaomi.push.h7.a(r6, r0)
            if (r1 != 0) goto L83
            r3.add(r0)
        L83:
            boolean r0 = r3.isEmpty()
            if (r0 != 0) goto Lb8
            int r0 = r3.size()
            java.lang.String[] r0 = new java.lang.String[r0]
            r3.toArray(r0)
            android.content.Intent r1 = new android.content.Intent
            r1.<init>()
            java.lang.String r3 = "com.xiaomi.mipush.ERROR"
            r1.setAction(r3)
            java.lang.String r3 = r6.getPackageName()
            r1.setPackage(r3)
            r3 = 5
            java.lang.String r4 = "message_type"
            r1.putExtra(r4, r3)
            java.lang.String r3 = "error_type"
            java.lang.String r4 = "error_lack_of_permission"
            r1.putExtra(r3, r4)
            java.lang.String r3 = "error_message"
            r1.putExtra(r3, r0)
            r6.sendBroadcast(r1)
        Lb8:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.MiPushClient.l(android.content.Context):boolean");
    }

    public static void l0() {
        new Thread(new j()).start();
    }

    public static void m(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.clear();
        edit.commit();
    }

    public static void n(Context context) {
        h0.g(context).V();
    }

    public static void o(Context context) {
        h0.g(context).m(-1);
    }

    public static void p(Context context, int i10) {
        h0.g(context).m(i10);
    }

    public static void q(Context context, String str, String str2) {
        h0.g(context).B(str, str2);
    }

    public static void r(Context context) {
        h0.g(context).C(true);
    }

    public static void s(Context context) {
        h0.g(context).C(false);
    }

    public static void t() {
        boolean i10 = kc.j.d(f46947b).i(hv.ForceHandleCrashSwitch.a(), false);
        if (f46946a || !i10) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(new g1(f46947b));
    }

    public static String u(Context context) {
        return context.getSharedPreferences("mipush_extra", 0).getString("accept_time", "00:00-23:59");
    }

    public static List<String> v(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : context.getSharedPreferences("mipush_extra", 0).getAll().h()) {
            if (str.startsWith("alias_")) {
                arrayList.add(str.substring(6));
            }
        }
        return arrayList;
    }

    public static List<String> w(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : context.getSharedPreferences("mipush_extra", 0).getAll().h()) {
            if (str.startsWith("topic_") && !str.contains("**ALL**")) {
                arrayList.add(str.substring(6));
            }
        }
        return arrayList;
    }

    public static List<String> x(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : context.getSharedPreferences("mipush_extra", 0).getAll().h()) {
            if (str.startsWith("account_")) {
                arrayList.add(str.substring(8));
            }
        }
        return arrayList;
    }

    public static boolean y() {
        return g7.i();
    }

    public static boolean z(Context context) {
        k(context, "context");
        return q0.e(context).m(d.ASSEMBLE_PUSH_FCM);
    }
}
