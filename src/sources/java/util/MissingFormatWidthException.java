package java.util;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class MissingFormatWidthException extends IllegalFormatException {
    private static final long serialVersionUID = 15560123;

    /* renamed from: s, reason: collision with root package name */
    private String f50481s;

    public MissingFormatWidthException(String s2) {
        if (s2 == null) {
            throw new NullPointerException();
        }
        this.f50481s = s2;
    }

    public String getFormatSpecifier() {
        return this.f50481s;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f50481s;
    }
}
