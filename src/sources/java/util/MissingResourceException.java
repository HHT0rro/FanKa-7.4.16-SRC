package java.util;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class MissingResourceException extends RuntimeException {
    private static final long serialVersionUID = -4876345176062000401L;
    private String className;
    private String key;

    public MissingResourceException(String s2, String className, String key) {
        super(s2);
        this.className = className;
        this.key = key;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MissingResourceException(String message, String className, String key, Throwable cause) {
        super(message, cause);
        this.className = className;
        this.key = key;
    }

    public String getClassName() {
        return this.className;
    }

    public String getKey() {
        return this.key;
    }
}
