package com.alimm.tanx.core.ut.impl;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alimm.tanx.core.TanxCoreManager;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.alimm.tanx.core.ad.interaction.AdClickInfo;
import com.alimm.tanx.core.ad.listener.ut.ITanxUserTracker;
import com.alimm.tanx.core.orange.OrangeManager;
import com.alimm.tanx.core.ut.AdUtConstants;
import com.alimm.tanx.core.ut.BiddingBean;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.bean.UtAntiCheat;
import com.alimm.tanx.core.ut.bean.UtErrorBean;
import com.alimm.tanx.core.ut.bean.UtItemH5Bean;
import com.alimm.tanx.core.utils.AntiCheatUtil;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NotConfused;
import com.alimm.tanx.core.utils.SysUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import uc.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class TanxBaseUt implements NotConfused {
    public static void biddingResult(List<ITanxAd> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        HashMap hashMap = new HashMap();
        StringBuilder sb2 = new StringBuilder();
        int i10 = 0;
        sb2.append(list.get(0).getScene());
        sb2.append("");
        hashMap.put("scenes", sb2.toString());
        ArrayList arrayList = new ArrayList();
        String str = "";
        String str2 = str;
        int i11 = 0;
        for (ITanxAd iTanxAd : list) {
            BiddingBean biddingBean = new BiddingBean();
            if (iTanxAd != null) {
                str = iTanxAd.getAdSlot() != null ? iTanxAd.getAdSlot().getPid() : "";
                biddingBean.setPid(str);
                str2 = iTanxAd.getRequestId();
                if (iTanxAd.getBidInfo() != null) {
                    biddingBean.setReqId(iTanxAd.getRequestId());
                    biddingBean.setCreative_id(iTanxAd.getBidInfo().getCreativeId());
                    biddingBean.setTemplate_id(iTanxAd.getBidInfo().getTemplateId());
                    biddingBean.setSessionId(iTanxAd.getBidInfo().getSessionId());
                }
                if (iTanxAd.getBiddingInfo() != null) {
                    if (iTanxAd.getBiddingInfo().isBidResult()) {
                        i10++;
                    } else {
                        i11++;
                    }
                    biddingBean.setIs_suc(iTanxAd.getBiddingInfo().isBidResult() ? "1" : "0");
                    biddingBean.setPrice(iTanxAd.getBiddingInfo().getAdPrice() + "");
                }
            }
            arrayList.add(biddingBean);
        }
        hashMap.put("createList", arrayList);
        AdUtConstants adUtConstants = AdUtConstants.BIDDING_CHECK;
        String str3 = adUtConstants.arg1;
        send(str3, adUtConstants.eventId, str, str2, str3, i10 + "", i11 + "", hashMap, "");
    }

    public static Map<String, Object> buildAntiCheatParam(Map<String, Object> map) {
        if (OrangeManager.getInstance().getCommonSwitch("antiCheatingSwitch")) {
            UtAntiCheat utAntiCheat = new UtAntiCheat();
            utAntiCheat.currentVolume = AntiCheatUtil.getInstance().getCurrentVolume(TanxCoreSdk.getApplication());
            utAntiCheat.battery = AntiCheatUtil.getInstance().getBatteryPercentage(TanxCoreSdk.getApplication());
            utAntiCheat.charge = AntiCheatUtil.getInstance().isCharging(TanxCoreSdk.getApplication());
            utAntiCheat.systemAlertPermissions = AntiCheatUtil.getInstance().isSystemAlertPermissions(TanxCoreSdk.getApplication());
            utAntiCheat.accessibilityEnabled = AntiCheatUtil.getInstance().accessibilityEnabled(TanxCoreSdk.getApplication());
            if (map == null) {
                map = new HashMap<>();
            }
            map.put("af", JSON.toJSONString(utAntiCheat));
        }
        return map;
    }

    public static Map<String, Object> buildArgs(String str) {
        return buildArgs(str, null, null, null);
    }

    public static void h5Ut(UtItemH5Bean utItemH5Bean) {
        track(utItemH5Bean.page, utItemH5Bean.pid, utItemH5Bean.reqId, utItemH5Bean.eventId, utItemH5Bean.eventStatus, utItemH5Bean.arg1, utItemH5Bean.arg2, utItemH5Bean.arg3, utItemH5Bean.args, "");
    }

    public static void send(String str, int i10, String str2, String str3, int i11, String str4, Map<String, Object> map, String str5) {
        track(str, str2, str3, i10, i11, str4, null, null, map, str5);
    }

    public static void shake(String str, BidInfo bidInfo, HashMap<String, Object> hashMap) {
        HashMap<String, Object> hashMap2;
        String str2;
        String str3;
        if (bidInfo != null) {
            String str4 = bidInfo.getId() + "";
            String creativeId = bidInfo.getCreativeId();
            String str5 = bidInfo.getOpenType() + "";
            String templateId = bidInfo.getTemplateId();
            String sessionId = bidInfo.getSessionId();
            Map<String, Object> buildArgs = buildArgs("", str4, creativeId, templateId);
            if (hashMap == null) {
                hashMap = new HashMap<>();
            }
            hashMap.putAll(buildArgs);
            hashMap.put("appId", TanxCoreSdk.getConfig() != null ? TanxCoreSdk.getConfig().getAppId() : "");
            hashMap.put("reqId", str4);
            hashMap.put("openType", str5);
            hashMap.put("creativeId", creativeId);
            str3 = sessionId;
            hashMap2 = hashMap;
            str2 = str4;
        } else {
            hashMap2 = hashMap;
            str2 = "";
            str3 = str2;
        }
        AdUtConstants adUtConstants = AdUtConstants.SHAKE;
        String str6 = adUtConstants.arg1;
        send(str6, adUtConstants.eventId, "", str2, str6, null, str, hashMap2, str3);
    }

    public static void track(String str, String str2, String str3, int i10, int i11, String str4, String str5, String str6, Map<String, Object> map, String str7) {
        a userTracker = TanxCoreManager.getInstance().getUserTracker();
        ITanxUserTracker tanxUserTracker = TanxCoreManager.getInstance().getTanxUserTracker();
        if (userTracker != null) {
            userTracker.a(str, i10, str4, str5, str6, map);
        } else if (tanxUserTracker != null) {
            tanxUserTracker.track(str, str2, str3, i10, i11, str4, str5, str6, map, str7);
        }
    }

    public static void utClick(AdClickInfo adClickInfo, boolean z10, String str, String str2, String str3) {
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        if (adClickInfo != null) {
            String pid = adClickInfo.getTanxAdSlot() != null ? adClickInfo.getTanxAdSlot().getPid() : "";
            if (adClickInfo.getTanxAdSlot() != null) {
                str4 = adClickInfo.getTanxAdSlot().getAdType() + "";
            } else {
                str4 = "";
            }
            String reqId = adClickInfo.getReqId();
            if (adClickInfo.getBidInfo() != null) {
                str5 = adClickInfo.getBidInfo().getCreativeId();
                str6 = adClickInfo.getBidInfo().getOpenType() + "";
                str7 = adClickInfo.getBidInfo().getTemplateId();
                String sessionId = adClickInfo.getBidInfo().getSessionId();
                str8 = (adClickInfo.getBidInfo().getTemplateConf() == null || adClickInfo.getBidInfo().getTemplateConf().getPidStyleId() == null) ? "" : adClickInfo.getBidInfo().getTemplateConf().getPidStyleId();
                str9 = sessionId;
            } else {
                str5 = "";
                str6 = str5;
                str7 = str6;
                str8 = str7;
                str9 = str8;
            }
            Map<String, Object> buildArgs = buildArgs(pid, reqId, str5, str7);
            buildArgs.putAll(adClickInfo.getUtArgs());
            buildArgs.put("adType", str4);
            buildArgs.put("dpUrlNull", Integer.valueOf(TextUtils.isEmpty(str2) ? 1 : 0));
            buildArgs.put("h5UrlNull", Integer.valueOf(TextUtils.isEmpty(str3) ? 1 : 0));
            buildArgs.put("openType", str6);
            buildArgs.put("pidStyleId", str8);
            String obj = SysUtils.getInstallStatus().toString();
            if (z10) {
                AdUtConstants adUtConstants = AdUtConstants.DEEP_LINK_OPEN;
                String str10 = adUtConstants.arg1;
                send(str10, adUtConstants.eventId, pid, reqId, str10, obj, "", buildArgs, str9);
                return;
            }
            buildArgs.put("dpUrl", str2 + "");
            buildArgs.put("h5Url", str3 + "");
            AdUtConstants adUtConstants2 = AdUtConstants.LANDING_H5;
            String str11 = adUtConstants2.arg1;
            send(str11, adUtConstants2.eventId, pid, reqId, str11, obj, "", buildArgs, str9);
        }
    }

    public static void utError(int i10, Exception exc) {
        utError(i10, exc, "");
    }

    public static void utErrorCode(ITanxAd iTanxAd, UtErrorCode utErrorCode) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        if (utErrorCode == null) {
            return;
        }
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
        Map<String, Object> buildArgs = buildArgs(str3, str4, str, str2);
        AdUtConstants adUtConstants = AdUtConstants.SDK_ERROR_CODE;
        send(adUtConstants.arg1, adUtConstants.eventId, str3, str4, utErrorCode.getIntCode(), utErrorCode.getMsg(), buildArgs, str5);
    }

    public static void utNavigate(AdClickInfo adClickInfo, String str, String str2, String str3, String str4) {
        String str5;
        String str6;
        String str7;
        String str8;
        if (adClickInfo != null) {
            String str9 = "";
            String pid = adClickInfo.getTanxAdSlot() != null ? adClickInfo.getTanxAdSlot().getPid() : "";
            String reqId = adClickInfo.getReqId();
            if (adClickInfo.getBidInfo() != null) {
                String creativeId = adClickInfo.getBidInfo().getCreativeId();
                str6 = adClickInfo.getBidInfo().getOpenType() + "";
                str7 = adClickInfo.getBidInfo().getTemplateId();
                String sessionId = adClickInfo.getBidInfo().getSessionId();
                if (adClickInfo.getBidInfo().getTemplateConf() != null && adClickInfo.getBidInfo().getTemplateConf().getPidStyleId() != null) {
                    str9 = adClickInfo.getBidInfo().getTemplateConf().getPidStyleId();
                }
                str8 = sessionId;
                String str10 = str9;
                str9 = creativeId;
                str5 = str10;
            } else {
                str5 = "";
                str6 = str5;
                str7 = str6;
                str8 = str7;
            }
            Map<String, Object> buildArgs = buildArgs(pid, reqId, str9, str7);
            buildArgs.putAll(adClickInfo.getUtArgs());
            buildArgs.put("dpUrlNull", Integer.valueOf(TextUtils.isEmpty(str3) ? 1 : 0));
            buildArgs.put("h5UrlNull", Integer.valueOf(TextUtils.isEmpty(str4) ? 1 : 0));
            buildArgs.put("openType", str6);
            buildArgs.put("pidStyleId", str5);
            send(adClickInfo.getAdUtConstants().arg1, adClickInfo.getAdUtConstants().eventId, pid, reqId, adClickInfo.getAdUtConstants().arg1, SysUtils.getInstallStatus().toString(), str, buildArgs, str8);
        }
    }

    public static void utNetError(int i10, String str, UtErrorBean utErrorBean, String str2) {
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str2)) {
            str2 = "main";
        }
        hashMap.put("taskName", str2);
        hashMap.put("msg", utErrorBean.toString());
        hashMap.put("tag", str);
        if (hashMap.get("msg") == 0 || !hashMap.get("msg").toString().contains("Unable to resolve host")) {
            AdUtConstants adUtConstants = AdUtConstants.EXCEPTION_MSG;
            String str3 = adUtConstants.arg1;
            send(str3, adUtConstants.eventId, "", "", i10, str3, hashMap, "");
        }
    }

    public static Map<String, Object> buildArgs(String str, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        hashMap.put(ExposeManager.UtArgsNames.templateId, str4);
        hashMap.put(ExposeManager.UtArgsNames.creativeId, str3);
        return hashMap;
    }

    public static void send(String str, int i10, String str2, String str3, int i11, String str4, String str5, String str6, Map<String, Object> map, String str7) {
        track(str, str2, str3, i10, i11, str4, str5, str6, map, str7);
    }

    public static void utError(int i10, Exception exc, String str) {
        utError(i10, "", exc, str);
    }

    public static void send(String str, int i10, int i11, String str2, String str3, String str4, String str5, String str6, Map<String, Object> map, String str7) {
        track(str, str2, str3, i10, i11, str4, str5, str6, map, str7);
    }

    public static void utError(int i10, String str, Exception exc, String str2) {
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str2)) {
            str2 = "main";
        }
        hashMap.put("taskName", str2);
        hashMap.put("msg", LogUtils.getStackTraceMessage(exc));
        hashMap.put("tag", str);
        if (hashMap.get("msg") == 0 || !hashMap.get("msg").toString().contains("Unable to resolve host")) {
            AdUtConstants adUtConstants = AdUtConstants.EXCEPTION_MSG;
            String str3 = adUtConstants.arg1;
            send(str3, adUtConstants.eventId, "", "", i10, str3, hashMap, "");
        }
    }

    public static void send(String str, int i10, String str2, String str3, String str4, Map<String, Object> map, String str5) {
        track(str, str2, str3, i10, 0, str4, null, null, map, str5);
    }

    public static void send(String str, int i10, String str2, String str3, String str4, String str5, String str6, Map<String, Object> map, String str7) {
        track(str, str2, str3, i10, 0, str4, str5, str6, map, str7);
    }

    public static void send(String str, int i10, int i11, String str2, Map<String, Object> map, String str3) {
        track(str, "", "", i10, i11, str2, null, null, map, str3);
    }

    public static void utError(int i10, String str, String str2, String str3) {
        utError(i10, str, str2, str3, "", "", "", "");
    }

    public static void utError(int i10, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        HashMap hashMap = new HashMap();
        hashMap.put("taskName", TextUtils.isEmpty(str3) ? "main" : str3);
        hashMap.put("msg", str2);
        hashMap.put("tag", str);
        if (hashMap.get("msg") == 0 || !hashMap.get("msg").toString().contains("Unable to resolve host")) {
            AdUtConstants adUtConstants = AdUtConstants.EXCEPTION_MSG;
            String str8 = adUtConstants.arg1;
            send(str8, adUtConstants.eventId, str4, str5, i10, str8, str6, str7, hashMap, "");
        }
    }
}
