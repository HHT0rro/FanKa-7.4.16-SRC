package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class BusinessArea implements Parcelable {
    public static final Parcelable.Creator<BusinessArea> CREATOR = new Parcelable.Creator<BusinessArea>() { // from class: com.amap.api.services.geocoder.BusinessArea.1
        private static BusinessArea a(Parcel parcel) {
            return new BusinessArea(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusinessArea createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusinessArea[] newArray(int i10) {
            return a(i10);
        }

        private static BusinessArea[] a(int i10) {
            return new BusinessArea[i10];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private LatLonPoint f8516a;

    /* renamed from: b, reason: collision with root package name */
    private String f8517b;

    public BusinessArea() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonPoint getCenterPoint() {
        return this.f8516a;
    }

    public String getName() {
        return this.f8517b;
    }

    public void setCenterPoint(LatLonPoint latLonPoint) {
        this.f8516a = latLonPoint;
    }

    public void setName(String str) {
        this.f8517b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f8516a, i10);
        parcel.writeString(this.f8517b);
    }

    public BusinessArea(Parcel parcel) {
        this.f8516a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f8517b = parcel.readString();
    }
}
