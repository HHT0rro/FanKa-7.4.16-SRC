package com.kwad.sdk.utils;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ba {
    private static volatile ba aPM;
    private SensorManager aPN;
    private final Map<String, a> aPO = new ConcurrentHashMap();
    private final Map<String, CopyOnWriteArraySet<SensorEventListener>> aPP = new ConcurrentHashMap();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a implements SensorEventListener {
        private final WeakReference<ba> XV;
        private final String key;

        public a(String str, ba baVar) {
            this.key = str;
            this.XV = new WeakReference<>(baVar);
        }

        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor sensor, int i10) {
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
            ba baVar = this.XV.get();
            if (baVar != null) {
                baVar.a(this.key, sensorEvent);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface b {
        void onFailed();
    }

    private ba() {
    }

    private static String A(int i10, int i11) {
        return i10 + "_" + i11;
    }

    @NonNull
    public static ba MB() {
        if (aPM == null) {
            synchronized (ba.class) {
                if (aPM == null) {
                    aPM = new ba();
                }
            }
        }
        return aPM;
    }

    @Nullable
    private Sensor eb(int i10) {
        if (getSensorManager() == null) {
            return null;
        }
        if (i10 == 1) {
            return getSensorManager().getDefaultSensor(10);
        }
        if (i10 == 2) {
            return getSensorManager().getDefaultSensor(4);
        }
        if (i10 == 3) {
            return getSensorManager().getDefaultSensor(1);
        }
        if (i10 != 4) {
            return null;
        }
        return getSensorManager().getDefaultSensor(9);
    }

    private static int ec(int i10) {
        if (i10 == -3) {
            return 2;
        }
        if (i10 != -2) {
            return i10 != -1 ? 3 : 0;
        }
        return 1;
    }

    private void gM(String str) {
        a aVar = this.aPO.get(str);
        if (aVar != null) {
            this.aPO.remove(str);
            getSensorManager().unregisterListener(aVar);
        }
    }

    private a gN(String str) {
        a aVar = this.aPO.get(str);
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a(str, this);
        this.aPO.put(str, aVar2);
        return aVar2;
    }

    private SensorManager getSensorManager() {
        if (this.aPN == null) {
            this.aPN = (SensorManager) ServiceProvider.getContext().getSystemService("sensor");
        }
        return this.aPN;
    }

    public final synchronized void a(int i10, int i11, SensorEventListener sensorEventListener, b bVar) {
        Sensor eb2 = eb(i10);
        if (eb2 == null) {
            if (bVar != null) {
                bVar.onFailed();
            }
            return;
        }
        String A = A(i10, i11);
        CopyOnWriteArraySet<SensorEventListener> copyOnWriteArraySet = this.aPP.get(A);
        if (copyOnWriteArraySet == null) {
            copyOnWriteArraySet = new CopyOnWriteArraySet<>();
        }
        copyOnWriteArraySet.add(sensorEventListener);
        if (copyOnWriteArraySet.size() == 1) {
            this.aPP.put(A, copyOnWriteArraySet);
            a(A, i11, eb2);
        }
    }

    public final synchronized void a(SensorEventListener sensorEventListener) {
        for (Map.Entry<String, CopyOnWriteArraySet<SensorEventListener>> entry : this.aPP.entrySet()) {
            CopyOnWriteArraySet<SensorEventListener> value = entry.getValue();
            Iterator<SensorEventListener> iterator2 = value.iterator2();
            while (true) {
                if (!iterator2.hasNext()) {
                    break;
                }
                SensorEventListener next = iterator2.next();
                if (next.equals(sensorEventListener)) {
                    value.remove(next);
                    break;
                }
            }
            if (value.size() == 0) {
                gM(entry.getKey());
            }
        }
    }

    private void a(String str, int i10, Sensor sensor) {
        getSensorManager().registerListener(gN(str), sensor, ec(i10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, SensorEvent sensorEvent) {
        CopyOnWriteArraySet<SensorEventListener> copyOnWriteArraySet = this.aPP.get(str);
        if (copyOnWriteArraySet != null) {
            Iterator<SensorEventListener> iterator2 = copyOnWriteArraySet.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().onSensorChanged(sensorEvent);
            }
        }
    }
}
