package com.cupidapp.live.mediapicker.newmediapicker.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LocalMedia.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class LocalMedia implements Parcelable {

    @NotNull
    public static final a CREATOR = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public long f17338b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public String f17339c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public String f17340d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public String f17341e;

    /* renamed from: f, reason: collision with root package name */
    public long f17342f;

    /* renamed from: g, reason: collision with root package name */
    public int f17343g;

    /* renamed from: h, reason: collision with root package name */
    public int f17344h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public String f17345i;

    /* renamed from: j, reason: collision with root package name */
    public long f17346j;

    /* compiled from: LocalMedia.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a implements Parcelable.Creator<LocalMedia> {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public LocalMedia createFromParcel(@NotNull Parcel parcel) {
            s.i(parcel, "parcel");
            return new LocalMedia(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public LocalMedia[] newArray(int i10) {
            return new LocalMedia[i10];
        }
    }

    public LocalMedia() {
        this(0L, null, null, null, 0L, 0, 0, null, 0L, 511, null);
    }

    public LocalMedia(long j10, @Nullable String str, @Nullable String str2, @Nullable String str3, long j11, int i10, int i11, @Nullable String str4, long j12) {
        this.f17338b = j10;
        this.f17339c = str;
        this.f17340d = str2;
        this.f17341e = str3;
        this.f17342f = j11;
        this.f17343g = i10;
        this.f17344h = i11;
        this.f17345i = str4;
        this.f17346j = j12;
    }

    public final long a() {
        return this.f17346j;
    }

    public final int b() {
        return this.f17344h;
    }

    @Nullable
    public final String c() {
        return this.f17345i;
    }

    @Nullable
    public final String d() {
        return this.f17340d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final String e() {
        return this.f17341e;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocalMedia)) {
            return false;
        }
        LocalMedia localMedia = (LocalMedia) obj;
        return this.f17338b == localMedia.f17338b && s.d(this.f17339c, localMedia.f17339c) && s.d(this.f17340d, localMedia.f17340d) && s.d(this.f17341e, localMedia.f17341e) && this.f17342f == localMedia.f17342f && this.f17343g == localMedia.f17343g && this.f17344h == localMedia.f17344h && s.d(this.f17345i, localMedia.f17345i) && this.f17346j == localMedia.f17346j;
    }

    public final int f() {
        return this.f17343g;
    }

    public final void g(long j10) {
        this.f17346j = j10;
    }

    public final void h(int i10) {
        this.f17344h = i10;
    }

    public int hashCode() {
        int a10 = b2.a.a(this.f17338b) * 31;
        String str = this.f17339c;
        int hashCode = (a10 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f17340d;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f17341e;
        int hashCode3 = (((((((hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + b2.a.a(this.f17342f)) * 31) + this.f17343g) * 31) + this.f17344h) * 31;
        String str4 = this.f17345i;
        return ((hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31) + b2.a.a(this.f17346j);
    }

    public final void i(long j10) {
        this.f17338b = j10;
    }

    public final void j(@Nullable String str) {
        this.f17345i = str;
    }

    public final void k(@Nullable String str) {
        this.f17339c = str;
    }

    public final void l(@Nullable String str) {
        this.f17340d = str;
    }

    public final void m(@Nullable String str) {
        this.f17341e = str;
    }

    public final void n(long j10) {
        this.f17342f = j10;
    }

    public final void o(int i10) {
        this.f17343g = i10;
    }

    @NotNull
    public String toString() {
        return "LocalMedia(id=" + this.f17338b + ", name=" + this.f17339c + ", path=" + this.f17340d + ", realPath=" + this.f17341e + ", size=" + this.f17342f + ", width=" + this.f17343g + ", height=" + this.f17344h + ", mimeType=" + this.f17345i + ", duration=" + this.f17346j + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i10) {
        s.i(parcel, "parcel");
        parcel.writeLong(this.f17338b);
        parcel.writeString(this.f17339c);
        parcel.writeString(this.f17340d);
        parcel.writeString(this.f17341e);
        parcel.writeLong(this.f17342f);
        parcel.writeInt(this.f17343g);
        parcel.writeInt(this.f17344h);
        parcel.writeString(this.f17345i);
        parcel.writeLong(this.f17346j);
    }

    public /* synthetic */ LocalMedia(long j10, String str, String str2, String str3, long j11, int i10, int i11, String str4, long j12, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 0L : j10, (i12 & 2) != 0 ? null : str, (i12 & 4) != 0 ? null : str2, (i12 & 8) != 0 ? null : str3, (i12 & 16) != 0 ? 0L : j11, (i12 & 32) != 0 ? 0 : i10, (i12 & 64) == 0 ? i11 : 0, (i12 & 128) == 0 ? str4 : null, (i12 & 256) == 0 ? j12 : 0L);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LocalMedia(@NotNull Parcel parcel) {
        this(0L, null, null, null, 0L, 0, 0, null, 0L, 511, null);
        s.i(parcel, "parcel");
        this.f17338b = parcel.readLong();
        this.f17339c = parcel.readString();
        this.f17340d = parcel.readString();
        this.f17341e = parcel.readString();
        this.f17342f = parcel.readLong();
        this.f17343g = parcel.readInt();
        this.f17344h = parcel.readInt();
        this.f17345i = parcel.readString();
        this.f17346j = parcel.readLong();
    }
}
