package com.amap.api.services.auto;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class AutoTChargeStationResult implements Parcelable {
    public static final Parcelable.Creator<AutoTChargeStationResult> CREATOR = new Parcelable.Creator<AutoTChargeStationResult>() { // from class: com.amap.api.services.auto.AutoTChargeStationResult.1
        private static AutoTChargeStationResult a(Parcel parcel) {
            return new AutoTChargeStationResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AutoTChargeStationResult createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AutoTChargeStationResult[] newArray(int i10) {
            return a(i10);
        }

        private static AutoTChargeStationResult[] a(int i10) {
            return new AutoTChargeStationResult[i10];
        }
    };
    public Classify classify;
    public int code;
    public ListData listData;
    public Lqii lqii;
    public String message;
    public Meta meta;
    public String originJson;

    public AutoTChargeStationResult() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.code);
        parcel.writeString(this.message);
        parcel.writeParcelable(this.classify, i10);
        parcel.writeParcelable(this.listData, i10);
        parcel.writeParcelable(this.lqii, i10);
        parcel.writeParcelable(this.meta, i10);
        parcel.writeString(this.originJson);
    }

    public AutoTChargeStationResult(Parcel parcel) {
        this.code = parcel.readInt();
        this.message = parcel.readString();
        this.classify = (Classify) parcel.readParcelable(Classify.class.getClassLoader());
        this.listData = (ListData) parcel.readParcelable(ListData.class.getClassLoader());
        this.lqii = (Lqii) parcel.readParcelable(Lqii.class.getClassLoader());
        this.meta = (Meta) parcel.readParcelable(Meta.class.getClassLoader());
        this.originJson = parcel.readString();
    }
}
