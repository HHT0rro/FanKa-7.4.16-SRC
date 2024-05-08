package com.yxcorp.kuaishou.addfp.android.a;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class c {

    /* renamed from: d, reason: collision with root package name */
    private static boolean f48571d = true;

    /* renamed from: e, reason: collision with root package name */
    private static int f48572e;

    /* renamed from: a, reason: collision with root package name */
    private String f48573a;

    /* renamed from: b, reason: collision with root package name */
    private String f48574b;

    /* renamed from: c, reason: collision with root package name */
    private ReentrantLock f48575c;

    private c() {
        this.f48574b = "";
        this.f48575c = new ReentrantLock();
    }

    private static String a(String str) {
        return TextUtils.isEmpty(str) ? "KWE_N" : str.replace("=", "").replace("&", "");
    }

    public static void a(JSONObject jSONObject) {
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if ("64".equals(next) && jSONObject.optInt(next, 1) == 0) {
                    f48571d = false;
                }
                if ("64_level".equals(next)) {
                    f48572e = jSONObject.optInt(next, 0);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0032, code lost:
    
        if (r2 != null) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String b() {
        /*
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L35
            java.lang.String r2 = "/sys/class/android_usb/android0/iSerial"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L35
            boolean r2 = r1.exists()     // Catch: java.lang.Throwable -> L35
            if (r2 == 0) goto L31
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L35
            java.io.FileReader r3 = new java.io.FileReader     // Catch: java.lang.Throwable -> L35
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L35
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L35
            java.lang.String r1 = r2.readLine()     // Catch: java.lang.Throwable -> L2f
            boolean r3 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L2f
            if (r3 != 0) goto L32
            java.lang.String r0 = r1.trim()     // Catch: java.lang.Throwable -> L2f
            r2.close()     // Catch: java.lang.Throwable -> L2a
            goto L2e
        L2a:
            r1 = move-exception
            r1.printStackTrace()
        L2e:
            return r0
        L2f:
            r1 = move-exception
            goto L37
        L31:
            r2 = r0
        L32:
            if (r2 == 0) goto L44
            goto L3c
        L35:
            r1 = move-exception
            r2 = r0
        L37:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L45
            if (r2 == 0) goto L44
        L3c:
            r2.close()     // Catch: java.lang.Throwable -> L40
            goto L44
        L40:
            r1 = move-exception
            r1.printStackTrace()
        L44:
            return r0
        L45:
            r0 = move-exception
            if (r2 == 0) goto L50
            r2.close()     // Catch: java.lang.Throwable -> L4c
            goto L50
        L4c:
            r1 = move-exception
            r1.printStackTrace()
        L50:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yxcorp.kuaishou.addfp.android.a.c.b():java.lang.String");
    }

    public static c c() {
        return b.f48570a;
    }

    public String a() {
        try {
            return !TextUtils.isEmpty(this.f48573a) ? this.f48573a : "KWE_N";
        } catch (Throwable th) {
            th.printStackTrace();
            return "KWE_N";
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(72:9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|(3:27|28|29)|30|31|32|33|34|35|36|37|38|39|40|41|42|43|(3:44|45|(1:47))|48|49|50|51|(2:52|53)|54|55|56|57|58|59|(3:60|61|62)|63|64|(2:65|66)|(5:67|68|69|(2:70|71)|72)|73|74|75|76|77|78|79|80|81|(1:121)(3:87|(4:89|90|91|92)(1:120)|93)|94|95|96|97|(4:100|(2:102|103)(1:105)|104|98)|106|107|108|109|(1:111)|112|113) */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x02de, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x02df, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0298 A[Catch: all -> 0x02de, TryCatch #12 {all -> 0x02de, blocks: (B:97:0x028e, B:100:0x0298, B:102:0x02ac, B:104:0x02b7, B:107:0x02ba), top: B:96:0x028e, outer: #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0335  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a(android.content.Context r20, com.yxcorp.kuaishou.addfp.ResponseDfpCallback r21, boolean r22) {
        /*
            Method dump skipped, instructions count: 833
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yxcorp.kuaishou.addfp.android.a.c.a(android.content.Context, com.yxcorp.kuaishou.addfp.ResponseDfpCallback, boolean):java.lang.String");
    }

    public void b(String str) {
        this.f48573a = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0018 A[Catch: all -> 0x00f1, TryCatch #1 {all -> 0x00f1, blocks: (B:2:0x0000, B:13:0x0018, B:16:0x0023, B:19:0x0029, B:23:0x0033, B:25:0x003b, B:27:0x0047, B:30:0x0056, B:34:0x0066, B:36:0x0074, B:39:0x00af, B:49:0x00d1, B:51:0x00db, B:54:0x00e2, B:56:0x00ea, B:75:0x00a2, B:77:0x00a8, B:82:0x009f, B:86:0x0012, B:8:0x0009, B:71:0x0080, B:73:0x0088), top: B:1:0x0000, inners: #0, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0029 A[Catch: all -> 0x00f1, TRY_ENTER, TryCatch #1 {all -> 0x00f1, blocks: (B:2:0x0000, B:13:0x0018, B:16:0x0023, B:19:0x0029, B:23:0x0033, B:25:0x003b, B:27:0x0047, B:30:0x0056, B:34:0x0066, B:36:0x0074, B:39:0x00af, B:49:0x00d1, B:51:0x00db, B:54:0x00e2, B:56:0x00ea, B:75:0x00a2, B:77:0x00a8, B:82:0x009f, B:86:0x0012, B:8:0x0009, B:71:0x0080, B:73:0x0088), top: B:1:0x0000, inners: #0, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0066 A[Catch: all -> 0x00f1, TryCatch #1 {all -> 0x00f1, blocks: (B:2:0x0000, B:13:0x0018, B:16:0x0023, B:19:0x0029, B:23:0x0033, B:25:0x003b, B:27:0x0047, B:30:0x0056, B:34:0x0066, B:36:0x0074, B:39:0x00af, B:49:0x00d1, B:51:0x00db, B:54:0x00e2, B:56:0x00ea, B:75:0x00a2, B:77:0x00a8, B:82:0x009f, B:86:0x0012, B:8:0x0009, B:71:0x0080, B:73:0x0088), top: B:1:0x0000, inners: #0, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00d1 A[Catch: all -> 0x00f1, TRY_ENTER, TryCatch #1 {all -> 0x00f1, blocks: (B:2:0x0000, B:13:0x0018, B:16:0x0023, B:19:0x0029, B:23:0x0033, B:25:0x003b, B:27:0x0047, B:30:0x0056, B:34:0x0066, B:36:0x0074, B:39:0x00af, B:49:0x00d1, B:51:0x00db, B:54:0x00e2, B:56:0x00ea, B:75:0x00a2, B:77:0x00a8, B:82:0x009f, B:86:0x0012, B:8:0x0009, B:71:0x0080, B:73:0x0088), top: B:1:0x0000, inners: #0, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ea A[Catch: all -> 0x00f1, TRY_LEAVE, TryCatch #1 {all -> 0x00f1, blocks: (B:2:0x0000, B:13:0x0018, B:16:0x0023, B:19:0x0029, B:23:0x0033, B:25:0x003b, B:27:0x0047, B:30:0x0056, B:34:0x0066, B:36:0x0074, B:39:0x00af, B:49:0x00d1, B:51:0x00db, B:54:0x00e2, B:56:0x00ea, B:75:0x00a2, B:77:0x00a8, B:82:0x009f, B:86:0x0012, B:8:0x0009, B:71:0x0080, B:73:0x0088), top: B:1:0x0000, inners: #0, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00ce A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r9) {
        /*
            Method dump skipped, instructions count: 248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yxcorp.kuaishou.addfp.android.a.c.a(android.content.Context):java.lang.String");
    }
}
