package com.google.android.exoplayer2.video;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.android.internal.logging.nano.MetricsProto;
import com.google.android.exoplayer2.util.j0;
import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ColorInfo implements Parcelable {
    public static final Parcelable.Creator<ColorInfo> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public final int f23041b;

    /* renamed from: c, reason: collision with root package name */
    public final int f23042c;

    /* renamed from: d, reason: collision with root package name */
    public final int f23043d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public final byte[] f23044e;

    /* renamed from: f, reason: collision with root package name */
    public int f23045f;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class a implements Parcelable.Creator<ColorInfo> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ColorInfo createFromParcel(Parcel parcel) {
            return new ColorInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ColorInfo[] newArray(int i10) {
            return new ColorInfo[i10];
        }
    }

    public ColorInfo(int i10, int i11, int i12, @Nullable byte[] bArr) {
        this.f23041b = i10;
        this.f23042c = i11;
        this.f23043d = i12;
        this.f23044e = bArr;
    }

    public static int a(int i10) {
        if (i10 == 1) {
            return 1;
        }
        if (i10 != 9) {
            return (i10 == 4 || i10 == 5 || i10 == 6 || i10 == 7) ? 2 : -1;
        }
        return 6;
    }

    public static int b(int i10) {
        if (i10 == 1) {
            return 3;
        }
        if (i10 == 16) {
            return 6;
        }
        if (i10 != 18) {
            return (i10 == 6 || i10 == 7) ? 3 : -1;
        }
        return 7;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ColorInfo.class != obj.getClass()) {
            return false;
        }
        ColorInfo colorInfo = (ColorInfo) obj;
        return this.f23041b == colorInfo.f23041b && this.f23042c == colorInfo.f23042c && this.f23043d == colorInfo.f23043d && Arrays.equals(this.f23044e, colorInfo.f23044e);
    }

    public int hashCode() {
        if (this.f23045f == 0) {
            this.f23045f = ((((((MetricsProto.MetricsEvent.DIALOG_SUPPORT_PHONE + this.f23041b) * 31) + this.f23042c) * 31) + this.f23043d) * 31) + Arrays.hashCode(this.f23044e);
        }
        return this.f23045f;
    }

    public String toString() {
        int i10 = this.f23041b;
        int i11 = this.f23042c;
        int i12 = this.f23043d;
        boolean z10 = this.f23044e != null;
        StringBuilder sb2 = new StringBuilder(55);
        sb2.append("ColorInfo(");
        sb2.append(i10);
        sb2.append(", ");
        sb2.append(i11);
        sb2.append(", ");
        sb2.append(i12);
        sb2.append(", ");
        sb2.append(z10);
        sb2.append(")");
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f23041b);
        parcel.writeInt(this.f23042c);
        parcel.writeInt(this.f23043d);
        j0.Y0(parcel, this.f23044e != null);
        byte[] bArr = this.f23044e;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
    }

    public ColorInfo(Parcel parcel) {
        this.f23041b = parcel.readInt();
        this.f23042c = parcel.readInt();
        this.f23043d = parcel.readInt();
        this.f23044e = j0.F0(parcel) ? parcel.createByteArray() : null;
    }
}
