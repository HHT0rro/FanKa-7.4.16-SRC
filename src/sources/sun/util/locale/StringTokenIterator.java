package sun.util.locale;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class StringTokenIterator {
    private char delimiterChar;
    private String dlms;
    private boolean done;
    private int end;
    private int start;
    private String text;
    private String token;

    public StringTokenIterator(String text, String dlms) {
        this.text = text;
        if (dlms.length() == 1) {
            this.delimiterChar = dlms.charAt(0);
        } else {
            this.dlms = dlms;
        }
        setStart(0);
    }

    public String first() {
        setStart(0);
        return this.token;
    }

    public String current() {
        return this.token;
    }

    public int currentStart() {
        return this.start;
    }

    public int currentEnd() {
        return this.end;
    }

    public boolean isDone() {
        return this.done;
    }

    public String next() {
        if (hasNext()) {
            int i10 = this.end + 1;
            this.start = i10;
            int nextDelimiter = nextDelimiter(i10);
            this.end = nextDelimiter;
            this.token = this.text.substring(this.start, nextDelimiter);
        } else {
            this.start = this.end;
            this.token = null;
            this.done = true;
        }
        return this.token;
    }

    public boolean hasNext() {
        return this.end < this.text.length();
    }

    public StringTokenIterator setStart(int offset) {
        if (offset > this.text.length()) {
            throw new IndexOutOfBoundsException();
        }
        this.start = offset;
        int nextDelimiter = nextDelimiter(offset);
        this.end = nextDelimiter;
        this.token = this.text.substring(this.start, nextDelimiter);
        this.done = false;
        return this;
    }

    public StringTokenIterator setText(String text) {
        this.text = text;
        setStart(0);
        return this;
    }

    private int nextDelimiter(int start) {
        int textlen = this.text.length();
        String str = this.dlms;
        if (str == null) {
            for (int idx = start; idx < textlen; idx++) {
                if (this.text.charAt(idx) == this.delimiterChar) {
                    return idx;
                }
            }
        } else {
            int dlmslen = str.length();
            for (int idx2 = start; idx2 < textlen; idx2++) {
                char c4 = this.text.charAt(idx2);
                for (int i10 = 0; i10 < dlmslen; i10++) {
                    if (c4 == this.dlms.charAt(i10)) {
                        return idx2;
                    }
                }
            }
        }
        return textlen;
    }
}
