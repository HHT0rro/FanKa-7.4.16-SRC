package com.wangmai.okserver.download;

import android.text.TextUtils;
import com.wangmai.okhttp.db.DownloadManager;
import com.wangmai.okhttp.exception.HttpException;
import com.wangmai.okhttp.exception.StorageException;
import com.wangmai.okhttp.model.Progress;
import com.wangmai.okhttp.request.base.Request;
import com.wangmai.okhttp.utils.HttpUtils;
import com.wangmai.okhttp.utils.IOUtils;
import com.wangmai.okserver.OkDownload;
import com.wangmai.okserver.task.PriorityRunnable;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class DownloadTask implements Runnable {
    public static final int BUFFER_SIZE = 8192;
    public ThreadPoolExecutor executor;
    public Map<Object, DownloadListener> listeners;
    public PriorityRunnable priorityRunnable;
    public Progress progress;

    public DownloadTask(String str, Request<File, ? extends Request> request) {
        HttpUtils.checkNotNull(str, "tag == null");
        Progress progress = new Progress();
        this.progress = progress;
        progress.tag = str;
        progress.folder = OkDownload.getInstance().getFolder();
        this.progress.url = request.getBaseUrl();
        Progress progress2 = this.progress;
        progress2.status = 0;
        progress2.totalSize = -1L;
        progress2.request = request;
        this.executor = OkDownload.getInstance().getThreadPool().getExecutor();
        this.listeners = new HashMap();
    }

    private void download(InputStream inputStream, RandomAccessFile randomAccessFile, Progress progress) throws IOException {
        if (inputStream == null || randomAccessFile == null) {
            return;
        }
        progress.status = 2;
        byte[] bArr = new byte[8192];
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 8192);
        while (true) {
            try {
                int read = bufferedInputStream.read(bArr, 0, 8192);
                if (read == -1 || progress.status != 2) {
                    break;
                }
                randomAccessFile.write(bArr, 0, read);
                try {
                    Progress.changeProgress(progress, read, progress.totalSize, new Progress.Action() { // from class: com.wangmai.okserver.download.DownloadTask.1
                        @Override // com.wangmai.okhttp.model.Progress.Action
                        public void call(Progress progress2) {
                            DownloadTask.this.postLoading(progress2);
                        }
                    });
                } catch (Throwable th) {
                    th = th;
                    IOUtils.closeQuietly(randomAccessFile);
                    IOUtils.closeQuietly(bufferedInputStream);
                    IOUtils.closeQuietly(inputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        IOUtils.closeQuietly(randomAccessFile);
        IOUtils.closeQuietly(bufferedInputStream);
        IOUtils.closeQuietly(inputStream);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postLoading(final Progress progress) {
        updateDatabase(progress);
        HttpUtils.runOnUiThread(new Runnable() { // from class: com.wangmai.okserver.download.DownloadTask.5
            @Override // java.lang.Runnable
            public void run() {
                Iterator<DownloadListener> iterator2 = DownloadTask.this.listeners.values().iterator2();
                while (iterator2.hasNext()) {
                    iterator2.next().onProgress(progress);
                }
            }
        });
    }

    private void postOnError(final Progress progress, Throwable th) {
        progress.speed = 0L;
        progress.status = 4;
        progress.exception = th;
        updateDatabase(progress);
        HttpUtils.runOnUiThread(new Runnable() { // from class: com.wangmai.okserver.download.DownloadTask.6
            @Override // java.lang.Runnable
            public void run() {
                for (DownloadListener downloadListener : DownloadTask.this.listeners.values()) {
                    downloadListener.onProgress(progress);
                    downloadListener.onError(progress);
                }
            }
        });
    }

    private void postOnFinish(final Progress progress, final File file) {
        progress.speed = 0L;
        progress.fraction = 1.0f;
        progress.status = 5;
        updateDatabase(progress);
        HttpUtils.runOnUiThread(new Runnable() { // from class: com.wangmai.okserver.download.DownloadTask.7
            @Override // java.lang.Runnable
            public void run() {
                for (DownloadListener downloadListener : DownloadTask.this.listeners.values()) {
                    downloadListener.onProgress(progress);
                    downloadListener.onFinish(file, progress);
                }
            }
        });
    }

    private void postOnRemove(final Progress progress) {
        updateDatabase(progress);
        HttpUtils.runOnUiThread(new Runnable() { // from class: com.wangmai.okserver.download.DownloadTask.8
            @Override // java.lang.Runnable
            public void run() {
                Iterator<DownloadListener> iterator2 = DownloadTask.this.listeners.values().iterator2();
                while (iterator2.hasNext()) {
                    iterator2.next().onRemove(progress);
                }
                DownloadTask.this.listeners.clear();
            }
        });
    }

    private void postOnStart(final Progress progress) {
        progress.speed = 0L;
        progress.status = 0;
        updateDatabase(progress);
        HttpUtils.runOnUiThread(new Runnable() { // from class: com.wangmai.okserver.download.DownloadTask.2
            @Override // java.lang.Runnable
            public void run() {
                Iterator<DownloadListener> iterator2 = DownloadTask.this.listeners.values().iterator2();
                while (iterator2.hasNext()) {
                    iterator2.next().onStart(progress);
                }
            }
        });
    }

    private void postPause(final Progress progress) {
        progress.speed = 0L;
        progress.status = 3;
        updateDatabase(progress);
        HttpUtils.runOnUiThread(new Runnable() { // from class: com.wangmai.okserver.download.DownloadTask.4
            @Override // java.lang.Runnable
            public void run() {
                Iterator<DownloadListener> iterator2 = DownloadTask.this.listeners.values().iterator2();
                while (iterator2.hasNext()) {
                    iterator2.next().onProgress(progress);
                }
            }
        });
    }

    private void postWaiting(final Progress progress) {
        progress.speed = 0L;
        progress.status = 1;
        updateDatabase(progress);
        HttpUtils.runOnUiThread(new Runnable() { // from class: com.wangmai.okserver.download.DownloadTask.3
            @Override // java.lang.Runnable
            public void run() {
                Iterator<DownloadListener> iterator2 = DownloadTask.this.listeners.values().iterator2();
                while (iterator2.hasNext()) {
                    iterator2.next().onProgress(progress);
                }
            }
        });
    }

    private void updateDatabase(Progress progress) {
        DownloadManager.getInstance().update(Progress.buildUpdateContentValues(progress), progress.tag);
    }

    public DownloadTask extra1(Serializable serializable) {
        this.progress.extra1 = serializable;
        return this;
    }

    public DownloadTask extra2(Serializable serializable) {
        this.progress.extra2 = serializable;
        return this;
    }

    public DownloadTask extra3(Serializable serializable) {
        this.progress.extra3 = serializable;
        return this;
    }

    public DownloadTask fileName(String str) {
        if (str != null && !TextUtils.isEmpty(str.trim())) {
            this.progress.fileName = str;
        }
        return this;
    }

    public DownloadTask folder(String str) {
        if (str != null && !TextUtils.isEmpty(str.trim())) {
            this.progress.folder = str;
        }
        return this;
    }

    public void pause() {
        this.executor.remove(this.priorityRunnable);
        Progress progress = this.progress;
        int i10 = progress.status;
        if (i10 == 1) {
            postPause(progress);
        } else if (i10 == 2) {
            progress.speed = 0L;
            progress.status = 3;
        }
    }

    public DownloadTask priority(int i10) {
        this.progress.priority = i10;
        return this;
    }

    public DownloadTask register(DownloadListener downloadListener) {
        if (downloadListener != null) {
            this.listeners.put(downloadListener.tag, downloadListener);
        }
        return this;
    }

    public void remove() {
        remove(false);
    }

    public void restart() {
        pause();
        IOUtils.delFileOrFolder(this.progress.filePath);
        Progress progress = this.progress;
        progress.status = 0;
        progress.currentSize = 0L;
        progress.fraction = 0.0f;
        progress.speed = 0L;
        DownloadManager.getInstance().replace((DownloadManager) this.progress);
        start();
    }

    @Override // java.lang.Runnable
    public void run() {
        File file;
        Progress progress = this.progress;
        long j10 = progress.currentSize;
        if (j10 < 0) {
            postOnError(progress, new Exception("file has expired!"));
            return;
        }
        if (j10 > 0 && !TextUtils.isEmpty(progress.filePath) && !new File(this.progress.filePath).exists()) {
            postOnError(this.progress, new Exception("file does not exist!"));
            return;
        }
        try {
            Request<?, ? extends Request> request = this.progress.request;
            request.headers("Range", "bytes=" + j10 + "-");
            Response execute = request.execute();
            int code = execute.code();
            if (code != 404 && code < 500) {
                ResponseBody body = execute.body();
                if (body == null) {
                    postOnError(this.progress, new HttpException("response body is null"));
                    return;
                }
                Progress progress2 = this.progress;
                if (progress2.totalSize == -1) {
                    progress2.totalSize = body.contentLength();
                }
                String str = this.progress.fileName;
                if (TextUtils.isEmpty(str)) {
                    str = HttpUtils.getNetFileName(execute, this.progress.url);
                    this.progress.fileName = str;
                }
                if (!IOUtils.createFolder(this.progress.folder)) {
                    postOnError(this.progress, StorageException.NOT_AVAILABLE());
                    return;
                }
                if (TextUtils.isEmpty(this.progress.filePath)) {
                    file = new File(this.progress.folder, str);
                    this.progress.filePath = file.getAbsolutePath();
                } else {
                    file = new File(this.progress.filePath);
                }
                if (j10 > 0 && !file.exists()) {
                    postOnError(this.progress, new Exception("file does not exist!"));
                    return;
                }
                Progress progress3 = this.progress;
                if (j10 > progress3.totalSize) {
                    postOnError(progress3, new Exception("file has expired!"));
                    return;
                }
                if (j10 == 0 && file.exists()) {
                    IOUtils.delFileOrFolder(file);
                }
                if (j10 == this.progress.totalSize && j10 > 0) {
                    if (file.exists() && j10 == file.length()) {
                        postOnFinish(this.progress, file);
                        return;
                    } else {
                        postOnError(this.progress, new Exception("file has expired!"));
                        return;
                    }
                }
                try {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                    randomAccessFile.seek(j10);
                    this.progress.currentSize = j10;
                    try {
                        DownloadManager.getInstance().replace((DownloadManager) this.progress);
                        download(body.byteStream(), randomAccessFile, this.progress);
                        Progress progress4 = this.progress;
                        int i10 = progress4.status;
                        if (i10 == 3) {
                            postPause(progress4);
                            return;
                        }
                        if (i10 == 2) {
                            long length = file.length();
                            Progress progress5 = this.progress;
                            if (length == progress5.totalSize) {
                                postOnFinish(progress5, file);
                                return;
                            } else {
                                postOnError(progress5, new Exception("file has expired!"));
                                return;
                            }
                        }
                        postOnError(progress4, new Exception("unknown exception!"));
                        return;
                    } catch (IOException e2) {
                        postOnError(this.progress, e2);
                        return;
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                    postOnError(this.progress, e10);
                    return;
                }
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(code);
            sb2.append("");
            postOnError(this.progress, HttpException.NET_ERROR());
        } catch (IOException e11) {
            postOnError(this.progress, e11);
        }
    }

    public DownloadTask save() {
        if (!TextUtils.isEmpty(this.progress.folder) && !TextUtils.isEmpty(this.progress.fileName)) {
            Progress progress = this.progress;
            progress.filePath = new File(progress.folder, progress.fileName).getAbsolutePath();
        }
        DownloadManager.getInstance().replace((DownloadManager) this.progress);
        return this;
    }

    public void start() {
        if (OkDownload.getInstance().getTask(this.progress.tag) != null && DownloadManager.getInstance().get(this.progress.tag) != null) {
            Progress progress = this.progress;
            int i10 = progress.status;
            if (i10 == 0 || i10 == 3 || i10 == 4) {
                postOnStart(progress);
                postWaiting(this.progress);
                PriorityRunnable priorityRunnable = new PriorityRunnable(this.progress.priority, this);
                this.priorityRunnable = priorityRunnable;
                this.executor.execute(priorityRunnable);
                return;
            }
            if (i10 == 5) {
                String str = progress.filePath;
                if (str == null) {
                    postOnError(progress, new StorageException("the file of the task with tag:" + this.progress.tag + " may be invalid or damaged, please call the method restart() to download again！"));
                    return;
                }
                File file = new File(str);
                if (file.exists()) {
                    long length = file.length();
                    Progress progress2 = this.progress;
                    if (length == progress2.totalSize) {
                        postOnFinish(progress2, new File(progress2.filePath));
                        return;
                    }
                }
                postOnError(this.progress, new StorageException("the file " + this.progress.filePath + " may be invalid or damaged, please call the method restart() to download again！"));
                return;
            }
            return;
        }
        throw new IllegalStateException("you must call DownloadTask#save() before DownloadTask#start()！");
    }

    public void unRegister(DownloadListener downloadListener) {
        HttpUtils.checkNotNull(downloadListener, "listener == null");
        this.listeners.remove(downloadListener.tag);
    }

    public DownloadTask remove(boolean z10) {
        pause();
        if (z10) {
            IOUtils.delFileOrFolder(this.progress.filePath);
        }
        DownloadManager.getInstance().delete(this.progress.tag);
        DownloadTask removeTask = OkDownload.getInstance().removeTask(this.progress.tag);
        postOnRemove(this.progress);
        return removeTask;
    }

    public void unRegister(String str) {
        HttpUtils.checkNotNull(str, "tag == null");
        this.listeners.remove(str);
    }

    public DownloadTask(Progress progress) {
        HttpUtils.checkNotNull(progress, "progress == null");
        this.progress = progress;
        this.executor = OkDownload.getInstance().getThreadPool().getExecutor();
        this.listeners = new HashMap();
    }
}
