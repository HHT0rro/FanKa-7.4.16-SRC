package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class OfflineMapProvince extends Province {
    public static final Parcelable.Creator<OfflineMapProvince> CREATOR = new Parcelable.Creator<OfflineMapProvince>() { // from class: com.amap.api.maps.offlinemap.OfflineMapProvince.1
        private static OfflineMapProvince a(Parcel parcel) {
            return new OfflineMapProvince(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ OfflineMapProvince createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ OfflineMapProvince[] newArray(int i10) {
            return a(i10);
        }

        private static OfflineMapProvince[] a(int i10) {
            return new OfflineMapProvince[i10];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f8301a;

    /* renamed from: b, reason: collision with root package name */
    private int f8302b;

    /* renamed from: c, reason: collision with root package name */
    private long f8303c;

    /* renamed from: d, reason: collision with root package name */
    private String f8304d;

    /* renamed from: e, reason: collision with root package name */
    private int f8305e;

    /* renamed from: f, reason: collision with root package name */
    private ArrayList<OfflineMapCity> f8306f;

    public OfflineMapProvince() {
        this.f8302b = 6;
        this.f8305e = 0;
    }

    @Override // com.amap.api.maps.offlinemap.Province, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ArrayList<OfflineMapCity> getCityList() {
        ArrayList<OfflineMapCity> arrayList = this.f8306f;
        return arrayList == null ? new ArrayList<>() : arrayList;
    }

    public ArrayList<OfflineMapCity> getDownloadedCityList() {
        ArrayList<OfflineMapCity> arrayList = new ArrayList<>();
        ArrayList<OfflineMapCity> arrayList2 = this.f8306f;
        if (arrayList2 == null) {
            return arrayList;
        }
        Iterator<OfflineMapCity> iterator2 = arrayList2.iterator2();
        while (iterator2.hasNext()) {
            OfflineMapCity next = iterator2.next();
            if (next.getState() != 6) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public long getSize() {
        return this.f8303c;
    }

    public int getState() {
        return this.f8302b;
    }

    public String getUrl() {
        return this.f8301a;
    }

    public String getVersion() {
        return this.f8304d;
    }

    public int getcompleteCode() {
        return this.f8305e;
    }

    public void setCityList(ArrayList<OfflineMapCity> arrayList) {
        this.f8306f = arrayList;
    }

    public void setCompleteCode(int i10) {
        this.f8305e = i10;
    }

    public void setSize(long j10) {
        this.f8303c = j10;
    }

    public void setState(int i10) {
        this.f8302b = i10;
    }

    public void setUrl(String str) {
        this.f8301a = str;
    }

    public void setVersion(String str) {
        this.f8304d = str;
    }

    @Override // com.amap.api.maps.offlinemap.Province, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeString(this.f8301a);
        parcel.writeInt(this.f8302b);
        parcel.writeLong(this.f8303c);
        parcel.writeString(this.f8304d);
        parcel.writeInt(this.f8305e);
        parcel.writeTypedList(this.f8306f);
    }

    public OfflineMapProvince(Parcel parcel) {
        super(parcel);
        this.f8302b = 6;
        this.f8305e = 0;
        this.f8301a = parcel.readString();
        this.f8302b = parcel.readInt();
        this.f8303c = parcel.readLong();
        this.f8304d = parcel.readString();
        this.f8305e = parcel.readInt();
        this.f8306f = parcel.createTypedArrayList(OfflineMapCity.CREATOR);
    }
}
