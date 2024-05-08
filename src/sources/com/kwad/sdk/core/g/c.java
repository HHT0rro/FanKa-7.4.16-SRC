package com.kwad.sdk.core.g;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import androidx.annotation.Nullable;
import com.alipay.sdk.util.i;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.utils.ba;
import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class c {

    @Nullable
    private com.kwad.sdk.core.g.a aAh;

    @Nullable
    private a aAi;
    private AdMatrixInfo.RotateInfo rotateInfo;
    private volatile boolean aAc = true;
    private long aAd = 0;
    private double aAe = 9.999999717180685E-10d;
    private double[] aAf = {ShadowDrawableWrapper.COS_45, ShadowDrawableWrapper.COS_45, ShadowDrawableWrapper.COS_45};
    private double[] aAg = {ShadowDrawableWrapper.COS_45, ShadowDrawableWrapper.COS_45, ShadowDrawableWrapper.COS_45};
    private final ba.b aAj = new ba.b() { // from class: com.kwad.sdk.core.g.c.1
        @Override // com.kwad.sdk.utils.ba.b
        public final void onFailed() {
            if (c.this.aAh != null) {
                c.this.aAh.lr();
            }
        }
    };

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class a implements SensorEventListener {
        private a() {
        }

        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor sensor, int i10) {
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
            float[] fArr = sensorEvent.values;
            float f10 = fArr[0];
            float f11 = fArr[1];
            float f12 = fArr[2];
            if (c.this.aAd != 0) {
                double d10 = (sensorEvent.timestamp - c.this.aAd) * c.this.aAe;
                double[] dArr = c.this.aAg;
                dArr[0] = dArr[0] + Math.toDegrees(f10 * d10);
                double[] dArr2 = c.this.aAg;
                dArr2[1] = dArr2[1] + Math.toDegrees(f11 * d10);
                double[] dArr3 = c.this.aAg;
                dArr3[2] = dArr3[2] + Math.toDegrees(f12 * d10);
                c.this.Fr();
                c.this.Fs();
            }
            c.this.aAd = sensorEvent.timestamp;
        }

        public /* synthetic */ a(c cVar, byte b4) {
            this();
        }
    }

    public c(AdMatrixInfo.RotateInfo rotateInfo) {
        this.rotateInfo = rotateInfo;
    }

    private void Fq() {
        Arrays.fill(this.aAf, ShadowDrawableWrapper.COS_45);
        Arrays.fill(this.aAg, ShadowDrawableWrapper.COS_45);
        this.aAd = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fr() {
        if (this.aAc) {
            if (Math.abs(this.aAg[0]) > Math.abs(this.aAf[0])) {
                this.aAf[0] = this.aAg[0];
            }
            if (Math.abs(this.aAg[1]) > Math.abs(this.aAf[1])) {
                this.aAf[1] = this.aAg[1];
            }
            if (Math.abs(this.aAg[2]) > Math.abs(this.aAf[2])) {
                this.aAf[2] = this.aAg[2];
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fs() {
        AdMatrixInfo.RotateInfo rotateInfo;
        if (!this.aAc || (rotateInfo = this.rotateInfo) == null || this.aAh == null) {
            return;
        }
        if (!a(0, r0.rotateDegree, rotateInfo.f36645x.direction)) {
            if (!a(1, r1.rotateDegree, this.rotateInfo.f36646y.direction)) {
                if (!a(2, r1.rotateDegree, this.rotateInfo.f36647z.direction)) {
                    return;
                }
            }
        }
        this.aAc = false;
        this.aAh.U(Ft());
    }

    private String Ft() {
        return "{\"x\": " + this.aAf[0] + ",\"y\":" + this.aAf[1] + ",\"z\":" + this.aAf[2] + i.f4738d;
    }

    public final void bi(Context context) {
        if (context == null) {
            return;
        }
        Fq();
        this.aAc = true;
        if (this.aAi == null) {
            this.aAi = new a(this, (byte) 0);
        }
        ba.MB().a(2, 2, this.aAi, this.aAj);
    }

    public final synchronized void bj(Context context) {
        if (context != null) {
            if (this.aAi != null) {
                ba.MB().a(this.aAi);
                this.aAi = null;
            }
        }
    }

    public final void a(AdMatrixInfo.RotateInfo rotateInfo) {
        this.rotateInfo = rotateInfo;
    }

    public final void a(@Nullable com.kwad.sdk.core.g.a aVar) {
        this.aAh = aVar;
    }

    private boolean a(int i10, double d10, int i11) {
        if (d10 <= ShadowDrawableWrapper.COS_45 || Math.abs(this.aAg[i10]) < d10) {
            return false;
        }
        double[] dArr = this.aAg;
        return (dArr[i10] <= ShadowDrawableWrapper.COS_45 || i11 != 1) && (dArr[i10] >= ShadowDrawableWrapper.COS_45 || i11 != 2);
    }
}
