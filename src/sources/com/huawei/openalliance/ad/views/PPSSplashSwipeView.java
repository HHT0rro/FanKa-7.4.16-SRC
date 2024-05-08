package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.splash.R;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class PPSSplashSwipeView extends PPSBaseSwipeView {
    public PPSSplashSwipeView(Context context) {
        super(context);
        Code(context);
    }

    public PPSSplashSwipeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Code(context);
    }

    public PPSSplashSwipeView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Code(context);
    }

    private void Code(Context context) {
        String str;
        gl.V("PPSSplashSwipeView", "init");
        try {
            View inflate = RelativeLayout.inflate(context, R.layout.hiad_layout_splash_swipe, this);
            this.Code = inflate;
            this.V = (TextView) inflate.findViewById(R.id.hiad_swipe_string);
            this.I = (TextView) this.Code.findViewById(R.id.hiad_swipe_desc);
            this.S = (ImageView) this.Code.findViewById(R.id.hiad_arrow);
            this.F = (ScanningView) this.Code.findViewById(R.id.scanning_view);
        } catch (RuntimeException unused) {
            str = "init RuntimeException";
            gl.I("PPSSplashSwipeView", str);
        } catch (Exception unused2) {
            str = "init error";
            gl.I("PPSSplashSwipeView", str);
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseSwipeView
    public String getViewTag() {
        return "PPSSplashSwipeView";
    }
}
