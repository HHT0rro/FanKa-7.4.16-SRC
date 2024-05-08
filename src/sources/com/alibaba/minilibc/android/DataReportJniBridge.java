package com.alibaba.minilibc.android;

import android.content.Context;
import com.alimm.tanx.core.constant.AdType;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class9.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class9.dex.bak */
public class DataReportJniBridge {
    private static final boolean DEBUG = false;
    private static final String TAG = "DataReportJniBridge";
    private static Class gAccsAdapterClass;
    private static volatile int gAccsAvaiableCache;
    private static volatile int gAccsAvaiableCacheChecked;
    private static Class gOrangeAdapterClass;
    private static volatile int gOrangeAvailableCache;
    private static volatile int gOrangeAvailableCacheChecked;
    private static Method gOrangeRegisterListenerMethod;
    private static Method gRegisterListenerMethod;

    public static int mtopAvaiableBridge() {
        return MtopMethodJniBridge.mtopAvaiable();
    }

    public static String sendReportBridge(String str, String str2, byte[] bArr) {
        HashMap hashMap;
        if (ConditionTool.stringNotNullOrEmpty(str2)) {
            hashMap = new HashMap();
            hashMap.put("keyindex", str2);
        } else {
            hashMap = null;
        }
        HttpClientResult doHttpPost = HttpClientUtils.doHttpPost(str, hashMap, bArr, null, AdType.NATIVE_EXPRESS, AdType.NATIVE_EXPRESS);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(doHttpPost.mResponseCode);
        sb2.append("|");
        sb2.append(doHttpPost.mResponseCode == 200 ? doHttpPost.mString : doHttpPost.mExceptionString);
        return sb2.toString();
    }

    public static String sendReportBridgeHttps(String str, Map<String, String> map, byte[] bArr) {
        HashMap hashMap = new HashMap();
        hashMap.put("keyindex", "wb_sc_int_res_k1");
        if (map != null) {
            hashMap.putAll(map);
        }
        HttpClientResult doHttpPost = HttpClientUtils.doHttpPost(str, hashMap, bArr, null, AdType.NATIVE_EXPRESS, AdType.NATIVE_EXPRESS);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(doHttpPost.mResponseCode);
        sb2.append("|");
        sb2.append(doHttpPost.mResponseCode == 200 ? doHttpPost.mString : doHttpPost.mExceptionString);
        return sb2.toString();
    }

    public static String sendReportBridgeHttps(String str, byte[] bArr) {
        return sendReportBridgeHttps(str, null, bArr);
    }

    public static String sendReportBridgeMtop(Context context, String str, String str2, String str3, Map<String, String> map, Map<String, String> map2, byte[] bArr) {
        return MtopMethodJniBridge.postRequest(context, str, str2, str3, map, map2, bArr);
    }
}
