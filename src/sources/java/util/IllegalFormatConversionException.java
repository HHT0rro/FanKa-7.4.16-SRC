package java.util;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class IllegalFormatConversionException extends IllegalFormatException {
    private static final long serialVersionUID = 17000126;
    private Class<?> arg;

    /* renamed from: c, reason: collision with root package name */
    private char f50471c;

    public IllegalFormatConversionException(char c4, Class<?> arg) {
        if (arg == null) {
            throw new NullPointerException();
        }
        this.f50471c = c4;
        this.arg = arg;
    }

    public char getConversion() {
        return this.f50471c;
    }

    public Class<?> getArgumentClass() {
        return this.arg;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return String.format("%c != %s", Character.valueOf(this.f50471c), this.arg.getName());
    }
}
