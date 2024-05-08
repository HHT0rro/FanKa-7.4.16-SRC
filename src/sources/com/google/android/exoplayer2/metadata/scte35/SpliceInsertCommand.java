package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.f0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SpliceInsertCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceInsertCommand> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public final long f20936b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f20937c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f20938d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f20939e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f20940f;

    /* renamed from: g, reason: collision with root package name */
    public final long f20941g;

    /* renamed from: h, reason: collision with root package name */
    public final long f20942h;

    /* renamed from: i, reason: collision with root package name */
    public final List<b> f20943i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f20944j;

    /* renamed from: k, reason: collision with root package name */
    public final long f20945k;

    /* renamed from: l, reason: collision with root package name */
    public final int f20946l;

    /* renamed from: m, reason: collision with root package name */
    public final int f20947m;

    /* renamed from: n, reason: collision with root package name */
    public final int f20948n;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class a implements Parcelable.Creator<SpliceInsertCommand> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SpliceInsertCommand createFromParcel(Parcel parcel) {
            return new SpliceInsertCommand(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public SpliceInsertCommand[] newArray(int i10) {
            return new SpliceInsertCommand[i10];
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f20949a;

        /* renamed from: b, reason: collision with root package name */
        public final long f20950b;

        /* renamed from: c, reason: collision with root package name */
        public final long f20951c;

        public /* synthetic */ b(int i10, long j10, long j11, a aVar) {
            this(i10, j10, j11);
        }

        public static b a(Parcel parcel) {
            return new b(parcel.readInt(), parcel.readLong(), parcel.readLong());
        }

        public void b(Parcel parcel) {
            parcel.writeInt(this.f20949a);
            parcel.writeLong(this.f20950b);
            parcel.writeLong(this.f20951c);
        }

        public b(int i10, long j10, long j11) {
            this.f20949a = i10;
            this.f20950b = j10;
            this.f20951c = j11;
        }
    }

    public /* synthetic */ SpliceInsertCommand(Parcel parcel, a aVar) {
        this(parcel);
    }

    public static SpliceInsertCommand a(ParsableByteArray parsableByteArray, long j10, f0 f0Var) {
        List list;
        boolean z10;
        boolean z11;
        long j11;
        boolean z12;
        long j12;
        int i10;
        int i11;
        int i12;
        boolean z13;
        boolean z14;
        long j13;
        long F = parsableByteArray.F();
        boolean z15 = (parsableByteArray.D() & 128) != 0;
        List emptyList = Collections.emptyList();
        if (z15) {
            list = emptyList;
            z10 = false;
            z11 = false;
            j11 = -9223372036854775807L;
            z12 = false;
            j12 = -9223372036854775807L;
            i10 = 0;
            i11 = 0;
            i12 = 0;
            z13 = false;
        } else {
            int D = parsableByteArray.D();
            boolean z16 = (D & 128) != 0;
            boolean z17 = (D & 64) != 0;
            boolean z18 = (D & 32) != 0;
            boolean z19 = (D & 16) != 0;
            long b4 = (!z17 || z19) ? -9223372036854775807L : TimeSignalCommand.b(parsableByteArray, j10);
            if (!z17) {
                int D2 = parsableByteArray.D();
                ArrayList arrayList = new ArrayList(D2);
                for (int i13 = 0; i13 < D2; i13++) {
                    int D3 = parsableByteArray.D();
                    long b10 = !z19 ? TimeSignalCommand.b(parsableByteArray, j10) : -9223372036854775807L;
                    arrayList.add(new b(D3, b10, f0Var.b(b10), null));
                }
                emptyList = arrayList;
            }
            if (z18) {
                long D4 = parsableByteArray.D();
                boolean z20 = (128 & D4) != 0;
                j13 = ((((D4 & 1) << 32) | parsableByteArray.F()) * 1000) / 90;
                z14 = z20;
            } else {
                z14 = false;
                j13 = -9223372036854775807L;
            }
            i10 = parsableByteArray.J();
            z13 = z17;
            i11 = parsableByteArray.D();
            i12 = parsableByteArray.D();
            list = emptyList;
            long j14 = b4;
            z12 = z14;
            j12 = j13;
            z11 = z19;
            z10 = z16;
            j11 = j14;
        }
        return new SpliceInsertCommand(F, z15, z10, z13, z11, j11, f0Var.b(j11), list, z12, j12, i10, i11, i12);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeLong(this.f20936b);
        parcel.writeByte(this.f20937c ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f20938d ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f20939e ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f20940f ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f20941g);
        parcel.writeLong(this.f20942h);
        int size = this.f20943i.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            this.f20943i.get(i11).b(parcel);
        }
        parcel.writeByte(this.f20944j ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f20945k);
        parcel.writeInt(this.f20946l);
        parcel.writeInt(this.f20947m);
        parcel.writeInt(this.f20948n);
    }

    public SpliceInsertCommand(long j10, boolean z10, boolean z11, boolean z12, boolean z13, long j11, long j12, List<b> list, boolean z14, long j13, int i10, int i11, int i12) {
        this.f20936b = j10;
        this.f20937c = z10;
        this.f20938d = z11;
        this.f20939e = z12;
        this.f20940f = z13;
        this.f20941g = j11;
        this.f20942h = j12;
        this.f20943i = Collections.unmodifiableList(list);
        this.f20944j = z14;
        this.f20945k = j13;
        this.f20946l = i10;
        this.f20947m = i11;
        this.f20948n = i12;
    }

    public SpliceInsertCommand(Parcel parcel) {
        this.f20936b = parcel.readLong();
        this.f20937c = parcel.readByte() == 1;
        this.f20938d = parcel.readByte() == 1;
        this.f20939e = parcel.readByte() == 1;
        this.f20940f = parcel.readByte() == 1;
        this.f20941g = parcel.readLong();
        this.f20942h = parcel.readLong();
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i10 = 0; i10 < readInt; i10++) {
            arrayList.add(b.a(parcel));
        }
        this.f20943i = Collections.unmodifiableList(arrayList);
        this.f20944j = parcel.readByte() == 1;
        this.f20945k = parcel.readLong();
        this.f20946l = parcel.readInt();
        this.f20947m = parcel.readInt();
        this.f20948n = parcel.readInt();
    }
}
