package com.kwad.components.core.video;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.core.video.VideoAdapters;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class DetailVideoView extends KSFrameLayout implements View.OnClickListener {
    public com.kwad.components.core.page.widget.b Un;
    private b Uo;
    private SurfaceTexture Up;
    public Surface Uq;
    private a Ur;
    private PhotoInfo.VideoInfo Us;
    private final RectF Ut;
    private int Uu;
    private int Uv;

    @NonNull
    private final d Uw;
    private Matrix mMatrix;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        void onClickRootView();

        void onClickVideoView();
    }

    public DetailVideoView(Context context) {
        super(context);
        this.Ut = new RectF();
        this.Uu = 0;
        this.Uv = 0;
        this.Uw = new d();
        B(context);
    }

    private void B(Context context) {
        this.mMatrix = new Matrix();
        this.Un = new com.kwad.components.core.page.widget.b(context);
        addView(this.Un, 0, new FrameLayout.LayoutParams(-1, -1, 17));
        rz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rA() {
        Surface surface = this.Uq;
        if (surface != null) {
            try {
                surface.release();
            } catch (Throwable th) {
                com.kwad.sdk.core.e.c.printStackTrace(th);
            }
            this.Uq = null;
        }
    }

    private void rz() {
        this.Un.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: com.kwad.components.core.video.DetailVideoView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i10, int i11) {
                if (DetailVideoView.this.Up == surfaceTexture) {
                    return;
                }
                DetailVideoView.this.Up = surfaceTexture;
                DetailVideoView.this.rA();
                DetailVideoView.this.Uq = new Surface(surfaceTexture);
                if (DetailVideoView.this.Uo != null) {
                    DetailVideoView.this.Uo.setSurface(DetailVideoView.this.Uq);
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i10, int i11) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        });
    }

    public final void adaptVideoSize(int i10, int i11) {
        if (this.Un == null) {
            com.kwad.sdk.core.e.c.w("DetailVideoView", "adaptVideoSize mTextureView is null");
            return;
        }
        this.Uv = i11;
        this.Uu = i10;
        if (this.Uw.rB()) {
            int rC = this.Uw.rC();
            c cVar = null;
            if (rC == 1) {
                cVar = new VideoAdapters.c();
            } else if (rC == 2) {
                cVar = new VideoAdapters.b();
            }
            if (cVar != null) {
                com.kwad.components.core.page.widget.b bVar = this.Un;
                cVar.a(bVar, (View) bVar.getParent(), i10, i11);
                return;
            }
            return;
        }
        if (this.Uw.rH()) {
            com.kwad.sdk.d.a.a.D(this.Un);
            return;
        }
        if (this.Uw.rD()) {
            com.kwad.sdk.d.a.a.e(this.Un, i10, i11);
            return;
        }
        if (this.Uw.rF()) {
            com.kwad.sdk.d.a.a.f(this.Un, i10, i11);
            return;
        }
        if (this.Uw.rE()) {
            com.kwad.sdk.d.a.a.d(this.Un, i10, i11);
            return;
        }
        if (this.Uw.rG()) {
            a(this.Un, i10, i11);
            return;
        }
        View view = (View) this.Un.getParent();
        if (view == null) {
            return;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        PhotoInfo.VideoInfo videoInfo = this.Us;
        if (videoInfo != null && com.kwad.sdk.core.response.b.h.a(this.mMatrix, width, height, videoInfo)) {
            ViewGroup.LayoutParams layoutParams = this.Un.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            this.Un.setTransform(this.mMatrix);
            this.Un.setLayoutParams(layoutParams);
        } else {
            ViewGroup.LayoutParams layoutParams2 = this.Un.getLayoutParams();
            layoutParams2.width = width;
            layoutParams2.height = (int) ((i11 / (i10 * 1.0f)) * width);
            this.mMatrix.reset();
            this.Un.setTransform(this.mMatrix);
            this.Un.setLayoutParams(layoutParams2);
        }
        this.Ut.set(this.Un.getLeft(), this.Un.getTop(), this.Un.getRight(), this.Un.getBottom());
    }

    @Deprecated
    public final void fixWidth(boolean z10) {
        this.Uw.aR(z10);
    }

    public final void g(boolean z10, int i10) {
        this.Uw.setAd(true);
        this.Uw.aN(i10);
    }

    public int getTextureViewGravity() {
        com.kwad.components.core.page.widget.b bVar = this.Un;
        if (bVar == null) {
            return 17;
        }
        ViewGroup.LayoutParams layoutParams = bVar.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            return ((FrameLayout.LayoutParams) layoutParams).gravity;
        }
        return 17;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.Un) {
            a aVar = this.Ur;
            if (aVar != null) {
                aVar.onClickVideoView();
                return;
            }
            return;
        }
        a aVar2 = this.Ur;
        if (aVar2 != null) {
            aVar2.onClickRootView();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        rA();
        SurfaceTexture surfaceTexture = this.Up;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.Up = null;
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        int i14;
        super.onSizeChanged(i10, i11, i12, i13);
        int i15 = this.Uu;
        if (i15 <= 0 || (i14 = this.Uv) <= 0) {
            return;
        }
        adaptVideoSize(i15, i14);
    }

    @Deprecated
    public void setAd(boolean z10) {
        this.Uw.setAd(z10);
    }

    public void setClickListener(a aVar) {
        this.Ur = aVar;
        setOnClickListener(this);
    }

    @Deprecated
    public void setFillXY(boolean z10) {
        this.Uw.setFillXY(z10);
    }

    @Deprecated
    public void setForce(boolean z10) {
        this.Uw.setForce(z10);
    }

    public void setHorizontalVideo(boolean z10) {
        this.Uw.setHorizontalVideo(z10);
    }

    public void setMediaPlayer(b bVar) {
        this.Uo = bVar;
        Surface surface = this.Uq;
        if (surface == null || bVar == null) {
            return;
        }
        bVar.setSurface(surface);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void setRadius(float f10) {
        com.kwad.components.core.widget.h.b(this, f10);
    }

    public void setVideoInfo(PhotoInfo.VideoInfo videoInfo) {
        this.Us = videoInfo;
    }

    public final void updateTextureViewGravity(int i10) {
        com.kwad.components.core.page.widget.b bVar = this.Un;
        if (bVar == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = bVar.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = i10;
            this.Un.requestLayout();
        }
    }

    private void a(View view, long j10, long j11) {
        View view2;
        if (view == null || j10 == 0 || j11 == 0 || (view2 = (View) view.getParent()) == null) {
            return;
        }
        int width = view2.getWidth();
        int height = view2.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        view.getLayoutParams();
        float f10 = ((float) j10) / ((float) j11);
        float f11 = height * f10;
        float f12 = width;
        if (f11 > f12) {
            height = (int) (f12 / f10);
        } else {
            width = (int) f11;
        }
        if (width == 0 || height == 0) {
            height = -1;
            width = -1;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = width;
        layoutParams.height = height;
        this.Un.setLayoutParams(layoutParams);
    }

    public DetailVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Ut = new RectF();
        this.Uu = 0;
        this.Uv = 0;
        this.Uw = new d();
        B(context);
    }

    public final ValueAnimator a(AdTemplate adTemplate, int i10, final ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        float height = getHeight();
        final float width = height / getWidth();
        final boolean W = com.kwad.sdk.core.response.b.a.W(com.kwad.sdk.core.response.b.e.dQ(adTemplate));
        final ViewGroup.LayoutParams layoutParams = getLayoutParams();
        ValueAnimator ofInt = ValueAnimator.ofInt((int) height, i10);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.core.video.DetailVideoView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (W) {
                    int i11 = (int) (intValue / width);
                    ViewGroup.LayoutParams layoutParams2 = layoutParams;
                    if (layoutParams2 != null) {
                        layoutParams2.height = intValue;
                        layoutParams2.width = i11;
                        DetailVideoView.this.setLayoutParams(layoutParams2);
                    }
                    DetailVideoView.this.adaptVideoSize(i11, intValue);
                } else {
                    ViewGroup.LayoutParams layoutParams3 = layoutParams;
                    if (layoutParams3 != null) {
                        layoutParams3.height = intValue;
                        layoutParams3.width = -1;
                        DetailVideoView.this.setLayoutParams(layoutParams3);
                    }
                }
                ValueAnimator.AnimatorUpdateListener animatorUpdateListener2 = animatorUpdateListener;
                if (animatorUpdateListener2 != null) {
                    animatorUpdateListener2.onAnimationUpdate(valueAnimator);
                }
            }
        });
        Interpolator create = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        ofInt.setDuration(500L);
        ofInt.setInterpolator(create);
        return ofInt;
    }
}
