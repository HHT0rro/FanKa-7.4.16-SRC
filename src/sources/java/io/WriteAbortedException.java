package java.io;

import com.tencent.connect.common.Constants;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class WriteAbortedException extends ObjectStreamException {
    private static final long serialVersionUID = -3326426625597282442L;

    @Deprecated(since = Constants.VIA_REPORT_TYPE_START_GROUP)
    public Exception detail;

    public WriteAbortedException(String s2, Exception ex) {
        super(s2);
        initCause(null);
        this.detail = ex;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        if (this.detail == null) {
            return super.getMessage();
        }
        return super.getMessage() + "; " + this.detail.toString();
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.detail;
    }
}
