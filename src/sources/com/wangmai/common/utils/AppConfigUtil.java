package com.wangmai.common.utils;

import android.content.Context;
import android.text.TextUtils;
import com.wangmai.common.bean.AppConfigRespBean;
import com.wangmai.common.bean.MediaAdSlotIdConfig;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class AppConfigUtil {
    public static final String TAG = "AppConfigUtil";
    public static volatile AppConfigUtil appConfigUtil;

    public static AppConfigUtil getInstance() {
        if (appConfigUtil == null) {
            synchronized (AppConfigUtil.class) {
                if (appConfigUtil == null) {
                    appConfigUtil = new AppConfigUtil();
                }
            }
        }
        return appConfigUtil;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0060, code lost:
    
        if ((java.lang.System.currentTimeMillis() - r6.getCurrentTimeStamp()) >= ((r1.getSdkAdslotConfig().getSdkStrategyCacheTime() * 60) * 1000)) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0062, code lost:
    
        r6 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean checkConfigValid(android.content.Context r6, java.lang.String r7) {
        /*
            r5 = this;
            com.wangmai.common.utils.SharedPreferencesHelper r6 = com.wangmai.common.utils.SharedPreferencesHelper.getInstance(r6)     // Catch: java.lang.Throwable -> L64
            java.lang.String r0 = com.wangmai.common.utils.ConstantInfo.SP_KEY_APP_CONFIG     // Catch: java.lang.Throwable -> L64
            java.lang.String r6 = r6.getPreferencesString(r0)     // Catch: java.lang.Throwable -> L64
            boolean r0 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Throwable -> L64
            if (r0 != 0) goto L7f
            com.wangmai.common.utils.GsonUtils r0 = com.wangmai.common.utils.GsonUtils.getInstance()     // Catch: java.lang.Throwable -> L64
            java.lang.Class<com.wangmai.common.bean.AppConfigRespBean> r1 = com.wangmai.common.bean.AppConfigRespBean.class
            java.lang.Object r6 = r0.fromJson(r6, r1)     // Catch: java.lang.Throwable -> L64
            com.wangmai.common.bean.AppConfigRespBean r6 = (com.wangmai.common.bean.AppConfigRespBean) r6     // Catch: java.lang.Throwable -> L64
            if (r6 == 0) goto L7f
            com.wangmai.common.bean.Appconfig r0 = r6.getAppConfig()     // Catch: java.lang.Throwable -> L64
            java.util.List r0 = r0.getAdslotIdsConfig()     // Catch: java.lang.Throwable -> L64
            if (r0 == 0) goto L7f
            boolean r1 = r0.isEmpty()     // Catch: java.lang.Throwable -> L64
            if (r1 != 0) goto L7f
            java.util.Iterator r0 = r0.iterator2()     // Catch: java.lang.Throwable -> L64
        L32:
            boolean r1 = r0.hasNext()     // Catch: java.lang.Throwable -> L64
            if (r1 == 0) goto L7f
            java.lang.Object r1 = r0.next()     // Catch: java.lang.Throwable -> L64
            com.wangmai.common.bean.MediaAdSlotIdConfig r1 = (com.wangmai.common.bean.MediaAdSlotIdConfig) r1     // Catch: java.lang.Throwable -> L64
            java.lang.String r2 = r1.getSdkAdslotId()     // Catch: java.lang.Throwable -> L64
            boolean r2 = r2.equals(r7)     // Catch: java.lang.Throwable -> L64
            if (r2 == 0) goto L32
            com.wangmai.common.bean.SdkAdSlotConfig r0 = r1.getSdkAdslotConfig()     // Catch: java.lang.Throwable -> L64
            int r0 = r0.getSdkStrategyCacheTime()     // Catch: java.lang.Throwable -> L64
            long r1 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L64
            long r3 = r6.getCurrentTimeStamp()     // Catch: java.lang.Throwable -> L64
            long r1 = r1 - r3
            int r0 = r0 * 60
            int r0 = r0 * 1000
            long r3 = (long) r0
            int r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r6 >= 0) goto L7f
            r6 = 1
            goto L80
        L64:
            r6 = move-exception
            java.lang.String r0 = com.wangmai.common.utils.AppConfigUtil.TAG
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "getAppConfig error:"
            r1.append(r2)
            java.lang.String r6 = r6.toString()
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            com.wangmai.common.utils.DebugLog.release_e(r0, r6)
        L7f:
            r6 = 0
        L80:
            java.lang.String r0 = com.wangmai.common.utils.AppConfigUtil.TAG
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "当前媒体代码位【"
            r1.append(r2)
            r1.append(r7)
            java.lang.String r7 = "】缓存配置"
            r1.append(r7)
            if (r6 == 0) goto L99
            java.lang.String r7 = "有效"
            goto L9b
        L99:
            java.lang.String r7 = "无效"
        L9b:
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            com.wangmai.common.utils.DebugLog.release_d(r0, r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wangmai.common.utils.AppConfigUtil.checkConfigValid(android.content.Context, java.lang.String):boolean");
    }

    public AppConfigRespBean getAppConfig(Context context) {
        try {
            String preferencesString = SharedPreferencesHelper.getInstance(context).getPreferencesString(ConstantInfo.SP_KEY_APP_CONFIG);
            if (!TextUtils.isEmpty(preferencesString)) {
                return (AppConfigRespBean) GsonUtils.getInstance().fromJson(preferencesString, AppConfigRespBean.class);
            }
        } catch (Throwable th) {
            DebugLog.release_e(TAG, "getAppConfig error:" + th.toString());
        }
        return null;
    }

    public MediaAdSlotIdConfig getMediaAdSlotConfigByAdSlotId(Context context, String str) {
        return getMediaAdSlotConfigByAdSlotId(getAppConfig(context), str);
    }

    public void saveAppConfig(Context context, AppConfigRespBean appConfigRespBean) {
        try {
            saveAppConfig(context, GsonUtils.getInstance().toJson(appConfigRespBean));
        } catch (Throwable th) {
            DebugLog.release_e(TAG, "saveAppConfig error:" + th.toString());
        }
    }

    public MediaAdSlotIdConfig getMediaAdSlotConfigByAdSlotId(AppConfigRespBean appConfigRespBean, String str) {
        if (appConfigRespBean != null) {
            try {
                for (MediaAdSlotIdConfig mediaAdSlotIdConfig : appConfigRespBean.getAppConfig().getAdslotIdsConfig()) {
                    if (mediaAdSlotIdConfig.getSdkAdslotId().equals(str)) {
                        return mediaAdSlotIdConfig;
                    }
                }
            } catch (Throwable th) {
                DebugLog.release_e(TAG, "getMediaAdSlotConfigByAdSlotId error:" + th.toString());
            }
        }
        return null;
    }

    public void saveAppConfig(Context context, String str) {
        try {
            SharedPreferencesHelper.getInstance(context).savePreferencesString(ConstantInfo.SP_KEY_APP_CONFIG, str);
        } catch (Throwable th) {
            DebugLog.release_e(TAG, "saveAppConfig error:" + th.toString());
        }
    }
}
