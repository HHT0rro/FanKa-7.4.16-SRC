package com.danlan.android.cognition.sensor;

import android.hardware.SensorEvent;
import androidx.annotation.Nullable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class SensorCoreModel {
    private int accuracy;
    private SensorEvent sensorEvent;
    private long timestamp;

    /* renamed from: x, reason: collision with root package name */
    private Float f19044x;

    /* renamed from: y, reason: collision with root package name */
    @Nullable
    private Float f19045y;

    /* renamed from: z, reason: collision with root package name */
    @Nullable
    private Float f19046z;

    public SensorCoreModel() {
    }

    public SensorCoreModel(SensorEvent sensorEvent) {
        this.sensorEvent = sensorEvent;
        this.timestamp = System.currentTimeMillis();
        this.accuracy = sensorEvent.accuracy;
        this.f19044x = Float.valueOf(sensorEvent.values[0]);
        try {
            this.f19045y = Float.valueOf(sensorEvent.values[1]);
        } catch (Exception unused) {
            this.f19045y = null;
        }
        try {
            this.f19046z = Float.valueOf(sensorEvent.values[2]);
        } catch (Exception unused2) {
            this.f19046z = null;
        }
    }

    public int getAccuracy() {
        return this.accuracy;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public Float getX() {
        return this.f19044x;
    }

    @Nullable
    public Float getY() {
        return this.f19045y;
    }

    @Nullable
    public Float getZ() {
        return this.f19046z;
    }

    public void setAccuracy(int i10) {
        this.accuracy = i10;
    }

    public void setTimestamp(long j10) {
        this.timestamp = j10;
    }

    public void setX(float f10) {
        this.f19044x = Float.valueOf(f10);
    }

    public void setY(float f10) {
        this.f19045y = Float.valueOf(f10);
    }

    public void setZ(float f10) {
        this.f19046z = Float.valueOf(f10);
    }
}
