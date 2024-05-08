package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.jv;
import com.huawei.hms.ads.lk;
import com.huawei.hms.ads.splash.R;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class PPSImageView extends PPSBaseView implements lk {

    /* renamed from: a, reason: collision with root package name */
    private ImageView f32776a;

    public PPSImageView(Context context) {
        super(context);
        Code(context);
        this.B = new jv(context, this);
    }

    private void Code(Context context) {
        RelativeLayout.inflate(context, R.layout.hiad_view_image_ad, this);
        this.f32776a = (ImageView) findViewById(R.id.iv_ad_content);
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseView, com.huawei.hms.ads.lq
    public boolean C() {
        return true;
    }

    @Override // com.huawei.hms.ads.lk
    public void Code(Drawable drawable) {
        gl.V("PPSImageView", "onAdImageLoaded - set image to view");
        this.f32776a.setImageDrawable(drawable);
        this.B.Code(this.F);
    }
}
