package com.ss.android.downloadlib.addownload.ej;

import com.ss.android.downloadlib.addownload.c;
import com.ss.android.downloadlib.addownload.dk.n;
import com.ss.android.downloadlib.addownload.dk.w;
import com.ss.android.downloadlib.hc.ve;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class dk implements Runnable {

    /* renamed from: m, reason: collision with root package name */
    private DownloadInfo f38599m;

    public dk(DownloadInfo downloadInfo) {
        this.f38599m = downloadInfo;
    }

    @Override // java.lang.Runnable
    public void run() {
        final com.ss.android.downloadad.api.m.dk m10;
        if (this.f38599m == null || (m10 = n.m().m(this.f38599m)) == null) {
            return;
        }
        com.ss.android.downloadlib.l.m.m().m("cleanspace_task", m10);
        long longValue = Double.valueOf((com.ss.android.downloadlib.hc.np.m(this.f38599m.getId()) + 1.0d) * this.f38599m.getTotalBytes()).longValue() - this.f38599m.getCurBytes();
        long dk = ve.dk(0L);
        if (c.sy() != null) {
            c.sy().np();
        }
        ej.m();
        ej.dk();
        if (com.ss.android.downloadlib.hc.np.hc(m10.x())) {
            ej.m(c.getContext());
        }
        long dk2 = ve.dk(0L);
        if (dk2 >= longValue) {
            m10.ve("1");
            w.m().m(m10);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("quite_clean_size", Long.valueOf(dk2 - dk));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            com.ss.android.downloadlib.l.m.m().m("cleanspace_download_after_quite_clean", jSONObject, m10);
            Downloader.getInstance(c.getContext()).restart(this.f38599m.getId());
            return;
        }
        if (c.sy() != null) {
            m10.l(false);
            l.m().m(m10.m(), new np() { // from class: com.ss.android.downloadlib.addownload.ej.dk.1
            });
            if (c.sy().m(this.f38599m.getId(), this.f38599m.getUrl(), true, longValue)) {
                m10.np(true);
                return;
            }
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("show_dialog_result", 3);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        com.ss.android.downloadlib.l.m.m().m("cleanspace_window_show", jSONObject2, m10);
    }
}
