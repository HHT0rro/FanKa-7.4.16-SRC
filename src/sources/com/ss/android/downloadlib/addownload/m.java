package com.ss.android.downloadlib.addownload;

import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.hc.sy;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.ss.android.socialbase.downloader.utils.SystemUtils;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class m implements sy.m {
    private static m dk = null;

    /* renamed from: m, reason: collision with root package name */
    private static final String f38633m = "m";
    private com.ss.android.downloadlib.hc.sy ej = new com.ss.android.downloadlib.hc.sy(Looper.getMainLooper(), this);

    /* renamed from: l, reason: collision with root package name */
    private long f38634l;

    private m() {
    }

    public static m m() {
        if (dk == null) {
            synchronized (m.class) {
                if (dk == null) {
                    dk = new m();
                }
            }
        }
        return dk;
    }

    public void m(@NonNull DownloadInfo downloadInfo, long j10, long j11, String str, String str2, String str3, String str4) {
        com.ss.android.downloadlib.addownload.dk.m mVar = new com.ss.android.downloadlib.addownload.dk.m(downloadInfo.getId(), j10, j11, str, str2, str3, str4);
        if (DownloadSetting.obtain(downloadInfo.getId()).optInt("back_miui_silent_install", 1) == 0 && ((com.ss.android.socialbase.appdownloader.n.np.sy() || com.ss.android.socialbase.appdownloader.n.np.r()) && SystemUtils.checkServiceExists(c.getContext(), "com.miui.securitycore", "com.miui.enterprise.service.EntInstallService"))) {
            if (DownloadUtils.getBoolean(downloadInfo.getTempCacheData().get("extra_silent_install_succeed"), false)) {
                Message obtainMessage = this.ej.obtainMessage(200, mVar);
                obtainMessage.arg1 = 2;
                this.ej.sendMessageDelayed(obtainMessage, r1.optInt("check_silent_install_interval", 60000));
                return;
            }
            com.ss.android.downloadad.api.m.dk l10 = com.ss.android.downloadlib.addownload.dk.n.m().l(mVar.dk);
            JSONObject jSONObject = new JSONObject();
            int i10 = -1;
            try {
                jSONObject.put("ttdownloader_type", "miui_silent_install");
                jSONObject.put("ttdownloader_message", "miui_silent_install_failed: has not started service");
                i10 = 5;
            } catch (Exception unused) {
            }
            c.n().m(null, new BaseException(i10, jSONObject.toString()), i10);
            com.ss.android.downloadlib.l.m.m().m("embeded_ad", "ah_result", jSONObject, l10);
        }
        if (com.ss.android.downloadlib.hc.np.ej()) {
            long currentTimeMillis = System.currentTimeMillis() - this.f38634l;
            long l11 = com.ss.android.downloadlib.hc.np.l();
            if (currentTimeMillis < com.ss.android.downloadlib.hc.np.np()) {
                long np = com.ss.android.downloadlib.hc.np.np() - currentTimeMillis;
                l11 += np;
                this.f38634l = System.currentTimeMillis() + np;
            } else {
                this.f38634l = System.currentTimeMillis();
            }
            com.ss.android.downloadlib.hc.sy syVar = this.ej;
            syVar.sendMessageDelayed(syVar.obtainMessage(200, mVar), l11);
        }
    }

    private void m(com.ss.android.downloadlib.addownload.dk.m mVar, int i10) {
        if (c.ve() == null || c.ve().m() || mVar == null) {
            return;
        }
        if (2 == i10) {
            com.ss.android.downloadad.api.m.dk l10 = com.ss.android.downloadlib.addownload.dk.n.m().l(mVar.dk);
            JSONObject jSONObject = new JSONObject();
            int i11 = -1;
            try {
                jSONObject.put("ttdownloader_type", "miui_silent_install");
                if (com.ss.android.downloadlib.hc.ve.np(c.getContext(), mVar.f38578l)) {
                    jSONObject.put("ttdownloader_message", "miui_silent_install_succeed");
                    i11 = 4;
                } else {
                    jSONObject.put("ttdownloader_message", "miui_silent_install_failed: has started service");
                    i11 = 5;
                }
            } catch (Exception unused) {
            }
            c.n().m(null, new BaseException(i11, jSONObject.toString()), i11);
            com.ss.android.downloadlib.l.m.m().m("embeded_ad", "ah_result", jSONObject, l10);
        }
        if (com.ss.android.downloadlib.hc.ve.np(c.getContext(), mVar.f38578l)) {
            com.ss.android.downloadlib.l.m.m().m("delayinstall_installed", mVar.dk);
            return;
        }
        if (!com.ss.android.downloadlib.hc.ve.m(mVar.f38577hc)) {
            com.ss.android.downloadlib.l.m.m().m("delayinstall_file_lost", mVar.dk);
        } else if (com.ss.android.downloadlib.addownload.m.m.m().m(mVar.f38578l)) {
            com.ss.android.downloadlib.l.m.m().m("delayinstall_conflict_with_back_dialog", mVar.dk);
        } else {
            com.ss.android.downloadlib.l.m.m().m("delayinstall_install_start", mVar.dk);
            com.ss.android.socialbase.appdownloader.l.m(c.getContext(), (int) mVar.f38579m);
        }
    }

    @Override // com.ss.android.downloadlib.hc.sy.m
    public void m(Message message) {
        if (message.what != 200) {
            return;
        }
        m((com.ss.android.downloadlib.addownload.dk.m) message.obj, message.arg1);
    }
}
