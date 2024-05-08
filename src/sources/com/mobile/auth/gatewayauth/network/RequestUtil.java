package com.mobile.auth.gatewayauth.network;

import android.content.Context;
import com.alicom.tools.networking.ResultMsg;
import com.alicom.tools.serialization.JSONType;
import com.alicom.tools.serialization.JSONUtils;
import com.mobile.auth.gatewayauth.ExceptionProcessor;
import com.mobile.auth.gatewayauth.annotations.SafeProtector;
import com.mobile.auth.gatewayauth.model.LimitConfig;
import com.mobile.auth.gatewayauth.model.RStruct;
import com.mobile.auth.gatewayauth.model.popsdkconfig.ConfigData;
import com.mobile.auth.gatewayauth.model.popsdkconfig.UploadData;
import com.mobile.auth.gatewayauth.utils.AESUtils;
import com.mobile.auth.gatewayauth.utils.EncryptUtils;
import com.mobile.auth.gatewayauth.utils.security.PackageUtils;
import com.nirvana.tools.core.CryptUtil;
import java.io.IOException;
import org.json.JSONObject;
import p.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class RequestUtil {
    public static final String PUBLIC_SECKEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCLShWjAtxJv3g2VPIYOOAv4rnVDdLkdseKm7+KOkCBLV9SKY5oqksFaXcLZ+nRnjnczhze5eGKhevwliUyag6x96GyXI2WagKIoB7Uwl2byl0xB5bNvYzf+x/DKHTSoGJshU6shXWXcjGFq+mUiPhM3WGZoqdY+vvqOWD+tga8XQIDAQAB";
    private static final String SERVEL_URL = "https://dypnsapi.aliyuncs.com/?";

    /* renamed from: com.mobile.auth.gatewayauth.network.RequestUtil$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class AnonymousClass1 extends JSONType<VendorRespone> {
    }

    /* renamed from: com.mobile.auth.gatewayauth.network.RequestUtil$2, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class AnonymousClass2 extends JSONType<com.mobile.auth.gatewayauth.model.popsdkconfig.SDKConfigRespone> {
    }

    /* renamed from: com.mobile.auth.gatewayauth.network.RequestUtil$3, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class AnonymousClass3 extends JSONType<UploadData> {
    }

    static {
        a.a("pns-2.13.2.1-LogOnlineStandardCuumRelease_alijtca_plus");
    }

    @SafeProtector
    private static String assembleCustomizeToken(Context context, String str, String str2) {
        try {
            try {
                String packageName = PackageUtils.getPackageName(context);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("sceneCode", str);
                jSONObject.put("packageName", packageName);
                jSONObject.put("packageSign", PackageUtils.getSign(context));
                jSONObject.put("osType", "Android");
                String generateAesKey = EncryptUtils.generateAesKey();
                RStruct rStruct = new RStruct();
                rStruct.setC(AESUtils.encryptString2Base64(jSONObject.toString(), generateAesKey, "0000000000000000"));
                rStruct.setK(EncryptUtils.encrpytAESKey(PUBLIC_SECKEY, generateAesKey));
                rStruct.setRid(str2);
                return CryptUtil.Base64.encode(JSONUtils.toJson(rStruct, null).toString().getBytes());
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
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

    private static native LimitConfig getConfig(ConfigData configData);

    public static native String getLifeBodyVerifyCertifyID(String str, String str2) throws IOException;

    public static native ResultMsg getPrivateKey(Context context, String str, String str2);

    public static native String getSDKConfigByPop(String str, String str2);

    private static native String getSecret1();

    private static native String getSecret2();

    private static native String getSecret3();

    private static native String getSecret4();

    public static native String getVendorListByPop(String str, String str2);

    public static native String uploadUserTrackInfoByPop(String str, String str2) throws IOException;
}
