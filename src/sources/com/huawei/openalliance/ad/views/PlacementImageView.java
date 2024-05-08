package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.gx;
import com.huawei.hms.ads.gz;
import com.huawei.hms.ads.jz;
import com.huawei.hms.ads.km;
import com.huawei.hms.ads.lr;
import com.huawei.openalliance.ad.inter.data.p;
import com.huawei.openalliance.ad.inter.data.r;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class PlacementImageView extends PlacementMediaView implements lr {
    private ImageView D;
    private r L;

    /* renamed from: a, reason: collision with root package name */
    private km f32944a;

    /* renamed from: b, reason: collision with root package name */
    private gz f32945b;

    public PlacementImageView(Context context) {
        super(context);
        Code(context);
    }

    public PlacementImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Code(context);
    }

    public PlacementImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Code(context);
    }

    private void Code(Context context) {
        this.f32944a = new jz(getContext(), this);
        this.D = new ImageView(context);
        addView(this.D, new RelativeLayout.LayoutParams(-1, -1));
        this.D.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void B() {
        gz gzVar = this.f32945b;
        if (gzVar != null) {
            gzVar.V();
        }
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void Code() {
        this.D.setImageDrawable(null);
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void Code(int i10) {
        this.D.setImageDrawable(null);
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void Code(gz gzVar) {
        this.f32945b = gzVar;
    }

    @Override // com.huawei.hms.ads.lr
    public void Code(r rVar, Drawable drawable) {
        ((PlacementMediaView) this).B = true;
        if (rVar == null || drawable == null) {
            ((PlacementMediaView) this).C = false;
        } else if (this.L != null && TextUtils.equals(rVar.Z(), this.L.Z())) {
            ((PlacementMediaView) this).C = true;
            this.D.setImageDrawable(drawable);
        }
        if (this.S) {
            Code(true, true);
        }
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void I() {
        gz gzVar = this.f32945b;
        if (gzVar != null) {
            gzVar.Code();
        }
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void V() {
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void V(gz gzVar) {
        this.f32945b = null;
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView, com.huawei.hms.ads.lz
    public void destroyView() {
        this.D.setImageDrawable(null);
        super.destroyView();
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public ImageView getLastFrame() {
        return this.D;
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public com.huawei.openalliance.ad.media.c getMediaState() {
        return null;
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void setMediaPlayerReleaseListener(gx gxVar) {
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void setPlacementAd(com.huawei.openalliance.ad.inter.data.h hVar) {
        super.setPlacementAd(hVar);
        gl.Code("PlacementImageView", "setPlacementAd");
        p pVar = ((PlacementMediaView) this).Code;
        if (pVar != null) {
            r S = pVar.S();
            this.L = S;
            if (S.V()) {
                return;
            }
            this.f32944a.Code(((PlacementMediaView) this).Code);
            ((PlacementMediaView) this).V = this.L.e();
        }
    }
}
