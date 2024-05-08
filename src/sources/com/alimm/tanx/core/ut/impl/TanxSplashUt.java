package com.alimm.tanx.core.ut.impl;

import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.ut.AdUtConstants;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class TanxSplashUt extends TanxBaseUt {
    public static final String FROM_TYPE = "from_type";
    public static final String IS_SUC = "is_suc";
    public static final int TYPE_FROM_CACHE = 0;
    public static final int TYPE_FROM_REQUEST = 1;

    public static void sendUt(ITanxAd iTanxAd, AdUtConstants adUtConstants, HashMap<String, String> hashMap, int i10) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        str = "";
        if (iTanxAd != null) {
            String pid = iTanxAd.getAdSlot() != null ? iTanxAd.getAdSlot().getPid() : "";
            String requestId = iTanxAd.getRequestId();
            String creativeId = iTanxAd.getBidInfo() != null ? iTanxAd.getBidInfo().getCreativeId() : "";
            str2 = iTanxAd.getBidInfo() != null ? iTanxAd.getBidInfo().getTemplateId() : "";
            str5 = iTanxAd.getBidInfo() != null ? iTanxAd.getBidInfo().getSessionId() : "";
            str3 = pid;
            str4 = requestId;
            str = creativeId;
        } else {
            str2 = "";
            str3 = str2;
            str4 = str3;
            str5 = str4;
        }
        Map<String, Object> buildArgs = TanxBaseUt.buildArgs(str3, str4, str, str2);
        buildArgs.putAll(hashMap);
        String str6 = adUtConstants.arg1;
        TanxBaseUt.send(str6, adUtConstants.eventId, str3, str4, i10, str6, buildArgs, str5);
    }

    public static void utSplashCacheExist(ITanxAd iTanxAd, int i10, boolean z10, int i11) {
        HashMap hashMap = new HashMap();
        hashMap.put(FROM_TYPE, String.valueOf(i10));
        hashMap.put("is_suc", z10 ? "1" : "0");
        sendUt(iTanxAd, AdUtConstants.SPLASH_CACHE_EXSIT, hashMap, i11);
    }

    public static void utSplashJsonCheck(ITanxAd iTanxAd, int i10, boolean z10, int i11) {
        HashMap hashMap = new HashMap();
        hashMap.put(FROM_TYPE, String.valueOf(i10));
        hashMap.put("is_suc", z10 ? "1" : "0");
        sendUt(iTanxAd, AdUtConstants.SCREEN_JSON_CHECK, hashMap, i11);
    }

    public static void utSplashTimer(ITanxAd iTanxAd, int i10, boolean z10, int i11) {
        HashMap hashMap = new HashMap();
        hashMap.put(FROM_TYPE, String.valueOf(i10));
        hashMap.put("is_suc", z10 ? "1" : "0");
        sendUt(iTanxAd, AdUtConstants.AD_TIMER, hashMap, i11);
    }

    public static void utSplashViewClose(ITanxAd iTanxAd, int i10) {
        HashMap hashMap = new HashMap();
        hashMap.put(FROM_TYPE, String.valueOf(i10));
        sendUt(iTanxAd, AdUtConstants.SCREEN_VIEW_CANCEL, hashMap, 0);
    }

    public static void utSplashViewCreate(ITanxAd iTanxAd, int i10, boolean z10, int i11) {
        utSplashViewCreate(iTanxAd, i10, z10, i11, "");
    }

    public static void utSplashWebCreate(ITanxAd iTanxAd, int i10) {
        sendUt(iTanxAd, AdUtConstants.WEB_DID_MOUNT, new HashMap(), i10);
    }

    public static void utSplashViewCreate(ITanxAd iTanxAd, int i10, boolean z10, int i11, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(FROM_TYPE, String.valueOf(i10));
        hashMap.put("is_suc", z10 ? "1" : "0");
        sendUt(iTanxAd, AdUtConstants.SCREEN_VIEW_CREATE, hashMap, i11);
    }
}
