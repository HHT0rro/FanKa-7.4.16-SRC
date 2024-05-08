package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class dk {

    /* renamed from: m, reason: collision with root package name */
    private static volatile dk f38556m;
    private Handler dk = null;

    public static dk m() {
        if (f38556m == null) {
            synchronized (dk.class) {
                if (f38556m == null) {
                    f38556m = new dk();
                }
            }
        }
        return f38556m;
    }

    public boolean dk() {
        return c.w().optInt("forbid_invalidte_download_file_install", 0) == 1;
    }

    public void m(Context context, DownloadInfo downloadInfo) {
        if (dk() && downloadInfo != null) {
            try {
                File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
                if (file.isFile() && file.exists()) {
                    file.delete();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (this.dk == null) {
                this.dk = new Handler(Looper.getMainLooper());
            }
            final String url = downloadInfo.getUrl();
            Downloader.getInstance(context).clearDownloadData(downloadInfo.getId());
            this.dk.post(new Runnable() { // from class: com.ss.android.downloadlib.addownload.dk.1
                @Override // java.lang.Runnable
                public void run() {
                    c.ej().m(3, c.getContext(), null, "下载失败，请重试！", null, 0);
                    np m10 = com.ss.android.downloadlib.hc.m().m(url);
                    if (m10 != null) {
                        m10.hc();
                    }
                }
            });
        }
    }
}
