package com.ss.android.downloadlib;

import android.content.SharedPreferences;
import android.util.SparseArray;
import com.ss.android.downloadlib.addownload.c;
import com.ss.android.downloadlib.hc.ve;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadCache;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.thread.DefaultThreadFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class l {
    private ExecutorService dk;
    private ScheduledExecutorService ej;

    /* renamed from: m, reason: collision with root package name */
    private ExecutorService f38783m;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class m {

        /* renamed from: m, reason: collision with root package name */
        private static l f38787m = new l();
    }

    public static l m() {
        return m.f38787m;
    }

    public void dk(Runnable runnable) {
        dk(runnable, false);
    }

    public ExecutorService ej() {
        if (this.dk == null) {
            synchronized (l.class) {
                if (this.dk == null) {
                    this.dk = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 30L, TimeUnit.SECONDS, new SynchronousQueue(), new DefaultThreadFactory(e.class.getName() + "-IOThreadPool"));
                }
            }
        }
        return this.dk;
    }

    public ScheduledExecutorService l() {
        if (this.ej == null) {
            synchronized (l.class) {
                if (this.ej == null) {
                    this.ej = new ScheduledThreadPoolExecutor(0, new DefaultThreadFactory(e.class.getName() + "-ScheduledThreadPool"));
                }
            }
        }
        return this.ej;
    }

    public void np() {
        m(new Runnable() { // from class: com.ss.android.downloadlib.l.1
            @Override // java.lang.Runnable
            public void run() {
                IDownloadCache downloadCache;
                synchronized (l.class) {
                    try {
                        String[] strArr = {"sp_ad_download_event", "sp_download_finish_cache", "sp_delay_operation_info", "sp_ttdownloader_md5", "sp_name_installed_app", "misc_config", "sp_ad_install_back_dialog", "sp_ttdownloader_clean", "sp_order_download", "sp_a_b_c", DownloadConstants.SP_ANTI_HIJACK_CONFIG, DownloadConstants.SP_DOWNLOAD_INFO, "sp_appdownloader"};
                        for (int i10 = 0; i10 < 13; i10++) {
                            SharedPreferences sharedPreferences = c.getContext().getSharedPreferences(strArr[i10], 0);
                            if (sharedPreferences != null) {
                                sharedPreferences.edit().clear().apply();
                            }
                        }
                        downloadCache = DownloadComponentManager.getDownloadCache();
                    } catch (Throwable unused) {
                    }
                    if (downloadCache instanceof DefaultDownloadCache) {
                        SparseArray<DownloadInfo> downloadInfoMap = ((DefaultDownloadCache) downloadCache).getDownloadCache().getDownloadInfoMap();
                        for (int size = downloadInfoMap.size() - 1; size >= 0; size--) {
                            DownloadInfo downloadInfo = downloadInfoMap.get(downloadInfoMap.keyAt(size));
                            if (downloadInfo != null) {
                                Downloader.getInstance(c.getContext()).clearDownloadData(downloadInfo.getId());
                            }
                        }
                    }
                }
            }
        });
    }

    private l() {
    }

    public void dk(Runnable runnable, boolean z10) {
        if (runnable == null) {
            return;
        }
        if (z10 && !ve.dk()) {
            runnable.run();
        } else {
            ej().execute(runnable);
        }
    }

    public void m(Runnable runnable) {
        m(runnable, false);
    }

    public void m(Runnable runnable, boolean z10) {
        if (runnable == null) {
            return;
        }
        if (z10 && !ve.dk()) {
            runnable.run();
        } else {
            dk().execute(runnable);
        }
    }

    public ExecutorService dk() {
        if (this.f38783m == null) {
            synchronized (l.class) {
                if (this.f38783m == null) {
                    this.f38783m = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 30L, TimeUnit.SECONDS, new SynchronousQueue(), new DefaultThreadFactory(e.class.getName() + "-CPUThreadPool"));
                }
            }
        }
        return this.f38783m;
    }

    public void m(Runnable runnable, long j10) {
        try {
            l().schedule(runnable, j10, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
