package com.android.internal.org.bouncycastle.jcajce.spec;

import java.security.spec.EncodedKeySpec;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class OpenSSHPrivateKeySpec extends EncodedKeySpec {
    private final String format;

    public OpenSSHPrivateKeySpec(byte[] encodedKey) {
        super(encodedKey);
        if (encodedKey[0] == 48) {
            this.format = "ASN.1";
        } else {
            if (encodedKey[0] == 111) {
                this.format = "OpenSSH";
                return;
            }
            throw new IllegalArgumentException("unknown byte encoding");
        }
    }

    @Override // java.security.spec.EncodedKeySpec
    public String getFormat() {
        return this.format;
    }
}
