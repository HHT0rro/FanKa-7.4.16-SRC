package java.io;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class OptionalDataException extends ObjectStreamException {
    private static final long serialVersionUID = -8011121865681257820L;
    public boolean eof;
    public int length;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OptionalDataException(int len) {
        this.eof = false;
        this.length = len;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OptionalDataException(boolean end) {
        this.length = 0;
        this.eof = end;
    }
}
