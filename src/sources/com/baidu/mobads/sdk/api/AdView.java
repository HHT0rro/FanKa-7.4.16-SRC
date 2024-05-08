package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.internal.ay;
import com.baidu.mobads.sdk.internal.bs;
import com.baidu.mobads.sdk.internal.cq;
import com.baidu.mobads.sdk.internal.cr;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class AdView extends RelativeLayout {
    private static final boolean AUTOPLAY = true;
    private static final float HEIGHT_FACTOR = 0.15f;
    public static final String P_VERSION = "3.61";
    private AtomicBoolean hasCalledRequestMethod;
    private cr mAdProd;

    public AdView(Context context) {
        super(context);
        this.hasCalledRequestMethod = new AtomicBoolean(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callRequest() {
        if (this.hasCalledRequestMethod.get()) {
            return;
        }
        this.hasCalledRequestMethod.set(true);
        this.mAdProd.a();
    }

    public void destroy() {
        cr crVar = this.mAdProd;
        if (crVar != null) {
            crVar.e();
        }
    }

    public void setAppSid(String str) {
        cr crVar = this.mAdProd;
        if (crVar != null) {
            crVar.h(str);
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        bs.a().a("AdView.setLayoutParams=", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height), Integer.valueOf(getWidth()), Integer.valueOf(getHeight()));
        int i10 = layoutParams.width;
        int i11 = layoutParams.height;
        DisplayMetrics f10 = ay.f(getContext());
        int i12 = f10.widthPixels;
        int i13 = f10.heightPixels;
        float f11 = f10.density;
        bs.a().a("AdView.setLayoutParams", Integer.valueOf(i12), Integer.valueOf(i13), Float.valueOf(f11));
        if (i10 <= 0) {
            i10 = Math.min(i12, i13);
        } else if (i10 > 0) {
            float f12 = 200.0f * f11;
            if (i10 < f12) {
                i10 = (int) f12;
            }
        }
        if (i11 <= 0) {
            i11 = (int) (Math.min(i12, i13) * HEIGHT_FACTOR);
        } else if (i11 > 0) {
            float f13 = f11 * 30.0f;
            if (i11 < f13) {
                i11 = (int) f13;
            }
        }
        layoutParams.width = i10;
        layoutParams.height = i11;
        cr crVar = this.mAdProd;
        if (crVar != null) {
            crVar.a(i10);
            this.mAdProd.c(i11);
        }
        bs.a().a("AdView.setLayoutParams adapter", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height));
        super.setLayoutParams(layoutParams);
    }

    public void setListener(AdViewListener adViewListener) {
        cr crVar = this.mAdProd;
        if (crVar != null) {
            crVar.a(adViewListener);
        }
    }

    public AdView(Context context, String str) {
        this(context, true, AdSize.Banner, str);
    }

    public AdView(Context context, AdSize adSize, String str) {
        this(context, true, adSize, str);
    }

    public AdView(Context context, boolean z10, AdSize adSize, String str) {
        this(context, null, z10, adSize, str);
    }

    public AdView(Context context, AttributeSet attributeSet, boolean z10, AdSize adSize, String str) {
        super(context, attributeSet);
        this.hasCalledRequestMethod = new AtomicBoolean(false);
        cq cqVar = new cq(context);
        this.mAdProd = new cr(this, context, cqVar, str, z10);
        cqVar.a(new cq.a() { // from class: com.baidu.mobads.sdk.api.AdView.1
            @Override // com.baidu.mobads.sdk.internal.cq.a
            public void onAttachedToWindow() {
                AdView.this.callRequest();
                AdView.this.mAdProd.o();
            }

            @Override // com.baidu.mobads.sdk.internal.cq.a
            public void onDetachedFromWindow() {
                AdView.this.mAdProd.p();
            }

            @Override // com.baidu.mobads.sdk.internal.cq.a
            public boolean onKeyDown(int i10, KeyEvent keyEvent) {
                return AdView.this.mAdProd.a(i10, keyEvent);
            }

            @Override // com.baidu.mobads.sdk.internal.cq.a
            public void onLayoutComplete(int i10, int i11) {
                AdView.this.callRequest();
            }

            @Override // com.baidu.mobads.sdk.internal.cq.a
            public void onWindowFocusChanged(boolean z11) {
                AdView.this.mAdProd.a(z11);
            }

            @Override // com.baidu.mobads.sdk.internal.cq.a
            public void onWindowVisibilityChanged(int i10) {
                AdView.this.mAdProd.b(i10);
            }
        });
        addView(cqVar, new ViewGroup.LayoutParams(-1, -1));
    }
}
