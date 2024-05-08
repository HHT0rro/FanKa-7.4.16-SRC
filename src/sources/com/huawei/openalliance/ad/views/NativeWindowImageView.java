package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.huawei.hms.ads.fi;
import com.huawei.hms.ads.fk;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.li;
import com.huawei.hms.ads.nativead.NativeView;
import com.huawei.hms.ads.nativead.R;
import com.huawei.openalliance.ad.beans.inner.SourceParam;
import com.huawei.openalliance.ad.inter.data.k;
import com.huawei.openalliance.ad.utils.aj;
import com.huawei.openalliance.ad.utils.ba;
import com.huawei.openalliance.ad.utils.y;
import java.util.Iterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class NativeWindowImageView extends AutoScaleSizeRelativeLayout implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, li, aj {
    private View B;
    private ImageView C;
    private Drawable D;
    private com.huawei.openalliance.ad.inter.data.g F;
    private Rect L;
    private ProgressBar S;

    /* renamed from: a, reason: collision with root package name */
    private Rect f32698a;

    /* renamed from: b, reason: collision with root package name */
    private float f32699b;

    /* renamed from: c, reason: collision with root package name */
    private int f32700c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f32701d;

    public NativeWindowImageView(Context context) {
        super(context);
        this.f32698a = new Rect();
        this.f32699b = 1.3007812f;
        this.f32700c = 0;
        this.f32701d = true;
        Code(context);
    }

    public NativeWindowImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f32698a = new Rect();
        this.f32699b = 1.3007812f;
        this.f32700c = 0;
        this.f32701d = true;
        Code(context);
    }

    public NativeWindowImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f32698a = new Rect();
        this.f32699b = 1.3007812f;
        this.f32700c = 0;
        this.f32701d = true;
        Code(context);
    }

    private void B() {
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnScrollChangedListener(this);
            viewTreeObserver.removeOnGlobalLayoutListener(this);
        }
    }

    private void C() {
        if (S()) {
            V();
            D();
            L();
            a();
            F();
        }
    }

    private void Code(Context context) {
        LayoutInflater.from(context).inflate(R.layout.hiad_window_image_layout, this);
        this.B = this;
        this.C = (ImageView) findViewById(R.id.window_image_content);
        this.S = (ProgressBar) findViewById(R.id.window_image_progress);
        setRatio(Float.valueOf(1.7777778f));
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.L = new Rect(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    private boolean Code(int i10) {
        return this.L.height() >= i10;
    }

    private boolean Code(Object obj) {
        return (obj instanceof PPSNativeView) || (obj instanceof NativeView);
    }

    private void D() {
        Object parent = this.B.getParent();
        if (parent == null) {
            gl.Z("NativeWindowImageView", "invalid parent obj");
        } else {
            ((View) parent).getGlobalVisibleRect(this.L);
        }
    }

    private void F() {
        if (this.D == null) {
            return;
        }
        this.C.setScaleType(ImageView.ScaleType.MATRIX);
        int intrinsicWidth = this.D.getIntrinsicWidth();
        float width = intrinsicWidth != 0 ? getWidth() / intrinsicWidth : 1.0f;
        Matrix matrix = new Matrix();
        matrix.setScale(width, width);
        matrix.postTranslate(0.0f, this.f32700c);
        this.C.setImageMatrix(matrix);
        this.C.invalidate();
    }

    private void I() {
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnScrollChangedListener(this);
            viewTreeObserver.addOnScrollChangedListener(this);
            viewTreeObserver.removeOnGlobalLayoutListener(this);
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
    }

    private void L() {
        Rect rect = new Rect();
        getLocalVisibleRect(rect);
        Rect rect2 = new Rect();
        getGlobalVisibleRect(rect2);
        Rect rect3 = this.f32698a;
        int i10 = rect2.left - rect.left;
        rect3.left = i10;
        rect3.right = i10 + getWidth();
        Rect rect4 = this.f32698a;
        int i11 = rect2.top - rect.top;
        rect4.top = i11;
        rect4.bottom = i11 + getHeight();
    }

    private boolean S() {
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        return rect.width() > 0 && rect.height() > 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void V() {
        if (this.f32701d) {
            ViewParent viewParent = this.B.getParent();
            while (viewParent != 0 && !Code(viewParent)) {
                viewParent = viewParent.getParent();
            }
            if (Code(viewParent)) {
                this.B = (View) viewParent;
            }
        }
    }

    private void a() {
        int width = (int) (getWidth() * this.f32699b);
        if (Code(width)) {
            int height = (this.L.height() - width) / 2;
            Rect rect = this.f32698a;
            int i10 = rect.top;
            Rect rect2 = this.L;
            int i11 = rect2.top;
            if (i10 - i11 <= height) {
                this.f32700c = 0;
            } else if (rect2.bottom - rect.bottom <= height) {
                this.f32700c = rect.height() - width;
            } else {
                this.f32700c = (i11 + height) - i10;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        int intrinsicWidth = this.D.getIntrinsicWidth();
        int intrinsicHeight = this.D.getIntrinsicHeight();
        if (intrinsicHeight != 0 && intrinsicWidth != 0) {
            this.f32699b = intrinsicHeight / intrinsicWidth;
        }
        C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImageDrawable(Drawable drawable) {
        if (drawable != null) {
            if (drawable instanceof fi) {
                ((fi) drawable).Code(new fk() { // from class: com.huawei.openalliance.ad.views.NativeWindowImageView.1
                    @Override // com.huawei.hms.ads.fk
                    public void Code() {
                        NativeWindowImageView.this.b();
                    }

                    @Override // com.huawei.hms.ads.fk
                    public void I() {
                    }

                    @Override // com.huawei.hms.ads.fk
                    public void V() {
                    }
                });
            } else {
                b();
            }
            this.C.setImageDrawable(drawable);
            this.S.setVisibility(8);
        }
    }

    @Override // com.huawei.openalliance.ad.utils.aj
    public void Code() {
        gl.Z("NativeWindowImageView", "load image fail");
    }

    @Override // com.huawei.openalliance.ad.utils.aj
    public void Code(String str, final Drawable drawable) {
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.NativeWindowImageView.2
            @Override // java.lang.Runnable
            public void run() {
                NativeWindowImageView.this.D = drawable;
                NativeWindowImageView nativeWindowImageView = NativeWindowImageView.this;
                nativeWindowImageView.setImageDrawable(nativeWindowImageView.D);
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        I();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        B();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        C();
    }

    @Override // com.huawei.openalliance.ad.views.AutoScaleSizeRelativeLayout, android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        ImageView imageView = this.C;
        imageView.layout(0, 0, imageView.getMeasuredWidth(), this.C.getMeasuredHeight());
    }

    @Override // com.huawei.openalliance.ad.views.AutoScaleSizeRelativeLayout, android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredWidth = getMeasuredWidth();
        this.C.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec((int) (measuredWidth * this.f32699b), 1073741824));
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public void onScrollChanged() {
        C();
    }

    @Override // com.huawei.hms.ads.li
    public void setDisplayView(View view) {
        if (view != null) {
            this.f32701d = false;
            this.B = view;
        }
    }

    @Override // com.huawei.hms.ads.li
    public void setNativeAd(com.huawei.openalliance.ad.inter.data.g gVar) {
        this.F = gVar;
        if (gVar != null) {
            Iterator<k> iterator2 = gVar.Z().iterator2();
            while (true) {
                if (!iterator2.hasNext()) {
                    break;
                }
                k next = iterator2.next();
                if (next != null) {
                    String Z = next.Z();
                    SourceParam sourceParam = new SourceParam();
                    sourceParam.I(Z);
                    sourceParam.V(next.I());
                    sourceParam.V(next.S());
                    y.Code(getContext(), sourceParam, this);
                    break;
                }
            }
            requestLayout();
        }
    }
}
