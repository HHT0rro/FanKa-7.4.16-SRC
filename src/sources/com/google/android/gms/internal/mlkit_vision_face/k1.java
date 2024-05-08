package com.google.android.gms.internal.mlkit_vision_face;

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

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class k1 implements a8.e {

    /* renamed from: e, reason: collision with root package name */
    public static final Charset f24994e = Charset.forName("UTF-8");

    /* renamed from: f, reason: collision with root package name */
    public static final a8.c f24995f;

    /* renamed from: g, reason: collision with root package name */
    public static final a8.c f24996g;

    /* renamed from: h, reason: collision with root package name */
    public static final a8.d<Map.Entry<Object, Object>> f24997h;

    /* renamed from: a, reason: collision with root package name */
    public OutputStream f24998a;

    /* renamed from: b, reason: collision with root package name */
    public final Map<Class<?>, a8.d<?>> f24999b;

    /* renamed from: c, reason: collision with root package name */
    public final Map<Class<?>, a8.f<?>> f25000c;

    /* renamed from: d, reason: collision with root package name */
    public final a8.d<Object> f25001d;

    static {
        c.b a10 = a8.c.a("key");
        f1 f1Var = new f1();
        f1Var.a(1);
        f24995f = a10.b(f1Var.b()).a();
        c.b a11 = a8.c.a("value");
        f1 f1Var2 = new f1();
        f1Var2.a(2);
        f24996g = a11.b(f1Var2.b()).a();
        f24997h = j1.f24954a;
    }

    public k1(OutputStream outputStream, Map<Class<?>, a8.d<?>> map, Map<Class<?>, a8.f<?>> map2, a8.d<Object> dVar) {
        this.f24998a = outputStream;
        this.f24999b = map;
        this.f25000c = map2;
        this.f25001d = dVar;
    }

    public static final /* synthetic */ void j(Map.Entry entry, a8.e eVar) throws IOException {
        eVar.e(f24995f, entry.getKey());
        eVar.e(f24996g, entry.getValue());
    }

    public static ByteBuffer n(int i10) {
        return ByteBuffer.allocate(i10).order(ByteOrder.LITTLE_ENDIAN);
    }

    public static int o(a8.c cVar) {
        i1 i1Var = (i1) cVar.c(i1.class);
        if (i1Var != null) {
            return i1Var.zza();
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    public static i1 p(a8.c cVar) {
        i1 i1Var = (i1) cVar.c(i1.class);
        if (i1Var != null) {
            return i1Var;
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    @NonNull
    public final a8.e a(@NonNull a8.c cVar, double d10) throws IOException {
        if (d10 == ShadowDrawableWrapper.COS_45) {
            return this;
        }
        q((o(cVar) << 3) | 1);
        this.f24998a.write(n(8).putDouble(d10).array());
        return this;
    }

    @NonNull
    public final a8.e b(@NonNull a8.c cVar, float f10) throws IOException {
        if (f10 == 0.0f) {
            return this;
        }
        q((o(cVar) << 3) | 5);
        this.f24998a.write(n(4).putFloat(f10).array());
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
            byte[] bytes = charSequence.toString().getBytes(f24994e);
            q(bytes.length);
            this.f24998a.write(bytes);
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
                k(f24997h, cVar, (Map.Entry) iterator22.next());
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
            this.f24998a.write(bArr);
            return this;
        }
        a8.d<?> dVar = this.f24999b.get(obj.getClass());
        if (dVar != null) {
            k(dVar, cVar, obj);
            return this;
        }
        a8.f<?> fVar = this.f25000c.get(obj.getClass());
        if (fVar != null) {
            m(fVar, cVar, obj);
            return this;
        }
        if (obj instanceof h1) {
            f(cVar, ((h1) obj).zza());
            return this;
        }
        if (obj instanceof Enum) {
            f(cVar, ((Enum) obj).ordinal());
            return this;
        }
        k(this.f25001d, cVar, obj);
        return this;
    }

    @NonNull
    public final k1 f(@NonNull a8.c cVar, int i10) throws IOException {
        if (i10 == 0) {
            return this;
        }
        i1 p10 = p(cVar);
        zzcv zzcvVar = zzcv.DEFAULT;
        int ordinal = p10.zzb().ordinal();
        if (ordinal == 0) {
            q(p10.zza() << 3);
            q(i10);
        } else if (ordinal == 1) {
            q(p10.zza() << 3);
            q((i10 + i10) ^ (i10 >> 31));
        } else if (ordinal == 2) {
            q((p10.zza() << 3) | 5);
            this.f24998a.write(n(4).putInt(i10).array());
        }
        return this;
    }

    @NonNull
    public final k1 g(@NonNull a8.c cVar, long j10) throws IOException {
        if (j10 == 0) {
            return this;
        }
        i1 p10 = p(cVar);
        zzcv zzcvVar = zzcv.DEFAULT;
        int ordinal = p10.zzb().ordinal();
        if (ordinal == 0) {
            q(p10.zza() << 3);
            r(j10);
        } else if (ordinal == 1) {
            q(p10.zza() << 3);
            r((j10 >> 63) ^ (j10 + j10));
        } else if (ordinal == 2) {
            q((p10.zza() << 3) | 1);
            this.f24998a.write(n(8).putLong(j10).array());
        }
        return this;
    }

    @NonNull
    public final k1 h(@NonNull a8.c cVar, boolean z10) throws IOException {
        if (!z10) {
            return this;
        }
        f(cVar, 1);
        return this;
    }

    public final k1 i(@Nullable Object obj) throws IOException {
        if (obj == null) {
            return this;
        }
        a8.d<?> dVar = this.f24999b.get(obj.getClass());
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

    public final <T> k1 k(a8.d<T> dVar, a8.c cVar, T t2) throws IOException {
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
        g1 g1Var = new g1();
        try {
            OutputStream outputStream = this.f24998a;
            this.f24998a = g1Var;
            try {
                dVar.a(t2, this);
                this.f24998a = outputStream;
                long a10 = g1Var.a();
                g1Var.close();
                return a10;
            } catch (Throwable th) {
                this.f24998a = outputStream;
                throw th;
            }
        } catch (Throwable th2) {
            try {
                g1Var.close();
            } catch (Throwable th3) {
                d1.a(th2, th3);
            }
            throw th2;
        }
    }

    public final <T> k1 m(a8.f<T> fVar, a8.c cVar, T t2) throws IOException {
        fVar.a(t2, new o1(cVar, this));
        return this;
    }

    public final void q(int i10) throws IOException {
        while ((i10 & (-128)) != 0) {
            this.f24998a.write((i10 & 127) | 128);
            i10 >>>= 7;
        }
        this.f24998a.write(i10 & 127);
    }

    public final void r(long j10) throws IOException {
        while (((-128) & j10) != 0) {
            this.f24998a.write((((int) j10) & 127) | 128);
            j10 >>>= 7;
        }
        this.f24998a.write(((int) j10) & 127);
    }
}
