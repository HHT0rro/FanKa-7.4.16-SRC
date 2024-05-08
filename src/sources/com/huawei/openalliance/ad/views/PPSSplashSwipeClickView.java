package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.splash.R;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class PPSSplashSwipeClickView extends PPSBaseSwipeView {
    private LinearLayout L;

    public PPSSplashSwipeClickView(Context context) {
        super(context);
        Code(context);
    }

    public PPSSplashSwipeClickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Code(context);
    }

    public PPSSplashSwipeClickView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Code(context);
    }

    private void Code(Context context) {
        String str;
        gl.V("PPSSplashSwipeClickView", "init");
        try {
            View inflate = RelativeLayout.inflate(context, R.layout.hiad_layout_splash_swipe_click, this);
            this.Code = inflate;
            this.L = (LinearLayout) inflate.findViewById(R.id.swipe_click_area);
            this.S = (ImageView) this.Code.findViewById(R.id.hiad_click_arrow);
            this.V = (TextView) this.Code.findViewById(R.id.hiad_click_swipe_string);
            this.I = (TextView) this.Code.findViewById(R.id.hiad_click_swipe_desc);
            this.F = (ScanningView) this.Code.findViewById(R.id.hiad_scanning_view);
        } catch (RuntimeException unused) {
            str = "init RuntimeException";
            gl.I("PPSSplashSwipeClickView", str);
        } catch (Exception unused2) {
            str = "init error";
            gl.I("PPSSplashSwipeClickView", str);
        }
    }

    public LinearLayout getClickAreaView() {
        return this.L;
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseSwipeView
    public String getViewTag() {
        return "PPSSplashSwipeClickView";
    }
}
