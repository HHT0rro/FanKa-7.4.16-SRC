package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class IndoorDataV2 implements Parcelable {
    public static final Parcelable.Creator<IndoorDataV2> CREATOR = new Parcelable.Creator<IndoorDataV2>() { // from class: com.amap.api.services.poisearch.IndoorDataV2.1
        private static IndoorDataV2 a(Parcel parcel) {
            return new IndoorDataV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ IndoorDataV2 createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ IndoorDataV2[] newArray(int i10) {
            return a(i10);
        }

        private static IndoorDataV2[] a(int i10) {
            return new IndoorDataV2[i10];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private boolean f8618a;

    /* renamed from: b, reason: collision with root package name */
    private String f8619b;

    /* renamed from: c, reason: collision with root package name */
    private int f8620c;

    /* renamed from: d, reason: collision with root package name */
    private String f8621d;

    public IndoorDataV2(boolean z10, String str, int i10, String str2) {
        this.f8618a = z10;
        this.f8619b = str;
        this.f8620c = i10;
        this.f8621d = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getFloor() {
        return this.f8620c;
    }

    public String getFloorName() {
        return this.f8621d;
    }

    public String getPoiId() {
        return this.f8619b;
    }

    public boolean isIndoorMap() {
        return this.f8618a;
    }

    public void setFloor(int i10) {
        this.f8620c = i10;
    }

    public void setFloorName(String str) {
        this.f8621d = str;
    }

    public void setIndoorMap(boolean z10) {
        this.f8618a = z10;
    }

    public void setPoiId(String str) {
        this.f8619b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeBooleanArray(new boolean[]{this.f8618a});
        parcel.writeString(this.f8619b);
        parcel.writeInt(this.f8620c);
        parcel.writeString(this.f8621d);
    }

    public IndoorDataV2(Parcel parcel) {
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        this.f8618a = zArr[0];
        this.f8619b = parcel.readString();
        this.f8620c = parcel.readInt();
        this.f8621d = parcel.readString();
    }
}
