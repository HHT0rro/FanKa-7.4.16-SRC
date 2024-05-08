package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hms.ads.ea;
import com.huawei.hms.ads.hg;
import com.huawei.hms.ads.splash.R;
import com.huawei.openalliance.ad.beans.metadata.AdSource;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.utils.au;
import com.huawei.openalliance.ad.utils.ay;
import com.huawei.openalliance.ad.utils.l;
import com.huawei.openalliance.ad.utils.v;
import java.util.Locale;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class PPSSplashAdSourceView extends RelativeLayout {
    private Integer B;
    private Integer C;
    private PPSSplashLabelView Code;
    private hg I;
    private TextView V;

    public PPSSplashAdSourceView(Context context) {
        super(context, null);
    }

    public PPSSplashAdSourceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PPSSplashAdSourceView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }

    public PPSSplashAdSourceView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10);
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

    private void Code(Context context) {
        RelativeLayout.inflate(context, getRootLayoutId(), this);
        PPSSplashLabelView pPSSplashLabelView = (PPSSplashLabelView) findViewById(R.id.hiad_ad_label);
        this.Code = pPSSplashLabelView;
        pPSSplashLabelView.setVisibility(8);
        TextView textView = (TextView) findViewById(R.id.hiad_ad_source);
        this.V = textView;
        textView.setVisibility(8);
    }

    private void Code(AdContentData adContentData) {
        PPSSplashLabelView pPSSplashLabelView;
        int i10;
        String n10 = adContentData.n();
        MetaData Z = adContentData.Z();
        AdSource Code = (Z == null || Z.i() == null) ? null : AdSource.Code(Z.i());
        if (TextUtils.isEmpty(n10)) {
            pPSSplashLabelView = this.Code;
            i10 = 8;
        } else {
            this.Code.Code(Code, n10, this.B, this.C, this.I);
            pPSSplashLabelView = this.Code;
            i10 = 0;
        }
        pPSSplashLabelView.setVisibility(i10);
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

    public static boolean Code(Context context, Integer num, Integer num2) {
        if (!ea.Code(context).V() || num == null || num2 == null) {
            return false;
        }
        return ((num.intValue() == 1 || num.intValue() == 4) && (num2.intValue() == 2 || num2.intValue() == 3)) || ((num.intValue() == 2 || num.intValue() == 3) && (num2.intValue() == 1 || num2.intValue() == 3));
    }

    private void V(AdContentData adContentData) {
        TextView textView;
        int i10;
        MetaData Z = adContentData.Z();
        if (Z == null || this.V == null) {
            return;
        }
        String V = au.V(Z.F());
        if (TextUtils.isEmpty(V)) {
            textView = this.V;
            i10 = 8;
        } else {
            this.V.setText(V);
            textView = this.V;
            i10 = 0;
        }
        textView.setVisibility(i10);
    }

    public void Code(AdContentData adContentData, boolean z10, int i10, int i11, boolean z11) {
        Code(getContext());
        String o10 = adContentData.o() == null ? "ll" : adContentData.o();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        Resources resources = getResources();
        int i12 = R.dimen.hiad_splash_label_side_margin;
        int dimensionPixelSize = resources.getDimensionPixelSize(i12);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(i12);
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if ("tr".equals(o10)) {
                Code(i10, i11, z11, dimensionPixelSize, dimensionPixelSize2, layoutParams2);
            } else {
                Code(z10, i10, i11, z11, dimensionPixelSize, dimensionPixelSize2, layoutParams2);
            }
            setLayoutParams(layoutParams2);
        }
        Code(adContentData);
        V(adContentData);
    }

    public void Code(Integer num, Integer num2) {
        this.B = num;
        this.C = num2;
    }

    public int getRootLayoutId() {
        return Code(getContext(), this.B, this.C) ? R.layout.hiad_splash_ad_source_with_click : R.layout.hiad_splash_ad_source;
    }

    public void setAdMediator(hg hgVar) {
        this.I = hgVar;
    }
}
