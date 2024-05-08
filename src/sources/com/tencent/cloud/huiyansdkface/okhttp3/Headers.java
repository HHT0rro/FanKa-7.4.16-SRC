package com.tencent.cloud.huiyansdkface.okhttp3;

import com.huawei.openalliance.ad.constant.u;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http.HttpDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class Headers {

    /* renamed from: a, reason: collision with root package name */
    private final String[] f41410a;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public final List<String> f41411a = new ArrayList(20);

        public Builder a(String str) {
            int indexOf = str.indexOf(u.bD, 1);
            return indexOf != -1 ? a(str.substring(0, indexOf), str.substring(indexOf + 1)) : str.startsWith(u.bD) ? a("", str.substring(1)) : a("", str);
        }

        public Builder a(String str, String str2) {
            this.f41411a.add(str);
            this.f41411a.add(str2.trim());
            return this;
        }

        public Builder add(String str) {
            int indexOf = str.indexOf(u.bD);
            if (indexOf != -1) {
                return add(str.substring(0, indexOf).trim(), str.substring(indexOf + 1));
            }
            throw new IllegalArgumentException("Unexpected header: " + str);
        }

        public Builder add(String str, String str2) {
            Headers.a(str);
            Headers.a(str2, str);
            return a(str, str2);
        }

        public Builder add(String str, Date date) {
            if (date != null) {
                add(str, HttpDate.format(date));
                return this;
            }
            throw new NullPointerException("value for name " + str + " == null");
        }

        public Builder addAll(Headers headers) {
            int size = headers.size();
            for (int i10 = 0; i10 < size; i10++) {
                a(headers.name(i10), headers.value(i10));
            }
            return this;
        }

        public Builder addUnsafeNonAscii(String str, String str2) {
            Headers.a(str);
            return a(str, str2);
        }

        public Headers build() {
            return new Headers(this);
        }

        public String get(String str) {
            for (int size = this.f41411a.size() - 2; size >= 0; size -= 2) {
                if (str.equalsIgnoreCase(this.f41411a.get(size))) {
                    return this.f41411a.get(size + 1);
                }
            }
            return null;
        }

        public Builder removeAll(String str) {
            int i10 = 0;
            while (i10 < this.f41411a.size()) {
                if (str.equalsIgnoreCase(this.f41411a.get(i10))) {
                    this.f41411a.remove(i10);
                    this.f41411a.remove(i10);
                    i10 -= 2;
                }
                i10 += 2;
            }
            return this;
        }

        public Builder set(String str, String str2) {
            Headers.a(str);
            Headers.a(str2, str);
            removeAll(str);
            a(str, str2);
            return this;
        }

        public Builder set(String str, Date date) {
            if (date != null) {
                set(str, HttpDate.format(date));
                return this;
            }
            throw new NullPointerException("value for name " + str + " == null");
        }
    }

    public Headers(Builder builder) {
        List<String> list = builder.f41411a;
        this.f41410a = (String[]) list.toArray(new String[list.size()]);
    }

    private Headers(String[] strArr) {
        this.f41410a = strArr;
    }

    private static String a(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    public static void a(String str) {
        Objects.requireNonNull(str, "name == null");
        if (str.isEmpty()) {
            throw new IllegalArgumentException("name is empty");
        }
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char charAt = str.charAt(i10);
            if (charAt <= ' ' || charAt >= 127) {
                throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i10), str));
            }
        }
    }

    public static void a(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("value for name " + str2 + " == null");
        }
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char charAt = str.charAt(i10);
            if ((charAt <= 31 && charAt != '\t') || charAt >= 127) {
                throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt), Integer.valueOf(i10), str2, str));
            }
        }
    }

    public static Headers of(Map<String, String> map) {
        Objects.requireNonNull(map, "headers == null");
        String[] strArr = new String[map.size() * 2];
        int i10 = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey() == null || entry.getValue() == null) {
                throw new IllegalArgumentException("Headers cannot be null");
            }
            String trim = entry.getKey().trim();
            String trim2 = entry.getValue().trim();
            a(trim);
            a(trim2, trim);
            strArr[i10] = trim;
            strArr[i10 + 1] = trim2;
            i10 += 2;
        }
        return new Headers(strArr);
    }

    public static Headers of(String... strArr) {
        Objects.requireNonNull(strArr, "namesAndValues == null");
        if (strArr.length % 2 != 0) {
            throw new IllegalArgumentException("Expected alternating header names and values");
        }
        String[] strArr2 = (String[]) strArr.clone();
        for (int i10 = 0; i10 < strArr2.length; i10++) {
            if (strArr2[i10] == null) {
                throw new IllegalArgumentException("Headers cannot be null");
            }
            strArr2[i10] = strArr2[i10].trim();
        }
        for (int i11 = 0; i11 < strArr2.length; i11 += 2) {
            String str = strArr2[i11];
            String str2 = strArr2[i11 + 1];
            a(str);
            a(str2, str);
        }
        return new Headers(strArr2);
    }

    public long byteCount() {
        String[] strArr = this.f41410a;
        long length = strArr.length * 2;
        for (int i10 = 0; i10 < strArr.length; i10++) {
            length += this.f41410a[i10].length();
        }
        return length;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Headers) && Arrays.equals(((Headers) obj).f41410a, this.f41410a);
    }

    public String get(String str) {
        return a(this.f41410a, str);
    }

    public Date getDate(String str) {
        String str2 = get(str);
        if (str2 != null) {
            return HttpDate.parse(str2);
        }
        return null;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f41410a);
    }

    public String name(int i10) {
        return this.f41410a[i10 * 2];
    }

    public Set<String> names() {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            treeSet.add(name(i10));
        }
        return Collections.unmodifiableSet(treeSet);
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        Collections.addAll(builder.f41411a, this.f41410a);
        return builder;
    }

    public int size() {
        return this.f41410a.length / 2;
    }

    public Map<String, List<String>> toMultimap() {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            String lowerCase = name(i10).toLowerCase(Locale.US);
            List list = (List) treeMap.get(lowerCase);
            if (list == null) {
                list = new ArrayList(2);
                treeMap.put(lowerCase, list);
            }
            list.add(value(i10));
        }
        return treeMap;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            sb2.append(name(i10));
            sb2.append(": ");
            sb2.append(value(i10));
            sb2.append("\n");
        }
        return sb2.toString();
    }

    public String value(int i10) {
        return this.f41410a[(i10 * 2) + 1];
    }

    public List<String> values(String str) {
        int size = size();
        ArrayList arrayList = null;
        for (int i10 = 0; i10 < size; i10++) {
            if (str.equalsIgnoreCase(name(i10))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(value(i10));
            }
        }
        return arrayList != null ? Collections.unmodifiableList(arrayList) : Collections.emptyList();
    }
}
