package com.ss.android.downloadlib.m.m;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class dk implements Parcelable {
    public static final Parcelable.Creator<dk> CREATOR = new Parcelable.Creator<dk>() { // from class: com.ss.android.downloadlib.m.m.dk.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public dk createFromParcel(Parcel parcel) {
            return new dk(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public dk[] newArray(int i10) {
            return new dk[i10];
        }
    };
    public int dk;
    public String ej;

    /* renamed from: l, reason: collision with root package name */
    public int f38799l;

    /* renamed from: m, reason: collision with root package name */
    public int f38800m;

    /* renamed from: n, reason: collision with root package name */
    public String f38801n;
    public String np;

    public dk() {
        this.ej = "";
        this.np = "";
        this.f38801n = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            dk dkVar = (dk) obj;
            if (this.f38800m == dkVar.f38800m && this.dk == dkVar.dk) {
                String str = this.ej;
                if (str != null) {
                    return str.equals(dkVar.ej);
                }
                if (dkVar.ej == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int i10 = ((this.f38800m * 31) + this.dk) * 31;
        String str = this.ej;
        return i10 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f38800m);
        parcel.writeInt(this.dk);
        parcel.writeString(this.ej);
        parcel.writeString(this.np);
        parcel.writeString(this.f38801n);
        parcel.writeInt(this.f38799l);
    }

    public dk(Parcel parcel) {
        this.ej = "";
        this.np = "";
        this.f38801n = "";
        this.f38800m = parcel.readInt();
        this.dk = parcel.readInt();
        this.ej = parcel.readString();
        this.np = parcel.readString();
        this.f38801n = parcel.readString();
        this.f38799l = parcel.readInt();
    }
}
