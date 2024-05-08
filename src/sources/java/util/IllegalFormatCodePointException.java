package java.util;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class IllegalFormatCodePointException extends IllegalFormatException {
    private static final long serialVersionUID = 19080630;

    /* renamed from: c, reason: collision with root package name */
    private int f50470c;

    public IllegalFormatCodePointException(int c4) {
        this.f50470c = c4;
    }

    public int getCodePoint() {
        return this.f50470c;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return String.format("Code point = %#x", Integer.valueOf(this.f50470c));
    }
}
