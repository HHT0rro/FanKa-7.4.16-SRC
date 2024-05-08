package com.tencent.mm.opensdk.diffdev;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface OAuthListener {
    void onAuthFinish(OAuthErrCode oAuthErrCode, String str);

    void onAuthGotQrcode(String str, byte[] bArr);

    void onQrcodeScanned();
}
