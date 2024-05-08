package java.io;

import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class UncheckedIOException extends RuntimeException {
    private static final long serialVersionUID = -8134305061645241065L;

    public UncheckedIOException(String message, IOException cause) {
        super(message, (Throwable) Objects.requireNonNull(cause));
    }

    public UncheckedIOException(IOException cause) {
        super((Throwable) Objects.requireNonNull(cause));
    }

    @Override // java.lang.Throwable
    public IOException getCause() {
        return (IOException) super.getCause();
    }

    private void readObject(ObjectInputStream s2) throws IOException, ClassNotFoundException {
        s2.defaultReadObject();
        Throwable cause = super.getCause();
        if (!(cause instanceof IOException)) {
            throw new InvalidObjectException("Cause must be an IOException");
        }
    }
}
