package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class OfflineMapCity extends City {
    public static final Parcelable.Creator<OfflineMapCity> CREATOR = new Parcelable.Creator<OfflineMapCity>() { // from class: com.amap.api.maps.offlinemap.OfflineMapCity.1
        private static OfflineMapCity a(Parcel parcel) {
            return new OfflineMapCity(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ OfflineMapCity createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ OfflineMapCity[] newArray(int i10) {
            return a(i10);
        }

        private static OfflineMapCity[] a(int i10) {
            return new OfflineMapCity[i10];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f8277a;

    /* renamed from: b, reason: collision with root package name */
    private long f8278b;

    /* renamed from: c, reason: collision with root package name */
    private int f8279c;

    /* renamed from: d, reason: collision with root package name */
    private String f8280d;

    /* renamed from: e, reason: collision with root package name */
    private int f8281e;

    public OfflineMapCity() {
        this.f8277a = "";
        this.f8278b = 0L;
        this.f8279c = 6;
        this.f8280d = "";
        this.f8281e = 0;
    }

    @Override // com.amap.api.maps.offlinemap.City, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getSize() {
        return this.f8278b;
    }

    public int getState() {
        return this.f8279c;
    }

    public String getUrl() {
        return this.f8277a;
    }

    public String getVersion() {
        return this.f8280d;
    }

    public int getcompleteCode() {
        return this.f8281e;
    }

    public void setCompleteCode(int i10) {
        this.f8281e = i10;
    }

    public void setSize(long j10) {
        this.f8278b = j10;
    }

    public void setState(int i10) {
        this.f8279c = i10;
    }

    public void setUrl(String str) {
        this.f8277a = str;
    }

    public void setVersion(String str) {
        this.f8280d = str;
    }

    @Override // com.amap.api.maps.offlinemap.City, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeString(this.f8277a);
        parcel.writeLong(this.f8278b);
        parcel.writeInt(this.f8279c);
        parcel.writeString(this.f8280d);
        parcel.writeInt(this.f8281e);
    }

    public OfflineMapCity(Parcel parcel) {
        super(parcel);
        this.f8277a = "";
        this.f8278b = 0L;
        this.f8279c = 6;
        this.f8280d = "";
        this.f8281e = 0;
        this.f8277a = parcel.readString();
        this.f8278b = parcel.readLong();
        this.f8279c = parcel.readInt();
        this.f8280d = parcel.readString();
        this.f8281e = parcel.readInt();
    }
}
