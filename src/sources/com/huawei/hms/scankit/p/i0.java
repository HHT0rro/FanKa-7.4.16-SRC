package com.huawei.hms.scankit.p;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import android.os.AsyncTask;
import com.huawei.quickcard.base.Attributes;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: CameraFocusManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class i0 implements Camera.AutoFocusCallback {

    /* renamed from: i, reason: collision with root package name */
    private static final Set<String> f31080i;

    /* renamed from: a, reason: collision with root package name */
    private final boolean f31081a;

    /* renamed from: b, reason: collision with root package name */
    private Camera f31082b;

    /* renamed from: c, reason: collision with root package name */
    private AsyncTask<?, ?, ?> f31083c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f31084d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f31085e = false;

    /* renamed from: f, reason: collision with root package name */
    private int f31086f = -1;

    /* renamed from: g, reason: collision with root package name */
    private int f31087g = 2;

    /* renamed from: h, reason: collision with root package name */
    private String f31088h = null;

    /* compiled from: CameraFocusManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a extends AsyncTask<Object, Object, Object> {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<i0> f31089a;

        public a(i0 i0Var) {
            this.f31089a = new WeakReference<>(i0Var);
        }

        @Override // android.os.AsyncTask
        public Object doInBackground(Object... objArr) {
            i0 i0Var = this.f31089a.get();
            if (i0Var == null) {
                return null;
            }
            i0Var.d();
            try {
                Thread.sleep(Math.max(i0Var.c(), 0));
            } catch (InterruptedException unused) {
            }
            return null;
        }
    }

    static {
        HashSet hashSet = new HashSet();
        f31080i = hashSet;
        hashSet.add(Attributes.LayoutDirection.AUTO);
        hashSet.add("macro");
    }

    public i0(Camera camera) {
        this.f31082b = camera;
        boolean contains = f31080i.contains(camera.getParameters().getFocusMode());
        this.f31081a = contains;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("CameraFocusManager useAutoFocus： ");
        sb2.append(contains);
    }

    private synchronized void b() {
        AsyncTask<?, ?, ?> asyncTask = this.f31083c;
        if (asyncTask != null) {
            if (asyncTask.getStatus() != AsyncTask.Status.FINISHED) {
                this.f31083c.cancel(true);
            }
            this.f31083c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized int c() {
        return this.f31086f;
    }

    public synchronized void d() {
        if (this.f31081a) {
            this.f31083c = null;
            if (!this.f31084d && !this.f31085e) {
                try {
                    this.f31082b.autoFocus(this);
                    this.f31085e = true;
                } catch (RuntimeException e2) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Unexpected exception while focusing");
                    sb2.append(e2.getMessage());
                    a();
                }
            }
        }
    }

    public synchronized void e() {
        this.f31084d = true;
        if (this.f31081a) {
            b();
            try {
                Camera camera = this.f31082b;
                if (camera != null) {
                    camera.cancelAutoFocus();
                }
            } catch (RuntimeException e2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unexpected exception while cancelling focusing");
                sb2.append(e2.getMessage());
            }
        }
    }

    @Override // android.hardware.Camera.AutoFocusCallback
    public synchronized void onAutoFocus(boolean z10, Camera camera) {
        this.f31085e = false;
        a();
        if (camera != null) {
            try {
                camera.cancelAutoFocus();
            } catch (RuntimeException e2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unexpected exception while cancelling focusing");
                sb2.append(e2.getMessage());
            }
            try {
                Camera.Parameters parameters = camera.getParameters();
                parameters.setFocusMode(this.f31088h);
                camera.setParameters(parameters);
            } catch (RuntimeException e10) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("CameraFocusManager::setCameraFocusArea failed: ");
                sb3.append(e10.getMessage());
            }
        }
    }

    private synchronized void a() {
        if (!this.f31084d && this.f31083c == null) {
            a aVar = new a(this);
            try {
                aVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
                this.f31083c = aVar;
            } catch (RejectedExecutionException e2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("CameraFocusManager::autoFocusAgainLater RejectedExecutionException: ");
                sb2.append(e2.getMessage());
            }
        }
    }

    public void a(Rect rect, int i10, int i11, boolean z10, boolean z11) {
        int i12 = this.f31087g;
        if (i12 < 1) {
            return;
        }
        this.f31087g = i12 - 1;
        Rect a10 = a(rect.centerX(), rect.centerY(), 1.0f, i11, i10, false, z10 ? 90 : 0);
        if (a10 == null) {
            this.f31087g--;
            return;
        }
        Camera camera = this.f31082b;
        if (camera != null) {
            try {
                camera.cancelAutoFocus();
                Camera.Parameters parameters = this.f31082b.getParameters();
                if (parameters.getMaxNumFocusAreas() > 0) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new Camera.Area(a10, 1000));
                    parameters.setFocusAreas(arrayList);
                }
                if (parameters.getMaxNumMeteringAreas() > 0) {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(new Camera.Area(a10, 1000));
                    parameters.setMeteringAreas(arrayList2);
                }
                this.f31088h = parameters.getFocusMode();
                parameters.setFocusMode("macro");
                this.f31082b.setParameters(parameters);
                this.f31082b.autoFocus(this);
            } catch (RuntimeException e2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("CameraFocusManager::setCameraFocusArea failed: ");
                sb2.append(e2.getMessage());
                this.f31087g++;
            }
        }
    }

    private static Rect a(float f10, float f11, float f12, int i10, int i11, boolean z10, int i12) {
        int i13 = (int) (((f10 / i10) * 2000.0f) - 1000.0f);
        int i14 = (int) (((f11 / i11) * 2000.0f) - 1000.0f);
        RectF rectF = new RectF(a(i13 - 150), a(i14 - 150), a(i13 + 150), a(i14 + 150));
        Matrix matrix = new Matrix();
        try {
            a(matrix, z10, i12);
            matrix.mapRect(rectF);
            return new Rect(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
        } catch (RuntimeException e2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CameraFocusManager::prepareMatrix failed: ");
            sb2.append(e2.getMessage());
            return null;
        }
    }

    public static void a(Matrix matrix, boolean z10, int i10) {
        if (matrix == null) {
            return;
        }
        Matrix matrix2 = new Matrix();
        try {
            matrix.reset();
            matrix2.setScale(z10 ? -1.0f : 1.0f, 1.0f);
            matrix2.postRotate(i10);
            matrix2.invert(matrix);
        } catch (RuntimeException e2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CameraFocusManager::prepareMatrix failed: ");
            sb2.append(e2.getMessage());
        }
    }

    private static int a(int i10) {
        if (i10 > 1000) {
            return 1000;
        }
        return Math.max(i10, -1000);
    }
}
