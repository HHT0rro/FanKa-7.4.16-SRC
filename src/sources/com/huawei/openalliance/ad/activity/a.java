package com.huawei.openalliance.ad.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.huawei.hms.ads.ea;
import com.huawei.hms.ads.gl;
import com.huawei.openalliance.ad.constant.ax;
import com.huawei.openalliance.ad.constant.bf;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.msgnotify.NotifyCallback;
import com.huawei.openalliance.ad.utils.ay;
import com.huawei.openalliance.ad.utils.ba;
import com.huawei.openalliance.ad.utils.l;
import com.huawei.openalliance.ad.utils.v;
import com.huawei.openalliance.ad.views.PPSBaseDialogContentView;
import com.huawei.openalliance.ad.views.i;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class a extends Activity implements NotifyCallback {
    public static final int B = 16;
    public static final int C = 2;
    public static final String Code = "huawei.permission.CLICK_STATUSBAR_BROADCAST";
    public static final String I = "com.huawei.ads.feedback.action.FINISH_FEEDBACK_ACTIVITY";
    public static final String V = "com.huawei.ads.feedback.action.ANCHOR_LOCATION_CHANGE";
    public static final int Z = 36;

    /* renamed from: n, reason: collision with root package name */
    private static final String f32126n = "BaseDialogActivity";

    /* renamed from: o, reason: collision with root package name */
    private static final int f32127o = 40;

    /* renamed from: p, reason: collision with root package name */
    private static final String f32128p = "android.permission.WRITE_SECURE_SETTINGS";

    /* renamed from: q, reason: collision with root package name */
    private static final String f32129q = "com.huawei.intent.action.CLICK_STATUSBAR";

    /* renamed from: s, reason: collision with root package name */
    private static Context f32130s;
    public int D;
    public int F;
    public int L;
    public int S;

    /* renamed from: a, reason: collision with root package name */
    public int[] f32131a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f32132b;

    /* renamed from: c, reason: collision with root package name */
    public AdContentData f32133c;

    /* renamed from: d, reason: collision with root package name */
    public PPSBaseDialogContentView f32134d;

    /* renamed from: e, reason: collision with root package name */
    public PPSBaseDialogContentView f32135e;

    /* renamed from: f, reason: collision with root package name */
    public PPSBaseDialogContentView f32136f;

    /* renamed from: g, reason: collision with root package name */
    public ImageView f32137g;

    /* renamed from: h, reason: collision with root package name */
    public ImageView f32138h;

    /* renamed from: i, reason: collision with root package name */
    public ImageView f32139i;

    /* renamed from: j, reason: collision with root package name */
    public RelativeLayout f32140j;

    /* renamed from: k, reason: collision with root package name */
    public View f32141k;

    /* renamed from: l, reason: collision with root package name */
    public View f32142l;

    /* renamed from: m, reason: collision with root package name */
    public c f32143m;

    /* renamed from: r, reason: collision with root package name */
    private boolean f32144r = false;

    /* renamed from: com.huawei.openalliance.ad.activity.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class ViewTreeObserverOnGlobalLayoutListenerC0328a implements ViewTreeObserver.OnGlobalLayoutListener {
        private final WeakReference<Context> Code;
        private final int[] I;
        private final WeakReference<View> V;

        public ViewTreeObserverOnGlobalLayoutListenerC0328a(View view, Context context, int[] iArr) {
            this.Code = new WeakReference<>(context);
            this.V = new WeakReference<>(view);
            this.I = iArr == null ? null : Arrays.copyOf(iArr, iArr.length);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            try {
                View view = this.V.get();
                Context context = this.Code.get();
                if (view != null && context != null && this.I != null) {
                    int[] iArr = new int[2];
                    view.getLocationOnScreen(iArr);
                    if (iArr[0] == 0 && iArr[1] == 0) {
                        gl.V(a.f32126n, "anchorView onGlobalLayout newLoc[x,y] =0,0");
                        view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        return;
                    }
                    int[] iArr2 = this.I;
                    if ((iArr2[0] == iArr[0] && iArr2[1] == iArr[1]) || a.V(iArr2, iArr)) {
                        return;
                    }
                    view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    gl.V(a.f32126n, "anchorView location change newLoc[x,y] = " + iArr[0] + "," + iArr[1] + "--oldLoc[x,y] = " + this.I[0] + "," + this.I[1]);
                    com.huawei.openalliance.ad.msgnotify.b.Code(context, bf.B, new Intent(a.V));
                }
            } catch (Throwable th) {
                gl.I(a.f32126n, "onGlobalLayout error:" + th.getClass().getSimpleName());
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class b implements i {
        public WeakReference<a> Code;

        public b(a aVar) {
            this.Code = new WeakReference<>(aVar);
        }

        @Override // com.huawei.openalliance.ad.views.i
        public void Code(int i10) {
            a aVar = this.Code.get();
            if (aVar == null || aVar.f32144r) {
                return;
            }
            gl.V(a.f32126n, "got safePadding: %s", Integer.valueOf(i10));
            aVar.Code(i10);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class c extends BroadcastReceiver {
        private c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                gl.V(a.f32126n, "intent is empty");
                return;
            }
            String action = intent.getAction();
            gl.V(a.f32126n, "FeedbackEventReceiver action = %s", action);
            if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(action) || a.f32129q.equals(action)) {
                a.this.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(int i10) {
        PPSBaseDialogContentView pPSBaseDialogContentView = this.f32136f;
        if (pPSBaseDialogContentView != null) {
            pPSBaseDialogContentView.Code(i10);
        }
        if (this.f32139i != null) {
            this.S += i10;
            c();
        }
        this.f32144r = true;
    }

    private boolean Code(int[] iArr) {
        return iArr == null || iArr.length != 2;
    }

    private void D() {
        if (Build.VERSION.SDK_INT >= 29) {
            this.f32140j.setForceDarkAllowed(false);
        }
    }

    private void F() {
        int i10;
        if (Code(this.f32131a) || Code(this.f32132b)) {
            gl.I(f32126n, "mAnchorViewLoc or mAnchorViewSize is unavailable");
            return;
        }
        if (this.f32131a[1] + (this.f32132b[1] >> 1) > (this.D >> 1)) {
            this.f32135e.setVisibility(8);
            this.f32137g.setVisibility(0);
            this.f32138h.setVisibility(8);
            this.f32136f = this.f32134d;
            this.f32139i = this.f32137g;
            int f10 = v.f(this);
            if (ea.Code(this).Code(this)) {
                f10 = Math.max(f10, ea.Code(this).Code(this.f32140j));
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f32136f.getLayoutParams();
            layoutParams.setMargins(0, f10, 0, 0);
            this.f32136f.setLayoutParams(layoutParams);
            return;
        }
        this.f32134d.setVisibility(8);
        this.f32137g.setVisibility(8);
        this.f32138h.setVisibility(0);
        this.f32136f = this.f32135e;
        this.f32139i = this.f32138h;
        boolean B2 = l.B(this);
        boolean z10 = l.C(this) && (1 == (i10 = this.L) || 9 == i10);
        boolean z11 = l.S(this) && l.F(this);
        if (B2 || z10 || z11) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f32136f.getLayoutParams();
            layoutParams2.setMargins(0, 0, 0, Math.max(v.V(this, 40.0f), ay.S(this)));
            this.f32136f.setLayoutParams(layoutParams2);
        }
    }

    private void L() {
        try {
            this.f32143m = new c();
            registerReceiver(this.f32143m, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"), f32128p, null);
            IntentFilter intentFilter = new IntentFilter(f32129q);
            if (getBaseContext() != null) {
                registerReceiver(this.f32143m, intentFilter, Code, null);
            }
            com.huawei.openalliance.ad.msgnotify.b.V(this, bf.B, this);
        } catch (Throwable th) {
            gl.I(f32126n, "registerReceiver error: %s", th.getClass().getSimpleName());
        }
    }

    private void S() {
        int i10;
        if (Build.VERSION.SDK_INT >= 30) {
            this.F = getWindowManager().getCurrentWindowMetrics().getBounds().width();
            i10 = getWindowManager().getCurrentWindowMetrics().getBounds().height();
        } else {
            Point point = new Point();
            getWindowManager().getDefaultDisplay().getSize(point);
            this.F = point.x;
            i10 = point.y;
        }
        this.D = i10;
        gl.Code(f32126n, "initDevicesInfo screenWidth: %s, screenHeight: %s", Integer.valueOf(this.F), Integer.valueOf(this.D));
        this.L = ay.c(this);
        this.S = v.V(this, 22.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean V(int[] iArr, int[] iArr2) {
        int max = Math.max(v.f(f32130s), ay.S(f32130s));
        return Math.abs(iArr[0] - iArr2[0]) <= max && Math.abs(iArr[1] - iArr2[1]) <= max;
    }

    private void a() {
        try {
            c cVar = this.f32143m;
            if (cVar != null) {
                unregisterReceiver(cVar);
            }
            com.huawei.openalliance.ad.msgnotify.b.V(this, bf.B);
        } catch (Throwable th) {
            gl.I(f32126n, "unRegisterFeedbackReceiver: %s", th.getClass().getSimpleName());
        }
    }

    private void b() {
        if (Code(this.f32131a) || Code(this.f32132b)) {
            gl.I(f32126n, "mAnchorViewLoc or mAnchorViewSize is unavailable");
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.f32141k.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            int[] iArr = this.f32131a;
            layoutParams2.width = iArr[0];
            layoutParams2.height = iArr[1];
            this.f32141k.setLayoutParams(layoutParams2);
        }
        ViewGroup.LayoutParams layoutParams3 = this.f32142l.getLayoutParams();
        if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
            int[] iArr2 = this.f32132b;
            layoutParams4.width = iArr2[0];
            layoutParams4.height = iArr2[1];
            this.f32142l.setLayoutParams(layoutParams4);
        }
    }

    private void c() {
        ImageView imageView;
        float f10;
        if (Code(this.f32131a) || Code(this.f32132b)) {
            gl.I(f32126n, "mAnchorViewLoc or mAnchorViewSize is unavailable");
            return;
        }
        int V2 = v.V(this, 36.0f);
        int i10 = this.S;
        int i11 = (this.F - i10) - V2;
        int i12 = (this.f32131a[0] + (this.f32132b[0] >> 1)) - (V2 >> 1);
        if (i12 >= i10) {
            i10 = i12;
        }
        if (i10 <= i11) {
            i11 = i10;
        }
        if (ay.I()) {
            imageView = this.f32139i;
            f10 = -i11;
        } else {
            imageView = this.f32139i;
            f10 = i11;
        }
        imageView.setX(f10);
    }

    private void d() {
        Window window = getWindow();
        window.getDecorView().setSystemUiVisibility(1280);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
    }

    public boolean B() {
        try {
            this.f32131a = getIntent().getIntArrayExtra(ax.ao);
            this.f32132b = getIntent().getIntArrayExtra(ax.ap);
            if (!Code(this.f32131a) && !Code(this.f32132b)) {
                if (ay.I()) {
                    int[] iArr = this.f32131a;
                    iArr[0] = (this.F - iArr[0]) - this.f32132b[0];
                    gl.V(f32126n, "rtl mAnchorViewLoc[x,y]= %d, %d", Integer.valueOf(iArr[0]), Integer.valueOf(this.f32131a[1]));
                }
                if (Build.VERSION.SDK_INT >= 24 && ay.Code((Activity) this)) {
                    int e2 = ay.e(this);
                    int[] iArr2 = this.f32131a;
                    iArr2[1] = iArr2[1] - e2;
                    gl.Code(f32126n, "windowing mode is freeform");
                    gl.Code(f32126n, "initDevicesInfo dragBarHeight: %s", Integer.valueOf(e2));
                }
                return true;
            }
            gl.I(f32126n, "mAnchorViewLoc or mAnchorViewSize is unavailable");
            return false;
        } catch (Throwable th) {
            gl.I(f32126n, "getIntentExtra error: %s", th.getClass().getSimpleName());
            return false;
        }
    }

    public void C() {
        int V2;
        gl.V(f32126n, "getRealOrientation orientation %s", Integer.valueOf(this.L));
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f32136f.getLayoutParams();
        int abs = Math.abs((int) this.f32139i.getX());
        int V3 = v.V(this, 36.0f);
        int i10 = (V3 >> 1) + abs;
        double d10 = V3 * 0.5d;
        int viewWidthPercent = (int) ((this.F * (1.0f - this.f32136f.getViewWidthPercent()) * 0.5d) + v.V(this, 16.0f) + d10);
        int viewWidthPercent2 = (int) (((this.F * ((this.f32136f.getViewWidthPercent() * 0.5d) + 0.5d)) - v.V(this, 16.0f)) - d10);
        gl.Code(f32126n, "locationX: %s, locationX2: %s", Integer.valueOf(viewWidthPercent), Integer.valueOf(viewWidthPercent2));
        gl.Code(f32126n, "curImgX: %s, curImgWidth: %s, curImgCenter: %s", Integer.valueOf(abs), Integer.valueOf(V3), Integer.valueOf(i10));
        int i11 = this.L;
        if (1 != i11 && 9 != i11) {
            layoutParams.removeRule(14);
            this.f32136f.setLayoutParams(layoutParams);
            int i12 = this.F;
            if (i10 >= i12 / 3) {
                if (i10 < (i12 * 2) / 3) {
                    V2 = i10 - (this.f32136f.getViewWith() >> 1);
                }
                V2 = ((abs + V3) + v.V(this, 16.0f)) - this.f32136f.getViewWith();
            }
            V2 = abs - v.V(this, 16.0f);
        } else if (i10 < viewWidthPercent) {
            gl.Code(f32126n, "curImgCenter < locationX");
            layoutParams.removeRule(14);
            this.f32136f.setLayoutParams(layoutParams);
            V2 = abs - v.V(this, 16.0f);
        } else {
            if (i10 <= viewWidthPercent2) {
                gl.Code(f32126n, "locationX =< curImgCenter =< locationX2");
                layoutParams.addRule(14);
                this.f32136f.setLayoutParams(layoutParams);
                ay.Code(this, new b(this));
            }
            gl.Code(f32126n, "curImgCenter > locationX2");
            layoutParams.removeRule(14);
            this.f32136f.setLayoutParams(layoutParams);
            V2 = ((abs + V3) + v.V(this, 16.0f)) - this.f32136f.getViewWith();
        }
        this.f32136f.setPaddingStart(V2);
        ay.Code(this, new b(this));
    }

    public void Code() {
    }

    public void I() {
    }

    public int V() {
        return 0;
    }

    public void Z() {
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        gl.V(f32126n, "finish");
        RelativeLayout relativeLayout = this.f32140j;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(4);
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        finish();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            requestWindowFeature(1);
            setContentView(V());
            f32130s = getApplicationContext();
            S();
            if (!B()) {
                gl.I(f32126n, "getIntentExtra return false");
                Z();
                finish();
                return;
            }
            d();
            getWindow().addFlags(134217728);
            Code();
            D();
            L();
            F();
            b();
            c();
            I();
        } catch (Throwable th) {
            gl.I(f32126n, "onCreate ex: %s", th.getClass().getSimpleName());
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        a();
    }

    @Override // com.huawei.openalliance.ad.msgnotify.NotifyCallback
    public void onMessageNotify(String str, Intent intent) {
        if (TextUtils.isEmpty(str) || intent == null) {
            gl.V(f32126n, "msgName or msgData is empty!");
            return;
        }
        gl.Code(f32126n, "onMessageNotify msgName:%s", str);
        try {
            String action = intent.getAction();
            gl.V(f32126n, "FeedbackEventReceiver action = %s", action);
            if (V.equals(action) || I.equals(action)) {
                ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.activity.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        gl.V(a.f32126n, "anchor point changed, do finish.");
                        a.this.finish();
                    }
                });
            }
        } catch (Throwable th) {
            gl.I(f32126n, "error: " + th.getClass().getSimpleName());
        }
    }
}
