package io.grpc;

import com.google.common.base.l;
import com.google.common.base.o;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1764")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class Attributes {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final Attributes EMPTY;
    private static final IdentityHashMap<Key<?>, Object> EMPTY_MAP;
    private final IdentityHashMap<Key<?>, Object> data;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Builder {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        private Attributes base;
        private IdentityHashMap<Key<?>, Object> newdata;

        private IdentityHashMap<Key<?>, Object> data(int i10) {
            if (this.newdata == null) {
                this.newdata = new IdentityHashMap<>(i10);
            }
            return this.newdata;
        }

        public Attributes build() {
            if (this.newdata != null) {
                for (Map.Entry entry : this.base.data.entrySet()) {
                    if (!this.newdata.containsKey(entry.getKey())) {
                        this.newdata.put((Key) entry.getKey(), entry.getValue());
                    }
                }
                this.base = new Attributes(this.newdata);
                this.newdata = null;
            }
            return this.base;
        }

        @ExperimentalApi("https://github.com/grpc/grpc-java/issues/5777")
        public <T> Builder discard(Key<T> key) {
            if (this.base.data.containsKey(key)) {
                IdentityHashMap identityHashMap = new IdentityHashMap(this.base.data);
                identityHashMap.remove(key);
                this.base = new Attributes(identityHashMap);
            }
            IdentityHashMap<Key<?>, Object> identityHashMap2 = this.newdata;
            if (identityHashMap2 != null) {
                identityHashMap2.remove(key);
            }
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public <T> Builder set(Key<T> key, T t2) {
            data(1).put(key, t2);
            return this;
        }

        public Builder setAll(Attributes attributes) {
            data(attributes.data.size()).putAll(attributes.data);
            return this;
        }

        private Builder(Attributes attributes) {
            this.base = attributes;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Key<T> {
        private final String debugString;

        private Key(String str) {
            this.debugString = str;
        }

        public static <T> Key<T> create(String str) {
            return new Key<>(str);
        }

        @Deprecated
        public static <T> Key<T> of(String str) {
            return new Key<>(str);
        }

        public String toString() {
            return this.debugString;
        }
    }

    static {
        IdentityHashMap<Key<?>, Object> identityHashMap = new IdentityHashMap<>();
        EMPTY_MAP = identityHashMap;
        EMPTY = new Attributes(identityHashMap);
    }

    @Deprecated
    public static Builder newBuilder(Attributes attributes) {
        o.s(attributes, "base");
        return new Builder();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Attributes.class != obj.getClass()) {
            return false;
        }
        Attributes attributes = (Attributes) obj;
        if (this.data.size() != attributes.data.size()) {
            return false;
        }
        for (Map.Entry<Key<?>, Object> entry : this.data.entrySet()) {
            if (!attributes.data.containsKey(entry.getKey()) || !l.a(entry.getValue(), attributes.data.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    public <T> T get(Key<T> key) {
        return (T) this.data.get(key);
    }

    public int hashCode() {
        int i10 = 0;
        for (Map.Entry<Key<?>, Object> entry : this.data.entrySet()) {
            i10 += l.b(entry.getKey(), entry.getValue());
        }
        return i10;
    }

    @Deprecated
    public Set<Key<?>> keys() {
        return Collections.unmodifiableSet(this.data.keySet());
    }

    public Set<Key<?>> keysForTest() {
        return Collections.unmodifiableSet(this.data.keySet());
    }

    public Builder toBuilder() {
        return new Builder();
    }

    public String toString() {
        return this.data.toString();
    }

    private Attributes(IdentityHashMap<Key<?>, Object> identityHashMap) {
        this.data = identityHashMap;
    }

    public static Builder newBuilder() {
        return new Builder();
    }
}
