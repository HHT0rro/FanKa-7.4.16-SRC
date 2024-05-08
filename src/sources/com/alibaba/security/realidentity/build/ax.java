package com.alibaba.security.realidentity.build;

import android.text.TextUtils;
import com.alibaba.security.common.log.RPLogging;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.common.utils.CommonUtils;
import com.alibaba.security.realidentity.build.j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: JavaScriptDispatcher.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ax {

    /* renamed from: a, reason: collision with root package name */
    private static final String f3137a = "ax";

    /* renamed from: b, reason: collision with root package name */
    private static final List<a> f3138b = new ArrayList();

    /* compiled from: JavaScriptDispatcher.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f3139a;

        /* renamed from: b, reason: collision with root package name */
        public Class<? extends aq> f3140b;

        public a(String str, Class<? extends aq> cls) {
            this.f3139a = str;
            this.f3140b = cls;
        }

        private boolean a(String str) {
            String str2 = this.f3139a;
            if (str2 == null) {
                return false;
            }
            return TextUtils.equals(str, this.f3139a) || Arrays.asList(str2.split(",")).contains(str);
        }
    }

    public static void a() {
        f3138b.clear();
    }

    public static void a(Class<? extends aq>[] clsArr) {
        String name;
        if (clsArr == null) {
            return;
        }
        for (Class<? extends aq> cls : clsArr) {
            aw awVar = (aw) cls.getAnnotation(aw.class);
            if (awVar != null) {
                name = awVar.a();
            } else {
                name = cls.getName();
            }
            f3138b.add(new a(name, cls));
        }
    }

    private static void a(String str, String str2, Throwable th) {
        RPLogging.e(f3137a, th.getMessage(), th);
        j.a.f3944a.collectLog(TrackLog.createSdkExceptionLog(str, str2, CommonUtils.getStackTrace(th)));
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0033 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[LOOP:0: B:2:0x0006->B:17:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.Class<? extends com.alibaba.security.realidentity.build.aq> a(java.lang.String r4) {
        /*
            java.util.List<com.alibaba.security.realidentity.build.ax$a> r0 = com.alibaba.security.realidentity.build.ax.f3138b
            java.util.Iterator r0 = r0.iterator2()
        L6:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L36
            java.lang.Object r1 = r0.next()
            com.alibaba.security.realidentity.build.ax$a r1 = (com.alibaba.security.realidentity.build.ax.a) r1
            java.lang.String r2 = r1.f3139a
            if (r2 == 0) goto L30
            java.lang.String r3 = ","
            java.lang.String[] r2 = r2.split(r3)
            java.lang.String r3 = r1.f3139a
            boolean r3 = android.text.TextUtils.equals(r4, r3)
            if (r3 != 0) goto L2e
            java.util.List r2 = java.util.Arrays.asList(r2)
            boolean r2 = r2.contains(r4)
            if (r2 == 0) goto L30
        L2e:
            r2 = 1
            goto L31
        L30:
            r2 = 0
        L31:
            if (r2 == 0) goto L6
            java.lang.Class<? extends com.alibaba.security.realidentity.build.aq> r4 = r1.f3140b
            return r4
        L36:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.realidentity.build.ax.a(java.lang.String):java.lang.Class");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0035 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[LOOP:0: B:2:0x0006->B:24:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(android.content.Context r6, java.lang.String r7, java.lang.String r8, com.alibaba.security.realidentity.build.ay r9) {
        /*
            java.util.List<com.alibaba.security.realidentity.build.ax$a> r0 = com.alibaba.security.realidentity.build.ax.f3138b
            java.util.Iterator r0 = r0.iterator2()
        L6:
            boolean r1 = r0.hasNext()
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L38
            java.lang.Object r1 = r0.next()
            com.alibaba.security.realidentity.build.ax$a r1 = (com.alibaba.security.realidentity.build.ax.a) r1
            java.lang.String r4 = r1.f3139a
            if (r4 == 0) goto L32
            java.lang.String r5 = ","
            java.lang.String[] r4 = r4.split(r5)
            java.lang.String r5 = r1.f3139a
            boolean r5 = android.text.TextUtils.equals(r7, r5)
            if (r5 != 0) goto L30
            java.util.List r4 = java.util.Arrays.asList(r4)
            boolean r4 = r4.contains(r7)
            if (r4 == 0) goto L32
        L30:
            r4 = 1
            goto L33
        L32:
            r4 = 0
        L33:
            if (r4 == 0) goto L6
            java.lang.Class<? extends com.alibaba.security.realidentity.build.aq> r0 = r1.f3140b
            goto L39
        L38:
            r0 = 0
        L39:
            if (r0 == 0) goto L5e
            java.lang.Object r0 = r0.newInstance()     // Catch: java.lang.Throwable -> L45
            com.alibaba.security.realidentity.build.aq r0 = (com.alibaba.security.realidentity.build.aq) r0     // Catch: java.lang.Throwable -> L45
            r0.a(r6, r8, r9)     // Catch: java.lang.Throwable -> L45
            return r2
        L45:
            r6 = move-exception
            java.lang.String r9 = com.alibaba.security.realidentity.build.ax.f3137a
            java.lang.String r0 = r6.getMessage()
            com.alibaba.security.common.log.RPLogging.e(r9, r0, r6)
            java.lang.String r6 = com.alibaba.security.common.utils.CommonUtils.getStackTrace(r6)
            com.alibaba.security.realidentity.build.j r9 = com.alibaba.security.realidentity.build.j.a.a()
            com.alibaba.security.common.track.model.TrackLog r6 = com.alibaba.security.common.track.model.TrackLog.createSdkExceptionLog(r7, r8, r6)
            r9.collectLog(r6)
        L5e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.realidentity.build.ax.a(android.content.Context, java.lang.String, java.lang.String, com.alibaba.security.realidentity.build.ay):boolean");
    }
}
