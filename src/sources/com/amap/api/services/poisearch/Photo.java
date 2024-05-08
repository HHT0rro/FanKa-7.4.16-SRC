package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class Photo implements Parcelable {
    public static final Parcelable.Creator<Photo> CREATOR = new Parcelable.Creator<Photo>() { // from class: com.amap.api.services.poisearch.Photo.1
        private static Photo a(Parcel parcel) {
            return new Photo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Photo createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Photo[] newArray(int i10) {
            return null;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f8622a;

    /* renamed from: b, reason: collision with root package name */
    private String f8623b;

    public Photo() {
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getTitle() {
        return this.f8622a;
    }

    public final String getUrl() {
        return this.f8623b;
    }

    public final void setTitle(String str) {
        this.f8622a = str;
    }

    public final void setUrl(String str) {
        this.f8623b = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f8622a);
        parcel.writeString(this.f8623b);
    }

    public Photo(String str, String str2) {
        this.f8622a = str;
        this.f8623b = str2;
    }

    public Photo(Parcel parcel) {
        this.f8622a = parcel.readString();
        this.f8623b = parcel.readString();
    }
}
