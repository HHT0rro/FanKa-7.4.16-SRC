package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadSettings;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.monitor.IDownloadMonitorListener;
import com.ss.android.socialbase.downloader.network.IDownloadDns;
import com.ss.android.socialbase.downloader.network.IDownloadHeadHttpService;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class DownloaderBuilder {
    private IChunkAdjustCalculator chunkAdjustCalculator;
    private IChunkCntCalculator chunkCntCalculator;
    private ExecutorService chunkDownloadExecutor;
    private final Context context;
    private ExecutorService cpuThreadExecutor;
    private ExecutorService dbThreadExecutor;
    private IDownloadCache downloadCache;
    private IDownloadDns downloadDns;
    private boolean downloadInMultiProcess;
    private IDownloadLaunchHandler downloadLaunchHandler;
    private IDownloadMonitorListener downloadMonitorListener;
    private IDownloadSettings downloadSetting;
    private IDownloadHeadHttpService headHttpService;
    private IDownloadHttpService httpService;
    private IDownloadIdGenerator idGenerator;
    private ExecutorService ioThreadExecutor;
    private int maxDownloadPoolSize;
    private ExecutorService mixApkDownloadExecutor;
    private ExecutorService mixDefaultDownloadExecutor;
    private ExecutorService mixFrequentDownloadExecutor;
    private IMonitorConfig monitorConfig;
    private INotificationClickCallback notificationClickCallback;
    private ExecutorService okHttpDispatcherExecutor;
    private ITTNetHandler ttNetHandler;
    private int writeBufferSize;
    private List<IDownloadCompleteHandler> downloadCompleteHandlers = new ArrayList();
    private boolean needAutoRefreshUnSuccessTask = true;
    private int downloadExpSwitch = 1056964607;

    public DownloaderBuilder(Context context) {
        this.context = context;
    }

    public DownloaderBuilder addDownloadCompleteHandler(IDownloadCompleteHandler iDownloadCompleteHandler) {
        synchronized (this.downloadCompleteHandlers) {
            if (iDownloadCompleteHandler != null) {
                if (!this.downloadCompleteHandlers.contains(iDownloadCompleteHandler)) {
                    this.downloadCompleteHandlers.add(iDownloadCompleteHandler);
                    return this;
                }
            }
            return this;
        }
    }

    public Downloader build() {
        return new Downloader(this);
    }

    public DownloaderBuilder chunkAdjustCalculator(IChunkAdjustCalculator iChunkAdjustCalculator) {
        this.chunkAdjustCalculator = iChunkAdjustCalculator;
        return this;
    }

    public DownloaderBuilder chunkCntCalculator(IChunkCntCalculator iChunkCntCalculator) {
        this.chunkCntCalculator = iChunkCntCalculator;
        return this;
    }

    public DownloaderBuilder chunkThreadExecutor(ExecutorService executorService) {
        this.chunkDownloadExecutor = executorService;
        return this;
    }

    public DownloaderBuilder cpuThreadExecutor(ExecutorService executorService) {
        this.cpuThreadExecutor = executorService;
        return this;
    }

    public DownloaderBuilder dbThreadExecutor(ExecutorService executorService) {
        this.dbThreadExecutor = executorService;
        return this;
    }

    public DownloaderBuilder downloadCache(IDownloadCache iDownloadCache) {
        this.downloadCache = iDownloadCache;
        return this;
    }

    public DownloaderBuilder downloadDns(IDownloadDns iDownloadDns) {
        this.downloadDns = iDownloadDns;
        return this;
    }

    public DownloaderBuilder downloadExpSwitch(int i10) {
        this.downloadExpSwitch = i10;
        return this;
    }

    public DownloaderBuilder downloadInMultiProcess(boolean z10) {
        this.downloadInMultiProcess = z10;
        return this;
    }

    public DownloaderBuilder downloadLaunchHandler(IDownloadLaunchHandler iDownloadLaunchHandler) {
        this.downloadLaunchHandler = iDownloadLaunchHandler;
        return this;
    }

    public DownloaderBuilder downloadMonitorListener(IDownloadMonitorListener iDownloadMonitorListener) {
        this.downloadMonitorListener = iDownloadMonitorListener;
        return this;
    }

    public DownloaderBuilder downloadSetting(IDownloadSettings iDownloadSettings) {
        this.downloadSetting = iDownloadSettings;
        return this;
    }

    public ExecutorService getCPUThreadExecutor() {
        return this.cpuThreadExecutor;
    }

    public IChunkAdjustCalculator getChunkAdjustCalculator() {
        return this.chunkAdjustCalculator;
    }

    public IChunkCntCalculator getChunkCntCalculator() {
        return this.chunkCntCalculator;
    }

    public ExecutorService getChunkThreadExecutor() {
        return this.chunkDownloadExecutor;
    }

    public Context getContext() {
        return this.context;
    }

    public ExecutorService getDBThreadExecutor() {
        return this.dbThreadExecutor;
    }

    public IDownloadCache getDownloadCache() {
        return this.downloadCache;
    }

    public List<IDownloadCompleteHandler> getDownloadCompleteHandlers() {
        return this.downloadCompleteHandlers;
    }

    public IDownloadDns getDownloadDns() {
        return this.downloadDns;
    }

    public int getDownloadExpSwitch() {
        return this.downloadExpSwitch;
    }

    public IDownloadLaunchHandler getDownloadLaunchHandler() {
        return this.downloadLaunchHandler;
    }

    public IDownloadMonitorListener getDownloadMonitorListener() {
        return this.downloadMonitorListener;
    }

    public IDownloadSettings getDownloadSetting() {
        return this.downloadSetting;
    }

    public IDownloadHeadHttpService getHeadHttpService() {
        return this.headHttpService;
    }

    public IDownloadHttpService getHttpService() {
        return this.httpService;
    }

    public ExecutorService getIOThreadExecutor() {
        return this.ioThreadExecutor;
    }

    public IDownloadIdGenerator getIdGenerator() {
        return this.idGenerator;
    }

    public int getMaxDownloadPoolSize() {
        return this.maxDownloadPoolSize;
    }

    public ExecutorService getMixApkDownloadExecutor() {
        return this.mixApkDownloadExecutor;
    }

    public ExecutorService getMixDefaultDownloadExecutor() {
        return this.mixDefaultDownloadExecutor;
    }

    public ExecutorService getMixFrequentDownloadExecutor() {
        return this.mixFrequentDownloadExecutor;
    }

    public IMonitorConfig getMonitorConfig() {
        return this.monitorConfig;
    }

    public INotificationClickCallback getNotificationClickCallback() {
        return this.notificationClickCallback;
    }

    public ExecutorService getOkHttpDispatcherExecutor() {
        return this.okHttpDispatcherExecutor;
    }

    public ITTNetHandler getTTNetHandler() {
        return this.ttNetHandler;
    }

    public int getWriteBufferSize() {
        return this.writeBufferSize;
    }

    public DownloaderBuilder headHttpService(IDownloadHeadHttpService iDownloadHeadHttpService) {
        this.headHttpService = iDownloadHeadHttpService;
        return this;
    }

    public DownloaderBuilder httpService(IDownloadHttpService iDownloadHttpService) {
        this.httpService = iDownloadHttpService;
        return this;
    }

    public DownloaderBuilder idGenerator(IDownloadIdGenerator iDownloadIdGenerator) {
        this.idGenerator = iDownloadIdGenerator;
        return this;
    }

    public DownloaderBuilder ioThreadExecutor(ExecutorService executorService) {
        this.ioThreadExecutor = executorService;
        return this;
    }

    public boolean isDownloadInMultiProcess() {
        return this.downloadInMultiProcess;
    }

    public DownloaderBuilder maxDownloadPoolSize(int i10) {
        this.maxDownloadPoolSize = i10;
        return this;
    }

    public DownloaderBuilder mixApkDownloadExecutor(ExecutorService executorService) {
        this.mixApkDownloadExecutor = executorService;
        return this;
    }

    public DownloaderBuilder mixDefaultDownloadExecutor(ExecutorService executorService) {
        this.mixDefaultDownloadExecutor = executorService;
        return this;
    }

    public DownloaderBuilder mixFrequentDownloadExecutor(ExecutorService executorService) {
        this.mixFrequentDownloadExecutor = executorService;
        return this;
    }

    public DownloaderBuilder monitorConfig(IMonitorConfig iMonitorConfig) {
        this.monitorConfig = iMonitorConfig;
        return this;
    }

    public DownloaderBuilder needAutoRefreshUnSuccessTask(boolean z10) {
        this.needAutoRefreshUnSuccessTask = z10;
        return this;
    }

    public DownloaderBuilder notificationClickCallback(INotificationClickCallback iNotificationClickCallback) {
        this.notificationClickCallback = iNotificationClickCallback;
        return this;
    }

    public DownloaderBuilder okHttpDispatcherExecutor(ExecutorService executorService) {
        this.okHttpDispatcherExecutor = executorService;
        return this;
    }

    public DownloaderBuilder ttNetHandler(ITTNetHandler iTTNetHandler) {
        this.ttNetHandler = iTTNetHandler;
        return this;
    }

    public DownloaderBuilder writeBufferSize(int i10) {
        this.writeBufferSize = i10;
        return this;
    }

    public boolean needAutoRefreshUnSuccessTask() {
        return this.needAutoRefreshUnSuccessTask;
    }
}
