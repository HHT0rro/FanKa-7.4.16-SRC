package com.cupidapp.live.liveshow.beauty.view;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.view.RoundedFrameLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r2.i;
import z0.z;

/* compiled from: FKLiveBeautyGLSurfaceView.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveBeautyGLSurfaceView extends RoundedFrameLayout implements GLSurfaceView.Renderer {

    /* renamed from: h, reason: collision with root package name */
    public boolean f14883h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14884i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveBeautyGLSurfaceView(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f14884i = new LinkedHashMap();
        d();
    }

    @Nullable
    public View c(int i10) {
        Map<Integer, View> map = this.f14884i;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public final void d() {
        z.a(this, R$layout.layout_live_beauty_gl_surface_view, true);
    }

    public final void e() {
        if (this.f14883h) {
            setCornerRadius(0.0f);
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = -1;
            }
            ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.width = -1;
            }
            setY(0.0f);
            setX(0.0f);
            this.f14883h = false;
        }
    }

    public final void f(float f10, float f11, int i10, int i11, float f12) {
        if (this.f14883h) {
            return;
        }
        setCornerRadius(f12);
        getLayoutParams().height = i11;
        getLayoutParams().width = i10;
        setY(f11);
        setX(f10);
        this.f14883h = true;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(@Nullable GL10 gl10) {
        i.f53231b.u();
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(@Nullable GL10 gl10, int i10, int i11) {
        i.f53231b.y(i10, i11);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(@Nullable GL10 gl10, @Nullable EGLConfig eGLConfig) {
        i iVar = i.f53231b;
        GLSurfaceView glSurfaceView = (GLSurfaceView) c(R$id.glSurfaceView);
        s.h(glSurfaceView, "glSurfaceView");
        iVar.z(glSurfaceView);
    }

    public final void setSurface() {
        int i10 = R$id.glSurfaceView;
        ((GLSurfaceView) c(i10)).setEGLContextClientVersion(2);
        ((GLSurfaceView) c(i10)).setRenderer(this);
        ((GLSurfaceView) c(i10)).setRenderMode(0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveBeautyGLSurfaceView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f14884i = new LinkedHashMap();
        d();
    }
}
