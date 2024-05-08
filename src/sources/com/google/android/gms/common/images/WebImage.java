package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.g;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class WebImage extends AbstractSafeParcelable {

    @RecentlyNonNull
    public static final Parcelable.Creator<WebImage> CREATOR = new b();

    /* renamed from: b, reason: collision with root package name */
    public final int f23560b;

    /* renamed from: c, reason: collision with root package name */
    public final Uri f23561c;

    /* renamed from: d, reason: collision with root package name */
    public final int f23562d;

    /* renamed from: e, reason: collision with root package name */
    public final int f23563e;

    public WebImage(int i10, Uri uri, int i11, int i12) {
        this.f23560b = i10;
        this.f23561c = uri;
        this.f23562d = i11;
        this.f23563e = i12;
    }

    @RecentlyNonNull
    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof WebImage)) {
            WebImage webImage = (WebImage) obj;
            if (g.a(this.f23561c, webImage.f23561c) && this.f23562d == webImage.f23562d && this.f23563e == webImage.f23563e) {
                return true;
            }
        }
        return false;
    }

    @RecentlyNonNull
    public final int f() {
        return this.f23563e;
    }

    @RecentlyNonNull
    public final Uri g() {
        return this.f23561c;
    }

    @RecentlyNonNull
    public final int hashCode() {
        return g.b(this.f23561c, Integer.valueOf(this.f23562d), Integer.valueOf(this.f23563e));
    }

    @RecentlyNonNull
    public final int i() {
        return this.f23562d;
    }

    @RecentlyNonNull
    public final String toString() {
        return String.format(Locale.US, "Image %dx%d %s", Integer.valueOf(this.f23562d), Integer.valueOf(this.f23563e), this.f23561c.toString());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10) {
        int a10 = w6.a.a(parcel);
        w6.a.j(parcel, 1, this.f23560b);
        w6.a.n(parcel, 2, g(), i10, false);
        w6.a.j(parcel, 3, i());
        w6.a.j(parcel, 4, f());
        w6.a.b(parcel, a10);
    }
}
