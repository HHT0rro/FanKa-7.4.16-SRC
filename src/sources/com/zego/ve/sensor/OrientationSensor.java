package com.zego.ve.sensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class OrientationSensor implements SensorBase, SensorEventListener {
    private static final String TAG = "sensor";
    private static OrientationSensor sInstance = new OrientationSensor();
    public Sensor mAccelerometer;
    public Context mContext;
    public Sensor mMagneticField;
    public SensorManager mSensorManager;
    private final float[] accelerometerReading = new float[3];
    private final float[] magnetometerReading = new float[3];
    private boolean is_created = false;
    private boolean is_started = false;
    private boolean is_updated = false;
    private List<Long> mCallbackObjects = new ArrayList();
    private Object mLock = new Object();

    private OrientationSensor() {
    }

    public static SensorBase getInstance() {
        return sInstance;
    }

    private static native int on_orientation_changed(float[] fArr);

    @Override // com.zego.ve.sensor.SensorBase
    public int addNativeCallbackObj(long j10) {
        synchronized (this.mLock) {
            if (this.mCallbackObjects.indexOf(Long.valueOf(j10)) != -1) {
                return 0;
            }
            this.mCallbackObjects.add(Long.valueOf(j10));
            return 0;
        }
    }

    @Override // com.zego.ve.sensor.SensorBase
    public int create(Context context) {
        if (this.is_created) {
            return 0;
        }
        this.mContext = context;
        SensorManager sensorManager = (SensorManager) context.getSystemService(TAG);
        this.mSensorManager = sensorManager;
        this.mAccelerometer = sensorManager.getDefaultSensor(1);
        this.mMagneticField = this.mSensorManager.getDefaultSensor(2);
        this.is_created = true;
        return 0;
    }

    @Override // com.zego.ve.sensor.SensorBase
    public void destroy() {
        if (this.is_created) {
            this.is_created = false;
        }
    }

    public float[] getOrientationAngle() {
        float[] fArr = new float[9];
        float[] fArr2 = new float[3];
        Arrays.fill(fArr2, 0.0f);
        SensorManager.getRotationMatrix(fArr, null, this.accelerometerReading, this.magnetometerReading);
        SensorManager.getOrientation(fArr, fArr2);
        return fArr2;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i10) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 1) {
            float[] fArr = sensorEvent.values;
            float[] fArr2 = this.accelerometerReading;
            System.arraycopy((Object) fArr, 0, (Object) fArr2, 0, fArr2.length);
            this.is_updated = true;
            return;
        }
        if (sensorEvent.sensor.getType() == 2) {
            float[] fArr3 = sensorEvent.values;
            float[] fArr4 = this.magnetometerReading;
            System.arraycopy((Object) fArr3, 0, (Object) fArr4, 0, fArr4.length);
            this.is_updated = true;
        }
    }

    @Override // com.zego.ve.sensor.SensorBase
    public int removeNativeCallbackObj(long j10) {
        synchronized (this.mLock) {
            int indexOf = this.mCallbackObjects.indexOf(Long.valueOf(j10));
            if (indexOf == -1) {
                return -1;
            }
            this.mCallbackObjects.remove(indexOf);
            return 0;
        }
    }

    @Override // com.zego.ve.sensor.SensorBase
    public int start() {
        if (this.is_started) {
            return 0;
        }
        Sensor sensor = this.mAccelerometer;
        if (sensor != null) {
            this.mSensorManager.registerListener(this, sensor, 3, 2);
        }
        Sensor sensor2 = this.mMagneticField;
        if (sensor2 != null) {
            this.mSensorManager.registerListener(this, sensor2, 3, 2);
        }
        Arrays.fill(this.accelerometerReading, 0.0f);
        Arrays.fill(this.magnetometerReading, 0.0f);
        this.is_started = true;
        this.is_updated = false;
        return 0;
    }

    @Override // com.zego.ve.sensor.SensorBase
    public void stop() {
        if (this.is_started) {
            this.mSensorManager.unregisterListener(this, this.mAccelerometer);
            this.mSensorManager.unregisterListener(this, this.mMagneticField);
            this.is_started = false;
        }
    }
}
