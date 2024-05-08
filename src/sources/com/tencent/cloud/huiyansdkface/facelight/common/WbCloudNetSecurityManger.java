package com.tencent.cloud.huiyansdkface.facelight.common;

import android.text.TextUtils;
import android.util.Base64;
import com.tencent.cloud.huiyansdkface.facelight.c.b.d;
import com.tencent.cloud.huiyansdkface.facelight.c.e.a;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import com.tencent.cloud.huiyansdkface.wejson.WeJson;
import java.util.concurrent.Callable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class WbCloudNetSecurityManger {

    /* renamed from: a, reason: collision with root package name */
    private static final String f40690a = "WbCloudNetSecurityManger";

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface ResultCallback<T> {
        void callback(T t2);
    }

    public static String base64Encry(boolean z10, String str, String str2) throws Exception {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new Exception("base64Encry src or key is null,please check!");
        }
        byte[] a10 = WbSecureProviders.secureType(z10).a(str.getBytes(), str2.getBytes(), null);
        return a10 == null ? "" : Base64.encodeToString(a10, 2);
    }

    public static String byteToHexString(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        for (byte b4 : bArr) {
            String hexString = Integer.toHexString(b4 & 255);
            if (hexString.length() < 2) {
                sb2.append("0");
            }
            sb2.append(hexString);
        }
        return sb2.toString();
    }

    public static <T> T decry(boolean z10, String str, Class<T> cls, String str2) throws Exception {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new Exception("decry encryString or key is null,please check!");
        }
        WeJson weJson = new WeJson();
        byte[] b4 = WbSecureProviders.secureType(z10).b(hexStringToBytes(str), str2.getBytes(), null);
        if (b4 == null) {
            throw new Exception("symmetricDecry failed!");
        }
        T t2 = (T) weJson.fromJson(new String(b4, "utf8"), (Class) cls);
        if (t2 != null) {
            return t2;
        }
        throw new Exception("decry Result failed!");
    }

    public static <T> void decryAsyn(final boolean z10, final String str, final Class<T> cls, final String str2, final ResultCallback<T> resultCallback) throws Exception {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new Exception("decry encryString or key is null,please check!");
        }
        hexStringToBytesAsyn(str, new ResultCallback<byte[]>() { // from class: com.tencent.cloud.huiyansdkface.facelight.common.WbCloudNetSecurityManger.1
            @Override // com.tencent.cloud.huiyansdkface.facelight.common.WbCloudNetSecurityManger.ResultCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void callback(byte[] bArr) {
                try {
                    byte[] b4 = WbSecureProviders.secureType(z10).b(WbCloudNetSecurityManger.hexStringToBytes(str), str2.getBytes(), null);
                    if (b4 == null) {
                        throw new Exception("decryAsyn failed!");
                    }
                    resultCallback.callback(new WeJson().fromJson(new String(b4, "utf8"), cls));
                } catch (Exception e2) {
                    e2.printStackTrace();
                    resultCallback.callback(null);
                }
            }
        });
    }

    public static String encryptAESKey(boolean z10, String str, String str2) {
        String str3;
        try {
            str3 = WbSecureProviders.secureType(z10).a(str.getBytes("utf8"));
            try {
                WLogger.d(f40690a, "get enKey:" + str3);
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                WLogger.w(f40690a, "enKey failed:" + e.toString());
                KycWaSDK.getInstance().trackCustomKVEvent(null, "faceservice_encry_enkey_fail", str2 + e.toString(), null);
                return str3;
            }
        } catch (Exception e10) {
            e = e10;
            str3 = null;
        }
        return str3;
    }

    public static String generateAESKey() {
        String a10 = a.a();
        return TextUtils.isEmpty(a10) ? a.a() : a10;
    }

    public static String hexEncry(boolean z10, byte[] bArr, String str) throws Exception {
        if (bArr == null || TextUtils.isEmpty(str)) {
            throw new Exception("hexEncry src or key is null,please check!");
        }
        return byteToHexString(WbSecureProviders.secureType(z10).a(bArr, str.getBytes(), null));
    }

    public static byte[] hexStringToBytes(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = i10 * 2;
            bArr[i10] = (byte) Integer.parseInt(str.substring(i11, i11 + 2), 16);
        }
        return bArr;
    }

    public static void hexStringToBytesAsyn(final String str, final ResultCallback<byte[]> resultCallback) {
        new d().a(new Callable<byte[]>() { // from class: com.tencent.cloud.huiyansdkface.facelight.common.WbCloudNetSecurityManger.2
            @Override // java.util.concurrent.Callable
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public byte[] call() throws Exception {
                int length = String.this.length() / 2;
                byte[] bArr = new byte[length];
                for (int i10 = 0; i10 < length; i10++) {
                    int i11 = i10 * 2;
                    bArr[i10] = (byte) Integer.parseInt(String.this.substring(i11, i11 + 2), 16);
                }
                return bArr;
            }
        }, new d.a<byte[]>() { // from class: com.tencent.cloud.huiyansdkface.facelight.common.WbCloudNetSecurityManger.3
            @Override // com.tencent.cloud.huiyansdkface.facelight.c.b.d.a
            public void a(byte[] bArr) {
                ResultCallback.this.callback(bArr);
            }
        });
    }
}
