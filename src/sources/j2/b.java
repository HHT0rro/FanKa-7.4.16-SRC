package j2;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Handler;
import android.os.Looper;
import android.util.Size;
import android.util.SizeF;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.zego.zegoliveroom.constants.ZegoConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: Camera2.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class b implements j2.d {

    /* renamed from: a, reason: collision with root package name */
    public CameraManager f50255a;

    /* renamed from: b, reason: collision with root package name */
    public CameraDevice f50256b;

    /* renamed from: c, reason: collision with root package name */
    public CameraCaptureSession f50257c;

    /* renamed from: e, reason: collision with root package name */
    public CaptureRequest.Builder f50259e;

    /* renamed from: f, reason: collision with root package name */
    public int f50260f;

    /* renamed from: g, reason: collision with root package name */
    public int f50261g;

    /* renamed from: h, reason: collision with root package name */
    public int f50262h;

    /* renamed from: i, reason: collision with root package name */
    public Size[] f50263i;

    /* renamed from: j, reason: collision with root package name */
    public j2.e f50264j;

    /* renamed from: l, reason: collision with root package name */
    public ArrayList<Surface> f50266l;

    /* renamed from: n, reason: collision with root package name */
    public Context f50268n;

    /* renamed from: q, reason: collision with root package name */
    public CameraCharacteristics f50271q;

    /* renamed from: r, reason: collision with root package name */
    public CaptureRequest f50272r;

    /* renamed from: d, reason: collision with root package name */
    public Handler f50258d = new Handler(Looper.getMainLooper());

    /* renamed from: k, reason: collision with root package name */
    public int f50265k = -1;

    /* renamed from: m, reason: collision with root package name */
    public final HashMap<String, PointF> f50267m = new HashMap<>();

    /* renamed from: o, reason: collision with root package name */
    public CameraDevice.StateCallback f50269o = new a();

    /* renamed from: p, reason: collision with root package name */
    public CameraCaptureSession.CaptureCallback f50270p = new C0759b();

    /* compiled from: Camera2.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class a extends CameraDevice.StateCallback {
        public a() {
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(@NonNull CameraDevice cameraDevice) {
            b.this.f50256b = cameraDevice;
            b.this.close();
            b.this.n();
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(@NonNull CameraDevice cameraDevice, int i10) {
            if (b.this.f50264j != null) {
                b.this.f50264j.a();
                b.this.f50264j = null;
            }
            b.this.f50256b = cameraDevice;
            b.this.close();
            b.this.n();
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(@NonNull CameraDevice cameraDevice) {
            b.this.f50256b = cameraDevice;
            if (b.this.f50264j != null) {
                b.this.f50264j.b();
            }
        }
    }

    /* compiled from: Camera2.java */
    /* renamed from: j2.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class C0759b extends CameraCaptureSession.CaptureCallback {
        public C0759b() {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            super.onCaptureCompleted(cameraCaptureSession, captureRequest, totalCaptureResult);
        }
    }

    /* compiled from: Camera2.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f50264j != null) {
                b.this.f50264j.a();
            }
        }
    }

    /* compiled from: Camera2.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f50264j != null) {
                b.this.f50264j.a();
                b.this.f50264j = null;
            }
        }
    }

    /* compiled from: Camera2.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class e extends CameraCaptureSession.StateCallback {
        public e() {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigured(CameraCaptureSession cameraCaptureSession) {
            b.this.f50257c = cameraCaptureSession;
            b.this.p();
        }
    }

    @Override // j2.d
    public int[] a() {
        return new int[]{this.f50261g, this.f50262h};
    }

    @Override // j2.d
    public void b(@NonNull SurfaceTexture surfaceTexture) {
        surfaceTexture.setDefaultBufferSize(this.f50261g, this.f50262h);
        o(Arrays.asList(new Surface(surfaceTexture)));
    }

    @Override // j2.d
    public boolean c() {
        return this.f50256b != null;
    }

    @Override // j2.d
    public void close() {
        try {
            CameraDevice cameraDevice = this.f50256b;
            if (cameraDevice != null) {
                cameraDevice.close();
                this.f50256b = null;
            }
            ArrayList<Surface> arrayList = this.f50266l;
            if (arrayList != null) {
                Iterator<Surface> iterator2 = arrayList.iterator2();
                while (iterator2.hasNext()) {
                    iterator2.next();
                }
                this.f50266l = null;
            }
        } catch (Throwable unused) {
        }
        this.f50264j = null;
    }

    @Override // j2.d
    public boolean d(int i10, j2.e eVar) {
        this.f50264j = eVar;
        try {
            String[] cameraIdList = this.f50255a.getCameraIdList();
            if (i10 >= 0 && i10 <= 2) {
                if (i10 >= cameraIdList.length) {
                    i10 = 1;
                }
                this.f50265k = i10;
                String str = cameraIdList[i10];
                CameraCharacteristics cameraCharacteristics = this.f50255a.getCameraCharacteristics(str);
                this.f50271q = cameraCharacteristics;
                StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
                this.f50260f = ((Integer) this.f50271q.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
                if (this.f50261g == 0 && this.f50262h == 0) {
                    Size[] outputSizes = streamConfigurationMap.getOutputSizes(SurfaceTexture.class);
                    this.f50263i = outputSizes;
                    m(outputSizes);
                }
                if (ContextCompat.checkSelfPermission(this.f50268n, "android.permission.CAMERA") != 0) {
                    return false;
                }
                this.f50255a.openCamera(str, this.f50269o, this.f50258d);
                return true;
            }
            this.f50258d.post(new c());
            return false;
        } catch (Throwable unused) {
            this.f50258d.post(new d());
            return false;
        }
    }

    @Override // j2.d
    public int[] e() {
        return new int[]{this.f50261g, this.f50262h};
    }

    @Override // j2.d
    public void f(int i10, j2.e eVar) {
        close();
        d(i10, eVar);
    }

    @Override // j2.d
    public int getOrientation() {
        CameraCharacteristics cameraCharacteristics = this.f50271q;
        if (cameraCharacteristics == null) {
            return 0;
        }
        return ((Integer) cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
    }

    @Override // j2.d
    public void init(Context context) {
        if (this.f50255a == null) {
            this.f50268n = context;
            CameraManager cameraManager = (CameraManager) context.getSystemService(ZegoConstants.DeviceNameType.DeviceNameCamera);
            this.f50255a = cameraManager;
            this.f50262h = 0;
            this.f50261g = 0;
            try {
                for (String str : cameraManager != null ? cameraManager.getCameraIdList() : new String[0]) {
                    CameraCharacteristics cameraCharacteristics = this.f50255a.getCameraCharacteristics(str);
                    float[] fArr = (float[]) cameraCharacteristics.get(CameraCharacteristics.LENS_INFO_AVAILABLE_FOCAL_LENGTHS);
                    SizeF sizeF = (SizeF) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_PHYSICAL_SIZE);
                    if (fArr != null && fArr.length > 0 && sizeF != null) {
                        this.f50267m.put(str, new PointF((float) Math.toDegrees(Math.atan(sizeF.getWidth() / (fArr[0] * 2.0f)) * 2.0d), (float) Math.toDegrees(Math.atan(sizeF.getHeight() / (fArr[0] * 2.0f)) * 2.0d)));
                    }
                }
            } catch (CameraAccessException e2) {
                throw new RuntimeException("Failed to get camera view angles", e2);
            }
        }
    }

    public final void m(Size[] sizeArr) {
        int i10;
        int i11;
        if (sizeArr != null) {
            int length = sizeArr.length;
            int i12 = 0;
            int i13 = -1;
            int i14 = -1;
            while (true) {
                if (i12 >= length) {
                    i10 = -1;
                    i11 = -1;
                    break;
                }
                Size size = sizeArr[i12];
                i11 = size.getWidth();
                i10 = size.getHeight();
                if (i11 == 1280 && i10 == 720) {
                    break;
                }
                if (Math.abs((i11 * 9) - (i10 * 16)) < 32 && i13 < i10) {
                    i13 = i10;
                    i14 = i11;
                }
                if (Math.abs((i11 * 3) - (i10 * 4)) < 32 && i13 < i10) {
                    i13 = i10;
                    i14 = i11;
                }
                i12++;
            }
            if (i10 != -1) {
                this.f50261g = i11;
                this.f50262h = i10;
            } else {
                this.f50261g = i14;
                this.f50262h = i13;
            }
        }
    }

    public final void n() {
        this.f50256b = null;
        this.f50259e = null;
        this.f50257c = null;
        this.f50271q = null;
        this.f50272r = null;
    }

    public void o(List<Surface> list) {
        if (this.f50256b == null || list == null || list.size() == 0) {
            return;
        }
        try {
            this.f50259e = this.f50256b.createCaptureRequest(3);
            if (this.f50266l == null) {
                this.f50266l = new ArrayList<>();
            }
            this.f50266l.addAll(list);
            Iterator<Surface> iterator2 = this.f50266l.iterator2();
            while (iterator2.hasNext()) {
                this.f50259e.addTarget(iterator2.next());
            }
            this.f50256b.createCaptureSession(this.f50266l, new e(), this.f50258d);
        } catch (CameraAccessException e2) {
            e2.printStackTrace();
        }
    }

    public final void p() {
        CaptureRequest.Builder builder;
        if (this.f50256b == null || (builder = this.f50259e) == null) {
            return;
        }
        try {
            builder.set(CaptureRequest.CONTROL_MODE, 1);
            this.f50259e.set(CaptureRequest.STATISTICS_FACE_DETECT_MODE, 1);
            CaptureRequest build = this.f50259e.build();
            this.f50272r = build;
            this.f50257c.setRepeatingRequest(build, this.f50270p, this.f50258d);
        } catch (CameraAccessException | IllegalStateException e2) {
            e2.printStackTrace();
        }
    }
}
