package com.cupidapp.live.mediapicker.newmediapicker.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LocalMediaFolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class LocalMediaFolder implements Parcelable {

    @NotNull
    public static final a CREATOR = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public long f17347b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public String f17348c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public String f17349d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public String f17350e;

    /* renamed from: f, reason: collision with root package name */
    public int f17351f;

    /* compiled from: LocalMediaFolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a implements Parcelable.Creator<LocalMediaFolder> {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public LocalMediaFolder createFromParcel(@NotNull Parcel parcel) {
            s.i(parcel, "parcel");
            return new LocalMediaFolder(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public LocalMediaFolder[] newArray(int i10) {
            return new LocalMediaFolder[i10];
        }
    }

    public LocalMediaFolder() {
        this(0L, null, null, null, 0, 31, null);
    }

    public LocalMediaFolder(long j10, @Nullable String str, @Nullable String str2, @Nullable String str3, int i10) {
        this.f17347b = j10;
        this.f17348c = str;
        this.f17349d = str2;
        this.f17350e = str3;
        this.f17351f = i10;
    }

    public final long a() {
        return this.f17347b;
    }

    @Nullable
    public final String b() {
        return this.f17349d;
    }

    public final int c() {
        return this.f17351f;
    }

    @Nullable
    public final String d() {
        return this.f17348c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final void e(long j10) {
        this.f17347b = j10;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocalMediaFolder)) {
            return false;
        }
        LocalMediaFolder localMediaFolder = (LocalMediaFolder) obj;
        return this.f17347b == localMediaFolder.f17347b && s.d(this.f17348c, localMediaFolder.f17348c) && s.d(this.f17349d, localMediaFolder.f17349d) && s.d(this.f17350e, localMediaFolder.f17350e) && this.f17351f == localMediaFolder.f17351f;
    }

    public final void f(@Nullable String str) {
        this.f17349d = str;
    }

    public final void g(@Nullable String str) {
        this.f17350e = str;
    }

    public final void h(int i10) {
        this.f17351f = i10;
    }

    public int hashCode() {
        int a10 = b2.a.a(this.f17347b) * 31;
        String str = this.f17348c;
        int hashCode = (a10 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f17349d;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f17350e;
        return ((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.f17351f;
    }

    public final void i(@Nullable String str) {
        this.f17348c = str;
    }

    @NotNull
    public String toString() {
        return "LocalMediaFolder(bucketId=" + this.f17347b + ", name=" + this.f17348c + ", firstImagePath=" + this.f17349d + ", firstMimeType=" + this.f17350e + ", mediaNum=" + this.f17351f + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i10) {
        s.i(parcel, "parcel");
        parcel.writeLong(this.f17347b);
        parcel.writeString(this.f17348c);
        parcel.writeString(this.f17349d);
        parcel.writeString(this.f17350e);
        parcel.writeInt(this.f17351f);
    }

    public /* synthetic */ LocalMediaFolder(long j10, String str, String str2, String str3, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? -1L : j10, (i11 & 2) != 0 ? null : str, (i11 & 4) != 0 ? null : str2, (i11 & 8) != 0 ? null : str3, (i11 & 16) != 0 ? 1 : i10);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LocalMediaFolder(@NotNull Parcel parcel) {
        this(0L, null, null, null, 0, 31, null);
        s.i(parcel, "parcel");
        this.f17347b = parcel.readLong();
        this.f17348c = parcel.readString();
        this.f17349d = parcel.readString();
        this.f17350e = parcel.readString();
        this.f17351f = parcel.readInt();
    }
}
