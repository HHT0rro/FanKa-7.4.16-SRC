package java.nio.charset;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class UnmappableCharacterException extends CharacterCodingException {
    private static final long serialVersionUID = -7026962371537706123L;
    private int inputLength;

    public UnmappableCharacterException(int inputLength) {
        this.inputLength = inputLength;
    }

    public int getInputLength() {
        return this.inputLength;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return "Input length = " + this.inputLength;
    }
}
