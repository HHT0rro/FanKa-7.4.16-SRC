package com.alibaba.security.biometrics.service.build;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

/* compiled from: ABShakeListener.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class d implements SensorEventListener {

    /* renamed from: c, reason: collision with root package name */
    private static final int f2695c = 70;

    /* renamed from: a, reason: collision with root package name */
    public boolean f2696a;

    /* renamed from: b, reason: collision with root package name */
    private int f2697b = 1000;

    /* renamed from: d, reason: collision with root package name */
    private Context f2698d;

    /* renamed from: e, reason: collision with root package name */
    private float f2699e;

    /* renamed from: f, reason: collision with root package name */
    private float f2700f;

    /* renamed from: g, reason: collision with root package name */
    private float f2701g;

    /* renamed from: h, reason: collision with root package name */
    private long f2702h;

    public d(Context context) {
        this.f2698d = context;
    }

    private boolean a() {
        return this.f2696a;
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i10) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        long currentTimeMillis = System.currentTimeMillis();
        long j10 = currentTimeMillis - this.f2702h;
        if (j10 < 70) {
            return;
        }
        this.f2702h = currentTimeMillis;
        float[] fArr = sensorEvent.values;
        float f10 = fArr[0];
        float f11 = fArr[1];
        float f12 = fArr[2];
        float f13 = f10 - this.f2699e;
        float f14 = f11 - this.f2700f;
        float f15 = f12 - this.f2701g;
        this.f2699e = f10;
        this.f2700f = f11;
        this.f2701g = f12;
        double sqrt = (Math.sqrt(((f13 * f13) + (f14 * f14)) + (f15 * f15)) / j10) * 10000.0d;
        this.f2696a = false;
        if (sqrt >= this.f2697b) {
            this.f2696a = true;
        }
    }
}
