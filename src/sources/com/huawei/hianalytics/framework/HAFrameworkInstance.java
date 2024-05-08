package com.huawei.hianalytics.framework;

import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.core.storage.IStorageHandler;
import com.huawei.hianalytics.framework.config.ICallback;
import com.huawei.hianalytics.framework.config.ICollectorConfig;
import com.huawei.hianalytics.framework.config.IMandatoryParameters;
import com.huawei.hianalytics.framework.data.ConfigManager;
import com.huawei.hianalytics.framework.policy.IStoragePolicy;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface HAFrameworkInstance {
    public static final String TAG = "HAFrameworkInstance";

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class Builder {
        public ICollectorConfig collectorConfig;
        public g listenerManager;
        public IMandatoryParameters parameters;
        public IStorageHandler storageHandler;
        public IStoragePolicy storagePolicy;

        public Builder addEventListener(f fVar) {
            if (this.listenerManager == null) {
                this.listenerManager = new g();
            }
            this.listenerManager.a(fVar);
            return this;
        }

        public HAFrameworkInstance build(String str) {
            if (this.parameters == null && ConfigManager.getInstance().getParameters() == null) {
                return null;
            }
            if (ConfigManager.getInstance().checkServiceTag(str)) {
                HiLog.sw(HAFrameworkInstance.TAG, "serviceTag check failed : " + str);
                return null;
            }
            ConfigManager.getInstance().init(str, this.collectorConfig, this.parameters, this.storageHandler, this.storagePolicy);
            return new a(str);
        }

        public Builder setCollectorConfig(ICollectorConfig iCollectorConfig) {
            this.collectorConfig = iCollectorConfig;
            return this;
        }

        public Builder setMandatoryParameters(IMandatoryParameters iMandatoryParameters) {
            this.parameters = iMandatoryParameters;
            return this;
        }

        public Builder setStorageHandler(IStorageHandler iStorageHandler) {
            this.storageHandler = iStorageHandler;
            return this;
        }

        public Builder setStoragePolicy(IStoragePolicy iStoragePolicy) {
            this.storagePolicy = iStoragePolicy;
            return this;
        }
    }

    void clearCacheDataAll();

    void clearCacheDataByTag();

    void clearCacheDataByTagType(String str);

    void onBackground(long j10);

    void onEvent(String str, String str2, JSONObject jSONObject, ICallback iCallback);

    void onEvent(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, ICallback iCallback);

    void onForeground(long j10);

    void onReport(String str, ICallback iCallback);

    void onStreamEvent(String str, String str2, JSONObject jSONObject, ICallback iCallback);

    void onStreamEvent(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, ICallback iCallback);

    void setMinSessionDuration(long j10);

    void setNeedRefreshSession(boolean z10);

    void setSessionTimeoutDuration(long j10);
}
