package java.util;

import com.alipay.sdk.util.i;
import com.android.internal.logging.nano.MetricsProto;
import com.huawei.appgallery.agd.common.constant.SymbolValues;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.CharBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class Scanner implements Iterator<String>, Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String BOOLEAN_PATTERN = "true|false";
    private static final int BUFFER_SIZE = 1024;
    private static final String LINE_PATTERN = ".*(\r\n|[\n\r\u2028\u2029\u0085])|.+$";
    private static final String LINE_SEPARATOR_PATTERN = "\r\n|[\n\r\u2028\u2029\u0085]";
    private static volatile Pattern boolPattern;
    private static volatile Pattern linePattern;
    private static volatile Pattern separatorPattern;
    private int SIMPLE_GROUP_INDEX;
    private CharBuffer buf;
    private boolean closed;
    private Pattern decimalPattern;
    private String decimalSeparator;
    private int defaultRadix;
    private Pattern delimPattern;
    private String digits;
    private Pattern floatPattern;
    private String groupSeparator;
    private Pattern hasNextPattern;
    private int hasNextPosition;
    private String hasNextResult;
    private String infinityString;
    private Pattern integerPattern;
    private IOException lastException;
    private Locale locale;
    private boolean matchValid;
    private Matcher matcher;
    int modCount;
    private String nanString;
    private boolean needInput;
    private String negativePrefix;
    private String negativeSuffix;
    private String non0Digit;
    private PatternLRUCache patternCache;
    private int position;
    private String positivePrefix;
    private String positiveSuffix;
    private int radix;
    private int savedScannerPosition;
    private boolean skipped;
    private Readable source;
    private boolean sourceClosed;
    private Object typeCache;
    private static Pattern WHITESPACE_PATTERN = Pattern.compile("\\p{javaWhitespace}+");
    private static Pattern FIND_ANY_PATTERN = Pattern.compile("(?s).*");
    private static Pattern NON_ASCII_DIGIT = Pattern.compile("[\\p{javaDigit}&&[^0-9]]");

    private static Pattern boolPattern() {
        Pattern bp = boolPattern;
        if (bp == null) {
            Pattern bp2 = Pattern.compile(BOOLEAN_PATTERN, 2);
            boolPattern = bp2;
            return bp2;
        }
        return bp;
    }

    private String buildIntegerPatternString() {
        String radixDigits = this.digits.substring(0, this.radix);
        String digit = "((?i)[" + radixDigits + "\\p{javaDigit}])";
        String non0RadixDigits = "((?i)[" + this.digits.substring(1, this.radix) + "]|(" + this.non0Digit + "))";
        String groupedNumeral = "(" + non0RadixDigits + digit + SymbolValues.QUESTION_EN_SYMBOL + digit + "?(" + this.groupSeparator + digit + digit + digit + ")+)";
        String numeral = "((" + digit + "++)|" + groupedNumeral + ")";
        String javaStyleInteger = "([-+]?(" + numeral + "))";
        String negativeInteger = this.negativePrefix + numeral + this.negativeSuffix;
        String positiveInteger = this.positivePrefix + numeral + this.positiveSuffix;
        return "(" + javaStyleInteger + ")|(" + positiveInteger + ")|(" + negativeInteger + ")";
    }

    private Pattern integerPattern() {
        if (this.integerPattern == null) {
            this.integerPattern = this.patternCache.forName(buildIntegerPatternString());
        }
        return this.integerPattern;
    }

    private static Pattern separatorPattern() {
        Pattern sp = separatorPattern;
        if (sp == null) {
            Pattern sp2 = Pattern.compile(LINE_SEPARATOR_PATTERN);
            separatorPattern = sp2;
            return sp2;
        }
        return sp;
    }

    private static Pattern linePattern() {
        Pattern lp = linePattern;
        if (lp == null) {
            Pattern lp2 = Pattern.compile(LINE_PATTERN);
            linePattern = lp2;
            return lp2;
        }
        return lp;
    }

    private void buildFloatAndDecimalPattern() {
        String exponent = "([eE][+-]?(([0-9\\p{javaDigit}]))+)?";
        String groupedNumeral = "(" + this.non0Digit + "(([0-9\\p{javaDigit}]))" + SymbolValues.QUESTION_EN_SYMBOL + "(([0-9\\p{javaDigit}]))?(" + this.groupSeparator + "(([0-9\\p{javaDigit}]))(([0-9\\p{javaDigit}]))(([0-9\\p{javaDigit}])))+)";
        String numeral = "(((([0-9\\p{javaDigit}]))++)|" + groupedNumeral + ")";
        String decimalNumeral = "(" + numeral + "|" + numeral + this.decimalSeparator + "(([0-9\\p{javaDigit}]))*+|" + this.decimalSeparator + "(([0-9\\p{javaDigit}]))++)";
        String nonNumber = "(NaN|" + this.nanString + "|Infinity|" + this.infinityString + ")";
        String positiveFloat = "(" + this.positivePrefix + decimalNumeral + this.positiveSuffix + exponent + ")";
        String negativeFloat = "(" + this.negativePrefix + decimalNumeral + this.negativeSuffix + exponent + ")";
        String decimal = "(([-+]?" + decimalNumeral + exponent + ")|" + positiveFloat + "|" + negativeFloat + ")";
        String positiveNonNumber = "(" + this.positivePrefix + nonNumber + this.positiveSuffix + ")";
        String negativeNonNumber = "(" + this.negativePrefix + nonNumber + this.negativeSuffix + ")";
        String signedNonNumber = "(([-+]?" + nonNumber + ")|" + positiveNonNumber + "|" + negativeNonNumber + ")";
        this.floatPattern = Pattern.compile(decimal + "|[-+]?0[xX][0-9a-fA-F]*\\.[0-9a-fA-F]+([pP][-+]?[0-9]+)?|" + signedNonNumber);
        this.decimalPattern = Pattern.compile(decimal);
    }

    private Pattern floatPattern() {
        if (this.floatPattern == null) {
            buildFloatAndDecimalPattern();
        }
        return this.floatPattern;
    }

    private Pattern decimalPattern() {
        if (this.decimalPattern == null) {
            buildFloatAndDecimalPattern();
        }
        return this.decimalPattern;
    }

    private Scanner(Readable source, Pattern pattern) {
        this.sourceClosed = false;
        this.needInput = false;
        this.skipped = false;
        this.savedScannerPosition = -1;
        this.typeCache = null;
        this.matchValid = false;
        this.closed = false;
        this.radix = 10;
        this.defaultRadix = 10;
        this.locale = null;
        this.patternCache = new PatternLRUCache(7);
        this.groupSeparator = "\\,";
        this.decimalSeparator = "\\.";
        this.nanString = "NaN";
        this.infinityString = "Infinity";
        this.positivePrefix = "";
        this.negativePrefix = "\\-";
        this.positiveSuffix = "";
        this.negativeSuffix = "";
        this.digits = "0123456789abcdefghijklmnopqrstuvwxyz";
        this.non0Digit = "[\\p{javaDigit}&&[^0]]";
        this.SIMPLE_GROUP_INDEX = 5;
        this.source = source;
        this.delimPattern = pattern;
        CharBuffer allocate = CharBuffer.allocate(1024);
        this.buf = allocate;
        allocate.limit(0);
        Matcher matcher = this.delimPattern.matcher(this.buf);
        this.matcher = matcher;
        matcher.useTransparentBounds(true);
        this.matcher.useAnchoringBounds(false);
        useLocale(Locale.getDefault(Locale.Category.FORMAT));
    }

    public Scanner(Readable source) {
        this((Readable) Objects.requireNonNull(source, "source"), WHITESPACE_PATTERN);
    }

    public Scanner(InputStream source) {
        this(new InputStreamReader(source), WHITESPACE_PATTERN);
    }

    public Scanner(InputStream source, String charsetName) {
        this(source, toCharset(charsetName));
    }

    public Scanner(InputStream source, Charset charset) {
        this(makeReadable((InputStream) Objects.requireNonNull(source, "source"), charset), WHITESPACE_PATTERN);
    }

    private static Charset toCharset(String csn) {
        Objects.requireNonNull(csn, "charsetName");
        try {
            return Charset.forName(csn);
        } catch (IllegalCharsetNameException | UnsupportedCharsetException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    private static Readable makeReadable(Path source, Charset charset) throws IOException {
        Objects.requireNonNull(charset, "charset");
        return makeReadable(Files.newInputStream(source, new OpenOption[0]), charset);
    }

    private static Readable makeReadable(InputStream source, Charset charset) {
        Objects.requireNonNull(charset, "charset");
        return new InputStreamReader(source, charset);
    }

    public Scanner(File source) throws FileNotFoundException {
        this(new FileInputStream(source).getChannel());
    }

    public Scanner(File source, String charsetName) throws FileNotFoundException {
        this((File) Objects.requireNonNull(source), toDecoder(charsetName));
    }

    public Scanner(File source, Charset charset) throws IOException {
        this((File) Objects.requireNonNull(source), charset.newDecoder());
    }

    private Scanner(File source, CharsetDecoder dec) throws FileNotFoundException {
        this(makeReadable(new FileInputStream(source).getChannel(), dec));
    }

    private static CharsetDecoder toDecoder(String charsetName) {
        if (charsetName == null) {
            throw new IllegalArgumentException("charsetName == null");
        }
        try {
            return Charset.forName(charsetName).newDecoder();
        } catch (IllegalCharsetNameException | UnsupportedCharsetException e2) {
            throw new IllegalArgumentException(charsetName);
        }
    }

    private static Readable makeReadable(ReadableByteChannel source, CharsetDecoder dec) {
        return Channels.newReader(source, dec, -1);
    }

    private static Readable makeReadable(ReadableByteChannel source, Charset charset) {
        Objects.requireNonNull(charset, "charset");
        return Channels.newReader(source, charset);
    }

    public Scanner(Path source) throws IOException {
        this(Files.newInputStream(source, new OpenOption[0]));
    }

    public Scanner(Path source, String charsetName) throws IOException {
        this((Path) Objects.requireNonNull(source), toCharset(charsetName));
    }

    public Scanner(Path source, Charset charset) throws IOException {
        this(makeReadable(source, charset));
    }

    public Scanner(String source) {
        this(new StringReader(source), WHITESPACE_PATTERN);
    }

    public Scanner(ReadableByteChannel source) {
        this(makeReadable((ReadableByteChannel) Objects.requireNonNull(source, "source")), WHITESPACE_PATTERN);
    }

    private static Readable makeReadable(ReadableByteChannel source) {
        return makeReadable(source, Charset.defaultCharset().newDecoder());
    }

    public Scanner(ReadableByteChannel source, String charsetName) {
        this(makeReadable((ReadableByteChannel) Objects.requireNonNull(source, "source"), toDecoder(charsetName)), WHITESPACE_PATTERN);
    }

    public Scanner(ReadableByteChannel source, Charset charset) {
        this(makeReadable((ReadableByteChannel) Objects.requireNonNull(source, "source"), charset), WHITESPACE_PATTERN);
    }

    private void saveState() {
        this.savedScannerPosition = this.position;
    }

    private void revertState() {
        this.position = this.savedScannerPosition;
        this.savedScannerPosition = -1;
        this.skipped = false;
    }

    private boolean revertState(boolean b4) {
        this.position = this.savedScannerPosition;
        this.savedScannerPosition = -1;
        this.skipped = false;
        return b4;
    }

    private void cacheResult() {
        this.hasNextResult = this.matcher.group();
        this.hasNextPosition = this.matcher.end();
        this.hasNextPattern = this.matcher.pattern();
    }

    private void cacheResult(String result) {
        this.hasNextResult = result;
        this.hasNextPosition = this.matcher.end();
        this.hasNextPattern = this.matcher.pattern();
    }

    private void clearCaches() {
        this.hasNextPattern = null;
        this.typeCache = null;
    }

    private String getCachedResult() {
        this.position = this.hasNextPosition;
        this.hasNextPattern = null;
        this.typeCache = null;
        return this.hasNextResult;
    }

    private void useTypeCache() {
        if (this.closed) {
            throw new IllegalStateException("Scanner closed");
        }
        this.position = this.hasNextPosition;
        this.hasNextPattern = null;
        this.typeCache = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void readInput() {
        int n10;
        if (this.buf.limit() == this.buf.capacity()) {
            makeSpace();
        }
        int p10 = this.buf.position();
        CharBuffer charBuffer = this.buf;
        charBuffer.position(charBuffer.limit());
        CharBuffer charBuffer2 = this.buf;
        charBuffer2.limit(charBuffer2.capacity());
        try {
            n10 = this.source.read(this.buf);
        } catch (IOException ioe) {
            this.lastException = ioe;
            n10 = -1;
        }
        if (n10 == -1) {
            this.sourceClosed = true;
            this.needInput = false;
        }
        if (n10 > 0) {
            this.needInput = false;
        }
        CharBuffer charBuffer3 = this.buf;
        charBuffer3.limit(charBuffer3.position());
        this.buf.position(p10);
        this.matcher.reset(this.buf);
    }

    private boolean makeSpace() {
        clearCaches();
        int offset = this.savedScannerPosition;
        if (offset == -1) {
            offset = this.position;
        }
        this.buf.position(offset);
        if (offset > 0) {
            this.buf.compact();
            translateSavedIndexes(offset);
            this.position -= offset;
            this.buf.flip();
            return true;
        }
        int newSize = this.buf.capacity() * 2;
        CharBuffer newBuf = CharBuffer.allocate(newSize);
        newBuf.put(this.buf);
        newBuf.flip();
        translateSavedIndexes(offset);
        this.position -= offset;
        this.buf = newBuf;
        this.matcher.reset(newBuf);
        return true;
    }

    private void translateSavedIndexes(int offset) {
        int i10 = this.savedScannerPosition;
        if (i10 != -1) {
            this.savedScannerPosition = i10 - offset;
        }
    }

    private void throwFor() {
        this.skipped = false;
        if (this.sourceClosed && this.position == this.buf.limit()) {
            throw new NoSuchElementException();
        }
        throw new InputMismatchException();
    }

    private boolean hasTokenInBuffer() {
        this.matchValid = false;
        this.matcher.usePattern(this.delimPattern);
        this.matcher.region(this.position, this.buf.limit());
        if (this.matcher.lookingAt()) {
            if (this.matcher.hitEnd() && !this.sourceClosed) {
                this.needInput = true;
                return false;
            }
            this.position = this.matcher.end();
        }
        return this.position != this.buf.limit();
    }

    private String getCompleteTokenInBuffer(Pattern pattern) {
        this.matchValid = false;
        this.matcher.usePattern(this.delimPattern);
        if (!this.skipped) {
            this.matcher.region(this.position, this.buf.limit());
            if (this.matcher.lookingAt()) {
                if (this.matcher.hitEnd() && !this.sourceClosed) {
                    this.needInput = true;
                    return null;
                }
                this.skipped = true;
                this.position = this.matcher.end();
            }
        }
        if (this.position == this.buf.limit()) {
            if (this.sourceClosed) {
                return null;
            }
            this.needInput = true;
            return null;
        }
        this.matcher.region(this.position, this.buf.limit());
        boolean foundNextDelim = this.matcher.find();
        if (foundNextDelim && this.matcher.end() == this.position) {
            foundNextDelim = this.matcher.find();
        }
        if (foundNextDelim) {
            if (this.matcher.requireEnd() && !this.sourceClosed) {
                this.needInput = true;
                return null;
            }
            int tokenEnd = this.matcher.start();
            if (pattern == null) {
                pattern = FIND_ANY_PATTERN;
            }
            this.matcher.usePattern(pattern);
            this.matcher.region(this.position, tokenEnd);
            if (!this.matcher.matches()) {
                return null;
            }
            String s2 = this.matcher.group();
            this.position = this.matcher.end();
            return s2;
        }
        if (this.sourceClosed) {
            if (pattern == null) {
                pattern = FIND_ANY_PATTERN;
            }
            this.matcher.usePattern(pattern);
            this.matcher.region(this.position, this.buf.limit());
            if (!this.matcher.matches()) {
                return null;
            }
            String s10 = this.matcher.group();
            this.position = this.matcher.end();
            return s10;
        }
        this.needInput = true;
        return null;
    }

    private boolean findPatternInBuffer(Pattern pattern, int horizon) {
        this.matchValid = false;
        this.matcher.usePattern(pattern);
        int bufferLimit = this.buf.limit();
        int horizonLimit = -1;
        int searchLimit = bufferLimit;
        if (horizon > 0 && (horizonLimit = this.position + horizon) < bufferLimit) {
            searchLimit = horizonLimit;
        }
        this.matcher.region(this.position, searchLimit);
        if (this.matcher.find()) {
            if (this.matcher.hitEnd() && !this.sourceClosed) {
                if (searchLimit != horizonLimit) {
                    this.needInput = true;
                    return false;
                }
                if (searchLimit == horizonLimit && this.matcher.requireEnd()) {
                    this.needInput = true;
                    return false;
                }
            }
            this.position = this.matcher.end();
            return true;
        }
        if (this.sourceClosed) {
            return false;
        }
        if (horizon == 0 || searchLimit != horizonLimit) {
            this.needInput = true;
        }
        return false;
    }

    private boolean matchPatternInBuffer(Pattern pattern) {
        this.matchValid = false;
        this.matcher.usePattern(pattern);
        this.matcher.region(this.position, this.buf.limit());
        if (this.matcher.lookingAt()) {
            if (this.matcher.hitEnd() && !this.sourceClosed) {
                this.needInput = true;
                return false;
            }
            this.position = this.matcher.end();
            return true;
        }
        if (this.sourceClosed) {
            return false;
        }
        this.needInput = true;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ensureOpen() {
        if (this.closed) {
            throw new IllegalStateException("Scanner closed");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.closed) {
            return;
        }
        Readable readable = this.source;
        if (readable instanceof Closeable) {
            try {
                ((Closeable) readable).close();
            } catch (IOException ioe) {
                this.lastException = ioe;
            }
        }
        this.sourceClosed = true;
        this.source = null;
        this.closed = true;
    }

    public IOException ioException() {
        return this.lastException;
    }

    public Pattern delimiter() {
        return this.delimPattern;
    }

    public Scanner useDelimiter(Pattern pattern) {
        this.modCount++;
        this.delimPattern = pattern;
        return this;
    }

    public Scanner useDelimiter(String pattern) {
        this.modCount++;
        this.delimPattern = this.patternCache.forName(pattern);
        return this;
    }

    public Locale locale() {
        return this.locale;
    }

    public Scanner useLocale(Locale locale) {
        if (locale.equals(this.locale)) {
            return this;
        }
        this.modCount++;
        this.locale = locale;
        NumberFormat nf = NumberFormat.getNumberInstance(locale);
        DecimalFormatSymbols dfs = DecimalFormatSymbols.getInstance(locale);
        DecimalFormat df = (DecimalFormat) nf;
        this.groupSeparator = "\\x{" + Integer.toHexString(dfs.getGroupingSeparator()) + i.f4738d;
        this.decimalSeparator = "\\x{" + Integer.toHexString(dfs.getDecimalSeparator()) + i.f4738d;
        this.nanString = Pattern.quote(dfs.getNaN());
        this.infinityString = Pattern.quote(dfs.getInfinity());
        String positivePrefix = df.getPositivePrefix();
        this.positivePrefix = positivePrefix;
        if (!positivePrefix.isEmpty()) {
            this.positivePrefix = Pattern.quote(this.positivePrefix);
        }
        String negativePrefix = df.getNegativePrefix();
        this.negativePrefix = negativePrefix;
        if (!negativePrefix.isEmpty()) {
            this.negativePrefix = Pattern.quote(this.negativePrefix);
        }
        String positiveSuffix = df.getPositiveSuffix();
        this.positiveSuffix = positiveSuffix;
        if (!positiveSuffix.isEmpty()) {
            this.positiveSuffix = Pattern.quote(this.positiveSuffix);
        }
        String negativeSuffix = df.getNegativeSuffix();
        this.negativeSuffix = negativeSuffix;
        if (!negativeSuffix.isEmpty()) {
            this.negativeSuffix = Pattern.quote(this.negativeSuffix);
        }
        this.integerPattern = null;
        this.floatPattern = null;
        return this;
    }

    public int radix() {
        return this.defaultRadix;
    }

    public Scanner useRadix(int radix) {
        if (radix < 2 || radix > 36) {
            throw new IllegalArgumentException("radix:" + radix);
        }
        if (this.defaultRadix == radix) {
            return this;
        }
        this.modCount++;
        this.defaultRadix = radix;
        this.integerPattern = null;
        return this;
    }

    private void setRadix(int radix) {
        if (radix < 2 || radix > 36) {
            throw new IllegalArgumentException("radix:" + radix);
        }
        if (this.radix != radix) {
            this.integerPattern = null;
            this.radix = radix;
        }
    }

    public MatchResult match() {
        if (!this.matchValid) {
            throw new IllegalStateException("No match result available");
        }
        return this.matcher.toMatchResult();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("java.util.Scanner");
        sb2.append("[delimiters=" + ((Object) this.delimPattern) + "]");
        sb2.append("[position=" + this.position + "]");
        sb2.append("[match valid=" + this.matchValid + "]");
        sb2.append("[need input=" + this.needInput + "]");
        sb2.append("[source closed=" + this.sourceClosed + "]");
        sb2.append("[skipped=" + this.skipped + "]");
        sb2.append("[group separator=" + this.groupSeparator + "]");
        sb2.append("[decimal separator=" + this.decimalSeparator + "]");
        sb2.append("[positive prefix=" + this.positivePrefix + "]");
        sb2.append("[negative prefix=" + this.negativePrefix + "]");
        sb2.append("[positive suffix=" + this.positiveSuffix + "]");
        sb2.append("[negative suffix=" + this.negativeSuffix + "]");
        sb2.append("[NaN string=" + this.nanString + "]");
        sb2.append("[infinity string=" + this.infinityString + "]");
        return sb2.toString();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        ensureOpen();
        saveState();
        this.modCount++;
        while (!this.sourceClosed) {
            if (hasTokenInBuffer()) {
                return revertState(true);
            }
            readInput();
        }
        boolean result = hasTokenInBuffer();
        return revertState(result);
    }

    @Override // java.util.Iterator
    public String next() {
        ensureOpen();
        clearCaches();
        this.modCount++;
        while (true) {
            String token = getCompleteTokenInBuffer(null);
            if (token != null) {
                this.matchValid = true;
                this.skipped = false;
                return token;
            }
            if (this.needInput) {
                readInput();
            } else {
                throwFor();
            }
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    public boolean hasNext(String pattern) {
        return hasNext(this.patternCache.forName(pattern));
    }

    public String next(String pattern) {
        return next(this.patternCache.forName(pattern));
    }

    public boolean hasNext(Pattern pattern) {
        ensureOpen();
        if (pattern == null) {
            throw new NullPointerException();
        }
        this.hasNextPattern = null;
        saveState();
        this.modCount++;
        while (getCompleteTokenInBuffer(pattern) == null) {
            if (this.needInput) {
                readInput();
            } else {
                return revertState(false);
            }
        }
        this.matchValid = true;
        cacheResult();
        return revertState(true);
    }

    public String next(Pattern pattern) {
        ensureOpen();
        if (pattern == null) {
            throw new NullPointerException();
        }
        this.modCount++;
        if (this.hasNextPattern == pattern) {
            return getCachedResult();
        }
        clearCaches();
        while (true) {
            String token = getCompleteTokenInBuffer(pattern);
            if (token != null) {
                this.matchValid = true;
                this.skipped = false;
                return token;
            }
            if (this.needInput) {
                readInput();
            } else {
                throwFor();
            }
        }
    }

    public boolean hasNextLine() {
        saveState();
        this.modCount++;
        String result = findWithinHorizon(linePattern(), 0);
        if (result != null) {
            MatchResult mr = match();
            String lineSep = mr.group(1);
            if (lineSep != null) {
                result = result.substring(0, result.length() - lineSep.length());
                cacheResult(result);
            } else {
                cacheResult();
            }
        }
        revertState();
        return result != null;
    }

    public String nextLine() {
        this.modCount++;
        if (this.hasNextPattern == linePattern()) {
            return getCachedResult();
        }
        clearCaches();
        String result = findWithinHorizon(linePattern, 0);
        if (result == null) {
            throw new NoSuchElementException("No line found");
        }
        MatchResult mr = match();
        String lineSep = mr.group(1);
        if (lineSep != null) {
            result = result.substring(0, result.length() - lineSep.length());
        }
        if (result == null) {
            throw new NoSuchElementException();
        }
        return result;
    }

    public String findInLine(String pattern) {
        return findInLine(this.patternCache.forName(pattern));
    }

    public String findInLine(Pattern pattern) {
        int endPosition;
        ensureOpen();
        if (pattern == null) {
            throw new NullPointerException();
        }
        clearCaches();
        this.modCount++;
        saveState();
        while (true) {
            if (findPatternInBuffer(separatorPattern(), 0)) {
                endPosition = this.matcher.start();
                break;
            }
            if (this.needInput) {
                readInput();
            } else {
                endPosition = this.buf.limit();
                break;
            }
        }
        revertState();
        int horizonForLine = endPosition - this.position;
        if (horizonForLine == 0) {
            return null;
        }
        return findWithinHorizon(pattern, horizonForLine);
    }

    public String findWithinHorizon(String pattern, int horizon) {
        return findWithinHorizon(this.patternCache.forName(pattern), horizon);
    }

    public String findWithinHorizon(Pattern pattern, int horizon) {
        ensureOpen();
        if (pattern == null) {
            throw new NullPointerException();
        }
        if (horizon < 0) {
            throw new IllegalArgumentException("horizon < 0");
        }
        clearCaches();
        this.modCount++;
        while (!findPatternInBuffer(pattern, horizon)) {
            if (this.needInput) {
                readInput();
            } else {
                return null;
            }
        }
        this.matchValid = true;
        return this.matcher.group();
    }

    public Scanner skip(Pattern pattern) {
        ensureOpen();
        if (pattern == null) {
            throw new NullPointerException();
        }
        clearCaches();
        this.modCount++;
        while (!matchPatternInBuffer(pattern)) {
            if (this.needInput) {
                readInput();
            } else {
                throw new NoSuchElementException();
            }
        }
        this.matchValid = true;
        this.position = this.matcher.end();
        return this;
    }

    public Scanner skip(String pattern) {
        return skip(this.patternCache.forName(pattern));
    }

    public boolean hasNextBoolean() {
        return hasNext(boolPattern());
    }

    public boolean nextBoolean() {
        clearCaches();
        return Boolean.parseBoolean(next(boolPattern()));
    }

    public boolean hasNextByte() {
        return hasNextByte(this.defaultRadix);
    }

    public boolean hasNextByte(int radix) {
        String s2;
        setRadix(radix);
        boolean result = hasNext(integerPattern());
        if (result) {
            try {
                if (this.matcher.group(this.SIMPLE_GROUP_INDEX) == null) {
                    s2 = processIntegerToken(this.hasNextResult);
                } else {
                    s2 = this.hasNextResult;
                }
                this.typeCache = Byte.valueOf(Byte.parseByte(s2, radix));
                return result;
            } catch (NumberFormatException e2) {
                return false;
            }
        }
        return result;
    }

    public byte nextByte() {
        return nextByte(this.defaultRadix);
    }

    public byte nextByte(int radix) {
        Object obj = this.typeCache;
        if (obj != null && (obj instanceof Byte) && this.radix == radix) {
            byte val = ((Byte) obj).byteValue();
            useTypeCache();
            return val;
        }
        setRadix(radix);
        clearCaches();
        try {
            String s2 = next(integerPattern());
            if (this.matcher.group(this.SIMPLE_GROUP_INDEX) == null) {
                s2 = processIntegerToken(s2);
            }
            return Byte.parseByte(s2, radix);
        } catch (NumberFormatException nfe) {
            this.position = this.matcher.start();
            throw new InputMismatchException(nfe.getMessage());
        }
    }

    public boolean hasNextShort() {
        return hasNextShort(this.defaultRadix);
    }

    public boolean hasNextShort(int radix) {
        String s2;
        setRadix(radix);
        boolean result = hasNext(integerPattern());
        if (result) {
            try {
                if (this.matcher.group(this.SIMPLE_GROUP_INDEX) == null) {
                    s2 = processIntegerToken(this.hasNextResult);
                } else {
                    s2 = this.hasNextResult;
                }
                this.typeCache = Short.valueOf(Short.parseShort(s2, radix));
                return result;
            } catch (NumberFormatException e2) {
                return false;
            }
        }
        return result;
    }

    public short nextShort() {
        return nextShort(this.defaultRadix);
    }

    public short nextShort(int radix) {
        Object obj = this.typeCache;
        if (obj != null && (obj instanceof Short) && this.radix == radix) {
            short val = ((Short) obj).shortValue();
            useTypeCache();
            return val;
        }
        setRadix(radix);
        clearCaches();
        try {
            String s2 = next(integerPattern());
            if (this.matcher.group(this.SIMPLE_GROUP_INDEX) == null) {
                s2 = processIntegerToken(s2);
            }
            return Short.parseShort(s2, radix);
        } catch (NumberFormatException nfe) {
            this.position = this.matcher.start();
            throw new InputMismatchException(nfe.getMessage());
        }
    }

    public boolean hasNextInt() {
        return hasNextInt(this.defaultRadix);
    }

    public boolean hasNextInt(int radix) {
        String s2;
        setRadix(radix);
        boolean result = hasNext(integerPattern());
        if (result) {
            try {
                if (this.matcher.group(this.SIMPLE_GROUP_INDEX) == null) {
                    s2 = processIntegerToken(this.hasNextResult);
                } else {
                    s2 = this.hasNextResult;
                }
                this.typeCache = Integer.valueOf(Integer.parseInt(s2, radix));
                return result;
            } catch (NumberFormatException e2) {
                return false;
            }
        }
        return result;
    }

    private String processIntegerToken(String token) {
        String result = token.replaceAll("" + this.groupSeparator, "");
        boolean isNegative = false;
        int preLen = this.negativePrefix.length();
        if (preLen > 0 && result.startsWith(this.negativePrefix)) {
            isNegative = true;
            result = result.substring(preLen);
        }
        int sufLen = this.negativeSuffix.length();
        if (sufLen > 0 && result.endsWith(this.negativeSuffix)) {
            isNegative = true;
            result = result.substring(result.length() - sufLen, result.length());
        }
        if (isNegative) {
            return "-" + result;
        }
        return result;
    }

    public int nextInt() {
        return nextInt(this.defaultRadix);
    }

    public int nextInt(int radix) {
        Object obj = this.typeCache;
        if (obj != null && (obj instanceof Integer) && this.radix == radix) {
            int val = ((Integer) obj).intValue();
            useTypeCache();
            return val;
        }
        setRadix(radix);
        clearCaches();
        try {
            String s2 = next(integerPattern());
            if (this.matcher.group(this.SIMPLE_GROUP_INDEX) == null) {
                s2 = processIntegerToken(s2);
            }
            return Integer.parseInt(s2, radix);
        } catch (NumberFormatException nfe) {
            this.position = this.matcher.start();
            throw new InputMismatchException(nfe.getMessage());
        }
    }

    public boolean hasNextLong() {
        return hasNextLong(this.defaultRadix);
    }

    public boolean hasNextLong(int radix) {
        String s2;
        setRadix(radix);
        boolean result = hasNext(integerPattern());
        if (result) {
            try {
                if (this.matcher.group(this.SIMPLE_GROUP_INDEX) == null) {
                    s2 = processIntegerToken(this.hasNextResult);
                } else {
                    s2 = this.hasNextResult;
                }
                this.typeCache = Long.valueOf(Long.parseLong(s2, radix));
                return result;
            } catch (NumberFormatException e2) {
                return false;
            }
        }
        return result;
    }

    public long nextLong() {
        return nextLong(this.defaultRadix);
    }

    public long nextLong(int radix) {
        Object obj = this.typeCache;
        if (obj != null && (obj instanceof Long) && this.radix == radix) {
            long val = ((Long) obj).longValue();
            useTypeCache();
            return val;
        }
        setRadix(radix);
        clearCaches();
        try {
            String s2 = next(integerPattern());
            if (this.matcher.group(this.SIMPLE_GROUP_INDEX) == null) {
                s2 = processIntegerToken(s2);
            }
            return Long.parseLong(s2, radix);
        } catch (NumberFormatException nfe) {
            this.position = this.matcher.start();
            throw new InputMismatchException(nfe.getMessage());
        }
    }

    private String processFloatToken(String token) {
        String result = token.replaceAll(this.groupSeparator, "");
        if (!this.decimalSeparator.equals("\\.")) {
            result = result.replaceAll(this.decimalSeparator, ".");
        }
        boolean isNegative = false;
        int preLen = this.negativePrefix.length();
        if (preLen > 0 && result.startsWith(this.negativePrefix)) {
            isNegative = true;
            result = result.substring(preLen);
        }
        int sufLen = this.negativeSuffix.length();
        if (sufLen > 0 && result.endsWith(this.negativeSuffix)) {
            isNegative = true;
            result = result.substring(result.length() - sufLen, result.length());
        }
        if (result.equals(this.nanString)) {
            result = "NaN";
        }
        if (result.equals(this.infinityString)) {
            result = "Infinity";
        }
        if (result.equals("∞")) {
            result = "Infinity";
        }
        if (isNegative) {
            result = "-" + result;
        }
        Matcher m10 = NON_ASCII_DIGIT.matcher(result);
        if (m10.find()) {
            StringBuilder inASCII = new StringBuilder();
            for (int i10 = 0; i10 < result.length(); i10++) {
                char nextChar = result.charAt(i10);
                if (Character.isDigit(nextChar)) {
                    int d10 = Character.digit(nextChar, 10);
                    if (d10 != -1) {
                        inASCII.append(d10);
                    } else {
                        inASCII.append(nextChar);
                    }
                } else {
                    inASCII.append(nextChar);
                }
            }
            return inASCII.toString();
        }
        return result;
    }

    public boolean hasNextFloat() {
        setRadix(10);
        boolean result = hasNext(floatPattern());
        if (result) {
            try {
                String s2 = processFloatToken(this.hasNextResult);
                this.typeCache = Float.valueOf(Float.parseFloat(s2));
                return result;
            } catch (NumberFormatException e2) {
                return false;
            }
        }
        return result;
    }

    public float nextFloat() {
        Object obj = this.typeCache;
        if (obj != null && (obj instanceof Float)) {
            float val = ((Float) obj).floatValue();
            useTypeCache();
            return val;
        }
        setRadix(10);
        clearCaches();
        try {
            return Float.parseFloat(processFloatToken(next(floatPattern())));
        } catch (NumberFormatException nfe) {
            this.position = this.matcher.start();
            throw new InputMismatchException(nfe.getMessage());
        }
    }

    public boolean hasNextDouble() {
        setRadix(10);
        boolean result = hasNext(floatPattern());
        if (result) {
            try {
                String s2 = processFloatToken(this.hasNextResult);
                this.typeCache = Double.valueOf(Double.parseDouble(s2));
                return result;
            } catch (NumberFormatException e2) {
                return false;
            }
        }
        return result;
    }

    public double nextDouble() {
        Object obj = this.typeCache;
        if (obj != null && (obj instanceof Double)) {
            double val = ((Double) obj).doubleValue();
            useTypeCache();
            return val;
        }
        setRadix(10);
        clearCaches();
        try {
            return Double.parseDouble(processFloatToken(next(floatPattern())));
        } catch (NumberFormatException nfe) {
            this.position = this.matcher.start();
            throw new InputMismatchException(nfe.getMessage());
        }
    }

    public boolean hasNextBigInteger() {
        return hasNextBigInteger(this.defaultRadix);
    }

    public boolean hasNextBigInteger(int radix) {
        String s2;
        setRadix(radix);
        boolean result = hasNext(integerPattern());
        if (result) {
            try {
                if (this.matcher.group(this.SIMPLE_GROUP_INDEX) == null) {
                    s2 = processIntegerToken(this.hasNextResult);
                } else {
                    s2 = this.hasNextResult;
                }
                this.typeCache = new BigInteger(s2, radix);
                return result;
            } catch (NumberFormatException e2) {
                return false;
            }
        }
        return result;
    }

    public BigInteger nextBigInteger() {
        return nextBigInteger(this.defaultRadix);
    }

    public BigInteger nextBigInteger(int radix) {
        Object obj = this.typeCache;
        if (obj != null && (obj instanceof BigInteger)) {
            BigInteger val = (BigInteger) obj;
            if (this.radix == radix) {
                useTypeCache();
                return val;
            }
        }
        setRadix(radix);
        clearCaches();
        try {
            String s2 = next(integerPattern());
            if (this.matcher.group(this.SIMPLE_GROUP_INDEX) == null) {
                s2 = processIntegerToken(s2);
            }
            return new BigInteger(s2, radix);
        } catch (NumberFormatException nfe) {
            this.position = this.matcher.start();
            throw new InputMismatchException(nfe.getMessage());
        }
    }

    public boolean hasNextBigDecimal() {
        setRadix(10);
        boolean result = hasNext(decimalPattern());
        if (result) {
            try {
                String s2 = processFloatToken(this.hasNextResult);
                this.typeCache = new BigDecimal(s2);
                return result;
            } catch (NumberFormatException e2) {
                return false;
            }
        }
        return result;
    }

    public BigDecimal nextBigDecimal() {
        Object obj = this.typeCache;
        if (obj != null && (obj instanceof BigDecimal)) {
            BigDecimal val = (BigDecimal) obj;
            useTypeCache();
            return val;
        }
        setRadix(10);
        clearCaches();
        try {
            String s2 = processFloatToken(next(decimalPattern()));
            return new BigDecimal(s2);
        } catch (NumberFormatException nfe) {
            this.position = this.matcher.start();
            throw new InputMismatchException(nfe.getMessage());
        }
    }

    public Scanner reset() {
        this.delimPattern = WHITESPACE_PATTERN;
        useLocale(Locale.getDefault(Locale.Category.FORMAT));
        useRadix(10);
        clearCaches();
        this.modCount++;
        return this;
    }

    public Stream<String> tokens() {
        ensureOpen();
        Stream<String> stream = StreamSupport.stream(new TokenSpliterator(), false);
        return (Stream) stream.onClose(new Scanner$$ExternalSyntheticLambda0(this));
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    class TokenSpliterator extends Spliterators.AbstractSpliterator<String> {
        int expectedCount;

        TokenSpliterator() {
            super(Long.MAX_VALUE, MetricsProto.MetricsEvent.ACTION_OUTPUT_CHOOSER_CONNECT);
            this.expectedCount = -1;
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super String> cons) {
            int i10 = this.expectedCount;
            if (i10 >= 0 && i10 != Scanner.this.modCount) {
                throw new ConcurrentModificationException();
            }
            if (Scanner.this.hasNext()) {
                String token = Scanner.this.next();
                this.expectedCount = Scanner.this.modCount;
                cons.accept(token);
                if (this.expectedCount != Scanner.this.modCount) {
                    throw new ConcurrentModificationException();
                }
                return true;
            }
            this.expectedCount = Scanner.this.modCount;
            return false;
        }
    }

    public Stream<MatchResult> findAll(Pattern pattern) {
        Objects.requireNonNull(pattern);
        ensureOpen();
        Stream<MatchResult> stream = StreamSupport.stream(new FindSpliterator(pattern), false);
        return (Stream) stream.onClose(new Scanner$$ExternalSyntheticLambda0(this));
    }

    public Stream<MatchResult> findAll(String patString) {
        Objects.requireNonNull(patString);
        ensureOpen();
        return findAll(this.patternCache.forName(patString));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class FindSpliterator extends Spliterators.AbstractSpliterator<MatchResult> {
        private boolean advance;
        int expectedCount;
        final Pattern pattern;

        FindSpliterator(Pattern pattern) {
            super(Long.MAX_VALUE, MetricsProto.MetricsEvent.ACTION_OUTPUT_CHOOSER_CONNECT);
            this.expectedCount = -1;
            this.advance = false;
            this.pattern = pattern;
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super MatchResult> cons) {
            Scanner.this.ensureOpen();
            int i10 = this.expectedCount;
            if (i10 >= 0) {
                if (i10 != Scanner.this.modCount) {
                    throw new ConcurrentModificationException();
                }
            } else {
                Scanner.this.matchValid = false;
                Scanner.this.matcher.usePattern(this.pattern);
                this.expectedCount = Scanner.this.modCount;
            }
            while (!nextInBuffer()) {
                if (!Scanner.this.needInput) {
                    return false;
                }
                Scanner.this.readInput();
            }
            cons.accept(Scanner.this.matcher.toMatchResult());
            if (this.expectedCount != Scanner.this.modCount) {
                throw new ConcurrentModificationException();
            }
            return true;
        }

        private boolean nextInBuffer() {
            if (this.advance) {
                if (Scanner.this.position + 1 > Scanner.this.buf.limit()) {
                    if (!Scanner.this.sourceClosed) {
                        Scanner.this.needInput = true;
                    }
                    return false;
                }
                Scanner.this.position++;
                this.advance = false;
            }
            Scanner.this.matcher.region(Scanner.this.position, Scanner.this.buf.limit());
            if (Scanner.this.matcher.find() && (!Scanner.this.matcher.hitEnd() || Scanner.this.sourceClosed)) {
                Scanner scanner = Scanner.this;
                scanner.position = scanner.matcher.end();
                this.advance = Scanner.this.matcher.start() == Scanner.this.position;
                return true;
            }
            if (!Scanner.this.sourceClosed) {
                Scanner.this.needInput = true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class PatternLRUCache {

        /* renamed from: oa, reason: collision with root package name */
        private Pattern[] f50482oa = null;
        private final int size;

        PatternLRUCache(int size) {
            this.size = size;
        }

        boolean hasName(Pattern p10, String s2) {
            return p10.pattern().equals(s2);
        }

        void moveToFront(Object[] oa2, int i10) {
            Object ob2 = oa2[i10];
            for (int j10 = i10; j10 > 0; j10--) {
                oa2[j10] = oa2[j10 - 1];
            }
            oa2[0] = ob2;
        }

        Pattern forName(String name) {
            if (this.f50482oa == null) {
                Pattern[] temp = new Pattern[this.size];
                this.f50482oa = temp;
            } else {
                int i10 = 0;
                while (true) {
                    Pattern[] patternArr = this.f50482oa;
                    if (i10 >= patternArr.length) {
                        break;
                    }
                    Pattern ob2 = patternArr[i10];
                    if (ob2 == null || !hasName(ob2, name)) {
                        i10++;
                    } else {
                        if (i10 > 0) {
                            moveToFront(this.f50482oa, i10);
                        }
                        return ob2;
                    }
                }
            }
            Pattern ob3 = Pattern.compile(name);
            Object[] objArr = this.f50482oa;
            objArr[objArr.length - 1] = ob3;
            moveToFront(objArr, objArr.length - 1);
            return ob3;
        }
    }
}
