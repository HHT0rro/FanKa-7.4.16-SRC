package com.huawei.hianalytics.v2;

import android.content.Context;
import com.huawei.hianalytics.a0;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.d0;
import com.huawei.hianalytics.data.HiAnalyticsDataManager;
import com.huawei.hianalytics.log.LogTag;
import com.huawei.hianalytics.process.HiAnalyticsConfig;
import com.huawei.hianalytics.process.HiAnalyticsManager;
import com.huawei.hianalytics.process.impl.HAImpl;
import java.util.Map;

@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class HiAnalyticsConf {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class Builder {
        public static final String TAG = LogTag.get(HiAnalyticsConf.class, Builder.class);
        public String appid;
        public HiAnalyticsConfig.Builder diffConfigBuilder;
        public Context mContext;
        public HiAnalyticsConfig.Builder maintConfigBuilder;
        public HiAnalyticsConfig.Builder operConfigBuilder;
        public HiAnalyticsConfig.Builder preConfigBuilder;

        public Builder(Context context) {
            if (context != null) {
                this.mContext = context.getApplicationContext();
            }
            this.maintConfigBuilder = new HiAnalyticsConfig.Builder();
            this.operConfigBuilder = new HiAnalyticsConfig.Builder();
            this.diffConfigBuilder = new HiAnalyticsConfig.Builder();
            this.preConfigBuilder = new HiAnalyticsConfig.Builder();
        }

        public void create() {
            if (this.mContext == null) {
                HiLog.e(TAG, "analyticsConf create(): context is null,create failed!");
                return;
            }
            String str = TAG;
            HiLog.i(str, "Builder.create() is execute.");
            HiAnalyticsConfig build = this.maintConfigBuilder.build();
            HiAnalyticsConfig build2 = this.operConfigBuilder.build();
            HiAnalyticsConfig build3 = this.diffConfigBuilder.build();
            HiAnalyticsConfig build4 = this.preConfigBuilder.build();
            HiAnalyticsDataManager.getInstance().init(this.mContext);
            HAImpl hAImpl = new HAImpl("_default_config_tag");
            if (hAImpl.getFrameworkInstance() == null) {
                HiLog.e(str, "create(): instance create frameworkInstance is null,create failed!TAG: _default_config_tag");
                return;
            }
            hAImpl.setOperConf(build2);
            hAImpl.setMaintConf(build);
            hAImpl.setDiffConf(build3);
            hAImpl.setPreInstallConf(build4);
            HiAnalyticsDataManager.getInstance().registerInstance("_default_config_tag", hAImpl);
            d0.klm.lmn(new a0(this.mContext, "_default_config_tag"));
            HiAnalyticsManager.setAppid(this.appid);
        }

        public void refresh(boolean z10) {
            String str = TAG;
            HiLog.i(str, "Builder.refresh() is execute.");
            HiAnalyticsConfig build = this.maintConfigBuilder.build();
            HiAnalyticsConfig build2 = this.operConfigBuilder.build();
            HiAnalyticsConfig build3 = this.diffConfigBuilder.build();
            HiAnalyticsConfig build4 = this.preConfigBuilder.build();
            HAImpl instanceByTag = HiAnalyticsDataManager.getInstance().getInstanceByTag("_default_config_tag");
            if (instanceByTag == null) {
                HiLog.sw(str, "HiAnalyticsInstance.Builder.Refresh(): calling refresh before create. TAG: _default_config_tag has no instance. ");
                return;
            }
            instanceByTag.refresh(1, build);
            instanceByTag.refresh(0, build2);
            instanceByTag.refresh(3, build3);
            instanceByTag.refresh(2, build4);
            if (z10) {
                HiAnalyticsDataManager.getInstance().clearDataByTag("_default_config_tag");
            }
            HiAnalyticsManager.setAppid(this.appid);
        }

        public Builder setAndroidId(String str) {
            HiLog.i(TAG, "setAndroidId(String androidId) is execute.");
            this.operConfigBuilder.setAndroidId(str);
            this.maintConfigBuilder.setAndroidId(str);
            this.diffConfigBuilder.setAndroidId(str);
            this.preConfigBuilder.setAndroidId(str);
            return this;
        }

        @Deprecated
        public Builder setAppID(String str) {
            HiLog.i(TAG, "Builder.setAppID is execute");
            this.appid = str;
            return this;
        }

        @Deprecated
        public Builder setAutoReportThreshold(int i10) {
            HiLog.sw(TAG, "Builder.setAutoReportThreshold is Deprecated");
            return this;
        }

        @Deprecated
        public Builder setCacheExpireTime(int i10) {
            HiLog.i(TAG, "Builder.setCacheExpireTime is execute");
            this.operConfigBuilder.setCacheExpireTime(i10);
            this.maintConfigBuilder.setCacheExpireTime(i10);
            this.diffConfigBuilder.setCacheExpireTime(i10);
            this.preConfigBuilder.setCacheExpireTime(i10);
            return this;
        }

        @Deprecated
        public Builder setChannel(String str) {
            HiLog.i(TAG, "Builder.setChannel(String channel) is execute.");
            this.operConfigBuilder.setChannel(str);
            this.maintConfigBuilder.setChannel(str);
            this.diffConfigBuilder.setChannel(str);
            this.preConfigBuilder.setChannel(str);
            return this;
        }

        @Deprecated
        public Builder setCollectURL(int i10, String str) {
            String str2 = TAG;
            HiLog.i(str2, "Builder.setCollectURL(int type,String collectURL) is execute.TYPE : " + i10);
            if (i10 == 0) {
                this.operConfigBuilder.setCollectURL(str);
            } else if (i10 == 1) {
                this.maintConfigBuilder.setCollectURL(str);
            } else if (i10 != 3) {
                HiLog.w(str2, "Builder.setCollectURL(int type,String collectURL): invalid type!");
            } else {
                this.diffConfigBuilder.setCollectURL(str);
            }
            return this;
        }

        @Deprecated
        public Builder setEnableAndroidID(boolean z10) {
            HiLog.i(TAG, "Builder.setEnableAndroidID(boolean reportAndroidID) is execute.");
            this.maintConfigBuilder.setEnableAndroidID(z10);
            this.operConfigBuilder.setEnableAndroidID(z10);
            this.diffConfigBuilder.setEnableAndroidID(z10);
            this.preConfigBuilder.setEnableAndroidID(z10);
            return this;
        }

        @Deprecated
        public Builder setEnableImei(boolean z10) {
            HiLog.i(TAG, "Builder.setEnableImei(boolean isReportAndroidImei) is execute.");
            this.operConfigBuilder.setEnableImei(z10);
            this.maintConfigBuilder.setEnableImei(z10);
            this.diffConfigBuilder.setEnableImei(z10);
            this.preConfigBuilder.setEnableImei(z10);
            return this;
        }

        @Deprecated
        public Builder setEnableMccMnc(boolean z10) {
            HiLog.i(TAG, "Builder.setEnableMccMnc(boolean enableMccMnc) is execute.");
            this.maintConfigBuilder.setEnableMccMnc(z10);
            this.operConfigBuilder.setEnableMccMnc(z10);
            this.diffConfigBuilder.setEnableMccMnc(z10);
            this.preConfigBuilder.setEnableMccMnc(z10);
            return this;
        }

        @Deprecated
        public Builder setEnableSN(boolean z10) {
            HiLog.i(TAG, "Builder.setEnableSN(boolean isReportSN) is execute.");
            this.maintConfigBuilder.setEnableSN(z10);
            this.operConfigBuilder.setEnableSN(z10);
            this.diffConfigBuilder.setEnableSN(z10);
            this.preConfigBuilder.setEnableSN(z10);
            return this;
        }

        public Builder setEnableSession(boolean z10) {
            HiLog.i(TAG, "setEnableSession(boolean enableSession) is execute.");
            this.operConfigBuilder.setEnableSession(z10);
            return this;
        }

        @Deprecated
        public Builder setEnableUDID(boolean z10) {
            HiLog.i(TAG, "Builder.setEnableUDID(boolean isReportUDID) is execute.");
            this.maintConfigBuilder.setEnableUDID(z10);
            this.operConfigBuilder.setEnableUDID(z10);
            this.diffConfigBuilder.setEnableUDID(z10);
            this.preConfigBuilder.setEnableUDID(z10);
            return this;
        }

        @Deprecated
        public Builder setEnableUUID(boolean z10) {
            HiLog.d(TAG, "Builder.setEnableUUID() is executed.");
            this.operConfigBuilder.setEnableUUID(z10);
            this.maintConfigBuilder.setEnableUUID(z10);
            this.diffConfigBuilder.setEnableUUID(z10);
            this.preConfigBuilder.setEnableUUID(z10);
            return this;
        }

        @Deprecated
        public Builder setHttpHeader(Map<String, String> map) {
            this.operConfigBuilder.setHttpHeader(map);
            this.maintConfigBuilder.setHttpHeader(map);
            this.diffConfigBuilder.setHttpHeader(map);
            this.preConfigBuilder.setHttpHeader(map);
            return this;
        }

        public Builder setIMEI(String str) {
            HiLog.i(TAG, "setIMEI(String imei) is execute.");
            this.operConfigBuilder.setImei(str);
            this.maintConfigBuilder.setImei(str);
            this.diffConfigBuilder.setImei(str);
            this.preConfigBuilder.setImei(str);
            return this;
        }

        public Builder setSN(String str) {
            HiLog.i(TAG, "setSN(String sn) is execute.");
            this.operConfigBuilder.setSN(str);
            this.maintConfigBuilder.setSN(str);
            this.diffConfigBuilder.setSN(str);
            this.preConfigBuilder.setSN(str);
            return this;
        }

        public Builder setUDID(String str) {
            HiLog.i(TAG, "setUDID(String udid) is execute.");
            this.operConfigBuilder.setUdid(str);
            this.maintConfigBuilder.setUdid(str);
            this.diffConfigBuilder.setUdid(str);
            this.preConfigBuilder.setUdid(str);
            return this;
        }
    }
}
