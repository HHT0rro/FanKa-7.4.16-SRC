package a8;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alipay.sdk.util.i;
import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: FieldDescriptor.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f717a;

    /* renamed from: b, reason: collision with root package name */
    public final Map<Class<?>, Object> f718b;

    /* compiled from: FieldDescriptor.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f719a;

        /* renamed from: b, reason: collision with root package name */
        public Map<Class<?>, Object> f720b = null;

        public b(String str) {
            this.f719a = str;
        }

        @NonNull
        public c a() {
            Map unmodifiableMap;
            String str = this.f719a;
            if (this.f720b == null) {
                unmodifiableMap = Collections.emptyMap();
            } else {
                unmodifiableMap = Collections.unmodifiableMap(new HashMap(this.f720b));
            }
            return new c(str, unmodifiableMap);
        }

        @NonNull
        public <T extends Annotation> b b(@NonNull T t2) {
            if (this.f720b == null) {
                this.f720b = new HashMap();
            }
            this.f720b.put(t2.annotationType(), t2);
            return this;
        }
    }

    @NonNull
    public static b a(@NonNull String str) {
        return new b(str);
    }

    @NonNull
    public static c d(@NonNull String str) {
        return new c(str, Collections.emptyMap());
    }

    @NonNull
    public String b() {
        return this.f717a;
    }

    @Nullable
    public <T extends Annotation> T c(@NonNull Class<T> cls) {
        return (T) this.f718b.get(cls);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f717a.equals(cVar.f717a) && this.f718b.equals(cVar.f718b);
    }

    public int hashCode() {
        return (this.f717a.hashCode() * 31) + this.f718b.hashCode();
    }

    @NonNull
    public String toString() {
        return "FieldDescriptor{name=" + this.f717a + ", properties=" + ((Object) this.f718b.values()) + i.f4738d;
    }

    public c(String str, Map<Class<?>, Object> map) {
        this.f717a = str;
        this.f718b = map;
    }
}
