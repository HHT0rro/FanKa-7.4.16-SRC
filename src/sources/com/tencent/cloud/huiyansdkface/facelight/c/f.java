package com.tencent.cloud.huiyansdkface.facelight.c;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.huawei.openalliance.ad.constant.u;
import com.tencent.cloud.huiyansdkface.facelight.api.WbCloudFaceContant;
import com.tencent.cloud.huiyansdkface.facelight.common.KycWaSDK;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import com.tencent.cloud.huiyansdkface.normal.tools.secure.AESEncrypt;
import com.tencent.cloud.huiyansdkface.normal.tools.secure.GetEncryptKeyException;
import com.tencent.cloud.huiyansdkface.normal.tools.secure.RSAEncrypt;
import java.io.IOException;
import java.util.Random;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class f {
    public static double a(String str, double d10, String str2) {
        return a(str, d10, str2, ShadowDrawableWrapper.COS_45);
    }

    public static double a(String str, double d10, String str2, double d11) {
        if (TextUtils.isEmpty(str)) {
            WLogger.d("Utils", "cdn拉取的" + str2 + "为空！use DEFAULT!");
            return d10;
        }
        try {
            double parseDouble = Double.parseDouble(str);
            WLogger.d("Utils", "cdn拉取的" + str2 + "=" + parseDouble);
            if (parseDouble >= d11) {
                return parseDouble;
            }
            WLogger.w("Utils", "cdn拉取的" + str2 + "小于阈值" + d11 + ",use DEFAULT!");
            return d10;
        } catch (Exception e2) {
            e2.printStackTrace();
            WLogger.w("Utils", "cdn拉取的" + str2 + "不合法！use DEFAULT!");
            return d10;
        }
    }

    public static float a(String str, float f10, String str2) {
        return a(str, f10, str2, 0.0f);
    }

    public static float a(String str, float f10, String str2, float f11) {
        if (TextUtils.isEmpty(str)) {
            WLogger.d("Utils", "cdn拉取的" + str2 + "为空！use DEFAULT!");
            return f10;
        }
        try {
            float parseFloat = Float.parseFloat(str);
            WLogger.d("Utils", "cdn拉取的" + str2 + "=" + parseFloat);
            if (parseFloat >= f11) {
                return parseFloat;
            }
            WLogger.w("Utils", "cdn拉取的" + str2 + "小于阈值" + f11 + ",use DEFAULT!");
            return f10;
        } catch (Exception e2) {
            e2.printStackTrace();
            WLogger.w("Utils", "cdn拉取的" + str2 + "不合法！use DEFAULT!");
            return f10;
        }
    }

    public static int a(Activity activity, int i10, int i11) {
        if (activity == null) {
            return -1;
        }
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        int i12 = 0;
        if (rotation != 0) {
            if (rotation == 1) {
                i12 = 90;
            } else if (rotation == 2) {
                i12 = 180;
            } else if (rotation == 3) {
                i12 = 270;
            }
        }
        WLogger.d("Utils", "degrees: " + i12 + ", orientation: " + i11 + ", mCameraFacing: " + i10);
        return (i10 == 1 ? i11 + i12 : i11 - i12) % 360;
    }

    public static int a(Context context, float f10) {
        return (int) ((f10 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int a(String str, int i10, String str2) {
        return a(str, i10, str2, 0);
    }

    public static int a(String str, int i10, String str2, int i11) {
        if (TextUtils.isEmpty(str)) {
            WLogger.d("Utils", "cdn拉取的" + str2 + "为空！use DEFAULT!");
            return i10;
        }
        try {
            int parseInt = Integer.parseInt(str);
            WLogger.d("Utils", "cdn拉取的" + str2 + "=" + parseInt);
            if (parseInt >= i11) {
                return parseInt;
            }
            WLogger.w("Utils", "cdn拉取的" + str2 + "小于阈值" + i11 + ",use DEFAULT!");
            return i10;
        } catch (Exception e2) {
            e2.printStackTrace();
            WLogger.w("Utils", "cdn拉取的" + str2 + "不合法！use DEFAULT!");
            return i10;
        }
    }

    public static long a(String str, long j10, String str2) {
        return a(str, j10, str2, 0L);
    }

    public static long a(String str, long j10, String str2, long j11) {
        if (TextUtils.isEmpty(str)) {
            WLogger.d("Utils", "cdn拉取的" + str2 + "为空！use DEFAULT!");
            return j10;
        }
        try {
            long parseLong = Long.parseLong(str);
            WLogger.d("Utils", "cdn拉取的" + str2 + u.bD + parseLong);
            if (parseLong >= j11) {
                return parseLong;
            }
            WLogger.w("Utils", "cdn拉取的" + str2 + "小于阈值" + j11 + ",use DEFAULT!");
            return j10;
        } catch (Exception e2) {
            e2.printStackTrace();
            WLogger.w("Utils", "cdn拉取的" + str2 + "不合法！use DEFAULT!");
            return j10;
        }
    }

    public static String a(int i10) {
        int parseInt = Integer.parseInt("4e00", 16);
        int parseInt2 = Integer.parseInt("9fa5", 16);
        String str = "";
        for (int i11 = 0; i11 < i10; i11++) {
            str = str + new String(new char[]{(char) (new Random().nextInt((parseInt2 - parseInt) + 1) + parseInt)});
        }
        return str;
    }

    public static String a(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        NetworkInfo.State state;
        if (context == null) {
            WLogger.e("Utils", "传入的context为空！");
            return "";
        }
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
        if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            if (networkInfo != null && (state = networkInfo.getState()) != null && (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING)) {
                return "WIFI";
            }
            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
            if (networkInfo2 != null) {
                NetworkInfo.State state2 = networkInfo2.getState();
                String subtypeName = networkInfo2.getSubtypeName();
                if (state2 != null && (state2 == NetworkInfo.State.CONNECTED || state2 == NetworkInfo.State.CONNECTING)) {
                    switch (activeNetworkInfo.getSubtype()) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            return "2G";
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            return "3G";
                        case 13:
                            return "4G";
                        default:
                            if (!subtypeName.equalsIgnoreCase("TD-SCDMA") && !subtypeName.equalsIgnoreCase("WCDMA")) {
                                if (!subtypeName.equalsIgnoreCase("CDMA2000")) {
                                    return "MOBILE";
                                }
                            }
                            return "3G";
                    }
                    e2.printStackTrace();
                    return "";
                }
            }
        }
        return "NONE";
    }

    public static String a(Context context, AESEncrypt aESEncrypt, String str, byte[] bArr) {
        try {
            return Base64.encodeToString(aESEncrypt.encrypt(bArr, str.getBytes("utf8")), 0);
        } catch (Exception e2) {
            e2.printStackTrace();
            WLogger.w("Utils", "加密本地返回视频失败：" + e2.toString());
            KycWaSDK.getInstance().trackCustomKVEvent(context, "facepage_encrypt_error", "userVideo 加密本地返回视频失败：" + e2.toString(), null);
            return null;
        }
    }

    public static String a(Context context, String str, String str2) {
        String str3;
        try {
            str3 = a(str.getBytes("utf8"), str2);
            try {
                WLogger.d("Utils", "enAESKey=" + str3);
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                WLogger.w("Utils", "加密本地视频AES失败：" + e.toString());
                KycWaSDK.getInstance().trackCustomKVEvent(context, "facepage_encrypt_error", "加密本地视频AES失败：" + e.toString(), null);
                return str3;
            }
        } catch (Exception e10) {
            e = e10;
            str3 = null;
        }
        return str3;
    }

    public static String a(String str) {
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1179248177:
                if (str.equals(WbCloudFaceContant.LANGUAGE_EN)) {
                    c4 = 0;
                    break;
                }
                break;
            case -1179248063:
                if (str.equals(WbCloudFaceContant.LANGUAGE_ID)) {
                    c4 = 1;
                    break;
                }
                break;
            case -1179248035:
                if (str.equals(WbCloudFaceContant.LANGUAGE_JA)) {
                    c4 = 2;
                    break;
                }
                break;
            case -1179247990:
                if (str.equals(WbCloudFaceContant.LANGUAGE_KO)) {
                    c4 = 3;
                    break;
                }
                break;
            case -1179247718:
                if (str.equals(WbCloudFaceContant.LANGUAGE_TH)) {
                    c4 = 4;
                    break;
                }
                break;
            case 1869349942:
                if (str.equals(WbCloudFaceContant.LANGUAGE_ZH_CN)) {
                    c4 = 5;
                    break;
                }
                break;
            case 1869350094:
                if (str.equals(WbCloudFaceContant.LANGUAGE_ZH_HK)) {
                    c4 = 6;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                return "en";
            case 1:
                return "id";
            case 2:
                return "ja";
            case 3:
                return "ko";
            case 4:
                return "th";
            case 5:
            default:
                return "cn";
            case 6:
                return "hk";
        }
    }

    public static String a(Throwable th) {
        return Log.getStackTraceString(th);
    }

    private static String a(byte[] bArr, String str) throws GetEncryptKeyException {
        try {
            RSAEncrypt rSAEncrypt = new RSAEncrypt();
            rSAEncrypt.loadPublicKey(str);
            return Base64.encodeToString(rSAEncrypt.encrypt(bArr), 2);
        } catch (Exception e2) {
            e2.printStackTrace();
            throw new GetEncryptKeyException();
        }
    }

    public static boolean a(AssetManager assetManager, String str, String str2) {
        StringBuilder sb2;
        try {
            String[] list = assetManager.list(str);
            for (String str3 : list) {
                if (str3.equals(str2.trim())) {
                    WLogger.i("Utils", str2 + "存在");
                    return true;
                }
            }
            sb2 = new StringBuilder();
        } catch (IOException e2) {
            e2.printStackTrace();
            sb2 = new StringBuilder();
        }
        sb2.append(str2);
        sb2.append("不存在");
        WLogger.w("Utils", sb2.toString());
        return false;
    }

    public static float b(String str, float f10, String str2) {
        if (TextUtils.isEmpty(str)) {
            WLogger.d("Utils", "cdn拉取的" + str2 + "为空！use DEFAULT!");
            return f10;
        }
        try {
            float parseFloat = Float.parseFloat(str);
            WLogger.d("Utils", "cdn拉取的" + str2 + "=" + parseFloat);
            return parseFloat;
        } catch (Exception e2) {
            e2.printStackTrace();
            WLogger.w("Utils", "cdn拉取的" + str2 + "不合法！use DEFAULT!");
            return f10;
        }
    }
}
