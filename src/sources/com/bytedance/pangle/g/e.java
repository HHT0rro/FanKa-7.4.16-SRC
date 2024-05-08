package com.bytedance.pangle.g;

import android.content.pm.Signature;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class e {
    public static boolean a(String str, String str2) {
        o a10;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (com.bytedance.pangle.util.i.a()) {
                a10 = d.a(str);
            } else {
                a10 = a.a(str);
            }
            Signature[] signatureArr = a10 != null ? a10.f10807b : null;
            byte[] decode = Base64.decode(Zeus.getPlugin(str2).mSignature, 0);
            if (decode != null && decode.length != 0) {
                int i10 = 0;
                for (Signature signature : signatureArr) {
                    i10 += signature.toByteArray().length;
                }
                byte[] bArr = new byte[i10];
                int i11 = 0;
                for (Signature signature2 : signatureArr) {
                    System.arraycopy((Object) signature2.toByteArray(), 0, (Object) bArr, i11, signature2.toByteArray().length);
                    i11 += signature2.toByteArray().length;
                }
                boolean a11 = o.a(bArr, decode);
                if (!a11) {
                    ZeusLogger.w(ZeusLogger.TAG_INSTALL, "ApkSignatureVerify verify plugin signature error : ".concat(String.valueOf(str)));
                }
                return a11;
            }
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "ApkSignatureVerify get hostSignature error : ".concat(String.valueOf(str)));
            return false;
        } catch (q e2) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "ApkSignatureVerify verify plugin signature error : ".concat(String.valueOf(str)), e2);
            return false;
        }
    }
}
