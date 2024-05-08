package j2;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;

/* compiled from: TextureHolder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class g {

    /* renamed from: b, reason: collision with root package name */
    public SurfaceTexture f50292b;

    /* renamed from: a, reason: collision with root package name */
    public int f50291a = -1;

    /* renamed from: c, reason: collision with root package name */
    public float[] f50293c = new float[16];

    /* compiled from: TextureHolder.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class a implements SurfaceTexture.OnFrameAvailableListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SurfaceTexture.OnFrameAvailableListener f50294b;

        public a(SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener) {
            this.f50294b = onFrameAvailableListener;
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            surfaceTexture.getTransformMatrix(g.this.f50293c);
            SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener = this.f50294b;
            if (onFrameAvailableListener != null) {
                onFrameAvailableListener.onFrameAvailable(surfaceTexture);
            }
        }
    }

    public SurfaceTexture b() {
        return this.f50292b;
    }

    public int c() {
        return this.f50291a;
    }

    public void d(SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener) {
        if (this.f50291a == -1) {
            this.f50291a = o2.a.f();
            SurfaceTexture surfaceTexture = new SurfaceTexture(this.f50291a);
            this.f50292b = surfaceTexture;
            surfaceTexture.setOnFrameAvailableListener(new a(onFrameAvailableListener));
        }
    }

    public void e() {
        SurfaceTexture surfaceTexture = this.f50292b;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.f50292b = null;
        }
        int i10 = this.f50291a;
        if (i10 != -1) {
            GLES20.glDeleteTextures(1, new int[]{i10}, 0);
        }
        this.f50291a = -1;
    }

    public void f() {
        SurfaceTexture surfaceTexture = this.f50292b;
        if (surfaceTexture != null) {
            surfaceTexture.updateTexImage();
        }
    }
}
