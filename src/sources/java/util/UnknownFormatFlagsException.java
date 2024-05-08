package java.util;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class UnknownFormatFlagsException extends IllegalFormatException {
    private static final long serialVersionUID = 19370506;
    private String flags;

    public UnknownFormatFlagsException(String f10) {
        if (f10 == null) {
            throw new NullPointerException();
        }
        this.flags = f10;
    }

    public String getFlags() {
        return this.flags;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return "Flags = " + this.flags;
    }
}
