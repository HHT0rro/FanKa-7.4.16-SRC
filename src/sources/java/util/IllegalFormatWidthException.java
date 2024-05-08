package java.util;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class IllegalFormatWidthException extends IllegalFormatException {
    private static final long serialVersionUID = 16660902;

    /* renamed from: w, reason: collision with root package name */
    private int f50473w;

    public IllegalFormatWidthException(int w3) {
        this.f50473w = w3;
    }

    public int getWidth() {
        return this.f50473w;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return Integer.toString(this.f50473w);
    }
}
