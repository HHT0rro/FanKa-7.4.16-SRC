package java.nio.file;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.ConcurrentModificationException;
import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class DirectoryIteratorException extends ConcurrentModificationException {
    private static final long serialVersionUID = -6012699886086212874L;

    public DirectoryIteratorException(IOException cause) {
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
