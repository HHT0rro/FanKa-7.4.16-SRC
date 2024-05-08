package java.util;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class FormatFlagsConversionMismatchException extends IllegalFormatException {
    private static final long serialVersionUID = 19120414;

    /* renamed from: c, reason: collision with root package name */
    private char f50463c;

    /* renamed from: f, reason: collision with root package name */
    private String f50464f;

    public FormatFlagsConversionMismatchException(String f10, char c4) {
        if (f10 == null) {
            throw new NullPointerException();
        }
        this.f50464f = f10;
        this.f50463c = c4;
    }

    public String getFlags() {
        return this.f50464f;
    }

    public char getConversion() {
        return this.f50463c;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return "Conversion = " + this.f50463c + ", Flags = " + this.f50464f;
    }
}
