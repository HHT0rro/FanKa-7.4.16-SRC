package com.amap.api.services.weather;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class LocalWeatherForecast implements Parcelable {
    public static final Parcelable.Creator<LocalWeatherForecast> CREATOR = new Parcelable.Creator<LocalWeatherForecast>() { // from class: com.amap.api.services.weather.LocalWeatherForecast.1
        private static LocalWeatherForecast a(Parcel parcel) {
            return new LocalWeatherForecast(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ LocalWeatherForecast createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ LocalWeatherForecast[] newArray(int i10) {
            return null;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f9108a;

    /* renamed from: b, reason: collision with root package name */
    private String f9109b;

    /* renamed from: c, reason: collision with root package name */
    private String f9110c;

    /* renamed from: d, reason: collision with root package name */
    private String f9111d;

    /* renamed from: e, reason: collision with root package name */
    private List<LocalDayWeatherForecast> f9112e;

    public LocalWeatherForecast() {
        this.f9112e = new ArrayList();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdCode() {
        return this.f9110c;
    }

    public String getCity() {
        return this.f9109b;
    }

    public String getProvince() {
        return this.f9108a;
    }

    public String getReportTime() {
        return this.f9111d;
    }

    public List<LocalDayWeatherForecast> getWeatherForecast() {
        return this.f9112e;
    }

    public void setAdCode(String str) {
        this.f9110c = str;
    }

    public void setCity(String str) {
        this.f9109b = str;
    }

    public void setProvince(String str) {
        this.f9108a = str;
    }

    public void setReportTime(String str) {
        this.f9111d = str;
    }

    public void setWeatherForecast(List<LocalDayWeatherForecast> list) {
        this.f9112e = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f9108a);
        parcel.writeString(this.f9109b);
        parcel.writeString(this.f9110c);
        parcel.writeString(this.f9111d);
        parcel.writeList(this.f9112e);
    }

    public LocalWeatherForecast(Parcel parcel) {
        this.f9112e = new ArrayList();
        this.f9108a = parcel.readString();
        this.f9109b = parcel.readString();
        this.f9110c = parcel.readString();
        this.f9111d = parcel.readString();
        this.f9112e = parcel.readArrayList(LocalWeatherForecast.class.getClassLoader());
    }
}
