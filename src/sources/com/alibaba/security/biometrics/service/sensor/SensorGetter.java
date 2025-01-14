package com.alibaba.security.biometrics.service.sensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import com.alibaba.security.common.log.RPLogging;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class SensorGetter implements SensorEventListener {
    private static final String TAG = "SensorGetter";
    private static SensorGetter mSensorGetter;
    private Context context;
    private ThreadPoolExecutor executorService;
    private Sensor mLightSensor;
    private Sensor mProximitySensor;
    private SensorManager mSensorManager;
    private Handler mUiHandler;
    private boolean started;
    private float mLightValue = -1.0f;
    private float mProximityValue = -1.0f;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface SensorCallback {
        void onGetSensorValue(float f10);
    }

    private SensorGetter() {
    }

    public static SensorGetter getDefault() {
        if (mSensorGetter == null) {
            synchronized (SensorGetter.class) {
                if (mSensorGetter == null) {
                    mSensorGetter = new SensorGetter();
                }
            }
        }
        return mSensorGetter;
    }

    public void collectLightSensorInfo(SensorCallback sensorCallback) {
        collectOneShotAsync(5, sensorCallback);
    }

    public void collectOneShotAsync(final int i10, final SensorCallback sensorCallback) {
        if (this.executorService == null) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.alibaba.security.biometrics.service.sensor.SensorGetter.1
                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(Runnable runnable) {
                    return new Thread(runnable, "rpsdk-sensorGetter");
                }
            });
            this.executorService = threadPoolExecutor;
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        }
        if (this.mUiHandler == null) {
            this.mUiHandler = new Handler(Looper.getMainLooper());
        }
        ThreadPoolExecutor threadPoolExecutor2 = this.executorService;
        if (threadPoolExecutor2 != null) {
            threadPoolExecutor2.submit(new Runnable() { // from class: com.alibaba.security.biometrics.service.sensor.SensorGetter.2
                @Override // java.lang.Runnable
                public final void run() {
                    final long currentTimeMillis = System.currentTimeMillis();
                    if (sensorCallback == null) {
                        RPLogging.e(SensorGetter.TAG, "sensorCallback is null");
                        return;
                    }
                    if (SensorGetter.this.mSensorManager == null) {
                        SensorGetter sensorGetter = SensorGetter.this;
                        sensorGetter.mSensorManager = (SensorManager) sensorGetter.context.getApplicationContext().getSystemService("sensor");
                    }
                    if (SensorGetter.this.mSensorManager == null) {
                        sensorCallback.onGetSensorValue(-1.0f);
                        return;
                    }
                    Sensor defaultSensor = SensorGetter.this.mSensorManager.getDefaultSensor(i10);
                    if (defaultSensor == null) {
                        sensorCallback.onGetSensorValue(-1.0f);
                        return;
                    }
                    final CountDownLatch countDownLatch = new CountDownLatch(1);
                    final float[] fArr = new float[1];
                    SensorEventListener sensorEventListener = new SensorEventListener() { // from class: com.alibaba.security.biometrics.service.sensor.SensorGetter.2.1
                        @Override // android.hardware.SensorEventListener
                        public final void onAccuracyChanged(Sensor sensor, int i11) {
                        }

                        @Override // android.hardware.SensorEventListener
                        public final void onSensorChanged(SensorEvent sensorEvent) {
                            try {
                                try {
                                    fArr[0] = sensorEvent.values[0];
                                    RPLogging.i(SensorGetter.TAG, "name:" + sensorEvent.sensor.getName() + "\tvalue:" + sensorEvent.values[0] + "\tcost:" + (System.currentTimeMillis() - currentTimeMillis));
                                } catch (Exception e2) {
                                    RPLogging.e(SensorGetter.TAG, e2);
                                }
                            } finally {
                                countDownLatch.countDown();
                            }
                        }
                    };
                    SensorGetter.this.mSensorManager.registerListener(sensorEventListener, defaultSensor, 3, 0);
                    try {
                        countDownLatch.await(500L, TimeUnit.MILLISECONDS);
                    } catch (Exception e2) {
                        RPLogging.e(SensorGetter.TAG, e2);
                    }
                    SensorGetter.this.mUiHandler.post(new Runnable() { // from class: com.alibaba.security.biometrics.service.sensor.SensorGetter.2.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            sensorCallback.onGetSensorValue(fArr[0]);
                        }
                    });
                    if (SensorGetter.this.mSensorManager != null) {
                        SensorGetter.this.mSensorManager.unregisterListener(sensorEventListener, defaultSensor);
                    }
                }
            });
        }
    }

    public void collectProximityInfo(SensorCallback sensorCallback) {
        collectOneShotAsync(8, sensorCallback);
    }

    public float getCurrentLightValue() {
        return this.mLightValue;
    }

    public float getProximityValue() {
        return this.mProximityValue;
    }

    public void init(Context context) {
        this.context = context.getApplicationContext();
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i10) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        try {
            if (sensorEvent.sensor.getType() == 5) {
                this.mLightValue = sensorEvent.values[0];
            }
            if (sensorEvent.sensor.getType() == 8) {
                this.mProximityValue = sensorEvent.values[0];
            }
        } catch (Exception e2) {
            RPLogging.e(TAG, e2);
        }
    }

    public void start() {
        if (this.started) {
            return;
        }
        if (this.mSensorManager == null) {
            this.mSensorManager = (SensorManager) this.context.getApplicationContext().getSystemService("sensor");
        }
        SensorManager sensorManager = this.mSensorManager;
        if (sensorManager != null) {
            Sensor defaultSensor = sensorManager.getDefaultSensor(5);
            this.mLightSensor = defaultSensor;
            if (defaultSensor != null) {
                this.mSensorManager.registerListener(this, defaultSensor, 3, 0);
            }
            Sensor defaultSensor2 = this.mSensorManager.getDefaultSensor(8);
            this.mProximitySensor = defaultSensor2;
            if (defaultSensor2 != null) {
                this.mSensorManager.registerListener(this, defaultSensor2, 3, 0);
            }
        }
        this.started = true;
    }

    public void stop() {
        if (this.started) {
            SensorManager sensorManager = this.mSensorManager;
            if (sensorManager != null) {
                Sensor sensor = this.mLightSensor;
                if (sensor != null) {
                    sensorManager.unregisterListener(this, sensor);
                }
                Sensor sensor2 = this.mProximitySensor;
                if (sensor2 != null) {
                    this.mSensorManager.unregisterListener(this, sensor2);
                }
            }
            this.mSensorManager = null;
            this.started = false;
        }
    }
}
