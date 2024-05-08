package com.alibaba.security.realidentity.build;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import java.util.Calendar;

/* compiled from: AutoFocusManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class hf {

    /* renamed from: i, reason: collision with root package name */
    public static final int f3809i = 500;

    /* renamed from: j, reason: collision with root package name */
    public static final int f3810j = 0;

    /* renamed from: k, reason: collision with root package name */
    public static final int f3811k = 1;

    /* renamed from: l, reason: collision with root package name */
    public static final int f3812l = 2;

    /* renamed from: a, reason: collision with root package name */
    public int f3813a;

    /* renamed from: b, reason: collision with root package name */
    public int f3814b;

    /* renamed from: c, reason: collision with root package name */
    public int f3815c;

    /* renamed from: e, reason: collision with root package name */
    public Calendar f3817e;

    /* renamed from: n, reason: collision with root package name */
    public a f3822n;

    /* renamed from: o, reason: collision with root package name */
    private SensorManager f3823o;

    /* renamed from: p, reason: collision with root package name */
    private Sensor f3824p;

    /* renamed from: d, reason: collision with root package name */
    public long f3816d = 0;

    /* renamed from: f, reason: collision with root package name */
    public boolean f3818f = false;

    /* renamed from: g, reason: collision with root package name */
    public boolean f3819g = false;

    /* renamed from: h, reason: collision with root package name */
    public boolean f3820h = false;

    /* renamed from: m, reason: collision with root package name */
    public int f3821m = 0;

    /* renamed from: q, reason: collision with root package name */
    private int f3825q = 1;

    /* compiled from: AutoFocusManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface a {
        void a();
    }

    public hf(a aVar) {
        this.f3822n = aVar;
    }

    private void a(a aVar) {
        this.f3822n = aVar;
    }

    private boolean b() {
        return this.f3820h && this.f3825q <= 0;
    }

    private void c() {
        this.f3818f = true;
        this.f3825q--;
    }

    private void d() {
        this.f3818f = false;
        this.f3825q++;
    }

    private void e() {
        this.f3825q = 1;
    }

    private void a(SensorEvent sensorEvent) {
        Sensor sensor = sensorEvent.sensor;
        if (sensor == null) {
            return;
        }
        if (this.f3818f) {
            this.f3821m = 0;
            this.f3819g = false;
            this.f3813a = 0;
            this.f3814b = 0;
            this.f3815c = 0;
            return;
        }
        if (sensor.getType() == 1) {
            float[] fArr = sensorEvent.values;
            int i10 = (int) fArr[0];
            int i11 = (int) fArr[1];
            int i12 = (int) fArr[2];
            Calendar calendar = Calendar.getInstance();
            this.f3817e = calendar;
            long timeInMillis = calendar.getTimeInMillis();
            this.f3817e.get(13);
            if (this.f3821m != 0) {
                int abs = Math.abs(this.f3813a - i10);
                int abs2 = Math.abs(this.f3814b - i11);
                int abs3 = Math.abs(this.f3815c - i12);
                if (Math.sqrt((abs * abs) + (abs2 * abs2) + (abs3 * abs3)) > 1.4d) {
                    this.f3821m = 2;
                } else {
                    if (this.f3821m == 2) {
                        this.f3816d = timeInMillis;
                        this.f3819g = true;
                    }
                    if (this.f3819g && timeInMillis - this.f3816d > 500 && !this.f3818f) {
                        this.f3819g = false;
                        a aVar = this.f3822n;
                        if (aVar != null) {
                            aVar.a();
                        }
                    }
                    this.f3821m = 1;
                }
            } else {
                this.f3816d = timeInMillis;
                this.f3821m = 1;
            }
            this.f3813a = i10;
            this.f3814b = i11;
            this.f3815c = i12;
        }
    }

    private void a() {
        this.f3821m = 0;
        this.f3819g = false;
        this.f3813a = 0;
        this.f3814b = 0;
        this.f3815c = 0;
    }
}
