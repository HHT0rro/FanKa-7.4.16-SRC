package com.mobile.auth.gatewayauth.detectnet;

import com.mobile.auth.gatewayauth.ExceptionProcessor;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class d {
    public static c a(c cVar, String str) {
        try {
            String str2 = "unknown host";
            if (str.contains("0% packet loss")) {
                int indexOf = str.indexOf("/mdev = ");
                int indexOf2 = str.indexOf(" ms\n", indexOf);
                if (indexOf != -1 && indexOf2 != -1) {
                    String[] split = str.substring(indexOf + 8, indexOf2).split("/");
                    cVar.a(true);
                    cVar.a((int) Float.parseFloat(split[1]));
                    return cVar;
                }
                str2 = "Error: " + str;
            } else if (str.contains("100% packet loss")) {
                str2 = "100% packet loss";
            } else if (str.contains("% packet loss")) {
                str2 = "partial packet loss";
            } else if (!str.contains("unknown host")) {
                str2 = "unknown error in getPingStats";
            }
            cVar.b(str2);
            cVar.a(10004);
            return cVar;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00dd A[Catch: all -> 0x0127, TRY_LEAVE, TryCatch #2 {all -> 0x0127, blocks: (B:3:0x0001, B:5:0x000c, B:9:0x0027, B:11:0x002d, B:12:0x0047, B:14:0x0058, B:19:0x0067, B:22:0x0087, B:23:0x00af, B:27:0x00c0, B:28:0x00ca, B:29:0x00d9, B:31:0x00ce, B:32:0x00dd, B:34:0x00eb, B:36:0x00f1, B:38:0x00fe, B:42:0x00fb, B:45:0x0093, B:49:0x0061, B:52:0x0108), top: B:2:0x0001, inners: #0, #7 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.mobile.auth.gatewayauth.detectnet.c a(java.lang.String r10, int r11) {
        /*
            Method dump skipped, instructions count: 305
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.auth.gatewayauth.detectnet.d.a(java.lang.String, int):com.mobile.auth.gatewayauth.detectnet.c");
    }
}
