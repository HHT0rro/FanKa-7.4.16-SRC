package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class Railway implements Parcelable {
    public static final Parcelable.Creator<Railway> CREATOR = new Parcelable.Creator<Railway>() { // from class: com.amap.api.services.route.Railway.1
        private static Railway a(Parcel parcel) {
            return new Railway(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Railway createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Railway[] newArray(int i10) {
            return a(i10);
        }

        private static Railway[] a(int i10) {
            return new Railway[i10];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f8836a;

    /* renamed from: b, reason: collision with root package name */
    private String f8837b;

    public Railway() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getID() {
        return this.f8836a;
    }

    public String getName() {
        return this.f8837b;
    }

    public void setID(String str) {
        this.f8836a = str;
    }

    public void setName(String str) {
        this.f8837b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f8836a);
        parcel.writeString(this.f8837b);
    }

    public Railway(Parcel parcel) {
        this.f8836a = parcel.readString();
        this.f8837b = parcel.readString();
    }
}
