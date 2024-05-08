package com.tencent.cloud.huiyansdkface.facelight.c.b;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.youtu.ytagreflectlivecheck.jni.YTAGReflectLiveCheckJNIInterface;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final String f40621a = "c";

    /* renamed from: b, reason: collision with root package name */
    private SensorManager f40622b;

    /* renamed from: c, reason: collision with root package name */
    private a f40623c;

    /* renamed from: d, reason: collision with root package name */
    private b f40624d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f40625e;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class a implements SensorEventListener {

        /* renamed from: b, reason: collision with root package name */
        private float f40627b;

        private a() {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i10) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.sensor.getType() == 5) {
                this.f40627b = sensorEvent.values[0];
                if (c.this.f40624d != null) {
                    c.this.f40624d.a(this.f40627b);
                }
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface b {
        void a(float f10);
    }

    /* renamed from: com.tencent.cloud.huiyansdkface.facelight.c.b.c$c, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class C0619c {

        /* renamed from: a, reason: collision with root package name */
        private static c f40628a = new c();
    }

    private c() {
        this.f40625e = false;
    }

    public static c a() {
        return C0619c.f40628a;
    }

    public int a(Context context, b bVar) {
        if (this.f40625e) {
            YTAGReflectLiveCheckJNIInterface.nativeLog("MicroMsg.LightSensor", "[SensorManagerWorker.start] light sensor has started");
            return 2;
        }
        this.f40625e = true;
        SensorManager sensorManager = (SensorManager) context.getApplicationContext().getSystemService("sensor");
        this.f40622b = sensorManager;
        Sensor defaultSensor = sensorManager.getDefaultSensor(5);
        if (defaultSensor == null) {
            YTAGReflectLiveCheckJNIInterface.nativeLog("MicroMsg.LightSensor", "[SensorManagerWorker.start] System do not have lightSensor");
            return 1;
        }
        a aVar = new a();
        this.f40623c = aVar;
        this.f40622b.registerListener(aVar, defaultSensor, 3);
        this.f40624d = bVar;
        return 0;
    }

    public float b() {
        if (this.f40623c == null) {
            return -1.0f;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Light lux: ");
        sb2.append(this.f40623c.f40627b);
        return this.f40623c.f40627b;
    }

    public void c() {
        SensorManager sensorManager;
        if (!this.f40625e || (sensorManager = this.f40622b) == null) {
            return;
        }
        this.f40625e = false;
        sensorManager.unregisterListener(this.f40623c);
    }
}
