package l9;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.huawei.appgallery.agd.common.application.ApplicationWrapper;

/* compiled from: ShakeSensorUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class c implements SensorEventListener {

    /* renamed from: b, reason: collision with root package name */
    public SensorManager f51683b;

    /* renamed from: c, reason: collision with root package name */
    public b f51684c;

    /* compiled from: ShakeSensorUtils.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface b {
        void onShake();
    }

    /* compiled from: ShakeSensorUtils.java */
    /* renamed from: l9.c$c, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class C0788c {

        /* renamed from: a, reason: collision with root package name */
        public static final c f51685a = new c(ApplicationWrapper.getInstance().getContext());
    }

    public static c a() {
        return C0788c.f51685a;
    }

    public final void b() {
        SensorManager sensorManager = this.f51683b;
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(1), 3);
    }

    public void c(b bVar) {
        this.f51684c = bVar;
        b();
    }

    public void d() {
        this.f51683b.unregisterListener(this);
        this.f51684c = null;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i10) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        int type = sensorEvent.sensor.getType();
        float[] fArr = sensorEvent.values;
        if (type == 1) {
            if (Math.abs(fArr[0]) > 14.0f || Math.abs(fArr[1]) > 14.0f || Math.abs(fArr[2]) > 14.0f) {
                j9.a.f50348d.i("ShakeSensorUtils", "sensor value ==  " + fArr[0] + " " + fArr[1] + " " + fArr[2]);
                b bVar = this.f51684c;
                if (bVar != null) {
                    bVar.onShake();
                }
            }
        }
    }

    public c(Context context) {
        this.f51683b = null;
        this.f51684c = null;
        this.f51683b = (SensorManager) context.getSystemService("sensor");
    }
}
