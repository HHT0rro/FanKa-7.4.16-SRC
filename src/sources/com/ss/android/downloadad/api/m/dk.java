package com.ss.android.downloadad.api.m;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.DeepLink;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.c;
import com.ss.android.socialbase.downloader.constants.DbJsonConstants;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class dk implements m {
    private boolean am;

    /* renamed from: b, reason: collision with root package name */
    private boolean f38446b;
    private String bm;
    private boolean by;
    private boolean bz;

    /* renamed from: c, reason: collision with root package name */
    private String f38447c;
    private boolean ch;
    private boolean cm;

    /* renamed from: d, reason: collision with root package name */
    private String f38448d;

    /* renamed from: db, reason: collision with root package name */
    private String f38449db;
    private long dh;
    public boolean dk;

    /* renamed from: e, reason: collision with root package name */
    private int f38450e;

    /* renamed from: ee, reason: collision with root package name */
    private long f38451ee;
    public final AtomicBoolean ej;

    /* renamed from: f, reason: collision with root package name */
    private String f38452f;

    /* renamed from: fb, reason: collision with root package name */
    private long f38453fb;
    private boolean fh;
    private int fr;

    /* renamed from: g, reason: collision with root package name */
    private String f38454g;
    private boolean gg;
    private long gw;
    private boolean gx;

    /* renamed from: hc, reason: collision with root package name */
    private String f38455hc;
    private int hr;

    /* renamed from: i, reason: collision with root package name */
    private boolean f38456i;
    private String iy;
    private boolean iz;

    /* renamed from: k, reason: collision with root package name */
    private int f38457k;
    private long ks;

    /* renamed from: l, reason: collision with root package name */
    public final AtomicBoolean f38458l;
    private boolean lf;
    private JSONObject li;

    /* renamed from: m, reason: collision with root package name */
    public boolean f38459m;
    private boolean mj;

    /* renamed from: n, reason: collision with root package name */
    private long f38460n;
    private boolean ni;
    private long np;

    /* renamed from: o, reason: collision with root package name */
    private long f38461o;

    /* renamed from: oa, reason: collision with root package name */
    private String f38462oa;

    /* renamed from: p, reason: collision with root package name */
    private long f38463p;

    /* renamed from: q, reason: collision with root package name */
    private int f38464q;

    @AdBaseConstants.FunnelType
    private int qx;

    /* renamed from: r, reason: collision with root package name */
    private int f38465r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f38466s;

    /* renamed from: sa, reason: collision with root package name */
    private transient boolean f38467sa;
    private boolean se;
    private int sy;

    /* renamed from: t, reason: collision with root package name */
    private String f38468t;

    /* renamed from: u, reason: collision with root package name */
    private int f38469u;

    /* renamed from: ub, reason: collision with root package name */
    private int f38470ub;
    private boolean un;

    /* renamed from: v, reason: collision with root package name */
    private int f38471v;
    private String ve;

    /* renamed from: w, reason: collision with root package name */
    private String f38472w;

    /* renamed from: x, reason: collision with root package name */
    private String f38473x;
    private boolean yy;

    /* renamed from: z, reason: collision with root package name */
    private String f38474z;

    /* renamed from: za, reason: collision with root package name */
    private boolean f38475za;
    private int zk;

    private dk() {
        this.f38450e = 1;
        this.mj = true;
        this.f38466s = false;
        this.f38469u = 0;
        this.fr = 0;
        this.ni = false;
        this.f38446b = false;
        this.lf = true;
        this.se = true;
        this.f38459m = true;
        this.dk = true;
        this.ej = new AtomicBoolean(false);
        this.f38458l = new AtomicBoolean(false);
        this.qx = 1;
        this.fh = true;
        this.f38463p = -1L;
    }

    public boolean am() {
        return this.yy;
    }

    public int b() {
        return this.f38457k;
    }

    public String bm() {
        return this.bm;
    }

    public boolean by() {
        return this.gx;
    }

    public int bz() {
        return this.f38465r;
    }

    @Override // com.ss.android.downloadad.api.m.m
    public JSONObject c() {
        return null;
    }

    public void c(String str) {
        this.f38473x = str;
    }

    public String ch() {
        return this.f38454g;
    }

    public boolean cm() {
        return this.f38446b;
    }

    public boolean d() {
        return this.f38466s;
    }

    public long db() {
        return this.dh;
    }

    public void dh(boolean z10) {
        this.dk = z10;
    }

    public void dk(int i10) {
        this.fr = i10;
    }

    public AdDownloadController dp() {
        return new AdDownloadController.Builder().setIsEnableBackDialog(this.f38466s).setLinkMode(this.f38465r).setDownloadMode(this.f38464q).setEnableShowComplianceDialog(this.fh).setEnableAH(this.f38459m).setEnableAM(this.dk).build();
    }

    public void e(int i10) {
        this.f38470ub = i10;
    }

    public long ee() {
        return this.ks;
    }

    public void ej(long j10) {
        this.f38451ee = j10;
    }

    @Override // com.ss.android.downloadad.api.m.m
    public JSONObject f() {
        return null;
    }

    public void f(boolean z10) {
        this.lf = z10;
    }

    public boolean fb() {
        return this.bz;
    }

    public long fh() {
        return this.f38453fb;
    }

    public int fr() {
        return this.fr;
    }

    public AdDownloadModel g() {
        return new AdDownloadModel.Builder().setAdId(this.np).setExtraValue(this.f38460n).setLogExtra(this.f38455hc).setPackageName(this.f38472w).setExtra(this.li).setIsAd(this.mj).setVersionCode(this.f38457k).setVersionName(this.f38468t).setDownloadUrl(this.f38462oa).setModelType(this.sy).setMimeType(this.f38449db).setAppName(this.f38452f).setAppIcon(this.f38473x).setTaskKey(this.f38454g).setDeepLink(new DeepLink(this.f38447c, this.ve, null)).build();
    }

    public boolean gg() {
        return this.ch;
    }

    public synchronized void gw() {
        this.fr++;
    }

    public JSONObject gx() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mId", this.np);
            jSONObject.put("mExtValue", this.f38460n);
            jSONObject.put("mLogExtra", this.f38455hc);
            jSONObject.put("mDownloadStatus", this.f38450e);
            jSONObject.put("mPackageName", this.f38472w);
            jSONObject.put("mIsAd", this.mj);
            jSONObject.put("mTimeStamp", this.dh);
            jSONObject.put("mExtras", this.li);
            jSONObject.put("mVersionCode", this.f38457k);
            jSONObject.put("mVersionName", this.f38468t);
            jSONObject.put("mDownloadId", this.f38471v);
            jSONObject.put("mIsV3Event", this.un);
            jSONObject.put("mScene", this.f38470ub);
            jSONObject.put("mEventTag", this.f38448d);
            jSONObject.put("mEventRefer", this.f38474z);
            jSONObject.put("mDownloadUrl", this.f38462oa);
            jSONObject.put("mEnableBackDialog", this.f38466s);
            jSONObject.put("hasSendInstallFinish", this.ej.get());
            jSONObject.put("hasSendDownloadFailedFinally", this.f38458l.get());
            jSONObject.put("mLastFailedErrCode", this.zk);
            jSONObject.put("mLastFailedErrMsg", this.bm);
            jSONObject.put("mOpenUrl", this.f38447c);
            jSONObject.put("mLinkMode", this.f38465r);
            jSONObject.put("mDownloadMode", this.f38464q);
            jSONObject.put("mModelType", this.sy);
            jSONObject.put("mAppName", this.f38452f);
            jSONObject.put("mAppIcon", this.f38473x);
            jSONObject.put("mDownloadFailedTimes", this.f38469u);
            long j10 = this.gw;
            if (j10 == 0) {
                j10 = this.dh;
            }
            jSONObject.put("mRecentDownloadResumeTime", j10);
            jSONObject.put("mClickPauseTimes", this.fr);
            jSONObject.put("mJumpInstallTime", this.ks);
            jSONObject.put("mCancelInstallTime", this.f38451ee);
            jSONObject.put("mLastFailedResumeCount", this.hr);
            jSONObject.put("mIsUpdateDownload", this.ni);
            jSONObject.put("mOriginMimeType", this.f38449db);
            jSONObject.put("mIsPatchApplyHandled", this.f38446b);
            jSONObject.put("downloadFinishReason", this.iy);
            jSONObject.put("clickDownloadTime", this.f38453fb);
            jSONObject.put("clickDownloadSize", this.f38461o);
            jSONObject.put("installAfterCleanSpace", this.bz);
            jSONObject.put(TTDownloadField.TT_FUNNEL_TYPE, this.qx);
            jSONObject.put(TTDownloadField.TT_WEB_URL, this.ve);
            jSONObject.put(TTDownloadField.TT_ENABLE_SHOW_COMPLIANCE_DIALOG, this.fh);
            jSONObject.put(TTDownloadField.TT_IS_AUTO_DOWNLOAD_ON_CARD_SHOW, this.iz);
            int i10 = 1;
            jSONObject.put("enable_new_activity", this.lf ? 1 : 0);
            jSONObject.put("enable_pause", this.se ? 1 : 0);
            jSONObject.put("enable_ah", this.f38459m ? 1 : 0);
            if (!this.dk) {
                i10 = 0;
            }
            jSONObject.put("enable_am", i10);
            jSONObject.putOpt("intent_jump_browser_success", Boolean.valueOf(this.gx));
            jSONObject.put(DbJsonConstants.DBJSON_KEY_TASK_KEY, this.f38454g);
        } catch (Exception e2) {
            c.mj().m(e2, "NativeDownloadModel toJson");
        }
        return jSONObject;
    }

    @Override // com.ss.android.downloadad.api.m.m
    public JSONObject hc() {
        return this.li;
    }

    public int hr() {
        return this.hr;
    }

    public String i() {
        return this.f38449db;
    }

    public boolean iy() {
        return this.ni;
    }

    public long iz() {
        return this.f38461o;
    }

    @Override // com.ss.android.downloadad.api.m.m
    public JSONObject k() {
        return null;
    }

    public void k(boolean z10) {
        this.fh = z10;
    }

    public long ks() {
        long j10 = this.gw;
        return j10 == 0 ? this.dh : j10;
    }

    public void l(int i10) {
        this.zk = i10;
    }

    public String lf() {
        return this.f38468t;
    }

    public void li(boolean z10) {
        this.gx = z10;
    }

    public void m(int i10) {
        this.f38469u = i10;
    }

    @Override // com.ss.android.downloadad.api.m.m
    public int mj() {
        return -1;
    }

    public void mj(boolean z10) {
        this.f38459m = z10;
    }

    public void n(long j10) {
        if (j10 > 0) {
            this.dh = j10;
        }
    }

    public int ni() {
        return this.f38450e;
    }

    public void np(long j10) {
        this.f38460n = j10;
    }

    public boolean o() {
        return this.f38475za;
    }

    @Override // com.ss.android.downloadad.api.m.m
    public String oa() {
        return this.f38448d;
    }

    public boolean p() {
        return this.am;
    }

    @Override // com.ss.android.downloadad.api.m.m
    public Object q() {
        return null;
    }

    public void q(boolean z10) {
        this.ch = z10;
    }

    public boolean qx() {
        return this.cm;
    }

    @Override // com.ss.android.downloadad.api.m.m
    public List<String> r() {
        return null;
    }

    public void r(boolean z10) {
        this.by = z10;
    }

    public int s() {
        return this.f38469u;
    }

    public boolean sa() {
        return this.gg;
    }

    public int se() {
        return this.f38470ub;
    }

    public AdDownloadEventConfig su() {
        return new AdDownloadEventConfig.Builder().setClickButtonTag(this.f38448d).setRefer(this.f38474z).setIsEnableV3Event(this.un).build();
    }

    @Override // com.ss.android.downloadad.api.m.m
    public boolean sy() {
        return this.un;
    }

    public void t(boolean z10) {
        this.iz = z10;
    }

    public synchronized void u() {
        this.f38469u++;
    }

    public String ub() {
        return this.iy;
    }

    public String un() {
        return this.f38452f;
    }

    @Override // com.ss.android.downloadad.api.m.m
    public DownloadController v() {
        return dp();
    }

    @Override // com.ss.android.downloadad.api.m.m
    public long ve() {
        return this.f38460n;
    }

    public void w(int i10) {
        this.qx = i10;
    }

    @Override // com.ss.android.downloadad.api.m.m
    public int x() {
        return this.f38471v;
    }

    public boolean yy() {
        return this.by;
    }

    public long z() {
        return this.f38463p;
    }

    public boolean za() {
        return this.f38467sa;
    }

    public int zk() {
        return this.zk;
    }

    public void c(int i10) {
        this.f38464q = i10;
    }

    @Override // com.ss.android.downloadad.api.m.m
    public DownloadModel dh() {
        return g();
    }

    public void dk(long j10) {
        this.ks = j10;
    }

    @Override // com.ss.android.downloadad.api.m.m
    public int e() {
        return this.qx;
    }

    public void ej(int i10) {
        this.hr = i10;
    }

    public void hc(int i10) {
        this.f38471v = i10;
    }

    public void l(long j10) {
        this.np = j10;
    }

    @Override // com.ss.android.downloadad.api.m.m
    public DownloadEventConfig li() {
        return su();
    }

    public void m(long j10) {
        this.gw = j10;
    }

    public void n(int i10) {
        this.f38457k = i10;
    }

    public void np(int i10) {
        this.f38450e = i10;
    }

    public void oa(String str) {
        this.f38452f = str;
    }

    public void r(String str) {
        this.f38454g = str;
    }

    public void sy(String str) {
        this.f38449db = str;
    }

    @Override // com.ss.android.downloadad.api.m.m
    public boolean t() {
        return this.lf;
    }

    public void ve(int i10) {
        this.sy = i10;
    }

    @Override // com.ss.android.downloadad.api.m.m
    public String w() {
        return this.f38474z;
    }

    public void x(boolean z10) {
        this.se = z10;
    }

    public void c(boolean z10) {
        this.am = z10;
    }

    @Override // com.ss.android.downloadad.api.m.m
    public long dk() {
        return this.np;
    }

    public void e(String str) {
        this.f38462oa = str;
    }

    public void ej(String str) {
        this.f38455hc = str;
    }

    public void hc(String str) {
        this.f38474z = str;
    }

    @Override // com.ss.android.downloadad.api.m.m
    public String l() {
        return this.f38455hc;
    }

    public void m(String str) {
        this.bm = str;
    }

    public void n(String str) {
        this.f38448d = str;
    }

    @Override // com.ss.android.downloadad.api.m.m
    public String np() {
        return this.f38472w;
    }

    public void oa(int i10) {
        this.f38465r = i10;
    }

    public void sy(boolean z10) {
        this.yy = z10;
    }

    public void ve(String str) {
        this.iy = str;
    }

    public void w(String str) {
        this.f38447c = str;
    }

    public void dk(String str) {
        this.f38472w = str;
    }

    public void e(long j10) {
        this.f38453fb = j10;
    }

    @Override // com.ss.android.downloadad.api.m.m
    public boolean ej() {
        return this.mj;
    }

    public void hc(long j10) {
        this.f38463p = j10;
    }

    public void l(String str) {
        this.f38468t = str;
    }

    public void m(boolean z10) {
        this.mj = z10;
    }

    @Override // com.ss.android.downloadad.api.m.m
    public String n() {
        return this.f38447c;
    }

    public void np(String str) {
        this.ve = str;
    }

    public void oa(boolean z10) {
        this.f38467sa = z10;
    }

    public void ve(boolean z10) {
        this.gg = z10;
    }

    public void w(long j10) {
        this.f38461o = j10;
    }

    public void dk(boolean z10) {
        this.un = z10;
    }

    public void e(boolean z10) {
        this.ni = z10;
    }

    public void ej(boolean z10) {
        this.f38466s = z10;
    }

    public void hc(boolean z10) {
        this.f38475za = z10;
    }

    public void l(boolean z10) {
        this.f38456i = z10;
    }

    public void m(JSONObject jSONObject) {
        this.li = jSONObject;
    }

    public void n(boolean z10) {
        this.bz = z10;
    }

    public void np(boolean z10) {
        this.cm = z10;
    }

    public void w(boolean z10) {
        this.f38446b = z10;
    }

    public static dk dk(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        dk dkVar = new dk();
        try {
            dkVar.l(com.ss.android.download.api.ej.dk.m(jSONObject, "mId"));
            dkVar.np(com.ss.android.download.api.ej.dk.m(jSONObject, "mExtValue"));
            dkVar.ej(jSONObject.optString("mLogExtra"));
            dkVar.np(jSONObject.optInt("mDownloadStatus"));
            dkVar.dk(jSONObject.optString("mPackageName"));
            boolean z10 = true;
            dkVar.m(jSONObject.optBoolean("mIsAd", true));
            dkVar.n(com.ss.android.download.api.ej.dk.m(jSONObject, "mTimeStamp"));
            dkVar.n(jSONObject.optInt("mVersionCode"));
            dkVar.l(jSONObject.optString("mVersionName"));
            dkVar.hc(jSONObject.optInt("mDownloadId"));
            dkVar.dk(jSONObject.optBoolean("mIsV3Event"));
            dkVar.e(jSONObject.optInt("mScene"));
            dkVar.n(jSONObject.optString("mEventTag"));
            dkVar.hc(jSONObject.optString("mEventRefer"));
            dkVar.e(jSONObject.optString("mDownloadUrl"));
            dkVar.ej(jSONObject.optBoolean("mEnableBackDialog"));
            dkVar.ej.set(jSONObject.optBoolean("hasSendInstallFinish"));
            dkVar.f38458l.set(jSONObject.optBoolean("hasSendDownloadFailedFinally"));
            dkVar.l(jSONObject.optInt("mLastFailedErrCode"));
            dkVar.m(jSONObject.optString("mLastFailedErrMsg"));
            dkVar.w(jSONObject.optString("mOpenUrl"));
            dkVar.oa(jSONObject.optInt("mLinkMode"));
            dkVar.c(jSONObject.optInt("mDownloadMode"));
            dkVar.ve(jSONObject.optInt("mModelType"));
            dkVar.oa(jSONObject.optString("mAppName"));
            dkVar.c(jSONObject.optString("mAppIcon"));
            dkVar.m(jSONObject.optInt("mDownloadFailedTimes", 0));
            dkVar.m(com.ss.android.download.api.ej.dk.m(jSONObject, "mRecentDownloadResumeTime"));
            dkVar.dk(jSONObject.optInt("mClickPauseTimes"));
            dkVar.dk(com.ss.android.download.api.ej.dk.m(jSONObject, "mJumpInstallTime"));
            dkVar.ej(com.ss.android.download.api.ej.dk.m(jSONObject, "mCancelInstallTime"));
            dkVar.ej(jSONObject.optInt("mLastFailedResumeCount"));
            dkVar.ve(jSONObject.optString("downloadFinishReason"));
            dkVar.w(jSONObject.optLong("clickDownloadSize"));
            dkVar.e(jSONObject.optLong("clickDownloadTime"));
            dkVar.e(jSONObject.optBoolean("mIsUpdateDownload"));
            dkVar.sy(jSONObject.optString("mOriginMimeType"));
            dkVar.w(jSONObject.optBoolean("mIsPatchApplyHandled"));
            dkVar.n(jSONObject.optBoolean("installAfterCleanSpace"));
            dkVar.w(jSONObject.optInt(TTDownloadField.TT_FUNNEL_TYPE, 1));
            dkVar.np(jSONObject.optString(TTDownloadField.TT_WEB_URL));
            dkVar.k(jSONObject.optBoolean(TTDownloadField.TT_ENABLE_SHOW_COMPLIANCE_DIALOG, true));
            dkVar.t(jSONObject.optBoolean(TTDownloadField.TT_IS_AUTO_DOWNLOAD_ON_CARD_SHOW));
            dkVar.f(jSONObject.optInt("enable_new_activity", 1) == 1);
            dkVar.x(jSONObject.optInt("enable_pause", 1) == 1);
            dkVar.mj(jSONObject.optInt("enable_ah", 1) == 1);
            if (jSONObject.optInt("enable_am", 1) != 1) {
                z10 = false;
            }
            dkVar.dh(z10);
            dkVar.m(jSONObject.optJSONObject("mExtras"));
            dkVar.li(jSONObject.optBoolean("intent_jump_browser_success"));
            dkVar.r(jSONObject.optString(DbJsonConstants.DBJSON_KEY_TASK_KEY));
        } catch (Exception e2) {
            c.mj().m(e2, "NativeDownloadModel fromJson");
        }
        return dkVar;
    }

    @Override // com.ss.android.downloadad.api.m.m
    public String m() {
        return this.f38462oa;
    }

    public dk(DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        this(downloadModel, downloadEventConfig, downloadController, 0);
    }

    public dk(DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, int i10) {
        this.f38450e = 1;
        this.mj = true;
        this.f38466s = false;
        this.f38469u = 0;
        this.fr = 0;
        this.ni = false;
        this.f38446b = false;
        this.lf = true;
        this.se = true;
        this.f38459m = true;
        this.dk = true;
        this.ej = new AtomicBoolean(false);
        this.f38458l = new AtomicBoolean(false);
        this.qx = 1;
        this.fh = true;
        this.f38463p = -1L;
        this.np = downloadModel.getId();
        this.f38460n = downloadModel.getExtraValue();
        this.f38455hc = downloadModel.getLogExtra();
        this.f38472w = downloadModel.getPackageName();
        this.li = downloadModel.getExtra();
        this.mj = downloadModel.isAd();
        this.f38457k = downloadModel.getVersionCode();
        this.f38468t = downloadModel.getVersionName();
        this.f38462oa = downloadModel.getDownloadUrl();
        if (downloadModel.getDeepLink() != null) {
            this.f38447c = downloadModel.getDeepLink().getOpenUrl();
            this.ve = downloadModel.getDeepLink().getWebUrl();
        }
        this.sy = downloadModel.getModelType();
        this.f38452f = downloadModel.getName();
        this.f38473x = downloadModel.getAppIcon();
        this.f38449db = downloadModel.getMimeType();
        this.f38448d = downloadEventConfig.getClickButtonTag();
        this.f38474z = downloadEventConfig.getRefer();
        this.un = downloadEventConfig.isEnableV3Event();
        this.f38466s = downloadController.isEnableBackDialog();
        this.f38465r = downloadController.getLinkMode();
        this.f38464q = downloadController.getDownloadMode();
        this.fh = downloadController.enableShowComplianceDialog();
        this.iz = downloadController.isAutoDownloadOnCardShow();
        this.lf = downloadController.enableNewActivity();
        this.f38459m = downloadController.enableAH();
        this.dk = downloadController.enableAM();
        this.f38471v = i10;
        long currentTimeMillis = System.currentTimeMillis();
        this.dh = currentTimeMillis;
        this.gw = currentTimeMillis;
        this.f38446b = downloadModel.shouldDownloadWithPatchApply();
        if (downloadModel instanceof AdDownloadModel) {
            this.f38454g = ((AdDownloadModel) downloadModel).getTaskKey();
        }
    }
}
