package sun.security.x509;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class X509AttributeName {
    private static final char SEPARATOR = '.';
    private String prefix;
    private String suffix;

    public X509AttributeName(String name) {
        this.prefix = null;
        this.suffix = null;
        int i10 = name.indexOf(46);
        if (i10 < 0) {
            this.prefix = name;
        } else {
            this.prefix = name.substring(0, i10);
            this.suffix = name.substring(i10 + 1);
        }
    }

    public String getPrefix() {
        return this.prefix;
    }

    public String getSuffix() {
        return this.suffix;
    }
}
