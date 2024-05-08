package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.f0;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class TimeSignalCommand extends SpliceCommand {
    public static final Parcelable.Creator<TimeSignalCommand> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public final long f20955b;

    /* renamed from: c, reason: collision with root package name */
    public final long f20956c;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class a implements Parcelable.Creator<TimeSignalCommand> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TimeSignalCommand createFromParcel(Parcel parcel) {
            return new TimeSignalCommand(parcel.readLong(), parcel.readLong(), null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public TimeSignalCommand[] newArray(int i10) {
            return new TimeSignalCommand[i10];
        }
    }

    public /* synthetic */ TimeSignalCommand(long j10, long j11, a aVar) {
        this(j10, j11);
    }

    public static TimeSignalCommand a(ParsableByteArray parsableByteArray, long j10, f0 f0Var) {
        long b4 = b(parsableByteArray, j10);
        return new TimeSignalCommand(b4, f0Var.b(b4));
    }

    public static long b(ParsableByteArray parsableByteArray, long j10) {
        long D = parsableByteArray.D();
        if ((128 & D) != 0) {
            return 8589934591L & ((((D & 1) << 32) | parsableByteArray.F()) + j10);
        }
        return -9223372036854775807L;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeLong(this.f20955b);
        parcel.writeLong(this.f20956c);
    }

    public TimeSignalCommand(long j10, long j11) {
        this.f20955b = j10;
        this.f20956c = j11;
    }
}
