package com.nirvana.tools.logger;

import android.content.Context;
import com.nirvana.tools.logger.cache.ACMMonitorCacheManager;
import com.nirvana.tools.logger.cache.db.DBHelpTool;
import com.nirvana.tools.logger.cache.db.DbException;
import com.nirvana.tools.logger.env.ACMComponent;
import com.nirvana.tools.logger.env.ACMComponentImpl;
import com.nirvana.tools.logger.executor.ReentrantSingleThreadExecutor;
import com.nirvana.tools.logger.model.ACMLimitConfig;
import com.nirvana.tools.logger.model.ACMMonitorRecord;
import com.nirvana.tools.logger.upload.ACMMonitorUploadManager;
import com.nirvana.tools.logger.upload.ACMUpload;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ACMMonitor implements ACMComponent {
    private static final AtomicInteger MONITOR_COUNT = new AtomicInteger();
    public static final int UPLOAD_TYPE_MANUAL = 1;
    public static final int UPLOAD_TYPE_TIMER = 2;
    private ACMMonitorCacheManager mCacheManager;
    private ACMComponentImpl mEnv;
    private ACMMonitorUploadManager mUploadManager;

    public ACMMonitor(Context context, ACMUpload<ACMMonitorRecord> aCMUpload) {
        this(context, aCMUpload, null);
    }

    public ACMMonitor(Context context, ACMUpload<ACMMonitorRecord> aCMUpload, String str) {
        String str2;
        ReentrantSingleThreadExecutor reentrantSingleThreadExecutor = new ReentrantSingleThreadExecutor("ACMMonitor" + MONITOR_COUNT.getAndAdd(1));
        if (str == null) {
            str2 = DBHelpTool.TABLE_NAME_MONITOR;
        } else {
            str2 = str + "_alitx_monitor";
        }
        this.mCacheManager = new ACMMonitorCacheManager(context.getApplicationContext(), reentrantSingleThreadExecutor, str2, str);
        ACMMonitorUploadManager aCMMonitorUploadManager = new ACMMonitorUploadManager(context.getApplicationContext(), this.mCacheManager, aCMUpload, reentrantSingleThreadExecutor);
        this.mUploadManager = aCMMonitorUploadManager;
        this.mEnv = new ACMComponentImpl(aCMMonitorUploadManager);
    }

    private void cacheMonitor(String str, int i10) {
        ACMMonitorRecord aCMMonitorRecord = new ACMMonitorRecord(i10);
        aCMMonitorRecord.setContent(str);
        try {
            this.mCacheManager.cacheRecord(aCMMonitorRecord);
        } catch (DbException e2) {
            e2.printStackTrace();
        }
    }

    private void cacheMonitorRecords(List<ACMMonitorRecord> list) {
        try {
            this.mCacheManager.cacheRecords(list);
        } catch (DbException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.nirvana.tools.logger.env.ACMComponent
    public void clearLimitConfig() {
        this.mEnv.clearLimitConfig();
    }

    public void deleteRecordsByFlag(int i10) {
        this.mUploadManager.deleteRecordsByFlag(i10);
    }

    public void monitor(String str, int i10) {
        cacheMonitor(str, i10);
    }

    public void monitor(Map<String, String> map, int i10) {
        cacheMonitor(new JSONObject(map).toString(), i10);
    }

    public void monitorRecords(List<ACMMonitorRecord> list) {
        cacheMonitorRecords(list);
    }

    @Override // com.nirvana.tools.logger.env.ACMComponent
    public void setLimitConfig(ACMLimitConfig aCMLimitConfig) {
        this.mEnv.setLimitConfig(aCMLimitConfig);
    }

    public void setMaxUploadRetry(long j10) {
        this.mUploadManager.setMaxUploadRetry(j10);
    }

    public void setMaxUploadSize(int i10) {
        this.mUploadManager.setMaxUploadSize(i10);
    }

    public void setRetryCount(int i10) {
        this.mUploadManager.setRetryCount(i10);
    }

    @Override // com.nirvana.tools.logger.env.ACMComponent
    public void setUploadEnabled(boolean z10) {
        this.mEnv.setUploadEnabled(z10);
    }

    public void setUploadType(int i10) {
        if (i10 == 1 || i10 == 2) {
            this.mUploadManager.setUploadType(i10);
        }
    }

    @Override // com.nirvana.tools.logger.env.ACMComponent
    public void uploadFailed() {
        this.mEnv.uploadFailed();
    }

    public void uploadManual() {
        this.mUploadManager.uploadManual();
    }
}
