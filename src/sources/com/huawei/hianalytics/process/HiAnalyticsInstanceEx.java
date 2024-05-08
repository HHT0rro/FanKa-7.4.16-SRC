package com.huawei.hianalytics.process;

import android.content.Context;
import com.huawei.hianalytics.a0;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.d0;
import com.huawei.hianalytics.data.HiAnalyticsDataManager;
import com.huawei.hianalytics.global.AutoCollectEventType;
import com.huawei.hianalytics.log.LogTag;
import com.huawei.hianalytics.process.impl.HAImpl;
import com.huawei.hianalytics.y;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface HiAnalyticsInstanceEx extends HiAnalyticsInstance {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class Builder {
        public static final String TAG = LogTag.get(HiAnalyticsInstanceEx.class, Builder.class);
        public Context mContext;
        public HiAnalyticsConfig maintConf = null;
        public HiAnalyticsConfig operConf = null;
        public HiAnalyticsConfig diffConf = null;
        public List<AutoCollectEventType> lsCollectTypes = null;

        public Builder(Context context) {
            if (context != null) {
                this.mContext = context.getApplicationContext();
            }
        }

        private void setConfEx(HAImpl hAImpl) {
            HiAnalyticsConfig hiAnalyticsConfig = this.operConf;
            hAImpl.setOperConf(hiAnalyticsConfig == null ? null : new HiAnalyticsConfig(hiAnalyticsConfig));
            HiAnalyticsConfig hiAnalyticsConfig2 = this.maintConf;
            hAImpl.setMaintConf(hiAnalyticsConfig2 == null ? null : new HiAnalyticsConfig(hiAnalyticsConfig2));
            HiAnalyticsConfig hiAnalyticsConfig3 = this.diffConf;
            hAImpl.setDiffConf(hiAnalyticsConfig3 != null ? new HiAnalyticsConfig(hiAnalyticsConfig3) : null);
        }

        public Builder autoCollect(List<AutoCollectEventType> list) {
            this.lsCollectTypes = list;
            return this;
        }

        public HiAnalyticsInstanceEx create() {
            if (this.mContext == null) {
                HiLog.e(TAG, "create(): instanceEx context is null,create failed!");
                return null;
            }
            if (HiAnalyticsManager.getInitFlag("_instance_ex_tag")) {
                HiLog.e(TAG, "create(): DEFAULT or existed tag is not allowed here.");
                return null;
            }
            HiAnalyticsDataManager.getInstance().init(this.mContext);
            y yVar = new y();
            setConfEx(yVar);
            HiAnalyticsDataManager.getInstance().registerInstanceEx(yVar);
            d0.klm.lmn(new a0(this.mContext, "_instance_ex_tag"));
            yVar.lmn(this.lsCollectTypes);
            return yVar;
        }

        public HiAnalyticsInstanceEx refresh() {
            y instanceEx = HiAnalyticsDataManager.getInstance().getInstanceEx();
            if (instanceEx == null) {
                HiLog.w(TAG, "HiAnalyticsInstanceEx.Builder.Refresh(): calling refresh before create. Instance not exist.");
                return create();
            }
            instanceEx.refresh(1, this.maintConf);
            instanceEx.refresh(0, this.operConf);
            instanceEx.refresh(3, this.diffConf);
            instanceEx.lmn(this.lsCollectTypes);
            return instanceEx;
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
    }

    @Deprecated
    void handleV1Cache();

    void onStartApp(String str, String str2);
}
