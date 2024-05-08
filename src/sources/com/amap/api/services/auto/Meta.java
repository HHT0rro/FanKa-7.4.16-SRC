package com.amap.api.services.auto;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class Meta implements Parcelable {
    public static final Parcelable.Creator<Meta> CREATOR = new Parcelable.Creator<Meta>() { // from class: com.amap.api.services.auto.Meta.1
        private static Meta a(Parcel parcel) {
            return new Meta(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Meta createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Meta[] newArray(int i10) {
            return a(i10);
        }

        private static Meta[] a(int i10) {
            return new Meta[i10];
        }
    };
    public String listBizType;

    public Meta() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.listBizType);
    }

    public Meta(Parcel parcel) {
        this.listBizType = parcel.readString();
    }
}
