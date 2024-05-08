package javax.net.ssl;

import java.net.IDN;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.regex.Pattern;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class SNIHostName extends SNIServerName {
    private final String hostname;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public SNIHostName(java.lang.String r3) {
        /*
            r2 = this;
            java.lang.String r0 = "Server name value of host_name cannot be null"
            java.lang.Object r0 = java.util.Objects.requireNonNull(r3, r0)
            java.lang.String r0 = (java.lang.String) r0
            r1 = 2
            java.lang.String r0 = java.net.IDN.toASCII(r0, r1)
            r3 = r0
            java.nio.charset.Charset r1 = java.nio.charset.StandardCharsets.US_ASCII
            byte[] r0 = r0.getBytes(r1)
            r1 = 0
            r2.<init>(r1, r0)
            r2.hostname = r3
            r2.checkHostName()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.net.ssl.SNIHostName.<init>(java.lang.String):void");
    }

    public SNIHostName(byte[] encoded) {
        super(0, encoded);
        try {
            CharsetDecoder decoder = StandardCharsets.UTF_8.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT);
            this.hostname = IDN.toASCII(decoder.decode(ByteBuffer.wrap(encoded)).toString());
            checkHostName();
        } catch (RuntimeException | CharacterCodingException e2) {
            throw new IllegalArgumentException("The encoded server name value is invalid", e2);
        }
    }

    public String getAsciiName() {
        return this.hostname;
    }

    @Override // javax.net.ssl.SNIServerName
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof SNIHostName) {
            return this.hostname.equalsIgnoreCase(((SNIHostName) other).hostname);
        }
        return false;
    }

    @Override // javax.net.ssl.SNIServerName
    public int hashCode() {
        int result = (17 * 31) + this.hostname.toUpperCase(Locale.ENGLISH).hashCode();
        return result;
    }

    @Override // javax.net.ssl.SNIServerName
    public String toString() {
        return "type=host_name (0), value=" + this.hostname;
    }

    public static SNIMatcher createSNIMatcher(String regex) {
        if (regex == null) {
            throw new NullPointerException("The regular expression cannot be null");
        }
        return new SNIHostNameMatcher(regex);
    }

    private void checkHostName() {
        if (this.hostname.isEmpty()) {
            throw new IllegalArgumentException("Server name value of host_name cannot be empty");
        }
        if (this.hostname.endsWith(".")) {
            throw new IllegalArgumentException("Server name value of host_name cannot have the trailing dot");
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static final class SNIHostNameMatcher extends SNIMatcher {
        private final Pattern pattern;

        SNIHostNameMatcher(String regex) {
            super(0);
            this.pattern = Pattern.compile(regex, 2);
        }

        @Override // javax.net.ssl.SNIMatcher
        public boolean matches(SNIServerName serverName) {
            SNIHostName hostname;
            if (serverName == null) {
                throw new NullPointerException("The SNIServerName argument cannot be null");
            }
            if (!(serverName instanceof SNIHostName)) {
                if (serverName.getType() != 0) {
                    throw new IllegalArgumentException("The server name type is not host_name");
                }
                try {
                    hostname = new SNIHostName(serverName.getEncoded());
                } catch (IllegalArgumentException | NullPointerException e2) {
                    return false;
                }
            } else {
                hostname = (SNIHostName) serverName;
            }
            String asciiName = hostname.getAsciiName();
            if (this.pattern.matcher(asciiName).matches()) {
                return true;
            }
            return this.pattern.matcher(IDN.toUnicode(asciiName)).matches();
        }
    }
}
