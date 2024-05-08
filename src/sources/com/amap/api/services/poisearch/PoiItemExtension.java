package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class PoiItemExtension implements Parcelable {
    public static final Parcelable.Creator<PoiItemExtension> CREATOR = new Parcelable.Creator<PoiItemExtension>() { // from class: com.amap.api.services.poisearch.PoiItemExtension.1
        private static PoiItemExtension a(Parcel parcel) {
            return new PoiItemExtension(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PoiItemExtension createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PoiItemExtension[] newArray(int i10) {
            return a(i10);
        }

        private static PoiItemExtension[] a(int i10) {
            return new PoiItemExtension[i10];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f8624a;

    /* renamed from: b, reason: collision with root package name */
    private String f8625b;

    public PoiItemExtension(String str, String str2) {
        this.f8624a = str;
        this.f8625b = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getOpentime() {
        return this.f8624a;
    }

    public String getmRating() {
        return this.f8625b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f8624a);
        parcel.writeString(this.f8625b);
    }

    public PoiItemExtension(Parcel parcel) {
        this.f8624a = parcel.readString();
        this.f8625b = parcel.readString();
    }
}
