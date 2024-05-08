package sun.security.x509;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import sun.security.util.DerOutputStream;
import sun.security.util.DerValue;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class URIName implements GeneralNameInterface {
    private String host;
    private DNSName hostDNS;
    private IPAddressName hostIP;
    private URI uri;

    public URIName(DerValue derValue) throws IOException {
        this(derValue.getIA5String());
    }

    public URIName(String name) throws IOException {
        try {
            URI uri = new URI(name);
            this.uri = uri;
            if (uri.getScheme() == null) {
                throw new IOException("URI name must include scheme:" + name);
            }
            String host = this.uri.getHost();
            this.host = host;
            if (host != null) {
                if (host.charAt(0) == '[') {
                    String str = this.host;
                    String ipV6Host = str.substring(1, str.length() - 1);
                    try {
                        this.hostIP = new IPAddressName(ipV6Host);
                        return;
                    } catch (IOException e2) {
                        throw new IOException("invalid URI name (host portion is not a valid IPv6 address):" + name);
                    }
                }
                try {
                    this.hostDNS = new DNSName(this.host);
                } catch (IOException e10) {
                    try {
                        this.hostIP = new IPAddressName(this.host);
                    } catch (Exception e11) {
                        throw new IOException("invalid URI name (host portion is not a valid DNS name, IPv4 address, or IPv6 address):" + name);
                    }
                }
            }
        } catch (URISyntaxException use) {
            throw new IOException("invalid URI name:" + name, use);
        }
    }

    public static URIName nameConstraint(DerValue value) throws IOException {
        DNSName hostDNS;
        String name = value.getIA5String();
        try {
            URI uri = new URI(name);
            if (uri.getScheme() == null) {
                String host = uri.getSchemeSpecificPart();
                try {
                    if (host.startsWith(".")) {
                        hostDNS = new DNSName(host.substring(1));
                    } else {
                        hostDNS = new DNSName(host);
                    }
                    return new URIName(uri, host, hostDNS);
                } catch (IOException ioe) {
                    throw new IOException("invalid URI name constraint:" + name, ioe);
                }
            }
            throw new IOException("invalid URI name constraint (should not include scheme):" + name);
        } catch (URISyntaxException use) {
            throw new IOException("invalid URI name constraint:" + name, use);
        }
    }

    URIName(URI uri, String host, DNSName hostDNS) {
        this.uri = uri;
        this.host = host;
        this.hostDNS = hostDNS;
    }

    @Override // sun.security.x509.GeneralNameInterface
    public int getType() {
        return 6;
    }

    @Override // sun.security.x509.GeneralNameInterface
    public void encode(DerOutputStream out) throws IOException {
        out.putIA5String(this.uri.toASCIIString());
    }

    public String toString() {
        return "URIName: " + this.uri.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof URIName)) {
            return false;
        }
        URIName other = (URIName) obj;
        return this.uri.equals(other.getURI());
    }

    public URI getURI() {
        return this.uri;
    }

    public String getName() {
        return this.uri.toString();
    }

    public String getScheme() {
        return this.uri.getScheme();
    }

    public String getHost() {
        return this.host;
    }

    public Object getHostObject() {
        IPAddressName iPAddressName = this.hostIP;
        if (iPAddressName != null) {
            return iPAddressName;
        }
        return this.hostDNS;
    }

    public int hashCode() {
        return this.uri.hashCode();
    }

    @Override // sun.security.x509.GeneralNameInterface
    public int constrains(GeneralNameInterface inputName) throws UnsupportedOperationException {
        int constraintType;
        if (inputName == null || inputName.getType() != 6) {
            return -1;
        }
        String otherHost = ((URIName) inputName).getHost();
        if (otherHost.equalsIgnoreCase(this.host)) {
            return 0;
        }
        Object otherHostObject = ((URIName) inputName).getHostObject();
        if (this.hostDNS == null || !(otherHostObject instanceof DNSName)) {
            return 3;
        }
        boolean thisDomain = this.host.charAt(0) == '.';
        boolean otherDomain = otherHost.charAt(0) == '.';
        DNSName otherDNS = (DNSName) otherHostObject;
        int constraintType2 = this.hostDNS.constrains(otherDNS);
        if (!thisDomain && !otherDomain && (constraintType2 == 2 || constraintType2 == 1)) {
            constraintType = 3;
        } else {
            constraintType = constraintType2;
        }
        if (thisDomain != otherDomain && constraintType == 0) {
            if (thisDomain) {
                return 2;
            }
            return 1;
        }
        return constraintType;
    }

    @Override // sun.security.x509.GeneralNameInterface
    public int subtreeDepth() throws UnsupportedOperationException {
        try {
            DNSName dnsName = new DNSName(this.host);
            return dnsName.subtreeDepth();
        } catch (IOException ioe) {
            throw new UnsupportedOperationException(ioe.getMessage());
        }
    }
}
