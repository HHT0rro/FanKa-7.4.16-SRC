package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class SearchCity implements Parcelable {
    public static final Parcelable.Creator<SearchCity> CREATOR = new Parcelable.Creator<SearchCity>() { // from class: com.amap.api.services.route.SearchCity.1
        private static SearchCity a(Parcel parcel) {
            return new SearchCity(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SearchCity createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SearchCity[] newArray(int i10) {
            return null;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f9002a;

    /* renamed from: b, reason: collision with root package name */
    private String f9003b;

    /* renamed from: c, reason: collision with root package name */
    private String f9004c;

    public SearchCity(Parcel parcel) {
        this.f9002a = parcel.readString();
        this.f9003b = parcel.readString();
        this.f9004c = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getSearchCityAdCode() {
        return this.f9004c;
    }

    public String getSearchCityName() {
        return this.f9002a;
    }

    public String getSearchCitycode() {
        return this.f9003b;
    }

    public void setSearchCityName(String str) {
        this.f9002a = str;
    }

    public void setSearchCitycode(String str) {
        this.f9003b = str;
    }

    public void setSearchCityhAdCode(String str) {
        this.f9004c = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f9002a);
        parcel.writeString(this.f9003b);
        parcel.writeString(this.f9004c);
    }

    public SearchCity() {
    }
}
