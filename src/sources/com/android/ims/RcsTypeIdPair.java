package com.android.ims;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class RcsTypeIdPair implements Parcelable {
    public static final Parcelable.Creator<RcsTypeIdPair> CREATOR = new Parcelable.Creator<RcsTypeIdPair>() { // from class: com.android.ims.RcsTypeIdPair.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RcsTypeIdPair createFromParcel(Parcel in) {
            return new RcsTypeIdPair(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RcsTypeIdPair[] newArray(int size) {
            return new RcsTypeIdPair[size];
        }
    };
    private int mId;
    private int mType;

    public RcsTypeIdPair(int type, int id2) {
        this.mType = type;
        this.mId = id2;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int type) {
        this.mType = type;
    }

    public int getId() {
        return this.mId;
    }

    public void setId(int id2) {
        this.mId = id2;
    }

    public RcsTypeIdPair(Parcel in) {
        this.mType = in.readInt();
        this.mId = in.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mType);
        dest.writeInt(this.mId);
    }
}