package cn.shuzilm.core;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class d implements SensorEventListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f1726a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SensorManager f1727b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ DUHelper f1728c;

    public d(DUHelper dUHelper, Context context, SensorManager sensorManager) {
        this.f1728c = dUHelper;
        this.f1726a = context;
        this.f1727b = sensorManager;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i10) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        try {
            float[] fArr = sensorEvent.values;
            sensorEvent.sensor.getType();
            for (float f10 : fArr) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(f10);
                sb2.append("");
            }
            DUHelper.onSensorChanged(this.f1726a, sensorEvent);
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        }
        this.f1727b.unregisterListener(this);
    }
}
