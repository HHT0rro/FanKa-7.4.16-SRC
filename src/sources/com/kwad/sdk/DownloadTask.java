package com.kwad.sdk;

import android.net.NetworkInfo;
import android.os.Environment;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.u;
import com.kwad.framework.filedownloader.exception.FileDownloadNetworkPolicyException;
import com.kwad.framework.filedownloader.r;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.q;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class DownloadTask implements Serializable {
    private static final long serialVersionUID = -7092669850073266500L;
    private int mAllowedNetworkTypes;
    public transient com.kwad.framework.filedownloader.a mBaseDownloadTask;
    private String mDestinationDir;
    private String mDestinationFileName;
    private int mNotificationVisibility;
    private Map<String, String> mRequestHeaders;
    private Serializable mTag;
    private String mUrl;
    private boolean mUserPause;
    private boolean mWakeInstallApk;
    private transient List<a> mDownloadListeners = new ArrayList();
    private boolean mIsCanceled = false;
    public boolean downloadEnablePause = false;
    private boolean notificationRemoved = false;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class DownloadRequest implements Serializable {
        private static final long serialVersionUID = -3638290207248829674L;
        private int mAllowedNetworkTypes;
        private String mDestinationFileName;
        private String mDownloadUrl;
        private Serializable mTag;
        private final Map<String, String> mRequestHeaders = new HashMap();
        private boolean mInstallAfterDownload = true;

        @Deprecated
        private boolean mIsPhotoAdDownloadRequest = false;
        private int mNotificationVisibility = 0;
        public boolean downloadEnablePause = false;
        private String mDestinationDir = c.xL().xM().getPath();

        public DownloadRequest(String str) {
            this.mAllowedNetworkTypes = 3;
            this.mDownloadUrl = str;
            NetworkInfo cj = ag.cj(c.xL().getContext());
            if (cj != null && cj.getType() == 0) {
                this.mAllowedNetworkTypes = 3;
            } else {
                this.mAllowedNetworkTypes = 2;
            }
        }

        public DownloadRequest addRequestHeader(String str, String str2) {
            ap.gH(str);
            if (!str.contains(u.bD)) {
                if (str2 == null) {
                    str2 = "";
                }
                this.mRequestHeaders.put(str, str2);
                return this;
            }
            throw new IllegalArgumentException("header may not contain ':'");
        }

        public int getAllowedNetworkTypes() {
            return this.mAllowedNetworkTypes;
        }

        public String getDestinationDir() {
            return this.mDestinationDir;
        }

        public String getDestinationFileName() {
            return this.mDestinationFileName;
        }

        public String getDownloadUrl() {
            return this.mDownloadUrl;
        }

        public Serializable getTag() {
            return this.mTag;
        }

        public boolean isDownloadEnablePause() {
            return this.downloadEnablePause;
        }

        public boolean isPhotoAdDownloadRequest() {
            return this.mIsPhotoAdDownloadRequest;
        }

        public DownloadRequest setAllowedNetworkTypes(int i10) {
            this.mAllowedNetworkTypes = i10;
            return this;
        }

        public DownloadRequest setDestinationDir(String str) {
            this.mDestinationDir = str;
            return this;
        }

        public DownloadRequest setDestinationFileName(String str) {
            this.mDestinationFileName = str;
            return this;
        }

        public void setDownloadEnablePause(boolean z10) {
            this.downloadEnablePause = z10;
        }

        public DownloadRequest setInstallAfterDownload(boolean z10) {
            this.mInstallAfterDownload = z10;
            return this;
        }

        public void setIsPhotoAdDownloadRequest() {
            this.mIsPhotoAdDownloadRequest = true;
        }

        public DownloadRequest setNotificationVisibility(int i10) {
            this.mNotificationVisibility = i10;
            return this;
        }

        public DownloadRequest setTag(Serializable serializable) {
            this.mTag = serializable;
            return this;
        }
    }

    public DownloadTask(DownloadRequest downloadRequest) {
        initDownloadRequestParams(downloadRequest);
        instantiateDownloadTask();
        initDownloadTaskParams();
    }

    private void initDownloadRequestParams(DownloadRequest downloadRequest) {
        this.mWakeInstallApk = downloadRequest.mInstallAfterDownload;
        this.mUrl = downloadRequest.mDownloadUrl;
        this.mAllowedNetworkTypes = downloadRequest.mAllowedNetworkTypes;
        this.mNotificationVisibility = downloadRequest.mNotificationVisibility;
        this.mDestinationDir = downloadRequest.mDestinationDir;
        this.mDestinationFileName = downloadRequest.mDestinationFileName;
        this.mRequestHeaders = downloadRequest.mRequestHeaders;
        this.mTag = downloadRequest.mTag;
        this.downloadEnablePause = downloadRequest.isDownloadEnablePause();
    }

    private void initDownloadTaskParams() {
        this.mBaseDownloadTask.e(this.mTag);
        this.mBaseDownloadTask.bc((this.mAllowedNetworkTypes ^ 2) == 0);
        for (Map.Entry<String, String> entry : this.mRequestHeaders.entrySet()) {
            this.mBaseDownloadTask.ba(entry.getKey());
            this.mBaseDownloadTask.t(entry.getKey(), entry.getValue());
        }
    }

    private void notify(DownloadTask downloadTask, com.kwad.sdk.g.a<d> aVar) {
        d xN = c.xL().xN();
        if (xN == null) {
            return;
        }
        if (downloadTask.isCanceled()) {
            xN.bV(downloadTask.getId());
        } else {
            aVar.accept(xN);
        }
    }

    private void notifyDownloadCanceled() {
        d xN = c.xL().xN();
        if (xN == null) {
            return;
        }
        xN.bV(getId());
    }

    private void notifyDownloadCompleted(com.kwad.framework.filedownloader.a aVar) {
        if ((this.mNotificationVisibility & 2) != 0) {
            notify(this, new com.kwad.sdk.g.a<d>() { // from class: com.kwad.sdk.DownloadTask.3
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.g.a
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public void accept(d dVar) {
                    dVar.k(DownloadTask.this);
                }
            });
        }
    }

    private void notifyDownloadError(com.kwad.framework.filedownloader.a aVar) {
        if ((this.mNotificationVisibility & 1) != 0) {
            notify(this, new com.kwad.sdk.g.a<d>() { // from class: com.kwad.sdk.DownloadTask.5
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.g.a
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public void accept(d dVar) {
                    dVar.j(DownloadTask.this);
                }
            });
        }
    }

    private void notifyDownloadPending() {
        if ((this.mNotificationVisibility & 2) != 0) {
            notify(this, new com.kwad.sdk.g.a<d>() { // from class: com.kwad.sdk.DownloadTask.2
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.g.a
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public void accept(d dVar) {
                    dVar.i(DownloadTask.this);
                }
            });
        }
    }

    private void notifyDownloadProgress(com.kwad.framework.filedownloader.a aVar, final boolean z10) {
        if ((aVar.getSmallFileTotalBytes() == 0 && aVar.getSmallFileSoFarBytes() == 0) || TextUtils.isEmpty(aVar.getFilename()) || (this.mNotificationVisibility & 1) == 0) {
            return;
        }
        notify(this, new com.kwad.sdk.g.a<d>() { // from class: com.kwad.sdk.DownloadTask.4
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void accept(d dVar) {
                dVar.a(DownloadTask.this, z10);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onBlockCompleted(com.kwad.framework.filedownloader.a aVar) {
        try {
            Iterator<a> iterator2 = this.mDownloadListeners.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void onCanceled(com.kwad.framework.filedownloader.a aVar) {
        try {
            this.mIsCanceled = true;
            Iterator<a> iterator2 = this.mDownloadListeners.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().d(this);
            }
            aVar.cancel();
            notifyDownloadCanceled();
            r.uU().n(getId(), this.mBaseDownloadTask.getTargetFilePath());
            releaseDownloadTask();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCompleted(com.kwad.framework.filedownloader.a aVar) {
        try {
            Iterator<a> iterator2 = this.mDownloadListeners.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().a(this);
            }
            notifyDownloadCompleted(aVar);
            if (this.mWakeInstallApk) {
                installApk();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onConnected(com.kwad.framework.filedownloader.a aVar, String str, boolean z10, int i10, int i11) {
        long j10;
        long j11 = i11;
        try {
            if (new File(this.mDestinationDir).exists()) {
                j10 = com.kwad.sdk.crash.utils.h.getAvailableBytes(this.mDestinationDir);
            } else {
                j10 = com.kwad.sdk.crash.utils.h.getAvailableBytes(Environment.getExternalStorageDirectory().getPath());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            j10 = j11;
        }
        if (j10 < j11) {
            c.xL().cancel(aVar.getId());
            notifyDownloadCanceled();
            onLowStorage(aVar);
            return;
        }
        try {
            Iterator<a> iterator2 = this.mDownloadListeners.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next();
            }
            notifyDownloadProgress(aVar, false);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDownloading(com.kwad.framework.filedownloader.a aVar, int i10, int i11) {
        try {
            Iterator<a> iterator2 = this.mDownloadListeners.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().a(this, i10, i11);
            }
            notifyDownloadProgress(this.mBaseDownloadTask, false);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(com.kwad.framework.filedownloader.a aVar, Throwable th) {
        try {
            Iterator<a> iterator2 = this.mDownloadListeners.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().a(this, th);
            }
            notifyDownloadError(aVar);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void onLowStorage(com.kwad.framework.filedownloader.a aVar) {
        try {
            Iterator<a> iterator2 = this.mDownloadListeners.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().f(this);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPause(com.kwad.framework.filedownloader.a aVar, int i10, int i11) {
        try {
            Iterator<a> iterator2 = this.mDownloadListeners.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().c(this);
            }
            notifyDownloadProgress(aVar, true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPending(com.kwad.framework.filedownloader.a aVar, int i10, int i11) {
        try {
            Iterator<a> iterator2 = this.mDownloadListeners.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next();
            }
            notifyDownloadPending();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void onResume(com.kwad.framework.filedownloader.a aVar, int i10, int i11) {
        try {
            Iterator<a> iterator2 = this.mDownloadListeners.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().e(this);
            }
            notifyDownloadProgress(aVar, true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStarted(com.kwad.framework.filedownloader.a aVar) {
        try {
            Iterator<a> iterator2 = this.mDownloadListeners.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().b(this);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onWarn(com.kwad.framework.filedownloader.a aVar) {
        try {
            Iterator<a> iterator2 = this.mDownloadListeners.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.mDownloadListeners = new ArrayList();
    }

    private void releaseDownloadTask() {
        this.mBaseDownloadTask.a(null);
        clearListener();
    }

    public void addListener(a aVar) {
        if (aVar == null || this.mDownloadListeners.contains(aVar)) {
            return;
        }
        this.mDownloadListeners.add(aVar);
    }

    public void cancel() {
        try {
            onCanceled(this.mBaseDownloadTask);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void clearListener() {
        this.mDownloadListeners.clear();
    }

    public int downLoadProgress() {
        long smallFileTotalBytes = this.mBaseDownloadTask.getSmallFileTotalBytes();
        int smallFileSoFarBytes = smallFileTotalBytes != 0 ? (int) ((this.mBaseDownloadTask.getSmallFileSoFarBytes() * 100.0f) / ((float) smallFileTotalBytes)) : 0;
        if (smallFileSoFarBytes != 100 || q.M(new File(this.mBaseDownloadTask.getTargetFilePath()))) {
            return smallFileSoFarBytes;
        }
        return 0;
    }

    public int getAllowedNetworkTypes() {
        return this.mAllowedNetworkTypes;
    }

    public String getDestinationDir() {
        return this.mDestinationDir;
    }

    public String getFilename() {
        return this.mBaseDownloadTask.getFilename();
    }

    public int getId() {
        return this.mBaseDownloadTask.getId();
    }

    public int getNotificationVisibility() {
        return this.mNotificationVisibility;
    }

    public String getPath() {
        return this.mBaseDownloadTask.getPath();
    }

    public int getSmallFileSoFarBytes() {
        return this.mBaseDownloadTask.getSmallFileSoFarBytes();
    }

    public int getSmallFileTotalBytes() {
        return this.mBaseDownloadTask.getSmallFileTotalBytes();
    }

    public int getSpeed() {
        return this.mBaseDownloadTask.getSpeed();
    }

    public int getStatus() {
        return this.mBaseDownloadTask.tV();
    }

    public long getStatusUpdateTime() {
        return this.mBaseDownloadTask.getStatusUpdateTime();
    }

    public Object getTag() {
        return this.mBaseDownloadTask.getTag();
    }

    public String getTargetFilePath() {
        return this.mBaseDownloadTask.getTargetFilePath();
    }

    public String getUrl() {
        return this.mUrl;
    }

    public void installApk() {
        try {
            c.xL().g(this);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void instantiateDownloadTask() {
        r.uU();
        this.mBaseDownloadTask = r.bc(this.mUrl).ba(true).aX(3).c(TextUtils.isEmpty(this.mDestinationFileName) ? this.mDestinationDir : new File(this.mDestinationDir, this.mDestinationFileName).getPath(), TextUtils.isEmpty(this.mDestinationFileName)).a(new com.kwad.framework.filedownloader.i() { // from class: com.kwad.sdk.DownloadTask.1
            @Override // com.kwad.framework.filedownloader.i
            public final void a(com.kwad.framework.filedownloader.a aVar, String str, boolean z10, int i10, int i11) {
                DownloadTask.this.onConnected(aVar, str, z10, i10, i11);
            }

            @Override // com.kwad.framework.filedownloader.i
            public final void b(com.kwad.framework.filedownloader.a aVar, int i10, int i11) {
                DownloadTask.this.onDownloading(aVar, i10, i11);
            }

            @Override // com.kwad.framework.filedownloader.i
            public final void c(com.kwad.framework.filedownloader.a aVar) {
                DownloadTask.this.onCompleted(aVar);
            }

            @Override // com.kwad.framework.filedownloader.i
            public final void d(com.kwad.framework.filedownloader.a aVar) {
                DownloadTask.this.onWarn(aVar);
            }

            @Override // com.kwad.framework.filedownloader.i
            public final void a(com.kwad.framework.filedownloader.a aVar) {
                DownloadTask.this.onStarted(aVar);
            }

            @Override // com.kwad.framework.filedownloader.i
            public final void b(com.kwad.framework.filedownloader.a aVar) {
                DownloadTask.this.onBlockCompleted(aVar);
            }

            @Override // com.kwad.framework.filedownloader.i
            public final void c(com.kwad.framework.filedownloader.a aVar, int i10, int i11) {
                DownloadTask.this.onPause(aVar, i10, i11);
            }

            @Override // com.kwad.framework.filedownloader.i
            public final void a(com.kwad.framework.filedownloader.a aVar, int i10, int i11) {
                DownloadTask.this.onPending(aVar, i10, i11);
            }

            @Override // com.kwad.framework.filedownloader.i
            public final void a(com.kwad.framework.filedownloader.a aVar, Throwable th) {
                DownloadTask.this.onError(aVar, th);
            }
        });
    }

    public boolean isCanceled() {
        return this.mIsCanceled;
    }

    public boolean isCompleted() {
        return this.mBaseDownloadTask.tV() == -3;
    }

    public boolean isError() {
        return this.mBaseDownloadTask.tV() == -1;
    }

    public boolean isErrorBecauseWifiRequired() {
        return this.mBaseDownloadTask.uc() && isError() && (this.mBaseDownloadTask.tX() instanceof FileDownloadNetworkPolicyException);
    }

    public boolean isInvalid() {
        return this.mBaseDownloadTask.tV() == 0;
    }

    public boolean isNotificationRemoved() {
        return this.notificationRemoved;
    }

    public boolean isPaused() {
        return this.mBaseDownloadTask.tV() == -2;
    }

    public boolean isRunning() {
        return this.mBaseDownloadTask.isRunning();
    }

    public boolean isUserPause() {
        return this.mUserPause;
    }

    public void pause() {
        this.mBaseDownloadTask.pause();
        notifyDownloadProgress(this.mBaseDownloadTask, true);
    }

    public void removeListener(a aVar) {
        if (aVar != null) {
            this.mDownloadListeners.remove(aVar);
        }
    }

    public void resume(DownloadRequest downloadRequest) {
        if (ag.isNetworkConnected(c.xL().getContext())) {
            if (downloadRequest != null) {
                initDownloadRequestParams(downloadRequest);
                initDownloadTaskParams();
            }
            this.mUserPause = false;
            if (!this.mBaseDownloadTask.isRunning()) {
                try {
                    if (com.kwad.framework.filedownloader.d.d.bF(this.mBaseDownloadTask.tV())) {
                        this.mBaseDownloadTask.tN();
                    }
                    submit();
                    com.kwad.framework.filedownloader.a aVar = this.mBaseDownloadTask;
                    onResume(aVar, aVar.getSmallFileSoFarBytes(), this.mBaseDownloadTask.getSmallFileTotalBytes());
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            com.kwad.framework.filedownloader.a aVar2 = this.mBaseDownloadTask;
            onResume(aVar2, aVar2.getSmallFileSoFarBytes(), this.mBaseDownloadTask.getSmallFileTotalBytes());
        }
    }

    public void setAllowedNetworkTypes(int i10) {
        this.mAllowedNetworkTypes = i10;
        this.mBaseDownloadTask.bc((i10 ^ 2) == 0);
    }

    public void setNotificationRemoved(boolean z10) {
        this.notificationRemoved = z10;
    }

    public void submit() {
        try {
            if (this.mBaseDownloadTask.isRunning()) {
                return;
            }
            this.mBaseDownloadTask.start();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public com.kwad.framework.filedownloader.a unwrap() {
        return this.mBaseDownloadTask;
    }

    public void userPause() {
        this.mUserPause = true;
        pause();
    }
}
