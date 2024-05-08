package com.ss.android.downloadlib;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.downloadlib.addownload.c;
import com.ss.android.downloadlib.addownload.ve;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class e {

    /* renamed from: m, reason: collision with root package name */
    private static volatile e f38716m;
    private final com.ss.android.download.api.m dk;
    private final hc ej;

    /* renamed from: l, reason: collision with root package name */
    private final com.ss.android.downloadad.api.m f38717l;

    /* renamed from: n, reason: collision with root package name */
    private long f38718n;
    private com.ss.android.downloadad.api.dk np;

    /* JADX INFO: Access modifiers changed from: private */
    public hc e() {
        return this.ej;
    }

    public void ej() {
        this.f38718n = System.currentTimeMillis();
    }

    public void hc() {
        l.m().np();
    }

    public com.ss.android.downloadad.api.m l() {
        return this.f38717l;
    }

    public String n() {
        return c.r();
    }

    public com.ss.android.downloadad.api.dk np() {
        if (this.np == null) {
            this.np = dk.m();
        }
        return this.np;
    }

    private e(Context context) {
        this.ej = hc.m();
        this.dk = new np();
        this.f38718n = System.currentTimeMillis();
        dk(context);
        this.f38717l = m.m();
    }

    private void dk(Context context) {
        c.m(context);
        Downloader.getInstance(c.getContext());
        com.ss.android.downloadlib.addownload.dk.n.m().dk();
        com.ss.android.socialbase.appdownloader.l.oa().m(c.getContext(), "misc_config", new com.ss.android.downloadlib.ej.hc(), new com.ss.android.downloadlib.ej.n(context), new ej());
        com.ss.android.downloadlib.ej.l lVar = new com.ss.android.downloadlib.ej.l();
        com.ss.android.socialbase.appdownloader.l.oa().m(lVar);
        Downloader.getInstance(context).registerDownloadCacheSyncListener(lVar);
        com.ss.android.socialbase.appdownloader.l.oa().m(new ve());
        DownloadComponentManager.setDownloadEventListener(new com.ss.android.downloadlib.ej.np());
        com.ss.android.socialbase.appdownloader.l.oa().m(com.ss.android.downloadlib.n.ej.m());
    }

    public static e m(final Context context) {
        if (f38716m == null) {
            synchronized (e.class) {
                if (f38716m == null) {
                    com.ss.android.downloadlib.np.dk.m(new Runnable() { // from class: com.ss.android.downloadlib.e.1
                        @Override // java.lang.Runnable
                        public void run() {
                            e unused = e.f38716m = new e(context);
                        }
                    });
                }
            }
        }
        return f38716m;
    }

    public com.ss.android.download.api.m m() {
        return this.dk;
    }

    public com.ss.android.download.api.m m(String str) {
        com.ss.android.download.api.config.n dk = n.m().dk();
        if (dk != null && dk.m(str)) {
            return dk.dk(str);
        }
        return this.dk;
    }

    public long dk() {
        return this.f38718n;
    }

    public DownloadInfo dk(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.ss.android.socialbase.appdownloader.l.oa().m(c.getContext(), str);
    }

    @MainThread
    public void m(final Context context, final int i10, final DownloadStatusChangeListener downloadStatusChangeListener, final DownloadModel downloadModel) {
        com.ss.android.downloadlib.np.dk.m(new Runnable() { // from class: com.ss.android.downloadlib.e.4
            @Override // java.lang.Runnable
            public void run() {
                e.this.e().m(context, i10, downloadStatusChangeListener, downloadModel);
            }
        });
    }

    @MainThread
    public void m(final String str, final long j10, final int i10, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController, final OnItemClickListener onItemClickListener, final IDownloadButtonClickListener iDownloadButtonClickListener) {
        com.ss.android.downloadlib.np.dk.m(new Runnable() { // from class: com.ss.android.downloadlib.e.5
            @Override // java.lang.Runnable
            public void run() {
                e.this.e().m(str, j10, i10, downloadEventConfig, downloadController, onItemClickListener, iDownloadButtonClickListener);
            }
        });
    }

    @MainThread
    public void m(final String str, final long j10, final int i10, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController) {
        com.ss.android.downloadlib.np.dk.m(new Runnable() { // from class: com.ss.android.downloadlib.e.6
            @Override // java.lang.Runnable
            public void run() {
                e.this.e().m(str, j10, i10, downloadEventConfig, downloadController);
            }
        });
    }

    @MainThread
    public void m(final String str, final long j10, final int i10, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController, final IDownloadButtonClickListener iDownloadButtonClickListener) {
        com.ss.android.downloadlib.np.dk.m(new Runnable() { // from class: com.ss.android.downloadlib.e.7
            @Override // java.lang.Runnable
            public void run() {
                e.this.e().m(str, j10, i10, downloadEventConfig, downloadController, iDownloadButtonClickListener);
            }
        });
    }

    @MainThread
    public void m(final String str, final int i10) {
        com.ss.android.downloadlib.np.dk.m(new Runnable() { // from class: com.ss.android.downloadlib.e.2
            @Override // java.lang.Runnable
            public void run() {
                e.this.e().m(str, i10);
            }
        });
    }

    @MainThread
    public void m(final String str, final boolean z10) {
        com.ss.android.downloadlib.np.dk.m(new Runnable() { // from class: com.ss.android.downloadlib.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.e().m(str, z10);
            }
        });
    }

    public void m(com.ss.android.download.api.download.m.m mVar) {
        e().m(mVar);
    }

    public DownloadInfo m(String str, String str2, boolean z10) {
        if (TextUtils.isEmpty(str2) && z10) {
            return dk(str);
        }
        return Downloader.getInstance(c.getContext()).getDownloadInfo(str, str2);
    }
}
