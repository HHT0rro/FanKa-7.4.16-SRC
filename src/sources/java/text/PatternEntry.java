package java.text;

import com.huawei.appgallery.agd.common.constant.SymbolValues;
import org.apache.commons.io.IOUtils;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
class PatternEntry {
    static final int RESET = -2;
    static final int UNSET = -1;
    String chars;
    String extension;
    int strength;

    public void appendQuotedExtension(StringBuffer toAddTo) {
        appendQuoted(this.extension, toAddTo);
    }

    public void appendQuotedChars(StringBuffer toAddTo) {
        appendQuoted(this.chars, toAddTo);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        PatternEntry other = (PatternEntry) obj;
        boolean result = this.chars.equals(other.chars);
        return result;
    }

    public int hashCode() {
        return this.chars.hashCode();
    }

    public String toString() {
        StringBuffer result = new StringBuffer();
        addToBuffer(result, true, false, null);
        return result.toString();
    }

    final int getStrength() {
        return this.strength;
    }

    final String getExtension() {
        return this.extension;
    }

    final String getChars() {
        return this.chars;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addToBuffer(StringBuffer toAddTo, boolean showExtension, boolean showWhiteSpace, PatternEntry lastEntry) {
        if (showWhiteSpace && toAddTo.length() > 0) {
            if (this.strength == 0 || lastEntry != null) {
                toAddTo.append('\n');
            } else {
                toAddTo.append(' ');
            }
        }
        char c4 = SymbolValues.CHAR_AND_SYMBOL;
        if (lastEntry != null) {
            toAddTo.append(SymbolValues.CHAR_AND_SYMBOL);
            if (showWhiteSpace) {
                toAddTo.append(' ');
            }
            lastEntry.appendQuotedChars(toAddTo);
            appendQuotedExtension(toAddTo);
            if (showWhiteSpace) {
                toAddTo.append(' ');
            }
        }
        switch (this.strength) {
            case -2:
                break;
            case -1:
                c4 = '?';
                break;
            case 0:
                c4 = '<';
                break;
            case 1:
                c4 = ';';
                break;
            case 2:
                c4 = ',';
                break;
            case 3:
                c4 = '=';
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + this.strength);
        }
        toAddTo.append(c4);
        if (showWhiteSpace) {
            toAddTo.append(' ');
        }
        appendQuoted(this.chars, toAddTo);
        if (showExtension && !this.extension.isEmpty()) {
            toAddTo.append(IOUtils.DIR_SEPARATOR_UNIX);
            appendQuoted(this.extension, toAddTo);
        }
    }

    static void appendQuoted(String chars, StringBuffer toAddTo) {
        boolean inQuote = false;
        char ch = chars.charAt(0);
        if (Character.isSpaceChar(ch)) {
            inQuote = true;
            toAddTo.append('\'');
        } else if (isSpecialChar(ch)) {
            inQuote = true;
            toAddTo.append('\'');
        } else {
            switch (ch) {
                case '\t':
                case '\n':
                case '\f':
                case '\r':
                case 16:
                case '@':
                    inQuote = true;
                    toAddTo.append('\'');
                    break;
                case '\'':
                    inQuote = true;
                    toAddTo.append('\'');
                    break;
                default:
                    if (0 != 0) {
                        inQuote = false;
                        toAddTo.append('\'');
                        break;
                    }
                    break;
            }
        }
        toAddTo.append(chars);
        if (inQuote) {
            toAddTo.append('\'');
        }
    }

    PatternEntry(int strength, StringBuffer chars, StringBuffer extension) {
        this.strength = -1;
        this.chars = "";
        this.extension = "";
        this.strength = strength;
        this.chars = chars.toString();
        this.extension = extension.length() > 0 ? extension.toString() : "";
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static class Parser {
        private String pattern;
        private StringBuffer newChars = new StringBuffer();
        private StringBuffer newExtension = new StringBuffer();

        /* renamed from: i, reason: collision with root package name */
        private int f50418i = 0;

        public Parser(String pattern) {
            this.pattern = pattern;
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:20:0x0049. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0113 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:47:0x0115  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.text.PatternEntry next() throws java.text.ParseException {
            /*
                Method dump skipped, instructions count: 400
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: java.text.PatternEntry.Parser.next():java.text.PatternEntry");
        }
    }

    static boolean isSpecialChar(char ch) {
        return ch == ' ' || (ch <= '/' && ch >= '\"') || ((ch <= '?' && ch >= ':') || ((ch <= '`' && ch >= '[') || (ch <= '~' && ch >= '{')));
    }
}
