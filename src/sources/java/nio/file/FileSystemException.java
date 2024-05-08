package java.nio.file;

import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class FileSystemException extends IOException {
    static final long serialVersionUID = -3055425747967319812L;
    private final String file;
    private final String other;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileSystemException(String file) {
        super((String) null);
        this.file = file;
        this.other = null;
    }

    public FileSystemException(String file, String other, String reason) {
        super(reason);
        this.file = file;
        this.other = other;
    }

    public String getFile() {
        return this.file;
    }

    public String getOtherFile() {
        return this.other;
    }

    public String getReason() {
        return super.getMessage();
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        if (this.file == null && this.other == null) {
            return getReason();
        }
        StringBuilder sb2 = new StringBuilder();
        String str = this.file;
        if (str != null) {
            sb2.append(str);
        }
        if (this.other != null) {
            sb2.append(" -> ");
            sb2.append(this.other);
        }
        if (getReason() != null) {
            sb2.append(": ");
            sb2.append(getReason());
        }
        return sb2.toString();
    }
}
