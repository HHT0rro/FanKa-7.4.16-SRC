package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class District implements Parcelable {
    public static final Parcelable.Creator<District> CREATOR = new Parcelable.Creator<District>() { // from class: com.amap.api.services.route.District.1
        private static District a(Parcel parcel) {
            return new District(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ District createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ District[] newArray(int i10) {
            return null;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f8771a;

    /* renamed from: b, reason: collision with root package name */
    private String f8772b;

    public District(Parcel parcel) {
        this.f8771a = parcel.readString();
        this.f8772b = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDistrictAdcode() {
        return this.f8772b;
    }

    public String getDistrictName() {
        return this.f8771a;
    }

    public void setDistrictAdcode(String str) {
        this.f8772b = str;
    }

    public void setDistrictName(String str) {
        this.f8771a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f8771a);
        parcel.writeString(this.f8772b);
    }

    public District() {
    }
}
