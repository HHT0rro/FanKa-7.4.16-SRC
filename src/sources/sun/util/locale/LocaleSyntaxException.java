package sun.util.locale;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class LocaleSyntaxException extends Exception {
    private static final long serialVersionUID = 1;
    private int index;

    public LocaleSyntaxException(String msg) {
        this(msg, 0);
    }

    public LocaleSyntaxException(String msg, int errorIndex) {
        super(msg);
        this.index = -1;
        this.index = errorIndex;
    }

    public int getErrorIndex() {
        return this.index;
    }
}
