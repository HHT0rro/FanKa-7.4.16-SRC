package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class StringToIntConverter extends AbstractSafeParcelable implements FastJsonResponse.a<String, Integer> {

    @RecentlyNonNull
    public static final Parcelable.Creator<StringToIntConverter> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public final int f23721b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap<String, Integer> f23722c;

    /* renamed from: d, reason: collision with root package name */
    public final SparseArray<String> f23723d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public final ArrayList<zaa> f23724e;

    public StringToIntConverter(int i10, ArrayList<zaa> arrayList) {
        this.f23721b = i10;
        this.f23722c = new HashMap<>();
        this.f23723d = new SparseArray<>();
        this.f23724e = null;
        int size = arrayList.size();
        int i11 = 0;
        while (i11 < size) {
            zaa zaaVar = arrayList.get(i11);
            i11++;
            zaa zaaVar2 = zaaVar;
            f(zaaVar2.f23726c, zaaVar2.f23727d);
        }
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse.a
    @RecentlyNonNull
    public final /* synthetic */ String b(@RecentlyNonNull Integer num) {
        String str = this.f23723d.get(num.intValue());
        return (str == null && this.f23722c.containsKey("gms_unknown")) ? "gms_unknown" : str;
    }

    @RecentlyNonNull
    public final StringToIntConverter f(@RecentlyNonNull String str, @RecentlyNonNull int i10) {
        this.f23722c.put(str, Integer.valueOf(i10));
        this.f23723d.put(i10, str);
        return this;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10) {
        int a10 = w6.a.a(parcel);
        w6.a.j(parcel, 1, this.f23721b);
        ArrayList arrayList = new ArrayList();
        for (String str : this.f23722c.h()) {
            arrayList.add(new zaa(str, this.f23722c.get(str).intValue()));
        }
        w6.a.s(parcel, 2, arrayList, false);
        w6.a.b(parcel, a10);
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class zaa extends AbstractSafeParcelable {
        public static final Parcelable.Creator<zaa> CREATOR = new b();

        /* renamed from: b, reason: collision with root package name */
        public final int f23725b;

        /* renamed from: c, reason: collision with root package name */
        public final String f23726c;

        /* renamed from: d, reason: collision with root package name */
        public final int f23727d;

        public zaa(int i10, String str, int i11) {
            this.f23725b = i10;
            this.f23726c = str;
            this.f23727d = i11;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i10) {
            int a10 = w6.a.a(parcel);
            w6.a.j(parcel, 1, this.f23725b);
            w6.a.o(parcel, 2, this.f23726c, false);
            w6.a.j(parcel, 3, this.f23727d);
            w6.a.b(parcel, a10);
        }

        public zaa(String str, int i10) {
            this.f23725b = 1;
            this.f23726c = str;
            this.f23727d = i10;
        }
    }

    public StringToIntConverter() {
        this.f23721b = 1;
        this.f23722c = new HashMap<>();
        this.f23723d = new SparseArray<>();
        this.f23724e = null;
    }
}
