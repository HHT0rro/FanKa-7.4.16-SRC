package com.tencent.turingface.sdk.mfa;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class SWw7W implements Parcelable {

    /* renamed from: a, reason: collision with root package name */
    public int f45705a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f45706b;

    /* renamed from: c, reason: collision with root package name */
    public int f45707c;

    public SWw7W(Parcel parcel) {
        this.f45705a = parcel.readInt();
        this.f45706b = parcel.createByteArray();
        this.f45707c = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f45705a);
        parcel.writeByteArray(this.f45706b);
        parcel.writeInt(this.f45707c);
    }
}
