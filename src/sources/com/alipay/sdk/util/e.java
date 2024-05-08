package com.alipay.sdk.util;

import android.app.Activity;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Binder;
import android.text.TextUtils;
import android.util.Base64;
import com.alipay.android.app.IAlixPay;
import com.alipay.android.app.IRemoteServiceCallback;
import com.alipay.sdk.app.AlipayResultActivity;
import com.alipay.sdk.util.n;
import com.vivo.push.PushClientConstants;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static final String f4721a = "failed";

    /* renamed from: b, reason: collision with root package name */
    public static final String f4722b = "scheme_failed";

    /* renamed from: c, reason: collision with root package name */
    private Activity f4723c;

    /* renamed from: d, reason: collision with root package name */
    private IAlixPay f4724d;

    /* renamed from: f, reason: collision with root package name */
    private boolean f4726f;

    /* renamed from: g, reason: collision with root package name */
    private a f4727g;

    /* renamed from: e, reason: collision with root package name */
    private final Object f4725e = IAlixPay.class;

    /* renamed from: h, reason: collision with root package name */
    private ServiceConnection f4728h = new f(this);

    /* renamed from: i, reason: collision with root package name */
    private String f4729i = null;

    /* renamed from: j, reason: collision with root package name */
    private IRemoteServiceCallback f4730j = new h(this);

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface a {
        void a();

        void b();
    }

    public e(Activity activity, a aVar) {
        this.f4723c = activity;
        this.f4727g = aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0053 A[Catch: all -> 0x005a, TryCatch #0 {all -> 0x005a, blocks: (B:3:0x0003, B:6:0x0017, B:9:0x0021, B:11:0x0027, B:14:0x002e, B:18:0x0037, B:20:0x003b, B:23:0x0046, B:24:0x004f, B:26:0x0053, B:27:0x0055, B:31:0x004b, B:33:0x0015), top: B:2:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a(java.lang.String r6) {
        /*
            r5 = this;
            java.lang.String r0 = ""
            r1 = 0
            com.alipay.sdk.data.a r2 = com.alipay.sdk.data.a.g()     // Catch: java.lang.Throwable -> L5a
            java.util.List r2 = r2.f()     // Catch: java.lang.Throwable -> L5a
            com.alipay.sdk.data.a r3 = com.alipay.sdk.data.a.g()     // Catch: java.lang.Throwable -> L5a
            boolean r3 = r3.f4580p     // Catch: java.lang.Throwable -> L5a
            if (r3 == 0) goto L15
            if (r2 != 0) goto L17
        L15:
            java.util.List<com.alipay.sdk.data.a$a> r2 = com.alipay.sdk.app.i.f4411a     // Catch: java.lang.Throwable -> L5a
        L17:
            android.app.Activity r3 = r5.f4723c     // Catch: java.lang.Throwable -> L5a
            com.alipay.sdk.util.n$a r2 = com.alipay.sdk.util.n.a(r3, r2)     // Catch: java.lang.Throwable -> L5a
            java.lang.String r3 = "failed"
            if (r2 == 0) goto L59
            boolean r4 = r2.a()     // Catch: java.lang.Throwable -> L5a
            if (r4 != 0) goto L59
            boolean r4 = r2.b()     // Catch: java.lang.Throwable -> L5a
            if (r4 == 0) goto L2e
            goto L59
        L2e:
            android.content.pm.PackageInfo r4 = r2.f4759a     // Catch: java.lang.Throwable -> L5a
            boolean r4 = com.alipay.sdk.util.n.a(r4)     // Catch: java.lang.Throwable -> L5a
            if (r4 == 0) goto L37
            return r3
        L37:
            android.content.pm.PackageInfo r3 = r2.f4759a     // Catch: java.lang.Throwable -> L5a
            if (r3 == 0) goto L4b
            java.lang.String r4 = "com.eg.android.AlipayGphone"
            java.lang.String r3 = r3.packageName     // Catch: java.lang.Throwable -> L5a
            boolean r3 = r4.equals(r3)     // Catch: java.lang.Throwable -> L5a
            if (r3 == 0) goto L46
            goto L4b
        L46:
            android.content.pm.PackageInfo r3 = r2.f4759a     // Catch: java.lang.Throwable -> L5a
            java.lang.String r0 = r3.packageName     // Catch: java.lang.Throwable -> L5a
            goto L4f
        L4b:
            java.lang.String r0 = com.alipay.sdk.util.n.a()     // Catch: java.lang.Throwable -> L5a
        L4f:
            android.content.pm.PackageInfo r3 = r2.f4759a     // Catch: java.lang.Throwable -> L5a
            if (r3 == 0) goto L55
            int r1 = r3.versionCode     // Catch: java.lang.Throwable -> L5a
        L55:
            r5.a(r2)     // Catch: java.lang.Throwable -> L5a
            goto L62
        L59:
            return r3
        L5a:
            r2 = move-exception
            java.lang.String r3 = "biz"
            java.lang.String r4 = "CheckClientSignEx"
            com.alipay.sdk.app.statistic.a.a(r3, r4, r2)
        L62:
            java.lang.String r6 = r5.a(r6, r0, r1)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.util.e.a(java.lang.String):java.lang.String");
    }

    private void a(n.a aVar) throws InterruptedException {
        PackageInfo packageInfo;
        if (aVar == null || (packageInfo = aVar.f4759a) == null) {
            return;
        }
        String str = packageInfo.packageName;
        Intent intent = new Intent();
        intent.setClassName(str, "com.alipay.android.app.TransProcessPayActivity");
        try {
            this.f4723c.startActivity(intent);
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.f4432b, com.alipay.sdk.app.statistic.c.H, th);
        }
        Thread.sleep(200L);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private String a(String str, String str2, int i10) {
        String str3;
        String a10 = a(str, str2);
        if (!f4721a.equals(a10) || !n.f4751b.equals(str2) || i10 <= 125 || !com.alipay.sdk.data.a.g().b()) {
            return a10;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        String a11 = n.a(32);
        com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.f4432b, "BSPStart", a11);
        AlipayResultActivity.f4355d.put(a11, new WeakReference<>(new g(this, countDownLatch)));
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sourcePid", Binder.getCallingPid());
            jSONObject.put(com.alipay.sdk.cons.b.f4542d, str);
            jSONObject.put(PushClientConstants.TAG_PKG_NAME, this.f4723c.getPackageName());
            jSONObject.put("session", a11);
            String str4 = "alipays://platefromapi/startapp?appId=20000125&mqpSchemePay=" + Uri.encode(Base64.encodeToString(jSONObject.toString().getBytes("UTF-8"), 2));
            Intent intent = new Intent();
            intent.setPackage(str2);
            intent.addFlags(268435456);
            intent.setData(Uri.parse(str4));
            this.f4723c.startActivity(intent);
            com.alipay.sdk.data.a.g().a(this.f4723c.getApplicationContext());
            countDownLatch.await();
            String str5 = this.f4729i;
            try {
                str3 = l.a(str5).get(l.f4746a);
                if (str3 == null) {
                    str3 = "null";
                }
            } catch (Throwable th) {
                str3 = "unknown";
                com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.f4432b, "BSPStatEx", th);
            }
            com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.f4432b, "BSPDone-" + str3, "");
            if (!TextUtils.isEmpty(str5)) {
                return str5;
            }
            com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.f4432b, "BSPEmpty", "");
            return f4722b;
        } catch (InterruptedException e2) {
            com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.f4432b, "BSPWaiting", e2);
            com.alipay.sdk.app.k kVar = com.alipay.sdk.app.k.PAY_WAITTING;
            return com.alipay.sdk.app.j.a(kVar.a(), kVar.b(), "");
        } catch (Throwable th2) {
            com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.f4432b, "BSPEx", th2);
            return f4722b;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00eb, code lost:
    
        if (r9 != null) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00ed, code lost:
    
        r9.setRequestedOrientation(0);
        r7.f4726f = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0129, code lost:
    
        if (r9 != null) goto L51;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a(java.lang.String r8, java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 374
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.util.e.a(java.lang.String, java.lang.String):java.lang.String");
    }

    public void a() {
        this.f4723c = null;
    }
}
