package com.wangmai.ad.dex.allmodules.utils;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.reflect.TypeToken;
import com.wangmai.ad.dex.allmodules.bean.ApiBean;
import com.wangmai.ad.dex.allmodules.bean.VirtualClickAdSlotInfo;
import com.wangmai.common.utils.ConstantInfo;
import com.wangmai.common.utils.GsonUtils;
import com.wangmai.common.utils.SharedPreferencesHelper;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: AbsVirtualClick.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public abstract class appa {
    private static final String appe = "appa";

    /* renamed from: appa, reason: collision with root package name */
    protected Context f46821appa;
    protected String appb;
    protected boolean appc;
    protected ApiBean.Optimization appd;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: AbsVirtualClick.java */
    /* renamed from: com.wangmai.ad.dex.allmodules.utils.appa$appa, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    class C0694appa extends TypeToken<Map<String, VirtualClickAdSlotInfo>> {
        C0694appa(appa appaVar) {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: AbsVirtualClick.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    class appb extends TypeToken<Map<String, VirtualClickAdSlotInfo>> {
        appb(appa appaVar) {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: AbsVirtualClick.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public interface appc {
        void appa(int i10, float f10, float f11, float f12, float f13);
    }

    public appa(Context context, String str, ApiBean.Optimization optimization, boolean z10) {
        this.f46821appa = context;
        this.appb = str;
        this.appd = optimization;
        this.appc = z10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean appa(int i10) {
        long currentTimeMillis = System.currentTimeMillis() - ConstantInfo.sdkInitTime;
        boolean z10 = ((double) currentTimeMillis) <= 300000.0d;
        if (z10) {
            if (appf.appm == i10) {
                appa.appa.appf.appd.appe(appe, "未触发模拟点击逻辑（风控时长限制）" + currentTimeMillis + " < 300000.0");
            } else {
                appa.appa.appf.appd.appe(appe, "未触发滑动点击逻辑（风控时长限制）" + currentTimeMillis + " < 300000.0");
            }
        }
        return z10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void appb(int i10) {
        String preferencesString;
        Map hashMap;
        VirtualClickAdSlotInfo appa2;
        synchronized (this) {
            try {
                preferencesString = SharedPreferencesHelper.getInstance(this.f46821appa).getPreferencesString(ConstantInfo.SP_KEY_VIRTUAL_CLICK, "");
            } finally {
            }
            if (!TextUtils.isEmpty(preferencesString) && (hashMap = (Map) GsonUtils.getInstance().fromJson(preferencesString, new appb(this))) != null && !hashMap.isEmpty()) {
                VirtualClickAdSlotInfo virtualClickAdSlotInfo = (VirtualClickAdSlotInfo) hashMap.get(this.appb);
                if (virtualClickAdSlotInfo == null) {
                    appa2 = appa(null, i10);
                } else {
                    appa2 = appa(virtualClickAdSlotInfo, i10);
                }
                hashMap.put(this.appb, appa2);
                String json = GsonUtils.getInstance().toJson(hashMap);
                appa.appa.appf.appd.appa(appe, "updateVirtualClickInfo:" + json);
                SharedPreferencesHelper.getInstance(this.f46821appa).savePreferencesString(ConstantInfo.SP_KEY_VIRTUAL_CLICK, json);
            }
            VirtualClickAdSlotInfo appa3 = appa(null, i10);
            hashMap = new HashMap();
            hashMap.put(this.appb, appa3);
            String json2 = GsonUtils.getInstance().toJson(hashMap);
            appa.appa.appf.appd.appa(appe, "updateVirtualClickInfo:" + json2);
            SharedPreferencesHelper.getInstance(this.f46821appa).savePreferencesString(ConstantInfo.SP_KEY_VIRTUAL_CLICK, json2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public VirtualClickAdSlotInfo appa() {
        VirtualClickAdSlotInfo virtualClickAdSlotInfo;
        Map map;
        synchronized (this) {
            virtualClickAdSlotInfo = null;
            try {
                String preferencesString = SharedPreferencesHelper.getInstance(this.f46821appa).getPreferencesString(ConstantInfo.SP_KEY_VIRTUAL_CLICK, "");
                if (!TextUtils.isEmpty(preferencesString) && (map = (Map) GsonUtils.getInstance().fromJson(preferencesString, new C0694appa(this))) != null && !map.isEmpty()) {
                    virtualClickAdSlotInfo = (VirtualClickAdSlotInfo) map.get(this.appb);
                }
            } finally {
                appa.appa.appf.appd.appa(appe, "getVirtualClickInfo:" + ((Object) virtualClickAdSlotInfo));
                return virtualClickAdSlotInfo;
            }
        }
        appa.appa.appf.appd.appa(appe, "getVirtualClickInfo:" + ((Object) virtualClickAdSlotInfo));
        return virtualClickAdSlotInfo;
    }

    private VirtualClickAdSlotInfo appa(VirtualClickAdSlotInfo virtualClickAdSlotInfo, int i10) {
        if (virtualClickAdSlotInfo == null) {
            appa.appa.appf.appd.appa(appe, "本地点击信息为空，执行创建");
            virtualClickAdSlotInfo = new VirtualClickAdSlotInfo();
            virtualClickAdSlotInfo.setAdSlotId(this.appb);
            if (appf.appm == i10) {
                virtualClickAdSlotInfo.setSimulatedClickedCount(1);
                virtualClickAdSlotInfo.setLastSimulatedClickTime(System.currentTimeMillis());
            } else {
                virtualClickAdSlotInfo.setSlideClickedCount(1);
                virtualClickAdSlotInfo.setLastSlideClickTime(System.currentTimeMillis());
            }
        } else {
            appa.appa.appf.appd.appa(appe, "本地点击信息有效，执行更新");
            if (virtualClickAdSlotInfo.isExpired()) {
                appa.appa.appf.appd.appe(appe, "已过期，重置频控");
                if (appf.appm == i10) {
                    virtualClickAdSlotInfo.setSimulatedClickedCount(1);
                    virtualClickAdSlotInfo.setLastSimulatedClickTime(System.currentTimeMillis());
                    virtualClickAdSlotInfo.setSlideClickedCount(0);
                    virtualClickAdSlotInfo.setLastSlideClickTime(0L);
                } else {
                    virtualClickAdSlotInfo.setSlideClickedCount(1);
                    virtualClickAdSlotInfo.setLastSlideClickTime(System.currentTimeMillis());
                    virtualClickAdSlotInfo.setSimulatedClickedCount(0);
                    virtualClickAdSlotInfo.setLastSimulatedClickTime(0L);
                }
            } else if (appf.appm == i10) {
                virtualClickAdSlotInfo.setSimulatedClickedCount(virtualClickAdSlotInfo.getSimulatedClickedCount() + 1);
                virtualClickAdSlotInfo.setLastSimulatedClickTime(System.currentTimeMillis());
            } else {
                virtualClickAdSlotInfo.setSlideClickedCount(virtualClickAdSlotInfo.getSlideClickedCount() + 1);
                virtualClickAdSlotInfo.setLastSlideClickTime(System.currentTimeMillis());
            }
        }
        virtualClickAdSlotInfo.setLastOperationTime(System.currentTimeMillis());
        return virtualClickAdSlotInfo;
    }
}
