package com.amap.api.services.weather;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class LocalWeatherLive implements Parcelable {
    public static final Parcelable.Creator<LocalWeatherLive> CREATOR = new Parcelable.Creator<LocalWeatherLive>() { // from class: com.amap.api.services.weather.LocalWeatherLive.1
        private static LocalWeatherLive a(Parcel parcel) {
            return new LocalWeatherLive(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ LocalWeatherLive createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ LocalWeatherLive[] newArray(int i10) {
            return null;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f9115a;

    /* renamed from: b, reason: collision with root package name */
    private String f9116b;

    /* renamed from: c, reason: collision with root package name */
    private String f9117c;

    /* renamed from: d, reason: collision with root package name */
    private String f9118d;

    /* renamed from: e, reason: collision with root package name */
    private String f9119e;

    /* renamed from: f, reason: collision with root package name */
    private String f9120f;

    /* renamed from: g, reason: collision with root package name */
    private String f9121g;

    /* renamed from: h, reason: collision with root package name */
    private String f9122h;

    /* renamed from: i, reason: collision with root package name */
    private String f9123i;

    public LocalWeatherLive() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdCode() {
        return this.f9117c;
    }

    public String getCity() {
        return this.f9116b;
    }

    public String getHumidity() {
        return this.f9122h;
    }

    public String getProvince() {
        return this.f9115a;
    }

    public String getReportTime() {
        return this.f9123i;
    }

    public String getTemperature() {
        return this.f9119e;
    }

    public String getWeather() {
        return this.f9118d;
    }

    public String getWindDirection() {
        return this.f9120f;
    }

    public String getWindPower() {
        return this.f9121g;
    }

    public void setAdCode(String str) {
        this.f9117c = str;
    }

    public void setCity(String str) {
        this.f9116b = str;
    }

    public void setHumidity(String str) {
        this.f9122h = str;
    }

    public void setProvince(String str) {
        this.f9115a = str;
    }

    public void setReportTime(String str) {
        this.f9123i = str;
    }

    public void setTemperature(String str) {
        this.f9119e = str;
    }

    public void setWeather(String str) {
        this.f9118d = str;
    }

    public void setWindDirection(String str) {
        this.f9120f = str;
    }

    public void setWindPower(String str) {
        this.f9121g = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f9115a);
        parcel.writeString(this.f9116b);
        parcel.writeString(this.f9117c);
        parcel.writeString(this.f9118d);
        parcel.writeString(this.f9119e);
        parcel.writeString(this.f9120f);
        parcel.writeString(this.f9121g);
        parcel.writeString(this.f9122h);
        parcel.writeString(this.f9123i);
    }

    public LocalWeatherLive(Parcel parcel) {
        this.f9115a = parcel.readString();
        this.f9116b = parcel.readString();
        this.f9117c = parcel.readString();
        this.f9118d = parcel.readString();
        this.f9119e = parcel.readString();
        this.f9120f = parcel.readString();
        this.f9121g = parcel.readString();
        this.f9122h = parcel.readString();
        this.f9123i = parcel.readString();
    }
}
