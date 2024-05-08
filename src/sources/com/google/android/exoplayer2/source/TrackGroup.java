package com.google.android.exoplayer2.source;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.android.internal.logging.nano.MetricsProto;
import com.google.android.exoplayer2.Format;
import java.util.Arrays;
import sun.util.locale.LanguageTag;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class TrackGroup implements Parcelable {
    public static final Parcelable.Creator<TrackGroup> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public final int f21168b;

    /* renamed from: c, reason: collision with root package name */
    public final Format[] f21169c;

    /* renamed from: d, reason: collision with root package name */
    public int f21170d;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class a implements Parcelable.Creator<TrackGroup> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TrackGroup createFromParcel(Parcel parcel) {
            return new TrackGroup(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public TrackGroup[] newArray(int i10) {
            return new TrackGroup[i10];
        }
    }

    public TrackGroup(Format... formatArr) {
        com.google.android.exoplayer2.util.a.g(formatArr.length > 0);
        this.f21169c = formatArr;
        this.f21168b = formatArr.length;
        f();
    }

    public static void c(String str, @Nullable String str2, @Nullable String str3, int i10) {
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 78 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb2.append("Different ");
        sb2.append(str);
        sb2.append(" combined in one TrackGroup: '");
        sb2.append(str2);
        sb2.append("' (track 0) and '");
        sb2.append(str3);
        sb2.append("' (track ");
        sb2.append(i10);
        sb2.append(")");
        com.google.android.exoplayer2.util.m.d("TrackGroup", "", new IllegalStateException(sb2.toString()));
    }

    public static String d(@Nullable String str) {
        return (str == null || str.equals(LanguageTag.UNDETERMINED)) ? "" : str;
    }

    public static int e(int i10) {
        return i10 | 16384;
    }

    public Format a(int i10) {
        return this.f21169c[i10];
    }

    public int b(Format format) {
        int i10 = 0;
        while (true) {
            Format[] formatArr = this.f21169c;
            if (i10 >= formatArr.length) {
                return -1;
            }
            if (format == formatArr[i10]) {
                return i10;
            }
            i10++;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TrackGroup.class != obj.getClass()) {
            return false;
        }
        TrackGroup trackGroup = (TrackGroup) obj;
        return this.f21168b == trackGroup.f21168b && Arrays.equals(this.f21169c, trackGroup.f21169c);
    }

    public final void f() {
        String d10 = d(this.f21169c[0].f19535d);
        int e2 = e(this.f21169c[0].f19537f);
        int i10 = 1;
        while (true) {
            Format[] formatArr = this.f21169c;
            if (i10 >= formatArr.length) {
                return;
            }
            if (!d10.equals(d(formatArr[i10].f19535d))) {
                Format[] formatArr2 = this.f21169c;
                c("languages", formatArr2[0].f19535d, formatArr2[i10].f19535d, i10);
                return;
            } else {
                if (e2 != e(this.f21169c[i10].f19537f)) {
                    c("role flags", Integer.toBinaryString(this.f21169c[0].f19537f), Integer.toBinaryString(this.f21169c[i10].f19537f), i10);
                    return;
                }
                i10++;
            }
        }
    }

    public int hashCode() {
        if (this.f21170d == 0) {
            this.f21170d = MetricsProto.MetricsEvent.DIALOG_SUPPORT_PHONE + Arrays.hashCode(this.f21169c);
        }
        return this.f21170d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f21168b);
        for (int i11 = 0; i11 < this.f21168b; i11++) {
            parcel.writeParcelable(this.f21169c[i11], 0);
        }
    }

    public TrackGroup(Parcel parcel) {
        int readInt = parcel.readInt();
        this.f21168b = readInt;
        this.f21169c = new Format[readInt];
        for (int i10 = 0; i10 < this.f21168b; i10++) {
            this.f21169c[i10] = (Format) parcel.readParcelable(Format.class.getClassLoader());
        }
    }
}
