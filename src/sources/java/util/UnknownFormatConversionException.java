package java.util;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class UnknownFormatConversionException extends IllegalFormatException {
    private static final long serialVersionUID = 19060418;

    /* renamed from: s, reason: collision with root package name */
    private String f50488s;

    public UnknownFormatConversionException(String s2) {
        if (s2 == null) {
            throw new NullPointerException();
        }
        this.f50488s = s2;
    }

    public String getConversion() {
        return this.f50488s;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return String.format("Conversion = '%s'", this.f50488s);
    }
}
