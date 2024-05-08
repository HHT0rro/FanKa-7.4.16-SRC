package j2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.view.SurfaceView;
import androidx.annotation.Nullable;
import com.android.internal.logging.nano.MetricsProto;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.List;

/* compiled from: Camera1.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class a implements d {

    /* renamed from: a, reason: collision with root package name */
    public Camera f50244a;

    /* renamed from: c, reason: collision with root package name */
    public int f50246c;

    /* renamed from: d, reason: collision with root package name */
    public int f50247d;

    /* renamed from: f, reason: collision with root package name */
    public Camera.CameraInfo f50249f;

    /* renamed from: g, reason: collision with root package name */
    public int f50250g;

    /* renamed from: i, reason: collision with root package name */
    public SurfaceView f50252i;

    /* renamed from: j, reason: collision with root package name */
    public Paint f50253j;

    /* renamed from: b, reason: collision with root package name */
    public int f50245b = 0;

    /* renamed from: e, reason: collision with root package name */
    public k2.b f50248e = k2.c.a();

    /* renamed from: h, reason: collision with root package name */
    public byte[] f50251h = null;

    /* compiled from: Camera1.java */
    /* renamed from: j2.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class C0758a implements Camera.PreviewCallback {
        public C0758a() {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            if (bArr == null || bArr.length != 1382400) {
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onPreviewFrame: ");
            sb2.append(bArr.length);
            a.this.h(bArr);
            camera.addCallbackBuffer(a.this.f50251h);
        }
    }

    @Override // j2.d
    public int[] a() {
        Camera camera = this.f50244a;
        if (camera != null) {
            i(camera.getParameters().getSupportedPreviewSizes());
            try {
                Camera.Parameters parameters = this.f50244a.getParameters();
                parameters.setPreviewSize(this.f50246c, this.f50247d);
                List<Integer> supportedPreviewFrameRates = parameters.getSupportedPreviewFrameRates();
                if (supportedPreviewFrameRates != null) {
                    Iterator<Integer> iterator2 = supportedPreviewFrameRates.iterator2();
                    int i10 = 0;
                    while (iterator2.hasNext()) {
                        int intValue = iterator2.next().intValue();
                        if (intValue == 30) {
                            i10 = intValue;
                        }
                    }
                    if (i10 == 0 && supportedPreviewFrameRates.size() > 0) {
                        i10 = supportedPreviewFrameRates.get(0).intValue();
                    }
                    if (i10 != 0) {
                        parameters.setPreviewFrameRate(i10);
                    }
                }
                if (parameters.getSupportedFocusModes().contains("continuous-video")) {
                    parameters.setFocusMode("continuous-video");
                }
                this.f50244a.setParameters(parameters);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return new int[]{this.f50246c, this.f50247d};
    }

    @Override // j2.d
    public void b(SurfaceTexture surfaceTexture) {
        Camera camera = this.f50244a;
        if (camera == null || surfaceTexture == null) {
            return;
        }
        try {
            camera.setPreviewTexture(surfaceTexture);
            m();
            this.f50244a.startPreview();
        } catch (Exception e2) {
            e2.printStackTrace();
            close();
        }
    }

    @Override // j2.d
    public boolean c() {
        return this.f50244a != null;
    }

    @Override // j2.d
    public void close() {
        Camera camera = this.f50244a;
        if (camera != null) {
            try {
                camera.setPreviewCallback(null);
                this.f50244a.stopPreview();
                this.f50244a.release();
            } catch (Exception unused) {
            }
        }
        this.f50244a = null;
    }

    @Override // j2.d
    public boolean d(int i10, @Nullable e eVar) {
        if (i10 == 0) {
            this.f50250g = 0;
        } else {
            this.f50250g = 1;
        }
        Camera k10 = k(this.f50250g);
        this.f50244a = k10;
        if (k10 != null) {
            if (eVar != null) {
                eVar.b();
            }
            return true;
        }
        if (eVar != null) {
            eVar.a();
        }
        return false;
    }

    @Override // j2.d
    @Nullable
    public int[] e() {
        try {
            Camera.Size previewSize = this.f50244a.getParameters().getPreviewSize();
            return new int[]{previewSize.width, previewSize.height};
        } catch (Exception e2) {
            e2.printStackTrace();
            return new int[]{0, 0};
        }
    }

    @Override // j2.d
    public void f(int i10, e eVar) {
        close();
        d(i10, eVar);
    }

    @Override // j2.d
    public int getOrientation() {
        return this.f50249f.orientation;
    }

    public final void h(byte[] bArr) {
        SurfaceView surfaceView = this.f50252i;
        if (surfaceView != null) {
            Canvas lockCanvas = surfaceView.getHolder().lockCanvas();
            lockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
            Bitmap j10 = j(bArr);
            if (j10 != null) {
                Matrix matrix = new Matrix();
                int width = j10.getWidth();
                int height = j10.getHeight();
                if (l()) {
                    matrix.setRotate(-90.0f, width / 2, height / 2);
                    matrix.postTranslate(((height - width) * 3) / 2, 0.0f);
                    matrix.postScale(-1.0f, 1.0f);
                } else {
                    matrix.setRotate(90.0f, width / 2, height / 2);
                    matrix.postTranslate((height - width) + 10, 0.0f);
                }
                lockCanvas.drawBitmap(j10, matrix, this.f50253j);
            }
            this.f50252i.getHolder().unlockCanvasAndPost(lockCanvas);
            if (j10 != null) {
                j10.recycle();
            }
        }
    }

    public final void i(List<Camera.Size> list) {
        int i10;
        int i11;
        if (list != null) {
            Iterator<Camera.Size> iterator2 = list.iterator2();
            int i12 = -1;
            int i13 = -1;
            while (true) {
                if (!iterator2.hasNext()) {
                    i10 = -1;
                    i11 = -1;
                    break;
                }
                Camera.Size next = iterator2.next();
                i11 = next.width;
                i10 = next.height;
                if (i11 == 1280 && i10 == 720) {
                    break;
                }
                if (Math.abs((i11 * 9) - (i10 * 16)) < 32 && i12 < i10) {
                    i12 = i10;
                    i13 = i11;
                }
                if (Math.abs((i11 * 3) - (i10 * 4)) < 32 && i12 < i10) {
                    i12 = i10;
                    i13 = i11;
                }
            }
            if (i10 != -1) {
                this.f50246c = i11;
                this.f50247d = i10;
            } else {
                this.f50246c = i13;
                this.f50247d = i12;
            }
        }
    }

    @Override // j2.d
    public void init(Context context) {
        this.f50249f = new Camera.CameraInfo();
    }

    public final Bitmap j(byte[] bArr) {
        new BitmapFactory.Options().inJustDecodeBounds = true;
        YuvImage yuvImage = new YuvImage(bArr, 17, 1280, MetricsProto.MetricsEvent.ACTION_PERMISSION_DENIED_RECEIVE_WAP_PUSH, null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        yuvImage.compressToJpeg(new Rect(0, 0, 1280, MetricsProto.MetricsEvent.ACTION_PERMISSION_DENIED_RECEIVE_WAP_PUSH), 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, options);
    }

    public final Camera k(int i10) {
        Camera camera;
        int numberOfCameras = Camera.getNumberOfCameras();
        int i11 = 0;
        while (true) {
            camera = null;
            if (i11 >= numberOfCameras) {
                break;
            }
            try {
                Camera.getCameraInfo(i11, this.f50249f);
            } catch (RuntimeException e2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Camera failed to open: ");
                sb2.append(e2.getLocalizedMessage());
                if (camera != null) {
                    try {
                        camera.release();
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            if (this.f50249f.facing == i10 || numberOfCameras == 1) {
                camera = Camera.open(i11);
                if (camera != null) {
                    camera.setParameters(camera.getParameters());
                }
                this.f50245b = i11;
                break;
            }
            i11++;
        }
        return camera;
    }

    public final boolean l() {
        return this.f50250g == 1;
    }

    public final void m() {
        if (this.f50251h == null) {
            this.f50251h = new byte[1382400];
        }
        this.f50244a.addCallbackBuffer(this.f50251h);
        this.f50244a.setPreviewCallbackWithBuffer(new C0758a());
    }
}
