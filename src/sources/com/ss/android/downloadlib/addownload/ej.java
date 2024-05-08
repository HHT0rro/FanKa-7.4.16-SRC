package com.ss.android.downloadlib.addownload;

import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ej {
    private static volatile ej dk = null;

    /* renamed from: m, reason: collision with root package name */
    private static String f38596m = "ej";
    private ConcurrentHashMap<Long, Runnable> ej;

    public ej() {
        this.ej = null;
        this.ej = new ConcurrentHashMap<>();
    }

    public static ej m() {
        if (dk == null) {
            synchronized (ej.class) {
                if (dk == null) {
                    dk = new ej();
                }
            }
        }
        return dk;
    }

    public long dk() {
        return c.w().optLong("quick_app_check_internal", 1200L);
    }

    public void m(np npVar, boolean z10, int i10, DownloadModel downloadModel) {
        if (downloadModel instanceof AdDownloadModel) {
            ((AdDownloadModel) downloadModel).setFunnelType(3);
        }
        long id2 = downloadModel.getId();
        if (i10 == 4) {
            if (!z10) {
                m(id2, false, 2);
                npVar.dk(false);
                return;
            } else {
                m(id2, true, 2);
                return;
            }
        }
        if (i10 == 5) {
            if (!z10) {
                m(id2, false, 1);
                npVar.ej(false);
                return;
            } else {
                m(id2, true, 1);
                return;
            }
        }
        if (i10 != 7) {
            return;
        }
        Runnable remove = this.ej.remove(Long.valueOf(id2));
        if (z10) {
            com.ss.android.downloadlib.l.m.m().m(id2, 1);
            m(id2, true, 1);
        } else {
            if (remove != null) {
                com.ss.android.downloadlib.hc.m().dk().post(remove);
            }
            m(id2, false, 1);
        }
    }

    private void m(long j10, boolean z10, int i10) {
        com.ss.android.downloadlib.l.m.m().m(j10, z10, i10);
        if (z10) {
            c.dh().m(null, null, null, null, null, 3);
        }
    }

    public void m(final np npVar, final int i10, final DownloadModel downloadModel) {
        com.ss.android.downloadlib.dk.np.m().m(new com.ss.android.downloadlib.dk.l() { // from class: com.ss.android.downloadlib.addownload.ej.1
            @Override // com.ss.android.downloadlib.dk.l
            public void m(boolean z10) {
                ej.this.m(npVar, z10, i10, downloadModel);
            }
        }, dk());
    }

    public static boolean m(DownloadInfo downloadInfo) {
        return downloadInfo == null || downloadInfo.getStatus() == 0 || downloadInfo.getStatus() == -4;
    }
}
