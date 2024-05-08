package com.google.android.exoplayer2.offline;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class StreamKey implements Comparable<StreamKey>, Parcelable {
    public static final Parcelable.Creator<StreamKey> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public final int f21019b;

    /* renamed from: c, reason: collision with root package name */
    public final int f21020c;

    /* renamed from: d, reason: collision with root package name */
    public final int f21021d;

    /* renamed from: e, reason: collision with root package name */
    @Deprecated
    public final int f21022e;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class a implements Parcelable.Creator<StreamKey> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public StreamKey createFromParcel(Parcel parcel) {
            return new StreamKey(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public StreamKey[] newArray(int i10) {
            return new StreamKey[i10];
        }
    }

    public StreamKey(int i10, int i11, int i12) {
        this.f21019b = i10;
        this.f21020c = i11;
        this.f21021d = i12;
        this.f21022e = i12;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(StreamKey streamKey) {
        int i10 = this.f21019b - streamKey.f21019b;
        if (i10 != 0) {
            return i10;
        }
        int i11 = this.f21020c - streamKey.f21020c;
        return i11 == 0 ? this.f21021d - streamKey.f21021d : i11;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || StreamKey.class != obj.getClass()) {
            return false;
        }
        StreamKey streamKey = (StreamKey) obj;
        return this.f21019b == streamKey.f21019b && this.f21020c == streamKey.f21020c && this.f21021d == streamKey.f21021d;
    }

    public int hashCode() {
        return (((this.f21019b * 31) + this.f21020c) * 31) + this.f21021d;
    }

    public String toString() {
        int i10 = this.f21019b;
        int i11 = this.f21020c;
        int i12 = this.f21021d;
        StringBuilder sb2 = new StringBuilder(35);
        sb2.append(i10);
        sb2.append(".");
        sb2.append(i11);
        sb2.append(".");
        sb2.append(i12);
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f21019b);
        parcel.writeInt(this.f21020c);
        parcel.writeInt(this.f21021d);
    }

    public StreamKey(Parcel parcel) {
        this.f21019b = parcel.readInt();
        this.f21020c = parcel.readInt();
        int readInt = parcel.readInt();
        this.f21021d = readInt;
        this.f21022e = readInt;
    }
}
