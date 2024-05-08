package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class GetServiceRequest extends AbstractSafeParcelable {

    @RecentlyNonNull
    public static final Parcelable.Creator<GetServiceRequest> CREATOR = new w();

    /* renamed from: b, reason: collision with root package name */
    public final int f23614b;

    /* renamed from: c, reason: collision with root package name */
    public final int f23615c;

    /* renamed from: d, reason: collision with root package name */
    public int f23616d;

    /* renamed from: e, reason: collision with root package name */
    public String f23617e;

    /* renamed from: f, reason: collision with root package name */
    public IBinder f23618f;

    /* renamed from: g, reason: collision with root package name */
    public Scope[] f23619g;

    /* renamed from: h, reason: collision with root package name */
    public Bundle f23620h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public Account f23621i;

    /* renamed from: j, reason: collision with root package name */
    public Feature[] f23622j;

    /* renamed from: k, reason: collision with root package name */
    public Feature[] f23623k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f23624l;

    /* renamed from: m, reason: collision with root package name */
    public int f23625m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f23626n;

    public GetServiceRequest(@RecentlyNonNull int i10) {
        this.f23614b = 5;
        this.f23616d = com.google.android.gms.common.b.f23516a;
        this.f23615c = i10;
        this.f23624l = true;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10) {
        int a10 = w6.a.a(parcel);
        w6.a.j(parcel, 1, this.f23614b);
        w6.a.j(parcel, 2, this.f23615c);
        w6.a.j(parcel, 3, this.f23616d);
        w6.a.o(parcel, 4, this.f23617e, false);
        w6.a.i(parcel, 5, this.f23618f, false);
        w6.a.r(parcel, 6, this.f23619g, i10, false);
        w6.a.d(parcel, 7, this.f23620h, false);
        w6.a.n(parcel, 8, this.f23621i, i10, false);
        w6.a.r(parcel, 10, this.f23622j, i10, false);
        w6.a.r(parcel, 11, this.f23623k, i10, false);
        w6.a.c(parcel, 12, this.f23624l);
        w6.a.j(parcel, 13, this.f23625m);
        w6.a.c(parcel, 14, this.f23626n);
        w6.a.b(parcel, a10);
    }

    public GetServiceRequest(int i10, int i11, int i12, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, Feature[] featureArr, Feature[] featureArr2, boolean z10, int i13, boolean z11) {
        this.f23614b = i10;
        this.f23615c = i11;
        this.f23616d = i12;
        if ("com.google.android.gms".equals(str)) {
            this.f23617e = "com.google.android.gms";
        } else {
            this.f23617e = str;
        }
        if (i10 < 2) {
            this.f23621i = iBinder != null ? AccountAccessor.getAccountBinderSafe(IAccountAccessor.Stub.asInterface(iBinder)) : null;
        } else {
            this.f23618f = iBinder;
            this.f23621i = account;
        }
        this.f23619g = scopeArr;
        this.f23620h = bundle;
        this.f23622j = featureArr;
        this.f23623k = featureArr2;
        this.f23624l = z10;
        this.f23625m = i13;
        this.f23626n = z11;
    }
}
