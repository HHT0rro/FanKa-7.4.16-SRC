package java.util;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class StringTokenizer implements Enumeration<Object> {
    private int currentPosition;
    private int[] delimiterCodePoints;
    private String delimiters;
    private boolean delimsChanged;
    private boolean hasSurrogates;
    private int maxDelimCodePoint;
    private int maxPosition;
    private int newPosition;
    private boolean retDelims;
    private String str;

    private void setMaxDelimCodePoint() {
        if (this.delimiters == null) {
            this.maxDelimCodePoint = 0;
            return;
        }
        int m10 = 0;
        int count = 0;
        int i10 = 0;
        while (i10 < this.delimiters.length()) {
            int c4 = this.delimiters.charAt(i10);
            if (c4 >= 55296 && c4 <= 57343) {
                c4 = this.delimiters.codePointAt(i10);
                this.hasSurrogates = true;
            }
            if (m10 < c4) {
                m10 = c4;
            }
            count++;
            i10 += Character.charCount(c4);
        }
        this.maxDelimCodePoint = m10;
        if (this.hasSurrogates) {
            this.delimiterCodePoints = new int[count];
            int i11 = 0;
            int j10 = 0;
            while (i11 < count) {
                int c10 = this.delimiters.codePointAt(j10);
                this.delimiterCodePoints[i11] = c10;
                i11++;
                j10 += Character.charCount(c10);
            }
        }
    }

    public StringTokenizer(String str, String delim, boolean returnDelims) {
        this.hasSurrogates = false;
        this.currentPosition = 0;
        this.newPosition = -1;
        this.delimsChanged = false;
        this.str = str;
        this.maxPosition = str.length();
        this.delimiters = delim;
        this.retDelims = returnDelims;
        setMaxDelimCodePoint();
    }

    public StringTokenizer(String str, String delim) {
        this(str, delim, false);
    }

    public StringTokenizer(String str) {
        this(str, " \t\n\r\f", false);
    }

    private int skipDelimiters(int startPos) {
        if (this.delimiters == null) {
            throw new NullPointerException();
        }
        int position = startPos;
        while (!this.retDelims && position < this.maxPosition) {
            if (!this.hasSurrogates) {
                char c4 = this.str.charAt(position);
                if (c4 > this.maxDelimCodePoint || this.delimiters.indexOf(c4) < 0) {
                    break;
                }
                position++;
            } else {
                int c10 = this.str.codePointAt(position);
                if (c10 > this.maxDelimCodePoint || !isDelimiter(c10)) {
                    break;
                }
                position += Character.charCount(c10);
            }
        }
        return position;
    }

    private int scanToken(int startPos) {
        int position = startPos;
        while (position < this.maxPosition) {
            if (!this.hasSurrogates) {
                char c4 = this.str.charAt(position);
                if (c4 <= this.maxDelimCodePoint && this.delimiters.indexOf(c4) >= 0) {
                    break;
                }
                position++;
            } else {
                int c10 = this.str.codePointAt(position);
                if (c10 <= this.maxDelimCodePoint && isDelimiter(c10)) {
                    break;
                }
                position += Character.charCount(c10);
            }
        }
        if (this.retDelims && startPos == position) {
            if (!this.hasSurrogates) {
                char c11 = this.str.charAt(position);
                if (c11 <= this.maxDelimCodePoint && this.delimiters.indexOf(c11) >= 0) {
                    return position + 1;
                }
                return position;
            }
            int c12 = this.str.codePointAt(position);
            if (c12 <= this.maxDelimCodePoint && isDelimiter(c12)) {
                return position + Character.charCount(c12);
            }
            return position;
        }
        return position;
    }

    private boolean isDelimiter(int codePoint) {
        for (int delimiterCodePoint : this.delimiterCodePoints) {
            if (delimiterCodePoint == codePoint) {
                return true;
            }
        }
        return false;
    }

    public boolean hasMoreTokens() {
        int skipDelimiters = skipDelimiters(this.currentPosition);
        this.newPosition = skipDelimiters;
        return skipDelimiters < this.maxPosition;
    }

    public String nextToken() {
        int i10 = this.newPosition;
        if (i10 < 0 || this.delimsChanged) {
            i10 = skipDelimiters(this.currentPosition);
        }
        this.currentPosition = i10;
        this.delimsChanged = false;
        this.newPosition = -1;
        if (i10 >= this.maxPosition) {
            throw new NoSuchElementException();
        }
        int start = this.currentPosition;
        int scanToken = scanToken(i10);
        this.currentPosition = scanToken;
        return this.str.substring(start, scanToken);
    }

    public String nextToken(String delim) {
        this.delimiters = delim;
        this.delimsChanged = true;
        setMaxDelimCodePoint();
        return nextToken();
    }

    @Override // java.util.Enumeration
    public boolean hasMoreElements() {
        return hasMoreTokens();
    }

    @Override // java.util.Enumeration
    public Object nextElement() {
        return nextToken();
    }

    public int countTokens() {
        int currpos;
        int count = 0;
        int currpos2 = this.currentPosition;
        while (currpos2 < this.maxPosition && (currpos = skipDelimiters(currpos2)) < this.maxPosition) {
            currpos2 = scanToken(currpos);
            count++;
        }
        return count;
    }
}
