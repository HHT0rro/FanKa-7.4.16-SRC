package com.nirvana.tools.logger.upload;

import android.content.Context;
import com.nirvana.tools.logger.cache.ACMLogCacheManager;
import com.nirvana.tools.logger.cache.db.DbException;
import com.nirvana.tools.logger.executor.AbstractSafeRunnable;
import com.nirvana.tools.logger.executor.ReentrantSingleThreadExecutor;
import com.nirvana.tools.logger.model.ACMLoggerRecord;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ACMLogUploadManager extends AbstractACMUploadManager<ACMLoggerRecord> {
    private ACMLogCacheManager mCacheManager;

    public ACMLogUploadManager(Context context, ACMLogCacheManager aCMLogCacheManager, ACMUpload<ACMLoggerRecord> aCMUpload, ReentrantSingleThreadExecutor reentrantSingleThreadExecutor) {
        super(context, aCMUpload, aCMLogCacheManager, reentrantSingleThreadExecutor);
        this.mCacheManager = aCMLogCacheManager;
    }

    @Override // com.nirvana.tools.logger.upload.AbstractACMUploadManager
    public void processUploadingFailed(List<ACMLoggerRecord> list) throws DbException {
        this.mCacheManager.addUploadCount(list);
    }

    public void uploadLogger(final long j10, final long j11, final int i10) {
        this.mExecutor.execute(new AbstractSafeRunnable() { // from class: com.nirvana.tools.logger.upload.ACMLogUploadManager.1
            @Override // com.nirvana.tools.logger.executor.AbstractSafeRunnable
            public void safeRun() {
                List<ACMLoggerRecord> loggerRecords;
                for (int i11 = 0; ACMLogUploadManager.this.isAllowUploading() && i11 < 100 && (loggerRecords = ACMLogUploadManager.this.mCacheManager.getLoggerRecords(j10, j11, 20, 0, i10)) != null && loggerRecords.size() > 0; i11++) {
                    try {
                        ACMLogUploadManager.this.doUploadRecords(loggerRecords);
                    } catch (DbException unused) {
                        return;
                    }
                }
            }
        });
    }
}
