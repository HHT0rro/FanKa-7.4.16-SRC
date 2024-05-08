package java.nio.charset;

import com.huawei.flexiblelayout.u0;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.Objects;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class CharsetEncoder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int ST_CODING = 1;
    private static final int ST_END = 2;
    private static final int ST_FLUSHED = 3;
    private static final int ST_RESET = 0;
    private static String[] stateNames = {"RESET", "CODING", "CODING_END", "FLUSHED"};
    private final float averageBytesPerChar;
    private WeakReference<CharsetDecoder> cachedDecoder;
    private final Charset charset;
    private CodingErrorAction malformedInputAction;
    private final float maxBytesPerChar;
    private byte[] replacement;
    private int state;
    private CodingErrorAction unmappableCharacterAction;

    protected abstract CoderResult encodeLoop(CharBuffer charBuffer, ByteBuffer byteBuffer);

    protected CharsetEncoder(Charset cs, float averageBytesPerChar, float maxBytesPerChar, byte[] replacement) {
        this(cs, averageBytesPerChar, maxBytesPerChar, replacement, false);
    }

    protected CharsetEncoder(Charset cs, float averageBytesPerChar, float maxBytesPerChar, byte[] replacement, boolean trusted) {
        this.malformedInputAction = CodingErrorAction.REPORT;
        this.unmappableCharacterAction = CodingErrorAction.REPORT;
        this.state = 0;
        this.cachedDecoder = null;
        this.charset = cs;
        if (averageBytesPerChar <= 0.0f) {
            throw new IllegalArgumentException("Non-positive averageBytesPerChar");
        }
        if (maxBytesPerChar <= 0.0f) {
            throw new IllegalArgumentException("Non-positive maxBytesPerChar");
        }
        if (averageBytesPerChar > maxBytesPerChar) {
            throw new IllegalArgumentException("averageBytesPerChar exceeds maxBytesPerChar");
        }
        this.replacement = replacement;
        this.averageBytesPerChar = averageBytesPerChar;
        this.maxBytesPerChar = maxBytesPerChar;
        if (!trusted) {
            replaceWith(replacement);
        }
    }

    protected CharsetEncoder(Charset cs, float averageBytesPerChar, float maxBytesPerChar) {
        this(cs, averageBytesPerChar, maxBytesPerChar, new byte[]{Utf8.REPLACEMENT_BYTE});
    }

    public final Charset charset() {
        return this.charset;
    }

    public final byte[] replacement() {
        byte[] bArr = this.replacement;
        return Arrays.copyOf(bArr, bArr.length);
    }

    public final CharsetEncoder replaceWith(byte[] newReplacement) {
        if (newReplacement == null) {
            throw new IllegalArgumentException("Null replacement");
        }
        int len = newReplacement.length;
        if (len == 0) {
            throw new IllegalArgumentException("Empty replacement");
        }
        if (len > this.maxBytesPerChar) {
            throw new IllegalArgumentException("Replacement too long");
        }
        if (!isLegalReplacement(newReplacement)) {
            throw new IllegalArgumentException("Illegal replacement");
        }
        byte[] copyOf = Arrays.copyOf(newReplacement, newReplacement.length);
        this.replacement = copyOf;
        implReplaceWith(copyOf);
        return this;
    }

    protected void implReplaceWith(byte[] newReplacement) {
    }

    public boolean isLegalReplacement(byte[] repl) {
        CharsetDecoder dec;
        WeakReference<CharsetDecoder> wr = this.cachedDecoder;
        if (wr != null) {
            CharsetDecoder charsetDecoder = wr.get();
            dec = charsetDecoder;
            if (charsetDecoder != null) {
                dec.reset();
                ByteBuffer bb2 = ByteBuffer.wrap(repl);
                CharBuffer cb2 = CharBuffer.allocate((int) (bb2.remaining() * dec.maxCharsPerByte()));
                CoderResult cr = dec.decode(bb2, cb2, true);
                return true ^ cr.isError();
            }
        }
        dec = charset().newDecoder();
        dec.onMalformedInput(CodingErrorAction.REPORT);
        dec.onUnmappableCharacter(CodingErrorAction.REPORT);
        this.cachedDecoder = new WeakReference<>(dec);
        ByteBuffer bb22 = ByteBuffer.wrap(repl);
        CharBuffer cb22 = CharBuffer.allocate((int) (bb22.remaining() * dec.maxCharsPerByte()));
        CoderResult cr2 = dec.decode(bb22, cb22, true);
        return true ^ cr2.isError();
    }

    public CodingErrorAction malformedInputAction() {
        return this.malformedInputAction;
    }

    public final CharsetEncoder onMalformedInput(CodingErrorAction newAction) {
        if (newAction == null) {
            throw new IllegalArgumentException("Null action");
        }
        this.malformedInputAction = newAction;
        implOnMalformedInput(newAction);
        return this;
    }

    protected void implOnMalformedInput(CodingErrorAction newAction) {
    }

    public CodingErrorAction unmappableCharacterAction() {
        return this.unmappableCharacterAction;
    }

    public final CharsetEncoder onUnmappableCharacter(CodingErrorAction newAction) {
        if (newAction == null) {
            throw new IllegalArgumentException("Null action");
        }
        this.unmappableCharacterAction = newAction;
        implOnUnmappableCharacter(newAction);
        return this;
    }

    protected void implOnUnmappableCharacter(CodingErrorAction newAction) {
    }

    public final float averageBytesPerChar() {
        return this.averageBytesPerChar;
    }

    public final float maxBytesPerChar() {
        return this.maxBytesPerChar;
    }

    public final CoderResult encode(CharBuffer in, ByteBuffer out, boolean endOfInput) {
        CoderResult cr;
        Objects.requireNonNull(in, u0.f28637e);
        Objects.requireNonNull(out, "out");
        int newState = endOfInput ? 2 : 1;
        int i10 = this.state;
        if (i10 != 0 && i10 != 1 && (!endOfInput || i10 != 2)) {
            throwIllegalStateException(i10, newState);
        }
        this.state = newState;
        while (true) {
            try {
                cr = encodeLoop(in, out);
                if (cr.isOverflow()) {
                    return cr;
                }
                if (cr.isUnderflow()) {
                    if (!endOfInput || !in.hasRemaining()) {
                        break;
                    }
                    cr = CoderResult.malformedForLength(in.remaining());
                }
                CodingErrorAction action = null;
                if (cr.isMalformed()) {
                    action = this.malformedInputAction;
                } else if (cr.isUnmappable()) {
                    action = this.unmappableCharacterAction;
                }
                if (action == CodingErrorAction.REPORT) {
                    return cr;
                }
                if (action == CodingErrorAction.REPLACE) {
                    int remaining = out.remaining();
                    byte[] bArr = this.replacement;
                    if (remaining < bArr.length) {
                        return CoderResult.OVERFLOW;
                    }
                    out.put(bArr);
                }
                if (action == CodingErrorAction.IGNORE || action == CodingErrorAction.REPLACE) {
                    in.position(in.position() + cr.length());
                }
            } catch (RuntimeException x10) {
                throw new CoderMalfunctionError(x10);
            }
        }
        return cr;
    }

    public final CoderResult flush(ByteBuffer out) {
        int i10 = this.state;
        if (i10 == 2) {
            CoderResult cr = implFlush(out);
            if (cr.isUnderflow()) {
                this.state = 3;
            }
            return cr;
        }
        if (i10 != 3) {
            throwIllegalStateException(i10, 3);
        }
        return CoderResult.UNDERFLOW;
    }

    protected CoderResult implFlush(ByteBuffer out) {
        return CoderResult.UNDERFLOW;
    }

    public final CharsetEncoder reset() {
        implReset();
        this.state = 0;
        return this;
    }

    protected void implReset() {
    }

    public final ByteBuffer encode(CharBuffer in) throws CharacterCodingException {
        int n10 = (int) (in.remaining() * averageBytesPerChar());
        ByteBuffer out = ByteBuffer.allocate(n10);
        if (n10 == 0 && in.remaining() == 0) {
            return out;
        }
        reset();
        while (true) {
            CoderResult cr = in.hasRemaining() ? encode(in, out, true) : CoderResult.UNDERFLOW;
            if (cr.isUnderflow()) {
                cr = flush(out);
            }
            if (!cr.isUnderflow()) {
                if (cr.isOverflow()) {
                    n10 = (n10 * 2) + 1;
                    ByteBuffer o10 = ByteBuffer.allocate(n10);
                    out.flip();
                    o10.put(out);
                    out = o10;
                } else {
                    cr.throwException();
                }
            } else {
                out.flip();
                return out;
            }
        }
    }

    private boolean canEncode(CharBuffer cb2) {
        int i10 = this.state;
        if (i10 == 3) {
            reset();
        } else if (i10 != 0) {
            throwIllegalStateException(i10, 1);
        }
        if (!cb2.hasRemaining()) {
            return true;
        }
        CodingErrorAction ma2 = malformedInputAction();
        CodingErrorAction ua2 = unmappableCharacterAction();
        try {
            onMalformedInput(CodingErrorAction.REPORT);
            onUnmappableCharacter(CodingErrorAction.REPORT);
            encode(cb2);
            onMalformedInput(ma2);
            onUnmappableCharacter(ua2);
            reset();
            return true;
        } catch (CharacterCodingException e2) {
            onMalformedInput(ma2);
            onUnmappableCharacter(ua2);
            reset();
            return false;
        } catch (Throwable th) {
            onMalformedInput(ma2);
            onUnmappableCharacter(ua2);
            reset();
            throw th;
        }
    }

    public boolean canEncode(char c4) {
        CharBuffer cb2 = CharBuffer.allocate(1);
        cb2.put(c4);
        cb2.flip();
        return canEncode(cb2);
    }

    public boolean canEncode(CharSequence cs) {
        CharBuffer cb2;
        if (cs instanceof CharBuffer) {
            cb2 = ((CharBuffer) cs).duplicate();
        } else {
            cb2 = CharBuffer.wrap(cs);
        }
        return canEncode(cb2);
    }

    private void throwIllegalStateException(int from, int to) {
        throw new IllegalStateException("Current state = " + stateNames[from] + ", new state = " + stateNames[to]);
    }
}
