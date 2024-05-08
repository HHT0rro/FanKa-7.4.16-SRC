package com.jd.ad.sdk.jad_jt;

import android.app.Application;
import android.content.ContentResolver;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.huawei.quickcard.framework.QuickCardField;
import com.jd.ad.sdk.bl.adload.JADAdLoadListener;
import com.jd.ad.sdk.bl.dynamicrender.DynamicRenderTemplateHelper;
import com.jd.ad.sdk.bl.initsdk.JADPrivateController;
import com.jd.ad.sdk.bl.initsdk.JADYunSdk;
import com.jd.ad.sdk.dl.error.JADError;
import com.jd.ad.sdk.dl.model.JADExtra;
import com.jd.ad.sdk.dl.model.JADSlot;
import com.jd.ad.sdk.fdt.utils.JsonUtils;
import com.jd.ad.sdk.jad_js.jad_na;
import com.jd.ad.sdk.jad_kv.jad_ly;
import com.jd.ad.sdk.jad_kx.jad_er;
import com.jd.ad.sdk.jad_ly.jad_bo;
import com.jd.ad.sdk.jad_ly.jad_cp;
import com.jd.ad.sdk.jad_mz.jad_dq;
import com.jd.ad.sdk.logger.Logger;
import com.jd.ad.sdk.mdt.service.JADEventService;
import com.jd.ad.sdk.mdt.servicemediator.JADMediator;
import com.kuaishou.weapon.p0.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: JADLoader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_jt {
    public int jad_an = 0;
    public DynamicRenderTemplateHelper jad_bo = null;

    /* JADX WARN: Removed duplicated region for block: B:17:0x00a5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void jad_an(com.jd.ad.sdk.jad_jt.jad_jt r7, com.jd.ad.sdk.dl.model.JADSlot r8) {
        /*
            r7.getClass()
            boolean r0 = r8.isFromNativeAd()
            r1 = 2
            r2 = 0
            if (r0 == 0) goto Lf
            r8.setRem(r1)
            goto L63
        Lf:
            int r0 = r8.getAdType()
            monitor-enter(r7)
            com.jd.ad.sdk.jad_na.jad_an r3 = com.jd.ad.sdk.jad_pc.jad_an.jad_an()     // Catch: java.lang.Throwable -> Lc6
            r4 = 1
            if (r3 == 0) goto L28
            java.lang.String r5 = "1"
            java.lang.String r3 = r3.jad_mz     // Catch: java.lang.Throwable -> Lc6
            boolean r3 = r5.equals(r3)     // Catch: java.lang.Throwable -> Lc6
            if (r3 == 0) goto L28
            monitor-exit(r7)
            r0 = 1
            goto L2e
        L28:
            if (r4 == r0) goto L2c
            r0 = 1
            goto L2d
        L2c:
            r0 = 0
        L2d:
            monitor-exit(r7)
        L2e:
            if (r0 != 0) goto L60
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = com.jd.ad.sdk.bl.initsdk.JADYunSdk.getAppId()
            r0.append(r3)
            java.lang.String r3 = r8.getSlotID()
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            com.jd.ad.sdk.bl.dynamicrender.DynamicRenderTemplateHelper r3 = r7.jad_bo
            if (r3 != 0) goto L56
            com.jd.ad.sdk.bl.dynamicrender.DynamicRenderTemplateHelper r3 = new com.jd.ad.sdk.bl.dynamicrender.DynamicRenderTemplateHelper
            android.app.Application r4 = com.jd.ad.sdk.jad_do.jad_bo.jad_an()
            r3.<init>(r4, r0)
            r7.jad_bo = r3
        L56:
            com.jd.ad.sdk.bl.dynamicrender.DynamicRenderTemplateHelper r0 = r7.jad_bo
            r8.setDynamicRenderTemplateHelper(r0)
            r0 = 3
            r8.setRem(r0)
            goto L63
        L60:
            r8.setRem(r4)
        L63:
            float r0 = r8.getWidth()     // Catch: java.lang.Exception -> L8f
            int r0 = java.lang.Math.round(r0)     // Catch: java.lang.Exception -> L8f
            float r3 = r8.getHeight()     // Catch: java.lang.Exception -> L8e
            int r2 = java.lang.Math.round(r3)     // Catch: java.lang.Exception -> L8e
            int r3 = r8.getRem()     // Catch: java.lang.Exception -> L8a
            if (r3 != r1) goto L93
            float r1 = r8.getAdImageWidth()     // Catch: java.lang.Exception -> L8a
            int r0 = java.lang.Math.round(r1)     // Catch: java.lang.Exception -> L8a
            float r1 = r8.getAdImageHeight()     // Catch: java.lang.Exception -> L8a
            int r2 = java.lang.Math.round(r1)     // Catch: java.lang.Exception -> L8a
            goto L93
        L8a:
            r6 = r2
            r2 = r0
            r0 = r6
            goto L90
        L8e:
            r2 = r0
        L8f:
            r0 = 0
        L90:
            r6 = r2
            r2 = r0
            r0 = r6
        L93:
            float r0 = (float) r0
            r8.setAdImageWidth(r0)
            float r0 = (float) r2
            r8.setAdImageHeight(r0)
            r8.getSlotID()
            r8.getAdType()
            r8.isFromNativeAd()
            monitor-enter(r7)
            com.jd.ad.sdk.dl.common.CommonConstants$AdTmp r0 = com.jd.ad.sdk.dl.common.CommonConstants.AdTmp.TEMPLATE_UNKNOWN     // Catch: java.lang.Throwable -> Lc3
            int r0 = r0.getTemplateId()     // Catch: java.lang.Throwable -> Lc3
            monitor-exit(r7)
            r8.setTemplateId(r0)
            com.jd.ad.sdk.mdt.servicemediator.JADMediator r7 = com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance()
            com.jd.ad.sdk.mdt.service.JADInitService r7 = r7.getInitService()
            java.lang.String r0 = r8.getSlotID()
            int r7 = r7.getSen(r0)
            r8.setSen(r7)
            return
        Lc3:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        Lc6:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_jt.jad_jt.jad_an(com.jd.ad.sdk.jad_jt.jad_jt, com.jd.ad.sdk.dl.model.JADSlot):void");
    }

    public static void jad_bo(jad_jt jad_jtVar, JADSlot jADSlot) {
        jad_jtVar.getClass();
        if (jADSlot == null) {
            return;
        }
        jADSlot.setLoadSucTime(System.currentTimeMillis());
        String requestId = jADSlot.getRequestId();
        String slotID = jADSlot.getSlotID();
        int adType = jADSlot.getAdType();
        int sen = jADSlot.getSen();
        int rem = jADSlot.getRem();
        int templateId = jADSlot.getTemplateId();
        long loadSucTime = jADSlot.getLoadSucTime() - jADSlot.getLoadTime();
        int eventInteractionType = jADSlot.getEventInteractionType();
        int modelClickAreaType = jADSlot.getModelClickAreaType();
        int mediaSpecSetType = jADSlot.getMediaSpecSetType();
        int ds = JADMediator.getInstance().getInitService().getDs(jADSlot.getSlotID());
        int r10 = JADMediator.getInstance().getInitService().getR(jADSlot.getSlotID());
        if (jADSlot.getAdDataRequestSourceType() != 1 && jADSlot.getAdDataRequestSourceType() != 2) {
            JADMediator.getInstance().getEventService().reportResponseEvent(requestId, slotID, adType, templateId, sen, rem, loadSucTime, eventInteractionType, modelClickAreaType, mediaSpecSetType, ds, r10);
        } else {
            JADMediator.getInstance().getEventService().reportPreloadResponseEvent(requestId, slotID, adType, templateId, sen, rem, loadSucTime, eventInteractionType, modelClickAreaType, mediaSpecSetType, ds, r10);
        }
    }

    public static void jad_an(jad_jt jad_jtVar, JADSlot jADSlot, String str) {
        Application jad_an;
        Application jad_an2;
        Map<String, jad_na> jad_an3;
        jad_na jad_naVar;
        jad_jtVar.getClass();
        String str2 = JADYunSdk.getAppId() + jADSlot.getSlotID();
        com.jd.ad.sdk.jad_kx.jad_er jad_erVar = jad_er.jad_an.jad_an;
        if (jad_erVar.jad_bo(str2)) {
            return;
        }
        com.jd.ad.sdk.jad_kx.jad_cp jad_cpVar = new com.jd.ad.sdk.jad_kx.jad_cp(0, str2, jADSlot.getRequestId(), str, System.currentTimeMillis() + "");
        com.jd.ad.sdk.jad_kx.jad_fs jad_fsVar = jad_erVar.jad_bo;
        if (jad_fsVar != null) {
            synchronized (jad_fsVar) {
                ArrayList<com.jd.ad.sdk.jad_kx.jad_cp> arrayList = jad_fsVar.jad_an.get(str2);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(jad_cpVar);
                jad_fsVar.jad_an.put(str2, arrayList);
            }
        }
        if (jad_erVar.jad_jt) {
            com.jd.ad.sdk.jad_kx.jad_an jad_anVar = jad_erVar.jad_an;
            if (jad_anVar != null) {
                jad_anVar.jad_an(jad_cpVar);
            }
        } else {
            synchronized (com.jd.ad.sdk.jad_re.jad_an.class) {
                String str3 = com.jd.ad.sdk.jad_re.jad_an.jad_bo() + "db_preload_ad/update";
                try {
                    ContentResolver jad_an4 = com.jd.ad.sdk.jad_re.jad_an.jad_an();
                    if (jad_an4 != null) {
                        jad_an4.update(Uri.parse(str3), com.jd.ad.sdk.jad_re.jad_an.jad_an(jad_cpVar), null, null);
                    }
                } catch (Throwable th) {
                    Logger.w("Exception while saving preload ad data: ", th.getMessage());
                }
            }
        }
        if (jADSlot.getDynamicRenderTemplateHelper() != null) {
            jADSlot.getDynamicRenderTemplateHelper().jad_an(str);
            String jad_bo = jad_bo.jad_an.jad_an.jad_bo(str);
            String str4 = jADSlot.getDynamicRenderTemplateHelper().jad_cp;
            if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(jad_bo)) {
                return;
            }
            try {
                Application jad_an5 = com.jd.ad.sdk.jad_do.jad_bo.jad_an();
                if (jad_an5 != null && (jad_an3 = jad_jtVar.jad_an(new JSONObject(str4), jad_bo)) != null && !jad_an3.isEmpty()) {
                    Iterator<String> iterator2 = jad_an3.h().iterator2();
                    while (iterator2.hasNext() && (jad_naVar = jad_an3.get(iterator2.next())) != null) {
                        com.jd.ad.sdk.jad_ep.jad_cp.jad_bo(jad_an5).jad_an(jad_naVar.jad_dq).jad_an(jad_ly.jad_bo).jad_bo(new jad_er(jad_jtVar)).jad_dq();
                    }
                    return;
                }
                return;
            } catch (Exception unused) {
                return;
            }
        }
        com.jd.ad.sdk.jad_ly.jad_bo jad_boVar = jad_bo.jad_an.jad_an;
        com.jd.ad.sdk.jad_wj.jad_cp jad_an6 = jad_boVar.jad_an(str);
        if ((jad_an6 != null ? jad_an6.jad_cp : 0) == 10005) {
            com.jd.ad.sdk.jad_wj.jad_fs jad_cp = jad_boVar.jad_cp(str);
            List<com.jd.ad.sdk.jad_wj.jad_er> list = jad_cp != null ? jad_cp.jad_fs : null;
            if (list == null || list.size() != 3 || (jad_an2 = com.jd.ad.sdk.jad_do.jad_bo.jad_an()) == null) {
                return;
            }
            for (int i10 = 0; i10 < list.size(); i10++) {
                if (list.get(i10) != null && !TextUtils.isEmpty(list.get(i10).jad_an)) {
                    com.jd.ad.sdk.jad_ep.jad_cp.jad_bo(jad_an2).jad_an(list.get(i10).jad_an).jad_an(jad_ly.jad_bo).jad_bo(new jad_dq(jad_jtVar)).jad_dq();
                }
            }
            return;
        }
        String jad_bo2 = jad_boVar.jad_bo(str);
        if (TextUtils.isEmpty(jad_bo2) || (jad_an = com.jd.ad.sdk.jad_do.jad_bo.jad_an()) == null) {
            return;
        }
        com.jd.ad.sdk.jad_ep.jad_cp.jad_bo(jad_an).jad_an(jad_bo2).jad_an(jad_ly.jad_bo).jad_bo(new jad_cp(jad_jtVar)).jad_dq();
    }

    public static void jad_an(jad_jt jad_jtVar, String str, String str2) {
        com.jd.ad.sdk.jad_wj.jad_hu jad_huVar;
        List<com.jd.ad.sdk.jad_wj.jad_dq> list;
        com.jd.ad.sdk.jad_wj.jad_dq jad_dqVar;
        jad_jtVar.getClass();
        JADExtra jADExtra = new JADExtra();
        com.jd.ad.sdk.jad_wj.jad_jt jad_jtVar2 = null;
        if (!TextUtils.isEmpty(str2)) {
            try {
                jad_jtVar2 = com.jd.ad.sdk.jad_wj.jad_jt.jad_an(str2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        jADExtra.setPrice((jad_jtVar2 == null || (jad_huVar = jad_jtVar2.jad_cp) == null || (list = jad_huVar.jad_an) == null || list.isEmpty() || (jad_dqVar = list.get(0)) == null) ? ShadowDrawableWrapper.COS_45 : jad_dqVar.jad_an);
        com.jd.ad.sdk.jad_ly.jad_cp jad_cpVar = jad_cp.jad_an.jad_an;
        jad_cpVar.jad_bo.put(str, jADExtra);
        jad_cpVar.jad_an.put(str, str2);
    }

    public static void jad_an(jad_jt jad_jtVar, JADAdLoadListener jADAdLoadListener, int i10) {
        jad_jtVar.getClass();
        if (jADAdLoadListener == null) {
            return;
        }
        if (i10 == 2) {
            if (jad_jtVar.jad_an != 1) {
                jad_jtVar.jad_an = 2;
                jADAdLoadListener.onLoadSuccess();
                return;
            }
            return;
        }
        if (jad_jtVar.jad_an != 2) {
            jad_jtVar.jad_an = 1;
            jADAdLoadListener.onLoadSuccess();
        }
    }

    public final boolean jad_an(@NonNull JADSlot jADSlot, @NonNull JADAdLoadListener jADAdLoadListener) {
        int i10;
        int i11;
        com.jd.ad.sdk.jad_uh.jad_an jad_anVar;
        if (TextUtils.isEmpty(jADSlot.getSlotID())) {
            JADEventService eventService = JADMediator.getInstance().getEventService();
            String requestId = jADSlot.getRequestId();
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar2 = com.jd.ad.sdk.jad_uh.jad_an.GW_REQUEST_SLOT_ID_IS_NULL_ERROR;
            eventService.reportRequestErrorEvent(requestId, jad_anVar2.jad_an, jad_an(jADSlot.getSlotID(), jADSlot.getAdType(), jad_anVar2.jad_an(new String[0])));
            jad_an(jADAdLoadListener, jad_anVar2.jad_an, jad_anVar2.jad_an(new String[0]));
            return false;
        }
        if (jADSlot.getAdDataRequestSourceType() == 1) {
            com.jd.ad.sdk.jad_na.jad_an jad_an = com.jd.ad.sdk.jad_pc.jad_an.jad_an();
            if (jad_an != null && jad_an.jad_na == 1) {
                JADEventService eventService2 = JADMediator.getInstance().getEventService();
                String requestId2 = jADSlot.getRequestId();
                com.jd.ad.sdk.jad_uh.jad_an jad_anVar3 = com.jd.ad.sdk.jad_uh.jad_an.GW_REQUEST_FORBID_PRELOAD_ERROR;
                eventService2.reportExceptionEvent(requestId2, jad_anVar3.jad_an, jad_anVar3.jad_an(new String[0]));
                Logger.d("preload 禁用预加载接口功能 - 中断网络请求");
                return false;
            }
            if (jad_er.jad_an.jad_an.jad_bo(JADYunSdk.getAppId() + jADSlot.getSlotID())) {
                JADEventService eventService3 = JADMediator.getInstance().getEventService();
                String requestId3 = jADSlot.getRequestId();
                com.jd.ad.sdk.jad_uh.jad_an jad_anVar4 = com.jd.ad.sdk.jad_uh.jad_an.GW_REQUEST_PRELOAD_AD_DARA_EXCEEDED_UPPER_LIMIT_ERROR;
                eventService3.reportRequestErrorEvent(requestId3, jad_anVar4.jad_an, jad_an(jADSlot.getSlotID(), jADSlot.getAdType(), jad_anVar4.jad_an(new String[0])));
                jad_an(jADAdLoadListener, jad_anVar4.jad_an, jad_anVar4.jad_an(new String[0]));
                return false;
            }
        }
        int adType = jADSlot.getAdType();
        String slotID = jADSlot.getSlotID();
        boolean isFromNativeAd = jADSlot.isFromNativeAd();
        com.jd.ad.sdk.jad_mz.jad_dq jad_dqVar = jad_dq.jad_an.jad_an;
        boolean jad_an2 = jad_dqVar.jad_an(jad_dqVar.jad_an(isFromNativeAd, adType), slotID);
        char c4 = 2;
        if (jad_an2) {
            int adType2 = jADSlot.getAdType();
            boolean isFromNativeAd2 = jADSlot.isFromNativeAd();
            synchronized (this) {
                if (adType2 != 1) {
                    c4 = adType2 != 2 ? adType2 != 4 ? adType2 != 5 ? (char) 65535 : isFromNativeAd2 ? '\b' : (char) 4 : isFromNativeAd2 ? (char) 7 : (char) 3 : isFromNativeAd2 ? '\t' : (char) 5;
                } else if (isFromNativeAd2) {
                    c4 = 6;
                }
                switch (c4) {
                    case 2:
                        jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.GW_REQUEST_TEMPLATE_SPLASH_FORBIDDEN_ERROR;
                        break;
                    case 3:
                        jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.GW_REQUEST_TEMPLATE_INTERSTITIAL_FORBIDDEN_ERROR;
                        break;
                    case 4:
                        jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.GW_REQUEST_TEMPLATE_BANNER_FORBIDDEN_ERROR;
                        break;
                    case 5:
                        jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.GW_REQUEST_TEMPLATE_FEED_FORBIDDEN_ERROR;
                        break;
                    case 6:
                        jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.GW_REQUEST_NATIVE_SPLASH_FORBIDDEN_ERROR;
                        break;
                    case 7:
                        jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.GW_REQUEST_NATIVE_INTERSTITIAL_FORBIDDEN_ERROR;
                        break;
                    case '\b':
                        jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.GW_REQUEST_NATIVE_BANNER_FORBIDDEN_ERROR;
                        break;
                    case '\t':
                        jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.GW_REQUEST_NATIVE_FEED_FORBIDDEN_ERROR;
                        break;
                    default:
                        jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.GW_REQUEST_FORBIDDEN_ERROR;
                        break;
                }
            }
            JADMediator.getInstance().getEventService().reportRequestErrorEvent(jADSlot.getRequestId(), jad_anVar.jad_an, jad_an(jADSlot.getSlotID(), jADSlot.getAdType(), jad_anVar.jad_an(new String[0])));
            jad_an(jADAdLoadListener, jad_anVar.jad_an, jad_anVar.jad_an(new String[0]));
            return false;
        }
        JADPrivateController privateController = JADYunSdk.getPrivateController();
        if (privateController == null) {
            Logger.w("oaid获取不正常，请注意实现oaid接口", new Object[0]);
        } else if (TextUtils.isEmpty(privateController.getOaid())) {
            Logger.w("oaid获取不正常，请注意实现oaid接口", new Object[0]);
        } else {
            Logger.i("oaid获取正常", new Object[0]);
        }
        try {
            i10 = Math.round(jADSlot.getWidth());
        } catch (Exception unused) {
            i10 = 0;
        }
        try {
            i11 = Math.round(jADSlot.getHeight());
            try {
                if (jADSlot.isFromNativeAd()) {
                    i10 = Math.round(jADSlot.getAdImageWidth());
                    i11 = Math.round(jADSlot.getAdImageHeight());
                }
            } catch (Exception unused2) {
            }
        } catch (Exception unused3) {
            i11 = 0;
            if (i10 <= 0) {
            }
            JADEventService eventService4 = JADMediator.getInstance().getEventService();
            String requestId4 = jADSlot.getRequestId();
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar5 = com.jd.ad.sdk.jad_uh.jad_an.GW_REQUEST_SIZE_ERROR;
            int i12 = jad_anVar5.jad_an;
            String slotID2 = jADSlot.getSlotID();
            int adType3 = jADSlot.getAdType();
            JSONObject jSONObject = new JSONObject();
            JsonUtils.put(jSONObject, ExposeManager.UtArgsNames.pid, slotID2);
            JsonUtils.put(jSONObject, "adt", Integer.valueOf(adType3));
            JsonUtils.put(jSONObject, "plwd", Float.valueOf(i10));
            JsonUtils.put(jSONObject, "plht", Float.valueOf(i11));
            JsonUtils.put(jSONObject, "error", jad_anVar5.jad_an(new String[0]));
            eventService4.reportRequestErrorEvent(requestId4, i12, jSONObject.toString());
            jad_an(jADAdLoadListener, jad_anVar5.jad_an, jad_anVar5.jad_an("(" + i10 + " , " + i11 + ")"));
            return false;
        }
        if (i10 <= 0 && (jADSlot.getAdType() == 2 || i11 > 0)) {
            return true;
        }
        JADEventService eventService42 = JADMediator.getInstance().getEventService();
        String requestId42 = jADSlot.getRequestId();
        com.jd.ad.sdk.jad_uh.jad_an jad_anVar52 = com.jd.ad.sdk.jad_uh.jad_an.GW_REQUEST_SIZE_ERROR;
        int i122 = jad_anVar52.jad_an;
        String slotID22 = jADSlot.getSlotID();
        int adType32 = jADSlot.getAdType();
        JSONObject jSONObject2 = new JSONObject();
        JsonUtils.put(jSONObject2, ExposeManager.UtArgsNames.pid, slotID22);
        JsonUtils.put(jSONObject2, "adt", Integer.valueOf(adType32));
        JsonUtils.put(jSONObject2, "plwd", Float.valueOf(i10));
        JsonUtils.put(jSONObject2, "plht", Float.valueOf(i11));
        JsonUtils.put(jSONObject2, "error", jad_anVar52.jad_an(new String[0]));
        eventService42.reportRequestErrorEvent(requestId42, i122, jSONObject2.toString());
        jad_an(jADAdLoadListener, jad_anVar52.jad_an, jad_anVar52.jad_an("(" + i10 + " , " + i11 + ")"));
        return false;
    }

    public final Map<String, jad_na> jad_an(JSONObject jSONObject, String str) {
        int length;
        JSONArray jSONArray = jSONObject.getJSONArray(QuickCardField.ASSETS);
        if (jSONArray == null || (length = jSONArray.length()) == 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (int i10 = 0; i10 < length; i10++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i10);
            String optString = optJSONObject.optString(t.f36217b);
            String optString2 = optJSONObject.optString(t.f36224i);
            String optString3 = optJSONObject.optString("id");
            int optInt = optJSONObject.optInt(IAdInterListener.AdReqParam.WIDTH);
            int optInt2 = optJSONObject.optInt("h");
            if (!TextUtils.isEmpty(optString)) {
                hashMap.put(optString3, new jad_na(optInt, optInt2, optString3, optString.equals("${materialImage}") ? str : optString, optString2));
            }
        }
        return hashMap;
    }

    public final String jad_an(String str, int i10, String str2) {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.put(jSONObject, ExposeManager.UtArgsNames.pid, str);
        JsonUtils.put(jSONObject, "adt", Integer.valueOf(i10));
        JsonUtils.put(jSONObject, "error", str2);
        return jSONObject.toString();
    }

    public final void jad_an(JADAdLoadListener jADAdLoadListener, int i10, String str) {
        if (jADAdLoadListener == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = JADError.DEFAULT_ERROR.getMessage(new String[0]);
        }
        if (this.jad_an != 2) {
            jADAdLoadListener.onLoadFailure(i10, str);
        }
    }
}
