package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.kb;
import com.huawei.hms.ads.ko;
import com.huawei.hms.ads.lw;
import com.huawei.hms.ads.mb;
import com.huawei.openalliance.ad.utils.ba;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class SloganView extends RelativeLayout implements lw {
    private int B;
    private int C;
    private float D;
    private View F;
    private ko I;
    private int S;

    public SloganView(Context context, int i10, int i11) {
        super(context);
        this.C = 0;
        this.S = 1;
        this.B = i10;
        V(i11);
    }

    public SloganView(Context context, int i10, int i11, int i12) {
        super(context);
        this.C = 0;
        this.S = i10;
        this.B = i11;
        V(i12);
    }

    private void Code(int i10, int i11) {
        int i12;
        String str;
        if (i10 <= 0 || i11 <= 0) {
            return;
        }
        float f10 = (i10 * 1.0f) / i11;
        float abs = Math.abs(this.D - f10);
        gl.Code("SloganView", "ratio: %s diff: %s", Float.valueOf(f10), Float.valueOf(abs));
        if (abs > 0.01f) {
            this.D = f10;
            if (f10 <= 0.9f || (i12 = this.C) <= 0) {
                i12 = this.B;
                str = "pick defaultSloganResId";
            } else {
                str = "pick wideSloganResId";
            }
            gl.Code("SloganView", str);
            this.I.Code(i12, false);
        }
    }

    private void V(int i10) {
        this.I = new kb(getContext(), this);
    }

    public void Code() {
        if (this.F == null) {
            this.I.Code(this.B, true);
        }
        setVisibility(0);
    }

    @Override // com.huawei.hms.ads.lw
    public void Code(final int i10) {
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.SloganView.1
            @Override // java.lang.Runnable
            public void run() {
                ImageView imageView;
                if (SloganView.this.F instanceof ImageView) {
                    imageView = (ImageView) SloganView.this.F;
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                } else {
                    SloganView.this.removeAllViews();
                    imageView = new ImageView(SloganView.this.getContext());
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    SloganView.this.F = imageView;
                    SloganView.this.addView(imageView, new RelativeLayout.LayoutParams(-1, -1));
                }
                imageView.setImageResource(i10);
            }
        });
    }

    public void V() {
        setVisibility(8);
    }

    public int getOrientation() {
        return this.S;
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        gl.Code("SloganView", "onSizeChanged w: %d h: %d oldw: %d oldh: %d", Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13));
        Code(i10, i11);
    }

    public void setSloganShowListener(mb mbVar) {
        this.I.Code(mbVar);
    }

    public void setWideSloganResId(int i10) {
        this.C = i10;
    }
}
