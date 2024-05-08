package com.kwad.framework.filedownloader.message;

import android.os.Parcel;
import com.kwad.framework.filedownloader.message.MessageSnapshot;
import java.util.zip.ZipUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class d extends MessageSnapshot {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a extends b implements com.kwad.framework.filedownloader.message.b {
        public a(int i10, boolean z10, long j10) {
            super(i10, true, j10);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class e extends f {
        public e(int i10, long j10, long j11) {
            super(i10, j10, j11);
        }

        @Override // com.kwad.framework.filedownloader.message.d.f, com.kwad.framework.filedownloader.message.c
        public final byte tV() {
            return (byte) -2;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class f extends d {
        private final long ahp;
        private final long totalBytes;

        public f(f fVar) {
            this(fVar.getId(), fVar.wc(), fVar.wa());
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public byte tV() {
            return (byte) 1;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final long wa() {
            return this.totalBytes;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final long wc() {
            return this.ahp;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeLong(this.ahp);
            parcel.writeLong(this.totalBytes);
        }

        public f(int i10, long j10, long j11) {
            super(i10);
            this.ahp = j10;
            this.totalBytes = j11;
        }

        public f(Parcel parcel) {
            super(parcel);
            this.ahp = parcel.readLong();
            this.totalBytes = parcel.readLong();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class i extends j implements com.kwad.framework.filedownloader.message.b {
        public i(int i10, long j10, long j11) {
            super(i10, j10, j11);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class j extends f implements MessageSnapshot.a {
        public j(int i10, long j10, long j11) {
            super(i10, j10, j11);
        }

        @Override // com.kwad.framework.filedownloader.message.d.f, com.kwad.framework.filedownloader.message.c
        public final byte tV() {
            return (byte) -4;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot.a
        public final MessageSnapshot we() {
            return new f(this);
        }

        public j(Parcel parcel) {
            super(parcel);
        }
    }

    public d(int i10) {
        super(i10);
        this.ahr = true;
    }

    @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
    public final int vY() {
        if (wc() > ZipUtils.UPPER_UNIXTIME_BOUND) {
            return Integer.MAX_VALUE;
        }
        return (int) wc();
    }

    @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
    public final int vZ() {
        if (wa() > ZipUtils.UPPER_UNIXTIME_BOUND) {
            return Integer.MAX_VALUE;
        }
        return (int) wa();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class g extends d {
        private final long ahp;

        public g(int i10, long j10) {
            super(i10);
            this.ahp = j10;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.kwad.framework.filedownloader.message.c
        public final byte tV() {
            return (byte) 3;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final long wc() {
            return this.ahp;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeLong(this.ahp);
        }

        public g(Parcel parcel) {
            super(parcel);
            this.ahp = parcel.readLong();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class h extends C0502d {
        private final int agU;

        public h(int i10, long j10, Throwable th, int i11) {
            super(i10, j10, th);
            this.agU = i11;
        }

        @Override // com.kwad.framework.filedownloader.message.d.C0502d, com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.kwad.framework.filedownloader.message.d.C0502d, com.kwad.framework.filedownloader.message.c
        public final byte tV() {
            return (byte) 5;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int tZ() {
            return this.agU;
        }

        @Override // com.kwad.framework.filedownloader.message.d.C0502d, com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.agU);
        }

        public h(Parcel parcel) {
            super(parcel);
            this.agU = parcel.readInt();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class b extends d {
        private final boolean ahm;
        private final long totalBytes;

        public b(int i10, boolean z10, long j10) {
            super(i10);
            this.ahm = z10;
            this.totalBytes = j10;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwad.framework.filedownloader.message.c
        public final byte tV() {
            return (byte) -3;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final long wa() {
            return this.totalBytes;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final boolean wb() {
            return this.ahm;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeByte(this.ahm ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.totalBytes);
        }

        public b(Parcel parcel) {
            super(parcel);
            this.ahm = parcel.readByte() != 0;
            this.totalBytes = parcel.readLong();
        }
    }

    /* renamed from: com.kwad.framework.filedownloader.message.d$d, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class C0502d extends d {
        private final long ahp;
        private final Throwable ahq;

        public C0502d(int i10, long j10, Throwable th) {
            super(i10);
            this.ahp = j10;
            this.ahq = th;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwad.framework.filedownloader.message.c
        public byte tV() {
            return (byte) -1;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final long wc() {
            return this.ahp;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final Throwable wd() {
            return this.ahq;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeLong(this.ahp);
            parcel.writeSerializable(this.ahq);
        }

        public C0502d(Parcel parcel) {
            super(parcel);
            this.ahp = parcel.readLong();
            this.ahq = (Throwable) parcel.readSerializable();
        }
    }

    public d(Parcel parcel) {
        super(parcel);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class c extends d {
        private final String afJ;
        private final boolean ahn;
        private final String aho;
        private final long totalBytes;

        public c(int i10, boolean z10, long j10, String str, String str2) {
            super(i10);
            this.ahn = z10;
            this.totalBytes = j10;
            this.afJ = str;
            this.aho = str2;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final String getEtag() {
            return this.afJ;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final String getFileName() {
            return this.aho;
        }

        @Override // com.kwad.framework.filedownloader.message.c
        public final byte tV() {
            return (byte) 2;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final boolean vQ() {
            return this.ahn;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final long wa() {
            return this.totalBytes;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeByte(this.ahn ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.totalBytes);
            parcel.writeString(this.afJ);
            parcel.writeString(this.aho);
        }

        public c(Parcel parcel) {
            super(parcel);
            this.ahn = parcel.readByte() != 0;
            this.totalBytes = parcel.readLong();
            this.afJ = parcel.readString();
            this.aho = parcel.readString();
        }
    }
}
