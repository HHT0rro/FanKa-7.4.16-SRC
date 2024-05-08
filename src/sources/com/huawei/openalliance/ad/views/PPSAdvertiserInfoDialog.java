package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.huawei.hms.ads.ea;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.splash.R;
import com.huawei.openalliance.ad.compliance.ComplianceView;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.utils.ay;
import com.huawei.openalliance.ad.utils.l;
import com.huawei.openalliance.ad.utils.v;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class PPSAdvertiserInfoDialog extends RelativeLayout {
    private int C;
    private int D;
    private int F;
    private RelativeLayout L;
    private int S;

    /* renamed from: a, reason: collision with root package name */
    private View f32702a;

    /* renamed from: b, reason: collision with root package name */
    private View f32703b;

    /* renamed from: c, reason: collision with root package name */
    private int[] f32704c;

    /* renamed from: d, reason: collision with root package name */
    private int[] f32705d;

    /* renamed from: e, reason: collision with root package name */
    private ComplianceView f32706e;

    /* renamed from: f, reason: collision with root package name */
    private ComplianceView f32707f;

    /* renamed from: g, reason: collision with root package name */
    private ComplianceView f32708g;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f32709h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f32710i;

    /* renamed from: j, reason: collision with root package name */
    private ImageView f32711j;

    /* renamed from: k, reason: collision with root package name */
    private Context f32712k;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a implements View.OnClickListener {
        private WeakReference<View> Code;

        public a(View view) {
            this.Code = new WeakReference<>(view);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            View view2 = this.Code.get();
            if (view2 != null) {
                view2.setVisibility(8);
            }
        }
    }

    public PPSAdvertiserInfoDialog(Context context) {
        super(context);
        Code(context);
    }

    public PPSAdvertiserInfoDialog(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Code(context);
    }

    public PPSAdvertiserInfoDialog(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Code(context);
    }

    public PPSAdvertiserInfoDialog(Context context, int[] iArr, int[] iArr2) {
        super(context);
        this.f32704c = iArr == null ? null : Arrays.copyOf(iArr, iArr.length);
        this.f32705d = iArr2 != null ? Arrays.copyOf(iArr2, iArr2.length) : null;
        Code(context);
    }

    private void B() {
        if (D() && ay.I()) {
            int[] iArr = this.f32704c;
            iArr[0] = (this.C - iArr[0]) - this.f32705d[0];
            gl.V("PPSAdvertiserInfoDialog", "rtl mAnchorViewLoc[x,y]= %d, %d", Integer.valueOf(iArr[0]), Integer.valueOf(this.f32704c[1]));
        }
    }

    private void C() {
        ImageView imageView;
        float f10;
        if (!D()) {
            V();
            return;
        }
        int V = v.V(this.f32712k, 36.0f);
        int i10 = this.D;
        int i11 = (this.C - i10) - V;
        int i12 = (this.f32704c[0] + (this.f32705d[0] / 2)) - (V / 2);
        if (i12 >= i10) {
            i10 = i12;
        }
        if (i10 <= i11) {
            i11 = i10;
        }
        if (ay.I()) {
            imageView = this.f32711j;
            f10 = -i11;
        } else {
            imageView = this.f32711j;
            f10 = i11;
        }
        imageView.setX(f10);
    }

    private void Code() {
        if (!D()) {
            V();
            return;
        }
        RelativeLayout relativeLayout = this.L;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        ComplianceView complianceView = this.f32708g;
        if (complianceView != null) {
            complianceView.Code(this.f32704c, this.f32705d);
        }
        F();
        S();
        C();
        L();
    }

    private void Code(Context context) {
        LayoutInflater.from(context).inflate(R.layout.hiad_advertiser_info_dialog, this);
        this.f32712k = context.getApplicationContext();
        I();
        Z();
        B();
        Code();
    }

    private void Code(boolean z10) {
        int i10 = z10 ? 8 : 0;
        int i11 = z10 ? 0 : 8;
        this.f32706e.setVisibility(i10);
        this.f32709h.setVisibility(i10);
        this.f32710i.setVisibility(i11);
        this.f32707f.setVisibility(i11);
        this.f32708g = z10 ? this.f32707f : this.f32706e;
        this.f32711j = z10 ? this.f32710i : this.f32709h;
    }

    private boolean D() {
        int[] iArr = this.f32704c;
        boolean z10 = iArr != null && iArr.length == 2;
        int[] iArr2 = this.f32705d;
        return z10 && (iArr2 != null && iArr2.length == 2);
    }

    private void F() {
        if (!D()) {
            V();
            return;
        }
        boolean z10 = this.f32704c[1] + (this.f32705d[1] / 2) <= this.S / 2;
        Code(z10);
        RelativeLayout.LayoutParams V = V(z10);
        ComplianceView complianceView = this.f32708g;
        if (complianceView == null || V == null) {
            return;
        }
        complianceView.setLayoutParams(V);
    }

    private void I() {
        this.C = com.huawei.openalliance.ad.utils.c.V(this.f32712k);
        this.S = com.huawei.openalliance.ad.utils.c.Code(this.f32712k);
        this.F = ay.c(this.f32712k);
        this.D = v.V(this.f32712k, 22.0f);
    }

    private void L() {
        int V;
        if (!D()) {
            V();
            return;
        }
        gl.V("PPSAdvertiserInfoDialog", "getRealOrientation orientation %s", Integer.valueOf(this.F));
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f32708g.getLayoutParams();
        int abs = Math.abs((int) this.f32711j.getX());
        int V2 = v.V(this.f32712k, 36.0f);
        int i10 = (V2 >> 1) + abs;
        double d10 = V2 * 0.5d;
        int viewWidthPercent = (int) ((this.C * (1.0f - this.f32708g.getViewWidthPercent()) * 0.5d) + v.V(this.f32712k, 16.0f) + d10);
        int viewWidthPercent2 = (int) (((this.C * ((this.f32708g.getViewWidthPercent() * 0.5d) + 0.5d)) - v.V(this.f32712k, 16.0f)) - d10);
        gl.Code("PPSAdvertiserInfoDialog", "locationX: %s, locationX2: %s", Integer.valueOf(viewWidthPercent), Integer.valueOf(viewWidthPercent2));
        gl.Code("PPSAdvertiserInfoDialog", "curImgX: %s, curImgWidth: %s, curImgCenter: %s", Integer.valueOf(abs), Integer.valueOf(V2), Integer.valueOf(i10));
        int i11 = this.F;
        if (1 != i11 && 9 != i11) {
            layoutParams.removeRule(14);
            this.f32708g.setLayoutParams(layoutParams);
            int i12 = this.C;
            if (i10 >= i12 / 3) {
                V = i10 < (i12 * 2) / 3 ? i10 - (this.f32708g.getViewWith() >> 1) : ((abs + V2) + v.V(this.f32712k, 16.0f)) - this.f32708g.getViewWith();
            }
            V = abs - v.V(this.f32712k, 16.0f);
        } else if (i10 < viewWidthPercent) {
            gl.Code("PPSAdvertiserInfoDialog", "curImgCenter < locationX");
            layoutParams.removeRule(14);
            this.f32708g.setLayoutParams(layoutParams);
            V = abs - v.V(this.f32712k, 16.0f);
        } else if (i10 <= viewWidthPercent2) {
            gl.Code("PPSAdvertiserInfoDialog", "locationX =< curImgCenter =< locationX2");
            layoutParams.addRule(14);
            this.f32708g.setLayoutParams(layoutParams);
            return;
        } else {
            gl.Code("PPSAdvertiserInfoDialog", "curImgCenter > locationX2");
            layoutParams.removeRule(14);
            this.f32708g.setLayoutParams(layoutParams);
            V = ((abs + V2) + v.V(this.f32712k, 16.0f)) - this.f32708g.getViewWith();
            gl.Code("PPSAdvertiserInfoDialog", "paddingStart: %s", Integer.valueOf(V));
        }
        this.f32708g.setPaddingStart(V);
    }

    private void S() {
        if (!D()) {
            V();
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.f32702a.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            int[] iArr = this.f32704c;
            layoutParams2.width = iArr[0];
            layoutParams2.height = iArr[1];
            this.f32702a.setLayoutParams(layoutParams2);
        }
        ViewGroup.LayoutParams layoutParams3 = this.f32703b.getLayoutParams();
        if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
            int[] iArr2 = this.f32705d;
            layoutParams4.width = iArr2[0];
            layoutParams4.height = iArr2[1];
            this.f32703b.setLayoutParams(layoutParams4);
        }
    }

    private RelativeLayout.LayoutParams V(boolean z10) {
        int i10;
        ComplianceView complianceView = this.f32708g;
        if (complianceView == null) {
            return null;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) complianceView.getLayoutParams();
        boolean B = l.B(this.f32712k);
        boolean z11 = l.C(this.f32712k) && (1 == (i10 = this.F) || 9 == i10);
        boolean z12 = l.S(this.f32712k) && l.F(this.f32712k);
        if (!z10) {
            int f10 = v.f(this.f32712k);
            if (ea.Code(this.f32712k).Code(this.f32712k)) {
                f10 = Math.max(f10, ea.Code(this.f32712k).Code(this.L));
            }
            layoutParams.setMargins(0, f10, 0, 0);
        } else if (B || z11 || z12) {
            layoutParams.setMargins(0, 0, 0, Math.max(v.V(this.f32712k, 40.0f), ay.S(this.f32712k)));
        }
        return layoutParams;
    }

    private void V() {
        RelativeLayout relativeLayout = this.L;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
    }

    private void Z() {
        this.L = (RelativeLayout) findViewById(R.id.haid_advertiser_info_dialog_root);
        this.f32702a = findViewById(R.id.margin_view);
        this.f32703b = findViewById(R.id.anchor_view);
        this.f32706e = (ComplianceView) findViewById(R.id.top_advertiser_view);
        this.f32709h = (ImageView) findViewById(R.id.top_advertiser_iv);
        this.f32707f = (ComplianceView) findViewById(R.id.bottom_advertiser_view);
        this.f32710i = (ImageView) findViewById(R.id.bottom_advertiser_iv);
        if (Build.VERSION.SDK_INT >= 29) {
            this.L.setForceDarkAllowed(false);
        }
        RelativeLayout relativeLayout = this.L;
        relativeLayout.setOnClickListener(new a(relativeLayout));
    }

    public PPSBaseDialogContentView getBottomDialogView() {
        return this.f32707f;
    }

    @Override // android.view.View
    public RelativeLayout getRootView() {
        return this.L;
    }

    public PPSBaseDialogContentView getTopDialogView() {
        return this.f32706e;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        V();
    }

    public void setAdContent(AdContentData adContentData) {
        this.f32708g.setAdContentData(adContentData);
        Code();
    }

    public void setScreenHeight(int i10) {
        if (i10 > 0) {
            this.S = i10;
        }
    }

    public void setScreenWidth(int i10) {
        if (i10 > 0) {
            this.C = i10;
        }
    }
}
