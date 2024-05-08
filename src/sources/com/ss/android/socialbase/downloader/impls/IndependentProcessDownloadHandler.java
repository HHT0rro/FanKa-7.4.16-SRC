package com.ss.android.socialbase.downloader.impls;

import android.app.Notification;
import android.os.IBinder;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.depend.ProcessCallback;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.IDownloadAidlService;
import com.ss.android.socialbase.downloader.downloader.IDownloadProxy;
import com.ss.android.socialbase.downloader.downloader.IDownloadServiceConnectionListener;
import com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler;
import com.ss.android.socialbase.downloader.downloader.IndependentProcessDownloadService;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadChunk;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.ss.android.socialbase.downloader.utils.IPCUtils;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class IndependentProcessDownloadHandler implements IDownloadProxy, IDownloadServiceConnectionListener {
    private static final String TAG = "IndependentProcessDownloadHandler";
    private volatile IDownloadAidlService aidlService;
    private IDownloadProxy downloadProxy = new ProcessDownloadHandler();
    private IDownloadServiceHandler<IndependentProcessDownloadService> downloadServiceHandler;

    public IndependentProcessDownloadHandler() {
        IDownloadServiceHandler<IndependentProcessDownloadService> independentDownloadServiceHandler = DownloadComponentManager.getIndependentDownloadServiceHandler();
        this.downloadServiceHandler = independentDownloadServiceHandler;
        independentDownloadServiceHandler.setServiceConnectionListener(this);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void addDownloadChunk(DownloadChunk downloadChunk) {
        if (this.aidlService == null) {
            this.downloadProxy.addDownloadChunk(downloadChunk);
            return;
        }
        try {
            this.aidlService.addDownloadChunk(downloadChunk);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void addDownloadListener(int i10, int i11, IDownloadListener iDownloadListener, ListenerType listenerType, boolean z10) {
        if (this.aidlService == null) {
            return;
        }
        try {
            this.aidlService.addDownloadListener(i10, i11, IPCUtils.convertListenerToAidl(iDownloadListener, listenerType != ListenerType.SUB), listenerType.ordinal(), z10);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void addProcessCallback(ProcessCallback processCallback) {
        if (this.aidlService != null) {
            try {
                this.aidlService.addProcessCallback(IPCUtils.convertProcessCallbackToAidl(processCallback));
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean canResume(int i10) {
        if (this.aidlService == null) {
            return false;
        }
        try {
            return this.aidlService.canResume(i10);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void cancel(int i10, boolean z10) {
        if (this.aidlService == null) {
            return;
        }
        try {
            this.aidlService.cancel(i10, z10);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void clearData() {
        if (this.aidlService == null) {
            this.downloadProxy.clearData();
            return;
        }
        try {
            this.aidlService.clearData();
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void clearDownloadData(int i10, boolean z10) {
        if (this.aidlService == null) {
            this.downloadProxy.clearDownloadData(i10, z10);
            return;
        }
        try {
            this.aidlService.clearDownloadData(i10, z10);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void dispatchProcessCallback(int i10, int i11) {
        if (this.aidlService != null) {
            try {
                this.aidlService.dispatchProcessCallback(i10, i11);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void forceDownloadIngoreRecommendSize(int i10) {
        if (this.aidlService == null) {
            this.downloadProxy.forceDownloadIngoreRecommendSize(i10);
            return;
        }
        try {
            this.aidlService.forceDownloadIngoreRecommendSize(i10);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getAllDownloadInfo() {
        if (this.aidlService == null) {
            return this.downloadProxy.getAllDownloadInfo();
        }
        try {
            return this.aidlService.getAllDownloadInfo();
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public long getCurBytes(int i10) {
        if (this.aidlService == null) {
            return 0L;
        }
        try {
            return this.aidlService.getCurBytes(i10);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadChunk> getDownloadChunk(int i10) {
        if (this.aidlService == null) {
            return this.downloadProxy.getDownloadChunk(i10);
        }
        try {
            return this.aidlService.getDownloadChunk(i10);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public IDownloadFileUriProvider getDownloadFileUriProvider(int i10) {
        if (this.aidlService == null) {
            return null;
        }
        try {
            return IPCUtils.convertFileProviderFromAidl(this.aidlService.getDownloadFileUriProvider(i10));
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public int getDownloadId(String str, String str2) {
        return DownloadComponentManager.getDownloadId(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public DownloadInfo getDownloadInfo(int i10) {
        if (this.aidlService == null) {
            return this.downloadProxy.getDownloadInfo(i10);
        }
        try {
            return this.aidlService.getDownloadInfo(i10);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getDownloadInfoList(String str) {
        if (this.aidlService == null) {
            return this.downloadProxy.getDownloadInfoList(str);
        }
        try {
            return this.aidlService.getDownloadInfoList(str);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public IDownloadNotificationEventListener getDownloadNotificationEventListener(int i10) {
        if (this.aidlService == null) {
            return null;
        }
        try {
            return IPCUtils.convertDownloadNotificationEventListenerFromAidl(this.aidlService.getDownloadNotificationEventListener(i10));
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public int getDownloadWithIndependentProcessStatus(int i10) {
        if (this.aidlService == null) {
            return DownloadProcessDispatcher.getInstance().getDownloadWithIndependentProcessStatusInner(i10);
        }
        try {
            return this.aidlService.getDownloadWithIndependentProcessStatus(i10);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String str) {
        if (this.aidlService == null) {
            return null;
        }
        try {
            return this.aidlService.getDownloadingDownloadInfosWithMimeType(str);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getFailedDownloadInfosWithMimeType(String str) {
        if (this.aidlService == null) {
            return this.downloadProxy.getFailedDownloadInfosWithMimeType(str);
        }
        try {
            return this.aidlService.getFailedDownloadInfosWithMimeType(str);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public INotificationClickCallback getNotificationClickCallback(int i10) {
        if (this.aidlService == null) {
            return null;
        }
        try {
            return IPCUtils.convertNotificationClickCallbackFromAidl(this.aidlService.getNotificationClickCallback(i10));
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public int getStatus(int i10) {
        if (this.aidlService == null) {
            return 0;
        }
        try {
            return this.aidlService.getStatus(i10);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String str) {
        if (this.aidlService == null) {
            return this.downloadProxy.getSuccessedDownloadInfosWithMimeType(str);
        }
        try {
            return this.aidlService.getSuccessedDownloadInfosWithMimeType(str);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String str) {
        if (this.aidlService == null) {
            return this.downloadProxy.getUnCompletedDownloadInfosWithMimeType(str);
        }
        try {
            return this.aidlService.getUnCompletedDownloadInfosWithMimeType(str);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isDownloadCacheSyncSuccess() {
        if (this.aidlService == null) {
            return this.downloadProxy.isDownloadCacheSyncSuccess();
        }
        try {
            return this.aidlService.isDownloadCacheSyncSuccess();
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isDownloadSuccessAndFileNotExist(DownloadInfo downloadInfo) {
        if (this.aidlService == null) {
            return this.downloadProxy.isDownloadSuccessAndFileNotExist(downloadInfo);
        }
        try {
            this.aidlService.isDownloadSuccessAndFileNotExist(downloadInfo);
            return false;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isDownloading(int i10) {
        if (this.aidlService == null) {
            return false;
        }
        try {
            return this.aidlService.isDownloading(i10);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isHttpServiceInit() {
        return DownloadComponentManager.isHttpServiceInit();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isServiceAlive() {
        return this.aidlService != null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isServiceForeground() {
        if (this.aidlService == null) {
            Logger.w(TAG, "isServiceForeground, aidlService is null");
            return false;
        }
        Logger.i(TAG, "aidlService.isServiceForeground");
        try {
            return this.aidlService.isServiceForeground();
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceConnectionListener
    public void onServiceConnection(IBinder iBinder) {
        this.aidlService = IDownloadAidlService.Stub.asInterface(iBinder);
        if (DownloadUtils.isMainProcess()) {
            addProcessCallback(new ProcessCallback() { // from class: com.ss.android.socialbase.downloader.impls.IndependentProcessDownloadHandler.1
                @Override // com.ss.android.socialbase.downloader.depend.ProcessCallback
                public void callback(int i10, int i11) {
                    if (i11 != 1) {
                        if (i11 == 2) {
                            Downloader.getInstance(DownloadComponentManager.getAppContext()).cancel(i10);
                        }
                    } else {
                        Downloader.getInstance(DownloadComponentManager.getAppContext()).pause(i10);
                        List<DownloadChunk> downloadChunk = DownloadProxy.get(false).getDownloadChunk(i10);
                        if (downloadChunk != null) {
                            DownloadProxy.get(true).syncDownloadChunks(i10, DownloadUtils.parseHostChunkList(downloadChunk));
                        }
                    }
                }
            });
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceConnectionListener
    public void onServiceDisConnection() {
        this.aidlService = null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void pause(int i10) {
        if (this.aidlService == null) {
            return;
        }
        try {
            this.aidlService.pause(i10);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void pauseAll() {
        if (this.aidlService == null) {
            return;
        }
        try {
            this.aidlService.pauseAll();
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void removeAllDownloadChunk(int i10) {
        if (this.aidlService == null) {
            this.downloadProxy.removeAllDownloadChunk(i10);
            return;
        }
        try {
            this.aidlService.removeAllDownloadChunk(i10);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean removeDownloadInfo(int i10) {
        if (this.aidlService == null) {
            return this.downloadProxy.removeDownloadInfo(i10);
        }
        try {
            return this.aidlService.removeDownloadInfo(i10);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void removeDownloadListener(int i10, int i11, IDownloadListener iDownloadListener, ListenerType listenerType, boolean z10) {
        if (this.aidlService == null) {
            return;
        }
        try {
            this.aidlService.removeDownloadListener(i10, i11, IPCUtils.convertListenerToAidl(iDownloadListener, listenerType != ListenerType.SUB), listenerType.ordinal(), z10);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean removeDownloadTaskData(int i10) {
        if (this.aidlService == null) {
            return this.downloadProxy.removeDownloadTaskData(i10);
        }
        try {
            return this.aidlService.removeDownloadTaskData(i10);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void resetDownloadData(int i10, boolean z10) {
        if (this.aidlService == null) {
            this.downloadProxy.resetDownloadData(i10, z10);
            return;
        }
        try {
            this.aidlService.resetDownloadData(i10, z10);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void restart(int i10) {
        if (this.aidlService == null) {
            return;
        }
        try {
            this.aidlService.restart(i10);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void restartAllFailedDownloadTasks(List<String> list) {
        if (this.aidlService == null) {
            this.downloadProxy.restartAllFailedDownloadTasks(list);
            return;
        }
        try {
            this.aidlService.restartAllFailedDownloadTasks(list);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void restartAllPauseReserveOnWifiDownloadTasks(List<String> list) {
        if (this.aidlService == null) {
            this.downloadProxy.restartAllPauseReserveOnWifiDownloadTasks(list);
            return;
        }
        try {
            this.aidlService.restartAllPauseReserveOnWifiDownloadTasks(list);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void resume(int i10) {
        if (this.aidlService == null) {
            return;
        }
        try {
            this.aidlService.resume(i10);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean retryDelayStart(int i10) {
        if (this.aidlService == null) {
            return false;
        }
        try {
            return this.aidlService.retryDelayStart(i10);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void setDownloadNotificationEventListener(int i10, IDownloadNotificationEventListener iDownloadNotificationEventListener) {
        if (this.aidlService != null) {
            try {
                this.aidlService.setDownloadNotificationEventListener(i10, IPCUtils.convertDownloadNotificationEventListenerToAidl(iDownloadNotificationEventListener));
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void setDownloadWithIndependentProcessStatus(int i10, boolean z10) {
        if (this.aidlService == null) {
            return;
        }
        try {
            this.aidlService.setDownloadWithIndependentProcessStatus(i10, z10);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void setLogLevel(int i10) {
        IDownloadServiceHandler<IndependentProcessDownloadService> iDownloadServiceHandler = this.downloadServiceHandler;
        if (iDownloadServiceHandler != null) {
            iDownloadServiceHandler.setLogLevel(i10);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void setThrottleNetSpeed(int i10, long j10) {
        if (this.aidlService == null) {
            return;
        }
        try {
            this.aidlService.setThrottleNetSpeed(i10, j10);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void startForeground(int i10, Notification notification) {
        if (this.aidlService == null) {
            Logger.w(TAG, "startForeground, aidlService is null");
            return;
        }
        Logger.i(TAG, "aidlService.startForeground, id = " + i10);
        try {
            this.aidlService.startForeground(i10, notification);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void startService() {
        IDownloadServiceHandler<IndependentProcessDownloadService> iDownloadServiceHandler = this.downloadServiceHandler;
        if (iDownloadServiceHandler != null) {
            iDownloadServiceHandler.startService();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void stopForeground(boolean z10, boolean z11) {
        if (this.aidlService == null) {
            Logger.w(TAG, "stopForeground, aidlService is null");
            return;
        }
        Logger.i(TAG, "aidlService.stopForeground");
        try {
            this.aidlService.stopForeground(z11);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void syncDownloadChunks(int i10, List<DownloadChunk> list) {
        if (this.aidlService == null) {
            return;
        }
        try {
            this.aidlService.syncDownloadChunks(i10, list);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void syncDownloadInfo(DownloadInfo downloadInfo) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void syncDownloadInfoFromOtherCache(int i10, List<DownloadChunk> list) {
        if (this.aidlService == null) {
            this.downloadProxy.syncDownloadInfoFromOtherCache(i10, list);
            return;
        }
        try {
            this.aidlService.syncDownloadInfoFromOtherCache(i10, list);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void tryDownload(DownloadTask downloadTask) {
        IDownloadServiceHandler<IndependentProcessDownloadService> iDownloadServiceHandler;
        if (downloadTask == null || (iDownloadServiceHandler = this.downloadServiceHandler) == null) {
            return;
        }
        iDownloadServiceHandler.tryDownload(downloadTask);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void tryDownloadWithEngine(DownloadTask downloadTask) {
        IDownloadServiceHandler<IndependentProcessDownloadService> iDownloadServiceHandler;
        if (downloadTask == null || (iDownloadServiceHandler = this.downloadServiceHandler) == null) {
            return;
        }
        iDownloadServiceHandler.tryDownloadWithEngine(downloadTask);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void updateDownloadChunk(int i10, int i11, long j10) {
        if (this.aidlService == null) {
            this.downloadProxy.updateDownloadChunk(i10, i11, j10);
            return;
        }
        try {
            this.aidlService.updateDownloadChunk(i10, i11, j10);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean updateDownloadInfo(DownloadInfo downloadInfo) {
        if (this.aidlService == null) {
            return this.downloadProxy.updateDownloadInfo(downloadInfo);
        }
        try {
            return this.aidlService.updateDownloadInfo(downloadInfo);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void updateSubDownloadChunk(int i10, int i11, int i12, long j10) {
        if (this.aidlService == null) {
            this.downloadProxy.updateSubDownloadChunk(i10, i11, i12, j10);
            return;
        }
        try {
            this.aidlService.updateSubDownloadChunk(i10, i11, i12, j10);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void updateSubDownloadChunkIndex(int i10, int i11, int i12, int i13) {
        if (this.aidlService == null) {
            this.downloadProxy.updateSubDownloadChunkIndex(i10, i11, i12, i13);
            return;
        }
        try {
            this.aidlService.updateSubDownloadChunkIndex(i10, i11, i12, i13);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void addDownloadListener(int i10, int i11, IDownloadListener iDownloadListener, ListenerType listenerType, boolean z10, boolean z11) {
        if (this.aidlService == null) {
            return;
        }
        try {
            this.aidlService.addDownloadListener1(i10, i11, IPCUtils.convertListenerToAidl(iDownloadListener, listenerType != ListenerType.SUB), listenerType.ordinal(), z10, z11);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public DownloadInfo getDownloadInfo(String str, String str2) {
        return getDownloadInfo(getDownloadId(str, str2));
    }
}
