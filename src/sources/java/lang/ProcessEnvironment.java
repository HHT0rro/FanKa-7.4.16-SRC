package java.lang;

import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class ProcessEnvironment {
    static final int MIN_NAME_LENGTH = 0;

    private static native byte[][] environ();

    private static Map<String, String> buildEnvironment() {
        byte[][] environ = environ();
        Map<Variable, Value> env = new HashMap<>((environ.length / 2) + 3);
        for (int i10 = environ.length - 1; i10 > 0; i10 -= 2) {
            env.put(Variable.valueOf(environ[i10 - 1]), Value.valueOf(environ[i10]));
        }
        return new StringEnvironment(env);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map<String, String> getenv() {
        return Collections.unmodifiableMap(buildEnvironment());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map<String, String> environment() {
        return buildEnvironment();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map<String, String> emptyEnvironment(int capacity) {
        return new StringEnvironment(new HashMap(capacity));
    }

    private ProcessEnvironment() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void validateVariable(String name) {
        if (name.indexOf(61) != -1 || name.indexOf(0) != -1) {
            throw new IllegalArgumentException("Invalid environment variable name: \"" + name + "\"");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void validateValue(String value) {
        if (value.indexOf(0) != -1) {
            throw new IllegalArgumentException("Invalid environment variable value: \"" + value + "\"");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static abstract class ExternalData {
        protected final byte[] bytes;
        protected final String str;

        protected ExternalData(String str, byte[] bytes) {
            this.str = str;
            this.bytes = bytes;
        }

        public byte[] getBytes() {
            return this.bytes;
        }

        public String toString() {
            return this.str;
        }

        public boolean equals(Object o10) {
            return (o10 instanceof ExternalData) && ProcessEnvironment.arrayEquals(getBytes(), ((ExternalData) o10).getBytes());
        }

        public int hashCode() {
            return ProcessEnvironment.arrayHash(getBytes());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class Variable extends ExternalData implements Comparable<Variable> {
        protected Variable(String str, byte[] bytes) {
            super(str, bytes);
        }

        public static Variable valueOfQueryOnly(Object str) {
            return valueOfQueryOnly((String) str);
        }

        public static Variable valueOfQueryOnly(String str) {
            return new Variable(str, str.getBytes());
        }

        public static Variable valueOf(String str) {
            ProcessEnvironment.validateVariable(str);
            return valueOfQueryOnly(str);
        }

        public static Variable valueOf(byte[] bytes) {
            return new Variable(new String(bytes), bytes);
        }

        @Override // java.lang.Comparable
        public int compareTo(Variable variable) {
            return ProcessEnvironment.arrayCompare(getBytes(), variable.getBytes());
        }

        @Override // java.lang.ProcessEnvironment.ExternalData
        public boolean equals(Object o10) {
            return (o10 instanceof Variable) && super.equals(o10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class Value extends ExternalData implements Comparable<Value> {
        protected Value(String str, byte[] bytes) {
            super(str, bytes);
        }

        public static Value valueOfQueryOnly(Object str) {
            return valueOfQueryOnly((String) str);
        }

        public static Value valueOfQueryOnly(String str) {
            return new Value(str, str.getBytes());
        }

        public static Value valueOf(String str) {
            ProcessEnvironment.validateValue(str);
            return valueOfQueryOnly(str);
        }

        public static Value valueOf(byte[] bytes) {
            return new Value(new String(bytes), bytes);
        }

        @Override // java.lang.Comparable
        public int compareTo(Value value) {
            return ProcessEnvironment.arrayCompare(getBytes(), value.getBytes());
        }

        @Override // java.lang.ProcessEnvironment.ExternalData
        public boolean equals(Object o10) {
            return (o10 instanceof Value) && super.equals(o10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class StringEnvironment extends AbstractMap<String, String> {

        /* renamed from: m, reason: collision with root package name */
        private Map<Variable, Value> f50360m;

        private static String toString(Value v2) {
            if (v2 == null) {
                return null;
            }
            return v2.toString();
        }

        public StringEnvironment(Map<Variable, Value> m10) {
            this.f50360m = m10;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f50360m.size();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return this.f50360m.isEmpty();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            this.f50360m.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object key) {
            return this.f50360m.containsKey(Variable.valueOfQueryOnly(key));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsValue(Object value) {
            return this.f50360m.containsValue(Value.valueOfQueryOnly(value));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public String get(Object key) {
            return toString(this.f50360m.get(Variable.valueOfQueryOnly(key)));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public String put(String key, String value) {
            return toString(this.f50360m.put(Variable.valueOf(key), Value.valueOf(value)));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public String remove(Object key) {
            return toString(this.f50360m.remove(Variable.valueOfQueryOnly(key)));
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: keySet */
        public Set<String> h() {
            return new StringKeySet(this.f50360m.h());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<String, String>> entrySet() {
            return new StringEntrySet(this.f50360m.entrySet());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<String> values() {
            return new StringValues(this.f50360m.values());
        }

        public byte[] toEnvironmentBlock(int[] envc) {
            int count = this.f50360m.size() * 2;
            for (Map.Entry<Variable, Value> entry : this.f50360m.entrySet()) {
                count = count + entry.getKey().getBytes().length + entry.getValue().getBytes().length;
            }
            byte[] block = new byte[count];
            int i10 = 0;
            for (Map.Entry<Variable, Value> entry2 : this.f50360m.entrySet()) {
                byte[] key = entry2.getKey().getBytes();
                byte[] value = entry2.getValue().getBytes();
                System.arraycopy((Object) key, 0, (Object) block, i10, key.length);
                int i11 = i10 + key.length;
                int i12 = i11 + 1;
                block[i11] = 61;
                System.arraycopy((Object) value, 0, (Object) block, i12, value.length);
                i10 = value.length + 1 + i12;
            }
            envc[0] = this.f50360m.size();
            return block;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] toEnvironmentBlock(Map<String, String> map, int[] envc) {
        if (map == null) {
            return null;
        }
        return ((StringEnvironment) map).toEnvironmentBlock(envc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class StringEntry implements Map.Entry<String, String> {

        /* renamed from: e, reason: collision with root package name */
        private final Map.Entry<Variable, Value> f50357e;

        public StringEntry(Map.Entry<Variable, Value> e2) {
            this.f50357e = e2;
        }

        @Override // java.util.Map.Entry
        public String getKey() {
            return this.f50357e.getKey().toString();
        }

        @Override // java.util.Map.Entry
        public String getValue() {
            return this.f50357e.getValue().toString();
        }

        @Override // java.util.Map.Entry
        public String setValue(String newValue) {
            return this.f50357e.setValue(Value.valueOf(newValue)).toString();
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object o10) {
            return (o10 instanceof StringEntry) && this.f50357e.equals(((StringEntry) o10).f50357e);
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f50357e.hashCode();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static class StringEntrySet extends AbstractSet<Map.Entry<String, String>> {

        /* renamed from: s, reason: collision with root package name */
        private final Set<Map.Entry<Variable, Value>> f50358s;

        public StringEntrySet(Set<Map.Entry<Variable, Value>> s2) {
            this.f50358s = s2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f50358s.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.f50358s.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.f50358s.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<Map.Entry<String, String>> iterator2() {
            return new Iterator<Map.Entry<String, String>>() { // from class: java.lang.ProcessEnvironment.StringEntrySet.1

                /* renamed from: i, reason: collision with root package name */
                Iterator<Map.Entry<Variable, Value>> f50359i;

                {
                    this.f50359i = StringEntrySet.this.f50358s.iterator2();
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.f50359i.hasNext();
                }

                @Override // java.util.Iterator
                public Map.Entry<String, String> next() {
                    return new StringEntry(this.f50359i.next());
                }

                @Override // java.util.Iterator
                public void remove() {
                    this.f50359i.remove();
                }
            };
        }

        private static Map.Entry<Variable, Value> vvEntry(final Object o10) {
            if (o10 instanceof StringEntry) {
                return ((StringEntry) o10).f50357e;
            }
            return new Map.Entry<Variable, Value>() { // from class: java.lang.ProcessEnvironment.StringEntrySet.2
                @Override // java.util.Map.Entry
                public Variable getKey() {
                    return Variable.valueOfQueryOnly(((Map.Entry) Object.this).getKey());
                }

                @Override // java.util.Map.Entry
                public Value getValue() {
                    return Value.valueOfQueryOnly(((Map.Entry) Object.this).getValue());
                }

                @Override // java.util.Map.Entry
                public Value setValue(Value value) {
                    throw new UnsupportedOperationException();
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o10) {
            return this.f50358s.contains(vvEntry(o10));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o10) {
            return this.f50358s.remove(vvEntry(o10));
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public boolean equals(Object o10) {
            return (o10 instanceof StringEntrySet) && this.f50358s.equals(((StringEntrySet) o10).f50358s);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return this.f50358s.hashCode();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static class StringValues extends AbstractCollection<String> {

        /* renamed from: c, reason: collision with root package name */
        private final Collection<Value> f50363c;

        public StringValues(Collection<Value> c4) {
            this.f50363c = c4;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f50363c.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.f50363c.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.f50363c.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<String> iterator2() {
            return new Iterator<String>() { // from class: java.lang.ProcessEnvironment.StringValues.1

                /* renamed from: i, reason: collision with root package name */
                Iterator<Value> f50364i;

                {
                    this.f50364i = StringValues.this.f50363c.iterator2();
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.f50364i.hasNext();
                }

                @Override // java.util.Iterator
                public String next() {
                    return this.f50364i.next().toString();
                }

                @Override // java.util.Iterator
                public void remove() {
                    this.f50364i.remove();
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o10) {
            return this.f50363c.contains(Value.valueOfQueryOnly(o10));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o10) {
            return this.f50363c.remove(Value.valueOfQueryOnly(o10));
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object o10) {
            return (o10 instanceof StringValues) && this.f50363c.equals(((StringValues) o10).f50363c);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return this.f50363c.hashCode();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static class StringKeySet extends AbstractSet<String> {

        /* renamed from: s, reason: collision with root package name */
        private final Set<Variable> f50361s;

        public StringKeySet(Set<Variable> s2) {
            this.f50361s = s2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f50361s.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.f50361s.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.f50361s.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<String> iterator2() {
            return new Iterator<String>() { // from class: java.lang.ProcessEnvironment.StringKeySet.1

                /* renamed from: i, reason: collision with root package name */
                Iterator<Variable> f50362i;

                {
                    this.f50362i = StringKeySet.this.f50361s.iterator2();
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.f50362i.hasNext();
                }

                @Override // java.util.Iterator
                public String next() {
                    return this.f50362i.next().toString();
                }

                @Override // java.util.Iterator
                public void remove() {
                    this.f50362i.remove();
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o10) {
            return this.f50361s.contains(Variable.valueOfQueryOnly(o10));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o10) {
            return this.f50361s.remove(Variable.valueOfQueryOnly(o10));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int arrayCompare(byte[] x10, byte[] y10) {
        int min = x10.length < y10.length ? x10.length : y10.length;
        for (int i10 = 0; i10 < min; i10++) {
            if (x10[i10] != y10[i10]) {
                return x10[i10] - y10[i10];
            }
        }
        int i11 = x10.length;
        return i11 - y10.length;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean arrayEquals(byte[] x10, byte[] y10) {
        if (x10.length != y10.length) {
            return false;
        }
        for (int i10 = 0; i10 < x10.length; i10++) {
            if (x10[i10] != y10[i10]) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int arrayHash(byte[] x10) {
        int hash = 0;
        for (byte b4 : x10) {
            hash = (hash * 31) + b4;
        }
        return hash;
    }
}
