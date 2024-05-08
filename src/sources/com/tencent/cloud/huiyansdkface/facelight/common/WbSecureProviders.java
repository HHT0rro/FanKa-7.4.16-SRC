package com.tencent.cloud.huiyansdkface.facelight.common;

import android.util.Base64;
import com.kycgm.GmCipher;
import com.tencent.cloud.huiyansdkface.facelight.c.e.a;
import com.tencent.cloud.huiyansdkface.facelight.c.e.c;
import com.tencent.cloud.huiyansdkface.facelight.c.e.d;
import com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceModeProviders;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import com.tencent.cloud.huiyansdkface.normal.tools.secure.GetEncryptKeyException;
import com.tencent.cloud.huiyansdkface.normal.tools.secure.RSAEncrypt;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class WbSecureProviders {

    /* renamed from: a, reason: collision with root package name */
    public static final d f40698a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f40699b;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class GMProvider {

        /* renamed from: a, reason: collision with root package name */
        private static c f40700a = new c();

        public static c getGm() {
            return f40700a;
        }
    }

    static {
        try {
            int i10 = GmCipher.f36654a;
            f40699b = true;
        } catch (ClassNotFoundException unused) {
            f40699b = false;
        }
        f40698a = new d() { // from class: com.tencent.cloud.huiyansdkface.facelight.common.WbSecureProviders.1
            @Override // com.tencent.cloud.huiyansdkface.facelight.c.e.d
            public String a(byte[] bArr) throws GetEncryptKeyException {
                WLogger.d("WbSecureProviders", "GJ_HELPER:asymmetricEncry");
                try {
                    RSAEncrypt rSAEncrypt = new RSAEncrypt();
                    rSAEncrypt.loadPublicKey("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA2OXYSHK17mwXtXP2G0yowfGOG3aYplI/hpc6FnZTl5PjGzZFzCnxi68XAKEtKkmkCDTCvSE13kbRxzw0nyMqEIbKgIZmg8K7G3ylCTUCJPVy8qNZh7WQ7piqSK4aQ74ibby1Jtw8MqWsd41kV5v48lkm1bc596dZcfMBM0KEqlRuMD8uwIzPCVI+rVjLduogMPRQNsV6aLsWLRnFzTTWb2mSXWvhZKQWU/g+XQGE6H1t+NKSJVGdj26F3Q5dzEcZyDzhpbuEWKmCZugmMjXxWjLj6XeuTvvWrAsKzwulOAHZ9nMibBZj6hnLhGbTEFKMtXe9P8jUmEPzRmd6nxVG5wIDAQAB");
                    return Base64.encodeToString(rSAEncrypt.encrypt(bArr), 0);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    throw new GetEncryptKeyException();
                }
            }

            @Override // com.tencent.cloud.huiyansdkface.facelight.c.e.d
            public byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
                try {
                    return a.a(bArr, bArr2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            }

            @Override // com.tencent.cloud.huiyansdkface.facelight.c.e.d
            public byte[] b(byte[] bArr, byte[] bArr2, byte[] bArr3) {
                try {
                    return a.b(bArr, bArr2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
        };
    }

    public static boolean isUseGm() {
        boolean z10 = com.tencent.cloud.huiyansdkface.facelight.process.d.z().e().z() && f40699b;
        WLogger.d("WbSecureProviders", "hasGm:" + f40699b + ";isUseGm =" + z10);
        if (!WbFaceModeProviders.isUseWillSdk()) {
            return z10;
        }
        WLogger.w("WbSecureProviders", "will not support Gm!");
        return false;
    }

    public static d secureType(boolean z10) {
        return z10 ? GMProvider.getGm() : f40698a;
    }
}
