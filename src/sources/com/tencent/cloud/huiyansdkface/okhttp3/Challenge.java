package com.tencent.cloud.huiyansdkface.okhttp3;

import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class Challenge {

    /* renamed from: a, reason: collision with root package name */
    private final String f41304a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, String> f41305b;

    public Challenge(String str, String str2) {
        Objects.requireNonNull(str, "scheme == null");
        Objects.requireNonNull(str2, "realm == null");
        this.f41304a = str;
        this.f41305b = Collections.singletonMap("realm", str2);
    }

    public Challenge(String str, Map<String, String> map) {
        Objects.requireNonNull(str, "scheme == null");
        Objects.requireNonNull(map, "authParams == null");
        this.f41304a = str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey() == null ? null : entry.getKey().toLowerCase(Locale.US), entry.getValue());
        }
        this.f41305b = Collections.unmodifiableMap(linkedHashMap);
    }

    public Map<String, String> authParams() {
        return this.f41305b;
    }

    public Charset charset() {
        String str = this.f41305b.get("charset");
        if (str != null) {
            try {
                return Charset.forName(str);
            } catch (Exception unused) {
            }
        }
        return Util.f41605f;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Challenge) {
            Challenge challenge = (Challenge) obj;
            if (challenge.f41304a.equals(this.f41304a) && challenge.f41305b.equals(this.f41305b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((899 + this.f41304a.hashCode()) * 31) + this.f41305b.hashCode();
    }

    public String realm() {
        return this.f41305b.get("realm");
    }

    public String scheme() {
        return this.f41304a;
    }

    public String toString() {
        return this.f41304a + " authParams=" + ((Object) this.f41305b);
    }

    public Challenge withCharset(Charset charset) {
        Objects.requireNonNull(charset, "charset == null");
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.f41305b);
        linkedHashMap.put("charset", charset.name());
        return new Challenge(this.f41304a, linkedHashMap);
    }
}
