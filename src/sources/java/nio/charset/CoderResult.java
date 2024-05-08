package java.nio.charset;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class CoderResult {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int CR_ERROR_MIN = 2;
    private static final int CR_MALFORMED = 2;
    private static final int CR_OVERFLOW = 1;
    private static final int CR_UNDERFLOW = 0;
    private static final int CR_UNMAPPABLE = 3;
    private final int length;
    private final int type;
    private static final String[] names = {"UNDERFLOW", "OVERFLOW", "MALFORMED", "UNMAPPABLE"};
    public static final CoderResult UNDERFLOW = new CoderResult(0, 0);
    public static final CoderResult OVERFLOW = new CoderResult(1, 0);
    private static final CoderResult[] malformed4 = {new CoderResult(2, 1), new CoderResult(2, 2), new CoderResult(2, 3), new CoderResult(2, 4)};
    private static final CoderResult[] unmappable4 = {new CoderResult(3, 1), new CoderResult(3, 2), new CoderResult(3, 3), new CoderResult(3, 4)};

    private CoderResult(int type, int length) {
        this.type = type;
        this.length = length;
    }

    public String toString() {
        String nm = names[this.type];
        return isError() ? nm + "[" + this.length + "]" : nm;
    }

    public boolean isUnderflow() {
        return this.type == 0;
    }

    public boolean isOverflow() {
        return this.type == 1;
    }

    public boolean isError() {
        return this.type >= 2;
    }

    public boolean isMalformed() {
        return this.type == 2;
    }

    public boolean isUnmappable() {
        return this.type == 3;
    }

    public int length() {
        if (!isError()) {
            throw new UnsupportedOperationException();
        }
        return this.length;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class Cache {
        static final Cache INSTANCE = new Cache();
        final Map<Integer, CoderResult> unmappable = new ConcurrentHashMap();
        final Map<Integer, CoderResult> malformed = new ConcurrentHashMap();

        private Cache() {
        }
    }

    public static CoderResult malformedForLength(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Non-positive length");
        }
        if (length <= 4) {
            return malformed4[length - 1];
        }
        return Cache.INSTANCE.malformed.computeIfAbsent(Integer.valueOf(length), new Function() { // from class: java.nio.charset.CoderResult$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return CoderResult.lambda$malformedForLength$0((Integer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ CoderResult lambda$malformedForLength$0(Integer n10) {
        return new CoderResult(2, n10.intValue());
    }

    public static CoderResult unmappableForLength(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Non-positive length");
        }
        if (length <= 4) {
            return unmappable4[length - 1];
        }
        return Cache.INSTANCE.unmappable.computeIfAbsent(Integer.valueOf(length), new Function() { // from class: java.nio.charset.CoderResult$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return CoderResult.lambda$unmappableForLength$1((Integer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ CoderResult lambda$unmappableForLength$1(Integer n10) {
        return new CoderResult(3, n10.intValue());
    }

    public void throwException() throws CharacterCodingException {
        switch (this.type) {
            case 0:
                throw new BufferUnderflowException();
            case 1:
                throw new BufferOverflowException();
            case 2:
                throw new MalformedInputException(this.length);
            case 3:
                throw new UnmappableCharacterException(this.length);
            default:
                return;
        }
    }
}
