package com.mobile.auth.gatewayauth.utils;

import android.content.Context;
import com.mobile.auth.gatewayauth.ExceptionProcessor;
import com.mobile.auth.gatewayauth.annotations.SafeProtector;
import com.mobile.auth.gatewayauth.manager.SystemManager;
import com.mobile.auth.gatewayauth.manager.VendorSdkInfoManager;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class TokenGenerator {

    /* renamed from: a, reason: collision with root package name */
    private com.mobile.auth.q.a f37374a;

    /* renamed from: b, reason: collision with root package name */
    private SystemManager f37375b;

    /* renamed from: c, reason: collision with root package name */
    private VendorSdkInfoManager f37376c;

    static {
        p.a.a("pns-2.13.2.1-LogOnlineStandardCuumRelease_alijtca_plus");
    }

    public TokenGenerator(com.mobile.auth.q.a aVar, SystemManager systemManager, VendorSdkInfoManager vendorSdkInfoManager) {
        this.f37374a = aVar;
        this.f37375b = systemManager;
        this.f37376c = vendorSdkInfoManager;
    }

    @SafeProtector
    private native String assembleCustomizeToken(Context context, String str, String str2, String str3, String str4, String str5, String str6);

    @SafeProtector
    private native String generateCsrf(String str);

    public String a(Context context, String str, String str2, String str3, boolean z10, String str4, String str5, String str6, boolean z11, String str7) {
        try {
            return assembleToken(context, null, null, null, str, str2, str3, z10, str4, str5, str6, z11, str7);
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

    /* JADX WARN: Removed duplicated region for block: B:11:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x002d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @com.mobile.auth.gatewayauth.annotations.SafeProtector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String assembleToken(android.content.Context r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, boolean r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, boolean r35, java.lang.String r36) {
        /*
            r23 = this;
            r9 = r23
            r10 = 0
            java.lang.String r0 = ""
            if (r31 == 0) goto Le
            r4 = r29
            java.lang.String r0 = r9.generateCsrf(r4)     // Catch: java.lang.Throwable -> L7c
            goto L10
        Le:
            r4 = r29
        L10:
            r19 = r0
            r8 = 1
            r22 = 0
            if (r35 == 0) goto L27
            java.lang.String r0 = "rpk"
            r2 = r24
            java.lang.String r0 = com.mobile.auth.gatewayauth.utils.k.g(r2, r0)     // Catch: java.lang.Throwable -> L7c
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L7c
            if (r1 != 0) goto L2a
            r1 = 1
            goto L2b
        L27:
            r2 = r24
            r0 = r10
        L2a:
            r1 = 0
        L2b:
            if (r1 != 0) goto L57
            com.mobile.auth.gatewayauth.manager.VendorSdkInfoManager r0 = r9.f37376c     // Catch: java.io.UnsupportedEncodingException -> L54 java.lang.Throwable -> L7c
            java.lang.String r15 = r0.c()     // Catch: java.io.UnsupportedEncodingException -> L54 java.lang.Throwable -> L7c
            r20 = 1
            r11 = r24
            r12 = r25
            r13 = r26
            r14 = r27
            r16 = r28
            r17 = r29
            r18 = r30
            r21 = r36
            java.lang.String r0 = com.mobile.auth.gatewayauth.utils.EncryptUtils.encryptToken(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)     // Catch: java.io.UnsupportedEncodingException -> L54 java.lang.Throwable -> L7c
            java.lang.String r1 = "UTF-8"
            byte[] r0 = r0.getBytes(r1)     // Catch: java.io.UnsupportedEncodingException -> L54 java.lang.Throwable -> L7c
            java.lang.String r0 = com.nirvana.tools.core.CryptUtil.Base64.encode(r0)     // Catch: java.io.UnsupportedEncodingException -> L54 java.lang.Throwable -> L7c
            goto L6b
        L54:
            r0 = move-exception
            r11 = 1
            goto L6e
        L57:
            r1 = r23
            r2 = r24
            r3 = r28
            r4 = r29
            r5 = r32
            r6 = r33
            r7 = r34
            r11 = 1
            r8 = r0
            java.lang.String r0 = r1.assembleCustomizeToken(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.io.UnsupportedEncodingException -> L6d java.lang.Throwable -> L7c
        L6b:
            r10 = r0
            goto L7b
        L6d:
            r0 = move-exception
        L6e:
            com.mobile.auth.q.a r1 = r9.f37374a     // Catch: java.lang.Throwable -> L7c
            java.lang.String[] r2 = new java.lang.String[r11]     // Catch: java.lang.Throwable -> L7c
            java.lang.String r0 = com.nirvana.tools.core.ExecutorManager.getErrorInfoFromException(r0)     // Catch: java.lang.Throwable -> L7c
            r2[r22] = r0     // Catch: java.lang.Throwable -> L7c
            r1.e(r2)     // Catch: java.lang.Throwable -> L7c
        L7b:
            return r10
        L7c:
            r0 = move-exception
            com.mobile.auth.gatewayauth.ExceptionProcessor.processException(r0)     // Catch: java.lang.Throwable -> L81
            return r10
        L81:
            r0 = move-exception
            r1 = r0
            com.mobile.auth.gatewayauth.ExceptionProcessor.processException(r1)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.auth.gatewayauth.utils.TokenGenerator.assembleToken(android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, java.lang.String, java.lang.String, java.lang.String, boolean, java.lang.String):java.lang.String");
    }
}
