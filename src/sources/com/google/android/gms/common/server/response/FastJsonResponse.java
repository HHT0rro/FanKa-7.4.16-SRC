package com.google.android.gms.common.server.response;

import android.os.Parcel;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import b7.i;
import b7.j;
import com.google.android.gms.common.internal.g;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.server.converter.zaa;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class FastJsonResponse {

    /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class Field<I, O> extends AbstractSafeParcelable {
        public static final b CREATOR = new b();

        /* renamed from: b, reason: collision with root package name */
        public final int f23730b;

        /* renamed from: c, reason: collision with root package name */
        @RecentlyNonNull
        public final int f23731c;

        /* renamed from: d, reason: collision with root package name */
        @RecentlyNonNull
        public final boolean f23732d;

        /* renamed from: e, reason: collision with root package name */
        @RecentlyNonNull
        public final int f23733e;

        /* renamed from: f, reason: collision with root package name */
        @RecentlyNonNull
        public final boolean f23734f;

        /* renamed from: g, reason: collision with root package name */
        @RecentlyNonNull
        public final String f23735g;

        /* renamed from: h, reason: collision with root package name */
        @RecentlyNonNull
        public final int f23736h;

        /* renamed from: i, reason: collision with root package name */
        @RecentlyNullable
        public final Class<? extends FastJsonResponse> f23737i;

        /* renamed from: j, reason: collision with root package name */
        @Nullable
        public final String f23738j;

        /* renamed from: k, reason: collision with root package name */
        public zal f23739k;

        /* renamed from: l, reason: collision with root package name */
        @Nullable
        public a<I, O> f23740l;

        public Field(int i10, int i11, boolean z10, int i12, boolean z11, String str, int i13, @Nullable String str2, @Nullable zaa zaaVar) {
            this.f23730b = i10;
            this.f23731c = i11;
            this.f23732d = z10;
            this.f23733e = i12;
            this.f23734f = z11;
            this.f23735g = str;
            this.f23736h = i13;
            if (str2 == null) {
                this.f23737i = null;
                this.f23738j = null;
            } else {
                this.f23737i = SafeParcelResponse.class;
                this.f23738j = str2;
            }
            if (zaaVar == null) {
                this.f23740l = null;
            } else {
                this.f23740l = (a<I, O>) zaaVar.g();
            }
        }

        @RecentlyNonNull
        public int f() {
            return this.f23736h;
        }

        public final void i(zal zalVar) {
            this.f23739k = zalVar;
        }

        @RecentlyNonNull
        public final I j(@RecentlyNonNull O o10) {
            h.h(this.f23740l);
            return this.f23740l.b(o10);
        }

        @RecentlyNonNull
        public final boolean k() {
            return this.f23740l != null;
        }

        @RecentlyNonNull
        public final Map<String, Field<?, ?>> l() {
            h.h(this.f23738j);
            h.h(this.f23739k);
            return (Map) h.h(this.f23739k.f(this.f23738j));
        }

        @Nullable
        public final String m() {
            String str = this.f23738j;
            if (str == null) {
                return null;
            }
            return str;
        }

        @Nullable
        public final zaa r() {
            a<I, O> aVar = this.f23740l;
            if (aVar == null) {
                return null;
            }
            return zaa.f(aVar);
        }

        @RecentlyNonNull
        public String toString() {
            g.a a10 = g.c(this).a("versionCode", Integer.valueOf(this.f23730b)).a("typeIn", Integer.valueOf(this.f23731c)).a("typeInArray", Boolean.valueOf(this.f23732d)).a("typeOut", Integer.valueOf(this.f23733e)).a("typeOutArray", Boolean.valueOf(this.f23734f)).a("outputFieldName", this.f23735g).a("safeParcelFieldId", Integer.valueOf(this.f23736h)).a("concreteTypeName", m());
            Class<? extends FastJsonResponse> cls = this.f23737i;
            if (cls != null) {
                a10.a("concreteType.class", cls.getCanonicalName());
            }
            a<I, O> aVar = this.f23740l;
            if (aVar != null) {
                a10.a("converterName", aVar.getClass().getCanonicalName());
            }
            return a10.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10) {
            int a10 = w6.a.a(parcel);
            w6.a.j(parcel, 1, this.f23730b);
            w6.a.j(parcel, 2, this.f23731c);
            w6.a.c(parcel, 3, this.f23732d);
            w6.a.j(parcel, 4, this.f23733e);
            w6.a.c(parcel, 5, this.f23734f);
            w6.a.o(parcel, 6, this.f23735g, false);
            w6.a.j(parcel, 7, f());
            w6.a.o(parcel, 8, m(), false);
            w6.a.n(parcel, 9, r(), i10, false);
            w6.a.b(parcel, a10);
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface a<I, O> {
        @RecentlyNonNull
        I b(@RecentlyNonNull O o10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @RecentlyNonNull
    public static <O, I> I f(@RecentlyNonNull Field<I, O> field, @Nullable Object obj) {
        return field.f23740l != null ? field.j(obj) : obj;
    }

    public static void g(StringBuilder sb2, Field field, Object obj) {
        int i10 = field.f23731c;
        if (i10 == 11) {
            Class<? extends FastJsonResponse> cls = field.f23737i;
            h.h(cls);
            sb2.append(cls.cast(obj).toString());
        } else {
            if (i10 == 7) {
                sb2.append("\"");
                sb2.append(i.a((String) obj));
                sb2.append("\"");
                return;
            }
            sb2.append(obj);
        }
    }

    @RecentlyNonNull
    public abstract Map<String, Field<?, ?>> a();

    @RecentlyNullable
    public Object b(@RecentlyNonNull Field field) {
        String str = field.f23735g;
        if (field.f23737i != null) {
            h.l(c(str) == null, "Concrete field shouldn't be value object: %s", field.f23735g);
            try {
                char upperCase = Character.toUpperCase(str.charAt(0));
                String substring = str.substring(1);
                StringBuilder sb2 = new StringBuilder(String.valueOf(substring).length() + 4);
                sb2.append(MonitorConstants.CONNECT_TYPE_GET);
                sb2.append(upperCase);
                sb2.append(substring);
                return getClass().getMethod(sb2.toString(), new Class[0]).invoke(this, new Object[0]);
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
        return c(str);
    }

    @RecentlyNullable
    public abstract Object c(@RecentlyNonNull String str);

    @RecentlyNonNull
    public boolean d(@RecentlyNonNull Field field) {
        if (field.f23733e == 11) {
            if (field.f23734f) {
                throw new UnsupportedOperationException("Concrete type arrays not supported");
            }
            throw new UnsupportedOperationException("Concrete types not supported");
        }
        return e(field.f23735g);
    }

    @RecentlyNonNull
    public abstract boolean e(@RecentlyNonNull String str);

    @RecentlyNonNull
    public String toString() {
        Map<String, Field<?, ?>> a10 = a();
        StringBuilder sb2 = new StringBuilder(100);
        for (String str : a10.h()) {
            Field<?, ?> field = a10.get(str);
            if (d(field)) {
                Object f10 = f(field, b(field));
                if (sb2.length() == 0) {
                    sb2.append("{");
                } else {
                    sb2.append(",");
                }
                sb2.append("\"");
                sb2.append(str);
                sb2.append("\":");
                if (f10 == null) {
                    sb2.append("null");
                } else {
                    switch (field.f23733e) {
                        case 8:
                            sb2.append("\"");
                            sb2.append(b7.b.a((byte[]) f10));
                            sb2.append("\"");
                            break;
                        case 9:
                            sb2.append("\"");
                            sb2.append(b7.b.b((byte[]) f10));
                            sb2.append("\"");
                            break;
                        case 10:
                            j.a(sb2, (HashMap) f10);
                            break;
                        default:
                            if (field.f23732d) {
                                ArrayList arrayList = (ArrayList) f10;
                                sb2.append("[");
                                int size = arrayList.size();
                                for (int i10 = 0; i10 < size; i10++) {
                                    if (i10 > 0) {
                                        sb2.append(",");
                                    }
                                    Object obj = arrayList.get(i10);
                                    if (obj != null) {
                                        g(sb2, field, obj);
                                    }
                                }
                                sb2.append("]");
                                break;
                            } else {
                                g(sb2, field, f10);
                                break;
                            }
                    }
                }
            }
        }
        if (sb2.length() > 0) {
            sb2.append(com.alipay.sdk.util.i.f4738d);
        } else {
            sb2.append("{}");
        }
        return sb2.toString();
    }
}
