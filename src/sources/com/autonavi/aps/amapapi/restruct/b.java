package com.autonavi.aps.amapapi.restruct;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import com.alimm.tanx.core.utils.LandingPageUtHelper;
import com.google.android.material.shadow.ShadowDrawableWrapper;

/* compiled from: AmapSensorManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class b implements SensorEventListener {

    /* renamed from: a, reason: collision with root package name */
    public SensorManager f9408a;

    /* renamed from: b, reason: collision with root package name */
    public Sensor f9409b;

    /* renamed from: c, reason: collision with root package name */
    public Sensor f9410c;

    /* renamed from: d, reason: collision with root package name */
    public Sensor f9411d;

    /* renamed from: s, reason: collision with root package name */
    private Context f9426s;

    /* renamed from: e, reason: collision with root package name */
    public boolean f9412e = false;

    /* renamed from: f, reason: collision with root package name */
    public double f9413f = ShadowDrawableWrapper.COS_45;

    /* renamed from: g, reason: collision with root package name */
    public float f9414g = 0.0f;

    /* renamed from: t, reason: collision with root package name */
    private float f9427t = 1013.25f;

    /* renamed from: u, reason: collision with root package name */
    private float f9428u = 0.0f;

    /* renamed from: h, reason: collision with root package name */
    public Handler f9415h = new Handler();

    /* renamed from: i, reason: collision with root package name */
    public double f9416i = ShadowDrawableWrapper.COS_45;

    /* renamed from: j, reason: collision with root package name */
    public double f9417j = ShadowDrawableWrapper.COS_45;

    /* renamed from: k, reason: collision with root package name */
    public double f9418k = ShadowDrawableWrapper.COS_45;

    /* renamed from: l, reason: collision with root package name */
    public double f9419l = ShadowDrawableWrapper.COS_45;

    /* renamed from: m, reason: collision with root package name */
    public double[] f9420m = new double[3];

    /* renamed from: n, reason: collision with root package name */
    public volatile double f9421n = ShadowDrawableWrapper.COS_45;

    /* renamed from: o, reason: collision with root package name */
    public long f9422o = 0;

    /* renamed from: p, reason: collision with root package name */
    public long f9423p = 0;

    /* renamed from: q, reason: collision with root package name */
    public final int f9424q = 100;

    /* renamed from: r, reason: collision with root package name */
    public final int f9425r = 30;

    public b(Context context) {
        this.f9426s = null;
        this.f9408a = null;
        this.f9409b = null;
        this.f9410c = null;
        this.f9411d = null;
        try {
            this.f9426s = context;
            if (this.f9408a == null) {
                this.f9408a = (SensorManager) context.getSystemService("sensor");
            }
            try {
                this.f9409b = this.f9408a.getDefaultSensor(6);
            } catch (Throwable unused) {
            }
            try {
                this.f9410c = this.f9408a.getDefaultSensor(11);
            } catch (Throwable unused2) {
            }
            try {
                this.f9411d = this.f9408a.getDefaultSensor(1);
            } catch (Throwable unused3) {
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "AMapSensorManager", "<init>");
        }
    }

    public final void a() {
        SensorManager sensorManager = this.f9408a;
        if (sensorManager == null || this.f9412e) {
            return;
        }
        this.f9412e = true;
        try {
            Sensor sensor = this.f9409b;
            if (sensor != null) {
                sensorManager.registerListener(this, sensor, 3, this.f9415h);
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "AMapSensorManager", "registerListener mPressure");
        }
        try {
            Sensor sensor2 = this.f9410c;
            if (sensor2 != null) {
                this.f9408a.registerListener(this, sensor2, 3, this.f9415h);
            }
        } catch (Throwable th2) {
            com.autonavi.aps.amapapi.utils.b.a(th2, "AMapSensorManager", "registerListener mRotationVector");
        }
        try {
            Sensor sensor3 = this.f9411d;
            if (sensor3 != null) {
                this.f9408a.registerListener(this, sensor3, 3, this.f9415h);
            }
        } catch (Throwable th3) {
            com.autonavi.aps.amapapi.utils.b.a(th3, "AMapSensorManager", "registerListener mAcceleroMeterVector");
        }
    }

    public final void b() {
        SensorManager sensorManager = this.f9408a;
        if (sensorManager == null || !this.f9412e) {
            return;
        }
        this.f9412e = false;
        try {
            Sensor sensor = this.f9409b;
            if (sensor != null) {
                sensorManager.unregisterListener(this, sensor);
            }
        } catch (Throwable unused) {
        }
        try {
            Sensor sensor2 = this.f9410c;
            if (sensor2 != null) {
                this.f9408a.unregisterListener(this, sensor2);
            }
        } catch (Throwable unused2) {
        }
        try {
            Sensor sensor3 = this.f9411d;
            if (sensor3 != null) {
                this.f9408a.unregisterListener(this, sensor3);
            }
        } catch (Throwable unused3) {
        }
    }

    public final double c() {
        return this.f9413f;
    }

    public final float d() {
        return this.f9428u;
    }

    public final double e() {
        return this.f9419l;
    }

    public final void f() {
        try {
            b();
            this.f9409b = null;
            this.f9410c = null;
            this.f9408a = null;
            this.f9411d = null;
            this.f9412e = false;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "AMapSensorManager", LandingPageUtHelper.XAD_UT_LP_DESTROY);
        }
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i10) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent == null) {
            return;
        }
        try {
            int type = sensorEvent.sensor.getType();
            if (type == 1) {
                if (this.f9411d != null) {
                    a((float[]) sensorEvent.values.clone());
                }
            } else {
                if (type != 6) {
                    if (type != 11) {
                        return;
                    }
                    try {
                        if (this.f9410c != null) {
                            c((float[]) sensorEvent.values.clone());
                            return;
                        }
                        return;
                    } catch (Throwable unused) {
                        return;
                    }
                }
                try {
                    if (this.f9409b != null) {
                        float[] fArr = (float[]) sensorEvent.values.clone();
                        this.f9414g = fArr[0];
                        b(fArr);
                    }
                } catch (Throwable unused2) {
                }
            }
        } catch (Throwable unused3) {
        }
    }

    private void c(float[] fArr) {
        if (fArr != null) {
            float[] fArr2 = new float[9];
            SensorManager.getRotationMatrixFromVector(fArr2, fArr);
            SensorManager.getOrientation(fArr2, new float[3]);
            float degrees = (float) Math.toDegrees(r3[0]);
            this.f9428u = degrees;
            if (degrees <= 0.0f) {
                degrees += 360.0f;
            }
            this.f9428u = (float) Math.floor(degrees);
        }
    }

    private void b(float[] fArr) {
        if (fArr != null) {
            this.f9413f = com.autonavi.aps.amapapi.utils.j.a(SensorManager.getAltitude(this.f9427t, fArr[0]));
        }
    }

    private void a(float[] fArr) {
        double[] dArr = this.f9420m;
        dArr[0] = (dArr[0] * 0.800000011920929d) + (fArr[0] * 0.19999999f);
        dArr[1] = (dArr[1] * 0.800000011920929d) + (fArr[1] * 0.19999999f);
        dArr[2] = (dArr[2] * 0.800000011920929d) + (fArr[2] * 0.19999999f);
        this.f9416i = fArr[0] - dArr[0];
        this.f9417j = fArr[1] - dArr[1];
        this.f9418k = fArr[2] - dArr[2];
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f9422o < 100) {
            return;
        }
        double d10 = this.f9416i;
        double d11 = this.f9417j;
        double d12 = (d10 * d10) + (d11 * d11);
        double d13 = this.f9418k;
        double sqrt = Math.sqrt(d12 + (d13 * d13));
        this.f9423p++;
        this.f9422o = currentTimeMillis;
        this.f9421n += sqrt;
        if (this.f9423p >= 30) {
            this.f9419l = this.f9421n / this.f9423p;
            this.f9421n = ShadowDrawableWrapper.COS_45;
            this.f9423p = 0L;
        }
    }
}
