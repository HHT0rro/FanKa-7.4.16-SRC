package java.util;

import androidx.exifinterface.media.ExifInterface;
import com.android.internal.accessibility.common.ShortcutConstants;
import com.android.internal.os.PowerProfile;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.kuaishou.weapon.p0.t;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Flushable;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import java.text.DateFormatSymbols;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.time.DateTimeException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQueries;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.util.Locale;
import jdk.internal.math.FormattedFloatingDecimal;
import libcore.icu.DecimalFormatData;
import libcore.icu.LocaleData;
import org.apache.commons.io.IOUtils;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class Formatter implements Closeable, Flushable {
    private static final int MAX_FD_CHARS = 30;
    private static double scaleUp;

    /* renamed from: a, reason: collision with root package name */
    private Appendable f50465a;

    /* renamed from: l, reason: collision with root package name */
    private final Locale f50466l;
    private IOException lastException;
    private final char zero;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public enum BigDecimalLayoutForm {
        SCIENTIFIC,
        DECIMAL_FLOAT
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public interface FormatString {
        int index();

        void print(Object obj, Locale locale) throws IOException;

        String toString();
    }

    private static Charset toCharset(String csn) throws UnsupportedEncodingException {
        Objects.requireNonNull(csn, "charsetName");
        try {
            return Charset.forName(csn);
        } catch (IllegalCharsetNameException | UnsupportedCharsetException e2) {
            throw new UnsupportedEncodingException(csn);
        }
    }

    private static final Appendable nonNullAppendable(Appendable a10) {
        if (a10 == null) {
            return new StringBuilder();
        }
        return a10;
    }

    private Formatter(Locale l10, Appendable a10) {
        this.f50465a = a10;
        this.f50466l = l10;
        this.zero = getZero(l10);
    }

    private Formatter(Charset charset, Locale l10, File file) throws FileNotFoundException {
        this(l10, new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), charset)));
    }

    public Formatter() {
        this(Locale.getDefault(Locale.Category.FORMAT), new StringBuilder());
    }

    public Formatter(Appendable a10) {
        this(Locale.getDefault(Locale.Category.FORMAT), nonNullAppendable(a10));
    }

    public Formatter(Locale l10) {
        this(l10, new StringBuilder());
    }

    public Formatter(Appendable a10, Locale l10) {
        this(l10, nonNullAppendable(a10));
    }

    public Formatter(String fileName) throws FileNotFoundException {
        this(Locale.getDefault(Locale.Category.FORMAT), new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName))));
    }

    public Formatter(String fileName, String csn) throws FileNotFoundException, UnsupportedEncodingException {
        this(fileName, csn, Locale.getDefault(Locale.Category.FORMAT));
    }

    public Formatter(String fileName, String csn, Locale l10) throws FileNotFoundException, UnsupportedEncodingException {
        this(toCharset(csn), l10, new File(fileName));
    }

    public Formatter(String fileName, Charset charset, Locale l10) throws IOException {
        this((Charset) Objects.requireNonNull(charset, "charset"), l10, new File(fileName));
    }

    public Formatter(File file) throws FileNotFoundException {
        this(Locale.getDefault(Locale.Category.FORMAT), new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file))));
    }

    public Formatter(File file, String csn) throws FileNotFoundException, UnsupportedEncodingException {
        this(file, csn, Locale.getDefault(Locale.Category.FORMAT));
    }

    public Formatter(File file, String csn, Locale l10) throws FileNotFoundException, UnsupportedEncodingException {
        this(toCharset(csn), l10, file);
    }

    public Formatter(File file, Charset charset, Locale l10) throws IOException {
        this((Charset) Objects.requireNonNull(charset, "charset"), l10, file);
    }

    public Formatter(PrintStream ps) {
        this(Locale.getDefault(Locale.Category.FORMAT), (Appendable) Objects.requireNonNull(ps));
    }

    public Formatter(OutputStream os) {
        this(Locale.getDefault(Locale.Category.FORMAT), new BufferedWriter(new OutputStreamWriter(os)));
    }

    public Formatter(OutputStream os, String csn) throws UnsupportedEncodingException {
        this(os, csn, Locale.getDefault(Locale.Category.FORMAT));
    }

    public Formatter(OutputStream os, String csn, Locale l10) throws UnsupportedEncodingException {
        this(l10, new BufferedWriter(new OutputStreamWriter(os, csn)));
    }

    public Formatter(OutputStream os, Charset charset, Locale l10) {
        this(l10, new BufferedWriter(new OutputStreamWriter(os, charset)));
    }

    private static char getZero(Locale l10) {
        if (l10 != null && !l10.equals(Locale.US)) {
            DecimalFormatData decimalFormatData = DecimalFormatData.getInstance(LocaleData.mapInvalidAndNullLocales(l10));
            return decimalFormatData.getZeroDigit();
        }
        return '0';
    }

    public Locale locale() {
        ensureOpen();
        return this.f50466l;
    }

    public Appendable out() {
        ensureOpen();
        return this.f50465a;
    }

    public String toString() {
        ensureOpen();
        return this.f50465a.toString();
    }

    @Override // java.io.Flushable
    public void flush() {
        ensureOpen();
        Appendable appendable = this.f50465a;
        if (appendable instanceof Flushable) {
            try {
                ((Flushable) appendable).flush();
            } catch (IOException ioe) {
                this.lastException = ioe;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Appendable appendable = this.f50465a;
        if (appendable == null) {
            return;
        }
        try {
            try {
                if (appendable instanceof Closeable) {
                    ((Closeable) appendable).close();
                }
            } catch (IOException ioe) {
                this.lastException = ioe;
            }
        } finally {
            this.f50465a = null;
        }
    }

    private void ensureOpen() {
        if (this.f50465a == null) {
            throw new FormatterClosedException();
        }
    }

    public IOException ioException() {
        return this.lastException;
    }

    public Formatter format(String format, Object... args) {
        return format(this.f50466l, format, args);
    }

    public Formatter format(Locale l10, String format, Object... args) {
        ensureOpen();
        int last = -1;
        int lasto = -1;
        List<FormatString> fsa = parse(format);
        for (FormatString fs : fsa) {
            int index = fs.index();
            Object obj = null;
            switch (index) {
                case -2:
                    fs.print(null, l10);
                    break;
                case -1:
                    if (last < 0 || (args != null && last > args.length - 1)) {
                        throw new MissingFormatArgumentException(fs.toString());
                    }
                    if (args != null) {
                        obj = args[last];
                    }
                    fs.print(obj, l10);
                    break;
                    break;
                case 0:
                    lasto++;
                    last = lasto;
                    if (args != null && lasto > args.length - 1) {
                        throw new MissingFormatArgumentException(fs.toString());
                    }
                    obj = args[lasto];
                    fs.print(obj, l10);
                    break;
                default:
                    last = index - 1;
                    if (args != null) {
                        try {
                            if (last > args.length - 1) {
                                throw new MissingFormatArgumentException(fs.toString());
                            }
                        } catch (IOException x10) {
                            this.lastException = x10;
                            break;
                        }
                    }
                    if (args != null) {
                        obj = args[last];
                    }
                    fs.print(obj, l10);
                    break;
            }
        }
        return this;
    }

    private List<FormatString> parse(String s2) {
        ArrayList<FormatString> al = new ArrayList<>();
        int i10 = 0;
        int len = s2.length();
        while (i10 < len) {
            int nextPercent = s2.indexOf(37, i10);
            if (s2.charAt(i10) != '%') {
                int plainTextStart = i10;
                int plainTextEnd = nextPercent == -1 ? len : nextPercent;
                al.add(new FixedString(s2, plainTextStart, plainTextEnd));
                i10 = plainTextEnd;
            } else {
                FormatSpecifierParser fsp = new FormatSpecifierParser(s2, i10 + 1);
                al.add(fsp.getFormatSpecifier());
                i10 = fsp.getEndIdx();
            }
        }
        return al;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class FormatSpecifierParser {
        private static final String FLAGS = ",-(+# 0<";
        private String conv;
        private int cursor;
        private String flags;
        private final String format;
        private FormatSpecifier fs;
        private String index;
        private String precision;
        private String tT;
        private String width;

        public FormatSpecifierParser(String format, int startIdx) {
            this.format = format;
            this.cursor = startIdx;
            if (nextIsInt()) {
                String nint = nextInt();
                if (peek() == '$') {
                    this.index = nint;
                    advance();
                } else if (nint.charAt(0) == '0') {
                    back(nint.length());
                } else {
                    this.width = nint;
                }
            }
            this.flags = "";
            while (this.width == null && FLAGS.indexOf(peek()) >= 0) {
                this.flags += advance();
            }
            if (this.width == null && nextIsInt()) {
                this.width = nextInt();
            }
            if (peek() == '.') {
                advance();
                if (!nextIsInt()) {
                    throw new IllegalFormatPrecisionException(peek());
                }
                this.precision = nextInt();
            }
            if (peek() == 't' || peek() == 'T') {
                this.tT = String.valueOf(advance());
            }
            this.conv = String.valueOf(advance());
            this.fs = new FormatSpecifier(this.index, this.flags, this.width, this.precision, this.tT, this.conv);
        }

        private String nextInt() {
            int strBegin = this.cursor;
            while (nextIsInt()) {
                advance();
            }
            return this.format.substring(strBegin, this.cursor);
        }

        private boolean nextIsInt() {
            return !isEnd() && Character.isDigit(peek());
        }

        private char peek() {
            if (isEnd()) {
                throw new UnknownFormatConversionException("End of String");
            }
            return this.format.charAt(this.cursor);
        }

        private char advance() {
            if (isEnd()) {
                throw new UnknownFormatConversionException("End of String");
            }
            String str = this.format;
            int i10 = this.cursor;
            this.cursor = i10 + 1;
            return str.charAt(i10);
        }

        private void back(int len) {
            this.cursor -= len;
        }

        private boolean isEnd() {
            return this.cursor == this.format.length();
        }

        public FormatSpecifier getFormatSpecifier() {
            return this.fs;
        }

        public int getEndIdx() {
            return this.cursor;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class FixedString implements FormatString {
        private int end;

        /* renamed from: s, reason: collision with root package name */
        private String f50467s;
        private int start;

        FixedString(String s2, int start, int end) {
            this.f50467s = s2;
            this.start = start;
            this.end = end;
        }

        @Override // java.util.Formatter.FormatString
        public int index() {
            return -2;
        }

        @Override // java.util.Formatter.FormatString
        public void print(Object arg, Locale l10) throws IOException {
            Formatter.this.f50465a.append(this.f50467s, this.start, this.end);
        }

        @Override // java.util.Formatter.FormatString
        public String toString() {
            return this.f50467s.substring(this.start, this.end);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class FormatSpecifier implements FormatString {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        /* renamed from: c, reason: collision with root package name */
        private char f50468c;
        private boolean dt;
        private int precision;
        private int width;
        private int index = -1;

        /* renamed from: f, reason: collision with root package name */
        private Flags f50469f = Flags.NONE;

        private int index(String s2) {
            if (s2 != null) {
                try {
                    this.index = Integer.parseInt(s2);
                } catch (NumberFormatException e2) {
                }
            } else {
                this.index = 0;
            }
            return this.index;
        }

        @Override // java.util.Formatter.FormatString
        public int index() {
            return this.index;
        }

        private Flags flags(String s2) {
            Flags parse = Flags.parse(s2, 0, s2.length());
            this.f50469f = parse;
            if (parse.contains(Flags.PREVIOUS)) {
                this.index = -1;
            }
            return this.f50469f;
        }

        private int width(String s2) {
            this.width = -1;
            if (s2 != null) {
                try {
                    int parseInt = Integer.parseInt(s2);
                    this.width = parseInt;
                    if (parseInt < 0) {
                        throw new IllegalFormatWidthException(parseInt);
                    }
                } catch (NumberFormatException e2) {
                }
            }
            return this.width;
        }

        private int precision(String s2) {
            this.precision = -1;
            if (s2 != null) {
                try {
                    int parseInt = Integer.parseInt(s2);
                    this.precision = parseInt;
                    if (parseInt < 0) {
                        throw new IllegalFormatPrecisionException(parseInt);
                    }
                } catch (NumberFormatException e2) {
                }
            }
            return this.precision;
        }

        private char conversion(char conv) {
            this.f50468c = conv;
            if (!this.dt) {
                if (!Conversion.isValid(conv)) {
                    throw new UnknownFormatConversionException(String.valueOf(this.f50468c));
                }
                if (Character.isUpperCase(this.f50468c)) {
                    this.f50469f.add(Flags.UPPERCASE);
                    this.f50468c = Character.toLowerCase(this.f50468c);
                }
                if (Conversion.isText(this.f50468c)) {
                    this.index = -2;
                }
            }
            return this.f50468c;
        }

        FormatSpecifier(String indexStr, String flagsStr, String widthStr, String precisionStr, String tTStr, String convStr) {
            this.dt = false;
            index(indexStr);
            flags(flagsStr);
            width(widthStr);
            precision(precisionStr);
            if (tTStr != null) {
                this.dt = true;
                if (tTStr.equals(ExifInterface.GPS_DIRECTION_TRUE)) {
                    this.f50469f.add(Flags.UPPERCASE);
                }
            }
            conversion(convStr.charAt(0));
            if (this.dt) {
                checkDateTime();
                return;
            }
            if (Conversion.isGeneral(this.f50468c)) {
                checkGeneral();
                return;
            }
            if (Conversion.isCharacter(this.f50468c)) {
                checkCharacter();
                return;
            }
            if (Conversion.isInteger(this.f50468c)) {
                checkInteger();
            } else if (Conversion.isFloat(this.f50468c)) {
                checkFloat();
            } else {
                if (Conversion.isText(this.f50468c)) {
                    checkText();
                    return;
                }
                throw new UnknownFormatConversionException(String.valueOf(this.f50468c));
            }
        }

        @Override // java.util.Formatter.FormatString
        public void print(Object arg, Locale l10) throws IOException {
            if (this.dt) {
                printDateTime(arg, l10);
                return;
            }
            switch (this.f50468c) {
                case '%':
                    print("%", l10);
                    return;
                case 'C':
                case 'c':
                    printCharacter(arg, l10);
                    return;
                case 'a':
                case 'e':
                case 'f':
                case 'g':
                    printFloat(arg, l10);
                    return;
                case 'b':
                    printBoolean(arg, l10);
                    return;
                case 'd':
                case 'o':
                case 'x':
                    printInteger(arg, l10);
                    return;
                case 'h':
                    printHashCode(arg, l10);
                    return;
                case 'n':
                    Formatter.this.f50465a.append(System.lineSeparator());
                    return;
                case 's':
                    printString(arg, l10);
                    return;
                default:
                    return;
            }
        }

        private void printInteger(Object arg, Locale l10) throws IOException {
            if (arg == null) {
                print("null", l10);
                return;
            }
            if (arg instanceof Byte) {
                print(((Byte) arg).byteValue(), l10);
                return;
            }
            if (arg instanceof Short) {
                print(((Short) arg).shortValue(), l10);
                return;
            }
            if (arg instanceof Integer) {
                print(((Integer) arg).intValue(), l10);
                return;
            }
            if (arg instanceof Long) {
                print(((Long) arg).longValue(), l10);
            } else if (arg instanceof BigInteger) {
                print((BigInteger) arg, l10);
            } else {
                failConversion(this.f50468c, arg);
            }
        }

        private void printFloat(Object arg, Locale l10) throws IOException {
            if (arg == null) {
                print("null", l10);
                return;
            }
            if (arg instanceof Float) {
                print(((Float) arg).floatValue(), l10);
                return;
            }
            if (arg instanceof Double) {
                print(((Double) arg).doubleValue(), l10);
            } else if (arg instanceof BigDecimal) {
                print((BigDecimal) arg, l10);
            } else {
                failConversion(this.f50468c, arg);
            }
        }

        private void printDateTime(Object arg, Locale l10) throws IOException {
            if (arg == null) {
                print("null", l10);
                return;
            }
            Calendar cal = null;
            if (arg instanceof Long) {
                cal = Calendar.getInstance(l10 == null ? Locale.US : l10);
                cal.setTimeInMillis(((Long) arg).longValue());
            } else if (arg instanceof Date) {
                cal = Calendar.getInstance(l10 == null ? Locale.US : l10);
                cal.setTime((Date) arg);
            } else if (arg instanceof Calendar) {
                cal = (Calendar) ((Calendar) arg).clone();
                cal.setLenient(true);
            } else {
                if (arg instanceof TemporalAccessor) {
                    print((TemporalAccessor) arg, this.f50468c, l10);
                    return;
                }
                failConversion(this.f50468c, arg);
            }
            print(cal, this.f50468c, l10);
        }

        private void printCharacter(Object arg, Locale l10) throws IOException {
            if (arg == null) {
                print("null", l10);
                return;
            }
            String s2 = null;
            if (arg instanceof Character) {
                s2 = ((Character) arg).toString();
            } else if (arg instanceof Byte) {
                byte i10 = ((Byte) arg).byteValue();
                if (Character.isValidCodePoint(i10)) {
                    s2 = new String(Character.toChars(i10));
                } else {
                    throw new IllegalFormatCodePointException(i10);
                }
            } else if (arg instanceof Short) {
                short i11 = ((Short) arg).shortValue();
                if (Character.isValidCodePoint(i11)) {
                    s2 = new String(Character.toChars(i11));
                } else {
                    throw new IllegalFormatCodePointException(i11);
                }
            } else if (arg instanceof Integer) {
                int i12 = ((Integer) arg).intValue();
                if (Character.isValidCodePoint(i12)) {
                    s2 = new String(Character.toChars(i12));
                } else {
                    throw new IllegalFormatCodePointException(i12);
                }
            } else {
                failConversion(this.f50468c, arg);
            }
            print(s2, l10);
        }

        private void printString(Object arg, Locale l10) throws IOException {
            if (arg instanceof Formattable) {
                Formatter fmt = Formatter.this;
                if (fmt.locale() != l10) {
                    fmt = new Formatter(fmt.out(), l10);
                }
                ((Formattable) arg).formatTo(fmt, this.f50469f.valueOf(), this.width, this.precision);
                return;
            }
            if (this.f50469f.contains(Flags.ALTERNATE)) {
                failMismatch(Flags.ALTERNATE, 's');
            }
            if (arg == null) {
                print("null", l10);
            } else {
                print(arg.toString(), l10);
            }
        }

        private void printBoolean(Object arg, Locale l10) throws IOException {
            String s2;
            if (arg != null) {
                if (arg instanceof Boolean) {
                    s2 = ((Boolean) arg).toString();
                } else {
                    s2 = Boolean.toString(true);
                }
            } else {
                s2 = Boolean.toString(false);
            }
            print(s2, l10);
        }

        private void printHashCode(Object arg, Locale l10) throws IOException {
            String s2;
            if (arg == null) {
                s2 = "null";
            } else {
                s2 = Integer.toHexString(arg.hashCode());
            }
            print(s2, l10);
        }

        private void print(String s2, Locale l10) throws IOException {
            int i10 = this.precision;
            if (i10 != -1 && i10 < s2.length()) {
                s2 = s2.substring(0, this.precision);
            }
            if (this.f50469f.contains(Flags.UPPERCASE)) {
                s2 = toUpperCaseWithLocale(s2, l10);
            }
            appendJustified(Formatter.this.f50465a, s2);
        }

        private String toUpperCaseWithLocale(String s2, Locale l10) {
            return s2.toUpperCase((Locale) Objects.requireNonNullElse(l10, Locale.getDefault(Locale.Category.FORMAT)));
        }

        private Appendable appendJustified(Appendable a10, CharSequence cs) throws IOException {
            if (this.width == -1) {
                return a10.append(cs);
            }
            boolean padRight = this.f50469f.contains(Flags.LEFT_JUSTIFY);
            int sp = this.width - cs.length();
            if (padRight) {
                a10.append(cs);
            }
            for (int i10 = 0; i10 < sp; i10++) {
                a10.append(' ');
            }
            if (!padRight) {
                a10.append(cs);
            }
            return a10;
        }

        @Override // java.util.Formatter.FormatString
        public String toString() {
            StringBuilder sb2 = new StringBuilder("%");
            Flags dupf = this.f50469f.dup().remove(Flags.UPPERCASE);
            sb2.append(dupf.toString());
            int i10 = this.index;
            if (i10 > 0) {
                sb2.append(i10).append('$');
            }
            int i11 = this.width;
            if (i11 != -1) {
                sb2.append(i11);
            }
            if (this.precision != -1) {
                sb2.append('.').append(this.precision);
            }
            if (this.dt) {
                sb2.append(this.f50469f.contains(Flags.UPPERCASE) ? 'T' : 't');
            }
            sb2.append(this.f50469f.contains(Flags.UPPERCASE) ? Character.toUpperCase(this.f50468c) : this.f50468c);
            return sb2.toString();
        }

        private void checkGeneral() {
            char c4 = this.f50468c;
            if ((c4 == 'b' || c4 == 'h') && this.f50469f.contains(Flags.ALTERNATE)) {
                failMismatch(Flags.ALTERNATE, this.f50468c);
            }
            if (this.width == -1 && this.f50469f.contains(Flags.LEFT_JUSTIFY)) {
                throw new MissingFormatWidthException(toString());
            }
            checkBadFlags(Flags.PLUS, Flags.LEADING_SPACE, Flags.ZERO_PAD, Flags.GROUP, Flags.PARENTHESES);
        }

        private void checkDateTime() {
            int i10 = this.precision;
            if (i10 != -1) {
                throw new IllegalFormatPrecisionException(i10);
            }
            if (!DateTime.isValid(this.f50468c)) {
                throw new UnknownFormatConversionException("t" + this.f50468c);
            }
            checkBadFlags(Flags.ALTERNATE, Flags.PLUS, Flags.LEADING_SPACE, Flags.ZERO_PAD, Flags.GROUP, Flags.PARENTHESES);
            if (this.width == -1 && this.f50469f.contains(Flags.LEFT_JUSTIFY)) {
                throw new MissingFormatWidthException(toString());
            }
        }

        private void checkCharacter() {
            int i10 = this.precision;
            if (i10 != -1) {
                throw new IllegalFormatPrecisionException(i10);
            }
            checkBadFlags(Flags.ALTERNATE, Flags.PLUS, Flags.LEADING_SPACE, Flags.ZERO_PAD, Flags.GROUP, Flags.PARENTHESES);
            if (this.width == -1 && this.f50469f.contains(Flags.LEFT_JUSTIFY)) {
                throw new MissingFormatWidthException(toString());
            }
        }

        private void checkInteger() {
            checkNumeric();
            int i10 = this.precision;
            if (i10 != -1) {
                throw new IllegalFormatPrecisionException(i10);
            }
            char c4 = this.f50468c;
            if (c4 == 'd') {
                checkBadFlags(Flags.ALTERNATE);
            } else if (c4 == 'o') {
                checkBadFlags(Flags.GROUP);
            } else {
                checkBadFlags(Flags.GROUP);
            }
        }

        private void checkBadFlags(Flags... badFlags) {
            for (Flags badFlag : badFlags) {
                if (this.f50469f.contains(badFlag)) {
                    failMismatch(badFlag, this.f50468c);
                }
            }
        }

        private void checkFloat() {
            checkNumeric();
            char c4 = this.f50468c;
            if (c4 != 'f') {
                if (c4 == 'a') {
                    checkBadFlags(Flags.PARENTHESES, Flags.GROUP);
                } else if (c4 == 'e') {
                    checkBadFlags(Flags.GROUP);
                } else if (c4 == 'g') {
                    checkBadFlags(Flags.ALTERNATE);
                }
            }
        }

        private void checkNumeric() {
            int i10 = this.width;
            if (i10 != -1 && i10 < 0) {
                throw new IllegalFormatWidthException(i10);
            }
            int i11 = this.precision;
            if (i11 != -1 && i11 < 0) {
                throw new IllegalFormatPrecisionException(i11);
            }
            if (i10 == -1 && (this.f50469f.contains(Flags.LEFT_JUSTIFY) || this.f50469f.contains(Flags.ZERO_PAD))) {
                throw new MissingFormatWidthException(toString());
            }
            if ((this.f50469f.contains(Flags.PLUS) && this.f50469f.contains(Flags.LEADING_SPACE)) || (this.f50469f.contains(Flags.LEFT_JUSTIFY) && this.f50469f.contains(Flags.ZERO_PAD))) {
                throw new IllegalFormatFlagsException(this.f50469f.toString());
            }
        }

        private void checkText() {
            int i10 = this.precision;
            if (i10 != -1) {
                throw new IllegalFormatPrecisionException(i10);
            }
            switch (this.f50468c) {
                case '%':
                    if (this.f50469f.valueOf() != Flags.LEFT_JUSTIFY.valueOf() && this.f50469f.valueOf() != Flags.NONE.valueOf()) {
                        throw new IllegalFormatFlagsException(this.f50469f.toString());
                    }
                    if (this.width == -1 && this.f50469f.contains(Flags.LEFT_JUSTIFY)) {
                        throw new MissingFormatWidthException(toString());
                    }
                    return;
                case 'n':
                    int i11 = this.width;
                    if (i11 != -1) {
                        throw new IllegalFormatWidthException(i11);
                    }
                    if (this.f50469f.valueOf() != Flags.NONE.valueOf()) {
                        throw new IllegalFormatFlagsException(this.f50469f.toString());
                    }
                    return;
                default:
                    return;
            }
        }

        private void print(byte value, Locale l10) throws IOException {
            char c4;
            long v2 = value;
            if (value < 0 && ((c4 = this.f50468c) == 'o' || c4 == 'x')) {
                v2 += 256;
            }
            print(v2, l10);
        }

        private void print(short value, Locale l10) throws IOException {
            char c4;
            long v2 = value;
            if (value < 0 && ((c4 = this.f50468c) == 'o' || c4 == 'x')) {
                v2 += 65536;
            }
            print(v2, l10);
        }

        private void print(int value, Locale l10) throws IOException {
            char c4;
            long v2 = value;
            if (value < 0 && ((c4 = this.f50468c) == 'o' || c4 == 'x')) {
                v2 += PowerProfile.SUBSYSTEM_MODEM;
            }
            print(v2, l10);
        }

        private void print(long value, Locale l10) throws IOException {
            int len;
            int len2;
            StringBuilder sb2 = new StringBuilder();
            char c4 = this.f50468c;
            if (c4 == 'd') {
                boolean neg = value < 0;
                String valueStr = Long.toString(value, 10);
                leadingSign(sb2, neg);
                int i10 = neg ? 1 : 0;
                Flags flags = this.f50469f;
                localizedMagnitude(sb2, valueStr, i10, flags, adjustWidth(this.width, flags, neg), l10);
                trailingSign(sb2, neg);
            } else if (c4 == 'o') {
                checkBadFlags(Flags.PARENTHESES, Flags.LEADING_SPACE, Flags.PLUS);
                String s2 = Long.toOctalString(value);
                if (this.f50469f.contains(Flags.ALTERNATE)) {
                    len2 = s2.length() + 1;
                } else {
                    len2 = s2.length();
                }
                if (this.f50469f.contains(Flags.ALTERNATE)) {
                    sb2.append('0');
                }
                if (this.f50469f.contains(Flags.ZERO_PAD)) {
                    trailingZeros(sb2, this.width - len2);
                }
                sb2.append(s2);
            } else if (c4 == 'x') {
                checkBadFlags(Flags.PARENTHESES, Flags.LEADING_SPACE, Flags.PLUS);
                String s10 = Long.toHexString(value);
                if (this.f50469f.contains(Flags.ALTERNATE)) {
                    len = s10.length() + 2;
                } else {
                    len = s10.length();
                }
                if (this.f50469f.contains(Flags.ALTERNATE)) {
                    sb2.append(this.f50469f.contains(Flags.UPPERCASE) ? "0X" : "0x");
                }
                if (this.f50469f.contains(Flags.ZERO_PAD)) {
                    trailingZeros(sb2, this.width - len);
                }
                if (this.f50469f.contains(Flags.UPPERCASE)) {
                    s10 = toUpperCaseWithLocale(s10, l10);
                }
                sb2.append(s10);
            }
            appendJustified(Formatter.this.f50465a, sb2);
        }

        private StringBuilder leadingSign(StringBuilder sb2, boolean neg) {
            if (!neg) {
                if (this.f50469f.contains(Flags.PLUS)) {
                    sb2.append('+');
                } else if (this.f50469f.contains(Flags.LEADING_SPACE)) {
                    sb2.append(' ');
                }
            } else if (this.f50469f.contains(Flags.PARENTHESES)) {
                sb2.append('(');
            } else {
                sb2.append('-');
            }
            return sb2;
        }

        private StringBuilder trailingSign(StringBuilder sb2, boolean neg) {
            if (neg && this.f50469f.contains(Flags.PARENTHESES)) {
                sb2.append(')');
            }
            return sb2;
        }

        private void print(BigInteger value, Locale l10) throws IOException {
            StringBuilder sb2 = new StringBuilder();
            boolean neg = value.signum() == -1;
            BigInteger v2 = value.abs();
            leadingSign(sb2, neg);
            char c4 = this.f50468c;
            if (c4 == 'd') {
                String bigInteger = v2.toString();
                Flags flags = this.f50469f;
                localizedMagnitude(sb2, bigInteger, 0, flags, adjustWidth(this.width, flags, neg), l10);
            } else if (c4 == 'o') {
                String s2 = v2.toString(8);
                int len = s2.length() + sb2.length();
                if (neg && this.f50469f.contains(Flags.PARENTHESES)) {
                    len++;
                }
                if (this.f50469f.contains(Flags.ALTERNATE)) {
                    len++;
                    sb2.append('0');
                }
                if (this.f50469f.contains(Flags.ZERO_PAD)) {
                    trailingZeros(sb2, this.width - len);
                }
                sb2.append(s2);
            } else if (c4 == 'x') {
                String s10 = v2.toString(16);
                int len2 = s10.length() + sb2.length();
                if (neg && this.f50469f.contains(Flags.PARENTHESES)) {
                    len2++;
                }
                if (this.f50469f.contains(Flags.ALTERNATE)) {
                    len2 += 2;
                    sb2.append(this.f50469f.contains(Flags.UPPERCASE) ? "0X" : "0x");
                }
                if (this.f50469f.contains(Flags.ZERO_PAD)) {
                    trailingZeros(sb2, this.width - len2);
                }
                if (this.f50469f.contains(Flags.UPPERCASE)) {
                    s10 = toUpperCaseWithLocale(s10, l10);
                }
                sb2.append(s10);
            }
            trailingSign(sb2, value.signum() == -1);
            appendJustified(Formatter.this.f50465a, sb2);
        }

        private void print(float value, Locale l10) throws IOException {
            print(value, l10);
        }

        private void print(double value, Locale l10) throws IOException {
            StringBuilder sb2 = new StringBuilder();
            boolean neg = Double.compare(value, ShadowDrawableWrapper.COS_45) == -1;
            if (!Double.isNaN(value)) {
                double v2 = Math.abs(value);
                leadingSign(sb2, neg);
                if (!Double.isInfinite(v2)) {
                    print(sb2, v2, l10, this.f50469f, this.f50468c, this.precision, neg);
                } else {
                    sb2.append(this.f50469f.contains(Flags.UPPERCASE) ? "INFINITY" : "Infinity");
                }
                trailingSign(sb2, neg);
            } else {
                sb2.append(this.f50469f.contains(Flags.UPPERCASE) ? "NAN" : "NaN");
            }
            appendJustified(Formatter.this.f50465a, sb2);
        }

        private void print(StringBuilder sb2, double value, Locale l10, Flags f10, char c4, int precision, boolean neg) throws IOException {
            int expRounded;
            char[] exp;
            int prec;
            int newW;
            int newW2;
            int newW3;
            String lowerCase;
            if (c4 == 'e') {
                int prec2 = precision != -1 ? precision : 6;
                FormattedFloatingDecimal fd2 = FormattedFloatingDecimal.valueOf(value, prec2, FormattedFloatingDecimal.Form.SCIENTIFIC);
                StringBuilder mant = new StringBuilder().append(fd2.getMantissa());
                addZeros(mant, prec2);
                if (f10.contains(Flags.ALTERNATE) && prec2 == 0) {
                    mant.append('.');
                }
                char[] exp2 = value == ShadowDrawableWrapper.COS_45 ? new char[]{'+', '0', '0'} : fd2.getExponent();
                int newW4 = this.width;
                if (this.width != -1) {
                    int newW5 = adjustWidth((r1 - exp2.length) - 1, f10, neg);
                    newW3 = newW5;
                } else {
                    newW3 = newW4;
                }
                int prec3 = newW3;
                localizedMagnitude(sb2, mant, 0, f10, prec3, l10);
                Locale separatorLocale = l10 != null ? l10 : Locale.getDefault();
                DecimalFormatData formatData = DecimalFormatData.getInstance(separatorLocale);
                if (f10.contains(Flags.UPPERCASE)) {
                    lowerCase = formatData.getExponentSeparator().toUpperCase(separatorLocale);
                } else {
                    lowerCase = formatData.getExponentSeparator().toLowerCase(separatorLocale);
                }
                sb2.append(lowerCase);
                char sign = exp2[0];
                sb2.append(sign);
                localizedMagnitudeExp(sb2, exp2, 1, l10);
                return;
            }
            if (c4 == 'f') {
                int prec4 = precision != -1 ? precision : 6;
                StringBuilder mant2 = new StringBuilder().append(FormattedFloatingDecimal.valueOf(value, prec4, FormattedFloatingDecimal.Form.DECIMAL_FLOAT).getMantissa());
                addZeros(mant2, prec4);
                if (f10.contains(Flags.ALTERNATE) && prec4 == 0) {
                    mant2.append('.');
                }
                int newW6 = this.width;
                int i10 = this.width;
                if (i10 != -1) {
                    int newW7 = adjustWidth(i10, f10, neg);
                    newW2 = newW7;
                } else {
                    newW2 = newW6;
                }
                localizedMagnitude(sb2, mant2, 0, f10, newW2, l10);
                return;
            }
            if (c4 != 'g') {
                if (c4 == 'a') {
                    int prec5 = precision;
                    if (precision == -1) {
                        prec5 = 0;
                    } else if (precision == 0) {
                        prec5 = 1;
                    }
                    String s2 = hexDouble(value, prec5);
                    StringBuilder va2 = new StringBuilder();
                    boolean upper = f10.contains(Flags.UPPERCASE);
                    sb2.append(upper ? "0X" : "0x");
                    if (f10.contains(Flags.ZERO_PAD)) {
                        trailingZeros(sb2, (this.width - s2.length()) - 2);
                    }
                    int idx = s2.indexOf(112);
                    if (upper) {
                        String tmp = s2.substring(0, idx);
                        va2.append(tmp.toUpperCase(Locale.ROOT));
                    } else {
                        va2.append((CharSequence) s2, 0, idx);
                    }
                    if (prec5 != 0) {
                        addZeros(va2, prec5);
                    }
                    sb2.append((CharSequence) va2);
                    sb2.append(upper ? 'P' : 'p');
                    sb2.append((CharSequence) s2, idx + 1, s2.length());
                    return;
                }
                return;
            }
            int prec6 = precision;
            if (precision == -1) {
                prec6 = 6;
            } else if (precision == 0) {
                prec6 = 1;
            }
            StringBuilder mant3 = new StringBuilder();
            if (value == ShadowDrawableWrapper.COS_45) {
                mant3.append('0');
                exp = null;
                expRounded = 0;
            } else {
                FormattedFloatingDecimal fd3 = FormattedFloatingDecimal.valueOf(value, prec6, FormattedFloatingDecimal.Form.GENERAL);
                char[] exp3 = fd3.getExponent();
                mant3.append(fd3.getMantissa());
                expRounded = fd3.getExponentRounded();
                exp = exp3;
            }
            if (exp != null) {
                prec = prec6 - 1;
            } else {
                prec = prec6 - (expRounded + 1);
            }
            addZeros(mant3, prec);
            if (f10.contains(Flags.ALTERNATE) && prec == 0) {
                mant3.append('.');
            }
            int newW8 = this.width;
            int i11 = this.width;
            if (i11 == -1) {
                newW = newW8;
            } else if (exp != null) {
                int newW9 = adjustWidth((i11 - exp.length) - 1, f10, neg);
                newW = newW9;
            } else {
                int newW10 = adjustWidth(i11, f10, neg);
                newW = newW10;
            }
            char[] exp4 = exp;
            localizedMagnitude(sb2, mant3, 0, f10, newW, l10);
            if (exp4 != null) {
                sb2.append(f10.contains(Flags.UPPERCASE) ? 'E' : 'e');
                char sign2 = exp4[0];
                sb2.append(sign2);
                localizedMagnitudeExp(sb2, exp4, 1, l10);
            }
        }

        private void addZeros(StringBuilder sb2, int prec) {
            int len = sb2.length();
            int i10 = 0;
            while (i10 < len && sb2.charAt(i10) != '.') {
                i10++;
            }
            int i11 = 0;
            if (i10 == len) {
                i11 = 1;
            }
            int outPrec = (len - i10) - (i11 ^ 1);
            if (outPrec == prec) {
                return;
            }
            if (i11 != 0) {
                sb2.append('.');
            }
            trailingZeros(sb2, prec - outPrec);
        }

        private String hexDouble(double d10, int prec) {
            double d11;
            if (!Double.isFinite(d10) || d10 == ShadowDrawableWrapper.COS_45 || prec == 0 || prec >= 13) {
                return Double.toHexString(d10).substring(2);
            }
            int exponent = Math.getExponent(d10);
            boolean subnormal = exponent == -1023;
            if (subnormal) {
                Formatter.scaleUp = Math.scalb(1.0d, 54);
                d11 = Formatter.scaleUp * d10;
                exponent = Math.getExponent(d11);
            } else {
                d11 = d10;
            }
            int precision = (prec * 4) + 1;
            int shiftDistance = 53 - precision;
            long doppel = Double.doubleToLongBits(d11);
            long newSignif = (Long.MAX_VALUE & doppel) >> shiftDistance;
            long roundingBits = (~((-1) << shiftDistance)) & doppel;
            boolean leastZero = (newSignif & 1) == 0;
            boolean round = ((1 << (shiftDistance + (-1))) & roundingBits) != 0;
            boolean sticky = shiftDistance > 1 && ((~(1 << (shiftDistance + (-1)))) & roundingBits) != 0;
            if ((leastZero && round && sticky) || (!leastZero && round)) {
                newSignif++;
            }
            long signBit = Long.MIN_VALUE & doppel;
            double result = Double.longBitsToDouble(signBit | (newSignif << shiftDistance));
            if (Double.isInfinite(result)) {
                return "1.0p1024";
            }
            String res = Double.toHexString(result).substring(2);
            if (!subnormal) {
                return res;
            }
            int idx = res.indexOf(112);
            if (idx == -1) {
                return null;
            }
            String exp = res.substring(idx + 1);
            int iexp = Integer.parseInt(exp) - 54;
            return res.substring(0, idx) + t.f36217b + Integer.toString(iexp);
        }

        private void print(BigDecimal value, Locale l10) throws IOException {
            char c4 = this.f50468c;
            if (c4 == 'a') {
                failConversion(c4, value);
            }
            StringBuilder sb2 = new StringBuilder();
            boolean neg = value.signum() == -1;
            BigDecimal v2 = value.abs();
            leadingSign(sb2, neg);
            print(sb2, v2, l10, this.f50469f, this.f50468c, this.precision, neg);
            trailingSign(sb2, neg);
            appendJustified(Formatter.this.f50465a, sb2);
        }

        private void print(StringBuilder sb2, BigDecimal value, Locale l10, Flags f10, char c4, int precision, boolean neg) throws IOException {
            int prec;
            int compPrec;
            int nzeros;
            BigDecimal value2 = value;
            if (c4 == 'e') {
                int prec2 = precision != -1 ? precision : 6;
                int scale = value.scale();
                int origPrec = value.precision();
                if (prec2 <= origPrec - 1) {
                    compPrec = 0;
                    nzeros = prec2 + 1;
                } else {
                    compPrec = prec2 - (origPrec - 1);
                    nzeros = origPrec;
                }
                MathContext mc2 = new MathContext(nzeros);
                BigDecimal v2 = new BigDecimal(value.unscaledValue(), scale, mc2);
                BigDecimalLayout bdl = new BigDecimalLayout(v2.unscaledValue(), v2.scale(), BigDecimalLayoutForm.SCIENTIFIC);
                StringBuilder mant = bdl.mantissa();
                if ((origPrec == 1 || !bdl.hasDot()) && (compPrec > 0 || f10.contains(Flags.ALTERNATE))) {
                    mant.append('.');
                }
                trailingZeros(mant, compPrec);
                StringBuilder exp = bdl.exponent();
                int newW = this.width;
                int i10 = this.width;
                int newW2 = newW;
                if (i10 != -1) {
                    newW2 = adjustWidth((i10 - exp.length()) - 1, f10, neg);
                }
                localizedMagnitude(sb2, mant, 0, f10, newW2, l10);
                sb2.append(f10.contains(Flags.UPPERCASE) ? 'E' : 'e');
                Flags flags = f10.dup().remove(Flags.GROUP);
                char sign = exp.charAt(0);
                sb2.append(sign);
                sb2.append((CharSequence) localizedMagnitude(null, exp, 1, flags, -1, l10));
                return;
            }
            if (c4 == 'f') {
                int prec3 = precision != -1 ? precision : 6;
                int scale2 = value.scale();
                if (scale2 > prec3) {
                    int compPrec2 = value.precision();
                    if (compPrec2 <= scale2) {
                        value2 = value2.setScale(prec3, RoundingMode.HALF_UP);
                    } else {
                        value2 = new BigDecimal(value.unscaledValue(), scale2, new MathContext(compPrec2 - (scale2 - prec3)));
                    }
                }
                BigDecimalLayout bdl2 = new BigDecimalLayout(value2.unscaledValue(), value2.scale(), BigDecimalLayoutForm.DECIMAL_FLOAT);
                StringBuilder mant2 = bdl2.mantissa();
                int nzeros2 = bdl2.scale() < prec3 ? prec3 - bdl2.scale() : 0;
                if (bdl2.scale() == 0 && (f10.contains(Flags.ALTERNATE) || nzeros2 > 0)) {
                    mant2.append('.');
                }
                trailingZeros(mant2, nzeros2);
                localizedMagnitude(sb2, mant2, 0, f10, adjustWidth(this.width, f10, neg), l10);
                return;
            }
            if (c4 == 'g') {
                if (precision == -1) {
                    prec = 6;
                } else if (precision != 0) {
                    prec = precision;
                } else {
                    prec = 1;
                }
                BigDecimal tenToTheNegFour = BigDecimal.valueOf(1L, 4);
                BigDecimal tenToThePrec = BigDecimal.valueOf(1L, -prec);
                if (!value2.equals(BigDecimal.ZERO) && (value2.compareTo(tenToTheNegFour) == -1 || value2.compareTo(tenToThePrec) != -1)) {
                    print(sb2, value, l10, f10, 'e', prec - 1, neg);
                    return;
                }
                int e2 = (-value.scale()) + (value.unscaledValue().toString().length() - 1);
                print(sb2, value, l10, f10, 'f', (prec - e2) - 1, neg);
                return;
            }
            if (c4 == 'a') {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        public class BigDecimalLayout {
            private boolean dot = false;
            private StringBuilder exp;
            private StringBuilder mant;
            private int scale;

            public BigDecimalLayout(BigInteger intVal, int scale, BigDecimalLayoutForm form) {
                layout(intVal, scale, form);
            }

            public boolean hasDot() {
                return this.dot;
            }

            public int scale() {
                return this.scale;
            }

            public StringBuilder mantissa() {
                return this.mant;
            }

            public StringBuilder exponent() {
                return this.exp;
            }

            private void layout(BigInteger intVal, int scale, BigDecimalLayoutForm form) {
                String coeff = intVal.toString();
                this.scale = scale;
                int len = coeff.length();
                StringBuilder sb2 = new StringBuilder(len + 14);
                this.mant = sb2;
                if (scale == 0) {
                    if (len > 1) {
                        sb2.append(coeff.charAt(0));
                        if (form == BigDecimalLayoutForm.SCIENTIFIC) {
                            this.mant.append('.');
                            this.dot = true;
                            this.mant.append((CharSequence) coeff, 1, len);
                            StringBuilder sb3 = new StringBuilder(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                            this.exp = sb3;
                            if (len < 10) {
                                sb3.append('0').append(len - 1);
                                return;
                            } else {
                                sb3.append(len - 1);
                                return;
                            }
                        }
                        this.mant.append((CharSequence) coeff, 1, len);
                        return;
                    }
                    sb2.append(coeff);
                    if (form == BigDecimalLayoutForm.SCIENTIFIC) {
                        this.exp = new StringBuilder("+00");
                        return;
                    }
                    return;
                }
                if (form == BigDecimalLayoutForm.DECIMAL_FLOAT) {
                    if (scale >= len) {
                        this.mant.append("0.");
                        this.dot = true;
                        FormatSpecifier.this.trailingZeros(this.mant, scale - len);
                        this.mant.append(coeff);
                        return;
                    }
                    if (scale > 0) {
                        int pad = len - scale;
                        this.mant.append((CharSequence) coeff, 0, pad);
                        this.mant.append('.');
                        this.dot = true;
                        this.mant.append((CharSequence) coeff, pad, len);
                        return;
                    }
                    this.mant.append((CharSequence) coeff, 0, len);
                    if (intVal.signum() != 0) {
                        FormatSpecifier.this.trailingZeros(this.mant, -scale);
                    }
                    this.scale = 0;
                    return;
                }
                this.mant.append(coeff.charAt(0));
                if (len > 1) {
                    this.mant.append('.');
                    this.dot = true;
                    this.mant.append((CharSequence) coeff, 1, len);
                }
                StringBuilder sb4 = new StringBuilder();
                this.exp = sb4;
                long adjusted = (-scale) + (len - 1);
                if (adjusted != 0) {
                    long abs = Math.abs(adjusted);
                    this.exp.append(adjusted < 0 ? '-' : '+');
                    if (abs < 10) {
                        this.exp.append('0');
                    }
                    this.exp.append(abs);
                    return;
                }
                sb4.append("+00");
            }
        }

        private int adjustWidth(int width, Flags f10, boolean neg) {
            if (width == -1 || !neg || !f10.contains(Flags.PARENTHESES)) {
                return width;
            }
            int newW = width - 1;
            return newW;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void trailingZeros(StringBuilder sb2, int nzeros) {
            for (int i10 = 0; i10 < nzeros; i10++) {
                sb2.append('0');
            }
        }

        private void print(Calendar t2, char c4, Locale l10) throws IOException {
            StringBuilder sb2 = new StringBuilder();
            print(sb2, t2, c4, l10);
            if (this.f50469f.contains(Flags.UPPERCASE)) {
                appendJustified(Formatter.this.f50465a, toUpperCaseWithLocale(sb2.toString(), l10));
            } else {
                appendJustified(Formatter.this.f50465a, sb2);
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:80:0x0302, code lost:
        
            return r11;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private java.lang.Appendable print(java.lang.StringBuilder r18, java.util.Calendar r19, char r20, java.util.Locale r21) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 906
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Formatter.FormatSpecifier.print(java.lang.StringBuilder, java.util.Calendar, char, java.util.Locale):java.lang.Appendable");
        }

        private void print(TemporalAccessor t2, char c4, Locale l10) throws IOException {
            StringBuilder sb2 = new StringBuilder();
            print(sb2, t2, c4, l10);
            if (this.f50469f.contains(Flags.UPPERCASE)) {
                appendJustified(Formatter.this.f50465a, toUpperCaseWithLocale(sb2.toString(), l10));
            } else {
                appendJustified(Formatter.this.f50465a, sb2);
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0016. Please report as an issue. */
        private Appendable print(StringBuilder sb2, TemporalAccessor t2, char c4, Locale l10) throws IOException {
            int i10;
            int size;
            Flags flags;
            if (sb2 == null) {
                sb2 = new StringBuilder();
            }
            try {
                switch (c4) {
                    case 'A':
                    case 'a':
                        int i11 = (t2.get(ChronoField.DAY_OF_WEEK) % 7) + 1;
                        Locale lt = (Locale) Objects.requireNonNullElse(l10, Locale.US);
                        DateFormatSymbols dfs = DateFormatSymbols.getInstance(lt);
                        if (c4 == 'A') {
                            sb2.append(dfs.getWeekdays()[i11]);
                        } else {
                            sb2.append(dfs.getShortWeekdays()[i11]);
                        }
                        return sb2;
                    case 'B':
                    case 'b':
                    case 'h':
                        int i12 = t2.get(ChronoField.MONTH_OF_YEAR) - 1;
                        Locale lt2 = (Locale) Objects.requireNonNullElse(l10, Locale.US);
                        DateFormatSymbols dfs2 = DateFormatSymbols.getInstance(lt2);
                        if (c4 == 'B') {
                            sb2.append(dfs2.getMonths()[i12]);
                        } else {
                            sb2.append(dfs2.getShortMonths()[i12]);
                        }
                        return sb2;
                    case 'C':
                    case 'Y':
                    case 'y':
                        int i13 = t2.get(ChronoField.YEAR_OF_ERA);
                        switch (c4) {
                            case 'C':
                                i13 /= 100;
                                size = 2;
                                break;
                            case 'Y':
                                size = 4;
                                break;
                            case 'y':
                                i13 %= 100;
                                size = 2;
                                break;
                            default:
                                size = 2;
                                break;
                        }
                        Flags flags2 = Flags.ZERO_PAD;
                        sb2.append((CharSequence) localizedMagnitude(null, i13, flags2, size, l10));
                        return sb2;
                    case 'D':
                        print(sb2, t2, 'm', l10).append(IOUtils.DIR_SEPARATOR_UNIX);
                        print(sb2, t2, 'd', l10).append(IOUtils.DIR_SEPARATOR_UNIX);
                        print(sb2, t2, 'y', l10);
                        return sb2;
                    case 'E':
                    case 'G':
                    case 'J':
                    case 'K':
                    case 'O':
                    case 'P':
                    case 'U':
                    case 'V':
                    case 'W':
                    case 'X':
                    case '[':
                    case '\\':
                    case ']':
                    case '^':
                    case '_':
                    case '`':
                    case 'f':
                    case 'g':
                    case 'i':
                    case 'n':
                    case 'o':
                    case 'q':
                    case 't':
                    case 'u':
                    case 'v':
                    case 'w':
                    case 'x':
                    default:
                        return sb2;
                    case 'F':
                        print(sb2, t2, 'Y', l10).append('-');
                        print(sb2, t2, 'm', l10).append('-');
                        print(sb2, t2, 'd', l10);
                        return sb2;
                    case 'H':
                        int i14 = t2.get(ChronoField.HOUR_OF_DAY);
                        sb2.append((CharSequence) localizedMagnitude(null, i14, Flags.ZERO_PAD, 2, l10));
                        return sb2;
                    case 'I':
                        int i15 = t2.get(ChronoField.CLOCK_HOUR_OF_AMPM);
                        sb2.append((CharSequence) localizedMagnitude(null, i15, Flags.ZERO_PAD, 2, l10));
                        return sb2;
                    case 'L':
                        int i16 = t2.get(ChronoField.MILLI_OF_SECOND);
                        Flags flags3 = Flags.ZERO_PAD;
                        sb2.append((CharSequence) localizedMagnitude(null, i16, flags3, 3, l10));
                        return sb2;
                    case 'M':
                        int i17 = t2.get(ChronoField.MINUTE_OF_HOUR);
                        Flags flags4 = Flags.ZERO_PAD;
                        sb2.append((CharSequence) localizedMagnitude(null, i17, flags4, 2, l10));
                        return sb2;
                    case 'N':
                        try {
                            i10 = t2.get(ChronoField.NANO_OF_SECOND);
                        } catch (UnsupportedTemporalTypeException e2) {
                            i10 = t2.get(ChronoField.MILLI_OF_SECOND) * 1000000;
                        }
                        Flags flags5 = Flags.ZERO_PAD;
                        sb2.append((CharSequence) localizedMagnitude(null, i10, flags5, 9, l10));
                        return sb2;
                    case 'Q':
                        long i18 = (t2.getLong(ChronoField.INSTANT_SECONDS) * 1000) + t2.getLong(ChronoField.MILLI_OF_SECOND);
                        Flags flags6 = Flags.NONE;
                        sb2.append((CharSequence) localizedMagnitude(null, i18, flags6, this.width, l10));
                        return sb2;
                    case 'R':
                    case 'T':
                        print(sb2, t2, 'H', l10).append(ShortcutConstants.SERVICES_SEPARATOR);
                        print(sb2, t2, 'M', l10);
                        if (c4 == 'T') {
                            sb2.append(ShortcutConstants.SERVICES_SEPARATOR);
                            print(sb2, t2, 'S', l10);
                        }
                        return sb2;
                    case 'S':
                        int i19 = t2.get(ChronoField.SECOND_OF_MINUTE);
                        Flags flags7 = Flags.ZERO_PAD;
                        sb2.append((CharSequence) localizedMagnitude(null, i19, flags7, 2, l10));
                        return sb2;
                    case 'Z':
                        ZoneId zid = (ZoneId) t2.query(TemporalQueries.zone());
                        if (zid == null) {
                            throw new IllegalFormatConversionException(c4, t2.getClass());
                        }
                        if (!(zid instanceof ZoneOffset) && t2.isSupported(ChronoField.INSTANT_SECONDS)) {
                            Instant instant = Instant.from(t2);
                            sb2.append(TimeZone.getTimeZone(zid.getId()).getDisplayName(zid.getRules().isDaylightSavings(instant), 0, (Locale) Objects.requireNonNullElse(l10, Locale.US)));
                        } else {
                            sb2.append(zid.getId());
                        }
                        return sb2;
                    case 'c':
                        print(sb2, t2, 'a', l10).append(' ');
                        print(sb2, t2, 'b', l10).append(' ');
                        print(sb2, t2, 'd', l10).append(' ');
                        print(sb2, t2, 'T', l10).append(' ');
                        print(sb2, t2, 'Z', l10).append(' ');
                        print(sb2, t2, 'Y', l10);
                        return sb2;
                    case 'd':
                    case 'e':
                        int i20 = t2.get(ChronoField.DAY_OF_MONTH);
                        if (c4 == 'd') {
                            flags = Flags.ZERO_PAD;
                        } else {
                            flags = Flags.NONE;
                        }
                        sb2.append((CharSequence) localizedMagnitude(null, i20, flags, 2, l10));
                        return sb2;
                    case 'j':
                        int i21 = t2.get(ChronoField.DAY_OF_YEAR);
                        Flags flags8 = Flags.ZERO_PAD;
                        sb2.append((CharSequence) localizedMagnitude(null, i21, flags8, 3, l10));
                        return sb2;
                    case 'k':
                        int i22 = t2.get(ChronoField.HOUR_OF_DAY);
                        sb2.append((CharSequence) localizedMagnitude(null, i22, Flags.NONE, 2, l10));
                        return sb2;
                    case 'l':
                        int i23 = t2.get(ChronoField.CLOCK_HOUR_OF_AMPM);
                        sb2.append((CharSequence) localizedMagnitude(null, i23, Flags.NONE, 2, l10));
                        return sb2;
                    case 'm':
                        int i24 = t2.get(ChronoField.MONTH_OF_YEAR);
                        Flags flags9 = Flags.ZERO_PAD;
                        sb2.append((CharSequence) localizedMagnitude(null, i24, flags9, 2, l10));
                        return sb2;
                    case 'p':
                        String[] ampm = {"AM", "PM"};
                        if (l10 != null && l10 != Locale.US) {
                            ampm = DateFormatSymbols.getInstance(l10).getAmPmStrings();
                        }
                        String s2 = ampm[t2.get(ChronoField.AMPM_OF_DAY)];
                        sb2.append(s2.toLowerCase((Locale) Objects.requireNonNullElse(l10, Locale.getDefault(Locale.Category.FORMAT))));
                        return sb2;
                    case 'r':
                        print(sb2, t2, 'I', l10).append(ShortcutConstants.SERVICES_SEPARATOR);
                        print(sb2, t2, 'M', l10).append(ShortcutConstants.SERVICES_SEPARATOR);
                        print(sb2, t2, 'S', l10).append(' ');
                        StringBuilder tsb = new StringBuilder();
                        print(tsb, t2, 'p', l10);
                        sb2.append(toUpperCaseWithLocale(tsb.toString(), l10));
                        return sb2;
                    case 's':
                        long i25 = t2.getLong(ChronoField.INSTANT_SECONDS);
                        Flags flags10 = Flags.NONE;
                        sb2.append((CharSequence) localizedMagnitude(null, i25, flags10, this.width, l10));
                        return sb2;
                    case 'z':
                        int i26 = t2.get(ChronoField.OFFSET_SECONDS);
                        boolean neg = i26 < 0;
                        sb2.append(neg ? '-' : '+');
                        if (neg) {
                            i26 = -i26;
                        }
                        int min = i26 / 60;
                        int offset = ((min / 60) * 100) + (min % 60);
                        Flags flags11 = Flags.ZERO_PAD;
                        sb2.append((CharSequence) localizedMagnitude(null, offset, flags11, 4, l10));
                        return sb2;
                }
            } catch (DateTimeException e10) {
                throw new IllegalFormatConversionException(c4, t2.getClass());
            }
        }

        private void failMismatch(Flags f10, char c4) {
            String fs = f10.toString();
            throw new FormatFlagsConversionMismatchException(fs, c4);
        }

        private void failConversion(char c4, Object arg) {
            throw new IllegalFormatConversionException(c4, arg.getClass());
        }

        private char getZero(Locale l10) {
            if (l10 != null && !l10.equals(Formatter.this.locale())) {
                DecimalFormatData decimalFormatData = DecimalFormatData.getInstance(LocaleData.mapInvalidAndNullLocales(l10));
                return decimalFormatData.getZeroDigit();
            }
            return Formatter.this.zero;
        }

        private StringBuilder localizedMagnitude(StringBuilder sb2, long value, Flags f10, int width, Locale l10) {
            return localizedMagnitude(sb2, Long.toString(value, 10), 0, f10, width, l10);
        }

        private StringBuilder localizedMagnitude(StringBuilder sb2, CharSequence value, int offset, Flags f10, int width, Locale l10) {
            StringBuilder sb3;
            CharSequence charSequence = value;
            if (sb2 != null) {
                sb3 = sb2;
            } else {
                sb3 = new StringBuilder();
            }
            int begin = sb3.length();
            char zero = getZero(l10);
            char grpSep = 0;
            int grpSize = -1;
            char decSep = 0;
            int len = value.length();
            int dot = len;
            int j10 = offset;
            while (true) {
                if (j10 >= len) {
                    break;
                }
                if (charSequence.charAt(j10) != '.') {
                    j10++;
                } else {
                    dot = j10;
                    break;
                }
            }
            if (dot < len) {
                if (l10 == null || l10.equals(Locale.US)) {
                    decSep = '.';
                } else {
                    DecimalFormatSymbols dfs = DecimalFormatSymbols.getInstance(l10);
                    decSep = dfs.getDecimalSeparator();
                }
            }
            if (f10.contains(Flags.GROUP)) {
                if (l10 == null || l10.equals(Locale.US)) {
                    grpSep = ',';
                    grpSize = 3;
                } else {
                    DecimalFormatSymbols dfs2 = DecimalFormatSymbols.getInstance(l10);
                    grpSep = dfs2.getGroupingSeparator();
                    DecimalFormat df = (DecimalFormat) NumberFormat.getIntegerInstance(l10);
                    grpSize = df.getGroupingSize();
                    if (!df.isGroupingUsed() || grpSize == 0) {
                        grpSep = 0;
                    }
                }
            }
            int j11 = offset;
            while (j11 < len) {
                if (j11 == dot) {
                    sb3.append(decSep);
                    grpSep = 0;
                } else {
                    char c4 = charSequence.charAt(j11);
                    sb3.append((char) ((c4 - '0') + zero));
                    if (grpSep != 0 && j11 != dot - 1 && (dot - j11) % grpSize == 1) {
                        sb3.append(grpSep);
                    }
                }
                j11++;
                charSequence = value;
            }
            if (width != -1 && f10.contains(Flags.ZERO_PAD)) {
                for (int k10 = sb3.length(); k10 < width; k10++) {
                    sb3.insert(begin, zero);
                }
            }
            return sb3;
        }

        private void localizedMagnitudeExp(StringBuilder sb2, char[] value, int offset, Locale l10) {
            char zero = getZero(l10);
            int len = value.length;
            for (int j10 = offset; j10 < len; j10++) {
                char c4 = value[j10];
                sb2.append((char) ((c4 - '0') + zero));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class Flags {
        private int flags;
        static final Flags NONE = new Flags(0);
        static final Flags LEFT_JUSTIFY = new Flags(1);
        static final Flags UPPERCASE = new Flags(2);
        static final Flags ALTERNATE = new Flags(4);
        static final Flags PLUS = new Flags(8);
        static final Flags LEADING_SPACE = new Flags(16);
        static final Flags ZERO_PAD = new Flags(32);
        static final Flags GROUP = new Flags(64);
        static final Flags PARENTHESES = new Flags(128);
        static final Flags PREVIOUS = new Flags(256);

        private Flags(int f10) {
            this.flags = f10;
        }

        public int valueOf() {
            return this.flags;
        }

        public boolean contains(Flags f10) {
            return (this.flags & f10.valueOf()) == f10.valueOf();
        }

        public Flags dup() {
            return new Flags(this.flags);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Flags add(Flags f10) {
            this.flags |= f10.valueOf();
            return this;
        }

        public Flags remove(Flags f10) {
            this.flags &= ~f10.valueOf();
            return this;
        }

        public static Flags parse(String s2, int start, int end) {
            Flags f10 = new Flags(0);
            for (int i10 = start; i10 < end; i10++) {
                char c4 = s2.charAt(i10);
                Flags v2 = parse(c4);
                if (f10.contains(v2)) {
                    throw new DuplicateFormatFlagsException(v2.toString());
                }
                f10.add(v2);
            }
            return f10;
        }

        private static Flags parse(char c4) {
            switch (c4) {
                case ' ':
                    return LEADING_SPACE;
                case '#':
                    return ALTERNATE;
                case '(':
                    return PARENTHESES;
                case '+':
                    return PLUS;
                case ',':
                    return GROUP;
                case '-':
                    return LEFT_JUSTIFY;
                case '0':
                    return ZERO_PAD;
                case '<':
                    return PREVIOUS;
                default:
                    throw new UnknownFormatFlagsException(String.valueOf(c4));
            }
        }

        public static String toString(Flags f10) {
            return f10.toString();
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            if (contains(LEFT_JUSTIFY)) {
                sb2.append('-');
            }
            if (contains(UPPERCASE)) {
                sb2.append('^');
            }
            if (contains(ALTERNATE)) {
                sb2.append('#');
            }
            if (contains(PLUS)) {
                sb2.append('+');
            }
            if (contains(LEADING_SPACE)) {
                sb2.append(' ');
            }
            if (contains(ZERO_PAD)) {
                sb2.append('0');
            }
            if (contains(GROUP)) {
                sb2.append(',');
            }
            if (contains(PARENTHESES)) {
                sb2.append('(');
            }
            if (contains(PREVIOUS)) {
                sb2.append('<');
            }
            return sb2.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class Conversion {
        static final char BOOLEAN = 'b';
        static final char BOOLEAN_UPPER = 'B';
        static final char CHARACTER = 'c';
        static final char CHARACTER_UPPER = 'C';
        static final char DATE_TIME = 't';
        static final char DATE_TIME_UPPER = 'T';
        static final char DECIMAL_FLOAT = 'f';
        static final char DECIMAL_INTEGER = 'd';
        static final char GENERAL = 'g';
        static final char GENERAL_UPPER = 'G';
        static final char HASHCODE = 'h';
        static final char HASHCODE_UPPER = 'H';
        static final char HEXADECIMAL_FLOAT = 'a';
        static final char HEXADECIMAL_FLOAT_UPPER = 'A';
        static final char HEXADECIMAL_INTEGER = 'x';
        static final char HEXADECIMAL_INTEGER_UPPER = 'X';
        static final char LINE_SEPARATOR = 'n';
        static final char OCTAL_INTEGER = 'o';
        static final char PERCENT_SIGN = '%';
        static final char SCIENTIFIC = 'e';
        static final char SCIENTIFIC_UPPER = 'E';
        static final char STRING = 's';
        static final char STRING_UPPER = 'S';

        private Conversion() {
        }

        static boolean isValid(char c4) {
            return isGeneral(c4) || isInteger(c4) || isFloat(c4) || isText(c4) || c4 == 't' || isCharacter(c4);
        }

        static boolean isGeneral(char c4) {
            switch (c4) {
                case 'B':
                case 'H':
                case 'S':
                case 'b':
                case 'h':
                case 's':
                    return true;
                default:
                    return false;
            }
        }

        static boolean isCharacter(char c4) {
            switch (c4) {
                case 'C':
                case 'c':
                    return true;
                default:
                    return false;
            }
        }

        static boolean isInteger(char c4) {
            switch (c4) {
                case 'X':
                case 'd':
                case 'o':
                case 'x':
                    return true;
                default:
                    return false;
            }
        }

        static boolean isFloat(char c4) {
            switch (c4) {
                case 'A':
                case 'E':
                case 'G':
                case 'a':
                case 'e':
                case 'f':
                case 'g':
                    return true;
                default:
                    return false;
            }
        }

        static boolean isText(char c4) {
            switch (c4) {
                case '%':
                case 'n':
                    return true;
                default:
                    return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class DateTime {
        static final char AM_PM = 'p';
        static final char CENTURY = 'C';
        static final char DATE = 'D';
        static final char DATE_TIME = 'c';
        static final char DAY_OF_MONTH = 'e';
        static final char DAY_OF_MONTH_0 = 'd';
        static final char DAY_OF_YEAR = 'j';
        static final char HOUR = 'l';
        static final char HOUR_0 = 'I';
        static final char HOUR_OF_DAY = 'k';
        static final char HOUR_OF_DAY_0 = 'H';
        static final char ISO_STANDARD_DATE = 'F';
        static final char MILLISECOND = 'L';
        static final char MILLISECOND_SINCE_EPOCH = 'Q';
        static final char MINUTE = 'M';
        static final char MONTH = 'm';
        static final char NAME_OF_DAY = 'A';
        static final char NAME_OF_DAY_ABBREV = 'a';
        static final char NAME_OF_MONTH = 'B';
        static final char NAME_OF_MONTH_ABBREV = 'b';
        static final char NAME_OF_MONTH_ABBREV_X = 'h';
        static final char NANOSECOND = 'N';
        static final char SECOND = 'S';
        static final char SECONDS_SINCE_EPOCH = 's';
        static final char TIME = 'T';
        static final char TIME_12_HOUR = 'r';
        static final char TIME_24_HOUR = 'R';
        static final char YEAR_2 = 'y';
        static final char YEAR_4 = 'Y';
        static final char ZONE = 'Z';
        static final char ZONE_NUMERIC = 'z';

        private DateTime() {
        }

        static boolean isValid(char c4) {
            switch (c4) {
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                case 'F':
                case 'H':
                case 'I':
                case 'L':
                case 'M':
                case 'N':
                case 'Q':
                case 'R':
                case 'S':
                case 'T':
                case 'Y':
                case 'Z':
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'h':
                case 'j':
                case 'k':
                case 'l':
                case 'm':
                case 'p':
                case 'r':
                case 's':
                case 'y':
                case 'z':
                    return true;
                case 'E':
                case 'G':
                case 'J':
                case 'K':
                case 'O':
                case 'P':
                case 'U':
                case 'V':
                case 'W':
                case 'X':
                case '[':
                case '\\':
                case ']':
                case '^':
                case '_':
                case '`':
                case 'f':
                case 'g':
                case 'i':
                case 'n':
                case 'o':
                case 'q':
                case 't':
                case 'u':
                case 'v':
                case 'w':
                case 'x':
                default:
                    return false;
            }
        }
    }
}
