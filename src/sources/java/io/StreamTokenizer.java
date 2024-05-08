package java.io;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class StreamTokenizer {
    private static final byte CT_ALPHA = 4;
    private static final byte CT_COMMENT = 16;
    private static final byte CT_DIGIT = 2;
    private static final byte CT_QUOTE = 8;
    private static final byte CT_WHITESPACE = 1;
    private static final int NEED_CHAR = Integer.MAX_VALUE;
    private static final int SKIP_LF = 2147483646;
    public static final int TT_EOF = -1;
    public static final int TT_EOL = 10;
    private static final int TT_NOTHING = -4;
    public static final int TT_NUMBER = -2;
    public static final int TT_WORD = -3;
    private int LINENO;
    private char[] buf;
    private byte[] ctype;
    private boolean eolIsSignificantP;
    private boolean forceLower;
    private InputStream input;
    public double nval;
    private int peekc;
    private boolean pushedBack;
    private Reader reader;
    private boolean slashSlashCommentsP;
    private boolean slashStarCommentsP;
    public String sval;
    public int ttype;

    private StreamTokenizer() {
        this.reader = null;
        this.input = null;
        this.buf = new char[20];
        this.peekc = Integer.MAX_VALUE;
        this.LINENO = 1;
        this.eolIsSignificantP = false;
        this.slashSlashCommentsP = false;
        this.slashStarCommentsP = false;
        this.ctype = new byte[256];
        this.ttype = -4;
        wordChars(97, 122);
        wordChars(65, 90);
        wordChars(160, 255);
        whitespaceChars(0, 32);
        commentChar(47);
        quoteChar(34);
        quoteChar(39);
        parseNumbers();
    }

    @Deprecated
    public StreamTokenizer(InputStream is) {
        this();
        if (is == null) {
            throw new NullPointerException();
        }
        this.input = is;
    }

    public StreamTokenizer(Reader r10) {
        this();
        if (r10 == null) {
            throw new NullPointerException();
        }
        this.reader = r10;
    }

    public void resetSyntax() {
        int i10 = this.ctype.length;
        while (true) {
            i10--;
            if (i10 >= 0) {
                this.ctype[i10] = 0;
            } else {
                return;
            }
        }
    }

    public void wordChars(int low, int hi) {
        if (low < 0) {
            low = 0;
        }
        byte[] bArr = this.ctype;
        if (hi >= bArr.length) {
            hi = bArr.length - 1;
        }
        while (low <= hi) {
            byte[] bArr2 = this.ctype;
            bArr2[low] = (byte) (bArr2[low] | 4);
            low++;
        }
    }

    public void whitespaceChars(int low, int hi) {
        if (low < 0) {
            low = 0;
        }
        byte[] bArr = this.ctype;
        if (hi >= bArr.length) {
            hi = bArr.length - 1;
        }
        while (low <= hi) {
            this.ctype[low] = 1;
            low++;
        }
    }

    public void ordinaryChars(int low, int hi) {
        if (low < 0) {
            low = 0;
        }
        byte[] bArr = this.ctype;
        if (hi >= bArr.length) {
            hi = bArr.length - 1;
        }
        while (low <= hi) {
            this.ctype[low] = 0;
            low++;
        }
    }

    public void ordinaryChar(int ch) {
        if (ch >= 0) {
            byte[] bArr = this.ctype;
            if (ch < bArr.length) {
                bArr[ch] = 0;
            }
        }
    }

    public void commentChar(int ch) {
        if (ch >= 0) {
            byte[] bArr = this.ctype;
            if (ch < bArr.length) {
                bArr[ch] = 16;
            }
        }
    }

    public void quoteChar(int ch) {
        if (ch >= 0) {
            byte[] bArr = this.ctype;
            if (ch < bArr.length) {
                bArr[ch] = 8;
            }
        }
    }

    public void parseNumbers() {
        for (int i10 = 48; i10 <= 57; i10++) {
            byte[] bArr = this.ctype;
            bArr[i10] = (byte) (bArr[i10] | 2);
        }
        byte[] bArr2 = this.ctype;
        bArr2[46] = (byte) (bArr2[46] | 2);
        bArr2[45] = (byte) (bArr2[45] | 2);
    }

    public void eolIsSignificant(boolean flag) {
        this.eolIsSignificantP = flag;
    }

    public void slashStarComments(boolean flag) {
        this.slashStarCommentsP = flag;
    }

    public void slashSlashComments(boolean flag) {
        this.slashSlashCommentsP = flag;
    }

    public void lowerCaseMode(boolean fl) {
        this.forceLower = fl;
    }

    private int read() throws IOException {
        Reader reader = this.reader;
        if (reader != null) {
            return reader.read();
        }
        InputStream inputStream = this.input;
        if (inputStream != null) {
            return inputStream.read();
        }
        throw new IllegalStateException();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x018b, code lost:
    
        r4 = read();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int nextToken() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 634
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.io.StreamTokenizer.nextToken():int");
    }

    public void pushBack() {
        if (this.ttype != -4) {
            this.pushedBack = true;
        }
    }

    public int lineno() {
        return this.LINENO;
    }

    public String toString() {
        String ret;
        int i10 = this.ttype;
        switch (i10) {
            case -4:
                ret = "NOTHING";
                break;
            case -3:
                ret = this.sval;
                break;
            case -2:
                ret = "n=" + this.nval;
                break;
            case -1:
                ret = "EOF";
                break;
            case 10:
                ret = "EOL";
                break;
            default:
                if (i10 < 256 && (this.ctype[i10] & 8) != 0) {
                    ret = this.sval;
                    break;
                } else {
                    char[] s2 = {'\'', (char) i10, '\''};
                    ret = new String(s2);
                    break;
                }
        }
        return "Token[" + ret + "], line " + this.LINENO;
    }
}
