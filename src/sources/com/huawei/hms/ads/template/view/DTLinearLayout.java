package com.huawei.hms.ads.template.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Pair;
import android.widget.LinearLayout;
import com.huawei.hms.ads.annotation.GlobalApi;
import com.huawei.hms.ads.cd;
import com.huawei.hms.ads.cj;
import com.huawei.hms.ads.cr;
import org.json.JSONObject;

@GlobalApi
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class DTLinearLayout extends LinearLayout implements a, b {
    private cd Code;
    private c V;

    @GlobalApi
    public DTLinearLayout(Context context) {
        super(context);
        this.V = new c(this);
    }

    @GlobalApi
    public DTLinearLayout(Context context, AttributeSet attributeSet) {
        super(context);
        this.V = new c(this);
        if (attributeSet != null) {
            cd cdVar = new cd(this);
            this.Code = cdVar;
            cdVar.Code((cj) new cr(this));
            this.Code.Code(attributeSet);
        }
    }

    @Override // com.huawei.hms.ads.template.view.a
    public void Code(JSONObject jSONObject) {
        cd cdVar = this.Code;
        if (cdVar != null) {
            cdVar.Code(jSONObject);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        this.V.Code(canvas);
        super.draw(canvas);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Pair<Integer, Integer> Code = com.huawei.hms.ads.template.util.a.Code(attributeSet, getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(((Integer) Code.first).intValue(), ((Integer) Code.second).intValue());
        layoutParams.gravity = com.huawei.hms.ads.template.util.a.V(attributeSet.getAttributeValue(null, "layout_gravity"));
        layoutParams.weight = attributeSet.getAttributeFloatValue(null, "layout_weight", 0.0f);
        com.huawei.hms.ads.template.util.a.Code(getContext(), layoutParams, attributeSet);
        return layoutParams;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        this.V.Code(z10, i10, i11, i12, i13);
    }

    @Override // com.huawei.hms.ads.template.view.b
    public void setRectRoundCornerRadius(float f10) {
        this.V.Code(f10);
    }
}
