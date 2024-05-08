package com.kwad.framework.filedownloader.message;

import android.os.Parcel;
import com.kwad.framework.filedownloader.message.MessageSnapshot;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class h extends MessageSnapshot {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a extends b implements com.kwad.framework.filedownloader.message.b {
        public a(int i10, boolean z10, int i11) {
            super(i10, true, i11);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class e extends f {
        public e(int i10, int i11, int i12) {
            super(i10, i11, i12);
        }

        @Override // com.kwad.framework.filedownloader.message.h.f, com.kwad.framework.filedownloader.message.c
        public final byte tV() {
            return (byte) -2;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class f extends h {
        private final int ahB;
        private final int ahC;

        public f(f fVar) {
            this(fVar.getId(), fVar.vY(), fVar.vZ());
        }

        public byte tV() {
            return (byte) 1;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int vY() {
            return this.ahC;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int vZ() {
            return this.ahB;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.ahC);
            parcel.writeInt(this.ahB);
        }

        public f(int i10, int i11, int i12) {
            super(i10);
            this.ahC = i11;
            this.ahB = i12;
        }

        public f(Parcel parcel) {
            super(parcel);
            this.ahC = parcel.readInt();
            this.ahB = parcel.readInt();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class i extends j implements com.kwad.framework.filedownloader.message.b {
        public i(int i10, int i11, int i12) {
            super(i10, i11, i12);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class j extends f implements MessageSnapshot.a {
        public j(int i10, int i11, int i12) {
            super(i10, i11, i12);
        }

        @Override // com.kwad.framework.filedownloader.message.h.f, com.kwad.framework.filedownloader.message.c
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

    public h(int i10) {
        super(i10);
        this.ahr = false;
    }

    @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
    public final long wa() {
        return vZ();
    }

    @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
    public final long wc() {
        return vY();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class g extends h {
        private final int ahC;

        public g(int i10, int i11) {
            super(i10);
            this.ahC = i11;
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
        public final int vY() {
            return this.ahC;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.ahC);
        }

        public g(Parcel parcel) {
            super(parcel);
            this.ahC = parcel.readInt();
        }
    }

    /* renamed from: com.kwad.framework.filedownloader.message.h$h, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class C0503h extends d {
        private final int agU;

        public C0503h(int i10, int i11, Throwable th, int i12) {
            super(i10, i11, th);
            this.agU = i12;
        }

        @Override // com.kwad.framework.filedownloader.message.h.d, com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.kwad.framework.filedownloader.message.h.d, com.kwad.framework.filedownloader.message.c
        public final byte tV() {
            return (byte) 5;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int tZ() {
            return this.agU;
        }

        @Override // com.kwad.framework.filedownloader.message.h.d, com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.agU);
        }

        public C0503h(Parcel parcel) {
            super(parcel);
            this.agU = parcel.readInt();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class b extends h {
        private final int ahB;
        private final boolean ahm;

        public b(int i10, boolean z10, int i11) {
            super(i10);
            this.ahm = z10;
            this.ahB = i11;
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
        public final int vZ() {
            return this.ahB;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final boolean wb() {
            return this.ahm;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeByte(this.ahm ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.ahB);
        }

        public b(Parcel parcel) {
            super(parcel);
            this.ahm = parcel.readByte() != 0;
            this.ahB = parcel.readInt();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class d extends h {
        private final int ahC;
        private final Throwable ahq;

        public d(int i10, int i11, Throwable th) {
            super(i10);
            this.ahC = i11;
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
        public final int vY() {
            return this.ahC;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final Throwable wd() {
            return this.ahq;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.ahC);
            parcel.writeSerializable(this.ahq);
        }

        public d(Parcel parcel) {
            super(parcel);
            this.ahC = parcel.readInt();
            this.ahq = (Throwable) parcel.readSerializable();
        }
    }

    public h(Parcel parcel) {
        super(parcel);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class c extends h {
        private final String afJ;
        private final int ahB;
        private final boolean ahn;
        private final String aho;

        public c(int i10, boolean z10, int i11, String str, String str2) {
            super(i10);
            this.ahn = z10;
            this.ahB = i11;
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
        public final int vZ() {
            return this.ahB;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeByte(this.ahn ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.ahB);
            parcel.writeString(this.afJ);
            parcel.writeString(this.aho);
        }

        public c(Parcel parcel) {
            super(parcel);
            this.ahn = parcel.readByte() != 0;
            this.ahB = parcel.readInt();
            this.afJ = parcel.readString();
            this.aho = parcel.readString();
        }
    }
}
