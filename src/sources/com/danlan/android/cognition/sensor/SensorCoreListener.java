package com.danlan.android.cognition.sensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.danlan.android.cognition.StringFog;
import com.danlan.android.cognition.collector.util.PermissionUtil;
import com.huawei.hms.framework.common.ExceptionCode;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class SensorCoreListener implements SensorEventListener {

    @Nullable
    private Sensor accelerometer;
    private Context context;
    private PermissionUtil permissionUtil;
    private SensorManager sensorManager;
    private DataGroupArrayList<SensorAccelerometerModel> accelerometerData = new DataGroupArrayList<>(3);
    private long lastAccelerometerRun = 0;
    private int sensorDelay = ExceptionCode.CRASH_EXCEPTION;

    public SensorCoreListener() {
    }

    public SensorCoreListener(@NonNull Context context) {
        this.context = context;
        this.permissionUtil = new PermissionUtil(context);
        SensorManager sensorManager = (SensorManager) context.getSystemService(StringFog.decrypt("UkZKUE5R"));
        this.sensorManager = sensorManager;
        if (sensorManager != null) {
            try {
                this.accelerometer = sensorManager.getDefaultSensor(1);
            } catch (Exception unused) {
            }
        }
    }

    private void addAccelerometerData(SensorEvent sensorEvent) {
        if (!shouldRun(this.accelerometer, this.lastAccelerometerRun, 0) || this.accelerometerData.size() == 2) {
            return;
        }
        this.accelerometerData.add(new SensorAccelerometerModel(sensorEvent));
        this.lastAccelerometerRun = getCurrentTimeInMicroSeconds();
    }

    private long getCurrentTimeInMicroSeconds() {
        return System.currentTimeMillis() * 1000;
    }

    private void registerListener(@Nullable Sensor sensor) {
        registerListener(sensor, Integer.valueOf(this.sensorDelay));
    }

    private void registerListener(@Nullable Sensor sensor, @Nullable Integer num) {
        if (sensor == null) {
            return;
        }
        if (num == null) {
            this.sensorManager.registerListener(this, sensor, this.sensorDelay);
        } else {
            this.sensorManager.registerListener(this, sensor, num.intValue());
        }
    }

    private boolean shouldRun(Sensor sensor, long j10) {
        return shouldRun(sensor, j10, Integer.valueOf(this.sensorDelay));
    }

    private boolean shouldRun(Sensor sensor, long j10, Integer num) {
        return shouldRun(sensor, j10, num, null);
    }

    private boolean shouldRun(Sensor sensor, long j10, Integer num, @Nullable String str) {
        boolean z10 = j10 == 0 || getCurrentTimeInMicroSeconds() >= ((long) num.intValue()) + j10;
        if (str != null) {
            if (sensor == null || !z10 || !this.permissionUtil.isPermissionGranted(str)) {
                return false;
            }
        } else if (sensor == null || !z10) {
            return false;
        }
        return true;
    }

    private void unregisterListener(@Nullable Sensor sensor) {
        if (sensor != null) {
            this.sensorManager.unregisterListener(this, sensor);
        }
    }

    public DataGroupArrayList<SensorAccelerometerModel> getAccelerometerData() {
        return this.accelerometerData;
    }

    public int getSensorDelay() {
        return this.sensorDelay;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i10) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        try {
            if (sensorEvent.sensor.getType() != 1) {
                return;
            }
            addAccelerometerData(sensorEvent);
        } catch (Exception unused) {
        }
    }

    public void registerListeners() {
        if (Volunteer.getInstance().ready(CognitionDataOpt.SENSOR_ACCELEROMETER)) {
            registerListener(this.accelerometer);
        }
    }

    public void reset() {
        this.accelerometerData = new DataGroupArrayList<>(3);
    }

    public void setSensorDelay(int i10) {
        this.sensorDelay = i10;
    }

    public void unregisterListeners() {
        if (Volunteer.getInstance().ready(CognitionDataOpt.SENSOR_ACCELEROMETER)) {
            unregisterListener(this.accelerometer);
        }
    }
}
