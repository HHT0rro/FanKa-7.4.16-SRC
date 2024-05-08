package com.google.android.exoplayer2;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.android.internal.logging.nano.MetricsProto;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.video.ColorInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class Format implements Parcelable {
    public static final Parcelable.Creator<Format> CREATOR = new a();
    public final int A;
    public final int B;
    public final int C;
    public final int D;
    public final int E;

    @Nullable
    public final Class<? extends b5.v> F;
    public int G;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f19533b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public final String f19534c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public final String f19535d;

    /* renamed from: e, reason: collision with root package name */
    public final int f19536e;

    /* renamed from: f, reason: collision with root package name */
    public final int f19537f;

    /* renamed from: g, reason: collision with root package name */
    public final int f19538g;

    /* renamed from: h, reason: collision with root package name */
    public final int f19539h;

    /* renamed from: i, reason: collision with root package name */
    public final int f19540i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public final String f19541j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    public final Metadata f19542k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    public final String f19543l;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    public final String f19544m;

    /* renamed from: n, reason: collision with root package name */
    public final int f19545n;

    /* renamed from: o, reason: collision with root package name */
    public final List<byte[]> f19546o;

    /* renamed from: p, reason: collision with root package name */
    @Nullable
    public final DrmInitData f19547p;

    /* renamed from: q, reason: collision with root package name */
    public final long f19548q;

    /* renamed from: r, reason: collision with root package name */
    public final int f19549r;

    /* renamed from: s, reason: collision with root package name */
    public final int f19550s;

    /* renamed from: t, reason: collision with root package name */
    public final float f19551t;

    /* renamed from: u, reason: collision with root package name */
    public final int f19552u;

    /* renamed from: v, reason: collision with root package name */
    public final float f19553v;

    /* renamed from: w, reason: collision with root package name */
    @Nullable
    public final byte[] f19554w;

    /* renamed from: x, reason: collision with root package name */
    public final int f19555x;

    /* renamed from: y, reason: collision with root package name */
    @Nullable
    public final ColorInfo f19556y;

    /* renamed from: z, reason: collision with root package name */
    public final int f19557z;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class a implements Parcelable.Creator<Format> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Format createFromParcel(Parcel parcel) {
            return new Format(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Format[] newArray(int i10) {
            return new Format[i10];
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b {
        public int A;
        public int B;
        public int C;

        @Nullable
        public Class<? extends b5.v> D;

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        public String f19558a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public String f19559b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        public String f19560c;

        /* renamed from: d, reason: collision with root package name */
        public int f19561d;

        /* renamed from: e, reason: collision with root package name */
        public int f19562e;

        /* renamed from: f, reason: collision with root package name */
        public int f19563f;

        /* renamed from: g, reason: collision with root package name */
        public int f19564g;

        /* renamed from: h, reason: collision with root package name */
        @Nullable
        public String f19565h;

        /* renamed from: i, reason: collision with root package name */
        @Nullable
        public Metadata f19566i;

        /* renamed from: j, reason: collision with root package name */
        @Nullable
        public String f19567j;

        /* renamed from: k, reason: collision with root package name */
        @Nullable
        public String f19568k;

        /* renamed from: l, reason: collision with root package name */
        public int f19569l;

        /* renamed from: m, reason: collision with root package name */
        @Nullable
        public List<byte[]> f19570m;

        /* renamed from: n, reason: collision with root package name */
        @Nullable
        public DrmInitData f19571n;

        /* renamed from: o, reason: collision with root package name */
        public long f19572o;

        /* renamed from: p, reason: collision with root package name */
        public int f19573p;

        /* renamed from: q, reason: collision with root package name */
        public int f19574q;

        /* renamed from: r, reason: collision with root package name */
        public float f19575r;

        /* renamed from: s, reason: collision with root package name */
        public int f19576s;

        /* renamed from: t, reason: collision with root package name */
        public float f19577t;

        /* renamed from: u, reason: collision with root package name */
        @Nullable
        public byte[] f19578u;

        /* renamed from: v, reason: collision with root package name */
        public int f19579v;

        /* renamed from: w, reason: collision with root package name */
        @Nullable
        public ColorInfo f19580w;

        /* renamed from: x, reason: collision with root package name */
        public int f19581x;

        /* renamed from: y, reason: collision with root package name */
        public int f19582y;

        /* renamed from: z, reason: collision with root package name */
        public int f19583z;

        public /* synthetic */ b(Format format, a aVar) {
            this(format);
        }

        public Format E() {
            return new Format(this, null);
        }

        public b F(int i10) {
            this.C = i10;
            return this;
        }

        public b G(int i10) {
            this.f19563f = i10;
            return this;
        }

        public b H(int i10) {
            this.f19581x = i10;
            return this;
        }

        public b I(@Nullable String str) {
            this.f19565h = str;
            return this;
        }

        public b J(@Nullable ColorInfo colorInfo) {
            this.f19580w = colorInfo;
            return this;
        }

        public b K(@Nullable String str) {
            this.f19567j = str;
            return this;
        }

        public b L(@Nullable DrmInitData drmInitData) {
            this.f19571n = drmInitData;
            return this;
        }

        public b M(int i10) {
            this.A = i10;
            return this;
        }

        public b N(int i10) {
            this.B = i10;
            return this;
        }

        public b O(@Nullable Class<? extends b5.v> cls) {
            this.D = cls;
            return this;
        }

        public b P(float f10) {
            this.f19575r = f10;
            return this;
        }

        public b Q(int i10) {
            this.f19574q = i10;
            return this;
        }

        public b R(int i10) {
            this.f19558a = Integer.toString(i10);
            return this;
        }

        public b S(@Nullable String str) {
            this.f19558a = str;
            return this;
        }

        public b T(@Nullable List<byte[]> list) {
            this.f19570m = list;
            return this;
        }

        public b U(@Nullable String str) {
            this.f19559b = str;
            return this;
        }

        public b V(@Nullable String str) {
            this.f19560c = str;
            return this;
        }

        public b W(int i10) {
            this.f19569l = i10;
            return this;
        }

        public b X(@Nullable Metadata metadata) {
            this.f19566i = metadata;
            return this;
        }

        public b Y(int i10) {
            this.f19583z = i10;
            return this;
        }

        public b Z(int i10) {
            this.f19564g = i10;
            return this;
        }

        public b a0(float f10) {
            this.f19577t = f10;
            return this;
        }

        public b b0(@Nullable byte[] bArr) {
            this.f19578u = bArr;
            return this;
        }

        public b c0(int i10) {
            this.f19562e = i10;
            return this;
        }

        public b d0(int i10) {
            this.f19576s = i10;
            return this;
        }

        public b e0(@Nullable String str) {
            this.f19568k = str;
            return this;
        }

        public b f0(int i10) {
            this.f19582y = i10;
            return this;
        }

        public b g0(int i10) {
            this.f19561d = i10;
            return this;
        }

        public b h0(int i10) {
            this.f19579v = i10;
            return this;
        }

        public b i0(long j10) {
            this.f19572o = j10;
            return this;
        }

        public b j0(int i10) {
            this.f19573p = i10;
            return this;
        }

        public b() {
            this.f19563f = -1;
            this.f19564g = -1;
            this.f19569l = -1;
            this.f19572o = Long.MAX_VALUE;
            this.f19573p = -1;
            this.f19574q = -1;
            this.f19575r = -1.0f;
            this.f19577t = 1.0f;
            this.f19579v = -1;
            this.f19581x = -1;
            this.f19582y = -1;
            this.f19583z = -1;
            this.C = -1;
        }

        public b(Format format) {
            this.f19558a = format.f19533b;
            this.f19559b = format.f19534c;
            this.f19560c = format.f19535d;
            this.f19561d = format.f19536e;
            this.f19562e = format.f19537f;
            this.f19563f = format.f19538g;
            this.f19564g = format.f19539h;
            this.f19565h = format.f19541j;
            this.f19566i = format.f19542k;
            this.f19567j = format.f19543l;
            this.f19568k = format.f19544m;
            this.f19569l = format.f19545n;
            this.f19570m = format.f19546o;
            this.f19571n = format.f19547p;
            this.f19572o = format.f19548q;
            this.f19573p = format.f19549r;
            this.f19574q = format.f19550s;
            this.f19575r = format.f19551t;
            this.f19576s = format.f19552u;
            this.f19577t = format.f19553v;
            this.f19578u = format.f19554w;
            this.f19579v = format.f19555x;
            this.f19580w = format.f19556y;
            this.f19581x = format.f19557z;
            this.f19582y = format.A;
            this.f19583z = format.B;
            this.A = format.C;
            this.B = format.D;
            this.C = format.E;
            this.D = format.F;
        }
    }

    public /* synthetic */ Format(b bVar, a aVar) {
        this(bVar);
    }

    public b a() {
        return new b(this, null);
    }

    public Format b(@Nullable Class<? extends b5.v> cls) {
        return a().O(cls).E();
    }

    public int c() {
        int i10;
        int i11 = this.f19549r;
        if (i11 == -1 || (i10 = this.f19550s) == -1) {
            return -1;
        }
        return i11 * i10;
    }

    public boolean d(Format format) {
        if (this.f19546o.size() != format.f19546o.size()) {
            return false;
        }
        for (int i10 = 0; i10 < this.f19546o.size(); i10++) {
            if (!Arrays.equals(this.f19546o.get(i10), format.f19546o.get(i10))) {
                return false;
            }
        }
        return true;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Format e(Format format) {
        String str;
        Metadata b4;
        if (this == format) {
            return this;
        }
        int l10 = com.google.android.exoplayer2.util.q.l(this.f19544m);
        String str2 = format.f19533b;
        String str3 = format.f19534c;
        if (str3 == null) {
            str3 = this.f19534c;
        }
        String str4 = this.f19535d;
        if ((l10 == 3 || l10 == 1) && (str = format.f19535d) != null) {
            str4 = str;
        }
        int i10 = this.f19538g;
        if (i10 == -1) {
            i10 = format.f19538g;
        }
        int i11 = this.f19539h;
        if (i11 == -1) {
            i11 = format.f19539h;
        }
        String str5 = this.f19541j;
        if (str5 == null) {
            String K = com.google.android.exoplayer2.util.j0.K(format.f19541j, l10);
            if (com.google.android.exoplayer2.util.j0.O0(K).length == 1) {
                str5 = K;
            }
        }
        Metadata metadata = this.f19542k;
        if (metadata == null) {
            b4 = format.f19542k;
        } else {
            b4 = metadata.b(format.f19542k);
        }
        float f10 = this.f19551t;
        if (f10 == -1.0f && l10 == 2) {
            f10 = format.f19551t;
        }
        int i12 = this.f19536e | format.f19536e;
        return a().S(str2).U(str3).V(str4).g0(i12).c0(this.f19537f | format.f19537f).G(i10).Z(i11).I(str5).X(b4).L(DrmInitData.createSessionCreationData(format.f19547p, this.f19547p)).P(f10).E();
    }

    public boolean equals(@Nullable Object obj) {
        int i10;
        if (this == obj) {
            return true;
        }
        if (obj == null || Format.class != obj.getClass()) {
            return false;
        }
        Format format = (Format) obj;
        int i11 = this.G;
        return (i11 == 0 || (i10 = format.G) == 0 || i11 == i10) && this.f19536e == format.f19536e && this.f19537f == format.f19537f && this.f19538g == format.f19538g && this.f19539h == format.f19539h && this.f19545n == format.f19545n && this.f19548q == format.f19548q && this.f19549r == format.f19549r && this.f19550s == format.f19550s && this.f19552u == format.f19552u && this.f19555x == format.f19555x && this.f19557z == format.f19557z && this.A == format.A && this.B == format.B && this.C == format.C && this.D == format.D && this.E == format.E && Float.compare(this.f19551t, format.f19551t) == 0 && Float.compare(this.f19553v, format.f19553v) == 0 && com.google.android.exoplayer2.util.j0.c(this.F, format.F) && com.google.android.exoplayer2.util.j0.c(this.f19533b, format.f19533b) && com.google.android.exoplayer2.util.j0.c(this.f19534c, format.f19534c) && com.google.android.exoplayer2.util.j0.c(this.f19541j, format.f19541j) && com.google.android.exoplayer2.util.j0.c(this.f19543l, format.f19543l) && com.google.android.exoplayer2.util.j0.c(this.f19544m, format.f19544m) && com.google.android.exoplayer2.util.j0.c(this.f19535d, format.f19535d) && Arrays.equals(this.f19554w, format.f19554w) && com.google.android.exoplayer2.util.j0.c(this.f19542k, format.f19542k) && com.google.android.exoplayer2.util.j0.c(this.f19556y, format.f19556y) && com.google.android.exoplayer2.util.j0.c(this.f19547p, format.f19547p) && d(format);
    }

    public int hashCode() {
        if (this.G == 0) {
            String str = this.f19533b;
            int hashCode = (MetricsProto.MetricsEvent.DIALOG_SUPPORT_PHONE + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f19534c;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.f19535d;
            int hashCode3 = (((((((((hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.f19536e) * 31) + this.f19537f) * 31) + this.f19538g) * 31) + this.f19539h) * 31;
            String str4 = this.f19541j;
            int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            Metadata metadata = this.f19542k;
            int hashCode5 = (hashCode4 + (metadata == null ? 0 : metadata.hashCode())) * 31;
            String str5 = this.f19543l;
            int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.f19544m;
            int hashCode7 = (((((((((((((((((((((((((((((hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31) + this.f19545n) * 31) + ((int) this.f19548q)) * 31) + this.f19549r) * 31) + this.f19550s) * 31) + Float.floatToIntBits(this.f19551t)) * 31) + this.f19552u) * 31) + Float.floatToIntBits(this.f19553v)) * 31) + this.f19555x) * 31) + this.f19557z) * 31) + this.A) * 31) + this.B) * 31) + this.C) * 31) + this.D) * 31) + this.E) * 31;
            Class<? extends b5.v> cls = this.F;
            this.G = hashCode7 + (cls != null ? cls.hashCode() : 0);
        }
        return this.G;
    }

    public String toString() {
        String str = this.f19533b;
        String str2 = this.f19534c;
        String str3 = this.f19543l;
        String str4 = this.f19544m;
        String str5 = this.f19541j;
        int i10 = this.f19540i;
        String str6 = this.f19535d;
        int i11 = this.f19549r;
        int i12 = this.f19550s;
        float f10 = this.f19551t;
        int i13 = this.f19557z;
        int i14 = this.A;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 104 + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length() + String.valueOf(str5).length() + String.valueOf(str6).length());
        sb2.append("Format(");
        sb2.append(str);
        sb2.append(", ");
        sb2.append(str2);
        sb2.append(", ");
        sb2.append(str3);
        sb2.append(", ");
        sb2.append(str4);
        sb2.append(", ");
        sb2.append(str5);
        sb2.append(", ");
        sb2.append(i10);
        sb2.append(", ");
        sb2.append(str6);
        sb2.append(", [");
        sb2.append(i11);
        sb2.append(", ");
        sb2.append(i12);
        sb2.append(", ");
        sb2.append(f10);
        sb2.append("], [");
        sb2.append(i13);
        sb2.append(", ");
        sb2.append(i14);
        sb2.append("])");
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f19533b);
        parcel.writeString(this.f19534c);
        parcel.writeString(this.f19535d);
        parcel.writeInt(this.f19536e);
        parcel.writeInt(this.f19537f);
        parcel.writeInt(this.f19538g);
        parcel.writeInt(this.f19539h);
        parcel.writeString(this.f19541j);
        parcel.writeParcelable(this.f19542k, 0);
        parcel.writeString(this.f19543l);
        parcel.writeString(this.f19544m);
        parcel.writeInt(this.f19545n);
        int size = this.f19546o.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            parcel.writeByteArray(this.f19546o.get(i11));
        }
        parcel.writeParcelable(this.f19547p, 0);
        parcel.writeLong(this.f19548q);
        parcel.writeInt(this.f19549r);
        parcel.writeInt(this.f19550s);
        parcel.writeFloat(this.f19551t);
        parcel.writeInt(this.f19552u);
        parcel.writeFloat(this.f19553v);
        com.google.android.exoplayer2.util.j0.Y0(parcel, this.f19554w != null);
        byte[] bArr = this.f19554w;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
        parcel.writeInt(this.f19555x);
        parcel.writeParcelable(this.f19556y, i10);
        parcel.writeInt(this.f19557z);
        parcel.writeInt(this.A);
        parcel.writeInt(this.B);
        parcel.writeInt(this.C);
        parcel.writeInt(this.D);
        parcel.writeInt(this.E);
    }

    public Format(b bVar) {
        this.f19533b = bVar.f19558a;
        this.f19534c = bVar.f19559b;
        this.f19535d = com.google.android.exoplayer2.util.j0.x0(bVar.f19560c);
        this.f19536e = bVar.f19561d;
        this.f19537f = bVar.f19562e;
        int i10 = bVar.f19563f;
        this.f19538g = i10;
        int i11 = bVar.f19564g;
        this.f19539h = i11;
        this.f19540i = i11 != -1 ? i11 : i10;
        this.f19541j = bVar.f19565h;
        this.f19542k = bVar.f19566i;
        this.f19543l = bVar.f19567j;
        this.f19544m = bVar.f19568k;
        this.f19545n = bVar.f19569l;
        this.f19546o = bVar.f19570m == null ? Collections.emptyList() : bVar.f19570m;
        DrmInitData drmInitData = bVar.f19571n;
        this.f19547p = drmInitData;
        this.f19548q = bVar.f19572o;
        this.f19549r = bVar.f19573p;
        this.f19550s = bVar.f19574q;
        this.f19551t = bVar.f19575r;
        this.f19552u = bVar.f19576s == -1 ? 0 : bVar.f19576s;
        this.f19553v = bVar.f19577t == -1.0f ? 1.0f : bVar.f19577t;
        this.f19554w = bVar.f19578u;
        this.f19555x = bVar.f19579v;
        this.f19556y = bVar.f19580w;
        this.f19557z = bVar.f19581x;
        this.A = bVar.f19582y;
        this.B = bVar.f19583z;
        this.C = bVar.A == -1 ? 0 : bVar.A;
        this.D = bVar.B != -1 ? bVar.B : 0;
        this.E = bVar.C;
        if (bVar.D == null && drmInitData != null) {
            this.F = b5.z.class;
        } else {
            this.F = bVar.D;
        }
    }

    public Format(Parcel parcel) {
        this.f19533b = parcel.readString();
        this.f19534c = parcel.readString();
        this.f19535d = parcel.readString();
        this.f19536e = parcel.readInt();
        this.f19537f = parcel.readInt();
        int readInt = parcel.readInt();
        this.f19538g = readInt;
        int readInt2 = parcel.readInt();
        this.f19539h = readInt2;
        this.f19540i = readInt2 != -1 ? readInt2 : readInt;
        this.f19541j = parcel.readString();
        this.f19542k = (Metadata) parcel.readParcelable(Metadata.class.getClassLoader());
        this.f19543l = parcel.readString();
        this.f19544m = parcel.readString();
        this.f19545n = parcel.readInt();
        int readInt3 = parcel.readInt();
        this.f19546o = new ArrayList(readInt3);
        for (int i10 = 0; i10 < readInt3; i10++) {
            this.f19546o.add((byte[]) com.google.android.exoplayer2.util.a.e(parcel.createByteArray()));
        }
        DrmInitData drmInitData = (DrmInitData) parcel.readParcelable(DrmInitData.class.getClassLoader());
        this.f19547p = drmInitData;
        this.f19548q = parcel.readLong();
        this.f19549r = parcel.readInt();
        this.f19550s = parcel.readInt();
        this.f19551t = parcel.readFloat();
        this.f19552u = parcel.readInt();
        this.f19553v = parcel.readFloat();
        this.f19554w = com.google.android.exoplayer2.util.j0.F0(parcel) ? parcel.createByteArray() : null;
        this.f19555x = parcel.readInt();
        this.f19556y = (ColorInfo) parcel.readParcelable(ColorInfo.class.getClassLoader());
        this.f19557z = parcel.readInt();
        this.A = parcel.readInt();
        this.B = parcel.readInt();
        this.C = parcel.readInt();
        this.D = parcel.readInt();
        this.E = parcel.readInt();
        this.F = drmInitData != null ? b5.z.class : null;
    }
}
