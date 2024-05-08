package com.zego.zegoavkit2.utils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class ZegoLogUtil {
    /* JADX WARN: Removed duplicated region for block: B:19:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0046 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getLogPath(android.content.Context r3) {
        /*
            r0 = 0
            if (r3 != 0) goto L4
            return r0
        L4:
            java.lang.String r1 = android.os.Environment.getExternalStorageState()     // Catch: java.lang.Exception -> L9
            goto Le
        L9:
            r1 = move-exception
            r1.printStackTrace()
            r1 = r0
        Le:
            java.lang.String r2 = "mounted"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L2c
            java.io.File r1 = r3.getExternalFilesDir(r0)
            if (r1 == 0) goto L2c
            java.lang.String r1 = r1.getAbsolutePath()
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L2c
            java.io.File r2 = new java.io.File
            r2.<init>(r1)
            goto L2d
        L2c:
            r2 = r0
        L2d:
            if (r2 != 0) goto L44
            java.io.File r3 = r3.getFilesDir()
            if (r3 == 0) goto L44
            java.lang.String r3 = r3.getAbsolutePath()
            boolean r1 = android.text.TextUtils.isEmpty(r3)
            if (r1 != 0) goto L44
            java.io.File r2 = new java.io.File
            r2.<init>(r3)
        L44:
            if (r2 != 0) goto L47
            return r0
        L47:
            boolean r3 = r2.exists()
            if (r3 != 0) goto L57
            r2.mkdirs()
            boolean r3 = r2.exists()
            if (r3 != 0) goto L57
            return r0
        L57:
            java.lang.String r3 = r2.getAbsolutePath()
            java.lang.String r3 = r3.toString()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zego.zegoavkit2.utils.ZegoLogUtil.getLogPath(android.content.Context):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0040 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getTemporaryFolder(android.content.Context r3) {
        /*
            r0 = 0
            if (r3 != 0) goto L4
            return r0
        L4:
            java.lang.String r1 = android.os.Environment.getExternalStorageState()
            java.lang.String r2 = "mounted"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L26
            java.io.File r1 = r3.getExternalCacheDir()
            if (r1 == 0) goto L26
            java.lang.String r1 = r1.getAbsolutePath()
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L26
            java.io.File r2 = new java.io.File
            r2.<init>(r1)
            goto L27
        L26:
            r2 = r0
        L27:
            if (r2 != 0) goto L3e
            java.io.File r3 = r3.getCacheDir()
            if (r3 == 0) goto L3e
            java.lang.String r3 = r3.getAbsolutePath()
            boolean r1 = android.text.TextUtils.isEmpty(r3)
            if (r1 != 0) goto L3e
            java.io.File r2 = new java.io.File
            r2.<init>(r3)
        L3e:
            if (r2 != 0) goto L41
            return r0
        L41:
            boolean r3 = r2.exists()
            if (r3 != 0) goto L51
            r2.mkdirs()
            boolean r3 = r2.exists()
            if (r3 != 0) goto L51
            return r0
        L51:
            java.lang.String r3 = r2.getAbsolutePath()
            java.lang.String r3 = r3.toString()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zego.zegoavkit2.utils.ZegoLogUtil.getTemporaryFolder(android.content.Context):java.lang.String");
    }
}
