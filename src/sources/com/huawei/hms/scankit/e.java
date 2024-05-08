package com.huawei.hms.scankit;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.huawei.hms.feature.DynamicModuleInitializer;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.hmsscankit.DetailRect;
import com.huawei.hms.hmsscankit.api.IOnErrorCallback;
import com.huawei.hms.hmsscankit.api.IOnLightCallback;
import com.huawei.hms.hmsscankit.api.IOnResultCallback;
import com.huawei.hms.hmsscankit.api.IRemoteViewDelegate;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.scankit.p.e5;
import com.huawei.hms.scankit.p.o4;
import com.huawei.hms.scankit.p.r3;
import com.huawei.hms.scankit.p.r6;
import com.huawei.hms.scankit.p.w3;
import com.huawei.hms.scankit.p.w7;
import com.huawei.hms.scankit.util.OpencvJNI;
import java.util.Iterator;

/* compiled from: IRemoteCustomedViewDelegateImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class e extends IRemoteViewDelegate.Stub implements e5, SensorEventListener {

    /* renamed from: y, reason: collision with root package name */
    private static final String f30631y = e.class.getSimpleName();

    /* renamed from: z, reason: collision with root package name */
    public static boolean f30632z = false;

    /* renamed from: b, reason: collision with root package name */
    public int f30634b;

    /* renamed from: c, reason: collision with root package name */
    public Context f30635c;

    /* renamed from: d, reason: collision with root package name */
    public ProviderRemoteView f30636d;

    /* renamed from: e, reason: collision with root package name */
    public TextureView f30637e;

    /* renamed from: f, reason: collision with root package name */
    public com.huawei.hms.scankit.b f30638f;

    /* renamed from: g, reason: collision with root package name */
    public IOnResultCallback f30639g;

    /* renamed from: h, reason: collision with root package name */
    public SensorManager f30640h;

    /* renamed from: i, reason: collision with root package name */
    public View.OnClickListener f30641i;

    /* renamed from: l, reason: collision with root package name */
    public Boolean f30644l;

    /* renamed from: m, reason: collision with root package name */
    public AlertDialog f30645m;

    /* renamed from: n, reason: collision with root package name */
    public Rect f30646n;

    /* renamed from: o, reason: collision with root package name */
    private IObjectWrapper f30647o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f30648p;

    /* renamed from: q, reason: collision with root package name */
    private OrientationEventListener f30649q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f30650r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f30651s;

    /* renamed from: v, reason: collision with root package name */
    public IOnLightCallback f30654v;

    /* renamed from: w, reason: collision with root package name */
    public LinearLayout f30655w;

    /* renamed from: a, reason: collision with root package name */
    private volatile w3 f30633a = null;

    /* renamed from: j, reason: collision with root package name */
    public boolean f30642j = false;

    /* renamed from: k, reason: collision with root package name */
    public final Float f30643k = Float.valueOf(40.0f);

    /* renamed from: t, reason: collision with root package name */
    public boolean f30652t = true;

    /* renamed from: u, reason: collision with root package name */
    private Point f30653u = null;

    /* renamed from: x, reason: collision with root package name */
    public boolean f30656x = false;

    /* compiled from: IRemoteCustomedViewDelegateImpl.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            e.this.f30638f.b(motionEvent);
            return true;
        }
    }

    /* compiled from: IRemoteCustomedViewDelegateImpl.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class b extends OrientationEventListener {
        public b(Context context) {
            super(context);
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i10) {
            int rotation = ((Activity) e.this.f30635c).getWindowManager().getDefaultDisplay().getRotation();
            boolean b4 = w7.b();
            boolean e2 = w7.e();
            if (w7.e(e.this.f30635c) && !b4) {
                e.this.a(90);
                return;
            }
            if (w7.b((Activity) e.this.f30635c) && !e2) {
                e.this.a(90);
                return;
            }
            if (rotation == 0) {
                e.this.a(90);
                return;
            }
            if (rotation == 1) {
                e.this.a(0);
            } else if (rotation == 2) {
                e.this.a(270);
            } else {
                if (rotation != 3) {
                    return;
                }
                e.this.a(180);
            }
        }
    }

    /* compiled from: IRemoteCustomedViewDelegateImpl.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.f30645m.dismiss();
        }
    }

    public e(Context context, int i10, Object obj, IObjectWrapper iObjectWrapper, boolean z10, boolean z11, boolean z12) {
        this.f30634b = 0;
        this.f30648p = false;
        this.f30635c = context;
        this.f30634b = i10;
        this.f30647o = iObjectWrapper;
        if (obj instanceof Rect) {
            this.f30646n = (Rect) obj;
        } else {
            this.f30646n = null;
        }
        this.f30648p = z10;
        this.f30650r = z11;
        this.f30651s = z12;
    }

    public void b(Point point, boolean z10) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f30637e.getLayoutParams();
        float f10 = point.x;
        float f11 = point.y;
        boolean b4 = w7.b();
        o4.d(f30631y, "initSurfaceViewSize: isPortraitScreen: " + w7.c((Activity) this.f30635c) + " inMultiWindow: " + w7.f(this.f30635c) + " isInMultiWindowFreeform: " + w7.b((Activity) this.f30635c) + " isPadOrFold: " + w7.j(this.f30635c) + " isFoldStateExpand: " + w7.h(this.f30635c) + " isPad: " + w7.i(this.f30635c) + " inMagicWindow: " + w7.e(this.f30635c) + " ignore: " + b4 + " screen: " + point.toString() + " width: " + layoutParams.width + " height: " + layoutParams.height + " inMagicWindow " + w7.e(this.f30635c) + " ignore " + b4 + " isInit " + z10 + " isSpecialExpectSize " + this.f30638f.b());
        if (!w7.c((Activity) this.f30635c) && (!w7.e(this.f30635c) || (w7.e(this.f30635c) && b4))) {
            f30632z = true;
            float f12 = 1920.0f;
            float f13 = 1080.0f;
            float f14 = 1280.0f;
            if (z10 && (w7.f(this.f30635c) || w7.b((Activity) this.f30635c) || w7.e(this.f30635c))) {
                f12 = 1280.0f;
                f13 = 1280.0f;
            }
            if (this.f30638f.b()) {
                f13 = 1280.0f;
            } else {
                f14 = f12;
            }
            float f15 = f10 / f14;
            float f16 = f11 / f13;
            if (f15 > f16) {
                layoutParams.width = -1;
                layoutParams.height = (int) (f13 * f15);
                layoutParams.gravity = 17;
            } else {
                layoutParams.height = -1;
                layoutParams.width = (int) (f14 * f16);
                layoutParams.gravity = 17;
            }
        } else {
            f30632z = false;
            int i10 = 1080;
            int i11 = 1920;
            int i12 = 1280;
            if ("ceres-c3".equals(Build.DEVICE)) {
                i10 = 1280;
                i11 = 1280;
            }
            if (z10 && (w7.f(this.f30635c) || w7.b((Activity) this.f30635c) || w7.e(this.f30635c))) {
                i10 = 1280;
                i11 = 1280;
            }
            if (this.f30638f.b()) {
                i11 = 1280;
            } else {
                i12 = i10;
            }
            float f17 = i12;
            float f18 = f10 / f17;
            float f19 = i11;
            float f20 = f11 / f19;
            if (f18 > f20) {
                layoutParams.width = -1;
                layoutParams.height = (int) (f19 * f18);
                layoutParams.gravity = 17;
            } else {
                layoutParams.height = -1;
                layoutParams.width = (int) (f17 * f20);
                layoutParams.gravity = 17;
            }
        }
        this.f30637e.setLayoutParams(layoutParams);
    }

    public void c() {
        Object systemService = this.f30635c.getSystemService("sensor");
        if (systemService instanceof SensorManager) {
            SensorManager sensorManager = (SensorManager) systemService;
            this.f30640h = sensorManager;
            Iterator<Sensor> iterator2 = sensorManager.getSensorList(-1).iterator2();
            while (iterator2.hasNext()) {
                if (5 == iterator2.next().getType()) {
                    this.f30642j = true;
                    return;
                }
            }
        }
    }

    public ProviderRemoteView d() {
        return new ProviderRemoteView(DynamicModuleInitializer.getContext() == null ? this.f30635c : DynamicModuleInitializer.getContext(), true);
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public HmsScan[] decodeWithBitmap(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Bundle bundle;
        boolean z10;
        boolean z11;
        boolean z12;
        if (!r3.A) {
            OpencvJNI.init();
        }
        if (iObjectWrapper2 != null && (ObjectWrapper.unwrap(iObjectWrapper2) instanceof Bundle)) {
            bundle = (Bundle) ObjectWrapper.unwrap(iObjectWrapper2);
        } else {
            bundle = new Bundle();
        }
        if (iObjectWrapper2 == null || !(ObjectWrapper.unwrap(iObjectWrapper2) instanceof Bundle)) {
            z10 = false;
            z11 = false;
            z12 = true;
        } else {
            z10 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getBoolean(DetailRect.USE_APK, false);
            z11 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getBoolean(DetailRect.SUPPORT_ROLLBACK, false);
            z12 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getBoolean(DetailRect.PARSE_RESULT, true);
        }
        r3.f31451f = z12;
        if (z11 && !r3.f31446a && z10) {
            return new HmsScan[]{r6.b()};
        }
        if (this.f30633a == null) {
            try {
                this.f30633a = new w3(bundle, DetailRect.PHOTO_MODE);
            } catch (RuntimeException unused) {
                o4.b(f30631y, "RuntimeException");
            } catch (Exception unused2) {
                o4.b(f30631y, "Exception");
            }
        }
        return a(iObjectWrapper, iObjectWrapper2);
    }

    public void e() {
        ProviderRemoteView d10 = d();
        this.f30636d = d10;
        this.f30637e = (TextureView) d10.findViewById(R.id.surfaceView);
        com.huawei.hms.scankit.b bVar = new com.huawei.hms.scankit.b(this.f30635c, this.f30637e, null, this.f30646n, this.f30634b, this.f30647o, this.f30648p, "CustomizedView", true);
        this.f30638f = bVar;
        bVar.b(this.f30651s);
        c();
        a((Point) null, true);
    }

    public void f() {
        try {
            com.huawei.hms.scankit.b bVar = this.f30638f;
            if (bVar == null || bVar.a() == null) {
                return;
            }
            this.f30638f.a().a("off");
        } catch (RuntimeException unused) {
            o4.b(f30631y, "offFlashRuntimeException");
        } catch (Exception unused2) {
            o4.b(f30631y, "offFlashException");
        }
    }

    public void g() {
        try {
            com.huawei.hms.scankit.b bVar = this.f30638f;
            if (bVar == null || bVar.a() == null) {
                return;
            }
            this.f30638f.a().a("torch");
        } catch (RuntimeException unused) {
            o4.b(f30631y, "openFlashRuntimeException");
        } catch (Exception unused2) {
            o4.b(f30631y, "openFlashException");
        }
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public boolean getLightStatus() throws RemoteException {
        return b();
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public IObjectWrapper getView() {
        return ObjectWrapper.wrap(this.f30636d);
    }

    public void h() {
        AlertDialog create = new AlertDialog.Builder(this.f30635c).create();
        this.f30645m = create;
        create.show();
        View inflate = LayoutInflater.from(DynamicModuleInitializer.getContext() == null ? this.f30635c : DynamicModuleInitializer.getContext()).inflate(R.layout.scankit_dialog_layout, (ViewGroup) null);
        Window window = this.f30645m.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.f817y = 60;
        window.setAttributes(attributes);
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setContentView(inflate);
        window.setGravity(80);
        inflate.findViewById(R.id.dialog_sure_btn).setOnClickListener(new c());
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i10) {
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void onCreate(Bundle bundle) {
        Context context = this.f30635c;
        if ((context instanceof Activity) && ((Activity) context).getWindow() != null) {
            ((Activity) this.f30635c).getWindow().setFlags(16777216, 16777216);
        }
        Context context2 = this.f30635c;
        if (context2 != null && context2.getPackageManager() != null) {
            this.f30652t = this.f30635c.getPackageManager().hasSystemFeature("android.hardware.camera.flash");
            o4.d("Scankit", "initlight hasFlash " + this.f30652t);
        }
        e();
        this.f30638f.a(this);
        this.f30636d.setOnTouchListener(new a());
        IOnResultCallback iOnResultCallback = this.f30639g;
        if (iOnResultCallback != null) {
            this.f30638f.a(iOnResultCallback);
        }
        this.f30638f.a(this.f30650r);
        this.f30638f.c();
        if (Build.VERSION.SDK_INT >= 24) {
            b bVar = new b(this.f30635c);
            this.f30649q = bVar;
            if (bVar.canDetectOrientation()) {
                this.f30649q.enable();
            } else {
                this.f30649q.disable();
            }
        }
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void onDestroy() {
        try {
            this.f30638f.d();
            OrientationEventListener orientationEventListener = this.f30649q;
            if (orientationEventListener != null && orientationEventListener.canDetectOrientation()) {
                this.f30649q.disable();
            }
            if (this.f30635c != null) {
                this.f30635c = null;
            }
            AlertDialog alertDialog = this.f30645m;
            if (alertDialog == null || !alertDialog.isShowing()) {
                return;
            }
            this.f30645m.dismiss();
            this.f30645m = null;
        } catch (RuntimeException unused) {
            o4.b(f30631y, "onDestroyRuntimeException");
        } catch (Exception unused2) {
            o4.b(f30631y, "onDestroyException");
        }
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void onPause() {
        try {
            this.f30638f.e();
            this.f30640h.unregisterListener(this);
        } catch (RuntimeException unused) {
            o4.b(f30631y, "onPauseRuntimeException");
        } catch (Exception unused2) {
            o4.b(f30631y, "onPauseException");
        }
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void onResume() {
        try {
            this.f30638f.f();
            SensorManager sensorManager = this.f30640h;
            sensorManager.registerListener(this, sensorManager.getDefaultSensor(5), 2);
        } catch (RuntimeException unused) {
            o4.b(f30631y, "onResumeRuntimeException");
        } catch (Exception unused2) {
            o4.b(f30631y, "onResumeException");
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (this.f30642j && sensorEvent.sensor.getType() == 5 && this.f30652t) {
            Boolean valueOf = Boolean.valueOf(sensorEvent.values[0] > this.f30643k.floatValue());
            this.f30644l = valueOf;
            if (valueOf.booleanValue()) {
                if (sensorEvent.values[0] > 600.0f) {
                    if (this.f30655w != null && !b()) {
                        this.f30655w.setVisibility(8);
                    }
                    IOnLightCallback iOnLightCallback = this.f30654v;
                    if (iOnLightCallback != null) {
                        try {
                            iOnLightCallback.onVisibleChanged(false);
                            return;
                        } catch (RemoteException unused) {
                            o4.e(f30631y, "onSensorChanged RemoteException");
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            if (w7.a(this.f30635c)) {
                if (this.f30655w != null) {
                    o4.d("Scankit", "initlight onSensorChanged open");
                    this.f30655w.setVisibility(0);
                }
                IOnLightCallback iOnLightCallback2 = this.f30654v;
                if (iOnLightCallback2 != null) {
                    try {
                        iOnLightCallback2.onVisibleChanged(true);
                    } catch (RemoteException unused2) {
                        o4.e(f30631y, "onSensorChanged RemoteException");
                    }
                }
            }
        }
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void onStart() {
        try {
            this.f30638f.g();
        } catch (RuntimeException unused) {
            o4.b(f30631y, "onStartRuntimeException");
        } catch (Exception unused2) {
            o4.b(f30631y, "onStartException");
        }
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void onStop() {
        try {
            this.f30638f.h();
        } catch (RuntimeException unused) {
            o4.b(f30631y, "onStopRuntimeException");
        } catch (Exception unused2) {
            o4.b(f30631y, "onStopException");
        }
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void pauseContinuouslyScan() throws RemoteException {
        com.huawei.hms.scankit.b bVar = this.f30638f;
        if (bVar != null) {
            bVar.i();
        }
        this.f30656x = true;
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void resumeContinuouslyScan() throws RemoteException {
        this.f30656x = false;
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void setOnClickListener(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper != null) {
            this.f30641i = (View.OnClickListener) ObjectWrapper.unwrap(iObjectWrapper);
        }
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void setOnErrorCallback(IOnErrorCallback iOnErrorCallback) throws RemoteException {
        com.huawei.hms.scankit.b bVar = this.f30638f;
        if (bVar != null) {
            bVar.a(iOnErrorCallback);
        }
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void setOnLightVisbleCallBack(IOnLightCallback iOnLightCallback) throws RemoteException {
        this.f30654v = iOnLightCallback;
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void setOnResultCallback(IOnResultCallback iOnResultCallback) {
        this.f30639g = iOnResultCallback;
        com.huawei.hms.scankit.b bVar = this.f30638f;
        if (bVar != null) {
            bVar.a(iOnResultCallback);
        }
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void turnOffLight() throws RemoteException {
        f();
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void turnOnLight() throws RemoteException {
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i10) {
        com.huawei.hms.scankit.b bVar = this.f30638f;
        if (bVar == null || bVar.a() == null) {
            return;
        }
        try {
            Point a10 = a(this.f30635c);
            if (i10 != this.f30638f.a().d()) {
                this.f30638f.a().b(i10);
            }
            if (this.f30638f.a().i()) {
                Point point = this.f30653u;
                if (point == null || point.x != a10.x) {
                    a(a10, false);
                }
            }
        } catch (NullPointerException unused) {
            o4.e(f30631y, "adjustCameraOrientation: nullpoint");
        } catch (Exception unused2) {
            o4.e(f30631y, "adjustCameraOrientation: Exception");
        }
    }

    private static Point a(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (!w7.f(context) && !w7.e(context)) {
            defaultDisplay.getRealSize(point);
        } else {
            defaultDisplay.getSize(point);
        }
        return point;
    }

    public void a(Point point, boolean z10) {
        try {
            if (this.f30635c.getSystemService("window") != null) {
                if (point == null) {
                    point = a(this.f30635c);
                }
                this.f30653u = point;
                b(point, z10);
            }
        } catch (NullPointerException unused) {
            o4.e(f30631y, "initSurfaceView: nullpoint");
        } catch (Exception unused2) {
            o4.e(f30631y, "initSurfaceView: Exception");
        }
    }

    @Override // com.huawei.hms.scankit.p.e5
    public boolean a(HmsScan[] hmsScanArr) {
        AlertDialog alertDialog;
        if (hmsScanArr == null || hmsScanArr.length <= 0 || (alertDialog = this.f30645m) == null || !alertDialog.isShowing()) {
            return false;
        }
        this.f30645m.dismiss();
        return false;
    }

    @Override // com.huawei.hms.scankit.p.e5
    public boolean a() {
        return this.f30656x;
    }

    private HmsScan[] a(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        boolean z10;
        int i10;
        if (iObjectWrapper == null) {
            o4.b("ScankitRemoteS", "bitmap is null");
            return new HmsScan[0];
        }
        if (iObjectWrapper2 == null || !(ObjectWrapper.unwrap(iObjectWrapper2) instanceof Bundle)) {
            z10 = false;
            i10 = 0;
        } else {
            i10 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getInt(DetailRect.FORMAT_FLAG);
            int i11 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getInt(DetailRect.TYPE_TRANS, 0);
            DetailRect.HMSSCAN_SDK_VALUE = i11;
            z10 = i11 >= 2;
            if (z10) {
                i10 = w7.b(i10);
            }
        }
        HmsScan[] b4 = r6.a().b((Bitmap) ObjectWrapper.unwrap(iObjectWrapper), i10, true, this.f30633a);
        if (!z10) {
            b4 = w7.a(b4);
        }
        if (b4.length == 0) {
            h();
        } else if (b4[0] != null && TextUtils.isEmpty(b4[0].originalValue)) {
            h();
        }
        return b4;
    }

    public boolean b() {
        try {
            return this.f30638f.a().h().equals("torch");
        } catch (RuntimeException unused) {
            o4.b(f30631y, "getFlashStatusRuntimeException");
            return false;
        } catch (Exception unused2) {
            o4.b(f30631y, "getFlashStatusException");
            return false;
        }
    }
}
