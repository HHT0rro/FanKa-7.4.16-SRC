package com.huawei.openalliance.ad.augreality.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.huawei.hms.ads.base.R;
import com.huawei.hms.ads.et;
import com.huawei.hms.ads.eu;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.views.AutoScaleSizeRelativeLayout;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class AugmentedRealityView extends AutoScaleSizeRelativeLayout implements a {
    private static final String I = "AugmentedRealityView";
    private et B;
    public Context Code;
    public AdContentData V;

    public AugmentedRealityView(Context context) {
        super(context);
        Code(context);
    }

    public AugmentedRealityView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Code(context);
    }

    public AugmentedRealityView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Code(context);
    }

    private void Code(Context context) {
        this.Code = context;
        LayoutInflater.from(context).inflate(R.layout.hiad_ar_view, this);
        this.B = new et(this.Code, this);
    }

    @Override // com.huawei.openalliance.ad.augreality.views.a
    public eu getPresenter() {
        return this.B;
    }

    @Override // com.huawei.openalliance.ad.augreality.views.a
    public void setAdContentData(AdContentData adContentData) {
        if (adContentData != null) {
            if (this.V == null) {
                this.V = adContentData;
            }
            this.B.Code(this.V);
        }
    }
}
