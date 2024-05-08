package com.cupidapp.live.liveshow.view.shake;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveShakeListener.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class a implements SensorEventListener {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final C0162a f15897d = new C0162a(null);

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final Function0<p> f15898b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final SensorManager f15899c;

    /* compiled from: FKLiveShakeListener.kt */
    @d
    /* renamed from: com.cupidapp.live.liveshow.view.shake.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class C0162a {
        public C0162a() {
        }

        public /* synthetic */ C0162a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a(@NotNull Context context, @Nullable Function0<p> function0) {
        s.i(context, "context");
        this.f15898b = function0;
        Object systemService = context.getSystemService("sensor");
        s.g(systemService, "null cannot be cast to non-null type android.hardware.SensorManager");
        this.f15899c = (SensorManager) systemService;
    }

    public final void a() {
        SensorManager sensorManager = this.f15899c;
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(1), 2);
    }

    public final void b() {
        this.f15899c.unregisterListener(this);
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(@Nullable Sensor sensor, int i10) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(@Nullable SensorEvent sensorEvent) {
        Function0<p> function0;
        if (sensorEvent != null && sensorEvent.sensor.getType() == 1) {
            float[] fArr = sensorEvent.values;
            float f10 = fArr != null ? fArr[0] : 0.0f;
            float f11 = fArr != null ? fArr[1] : 0.0f;
            float f12 = fArr != null ? fArr[2] : 0.0f;
            if ((Math.abs(f10) > 17.0f || Math.abs(f11) > 17.0f || Math.abs(f12) > 17.0f) && (function0 = this.f15898b) != null) {
                function0.invoke();
            }
        }
    }
}
