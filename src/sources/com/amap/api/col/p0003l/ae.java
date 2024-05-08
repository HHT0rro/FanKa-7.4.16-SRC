package com.amap.api.col.p0003l;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.WindowManager;
import com.amap.api.maps.model.Marker;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

/* compiled from: SensorEventHelper.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ae implements SensorEventListener {

    /* renamed from: a, reason: collision with root package name */
    private SensorManager f4894a;

    /* renamed from: b, reason: collision with root package name */
    private Sensor f4895b;

    /* renamed from: c, reason: collision with root package name */
    private Sensor f4896c;

    /* renamed from: d, reason: collision with root package name */
    private Sensor f4897d;

    /* renamed from: e, reason: collision with root package name */
    private Context f4898e;

    /* renamed from: f, reason: collision with root package name */
    private IAMapDelegate f4899f;

    /* renamed from: g, reason: collision with root package name */
    private Marker f4900g;

    /* renamed from: h, reason: collision with root package name */
    private float f4901h;

    /* renamed from: i, reason: collision with root package name */
    private float[] f4902i = new float[3];

    /* renamed from: j, reason: collision with root package name */
    private float[] f4903j = new float[3];

    /* renamed from: k, reason: collision with root package name */
    private float[] f4904k = new float[3];

    /* renamed from: l, reason: collision with root package name */
    private float[] f4905l = new float[9];

    /* renamed from: m, reason: collision with root package name */
    private boolean f4906m = true;

    public ae(Context context, IAMapDelegate iAMapDelegate) {
        this.f4898e = context.getApplicationContext();
        this.f4899f = iAMapDelegate;
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            this.f4894a = sensorManager;
            if (sensorManager != null && c()) {
                this.f4895b = this.f4894a.getDefaultSensor(3);
            } else {
                this.f4896c = this.f4894a.getDefaultSensor(1);
                this.f4897d = this.f4894a.getDefaultSensor(2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private boolean c() {
        SensorManager sensorManager = this.f4894a;
        if (sensorManager == null) {
            return false;
        }
        for (Sensor sensor : sensorManager.getSensorList(-1)) {
            int type = sensor.getType();
            sensor.getStringType();
            if (type == 3) {
                return true;
            }
        }
        return false;
    }

    public final void a() {
        Sensor sensor;
        Sensor sensor2;
        SensorManager sensorManager = this.f4894a;
        if (sensorManager != null && (sensor2 = this.f4895b) != null) {
            sensorManager.registerListener(this, sensor2, 3);
        }
        SensorManager sensorManager2 = this.f4894a;
        if (sensorManager2 == null || (sensor = this.f4896c) == null || this.f4897d == null) {
            return;
        }
        sensorManager2.registerListener(this, sensor, 3);
        this.f4894a.registerListener(this, this.f4897d, 3);
    }

    public final void b() {
        Sensor sensor;
        Sensor sensor2;
        SensorManager sensorManager = this.f4894a;
        if (sensorManager != null && (sensor2 = this.f4895b) != null) {
            sensorManager.unregisterListener(this, sensor2);
        }
        SensorManager sensorManager2 = this.f4894a;
        if (sensorManager2 == null || (sensor = this.f4896c) == null || this.f4897d == null) {
            return;
        }
        sensorManager2.unregisterListener(this, sensor);
        this.f4894a.unregisterListener(this, this.f4897d);
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i10) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        try {
            if (this.f4899f.getGLMapEngine() == null || this.f4899f.getGLMapEngine().getAnimateionsCount() <= 0) {
                int type = sensorEvent.sensor.getType();
                if (type == 3) {
                    float f10 = sensorEvent.values[0];
                    float a10 = a(f10);
                    if (Math.abs(this.f4901h - f10) < 3.0f) {
                        return;
                    }
                    this.f4901h = a10;
                    c(a10);
                    return;
                }
                if (type == 1) {
                    this.f4902i = (float[]) sensorEvent.values.clone();
                } else if (type == 2) {
                    this.f4903j = (float[]) sensorEvent.values.clone();
                }
                float a11 = a(this.f4902i, this.f4903j);
                if (Math.abs(this.f4901h - a11) < 3.0f) {
                    return;
                }
                this.f4901h = a11;
                c(a11);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private float b(float f10) {
        float a10 = (f10 + a(this.f4898e)) % 360.0f;
        if (a10 > 180.0f) {
            a10 -= 360.0f;
        } else if (a10 < -180.0f) {
            a10 += 360.0f;
        }
        if (Float.isNaN(a10)) {
            return 0.0f;
        }
        return a10;
    }

    private void c(float f10) {
        Marker marker = this.f4900g;
        if (marker != null) {
            try {
                if (this.f4906m) {
                    this.f4899f.moveCamera(al.d(f10));
                    this.f4900g.setRotateAngle(-f10);
                } else {
                    marker.setRotateAngle(360.0f - f10);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void a(Marker marker) {
        this.f4900g = marker;
    }

    public final void a(boolean z10) {
        this.f4906m = z10;
    }

    private float a(float f10) {
        return b(f10);
    }

    private float a(float[] fArr, float[] fArr2) {
        if (!SensorManager.getRotationMatrix(this.f4905l, null, fArr, fArr2)) {
            return 0.0f;
        }
        SensorManager.getOrientation(this.f4905l, this.f4904k);
        this.f4904k[0] = (float) Math.toDegrees(r3[0]);
        return this.f4904k[0];
    }

    private static int a(Context context) {
        WindowManager windowManager;
        if (context == null || (windowManager = (WindowManager) context.getSystemService("window")) == null) {
            return 0;
        }
        try {
            int rotation = windowManager.getDefaultDisplay().getRotation();
            if (rotation == 1) {
                return 90;
            }
            if (rotation != 2) {
                return rotation != 3 ? 0 : -90;
            }
            return 180;
        } catch (Throwable unused) {
            return 0;
        }
    }
}
