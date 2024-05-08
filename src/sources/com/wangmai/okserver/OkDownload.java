package com.wangmai.okserver;

import android.os.Environment;
import com.wangmai.okhttp.db.DownloadManager;
import com.wangmai.okhttp.model.Progress;
import com.wangmai.okhttp.request.base.Request;
import com.wangmai.okhttp.utils.IOUtils;
import com.wangmai.okserver.download.DownloadTask;
import com.wangmai.okserver.download.DownloadThreadPool;
import com.wangmai.okserver.task.XExecutor;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class OkDownload {
    public String folder;
    public ConcurrentHashMap<String, DownloadTask> taskMap;
    public DownloadThreadPool threadPool;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class OkDownloadHolder {
        public static final OkDownload instance = new OkDownload();
    }

    public static OkDownload getInstance() {
        return OkDownloadHolder.instance;
    }

    public static DownloadTask request(String str, Request<File, ? extends Request> request) {
        Map<String, DownloadTask> taskMap = getInstance().getTaskMap();
        DownloadTask downloadTask = taskMap.get(str);
        if (downloadTask != null) {
            return downloadTask;
        }
        DownloadTask downloadTask2 = new DownloadTask(str, request);
        taskMap.put(str, downloadTask2);
        return downloadTask2;
    }

    public static DownloadTask restore(Progress progress) {
        Map<String, DownloadTask> taskMap = getInstance().getTaskMap();
        DownloadTask downloadTask = taskMap.get(progress.tag);
        if (downloadTask != null) {
            return downloadTask;
        }
        DownloadTask downloadTask2 = new DownloadTask(progress);
        taskMap.put(progress.tag, downloadTask2);
        return downloadTask2;
    }

    public void addOnAllTaskEndListener(XExecutor.OnAllTaskEndListener onAllTaskEndListener) {
        this.threadPool.getExecutor().addOnAllTaskEndListener(onAllTaskEndListener);
    }

    public String getFolder() {
        return this.folder;
    }

    public DownloadTask getTask(String str) {
        return this.taskMap.get(str);
    }

    public Map<String, DownloadTask> getTaskMap() {
        return this.taskMap;
    }

    public DownloadThreadPool getThreadPool() {
        return this.threadPool;
    }

    public boolean hasTask(String str) {
        return this.taskMap.containsKey(str);
    }

    public void init() {
    }

    public void pauseAll() {
        Iterator<Map.Entry<String, DownloadTask>> iterator2 = this.taskMap.entrySet().iterator2();
        while (iterator2.hasNext()) {
            DownloadTask value = iterator2.next().getValue();
            if (value != null && value.progress.status != 2) {
                value.pause();
            }
        }
        Iterator<Map.Entry<String, DownloadTask>> iterator22 = this.taskMap.entrySet().iterator2();
        while (iterator22.hasNext()) {
            DownloadTask value2 = iterator22.next().getValue();
            if (value2 != null && value2.progress.status == 2) {
                value2.pause();
            }
        }
    }

    public void removeAll() {
        removeAll(false);
    }

    public void removeOnAllTaskEndListener(XExecutor.OnAllTaskEndListener onAllTaskEndListener) {
        this.threadPool.getExecutor().removeOnAllTaskEndListener(onAllTaskEndListener);
    }

    public DownloadTask removeTask(String str) {
        return this.taskMap.remove(str);
    }

    public OkDownload setFolder(String str) {
        this.folder = str;
        return this;
    }

    public void startAll() {
        Iterator<Map.Entry<String, DownloadTask>> iterator2 = this.taskMap.entrySet().iterator2();
        while (iterator2.hasNext()) {
            DownloadTask value = iterator2.next().getValue();
            if (value != null) {
                value.start();
            }
        }
    }

    public OkDownload() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append((Object) Environment.getExternalStorageDirectory());
        String str = File.separator;
        sb2.append(str);
        sb2.append("download");
        sb2.append(str);
        String sb3 = sb2.toString();
        this.folder = sb3;
        IOUtils.createFolder(sb3);
        this.threadPool = new DownloadThreadPool();
        this.taskMap = new ConcurrentHashMap<>();
        List<Progress> downloading = DownloadManager.getInstance().getDownloading();
        for (Progress progress : downloading) {
            int i10 = progress.status;
            if (i10 == 1 || i10 == 2 || i10 == 3) {
                progress.status = 0;
            }
        }
        DownloadManager.getInstance().replace((List) downloading);
    }

    public void removeAll(boolean z10) {
        HashMap hashMap = new HashMap(this.taskMap);
        Iterator iterator2 = hashMap.entrySet().iterator2();
        while (iterator2.hasNext()) {
            DownloadTask downloadTask = (DownloadTask) ((Map.Entry) iterator2.next()).getValue();
            if (downloadTask != null && downloadTask.progress.status != 2) {
                downloadTask.remove(z10);
            }
        }
        Iterator iterator22 = hashMap.entrySet().iterator2();
        while (iterator22.hasNext()) {
            DownloadTask downloadTask2 = (DownloadTask) ((Map.Entry) iterator22.next()).getValue();
            if (downloadTask2 != null && downloadTask2.progress.status == 2) {
                downloadTask2.remove(z10);
            }
        }
    }

    public static List<DownloadTask> restore(List<Progress> list) {
        Map<String, DownloadTask> taskMap = getInstance().getTaskMap();
        ArrayList arrayList = new ArrayList();
        for (Progress progress : list) {
            DownloadTask downloadTask = taskMap.get(progress.tag);
            if (downloadTask == null) {
                downloadTask = new DownloadTask(progress);
                taskMap.put(progress.tag, downloadTask);
            }
            arrayList.add(downloadTask);
        }
        return arrayList;
    }
}
