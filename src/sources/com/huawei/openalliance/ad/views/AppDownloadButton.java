package com.huawei.openalliance.ad.views;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;
import com.huawei.hms.ads.dw;
import com.huawei.hms.ads.ez;
import com.huawei.hms.ads.fa;
import com.huawei.hms.ads.fd;
import com.huawei.hms.ads.gf;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.kt;
import com.huawei.hms.ads.kv;
import com.huawei.hms.ads.lg;
import com.huawei.hms.ads.lm;
import com.huawei.hms.ads.ma;
import com.huawei.hms.ads.nativead.R;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.beans.metadata.TextState;
import com.huawei.openalliance.ad.constant.ae;
import com.huawei.openalliance.ad.constant.t;
import com.huawei.openalliance.ad.constant.u;
import com.huawei.openalliance.ad.download.app.AppDownloadTask;
import com.huawei.openalliance.ad.download.app.PPSAppDownloadManager;
import com.huawei.openalliance.ad.download.app.j;
import com.huawei.openalliance.ad.download.app.k;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.AppInfo;
import com.huawei.openalliance.ad.inter.data.m;
import com.huawei.openalliance.ad.inter.data.n;
import com.huawei.openalliance.ad.utils.aa;
import com.huawei.openalliance.ad.utils.ai;
import com.huawei.openalliance.ad.utils.au;
import com.huawei.openalliance.ad.utils.ay;
import com.huawei.openalliance.ad.utils.ba;
import com.huawei.openalliance.ad.utils.v;
import com.huawei.openalliance.ad.views.a;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class AppDownloadButton extends ProgressButton implements lg, com.huawei.openalliance.ad.download.g {
    private n C;
    private boolean D;
    private com.huawei.openalliance.ad.views.a F;
    private b L;
    private AppInfo S;

    /* renamed from: a, reason: collision with root package name */
    private c f32611a;

    /* renamed from: b, reason: collision with root package name */
    private a f32612b;

    /* renamed from: c, reason: collision with root package name */
    private k f32613c;

    /* renamed from: d, reason: collision with root package name */
    private k f32614d;

    /* renamed from: e, reason: collision with root package name */
    private int f32615e;

    /* renamed from: f, reason: collision with root package name */
    private AdContentData f32616f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f32617g;

    /* renamed from: h, reason: collision with root package name */
    private int f32618h;

    /* renamed from: i, reason: collision with root package name */
    private final int f32619i;

    /* renamed from: j, reason: collision with root package name */
    private List<TextState> f32620j;

    /* renamed from: k, reason: collision with root package name */
    private lm f32621k;

    /* renamed from: l, reason: collision with root package name */
    private final boolean f32622l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f32623m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f32624n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f32625o;

    /* renamed from: p, reason: collision with root package name */
    private ma f32626p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f32627q;

    /* renamed from: r, reason: collision with root package name */
    private int f32628r;

    /* renamed from: s, reason: collision with root package name */
    private m f32629s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f32630t;

    /* renamed from: com.huawei.openalliance.ad.views.AppDownloadButton$4, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static /* synthetic */ class AnonymousClass4 {
        public static final /* synthetic */ int[] Code;

        static {
            int[] iArr = new int[k.values().length];
            Code = iArr;
            try {
                iArr[k.DOWNLOAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Code[k.PAUSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Code[k.DOWNLOADING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                Code[k.INSTALLED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                Code[k.INSTALL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                Code[k.INSTALLING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface a {
        CharSequence Code(CharSequence charSequence, k kVar);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface b {
        void Code(k kVar);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface c {
        boolean Code(AppInfo appInfo, long j10);
    }

    public AppDownloadButton(Context context) {
        super(context);
        this.f32615e = -1;
        this.f32617g = true;
        this.f32618h = 1;
        this.f32619i = 2;
        this.f32622l = true;
        this.f32624n = true;
        this.f32625o = false;
        this.f32627q = true;
        this.f32628r = -1;
        this.f32630t = false;
        Code(context, null, -1, -1);
    }

    public AppDownloadButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f32615e = -1;
        this.f32617g = true;
        this.f32618h = 1;
        this.f32619i = 2;
        this.f32622l = true;
        this.f32624n = true;
        this.f32625o = false;
        this.f32627q = true;
        this.f32628r = -1;
        this.f32630t = false;
        Code(context, attributeSet, -1, -1);
    }

    public AppDownloadButton(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f32615e = -1;
        this.f32617g = true;
        this.f32618h = 1;
        this.f32619i = 2;
        this.f32622l = true;
        this.f32624n = true;
        this.f32625o = false;
        this.f32627q = true;
        this.f32628r = -1;
        this.f32630t = false;
        Code(context, attributeSet, i10, -1);
    }

    public AppDownloadButton(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f32615e = -1;
        this.f32617g = true;
        this.f32618h = 1;
        this.f32619i = 2;
        this.f32622l = true;
        this.f32624n = true;
        this.f32625o = false;
        this.f32627q = true;
        this.f32628r = -1;
        this.f32630t = false;
        Code(context, attributeSet, i10, i11);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0043, code lost:
    
        if (r6 > 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005e, code lost:
    
        if (r6 <= 0) goto L4;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0018. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.huawei.openalliance.ad.download.app.k Code(com.huawei.openalliance.ad.download.app.AppDownloadTask r6, java.lang.String r7, boolean r8) {
        /*
            r5 = this;
            int r0 = r6.B()
            r1 = 2
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
            r3 = 0
            r1[r3] = r2
            r2 = 1
            r1[r2] = r7
            java.lang.String r7 = "AppDownBtn"
            java.lang.String r4 = "refreshStatus, dwnStatus:%s, pkg:%s"
            com.huawei.hms.ads.gl.Code(r7, r4, r1)
            switch(r0) {
                case 0: goto L52;
                case 1: goto L49;
                case 2: goto L49;
                case 3: goto L46;
                case 4: goto L3d;
                case 5: goto L3a;
                case 6: goto L1e;
                default: goto L1b;
            }
        L1b:
            com.huawei.openalliance.ad.download.app.k r0 = com.huawei.openalliance.ad.download.app.k.DOWNLOAD
            goto L62
        L1e:
            if (r8 != 0) goto L37
            com.huawei.openalliance.ad.download.app.k r0 = com.huawei.openalliance.ad.download.app.k.DOWNLOAD
            java.lang.Object[] r1 = new java.lang.Object[r2]
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)
            r1[r3] = r8
            java.lang.String r8 = " hasInstalled=%s"
            com.huawei.hms.ads.gl.Code(r7, r8, r1)
            com.huawei.openalliance.ad.download.app.g r7 = com.huawei.openalliance.ad.download.app.g.I()
            r7.I(r6)
            goto L62
        L37:
            com.huawei.openalliance.ad.download.app.k r0 = com.huawei.openalliance.ad.download.app.k.INSTALLED
            goto L62
        L3a:
            com.huawei.openalliance.ad.download.app.k r0 = com.huawei.openalliance.ad.download.app.k.INSTALLING
            goto L4b
        L3d:
            int r6 = r6.S()
            r5.f32615e = r6
            if (r6 <= 0) goto L1b
            goto L60
        L46:
            com.huawei.openalliance.ad.download.app.k r0 = com.huawei.openalliance.ad.download.app.k.INSTALL
            goto L62
        L49:
            com.huawei.openalliance.ad.download.app.k r0 = com.huawei.openalliance.ad.download.app.k.DOWNLOADING
        L4b:
            int r6 = r6.S()
            r5.f32615e = r6
            goto L62
        L52:
            int r7 = r6.D()
            int r6 = r6.S()
            r5.f32615e = r6
            if (r7 != 0) goto L60
            if (r6 <= 0) goto L1b
        L60:
            com.huawei.openalliance.ad.download.app.k r0 = com.huawei.openalliance.ad.download.app.k.PAUSE
        L62:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.views.AppDownloadButton.Code(com.huawei.openalliance.ad.download.app.AppDownloadTask, java.lang.String, boolean):com.huawei.openalliance.ad.download.app.k");
    }

    private String Code(int i10, k kVar) {
        String str = null;
        if (aa.Code(this.f32620j)) {
            return null;
        }
        int i11 = 1 == i10 ? 2 : 1;
        int Code = TextState.Code(kVar);
        String V = com.huawei.openalliance.ad.utils.c.V();
        Iterator<TextState> iterator2 = this.f32620j.iterator2();
        String str2 = null;
        String str3 = null;
        while (true) {
            if (!iterator2.hasNext()) {
                break;
            }
            TextState next = iterator2.next();
            if (next != null && i11 == next.Code()) {
                if (Code == next.V()) {
                    if (V.equalsIgnoreCase(new Locale(next.I()).getLanguage())) {
                        str = next.Z();
                        break;
                    }
                    if (1 == next.B()) {
                        str2 = next.Z();
                    }
                }
                if (next.V() == 0) {
                    str3 = next.Z();
                }
            }
        }
        if (!TextUtils.isEmpty(str)) {
            str2 = str;
        }
        if (!TextUtils.isEmpty(str2)) {
            str3 = str2;
        }
        return au.V(str3);
    }

    private String Code(Context context, k kVar) {
        int i10;
        if (context == null || kVar == null) {
            return "";
        }
        switch (AnonymousClass4.Code[kVar.ordinal()]) {
            case 1:
                return dw.Code(context, this.S);
            case 2:
                i10 = R.string.hiad_download_resume;
                break;
            case 3:
                return NumberFormat.getPercentInstance().format((this.f32615e * 1.0f) / 100.0f);
            case 4:
                return dw.Code(context, this.S, this.f32628r);
            case 5:
                i10 = R.string.hiad_download_install;
                break;
            case 6:
                i10 = R.string.hiad_download_installing;
                break;
            default:
                return null;
        }
        return context.getString(i10);
    }

    private void Code(Context context) {
        Code(context, this.f32618h, k.INSTALLED);
    }

    private void Code(Context context, int i10, k kVar) {
        String Code = Code(i10, kVar);
        if (TextUtils.isEmpty(Code)) {
            Code((CharSequence) Code(context, kVar), true, kVar);
            return;
        }
        if (this.f32630t && i10 == 1 && kVar == k.DOWNLOADING) {
            Code = Code + NumberFormat.getPercentInstance().format((this.f32615e * 1.0f) / 100.0f);
        }
        Code((CharSequence) Code, false, kVar);
    }

    private void Code(AppDownloadTask appDownloadTask, Context context) {
        if (appDownloadTask != null) {
            Code(context, this.f32618h, k.INSTALL);
        }
    }

    private void Code(k kVar) {
        a.C0341a Code = this.F.Code(getContext(), kVar);
        setTextColor(Code.V);
        setProgressDrawable(Code.Code);
        Code(getContext(), this.f32618h, kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(boolean z10) {
        gl.V("AppDownBtn", "processDownload, needShowPermissionDialog = %s", Boolean.valueOf(z10));
        if (!ai.Z(getContext())) {
            Toast.makeText(getContext(), R.string.hiad_network_no_available, 0).show();
            return;
        }
        if (this.S.n() && this.f32617g && z10) {
            com.huawei.openalliance.ad.download.app.j.Code(getContext(), this.S, new j.a() { // from class: com.huawei.openalliance.ad.views.AppDownloadButton.7
                @Override // com.huawei.openalliance.ad.download.app.j.a
                public void Code() {
                    AppDownloadButton.this.setNeedShowConfirmDialog(false);
                    AppDownloadButton.this.Code(false);
                }
            });
            return;
        }
        if (!ai.I(getContext())) {
            long leftSize = getLeftSize();
            c cVar = this.f32611a;
            if (cVar == null) {
                V();
                return;
            } else if (!cVar.Code(this.S, leftSize)) {
                return;
            }
        }
        I();
    }

    private boolean Code(Context context, String str) {
        boolean Code = com.huawei.openalliance.ad.utils.e.Code(context, str, this.S.D());
        if (Code) {
            PPSAppDownloadManager.Code(context, this.S);
            l();
            kv.Code(context, this.f32616f, "intentSuccess", (Integer) 1, (Integer) null);
            kv.Code(context, this.f32616f, 0, 0, "app", this.f32618h, this.f32629s, com.huawei.openalliance.ad.utils.b.Code(getContext()), ay.Code((View) this));
            this.f32629s = null;
            m();
            return Code;
        }
        gl.V("AppDownBtn", "handClick, openAppIntent fail");
        kv.Code(getContext(), this.f32616f, ae.D, (Integer) 1, Integer.valueOf(com.huawei.openalliance.ad.utils.e.Code(context, str) ? 2 : 1));
        boolean I = com.huawei.openalliance.ad.utils.e.I(context, str);
        if (I) {
            l();
            kv.Code(context, this.C.l(), (Integer) 1);
            PPSAppDownloadManager.Code(context, this.S);
            kv.Code(context, this.f32616f, 0, 0, "app", this.f32618h, this.f32629s, com.huawei.openalliance.ad.utils.b.Code(getContext()), ay.Code((View) this));
            this.f32629s = null;
            m();
        } else {
            gl.V("AppDownBtn", "handClick, openAppMainPage fail");
        }
        return I;
    }

    private boolean D() {
        AppInfo appInfo = this.S;
        if (appInfo == null) {
            h();
            gl.V("AppDownBtn", "appInfo is empty");
            return false;
        }
        if (this.f32613c == k.INSTALLED || appInfo.o()) {
            return true;
        }
        String r10 = this.S.r();
        if (!TextUtils.isEmpty(r10)) {
            if (r10.equals("7") && !TextUtils.isEmpty(this.S.h())) {
                return true;
            }
            if (r10.equals("9") && !TextUtils.isEmpty(this.S.Code()) && !TextUtils.isEmpty(this.S.s())) {
                return true;
            }
        }
        if (!TextUtils.isEmpty(this.S.Z())) {
            return true;
        }
        h();
        return false;
    }

    private boolean F() {
        AppInfo appInfo = this.S;
        if (appInfo == null) {
            return false;
        }
        String r10 = appInfo.r();
        return (TextUtils.isEmpty(r10) || TextUtils.isEmpty(this.S.Code()) || !r10.equals("6")) ? false : true;
    }

    private void I(AppDownloadTask appDownloadTask) {
        int i10;
        k kVar;
        if (gl.Code()) {
            Object[] objArr = new Object[3];
            objArr[0] = this.f32613c;
            objArr[1] = this.f32614d;
            AppInfo appInfo = this.S;
            objArr[2] = appInfo == null ? null : appInfo.Code();
            gl.Code("AppDownBtn", "processStatus, status:%s, preStatus:%s, packageName:%s", objArr);
        }
        if (F() && this.f32613c != k.INSTALLED) {
            Code(k.DOWNLOAD);
            return;
        }
        Context context = getContext();
        a.C0341a Code = this.F.Code(getContext(), this.f32613c);
        setTextColor(Code.V);
        if (this.f32627q) {
            int i11 = this.f32615e;
            Drawable drawable = Code.Code;
            if (i11 != -1) {
                Code(drawable, i11);
            } else {
                setProgressDrawable(drawable);
            }
        }
        switch (AnonymousClass4.Code[this.f32613c.ordinal()]) {
            case 1:
                Code(context, this.f32618h, k.DOWNLOAD);
                return;
            case 2:
                i10 = this.f32618h;
                kVar = k.PAUSE;
                break;
            case 3:
                i10 = this.f32618h;
                kVar = k.DOWNLOADING;
                break;
            case 4:
                Code(context);
                return;
            case 5:
                Code(appDownloadTask, context);
                return;
            case 6:
                V(appDownloadTask, context);
                return;
            default:
                return;
        }
        Code(context, i10, kVar);
        setProgress(this.f32615e);
    }

    private boolean L() {
        String r10 = this.S.r();
        if (TextUtils.isEmpty(r10) || TextUtils.isEmpty(this.S.h()) || !r10.equals("7")) {
            return false;
        }
        if (!new com.huawei.openalliance.ad.uriaction.b(getContext(), this.f32616f).Code()) {
            h();
            return false;
        }
        V(t.Code, this.f32618h);
        j();
        return true;
    }

    private void V(AppDownloadTask appDownloadTask, Context context) {
        if (appDownloadTask != null) {
            Code(context, this.f32618h, k.INSTALLING);
        }
    }

    private boolean V(Context context) {
        boolean Code = new com.huawei.openalliance.ad.uriaction.g(context, this.f32616f).Code();
        if (Code) {
            PPSAppDownloadManager.Code(context, this.S);
            l();
            kv.Code(context, this.f32616f, 0, 0, t.Z, this.f32618h, this.f32629s, com.huawei.openalliance.ad.utils.b.Code(getContext()), ay.Code((View) this));
            this.f32629s = null;
            m();
        }
        return Code;
    }

    private void Z(AppDownloadTask appDownloadTask) {
        if (this.S == null || this.f32616f == null) {
            gl.I("AppDownBtn", "installApk, appinfo or content record is null");
        } else {
            com.huawei.openalliance.ad.download.app.g.I().Code(appDownloadTask);
        }
    }

    private boolean a() {
        if (!"9".equals(this.S.r()) || TextUtils.isEmpty(this.S.Code()) || TextUtils.isEmpty(this.S.s())) {
            return false;
        }
        com.huawei.openalliance.ad.uriaction.h hVar = new com.huawei.openalliance.ad.uriaction.h(getContext(), this.f32616f);
        if (!hVar.Code()) {
            h();
            return false;
        }
        V(hVar.I(), this.f32618h);
        j();
        return true;
    }

    private boolean b() {
        String r10 = this.S.r();
        if (TextUtils.isEmpty(r10) || TextUtils.isEmpty(this.S.Code()) || !r10.equals("6")) {
            return false;
        }
        com.huawei.openalliance.ad.uriaction.m mVar = new com.huawei.openalliance.ad.uriaction.m(getContext(), this.f32616f);
        mVar.Code(this.f32618h);
        mVar.Code();
        V(t.F, this.f32618h);
        j();
        return true;
    }

    private boolean c() {
        List<Integer> t2;
        if (this.S != null && v.B(getContext()) && (t2 = this.S.t()) != null && t2.contains(14)) {
            gf.Code(getContext()).Code();
            if (com.huawei.openalliance.ad.uriaction.d.Code(getContext(), this.f32616f, this.C.ae(), t2).Code()) {
                V("web", this.f32618h);
                j();
                return true;
            }
            h();
        }
        return false;
    }

    private void d() {
        AppDownloadTask task;
        gl.Code("AppDownBtn", "doClickAction, status:" + ((Object) this.f32613c));
        int i10 = AnonymousClass4.Code[this.f32613c.ordinal()];
        if (i10 == 1) {
            if (!com.huawei.openalliance.ad.utils.e.Code() && k()) {
                gl.V("AppDownBtn", "not allowed");
                return;
            } else {
                Code(true);
                V("download", this.f32618h);
                return;
            }
        }
        if (i10 == 2) {
            Code(false);
            return;
        }
        if (i10 == 3) {
            AppDownloadTask task2 = getTask();
            if (task2 != null) {
                com.huawei.openalliance.ad.download.app.g.I().V(task2);
                return;
            }
            return;
        }
        if (i10 == 4) {
            e();
        } else if (i10 == 5 && (task = getTask()) != null) {
            Z(task);
        }
    }

    private void e() {
        if (!g() || this.f32628r == 1) {
            k();
        } else {
            f();
            ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.AppDownloadButton.6
                @Override // java.lang.Runnable
                public void run() {
                    AppDownloadButton.this.k();
                }
            }, 600L);
        }
    }

    private void f() {
        Context context = getContext();
        AppDownloadTask o10 = o();
        if (context == null || o10 == null) {
            return;
        }
        com.huawei.openalliance.ad.download.app.b.Code(context).Code(o10);
    }

    private boolean g() {
        return kt.b(this.f32616f.r()) && dw.Code(this.S);
    }

    private long getLeftSize() {
        if (this.S == null) {
            return 0L;
        }
        AppDownloadTask task = getTask();
        long B = this.S.B();
        if (task == null) {
            return B;
        }
        long B2 = this.S.B() - task.Z();
        return B2 <= 0 ? B : B2;
    }

    private AppDownloadTask getTask() {
        AdContentData adContentData;
        AppDownloadTask V = com.huawei.openalliance.ad.download.app.g.I().V(this.S);
        if (V != null && (adContentData = this.f32616f) != null) {
            V.Z(adContentData.C());
            V.B(this.f32616f.s());
            V.C(this.f32616f.S());
            V.I(this.f32616f.B());
            V.S(this.f32616f.ao());
            V.F(this.f32616f.ap());
            V.D(this.f32616f.E());
            V.C(this.f32616f.aA());
            V.a(this.f32616f.az());
        }
        return V;
    }

    private void h() {
        ma maVar = this.f32626p;
        if (maVar != null) {
            maVar.Code(this);
        }
    }

    private void i() {
        ma maVar = this.f32626p;
        if (maVar != null) {
            maVar.V(this);
        }
    }

    private void j() {
        ma maVar = this.f32626p;
        if (maVar != null) {
            maVar.I(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k() {
        if (this.f32616f == null) {
            return false;
        }
        Context context = getContext();
        String Code = this.S.Code();
        boolean V = com.huawei.openalliance.ad.utils.t.Code(context, Code) ? V(context) : false;
        return !V ? Code(context, Code) : V;
    }

    private void l() {
        lm lmVar = this.f32621k;
        if (lmVar != null) {
            lmVar.Code(2, true);
        }
    }

    private void m() {
        lm lmVar = this.f32621k;
        if (lmVar != null) {
            lmVar.D();
        }
    }

    private boolean n() {
        AppInfo appInfo = this.S;
        return appInfo != null && appInfo.o() && com.huawei.openalliance.ad.utils.e.Z(getContext(), u.W) >= 100300300;
    }

    private AppDownloadTask o() {
        AppDownloadTask Code = new AppDownloadTask.a().Code(this.D).Code(this.S).Code();
        if (Code == null) {
            return null;
        }
        Code.Code(Integer.valueOf(this.f32618h));
        Code.I((Integer) 2);
        Code.Code(this.f32616f);
        AdContentData adContentData = this.f32616f;
        if (adContentData != null) {
            Code.B(adContentData.s());
            Code.Z(this.f32616f.C());
            Code.C(this.f32616f.S());
            Code.I(this.f32616f.B());
            Code.S(this.f32616f.ao());
            Code.F(this.f32616f.ap());
            Code.D(this.f32616f.E());
            Code.a(this.f32616f.az());
            Code.C(this.f32616f.aA());
        }
        return Code;
    }

    public void B() {
        if (gl.Code()) {
            gl.Code("AppDownBtn", "downloadApp, status:%s", this.f32613c);
        }
        k kVar = this.f32613c;
        if ((kVar == k.DOWNLOAD || kVar == k.PAUSE) && this.S != null) {
            AppDownloadTask task = getTask();
            if (task == null) {
                com.huawei.openalliance.ad.download.app.g.I().Code(o());
                return;
            }
            task.Code(Integer.valueOf(this.f32618h));
            task.I((Integer) 2);
            task.Code(this.D);
            com.huawei.openalliance.ad.download.app.g.I().I(task);
        }
    }

    public k Code() {
        k kVar = k.DOWNLOAD;
        AppInfo appInfo = this.S;
        AppDownloadTask appDownloadTask = null;
        if (appInfo == null) {
            this.f32614d = this.f32613c;
            this.f32613c = kVar;
        } else {
            String Code = appInfo.Code();
            if (com.huawei.openalliance.ad.utils.e.V(getContext(), this.S.Code()) != null) {
                kVar = k.INSTALLED;
            } else {
                appDownloadTask = getTask();
                if (appDownloadTask != null) {
                    kVar = Code(appDownloadTask, Code, false);
                }
            }
            this.f32614d = this.f32613c;
            this.f32613c = kVar;
            I(appDownloadTask);
            appDownloadTask = Code;
        }
        gl.Code("AppDownBtn", "refreshStatus, status:%s, pkg:%s", this.f32613c, appDownloadTask);
        return this.f32613c;
    }

    @Override // com.huawei.hms.ads.lg
    public void Code(long j10) {
        AdContentData adContentData = this.f32616f;
        if (adContentData != null) {
            adContentData.Z(j10);
        }
    }

    public void Code(Context context, AttributeSet attributeSet, int i10, int i11) {
        this.F = new com.huawei.openalliance.ad.views.a(context);
        setOnClickListener(this);
    }

    @Override // com.huawei.openalliance.ad.download.g
    public void Code(AppDownloadTask appDownloadTask) {
        AppInfo appInfo = this.S;
        if (appInfo == null || !appInfo.Code().equals(appDownloadTask.F())) {
            return;
        }
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.AppDownloadButton.12
            @Override // java.lang.Runnable
            public void run() {
                AppDownloadButton.this.Code();
                if (AppDownloadButton.this.L == null || AppDownloadButton.this.f32614d == AppDownloadButton.this.f32613c) {
                    return;
                }
                AppDownloadButton.this.L.Code(AppDownloadButton.this.f32613c);
            }
        });
    }

    public void Code(CharSequence charSequence, boolean z10, k kVar) {
        a aVar = this.f32612b;
        if (aVar != null && z10) {
            charSequence = aVar.Code(charSequence, kVar);
        }
        super.setText(charSequence);
    }

    @Override // com.huawei.openalliance.ad.download.g
    public void Code(String str) {
        if (gl.Code()) {
            Object[] objArr = new Object[2];
            objArr[0] = str;
            AppInfo appInfo = this.S;
            objArr[1] = appInfo == null ? null : appInfo.Code();
            gl.Code("AppDownBtn", "onStatusChanged, packageName:%s, packageName %s", objArr);
        }
        AppInfo appInfo2 = this.S;
        if (appInfo2 == null || !appInfo2.Code().equals(str)) {
            return;
        }
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.AppDownloadButton.11
            @Override // java.lang.Runnable
            public void run() {
                AppDownloadButton.this.Code();
                if (AppDownloadButton.this.L == null || AppDownloadButton.this.f32614d == AppDownloadButton.this.f32613c) {
                    return;
                }
                AppDownloadButton.this.L.Code(AppDownloadButton.this.f32613c);
            }
        });
    }

    @Override // com.huawei.openalliance.ad.download.f
    public void Code(String str, final int i10) {
        if (gl.Code()) {
            gl.Code("AppDownBtn", "status %s, packageName:%s", Integer.valueOf(i10), str);
        }
        if (dw.Code(this.S)) {
            ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.AppDownloadButton.3
                @Override // java.lang.Runnable
                public void run() {
                    AppDownloadButton.this.f32628r = i10;
                    AppDownloadButton.this.Code();
                }
            });
        }
    }

    @Override // com.huawei.hms.ads.lg
    public boolean Code(com.huawei.openalliance.ad.inter.data.g gVar) {
        if (gVar == null) {
            setAppInfo(null);
            this.f32616f = null;
            this.C = null;
            return false;
        }
        if (gVar instanceof n) {
            this.C = (n) gVar;
        }
        try {
            this.f32618h = 1;
            this.f32616f = this.C.l();
            AppInfo v2 = gVar.v();
            setAppInfo(v2);
            n nVar = this.C;
            if (nVar != null) {
                MetaData k10 = nVar.k();
                if (k10 != null) {
                    this.f32620j = k10.f();
                }
                this.f32623m = kt.B(this.C.z());
            }
            if (v2 != null) {
                setShowPermissionDialog(v2.c());
                return true;
            }
        } catch (RuntimeException | Exception unused) {
            gl.Z("AppDownBtn", "setNativeAd ex");
        }
        return false;
    }

    public void I() {
        Context context = getContext();
        if (!(context instanceof Activity) || getStatus() != k.DOWNLOAD || !this.f32623m || !this.f32624n) {
            B();
            return;
        }
        fa faVar = new fa(context);
        faVar.Code(new ez.a() { // from class: com.huawei.openalliance.ad.views.AppDownloadButton.9
            @Override // com.huawei.hms.ads.ez.a
            public void Code(AppInfo appInfo) {
                AppDownloadButton.this.setNeedShowConfirmDialog(false);
                AppDownloadButton.this.B();
            }

            @Override // com.huawei.hms.ads.ez.a
            public void V(AppInfo appInfo) {
            }
        });
        this.f32625o = true;
        faVar.Code(this.S, this.f32616f, getLeftSize());
    }

    @Override // com.huawei.openalliance.ad.download.g
    public void I(String str) {
        V(str);
    }

    public void V() {
        gl.Code("AppDownBtn", "downloadInMobileData");
        if (n()) {
            I();
            return;
        }
        gl.Code("AppDownBtn", "not useAgMobileDataTipsDialog");
        fd fdVar = new fd(getContext());
        fdVar.Code(new ez.a() { // from class: com.huawei.openalliance.ad.views.AppDownloadButton.8
            @Override // com.huawei.hms.ads.ez.a
            public void Code(AppInfo appInfo) {
                AppDownloadButton.this.setAllowedNonWifiNetwork(true);
                AppDownloadButton.this.setNeedShowConfirmDialog(false);
                AppDownloadButton.this.I();
            }

            @Override // com.huawei.hms.ads.ez.a
            public void V(AppInfo appInfo) {
            }
        });
        fdVar.Code(this.S, this.f32616f, getLeftSize());
    }

    @Override // com.huawei.openalliance.ad.download.g
    public void V(AppDownloadTask appDownloadTask) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onStatusChanged, taskId:");
        sb2.append(appDownloadTask.F());
        sb2.append(", packageName");
        AppInfo appInfo = this.S;
        sb2.append(appInfo == null ? null : appInfo.Code());
        sb2.append(", status:");
        sb2.append(appDownloadTask.B());
        gl.V("AppDownBtn", sb2.toString());
        AppInfo appInfo2 = this.S;
        if (appInfo2 == null || !appInfo2.Code().equals(appDownloadTask.F())) {
            return;
        }
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.AppDownloadButton.10
            @Override // java.lang.Runnable
            public void run() {
                AppDownloadButton.this.Code();
                if (AppDownloadButton.this.L != null) {
                    AppDownloadButton.this.L.Code(AppDownloadButton.this.f32613c);
                }
            }
        });
    }

    @Override // com.huawei.openalliance.ad.download.g
    public void V(String str) {
        AppInfo appInfo = this.S;
        if (appInfo == null || str == null || !str.equals(appInfo.Code())) {
            return;
        }
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.AppDownloadButton.2
            @Override // java.lang.Runnable
            public void run() {
                AppDownloadButton.this.Code();
                if (AppDownloadButton.this.L != null) {
                    AppDownloadButton.this.L.Code(AppDownloadButton.this.f32613c);
                }
            }
        });
    }

    public void V(String str, int i10) {
        if (this.f32616f != null) {
            l();
            if (i10 == 1 || this.f32616f.Code() == 7 || this.f32616f.Code() == 12) {
                kv.Code(getContext(), this.f32616f, 0, 0, str, i10, this.f32629s, com.huawei.openalliance.ad.utils.b.Code(getContext()), ay.Code((View) this));
                this.f32629s = null;
                m();
            }
        }
    }

    @Override // com.huawei.hms.ads.lg
    public void Z(String str) {
        AdContentData adContentData = this.f32616f;
        if (adContentData != null) {
            adContentData.V(str);
        }
    }

    public void cancel() {
        com.huawei.openalliance.ad.download.app.g.I().Code(this.S);
        Code();
        setOnNonWifiDownloadListener(null);
        setNeedShowConfirmDialog(true);
    }

    public void continueDownload() {
        String str;
        if (D()) {
            i();
            if (a()) {
                str = "open harmony service";
            } else {
                if (this.f32613c == k.INSTALLED) {
                    d();
                    return;
                }
                if (L()) {
                    str = "open Ag detail";
                } else if (b()) {
                    str = "open Ag mini detail";
                } else {
                    if (!c()) {
                        B();
                        return;
                    }
                    str = "open Gp detail";
                }
            }
        } else {
            str = "click action invalid.";
        }
        gl.V("AppDownBtn", str);
    }

    public ma getClickActionListener() {
        return this.f32626p;
    }

    public k getStatus() {
        return this.f32613c;
    }

    public com.huawei.openalliance.ad.views.a getStyle() {
        return this.F;
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        try {
            if (gl.Code()) {
                Object[] objArr = new Object[1];
                AppInfo appInfo = this.S;
                objArr[0] = appInfo == null ? null : appInfo.Code();
                gl.Code("AppDownBtn", "attach, pkg:%s", objArr);
            } else {
                gl.V("AppDownBtn", "attach appinfo is " + au.V(this.S));
            }
            com.huawei.openalliance.ad.download.app.g.I().Code(this.S, this);
            ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.AppDownloadButton.1
                @Override // java.lang.Runnable
                public void run() {
                    AppDownloadButton.this.Code();
                }
            });
        } catch (RuntimeException | Exception unused) {
            gl.I("AppDownBtn", "attach ex");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        gl.V("AppDownBtn", "onClick");
        if (S()) {
            str = "fast click";
        } else if (D()) {
            i();
            if (a()) {
                str = "open harmony service";
            } else {
                if (this.f32613c == k.INSTALLED) {
                    d();
                    return;
                }
                if (L()) {
                    str = "open Ag detail";
                } else if (b()) {
                    str = "open Ag mini detail";
                } else {
                    if (!c()) {
                        d();
                        return;
                    }
                    str = "open Gp detail";
                }
            }
        } else {
            str = "click action invalid.";
        }
        gl.V("AppDownBtn", str);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            if (gl.Code()) {
                Object[] objArr = new Object[1];
                AppInfo appInfo = this.S;
                objArr[0] = appInfo == null ? null : appInfo.Code();
                gl.Code("AppDownBtn", "detach, pkg:%s", objArr);
            } else {
                gl.V("AppDownBtn", "detach appinfo is " + au.V(this.S));
            }
            com.huawei.openalliance.ad.download.app.g.I().V(this.S, this);
            gf.Code(getContext()).V();
        } catch (RuntimeException | Exception unused) {
            gl.I("AppDownBtn", "detach ex");
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i10) {
        gl.V("AppDownBtn", "onVisibilityChanged, status:" + ((Object) this.f32613c));
        super.onVisibilityChanged(view, i10);
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.AppDownloadButton.5
            @Override // java.lang.Runnable
            public void run() {
                AppDownloadButton.this.Code();
            }
        });
    }

    public void setAfDlBtnText(String str) {
        if (this.S == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.S.S(str);
    }

    public void setAllowedNonWifiNetwork(boolean z10) {
        this.D = z10;
    }

    public void setAppDownloadButtonStyle(com.huawei.openalliance.ad.views.a aVar) {
        this.F = aVar;
    }

    public void setAppInfo(AppInfo appInfo) {
        gl.V("AppDownBtn", "setAppInfo appInfo is " + au.V(appInfo));
        this.S = appInfo;
        if (appInfo != null) {
            com.huawei.openalliance.ad.download.app.g.I().Code(appInfo, this);
        }
    }

    public void setButtonTextWatcher(a aVar) {
        this.f32612b = aVar;
    }

    @Override // com.huawei.hms.ads.lg
    public void setClickActionListener(ma maVar) {
        this.f32626p = maVar;
    }

    public void setClickInfo(m mVar) {
        this.f32629s = mVar;
    }

    public void setIsSetProgressDrawable(boolean z10) {
        this.f32627q = z10;
    }

    public void setNeedAppendProgress(boolean z10) {
        this.f32630t = z10;
    }

    public void setNeedShowConfirmDialog(boolean z10) {
        this.f32624n = z10;
    }

    public void setOnDownloadStatusChangedListener(b bVar) {
        this.L = bVar;
    }

    public void setOnNonWifiDownloadListener(c cVar) {
        this.f32611a = cVar;
    }

    @Override // com.huawei.hms.ads.lg
    public void setPpsNativeView(lm lmVar) {
        this.f32621k = lmVar;
    }

    public void setShowPermissionDialog(boolean z10) {
        this.f32617g = z10;
    }
}
