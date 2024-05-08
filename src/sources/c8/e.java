package c8;

import a8.f;
import a8.g;
import android.util.Base64;
import android.util.JsonWriter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.encoders.EncodingException;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

/* compiled from: JsonValueObjectEncoderContext.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class e implements a8.e, g {

    /* renamed from: a, reason: collision with root package name */
    public e f1576a = null;

    /* renamed from: b, reason: collision with root package name */
    public boolean f1577b = true;

    /* renamed from: c, reason: collision with root package name */
    public final JsonWriter f1578c;

    /* renamed from: d, reason: collision with root package name */
    public final Map<Class<?>, a8.d<?>> f1579d;

    /* renamed from: e, reason: collision with root package name */
    public final Map<Class<?>, f<?>> f1580e;

    /* renamed from: f, reason: collision with root package name */
    public final a8.d<Object> f1581f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f1582g;

    public e(@NonNull Writer writer, @NonNull Map<Class<?>, a8.d<?>> map, @NonNull Map<Class<?>, f<?>> map2, a8.d<Object> dVar, boolean z10) {
        this.f1578c = new JsonWriter(writer);
        this.f1579d = map;
        this.f1580e = map2;
        this.f1581f = dVar;
        this.f1582g = z10;
    }

    @Override // a8.e
    @NonNull
    public a8.e e(@NonNull a8.c cVar, @Nullable Object obj) throws IOException {
        return c(cVar.b(), obj);
    }

    @NonNull
    public e f(long j10) throws IOException {
        r();
        this.f1578c.value(j10);
        return this;
    }

    @NonNull
    public e g(@Nullable Object obj, boolean z10) throws IOException {
        int i10 = 0;
        if (z10 && m(obj)) {
            Object[] objArr = new Object[1];
            objArr[0] = obj == null ? null : obj.getClass();
            throw new EncodingException(String.format("%s cannot be encoded inline", objArr));
        }
        if (obj == null) {
            this.f1578c.nullValue();
            return this;
        }
        if (obj instanceof Number) {
            this.f1578c.value((Number) obj);
            return this;
        }
        if (obj.getClass().isArray()) {
            if (obj instanceof byte[]) {
                return l((byte[]) obj);
            }
            this.f1578c.beginArray();
            if (obj instanceof int[]) {
                int length = ((int[]) obj).length;
                while (i10 < length) {
                    this.f1578c.value(r6[i10]);
                    i10++;
                }
            } else if (obj instanceof long[]) {
                long[] jArr = (long[]) obj;
                int length2 = jArr.length;
                while (i10 < length2) {
                    f(jArr[i10]);
                    i10++;
                }
            } else if (obj instanceof double[]) {
                double[] dArr = (double[]) obj;
                int length3 = dArr.length;
                while (i10 < length3) {
                    this.f1578c.value(dArr[i10]);
                    i10++;
                }
            } else if (obj instanceof boolean[]) {
                boolean[] zArr = (boolean[]) obj;
                int length4 = zArr.length;
                while (i10 < length4) {
                    this.f1578c.value(zArr[i10]);
                    i10++;
                }
            } else if (obj instanceof Number[]) {
                for (Number number : (Number[]) obj) {
                    g(number, false);
                }
            } else {
                for (Object obj2 : (Object[]) obj) {
                    g(obj2, false);
                }
            }
            this.f1578c.endArray();
            return this;
        }
        if (obj instanceof Collection) {
            this.f1578c.beginArray();
            Iterator iterator2 = ((Collection) obj).iterator2();
            while (iterator2.hasNext()) {
                g(iterator2.next(), false);
            }
            this.f1578c.endArray();
            return this;
        }
        if (obj instanceof Map) {
            this.f1578c.beginObject();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                Object key = entry.getKey();
                try {
                    c((String) key, entry.getValue());
                } catch (ClassCastException e2) {
                    throw new EncodingException(String.format("Only String keys are currently supported in maps, got %s of type %s instead.", key, key.getClass()), e2);
                }
            }
            this.f1578c.endObject();
            return this;
        }
        a8.d<?> dVar = this.f1579d.get(obj.getClass());
        if (dVar != null) {
            return o(dVar, obj, z10);
        }
        f<?> fVar = this.f1580e.get(obj.getClass());
        if (fVar != null) {
            fVar.a(obj, this);
            return this;
        }
        if (obj instanceof Enum) {
            a(((Enum) obj).name());
            return this;
        }
        return o(this.f1581f, obj, z10);
    }

    @Override // a8.g
    @NonNull
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public e a(@Nullable String str) throws IOException {
        r();
        this.f1578c.value(str);
        return this;
    }

    @Override // a8.e
    @NonNull
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public e d(@NonNull String str, long j10) throws IOException {
        r();
        this.f1578c.name(str);
        return f(j10);
    }

    @Override // a8.e
    @NonNull
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public e c(@NonNull String str, @Nullable Object obj) throws IOException {
        if (this.f1582g) {
            return q(str, obj);
        }
        return p(str, obj);
    }

    @Override // a8.g
    @NonNull
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public e b(boolean z10) throws IOException {
        r();
        this.f1578c.value(z10);
        return this;
    }

    @NonNull
    public e l(@Nullable byte[] bArr) throws IOException {
        r();
        if (bArr == null) {
            this.f1578c.nullValue();
        } else {
            this.f1578c.value(Base64.encodeToString(bArr, 2));
        }
        return this;
    }

    public final boolean m(Object obj) {
        return obj == null || obj.getClass().isArray() || (obj instanceof Collection) || (obj instanceof Date) || (obj instanceof Enum) || (obj instanceof Number);
    }

    public void n() throws IOException {
        r();
        this.f1578c.flush();
    }

    public e o(a8.d<Object> dVar, Object obj, boolean z10) throws IOException {
        if (!z10) {
            this.f1578c.beginObject();
        }
        dVar.a(obj, this);
        if (!z10) {
            this.f1578c.endObject();
        }
        return this;
    }

    public final e p(@NonNull String str, @Nullable Object obj) throws IOException, EncodingException {
        r();
        this.f1578c.name(str);
        if (obj == null) {
            this.f1578c.nullValue();
            return this;
        }
        return g(obj, false);
    }

    public final e q(@NonNull String str, @Nullable Object obj) throws IOException, EncodingException {
        if (obj == null) {
            return this;
        }
        r();
        this.f1578c.name(str);
        return g(obj, false);
    }

    public final void r() throws IOException {
        if (this.f1577b) {
            e eVar = this.f1576a;
            if (eVar != null) {
                eVar.r();
                this.f1576a.f1577b = false;
                this.f1576a = null;
                this.f1578c.endObject();
                return;
            }
            return;
        }
        throw new IllegalStateException("Parent context used since this context was created. Cannot use this context anymore.");
    }
}
