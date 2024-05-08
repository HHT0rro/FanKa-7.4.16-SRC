package com.alibaba.security.biometrics.service.build;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/* compiled from: ABSensorManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class c {

    /* renamed from: i, reason: collision with root package name */
    private static final String f2683i = "ABSensorManager";

    /* renamed from: a, reason: collision with root package name */
    public t f2684a;

    /* renamed from: b, reason: collision with root package name */
    public Context f2685b;

    /* renamed from: c, reason: collision with root package name */
    public SensorManager f2686c;

    /* renamed from: d, reason: collision with root package name */
    public Sensor f2687d;

    /* renamed from: e, reason: collision with root package name */
    public Sensor f2688e;

    /* renamed from: f, reason: collision with root package name */
    public SensorEventListener f2689f = new SensorEventListener() { // from class: com.alibaba.security.biometrics.service.build.c.1
        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor sensor, int i10) {
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
            t tVar;
            if (sensorEvent != null) {
                try {
                    Sensor sensor = sensorEvent.sensor;
                    if (sensor == null || sensor.getType() == 15) {
                        return;
                    }
                    if (sensorEvent.sensor.getType() == 1) {
                        t tVar2 = c.this.f2684a;
                        if (tVar2 != null) {
                            tVar2.a(sensorEvent);
                            return;
                        }
                        return;
                    }
                    if (sensorEvent.sensor.getType() == 10 || sensorEvent.sensor.getType() == 4 || sensorEvent.sensor.getType() == 16 || sensorEvent.sensor.getType() == 11 || sensorEvent.sensor.getType() == 9 || sensorEvent.sensor.getType() != 5 || (tVar = c.this.f2684a) == null) {
                        return;
                    }
                    tVar.a(sensorEvent.values[0]);
                } catch (Throwable unused) {
                }
            }
        }
    };

    /* renamed from: g, reason: collision with root package name */
    public SensorEventListener f2690g = new SensorEventListener() { // from class: com.alibaba.security.biometrics.service.build.c.2
        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor sensor, int i10) {
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
            Sensor sensor;
            t tVar;
            if (sensorEvent == null || (sensor = sensorEvent.sensor) == null || sensor.getType() == 15) {
                return;
            }
            if (sensorEvent.sensor.getType() == 1) {
                t tVar2 = c.this.f2684a;
                if (tVar2 != null) {
                    tVar2.a(sensorEvent);
                    return;
                }
                return;
            }
            if (sensorEvent.sensor.getType() == 10 || sensorEvent.sensor.getType() == 4 || sensorEvent.sensor.getType() == 16 || sensorEvent.sensor.getType() == 11 || sensorEvent.sensor.getType() == 9 || sensorEvent.sensor.getType() != 5 || (tVar = c.this.f2684a) == null) {
                return;
            }
            tVar.a(sensorEvent.values[0]);
        }
    };

    /* renamed from: h, reason: collision with root package name */
    public SensorEventListener f2691h = new SensorEventListener() { // from class: com.alibaba.security.biometrics.service.build.c.3
        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor sensor, int i10) {
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
            Sensor sensor;
            t tVar;
            if (sensorEvent == null || (sensor = sensorEvent.sensor) == null || sensor.getType() == 15) {
                return;
            }
            if (sensorEvent.sensor.getType() == 1) {
                t tVar2 = c.this.f2684a;
                if (tVar2 != null) {
                    tVar2.a(sensorEvent);
                    return;
                }
                return;
            }
            if (sensorEvent.sensor.getType() == 10 || sensorEvent.sensor.getType() == 4 || sensorEvent.sensor.getType() == 16 || sensorEvent.sensor.getType() == 11 || sensorEvent.sensor.getType() == 9 || sensorEvent.sensor.getType() != 5 || (tVar = c.this.f2684a) == null) {
                return;
            }
            tVar.a(sensorEvent.values[0]);
        }
    };

    public c(Context context, t tVar) {
        this.f2685b = context;
        this.f2684a = tVar;
    }

    private void b() {
        SensorManager sensorManager = this.f2686c;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this.f2689f);
            this.f2686c.unregisterListener(this.f2690g);
            this.f2686c.unregisterListener(this.f2691h);
        }
        this.f2686c = null;
        this.f2689f = null;
        this.f2690g = null;
        this.f2691h = null;
    }

    private void a() {
        SensorManager sensorManager = (SensorManager) this.f2685b.getSystemService("sensor");
        this.f2686c = sensorManager;
        if (sensorManager != null) {
            this.f2687d = sensorManager.getDefaultSensor(4);
            this.f2688e = this.f2686c.getDefaultSensor(5);
            this.f2686c.registerListener(this.f2690g, this.f2687d, 3);
            this.f2686c.registerListener(this.f2691h, this.f2688e, 3);
        }
    }
}
