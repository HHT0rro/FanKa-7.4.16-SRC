package com.ss.android.downloadlib;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.huawei.openalliance.ad.constant.u;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.c;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class hc {

    /* renamed from: m, reason: collision with root package name */
    private static volatile hc f38757m;

    /* renamed from: n, reason: collision with root package name */
    private long f38759n;
    private final List<com.ss.android.downloadlib.addownload.hc> ej = new CopyOnWriteArrayList();

    /* renamed from: l, reason: collision with root package name */
    private final Map<String, com.ss.android.downloadlib.addownload.hc> f38758l = new ConcurrentHashMap();
    private final CopyOnWriteArrayList<Object> np = new CopyOnWriteArrayList<>();
    private final Handler dk = new Handler(Looper.getMainLooper());

    private hc() {
    }

    private synchronized void dk(Context context, int i10, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
        if (this.ej.size() <= 0) {
            ej(context, i10, downloadStatusChangeListener, downloadModel);
        } else {
            com.ss.android.downloadlib.addownload.hc remove = this.ej.remove(0);
            remove.dk(context).dk(i10, downloadStatusChangeListener).dk(downloadModel).m();
            this.f38758l.put(downloadModel.getDownloadUrl(), remove);
        }
    }

    private void ej(Context context, int i10, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
        if (downloadModel == null) {
            return;
        }
        com.ss.android.downloadlib.addownload.np npVar = new com.ss.android.downloadlib.addownload.np();
        npVar.dk(context).dk(i10, downloadStatusChangeListener).dk(downloadModel).m();
        this.f38758l.put(downloadModel.getDownloadUrl(), npVar);
    }

    private void l() {
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (com.ss.android.downloadlib.addownload.hc hcVar : this.ej) {
            if (!hcVar.dk() && currentTimeMillis - hcVar.l() > u.as) {
                hcVar.e();
                arrayList.add(hcVar);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.ej.removeAll(arrayList);
    }

    public static hc m() {
        if (f38757m == null) {
            synchronized (hc.class) {
                if (f38757m == null) {
                    f38757m = new hc();
                }
            }
        }
        return f38757m;
    }

    private void ej() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f38759n < u.as) {
            return;
        }
        this.f38759n = currentTimeMillis;
        if (this.ej.isEmpty()) {
            return;
        }
        l();
    }

    public void m(Context context, int i10, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
        com.ss.android.downloadlib.addownload.hc hcVar;
        if (downloadModel == null || TextUtils.isEmpty(downloadModel.getDownloadUrl())) {
            return;
        }
        boolean z10 = c.w().optInt("filter_download_url_key", 0) == 1;
        String m10 = com.ss.android.downloadlib.addownload.n.m().m(downloadModel.getDownloadUrl());
        if (z10 && !TextUtils.isEmpty(m10)) {
            hcVar = this.f38758l.get(m10);
            if (downloadModel instanceof AdDownloadModel) {
                AdDownloadModel adDownloadModel = (AdDownloadModel) downloadModel;
                if (TextUtils.isEmpty(adDownloadModel.getTaskKey())) {
                    adDownloadModel.setTaskKey(m10);
                }
            }
        } else {
            hcVar = this.f38758l.get(downloadModel.getDownloadUrl());
        }
        if (hcVar != null) {
            hcVar.dk(context).dk(i10, downloadStatusChangeListener).dk(downloadModel).m();
            return;
        }
        if (this.ej.isEmpty()) {
            if (z10) {
                if (!TextUtils.isEmpty(m10)) {
                    dk(context, i10, downloadStatusChangeListener, downloadModel, m10);
                    return;
                }
                String m11 = com.ss.android.downloadlib.addownload.n.m().m(downloadModel);
                if (TextUtils.isEmpty(m11)) {
                    ej(context, i10, downloadStatusChangeListener, downloadModel);
                    return;
                }
                dk(context, i10, downloadStatusChangeListener, downloadModel, m11);
                if (downloadModel instanceof AdDownloadModel) {
                    AdDownloadModel adDownloadModel2 = (AdDownloadModel) downloadModel;
                    if (TextUtils.isEmpty(adDownloadModel2.getTaskKey())) {
                        adDownloadModel2.setTaskKey(m11);
                        return;
                    }
                    return;
                }
                return;
            }
            ej(context, i10, downloadStatusChangeListener, downloadModel);
            return;
        }
        if (z10) {
            if (!TextUtils.isEmpty(m10)) {
                m(context, i10, downloadStatusChangeListener, downloadModel, m10);
                return;
            }
            String m12 = com.ss.android.downloadlib.addownload.n.m().m(downloadModel);
            if (TextUtils.isEmpty(m12)) {
                dk(context, i10, downloadStatusChangeListener, downloadModel);
                return;
            }
            m(context, i10, downloadStatusChangeListener, downloadModel, m12);
            if (downloadModel instanceof AdDownloadModel) {
                AdDownloadModel adDownloadModel3 = (AdDownloadModel) downloadModel;
                if (TextUtils.isEmpty(adDownloadModel3.getTaskKey())) {
                    adDownloadModel3.setTaskKey(m12);
                    return;
                }
                return;
            }
            return;
        }
        dk(context, i10, downloadStatusChangeListener, downloadModel);
    }

    private void dk(Context context, int i10, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel, String str) {
        if (downloadModel == null) {
            return;
        }
        com.ss.android.downloadlib.addownload.np npVar = new com.ss.android.downloadlib.addownload.np();
        npVar.dk(context).dk(i10, downloadStatusChangeListener).dk(downloadModel).m(str).m();
        this.f38758l.put(str, npVar);
        com.ss.android.downloadlib.addownload.n.m().m(str, downloadModel.getDownloadUrl());
    }

    public void dk(final DownloadInfo downloadInfo, final String str) {
        this.dk.post(new Runnable() { // from class: com.ss.android.downloadlib.hc.4
            @Override // java.lang.Runnable
            public void run() {
                Iterator iterator2 = hc.this.np.iterator2();
                while (iterator2.hasNext()) {
                    Object next = iterator2.next();
                    if (next instanceof com.ss.android.download.api.download.m.m) {
                        ((com.ss.android.download.api.download.m.m) next).dk(downloadInfo, str);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof com.ss.android.download.api.download.m.m) {
                            ((com.ss.android.download.api.download.m.m) softReference.get()).dk(downloadInfo, str);
                        }
                    }
                }
            }
        });
    }

    public Handler dk() {
        return this.dk;
    }

    public com.ss.android.downloadlib.addownload.np m(String str) {
        com.ss.android.downloadlib.addownload.hc hcVar;
        Map<String, com.ss.android.downloadlib.addownload.hc> map = this.f38758l;
        if (map != null && map.size() != 0 && !TextUtils.isEmpty(str)) {
            if (c.w().optInt("filter_download_url_key", 0) == 1) {
                hcVar = this.f38758l.get(com.ss.android.downloadlib.addownload.n.m().m(str));
            } else {
                hcVar = this.f38758l.get(str);
            }
            if (hcVar instanceof com.ss.android.downloadlib.addownload.np) {
                return (com.ss.android.downloadlib.addownload.np) hcVar;
            }
        }
        return null;
    }

    private synchronized void m(Context context, int i10, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel, String str) {
        if (this.ej.size() <= 0) {
            dk(context, i10, downloadStatusChangeListener, downloadModel, str);
        } else {
            com.ss.android.downloadlib.addownload.hc remove = this.ej.remove(0);
            remove.dk(context).dk(i10, downloadStatusChangeListener).dk(downloadModel).m(str).m();
            this.f38758l.put(str, remove);
            com.ss.android.downloadlib.addownload.n.m().m(str, downloadModel.getDownloadUrl());
        }
    }

    public void m(String str, int i10) {
        com.ss.android.downloadlib.addownload.hc hcVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z10 = c.w().optInt("filter_download_url_key", 0) == 1;
        String m10 = com.ss.android.downloadlib.addownload.n.m().m(str);
        if (z10 && !TextUtils.isEmpty(m10)) {
            hcVar = this.f38758l.get(m10);
        } else {
            hcVar = this.f38758l.get(str);
        }
        if (hcVar != null) {
            if (hcVar.m(i10)) {
                this.ej.add(hcVar);
                if (z10 && !TextUtils.isEmpty(m10)) {
                    this.f38758l.remove(m10);
                    com.ss.android.downloadlib.addownload.n.m().dk(m10);
                } else {
                    this.f38758l.remove(str);
                }
            }
            ej();
        }
    }

    public void m(String str, boolean z10) {
        com.ss.android.downloadlib.addownload.hc hcVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z11 = c.w().optInt("filter_download_url_key", 0) == 1;
        String m10 = com.ss.android.downloadlib.addownload.n.m().m(str);
        if (z11 && !TextUtils.isEmpty(m10)) {
            hcVar = this.f38758l.get(m10);
        } else {
            hcVar = this.f38758l.get(str);
        }
        if (hcVar != null) {
            hcVar.m(z10);
        }
    }

    public void m(String str, long j10, int i10, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        m(str, j10, i10, downloadEventConfig, downloadController, null, null);
    }

    public void m(String str, long j10, int i10, DownloadEventConfig downloadEventConfig, DownloadController downloadController, IDownloadButtonClickListener iDownloadButtonClickListener) {
        m(str, j10, i10, downloadEventConfig, downloadController, null, iDownloadButtonClickListener);
    }

    public void m(String str, long j10, int i10, DownloadEventConfig downloadEventConfig, DownloadController downloadController, OnItemClickListener onItemClickListener, IDownloadButtonClickListener iDownloadButtonClickListener) {
        com.ss.android.downloadlib.addownload.hc hcVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z10 = c.w().optInt("filter_download_url_key", 0) == 1;
        String m10 = com.ss.android.downloadlib.addownload.n.m().m(str);
        if (z10 && !TextUtils.isEmpty(m10)) {
            hcVar = this.f38758l.get(m10);
        } else {
            hcVar = this.f38758l.get(str);
        }
        if (hcVar != null) {
            hcVar.m(j10).dk(downloadEventConfig).dk(downloadController).m(onItemClickListener).m(iDownloadButtonClickListener).dk(i10);
        }
    }

    public void m(com.ss.android.download.api.download.m.m mVar) {
        if (mVar != null) {
            if (DownloadSetting.obtainGlobal().optBugFix("fix_listener_oom", false)) {
                this.np.add(new SoftReference(mVar));
            } else {
                this.np.add(mVar);
            }
        }
    }

    public void m(final DownloadModel downloadModel, @Nullable final DownloadController downloadController, @Nullable final DownloadEventConfig downloadEventConfig) {
        this.dk.post(new Runnable() { // from class: com.ss.android.downloadlib.hc.1
            @Override // java.lang.Runnable
            public void run() {
                Iterator iterator2 = hc.this.np.iterator2();
                while (iterator2.hasNext()) {
                    Object next = iterator2.next();
                    if (next instanceof com.ss.android.download.api.download.m.m) {
                        ((com.ss.android.download.api.download.m.m) next).m(downloadModel, downloadController, downloadEventConfig);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof com.ss.android.download.api.download.m.m) {
                            ((com.ss.android.download.api.download.m.m) softReference.get()).m(downloadModel, downloadController, downloadEventConfig);
                        }
                    }
                }
            }
        });
    }

    public void m(final DownloadInfo downloadInfo, final BaseException baseException, final String str) {
        this.dk.post(new Runnable() { // from class: com.ss.android.downloadlib.hc.2
            @Override // java.lang.Runnable
            public void run() {
                Iterator iterator2 = hc.this.np.iterator2();
                while (iterator2.hasNext()) {
                    Object next = iterator2.next();
                    if (next instanceof com.ss.android.download.api.download.m.m) {
                        ((com.ss.android.download.api.download.m.m) next).m(downloadInfo, baseException, str);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof com.ss.android.download.api.download.m.m) {
                            ((com.ss.android.download.api.download.m.m) softReference.get()).m(downloadInfo, baseException, str);
                        }
                    }
                }
            }
        });
    }

    public void m(final DownloadInfo downloadInfo, final String str) {
        this.dk.post(new Runnable() { // from class: com.ss.android.downloadlib.hc.3
            @Override // java.lang.Runnable
            public void run() {
                Iterator iterator2 = hc.this.np.iterator2();
                while (iterator2.hasNext()) {
                    Object next = iterator2.next();
                    if (next instanceof com.ss.android.download.api.download.m.m) {
                        ((com.ss.android.download.api.download.m.m) next).m(downloadInfo, str);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof com.ss.android.download.api.download.m.m) {
                            ((com.ss.android.download.api.download.m.m) softReference.get()).m(downloadInfo, str);
                        }
                    }
                }
            }
        });
    }

    public void m(final DownloadInfo downloadInfo) {
        this.dk.post(new Runnable() { // from class: com.ss.android.downloadlib.hc.5
            @Override // java.lang.Runnable
            public void run() {
                Iterator iterator2 = hc.this.np.iterator2();
                while (iterator2.hasNext()) {
                    Object next = iterator2.next();
                    if (next instanceof com.ss.android.download.api.download.m.m) {
                        ((com.ss.android.download.api.download.m.m) next).m(downloadInfo);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof com.ss.android.download.api.download.m.m) {
                            ((com.ss.android.download.api.download.m.m) softReference.get()).m(downloadInfo);
                        }
                    }
                }
            }
        });
    }
}
