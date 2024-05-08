package java.util;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class IllegalFormatPrecisionException extends IllegalFormatException {
    private static final long serialVersionUID = 18711008;

    /* renamed from: p, reason: collision with root package name */
    private int f50472p;

    public IllegalFormatPrecisionException(int p10) {
        this.f50472p = p10;
    }

    public int getPrecision() {
        return this.f50472p;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return Integer.toString(this.f50472p);
    }
}
