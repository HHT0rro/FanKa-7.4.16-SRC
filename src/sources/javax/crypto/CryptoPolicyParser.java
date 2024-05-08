package javax.crypto;

import java.io.IOException;
import java.io.Reader;
import java.security.GeneralSecurityException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
final class CryptoPolicyParser {
    CryptoPolicyParser() {
    }

    void read(Reader policy) throws ParsingException, IOException {
    }

    CryptoPermission[] getPermissions() {
        return null;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class ParsingException extends GeneralSecurityException {
        ParsingException(String msg) {
            super("");
        }

        ParsingException(int line, String msg) {
            super("");
        }

        ParsingException(int line, String expect, String actual) {
            super("");
        }
    }
}
