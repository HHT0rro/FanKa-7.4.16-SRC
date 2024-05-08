package com.wangmai.okserver.upload;

import com.wangmai.helper.LogHelper;
import com.wangmai.okhttp.db.UploadManager;
import com.wangmai.okhttp.model.Progress;
import com.wangmai.okhttp.model.Response;
import com.wangmai.okhttp.request.base.ProgressRequestBody;
import com.wangmai.okhttp.request.base.Request;
import com.wangmai.okhttp.utils.HttpUtils;
import com.wangmai.okserver.OkUpload;
import com.wangmai.okserver.task.PriorityRunnable;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import okhttp3.Call;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class UploadTask<T> implements Runnable {
    public ThreadPoolExecutor executor;
    public Map<Object, UploadListener<T>> listeners;
    public PriorityRunnable priorityRunnable;
    public Progress progress;

    /* JADX WARN: Multi-variable type inference failed */
    public UploadTask(String str, Request<T, ? extends Request> request) {
        HttpUtils.checkNotNull(str, "tag == null");
        Progress progress = new Progress();
        this.progress = progress;
        progress.tag = str;
        progress.url = request.getBaseUrl();
        Progress progress2 = this.progress;
        progress2.status = 0;
        progress2.totalSize = -1L;
        progress2.request = request;
        this.executor = OkUpload.getInstance().getThreadPool().getExecutor();
        this.listeners = new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postLoading(final Progress progress) {
        updateDatabase(progress);
        HttpUtils.runOnUiThread(new Runnable() { // from class: com.wangmai.okserver.upload.UploadTask.5
            @Override // java.lang.Runnable
            public void run() {
                Iterator<UploadListener<T>> iterator2 = UploadTask.this.listeners.values().iterator2();
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
        HttpUtils.runOnUiThread(new Runnable() { // from class: com.wangmai.okserver.upload.UploadTask.6
            @Override // java.lang.Runnable
            public void run() {
                for (UploadListener<T> uploadListener : UploadTask.this.listeners.values()) {
                    uploadListener.onProgress(progress);
                    uploadListener.onError(progress);
                }
            }
        });
    }

    private void postOnFinish(final Progress progress, final T t2) {
        progress.speed = 0L;
        progress.fraction = 1.0f;
        progress.status = 5;
        updateDatabase(progress);
        HttpUtils.runOnUiThread(new Runnable() { // from class: com.wangmai.okserver.upload.UploadTask.7
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                for (UploadListener<T> uploadListener : UploadTask.this.listeners.values()) {
                    uploadListener.onProgress(progress);
                    uploadListener.onFinish(t2, progress);
                }
            }
        });
    }

    private void postOnRemove(final Progress progress) {
        updateDatabase(progress);
        HttpUtils.runOnUiThread(new Runnable() { // from class: com.wangmai.okserver.upload.UploadTask.8
            @Override // java.lang.Runnable
            public void run() {
                Iterator<UploadListener<T>> iterator2 = UploadTask.this.listeners.values().iterator2();
                while (iterator2.hasNext()) {
                    iterator2.next().onRemove(progress);
                }
                UploadTask.this.listeners.clear();
            }
        });
    }

    private void postOnStart(final Progress progress) {
        progress.speed = 0L;
        progress.status = 0;
        updateDatabase(progress);
        HttpUtils.runOnUiThread(new Runnable() { // from class: com.wangmai.okserver.upload.UploadTask.2
            @Override // java.lang.Runnable
            public void run() {
                Iterator<UploadListener<T>> iterator2 = UploadTask.this.listeners.values().iterator2();
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
        HttpUtils.runOnUiThread(new Runnable() { // from class: com.wangmai.okserver.upload.UploadTask.4
            @Override // java.lang.Runnable
            public void run() {
                Iterator<UploadListener<T>> iterator2 = UploadTask.this.listeners.values().iterator2();
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
        HttpUtils.runOnUiThread(new Runnable() { // from class: com.wangmai.okserver.upload.UploadTask.3
            @Override // java.lang.Runnable
            public void run() {
                Iterator<UploadListener<T>> iterator2 = UploadTask.this.listeners.values().iterator2();
                while (iterator2.hasNext()) {
                    iterator2.next().onProgress(progress);
                }
            }
        });
    }

    private void updateDatabase(Progress progress) {
        UploadManager.getInstance().update(Progress.buildUpdateContentValues(progress), progress.tag);
    }

    public UploadTask<T> extra1(Serializable serializable) {
        this.progress.extra1 = serializable;
        return this;
    }

    public UploadTask<T> extra2(Serializable serializable) {
        this.progress.extra2 = serializable;
        return this;
    }

    public UploadTask<T> extra3(Serializable serializable) {
        this.progress.extra3 = serializable;
        return this;
    }

    public void pause() {
        this.executor.remove(this.priorityRunnable);
        Progress progress = this.progress;
        int i10 = progress.status;
        if (i10 == 1) {
            postPause(progress);
            return;
        }
        if (i10 == 2) {
            progress.speed = 0L;
            progress.status = 3;
        } else {
            LogHelper.w("only the task with status WAITING(1) or LOADING(2) can pause, current status is " + this.progress.status);
        }
    }

    public UploadTask<T> priority(int i10) {
        this.progress.priority = i10;
        return this;
    }

    public UploadTask<T> register(UploadListener<T> uploadListener) {
        if (uploadListener != null) {
            this.listeners.put(uploadListener.tag, uploadListener);
        }
        return this;
    }

    public UploadTask<T> remove() {
        pause();
        UploadManager.getInstance().delete(this.progress.tag);
        UploadTask<T> uploadTask = (UploadTask<T>) OkUpload.getInstance().removeTask(this.progress.tag);
        postOnRemove(this.progress);
        return uploadTask;
    }

    public void restart() {
        pause();
        Progress progress = this.progress;
        progress.status = 0;
        progress.currentSize = 0L;
        progress.fraction = 0.0f;
        progress.speed = 0L;
        UploadManager.getInstance().replace((UploadManager) this.progress);
        start();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public void run() {
        Progress progress = this.progress;
        progress.status = 2;
        postLoading(progress);
        try {
            Request<?, ? extends Request> request = this.progress.request;
            final Call rawCall = request.getRawCall();
            request.uploadInterceptor(new ProgressRequestBody.UploadInterceptor() { // from class: com.wangmai.okserver.upload.UploadTask.1
                @Override // com.wangmai.okhttp.request.base.ProgressRequestBody.UploadInterceptor
                public void uploadProgress(Progress progress2) {
                    if (rawCall.isCanceled()) {
                        return;
                    }
                    Progress progress3 = UploadTask.this.progress;
                    if (progress3.status != 2) {
                        rawCall.cancel();
                        return;
                    }
                    progress3.from(progress2);
                    UploadTask uploadTask = UploadTask.this;
                    uploadTask.postLoading(uploadTask.progress);
                }
            });
            Response<?> execute = request.adapt().execute();
            if (execute.isSuccessful()) {
                postOnFinish(this.progress, execute.body());
            } else {
                postOnError(this.progress, execute.getException());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            postOnError(this.progress, e2);
        }
    }

    public UploadTask<T> save() {
        UploadManager.getInstance().replace((UploadManager) this.progress);
        return this;
    }

    public UploadTask<T> start() {
        if (OkUpload.getInstance().getTask(this.progress.tag) != null && UploadManager.getInstance().get(this.progress.tag) != null) {
            Progress progress = this.progress;
            int i10 = progress.status;
            if (i10 != 1 && i10 != 2) {
                postOnStart(progress);
                postWaiting(this.progress);
                PriorityRunnable priorityRunnable = new PriorityRunnable(this.progress.priority, this);
                this.priorityRunnable = priorityRunnable;
                this.executor.execute(priorityRunnable);
            } else {
                LogHelper.w("the task with tag " + this.progress.tag + " is already in the upload queue, current task status is " + this.progress.status);
            }
            return this;
        }
        throw new IllegalStateException("you must call UploadTask#save() before UploadTask#start()！");
    }

    public void unRegister(UploadListener<T> uploadListener) {
        HttpUtils.checkNotNull(uploadListener, "listener == null");
        this.listeners.remove(uploadListener.tag);
    }

    public void unRegister(String str) {
        HttpUtils.checkNotNull(str, "tag == null");
        this.listeners.remove(str);
    }

    public UploadTask(Progress progress) {
        HttpUtils.checkNotNull(progress, "progress == null");
        this.progress = progress;
        this.executor = OkUpload.getInstance().getThreadPool().getExecutor();
        this.listeners = new HashMap();
    }
}
