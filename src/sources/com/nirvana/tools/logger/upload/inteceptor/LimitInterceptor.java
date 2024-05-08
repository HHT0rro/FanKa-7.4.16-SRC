package com.nirvana.tools.logger.upload.inteceptor;

import android.content.Context;
import com.nirvana.tools.logger.model.ACMLimitConfig;
import com.nirvana.tools.logger.utils.CommonUtils;
import com.nirvana.tools.logger.utils.UTSharedPreferencesHelper;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class LimitInterceptor implements BaseInterceptor {
    private static volatile LimitInterceptor mInstance;
    private ACMLimitConfig mConfig;
    private Context mContext;

    public LimitInterceptor(Context context) {
        this.mContext = context;
        this.mConfig = UTSharedPreferencesHelper.readLimitConfig(context);
    }

    public static LimitInterceptor getInstance(Context context) {
        if (mInstance == null) {
            synchronized (LimitInterceptor.class) {
                if (mInstance == null) {
                    mInstance = new LimitInterceptor(context);
                }
            }
        }
        return mInstance;
    }

    public synchronized void addLimitCount() {
        ACMLimitConfig aCMLimitConfig = this.mConfig;
        if (aCMLimitConfig != null && aCMLimitConfig.isLimited() && this.mConfig.getLimitHours() > 0) {
            UTSharedPreferencesHelper.saveSLSLimitCount(this.mContext, CommonUtils.getLimitIntervalIndex(this.mConfig.getLimitHours()));
        }
    }

    public synchronized void clearLimitInfo() {
        UTSharedPreferencesHelper.clearLimitCount(this.mContext);
    }

    @Override // com.nirvana.tools.logger.upload.inteceptor.BaseInterceptor
    public synchronized boolean isAllowUploading() {
        ACMLimitConfig aCMLimitConfig = this.mConfig;
        if (aCMLimitConfig == null || !aCMLimitConfig.isLimited() || this.mConfig.getLimitHours() <= 0) {
            return true;
        }
        return UTSharedPreferencesHelper.readSLSLimitCount(this.mContext, CommonUtils.getLimitIntervalIndex(this.mConfig.getLimitHours())) < this.mConfig.getLimitCount();
    }

    public synchronized void setConfig(ACMLimitConfig aCMLimitConfig) {
        if (aCMLimitConfig != null) {
            this.mConfig = aCMLimitConfig;
            UTSharedPreferencesHelper.writeLimitConfig(this.mContext, aCMLimitConfig);
        }
    }
}
