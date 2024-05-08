package com.autonavi.aps.amapapi.trans;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.amap.api.col.p0003l.fk;
import com.amap.api.col.p0003l.hw;
import com.amap.api.col.p0003l.id;
import com.amap.api.col.p0003l.jd;
import com.amap.api.col.p0003l.je;
import com.autonavi.aps.amapapi.utils.h;
import com.autonavi.aps.amapapi.utils.i;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.openalliance.ad.constant.u;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AMapDnsManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static int f9542a = 1;

    /* renamed from: b, reason: collision with root package name */
    public static int f9543b = 2;

    /* renamed from: e, reason: collision with root package name */
    private static a f9544e;

    /* renamed from: j, reason: collision with root package name */
    private Context f9551j;

    /* renamed from: k, reason: collision with root package name */
    private String f9552k;

    /* renamed from: c, reason: collision with root package name */
    private long f9545c = 0;

    /* renamed from: d, reason: collision with root package name */
    private boolean f9546d = false;

    /* renamed from: f, reason: collision with root package name */
    private ArrayList<String> f9547f = new ArrayList<>();

    /* renamed from: g, reason: collision with root package name */
    private com.autonavi.aps.amapapi.d f9548g = new com.autonavi.aps.amapapi.d();

    /* renamed from: h, reason: collision with root package name */
    private com.autonavi.aps.amapapi.d f9549h = new com.autonavi.aps.amapapi.d();

    /* renamed from: i, reason: collision with root package name */
    private long f9550i = 120000;

    /* renamed from: l, reason: collision with root package name */
    private boolean f9553l = false;

    private a(Context context) {
        this.f9551j = context;
    }

    private static String c(int i10) {
        return i10 == f9543b ? "last_ip_6" : "last_ip_4";
    }

    private void d(int i10) {
        if (b(i10).d()) {
            SharedPreferences.Editor a10 = i.a(this.f9551j, "cbG9jaXA");
            i.a(a10, c(i10));
            i.a(a10);
            b(i10).a(false);
        }
    }

    private String e(int i10) {
        String str;
        int i11 = 0;
        b(false, i10);
        String[] a10 = b(i10).a();
        if (a10 != null && a10.length > 0) {
            int length = a10.length;
            while (true) {
                if (i11 >= length) {
                    str = null;
                    break;
                }
                str = a10[i11];
                if (!this.f9547f.contains(str)) {
                    break;
                }
                i11++;
            }
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            b(i10).a(str);
            return str;
        }
        g(i10);
        return b(i10).b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i10) {
        if (b(i10).a() == null || b(i10).a().length <= 0) {
            return;
        }
        String str = b(i10).a()[0];
        if (str.equals(this.f9552k) || this.f9547f.contains(str)) {
            return;
        }
        this.f9552k = str;
        SharedPreferences.Editor a10 = i.a(this.f9551j, "cbG9jaXA");
        i.a(a10, c(i10), str);
        i.a(a10);
    }

    private void g(int i10) {
        String a10 = i.a(this.f9551j, "cbG9jaXA", c(i10), (String) null);
        if (TextUtils.isEmpty(a10) || this.f9547f.contains(a10)) {
            return;
        }
        b(i10).a(a10);
        b(i10).b(a10);
        b(i10).a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.autonavi.aps.amapapi.d b(int i10) {
        if (i10 == f9543b) {
            return this.f9549h;
        }
        return this.f9548g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(String[] strArr, String[] strArr2) {
        if (strArr == null || strArr.length == 0 || strArr2 == null || strArr2.length == 0 || strArr.length != strArr2.length) {
            return false;
        }
        int length = strArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (!strArr[i10].equals(strArr2[i10])) {
                return false;
            }
        }
        return true;
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f9544e == null) {
                f9544e = new a(context);
            }
            aVar = f9544e;
        }
        return aVar;
    }

    public final String a(d dVar, int i10) {
        try {
            if (com.autonavi.aps.amapapi.utils.a.q() && dVar != null) {
                String url = dVar.getURL();
                String host = new URL(url).getHost();
                if (!"http://abroad.apilocate.amap.com/mobile/binary".equals(url) && !"abroad.apilocate.amap.com".equals(host)) {
                    String str = "apilocate.amap.com".equalsIgnoreCase(host) ? "httpdns.apilocate.amap.com" : host;
                    if (!fk.g(str)) {
                        return null;
                    }
                    String e2 = e(i10);
                    if (!TextUtils.isEmpty(e2)) {
                        dVar.c(url.replace(host, e2));
                        dVar.getRequestHead().put("host", str);
                        dVar.d(str);
                        dVar.setIPV6Request(i10 == f9543b);
                        return e2;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private synchronized void b(boolean z10, final int i10) {
        if (!z10) {
            if (!com.autonavi.aps.amapapi.utils.a.p() && this.f9553l) {
                return;
            }
        }
        if (this.f9545c != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            long j10 = this.f9545c;
            if (currentTimeMillis - j10 < this.f9550i) {
                return;
            }
            if (currentTimeMillis - j10 < 60000) {
                return;
            }
        }
        this.f9545c = System.currentTimeMillis();
        this.f9553l = true;
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StringBuffer stringBuffer = new StringBuffer();
        for (StackTraceElement stackTraceElement : stackTrace) {
            stringBuffer.append(stackTraceElement.getClassName() + "(" + stackTraceElement.getMethodName() + u.bD + stackTraceElement.getLineNumber() + "),");
        }
        jd.a().a(new je() { // from class: com.autonavi.aps.amapapi.trans.a.1
            @Override // com.amap.api.col.p0003l.je
            public final void runTask() {
                int i11;
                StringBuilder sb2 = new StringBuilder("http://");
                sb2.append(com.autonavi.aps.amapapi.utils.a.r());
                sb2.append("?host=dualstack-a.apilocate.amap.com&query=");
                sb2.append(i10 == a.f9543b ? 6 : 4);
                String sb3 = sb2.toString();
                b bVar = new b();
                bVar.a(sb3);
                bVar.b(sb3);
                bVar.setDegradeAbility(id.a.SINGLE);
                bVar.setHttpProtocol(id.c.HTTP);
                try {
                    hw.a();
                    JSONObject jSONObject = new JSONObject(new String(hw.a(bVar).f6444a));
                    String[] b4 = a.b(jSONObject.optJSONArray("ips"), a.f9542a);
                    if (b4 != null && b4.length > 0 && !a.b(b4, a.this.b(a.f9542a).a())) {
                        a.this.b(a.f9542a).a(b4);
                        a.this.f(a.f9542a);
                    }
                    String[] b10 = a.b(jSONObject.optJSONArray("ipsv6"), a.f9543b);
                    if (b10 != null && b10.length > 0 && !a.b(b10, a.this.b(a.f9543b).a())) {
                        a.this.b(a.f9543b).a(b10);
                        a.this.f(a.f9543b);
                    }
                    if ((jSONObject.has("ips") || jSONObject.has("ipsv6")) && jSONObject.has(RemoteMessageConst.TTL) && (i11 = jSONObject.getInt(RemoteMessageConst.TTL)) > 30) {
                        a.this.f9550i = i11 * 1000;
                    }
                } catch (Throwable th) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("key", "dnsError");
                        jSONObject2.put("reason", th.getMessage());
                    } catch (Throwable unused) {
                    }
                    h.a(a.this.f9551j, "O018", jSONObject2);
                }
            }
        });
    }

    public final void a(int i10) {
        if (!b(i10).e()) {
            this.f9547f.add(b(i10).b());
            d(i10);
            b(true, i10);
            return;
        }
        d(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String[] b(JSONArray jSONArray, int i10) throws JSONException {
        if (jSONArray == null || jSONArray.length() == 0) {
            return new String[0];
        }
        int length = jSONArray.length();
        String[] strArr = new String[length];
        for (int i11 = 0; i11 < length; i11++) {
            String string = jSONArray.getString(i11);
            if (!TextUtils.isEmpty(string)) {
                if (i10 == f9543b) {
                    string = "[" + string + "]";
                }
                strArr[i11] = string;
            }
        }
        return strArr;
    }

    public final void a(boolean z10, int i10) {
        b(i10).b(z10);
        if (z10) {
            String c4 = b(i10).c();
            String b4 = b(i10).b();
            if (TextUtils.isEmpty(b4) || b4.equals(c4)) {
                return;
            }
            SharedPreferences.Editor a10 = i.a(this.f9551j, "cbG9jaXA");
            i.a(a10, c(i10), b4);
            i.a(a10);
        }
    }
}
