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
public class PPSSplashTwistClickView extends PPSBaseTwistView {
    private LinearLayout L;

    public PPSSplashTwistClickView(Context context) {
        super(context);
        Code(context);
    }

    public PPSSplashTwistClickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Code(context);
    }

    public PPSSplashTwistClickView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Code(context);
    }

    private void Code(Context context) {
        String str;
        gl.V("PPSSplashTwistClickView", "init");
        try {
            View inflate = RelativeLayout.inflate(context, R.layout.hiad_layout_splash_twist_click, this);
            this.Code = inflate;
            this.F = (ImageView) inflate.findViewById(R.id.hiad_click_phone_jpg);
            this.L = (LinearLayout) this.Code.findViewById(R.id.twist_click_area);
            this.V = (TextView) this.Code.findViewById(R.id.hiad_click_twist_string);
            this.I = (TextView) this.Code.findViewById(R.id.hiad_click_twist_desc);
        } catch (RuntimeException unused) {
            str = "init RuntimeException";
            gl.I("PPSSplashTwistClickView", str);
        } catch (Exception unused2) {
            str = "init error";
            gl.I("PPSSplashTwistClickView", str);
        }
    }

    public LinearLayout getClickAreaView() {
        return this.L;
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseTwistView
    public String getViewTag() {
        return "PPSSplashTwistClickView";
    }
}
