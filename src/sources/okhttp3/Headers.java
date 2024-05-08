package okhttp3;

import ce.h;
import ce.n;
import com.android.internal.accessibility.common.ShortcutConstants;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import kotlin.Pair;
import kotlin.collections.m;
import kotlin.collections.x;
import kotlin.d;
import kotlin.f;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.y;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.p;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import zd.a;

/* compiled from: Headers.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class Headers implements Iterable<Pair<? extends String, ? extends String>>, a {
    public static final Companion Companion = new Companion(null);
    private final String[] namesAndValues;

    /* compiled from: Headers.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Builder {

        @NotNull
        private final List<String> namesAndValues = new ArrayList(20);

        @NotNull
        public final Builder add(@NotNull String line) {
            s.i(line, "line");
            int W = StringsKt__StringsKt.W(line, ShortcutConstants.SERVICES_SEPARATOR, 0, false, 6, null);
            if (W != -1) {
                String substring = line.substring(0, W);
                s.h(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                Objects.requireNonNull(substring, "null cannot be cast to non-null type kotlin.CharSequence");
                String obj = StringsKt__StringsKt.P0(substring).toString();
                String substring2 = line.substring(W + 1);
                s.h(substring2, "(this as java.lang.String).substring(startIndex)");
                add(obj, substring2);
                return this;
            }
            throw new IllegalArgumentException(("Unexpected header: " + line).toString());
        }

        @NotNull
        public final Builder addAll(@NotNull Headers headers) {
            s.i(headers, "headers");
            int size = headers.size();
            for (int i10 = 0; i10 < size; i10++) {
                addLenient$okhttp(headers.name(i10), headers.value(i10));
            }
            return this;
        }

        @NotNull
        public final Builder addLenient$okhttp(@NotNull String line) {
            s.i(line, "line");
            int W = StringsKt__StringsKt.W(line, ShortcutConstants.SERVICES_SEPARATOR, 1, false, 4, null);
            if (W != -1) {
                String substring = line.substring(0, W);
                s.h(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                String substring2 = line.substring(W + 1);
                s.h(substring2, "(this as java.lang.String).substring(startIndex)");
                addLenient$okhttp(substring, substring2);
            } else if (line.charAt(0) == ':') {
                String substring3 = line.substring(1);
                s.h(substring3, "(this as java.lang.String).substring(startIndex)");
                addLenient$okhttp("", substring3);
            } else {
                addLenient$okhttp("", line);
            }
            return this;
        }

        @NotNull
        public final Builder addUnsafeNonAscii(@NotNull String name, @NotNull String value) {
            s.i(name, "name");
            s.i(value, "value");
            Headers.Companion.checkName(name);
            addLenient$okhttp(name, value);
            return this;
        }

        @NotNull
        public final Headers build() {
            Object[] array = this.namesAndValues.toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            return new Headers((String[]) array, null);
        }

        @Nullable
        public final String get(@NotNull String name) {
            s.i(name, "name");
            h h10 = n.h(n.g(this.namesAndValues.size() - 2, 0), 2);
            int b4 = h10.b();
            int c4 = h10.c();
            int f10 = h10.f();
            if (f10 >= 0) {
                if (b4 > c4) {
                    return null;
                }
            } else if (b4 < c4) {
                return null;
            }
            while (!p.r(name, this.namesAndValues.get(b4), true)) {
                if (b4 == c4) {
                    return null;
                }
                b4 += f10;
            }
            return this.namesAndValues.get(b4 + 1);
        }

        @NotNull
        public final List<String> getNamesAndValues$okhttp() {
            return this.namesAndValues;
        }

        @NotNull
        public final Builder removeAll(@NotNull String name) {
            s.i(name, "name");
            int i10 = 0;
            while (i10 < this.namesAndValues.size()) {
                if (p.r(name, this.namesAndValues.get(i10), true)) {
                    this.namesAndValues.remove(i10);
                    this.namesAndValues.remove(i10);
                    i10 -= 2;
                }
                i10 += 2;
            }
            return this;
        }

        @NotNull
        public final Builder set(@NotNull String name, @NotNull Date value) {
            s.i(name, "name");
            s.i(value, "value");
            set(name, DatesKt.toHttpDateString(value));
            return this;
        }

        @NotNull
        public final Builder set(@NotNull String name, @NotNull Instant value) {
            s.i(name, "name");
            s.i(value, "value");
            return set(name, new Date(value.toEpochMilli()));
        }

        @NotNull
        public final Builder set(@NotNull String name, @NotNull String value) {
            s.i(name, "name");
            s.i(value, "value");
            Companion companion = Headers.Companion;
            companion.checkName(name);
            companion.checkValue(value, name);
            removeAll(name);
            addLenient$okhttp(name, value);
            return this;
        }

        @NotNull
        public final Builder add(@NotNull String name, @NotNull String value) {
            s.i(name, "name");
            s.i(value, "value");
            Companion companion = Headers.Companion;
            companion.checkName(name);
            companion.checkValue(value, name);
            addLenient$okhttp(name, value);
            return this;
        }

        @NotNull
        public final Builder addLenient$okhttp(@NotNull String name, @NotNull String value) {
            s.i(name, "name");
            s.i(value, "value");
            this.namesAndValues.add(name);
            this.namesAndValues.add(StringsKt__StringsKt.P0(value).toString());
            return this;
        }

        @NotNull
        public final Builder add(@NotNull String name, @NotNull Date value) {
            s.i(name, "name");
            s.i(value, "value");
            add(name, DatesKt.toHttpDateString(value));
            return this;
        }

        @NotNull
        public final Builder add(@NotNull String name, @NotNull Instant value) {
            s.i(name, "name");
            s.i(value, "value");
            add(name, new Date(value.toEpochMilli()));
            return this;
        }
    }

    /* compiled from: Headers.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Companion {
        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void checkName(String str) {
            if (str.length() > 0) {
                int length = str.length();
                for (int i10 = 0; i10 < length; i10++) {
                    char charAt = str.charAt(i10);
                    if (!('!' <= charAt && '~' >= charAt)) {
                        throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i10), str).toString());
                    }
                }
                return;
            }
            throw new IllegalArgumentException("name is empty".toString());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void checkValue(String str, String str2) {
            int length = str.length();
            for (int i10 = 0; i10 < length; i10++) {
                char charAt = str.charAt(i10);
                if (!(charAt == '\t' || (' ' <= charAt && '~' >= charAt))) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(Util.format("Unexpected char %#04x at %d in %s value", Integer.valueOf(charAt), Integer.valueOf(i10), str2));
                    sb2.append(Util.isSensitiveHeader(str2) ? "" : ": " + str);
                    throw new IllegalArgumentException(sb2.toString().toString());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String get(String[] strArr, String str) {
            h h10 = n.h(n.g(strArr.length - 2, 0), 2);
            int b4 = h10.b();
            int c4 = h10.c();
            int f10 = h10.f();
            if (f10 >= 0) {
                if (b4 > c4) {
                    return null;
                }
            } else if (b4 < c4) {
                return null;
            }
            while (!p.r(str, strArr[b4], true)) {
                if (b4 == c4) {
                    return null;
                }
                b4 += f10;
            }
            return strArr[b4 + 1];
        }

        @NotNull
        /* renamed from: -deprecated_of, reason: not valid java name */
        public final Headers m3643deprecated_of(@NotNull String... namesAndValues) {
            s.i(namesAndValues, "namesAndValues");
            return of((String[]) Arrays.copyOf(namesAndValues, namesAndValues.length));
        }

        @NotNull
        public final Headers of(@NotNull String... namesAndValues) {
            s.i(namesAndValues, "namesAndValues");
            if (namesAndValues.length % 2 == 0) {
                Object clone = namesAndValues.clone();
                Objects.requireNonNull(clone, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                String[] strArr = (String[]) clone;
                int length = strArr.length;
                for (int i10 = 0; i10 < length; i10++) {
                    if (strArr[i10] != null) {
                        String str = strArr[i10];
                        Objects.requireNonNull(str, "null cannot be cast to non-null type kotlin.CharSequence");
                        strArr[i10] = StringsKt__StringsKt.P0(str).toString();
                    } else {
                        throw new IllegalArgumentException("Headers cannot be null".toString());
                    }
                }
                h h10 = n.h(m.y(strArr), 2);
                int b4 = h10.b();
                int c4 = h10.c();
                int f10 = h10.f();
                if (f10 < 0 ? b4 >= c4 : b4 <= c4) {
                    while (true) {
                        String str2 = strArr[b4];
                        String str3 = strArr[b4 + 1];
                        checkName(str2);
                        checkValue(str3, str2);
                        if (b4 == c4) {
                            break;
                        }
                        b4 += f10;
                    }
                }
                return new Headers(strArr, null);
            }
            throw new IllegalArgumentException("Expected alternating header names and values".toString());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        /* renamed from: -deprecated_of, reason: not valid java name */
        public final Headers m3642deprecated_of(@NotNull Map<String, String> headers) {
            s.i(headers, "headers");
            return of(headers);
        }

        @NotNull
        public final Headers of(@NotNull Map<String, String> toHeaders) {
            s.i(toHeaders, "$this$toHeaders");
            String[] strArr = new String[toHeaders.size() * 2];
            int i10 = 0;
            for (Map.Entry<String, String> entry : toHeaders.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                Objects.requireNonNull(key, "null cannot be cast to non-null type kotlin.CharSequence");
                String obj = StringsKt__StringsKt.P0(key).toString();
                Objects.requireNonNull(value, "null cannot be cast to non-null type kotlin.CharSequence");
                String obj2 = StringsKt__StringsKt.P0(value).toString();
                checkName(obj);
                checkValue(obj2, obj);
                strArr[i10] = obj;
                strArr[i10 + 1] = obj2;
                i10 += 2;
            }
            return new Headers(strArr, null);
        }
    }

    private Headers(String[] strArr) {
        this.namesAndValues = strArr;
    }

    @NotNull
    public static final Headers of(@NotNull Map<String, String> map) {
        return Companion.of(map);
    }

    @NotNull
    public static final Headers of(@NotNull String... strArr) {
        return Companion.of(strArr);
    }

    /* renamed from: -deprecated_size, reason: not valid java name */
    public final int m3641deprecated_size() {
        return size();
    }

    public final long byteCount() {
        String[] strArr = this.namesAndValues;
        long length = strArr.length * 2;
        for (int i10 = 0; i10 < strArr.length; i10++) {
            length += this.namesAndValues[i10].length();
        }
        return length;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof Headers) && Arrays.equals(this.namesAndValues, ((Headers) obj).namesAndValues);
    }

    @Nullable
    public final String get(@NotNull String name) {
        s.i(name, "name");
        return Companion.get(this.namesAndValues, name);
    }

    @Nullable
    public final Date getDate(@NotNull String name) {
        s.i(name, "name");
        String str = get(name);
        if (str != null) {
            return DatesKt.toHttpDateOrNull(str);
        }
        return null;
    }

    @Nullable
    public final Instant getInstant(@NotNull String name) {
        s.i(name, "name");
        Date date = getDate(name);
        if (date != null) {
            return date.toInstant();
        }
        return null;
    }

    public int hashCode() {
        return Arrays.hashCode(this.namesAndValues);
    }

    @Override // java.lang.Iterable
    @NotNull
    /* renamed from: iterator */
    public Iterator<Pair<? extends String, ? extends String>> iterator2() {
        int size = size();
        Pair[] pairArr = new Pair[size];
        for (int i10 = 0; i10 < size; i10++) {
            pairArr[i10] = f.a(name(i10), value(i10));
        }
        return kotlin.jvm.internal.h.a(pairArr);
    }

    @NotNull
    public final String name(int i10) {
        return this.namesAndValues[i10 * 2];
    }

    @NotNull
    public final Set<String> names() {
        TreeSet treeSet = new TreeSet(p.s(y.f51038a));
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            treeSet.add(name(i10));
        }
        Set<String> unmodifiableSet = Collections.unmodifiableSet(treeSet);
        s.h(unmodifiableSet, "Collections.unmodifiableSet(result)");
        return unmodifiableSet;
    }

    @NotNull
    public final Builder newBuilder() {
        Builder builder = new Builder();
        x.y(builder.getNamesAndValues$okhttp(), this.namesAndValues);
        return builder;
    }

    public final int size() {
        return this.namesAndValues.length / 2;
    }

    @NotNull
    public final Map<String, List<String>> toMultimap() {
        TreeMap treeMap = new TreeMap(p.s(y.f51038a));
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            String name = name(i10);
            Locale locale = Locale.US;
            s.h(locale, "Locale.US");
            Objects.requireNonNull(name, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = name.toLowerCase(locale);
            s.h(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            List list = (List) treeMap.get(lowerCase);
            if (list == null) {
                list = new ArrayList(2);
                treeMap.put(lowerCase, list);
            }
            list.add(value(i10));
        }
        return treeMap;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            String name = name(i10);
            String value = value(i10);
            sb2.append(name);
            sb2.append(": ");
            if (Util.isSensitiveHeader(name)) {
                value = "██";
            }
            sb2.append(value);
            sb2.append("\n");
        }
        String sb3 = sb2.toString();
        s.h(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }

    @NotNull
    public final String value(int i10) {
        return this.namesAndValues[(i10 * 2) + 1];
    }

    @NotNull
    public final List<String> values(@NotNull String name) {
        s.i(name, "name");
        int size = size();
        ArrayList arrayList = null;
        for (int i10 = 0; i10 < size; i10++) {
            if (p.r(name, name(i10), true)) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(value(i10));
            }
        }
        if (arrayList != null) {
            List<String> unmodifiableList = Collections.unmodifiableList(arrayList);
            s.h(unmodifiableList, "Collections.unmodifiableList(result)");
            return unmodifiableList;
        }
        return kotlin.collections.s.j();
    }

    public /* synthetic */ Headers(String[] strArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(strArr);
    }
}
