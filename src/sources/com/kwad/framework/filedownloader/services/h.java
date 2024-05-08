package com.kwad.framework.filedownloader.services;

import android.util.SparseArray;
import com.kwad.framework.filedownloader.download.DownloadLaunchRunnable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class h {
    private ThreadPoolExecutor aic;
    private int aie;
    private SparseArray<DownloadLaunchRunnable> aib = new SparseArray<>();
    private final String aid = "Network";
    private int aif = 0;

    public h(int i10) {
        this.aic = com.kwad.framework.filedownloader.f.b.o(i10, "Network");
        this.aie = i10;
    }

    private synchronized void wF() {
        SparseArray<DownloadLaunchRunnable> sparseArray = new SparseArray<>();
        int size = this.aib.size();
        for (int i10 = 0; i10 < size; i10++) {
            int keyAt = this.aib.keyAt(i10);
            DownloadLaunchRunnable downloadLaunchRunnable = this.aib.get(keyAt);
            if (downloadLaunchRunnable.isAlive()) {
                sparseArray.put(keyAt, downloadLaunchRunnable);
            }
        }
        this.aib = sparseArray;
    }

    public final void a(DownloadLaunchRunnable downloadLaunchRunnable) {
        downloadLaunchRunnable.vy();
        synchronized (this) {
            this.aib.put(downloadLaunchRunnable.getId(), downloadLaunchRunnable);
        }
        this.aic.execute(downloadLaunchRunnable);
        int i10 = this.aif;
        if (i10 >= 600) {
            wF();
            this.aif = 0;
        } else {
            this.aif = i10 + 1;
        }
    }

    public final boolean bK(int i10) {
        DownloadLaunchRunnable downloadLaunchRunnable = this.aib.get(i10);
        return downloadLaunchRunnable != null && downloadLaunchRunnable.isAlive();
    }

    public final synchronized boolean bx(int i10) {
        if (wG() > 0) {
            com.kwad.framework.filedownloader.f.d.d(this, "Can't change the max network thread count, because the  network thread pool isn't in IDLE, please try again after all running tasks are completed or invoking FileDownloader#pauseAll directly.", new Object[0]);
            return false;
        }
        int bL = com.kwad.framework.filedownloader.f.e.bL(i10);
        if (com.kwad.framework.filedownloader.f.d.ail) {
            com.kwad.framework.filedownloader.f.d.c(this, "change the max network thread count, from %d to %d", Integer.valueOf(this.aie), Integer.valueOf(bL));
        }
        List<Runnable> shutdownNow = this.aic.shutdownNow();
        this.aic = com.kwad.framework.filedownloader.f.b.o(bL, "Network");
        if (shutdownNow.size() > 0) {
            com.kwad.framework.filedownloader.f.d.d(this, "recreate the network thread pool and discard %d tasks", Integer.valueOf(shutdownNow.size()));
        }
        this.aie = bL;
        return true;
    }

    public final void cancel(int i10) {
        wF();
        synchronized (this) {
            DownloadLaunchRunnable downloadLaunchRunnable = this.aib.get(i10);
            if (downloadLaunchRunnable != null) {
                downloadLaunchRunnable.pause();
                boolean remove = this.aic.remove(downloadLaunchRunnable);
                if (com.kwad.framework.filedownloader.f.d.ail) {
                    com.kwad.framework.filedownloader.f.d.c(this, "successful cancel %d %B", Integer.valueOf(i10), Boolean.valueOf(remove));
                }
            }
            this.aib.remove(i10);
        }
    }

    public final int p(String str, int i10) {
        if (str == null) {
            return 0;
        }
        int size = this.aib.size();
        for (int i11 = 0; i11 < size; i11++) {
            DownloadLaunchRunnable valueAt = this.aib.valueAt(i11);
            if (valueAt != null && valueAt.isAlive() && valueAt.getId() != i10 && str.equals(valueAt.vD())) {
                return valueAt.getId();
            }
        }
        return 0;
    }

    public final synchronized int wG() {
        wF();
        return this.aib.size();
    }

    public final synchronized List<Integer> wH() {
        ArrayList arrayList;
        wF();
        arrayList = new ArrayList();
        for (int i10 = 0; i10 < this.aib.size(); i10++) {
            SparseArray<DownloadLaunchRunnable> sparseArray = this.aib;
            arrayList.add(Integer.valueOf(sparseArray.get(sparseArray.keyAt(i10)).getId()));
        }
        return arrayList;
    }
}
