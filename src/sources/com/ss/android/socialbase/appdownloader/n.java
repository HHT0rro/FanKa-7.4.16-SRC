package com.ss.android.socialbase.appdownloader;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.constants.ExecutorGroup;
import com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.downloader.IChunkAdjustCalculator;
import com.ss.android.socialbase.downloader.downloader.IChunkCntCalculator;
import com.ss.android.socialbase.downloader.downloader.IRetryDelayTimeCalculator;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.notification.AbsNotificationItem;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class n {
    private boolean am;

    /* renamed from: b, reason: collision with root package name */
    private boolean f38897b;
    private IDownloadDepend bz;
    private String ch;

    /* renamed from: d, reason: collision with root package name */
    private int f38899d;

    /* renamed from: db, reason: collision with root package name */
    private boolean f38900db;
    private AbsNotificationItem dh;
    private Context dk;

    /* renamed from: e, reason: collision with root package name */
    private List<HttpHeader> f38901e;

    /* renamed from: ee, reason: collision with root package name */
    private int f38902ee;
    private String ej;

    /* renamed from: f, reason: collision with root package name */
    private IChunkAdjustCalculator f38903f;

    /* renamed from: fb, reason: collision with root package name */
    private IDownloadDiskSpaceHandler f38904fb;
    private INotificationClickCallback fh;
    private long fr;
    private String gg;
    private boolean gw;
    private int[] gx;

    /* renamed from: hc, reason: collision with root package name */
    private String f38905hc;
    private boolean hr;

    /* renamed from: i, reason: collision with root package name */
    private String f38906i;
    private JSONObject iy;
    private boolean iz;

    /* renamed from: l, reason: collision with root package name */
    private List<String> f38908l;
    private boolean li;

    /* renamed from: m, reason: collision with root package name */
    private Activity f38909m;
    private IRetryDelayTimeCalculator mj;

    /* renamed from: n, reason: collision with root package name */
    private String f38910n;
    private boolean ni;
    private String np;

    /* renamed from: o, reason: collision with root package name */
    private boolean f38911o;

    /* renamed from: p, reason: collision with root package name */
    private long f38913p;

    /* renamed from: q, reason: collision with root package name */
    private String f38914q;
    private IDownloadFileUriProvider qx;

    /* renamed from: r, reason: collision with root package name */
    private IDownloadListener f38915r;

    /* renamed from: s, reason: collision with root package name */
    private String f38916s;

    /* renamed from: sa, reason: collision with root package name */
    private int f38917sa;
    private IDownloadListener sy;

    /* renamed from: t, reason: collision with root package name */
    private boolean f38918t;

    /* renamed from: u, reason: collision with root package name */
    private String f38919u;

    /* renamed from: ub, reason: collision with root package name */
    private com.ss.android.socialbase.appdownloader.ej.np f38920ub;
    private IDownloadMonitorDepend un;

    /* renamed from: v, reason: collision with root package name */
    private boolean f38921v;

    /* renamed from: x, reason: collision with root package name */
    private IChunkCntCalculator f38923x;

    /* renamed from: za, reason: collision with root package name */
    private int f38925za;
    private String zk;

    /* renamed from: w, reason: collision with root package name */
    private boolean f38922w = true;

    /* renamed from: oa, reason: collision with root package name */
    private boolean f38912oa = false;

    /* renamed from: c, reason: collision with root package name */
    private boolean f38898c = true;
    private boolean ve = false;

    /* renamed from: k, reason: collision with root package name */
    private String f38907k = "application/vnd.android.package-archive";
    private int ks = 5;
    private boolean bm = true;
    private EnqueueType lf = EnqueueType.ENQUEUE_NONE;
    private int se = 150;

    /* renamed from: z, reason: collision with root package name */
    private boolean f38924z = true;
    private List<IDownloadCompleteHandler> cm = new ArrayList();
    private boolean yy = true;
    private boolean by = true;

    public n(@NonNull Context context, @NonNull String str) {
        this.dk = context.getApplicationContext();
        this.ej = str;
    }

    public String am() {
        return this.f38906i;
    }

    public boolean b() {
        return this.f38911o;
    }

    public boolean bm() {
        return this.f38900db;
    }

    public JSONObject by() {
        return this.iy;
    }

    public com.ss.android.socialbase.appdownloader.ej.np bz() {
        return this.f38920ub;
    }

    public String c() {
        return this.f38914q;
    }

    public String cm() {
        return this.ch;
    }

    public String d() {
        return this.f38910n;
    }

    public boolean db() {
        return this.f38924z;
    }

    public String dh() {
        return this.f38919u;
    }

    public String dk() {
        return this.np;
    }

    public boolean e() {
        return this.ve;
    }

    public IRetryDelayTimeCalculator ee() {
        return this.mj;
    }

    public String ej() {
        return this.f38905hc;
    }

    public boolean f() {
        return this.f38921v;
    }

    public List<IDownloadCompleteHandler> fb() {
        return this.cm;
    }

    public boolean fh() {
        return this.iz;
    }

    public String fr() {
        return this.zk;
    }

    public Activity getActivity() {
        return this.f38909m;
    }

    public Context getContext() {
        return this.dk;
    }

    public IDownloadDiskSpaceHandler gg() {
        return this.f38904fb;
    }

    public boolean gw() {
        return this.bm;
    }

    public boolean hc() {
        return this.f38898c;
    }

    public int hr() {
        return this.se;
    }

    public boolean i() {
        return this.by;
    }

    public long iy() {
        return this.f38913p;
    }

    public int iz() {
        return this.f38925za;
    }

    public IChunkAdjustCalculator k() {
        return this.f38903f;
    }

    public boolean ks() {
        return this.ni;
    }

    public List<HttpHeader> l() {
        return this.f38901e;
    }

    public EnqueueType lf() {
        return this.lf;
    }

    public long li() {
        return this.fr;
    }

    public String m() {
        return this.ej;
    }

    public String mj() {
        return this.f38916s;
    }

    public boolean n() {
        return this.f38912oa;
    }

    public boolean ni() {
        return this.f38897b;
    }

    public boolean np() {
        return this.f38922w;
    }

    public String o() {
        return this.gg;
    }

    public IDownloadListener oa() {
        return this.f38915r;
    }

    public boolean p() {
        return this.am;
    }

    public IChunkCntCalculator q() {
        return this.f38923x;
    }

    public INotificationClickCallback qx() {
        return this.fh;
    }

    public AbsNotificationItem r() {
        return this.dh;
    }

    public int s() {
        return this.f38902ee;
    }

    public boolean sa() {
        return this.yy;
    }

    public boolean se() {
        return this.gw;
    }

    public boolean sy() {
        return this.f38918t;
    }

    public boolean t() {
        return this.li;
    }

    public boolean u() {
        return this.hr;
    }

    public IDownloadFileUriProvider ub() {
        return this.qx;
    }

    public IDownloadDepend un() {
        return this.bz;
    }

    public int v() {
        return this.ks;
    }

    public String ve() {
        return this.f38907k;
    }

    public IDownloadListener w() {
        return this.sy;
    }

    public int x() {
        return this.f38917sa;
    }

    public List<String> yy() {
        return this.f38908l;
    }

    public IDownloadMonitorDepend z() {
        return this.un;
    }

    public int[] za() {
        return this.gx;
    }

    public int zk() {
        return this.f38899d;
    }

    public n c(boolean z10) {
        this.f38900db = z10;
        return this;
    }

    public n dk(String str) {
        this.f38910n = str;
        return this;
    }

    public n e(String str) {
        this.f38919u = str;
        return this;
    }

    public n ej(@NonNull String str) {
        this.f38905hc = str;
        return this;
    }

    public n hc(String str) {
        this.f38916s = str;
        return this;
    }

    public n k(boolean z10) {
        this.yy = z10;
        return this;
    }

    public n l(String str) {
        this.gg = str;
        return this;
    }

    public void m(int i10) {
        this.f38917sa = i10;
    }

    public n n(String str) {
        this.f38907k = str;
        return this;
    }

    public n np(String str) {
        this.f38914q = str;
        return this;
    }

    public n oa(boolean z10) {
        this.ni = z10;
        return this;
    }

    public n q(boolean z10) {
        this.am = z10;
        return this;
    }

    public n r(boolean z10) {
        this.gw = z10;
        return this;
    }

    public n sy(boolean z10) {
        this.f38924z = z10;
        return this;
    }

    public n ve(boolean z10) {
        this.f38897b = z10;
        return this;
    }

    public n w(String str) {
        this.zk = str;
        return this;
    }

    public n c(String str) {
        this.f38906i = str;
        return this;
    }

    public n dk(boolean z10) {
        this.f38912oa = z10;
        return this;
    }

    public n e(boolean z10) {
        this.f38911o = z10;
        return this;
    }

    public n ej(boolean z10) {
        this.ve = z10;
        return this;
    }

    public n hc(boolean z10) {
        this.hr = z10;
        return this;
    }

    public n l(boolean z10) {
        this.f38918t = z10;
        return this;
    }

    public n m(String str) {
        this.np = str;
        return this;
    }

    public n n(boolean z10) {
        this.f38921v = z10;
        return this;
    }

    public n np(boolean z10) {
        this.li = z10;
        return this;
    }

    public n oa(String str) {
        this.ch = str;
        return this;
    }

    public n w(boolean z10) {
        this.bm = z10;
        return this;
    }

    public n dk(int i10) {
        this.ks = i10;
        return this;
    }

    public n ej(int i10) {
        this.f38902ee = i10;
        return this;
    }

    public n l(int i10) {
        this.se = i10;
        return this;
    }

    public n m(List<HttpHeader> list) {
        this.f38901e = list;
        return this;
    }

    public n n(@ExecutorGroup int i10) {
        this.f38925za = i10;
        return this;
    }

    public n np(int i10) {
        this.f38899d = i10;
        return this;
    }

    public n dk(List<String> list) {
        this.f38908l = list;
        return this;
    }

    public n m(boolean z10) {
        this.f38922w = z10;
        return this;
    }

    public n m(IDownloadListener iDownloadListener) {
        this.sy = iDownloadListener;
        return this;
    }

    public n m(long j10) {
        this.fr = j10;
        return this;
    }

    public n m(EnqueueType enqueueType) {
        this.lf = enqueueType;
        return this;
    }

    public n m(IDownloadFileUriProvider iDownloadFileUriProvider) {
        this.qx = iDownloadFileUriProvider;
        return this;
    }

    public n m(IDownloadDiskSpaceHandler iDownloadDiskSpaceHandler) {
        this.f38904fb = iDownloadDiskSpaceHandler;
        return this;
    }

    public n m(JSONObject jSONObject) {
        this.iy = jSONObject;
        return this;
    }

    public n m(IDownloadCompleteHandler iDownloadCompleteHandler) {
        synchronized (this.cm) {
            if (iDownloadCompleteHandler != null) {
                if (!this.cm.contains(iDownloadCompleteHandler)) {
                    this.cm.add(iDownloadCompleteHandler);
                    return this;
                }
            }
            return this;
        }
    }
}
