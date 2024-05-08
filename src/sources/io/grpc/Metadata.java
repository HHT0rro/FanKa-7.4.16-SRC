package io.grpc;

import com.google.common.base.c;
import com.google.common.base.o;
import com.google.common.io.BaseEncoding;
import com.google.common.io.a;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class Metadata {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String BINARY_HEADER_SUFFIX = "-bin";
    private Object[] namesAndValues;
    private int size;
    private static final Logger logger = Logger.getLogger(Metadata.class.getName());
    public static final BinaryMarshaller<byte[]> BINARY_BYTE_MARSHALLER = new BinaryMarshaller<byte[]>() { // from class: io.grpc.Metadata.1
        @Override // io.grpc.Metadata.BinaryMarshaller
        public byte[] parseBytes(byte[] bArr) {
            return bArr;
        }

        @Override // io.grpc.Metadata.BinaryMarshaller
        public byte[] toBytes(byte[] bArr) {
            return bArr;
        }
    };
    public static final AsciiMarshaller<String> ASCII_STRING_MARSHALLER = new AsciiMarshaller<String>() { // from class: io.grpc.Metadata.2
        @Override // io.grpc.Metadata.AsciiMarshaller
        public String parseAsciiString(String str) {
            return str;
        }

        @Override // io.grpc.Metadata.AsciiMarshaller
        public String toAsciiString(String str) {
            return str;
        }
    };
    public static final BaseEncoding BASE64_ENCODING_OMIT_PADDING = BaseEncoding.a().k();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class AsciiKey<T> extends Key<T> {
        private final AsciiMarshaller<T> marshaller;

        @Override // io.grpc.Metadata.Key
        public T parseBytes(byte[] bArr) {
            return this.marshaller.parseAsciiString(new String(bArr, c.f25959a));
        }

        @Override // io.grpc.Metadata.Key
        public byte[] toBytes(T t2) {
            return ((String) o.s(this.marshaller.toAsciiString(t2), "null marshaller.toAsciiString()")).getBytes(c.f25959a);
        }

        private AsciiKey(String str, boolean z10, AsciiMarshaller<T> asciiMarshaller) {
            super(str, z10, asciiMarshaller);
            o.n(!str.endsWith(Metadata.BINARY_HEADER_SUFFIX), "ASCII header is named %s.  Only binary headers may end with %s", str, Metadata.BINARY_HEADER_SUFFIX);
            this.marshaller = (AsciiMarshaller) o.s(asciiMarshaller, "marshaller");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface AsciiMarshaller<T> {
        T parseAsciiString(String str);

        String toAsciiString(T t2);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class BinaryKey<T> extends Key<T> {
        private final BinaryMarshaller<T> marshaller;

        @Override // io.grpc.Metadata.Key
        public T parseBytes(byte[] bArr) {
            return this.marshaller.parseBytes(bArr);
        }

        @Override // io.grpc.Metadata.Key
        public byte[] toBytes(T t2) {
            return (byte[]) o.s(this.marshaller.toBytes(t2), "null marshaller.toBytes()");
        }

        private BinaryKey(String str, BinaryMarshaller<T> binaryMarshaller) {
            super(str, false, binaryMarshaller);
            o.n(str.endsWith(Metadata.BINARY_HEADER_SUFFIX), "Binary header is named %s. It must end with %s", str, Metadata.BINARY_HEADER_SUFFIX);
            o.e(str.length() > 4, "empty key name");
            this.marshaller = (BinaryMarshaller) o.s(binaryMarshaller, "marshaller is null");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface BinaryMarshaller<T> {
        T parseBytes(byte[] bArr);

        byte[] toBytes(T t2);
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/6575")
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface BinaryStreamMarshaller<T> {
        T parseStream(InputStream inputStream);

        InputStream toStream(T t2);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public final class IterableAt<T> implements Iterable<T> {
        private final Key<T> key;
        private int startIdx;

        @Override // java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<T> iterator2() {
            return new Iterator<T>() { // from class: io.grpc.Metadata.IterableAt.1
                private boolean hasNext = true;
                private int idx;

                {
                    this.idx = IterableAt.this.startIdx;
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    if (this.hasNext) {
                        return true;
                    }
                    while (this.idx < Metadata.this.size) {
                        IterableAt iterableAt = IterableAt.this;
                        if (Metadata.this.bytesEqual(iterableAt.key.asciiName(), Metadata.this.name(this.idx))) {
                            this.hasNext = true;
                            return true;
                        }
                        this.idx++;
                    }
                    return false;
                }

                @Override // java.util.Iterator
                public T next() {
                    if (hasNext()) {
                        this.hasNext = false;
                        IterableAt iterableAt = IterableAt.this;
                        Metadata metadata = Metadata.this;
                        int i10 = this.idx;
                        this.idx = i10 + 1;
                        return (T) metadata.valueAsT(i10, iterableAt.key);
                    }
                    throw new NoSuchElementException();
                }

                @Override // java.util.Iterator
                public void remove() {
                    throw new UnsupportedOperationException();
                }
            };
        }

        private IterableAt(Key<T> key, int i10) {
            this.key = key;
            this.startIdx = i10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static abstract class Key<T> {
        private static final BitSet VALID_T_CHARS = generateValidTChars();
        private final Object marshaller;
        private final String name;
        private final byte[] nameBytes;
        private final String originalName;

        private static BitSet generateValidTChars() {
            BitSet bitSet = new BitSet(127);
            bitSet.set(45);
            bitSet.set(95);
            bitSet.set(46);
            for (char c4 = '0'; c4 <= '9'; c4 = (char) (c4 + 1)) {
                bitSet.set(c4);
            }
            for (char c10 = 'a'; c10 <= 'z'; c10 = (char) (c10 + 1)) {
                bitSet.set(c10);
            }
            return bitSet;
        }

        public static <T> Key<T> of(String str, BinaryMarshaller<T> binaryMarshaller) {
            return new BinaryKey(str, binaryMarshaller);
        }

        private static String validateName(String str, boolean z10) {
            o.s(str, "name");
            o.e(!str.isEmpty(), "token must have at least 1 tchar");
            if (str.equals("connection")) {
                Metadata.logger.log(Level.WARNING, "Metadata key is 'Connection', which should not be used. That is used by HTTP/1 for connection-specific headers which are not to be forwarded. There is probably an HTTP/1 conversion bug. Simply removing the Connection header is not enough; you should remove all headers it references as well. See RFC 7230 section 6.1", (Throwable) new RuntimeException("exception to show backtrace"));
            }
            for (int i10 = 0; i10 < str.length(); i10++) {
                char charAt = str.charAt(i10);
                if (!z10 || charAt != ':' || i10 != 0) {
                    o.g(VALID_T_CHARS.get(charAt), "Invalid character '%s' in key name '%s'", charAt, str);
                }
            }
            return str;
        }

        public byte[] asciiName() {
            return this.nameBytes;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.name.equals(((Key) obj).name);
        }

        public final <M> M getMarshaller(Class<M> cls) {
            if (cls.isInstance(this.marshaller)) {
                return cls.cast(this.marshaller);
            }
            return null;
        }

        public final int hashCode() {
            return this.name.hashCode();
        }

        public final String name() {
            return this.name;
        }

        public final String originalName() {
            return this.originalName;
        }

        public abstract T parseBytes(byte[] bArr);

        public boolean serializesToStreams() {
            return false;
        }

        public abstract byte[] toBytes(T t2);

        public String toString() {
            return "Key{name='" + this.name + "'}";
        }

        private Key(String str, boolean z10, Object obj) {
            String str2 = (String) o.s(str, "name");
            this.originalName = str2;
            String validateName = validateName(str2.toLowerCase(Locale.ROOT), z10);
            this.name = validateName;
            this.nameBytes = validateName.getBytes(c.f25959a);
            this.marshaller = obj;
        }

        @ExperimentalApi("https://github.com/grpc/grpc-java/issues/6575")
        public static <T> Key<T> of(String str, BinaryStreamMarshaller<T> binaryStreamMarshaller) {
            return new LazyStreamBinaryKey(str, binaryStreamMarshaller);
        }

        public static <T> Key<T> of(String str, AsciiMarshaller<T> asciiMarshaller) {
            return of(str, false, (AsciiMarshaller) asciiMarshaller);
        }

        public static <T> Key<T> of(String str, boolean z10, AsciiMarshaller<T> asciiMarshaller) {
            return new AsciiKey(str, z10, asciiMarshaller);
        }

        public static <T> Key<T> of(String str, boolean z10, TrustedAsciiMarshaller<T> trustedAsciiMarshaller) {
            return new TrustedAsciiKey(str, z10, trustedAsciiMarshaller);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class LazyStreamBinaryKey<T> extends Key<T> {
        private final BinaryStreamMarshaller<T> marshaller;

        @Override // io.grpc.Metadata.Key
        public T parseBytes(byte[] bArr) {
            return this.marshaller.parseStream(new ByteArrayInputStream(bArr));
        }

        @Override // io.grpc.Metadata.Key
        public boolean serializesToStreams() {
            return true;
        }

        @Override // io.grpc.Metadata.Key
        public byte[] toBytes(T t2) {
            return Metadata.streamToBytes((InputStream) o.s(this.marshaller.toStream(t2), "null marshaller.toStream()"));
        }

        private LazyStreamBinaryKey(String str, BinaryStreamMarshaller<T> binaryStreamMarshaller) {
            super(str, false, binaryStreamMarshaller);
            o.n(str.endsWith(Metadata.BINARY_HEADER_SUFFIX), "Binary header is named %s. It must end with %s", str, Metadata.BINARY_HEADER_SUFFIX);
            o.e(str.length() > 4, "empty key name");
            this.marshaller = (BinaryStreamMarshaller) o.s(binaryStreamMarshaller, "marshaller is null");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class LazyValue<T> {
        private final BinaryStreamMarshaller<T> marshaller;
        private volatile byte[] serialized;
        private final T value;

        public LazyValue(BinaryStreamMarshaller<T> binaryStreamMarshaller, T t2) {
            this.marshaller = binaryStreamMarshaller;
            this.value = t2;
        }

        public static <T> LazyValue<T> create(Key<T> key, T t2) {
            return new LazyValue<>((BinaryStreamMarshaller) o.r(getBinaryStreamMarshaller(key)), t2);
        }

        private static <T> BinaryStreamMarshaller<T> getBinaryStreamMarshaller(Key<T> key) {
            return (BinaryStreamMarshaller) key.getMarshaller(BinaryStreamMarshaller.class);
        }

        public byte[] toBytes() {
            if (this.serialized == null) {
                synchronized (this) {
                    if (this.serialized == null) {
                        this.serialized = Metadata.streamToBytes(toStream());
                    }
                }
            }
            return this.serialized;
        }

        public <T2> T2 toObject(Key<T2> key) {
            BinaryStreamMarshaller binaryStreamMarshaller;
            if (key.serializesToStreams() && (binaryStreamMarshaller = getBinaryStreamMarshaller(key)) != null) {
                return (T2) binaryStreamMarshaller.parseStream(toStream());
            }
            return key.parseBytes(toBytes());
        }

        public InputStream toStream() {
            return (InputStream) o.s(this.marshaller.toStream(this.value), "null marshaller.toStream()");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class TrustedAsciiKey<T> extends Key<T> {
        private final TrustedAsciiMarshaller<T> marshaller;

        @Override // io.grpc.Metadata.Key
        public T parseBytes(byte[] bArr) {
            return this.marshaller.parseAsciiString(bArr);
        }

        @Override // io.grpc.Metadata.Key
        public byte[] toBytes(T t2) {
            return (byte[]) o.s(this.marshaller.toAsciiString(t2), "null marshaller.toAsciiString()");
        }

        private TrustedAsciiKey(String str, boolean z10, TrustedAsciiMarshaller<T> trustedAsciiMarshaller) {
            super(str, z10, trustedAsciiMarshaller);
            o.n(!str.endsWith(Metadata.BINARY_HEADER_SUFFIX), "ASCII header is named %s.  Only binary headers may end with %s", str, Metadata.BINARY_HEADER_SUFFIX);
            this.marshaller = (TrustedAsciiMarshaller) o.s(trustedAsciiMarshaller, "marshaller");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface TrustedAsciiMarshaller<T> {
        T parseAsciiString(byte[] bArr);

        byte[] toAsciiString(T t2);
    }

    public Metadata(byte[]... bArr) {
        this(bArr.length / 2, bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bytesEqual(byte[] bArr, byte[] bArr2) {
        return Arrays.equals(bArr, bArr2);
    }

    private int cap() {
        Object[] objArr = this.namesAndValues;
        if (objArr != null) {
            return objArr.length;
        }
        return 0;
    }

    private void expand(int i10) {
        Object[] objArr = new Object[i10];
        if (!isEmpty()) {
            System.arraycopy(this.namesAndValues, 0, objArr, 0, len());
        }
        this.namesAndValues = objArr;
    }

    private boolean isEmpty() {
        return this.size == 0;
    }

    private int len() {
        return this.size * 2;
    }

    private void maybeExpand() {
        if (len() == 0 || len() == cap()) {
            expand(Math.max(len() * 2, 8));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] name(int i10) {
        return (byte[]) this.namesAndValues[i10 * 2];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] streamToBytes(InputStream inputStream) {
        try {
            return a.d(inputStream);
        } catch (IOException e2) {
            throw new RuntimeException("failure reading serialized stream", e2);
        }
    }

    private Object value(int i10) {
        return this.namesAndValues[(i10 * 2) + 1];
    }

    private byte[] valueAsBytes(int i10) {
        Object value = value(i10);
        if (value instanceof byte[]) {
            return (byte[]) value;
        }
        return ((LazyValue) value).toBytes();
    }

    private Object valueAsBytesOrStream(int i10) {
        Object value = value(i10);
        return value instanceof byte[] ? value : ((LazyValue) value).toStream();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> T valueAsT(int i10, Key<T> key) {
        Object value = value(i10);
        if (value instanceof byte[]) {
            return key.parseBytes((byte[]) value);
        }
        return (T) ((LazyValue) value).toObject(key);
    }

    public boolean containsKey(Key<?> key) {
        for (int i10 = 0; i10 < this.size; i10++) {
            if (bytesEqual(key.asciiName(), name(i10))) {
                return true;
            }
        }
        return false;
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/4691")
    public <T> void discardAll(Key<T> key) {
        if (isEmpty()) {
            return;
        }
        int i10 = 0;
        for (int i11 = 0; i11 < this.size; i11++) {
            if (!bytesEqual(key.asciiName(), name(i11))) {
                name(i10, name(i11));
                value(i10, value(i11));
                i10++;
            }
        }
        Arrays.fill(this.namesAndValues, i10 * 2, len(), (Object) null);
        this.size = i10;
    }

    public <T> T get(Key<T> key) {
        for (int i10 = this.size - 1; i10 >= 0; i10--) {
            if (bytesEqual(key.asciiName(), name(i10))) {
                return (T) valueAsT(i10, key);
            }
        }
        return null;
    }

    public <T> Iterable<T> getAll(Key<T> key) {
        int i10 = 0;
        while (true) {
            if (i10 >= this.size) {
                return null;
            }
            if (bytesEqual(key.asciiName(), name(i10))) {
                return new IterableAt(key, i10);
            }
            i10++;
        }
    }

    public int headerCount() {
        return this.size;
    }

    public Set<String> keys() {
        if (isEmpty()) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet(this.size);
        for (int i10 = 0; i10 < this.size; i10++) {
            hashSet.add(new String(name(i10), 0));
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public void merge(Metadata metadata) {
        if (metadata.isEmpty()) {
            return;
        }
        int cap = cap() - len();
        if (isEmpty() || cap < metadata.len()) {
            expand(len() + metadata.len());
        }
        System.arraycopy(metadata.namesAndValues, 0, this.namesAndValues, len(), metadata.len());
        this.size += metadata.size;
    }

    public <T> void put(Key<T> key, T t2) {
        o.s(key, "key");
        o.s(t2, "value");
        maybeExpand();
        name(this.size, key.asciiName());
        if (key.serializesToStreams()) {
            value(this.size, LazyValue.create(key, t2));
        } else {
            value(this.size, key.toBytes(t2));
        }
        this.size++;
    }

    public <T> boolean remove(Key<T> key, T t2) {
        o.s(key, "key");
        o.s(t2, "value");
        for (int i10 = 0; i10 < this.size; i10++) {
            if (bytesEqual(key.asciiName(), name(i10)) && t2.equals(valueAsT(i10, key))) {
                int i11 = i10 * 2;
                int i12 = (i10 + 1) * 2;
                int len = len() - i12;
                Object[] objArr = this.namesAndValues;
                System.arraycopy(objArr, i12, objArr, i11, len);
                int i13 = this.size - 1;
                this.size = i13;
                name(i13, null);
                value(this.size, (byte[]) null);
                return true;
            }
        }
        return false;
    }

    public <T> Iterable<T> removeAll(Key<T> key) {
        if (isEmpty()) {
            return null;
        }
        ArrayList arrayList = null;
        int i10 = 0;
        for (int i11 = 0; i11 < this.size; i11++) {
            if (bytesEqual(key.asciiName(), name(i11))) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(valueAsT(i11, key));
            } else {
                name(i10, name(i11));
                value(i10, value(i11));
                i10++;
            }
        }
        Arrays.fill(this.namesAndValues, i10 * 2, len(), (Object) null);
        this.size = i10;
        return arrayList;
    }

    public byte[][] serialize() {
        byte[][] bArr = new byte[len()];
        Object[] objArr = this.namesAndValues;
        if (objArr instanceof byte[][]) {
            System.arraycopy(objArr, 0, bArr, 0, len());
        } else {
            for (int i10 = 0; i10 < this.size; i10++) {
                int i11 = i10 * 2;
                bArr[i11] = name(i10);
                bArr[i11 + 1] = valueAsBytes(i10);
            }
        }
        return bArr;
    }

    public Object[] serializePartial() {
        Object[] objArr = new Object[len()];
        for (int i10 = 0; i10 < this.size; i10++) {
            int i11 = i10 * 2;
            objArr[i11] = name(i10);
            objArr[i11 + 1] = valueAsBytesOrStream(i10);
        }
        return objArr;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("Metadata(");
        for (int i10 = 0; i10 < this.size; i10++) {
            if (i10 != 0) {
                sb2.append(',');
            }
            byte[] name = name(i10);
            Charset charset = c.f25959a;
            String str = new String(name, charset);
            sb2.append(str);
            sb2.append('=');
            if (str.endsWith(BINARY_HEADER_SUFFIX)) {
                sb2.append(BASE64_ENCODING_OMIT_PADDING.e(valueAsBytes(i10)));
            } else {
                sb2.append(new String(valueAsBytes(i10), charset));
            }
        }
        sb2.append(')');
        return sb2.toString();
    }

    public Metadata(int i10, byte[]... bArr) {
        this(i10, (Object[]) bArr);
    }

    private void name(int i10, byte[] bArr) {
        this.namesAndValues[i10 * 2] = bArr;
    }

    private void value(int i10, byte[] bArr) {
        this.namesAndValues[(i10 * 2) + 1] = bArr;
    }

    public Metadata(int i10, Object[] objArr) {
        this.size = i10;
        this.namesAndValues = objArr;
    }

    private void value(int i10, Object obj) {
        if (this.namesAndValues instanceof byte[][]) {
            expand(cap());
        }
        this.namesAndValues[(i10 * 2) + 1] = obj;
    }

    public Metadata() {
    }

    public void merge(Metadata metadata, Set<Key<?>> set) {
        o.s(metadata, "other");
        HashMap hashMap = new HashMap(set.size());
        for (Key<?> key : set) {
            hashMap.put(ByteBuffer.wrap(key.asciiName()), key);
        }
        for (int i10 = 0; i10 < metadata.size; i10++) {
            if (hashMap.containsKey(ByteBuffer.wrap(metadata.name(i10)))) {
                maybeExpand();
                name(this.size, metadata.name(i10));
                value(this.size, metadata.value(i10));
                this.size++;
            }
        }
    }
}
