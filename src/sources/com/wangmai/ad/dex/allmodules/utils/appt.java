package com.wangmai.ad.dex.allmodules.utils;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: ShakeUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class appt implements SensorEventListener {
    private static ConcurrentLinkedQueue<appt> appl = new ConcurrentLinkedQueue<>();

    /* renamed from: appa, reason: collision with root package name */
    SensorManager f46862appa;
    Sensor appb;
    int appc;
    appa appd;
    private boolean appe = false;
    long appf = 50;
    long appg = System.currentTimeMillis();
    boolean apph = false;
    float appi;
    float appj;
    float appk;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: ShakeUtils.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public interface appa {
        void appa();
    }

    public appt(SensorManager sensorManager, int i10, appa appaVar) {
        this.f46862appa = sensorManager;
        this.appc = i10;
        this.appb = sensorManager.getDefaultSensor(1);
        this.appd = appaVar;
    }

    private void appf() {
        try {
            if (this.f46862appa == null || this.appb == null) {
                return;
            }
            appa.appa.appf.appd.appa("ShakeUtils", "ShakeUtils unregister");
            this.f46862appa.unregisterListener(this, this.appb);
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("ShakeUtils", "unregister:" + th.toString());
        }
    }

    public void appa() {
        try {
            appa.appa.appf.appd.appa("ShakeUtils", "ShakeUtils destroy");
            if (this.f46862appa != null && this.appb != null) {
                this.f46862appa.unregisterListener(this, this.appb);
                this.appb = null;
                this.f46862appa = null;
            }
            this.appd = null;
            if (appl == null || appl.isEmpty()) {
                return;
            }
            appl.clear();
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("ShakeUtils", "unregister:" + th.toString());
        }
    }

    public void appb() {
        appa.appa.appf.appd.appa("ShakeUtils", "ShakeUtils dispose");
        appf();
    }

    public void appc() {
        try {
            if (!this.appe) {
                appa.appa.appf.appd.appa("ShakeUtils", "ShakeUtils pause");
                this.appe = true;
                appf();
            } else {
                appa.appa.appf.appd.appa("ShakeUtils", "摇一摇监听已经暂停，无需重复操作");
            }
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("ShakeUtils", "shake pause error:" + th.toString());
        }
    }

    public void appd() {
        try {
            synchronized (appl) {
                while (!appl.isEmpty()) {
                    appt poll = appl.poll();
                    if (poll != null && poll != this) {
                        poll.appb();
                    }
                }
                appl.offer(this);
                if (this.f46862appa != null && this.appb != null) {
                    appa.appa.appf.appd.appa("ShakeUtils", "ShakeUtils register");
                    this.f46862appa.registerListener(this, this.appb, 3);
                }
            }
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("ShakeUtils", "ShakeUtils register exception:" + th.toString());
        }
    }

    public void appe() {
        try {
            if (this.appe) {
                appa.appa.appf.appd.appa("ShakeUtils", "ShakeUtils resume");
                appd();
                this.appe = false;
            } else {
                appa.appa.appf.appd.appa("ShakeUtils", "摇一摇监听已经开启，无需重复操作");
            }
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("ShakeUtils", "shake resume error:" + th.toString());
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i10) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        try {
            long currentTimeMillis = System.currentTimeMillis() - this.appg;
            if (this.appf > currentTimeMillis) {
                return;
            }
            float[] fArr = sensorEvent.values;
            if (!this.apph) {
                this.appi = fArr[0];
                this.appj = fArr[1];
                this.appk = fArr[2];
                this.appg = System.currentTimeMillis();
                this.apph = true;
            }
            float f10 = fArr[0];
            float f11 = fArr[1];
            float f12 = fArr[2];
            float f13 = f10 - this.appi;
            float f14 = f11 - this.appj;
            float f15 = f12 - this.appk;
            this.appg = System.currentTimeMillis();
            this.appi = f10;
            this.appj = f11;
            this.appk = f12;
            double sqrt = (Math.sqrt(((f13 * f13) + (f14 * f14)) + (f15 * f15)) / currentTimeMillis) * 200.0d;
            appa.appa.appf.appd.appa("ShakeUtils", "speed:" + sqrt, "threshold:" + this.appc);
            if (sqrt > this.appc) {
                appa.appa.appf.appd.appa("ShakeUtils", "delta:" + f13 + " " + f14 + " " + f15);
                appa.appa.appf.appd.appa("ShakeUtils", "Current:" + f10 + " " + f11 + " " + f12);
                if (this.appd != null) {
                    this.appd.appa();
                }
            }
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("ShakeUtils", "onSensorChanged:" + th.toString());
        }
    }
}
