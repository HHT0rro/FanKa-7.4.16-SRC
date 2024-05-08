package com.ss.android.downloadlib.addownload.dk;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import java.util.List;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class np implements com.ss.android.downloadad.api.m.m {
    public DownloadModel dk;
    public DownloadEventConfig ej;

    /* renamed from: l, reason: collision with root package name */
    public DownloadController f38585l;

    /* renamed from: m, reason: collision with root package name */
    public long f38586m;
    public com.ss.android.downloadad.api.m.dk np;

    public np() {
    }

    @Override // com.ss.android.downloadad.api.m.m
    public JSONObject c() {
        return this.ej.getParamsJson();
    }

    @Override // com.ss.android.downloadad.api.m.m
    public DownloadModel dh() {
        return this.dk;
    }

    @Override // com.ss.android.downloadad.api.m.m
    public long dk() {
        return this.dk.getId();
    }

    @Override // com.ss.android.downloadad.api.m.m
    public int e() {
        if (this.f38585l.getDownloadMode() == 2) {
            return 2;
        }
        return this.dk.getFunnelType();
    }

    @Override // com.ss.android.downloadad.api.m.m
    public boolean ej() {
        return this.dk.isAd();
    }

    @Override // com.ss.android.downloadad.api.m.m
    public JSONObject f() {
        return this.dk.getDownloadSettings();
    }

    @Override // com.ss.android.downloadad.api.m.m
    public JSONObject hc() {
        return this.dk.getExtra();
    }

    @Override // com.ss.android.downloadad.api.m.m
    public JSONObject k() {
        return this.ej.getExtraJson();
    }

    @Override // com.ss.android.downloadad.api.m.m
    public String l() {
        return this.dk.getLogExtra();
    }

    @Override // com.ss.android.downloadad.api.m.m
    public DownloadEventConfig li() {
        return this.ej;
    }

    @Override // com.ss.android.downloadad.api.m.m
    public String m() {
        return this.dk.getDownloadUrl();
    }

    @Override // com.ss.android.downloadad.api.m.m
    public int mj() {
        return this.ej.getDownloadScene();
    }

    @Override // com.ss.android.downloadad.api.m.m
    public String n() {
        if (this.dk.getDeepLink() != null) {
            return this.dk.getDeepLink().getOpenUrl();
        }
        return null;
    }

    @Override // com.ss.android.downloadad.api.m.m
    public String np() {
        return this.dk.getPackageName();
    }

    @Override // com.ss.android.downloadad.api.m.m
    public String oa() {
        return this.ej.getClickButtonTag();
    }

    @Override // com.ss.android.downloadad.api.m.m
    public Object q() {
        return this.ej.getExtraEventObject();
    }

    @Override // com.ss.android.downloadad.api.m.m
    public List<String> r() {
        return this.dk.getClickTrackUrl();
    }

    public boolean s() {
        DownloadModel downloadModel;
        if (this.f38586m == 0 || (downloadModel = this.dk) == null || this.ej == null || this.f38585l == null) {
            return true;
        }
        return downloadModel.isAd() && this.f38586m <= 0;
    }

    @Override // com.ss.android.downloadad.api.m.m
    public boolean sy() {
        return this.ej.isEnableV3Event();
    }

    @Override // com.ss.android.downloadad.api.m.m
    public boolean t() {
        return this.f38585l.enableNewActivity();
    }

    public boolean u() {
        if (s()) {
            return false;
        }
        if (this.dk.isAd()) {
            DownloadModel downloadModel = this.dk;
            return (downloadModel instanceof AdDownloadModel) && !TextUtils.isEmpty(downloadModel.getLogExtra()) && (this.ej instanceof AdDownloadEventConfig) && (this.f38585l instanceof AdDownloadController);
        }
        return this.dk instanceof AdDownloadModel;
    }

    @Override // com.ss.android.downloadad.api.m.m
    public DownloadController v() {
        return this.f38585l;
    }

    @Override // com.ss.android.downloadad.api.m.m
    public long ve() {
        return this.dk.getExtraValue();
    }

    @Override // com.ss.android.downloadad.api.m.m
    public String w() {
        return this.ej.getRefer();
    }

    @Override // com.ss.android.downloadad.api.m.m
    public int x() {
        return 0;
    }

    public np(long j10, @NonNull DownloadModel downloadModel, @NonNull DownloadEventConfig downloadEventConfig, @NonNull DownloadController downloadController) {
        this.f38586m = j10;
        this.dk = downloadModel;
        this.ej = downloadEventConfig;
        this.f38585l = downloadController;
    }
}
