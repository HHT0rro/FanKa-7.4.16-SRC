package sun.nio.cs;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ThreadLocalCoders {
    private static final int CACHE_SIZE = 3;
    private static Cache decoderCache;
    private static Cache encoderCache;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static abstract class Cache {
        private ThreadLocal<Object[]> cache = new ThreadLocal<>();
        private final int size;

        abstract Object create(Object obj);

        abstract boolean hasName(Object obj, Object obj2);

        Cache(int size) {
            this.size = size;
        }

        private void moveToFront(Object[] oa2, int i10) {
            Object ob2 = oa2[i10];
            for (int j10 = i10; j10 > 0; j10--) {
                oa2[j10] = oa2[j10 - 1];
            }
            oa2[0] = ob2;
        }

        Object forName(Object name) {
            Object[] oa2 = this.cache.get();
            if (oa2 == null) {
                oa2 = new Object[this.size];
                this.cache.set(oa2);
            } else {
                for (int i10 = 0; i10 < oa2.length; i10++) {
                    Object ob2 = oa2[i10];
                    if (ob2 != null && hasName(ob2, name)) {
                        if (i10 > 0) {
                            moveToFront(oa2, i10);
                        }
                        return ob2;
                    }
                }
            }
            Object ob3 = create(name);
            oa2[oa2.length - 1] = ob3;
            moveToFront(oa2, oa2.length - 1);
            return ob3;
        }
    }

    static {
        int i10 = 3;
        decoderCache = new Cache(i10) { // from class: sun.nio.cs.ThreadLocalCoders.1
            static final /* synthetic */ boolean $assertionsDisabled = false;

            @Override // sun.nio.cs.ThreadLocalCoders.Cache
            boolean hasName(Object ob2, Object name) {
                if (name instanceof String) {
                    return ((CharsetDecoder) ob2).charset().name().equals(name);
                }
                if (name instanceof Charset) {
                    return ((CharsetDecoder) ob2).charset().equals(name);
                }
                return false;
            }

            @Override // sun.nio.cs.ThreadLocalCoders.Cache
            Object create(Object name) {
                if (name instanceof String) {
                    return Charset.forName((String) name).newDecoder();
                }
                if (name instanceof Charset) {
                    return ((Charset) name).newDecoder();
                }
                return null;
            }
        };
        encoderCache = new Cache(i10) { // from class: sun.nio.cs.ThreadLocalCoders.2
            static final /* synthetic */ boolean $assertionsDisabled = false;

            @Override // sun.nio.cs.ThreadLocalCoders.Cache
            boolean hasName(Object ob2, Object name) {
                if (name instanceof String) {
                    return ((CharsetEncoder) ob2).charset().name().equals(name);
                }
                if (name instanceof Charset) {
                    return ((CharsetEncoder) ob2).charset().equals(name);
                }
                return false;
            }

            @Override // sun.nio.cs.ThreadLocalCoders.Cache
            Object create(Object name) {
                if (name instanceof String) {
                    return Charset.forName((String) name).newEncoder();
                }
                if (name instanceof Charset) {
                    return ((Charset) name).newEncoder();
                }
                return null;
            }
        };
    }

    public static CharsetDecoder decoderFor(Object name) {
        CharsetDecoder cd2 = (CharsetDecoder) decoderCache.forName(name);
        cd2.reset();
        return cd2;
    }

    public static CharsetEncoder encoderFor(Object name) {
        CharsetEncoder ce2 = (CharsetEncoder) encoderCache.forName(name);
        ce2.reset();
        return ce2;
    }
}
