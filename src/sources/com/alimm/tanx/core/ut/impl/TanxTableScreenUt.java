package com.alimm.tanx.core.ut.impl;

import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.ut.AdUtConstants;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class TanxTableScreenUt extends TanxBaseUt {
    public static void utRewardExposureTime(ITanxAd iTanxAd, long j10) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5 = "";
        if (iTanxAd != null) {
            String pid = iTanxAd.getAdSlot() != null ? iTanxAd.getAdSlot().getPid() : "";
            String requestId = iTanxAd.getRequestId();
            if (iTanxAd.getBidInfo() != null) {
                str5 = iTanxAd.getBidInfo().getCreativeId();
                str = iTanxAd.getBidInfo().getTemplateId();
                str4 = iTanxAd.getBidInfo().getSessionId();
            } else {
                str = "";
                str4 = str;
            }
            str2 = pid;
            str3 = requestId;
        } else {
            str = "";
            str2 = str;
            str3 = str2;
            str4 = str3;
        }
        Map<String, Object> buildArgs = TanxBaseUt.buildArgs(str2, str3, str5, str);
        buildArgs.put("exposure_time", Long.valueOf(j10));
        AdUtConstants adUtConstants = AdUtConstants.TABLE_SCREEN_EXPOSURE_MONITOR;
        String str6 = adUtConstants.arg1;
        TanxBaseUt.send(str6, adUtConstants.eventId, str2, str3, 0, str6, buildArgs, str4);
    }

    public static void utViewDraw(ITanxAd iTanxAd, int i10) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        if (iTanxAd != null) {
            String pid = iTanxAd.getAdSlot() != null ? iTanxAd.getAdSlot().getPid() : "";
            String requestId = iTanxAd.getRequestId();
            if (iTanxAd.getBidInfo() != null) {
                String creativeId = iTanxAd.getBidInfo().getCreativeId();
                String templateId = iTanxAd.getBidInfo().getTemplateId();
                str5 = iTanxAd.getBidInfo().getSessionId();
                str3 = creativeId;
                str = pid;
                str2 = requestId;
                str4 = templateId;
            } else {
                str3 = "";
                str4 = str3;
                str5 = str4;
                str = pid;
                str2 = requestId;
            }
        } else {
            str = "";
            str2 = str;
            str3 = str2;
            str4 = str3;
            str5 = str4;
        }
        utViewDraw(str, str2, str3, str4, i10, str5);
    }

    public static void utViewDraw(String str, String str2, String str3, String str4, int i10, String str5) {
        Map<String, Object> buildArgs = TanxBaseUt.buildArgs(str, str2, str3, str4);
        buildArgs.put("is_suc", i10 + "");
        int i11 = i10 == 1 ? 0 : 1;
        AdUtConstants adUtConstants = AdUtConstants.TABLE_SCREEN_VIEW_CREATE;
        String str6 = adUtConstants.arg1;
        TanxBaseUt.send(str6, adUtConstants.eventId, str, str2, i11, str6, buildArgs, str5);
    }
}
