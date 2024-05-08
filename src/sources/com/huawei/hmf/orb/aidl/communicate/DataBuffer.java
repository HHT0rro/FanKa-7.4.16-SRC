package com.huawei.hmf.orb.aidl.communicate;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class DataBuffer implements Parcelable {
    public static final Parcelable.Creator<DataBuffer> CREATOR = new Parcelable.Creator<DataBuffer>() { // from class: com.huawei.hmf.orb.aidl.communicate.DataBuffer.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DataBuffer createFromParcel(Parcel parcel) {
            return new DataBuffer(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DataBuffer[] newArray(int i10) {
            return new DataBuffer[i10];
        }
    };
    public String URI;
    private Bundle body;
    public Bundle header;
    private int version;

    private static ClassLoader getClassLoader(Class cls) {
        return cls == null ? ClassLoader.getSystemClassLoader() : cls.getClassLoader();
    }

    private void readFromParcel(Parcel parcel) {
        this.version = parcel.readInt();
        this.URI = parcel.readString();
        this.header = parcel.readBundle(getClassLoader(getClass()));
        this.body = parcel.readBundle(getClassLoader(getClass()));
    }

    public DataBuffer addBody(Bundle bundle) {
        this.body = bundle;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Bundle getBody() {
        return this.body;
    }

    public int getBodySize() {
        return this.body == null ? 0 : 1;
    }

    public int getProtocol() {
        return this.version;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.version);
        parcel.writeString(this.URI);
        parcel.writeBundle(this.header);
        parcel.writeBundle(this.body);
    }

    private DataBuffer(Parcel parcel) {
        this.version = 1;
        this.header = null;
        this.body = null;
        readFromParcel(parcel);
    }

    public DataBuffer() {
        this.version = 1;
        this.header = null;
        this.body = null;
    }

    public DataBuffer(String str) {
        this.version = 1;
        this.header = null;
        this.body = null;
        this.URI = str;
    }

    public DataBuffer(String str, int i10) {
        this.header = null;
        this.body = null;
        this.URI = str;
        this.version = i10;
    }
}
