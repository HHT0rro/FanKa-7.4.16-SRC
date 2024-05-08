package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.hl;
import com.huawei.hms.ads.hm;
import com.huawei.openalliance.ad.inter.data.n;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class NativeMediaView extends AutoScaleSizeRelativeLayout {
    private static final String S = NativeMediaView.class.getSimpleName();
    public n B;
    public hl C;
    private hm D;
    public boolean I;
    public boolean V;

    public NativeMediaView(Context context) {
        super(context);
        this.V = false;
        this.I = false;
        this.C = new hl(this) { // from class: com.huawei.openalliance.ad.views.NativeMediaView.1
            @Override // com.huawei.hms.ads.hl
            public void Code() {
                NativeMediaView.this.Code();
            }

            @Override // com.huawei.hms.ads.hl
            public void Code(int i10) {
                NativeMediaView.this.Code(i10);
            }

            @Override // com.huawei.hms.ads.hl
            public void Code(long j10, int i10) {
                NativeMediaView.this.Code(0);
            }
        };
    }

    public NativeMediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.V = false;
        this.I = false;
        this.C = new hl(this) { // from class: com.huawei.openalliance.ad.views.NativeMediaView.1
            @Override // com.huawei.hms.ads.hl
            public void Code() {
                NativeMediaView.this.Code();
            }

            @Override // com.huawei.hms.ads.hl
            public void Code(int i10) {
                NativeMediaView.this.Code(i10);
            }

            @Override // com.huawei.hms.ads.hl
            public void Code(long j10, int i10) {
                NativeMediaView.this.Code(0);
            }
        };
    }

    public NativeMediaView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.V = false;
        this.I = false;
        this.C = new hl(this) { // from class: com.huawei.openalliance.ad.views.NativeMediaView.1
            @Override // com.huawei.hms.ads.hl
            public void Code() {
                NativeMediaView.this.Code();
            }

            @Override // com.huawei.hms.ads.hl
            public void Code(int i102) {
                NativeMediaView.this.Code(i102);
            }

            @Override // com.huawei.hms.ads.hl
            public void Code(long j10, int i102) {
                NativeMediaView.this.Code(0);
            }
        };
    }

    public void B() {
    }

    public void Code() {
    }

    void Code(int i10) {
        String str = S;
        gl.V(str, "visiblePercentage is " + i10);
        hm hmVar = this.D;
        if (hmVar != null) {
            hmVar.Code(i10);
        }
        if (i10 >= getAutoPlayAreaPercentageThresshold()) {
            this.I = false;
            if (this.V) {
                return;
            }
            this.V = true;
            V();
            return;
        }
        this.V = false;
        int hiddenAreaPercentageThreshhold = getHiddenAreaPercentageThreshhold();
        gl.V(str, "HiddenAreaPercentageThreshhold is " + hiddenAreaPercentageThreshhold);
        if (i10 > 100 - hiddenAreaPercentageThreshhold) {
            if (this.I) {
                B();
            }
            this.I = false;
        } else {
            if (this.I) {
                return;
            }
            this.I = true;
            I();
        }
    }

    public void I() {
    }

    public void V() {
    }

    public int getAutoPlayAreaPercentageThresshold() {
        return 100;
    }

    public int getHiddenAreaPercentageThreshhold() {
        return 10;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        hl hlVar = this.C;
        if (hlVar != null) {
            hlVar.D();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        hl hlVar = this.C;
        if (hlVar != null) {
            hlVar.L();
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        hl hlVar = this.C;
        if (hlVar != null) {
            hlVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setNativeAd(com.huawei.openalliance.ad.inter.data.g gVar) {
        this.B = gVar instanceof n ? (n) gVar : null;
    }

    public void setViewShowAreaListener(hm hmVar) {
        this.D = hmVar;
    }
}
