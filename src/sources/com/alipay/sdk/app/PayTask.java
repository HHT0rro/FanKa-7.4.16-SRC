package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alipay.sdk.app.PayResultActivity;
import com.alipay.sdk.data.a;
import com.alipay.sdk.util.H5PayResultModel;
import com.alipay.sdk.util.e;
import com.alipay.sdk.util.l;
import com.alipay.sdk.util.n;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class PayTask {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f4378a = com.alipay.sdk.util.e.class;

    /* renamed from: h, reason: collision with root package name */
    private static long f4379h = 0;

    /* renamed from: i, reason: collision with root package name */
    private static final long f4380i = 3000;

    /* renamed from: j, reason: collision with root package name */
    private static long f4381j = -1;

    /* renamed from: b, reason: collision with root package name */
    private Activity f4382b;

    /* renamed from: c, reason: collision with root package name */
    private com.alipay.sdk.widget.a f4383c;

    /* renamed from: d, reason: collision with root package name */
    private String f4384d = "wappaygw.alipay.com/service/rest.htm";

    /* renamed from: e, reason: collision with root package name */
    private String f4385e = "mclient.alipay.com/service/rest.htm";

    /* renamed from: f, reason: collision with root package name */
    private String f4386f = "mclient.alipay.com/home/exterfaceAssign.htm";

    /* renamed from: g, reason: collision with root package name */
    private Map<String, a> f4387g = new HashMap();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class a {

        /* renamed from: b, reason: collision with root package name */
        private String f4389b;

        /* renamed from: c, reason: collision with root package name */
        private String f4390c;

        /* renamed from: d, reason: collision with root package name */
        private String f4391d;

        /* renamed from: e, reason: collision with root package name */
        private String f4392e;

        private a() {
            this.f4389b = "";
            this.f4390c = "";
            this.f4391d = "";
            this.f4392e = "";
        }

        public String a() {
            return this.f4389b;
        }

        public String b() {
            return this.f4391d;
        }

        public String c() {
            return this.f4390c;
        }

        public String d() {
            return this.f4392e;
        }

        public void a(String str) {
            this.f4389b = str;
        }

        public void b(String str) {
            this.f4391d = str;
        }

        public void c(String str) {
            this.f4390c = str;
        }

        public void d(String str) {
            this.f4392e = str;
        }

        public /* synthetic */ a(PayTask payTask, g gVar) {
            this();
        }
    }

    public PayTask(Activity activity) {
        this.f4382b = activity;
        com.alipay.sdk.sys.b.a().a(this.f4382b, com.alipay.sdk.data.c.b());
        com.alipay.sdk.app.statistic.a.a(activity);
        this.f4383c = new com.alipay.sdk.widget.a(activity, com.alipay.sdk.widget.a.f4776b);
    }

    private static final String a(String... strArr) {
        if (strArr == null) {
            return "";
        }
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String b(java.lang.String r8) {
        /*
            r7 = this;
            r7.showLoading()
            r0 = 0
            com.alipay.sdk.packet.impl.e r1 = new com.alipay.sdk.packet.impl.e     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L90
            r1.<init>()     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L90
            android.app.Activity r2 = r7.f4382b     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L90
            android.content.Context r2 = r2.getApplicationContext()     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L90
            com.alipay.sdk.packet.b r8 = r1.a(r2, r8)     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L90
            org.json.JSONObject r8 = r8.c()     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L90
            java.lang.String r1 = "end_code"
            java.lang.String r1 = r8.optString(r1, r0)     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L90
            java.lang.String r2 = "form"
            org.json.JSONObject r2 = r8.optJSONObject(r2)     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L90
            java.lang.String r3 = "onload"
            org.json.JSONObject r2 = r2.optJSONObject(r3)     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L90
            java.util.List r2 = com.alipay.sdk.protocol.b.a(r2)     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L90
            r3 = 0
            r4 = 0
        L2f:
            int r5 = r2.size()     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L90
            if (r4 >= r5) goto L4f
            java.lang.Object r5 = r2.get(r4)     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L90
            com.alipay.sdk.protocol.b r5 = (com.alipay.sdk.protocol.b) r5     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L90
            com.alipay.sdk.protocol.a r5 = r5.b()     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L90
            com.alipay.sdk.protocol.a r6 = com.alipay.sdk.protocol.a.Update     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L90
            if (r5 != r6) goto L4c
            java.lang.Object r5 = r2.get(r4)     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L90
            com.alipay.sdk.protocol.b r5 = (com.alipay.sdk.protocol.b) r5     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L90
            com.alipay.sdk.protocol.b.a(r5)     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L90
        L4c:
            int r4 = r4 + 1
            goto L2f
        L4f:
            r7.a(r8)     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L90
            r7.dismissLoading()     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L90
        L55:
            int r8 = r2.size()     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L90
            if (r3 >= r8) goto La0
            java.lang.Object r8 = r2.get(r3)     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L90
            com.alipay.sdk.protocol.b r8 = (com.alipay.sdk.protocol.b) r8     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L90
            com.alipay.sdk.protocol.a r4 = r8.b()     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L90
            com.alipay.sdk.protocol.a r5 = com.alipay.sdk.protocol.a.WapPay     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L90
            if (r4 != r5) goto L71
            java.lang.String r8 = r7.a(r8)     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L90
            r7.dismissLoading()
            return r8
        L71:
            com.alipay.sdk.protocol.a r4 = r8.b()     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L90
            com.alipay.sdk.protocol.a r5 = com.alipay.sdk.protocol.a.OpenWeb     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L90
            if (r4 != r5) goto L81
            java.lang.String r8 = r7.a(r8, r1)     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L90
            r7.dismissLoading()
            return r8
        L81:
            int r3 = r3 + 1
            goto L55
        L84:
            r8 = move-exception
            com.alipay.sdk.util.c.a(r8)     // Catch: java.lang.Throwable -> Lbe
            java.lang.String r1 = "biz"
            java.lang.String r2 = "H5PayDataAnalysisError"
            com.alipay.sdk.app.statistic.a.a(r1, r2, r8)     // Catch: java.lang.Throwable -> Lbe
            goto La0
        L90:
            r8 = move-exception
            com.alipay.sdk.app.k r0 = com.alipay.sdk.app.k.NETWORK_ERROR     // Catch: java.lang.Throwable -> Lbe
            int r0 = r0.a()     // Catch: java.lang.Throwable -> Lbe
            com.alipay.sdk.app.k r0 = com.alipay.sdk.app.k.b(r0)     // Catch: java.lang.Throwable -> Lbe
            java.lang.String r1 = "net"
            com.alipay.sdk.app.statistic.a.a(r1, r8)     // Catch: java.lang.Throwable -> Lbe
        La0:
            r7.dismissLoading()
            if (r0 != 0) goto Laf
            com.alipay.sdk.app.k r8 = com.alipay.sdk.app.k.FAILED
            int r8 = r8.a()
            com.alipay.sdk.app.k r0 = com.alipay.sdk.app.k.b(r8)
        Laf:
            int r8 = r0.a()
            java.lang.String r0 = r0.b()
            java.lang.String r1 = ""
            java.lang.String r8 = com.alipay.sdk.app.j.a(r8, r0, r1)
            return r8
        Lbe:
            r8 = move-exception
            r7.dismissLoading()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.PayTask.b(java.lang.String):java.lang.String");
    }

    public static synchronized boolean fetchSdkConfig(Context context) {
        synchronized (PayTask.class) {
            try {
                com.alipay.sdk.sys.b.a().a(context, com.alipay.sdk.data.c.b());
                long elapsedRealtime = SystemClock.elapsedRealtime() / 1000;
                if (elapsedRealtime - f4379h < com.alipay.sdk.data.a.g().e()) {
                    return false;
                }
                f4379h = elapsedRealtime;
                com.alipay.sdk.data.a.g().a(context.getApplicationContext());
                return true;
            } catch (Exception e2) {
                com.alipay.sdk.util.c.a(e2);
                return false;
            }
        }
    }

    public void dismissLoading() {
        com.alipay.sdk.widget.a aVar = this.f4383c;
        if (aVar != null) {
            aVar.c();
            this.f4383c = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x00dc, code lost:
    
        if (r9.startsWith("http://" + r16.f4385e) != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0179, code lost:
    
        if (r9.startsWith("http://" + r16.f4386f) != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x003f, code lost:
    
        if (r9.startsWith("http://" + r16.f4384d) != false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized java.lang.String fetchOrderInfoFromH5PayUrl(java.lang.String r17) {
        /*
            Method dump skipped, instructions count: 1189
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.PayTask.fetchOrderInfoFromH5PayUrl(java.lang.String):java.lang.String");
    }

    public synchronized String fetchTradeToken() {
        return com.alipay.sdk.util.i.a(this.f4382b.getApplicationContext());
    }

    public String getVersion() {
        return "15.6.2";
    }

    public synchronized H5PayResultModel h5Pay(String str, boolean z10) {
        H5PayResultModel h5PayResultModel;
        h5PayResultModel = new H5PayResultModel();
        try {
            String[] split = pay(str, z10).split(";");
            HashMap hashMap = new HashMap();
            for (String str2 : split) {
                String substring = str2.substring(0, str2.indexOf("={"));
                hashMap.put(substring, a(str2, substring));
            }
            if (hashMap.containsKey(l.f4746a)) {
                h5PayResultModel.setResultCode(hashMap.get(l.f4746a));
            }
            h5PayResultModel.setReturnUrl(a(str, hashMap));
            if (TextUtils.isEmpty(h5PayResultModel.getReturnUrl())) {
                com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.f4432b, com.alipay.sdk.app.statistic.c.R, "");
            }
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.f4432b, com.alipay.sdk.app.statistic.c.S, th);
            com.alipay.sdk.util.c.a(th);
        }
        return h5PayResultModel;
    }

    public synchronized String pay(String str, boolean z10) {
        String str2;
        if (b()) {
            return j.d();
        }
        if (z10) {
            showLoading();
        }
        if (str.contains("payment_inst=")) {
            String substring = str.substring(str.indexOf("payment_inst=") + 13);
            int indexOf = substring.indexOf(38);
            if (indexOf > 0) {
                substring = substring.substring(0, indexOf);
            }
            i.a(substring.replaceAll("\"", "").toLowerCase(Locale.getDefault()).replaceAll("alipay", ""));
        } else {
            i.a("");
        }
        if (str.contains(com.alipay.sdk.cons.a.f4535r)) {
            com.alipay.sdk.cons.a.f4536s = true;
        }
        if (com.alipay.sdk.cons.a.f4536s) {
            if (str.startsWith(com.alipay.sdk.cons.a.f4537t)) {
                str = str.substring(str.indexOf(com.alipay.sdk.cons.a.f4537t) + 53);
            } else if (str.startsWith(com.alipay.sdk.cons.a.f4538u)) {
                str = str.substring(str.indexOf(com.alipay.sdk.cons.a.f4538u) + 52);
            }
        }
        try {
            str2 = a(str);
            com.alipay.sdk.util.i.a(this.f4382b.getApplicationContext(), str2);
        } catch (Throwable th) {
            try {
                String c4 = j.c();
                com.alipay.sdk.util.c.a(th);
                com.alipay.sdk.data.a.g().a(this.f4382b.getApplicationContext());
                dismissLoading();
                com.alipay.sdk.app.statistic.a.b(this.f4382b.getApplicationContext(), str);
                str2 = c4;
            } finally {
                com.alipay.sdk.data.a.g().a(this.f4382b.getApplicationContext());
                dismissLoading();
                com.alipay.sdk.app.statistic.a.b(this.f4382b.getApplicationContext(), str);
            }
        }
        return str2;
    }

    public synchronized boolean payInterceptorWithUrl(String str, boolean z10, H5PayCallback h5PayCallback) {
        String fetchOrderInfoFromH5PayUrl;
        fetchOrderInfoFromH5PayUrl = fetchOrderInfoFromH5PayUrl(str);
        if (!TextUtils.isEmpty(fetchOrderInfoFromH5PayUrl)) {
            new Thread(new g(this, fetchOrderInfoFromH5PayUrl, z10, h5PayCallback)).start();
        }
        return !TextUtils.isEmpty(fetchOrderInfoFromH5PayUrl);
    }

    public synchronized Map<String, String> payV2(String str, boolean z10) {
        return l.a(pay(str, z10));
    }

    public void showLoading() {
        com.alipay.sdk.widget.a aVar = this.f4383c;
        if (aVar != null) {
            aVar.b();
        }
    }

    private boolean a(boolean z10, boolean z11, String str, StringBuilder sb2, Map<String, String> map, String... strArr) {
        String str2;
        int length = strArr.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                str2 = "";
                break;
            }
            String str3 = strArr[i10];
            if (!TextUtils.isEmpty(map.get(str3))) {
                str2 = map.get(str3);
                break;
            }
            i10++;
        }
        if (TextUtils.isEmpty(str2)) {
            return !z11;
        }
        if (z10) {
            sb2.append("&");
            sb2.append(str);
            sb2.append("=\"");
            sb2.append(str2);
            sb2.append("\"");
            return true;
        }
        sb2.append(str);
        sb2.append("=\"");
        sb2.append(str2);
        sb2.append("\"");
        return true;
    }

    private String a(String str, Map<String, String> map) throws UnsupportedEncodingException {
        boolean equals = "9000".equals(map.get(l.f4746a));
        String str2 = map.get("result");
        a remove = this.f4387g.remove(str);
        String[] strArr = new String[2];
        strArr[0] = remove != null ? remove.b() : "";
        strArr[1] = remove != null ? remove.d() : "";
        a(strArr);
        if (map.containsKey("callBackUrl")) {
            return map.get("callBackUrl");
        }
        if (str2.length() > 15) {
            String a10 = a(n.a("&callBackUrl=\"", "\"", str2), n.a("&call_back_url=\"", "\"", str2), n.a(com.alipay.sdk.cons.a.f4533p, "\"", str2), URLDecoder.decode(n.a(com.alipay.sdk.cons.a.f4534q, "&", str2), "utf-8"), URLDecoder.decode(n.a("&callBackUrl=", "&", str2), "utf-8"), n.a("call_back_url=\"", "\"", str2));
            if (!TextUtils.isEmpty(a10)) {
                return a10;
            }
        }
        if (remove != null) {
            String a11 = equals ? remove.a() : remove.c();
            if (!TextUtils.isEmpty(a11)) {
                return a11;
            }
        }
        return com.alipay.sdk.data.a.g().d();
    }

    private String a(String str, String str2) {
        String str3 = str2 + "={";
        return str.substring(str.indexOf(str3) + str3.length(), str.lastIndexOf(com.alipay.sdk.util.i.f4738d));
    }

    private static boolean b() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - f4381j < 3000) {
            return true;
        }
        f4381j = elapsedRealtime;
        return false;
    }

    private e.a a() {
        return new h(this);
    }

    private String a(String str) {
        String a10 = new com.alipay.sdk.sys.a(this.f4382b).a(str);
        if (a10.contains("paymethod=\"expressGateway\"")) {
            return b(a10);
        }
        List<a.C0096a> f10 = com.alipay.sdk.data.a.g().f();
        if (!com.alipay.sdk.data.a.g().f4580p || f10 == null) {
            f10 = i.f4411a;
        }
        if (n.b(this.f4382b, f10)) {
            com.alipay.sdk.util.e eVar = new com.alipay.sdk.util.e(this.f4382b, a());
            String a11 = eVar.a(a10);
            eVar.a();
            if (!TextUtils.equals(a11, com.alipay.sdk.util.e.f4721a) && !TextUtils.equals(a11, com.alipay.sdk.util.e.f4722b)) {
                if (TextUtils.isEmpty(a11)) {
                    return j.c();
                }
                if (!a11.contains(PayResultActivity.f4367a)) {
                    return a11;
                }
                com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.f4432b, com.alipay.sdk.app.statistic.c.O, "");
                return a(a10, f10, a11, this.f4382b);
            }
            com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.f4432b, com.alipay.sdk.app.statistic.c.M, "");
            return b(a10);
        }
        com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.f4432b, com.alipay.sdk.app.statistic.c.N, "");
        return b(a10);
    }

    private static String a(String str, List<a.C0096a> list, String str2, Activity activity) {
        n.a a10 = n.a(activity, list);
        if (a10 == null || a10.a() || a10.b() || !TextUtils.equals(a10.f4759a.packageName, PayResultActivity.f4369c)) {
            return str2;
        }
        com.alipay.sdk.util.c.b("msp", "PayTask:payResult: NOT_LOGIN");
        String valueOf = String.valueOf(str.hashCode());
        Object obj = new Object();
        HashMap<String, Object> hashMap = PayResultActivity.f4368b;
        hashMap.put(valueOf, obj);
        Intent intent = new Intent(activity, (Class<?>) PayResultActivity.class);
        intent.putExtra(PayResultActivity.f4371e, str);
        intent.putExtra(PayResultActivity.f4372f, activity.getPackageName());
        intent.putExtra(PayResultActivity.f4370d, valueOf);
        activity.startActivity(intent);
        synchronized (hashMap.get(valueOf)) {
            try {
                com.alipay.sdk.util.c.b("msp", "PayTask:payResult: wait");
                hashMap.get(valueOf).wait();
            } catch (InterruptedException e2) {
                com.alipay.sdk.util.c.b("msp", "PayTask:payResult: InterruptedException:" + ((Object) e2));
                return j.c();
            }
        }
        String str3 = PayResultActivity.a.f4377b;
        com.alipay.sdk.util.c.b("msp", "PayTask:payResult: result:" + str3);
        return str3;
    }

    private void a(JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString("tid");
            String optString2 = jSONObject.optString(com.alipay.sdk.tid.b.f4685e);
            if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                return;
            }
            com.alipay.sdk.tid.b.a(com.alipay.sdk.sys.b.a().b()).a(optString, optString2);
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.f4432b, com.alipay.sdk.app.statistic.c.F, th);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x008c, code lost:
    
        r0 = r6.c();
        r10 = com.alipay.sdk.app.j.a(java.lang.Integer.valueOf(r0[1]).intValue(), r0[0], com.alipay.sdk.util.n.e(r0[2]));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a(com.alipay.sdk.protocol.b r10, java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 274
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.PayTask.a(com.alipay.sdk.protocol.b, java.lang.String):java.lang.String");
    }

    private String a(com.alipay.sdk.protocol.b bVar) {
        String[] c4 = bVar.c();
        Intent intent = new Intent(this.f4382b, (Class<?>) H5PayActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("url", c4[0]);
        if (c4.length == 2) {
            bundle.putString("cookie", c4[1]);
        }
        intent.putExtras(bundle);
        this.f4382b.startActivity(intent);
        Object obj = f4378a;
        synchronized (obj) {
            try {
                obj.wait();
            } catch (InterruptedException e2) {
                com.alipay.sdk.util.c.a(e2);
                return j.c();
            }
        }
        String a10 = j.a();
        return TextUtils.isEmpty(a10) ? j.c() : a10;
    }
}
