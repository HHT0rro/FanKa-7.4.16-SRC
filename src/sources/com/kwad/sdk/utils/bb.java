package com.kwad.sdk.utils;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.kwad.sdk.utils.ba;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class bb implements SensorEventListener {
    private final b aPQ;
    private final b aPR;
    private final b aPS;
    private boolean aPT;
    private boolean aPU;
    private final ba.b aPV;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {
        private static final bb aPX = new bb(0);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class b {
        private SensorEvent aPY;
        private long timestamp;

        private b() {
        }

        public /* synthetic */ b(byte b4) {
            this();
        }

        public final void Q(List<com.kwad.sdk.l.a.e> list) {
            if (this.aPY == null) {
                return;
            }
            com.kwad.sdk.l.a.e eVar = new com.kwad.sdk.l.a.e();
            eVar.sensorType = this.aPY.sensor.getType();
            eVar.timestamp = this.timestamp / 1000;
            for (float f10 : this.aPY.values) {
                eVar.aNc.add(Float.valueOf(f10));
            }
            list.add(eVar);
        }

        public final void b(SensorEvent sensorEvent) {
            this.aPY = sensorEvent;
            this.timestamp = System.currentTimeMillis();
        }
    }

    public /* synthetic */ bb(byte b4) {
        this();
    }

    public static bb MC() {
        return a.aPX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void ME() {
        if (this.aPU) {
            ba.MB().a(this);
            this.aPU = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void register() {
        if (!this.aPT && !this.aPU) {
            this.aPU = true;
            try {
                ba.MB().a(3, 3, this, this.aPV);
                ba.MB().a(2, 3, this, this.aPV);
                ba.MB().a(4, 3, this, this.aPV);
            } catch (Throwable unused) {
                this.aPT = true;
            }
        }
    }

    public final synchronized List<com.kwad.sdk.l.a.e> MD() {
        if (!o.Ll()) {
            return null;
        }
        com.kwad.sdk.core.c.b.DD();
        if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
            register();
        }
        ArrayList arrayList = new ArrayList();
        this.aPQ.Q(arrayList);
        this.aPR.Q(arrayList);
        this.aPS.Q(arrayList);
        return arrayList;
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i10) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        int type = sensorEvent.sensor.getType();
        if (type == 1) {
            this.aPQ.b(sensorEvent);
        } else if (type == 4) {
            this.aPR.b(sensorEvent);
        } else {
            if (type != 9) {
                return;
            }
            this.aPS.b(sensorEvent);
        }
    }

    private bb() {
        byte b4 = 0;
        this.aPQ = new b(b4);
        this.aPR = new b(b4);
        this.aPS = new b(b4);
        this.aPT = false;
        this.aPV = new ba.b() { // from class: com.kwad.sdk.utils.bb.2
            @Override // com.kwad.sdk.utils.ba.b
            public final void onFailed() {
                bb.a(bb.this, true);
            }
        };
        com.kwad.sdk.core.c.b.DD();
        com.kwad.sdk.core.c.b.a(new com.kwad.sdk.core.c.d() { // from class: com.kwad.sdk.utils.bb.1
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToBackground() {
                super.onBackToBackground();
                bb.this.ME();
            }

            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToForeground() {
                super.onBackToForeground();
                if (o.Ll()) {
                    bb.this.register();
                }
            }
        });
    }

    public static /* synthetic */ boolean a(bb bbVar, boolean z10) {
        bbVar.aPT = true;
        return true;
    }
}
