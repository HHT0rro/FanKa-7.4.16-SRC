package com.alipay.sdk.tid;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alipay.sdk.util.c;
import java.util.Random;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static final String f4681a = "alipay_tid_storage";

    /* renamed from: b, reason: collision with root package name */
    public static final String f4682b = "tidinfo";

    /* renamed from: c, reason: collision with root package name */
    public static final String f4683c = "upgraded_from_db";

    /* renamed from: d, reason: collision with root package name */
    public static final String f4684d = "tid";

    /* renamed from: e, reason: collision with root package name */
    public static final String f4685e = "client_key";

    /* renamed from: f, reason: collision with root package name */
    public static final String f4686f = "timestamp";

    /* renamed from: g, reason: collision with root package name */
    public static final String f4687g = "vimei";

    /* renamed from: h, reason: collision with root package name */
    public static final String f4688h = "vimsi";

    /* renamed from: i, reason: collision with root package name */
    private static Context f4689i;

    /* renamed from: o, reason: collision with root package name */
    private static b f4690o;

    /* renamed from: j, reason: collision with root package name */
    private String f4691j;

    /* renamed from: k, reason: collision with root package name */
    private String f4692k;

    /* renamed from: l, reason: collision with root package name */
    private long f4693l;

    /* renamed from: m, reason: collision with root package name */
    private String f4694m;

    /* renamed from: n, reason: collision with root package name */
    private String f4695n;

    /* renamed from: p, reason: collision with root package name */
    private boolean f4696p = false;

    public static synchronized b a(Context context) {
        b bVar;
        synchronized (b.class) {
            if (f4690o == null) {
                c.b("TidStorage", "getInstance");
                f4690o = new b();
            }
            if (f4689i == null) {
                f4690o.b(context);
            }
            bVar = f4690o;
        }
        return bVar;
    }

    private void b(Context context) {
        if (context != null) {
            c.b("TidStorage", "TidStorage.initialize context != null");
            f4689i = context.getApplicationContext();
        }
        if (this.f4696p) {
            return;
        }
        this.f4696p = true;
        k();
        l();
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0072, code lost:
    
        if (r5 == null) goto L49;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void k() {
        /*
            r10 = this;
            android.content.Context r0 = com.alipay.sdk.tid.b.f4689i
            if (r0 != 0) goto L5
            return
        L5:
            java.lang.String r1 = "alipay_tid_storage"
            java.lang.String r2 = "upgraded_from_db"
            boolean r3 = com.alipay.sdk.tid.b.a.d(r1, r2)
            java.lang.String r4 = "TidStorage"
            if (r3 == 0) goto L17
            java.lang.String r0 = "transferTidFromOldDb: already migrated. returning"
            com.alipay.sdk.util.c.b(r4, r0)
            return
        L17:
            r3 = 0
            java.lang.String r5 = "transferTidFromOldDb: tid from db: "
            com.alipay.sdk.util.c.b(r4, r5)     // Catch: java.lang.Throwable -> L6b
            com.alipay.sdk.tid.a r5 = new com.alipay.sdk.tid.a     // Catch: java.lang.Throwable -> L6b
            r5.<init>(r0)     // Catch: java.lang.Throwable -> L6b
            com.alipay.sdk.util.a r3 = com.alipay.sdk.util.a.a(r0)     // Catch: java.lang.Throwable -> L69
            java.lang.String r3 = r3.b()     // Catch: java.lang.Throwable -> L69
            com.alipay.sdk.util.a r6 = com.alipay.sdk.util.a.a(r0)     // Catch: java.lang.Throwable -> L69
            java.lang.String r6 = r6.a()     // Catch: java.lang.Throwable -> L69
            java.lang.String r7 = r5.a(r3, r6)     // Catch: java.lang.Throwable -> L69
            java.lang.String r3 = r5.b(r3, r6)     // Catch: java.lang.Throwable -> L69
            boolean r6 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Throwable -> L69
            if (r6 != 0) goto L65
            boolean r6 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L69
            if (r6 != 0) goto L65
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L69
            r6.<init>()     // Catch: java.lang.Throwable -> L69
            java.lang.String r8 = "transferTidFromOldDb: tid from db is "
            r6.append(r8)     // Catch: java.lang.Throwable -> L69
            r6.append(r7)     // Catch: java.lang.Throwable -> L69
            java.lang.String r8 = ", "
            r6.append(r8)     // Catch: java.lang.Throwable -> L69
            r6.append(r3)     // Catch: java.lang.Throwable -> L69
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L69
            com.alipay.sdk.util.c.b(r4, r6)     // Catch: java.lang.Throwable -> L69
            r10.a(r7, r3)     // Catch: java.lang.Throwable -> L69
        L65:
            r5.close()
            goto L75
        L69:
            r3 = move-exception
            goto L6f
        L6b:
            r5 = move-exception
            r9 = r5
            r5 = r3
            r3 = r9
        L6f:
            com.alipay.sdk.util.c.a(r3)     // Catch: java.lang.Throwable -> La0
            if (r5 == 0) goto L75
            goto L65
        L75:
            java.lang.String r3 = "transferTidFromOldDb: removing database table"
            com.alipay.sdk.util.c.b(r4, r3)     // Catch: java.lang.Throwable -> L89
            com.alipay.sdk.tid.a r3 = new com.alipay.sdk.tid.a     // Catch: java.lang.Throwable -> L89
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L89
            r3.a()     // Catch: java.lang.Throwable -> L86
            r3.close()
            goto L92
        L86:
            r0 = move-exception
            r5 = r3
            goto L8a
        L89:
            r0 = move-exception
        L8a:
            com.alipay.sdk.util.c.a(r0)     // Catch: java.lang.Throwable -> L99
            if (r5 == 0) goto L92
            r5.close()
        L92:
            r0 = 0
            java.lang.String r3 = "updated"
            com.alipay.sdk.tid.b.a.a(r1, r2, r3, r0)
            return
        L99:
            r0 = move-exception
            if (r5 == 0) goto L9f
            r5.close()
        L9f:
            throw r0
        La0:
            r0 = move-exception
            if (r5 == 0) goto La6
            r5.close()
        La6:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.tid.b.k():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0095  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void l() {
        /*
            r9 = this;
            java.lang.String r0 = ""
            long r1 = java.lang.System.currentTimeMillis()
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            r2 = 0
            java.lang.String r3 = "alipay_tid_storage"
            java.lang.String r4 = "tidinfo"
            r5 = 1
            java.lang.String r3 = com.alipay.sdk.tid.b.a.a(r3, r4, r5)     // Catch: java.lang.Exception -> L52
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Exception -> L52
            if (r4 != 0) goto L4e
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch: java.lang.Exception -> L52
            r4.<init>(r3)     // Catch: java.lang.Exception -> L52
            java.lang.String r3 = "tid"
            java.lang.String r3 = r4.optString(r3, r0)     // Catch: java.lang.Exception -> L52
            java.lang.String r5 = "client_key"
            java.lang.String r5 = r4.optString(r5, r0)     // Catch: java.lang.Exception -> L4b
            java.lang.String r6 = "timestamp"
            long r7 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L48
            long r6 = r4.optLong(r6, r7)     // Catch: java.lang.Exception -> L48
            java.lang.Long r1 = java.lang.Long.valueOf(r6)     // Catch: java.lang.Exception -> L48
            java.lang.String r6 = "vimei"
            java.lang.String r6 = r4.optString(r6, r0)     // Catch: java.lang.Exception -> L48
            java.lang.String r7 = "vimsi"
            java.lang.String r0 = r4.optString(r7, r0)     // Catch: java.lang.Exception -> L46
            goto L5a
        L46:
            r0 = move-exception
            goto L56
        L48:
            r0 = move-exception
            r6 = r2
            goto L56
        L4b:
            r0 = move-exception
            r5 = r2
            goto L55
        L4e:
            r0 = r2
            r5 = r0
            r6 = r5
            goto L5b
        L52:
            r0 = move-exception
            r3 = r2
            r5 = r3
        L55:
            r6 = r5
        L56:
            com.alipay.sdk.util.c.a(r0)
            r0 = r2
        L5a:
            r2 = r3
        L5b:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "TidStorage.load "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r4 = " "
            r3.append(r4)
            r3.append(r5)
            r3.append(r4)
            r3.append(r1)
            r3.append(r4)
            r3.append(r6)
            r3.append(r4)
            r3.append(r0)
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "TidStorage"
            com.alipay.sdk.util.c.b(r4, r3)
            boolean r3 = r9.a(r2, r5, r6, r0)
            if (r3 == 0) goto L95
            r9.m()
            goto La3
        L95:
            r9.f4691j = r2
            r9.f4692k = r5
            long r1 = r1.longValue()
            r9.f4693l = r1
            r9.f4694m = r6
            r9.f4695n = r0
        La3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.tid.b.l():void");
    }

    private void m() {
        this.f4691j = "";
        this.f4692k = f();
        this.f4693l = System.currentTimeMillis();
        this.f4694m = n();
        this.f4695n = n();
        a.b(f4681a, f4682b);
    }

    private String n() {
        return Long.toHexString(System.currentTimeMillis()) + (new Random().nextInt(9000) + 1000);
    }

    private void o() {
    }

    private void p() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("tid", this.f4691j);
            jSONObject.put(f4685e, this.f4692k);
            jSONObject.put("timestamp", this.f4693l);
            jSONObject.put(f4687g, this.f4694m);
            jSONObject.put(f4688h, this.f4695n);
            a.a(f4681a, f4682b, jSONObject.toString(), true);
        } catch (Exception e2) {
            c.a(e2);
        }
    }

    public String c() {
        c.b("TidStorage", "TidStorage.getVirtualImei " + this.f4694m);
        return this.f4694m;
    }

    public String d() {
        c.b("TidStorage", "TidStorage.getVirtualImsi " + this.f4695n);
        return this.f4695n;
    }

    public boolean e() {
        return TextUtils.isEmpty(this.f4691j) || TextUtils.isEmpty(this.f4692k) || TextUtils.isEmpty(this.f4694m) || TextUtils.isEmpty(this.f4695n);
    }

    public String f() {
        String hexString = Long.toHexString(System.currentTimeMillis());
        return hexString.length() > 10 ? hexString.substring(hexString.length() - 10) : hexString;
    }

    public void g() {
        c.b("TidStorage", "TidStorage.delete " + String.format("TidStorage::delete > %s，%s，%s，%s，%s", this.f4691j, this.f4692k, Long.valueOf(this.f4693l), this.f4694m, this.f4695n));
        m();
    }

    public boolean h() {
        return e();
    }

    public Long i() {
        return Long.valueOf(this.f4693l);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class a {
        private static String a() {
            return "!@#23457";
        }

        public static boolean a(String str, String str2) {
            if (b.f4689i == null) {
                return false;
            }
            return b.f4689i.getSharedPreferences(str, 0).contains(str2);
        }

        public static void b(String str, String str2) {
            if (b.f4689i == null) {
                return;
            }
            b.f4689i.getSharedPreferences(str, 0).edit().remove(str2).apply();
        }

        public static String c(String str, String str2) {
            return a(str, str2, true);
        }

        public static boolean d(String str, String str2) {
            if (b.f4689i == null) {
                return false;
            }
            return b.f4689i.getSharedPreferences(str, 0).contains(str2);
        }

        public static String a(String str, String str2, boolean z10) {
            String str3;
            if (b.f4689i == null) {
                return null;
            }
            String string = b.f4689i.getSharedPreferences(str, 0).getString(str2, null);
            if (TextUtils.isEmpty(string) || !z10) {
                str3 = string;
            } else {
                String b4 = b();
                str3 = com.alipay.sdk.encrypt.b.b(string, b4);
                if (TextUtils.isEmpty(str3)) {
                    str3 = com.alipay.sdk.encrypt.b.b(string, a());
                    if (!TextUtils.isEmpty(str3)) {
                        a(str, str2, str3, true);
                    }
                }
                if (TextUtils.isEmpty(str3)) {
                    String.format("LocalPreference::getLocalPreferences failed %s，%s", string, b4);
                    c.b("TidStorage", "TidStorage.save LocalPreference::getLocalPreferences failed");
                }
            }
            c.b("TidStorage", "TidStorage.save LocalPreference::getLocalPreferences value " + string);
            return str3;
        }

        private static String b() {
            String str;
            try {
                str = b.f4689i.getApplicationContext().getPackageName();
            } catch (Throwable th) {
                c.a(th);
                str = "";
            }
            if (TextUtils.isEmpty(str)) {
                str = "unknow";
            }
            return (str + "00000000").substring(0, 8);
        }

        public static void a(String str, String str2, String str3) {
            a(str, str2, str3, true);
        }

        public static void a(String str, String str2, String str3, boolean z10) {
            if (b.f4689i == null) {
                return;
            }
            SharedPreferences sharedPreferences = b.f4689i.getSharedPreferences(str, 0);
            if (z10) {
                String b4 = b();
                String a10 = com.alipay.sdk.encrypt.b.a(str3, b4);
                if (TextUtils.isEmpty(a10)) {
                    String.format("LocalPreference::putLocalPreferences failed %s，%s", str3, b4);
                }
                str3 = a10;
            }
            sharedPreferences.edit().putString(str2, str3).apply();
        }
    }

    public String a() {
        c.b("TidStorage", "TidStorage.getTid " + this.f4691j);
        return this.f4691j;
    }

    public String b() {
        c.b("TidStorage", "TidStorage.getClientKey " + this.f4692k);
        return this.f4692k;
    }

    private boolean a(String str, String str2, String str3, String str4) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4);
    }

    public void a(String str, String str2) {
        c.b("TidStorage", "TidStorage.save " + ("tid=" + str + ",clientKey=" + str2));
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.f4691j = str;
        this.f4692k = str2;
        this.f4693l = System.currentTimeMillis();
        p();
        o();
    }

    private void a(String str, String str2, String str3, String str4, Long l10) {
        if (a(str, str2, str3, str4)) {
            return;
        }
        this.f4691j = str;
        this.f4692k = str2;
        this.f4694m = str3;
        this.f4695n = str4;
        if (l10 == null) {
            this.f4693l = System.currentTimeMillis();
        } else {
            this.f4693l = l10.longValue();
        }
        p();
    }
}
