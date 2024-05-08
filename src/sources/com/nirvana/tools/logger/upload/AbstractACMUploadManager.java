package com.nirvana.tools.logger.upload;

import android.content.Context;
import com.nirvana.tools.logger.cache.ACMCacheManager;
import com.nirvana.tools.logger.cache.db.AbstractDatabase;
import com.nirvana.tools.logger.cache.db.DbException;
import com.nirvana.tools.logger.executor.AbstractSafeRunnable;
import com.nirvana.tools.logger.executor.ReentrantSingleThreadExecutor;
import com.nirvana.tools.logger.model.ACMLimitConfig;
import com.nirvana.tools.logger.model.ACMRecord;
import com.nirvana.tools.logger.upload.inteceptor.BaseInterceptor;
import com.nirvana.tools.logger.upload.inteceptor.EnableInterceptor;
import com.nirvana.tools.logger.upload.inteceptor.LimitInterceptor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class AbstractACMUploadManager<T extends ACMRecord> {
    public static final long MAX_TURNS_FOR_SINGLE_UPLOAD = 100;
    public static final int PAGE_SIZE = 20;
    public static final long TIME_INTERVAL = 12000;
    private static final int UPLOAD_RETRY_MAX_COUNT = 1;
    private boolean isUploadingFailed;
    public ACMCacheManager<T, ? extends AbstractDatabase<T>> mCacheManager;
    public Context mContext;
    private EnableInterceptor mEnableInterceptor;
    public ReentrantSingleThreadExecutor mExecutor;
    public ACMUpload<T> mUploader;
    public long maxUploadRetry;
    public int maxUploadSize;
    private int retryCount;
    public Map<Class, BaseInterceptor> mInterceptors = new HashMap();
    private Object mFailedLock = new Object();

    public AbstractACMUploadManager(Context context, ACMUpload<T> aCMUpload, ACMCacheManager<T, ? extends AbstractDatabase<T>> aCMCacheManager, ReentrantSingleThreadExecutor reentrantSingleThreadExecutor) {
        this.maxUploadSize = 0;
        this.maxUploadRetry = 0L;
        this.retryCount = 0;
        this.mContext = context;
        this.mUploader = aCMUpload;
        this.mCacheManager = aCMCacheManager;
        this.mExecutor = reentrantSingleThreadExecutor;
        this.mInterceptors.put(LimitInterceptor.class, LimitInterceptor.getInstance(context));
        this.maxUploadSize = 20;
        this.maxUploadRetry = 100L;
        this.retryCount = 1;
    }

    public void clearLimitConfig() {
        LimitInterceptor limitInterceptor = (LimitInterceptor) this.mInterceptors.remove(LimitInterceptor.class);
        if (limitInterceptor != null) {
            limitInterceptor.clearLimitInfo();
        }
    }

    public void deleteRecordsByFlag(int i10) {
        List<T> allFailedRecords = i10 == 1 ? this.mCacheManager.getAllFailedRecords() : i10 == 2 ? this.mCacheManager.getUnUploadRecords() : this.mCacheManager.getAllRecords();
        if (allFailedRecords == null || allFailedRecords.size() <= 0) {
            return;
        }
        try {
            this.mCacheManager.deleteRecords(allFailedRecords);
        } catch (DbException e2) {
            e2.printStackTrace();
        }
    }

    public boolean doUploadRecords(List<T> list) throws DbException {
        if (list != null && list.size() > 0) {
            int i10 = 0;
            boolean z10 = false;
            while (true) {
                if (i10 > this.retryCount) {
                    break;
                }
                if (!isAllowUploading()) {
                    return true;
                }
                LimitInterceptor.getInstance(this.mContext).addLimitCount();
                z10 = this.mUploader.upload(list);
                if (z10) {
                    this.mCacheManager.deleteRecords(list);
                    break;
                }
                i10++;
            }
            if (!z10) {
                processUploadingFailed(list);
                return false;
            }
        }
        return true;
    }

    public boolean isAllowUploading() {
        Map<Class, BaseInterceptor> map = this.mInterceptors;
        if (map != null && map.size() != 0) {
            Iterator<BaseInterceptor> iterator2 = this.mInterceptors.values().iterator2();
            while (iterator2.hasNext()) {
                if (!iterator2.next().isAllowUploading()) {
                    return false;
                }
            }
        }
        return true;
    }

    public abstract void processUploadingFailed(List<T> list) throws DbException;

    public void setLimitConfig(ACMLimitConfig aCMLimitConfig) {
        LimitInterceptor limitInterceptor = LimitInterceptor.getInstance(this.mContext);
        limitInterceptor.setConfig(aCMLimitConfig);
        this.mInterceptors.put(LimitInterceptor.class, limitInterceptor);
    }

    public void setMaxUploadRetry(long j10) {
        this.maxUploadRetry = j10;
    }

    public void setMaxUploadSize(int i10) {
        this.maxUploadSize = i10;
    }

    public void setRetryCount(int i10) {
        this.retryCount = i10;
    }

    public void setUploadEnable(boolean z10) {
        if (this.mEnableInterceptor == null) {
            this.mEnableInterceptor = new EnableInterceptor();
        }
        this.mEnableInterceptor.setEnabled(z10);
        this.mInterceptors.put(EnableInterceptor.class, this.mEnableInterceptor);
    }

    public void uploadFailed() {
        synchronized (this.mFailedLock) {
            if (this.isUploadingFailed) {
                return;
            }
            this.isUploadingFailed = true;
            this.mExecutor.execute(new AbstractSafeRunnable() { // from class: com.nirvana.tools.logger.upload.AbstractACMUploadManager.1
                @Override // com.nirvana.tools.logger.executor.AbstractSafeRunnable
                public void safeRun() {
                    if (AbstractACMUploadManager.this.mCacheManager.hasFailedRecords()) {
                        AbstractACMUploadManager.this.mExecutor.execute(new AbstractSafeRunnable() { // from class: com.nirvana.tools.logger.upload.AbstractACMUploadManager.1.1
                            @Override // com.nirvana.tools.logger.executor.AbstractSafeRunnable
                            public void safeRun() {
                                List<T> failedRecords;
                                long failedMaxID = AbstractACMUploadManager.this.mCacheManager.getFailedMaxID();
                                long j10 = 0;
                                int i10 = 0;
                                while (AbstractACMUploadManager.this.isAllowUploading()) {
                                    long j11 = i10;
                                    AbstractACMUploadManager abstractACMUploadManager = AbstractACMUploadManager.this;
                                    if (j11 >= abstractACMUploadManager.maxUploadRetry || (failedRecords = abstractACMUploadManager.mCacheManager.getFailedRecords(j10, failedMaxID, abstractACMUploadManager.maxUploadSize)) == null || failedRecords.size() <= 0) {
                                        break;
                                    }
                                    try {
                                        AbstractACMUploadManager.this.doUploadRecords(failedRecords);
                                        j10 = failedRecords.get(failedRecords.size() - 1).getId() + 1;
                                        i10++;
                                    } catch (DbException unused) {
                                    }
                                }
                                AbstractACMUploadManager.this.isUploadingFailed = false;
                            }
                        });
                    }
                }
            });
        }
    }
}
