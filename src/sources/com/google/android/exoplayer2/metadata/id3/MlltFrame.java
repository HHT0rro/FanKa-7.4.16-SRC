package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.android.internal.logging.nano.MetricsProto;
import com.google.android.exoplayer2.util.j0;
import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MlltFrame extends Id3Frame {
    public static final Parcelable.Creator<MlltFrame> CREATOR = new a();

    /* renamed from: c, reason: collision with root package name */
    public final int f20907c;

    /* renamed from: d, reason: collision with root package name */
    public final int f20908d;

    /* renamed from: e, reason: collision with root package name */
    public final int f20909e;

    /* renamed from: f, reason: collision with root package name */
    public final int[] f20910f;

    /* renamed from: g, reason: collision with root package name */
    public final int[] f20911g;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class a implements Parcelable.Creator<MlltFrame> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MlltFrame createFromParcel(Parcel parcel) {
            return new MlltFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public MlltFrame[] newArray(int i10) {
            return new MlltFrame[i10];
        }
    }

    public MlltFrame(int i10, int i11, int i12, int[] iArr, int[] iArr2) {
        super("MLLT");
        this.f20907c = i10;
        this.f20908d = i11;
        this.f20909e = i12;
        this.f20910f = iArr;
        this.f20911g = iArr2;
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MlltFrame.class != obj.getClass()) {
            return false;
        }
        MlltFrame mlltFrame = (MlltFrame) obj;
        return this.f20907c == mlltFrame.f20907c && this.f20908d == mlltFrame.f20908d && this.f20909e == mlltFrame.f20909e && Arrays.equals(this.f20910f, mlltFrame.f20910f) && Arrays.equals(this.f20911g, mlltFrame.f20911g);
    }

    public int hashCode() {
        return ((((((((MetricsProto.MetricsEvent.DIALOG_SUPPORT_PHONE + this.f20907c) * 31) + this.f20908d) * 31) + this.f20909e) * 31) + Arrays.hashCode(this.f20910f)) * 31) + Arrays.hashCode(this.f20911g);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f20907c);
        parcel.writeInt(this.f20908d);
        parcel.writeInt(this.f20909e);
        parcel.writeIntArray(this.f20910f);
        parcel.writeIntArray(this.f20911g);
    }

    public MlltFrame(Parcel parcel) {
        super("MLLT");
        this.f20907c = parcel.readInt();
        this.f20908d = parcel.readInt();
        this.f20909e = parcel.readInt();
        this.f20910f = (int[]) j0.j(parcel.createIntArray());
        this.f20911g = (int[]) j0.j(parcel.createIntArray());
    }
}
