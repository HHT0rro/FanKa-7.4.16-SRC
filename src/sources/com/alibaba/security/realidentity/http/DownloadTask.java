package com.alibaba.security.realidentity.http;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.security.common.log.RPLogging;
import java.io.File;
import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class DownloadTask implements IDownloadOperator {
    public static final int DOWNLOAD_STATE_LOCAL_UP_TO_DATE = 2;
    public static final int DOWNLOAD_STATE_NEED_UPDATE = 1;
    public static final int DOWNLOAD_STATE_NO_EXIST = 0;
    private static final String TAG = "DownloadTask";
    private final Context mContext;
    private DownloadProgressCallback mDownloadCallback;
    private String mLocalFilePath;
    private String mTaskDownloadTargetDir;
    private String mTaskDownloadUrl;
    private String mTaskMd5;
    private String mTaskName;

    public DownloadTask(Context context, String str, String str2, String str3, String str4) {
        this.mTaskMd5 = str;
        this.mContext = context;
        this.mTaskDownloadUrl = str2;
        this.mTaskDownloadTargetDir = str3;
        this.mTaskName = str4;
    }

    private String getFileName(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(47) + 1;
        int length = str.length();
        int lastIndexOf2 = str.lastIndexOf(63);
        if (lastIndexOf2 == -1) {
            lastIndexOf2 = length;
        }
        int lastIndexOf3 = str.lastIndexOf(35);
        if (lastIndexOf3 != -1) {
            length = lastIndexOf3;
        }
        return str.substring(lastIndexOf, Math.min(lastIndexOf2, length));
    }

    @Override // com.alibaba.security.realidentity.http.IDownloadOperator
    public void cancel() {
    }

    public DownloadProgressCallback getDownloadCallback() {
        return this.mDownloadCallback;
    }

    public String getDownloadFileName() {
        return getFileName(this.mTaskDownloadUrl);
    }

    public String getLocalFilePath() {
        return this.mLocalFilePath;
    }

    public String getTaskDownloadTargetDir() {
        return this.mTaskDownloadTargetDir;
    }

    public String getTaskDownloadUrl() {
        return this.mTaskDownloadUrl;
    }

    public String getTaskMd5() {
        return this.mTaskMd5;
    }

    public String getTaskName() {
        return this.mTaskName;
    }

    @Override // com.alibaba.security.realidentity.http.IDownloadOperator
    public void pause() {
    }

    @Override // com.alibaba.security.realidentity.http.IDownloadOperator
    public void registerDownloadCallback(DownloadProgressCallback downloadProgressCallback) {
        this.mDownloadCallback = downloadProgressCallback;
    }

    @Override // com.alibaba.security.realidentity.http.IDownloadOperator
    public void start() {
        HttpRequestManager.getInstance().asyncDownloadFile(this.mContext, this.mTaskDownloadUrl, this.mTaskDownloadTargetDir + File.separator + this.mTaskName, new ProgressCallback() { // from class: com.alibaba.security.realidentity.http.DownloadTask.1
            @Override // com.alibaba.security.realidentity.http.IHttpCallback
            public void onFailure(Exception exc) {
                if (DownloadTask.this.mDownloadCallback != null) {
                    DownloadTask.this.mDownloadCallback.onFailed(DownloadTask.this.mTaskName);
                }
            }

            @Override // com.alibaba.security.realidentity.http.ProgressCallback
            public void onProgress(long j10, long j11) {
                if (DownloadTask.this.mDownloadCallback != null) {
                    RPLogging.d(DownloadTask.TAG, "onProgress: " + j10 + " totalSize: " + j11);
                    DownloadTask.this.mDownloadCallback.onProgress(DownloadTask.this.mTaskName, j10, j11);
                }
            }

            @Override // com.alibaba.security.realidentity.http.IHttpCallback
            public void onResponse(RpHttpResponse rpHttpResponse) throws IOException {
                if (DownloadTask.this.mDownloadCallback != null) {
                    DownloadTask.this.mDownloadCallback.onFinish(DownloadTask.this.mTaskName, DownloadTask.this.mTaskMd5, rpHttpResponse.getResponseBody());
                }
            }
        });
    }

    @Override // com.alibaba.security.realidentity.http.IDownloadOperator
    public void unregisterDownloadCallback() {
        this.mDownloadCallback = null;
    }
}
