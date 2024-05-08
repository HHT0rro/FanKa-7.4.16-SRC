package com.nirvana.tools.logger;

import android.content.Context;
import com.nirvana.tools.logger.cache.ACMLogCacheManager;
import com.nirvana.tools.logger.cache.db.DBHelpTool;
import com.nirvana.tools.logger.cache.db.DbException;
import com.nirvana.tools.logger.env.ACMComponent;
import com.nirvana.tools.logger.env.ACMComponentImpl;
import com.nirvana.tools.logger.executor.ReentrantSingleThreadExecutor;
import com.nirvana.tools.logger.model.ACMLimitConfig;
import com.nirvana.tools.logger.model.ACMLoggerRecord;
import com.nirvana.tools.logger.upload.ACMLogUploadManager;
import com.nirvana.tools.logger.upload.ACMUpload;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ACMLogger implements ACMComponent {
    private static final AtomicInteger LOGGER_COUNT = new AtomicInteger();
    private ACMLogCacheManager mCacheManager;
    private ACMComponent mComponentDelegate;
    private ACMLogUploadManager mUploadManager;

    public ACMLogger(Context context, ACMUpload<ACMLoggerRecord> aCMUpload) {
        this(context, aCMUpload, null);
    }

    public ACMLogger(Context context, ACMUpload<ACMLoggerRecord> aCMUpload, String str) {
        String str2;
        ReentrantSingleThreadExecutor reentrantSingleThreadExecutor = new ReentrantSingleThreadExecutor("ACMLogger" + LOGGER_COUNT.getAndAdd(1));
        if (str == null) {
            str2 = DBHelpTool.TABLE_NAME_LOGGER;
        } else {
            str2 = str + "_alitx_logger";
        }
        this.mCacheManager = new ACMLogCacheManager(context.getApplicationContext(), reentrantSingleThreadExecutor, str2, str);
        ACMLogUploadManager aCMLogUploadManager = new ACMLogUploadManager(context.getApplicationContext(), this.mCacheManager, aCMUpload, reentrantSingleThreadExecutor);
        this.mUploadManager = aCMLogUploadManager;
        this.mComponentDelegate = new ACMComponentImpl(aCMLogUploadManager);
    }

    private void internalLog(int i10, String str) {
        ACMLoggerRecord aCMLoggerRecord = new ACMLoggerRecord();
        aCMLoggerRecord.setLevel(i10);
        aCMLoggerRecord.setTimestamp(System.currentTimeMillis());
        aCMLoggerRecord.setContent(str);
        aCMLoggerRecord.setUploadCount(0);
        aCMLoggerRecord.setUploadFlag(0);
        aCMLoggerRecord.setStrategy(2);
        try {
            this.mCacheManager.cacheRecord(aCMLoggerRecord);
        } catch (DbException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.nirvana.tools.logger.env.ACMComponent
    public void clearLimitConfig() {
        this.mComponentDelegate.clearLimitConfig();
    }

    public void crash(String str) {
        internalLog(6, str);
    }

    public void debug(String str) {
        internalLog(2, str);
    }

    public void error(String str) {
        internalLog(5, str);
    }

    public void info(String str) {
        internalLog(3, str);
    }

    public void realTime(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        internalLog(Integer.MAX_VALUE, str);
        uploadLog(currentTimeMillis, System.currentTimeMillis() + 1000000, Integer.MAX_VALUE);
    }

    @Override // com.nirvana.tools.logger.env.ACMComponent
    public void setLimitConfig(ACMLimitConfig aCMLimitConfig) {
        this.mComponentDelegate.setLimitConfig(aCMLimitConfig);
    }

    @Override // com.nirvana.tools.logger.env.ACMComponent
    public void setUploadEnabled(boolean z10) {
        this.mComponentDelegate.setUploadEnabled(z10);
    }

    @Override // com.nirvana.tools.logger.env.ACMComponent
    public void uploadFailed() {
        this.mComponentDelegate.uploadFailed();
    }

    public void uploadLog(long j10, long j11, int i10) {
        this.mUploadManager.uploadLogger(j10, j11, i10);
    }

    public void verbose(String str) {
        internalLog(1, str);
    }

    public void warning(String str) {
        internalLog(4, str);
    }
}
