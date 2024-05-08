package com.jd.ad.sdk.jad_xg;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.jd.ad.sdk.bl.adload.JADAdLoadListener;
import com.jd.ad.sdk.dl.model.IJADExtra;
import com.jd.ad.sdk.dl.model.JADExtra;
import com.jd.ad.sdk.dl.model.JADSlot;
import com.jd.ad.sdk.fdt.thread.WorkExecutor;
import com.jd.ad.sdk.jad_kx.jad_er;
import com.jd.ad.sdk.jad_ly.jad_cp;
import com.jd.ad.sdk.logger.Logger;
import com.jd.ad.sdk.mdt.service.JADAdService;
import com.jd.ad.sdk.mdt.service.JADEventService;
import com.jd.ad.sdk.mdt.servicemediator.JADMediator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: JADAdServiceImplementor.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class jad_an implements JADAdService {
    public final ConcurrentHashMap<String, com.jd.ad.sdk.jad_jt.jad_jt> jad_an = new ConcurrentHashMap<>();
    public final ConcurrentHashMap<String, ArrayList<com.jd.ad.sdk.jad_jt.jad_jt>> jad_bo = new ConcurrentHashMap<>();

    @Override // com.jd.ad.sdk.mdt.service.JADAdService
    public boolean enablePreloadAd(@NonNull String str, @NonNull JADSlot jADSlot) {
        if (this.jad_an.get(str) == null) {
            return false;
        }
        ArrayList<com.jd.ad.sdk.jad_jt.jad_jt> arrayList = this.jad_bo.get(jADSlot.getSlotID());
        return arrayList == null || arrayList.size() < jad_er.jad_an.jad_an.jad_an();
    }

    @Override // com.jd.ad.sdk.mdt.service.JADAdService
    public IJADExtra getJADExtra(@NonNull String str) {
        IJADExtra iJADExtra = jad_cp.jad_an.jad_an.jad_bo.get(str);
        return iJADExtra == null ? new JADExtra() : iJADExtra;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0063  */
    @Override // com.jd.ad.sdk.mdt.service.JADAdService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<com.jd.ad.sdk.dl.addata.JADMaterialData> getJADMaterialDataList(@androidx.annotation.NonNull java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 227
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_xg.jad_an.getJADMaterialDataList(java.lang.String):java.util.List");
    }

    @Override // com.jd.ad.sdk.mdt.service.JADAdService
    public void loadAd(@NonNull String str, @NonNull JADSlot jADSlot, @NonNull JADAdLoadListener jADAdLoadListener) {
        com.jd.ad.sdk.jad_jt.jad_jt jad_jtVar = this.jad_an.get(str);
        if (jad_jtVar != null) {
            String requestId = jADSlot.getRequestId();
            try {
                if (jADSlot.getAdDataRequestSourceType() == 0) {
                    if (jad_jtVar.jad_an == 2) {
                        return;
                    }
                } else if (!JADMediator.getInstance().getAdService().enablePreloadAd(str, jADSlot)) {
                    return;
                } else {
                    JADMediator.getInstance().getAdService().registerAdPreloader(str, jADSlot);
                }
                if (jad_jtVar.jad_an(jADSlot, jADAdLoadListener)) {
                    WorkExecutor.execute(new com.jd.ad.sdk.jad_jt.jad_an(jad_jtVar, jADSlot, jADAdLoadListener, requestId, str));
                    return;
                }
                return;
            } catch (Exception e2) {
                com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.GW_REQUEST_OTHER_ERROR;
                jad_jtVar.jad_an(jADAdLoadListener, jad_anVar.jad_an, jad_anVar.jad_an(new String[0]));
                com.jd.ad.sdk.jad_vi.jad_fs.jad_an(requestId, 3, jad_anVar.jad_an, jad_jtVar.jad_an(jADSlot.getSlotID(), jADSlot.getAdType(), jad_anVar.jad_an(e2.getMessage())), jADSlot.getSen());
                return;
            }
        }
        JADEventService eventService = JADMediator.getInstance().getEventService();
        String requestId2 = jADSlot.getRequestId();
        com.jd.ad.sdk.jad_uh.jad_an jad_anVar2 = com.jd.ad.sdk.jad_uh.jad_an.GW_REQUEST_REGISTER_AD_SERVICE_ERROR;
        eventService.reportRequestErrorEvent(requestId2, jad_anVar2.jad_an, jad_anVar2.jad_an(new String[0]));
        jADAdLoadListener.onLoadFailure(jad_anVar2.jad_an, jad_anVar2.jad_an(new String[0]));
    }

    @Override // com.jd.ad.sdk.mdt.service.JADAdService
    public void loadAdFromCache(@NonNull String str, @NonNull JADSlot jADSlot, @NonNull JADAdLoadListener jADAdLoadListener) {
        com.jd.ad.sdk.jad_jt.jad_jt jad_jtVar = this.jad_an.get(str);
        if (jad_jtVar == null || jADSlot == null) {
            return;
        }
        try {
            if (jad_jtVar.jad_an == 1) {
                return;
            }
            jADSlot.setAdDataRequestSourceType(2);
            WorkExecutor.execute(new com.jd.ad.sdk.jad_jt.jad_bo(jad_jtVar, jADSlot, str, jADAdLoadListener));
        } catch (Exception e2) {
            StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Exception while preload ad load from cache failed:");
            jad_an.append(Log.getStackTraceString(e2));
            Logger.d(jad_an.toString());
        }
    }

    @Override // com.jd.ad.sdk.mdt.service.JADAdService
    public synchronized void printRequestData(@NonNull JADSlot jADSlot) {
        String str;
        String adUrl = JADMediator.getInstance().getInitService().getAdUrl(jADSlot.getSlotID());
        byte[] jad_bo = com.jd.ad.sdk.jad_jt.jad_hu.jad_bo(jADSlot);
        if (jad_bo != null) {
            String str2 = new String(jad_bo);
            if (!TextUtils.isEmpty(str2)) {
                HashMap hashMap = new HashMap(3);
                hashMap.put("Content-Type", "application/json");
                hashMap.put("User-Agent", com.jd.ad.sdk.jad_ob.jad_fs.jad_cp());
                hashMap.put("sdkxid", "default");
                if (!TextUtils.isEmpty(adUrl) && !TextUtils.isEmpty(str2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("curl -v ");
                    for (Map.Entry entry : hashMap.entrySet()) {
                        sb2.append("-H '" + ((String) entry.getKey()) + ": " + ((String) entry.getValue()) + "' ");
                    }
                    sb2.append("-d '" + str2 + "' ");
                    sb2.append("'" + adUrl + "'");
                    str = sb2.toString();
                    Logger.w(str, new Object[0]);
                }
                Logger.w("url or requestData is empty", new Object[0]);
                str = "";
                Logger.w(str, new Object[0]);
            }
        }
    }

    @Override // com.jd.ad.sdk.mdt.service.JADAdService
    public void registerAd(String str) {
        if (this.jad_an.get(str) == null) {
            this.jad_an.put(str, new com.jd.ad.sdk.jad_jt.jad_jt());
        }
    }

    @Override // com.jd.ad.sdk.mdt.service.JADAdService
    public void registerAdPreloader(@NonNull String str, @NonNull JADSlot jADSlot) {
        com.jd.ad.sdk.jad_jt.jad_jt jad_jtVar = this.jad_an.get(str);
        if (jad_jtVar != null) {
            ArrayList<com.jd.ad.sdk.jad_jt.jad_jt> arrayList = this.jad_bo.get(jADSlot.getSlotID());
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            arrayList.add(jad_jtVar);
            this.jad_bo.put(jADSlot.getSlotID(), arrayList);
        }
    }

    @Override // com.jd.ad.sdk.mdt.service.JADAdService
    public void removeData(@NonNull String str) {
        com.jd.ad.sdk.jad_ly.jad_cp jad_cpVar = jad_cp.jad_an.jad_an;
        if (jad_cpVar.jad_an.containsKey(str)) {
            jad_cpVar.jad_an.remove(str);
        }
        if (jad_cpVar.jad_bo.containsKey(str)) {
            jad_cpVar.jad_bo.remove(str);
        }
    }

    @Override // com.jd.ad.sdk.mdt.service.JADAdService
    public void unregisterAd(@NonNull String str) {
        if (this.jad_an.get(str) == null) {
            return;
        }
        this.jad_an.remove(str);
    }

    @Override // com.jd.ad.sdk.mdt.service.JADAdService
    public void unregisterAdPreloader(@NonNull String str, @NonNull JADSlot jADSlot) {
        ArrayList<com.jd.ad.sdk.jad_jt.jad_jt> arrayList;
        com.jd.ad.sdk.jad_jt.jad_jt jad_jtVar = this.jad_an.get(str);
        if (jad_jtVar == null || (arrayList = this.jad_bo.get(jADSlot.getSlotID())) == null || arrayList.size() <= 0) {
            return;
        }
        arrayList.remove(jad_jtVar);
        this.jad_bo.put(jADSlot.getSlotID(), arrayList);
    }
}
