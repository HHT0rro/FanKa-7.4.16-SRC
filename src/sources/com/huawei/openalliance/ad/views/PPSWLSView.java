package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hms.ads.ea;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.hg;
import com.huawei.hms.ads.splash.ChoicesView;
import com.huawei.hms.ads.splash.R;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.utils.au;
import com.huawei.openalliance.ad.utils.ay;
import com.huawei.openalliance.ad.utils.l;
import com.huawei.openalliance.ad.utils.v;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class PPSWLSView extends RelativeLayout {
    private ChoicesView B;
    private hg C;
    private Integer D;
    private Integer F;
    private TextView I;
    private View.OnClickListener L;
    private WeakReference<PPSLinkedView> S;
    private PPSSplashLabelView V;

    public PPSWLSView(Context context) {
        super(context, null);
        Code(context);
    }

    public PPSWLSView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Code(context);
    }

    public PPSWLSView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Code(context);
    }

    public PPSWLSView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10);
        Code(context);
    }

    private void Code(int i10, int i11, boolean z10, int i12, int i13, RelativeLayout.LayoutParams layoutParams) {
        int I;
        layoutParams.addRule(10);
        layoutParams.addRule(21);
        layoutParams.rightMargin = i12;
        layoutParams.setMarginEnd(i12);
        layoutParams.topMargin = i13;
        if (i11 != 0) {
            layoutParams.topMargin = i13 + i10;
            return;
        }
        if (!z10) {
            layoutParams.setMarginEnd(layoutParams.rightMargin + i10);
            layoutParams.rightMargin += i10;
        }
        if (ea.V(getContext())) {
            layoutParams.setMarginEnd(layoutParams.rightMargin + ay.I(getContext()));
            I = layoutParams.rightMargin + ay.I(getContext());
        } else {
            layoutParams.setMarginEnd(ay.I(getContext()));
            I = ay.I(getContext());
        }
        layoutParams.rightMargin = I;
        layoutParams.topMargin += v.V(getContext(), 12.0f);
    }

    private void Code(AdContentData adContentData) {
        MetaData Z = adContentData.Z();
        if (Z != null) {
            String V = au.V(Z.F());
            if (TextUtils.isEmpty(V)) {
                this.I.setVisibility(8);
                return;
            }
            this.I.setText(V);
            this.I.setVisibility(0);
            I(adContentData.o());
        }
    }

    private void Code(AdContentData adContentData, String str) {
        PPSSplashLabelView pPSSplashLabelView;
        V(str);
        String n10 = adContentData.n();
        int i10 = 0;
        if (TextUtils.isEmpty(n10)) {
            ViewGroup.LayoutParams layoutParams = this.V.getLayoutParams();
            layoutParams.width = 0;
            this.V.setLayoutParams(layoutParams);
            pPSSplashLabelView = this.V;
            i10 = 4;
        } else {
            this.V.Code(null, n10, this.F, this.D, this.C);
            pPSSplashLabelView = this.V;
        }
        pPSSplashLabelView.setVisibility(i10);
    }

    private void Code(String str) {
        Resources resources = getResources();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.B.getLayoutParams();
        if ("tr".equals(str)) {
            layoutParams.addRule(10);
            layoutParams.addRule(21);
            layoutParams.setMarginStart(resources.getDimensionPixelSize(R.dimen.hiad_8_dp));
        } else {
            layoutParams.addRule(12);
            layoutParams.addRule(20);
            layoutParams.setMarginEnd(resources.getDimensionPixelSize(R.dimen.hiad_8_dp));
        }
        this.B.setLayoutParams(layoutParams);
    }

    private void Code(boolean z10, int i10, int i11, boolean z11, int i12, int i13, RelativeLayout.LayoutParams layoutParams) {
        layoutParams.addRule(12);
        layoutParams.addRule(20);
        layoutParams.leftMargin = i12;
        layoutParams.setMarginStart(i12);
        layoutParams.bottomMargin = i13;
        if (i11 != 0) {
            if (z10) {
                return;
            }
            layoutParams.bottomMargin = i13 + ay.I(getContext());
            return;
        }
        if (ea.V(getContext()) && z11) {
            layoutParams.setMarginStart(layoutParams.leftMargin + i10);
            layoutParams.leftMargin += i10;
        } else if (!ea.V(getContext()) || (ea.V(getContext()) && TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1)) {
            layoutParams.setMarginStart(ay.I(getContext()));
            layoutParams.leftMargin = ay.I(getContext());
        }
        if (z10) {
            return;
        }
        if (l.B(getContext()) || l.S(getContext())) {
            layoutParams.bottomMargin += ay.I(getContext());
        }
    }

    private void I(String str) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.I.getLayoutParams();
        int i10 = R.id.hiad_ad_label_wls;
        layoutParams.addRule(6, i10);
        layoutParams.addRule(8, i10);
        layoutParams.addRule("tr".equals(str) ? 16 : 17, i10);
        this.I.setLayoutParams(layoutParams);
    }

    private void V(final AdContentData adContentData, String str) {
        Code(str);
        String V = au.V(adContentData.X());
        String V2 = au.V(adContentData.Y());
        if (!TextUtils.isEmpty(V)) {
            if (TextUtils.isEmpty(V2)) {
                this.B.I();
            } else {
                this.B.setAdChoiceIcon(V2);
            }
        }
        this.B.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSWLSView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (gl.Code()) {
                    gl.Code("PPSWLSView", "choiceView onclick");
                }
                if (PPSWLSView.this.L != null) {
                    PPSWLSView.this.L.onClick(view);
                    return;
                }
                String V3 = au.V(adContentData.X());
                if (TextUtils.isEmpty(V3)) {
                    V3 = au.V(adContentData.W());
                }
                if (v.Code(PPSWLSView.this.getContext(), V3)) {
                    if (PPSWLSView.this.C != null) {
                        PPSWLSView.this.C.Z();
                    }
                    if (PPSWLSView.this.getPpsLinkedView() != null) {
                        PPSWLSView.this.getPpsLinkedView().Code((Integer) 10, true);
                    }
                }
            }
        });
    }

    private void V(String str) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.V.getLayoutParams();
        layoutParams.addRule(15);
        layoutParams.addRule("tr".equals(str) ? 16 : 17, R.id.splash_why_this_ad);
        this.V.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PPSLinkedView getPpsLinkedView() {
        WeakReference<PPSLinkedView> weakReference = this.S;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public void Code(Context context) {
        RelativeLayout.inflate(context, R.layout.hiad_wls_view, this);
        ChoicesView choicesView = (ChoicesView) findViewById(R.id.splash_why_this_ad);
        this.B = choicesView;
        choicesView.setVisibility(8);
        PPSSplashLabelView pPSSplashLabelView = (PPSSplashLabelView) findViewById(R.id.hiad_ad_label_wls);
        this.V = pPSSplashLabelView;
        pPSSplashLabelView.setVisibility(8);
        TextView textView = (TextView) findViewById(R.id.hiad_ad_source_wls);
        this.I = textView;
        textView.setVisibility(8);
    }

    public void Code(AdContentData adContentData, boolean z10, int i10, int i11, boolean z11) {
        gl.V("PPSWLSView", "positionAndSet. ");
        String o10 = adContentData.o() == null ? "ll" : adContentData.o();
        this.B.setVisibility(0);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        Resources resources = getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.hiad_splash_wls_side_margin);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.hiad_splash_wls_vertical_margin);
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if ("tr".equals(o10)) {
                Code(i10, i11, z11, dimensionPixelSize, dimensionPixelSize2, layoutParams2);
            } else {
                Code(z10, i10, i11, z11, dimensionPixelSize, dimensionPixelSize2, layoutParams2);
            }
            setLayoutParams(layoutParams2);
        }
        V(adContentData, o10);
        Code(adContentData, o10);
        Code(adContentData);
    }

    public void Code(Integer num, Integer num2) {
        this.F = num;
        this.D = num2;
    }

    public int[] getChoiceViewLoc() {
        return ay.I(this.B);
    }

    public int[] getChoiceViewSize() {
        return ay.Z(this.B);
    }

    public void setAdMediator(hg hgVar) {
        this.C = hgVar;
    }

    public void setChoiceViewOnClickListener(View.OnClickListener onClickListener) {
        this.L = onClickListener;
    }

    public void setPpsLinkedView(PPSLinkedView pPSLinkedView) {
        this.S = new WeakReference<>(pPSLinkedView);
    }
}
