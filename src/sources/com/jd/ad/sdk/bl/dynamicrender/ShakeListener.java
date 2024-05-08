package com.jd.ad.sdk.bl.dynamicrender;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.jd.ad.sdk.logger.Logger;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class ShakeListener implements SensorEventListener, Handler.Callback {
    public SensorManager jad_an;
    public float jad_bo;
    public float[] jad_cp;
    public float[] jad_dq;
    public boolean jad_er;
    public float jad_fs;
    public double jad_hu;
    public List<Long> jad_iv;
    public float jad_jt;
    public List<Long> jad_jw;
    public long jad_kx;
    public long jad_ly;
    public Handler jad_mz;
    public long jad_na;
    public double jad_ob;

    public ShakeListener(Context context) {
        this.jad_bo = 0.0f;
        this.jad_cp = new float[4];
        this.jad_dq = new float[4];
        this.jad_er = false;
        this.jad_fs = 0.0f;
        this.jad_jt = 0.0f;
        this.jad_hu = 1500.0d;
        this.jad_iv = new ArrayList();
        this.jad_jw = new ArrayList();
        this.jad_kx = 0L;
        this.jad_na = 0L;
        this.jad_ob = 2000.0d;
        try {
            this.jad_an = (SensorManager) context.getSystemService("sensor");
        } catch (SecurityException e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        jad_an();
        return true;
    }

    public final void jad_an() {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.jad_na <= this.jad_ob) {
                return;
            }
            this.jad_na = currentTimeMillis;
            boolean jad_an = jad_an(this.jad_iv);
            boolean jad_an2 = jad_an(this.jad_jw);
            float f10 = this.jad_fs;
            if (f10 > 0.0f && this.jad_bo > 0.0f) {
                if (jad_an && jad_an2) {
                    jad_an = true;
                }
                jad_an = false;
            } else if (f10 > 0.0f) {
                jad_an = jad_an2;
            } else {
                if (this.jad_bo > 0.0f) {
                }
                jad_an = false;
            }
            if (jad_an) {
                onShake();
                jad_dq();
            } else {
                jad_dq();
            }
        } catch (Exception e2) {
            jad_dq();
            e2.printStackTrace();
        }
    }

    public final synchronized void jad_bo() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.jad_jt > 0.0f) {
            if (currentTimeMillis - this.jad_kx > this.jad_hu) {
                this.jad_iv = new ArrayList();
                this.jad_jw = new ArrayList();
                jad_dq();
            }
            Handler handler = this.jad_mz;
            if (handler == null) {
                if (handler == null) {
                    this.jad_mz = new Handler(Looper.getMainLooper(), this);
                }
                Handler handler2 = this.jad_mz;
                if (handler2 != null) {
                    handler2.sendEmptyMessageDelayed(1, this.jad_jt * 1000.0f);
                }
            }
        }
        this.jad_kx = currentTimeMillis;
        if (this.jad_iv == null) {
            this.jad_iv = new ArrayList();
        }
        this.jad_iv.add(Long.valueOf(currentTimeMillis));
        if (this.jad_jt == 0.0f) {
            jad_an();
        }
    }

    public final synchronized void jad_cp() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.jad_jt > 0.0f) {
            if (currentTimeMillis - this.jad_ly > this.jad_hu) {
                this.jad_jw = new ArrayList();
                this.jad_iv = new ArrayList();
                jad_dq();
            }
            Handler handler = this.jad_mz;
            if (handler == null) {
                if (handler == null) {
                    this.jad_mz = new Handler(Looper.getMainLooper(), this);
                }
                Handler handler2 = this.jad_mz;
                if (handler2 != null) {
                    handler2.sendEmptyMessageDelayed(1, this.jad_jt * 1000.0f);
                }
            }
        }
        this.jad_ly = currentTimeMillis;
        if (this.jad_jw == null) {
            this.jad_jw = new ArrayList();
        }
        this.jad_jw.add(Long.valueOf(currentTimeMillis));
        if (this.jad_jt == 0.0f) {
            jad_an();
        }
    }

    public final void jad_dq() {
        Handler handler = this.jad_mz;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.jad_mz = null;
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i10) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        try {
            if (sensorEvent.sensor.getType() == 1) {
                if (this.jad_bo > 0.0f) {
                    float[] fArr = sensorEvent.values;
                    if (Math.sqrt(Math.pow(fArr[0], 2.0d) + Math.pow(fArr[1], 2.0d) + Math.pow(fArr[2], 2.0d)) > this.jad_bo) {
                        jad_bo();
                    }
                }
            } else if (sensorEvent.sensor.getType() == 11 && this.jad_fs > 0.0f) {
                float[] fArr2 = sensorEvent.values;
                float[] fArr3 = this.jad_dq;
                System.arraycopy((Object) fArr2, 0, (Object) fArr3, 0, fArr3.length);
                if (!this.jad_er) {
                    float[] fArr4 = this.jad_dq;
                    System.arraycopy((Object) fArr4, 0, (Object) this.jad_cp, 0, fArr4.length);
                    this.jad_er = true;
                } else {
                    float[] fArr5 = new float[4];
                    SensorManager.getQuaternionFromVector(fArr5, this.jad_cp);
                    SensorManager.getQuaternionFromVector(new float[4], this.jad_dq);
                    if (this.jad_fs <= Math.toDegrees(Math.acos(Math.min(Math.max((((fArr5[3] * r10[3]) + ((fArr5[2] * r10[2]) + ((fArr5[1] * r10[1]) + (fArr5[0] * r10[0])))) * (((fArr5[3] * r10[3]) + ((fArr5[2] * r10[2]) + ((fArr5[1] * r10[1]) + (fArr5[0] * r10[0])))) * 2.0f)) - 1.0f, -1.0d), 1.0d)))) {
                        this.jad_cp = fArr5;
                        jad_cp();
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public abstract void onShake();

    public void register() {
        try {
            SensorManager sensorManager = this.jad_an;
            if (sensorManager != null) {
                sensorManager.registerListener(this, sensorManager.getDefaultSensor(1), 2);
                SensorManager sensorManager2 = this.jad_an;
                sensorManager2.registerListener(this, sensorManager2.getDefaultSensor(11), 3);
            }
        } catch (Exception e2) {
            Logger.w("Exception while register shake listener: " + ((Object) e2), new Object[0]);
        }
    }

    public void unregister() {
        jad_dq();
        SensorManager sensorManager = this.jad_an;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
    }

    public final boolean jad_an(List<Long> list) {
        if (list == null || list.size() == 0) {
            return false;
        }
        if (this.jad_jt == 0.0f) {
            return true;
        }
        if (list.size() < 2) {
            return false;
        }
        int size = list.size();
        double longValue = list.get(0).longValue();
        int i10 = size - 1;
        double longValue2 = list.get(i10).longValue();
        if (longValue2 - longValue <= ShadowDrawableWrapper.COS_45) {
            return false;
        }
        double d10 = 0.0d;
        for (int i11 = 1; i11 < size; i11++) {
            double longValue3 = list.get(i11).longValue() - list.get(i11 - 1).longValue();
            if (longValue3 < ShadowDrawableWrapper.COS_45) {
                return false;
            }
            d10 += longValue3;
        }
        double d11 = i10;
        return d10 / d11 <= ((double) (this.jad_jt * 1000.0f)) / d11 && ((double) System.currentTimeMillis()) - longValue2 < this.jad_hu;
    }

    public ShakeListener(Context context, float f10, float f11, float f12) {
        this.jad_bo = 0.0f;
        this.jad_cp = new float[4];
        this.jad_dq = new float[4];
        this.jad_er = false;
        this.jad_fs = 0.0f;
        this.jad_jt = 0.0f;
        this.jad_hu = 1500.0d;
        this.jad_iv = new ArrayList();
        this.jad_jw = new ArrayList();
        this.jad_kx = 0L;
        this.jad_na = 0L;
        this.jad_ob = 2000.0d;
        try {
            this.jad_an = (SensorManager) context.getSystemService("sensor");
            this.jad_bo = f10;
            this.jad_fs = f11;
            this.jad_jt = f12;
        } catch (SecurityException e2) {
            e2.printStackTrace();
        }
    }

    public ShakeListener(Context context, float f10, float f11, float f12, boolean z10) {
        this.jad_bo = 0.0f;
        this.jad_cp = new float[4];
        this.jad_dq = new float[4];
        this.jad_er = false;
        this.jad_fs = 0.0f;
        this.jad_jt = 0.0f;
        this.jad_hu = 1500.0d;
        this.jad_iv = new ArrayList();
        this.jad_jw = new ArrayList();
        this.jad_kx = 0L;
        this.jad_na = 0L;
        this.jad_ob = 2000.0d;
        try {
            this.jad_an = (SensorManager) context.getSystemService("sensor");
            this.jad_bo = f10;
            this.jad_fs = f11;
            this.jad_jt = f12;
        } catch (SecurityException e2) {
            e2.printStackTrace();
        }
    }
}
