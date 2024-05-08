package com.amap.api.services.weather;

import com.amap.api.col.s.n;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class WeatherSearchQuery implements Cloneable {
    public static final int WEATHER_TYPE_FORECAST = 2;
    public static final int WEATHER_TYPE_LIVE = 1;

    /* renamed from: a, reason: collision with root package name */
    private String f9127a;

    /* renamed from: b, reason: collision with root package name */
    private int f9128b;

    public WeatherSearchQuery(String str, int i10) {
        this.f9127a = str;
        this.f9128b = i10;
    }

    public String getCity() {
        return this.f9127a;
    }

    public int getType() {
        return this.f9128b;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public WeatherSearchQuery m1995clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e2) {
            n.a(e2, "WeatherSearchQuery", "clone");
        }
        return new WeatherSearchQuery(this.f9127a, this.f9128b);
    }

    public WeatherSearchQuery() {
        this.f9128b = 1;
    }
}
