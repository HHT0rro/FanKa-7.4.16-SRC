package com.nirvana.tools.logger.upload;

import android.content.Context;
import com.nirvana.tools.logger.cache.ACMMonitorCacheManager;
import com.nirvana.tools.logger.cache.db.DbException;
import com.nirvana.tools.logger.executor.AbstractSafeRunnable;
import com.nirvana.tools.logger.executor.ReentrantSingleThreadExecutor;
import com.nirvana.tools.logger.executor.Timer;
import com.nirvana.tools.logger.model.ACMMonitorRecord;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ACMMonitorUploadManager extends AbstractACMUploadManager<ACMMonitorRecord> {
    private static final int MAX_RETRY_COUNT = 2;
    private ACMMonitorCacheManager mCacheManager;
    private Timer mNormalLooperTimer;
    private volatile int mUploadType;

    public ACMMonitorUploadManager(Context context, ACMMonitorCacheManager aCMMonitorCacheManager, ACMUpload<ACMMonitorRecord> aCMUpload, ReentrantSingleThreadExecutor reentrantSingleThreadExecutor) {
        super(context, aCMUpload, aCMMonitorCacheManager, reentrantSingleThreadExecutor);
        this.mUploadType = 1;
        this.mCacheManager = aCMMonitorCacheManager;
    }

    private void uploadMonitorByPage() {
        this.mExecutor.execute(new AbstractSafeRunnable() { // from class: com.nirvana.tools.logger.upload.ACMMonitorUploadManager.2
            @Override // com.nirvana.tools.logger.executor.AbstractSafeRunnable
            public void safeRun() {
                List<ACMMonitorRecord> normalMonitorRecords;
                int i10 = 0;
                while (ACMMonitorUploadManager.this.isAllowUploading()) {
                    long j10 = i10;
                    ACMMonitorUploadManager aCMMonitorUploadManager = ACMMonitorUploadManager.this;
                    if (j10 >= aCMMonitorUploadManager.maxUploadRetry || (normalMonitorRecords = aCMMonitorUploadManager.mCacheManager.getNormalMonitorRecords(ACMMonitorUploadManager.this.maxUploadSize)) == null || normalMonitorRecords.size() <= 0) {
                        return;
                    }
                    try {
                        ACMMonitorUploadManager.this.doUploadRecords(normalMonitorRecords);
                        i10++;
                    } catch (DbException e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
            }
        });
    }

    @Override // com.nirvana.tools.logger.upload.AbstractACMUploadManager
    public void processUploadingFailed(List<ACMMonitorRecord> list) throws DbException {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (ACMMonitorRecord aCMMonitorRecord : list) {
            if (aCMMonitorRecord.getUrgency() == 1 || aCMMonitorRecord.getUploadCount() >= 2) {
                arrayList.add(aCMMonitorRecord);
            } else {
                arrayList2.add(aCMMonitorRecord);
            }
        }
        this.mCacheManager.deleteRecords(arrayList);
        this.mCacheManager.addUploadCount(arrayList2);
    }

    public void setUploadType(int i10) {
        this.mUploadType = i10;
    }

    public void startLoop() {
        if (this.mUploadType != 2) {
            return;
        }
        Timer timer = this.mNormalLooperTimer;
        if (timer == null || !timer.isWorking()) {
            Timer timer2 = this.mNormalLooperTimer;
            if (timer2 != null) {
                timer2.resume();
            } else {
                this.mNormalLooperTimer = new Timer(AbstractACMUploadManager.TIME_INTERVAL, new AbstractSafeRunnable() { // from class: com.nirvana.tools.logger.upload.ACMMonitorUploadManager.1
                    @Override // com.nirvana.tools.logger.executor.AbstractSafeRunnable
                    public void safeRun() {
                        if (ACMMonitorUploadManager.this.isAllowUploading()) {
                            try {
                                ACMMonitorUploadManager.this.doUploadRecords(ACMMonitorUploadManager.this.mCacheManager.getNormalMonitorRecords(ACMMonitorUploadManager.this.maxUploadSize));
                            } catch (DbException e2) {
                                e2.printStackTrace();
                                ACMMonitorUploadManager.this.stopLoop();
                            }
                            if (ACMMonitorUploadManager.this.mCacheManager.hasNormalRecords()) {
                                return;
                            }
                            ACMMonitorUploadManager.this.mNormalLooperTimer.pause();
                        }
                    }
                });
            }
        }
    }

    public void stopLoop() {
        Timer timer = this.mNormalLooperTimer;
        if (timer == null || !timer.isWorking()) {
            return;
        }
        this.mNormalLooperTimer.quit();
        this.mNormalLooperTimer = null;
    }

    public void uploadManual() {
        stopLoop();
        uploadMonitorByPage();
    }
}
