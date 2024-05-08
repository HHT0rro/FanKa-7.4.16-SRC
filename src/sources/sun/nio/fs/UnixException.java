package sun.nio.fs;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileSystemException;
import java.nio.file.NoSuchFileException;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class UnixException extends Exception {
    static final long serialVersionUID = 7227016794320723218L;
    private int errno;
    private String msg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UnixException(int errno) {
        this.errno = errno;
        this.msg = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public UnixException(String msg) {
        this.errno = 0;
        this.msg = msg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int errno() {
        return this.errno;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setError(int errno) {
        this.errno = errno;
        this.msg = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String errorString() {
        String str = this.msg;
        if (str != null) {
            return str;
        }
        return Util.toString(UnixNativeDispatcher.strerror(errno()));
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return errorString();
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }

    private IOException translateToIOException(String file, String other) {
        String str = this.msg;
        if (str != null) {
            return new IOException(str);
        }
        if (errno() == UnixConstants.EACCES) {
            return new AccessDeniedException(file, other, null);
        }
        if (errno() == UnixConstants.ENOENT) {
            return new NoSuchFileException(file, other, null);
        }
        if (errno() == UnixConstants.EEXIST) {
            return new FileAlreadyExistsException(file, other, null);
        }
        if (errno() == UnixConstants.ELOOP) {
            return new FileSystemException(file, other, errorString() + " or unable to access attributes of symbolic link");
        }
        return new FileSystemException(file, other, errorString());
    }

    void rethrowAsIOException(String file) throws IOException {
        IOException x10 = translateToIOException(file, null);
        throw x10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void rethrowAsIOException(UnixPath file, UnixPath other) throws IOException {
        String a10 = file == null ? null : file.getPathForExceptionMessage();
        String b4 = other != null ? other.getPathForExceptionMessage() : null;
        IOException x10 = translateToIOException(a10, b4);
        throw x10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void rethrowAsIOException(UnixPath file) throws IOException {
        rethrowAsIOException(file, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IOException asIOException(UnixPath file) {
        return translateToIOException(file.getPathForExceptionMessage(), null);
    }
}
