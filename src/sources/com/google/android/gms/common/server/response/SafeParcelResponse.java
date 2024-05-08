package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import b7.i;
import b7.j;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.huawei.openalliance.ad.constant.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import z6.c;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class SafeParcelResponse extends FastSafeParcelableJsonResponse {

    @RecentlyNonNull
    public static final Parcelable.Creator<SafeParcelResponse> CREATOR = new c();

    /* renamed from: b, reason: collision with root package name */
    public final int f23741b;

    /* renamed from: c, reason: collision with root package name */
    public final Parcel f23742c;

    /* renamed from: d, reason: collision with root package name */
    public final int f23743d = 2;

    /* renamed from: e, reason: collision with root package name */
    public final zal f23744e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public final String f23745f;

    /* renamed from: g, reason: collision with root package name */
    public int f23746g;

    /* renamed from: h, reason: collision with root package name */
    public int f23747h;

    public SafeParcelResponse(int i10, Parcel parcel, zal zalVar) {
        this.f23741b = i10;
        this.f23742c = (Parcel) h.h(parcel);
        this.f23744e = zalVar;
        if (zalVar == null) {
            this.f23745f = null;
        } else {
            this.f23745f = zalVar.i();
        }
        this.f23746g = 2;
    }

    public static void g(StringBuilder sb2, FastJsonResponse.Field<?, ?> field, Object obj) {
        if (field.f23732d) {
            ArrayList arrayList = (ArrayList) obj;
            sb2.append("[");
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (i10 != 0) {
                    sb2.append(",");
                }
                i(sb2, field.f23731c, arrayList.get(i10));
            }
            sb2.append("]");
            return;
        }
        i(sb2, field.f23731c, obj);
    }

    public static void i(StringBuilder sb2, int i10, @Nullable Object obj) {
        switch (i10) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                sb2.append(obj);
                return;
            case 7:
                sb2.append("\"");
                sb2.append(i.a(h.h(obj).toString()));
                sb2.append("\"");
                return;
            case 8:
                sb2.append("\"");
                sb2.append(b7.b.a((byte[]) obj));
                sb2.append("\"");
                return;
            case 9:
                sb2.append("\"");
                sb2.append(b7.b.b((byte[]) obj));
                sb2.append("\"");
                return;
            case 10:
                j.a(sb2, (HashMap) h.h(obj));
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                StringBuilder sb3 = new StringBuilder(26);
                sb3.append("Unknown type = ");
                sb3.append(i10);
                throw new IllegalArgumentException(sb3.toString());
        }
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    @RecentlyNullable
    public Map<String, FastJsonResponse.Field<?, ?>> a() {
        zal zalVar = this.f23744e;
        if (zalVar == null) {
            return null;
        }
        return zalVar.f((String) h.h(this.f23745f));
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse, com.google.android.gms.common.server.response.FastJsonResponse
    @RecentlyNonNull
    public Object c(@RecentlyNonNull String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse, com.google.android.gms.common.server.response.FastJsonResponse
    @RecentlyNonNull
    public boolean e(@RecentlyNonNull String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0005, code lost:
    
        if (r0 != 1) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.os.Parcel h() {
        /*
            r2 = this;
            int r0 = r2.f23746g
            if (r0 == 0) goto L8
            r1 = 1
            if (r0 == r1) goto L10
            goto L1a
        L8:
            android.os.Parcel r0 = r2.f23742c
            int r0 = w6.a.a(r0)
            r2.f23747h = r0
        L10:
            android.os.Parcel r0 = r2.f23742c
            int r1 = r2.f23747h
            w6.a.b(r0, r1)
            r0 = 2
            r2.f23746g = r0
        L1a:
            android.os.Parcel r0 = r2.f23742c
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.server.response.SafeParcelResponse.h():android.os.Parcel");
    }

    public final void j(StringBuilder sb2, Map<String, FastJsonResponse.Field<?, ?>> map, Parcel parcel) {
        SparseArray sparseArray = new SparseArray();
        for (Map.Entry<String, FastJsonResponse.Field<?, ?>> entry : map.entrySet()) {
            sparseArray.put(entry.getValue().f(), entry);
        }
        sb2.append('{');
        int F = SafeParcelReader.F(parcel);
        boolean z10 = false;
        while (parcel.dataPosition() < F) {
            int z11 = SafeParcelReader.z(parcel);
            Map.Entry entry2 = (Map.Entry) sparseArray.get(SafeParcelReader.v(z11));
            if (entry2 != null) {
                if (z10) {
                    sb2.append(",");
                }
                String str = (String) entry2.getKey();
                FastJsonResponse.Field field = (FastJsonResponse.Field) entry2.getValue();
                sb2.append("\"");
                sb2.append(str);
                sb2.append("\":");
                if (field.k()) {
                    switch (field.f23733e) {
                        case 0:
                            g(sb2, field, FastJsonResponse.f(field, Integer.valueOf(SafeParcelReader.B(parcel, z11))));
                            break;
                        case 1:
                            g(sb2, field, FastJsonResponse.f(field, SafeParcelReader.c(parcel, z11)));
                            break;
                        case 2:
                            g(sb2, field, FastJsonResponse.f(field, Long.valueOf(SafeParcelReader.C(parcel, z11))));
                            break;
                        case 3:
                            g(sb2, field, FastJsonResponse.f(field, Float.valueOf(SafeParcelReader.y(parcel, z11))));
                            break;
                        case 4:
                            g(sb2, field, FastJsonResponse.f(field, Double.valueOf(SafeParcelReader.x(parcel, z11))));
                            break;
                        case 5:
                            g(sb2, field, FastJsonResponse.f(field, SafeParcelReader.a(parcel, z11)));
                            break;
                        case 6:
                            g(sb2, field, FastJsonResponse.f(field, Boolean.valueOf(SafeParcelReader.w(parcel, z11))));
                            break;
                        case 7:
                            g(sb2, field, FastJsonResponse.f(field, SafeParcelReader.p(parcel, z11)));
                            break;
                        case 8:
                        case 9:
                            g(sb2, field, FastJsonResponse.f(field, SafeParcelReader.g(parcel, z11)));
                            break;
                        case 10:
                            Bundle f10 = SafeParcelReader.f(parcel, z11);
                            HashMap hashMap = new HashMap();
                            for (String str2 : f10.keySet()) {
                                hashMap.put(str2, (String) h.h(f10.getString(str2)));
                            }
                            g(sb2, field, FastJsonResponse.f(field, hashMap));
                            break;
                        case 11:
                            throw new IllegalArgumentException("Method does not accept concrete type.");
                        default:
                            int i10 = field.f23733e;
                            StringBuilder sb3 = new StringBuilder(36);
                            sb3.append("Unknown field out type = ");
                            sb3.append(i10);
                            throw new IllegalArgumentException(sb3.toString());
                    }
                } else if (field.f23734f) {
                    sb2.append("[");
                    switch (field.f23733e) {
                        case 0:
                            b7.a.d(sb2, SafeParcelReader.k(parcel, z11));
                            break;
                        case 1:
                            b7.a.f(sb2, SafeParcelReader.d(parcel, z11));
                            break;
                        case 2:
                            b7.a.e(sb2, SafeParcelReader.l(parcel, z11));
                            break;
                        case 3:
                            b7.a.c(sb2, SafeParcelReader.j(parcel, z11));
                            break;
                        case 4:
                            b7.a.b(sb2, SafeParcelReader.i(parcel, z11));
                            break;
                        case 5:
                            b7.a.f(sb2, SafeParcelReader.b(parcel, z11));
                            break;
                        case 6:
                            b7.a.g(sb2, SafeParcelReader.e(parcel, z11));
                            break;
                        case 7:
                            b7.a.h(sb2, SafeParcelReader.q(parcel, z11));
                            break;
                        case 8:
                        case 9:
                        case 10:
                            throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                        case 11:
                            Parcel[] n10 = SafeParcelReader.n(parcel, z11);
                            int length = n10.length;
                            for (int i11 = 0; i11 < length; i11++) {
                                if (i11 > 0) {
                                    sb2.append(",");
                                }
                                n10[i11].setDataPosition(0);
                                j(sb2, field.l(), n10[i11]);
                            }
                            break;
                        default:
                            throw new IllegalStateException("Unknown field type out.");
                    }
                    sb2.append("]");
                } else {
                    switch (field.f23733e) {
                        case 0:
                            sb2.append(SafeParcelReader.B(parcel, z11));
                            break;
                        case 1:
                            sb2.append((Object) SafeParcelReader.c(parcel, z11));
                            break;
                        case 2:
                            sb2.append(SafeParcelReader.C(parcel, z11));
                            break;
                        case 3:
                            sb2.append(SafeParcelReader.y(parcel, z11));
                            break;
                        case 4:
                            sb2.append(SafeParcelReader.x(parcel, z11));
                            break;
                        case 5:
                            sb2.append((Object) SafeParcelReader.a(parcel, z11));
                            break;
                        case 6:
                            sb2.append(SafeParcelReader.w(parcel, z11));
                            break;
                        case 7:
                            String p10 = SafeParcelReader.p(parcel, z11);
                            sb2.append("\"");
                            sb2.append(i.a(p10));
                            sb2.append("\"");
                            break;
                        case 8:
                            byte[] g3 = SafeParcelReader.g(parcel, z11);
                            sb2.append("\"");
                            sb2.append(b7.b.a(g3));
                            sb2.append("\"");
                            break;
                        case 9:
                            byte[] g10 = SafeParcelReader.g(parcel, z11);
                            sb2.append("\"");
                            sb2.append(b7.b.b(g10));
                            sb2.append("\"");
                            break;
                        case 10:
                            Bundle f11 = SafeParcelReader.f(parcel, z11);
                            Set<String> keySet = f11.keySet();
                            sb2.append("{");
                            boolean z12 = true;
                            for (String str3 : keySet) {
                                if (!z12) {
                                    sb2.append(",");
                                }
                                sb2.append("\"");
                                sb2.append(str3);
                                sb2.append("\"");
                                sb2.append(u.bD);
                                sb2.append("\"");
                                sb2.append(i.a(f11.getString(str3)));
                                sb2.append("\"");
                                z12 = false;
                            }
                            sb2.append(com.alipay.sdk.util.i.f4738d);
                            break;
                        case 11:
                            Parcel m10 = SafeParcelReader.m(parcel, z11);
                            m10.setDataPosition(0);
                            j(sb2, field.l(), m10);
                            break;
                        default:
                            throw new IllegalStateException("Unknown field type out");
                    }
                }
                z10 = true;
            }
        }
        if (parcel.dataPosition() == F) {
            sb2.append('}');
            return;
        }
        StringBuilder sb4 = new StringBuilder(37);
        sb4.append("Overread allowed size end=");
        sb4.append(F);
        throw new SafeParcelReader.ParseException(sb4.toString(), parcel);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    @RecentlyNonNull
    public String toString() {
        h.i(this.f23744e, "Cannot convert to JSON on client side.");
        Parcel h10 = h();
        h10.setDataPosition(0);
        StringBuilder sb2 = new StringBuilder(100);
        j(sb2, (Map) h.h(this.f23744e.f((String) h.h(this.f23745f))), h10);
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10) {
        zal zalVar;
        int a10 = w6.a.a(parcel);
        w6.a.j(parcel, 1, this.f23741b);
        w6.a.m(parcel, 2, h(), false);
        int i11 = this.f23743d;
        if (i11 == 0) {
            zalVar = null;
        } else if (i11 == 1) {
            zalVar = this.f23744e;
        } else if (i11 == 2) {
            zalVar = this.f23744e;
        } else {
            int i12 = this.f23743d;
            StringBuilder sb2 = new StringBuilder(34);
            sb2.append("Invalid creation type: ");
            sb2.append(i12);
            throw new IllegalStateException(sb2.toString());
        }
        w6.a.n(parcel, 3, zalVar, i10, false);
        w6.a.b(parcel, a10);
    }
}
