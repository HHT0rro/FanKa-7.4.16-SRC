package com.kuaishou.weapon.p0;

import java.io.File;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ae {
    public boolean a(String str) {
        StringBuilder sb2 = new StringBuilder();
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append("proc");
        sb2.append(str2);
        sb2.append(str);
        return new File(sb2.toString()).canWrite();
    }

    public boolean b(String str) {
        return a(str, false);
    }

    public JSONObject b() {
        try {
            JSONObject jSONObject = new JSONObject();
            int i10 = 1;
            jSONObject.put("0", a("/sys", true) ? 1 : 0);
            jSONObject.put("1", a("/sbin", true) ? 1 : 0);
            jSONObject.put("2", a("/etc", true) ? 1 : 0);
            if (!a("/dev", true)) {
                i10 = 0;
            }
            jSONObject.put("3", i10);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0055 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(java.lang.String r4, boolean r5) {
        /*
            r3 = this;
            java.lang.String r0 = ""
            if (r5 == 0) goto L2c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L52
            r0.<init>()     // Catch: java.lang.Throwable -> L52
            r0.append(r4)     // Catch: java.lang.Throwable -> L52
            java.lang.String r4 = "/-"
            r0.append(r4)     // Catch: java.lang.Throwable -> L52
            long r1 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L52
            r0.append(r1)     // Catch: java.lang.Throwable -> L52
            java.lang.String r4 = r0.toString()     // Catch: java.lang.Throwable -> L52
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L52
            r0.<init>()     // Catch: java.lang.Throwable -> L52
            long r1 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L52
            r0.append(r1)     // Catch: java.lang.Throwable -> L52
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L52
        L2c:
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L52
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L52
            r1.exists()     // Catch: java.lang.Throwable -> L52
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L52
            r4.<init>(r1)     // Catch: java.lang.Throwable -> L52
            byte[] r0 = r0.getBytes()     // Catch: java.lang.Throwable -> L50
            r4.write(r0)     // Catch: java.lang.Throwable -> L50
            r4.flush()     // Catch: java.lang.Throwable -> L50
            r4.close()     // Catch: java.lang.Throwable -> L50
            if (r5 == 0) goto L4b
            r1.delete()     // Catch: java.lang.Throwable -> L50
        L4b:
            r4.close()     // Catch: java.lang.Exception -> L4e
        L4e:
            r4 = 1
            return r4
        L50:
            goto L53
        L52:
            r4 = 0
        L53:
            if (r4 == 0) goto L58
            r4.close()     // Catch: java.lang.Exception -> L58
        L58:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.ae.a(java.lang.String, boolean):boolean");
    }

    public JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            int i10 = 1;
            jSONObject.put("0", a("/data", true) ? 1 : 0);
            jSONObject.put("1", a("/system/bin", true) ? 1 : 0);
            if (!a("/system/lib", true)) {
                i10 = 0;
            }
            jSONObject.put("2", i10);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }
}
