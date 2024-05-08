package com.google.android.exoplayer2.video.spherical;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.WindowManager;
import androidx.annotation.AnyThread;
import androidx.annotation.BinderThread;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.util.j0;
import com.google.android.exoplayer2.video.spherical.d;
import com.google.android.exoplayer2.video.spherical.j;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SphericalGLSurfaceView extends GLSurfaceView {

    /* renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<b> f23097b;

    /* renamed from: c, reason: collision with root package name */
    public final SensorManager f23098c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public final Sensor f23099d;

    /* renamed from: e, reason: collision with root package name */
    public final d f23100e;

    /* renamed from: f, reason: collision with root package name */
    public final Handler f23101f;

    /* renamed from: g, reason: collision with root package name */
    public final j f23102g;

    /* renamed from: h, reason: collision with root package name */
    public final g f23103h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public SurfaceTexture f23104i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public Surface f23105j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f23106k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f23107l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f23108m;

    @VisibleForTesting
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public final class a implements GLSurfaceView.Renderer, j.a, d.a {

        /* renamed from: b, reason: collision with root package name */
        public final g f23109b;

        /* renamed from: e, reason: collision with root package name */
        public final float[] f23112e;

        /* renamed from: f, reason: collision with root package name */
        public final float[] f23113f;

        /* renamed from: g, reason: collision with root package name */
        public final float[] f23114g;

        /* renamed from: h, reason: collision with root package name */
        public float f23115h;

        /* renamed from: i, reason: collision with root package name */
        public float f23116i;

        /* renamed from: c, reason: collision with root package name */
        public final float[] f23110c = new float[16];

        /* renamed from: d, reason: collision with root package name */
        public final float[] f23111d = new float[16];

        /* renamed from: j, reason: collision with root package name */
        public final float[] f23117j = new float[16];

        /* renamed from: k, reason: collision with root package name */
        public final float[] f23118k = new float[16];

        public a(g gVar) {
            float[] fArr = new float[16];
            this.f23112e = fArr;
            float[] fArr2 = new float[16];
            this.f23113f = fArr2;
            float[] fArr3 = new float[16];
            this.f23114g = fArr3;
            this.f23109b = gVar;
            Matrix.setIdentityM(fArr, 0);
            Matrix.setIdentityM(fArr2, 0);
            Matrix.setIdentityM(fArr3, 0);
            this.f23116i = 3.1415927f;
        }

        @Override // com.google.android.exoplayer2.video.spherical.d.a
        @BinderThread
        public synchronized void a(float[] fArr, float f10) {
            float[] fArr2 = this.f23112e;
            System.arraycopy((Object) fArr, 0, (Object) fArr2, 0, fArr2.length);
            this.f23116i = -f10;
            d();
        }

        @Override // com.google.android.exoplayer2.video.spherical.j.a
        @UiThread
        public synchronized void b(PointF pointF) {
            this.f23115h = pointF.y;
            d();
            Matrix.setRotateM(this.f23114g, 0, -pointF.x, 0.0f, 1.0f, 0.0f);
        }

        public final float c(float f10) {
            if (f10 > 1.0f) {
                return (float) (Math.toDegrees(Math.atan(Math.tan(Math.toRadians(45.0d)) / f10)) * 2.0d);
            }
            return 90.0f;
        }

        @AnyThread
        public final void d() {
            Matrix.setRotateM(this.f23113f, 0, -this.f23115h, (float) Math.cos(this.f23116i), (float) Math.sin(this.f23116i), 0.0f);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            synchronized (this) {
                Matrix.multiplyMM(this.f23118k, 0, this.f23112e, 0, this.f23114g, 0);
                Matrix.multiplyMM(this.f23117j, 0, this.f23113f, 0, this.f23118k, 0);
            }
            Matrix.multiplyMM(this.f23111d, 0, this.f23110c, 0, this.f23117j, 0);
            this.f23109b.e(this.f23111d, false);
        }

        @Override // com.google.android.exoplayer2.video.spherical.j.a
        @UiThread
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return SphericalGLSurfaceView.this.performClick();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i10, int i11) {
            GLES20.glViewport(0, 0, i10, i11);
            float f10 = i10 / i11;
            Matrix.perspectiveM(this.f23110c, 0, c(f10), f10, 0.1f, 100.0f);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public synchronized void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            SphericalGLSurfaceView.this.g(this.f23109b.f());
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface b {
        void l(Surface surface);

        void n(Surface surface);
    }

    public SphericalGLSurfaceView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        Surface surface = this.f23105j;
        if (surface != null) {
            Iterator<b> iterator2 = this.f23097b.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().l(surface);
            }
        }
        h(this.f23104i, surface);
        this.f23104i = null;
        this.f23105j = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(SurfaceTexture surfaceTexture) {
        SurfaceTexture surfaceTexture2 = this.f23104i;
        Surface surface = this.f23105j;
        Surface surface2 = new Surface(surfaceTexture);
        this.f23104i = surfaceTexture;
        this.f23105j = surface2;
        Iterator<b> iterator2 = this.f23097b.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().n(surface2);
        }
        h(surfaceTexture2, surface);
    }

    public static void h(@Nullable SurfaceTexture surfaceTexture, @Nullable Surface surface) {
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
        if (surface != null) {
            surface.release();
        }
    }

    public void d(b bVar) {
        this.f23097b.add(bVar);
    }

    public final void g(final SurfaceTexture surfaceTexture) {
        this.f23101f.post(new Runnable() { // from class: com.google.android.exoplayer2.video.spherical.i
            @Override // java.lang.Runnable
            public final void run() {
                SphericalGLSurfaceView.this.f(surfaceTexture);
            }
        });
    }

    public com.google.android.exoplayer2.video.spherical.a getCameraMotionListener() {
        return this.f23103h;
    }

    public q6.h getVideoFrameMetadataListener() {
        return this.f23103h;
    }

    @Nullable
    public Surface getVideoSurface() {
        return this.f23105j;
    }

    public void i(b bVar) {
        this.f23097b.remove(bVar);
    }

    public final void j() {
        boolean z10 = this.f23106k && this.f23107l;
        Sensor sensor = this.f23099d;
        if (sensor == null || z10 == this.f23108m) {
            return;
        }
        if (z10) {
            this.f23098c.registerListener(this.f23100e, sensor, 0);
        } else {
            this.f23098c.unregisterListener(this.f23100e);
        }
        this.f23108m = z10;
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f23101f.post(new Runnable() { // from class: com.google.android.exoplayer2.video.spherical.h
            @Override // java.lang.Runnable
            public final void run() {
                SphericalGLSurfaceView.this.e();
            }
        });
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        this.f23107l = false;
        j();
        super.onPause();
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        this.f23107l = true;
        j();
    }

    public void setDefaultStereoMode(int i10) {
        this.f23103h.h(i10);
    }

    public void setUseSensorRotation(boolean z10) {
        this.f23106k = z10;
        j();
    }

    public SphericalGLSurfaceView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23097b = new CopyOnWriteArrayList<>();
        this.f23101f = new Handler(Looper.getMainLooper());
        SensorManager sensorManager = (SensorManager) com.google.android.exoplayer2.util.a.e(context.getSystemService("sensor"));
        this.f23098c = sensorManager;
        Sensor defaultSensor = j0.f22990a >= 18 ? sensorManager.getDefaultSensor(15) : null;
        this.f23099d = defaultSensor == null ? sensorManager.getDefaultSensor(11) : defaultSensor;
        g gVar = new g();
        this.f23103h = gVar;
        a aVar = new a(gVar);
        j jVar = new j(context, aVar, 25.0f);
        this.f23102g = jVar;
        this.f23100e = new d(((WindowManager) com.google.android.exoplayer2.util.a.e((WindowManager) context.getSystemService("window"))).getDefaultDisplay(), jVar, aVar);
        this.f23106k = true;
        setEGLContextClientVersion(2);
        setRenderer(aVar);
        setOnTouchListener(jVar);
    }
}
