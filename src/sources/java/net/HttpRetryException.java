package java.net;

import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class HttpRetryException extends IOException {
    private static final long serialVersionUID = -9186022286469111381L;
    private String location;
    private int responseCode;

    public HttpRetryException(String detail, int code) {
        super(detail);
        this.responseCode = code;
    }

    public HttpRetryException(String detail, int code, String location) {
        super(detail);
        this.responseCode = code;
        this.location = location;
    }

    public int responseCode() {
        return this.responseCode;
    }

    public String getReason() {
        return super.getMessage();
    }

    public String getLocation() {
        return this.location;
    }
}
