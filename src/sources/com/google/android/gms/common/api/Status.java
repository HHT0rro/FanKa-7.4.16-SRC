package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.g;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import u6.f;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class Status extends AbstractSafeParcelable implements Result, ReflectedParcelable {

    /* renamed from: b, reason: collision with root package name */
    public final int f23385b;

    /* renamed from: c, reason: collision with root package name */
    public final int f23386c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public final String f23387d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public final PendingIntent f23388e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public final ConnectionResult f23389f;

    /* renamed from: g, reason: collision with root package name */
    @RecentlyNonNull
    public static final Status f23378g = new Status(0);

    /* renamed from: h, reason: collision with root package name */
    @RecentlyNonNull
    public static final Status f23379h = new Status(14);

    /* renamed from: i, reason: collision with root package name */
    @RecentlyNonNull
    public static final Status f23380i = new Status(8);

    /* renamed from: j, reason: collision with root package name */
    @RecentlyNonNull
    public static final Status f23381j = new Status(15);

    /* renamed from: k, reason: collision with root package name */
    @RecentlyNonNull
    public static final Status f23382k = new Status(16);

    /* renamed from: l, reason: collision with root package name */
    public static final Status f23383l = new Status(17);

    /* renamed from: m, reason: collision with root package name */
    @RecentlyNonNull
    public static final Status f23384m = new Status(18);

    @RecentlyNonNull
    public static final Parcelable.Creator<Status> CREATOR = new f();

    public Status(int i10, int i11, @Nullable String str, @Nullable PendingIntent pendingIntent) {
        this(i10, i11, str, pendingIntent, null);
    }

    @RecentlyNonNull
    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.f23385b == status.f23385b && this.f23386c == status.f23386c && g.a(this.f23387d, status.f23387d) && g.a(this.f23388e, status.f23388e) && g.a(this.f23389f, status.f23389f);
    }

    @RecentlyNullable
    public final ConnectionResult f() {
        return this.f23389f;
    }

    @RecentlyNonNull
    public final int g() {
        return this.f23386c;
    }

    @RecentlyNullable
    public final PendingIntent getResolution() {
        return this.f23388e;
    }

    @Override // com.google.android.gms.common.api.Result
    @RecentlyNonNull
    public final Status getStatus() {
        return this;
    }

    @RecentlyNonNull
    public final boolean hasResolution() {
        return this.f23388e != null;
    }

    @RecentlyNonNull
    public final int hashCode() {
        return g.b(Integer.valueOf(this.f23385b), Integer.valueOf(this.f23386c), this.f23387d, this.f23388e, this.f23389f);
    }

    @RecentlyNullable
    public final String i() {
        return this.f23387d;
    }

    @RecentlyNonNull
    public final boolean isSuccess() {
        return this.f23386c <= 0;
    }

    @RecentlyNonNull
    public final String j() {
        String str = this.f23387d;
        return str != null ? str : u6.a.a(this.f23386c);
    }

    public final void startResolutionForResult(@RecentlyNonNull Activity activity, @RecentlyNonNull int i10) throws IntentSender.SendIntentException {
        if (hasResolution()) {
            activity.startIntentSenderForResult(((PendingIntent) h.h(this.f23388e)).getIntentSender(), i10, null, 0, 0, 0);
        }
    }

    @RecentlyNonNull
    public final String toString() {
        return g.c(this).a("statusCode", j()).a("resolution", this.f23388e).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10) {
        int a10 = w6.a.a(parcel);
        w6.a.j(parcel, 1, g());
        w6.a.o(parcel, 2, i(), false);
        w6.a.n(parcel, 3, this.f23388e, i10, false);
        w6.a.n(parcel, 4, f(), i10, false);
        w6.a.j(parcel, 1000, this.f23385b);
        w6.a.b(parcel, a10);
    }

    public Status(int i10, int i11, @Nullable String str, @Nullable PendingIntent pendingIntent, @Nullable ConnectionResult connectionResult) {
        this.f23385b = i10;
        this.f23386c = i11;
        this.f23387d = str;
        this.f23388e = pendingIntent;
        this.f23389f = connectionResult;
    }

    public Status(@RecentlyNonNull int i10) {
        this(i10, (String) null);
    }

    public Status(@RecentlyNonNull int i10, @Nullable String str) {
        this(1, i10, str, null);
    }

    public Status(@RecentlyNonNull int i10, @Nullable String str, @Nullable PendingIntent pendingIntent) {
        this(1, i10, str, pendingIntent);
    }

    public Status(@RecentlyNonNull ConnectionResult connectionResult, @RecentlyNonNull String str) {
        this(connectionResult, str, 17);
    }

    @Deprecated
    public Status(@RecentlyNonNull ConnectionResult connectionResult, @RecentlyNonNull String str, @RecentlyNonNull int i10) {
        this(1, i10, str, connectionResult.getResolution(), connectionResult);
    }
}
