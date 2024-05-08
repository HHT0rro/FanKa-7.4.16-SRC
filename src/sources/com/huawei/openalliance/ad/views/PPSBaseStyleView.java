package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.openalliance.ad.utils.ay;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class PPSBaseStyleView extends RelativeLayout {
    public boolean B;
    public int C;
    public View Code;
    public TextView I;
    public TextView V;

    public PPSBaseStyleView(Context context) {
        super(context);
        this.C = 1;
    }

    public PPSBaseStyleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.C = 1;
    }

    public PPSBaseStyleView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.C = 1;
    }

    public void Code() {
        if (this.B || this.C != 1) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.bottomMargin += ay.I(getContext());
            setLayoutParams(layoutParams2);
        }
    }

    public void Code(String str, String str2) {
        if (this.V != null && !TextUtils.isEmpty(str)) {
            this.V.setText(str);
        }
        if (this.I == null || TextUtils.isEmpty(str2)) {
            return;
        }
        this.I.setText(str2);
    }

    public void setOrientation(int i10) {
        this.C = i10;
    }

    public void setShowLogo(boolean z10) {
        this.B = z10;
        Code();
    }
}
