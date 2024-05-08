package com.alibaba.security.realidentity.build;

import com.alibaba.security.common.utils.ImageUtils;
import java.io.File;

/* compiled from: FinishApi.java */
@aw(a = "finish,rpFinish")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class at extends aq {
    private static void d() {
        if (ImageUtils.getVerifyCacheDir() != null) {
            ImageUtils.deleteFile(new File(ImageUtils.getVerifyCacheDir()));
        }
    }

    @Override // com.alibaba.security.realidentity.build.aq
    public final String a() {
        return "finish";
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0055  */
    @Override // com.alibaba.security.realidentity.build.aq
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(java.lang.String r6, com.alibaba.security.realidentity.build.ay r7) {
        /*
            r5 = this;
            java.lang.String r0 = "message"
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: org.json.JSONException -> L6f
            r1.<init>(r6)     // Catch: org.json.JSONException -> L6f
            java.lang.String r6 = "status"
            int r6 = r1.getInt(r6)     // Catch: org.json.JSONException -> L6f
            java.lang.String r2 = "code"
            java.lang.String r2 = r1.getString(r2)     // Catch: org.json.JSONException -> L6f
            boolean r3 = r1.has(r0)     // Catch: org.json.JSONException -> L6f
            java.lang.String r4 = ""
            if (r3 == 0) goto L20
            java.lang.String r0 = r1.getString(r0)     // Catch: org.json.JSONException -> L6f
            goto L21
        L20:
            r0 = r4
        L21:
            r1 = -1
            r3 = 1
            if (r6 == r1) goto L2d
            if (r6 == r3) goto L2a
            com.alibaba.security.realidentity.RPResult r6 = com.alibaba.security.realidentity.RPResult.AUDIT_FAIL
            goto L2f
        L2a:
            com.alibaba.security.realidentity.RPResult r6 = com.alibaba.security.realidentity.RPResult.AUDIT_PASS
            goto L30
        L2d:
            com.alibaba.security.realidentity.RPResult r6 = com.alibaba.security.realidentity.RPResult.AUDIT_NOT
        L2f:
            r4 = r0
        L30:
            com.alibaba.security.realidentity.build.j r0 = com.alibaba.security.realidentity.build.j.a.a()
            com.alibaba.security.realidentity.build.b r0 = r0.f3899i
            if (r0 == 0) goto L42
            r0.onFinish(r6, r2, r4)
            com.alibaba.security.realidentity.build.j r6 = com.alibaba.security.realidentity.build.j.a.a()
            r0 = 0
            r6.f3899i = r0
        L42:
            android.content.Context r6 = r5.al
            if (r6 == 0) goto L4f
            boolean r0 = r6 instanceof android.app.Activity
            if (r0 == 0) goto L4f
            android.app.Activity r6 = (android.app.Activity) r6
            r6.finish()
        L4f:
            java.lang.String r6 = com.alibaba.security.common.utils.ImageUtils.getVerifyCacheDir()
            if (r6 == 0) goto L61
            java.io.File r6 = new java.io.File
            java.lang.String r0 = com.alibaba.security.common.utils.ImageUtils.getVerifyCacheDir()
            r6.<init>(r0)
            com.alibaba.security.common.utils.ImageUtils.deleteFile(r6)
        L61:
            r7.b()
            com.alibaba.security.realidentity.build.bf r6 = new com.alibaba.security.realidentity.build.bf
            java.lang.String r7 = "success"
            r6.<init>(r7)
            r5.a(r6, r3)
            return r3
        L6f:
            r6 = move-exception
            boolean r0 = com.alibaba.security.common.log.RPLogging.isEnable()
            if (r0 == 0) goto L7b
            java.lang.String r0 = "AbsJavaScriptExecuter"
            com.alibaba.security.common.log.RPLogging.e(r0, r6)
        L7b:
            com.alibaba.security.realidentity.build.aq.a(r7)
            java.lang.String r7 = "FinishApi parse params error"
            com.alibaba.security.realidentity.build.aq.a(r7, r6)
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.realidentity.build.at.a(java.lang.String, com.alibaba.security.realidentity.build.ay):boolean");
    }
}
