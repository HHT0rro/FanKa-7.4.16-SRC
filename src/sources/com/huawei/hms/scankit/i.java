package com.huawei.hms.scankit;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hms.feature.DynamicModuleInitializer;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.scankit.p.i8;
import com.huawei.hms.scankit.p.o4;
import com.huawei.hms.scankit.p.w7;
import java.util.Locale;

/* compiled from: IRemoteViewDelegateImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class i extends e {
    public ViewfinderView A;
    public ImageView B;
    private ImageView C;
    private TextView D;
    private IObjectWrapper E;
    private RelativeLayout F;
    private int G;
    private int H;

    /* compiled from: IRemoteViewDelegateImpl.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RelativeLayout f30669a;

        public a(RelativeLayout relativeLayout) {
            this.f30669a = relativeLayout;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (i.this.G == this.f30669a.getHeight() || i.this.H == this.f30669a.getWidth()) {
                return;
            }
            i.this.G = this.f30669a.getHeight();
            i.this.H = this.f30669a.getWidth();
            i.this.p();
        }
    }

    /* compiled from: IRemoteViewDelegateImpl.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            View.OnClickListener onClickListener = i.this.f30641i;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    /* compiled from: IRemoteViewDelegateImpl.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.isSelected()) {
                i.this.f();
                i.this.o();
                i.this.C.setContentDescription(i.this.C.getResources().getString(R.string.scankit_light));
            } else {
                i.this.g();
                view.setSelected(true);
                TextView textView = i.this.D;
                int i10 = R.string.scankit_light_off;
                textView.setText(i10);
                i.this.C.setContentDescription(i.this.C.getResources().getString(i10));
            }
        }
    }

    public i(Context context, int i10, IObjectWrapper iObjectWrapper, boolean z10, boolean z11) {
        super(context, i10, null, iObjectWrapper, z10, false, z11);
        this.G = 0;
        this.H = 0;
        this.E = iObjectWrapper;
        this.f30635c = context;
        this.f30634b = i10;
        this.f30648p = z10;
        this.f30646n = new Rect(-1, -1, -1, -1);
        this.f30651s = z11;
    }

    private boolean n() {
        return this.f30635c.getResources().getDisplayMetrics().widthPixels > 1990 && this.f30635c.getResources().getDisplayMetrics().widthPixels < 2300 && this.f30635c.getResources().getDisplayMetrics().heightPixels > 2190 && this.f30635c.getResources().getDisplayMetrics().heightPixels < 2600;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        ImageView imageView = this.C;
        if (imageView != null) {
            imageView.setSelected(false);
        }
        TextView textView = this.D;
        if (textView != null) {
            textView.setText(R.string.scankit_light);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if ((w7.f(this.f30635c) && w7.b((Activity) this.f30635c)) || this.F == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.F.getLayoutParams().width, this.F.getLayoutParams().height);
        layoutParams.setMargins(0, m(), 0, 0);
        this.F.setLayoutParams(layoutParams);
    }

    @Override // com.huawei.hms.scankit.e, com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public IObjectWrapper getView() {
        return ObjectWrapper.wrap(this.f30636d);
    }

    public void i() {
        RelativeLayout relativeLayout = (RelativeLayout) this.f30636d.findViewById(R.id.scan_parent_view);
        this.f30655w = new LinearLayout(this.f30635c);
        o4.d("Scankit", "initlight adJustLightLayout open");
        this.f30655w.setVisibility(0);
        this.f30655w.setOrientation(1);
        ViewGroup viewGroup = (ViewGroup) this.C.getParent();
        viewGroup.removeView(this.C);
        viewGroup.removeView(this.D);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = i8.a(this.f30635c, 6);
        this.f30655w.setGravity(16);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i8.a(this.f30635c, 214), -1);
        layoutParams2.addRule(11);
        layoutParams2.addRule(15);
        LinearLayout linearLayout = new LinearLayout(this.f30635c);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.setMargins(i8.a(this.f30635c, 24), 0, i8.a(this.f30635c, 24), 0);
        linearLayout.setLayoutParams(layoutParams3);
        linearLayout.setGravity(16);
        linearLayout.setOrientation(1);
        ((LinearLayout.LayoutParams) this.C.getLayoutParams()).setMargins(0, 0, 0, 0);
        linearLayout.addView(this.C);
        linearLayout.addView(this.D, layoutParams);
        this.f30655w.addView(linearLayout);
        relativeLayout.addView(this.f30655w, layoutParams2);
    }

    public void j() {
        if (Locale.getDefault() == null || !w7.d()) {
            return;
        }
        TextView textView = (TextView) this.f30636d.findViewById(R.id.title_scan);
        ImageView imageView = (ImageView) this.f30636d.findViewById(R.id.back_img_in);
        if (imageView != null) {
            imageView.setRotation(180.0f);
        }
        if (textView != null) {
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.addRule(1, R.id.img_btn);
                layoutParams2.rightMargin = 200;
                textView.setLayoutParams(layoutParams);
            }
        }
        k();
    }

    public void k() {
        ViewGroup.LayoutParams layoutParams = this.f30655w.getLayoutParams();
        Context context = this.f30635c;
        if (context == null || context.getResources() == null || this.f30635c.getResources().getDisplayMetrics() == null || !n() || !(layoutParams instanceof FrameLayout.LayoutParams)) {
            return;
        }
        ((FrameLayout.LayoutParams) layoutParams).bottomMargin = 150;
        this.f30655w.setLayoutParams(layoutParams);
    }

    public int l() {
        int m10 = m();
        Context context = this.f30635c;
        if (context == null || context.getResources() == null) {
            return m10;
        }
        try {
            int identifier = this.f30635c.getResources().getIdentifier("hw_multiwindow_height_of_drag_bar", "dimen", "androidhwext");
            return identifier > 0 ? this.f30635c.getResources().getDimensionPixelSize(identifier) : m10;
        } catch (Exception e2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getMultiWindowDragBarHeight exception: ");
            sb2.append(e2.getMessage());
            return m10;
        }
    }

    public int m() {
        int identifier;
        Context context = this.f30635c;
        if (context == null || context.getResources() == null || (identifier = this.f30635c.getResources().getIdentifier("status_bar_height", "dimen", "android")) <= 0) {
            return 0;
        }
        return this.f30635c.getResources().getDimensionPixelSize(identifier);
    }

    @Override // com.huawei.hms.scankit.e, android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i10) {
    }

    @Override // com.huawei.hms.scankit.e, com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.huawei.hms.scankit.e, com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void onResume() {
        com.huawei.hms.scankit.b bVar = this.f30638f;
        if (bVar.f30553i == null) {
            bVar.f30553i = this.f30637e;
        }
        bVar.f();
        o();
        SensorManager sensorManager = this.f30640h;
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(5), 2);
    }

    @Override // com.huawei.hms.scankit.e, com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void setOnClickListener(IObjectWrapper iObjectWrapper) {
        this.f30641i = (View.OnClickListener) ObjectWrapper.unwrap(iObjectWrapper);
    }

    @Override // com.huawei.hms.scankit.e, com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void turnOffLight() throws RemoteException {
    }

    @Override // com.huawei.hms.scankit.e, com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void turnOnLight() throws RemoteException {
    }

    @Override // com.huawei.hms.scankit.e
    public void c() {
        super.c();
        o4.d("Scankit", "initlight mIsContains " + this.f30642j);
        if (!this.f30642j && this.f30652t && w7.a(this.f30635c)) {
            o4.d("Scankit", "initlight open");
            this.f30655w.setVisibility(0);
        }
    }

    @Override // com.huawei.hms.scankit.e
    public ProviderRemoteView d() {
        return new ProviderRemoteView(DynamicModuleInitializer.getContext() == null ? this.f30635c : DynamicModuleInitializer.getContext(), false);
    }

    @Override // com.huawei.hms.scankit.e
    public void e() {
        ProviderRemoteView d10 = d();
        this.f30636d = d10;
        this.F = (RelativeLayout) d10.findViewById(R.id.scan_title);
        p();
        RelativeLayout relativeLayout = (RelativeLayout) this.f30636d.findViewById(R.id.scan_parent_view);
        if (relativeLayout != null) {
            relativeLayout.getViewTreeObserver().addOnGlobalLayoutListener(new a(relativeLayout));
        }
        this.f30637e = (TextureView) this.f30636d.findViewById(R.id.surfaceView);
        this.A = (ViewfinderView) this.f30636d.findViewById(R.id.viewfinderView);
        com.huawei.hms.scankit.b bVar = new com.huawei.hms.scankit.b(this.f30635c, this.f30637e, this.A, this.f30646n, this.f30634b, this.E, this.f30648p, "DefaultView", false);
        this.f30638f = bVar;
        bVar.b(this.f30651s);
        ImageView imageView = (ImageView) this.f30636d.findViewById(R.id.img_btn);
        this.B = imageView;
        imageView.setOnClickListener(new b());
        this.f30655w = (LinearLayout) this.f30636d.findViewById(R.id.flash_light_ll);
        this.C = (ImageView) this.f30636d.findViewById(R.id.ivFlash);
        c();
        this.C.setOnClickListener(new c());
        this.D = (TextView) this.f30636d.findViewById(R.id.flash_light_text);
        a((Point) null, true);
        j();
        k();
    }
}
