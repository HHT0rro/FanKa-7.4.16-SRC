package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class dg {

    /* renamed from: a, reason: collision with root package name */
    public static final String f10154a = "error_message";

    /* renamed from: b, reason: collision with root package name */
    public static final String f10155b = "error_code";

    /* renamed from: d, reason: collision with root package name */
    private static volatile dg f10156d;

    /* renamed from: c, reason: collision with root package name */
    public final bs f10157c = bs.a();

    private dg() {
    }

    public static dg a() {
        if (f10156d == null) {
            synchronized (dg.class) {
                if (f10156d == null) {
                    f10156d = new dg();
                }
            }
        }
        return f10156d;
    }

    public String a(bo boVar, String str) {
        if (boVar == null) {
            return "";
        }
        return a(boVar.b() + "", boVar.c(), str);
    }

    public String a(String str, String str2, String str3) {
        StringBuilder sb2 = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb2.append("ErrorCode: [");
            sb2.append(str);
            sb2.append("];");
        }
        if (!TextUtils.isEmpty(str2)) {
            sb2.append("ErrorDesc: [");
            sb2.append(str2);
            sb2.append("];");
        }
        if (!TextUtils.isEmpty(str3)) {
            sb2.append(" Extra: [");
            sb2.append(str3);
            sb2.append("];");
        }
        return sb2.toString();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:9:0x0026
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1166)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:1022)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:55)
        */
    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a(java.util.Map<java.lang.String, java.lang.Object> r5) {
        /*
            r4 = this;
            java.lang.String r0 = "error_message"
            java.lang.String r1 = "msg"
            java.lang.String r2 = ""
            if (r5 == 0) goto L26
            boolean r3 = r5.containsKey(r1)     // Catch: java.lang.Exception -> L26
            if (r3 == 0) goto L19
            java.lang.Object r5 = r5.get(r1)     // Catch: java.lang.Exception -> L26
            com.baidu.mobads.sdk.internal.bo r5 = (com.baidu.mobads.sdk.internal.bo) r5     // Catch: java.lang.Exception -> L26
            java.lang.String r5 = r4.a(r5, r2)     // Catch: java.lang.Exception -> L26
            goto L27
        L19:
            boolean r1 = r5.containsKey(r0)     // Catch: java.lang.Exception -> L26
            if (r1 == 0) goto L26
            java.lang.Object r5 = r5.get(r0)     // Catch: java.lang.Exception -> L26
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Exception -> L26
            goto L27
        L26:
            r5 = r2
        L27:
            if (r5 != 0) goto L2a
            goto L2b
        L2a:
            r2 = r5
        L2b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.dg.a(java.util.Map):java.lang.String");
    }
}
