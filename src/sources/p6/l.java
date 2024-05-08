package p6;

import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: DefaultContentMetadata.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class l implements j {

    /* renamed from: c, reason: collision with root package name */
    public static final l f52900c = new l(Collections.emptyMap());

    /* renamed from: a, reason: collision with root package name */
    public int f52901a;

    /* renamed from: b, reason: collision with root package name */
    public final Map<String, byte[]> f52902b;

    public l() {
        this(Collections.emptyMap());
    }

    public static void b(HashMap<String, byte[]> hashMap, Map<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            hashMap.put(entry.getKey(), f(entry.getValue()));
        }
    }

    public static Map<String, byte[]> c(Map<String, byte[]> map, k kVar) {
        HashMap hashMap = new HashMap(map);
        h(hashMap, kVar.c());
        b(hashMap, kVar.b());
        return hashMap;
    }

    public static byte[] f(Object obj) {
        if (obj instanceof Long) {
            return ByteBuffer.allocate(8).putLong(((Long) obj).longValue()).array();
        }
        if (obj instanceof String) {
            return ((String) obj).getBytes(com.google.common.base.c.f25961c);
        }
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        throw new IllegalArgumentException();
    }

    public static boolean g(Map<String, byte[]> map, Map<String, byte[]> map2) {
        if (map.size() != map2.size()) {
            return false;
        }
        for (Map.Entry<String, byte[]> entry : map.entrySet()) {
            if (!Arrays.equals(entry.getValue(), map2.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    public static void h(HashMap<String, byte[]> hashMap, List<String> list) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            hashMap.remove(list.get(i10));
        }
    }

    @Override // p6.j
    public final long a(String str, long j10) {
        byte[] bArr = this.f52902b.get(str);
        return bArr != null ? ByteBuffer.wrap(bArr).getLong() : j10;
    }

    public l d(k kVar) {
        Map<String, byte[]> c4 = c(this.f52902b, kVar);
        return g(this.f52902b, c4) ? this : new l(c4);
    }

    public Set<Map.Entry<String, byte[]>> e() {
        return this.f52902b.entrySet();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || l.class != obj.getClass()) {
            return false;
        }
        return g(this.f52902b, ((l) obj).f52902b);
    }

    @Override // p6.j
    @Nullable
    public final String get(String str, @Nullable String str2) {
        byte[] bArr = this.f52902b.get(str);
        return bArr != null ? new String(bArr, com.google.common.base.c.f25961c) : str2;
    }

    public int hashCode() {
        if (this.f52901a == 0) {
            int i10 = 0;
            for (Map.Entry<String, byte[]> entry : this.f52902b.entrySet()) {
                i10 += Arrays.hashCode(entry.getValue()) ^ entry.getKey().hashCode();
            }
            this.f52901a = i10;
        }
        return this.f52901a;
    }

    public l(Map<String, byte[]> map) {
        this.f52902b = Collections.unmodifiableMap(map);
    }
}
