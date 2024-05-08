package com.huawei.hms.ads;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class la implements SensorEventListener {
    private static final String Code = "PhoneAccelerometerDetec";
    private static final float V = 9.80665f;
    private a B;
    private SensorManager I;
    private Sensor Z;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface a {
        void Code(float f10, float f11, float f12);
    }

    public la(Context context) {
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        this.I = sensorManager;
        this.Z = sensorManager.getDefaultSensor(1);
    }

    public void Code() {
        Sensor sensor = this.Z;
        if (sensor != null) {
            this.I.registerListener(this, sensor, 2);
        }
    }

    public void Code(a aVar) {
        this.B = aVar;
    }

    public void V() {
        try {
            this.I.unregisterListener(this, this.Z);
        } catch (Throwable th) {
            gl.I(Code, "unregister err: %s", th.getClass().getSimpleName());
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i10) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (1 == sensorEvent.sensor.getType()) {
            float[] fArr = sensorEvent.values;
            float f10 = fArr[0];
            float f11 = fArr[1];
            float f12 = fArr[2];
            gl.Code(Code, "onSensorChanged x:" + f10 + " y:" + f11 + " z:" + f12);
            a aVar = this.B;
            if (aVar != null) {
                aVar.Code(f10, f11, f12);
            }
        }
    }
}
