package com.alibaba.wireless.security.framework;

import android.content.pm.PackageInfo;
import com.alibaba.wireless.security.framework.utils.C0050;
import java.io.File;
import org.json.JSONObject;

/* renamed from: com.alibaba.wireless.security.framework.а, reason: contains not printable characters */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class C0056 {

    /* renamed from: б, reason: contains not printable characters */
    private String f70;

    /* renamed from: в, reason: contains not printable characters */
    public PackageInfo f71 = null;

    /* renamed from: а, reason: contains not printable characters */
    private JSONObject f69 = null;

    public C0056(String str) {
        this.f70 = str;
    }

    /* renamed from: а, reason: contains not printable characters */
    public String m1853(String str) {
        try {
            JSONObject m1854 = m1854();
            return m1854 != null ? m1854.getString(str) : "";
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: а, reason: contains not printable characters */
    public JSONObject m1854() {
        JSONObject jSONObject = this.f69;
        if (jSONObject != null) {
            return jSONObject;
        }
        JSONObject jSONObject2 = null;
        try {
            String m1826 = C0050.m1826(new File(this.f70));
            if (m1826 != null && m1826.length() > 0) {
                jSONObject2 = new JSONObject(m1826);
            }
        } catch (Exception unused) {
        }
        this.f69 = jSONObject2;
        return jSONObject2;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00a5 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* renamed from: а, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m1855(android.content.pm.PackageInfo r12, java.lang.String r13) {
        /*
            r11 = this;
            java.lang.String r0 = "keepaliveprocs"
            java.lang.String r1 = "thirdpartyso"
            java.lang.String r2 = "reversedependencies"
            java.lang.String r3 = "weakdependencies"
            java.lang.String r4 = "dependencies"
            java.lang.String r5 = "pluginclass"
            java.lang.String r6 = "pluginname"
            java.lang.String r7 = "hasso"
            r8 = 0
            if (r12 == 0) goto La6
            if (r13 != 0) goto L17
            goto La6
        L17:
            org.json.JSONObject r13 = new org.json.JSONObject
            r13.<init>()
            java.lang.String r9 = "version"
            java.lang.String r10 = r12.versionName     // Catch: java.lang.Exception -> La5
            r13.put(r9, r10)     // Catch: java.lang.Exception -> La5
            android.content.pm.ApplicationInfo r9 = r12.applicationInfo     // Catch: java.lang.Exception -> La5
            android.os.Bundle r9 = r9.metaData     // Catch: java.lang.Exception -> La5
            boolean r9 = r9.getBoolean(r7, r8)     // Catch: java.lang.Exception -> La5
            r13.put(r7, r9)     // Catch: java.lang.Exception -> La5
            android.content.pm.ApplicationInfo r7 = r12.applicationInfo     // Catch: java.lang.Exception -> La5
            android.os.Bundle r7 = r7.metaData     // Catch: java.lang.Exception -> La5
            java.lang.String r7 = r7.getString(r6)     // Catch: java.lang.Exception -> La5
            r13.put(r6, r7)     // Catch: java.lang.Exception -> La5
            android.content.pm.ApplicationInfo r6 = r12.applicationInfo     // Catch: java.lang.Exception -> La5
            android.os.Bundle r6 = r6.metaData     // Catch: java.lang.Exception -> La5
            java.lang.String r6 = r6.getString(r5)     // Catch: java.lang.Exception -> La5
            r13.put(r5, r6)     // Catch: java.lang.Exception -> La5
            android.content.pm.ApplicationInfo r5 = r12.applicationInfo     // Catch: java.lang.Exception -> La5
            android.os.Bundle r5 = r5.metaData     // Catch: java.lang.Exception -> La5
            java.lang.String r5 = r5.getString(r4)     // Catch: java.lang.Exception -> La5
            r13.put(r4, r5)     // Catch: java.lang.Exception -> La5
            android.content.pm.ApplicationInfo r4 = r12.applicationInfo     // Catch: java.lang.Exception -> La5
            android.os.Bundle r4 = r4.metaData     // Catch: java.lang.Exception -> La5
            java.lang.String r4 = r4.getString(r3)     // Catch: java.lang.Exception -> La5
            r13.put(r3, r4)     // Catch: java.lang.Exception -> La5
            android.content.pm.ApplicationInfo r3 = r12.applicationInfo     // Catch: java.lang.Exception -> La5
            android.os.Bundle r3 = r3.metaData     // Catch: java.lang.Exception -> La5
            java.lang.String r3 = r3.getString(r2)     // Catch: java.lang.Exception -> La5
            r13.put(r2, r3)     // Catch: java.lang.Exception -> La5
            android.content.pm.ApplicationInfo r2 = r12.applicationInfo     // Catch: java.lang.Exception -> La5
            android.os.Bundle r2 = r2.metaData     // Catch: java.lang.Exception -> La5
            boolean r2 = r2.getBoolean(r1)     // Catch: java.lang.Exception -> La5
            r13.put(r1, r2)     // Catch: java.lang.Exception -> La5
            android.content.pm.ApplicationInfo r12 = r12.applicationInfo     // Catch: java.lang.Exception -> La5
            android.os.Bundle r12 = r12.metaData     // Catch: java.lang.Exception -> La5
            java.lang.String r12 = r12.getString(r0)     // Catch: java.lang.Exception -> La5
            r13.put(r0, r12)     // Catch: java.lang.Exception -> La5
            r12 = 0
            java.io.File r0 = new java.io.File     // Catch: java.lang.Exception -> L8f
            java.lang.String r1 = r11.f70     // Catch: java.lang.Exception -> L8f
            r0.<init>(r1)     // Catch: java.lang.Exception -> L8f
            boolean r12 = r0.exists()     // Catch: java.lang.Exception -> L8d
            if (r12 != 0) goto L9a
            r0.createNewFile()     // Catch: java.lang.Exception -> L8d
            goto L9a
        L8d:
            r12 = r0
            goto L90
        L8f:
        L90:
            boolean r0 = r12.exists()
            if (r0 != 0) goto L99
            r12.createNewFile()     // Catch: java.lang.Exception -> L99
        L99:
            r0 = r12
        L9a:
            java.lang.String r12 = r13.toString()
            boolean r12 = com.alibaba.wireless.security.framework.utils.C0050.m1827(r0, r12)
            if (r12 != 0) goto La5
            goto La6
        La5:
            r8 = 1
        La6:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.C0056.m1855(android.content.pm.PackageInfo, java.lang.String):boolean");
    }

    /* renamed from: б, reason: contains not printable characters */
    public boolean m1856() {
        try {
            return new File(this.f70).exists();
        } catch (Exception unused) {
            return false;
        }
    }
}
