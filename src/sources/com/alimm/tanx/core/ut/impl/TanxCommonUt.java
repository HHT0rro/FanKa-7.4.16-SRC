package com.alimm.tanx.core.ut.impl;

import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.ad.bean.AdInfo;
import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.alimm.tanx.core.ad.listener.bean.IBidInfo;
import com.alimm.tanx.core.constant.TanxAdType;
import com.alimm.tanx.core.request.TanxAdSlot;
import com.alimm.tanx.core.ut.AdUtConstants;
import com.alimm.tanx.core.utils.LogUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class TanxCommonUt extends TanxBaseUt {
    public static final String IS_SUC = "is_suc";

    public static void cacheCheck(ITanxAd iTanxAd, String str, int i10, Exception exc) {
        HashMap hashMap = new HashMap();
        hashMap.put("video_url", str);
        if (exc != null) {
            hashMap.put("error", LogUtils.getStackTraceMessage(exc));
        }
        sendUt(iTanxAd, AdUtConstants.CACHE_CHECK, hashMap, i10);
    }

    public static void fileSizeCheck(ITanxAd iTanxAd, long j10, int i10, long j11) {
        HashMap hashMap = new HashMap();
        hashMap.put("file_size", j10 + "");
        hashMap.put("file_size_m", ((((double) j10) / 1024.0d) / 1024.0d) + "");
        hashMap.put("time", j11 + "");
        sendUt(iTanxAd, AdUtConstants.FILE_SIZE_CHECK, hashMap, i10);
    }

    public static void sendAdRqFail(String str, String str2, String str3, long j10, int i10, String str4, String str5) {
        Map<String, Object> buildArgs = TanxBaseUt.buildArgs(str2, str3, null, null);
        buildArgs.put("scenes", str);
        buildArgs.put("request_time", String.valueOf(j10));
        buildArgs.put("params", str5);
        buildArgs.put("msg", str4);
        AdUtConstants adUtConstants = AdUtConstants.AD_REQUEST;
        String str6 = adUtConstants.arg1;
        TanxBaseUt.send(str6, adUtConstants.eventId, str2, str3, i10, str6, buildArgs, "");
    }

    public static void sendAdRqSuc(String str, TanxAdSlot tanxAdSlot, String str2, long j10, int i10, AdInfo adInfo) {
        ArrayList arrayList = new ArrayList();
        if (adInfo != null && adInfo.getBidInfoList() != null && adInfo.getBidInfoList().size() > 0) {
            for (int i11 = 0; i11 < adInfo.getBidInfoList().size(); i11++) {
                arrayList.add(adInfo.getBidInfoList().get(i11).getTemplateId());
            }
        }
        Map<String, Object> buildArgs = TanxBaseUt.buildArgs(tanxAdSlot.getPid(), str2, null, null);
        buildArgs.put("scenes", str);
        buildArgs.put(ExposeManager.UtArgsNames.templateId, arrayList.toString());
        buildArgs.put("ad_count", String.valueOf(tanxAdSlot.getAdCount()));
        buildArgs.put("result_ad_count", String.valueOf(i10));
        buildArgs.put("request_time", String.valueOf(j10));
        AdUtConstants adUtConstants = AdUtConstants.AD_REQUEST;
        TanxBaseUt.send(adUtConstants.arg1, adUtConstants.eventId, tanxAdSlot.getPid(), str2, adInfo == null ? -1 : adInfo.getStatus(), adUtConstants.arg1, buildArgs, "");
    }

    public static void sendClickExposureFail(String str, String str2, IBidInfo iBidInfo, String str3, int i10, String str4) {
        Map<String, Object> buildArgs = TanxBaseUt.buildArgs(str, str2, iBidInfo.getCreativeId(), iBidInfo.getTemplateId());
        buildArgs.put(ExposeManager.UtArgsNames.templateId, iBidInfo.getTemplateId());
        buildArgs.put("params", str3);
        buildArgs.put("msg", str4);
        AdUtConstants adUtConstants = AdUtConstants.CLICK_REQUEST;
        String str5 = adUtConstants.arg1;
        TanxBaseUt.send(str5, adUtConstants.eventId, str, str2, i10, str5, iBidInfo.getInteractType2Int() + "", "", buildArgs, iBidInfo.getSessionId());
    }

    public static void sendClickExposureSuc(String str, String str2, IBidInfo iBidInfo, String str3) {
        Map<String, Object> buildArgs = TanxBaseUt.buildArgs(str, str2, iBidInfo.getCreativeId(), iBidInfo.getTemplateId());
        buildArgs.put(ExposeManager.UtArgsNames.templateId, iBidInfo.getTemplateId());
        AdUtConstants adUtConstants = AdUtConstants.CLICK_REQUEST;
        String str4 = adUtConstants.arg1;
        TanxBaseUt.send(str4, adUtConstants.eventId, str, str2, 0, str4, iBidInfo.getInteractType2Int() + "", "", buildArgs, iBidInfo.getSessionId());
    }

    public static void sendDownH5ZipFail(String str, int i10, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("params", str);
        hashMap.put("code", i10 + "");
        hashMap.put("msg", str2);
        AdUtConstants adUtConstants = AdUtConstants.DOWN_H5_ZIP;
        String str3 = adUtConstants.arg1;
        TanxBaseUt.send(str3, adUtConstants.eventId, i10, str3, hashMap, "");
    }

    public static void sendExposureFail(String str, String str2, IBidInfo iBidInfo, String str3, int i10, String str4) {
        Map<String, Object> buildArgs = TanxBaseUt.buildArgs(str, str2, iBidInfo.getCreativeId(), iBidInfo.getTemplateId());
        buildArgs.put(ExposeManager.UtArgsNames.templateId, iBidInfo.getTemplateId());
        buildArgs.put("params", str3);
        buildArgs.put("code", i10 + "");
        buildArgs.put("msg", str4);
        AdUtConstants adUtConstants = AdUtConstants.IMP_REQUEST;
        String str5 = adUtConstants.arg1;
        TanxBaseUt.send(str5, adUtConstants.eventId, str, str2, i10, str5, iBidInfo.getInteractType2Int() + "", "", buildArgs, iBidInfo.getSessionId());
    }

    public static void sendExposureSuc(String str, String str2, IBidInfo iBidInfo, String str3) {
        Map<String, Object> buildArgs = TanxBaseUt.buildArgs(str, str2, iBidInfo.getCreativeId(), iBidInfo.getTemplateId());
        buildArgs.put(ExposeManager.UtArgsNames.templateId, iBidInfo.getTemplateId());
        AdUtConstants adUtConstants = AdUtConstants.IMP_REQUEST;
        String str4 = adUtConstants.arg1;
        TanxBaseUt.send(str4, adUtConstants.eventId, str, str2, 0, str4, iBidInfo.getInteractType2Int() + "", "", buildArgs, iBidInfo.getSessionId());
    }

    public static void sendIntoMethod(TanxAdSlot tanxAdSlot, String str, IBidInfo iBidInfo, String str2, AdUtConstants adUtConstants) {
        sendIntoMethod(tanxAdSlot, str, iBidInfo, str2, adUtConstants, new HashMap());
    }

    public static void sendStartImp(TanxAdSlot tanxAdSlot, String str, IBidInfo iBidInfo, int i10) {
        String pid = tanxAdSlot != null ? tanxAdSlot.getPid() : "";
        Map<String, Object> buildArgs = TanxBaseUt.buildArgs(pid, str, iBidInfo.getCreativeId(), iBidInfo.getTemplateId());
        buildArgs.put("scenes", TanxAdType.getAdTypeStr(i10) + "");
        TanxBaseUt.buildAntiCheatParam(buildArgs);
        AdUtConstants adUtConstants = AdUtConstants.START_IMP;
        String str2 = adUtConstants.arg1;
        TanxBaseUt.send(str2, adUtConstants.eventId, pid, str, str2, iBidInfo.getInteractType2Int() + "", null, buildArgs, iBidInfo.getSessionId());
    }

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
        TanxBaseUt.send(str6, adUtConstants.eventId, str3, str4, i10, str6, "", "", buildArgs, str5);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0078 A[Catch: Exception -> 0x005d, TryCatch #0 {Exception -> 0x005d, blocks: (B:17:0x0004, B:19:0x000a, B:20:0x0014, B:22:0x001e, B:24:0x0040, B:26:0x004e, B:5:0x0064, B:7:0x0078, B:8:0x007f), top: B:16:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void utShakeDestroy(com.alimm.tanx.core.ad.ITanxAd r16, java.lang.String r17) {
        /*
            java.lang.String r0 = ""
            if (r16 == 0) goto L5f
            com.alimm.tanx.core.request.TanxAdSlot r1 = r16.getAdSlot()     // Catch: java.lang.Exception -> L5d
            if (r1 == 0) goto L13
            com.alimm.tanx.core.request.TanxAdSlot r1 = r16.getAdSlot()     // Catch: java.lang.Exception -> L5d
            java.lang.String r1 = r1.getPid()     // Catch: java.lang.Exception -> L5d
            goto L14
        L13:
            r1 = r0
        L14:
            java.lang.String r2 = r16.getRequestId()     // Catch: java.lang.Exception -> L5d
            com.alimm.tanx.core.ad.bean.BidInfo r3 = r16.getBidInfo()     // Catch: java.lang.Exception -> L5d
            if (r3 == 0) goto L5b
            com.alimm.tanx.core.ad.bean.BidInfo r3 = r16.getBidInfo()     // Catch: java.lang.Exception -> L5d
            java.lang.String r3 = r3.getCreativeId()     // Catch: java.lang.Exception -> L5d
            com.alimm.tanx.core.ad.bean.BidInfo r4 = r16.getBidInfo()     // Catch: java.lang.Exception -> L5d
            java.lang.String r4 = r4.getTemplateId()     // Catch: java.lang.Exception -> L5d
            com.alimm.tanx.core.ad.bean.BidInfo r5 = r16.getBidInfo()     // Catch: java.lang.Exception -> L5d
            java.lang.String r5 = r5.getSessionId()     // Catch: java.lang.Exception -> L5d
            com.alimm.tanx.core.ad.bean.BidInfo r6 = r16.getBidInfo()     // Catch: java.lang.Exception -> L5d
            com.alimm.tanx.core.ad.bean.TemplateConfig r6 = r6.getTemplateConf()     // Catch: java.lang.Exception -> L5d
            if (r6 == 0) goto L64
            com.alimm.tanx.core.ad.bean.BidInfo r6 = r16.getBidInfo()     // Catch: java.lang.Exception -> L5d
            com.alimm.tanx.core.ad.bean.TemplateConfig r6 = r6.getTemplateConf()     // Catch: java.lang.Exception -> L5d
            java.lang.String r6 = r6.getPidStyleId()     // Catch: java.lang.Exception -> L5d
            if (r6 == 0) goto L64
            com.alimm.tanx.core.ad.bean.BidInfo r0 = r16.getBidInfo()     // Catch: java.lang.Exception -> L5d
            com.alimm.tanx.core.ad.bean.TemplateConfig r0 = r0.getTemplateConf()     // Catch: java.lang.Exception -> L5d
            java.lang.String r0 = r0.getPidStyleId()     // Catch: java.lang.Exception -> L5d
            goto L64
        L5b:
            r3 = r0
            goto L62
        L5d:
            r0 = move-exception
            goto L8d
        L5f:
            r1 = r0
            r2 = r1
            r3 = r2
        L62:
            r4 = r3
            r5 = r4
        L64:
            r13 = r0
            r9 = r1
            r10 = r2
            r15 = r5
            java.util.Map r14 = com.alimm.tanx.core.ut.impl.TanxBaseUt.buildArgs(r9, r10, r3, r4)     // Catch: java.lang.Exception -> L5d
            com.alimm.tanx.core.orange.OrangeManager r0 = com.alimm.tanx.core.orange.OrangeManager.getInstance()     // Catch: java.lang.Exception -> L5d
            java.lang.String r1 = "antiCheatingSwitch"
            boolean r0 = r0.getCommonSwitch(r1)     // Catch: java.lang.Exception -> L5d
            if (r0 == 0) goto L7f
            java.lang.String r0 = "sensor_list"
            r1 = r17
            r14.put(r0, r1)     // Catch: java.lang.Exception -> L5d
        L7f:
            r8 = 1
            com.alimm.tanx.core.ut.AdUtConstants r0 = com.alimm.tanx.core.ut.AdUtConstants.SHAKE_DESTROY     // Catch: java.lang.Exception -> L5d
            java.lang.String r11 = r0.arg1     // Catch: java.lang.Exception -> L5d
            int r7 = r0.eventId     // Catch: java.lang.Exception -> L5d
            java.lang.String r12 = ""
            r6 = r11
            com.alimm.tanx.core.ut.impl.TanxBaseUt.send(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)     // Catch: java.lang.Exception -> L5d
            goto L90
        L8d:
            com.alimm.tanx.core.utils.LogUtils.e(r0)
        L90:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alimm.tanx.core.ut.impl.TanxCommonUt.utShakeDestroy(com.alimm.tanx.core.ad.ITanxAd, java.lang.String):void");
    }

    public static void utTimer(ITanxAd iTanxAd, boolean z10, int i10) {
        HashMap hashMap = new HashMap();
        hashMap.put("is_suc", z10 ? "1" : "0");
        sendUt(iTanxAd, AdUtConstants.AD_TIMER, hashMap, i10);
    }

    public static void utWebStartLoad(ITanxAd iTanxAd) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6 = "";
        if (iTanxAd != null) {
            str = iTanxAd.getAdSlot() != null ? iTanxAd.getAdSlot().getPid() : "";
            str2 = iTanxAd.getRequestId();
            if (iTanxAd.getBidInfo() != null) {
                str3 = iTanxAd.getBidInfo().getCreativeId();
                str4 = iTanxAd.getBidInfo().getTemplateId();
                str5 = iTanxAd.getBidInfo().getSessionId();
                if (iTanxAd.getBidInfo().getTemplateConf() != null && iTanxAd.getBidInfo().getTemplateConf().getPidStyleId() != null) {
                    str6 = iTanxAd.getBidInfo().getTemplateConf().getPidStyleId();
                }
                String str7 = str;
                String str8 = str2;
                Map<String, Object> buildArgs = TanxBaseUt.buildArgs(str7, str8, str3, str4);
                AdUtConstants adUtConstants = AdUtConstants.WEB_START_LOAD;
                String str9 = adUtConstants.arg1;
                TanxBaseUt.send(str9, adUtConstants.eventId, 1, str7, str8, str9, "", str6, buildArgs, str5);
            }
            str3 = "";
        } else {
            str = "";
            str2 = str;
            str3 = str2;
        }
        str4 = str3;
        str5 = str4;
        String str72 = str;
        String str82 = str2;
        Map<String, Object> buildArgs2 = TanxBaseUt.buildArgs(str72, str82, str3, str4);
        AdUtConstants adUtConstants2 = AdUtConstants.WEB_START_LOAD;
        String str92 = adUtConstants2.arg1;
        TanxBaseUt.send(str92, adUtConstants2.eventId, 1, str72, str82, str92, "", str6, buildArgs2, str5);
    }

    public static void sendIntoMethod(TanxAdSlot tanxAdSlot, String str, IBidInfo iBidInfo, String str2, AdUtConstants adUtConstants, Map<String, String> map) {
        String pid = tanxAdSlot != null ? tanxAdSlot.getPid() : "";
        Map<String, Object> buildArgs = TanxBaseUt.buildArgs(pid, str, iBidInfo.getCreativeId(), iBidInfo.getTemplateId());
        if (map != null) {
            buildArgs.putAll(map);
        }
        buildArgs.put("method_name", str2);
        String str3 = adUtConstants.arg1;
        TanxBaseUt.send(str3, adUtConstants.eventId, pid, str, str3, buildArgs, iBidInfo.getSessionId());
    }
}
