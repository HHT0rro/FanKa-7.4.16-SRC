package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class Doorway implements Parcelable {
    public static final Parcelable.Creator<Doorway> CREATOR = new Parcelable.Creator<Doorway>() { // from class: com.amap.api.services.route.Doorway.1
        private static Doorway a(Parcel parcel) {
            return new Doorway(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Doorway createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Doorway[] newArray(int i10) {
            return null;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f8773a;

    /* renamed from: b, reason: collision with root package name */
    private LatLonPoint f8774b;

    public Doorway(Parcel parcel) {
        this.f8773a = parcel.readString();
        this.f8774b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonPoint getLatLonPoint() {
        return this.f8774b;
    }

    public String getName() {
        return this.f8773a;
    }

    public void setLatLonPoint(LatLonPoint latLonPoint) {
        this.f8774b = latLonPoint;
    }

    public void setName(String str) {
        this.f8773a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f8773a);
        parcel.writeParcelable(this.f8774b, i10);
    }

    public Doorway() {
    }
}
