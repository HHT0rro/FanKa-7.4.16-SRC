package com.kwad.sdk.core.g;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import androidx.annotation.Nullable;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.utils.ba;
import java.util.Random;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class d {
    private static float aAm = 9.81f;
    private static double aAn = 0.01d;
    private volatile boolean aAc = true;
    private final ba.b aAj = new ba.b() { // from class: com.kwad.sdk.core.g.d.1
        @Override // com.kwad.sdk.utils.ba.b
        public final void onFailed() {
            if (d.this.aAo != null) {
                d.this.aAo.aV();
            }
        }
    };
    private float aAl;

    @Nullable
    private b aAo;

    @Nullable
    private a aAp;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class a implements SensorEventListener {
        private boolean aAs;
        private Random awB;
        private final float[] aAr = {0.0f, 0.0f, 9.8f};
        private final float[] aAt = {0.0f, 0.0f, 0.0f};

        public a() {
            this.aAs = false;
            if (((DevelopMangerComponents) com.kwad.sdk.components.c.f(DevelopMangerComponents.class)) != null) {
                this.aAs = false;
            }
        }

        private void Fx() {
            if (this.awB == null) {
                this.awB = new Random();
            }
            if (this.awB.nextInt(100) == 1) {
                a(this.aAr);
            }
        }

        private void a(float[] fArr) {
            c(fArr);
            float f10 = fArr[0];
            float f11 = fArr[1];
            float f12 = fArr[2];
            double abs = Math.abs(Math.sqrt((f10 * f10) + (f11 * f11) + (f12 * f12)));
            if (b(fArr)) {
                abs = Math.abs(abs - d.aAm);
            }
            if (!d.this.aAc || abs < d.this.aAl || d.this.aAo == null) {
                return;
            }
            d.a(d.this, false);
            d.this.aAo.a(abs);
        }

        private static boolean b(float[] fArr) {
            return Math.abs(Math.abs(Math.sqrt((double) (((fArr[0] * fArr[0]) + (fArr[1] * fArr[1])) + (fArr[2] * fArr[2])))) - ((double) d.aAm)) <= d.aAn;
        }

        private void c(float[] fArr) {
            float[] fArr2 = this.aAt;
            float f10 = (fArr2[0] == 0.0f && fArr2[1] == 0.0f && fArr2[2] == 0.0f) ? 1.0f : 0.6f;
            float f11 = 1.0f - f10;
            fArr[0] = (fArr[0] * f10) + (fArr2[0] * f11);
            fArr[1] = (fArr[1] * f10) + (fArr2[1] * f11);
            fArr[2] = (f10 * fArr[2]) + (f11 * fArr2[2]);
            System.arraycopy((Object) fArr, 0, (Object) fArr2, 0, 3);
        }

        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor sensor, int i10) {
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
            a(sensorEvent.values);
            if (this.aAs) {
                Fx();
            }
        }
    }

    public d(float f10) {
        if (f10 <= 0.0f) {
            this.aAl = 5.0f;
        } else {
            this.aAl = f10;
        }
    }

    public final synchronized void Fu() {
        this.aAc = true;
    }

    public final void bi(Context context) {
        if (context == null) {
            com.kwad.sdk.core.e.c.d("ShakeDetector", "startDetect context is null");
            return;
        }
        this.aAc = true;
        if (this.aAp == null) {
            this.aAp = new a();
        }
        ba.MB().a(1, 2, this.aAp, this.aAj);
    }

    public final synchronized void bj(Context context) {
        if (context != null) {
            if (this.aAp != null) {
                ba.MB().a(this.aAp);
                this.aAp = null;
            }
        }
    }

    public final void e(float f10) {
        this.aAl = f10;
    }

    public static /* synthetic */ boolean a(d dVar, boolean z10) {
        dVar.aAc = false;
        return false;
    }

    public final void a(@Nullable b bVar) {
        this.aAo = bVar;
    }
}
