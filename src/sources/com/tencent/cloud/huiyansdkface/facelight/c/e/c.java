package com.tencent.cloud.huiyansdkface.facelight.c.e;

import android.util.Base64;
import com.kycgm.GmCipher;
import com.tencent.cloud.huiyansdkface.facelight.common.KycWaSDK;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class c implements d {
    @Override // com.tencent.cloud.huiyansdkface.facelight.c.e.d
    public String a(byte[] bArr) {
        byte[] sm2Encrypt = GmCipher.sm2Encrypt(bArr, Base64.decode("x9Wi9R/0gY/vNYnvEiIevjmHC5knKybFS0/87+yZPR8EwAh9S9KVt6w3UPh8vVB6VrxNqME3Hv3vATVO28VI0w==", 2));
        if (sm2Encrypt != null) {
            return Base64.encodeToString(sm2Encrypt, 2);
        }
        KycWaSDK.getInstance().trackCustomKVEvent(null, "faceservice_gm_sm2Encrypt_fail", null, null);
        return "";
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.c.e.d
    public byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return GmCipher.sm4CbcEncrypt(bArr, bArr2, "ItdzfwvGcrpuLlwz".getBytes());
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.c.e.d
    public byte[] b(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return GmCipher.sm4CbcDecrypt(bArr, bArr2, "ItdzfwvGcrpuLlwz".getBytes());
    }
}
