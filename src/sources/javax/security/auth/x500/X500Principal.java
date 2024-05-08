package javax.security.auth.x500;

import java.io.IOException;
import java.io.InputStream;
import java.io.NotActiveException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.Principal;
import java.util.Collections;
import java.util.Map;
import sun.security.util.DerValue;
import sun.security.util.ResourcesMgr;
import sun.security.x509.X500Name;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class X500Principal implements Principal, Serializable {
    public static final String CANONICAL = "CANONICAL";
    public static final String RFC1779 = "RFC1779";
    public static final String RFC2253 = "RFC2253";
    private static final long serialVersionUID = -500463348111345721L;
    private transient X500Name thisX500Name;

    X500Principal(X500Name x500Name) {
        this.thisX500Name = x500Name;
    }

    public X500Principal(String name) {
        this(name, Collections.emptyMap());
    }

    public X500Principal(String name, Map<String, String> keywordMap) {
        if (name == null) {
            throw new NullPointerException(ResourcesMgr.getString("provided.null.name"));
        }
        if (keywordMap == null) {
            throw new NullPointerException(ResourcesMgr.getString("provided.null.keyword.map"));
        }
        try {
            this.thisX500Name = new X500Name(name, keywordMap);
        } catch (Exception e2) {
            IllegalArgumentException iae = new IllegalArgumentException("improperly specified input name: " + name);
            iae.initCause(e2);
            throw iae;
        }
    }

    public X500Principal(byte[] name) {
        try {
            this.thisX500Name = new X500Name(name);
        } catch (Exception e2) {
            IllegalArgumentException iae = new IllegalArgumentException("improperly specified input name");
            iae.initCause(e2);
            throw iae;
        }
    }

    public X500Principal(InputStream is) {
        if (is == null) {
            throw new NullPointerException("provided null input stream");
        }
        try {
            if (is.markSupported()) {
                is.mark(is.available() + 1);
            }
            DerValue der = new DerValue(is);
            this.thisX500Name = new X500Name(der.data);
        } catch (Exception e2) {
            if (is.markSupported()) {
                try {
                    is.reset();
                } catch (IOException e10) {
                    IllegalArgumentException iae = new IllegalArgumentException("improperly specified input stream and unable to reset input stream");
                    iae.initCause(e2);
                    throw iae;
                }
            }
            IllegalArgumentException iae2 = new IllegalArgumentException("improperly specified input stream");
            iae2.initCause(e2);
            throw iae2;
        }
    }

    @Override // java.security.Principal
    public String getName() {
        return getName(RFC2253);
    }

    public String getName(String format) {
        if (format != null) {
            if (format.equalsIgnoreCase(RFC1779)) {
                return this.thisX500Name.getRFC1779Name();
            }
            if (format.equalsIgnoreCase(RFC2253)) {
                return this.thisX500Name.getRFC2253Name();
            }
            if (format.equalsIgnoreCase(CANONICAL)) {
                return this.thisX500Name.getRFC2253CanonicalName();
            }
        }
        throw new IllegalArgumentException("invalid format specified");
    }

    public String getName(String format, Map<String, String> oidMap) {
        if (oidMap == null) {
            throw new NullPointerException(ResourcesMgr.getString("provided.null.OID.map"));
        }
        if (format != null) {
            if (format.equalsIgnoreCase(RFC1779)) {
                return this.thisX500Name.getRFC1779Name(oidMap);
            }
            if (format.equalsIgnoreCase(RFC2253)) {
                return this.thisX500Name.getRFC2253Name(oidMap);
            }
        }
        throw new IllegalArgumentException("invalid format specified");
    }

    public byte[] getEncoded() {
        try {
            return this.thisX500Name.getEncoded();
        } catch (IOException e2) {
            throw new RuntimeException("unable to get encoding", e2);
        }
    }

    @Override // java.security.Principal
    public String toString() {
        return this.thisX500Name.toString();
    }

    @Override // java.security.Principal
    public boolean equals(Object o10) {
        if (this == o10) {
            return true;
        }
        if (!(o10 instanceof X500Principal)) {
            return false;
        }
        X500Principal other = (X500Principal) o10;
        return this.thisX500Name.equals(other.thisX500Name);
    }

    @Override // java.security.Principal
    public int hashCode() {
        return this.thisX500Name.hashCode();
    }

    private void writeObject(ObjectOutputStream s2) throws IOException {
        s2.writeObject(this.thisX500Name.getEncodedInternal());
    }

    private void readObject(ObjectInputStream s2) throws IOException, NotActiveException, ClassNotFoundException {
        this.thisX500Name = new X500Name((byte[]) s2.readObject());
    }
}
