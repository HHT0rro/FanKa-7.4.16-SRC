package com.huawei.hianalytics.process;

import android.content.Context;
import com.huawei.hianalytics.a0;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.d0;
import com.huawei.hianalytics.data.HiAnalyticsDataManager;
import com.huawei.hianalytics.i0;
import com.huawei.hianalytics.log.LogTag;
import com.huawei.hianalytics.process.impl.HAImpl;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface HiAnalyticsInstance {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class Builder {
        public static final String TAG = LogTag.get(HiAnalyticsInstance.class, Builder.class);
        public Context mContext;
        public HiAnalyticsConfig maintConf = null;
        public HiAnalyticsConfig operConf = null;
        public HiAnalyticsConfig diffConf = null;
        public HiAnalyticsConfig preConfig = null;

        public Builder(Context context) {
            if (context != null) {
                this.mContext = context.getApplicationContext();
            }
        }

        private void setConf(HAImpl hAImpl) {
            HiAnalyticsConfig hiAnalyticsConfig = this.operConf;
            if (hiAnalyticsConfig == null) {
                hAImpl.setOperConf(null);
            } else {
                hAImpl.setOperConf(new HiAnalyticsConfig(hiAnalyticsConfig));
            }
            HiAnalyticsConfig hiAnalyticsConfig2 = this.maintConf;
            if (hiAnalyticsConfig2 == null) {
                hAImpl.setMaintConf(null);
            } else {
                hAImpl.setMaintConf(new HiAnalyticsConfig(hiAnalyticsConfig2));
            }
            HiAnalyticsConfig hiAnalyticsConfig3 = this.diffConf;
            if (hiAnalyticsConfig3 == null) {
                hAImpl.setDiffConf(null);
            } else {
                hAImpl.setDiffConf(new HiAnalyticsConfig(hiAnalyticsConfig3));
            }
            HiAnalyticsConfig hiAnalyticsConfig4 = this.preConfig;
            if (hiAnalyticsConfig4 == null) {
                hAImpl.setPreInstallConf(null);
            } else {
                hAImpl.setPreInstallConf(new HiAnalyticsConfig(hiAnalyticsConfig4));
            }
        }

        public HiAnalyticsInstance create(String str) {
            if (this.mContext == null) {
                HiLog.e(TAG, "create(): instance context is null,create failed!TAG: " + str);
                return null;
            }
            if (str != null && i0.lmn("tag", str, "[a-zA-Z0-9][a-zA-Z0-9_]{0,255}")) {
                if (HiAnalyticsManager.getInitFlag(str)) {
                    HiLog.e(TAG, "This tag already exists.TAG: " + str);
                    return null;
                }
                if (HiAnalyticsDataManager.getInstance().isBlackTag(str)) {
                    HiLog.e(TAG, "create(): black tag is not allowed here.TAG: " + str);
                    return null;
                }
                if (HiAnalyticsDataManager.getInstance().getInstanceSize() - HiAnalyticsDataManager.getInstance().getPresetInstanceSize() > 50) {
                    HiLog.e(TAG, "The number of TAGs exceeds the limit!TAG: " + str);
                    return null;
                }
                HiAnalyticsDataManager.getInstance().init(this.mContext);
                HAImpl hAImpl = new HAImpl(str);
                if (hAImpl.getFrameworkInstance() == null) {
                    HiLog.e(TAG, "create(): instance create frameworkInstance is null,create failed!TAG: " + str);
                    return null;
                }
                setConf(hAImpl);
                HAImpl registerInstance = HiAnalyticsDataManager.getInstance().registerInstance(str, hAImpl);
                d0.klm.lmn(new a0(this.mContext, str));
                return registerInstance == null ? hAImpl : registerInstance;
            }
            HiLog.e(TAG, "create(): check tag failed! TAG: " + str);
            return null;
        }

        public HiAnalyticsInstance refresh(String str) {
            HAImpl instanceByTag = HiAnalyticsDataManager.getInstance().getInstanceByTag(str);
            if (instanceByTag == null) {
                HiLog.w(TAG, "HiAnalyticsInstance.Builder.Refresh(): calling refresh before create. TAG: " + str + " has no instance. ");
                return create(str);
            }
            instanceByTag.refresh(1, this.maintConf);
            instanceByTag.refresh(0, this.operConf);
            instanceByTag.refresh(3, this.diffConf);
            instanceByTag.refresh(2, this.preConfig);
            return instanceByTag;
        }

        public Builder setDiffConf(HiAnalyticsConfig hiAnalyticsConfig) {
            this.diffConf = hiAnalyticsConfig;
            return this;
        }

        public Builder setMaintConf(HiAnalyticsConfig hiAnalyticsConfig) {
            this.maintConf = hiAnalyticsConfig;
            return this;
        }

        public Builder setOperConf(HiAnalyticsConfig hiAnalyticsConfig) {
            this.operConf = hiAnalyticsConfig;
            return this;
        }

        public Builder setPreConfig(HiAnalyticsConfig hiAnalyticsConfig) {
            this.preConfig = hiAnalyticsConfig;
            return this;
        }
    }

    void clearData();

    String getUUID(int i10);

    void newInstanceUUID();

    void onBackground(long j10);

    void onEvent(int i10, String str, LinkedHashMap<String, String> linkedHashMap);

    void onEvent(int i10, String str, LinkedHashMap<String, String> linkedHashMap, LinkedHashMap<String, String> linkedHashMap2, LinkedHashMap<String, String> linkedHashMap3);

    @Deprecated
    void onEvent(Context context, String str, String str2);

    void onEvent(String str, LinkedHashMap<String, String> linkedHashMap);

    void onForeground(long j10);

    void onPause(Context context);

    void onPause(Context context, LinkedHashMap<String, String> linkedHashMap);

    void onPause(String str, LinkedHashMap<String, String> linkedHashMap);

    void onReport(int i10);

    @Deprecated
    void onReport(Context context, int i10);

    void onResume(Context context);

    void onResume(Context context, LinkedHashMap<String, String> linkedHashMap);

    void onResume(String str, LinkedHashMap<String, String> linkedHashMap);

    void onStreamEvent(int i10, String str, LinkedHashMap<String, String> linkedHashMap);

    void onStreamEvent(int i10, String str, LinkedHashMap<String, String> linkedHashMap, LinkedHashMap<String, String> linkedHashMap2, LinkedHashMap<String, String> linkedHashMap3);

    void refresh(int i10, HiAnalyticsConfig hiAnalyticsConfig);

    void setAccountBrandId(String str);

    void setAppBrandId(String str);

    void setAppid(String str);

    void setCommonProp(int i10, Map<String, String> map);

    void setHandsetManufacturer(String str);

    void setHansetBrandId(String str);

    void setOAID(int i10, String str);

    void setOAIDTrackingFlag(int i10, boolean z10);

    void setUpid(int i10, String str);
}
