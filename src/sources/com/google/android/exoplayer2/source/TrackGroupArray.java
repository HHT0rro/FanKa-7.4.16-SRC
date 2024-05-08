package com.google.android.exoplayer2.source;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class TrackGroupArray implements Parcelable {

    /* renamed from: b, reason: collision with root package name */
    public final int f21172b;

    /* renamed from: c, reason: collision with root package name */
    public final TrackGroup[] f21173c;

    /* renamed from: d, reason: collision with root package name */
    public int f21174d;

    /* renamed from: e, reason: collision with root package name */
    public static final TrackGroupArray f21171e = new TrackGroupArray(new TrackGroup[0]);
    public static final Parcelable.Creator<TrackGroupArray> CREATOR = new a();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class a implements Parcelable.Creator<TrackGroupArray> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TrackGroupArray createFromParcel(Parcel parcel) {
            return new TrackGroupArray(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public TrackGroupArray[] newArray(int i10) {
            return new TrackGroupArray[i10];
        }
    }

    public TrackGroupArray(TrackGroup... trackGroupArr) {
        this.f21173c = trackGroupArr;
        this.f21172b = trackGroupArr.length;
    }

    public TrackGroup a(int i10) {
        return this.f21173c[i10];
    }

    public int b(TrackGroup trackGroup) {
        for (int i10 = 0; i10 < this.f21172b; i10++) {
            if (this.f21173c[i10] == trackGroup) {
                return i10;
            }
        }
        return -1;
    }

    public boolean c() {
        return this.f21172b == 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TrackGroupArray.class != obj.getClass()) {
            return false;
        }
        TrackGroupArray trackGroupArray = (TrackGroupArray) obj;
        return this.f21172b == trackGroupArray.f21172b && Arrays.equals(this.f21173c, trackGroupArray.f21173c);
    }

    public int hashCode() {
        if (this.f21174d == 0) {
            this.f21174d = Arrays.hashCode(this.f21173c);
        }
        return this.f21174d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f21172b);
        for (int i11 = 0; i11 < this.f21172b; i11++) {
            parcel.writeParcelable(this.f21173c[i11], 0);
        }
    }

    public TrackGroupArray(Parcel parcel) {
        int readInt = parcel.readInt();
        this.f21172b = readInt;
        this.f21173c = new TrackGroup[readInt];
        for (int i10 = 0; i10 < this.f21172b; i10++) {
            this.f21173c[i10] = (TrackGroup) parcel.readParcelable(TrackGroup.class.getClassLoader());
        }
    }
}
