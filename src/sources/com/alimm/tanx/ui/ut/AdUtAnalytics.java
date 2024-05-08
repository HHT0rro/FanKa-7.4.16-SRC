package com.alimm.tanx.ui.ut;

import com.alimm.tanx.core.ad.listener.ut.ITanxUserTracker;
import com.alimm.tanx.core.orange.OrangeManager;
import com.alimm.tanx.core.orange.bean.OrangeBean;
import com.alimm.tanx.core.orange.bean.OrangeUtBean;
import com.alimm.tanx.core.ut.bean.UtItemBean;
import com.alimm.tanx.core.ut.core.UserReportManager;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NotConfused;
import com.alimm.tanx.core.utils.TanxTestLog;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class AdUtAnalytics implements ITanxUserTracker, NotConfused {
    public static final String TAG = "AdUtAnalytics";
    public static AdUtAnalytics sInstance;
    public volatile int lastUtItemBeanHashCode = 0;

    public static AdUtAnalytics getInstance() {
        if (sInstance == null) {
            synchronized (AdUtAnalytics.class) {
                if (sInstance == null) {
                    sInstance = new AdUtAnalytics();
                }
            }
        }
        return sInstance;
    }

    public static boolean isOpen(String str) {
        Boolean bool;
        OrangeBean orangeBean = OrangeManager.getInstance().getOrangeBean();
        if (orangeBean == null) {
            return true;
        }
        OrangeUtBean orangeUtBean = orangeBean.ut;
        if (orangeUtBean != null && (bool = orangeUtBean.utSwitch) != null && !bool.booleanValue()) {
            return false;
        }
        HashMap<String, String> hashMap = orangeBean.commonSwitch;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return true;
        }
        return "true".equalsIgnoreCase(orangeBean.commonSwitch.get(str));
    }

    public synchronized void send(String str, String str2, String str3, int i10, int i11, String str4, String str5, String str6, Map<String, Object> map, String str7) {
        LogUtils.d(TAG, "start—send-ut");
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
            LogUtils.d(TAG, "send UT exception.", e2);
        }
        if (!isOpen(str)) {
            LogUtils.d(TAG, "埋点开关为false，终止上报");
            return;
        }
        if (OrangeManager.getInstance().getOrangeBean() != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(OrangeManager.getInstance().getOrangeBean().version);
            sb2.append("");
            map.put("orangeVersion", sb2.toString());
        }
        UtItemBean utItemBean = new UtItemBean(str3, str2, str, i10, i11, str4, str5, str6, map, str7);
        int hashCode = utItemBean.hashCode();
        if (this.lastUtItemBeanHashCode != 0 && this.lastUtItemBeanHashCode == hashCode) {
            LogUtils.d(TAG, "Send UT End Duplicate Data");
        } else {
            UserReportManager.getInstance().send(utItemBean);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("\nlastUtItemBean ");
            sb3.append(this.lastUtItemBeanHashCode);
            String sb4 = sb3.toString();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(sb4);
            sb5.append("\nutItemBean ");
            sb5.append(hashCode);
            String sb6 = sb5.toString();
            StringBuilder sb7 = new StringBuilder();
            sb7.append("sendUtData:");
            sb7.append(utItemBean.toString());
            sb7.append(sb6);
            LogUtils.d(TAG, sb7.toString());
            this.lastUtItemBeanHashCode = hashCode;
        }
        TanxTestLog.sendLog(str, map);
    }

    @Override // com.alimm.tanx.core.ad.listener.ut.ITanxUserTracker
    public void track(String str, String str2, String str3, int i10, int i11, String str4, String str5, String str6, Map<String, Object> map, String str7) {
        send(str, str2, str3, i10, i11, str4, str5, str6, map, str7);
    }
}
