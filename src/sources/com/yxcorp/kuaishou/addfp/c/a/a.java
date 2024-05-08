package com.yxcorp.kuaishou.addfp.c.a;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.yxcorp.kuaishou.addfp.KWEGIDDFP;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class a {
    /* JADX WARN: Code restructure failed: missing block: B:31:0x015e, code lost:
    
        if (r1 == null) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0160, code lost:
    
        r11 = r0;
        r10 = r1;
        r1 = r12;
        r12 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0139, code lost:
    
        if (r1 == null) goto L105;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0152 A[Catch: IOException -> 0x014e, TryCatch #9 {IOException -> 0x014e, blocks: (B:38:0x014a, B:24:0x0152, B:26:0x0157), top: B:37:0x014a }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0157 A[Catch: IOException -> 0x014e, TRY_LEAVE, TryCatch #9 {IOException -> 0x014e, blocks: (B:38:0x014a, B:24:0x0152, B:26:0x0157), top: B:37:0x014a }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x014a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x012d A[Catch: IOException -> 0x0129, TryCatch #11 {IOException -> 0x0129, blocks: (B:54:0x0125, B:45:0x012d, B:47:0x0132), top: B:53:0x0125 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0132 A[Catch: IOException -> 0x0129, TRY_LEAVE, TryCatch #11 {IOException -> 0x0129, blocks: (B:54:0x0125, B:45:0x012d, B:47:0x0132), top: B:53:0x0125 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0125 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x017f A[Catch: IOException -> 0x017b, TryCatch #20 {IOException -> 0x017b, blocks: (B:72:0x0177, B:60:0x017f, B:62:0x0184), top: B:71:0x0177 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0184 A[Catch: IOException -> 0x017b, TRY_LEAVE, TryCatch #20 {IOException -> 0x017b, blocks: (B:72:0x0177, B:60:0x017f, B:62:0x0184), top: B:71:0x0177 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0177 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v17 */
    /* JADX WARN: Type inference failed for: r12v18, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v20 */
    /* JADX WARN: Type inference failed for: r12v21 */
    /* JADX WARN: Type inference failed for: r12v23 */
    /* JADX WARN: Type inference failed for: r12v26, types: [java.lang.Process] */
    /* JADX WARN: Type inference failed for: r12v34 */
    /* JADX WARN: Type inference failed for: r12v37 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r1v28, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v41 */
    /* JADX WARN: Type inference failed for: r1v42 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.yxcorp.kuaishou.addfp.android.b.e a(java.lang.String r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 401
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yxcorp.kuaishou.addfp.c.a.a.a(java.lang.String, boolean):com.yxcorp.kuaishou.addfp.android.b.e");
    }

    public static String a(int i10, String str) {
        String a10;
        Context paramContext = KWEGIDDFP.instance().getParamContext();
        if (paramContext == null) {
            return "";
        }
        String[] split = new String(Base64.decode("U3lzdGVtQFNlY3VyZUBHbG9iYWw=", 0)).split("@");
        String str2 = split[0];
        String str3 = split[1];
        String str4 = split[2];
        if (i10 == 0) {
            a10 = com.yxcorp.kuaishou.addfp.android.b.a.a(paramContext, split[0], str);
            if (TextUtils.isEmpty(a10)) {
                a10 = Settings.System.getString(paramContext.getContentResolver(), str);
            }
        } else if (i10 == 1) {
            a10 = com.yxcorp.kuaishou.addfp.android.b.a.a(paramContext, split[1], str);
            if (TextUtils.isEmpty(a10)) {
                a10 = Settings.Secure.getString(paramContext.getContentResolver(), str);
            }
        } else if (i10 == 2) {
            a10 = com.yxcorp.kuaishou.addfp.android.b.a.a(paramContext, split[2], str);
            if (TextUtils.isEmpty(a10)) {
                a10 = Settings.Global.getString(paramContext.getContentResolver(), str);
            }
        } else {
            a10 = "";
        }
        return a10 == null ? "" : a10;
    }

    public static String a(Context context, String str) {
        try {
            return Settings.System.getString(context.getContentResolver(), str);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String a(String str, String str2) {
        String str3;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str3 = (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(cls, str, str2);
        } catch (Exception unused) {
            str3 = null;
        }
        return str3 == null ? "" : str3;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008e A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a() {
        /*
            Method dump skipped, instructions count: 253
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yxcorp.kuaishou.addfp.c.a.a.a():java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00ab A[Catch: all -> 0x0099, TRY_LEAVE, TryCatch #2 {all -> 0x0099, blocks: (B:31:0x00a3, B:35:0x00ab), top: B:30:0x00a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c1 A[Catch: all -> 0x00c8, TRY_LEAVE, TryCatch #1 {all -> 0x00c8, blocks: (B:3:0x0004, B:6:0x0016, B:8:0x0020, B:11:0x0055, B:13:0x005b, B:18:0x0062, B:20:0x006c, B:23:0x007c, B:25:0x0082, B:26:0x0099, B:41:0x00bb, B:43:0x00c1, B:49:0x0072, B:55:0x0039, B:57:0x0043, B:59:0x0051), top: B:2:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r8) {
        /*
            java.lang.String r0 = "k_w_o_d_out_dtt"
            java.lang.String r1 = "KWE_N"
            java.lang.String r2 = a(r8, r0)     // Catch: java.lang.Throwable -> Lc8
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> Lc8
            java.lang.String r4 = "Lm91a2R0ZnQ="
            java.lang.String r5 = "android.permission.WRITE_EXTERNAL_STORAGE"
            java.lang.String r6 = "android.permission.READ_EXTERNAL_STORAGE"
            java.lang.String r7 = ""
            if (r3 == 0) goto L39
            java.lang.String[] r3 = new java.lang.String[]{r6, r5}     // Catch: java.lang.Throwable -> Lc8
            boolean r3 = com.yxcorp.kuaishou.addfp.android.b.g.a(r8, r3)     // Catch: java.lang.Throwable -> Lc8
            if (r3 == 0) goto L36
            com.yxcorp.kuaishou.addfp.android.a.d r3 = com.yxcorp.kuaishou.addfp.android.a.d.a(r8)     // Catch: java.lang.Throwable -> Lc8
            java.lang.String r7 = r3.a(r4)     // Catch: java.lang.Throwable -> Lc8
            boolean r3 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Throwable -> Lc8
            if (r3 != 0) goto L54
            android.content.ContentResolver r3 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L54
            android.provider.Settings.System.putString(r3, r0, r7)     // Catch: java.lang.Throwable -> L54
            goto L54
        L36:
            java.lang.String r0 = "KWE_PN"
            goto L55
        L39:
            java.lang.String[] r0 = new java.lang.String[]{r6, r5}     // Catch: java.lang.Throwable -> Lc8
            boolean r0 = com.yxcorp.kuaishou.addfp.android.b.g.a(r8, r0)     // Catch: java.lang.Throwable -> Lc8
            if (r0 == 0) goto L54
            com.yxcorp.kuaishou.addfp.android.a.d r0 = com.yxcorp.kuaishou.addfp.android.a.d.a(r8)     // Catch: java.lang.Throwable -> Lc8
            java.lang.String r7 = r0.a(r4)     // Catch: java.lang.Throwable -> Lc8
            boolean r0 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Throwable -> Lc8
            if (r0 == 0) goto L54
            com.yxcorp.kuaishou.addfp.android.a.d.a(r8, r2)     // Catch: java.lang.Throwable -> Lc8
        L54:
            r0 = r1
        L55:
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> Lc8
            if (r3 == 0) goto L62
            boolean r3 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Throwable -> Lc8
            if (r3 == 0) goto L62
            goto Lce
        L62:
            com.yxcorp.kuaishou.addfp.android.a.d r1 = com.yxcorp.kuaishou.addfp.android.a.d.a(r8)     // Catch: java.lang.Throwable -> Lc8
            java.util.LinkedHashMap r1 = r1.b(r2)     // Catch: java.lang.Throwable -> Lc8
            if (r1 == 0) goto L72
            int r2 = r1.size()     // Catch: java.lang.Throwable -> Lc8
            if (r2 != 0) goto L7a
        L72:
            com.yxcorp.kuaishou.addfp.android.a.d r8 = com.yxcorp.kuaishou.addfp.android.a.d.a(r8)     // Catch: java.lang.Throwable -> Lc8
            java.util.LinkedHashMap r1 = r8.b(r7)     // Catch: java.lang.Throwable -> Lc8
        L7a:
            if (r1 == 0) goto Lc6
            int r8 = r1.size()     // Catch: java.lang.Throwable -> Lc8
            if (r8 <= 0) goto Lc6
            r8 = 0
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Lc8
            java.util.Set r3 = r1.entrySet()     // Catch: java.lang.Throwable -> Lc8
            r2.<init>(r3)     // Catch: java.lang.Throwable -> Lc8
            int r1 = r1.size()     // Catch: java.lang.Throwable -> Lc8
            java.util.ListIterator r1 = r2.listIterator(r1)     // Catch: java.lang.Throwable -> Lc8
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: java.lang.Throwable -> Lc8
            r2.<init>()     // Catch: java.lang.Throwable -> Lc8
        L99:
            boolean r3 = r1.hasPrevious()     // Catch: java.lang.Throwable -> Lc8
            if (r3 == 0) goto Lbb
            r3 = 10
            if (r8 >= r3) goto Lbb
            java.lang.Object r3 = r1.previous()     // Catch: java.lang.Throwable -> L99
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch: java.lang.Throwable -> L99
            if (r3 == 0) goto Lb8
            java.lang.Object r4 = r3.getKey()     // Catch: java.lang.Throwable -> L99
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> L99
            java.lang.Object r3 = r3.getValue()     // Catch: java.lang.Throwable -> L99
            r2.put(r4, r3)     // Catch: java.lang.Throwable -> L99
        Lb8:
            int r8 = r8 + 1
            goto L99
        Lbb:
            int r8 = r2.length()     // Catch: java.lang.Throwable -> Lc8
            if (r8 <= 0) goto Lc6
            java.lang.String r8 = r2.toString()     // Catch: java.lang.Throwable -> Lc8
            return r8
        Lc6:
            r1 = r0
            goto Lce
        Lc8:
            r8 = move-exception
            r8.printStackTrace()
            java.lang.String r1 = "KWE_PE"
        Lce:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yxcorp.kuaishou.addfp.c.a.a.a(android.content.Context):java.lang.String");
    }
}
