package com.ss.android.socialbase.downloader.network.connectionpool;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.u;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.network.IFetchHttpHeadInfoListener;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class DownloadPreconnecter {
    private static final long DEFAULT_CONNECTION_OUTDATE_TIME = 300000;
    private static final long DEFAULT_HEAD_INFO_OUTDATE_TIME = 300000;
    private static Runnable sCancelRunnable;
    public static long sConnectionOutdatedTime;
    private static final Handler sHandler;
    public static long sHeadInfoOutdatedTime;
    private static final HandlerThread sPreconnectThread;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class CancelRunnable implements Runnable {
        private final String mUrl;

        public CancelRunnable(String str) {
            this.mUrl = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                DownloadConnectionPool.getInstance().releaseDownloadConnection(this.mUrl);
            } catch (Throwable unused) {
            }
        }
    }

    static {
        HandlerThread handlerThread = new HandlerThread("Downloader-preconnecter");
        sPreconnectThread = handlerThread;
        init();
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        sHandler = handler;
        handler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.network.connectionpool.DownloadPreconnecter.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Process.setThreadPriority(10);
                } catch (Throwable unused) {
                }
            }
        });
    }

    public static void asyncFetchHttpHeadInfo(final String str, final IFetchHttpHeadInfoListener iFetchHttpHeadInfoListener) {
        sHandler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.network.connectionpool.DownloadPreconnecter.2
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(String.this)) {
                    IFetchHttpHeadInfoListener iFetchHttpHeadInfoListener2 = iFetchHttpHeadInfoListener;
                    if (iFetchHttpHeadInfoListener2 != null) {
                        iFetchHttpHeadInfoListener2.onFetchFinished(null);
                        return;
                    }
                    return;
                }
                try {
                    try {
                        List<HttpHeader> extraHeaders = DownloadPreconnecter.getExtraHeaders(0L, null, null);
                        r1 = DownloadConnectionPool.getInstance().isHeadConnectionExist(String.this) ? DownloadConnectionPool.getInstance().getCachedHeadConnection(String.this, extraHeaders) : null;
                        if (r1 == null) {
                            FakeDownloadHeadHttpConnection fakeDownloadHeadHttpConnection = new FakeDownloadHeadHttpConnection(String.this, extraHeaders, 0L);
                            try {
                                fakeDownloadHeadHttpConnection.execute();
                                if (fakeDownloadHeadHttpConnection.isSuccessful()) {
                                    DownloadConnectionPool.getInstance().putCachedHeadConnections(String.this, fakeDownloadHeadHttpConnection);
                                }
                                r1 = fakeDownloadHeadHttpConnection;
                            } catch (Exception e2) {
                                e = e2;
                                r1 = fakeDownloadHeadHttpConnection;
                                e.printStackTrace();
                                r1.cancel();
                            } catch (Throwable th) {
                                th = th;
                                r1 = fakeDownloadHeadHttpConnection;
                                try {
                                    r1.cancel();
                                } catch (Throwable unused) {
                                }
                                throw th;
                            }
                        }
                        Map<String, String> responseHeaders = r1.getResponseHeaders();
                        IFetchHttpHeadInfoListener iFetchHttpHeadInfoListener3 = iFetchHttpHeadInfoListener;
                        if (iFetchHttpHeadInfoListener3 != null) {
                            iFetchHttpHeadInfoListener3.onFetchFinished(responseHeaders);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Exception e10) {
                    e = e10;
                }
                try {
                    r1.cancel();
                } catch (Throwable unused2) {
                }
            }
        });
    }

    private static void asyncPreconnect(final int i10, final String str, final List<HttpHeader> list, final long j10, final boolean z10, final boolean z11) {
        sHandler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.network.connectionpool.DownloadPreconnecter.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (z11) {
                        DownloadPreconnecter.fetchHeadInfo(str, list, j10);
                    }
                    if (z10) {
                        DownloadPreconnecter.createConnection(i10, str, list, j10);
                        Runnable unused = DownloadPreconnecter.sCancelRunnable = new CancelRunnable(str);
                        DownloadPreconnecter.sHandler.postDelayed(DownloadPreconnecter.sCancelRunnable, DownloadPreconnecter.sConnectionOutdatedTime);
                    }
                } catch (Throwable unused2) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void createConnection(int i10, String str, List<HttpHeader> list, long j10) {
        if (DownloadConnectionPool.getInstance().isDownloadConnectionExist(str)) {
            return;
        }
        FakeDownloadHttpConnection fakeDownloadHttpConnection = new FakeDownloadHttpConnection(i10, str, list, j10);
        DownloadConnectionPool.getInstance().putCachedDownloadConnections(str, fakeDownloadHttpConnection);
        try {
            fakeDownloadHttpConnection.execute();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void fetchHeadInfo(String str, List<HttpHeader> list, long j10) {
        if (DownloadConnectionPool.getInstance().isHeadConnectionExist(str)) {
            return;
        }
        FakeDownloadHeadHttpConnection fakeDownloadHeadHttpConnection = new FakeDownloadHeadHttpConnection(str, list, j10);
        DownloadConnectionPool.getInstance().putCachedHeadConnections(str, fakeDownloadHeadHttpConnection);
        try {
            try {
                fakeDownloadHeadHttpConnection.execute();
            } catch (Throwable th) {
                try {
                    fakeDownloadHeadHttpConnection.cancel();
                } catch (Throwable unused) {
                }
                throw th;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            fakeDownloadHeadHttpConnection.cancel();
        } catch (Throwable unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<HttpHeader> getExtraHeaders(long j10, DownloadInfo downloadInfo, List<HttpHeader> list) {
        return DownloadUtils.addRangeHeader(list, downloadInfo == null ? null : downloadInfo.geteTag(), j10, 0L);
    }

    public static Looper getLooper() {
        return sPreconnectThread.getLooper();
    }

    private static void init() {
        sConnectionOutdatedTime = DownloadSetting.obtainGlobal().optLong(DownloadSettingKeys.GLOBAL_KEY_PRECONNECT_CONNECTION_OUTDATE_TIME, u.as);
        sHeadInfoOutdatedTime = DownloadSetting.obtainGlobal().optLong(DownloadSettingKeys.GLOBAL_KEY_PRECONNECT_HEAD_INFO_OUTDATE_TIME, u.as);
        DownloadConnectionPool.getInstance().setMaxCachedDownloadConnectionSize(DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.GLOBAL_KEY_PRECONNECT_MAX_CACHE_SIZE, 3));
    }

    public static void preconnect(String str, String str2, boolean z10) {
        preconnect(-1, str, str2, null, z10, true);
    }

    public static void preconnect(int i10, String str, String str2, List<HttpHeader> list, boolean z10, boolean z11) {
        long j10;
        DownloadInfo downloadInfo = Downloader.getInstance(DownloadComponentManager.getAppContext()).getDownloadInfo(str, str2);
        if (downloadInfo == null) {
            j10 = 0;
        } else if (downloadInfo.isDownloadingStatus() || downloadInfo.isDownloaded() || downloadInfo.getChunkCount() > 1) {
            return;
        } else {
            j10 = DownloadUtils.getFirstOffset(downloadInfo);
        }
        long j11 = j10;
        asyncPreconnect(i10, str, getExtraHeaders(j11, downloadInfo, list), j11, z10, z11);
    }
}
