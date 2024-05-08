package com.ss.android.downloadlib.addownload;

import android.os.Handler;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.addownload.np;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.network.IFetchHttpHeadInfoListener;
import com.ss.android.socialbase.downloader.network.connectionpool.DownloadPreconnecter;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class l {
    private com.ss.android.downloadlib.addownload.dk.np dk;
    private AtomicBoolean ej = new AtomicBoolean(false);

    /* renamed from: l, reason: collision with root package name */
    private AtomicBoolean f38604l = new AtomicBoolean(false);

    /* renamed from: m, reason: collision with root package name */
    private Handler f38605m;

    public l(Handler handler) {
        this.f38605m = handler;
    }

    public static long dk() {
        if (c.sy() != null) {
            return c.sy().m();
        }
        return 0L;
    }

    public static /* synthetic */ long ej() {
        return l();
    }

    private static long l() {
        return com.ss.android.downloadlib.hc.ve.dk(0L);
    }

    private void dk(com.ss.android.downloadad.api.m.dk dkVar, JSONObject jSONObject, long j10, long j11) {
        dkVar.ve("1");
        com.ss.android.downloadlib.addownload.dk.w.m().m(dkVar);
        try {
            jSONObject.putOpt("quite_clean_size", Long.valueOf(j11 - j10));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.l.m.m().m("cleanspace_download_after_quite_clean", jSONObject, dkVar);
    }

    public void m(com.ss.android.downloadlib.addownload.dk.np npVar) {
        this.dk = npVar;
    }

    public boolean m() {
        return this.f38604l.get();
    }

    public void m(boolean z10) {
        this.f38604l.set(z10);
    }

    public void m(final int i10, final long j10, long j11, final np.m mVar) {
        this.f38604l.set(false);
        if (mVar == null) {
            return;
        }
        if (com.ss.android.downloadlib.hc.np.n(i10) && com.ss.android.downloadlib.hc.np.np(i10)) {
            long ej = com.ss.android.downloadlib.hc.np.ej(i10);
            this.ej.set(false);
            final String downloadUrl = this.dk.dk.getDownloadUrl();
            com.ss.android.downloadad.api.m.dk dk = com.ss.android.downloadlib.addownload.dk.n.m().dk(downloadUrl);
            if (dk == null) {
                com.ss.android.downloadlib.addownload.dk.np npVar = this.dk;
                dk = new com.ss.android.downloadad.api.m.dk(npVar.dk, npVar.ej, npVar.f38585l, 0);
                com.ss.android.downloadlib.addownload.dk.n.m().m(dk);
            }
            final com.ss.android.downloadad.api.m.dk dkVar = dk;
            dkVar.np(false);
            if (c.sy() != null) {
                c.sy().m(dkVar.dk());
            }
            com.ss.android.downloadlib.addownload.ej.l.m().m(dkVar.m());
            boolean l10 = com.ss.android.downloadlib.hc.np.l(i10);
            if (j11 > 0) {
                m(i10, downloadUrl, j11, dkVar, j10, mVar);
            } else if (l10) {
                m(downloadUrl, dkVar, new np.dk() { // from class: com.ss.android.downloadlib.addownload.l.1
                    @Override // com.ss.android.downloadlib.addownload.np.dk
                    public void m(long j12) {
                        l.this.m(i10, downloadUrl, j12, dkVar, j10, mVar);
                    }
                });
            } else {
                ej = 0;
            }
            this.f38605m.postDelayed(new Runnable() { // from class: com.ss.android.downloadlib.addownload.l.2
                @Override // java.lang.Runnable
                public void run() {
                    if (l.this.ej.get()) {
                        return;
                    }
                    l.this.ej.set(true);
                    mVar.m();
                }
            }, ej);
            return;
        }
        mVar.m();
    }

    private void m(String str, com.ss.android.downloadad.api.m.dk dkVar, final np.dk dkVar2) {
        if (dkVar2 == null) {
            return;
        }
        DownloadPreconnecter.asyncFetchHttpHeadInfo(str, new IFetchHttpHeadInfoListener() { // from class: com.ss.android.downloadlib.addownload.l.3
            @Override // com.ss.android.socialbase.downloader.network.IFetchHttpHeadInfoListener
            public void onFetchFinished(Map<String, String> map) {
                if (l.this.ej.get()) {
                    return;
                }
                l.this.ej.set(true);
                long m10 = l.this.m(map);
                if (m10 > 0) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt("apk_size", Long.valueOf(m10));
                        jSONObject.putOpt("available_space", Long.valueOf(l.ej()));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                dkVar2.m(m10);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long m(Map<String, String> map) {
        if (map != null && map.size() != 0) {
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if ("content-length".equalsIgnoreCase(key)) {
                        return Long.parseLong(value);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(int i10, String str, long j10, final com.ss.android.downloadad.api.m.dk dkVar, long j11, final np.m mVar) {
        this.ej.set(true);
        boolean z10 = false;
        if (j10 > 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("apk_size", Long.valueOf(j10));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            long longValue = (Double.valueOf((com.ss.android.downloadlib.hc.np.m(i10) + 1.0d) * j10).longValue() + com.ss.android.downloadlib.hc.np.dk(i10)) - j11;
            long l10 = l();
            if (l10 < longValue) {
                m(dkVar, jSONObject, longValue, l10);
                m(dkVar);
                long l11 = l();
                if (l11 < longValue) {
                    dkVar.l(true);
                    final String m10 = dkVar.m();
                    com.ss.android.downloadlib.addownload.ej.l.m().m(m10, new com.ss.android.downloadlib.addownload.ej.np() { // from class: com.ss.android.downloadlib.addownload.l.4
                    });
                    z10 = m(i10, dkVar, str, longValue);
                    if (z10) {
                        dkVar.np(true);
                    }
                } else {
                    dk(dkVar, jSONObject, l10, l11);
                }
            }
        }
        if (z10) {
            return;
        }
        this.f38605m.post(new Runnable() { // from class: com.ss.android.downloadlib.addownload.l.5
            @Override // java.lang.Runnable
            public void run() {
                mVar.m();
            }
        });
    }

    private boolean m(int i10, @NonNull com.ss.android.downloadad.api.m.dk dkVar, String str, long j10) {
        if (!com.ss.android.downloadlib.hc.np.n(i10)) {
            return false;
        }
        if (c.sy() != null) {
            return c.sy().m(i10, str, true, j10);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("show_dialog_result", 3);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.l.m.m().m("cleanspace_window_show", jSONObject, dkVar);
        return false;
    }

    public static boolean m(final DownloadInfo downloadInfo, long j10) {
        int id2 = downloadInfo.getId();
        boolean z10 = false;
        if (!com.ss.android.downloadlib.hc.np.n(id2)) {
            return false;
        }
        if (c.sy() != null && (z10 = c.sy().m(id2, downloadInfo.getUrl(), false, j10))) {
            com.ss.android.downloadlib.addownload.ej.l.m().m(downloadInfo.getUrl(), new com.ss.android.downloadlib.addownload.ej.np() { // from class: com.ss.android.downloadlib.addownload.l.6
            });
        }
        return z10;
    }

    public static JSONObject m(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("clean_space_install_params", str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public static void m(int i10) {
        if (com.ss.android.downloadlib.hc.np.n(i10) && c.sy() != null && c.sy().dk()) {
            c.sy().ej();
        }
    }

    private static void m(com.ss.android.downloadad.api.m.dk dkVar) {
        long l10 = l();
        if (c.sy() != null) {
            c.sy().np();
        }
        com.ss.android.downloadlib.addownload.ej.ej.m();
        com.ss.android.downloadlib.addownload.ej.ej.dk();
        if (com.ss.android.downloadlib.hc.np.hc(dkVar.x())) {
            com.ss.android.downloadlib.addownload.ej.ej.m(c.getContext());
        }
        long l11 = l();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("quite_clean_size", Long.valueOf(l11 - l10));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.l.m.m().m("clean_quite_finish", jSONObject, dkVar);
    }

    private void m(com.ss.android.downloadad.api.m.dk dkVar, JSONObject jSONObject, long j10, long j11) {
        try {
            jSONObject.putOpt("available_space", Long.valueOf(j11));
            jSONObject.putOpt("apk_download_need_size", Long.valueOf(j10));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.l.m.m().m("clean_space_no_enough_for_download", jSONObject, dkVar);
    }
}
