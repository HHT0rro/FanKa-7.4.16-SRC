package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.j0;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class PrivateCommand extends SpliceCommand {
    public static final Parcelable.Creator<PrivateCommand> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public final long f20933b;

    /* renamed from: c, reason: collision with root package name */
    public final long f20934c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f20935d;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class a implements Parcelable.Creator<PrivateCommand> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PrivateCommand createFromParcel(Parcel parcel) {
            return new PrivateCommand(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public PrivateCommand[] newArray(int i10) {
            return new PrivateCommand[i10];
        }
    }

    public /* synthetic */ PrivateCommand(Parcel parcel, a aVar) {
        this(parcel);
    }

    public static PrivateCommand a(ParsableByteArray parsableByteArray, int i10, long j10) {
        long F = parsableByteArray.F();
        int i11 = i10 - 4;
        byte[] bArr = new byte[i11];
        parsableByteArray.j(bArr, 0, i11);
        return new PrivateCommand(F, bArr, j10);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeLong(this.f20933b);
        parcel.writeLong(this.f20934c);
        parcel.writeByteArray(this.f20935d);
    }

    public PrivateCommand(long j10, byte[] bArr, long j11) {
        this.f20933b = j11;
        this.f20934c = j10;
        this.f20935d = bArr;
    }

    public PrivateCommand(Parcel parcel) {
        this.f20933b = parcel.readLong();
        this.f20934c = parcel.readLong();
        this.f20935d = (byte[]) j0.j(parcel.createByteArray());
    }
}
