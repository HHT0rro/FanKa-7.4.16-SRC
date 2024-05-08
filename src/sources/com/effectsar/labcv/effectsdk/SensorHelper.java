package com.effectsar.labcv.effectsdk;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.SystemClock;
import android.view.OrientationEventListener;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class SensorHelper {
    private static final int BEF_REQUIREMENT_SKY_SEG = 16384;
    private static final int RENDER_MSG_EVENT_DID_SWITCH_EFFECT = 6;
    private static final int RENDER_MSG_TYPE_EFFECT = 20;
    private static final String TAG = "SensorHelper";
    private AcceleratorListener acceleratorListener;
    private Sensor acceleratorSeneor;
    private GravityListener gravityListener;
    private Sensor gravitySensor;
    private GyroscopeListener gyroscopeListener;
    private Sensor gyroscopeSensor;
    private Accelerometer mAccelerometer;
    private ISensorListener mListener;
    private SensorManager mSensorManager;
    private Sensor rotationSensor;
    private RotationSensorListener rotationSensorListener;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class AcceleratorListener implements SensorEventListener {
        private AcceleratorListener() {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i10) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (SensorHelper.this.mListener == null) {
                return;
            }
            double timestamp = SensorHelper.this.getTimestamp(sensorEvent);
            ISensorListener iSensorListener = SensorHelper.this.mListener;
            float[] fArr = sensorEvent.values;
            iSensorListener.onAcceleratorChanged(fArr[0], fArr[1], fArr[2], timestamp);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class Accelerometer {
        private static final String TAG = "Accelerometer";
        private AlbumOrientationEventListener mAlbumOrientationEventListener;
        private int mOrientation = 0;

        public Accelerometer(Context context) {
            AlbumOrientationEventListener albumOrientationEventListener = new AlbumOrientationEventListener(context, 3);
            this.mAlbumOrientationEventListener = albumOrientationEventListener;
            if (albumOrientationEventListener.canDetectOrientation()) {
                this.mAlbumOrientationEventListener.enable();
            }
        }

        public int getDirection() {
            return this.mOrientation;
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public class AlbumOrientationEventListener extends OrientationEventListener {
            public AlbumOrientationEventListener(Context context) {
                super(context);
            }

            @Override // android.view.OrientationEventListener
            public void onOrientationChanged(int i10) {
                int i11;
                if (i10 == -1 || (i11 = (((i10 + 45) / 90) * 90) % 360) == Accelerometer.this.mOrientation) {
                    return;
                }
                Accelerometer.this.mOrientation = i11;
            }

            public AlbumOrientationEventListener(Context context, int i10) {
                super(context, i10);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class GravityListener implements SensorEventListener {
        private GravityListener() {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i10) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (SensorHelper.this.mListener == null) {
                return;
            }
            double timestamp = SensorHelper.this.getTimestamp(sensorEvent);
            ISensorListener iSensorListener = SensorHelper.this.mListener;
            float[] fArr = sensorEvent.values;
            iSensorListener.onGravityChanged(fArr[0], fArr[1], fArr[2], timestamp);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class GyroscopeListener implements SensorEventListener {
        private GyroscopeListener() {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i10) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (SensorHelper.this.mListener == null) {
                return;
            }
            double timestamp = SensorHelper.this.getTimestamp(sensorEvent);
            ISensorListener iSensorListener = SensorHelper.this.mListener;
            float[] fArr = sensorEvent.values;
            iSensorListener.onGyroscopeChanged(fArr[0], fArr[1], fArr[2], timestamp);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface ISensorListener {
        void deviceConfig(boolean z10, boolean z11, boolean z12, boolean z13);

        void onAcceleratorChanged(double d10, double d11, double d12, double d13);

        void onGravityChanged(double d10, double d11, double d12, double d13);

        void onGyroscopeChanged(double d10, double d11, double d12, double d13);

        void onOrientationChanged(double[] dArr, int i10, double d10);

        void setDeviceRotation(float[] fArr);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class RotationSensorListener implements SensorEventListener {
        private RotationSensorListener() {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i10) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (SensorHelper.this.mListener == null) {
                return;
            }
            double timestamp = SensorHelper.this.getTimestamp(sensorEvent);
            SensorManager unused = SensorHelper.this.mSensorManager;
            SensorManager.getRotationMatrixFromVector(new float[9], sensorEvent.values);
            double[] dArr = new double[9];
            for (int i10 = 0; i10 < 9; i10++) {
                dArr[i10] = r3[i10];
            }
            SensorHelper.this.mListener.onOrientationChanged(dArr, 9, timestamp / 1.0E9d);
            float[] fArr = sensorEvent.values;
            SensorHelper.this.mListener.setDeviceRotation(new float[]{fArr[0], fArr[1], fArr[2], fArr[3]});
        }
    }

    public SensorHelper(Context context, ISensorListener iSensorListener) {
        this.mListener = iSensorListener;
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        this.mSensorManager = sensorManager;
        this.gyroscopeSensor = sensorManager.getDefaultSensor(4);
        this.acceleratorSeneor = this.mSensorManager.getDefaultSensor(1);
        this.gravitySensor = this.mSensorManager.getDefaultSensor(9);
        Sensor defaultSensor = this.mSensorManager.getDefaultSensor(15);
        this.rotationSensor = defaultSensor;
        if (defaultSensor == null) {
            this.rotationSensor = this.mSensorManager.getDefaultSensor(11);
        }
        this.rotationSensorListener = new RotationSensorListener();
        this.acceleratorListener = new AcceleratorListener();
        this.gyroscopeListener = new GyroscopeListener();
        this.gravityListener = new GravityListener();
        this.mAccelerometer = new Accelerometer(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public double getTimestamp(SensorEvent sensorEvent) {
        long nanoTime = System.nanoTime();
        return nanoTime - Math.min(Math.abs(nanoTime - sensorEvent.timestamp), Math.abs(SystemClock.elapsedRealtimeNanos() - sensorEvent.timestamp));
    }

    public void registerSensor() {
        ISensorListener iSensorListener = this.mListener;
        if (iSensorListener != null) {
            iSensorListener.deviceConfig(this.acceleratorSeneor != null, this.gyroscopeSensor != null, this.gravitySensor != null, this.rotationSensor != null);
        }
        this.mSensorManager.registerListener(this.rotationSensorListener, this.rotationSensor, 0);
        this.mSensorManager.registerListener(this.acceleratorListener, this.acceleratorSeneor, 0);
        this.mSensorManager.registerListener(this.gyroscopeListener, this.gyroscopeSensor, 0);
        this.mSensorManager.registerListener(this.gravityListener, this.gravitySensor, 0);
    }

    public void unRegisterSensor() {
        this.mSensorManager.unregisterListener(this.rotationSensorListener);
        this.mSensorManager.unregisterListener(this.acceleratorListener);
        this.mSensorManager.unregisterListener(this.gyroscopeListener);
        this.mSensorManager.unregisterListener(this.gravityListener);
    }
}
