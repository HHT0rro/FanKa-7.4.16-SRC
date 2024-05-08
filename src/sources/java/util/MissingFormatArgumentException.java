package java.util;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class MissingFormatArgumentException extends IllegalFormatException {
    private static final long serialVersionUID = 19190115;

    /* renamed from: s, reason: collision with root package name */
    private String f50480s;

    public MissingFormatArgumentException(String s2) {
        if (s2 == null) {
            throw new NullPointerException();
        }
        this.f50480s = s2;
    }

    public String getFormatSpecifier() {
        return this.f50480s;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return "Format specifier '" + this.f50480s + "'";
    }
}
