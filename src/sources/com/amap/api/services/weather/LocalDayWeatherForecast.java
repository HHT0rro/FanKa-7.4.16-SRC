package com.amap.api.services.weather;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class LocalDayWeatherForecast implements Parcelable {
    public static final Parcelable.Creator<LocalDayWeatherForecast> CREATOR = new Parcelable.Creator<LocalDayWeatherForecast>() { // from class: com.amap.api.services.weather.LocalDayWeatherForecast.1
        private static LocalDayWeatherForecast a(Parcel parcel) {
            return new LocalDayWeatherForecast(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ LocalDayWeatherForecast createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ LocalDayWeatherForecast[] newArray(int i10) {
            return null;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f9098a;

    /* renamed from: b, reason: collision with root package name */
    private String f9099b;

    /* renamed from: c, reason: collision with root package name */
    private String f9100c;

    /* renamed from: d, reason: collision with root package name */
    private String f9101d;

    /* renamed from: e, reason: collision with root package name */
    private String f9102e;

    /* renamed from: f, reason: collision with root package name */
    private String f9103f;

    /* renamed from: g, reason: collision with root package name */
    private String f9104g;

    /* renamed from: h, reason: collision with root package name */
    private String f9105h;

    /* renamed from: i, reason: collision with root package name */
    private String f9106i;

    /* renamed from: j, reason: collision with root package name */
    private String f9107j;

    public LocalDayWeatherForecast() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDate() {
        return this.f9098a;
    }

    public String getDayTemp() {
        return this.f9102e;
    }

    public String getDayWeather() {
        return this.f9100c;
    }

    public String getDayWindDirection() {
        return this.f9104g;
    }

    public String getDayWindPower() {
        return this.f9106i;
    }

    public String getNightTemp() {
        return this.f9103f;
    }

    public String getNightWeather() {
        return this.f9101d;
    }

    public String getNightWindDirection() {
        return this.f9105h;
    }

    public String getNightWindPower() {
        return this.f9107j;
    }

    public String getWeek() {
        return this.f9099b;
    }

    public void setDate(String str) {
        this.f9098a = str;
    }

    public void setDayTemp(String str) {
        this.f9102e = str;
    }

    public void setDayWeather(String str) {
        this.f9100c = str;
    }

    public void setDayWindDirection(String str) {
        this.f9104g = str;
    }

    public void setDayWindPower(String str) {
        this.f9106i = str;
    }

    public void setNightTemp(String str) {
        this.f9103f = str;
    }

    public void setNightWeather(String str) {
        this.f9101d = str;
    }

    public void setNightWindDirection(String str) {
        this.f9105h = str;
    }

    public void setNightWindPower(String str) {
        this.f9107j = str;
    }

    public void setWeek(String str) {
        this.f9099b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f9098a);
        parcel.writeString(this.f9099b);
        parcel.writeString(this.f9100c);
        parcel.writeString(this.f9101d);
        parcel.writeString(this.f9102e);
        parcel.writeString(this.f9103f);
        parcel.writeString(this.f9104g);
        parcel.writeString(this.f9105h);
        parcel.writeString(this.f9106i);
        parcel.writeString(this.f9107j);
    }

    public LocalDayWeatherForecast(Parcel parcel) {
        this.f9098a = parcel.readString();
        this.f9099b = parcel.readString();
        this.f9100c = parcel.readString();
        this.f9101d = parcel.readString();
        this.f9102e = parcel.readString();
        this.f9103f = parcel.readString();
        this.f9104g = parcel.readString();
        this.f9105h = parcel.readString();
        this.f9106i = parcel.readString();
        this.f9107j = parcel.readString();
    }
}
