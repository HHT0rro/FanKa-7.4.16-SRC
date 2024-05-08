package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zak extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zak> CREATOR = new z6.b();

    /* renamed from: b, reason: collision with root package name */
    public final int f23748b;

    /* renamed from: c, reason: collision with root package name */
    public final String f23749c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public final ArrayList<zan> f23750d;

    public zak(int i10, String str, ArrayList<zan> arrayList) {
        this.f23748b = i10;
        this.f23749c = str;
        this.f23750d = arrayList;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = w6.a.a(parcel);
        w6.a.j(parcel, 1, this.f23748b);
        w6.a.o(parcel, 2, this.f23749c, false);
        w6.a.s(parcel, 3, this.f23750d, false);
        w6.a.b(parcel, a10);
    }

    public zak(String str, Map<String, FastJsonResponse.Field<?, ?>> map) {
        ArrayList<zan> arrayList;
        this.f23748b = 1;
        this.f23749c = str;
        if (map == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList<>();
            for (String str2 : map.h()) {
                arrayList.add(new zan(str2, map.get(str2)));
            }
        }
        this.f23750d = arrayList;
    }
}
