package com.ss.android.download.api.download;

import org.json.JSONObject;

@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ej implements DownloadEventConfig {

    /* renamed from: c, reason: collision with root package name */
    private String f38373c;
    private boolean dk;

    /* renamed from: e, reason: collision with root package name */
    private String f38374e;
    private String ej;

    /* renamed from: hc, reason: collision with root package name */
    private String f38375hc;

    /* renamed from: k, reason: collision with root package name */
    private String f38376k;

    /* renamed from: l, reason: collision with root package name */
    private String f38377l;

    /* renamed from: m, reason: collision with root package name */
    private String f38378m;

    /* renamed from: n, reason: collision with root package name */
    private String f38379n;
    private String np;

    /* renamed from: oa, reason: collision with root package name */
    private String f38380oa;

    /* renamed from: q, reason: collision with root package name */
    private boolean f38381q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f38382r;
    private boolean sy;

    /* renamed from: t, reason: collision with root package name */
    private String f38383t;
    private Object ve;

    /* renamed from: w, reason: collision with root package name */
    private String f38384w;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class m {

        /* renamed from: c, reason: collision with root package name */
        private String f38385c;
        private boolean dk;

        /* renamed from: e, reason: collision with root package name */
        private String f38386e;
        private String ej;

        /* renamed from: hc, reason: collision with root package name */
        private String f38387hc;

        /* renamed from: k, reason: collision with root package name */
        private String f38388k;

        /* renamed from: l, reason: collision with root package name */
        private String f38389l;

        /* renamed from: m, reason: collision with root package name */
        private String f38390m;

        /* renamed from: n, reason: collision with root package name */
        private String f38391n;
        private String np;

        /* renamed from: oa, reason: collision with root package name */
        private String f38392oa;

        /* renamed from: q, reason: collision with root package name */
        private boolean f38393q;

        /* renamed from: r, reason: collision with root package name */
        private boolean f38394r;
        private boolean sy;

        /* renamed from: t, reason: collision with root package name */
        private String f38395t;
        private Object ve;

        /* renamed from: w, reason: collision with root package name */
        private String f38396w;

        public ej m() {
            return new ej(this);
        }
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickButtonTag() {
        return this.f38378m;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickContinueLabel() {
        return this.f38379n;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickInstallLabel() {
        return this.f38375hc;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickItemTag() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickLabel() {
        return this.ej;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickPauseLabel() {
        return this.np;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickStartLabel() {
        return this.f38377l;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public int getDownloadScene() {
        return 0;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public Object getExtraEventObject() {
        return this.ve;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public JSONObject getExtraJson() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public JSONObject getParamsJson() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getRefer() {
        return this.f38383t;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getStorageDenyLabel() {
        return this.f38380oa;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public boolean isEnableClickEvent() {
        return this.dk;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public boolean isEnableV3Event() {
        return this.sy;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public void setDownloadScene(int i10) {
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public void setRefer(String str) {
    }

    public ej() {
    }

    private ej(m mVar) {
        this.f38378m = mVar.f38390m;
        this.dk = mVar.dk;
        this.ej = mVar.ej;
        this.f38377l = mVar.f38389l;
        this.np = mVar.np;
        this.f38379n = mVar.f38391n;
        this.f38375hc = mVar.f38387hc;
        this.f38374e = mVar.f38386e;
        this.f38384w = mVar.f38396w;
        this.f38380oa = mVar.f38392oa;
        this.f38373c = mVar.f38385c;
        this.ve = mVar.ve;
        this.sy = mVar.sy;
        this.f38382r = mVar.f38394r;
        this.f38381q = mVar.f38393q;
        this.f38376k = mVar.f38388k;
        this.f38383t = mVar.f38395t;
    }
}
