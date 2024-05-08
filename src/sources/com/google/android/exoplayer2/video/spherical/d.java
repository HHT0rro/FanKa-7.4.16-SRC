package com.google.android.exoplayer2.video.spherical;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.view.Display;
import androidx.annotation.BinderThread;

/* compiled from: OrientationListener.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class d implements SensorEventListener {

    /* renamed from: b, reason: collision with root package name */
    public final float[] f23129b = new float[16];

    /* renamed from: c, reason: collision with root package name */
    public final float[] f23130c = new float[16];

    /* renamed from: d, reason: collision with root package name */
    public final float[] f23131d = new float[16];

    /* renamed from: e, reason: collision with root package name */
    public final float[] f23132e = new float[3];

    /* renamed from: f, reason: collision with root package name */
    public final Display f23133f;

    /* renamed from: g, reason: collision with root package name */
    public final a[] f23134g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f23135h;

    /* compiled from: OrientationListener.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface a {
        void a(float[] fArr, float f10);
    }

    public d(Display display, a... aVarArr) {
        this.f23133f = display;
        this.f23134g = aVarArr;
    }

    public static void e(float[] fArr) {
        Matrix.rotateM(fArr, 0, 90.0f, 1.0f, 0.0f, 0.0f);
    }

    public final float a(float[] fArr) {
        SensorManager.remapCoordinateSystem(fArr, 1, 131, this.f23130c);
        SensorManager.getOrientation(this.f23130c, this.f23132e);
        return this.f23132e[2];
    }

    public final void b(float[] fArr, float f10) {
        for (a aVar : this.f23134g) {
            aVar.a(fArr, f10);
        }
    }

    public final void c(float[] fArr) {
        if (!this.f23135h) {
            c.a(this.f23131d, fArr);
            this.f23135h = true;
        }
        float[] fArr2 = this.f23130c;
        System.arraycopy((Object) fArr, 0, (Object) fArr2, 0, fArr2.length);
        Matrix.multiplyMM(fArr, 0, this.f23130c, 0, this.f23131d, 0);
    }

    public final void d(float[] fArr, int i10) {
        if (i10 != 0) {
            int i11 = 130;
            int i12 = 129;
            if (i10 == 1) {
                i11 = 2;
            } else if (i10 == 2) {
                i11 = 129;
                i12 = 130;
            } else {
                if (i10 != 3) {
                    throw new IllegalStateException();
                }
                i12 = 1;
            }
            float[] fArr2 = this.f23130c;
            System.arraycopy((Object) fArr, 0, (Object) fArr2, 0, fArr2.length);
            SensorManager.remapCoordinateSystem(this.f23130c, i11, i12, fArr);
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i10) {
    }

    @Override // android.hardware.SensorEventListener
    @BinderThread
    public void onSensorChanged(SensorEvent sensorEvent) {
        SensorManager.getRotationMatrixFromVector(this.f23129b, sensorEvent.values);
        d(this.f23129b, this.f23133f.getRotation());
        float a10 = a(this.f23129b);
        e(this.f23129b);
        c(this.f23129b);
        b(this.f23129b, a10);
    }
}
