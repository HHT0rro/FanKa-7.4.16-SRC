package java.lang;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class StringIndexOutOfBoundsException extends IndexOutOfBoundsException {
    private static final long serialVersionUID = -6762910422159637258L;

    public StringIndexOutOfBoundsException() {
    }

    public StringIndexOutOfBoundsException(String s2) {
        super(s2);
    }

    public StringIndexOutOfBoundsException(int index) {
        super("String index out of range: " + index);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public StringIndexOutOfBoundsException(String s2, int index) {
        this(s2.length(), index);
    }

    StringIndexOutOfBoundsException(int sourceLength, int index) {
        super("length=" + sourceLength + "; index=" + index);
    }

    StringIndexOutOfBoundsException(String s2, int offset, int count) {
        this(s2.length(), offset, count);
    }

    StringIndexOutOfBoundsException(int sourceLength, int offset, int count) {
        super("length=" + sourceLength + "; regionStart=" + offset + "; regionLength=" + count);
    }
}
