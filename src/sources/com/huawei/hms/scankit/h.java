package com.huawei.hms.scankit;

import android.app.Activity;
import android.app.UiModeManager;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.internal.logging.nano.MetricsProto;
import com.huawei.hms.feature.DynamicModuleInitializer;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.scankit.drawable.ScanDrawable;
import com.huawei.hms.scankit.p.i8;
import com.huawei.hms.scankit.p.w7;
import java.util.Locale;

/* compiled from: IRemoteLocalViewDelegateImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class h extends i implements View.OnClickListener {
    private ScanDrawable I;
    private ImageView J;
    private ImageView K;
    private ImageView L;
    private ImageView M;
    private ImageView N;
    private RelativeLayout O;
    private LinearLayout P;
    private LinearLayout Q;
    private LinearLayout R;
    private LinearLayout S;
    private int T;
    private int U;
    private LinearLayout V;
    private TextView W;
    private TextView X;
    private TextView Y;
    private TextView Z;

    /* renamed from: a0, reason: collision with root package name */
    private LinearLayout f30665a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f30666b0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f30667c0;

    /* compiled from: IRemoteLocalViewDelegateImpl.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Rect rect = new Rect();
            Context context = h.this.f30635c;
            if (context == null) {
                return;
            }
            ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            if (w7.c((Activity) h.this.f30635c)) {
                return;
            }
            int width = ((Activity) h.this.f30635c).getWindow().getDecorView().getRootView().getWidth() - rect.right;
            if (!w7.d()) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) h.this.S.getLayoutParams();
                if (width != 0) {
                    if (layoutParams.getMarginEnd() != i8.a(h.this.f30635c, r2.T - 12)) {
                        layoutParams.setMarginEnd(i8.a(h.this.f30635c, r1.T - 12));
                        return;
                    }
                    return;
                }
                if (layoutParams.getMarginEnd() != i8.a(h.this.f30635c, r2.T - 12) + i8.a(h.this.f30635c)) {
                    layoutParams.setMarginEnd(i8.a(h.this.f30635c, r1.T - 12) + i8.a(h.this.f30635c));
                    return;
                }
                return;
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) h.this.O.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) h.this.f30665a0.getLayoutParams();
            if (width != 0) {
                if (layoutParams2.getMarginStart() != i8.a(h.this.f30635c, r3.T - 12)) {
                    layoutParams2.setMarginStart(i8.a(h.this.f30635c, r1.T - 12));
                }
                if (layoutParams3.getMarginStart() != i8.a(h.this.f30635c, r1.T - 12)) {
                    layoutParams3.setMarginStart(i8.a(h.this.f30635c, r0.T - 12));
                    return;
                }
                return;
            }
            if (layoutParams2.getMarginStart() != i8.a(h.this.f30635c, r3.T - 12) + i8.a(h.this.f30635c)) {
                layoutParams2.setMarginStart(i8.a(h.this.f30635c, r1.T - 12) + i8.a(h.this.f30635c));
            }
            if (layoutParams3.getMarginStart() != i8.a(h.this.f30635c, r1.T - 12) + i8.a(h.this.f30635c)) {
                layoutParams3.setMarginStart(i8.a(h.this.f30635c, r0.T - 12) + i8.a(h.this.f30635c));
            }
        }
    }

    public h(Context context, int i10, IObjectWrapper iObjectWrapper, boolean z10, boolean z11, int i11, boolean z12, boolean z13) {
        super(context, i10, iObjectWrapper, z10, z11);
        this.T = 24;
        this.U = i11;
        this.f30666b0 = z12;
        this.f30667c0 = z13;
    }

    private void q() {
        ((RelativeLayout.LayoutParams) this.P.getLayoutParams()).setMarginStart(i8.a(this.f30635c, this.T - 12));
        ((RelativeLayout.LayoutParams) this.Q.getLayoutParams()).setMarginEnd(i8.a(this.f30635c, this.T - 12));
        ((RelativeLayout.LayoutParams) this.R.getLayoutParams()).setMarginStart(i8.a(this.f30635c, this.T - 12));
        ((RelativeLayout.LayoutParams) this.S.getLayoutParams()).setMarginEnd(i8.a(this.f30635c, this.T - 12));
    }

    private void r() {
        Context context = this.f30635c;
        if (context instanceof Activity) {
            ((Activity) context).finish();
        }
    }

    private void s() {
        this.f30636d.findViewById(R.id.scan_title_landscape).setVisibility(8);
        this.f30636d.findViewById(R.id.scan_title).setVisibility(0);
    }

    private void t() {
        int currentModeType = ((UiModeManager) ((Activity) this.f30635c).getSystemService("uimode")).getCurrentModeType();
        if (currentModeType == 3) {
            this.T = 32;
            return;
        }
        if (currentModeType == 4) {
            this.T = 48;
        } else if (currentModeType != 6) {
            this.T = 24;
        } else {
            this.T = 26;
        }
    }

    private void u() {
        WindowManager windowManager;
        int i10;
        if (Build.VERSION.SDK_INT >= 24) {
            Context context = this.f30635c;
            if (context instanceof Activity) {
                windowManager = ((Activity) context).getWindowManager();
            } else {
                windowManager = (WindowManager) context.getSystemService("window");
            }
            Display defaultDisplay = windowManager.getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            if (w7.c((Activity) this.f30635c)) {
                i10 = point.x;
            } else {
                i10 = point.y;
            }
            if (defaultDisplay.getWidth() < i10) {
                s();
            } else {
                v();
            }
        }
    }

    private void v() {
        this.V.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.O.getLayoutParams();
        layoutParams.setMargins(0, l(), 0, 0);
        this.O.setLayoutParams(layoutParams);
        this.f30636d.findViewById(R.id.scan_title_landscape).setVisibility(0);
        this.f30636d.findViewById(R.id.scan_title).setVisibility(8);
    }

    @Override // com.huawei.hms.scankit.i, com.huawei.hms.scankit.e
    public void e() {
        super.e();
        this.f30638f.c(this.f30667c0);
        this.J = (ImageView) this.f30636d.findViewById(R.id.ivScan);
        this.K = (ImageView) this.f30636d.findViewById(R.id.back_img_in);
        this.L = (ImageView) this.f30636d.findViewById(R.id.img_btn);
        this.M = (ImageView) this.f30636d.findViewById(R.id.scankit_back_img_in_land);
        this.N = (ImageView) this.f30636d.findViewById(R.id.scankit_img_btn_in_land);
        this.O = (RelativeLayout) this.f30636d.findViewById(R.id.scan_title_landscape);
        this.P = (LinearLayout) this.f30636d.findViewById(R.id.back_layout);
        this.Q = (LinearLayout) this.f30636d.findViewById(R.id.gallery_Layout);
        this.R = (LinearLayout) this.f30636d.findViewById(R.id.back_layout_landscape);
        this.S = (LinearLayout) this.f30636d.findViewById(R.id.gallery_Layout_landscape);
        ProviderRemoteView providerRemoteView = this.f30636d;
        int i10 = R.id.scan_title_layout;
        this.V = (LinearLayout) providerRemoteView.findViewById(i10);
        this.W = (TextView) this.f30636d.findViewById(R.id.title_scan);
        this.X = (TextView) this.f30636d.findViewById(R.id.title_scan_level_two);
        this.Y = (TextView) this.f30636d.findViewById(R.id.scankit_title_scan_land);
        this.Z = (TextView) this.f30636d.findViewById(R.id.scankit_title_scan_land_level_two);
        this.f30665a0 = (LinearLayout) this.f30636d.findViewById(R.id.scanLayout);
        this.P.setOnClickListener(this);
        this.Q.setOnClickListener(this);
        this.K.setOnClickListener(this);
        this.L.setOnClickListener(this);
        this.M.setOnClickListener(this);
        this.N.setOnClickListener(this);
        this.R.setOnClickListener(this);
        this.S.setOnClickListener(this);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.V.getLayoutParams();
        layoutParams.setMargins(0, i8.a(this.f30635c, 80) + w7.d(this.f30635c), 0, 0);
        layoutParams.addRule(6);
        this.V.setLayoutParams(layoutParams);
        this.V.bringToFront();
        this.V.setVisibility(0);
        t();
        q();
        if (this.U == 0) {
            TextView textView = this.W;
            int i11 = R.string.scankit_title_all;
            textView.setText(i11);
            TextView textView2 = this.W;
            textView2.setContentDescription(textView2.getResources().getString(i11));
            TextView textView3 = this.X;
            int i12 = R.string.scankit_title_all_level_two;
            textView3.setText(i12);
            this.Y.setText(i11);
            TextView textView4 = this.Y;
            textView4.setContentDescription(textView4.getResources().getString(i11));
            this.Z.setText(i12);
        } else {
            TextView textView5 = this.W;
            int i13 = R.string.scankit_title_qr;
            textView5.setText(i13);
            TextView textView6 = this.W;
            textView6.setContentDescription(textView6.getResources().getString(i13));
            TextView textView7 = this.X;
            int i14 = R.string.scankit_title_qr_level_two;
            textView7.setText(i14);
            this.Y.setText(i13);
            TextView textView8 = this.Y;
            textView8.setContentDescription(textView8.getResources().getString(i13));
            this.Z.setText(i14);
        }
        this.Z.bringToFront();
        try {
            ImageView imageView = this.J;
            if (imageView != null) {
                ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
                if (i8.b(this.f30635c).x > i8.a(this.f30635c, MetricsProto.MetricsEvent.PROVISIONING_PREPROVISIONING_ACTIVITY_TIME_MS)) {
                    layoutParams2.width = i8.b(this.f30635c).x / 2;
                } else {
                    layoutParams2.width = i8.b(this.f30635c).x;
                }
                this.J.setLayoutParams(layoutParams2);
                ScanDrawable scanDrawable = new ScanDrawable(this.f30635c.getResources());
                this.I = scanDrawable;
                this.J.setImageDrawable(scanDrawable);
            }
            if (!w7.j(this.f30635c)) {
                if (!w7.c((Activity) this.f30635c)) {
                    u();
                } else {
                    s();
                }
                if (w7.f(this.f30635c) && !w7.b((Activity) this.f30635c) && !w7.h(this.f30635c)) {
                    if (w7.f()) {
                        u();
                    } else {
                        v();
                    }
                }
            }
            if (w7.f(this.f30635c)) {
                LinearLayout linearLayout = (LinearLayout) this.f30636d.findViewById(i10);
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                if (w7.b((Activity) this.f30635c)) {
                    layoutParams3.setMargins(0, i8.a(this.f30635c, 80), 0, 0);
                    layoutParams3.addRule(10);
                } else if (!w7.h(this.f30635c)) {
                    if (w7.f()) {
                        layoutParams3.setMargins(0, i8.a(this.f30635c, 80), 0, 0);
                        layoutParams3.addRule(10);
                    } else {
                        layoutParams3.setMargins(0, i8.a(this.f30635c, 0), 0, 0);
                        layoutParams3.addRule(12);
                    }
                }
                linearLayout.setLayoutParams(layoutParams3);
                linearLayout.bringToFront();
            }
            if (!w7.c((Activity) this.f30635c) && w7.k(this.f30635c) && !w7.j(this.f30635c) && !w7.f(this.f30635c)) {
                if (Locale.getDefault() != null && w7.d()) {
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.O.getLayoutParams();
                    layoutParams4.setMarginEnd(i8.a(this.f30635c, 0));
                    layoutParams4.setMarginStart(i8.a(this.f30635c, this.T - 12) + i8.a(this.f30635c));
                    RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.f30665a0.getLayoutParams();
                    layoutParams5.setMarginEnd(i8.a(this.f30635c, 0));
                    layoutParams5.setMarginStart(i8.a(this.f30635c, this.T - 12) + i8.a(this.f30635c));
                } else {
                    ((RelativeLayout.LayoutParams) this.S.getLayoutParams()).setMarginEnd(i8.a(this.f30635c, this.T - 12) + i8.a(this.f30635c));
                }
            }
            if (!w7.c((Activity) this.f30635c) && w7.i(this.f30635c) && this.f30652t && this.f30666b0) {
                i();
            }
        } catch (NullPointerException | RuntimeException unused) {
        }
        ((RelativeLayout) this.f30636d.findViewById(R.id.scan_parent_view)).getViewTreeObserver().addOnGlobalLayoutListener(new a());
        if (this.f30666b0) {
            return;
        }
        this.J.setVisibility(8);
    }

    @Override // com.huawei.hms.scankit.i
    public void j() {
        if (Locale.getDefault() == null || !w7.d()) {
            return;
        }
        this.K = (ImageView) this.f30636d.findViewById(R.id.back_img_in);
        this.M = (ImageView) this.f30636d.findViewById(R.id.scankit_back_img_in_land);
        ImageView imageView = this.K;
        if (imageView != null) {
            int i10 = R.drawable.scankit_ic_back_mirroring;
            imageView.setImageResource(i10);
            this.M.setImageResource(i10);
        }
        k();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.back_layout) {
            r();
        }
        if (view.getId() == R.id.back_layout_landscape) {
            r();
        }
        if (view.getId() == R.id.back_img_in) {
            r();
        }
        if (view.getId() == R.id.scankit_back_img_in_land) {
            r();
        }
        if (view.getId() == R.id.gallery_Layout) {
            this.f30641i.onClick(view);
        }
        if (view.getId() == R.id.gallery_Layout_landscape) {
            this.f30641i.onClick(view);
        }
        if (view.getId() == R.id.scankit_img_btn_in_land) {
            this.f30641i.onClick(view);
        }
        if (view.getId() == R.id.img_btn) {
            this.f30641i.onClick(view);
        }
    }

    @Override // com.huawei.hms.scankit.e, com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void onStart() {
        super.onStart();
        if (this.f30666b0) {
            ScanDrawable scanDrawable = this.I;
            if (scanDrawable == null) {
                ScanDrawable scanDrawable2 = new ScanDrawable(this.f30635c.getResources());
                this.I = scanDrawable2;
                this.J.setImageDrawable(scanDrawable2);
                this.I.start();
                return;
            }
            if (scanDrawable.isRunning()) {
                return;
            }
            this.I.start();
        }
    }

    @Override // com.huawei.hms.scankit.e, com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void onStop() {
        ScanDrawable scanDrawable;
        super.onStop();
        if (this.f30666b0 && (scanDrawable = this.I) != null && scanDrawable.isRunning()) {
            this.I.stop();
        }
    }

    @Override // com.huawei.hms.scankit.i, com.huawei.hms.scankit.e
    public ProviderRemoteView d() {
        return new ProviderRemoteView(DynamicModuleInitializer.getContext() == null ? this.f30635c : DynamicModuleInitializer.getContext(), false, false);
    }
}
