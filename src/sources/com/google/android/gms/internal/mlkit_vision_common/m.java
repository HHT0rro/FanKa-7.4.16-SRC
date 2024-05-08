package com.google.android.gms.internal.mlkit_vision_common;

import a8.c;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.google.firebase.encoders.EncodingException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.mlkit:vision-common@@16.3.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class m implements a8.e {

    /* renamed from: e, reason: collision with root package name */
    public static final Charset f24447e = Charset.forName("UTF-8");

    /* renamed from: f, reason: collision with root package name */
    public static final a8.c f24448f;

    /* renamed from: g, reason: collision with root package name */
    public static final a8.c f24449g;

    /* renamed from: h, reason: collision with root package name */
    public static final a8.d<Map.Entry<Object, Object>> f24450h;

    /* renamed from: a, reason: collision with root package name */
    public OutputStream f24451a;

    /* renamed from: b, reason: collision with root package name */
    public final Map<Class<?>, a8.d<?>> f24452b;

    /* renamed from: c, reason: collision with root package name */
    public final Map<Class<?>, a8.f<?>> f24453c;

    /* renamed from: d, reason: collision with root package name */
    public final a8.d<Object> f24454d;

    static {
        c.b a10 = a8.c.a("key");
        h hVar = new h();
        hVar.a(1);
        f24448f = a10.b(hVar.b()).a();
        c.b a11 = a8.c.a("value");
        h hVar2 = new h();
        hVar2.a(2);
        f24449g = a11.b(hVar2.b()).a();
        f24450h = l.f24425a;
    }

    public m(OutputStream outputStream, Map<Class<?>, a8.d<?>> map, Map<Class<?>, a8.f<?>> map2, a8.d<Object> dVar) {
        this.f24451a = outputStream;
        this.f24452b = map;
        this.f24453c = map2;
        this.f24454d = dVar;
    }

    public static final /* synthetic */ void j(Map.Entry entry, a8.e eVar) throws IOException {
        eVar.e(f24448f, entry.getKey());
        eVar.e(f24449g, entry.getValue());
    }

    public static ByteBuffer n(int i10) {
        return ByteBuffer.allocate(i10).order(ByteOrder.LITTLE_ENDIAN);
    }

    public static int o(a8.c cVar) {
        k kVar = (k) cVar.c(k.class);
        if (kVar != null) {
            return kVar.zza();
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    public static k p(a8.c cVar) {
        k kVar = (k) cVar.c(k.class);
        if (kVar != null) {
            return kVar;
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    @NonNull
    public final a8.e a(@NonNull a8.c cVar, double d10) throws IOException {
        if (d10 == ShadowDrawableWrapper.COS_45) {
            return this;
        }
        q((o(cVar) << 3) | 1);
        this.f24451a.write(n(8).putDouble(d10).array());
        return this;
    }

    @NonNull
    public final a8.e b(@NonNull a8.c cVar, float f10) throws IOException {
        if (f10 == 0.0f) {
            return this;
        }
        q((o(cVar) << 3) | 5);
        this.f24451a.write(n(4).putFloat(f10).array());
        return this;
    }

    @Override // a8.e
    @NonNull
    public final a8.e c(@NonNull String str, @Nullable Object obj) throws IOException {
        e(a8.c.d(str), obj);
        return this;
    }

    @Override // a8.e
    @NonNull
    public final a8.e d(@NonNull String str, long j10) throws IOException {
        g(a8.c.d(str), j10);
        return this;
    }

    @Override // a8.e
    @NonNull
    public final a8.e e(@NonNull a8.c cVar, @Nullable Object obj) throws IOException {
        if (obj == null) {
            return this;
        }
        if (obj instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) obj;
            if (charSequence.length() == 0) {
                return this;
            }
            q((o(cVar) << 3) | 2);
            byte[] bytes = charSequence.toString().getBytes(f24447e);
            q(bytes.length);
            this.f24451a.write(bytes);
            return this;
        }
        if (obj instanceof Collection) {
            Iterator iterator2 = ((Collection) obj).iterator2();
            while (iterator2.hasNext()) {
                e(cVar, iterator2.next());
            }
            return this;
        }
        if (obj instanceof Map) {
            Iterator iterator22 = ((Map) obj).entrySet().iterator2();
            while (iterator22.hasNext()) {
                k(f24450h, cVar, (Map.Entry) iterator22.next());
            }
            return this;
        }
        if (obj instanceof Double) {
            a(cVar, ((Double) obj).doubleValue());
            return this;
        }
        if (obj instanceof Float) {
            b(cVar, ((Float) obj).floatValue());
            return this;
        }
        if (obj instanceof Number) {
            g(cVar, ((Number) obj).longValue());
            return this;
        }
        if (obj instanceof Boolean) {
            h(cVar, ((Boolean) obj).booleanValue());
            return this;
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            int length = bArr.length;
            if (length == 0) {
                return this;
            }
            q((o(cVar) << 3) | 2);
            q(length);
            this.f24451a.write(bArr);
            return this;
        }
        a8.d<?> dVar = this.f24452b.get(obj.getClass());
        if (dVar != null) {
            k(dVar, cVar, obj);
            return this;
        }
        a8.f<?> fVar = this.f24453c.get(obj.getClass());
        if (fVar != null) {
            m(fVar, cVar, obj);
            return this;
        }
        if (obj instanceof j) {
            f(cVar, ((j) obj).zza());
            return this;
        }
        if (obj instanceof Enum) {
            f(cVar, ((Enum) obj).ordinal());
            return this;
        }
        k(this.f24454d, cVar, obj);
        return this;
    }

    @NonNull
    public final m f(@NonNull a8.c cVar, int i10) throws IOException {
        if (i10 == 0) {
            return this;
        }
        k p10 = p(cVar);
        zzaj zzajVar = zzaj.DEFAULT;
        int ordinal = p10.zzb().ordinal();
        if (ordinal == 0) {
            q(p10.zza() << 3);
            q(i10);
        } else if (ordinal == 1) {
            q(p10.zza() << 3);
            q((i10 + i10) ^ (i10 >> 31));
        } else if (ordinal == 2) {
            q((p10.zza() << 3) | 5);
            this.f24451a.write(n(4).putInt(i10).array());
        }
        return this;
    }

    @NonNull
    public final m g(@NonNull a8.c cVar, long j10) throws IOException {
        if (j10 == 0) {
            return this;
        }
        k p10 = p(cVar);
        zzaj zzajVar = zzaj.DEFAULT;
        int ordinal = p10.zzb().ordinal();
        if (ordinal == 0) {
            q(p10.zza() << 3);
            r(j10);
        } else if (ordinal == 1) {
            q(p10.zza() << 3);
            r((j10 >> 63) ^ (j10 + j10));
        } else if (ordinal == 2) {
            q((p10.zza() << 3) | 1);
            this.f24451a.write(n(8).putLong(j10).array());
        }
        return this;
    }

    @NonNull
    public final m h(@NonNull a8.c cVar, boolean z10) throws IOException {
        if (!z10) {
            return this;
        }
        f(cVar, 1);
        return this;
    }

    public final m i(@Nullable Object obj) throws IOException {
        if (obj == null) {
            return this;
        }
        a8.d<?> dVar = this.f24452b.get(obj.getClass());
        if (dVar != null) {
            dVar.a(obj, this);
            return this;
        }
        String valueOf = String.valueOf(obj.getClass());
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 15);
        sb2.append("No encoder for ");
        sb2.append(valueOf);
        throw new EncodingException(sb2.toString());
    }

    public final <T> m k(a8.d<T> dVar, a8.c cVar, T t2) throws IOException {
        long l10 = l(dVar, t2);
        if (l10 == 0) {
            return this;
        }
        q((o(cVar) << 3) | 2);
        r(l10);
        dVar.a(t2, this);
        return this;
    }

    public final <T> long l(a8.d<T> dVar, T t2) throws IOException {
        i iVar = new i();
        try {
            OutputStream outputStream = this.f24451a;
            this.f24451a = iVar;
            try {
                dVar.a(t2, this);
                this.f24451a = outputStream;
                long a10 = iVar.a();
                iVar.close();
                return a10;
            } catch (Throwable th) {
                this.f24451a = outputStream;
                throw th;
            }
        } catch (Throwable th2) {
            try {
                iVar.close();
            } catch (Throwable th3) {
                f.a(th2, th3);
            }
            throw th2;
        }
    }

    public final <T> m m(a8.f<T> fVar, a8.c cVar, T t2) throws IOException {
        fVar.a(t2, new q(cVar, this));
        return this;
    }

    public final void q(int i10) throws IOException {
        while ((i10 & (-128)) != 0) {
            this.f24451a.write((i10 & 127) | 128);
            i10 >>>= 7;
        }
        this.f24451a.write(i10 & 127);
    }

    public final void r(long j10) throws IOException {
        while (((-128) & j10) != 0) {
            this.f24451a.write((((int) j10) & 127) | 128);
            j10 >>>= 7;
        }
        this.f24451a.write(((int) j10) & 127);
    }
}
