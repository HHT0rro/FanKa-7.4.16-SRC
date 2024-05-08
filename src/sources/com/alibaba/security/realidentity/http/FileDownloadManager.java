package com.alibaba.security.realidentity.http;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alibaba.security.common.log.RPLogging;
import com.alibaba.security.common.utils.FileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class FileDownloadManager {
    private static final String LOCAL_MODEL_DATA = "local_model_data";
    private static final int MSG_DOWNLOAD_COMPLETE = 2;
    private static final int MSG_DOWNLOAD_FAILED = 3;
    private static final int MSG_PROGRESS_UPDATE = 1;
    private static final int STATE_DOWNLOAD_COMPLETE = 4;
    private static final int STATE_DOWNLOAD_ERROR = 3;
    private static final int STATE_DOWNLOAD_INIT = 0;
    private static final int STATE_DOWNLOAD_START = 1;
    private static final int STATE_DOWNLOAD_UPDATE = 2;
    private static final String TAG = "FileDownloadManager";
    private static final Handler mMainThreadHandler = new Handler(Looper.getMainLooper());
    private String mDownloadParentDir;
    private DownloadCallbackHandler mDownloadTasksProgressHandler;
    private SharedPreferences mSp;
    private SharedPreferences.Editor mSpEditor;
    private int mTotalTaskNum;
    private DownloadCallback mWholeDownloadCallback;
    private volatile int mDownloadState = 0;
    private ConcurrentHashMap<String, DownloadProgressCallback> mProgressCallbacks = new ConcurrentHashMap<>();
    private List<DownloadTask> mCurrentDownloadTasks = new ArrayList();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class DownloadCallbackHandler extends Handler {
        private HashMap<String, String> downloadFinishedTaskInfo;
        private HashMap<String, DownloadProgress> downloadProgressMap;
        private int mCurrentUnfinishedTasks;
        private boolean mIsTaskFailed;

        public DownloadCallbackHandler(Looper looper) {
            super(looper);
            this.mIsTaskFailed = false;
            this.downloadProgressMap = new HashMap<>();
            this.downloadFinishedTaskInfo = new HashMap<>();
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            DownloadProgress downloadProgress = (DownloadProgress) message.obj;
            if (downloadProgress == null) {
                return;
            }
            if (message.what == 1) {
                this.downloadProgressMap.put(downloadProgress.getTaskId(), downloadProgress);
            }
            int i10 = message.what;
            if (i10 == 1) {
                if (this.downloadProgressMap.size() != FileDownloadManager.this.mTotalTaskNum) {
                    return;
                }
                long j10 = 0;
                long j11 = 0;
                for (Map.Entry<String, DownloadProgress> entry : this.downloadProgressMap.entrySet()) {
                    j10 += entry.getValue().getTotalSize();
                    j11 += entry.getValue().getCurrentSize();
                }
                if (j10 != 0) {
                    int i11 = (int) ((((float) j11) / ((float) j10)) * 100.0f);
                    if (FileDownloadManager.this.mWholeDownloadCallback == null) {
                        return;
                    }
                    FileDownloadManager.this.mDownloadState = 2;
                    FileDownloadManager.this.mWholeDownloadCallback.onProgress(i11);
                    return;
                }
                return;
            }
            if (i10 != 2) {
                if (i10 != 3 || FileDownloadManager.this.mWholeDownloadCallback == null || this.mIsTaskFailed) {
                    return;
                }
                this.mIsTaskFailed = true;
                FileDownloadManager.this.mDownloadState = 3;
                FileDownloadManager.this.mWholeDownloadCallback.onError();
                return;
            }
            this.mCurrentUnfinishedTasks--;
            if (!TextUtils.isEmpty(downloadProgress.getDestFilePath())) {
                this.downloadFinishedTaskInfo.put(downloadProgress.getTaskId(), downloadProgress.getDestFilePath());
            }
            if (this.mCurrentUnfinishedTasks == 0) {
                RPLogging.d(FileDownloadManager.TAG, "File download progress > DONE");
                FileDownloadManager.this.mDownloadState = 4;
                if (FileDownloadManager.this.mWholeDownloadCallback == null) {
                    return;
                }
                FileDownloadManager.this.mWholeDownloadCallback.onComplete(this.downloadFinishedTaskInfo);
            }
        }

        public void setCurrentUnfinishedTask(int i10) {
            this.mCurrentUnfinishedTasks = i10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class DownloadProgress {
        private final long currentSize;
        private final String destFilePath;
        private final String taskId;
        private final long totalSize;

        public DownloadProgress(String str, long j10, long j11, String str2) {
            this.taskId = str;
            this.currentSize = j10;
            this.totalSize = j11;
            this.destFilePath = str2;
        }

        public long getCurrentSize() {
            return this.currentSize;
        }

        public String getDestFilePath() {
            return this.destFilePath;
        }

        public String getTaskId() {
            return this.taskId;
        }

        public long getTotalSize() {
            return this.totalSize;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class HOLDER {
        private static final FileDownloadManager SINGLE = new FileDownloadManager();

        private HOLDER() {
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class InnerDownloadCallback implements DownloadProgressCallback {
        private InnerDownloadCallback() {
        }

        @Override // com.alibaba.security.realidentity.http.DownloadProgressCallback
        public void onFailed(String str) {
            FileDownloadManager.this.mDownloadTasksProgressHandler.obtainMessage(3, new DownloadProgress(str, 0L, 0L, null)).sendToTarget();
        }

        @Override // com.alibaba.security.realidentity.http.DownloadProgressCallback
        public void onFinish(String str, String str2, String str3) {
            FileDownloadManager.this.mSpEditor.putString(str, str2);
            FileDownloadManager.this.mSpEditor.apply();
            FileDownloadManager.this.mDownloadTasksProgressHandler.obtainMessage(2, new DownloadProgress(str, 0L, 0L, str3)).sendToTarget();
        }

        @Override // com.alibaba.security.realidentity.http.DownloadProgressCallback
        public void onProgress(String str, long j10, long j11) {
            FileDownloadManager.this.mDownloadTasksProgressHandler.obtainMessage(1, new DownloadProgress(str, j10, j11, null)).sendToTarget();
        }

        @Override // com.alibaba.security.realidentity.http.DownloadProgressCallback
        public void onStart(String str) {
        }
    }

    private void downloadStart(DownloadTask downloadTask) {
        downloadTask.registerDownloadCallback(new InnerDownloadCallback());
        downloadTask.start();
    }

    private synchronized void downloadTaskFilter(List<DownloadTask> list) {
        Iterator<DownloadTask> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            DownloadTask next = iterator2.next();
            String string = this.mSp.getString(next.getTaskName(), null);
            if (string != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.mDownloadParentDir);
                String str = File.separator;
                sb2.append(str);
                sb2.append(next.getTaskName());
                sb2.append(str);
                sb2.append(next.getDownloadFileName());
                String sb3 = sb2.toString();
                if (string.equals(next.getTaskMd5()) && isFileExists(sb3)) {
                    iterator2.remove();
                } else {
                    FileUtils.delete(new File(sb3));
                    RPLogging.d(TAG, "Delete old file".concat(String.valueOf(sb3)));
                }
            }
        }
    }

    public static FileDownloadManager getInstance() {
        return HOLDER.SINGLE;
    }

    private boolean isFileExists(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return FileUtils.isExist(str);
    }

    public void initDownloadManager(Context context) {
        HandlerThread handlerThread = new HandlerThread("DownloadHandlerThread");
        handlerThread.start();
        this.mDownloadTasksProgressHandler = new DownloadCallbackHandler(handlerThread.getLooper());
        SharedPreferences sharedPreferences = context.getSharedPreferences(LOCAL_MODEL_DATA, 0);
        this.mSp = sharedPreferences;
        this.mSpEditor = sharedPreferences.edit();
    }

    public boolean isDownloading() {
        List<DownloadTask> list = this.mCurrentDownloadTasks;
        if (list == null || list.isEmpty()) {
            return false;
        }
        return this.mDownloadState == 1 || this.mDownloadState == 2;
    }

    public boolean isFileNotReady() {
        List<DownloadTask> list = this.mCurrentDownloadTasks;
        if (list == null || list.isEmpty()) {
            return false;
        }
        for (DownloadTask downloadTask : this.mCurrentDownloadTasks) {
            if (!this.mSp.getString(downloadTask.getTaskName(), "").equals(downloadTask.getTaskMd5())) {
                return true;
            }
        }
        return isDownloading();
    }

    public void registerDownloadCallback(DownloadCallback downloadCallback) {
        this.mWholeDownloadCallback = downloadCallback;
    }

    public void startDownload(Context context, List<DownloadTask> list, String str) {
        if (list != null && !list.isEmpty()) {
            this.mDownloadParentDir = str;
            downloadTaskFilter(list);
            if (list.isEmpty()) {
                this.mDownloadState = 4;
                RPLogging.i(TAG, "No download task of needing update found");
                return;
            }
            int size = list.size();
            this.mTotalTaskNum = size;
            this.mDownloadTasksProgressHandler.setCurrentUnfinishedTask(size);
            this.mDownloadState = 1;
            this.mCurrentDownloadTasks = list;
            Iterator<DownloadTask> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                downloadStart(iterator2.next());
            }
            return;
        }
        RPLogging.i(TAG, "No download task found");
    }

    public void unregisterDownloadCallback() {
        this.mWholeDownloadCallback = null;
    }
}
