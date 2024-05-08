package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zal extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zal> CREATOR = new z6.a();

    /* renamed from: b, reason: collision with root package name */
    public final int f23751b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> f23752c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public final ArrayList<zak> f23753d = null;

    /* renamed from: e, reason: collision with root package name */
    public final String f23754e;

    public zal(int i10, ArrayList<zak> arrayList, String str) {
        this.f23751b = i10;
        HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> hashMap = new HashMap<>();
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            zak zakVar = arrayList.get(i11);
            String str2 = zakVar.f23749c;
            HashMap hashMap2 = new HashMap();
            int size2 = ((ArrayList) h.h(zakVar.f23750d)).size();
            for (int i12 = 0; i12 < size2; i12++) {
                zan zanVar = zakVar.f23750d.get(i12);
                hashMap2.put(zanVar.f23756c, zanVar.f23757d);
            }
            hashMap.put(str2, hashMap2);
        }
        this.f23752c = hashMap;
        this.f23754e = (String) h.h(str);
        g();
    }

    @Nullable
    public final Map<String, FastJsonResponse.Field<?, ?>> f(String str) {
        return this.f23752c.get(str);
    }

    public final void g() {
        Iterator<String> iterator2 = this.f23752c.h().iterator2();
        while (iterator2.hasNext()) {
            Map<String, FastJsonResponse.Field<?, ?>> map = this.f23752c.get(iterator2.next());
            Iterator<String> iterator22 = map.h().iterator2();
            while (iterator22.hasNext()) {
                map.get(iterator22.next()).i(this);
            }
        }
    }

    public final String i() {
        return this.f23754e;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        for (String str : this.f23752c.h()) {
            sb2.append(str);
            sb2.append(":\n");
            Map<String, FastJsonResponse.Field<?, ?>> map = this.f23752c.get(str);
            for (String str2 : map.h()) {
                sb2.append("  ");
                sb2.append(str2);
                sb2.append(": ");
                sb2.append((Object) map.get(str2));
            }
        }
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = w6.a.a(parcel);
        w6.a.j(parcel, 1, this.f23751b);
        ArrayList arrayList = new ArrayList();
        for (String str : this.f23752c.h()) {
            arrayList.add(new zak(str, this.f23752c.get(str)));
        }
        w6.a.s(parcel, 2, arrayList, false);
        w6.a.o(parcel, 3, this.f23754e, false);
        w6.a.b(parcel, a10);
    }
}
