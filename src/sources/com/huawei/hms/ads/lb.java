package com.huawei.hms.ads;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class lb implements SensorEventListener {
    private static final String Code = "RotateDetector";
    private final float[] B;
    private float[] C = new float[3];
    private Sensor I;
    private SensorManager V;
    private a Z;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface a {
        void Code(double d10, double d11, double d12);
    }

    public lb(Context context) {
        float[] fArr = new float[16];
        this.B = fArr;
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        this.V = sensorManager;
        this.I = sensorManager.getDefaultSensor(15);
        fArr[0] = 1.0f;
        fArr[4] = 1.0f;
        fArr[8] = 1.0f;
        fArr[12] = 1.0f;
    }

    public void Code() {
        this.V.registerListener(this, this.I, 3);
    }

    public void Code(a aVar) {
        this.Z = aVar;
    }

    public void V() {
        try {
            this.V.unregisterListener(this, this.I);
        } catch (Throwable th) {
            gl.I(Code, "unregister err: %s", th.getClass().getSimpleName());
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i10) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 15) {
            SensorManager.getRotationMatrixFromVector(this.B, sensorEvent.values);
            SensorManager.getOrientation(this.B, this.C);
            double degrees = Math.toDegrees(this.C[0]);
            double degrees2 = Math.toDegrees(this.C[1]);
            double degrees3 = Math.toDegrees(this.C[2]);
            gl.Code(Code, "degree x: " + degrees2 + " y: " + degrees3 + " z: " + degrees);
            a aVar = this.Z;
            if (aVar != null) {
                aVar.Code(degrees2, degrees3, degrees);
            }
        }
    }
}
