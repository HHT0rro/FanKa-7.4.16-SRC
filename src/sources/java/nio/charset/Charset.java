package java.nio.charset;

import com.android.icu.charset.CharsetFactory;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.spi.CharsetProvider;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import jdk.internal.misc.VM;
import org.apache.commons.lang3.CharEncoding;
import sun.nio.cs.ThreadLocalCoders;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class Charset implements Comparable<Charset> {
    private static volatile Charset defaultCharset;
    private Set<String> aliasSet = null;
    private final String[] aliases;
    private final String name;
    private static final String[] zeroAliases = new String[0];
    private static volatile Map.Entry<String, Charset> cache1 = null;
    private static final HashMap<String, Charset> cache2 = new HashMap<>();
    private static ThreadLocal<ThreadLocal<?>> gate = new ThreadLocal<>();

    /* renamed from: -$$Nest$smproviders, reason: not valid java name */
    static /* bridge */ /* synthetic */ Iterator m3254$$Nest$smproviders() {
        return providers();
    }

    public abstract boolean contains(Charset charset);

    public abstract CharsetDecoder newDecoder();

    public abstract CharsetEncoder newEncoder();

    private static void checkName(String s2) {
        int n10 = s2.length();
        if (n10 == 0) {
            throw new IllegalCharsetNameException(s2);
        }
        for (int i10 = 0; i10 < n10; i10++) {
            char c4 = s2.charAt(i10);
            if ((c4 < 'A' || c4 > 'Z') && ((c4 < 'a' || c4 > 'z') && ((c4 < '0' || c4 > '9') && ((c4 != '-' || i10 == 0) && ((c4 != '+' || i10 == 0) && ((c4 != ':' || i10 == 0) && ((c4 != '_' || i10 == 0) && (c4 != '.' || i10 == 0)))))))) {
                throw new IllegalCharsetNameException(s2);
            }
        }
    }

    private static void cache(String charsetName, Charset cs) {
        HashMap<String, Charset> hashMap = cache2;
        synchronized (hashMap) {
            String canonicalName = cs.name();
            Charset canonicalCharset = hashMap.get(canonicalName);
            if (canonicalCharset != null) {
                cs = canonicalCharset;
            } else {
                hashMap.put(canonicalName, cs);
                for (String alias : cs.aliases()) {
                    cache2.put(alias, cs);
                }
            }
            cache2.put(charsetName, cs);
        }
        cache1 = new AbstractMap.SimpleImmutableEntry(charsetName, cs);
    }

    private static Iterator<CharsetProvider> providers() {
        return new Iterator<CharsetProvider>() { // from class: java.nio.charset.Charset.1

            /* renamed from: i, reason: collision with root package name */
            Iterator<CharsetProvider> f50391i;
            CharsetProvider next;
            ServiceLoader<CharsetProvider> sl;

            {
                ServiceLoader<CharsetProvider> load = ServiceLoader.load(CharsetProvider.class);
                this.sl = load;
                this.f50391i = load.iterator2();
                this.next = null;
            }

            private boolean getNext() {
                while (this.next == null) {
                    try {
                    } catch (ServiceConfigurationError sce) {
                        if (!(sce.getCause() instanceof SecurityException)) {
                            throw sce;
                        }
                    }
                    if (!this.f50391i.hasNext()) {
                        return false;
                    }
                    this.next = this.f50391i.next();
                }
                return true;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return getNext();
            }

            @Override // java.util.Iterator
            public CharsetProvider next() {
                if (!getNext()) {
                    throw new NoSuchElementException();
                }
                CharsetProvider n10 = this.next;
                this.next = null;
                return n10;
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    private static Charset lookupViaProviders(final String charsetName) {
        if (!VM.isBooted() || gate.get() != null) {
            return null;
        }
        try {
            ThreadLocal<?> threadLocal = gate;
            threadLocal.set(threadLocal);
            return (Charset) AccessController.doPrivileged(new PrivilegedAction<Charset>() { // from class: java.nio.charset.Charset.2
                @Override // java.security.PrivilegedAction
                public Charset run() {
                    Iterator<CharsetProvider> i10 = Charset.m3254$$Nest$smproviders();
                    while (i10.hasNext()) {
                        CharsetProvider cp = i10.next();
                        Charset cs = cp.charsetForName(String.this);
                        if (cs != null) {
                            return cs;
                        }
                    }
                    return null;
                }
            });
        } finally {
            gate.set(null);
        }
    }

    private static Charset lookup(String charsetName) {
        if (charsetName == null) {
            throw new IllegalArgumentException("Null charset name");
        }
        Map.Entry<String, Charset> cached = cache1;
        if (cached != null && charsetName.equals(cached.getKey())) {
            return cached.getValue();
        }
        return lookup2(charsetName);
    }

    private static Charset lookup2(String charsetName) {
        HashMap<String, Charset> hashMap = cache2;
        synchronized (hashMap) {
            Charset cs = hashMap.get(charsetName);
            if (cs != null) {
                cache1 = new AbstractMap.SimpleImmutableEntry(charsetName, cs);
                return cs;
            }
            Charset create = CharsetFactory.create(charsetName);
            Charset cs2 = create;
            if (create == null) {
                Charset lookupViaProviders = lookupViaProviders(charsetName);
                cs2 = lookupViaProviders;
                if (lookupViaProviders == null) {
                    checkName(charsetName);
                    return null;
                }
            }
            cache(charsetName, cs2);
            return cs2;
        }
    }

    public static boolean isSupported(String charsetName) {
        return lookup(charsetName) != null;
    }

    public static Charset forName(String charsetName) {
        Charset cs = lookup(charsetName);
        if (cs != null) {
            return cs;
        }
        throw new UnsupportedCharsetException(charsetName);
    }

    public static Charset forNameUEE(String charsetName) throws UnsupportedEncodingException {
        try {
            return forName(charsetName);
        } catch (Exception cause) {
            UnsupportedEncodingException ex = new UnsupportedEncodingException(charsetName);
            ex.initCause(cause);
            throw ex;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void put(Iterator<Charset> i10, Map<String, Charset> m10) {
        while (i10.hasNext()) {
            Charset cs = i10.next();
            if (!m10.containsKey(cs.name())) {
                m10.put(cs.name(), cs);
            }
        }
    }

    public static SortedMap<String, Charset> availableCharsets() {
        return (SortedMap) AccessController.doPrivileged(new PrivilegedAction<SortedMap<String, Charset>>() { // from class: java.nio.charset.Charset.3
            @Override // java.security.PrivilegedAction
            public SortedMap<String, Charset> run() {
                TreeMap<String, Charset> m10 = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
                for (String charsetName : CharsetFactory.getAvailableCharsetNames()) {
                    Charset charset = CharsetFactory.create(charsetName);
                    m10.put(charset.name(), charset);
                }
                Iterator<CharsetProvider> i10 = Charset.m3254$$Nest$smproviders();
                while (i10.hasNext()) {
                    CharsetProvider cp = i10.next();
                    Charset.put(cp.charsets(), m10);
                }
                return Collections.unmodifiableSortedMap(m10);
            }
        });
    }

    public static Charset defaultCharset() {
        if (defaultCharset == null) {
            synchronized (Charset.class) {
                defaultCharset = StandardCharsets.UTF_8;
            }
        }
        return defaultCharset;
    }

    protected Charset(String canonicalName, String[] aliases) {
        String[] as = (String[]) Objects.requireNonNullElse(aliases, zeroAliases);
        if (canonicalName != CharEncoding.ISO_8859_1 && canonicalName != CharEncoding.US_ASCII && canonicalName != "UTF-8") {
            checkName(canonicalName);
            for (String str : as) {
                checkName(str);
            }
        }
        this.name = canonicalName;
        this.aliases = as;
    }

    public final String name() {
        return this.name;
    }

    public final Set<String> aliases() {
        Set<String> set = this.aliasSet;
        if (set != null) {
            return set;
        }
        int n10 = this.aliases.length;
        HashSet<String> hs = new HashSet<>(n10);
        for (int i10 = 0; i10 < n10; i10++) {
            hs.add(this.aliases[i10]);
        }
        Set<String> unmodifiableSet = Collections.unmodifiableSet(hs);
        this.aliasSet = unmodifiableSet;
        return unmodifiableSet;
    }

    public String displayName() {
        return this.name;
    }

    public final boolean isRegistered() {
        return (this.name.startsWith("X-") || this.name.startsWith("x-")) ? false : true;
    }

    public String displayName(Locale locale) {
        return this.name;
    }

    public boolean canEncode() {
        return true;
    }

    public final CharBuffer decode(ByteBuffer bb2) {
        try {
            return ThreadLocalCoders.decoderFor(this).onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE).decode(bb2);
        } catch (CharacterCodingException x10) {
            throw new Error(x10);
        }
    }

    public final ByteBuffer encode(CharBuffer cb2) {
        try {
            return ThreadLocalCoders.encoderFor(this).onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE).encode(cb2);
        } catch (CharacterCodingException x10) {
            throw new Error(x10);
        }
    }

    public final ByteBuffer encode(String str) {
        return encode(CharBuffer.wrap(str));
    }

    @Override // java.lang.Comparable
    public final int compareTo(Charset that) {
        return name().compareToIgnoreCase(that.name());
    }

    public final int hashCode() {
        return name().hashCode();
    }

    public final boolean equals(Object ob2) {
        if (!(ob2 instanceof Charset)) {
            return false;
        }
        if (this == ob2) {
            return true;
        }
        return this.name.equals(((Charset) ob2).name());
    }

    public final String toString() {
        return name();
    }
}
