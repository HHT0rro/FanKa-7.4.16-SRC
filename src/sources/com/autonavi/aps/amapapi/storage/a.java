package com.autonavi.aps.amapapi.storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.amap.api.col.p0003l.fn;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.autonavi.aps.amapapi.restruct.d;
import com.autonavi.aps.amapapi.utils.j;
import com.baidu.mobads.sdk.internal.bk;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

/* compiled from: Cache.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public Hashtable<String, ArrayList<C0112a>> f9522a = new Hashtable<>();

    /* renamed from: i, reason: collision with root package name */
    private long f9530i = 0;

    /* renamed from: j, reason: collision with root package name */
    private boolean f9531j = false;

    /* renamed from: k, reason: collision with root package name */
    private String f9532k = "2.0.201501131131".replace(".", "");

    /* renamed from: l, reason: collision with root package name */
    private String f9533l = null;

    /* renamed from: b, reason: collision with root package name */
    public boolean f9523b = true;

    /* renamed from: c, reason: collision with root package name */
    public long f9524c = 0;

    /* renamed from: d, reason: collision with root package name */
    public String f9525d = null;

    /* renamed from: e, reason: collision with root package name */
    public d f9526e = null;

    /* renamed from: m, reason: collision with root package name */
    private String f9534m = null;

    /* renamed from: n, reason: collision with root package name */
    private long f9535n = 0;

    /* renamed from: f, reason: collision with root package name */
    public boolean f9527f = true;

    /* renamed from: g, reason: collision with root package name */
    public boolean f9528g = true;

    /* renamed from: h, reason: collision with root package name */
    public String f9529h = String.valueOf(AMapLocationClientOption.GeoLanguage.DEFAULT);

    /* compiled from: Cache.java */
    /* renamed from: com.autonavi.aps.amapapi.storage.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class C0112a {

        /* renamed from: a, reason: collision with root package name */
        private com.autonavi.aps.amapapi.model.a f9536a = null;

        /* renamed from: b, reason: collision with root package name */
        private String f9537b = null;

        public final com.autonavi.aps.amapapi.model.a a() {
            return this.f9536a;
        }

        public final String b() {
            return this.f9537b;
        }

        public final void a(com.autonavi.aps.amapapi.model.a aVar) {
            this.f9536a = aVar;
        }

        public final void a(String str) {
            if (TextUtils.isEmpty(str)) {
                this.f9537b = null;
            } else {
                this.f9537b = str.replace("##", "#");
            }
        }
    }

    private boolean b() {
        long b4 = j.b();
        long j10 = this.f9530i;
        long j11 = b4 - j10;
        if (j10 == 0) {
            return false;
        }
        return this.f9522a.size() > 360 || j11 > bk.f9896e;
    }

    private void c() {
        this.f9530i = 0L;
        if (!this.f9522a.isEmpty()) {
            this.f9522a.clear();
        }
        this.f9531j = false;
    }

    public final void a(String str, StringBuilder sb2, com.autonavi.aps.amapapi.model.a aVar, Context context, boolean z10) {
        try {
            if (j.a(aVar)) {
                String str2 = str + "&" + aVar.isOffset() + "&" + aVar.i() + "&" + aVar.j();
                if (!a(str2, aVar) || aVar.e().equals("mem") || aVar.e().equals("file") || aVar.e().equals("wifioff") || "-3".equals(aVar.d())) {
                    return;
                }
                if (b()) {
                    c();
                }
                JSONObject f10 = aVar.f();
                if (j.a(f10, "offpct")) {
                    f10.remove("offpct");
                    aVar.a(f10);
                }
                if (str2.contains("wifi")) {
                    if (TextUtils.isEmpty(sb2)) {
                        return;
                    }
                    if (aVar.getAccuracy() >= 300.0f) {
                        int i10 = 0;
                        for (String str3 : sb2.toString().split("#")) {
                            if (str3.contains(",")) {
                                i10++;
                            }
                        }
                        if (i10 >= 8) {
                            return;
                        }
                    } else if (aVar.getAccuracy() <= 3.0f) {
                        return;
                    }
                    if (str2.contains("cgiwifi") && !TextUtils.isEmpty(aVar.g())) {
                        String replace = str2.replace("cgiwifi", "cgi");
                        com.autonavi.aps.amapapi.model.a h10 = aVar.h();
                        if (j.a(h10)) {
                            a(replace, new StringBuilder(), h10, context, true);
                        }
                    }
                } else if (str2.contains("cgi") && ((sb2 != null && sb2.indexOf(",") != -1) || "4".equals(aVar.d()))) {
                    return;
                }
                com.autonavi.aps.amapapi.model.a a10 = a(str2, sb2, false);
                if (j.a(a10) && a10.toStr().equals(aVar.toStr(3))) {
                    return;
                }
                this.f9530i = j.b();
                C0112a c0112a = new C0112a();
                c0112a.a(aVar);
                c0112a.a(TextUtils.isEmpty(sb2) ? null : sb2.toString());
                if (this.f9522a.containsKey(str2)) {
                    this.f9522a.get(str2).add(c0112a);
                } else {
                    ArrayList<C0112a> arrayList = new ArrayList<>();
                    arrayList.add(c0112a);
                    this.f9522a.put(str2, arrayList);
                }
                if (z10) {
                    try {
                        a(str2, aVar, sb2, context);
                    } catch (Throwable th) {
                        com.autonavi.aps.amapapi.utils.b.a(th, "Cache", "add");
                    }
                }
            }
        } catch (Throwable th2) {
            com.autonavi.aps.amapapi.utils.b.a(th2, "Cache", "add");
        }
    }

    public final void b(Context context) {
        try {
            c();
            c(context);
            this.f9531j = false;
            this.f9525d = null;
            this.f9535n = 0L;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "Cache", "destroy part");
        }
    }

    private void c(Context context) throws Exception {
        boolean isOpen;
        if (context == null) {
            return;
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = context.openOrCreateDatabase("hmdb", 0, null);
            if (!j.a(sQLiteDatabase, "hist")) {
                if (sQLiteDatabase != null) {
                    if (isOpen) {
                        return;
                    } else {
                        return;
                    }
                }
                return;
            }
            try {
                sQLiteDatabase.delete("hist" + this.f9532k, "time<?", new String[]{String.valueOf(j.a() - bk.f9896e)});
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "DB", "clearHist");
                String message = th.getMessage();
                if (!TextUtils.isEmpty(message)) {
                    message.contains("no such table");
                }
            }
            if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                return;
            }
            sQLiteDatabase.close();
        } catch (Throwable th2) {
            try {
                com.autonavi.aps.amapapi.utils.b.a(th2, "DB", "clearHist p2");
                if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                    return;
                }
                sQLiteDatabase.close();
            } finally {
                if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                    sQLiteDatabase.close();
                }
            }
        }
    }

    public final com.autonavi.aps.amapapi.model.a a(Context context, String str, StringBuilder sb2, boolean z10, boolean z11) {
        if (TextUtils.isEmpty(str) || !com.autonavi.aps.amapapi.utils.a.e()) {
            return null;
        }
        String str2 = str + "&" + this.f9527f + "&" + this.f9528g + "&" + this.f9529h;
        if (str2.contains(GeocodeSearch.GPS) || !com.autonavi.aps.amapapi.utils.a.e() || sb2 == null) {
            return null;
        }
        if (b()) {
            c();
            return null;
        }
        if (z10 && !this.f9531j) {
            try {
                String a10 = a(str2, sb2, context);
                c();
                a(context, a10, z11);
            } catch (Throwable unused) {
            }
        }
        if (this.f9522a.isEmpty()) {
            return null;
        }
        return a(str2, sb2, z11);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x008b A[Catch: all -> 0x0094, TryCatch #0 {all -> 0x0094, blocks: (B:3:0x0001, B:5:0x0009, B:8:0x0012, B:10:0x001a, B:12:0x0022, B:14:0x0030, B:16:0x0048, B:18:0x0052, B:20:0x0064, B:23:0x006f, B:25:0x0073, B:27:0x0079, B:28:0x0085, B:30:0x008b, B:31:0x008f, B:36:0x0042), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.autonavi.aps.amapapi.model.a a(java.lang.String r5, java.lang.StringBuilder r6, boolean r7) {
        /*
            r4 = this;
            r0 = 0
            java.lang.String r1 = "cgiwifi"
            boolean r1 = r5.contains(r1)     // Catch: java.lang.Throwable -> L94
            if (r1 != 0) goto L42
            java.lang.String r1 = "wifi"
            boolean r1 = r5.contains(r1)     // Catch: java.lang.Throwable -> L94
            if (r1 == 0) goto L12
            goto L42
        L12:
            java.lang.String r6 = "cgi"
            boolean r6 = r5.contains(r6)     // Catch: java.lang.Throwable -> L94
            if (r6 == 0) goto L40
            java.util.Hashtable<java.lang.String, java.util.ArrayList<com.autonavi.aps.amapapi.storage.a$a>> r6 = r4.f9522a     // Catch: java.lang.Throwable -> L94
            boolean r6 = r6.containsKey(r5)     // Catch: java.lang.Throwable -> L94
            if (r6 == 0) goto L40
            java.util.Hashtable<java.lang.String, java.util.ArrayList<com.autonavi.aps.amapapi.storage.a$a>> r6 = r4.f9522a     // Catch: java.lang.Throwable -> L94
            java.lang.Object r6 = r6.get(r5)     // Catch: java.lang.Throwable -> L94
            java.util.ArrayList r6 = (java.util.ArrayList) r6     // Catch: java.lang.Throwable -> L94
            int r6 = r6.size()     // Catch: java.lang.Throwable -> L94
            if (r6 <= 0) goto L40
            java.util.Hashtable<java.lang.String, java.util.ArrayList<com.autonavi.aps.amapapi.storage.a$a>> r6 = r4.f9522a     // Catch: java.lang.Throwable -> L94
            java.lang.Object r6 = r6.get(r5)     // Catch: java.lang.Throwable -> L94
            java.util.ArrayList r6 = (java.util.ArrayList) r6     // Catch: java.lang.Throwable -> L94
            r1 = 0
            java.lang.Object r6 = r6.get(r1)     // Catch: java.lang.Throwable -> L94
            com.autonavi.aps.amapapi.storage.a$a r6 = (com.autonavi.aps.amapapi.storage.a.C0112a) r6     // Catch: java.lang.Throwable -> L94
            goto L46
        L40:
            r6 = r0
            goto L46
        L42:
            com.autonavi.aps.amapapi.storage.a$a r6 = r4.a(r6, r5)     // Catch: java.lang.Throwable -> L94
        L46:
            if (r6 == 0) goto L9c
            com.autonavi.aps.amapapi.model.a r1 = r6.a()     // Catch: java.lang.Throwable -> L94
            boolean r1 = com.autonavi.aps.amapapi.utils.j.a(r1)     // Catch: java.lang.Throwable -> L94
            if (r1 == 0) goto L9c
            com.autonavi.aps.amapapi.model.a r1 = r6.a()     // Catch: java.lang.Throwable -> L94
            java.lang.String r2 = "mem"
            r1.e(r2)     // Catch: java.lang.Throwable -> L94
            java.lang.String r2 = r6.b()     // Catch: java.lang.Throwable -> L94
            r1.h(r2)     // Catch: java.lang.Throwable -> L94
            if (r7 != 0) goto L85
            long r2 = r1.getTime()     // Catch: java.lang.Throwable -> L94
            boolean r7 = com.autonavi.aps.amapapi.utils.a.a(r2)     // Catch: java.lang.Throwable -> L94
            if (r7 == 0) goto L6f
            goto L85
        L6f:
            java.util.Hashtable<java.lang.String, java.util.ArrayList<com.autonavi.aps.amapapi.storage.a$a>> r7 = r4.f9522a     // Catch: java.lang.Throwable -> L94
            if (r7 == 0) goto L9c
            boolean r7 = r7.containsKey(r5)     // Catch: java.lang.Throwable -> L94
            if (r7 == 0) goto L9c
            java.util.Hashtable<java.lang.String, java.util.ArrayList<com.autonavi.aps.amapapi.storage.a$a>> r7 = r4.f9522a     // Catch: java.lang.Throwable -> L94
            java.lang.Object r5 = r7.get(r5)     // Catch: java.lang.Throwable -> L94
            java.util.ArrayList r5 = (java.util.ArrayList) r5     // Catch: java.lang.Throwable -> L94
            r5.remove(r6)     // Catch: java.lang.Throwable -> L94
            goto L9c
        L85:
            boolean r5 = com.autonavi.aps.amapapi.utils.j.a(r1)     // Catch: java.lang.Throwable -> L94
            if (r5 == 0) goto L8f
            r5 = 0
            r4.f9524c = r5     // Catch: java.lang.Throwable -> L94
        L8f:
            r5 = 4
            r1.setLocationType(r5)     // Catch: java.lang.Throwable -> L94
            return r1
        L94:
            r5 = move-exception
            java.lang.String r6 = "Cache"
            java.lang.String r7 = "get1"
            com.autonavi.aps.amapapi.utils.b.a(r5, r6, r7)
        L9c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.storage.a.a(java.lang.String, java.lang.StringBuilder, boolean):com.autonavi.aps.amapapi.model.a");
    }

    private static boolean a(String str, com.autonavi.aps.amapapi.model.a aVar) {
        if (TextUtils.isEmpty(str) || !j.a(aVar) || str.startsWith("#")) {
            return false;
        }
        return str.contains("network");
    }

    private C0112a a(StringBuilder sb2, String str) {
        C0112a c0112a;
        boolean z10;
        C0112a c0112a2;
        if (this.f9522a.isEmpty() || TextUtils.isEmpty(sb2)) {
            return null;
        }
        if (!this.f9522a.containsKey(str)) {
            return null;
        }
        Hashtable hashtable = new Hashtable();
        Hashtable hashtable2 = new Hashtable();
        Hashtable hashtable3 = new Hashtable();
        ArrayList<C0112a> arrayList = this.f9522a.get(str);
        char c4 = 1;
        int size = arrayList.size() - 1;
        while (size >= 0) {
            C0112a c0112a3 = arrayList.get(size);
            if (!TextUtils.isEmpty(c0112a3.b())) {
                if (!a(c0112a3.b(), sb2)) {
                    z10 = false;
                } else {
                    if (j.a(c0112a3.b(), sb2.toString())) {
                        c0112a2 = c0112a3;
                        c0112a = c0112a2;
                        break;
                    }
                    z10 = true;
                }
                a(c0112a3.b(), (Hashtable<String, String>) hashtable);
                a(sb2.toString(), (Hashtable<String, String>) hashtable2);
                hashtable3.clear();
                Iterator iterator2 = hashtable.h().iterator2();
                while (iterator2.hasNext()) {
                    hashtable3.put((String) iterator2.next(), "");
                }
                Iterator iterator22 = hashtable2.h().iterator2();
                while (iterator22.hasNext()) {
                    hashtable3.put((String) iterator22.next(), "");
                }
                Set h10 = hashtable3.h();
                double[] dArr = new double[h10.size()];
                double[] dArr2 = new double[h10.size()];
                Iterator iterator23 = h10.iterator2();
                int i10 = 0;
                while (iterator23 != null && iterator23.hasNext()) {
                    String str2 = (String) iterator23.next();
                    double d10 = 1.0d;
                    dArr[i10] = hashtable.containsKey(str2) ? 1.0d : 0.0d;
                    if (!hashtable2.containsKey(str2)) {
                        d10 = 0.0d;
                    }
                    dArr2[i10] = d10;
                    i10++;
                }
                h10.clear();
                double[] a10 = a(dArr, dArr2);
                if (a10[0] < 0.800000011920929d) {
                    c0112a2 = c0112a3;
                    if (a10[c4] < Math.min(com.autonavi.aps.amapapi.utils.a.g(), 0.618d)) {
                        if (z10 && a10[0] >= Math.min(com.autonavi.aps.amapapi.utils.a.g(), 0.618d)) {
                        }
                    }
                    c0112a = c0112a2;
                    break;
                }
                c0112a2 = c0112a3;
                c0112a = c0112a2;
                break;
            }
            size--;
            c4 = 1;
        }
        c0112a = null;
        hashtable.clear();
        hashtable2.clear();
        hashtable3.clear();
        return c0112a;
    }

    private static boolean a(String str, StringBuilder sb2) {
        String str2;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(sb2) || !str.contains(",access") || sb2.indexOf(",access") == -1) {
            return false;
        }
        String[] split = str.split(",access");
        if (split[0].contains("#")) {
            str2 = split[0].substring(split[0].lastIndexOf("#") + 1);
        } else {
            str2 = split[0];
        }
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        return sb2.toString().contains(str2 + ",access");
    }

    private static void a(String str, Hashtable<String, String> hashtable) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        hashtable.clear();
        for (String str2 : str.split("#")) {
            if (!TextUtils.isEmpty(str2) && !str2.contains("|")) {
                hashtable.put(str2, "");
            }
        }
    }

    private static double[] a(double[] dArr, double[] dArr2) {
        double[] dArr3 = new double[3];
        double d10 = ShadowDrawableWrapper.COS_45;
        double d11 = 0.0d;
        double d12 = 0.0d;
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < dArr.length; i12++) {
            d11 += dArr[i12] * dArr[i12];
            d12 += dArr2[i12] * dArr2[i12];
            d10 += dArr[i12] * dArr2[i12];
            if (dArr2[i12] == 1.0d) {
                i11++;
                if (dArr[i12] == 1.0d) {
                    i10++;
                }
            }
        }
        dArr3[0] = d10 / (Math.sqrt(d11) * Math.sqrt(d12));
        double d13 = i10;
        dArr3[1] = (d13 * 1.0d) / i11;
        dArr3[2] = d13;
        for (int i13 = 0; i13 < 2; i13++) {
            if (dArr3[i13] > 1.0d) {
                dArr3[i13] = 1.0d;
            }
        }
        return dArr3;
    }

    public final void a(Context context) {
        if (this.f9531j) {
            return;
        }
        try {
            c();
            a(context, (String) null, false);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "Cache", "loadDB");
        }
        this.f9531j = true;
    }

    private String a(String str, StringBuilder sb2, Context context) {
        String str2;
        if (context == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            this.f9533l = j.l(context);
            if (str.contains("&")) {
                str = str.substring(0, str.indexOf("&"));
            }
            String substring = str.substring(str.lastIndexOf("#") + 1);
            if (substring.equals("cgi")) {
                jSONObject.put("cgi", str.substring(0, str.length() - 12));
            } else if (!TextUtils.isEmpty(sb2) && sb2.indexOf(",access") != -1) {
                jSONObject.put("cgi", str.substring(0, str.length() - (substring.length() + 9)));
                String[] split = sb2.toString().split(",access");
                if (split[0].contains("#")) {
                    str2 = split[0].substring(split[0].lastIndexOf("#") + 1);
                } else {
                    str2 = split[0];
                }
                jSONObject.put("mmac", str2);
            }
            return fn.b(com.autonavi.aps.amapapi.security.a.a(jSONObject.toString().getBytes("UTF-8"), this.f9533l));
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Finally extract failed */
    private void a(String str, AMapLocation aMapLocation, StringBuilder sb2, Context context) throws Exception {
        if (context == null) {
            return;
        }
        if (this.f9533l == null) {
            this.f9533l = j.l(context);
        }
        String a10 = a(str, sb2, context);
        StringBuilder sb3 = new StringBuilder();
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = context.openOrCreateDatabase("hmdb", 0, null);
            sb3.append("CREATE TABLE IF NOT EXISTS hist");
            sb3.append(this.f9532k);
            sb3.append(" (feature VARCHAR PRIMARY KEY, nb VARCHAR, loc VARCHAR, time VARCHAR);");
            sQLiteDatabase.execSQL(sb3.toString());
            sb3.delete(0, sb3.length());
            sb3.append("REPLACE INTO ");
            sb3.append("hist");
            sb3.append(this.f9532k);
            sb3.append(" VALUES (?, ?, ?, ?)");
            Object[] objArr = new Object[4];
            objArr[0] = a10;
            byte[] a11 = com.autonavi.aps.amapapi.security.a.a(sb2.toString().getBytes("UTF-8"), this.f9533l);
            objArr[1] = a11;
            objArr[2] = com.autonavi.aps.amapapi.security.a.a(aMapLocation.toStr().getBytes("UTF-8"), this.f9533l);
            objArr[3] = Long.valueOf(aMapLocation.getTime());
            for (int i10 = 1; i10 < 3; i10++) {
                objArr[i10] = fn.b((byte[]) objArr[i10]);
            }
            sQLiteDatabase.execSQL(sb3.toString(), objArr);
            sb3.delete(0, sb3.length());
            sb3.delete(0, sb3.length());
            if (sQLiteDatabase.isOpen()) {
                sQLiteDatabase.close();
            }
        } catch (Throwable th) {
            try {
                com.autonavi.aps.amapapi.utils.b.a(th, "DB", "updateHist");
                sb3.delete(0, sb3.length());
                if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                    return;
                }
                sQLiteDatabase.close();
            } catch (Throwable th2) {
                sb3.delete(0, sb3.length());
                if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                    sQLiteDatabase.close();
                }
                throw th2;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x027b A[LOOP:0: B:34:0x00d1->B:56:0x027b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x026b A[EDGE_INSN: B:57:0x026b->B:58:0x026b BREAK  A[LOOP:0: B:34:0x00d1->B:56:0x027b], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02a5 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x02aa A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:79:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(android.content.Context r20, java.lang.String r21, boolean r22) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 710
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.storage.a.a(android.content.Context, java.lang.String, boolean):void");
    }

    public final void a(AMapLocationClientOption aMapLocationClientOption) {
        this.f9528g = aMapLocationClientOption.isNeedAddress();
        this.f9527f = aMapLocationClientOption.isOffset();
        this.f9523b = aMapLocationClientOption.isLocationCacheEnable();
        this.f9529h = String.valueOf(aMapLocationClientOption.getGeoLanguage());
    }

    public final void a(d dVar) {
        this.f9526e = dVar;
    }

    private boolean a(com.autonavi.aps.amapapi.model.a aVar, boolean z10) {
        if (a(z10)) {
            return aVar == null || com.autonavi.aps.amapapi.utils.a.a(aVar.getTime()) || z10;
        }
        return false;
    }

    private boolean a(boolean z10) {
        if (com.autonavi.aps.amapapi.utils.a.e() || z10) {
            return this.f9523b || com.autonavi.aps.amapapi.utils.a.f() || z10;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0029 A[Catch: all -> 0x00f0, TryCatch #0 {all -> 0x00f0, blocks: (B:6:0x000f, B:8:0x0015, B:12:0x0029, B:20:0x004b, B:24:0x0053, B:26:0x0061, B:32:0x0086, B:33:0x008f, B:35:0x0093, B:37:0x0099, B:39:0x00a4, B:42:0x00c9, B:44:0x00d8, B:52:0x00e9, B:57:0x00a8, B:59:0x00b1, B:61:0x00b5, B:62:0x00be, B:63:0x008d, B:64:0x0073, B:66:0x0079, B:72:0x0019, B:74:0x001d), top: B:5:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0086 A[Catch: all -> 0x00f0, TryCatch #0 {all -> 0x00f0, blocks: (B:6:0x000f, B:8:0x0015, B:12:0x0029, B:20:0x004b, B:24:0x0053, B:26:0x0061, B:32:0x0086, B:33:0x008f, B:35:0x0093, B:37:0x0099, B:39:0x00a4, B:42:0x00c9, B:44:0x00d8, B:52:0x00e9, B:57:0x00a8, B:59:0x00b1, B:61:0x00b5, B:62:0x00be, B:63:0x008d, B:64:0x0073, B:66:0x0079, B:72:0x0019, B:74:0x001d), top: B:5:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d8 A[Catch: all -> 0x00f0, TryCatch #0 {all -> 0x00f0, blocks: (B:6:0x000f, B:8:0x0015, B:12:0x0029, B:20:0x004b, B:24:0x0053, B:26:0x0061, B:32:0x0086, B:33:0x008f, B:35:0x0093, B:37:0x0099, B:39:0x00a4, B:42:0x00c9, B:44:0x00d8, B:52:0x00e9, B:57:0x00a8, B:59:0x00b1, B:61:0x00b5, B:62:0x00be, B:63:0x008d, B:64:0x0073, B:66:0x0079, B:72:0x0019, B:74:0x001d), top: B:5:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00e3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b5 A[Catch: all -> 0x00f0, TryCatch #0 {all -> 0x00f0, blocks: (B:6:0x000f, B:8:0x0015, B:12:0x0029, B:20:0x004b, B:24:0x0053, B:26:0x0061, B:32:0x0086, B:33:0x008f, B:35:0x0093, B:37:0x0099, B:39:0x00a4, B:42:0x00c9, B:44:0x00d8, B:52:0x00e9, B:57:0x00a8, B:59:0x00b1, B:61:0x00b5, B:62:0x00be, B:63:0x008d, B:64:0x0073, B:66:0x0079, B:72:0x0019, B:74:0x001d), top: B:5:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00be A[Catch: all -> 0x00f0, TryCatch #0 {all -> 0x00f0, blocks: (B:6:0x000f, B:8:0x0015, B:12:0x0029, B:20:0x004b, B:24:0x0053, B:26:0x0061, B:32:0x0086, B:33:0x008f, B:35:0x0093, B:37:0x0099, B:39:0x00a4, B:42:0x00c9, B:44:0x00d8, B:52:0x00e9, B:57:0x00a8, B:59:0x00b1, B:61:0x00b5, B:62:0x00be, B:63:0x008d, B:64:0x0073, B:66:0x0079, B:72:0x0019, B:74:0x001d), top: B:5:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x008d A[Catch: all -> 0x00f0, TryCatch #0 {all -> 0x00f0, blocks: (B:6:0x000f, B:8:0x0015, B:12:0x0029, B:20:0x004b, B:24:0x0053, B:26:0x0061, B:32:0x0086, B:33:0x008f, B:35:0x0093, B:37:0x0099, B:39:0x00a4, B:42:0x00c9, B:44:0x00d8, B:52:0x00e9, B:57:0x00a8, B:59:0x00b1, B:61:0x00b5, B:62:0x00be, B:63:0x008d, B:64:0x0073, B:66:0x0079, B:72:0x0019, B:74:0x001d), top: B:5:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.autonavi.aps.amapapi.model.a a(com.autonavi.aps.amapapi.restruct.e r16, boolean r17, com.autonavi.aps.amapapi.model.a r18, com.autonavi.aps.amapapi.restruct.k r19, java.lang.StringBuilder r20, java.lang.String r21, android.content.Context r22, boolean r23) {
        /*
            Method dump skipped, instructions count: 241
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.storage.a.a(com.autonavi.aps.amapapi.restruct.e, boolean, com.autonavi.aps.amapapi.model.a, com.autonavi.aps.amapapi.restruct.k, java.lang.StringBuilder, java.lang.String, android.content.Context, boolean):com.autonavi.aps.amapapi.model.a");
    }

    public final void a(String str) {
        this.f9525d = str;
    }

    public final void a() {
        this.f9524c = 0L;
        this.f9525d = null;
    }
}
