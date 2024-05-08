package com.android.internal.org.bouncycastle.jcajce.spec;

import com.android.internal.org.bouncycastle.util.Arrays;
import com.android.internal.org.bouncycastle.util.Strings;
import java.security.spec.EncodedKeySpec;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class OpenSSHPublicKeySpec extends EncodedKeySpec {
    private static final String[] allowedTypes = {"ssh-rsa", "ssh-ed25519", "ssh-dss"};
    private final String type;

    public OpenSSHPublicKeySpec(byte[] encodedKey) {
        super(encodedKey);
        int pos = 0 + 1;
        int i10 = (encodedKey[0] & 255) << 24;
        int pos2 = pos + 1;
        int i11 = i10 | ((encodedKey[pos] & 255) << 16);
        int pos3 = pos2 + 1;
        int i12 = i11 | ((encodedKey[pos2] & 255) << 8);
        int pos4 = pos3 + 1;
        int i13 = i12 | (encodedKey[pos3] & 255);
        if (pos4 + i13 >= encodedKey.length) {
            throw new IllegalArgumentException("invalid public key blob: type field longer than blob");
        }
        String fromByteArray = Strings.fromByteArray(Arrays.copyOfRange(encodedKey, pos4, pos4 + i13));
        this.type = fromByteArray;
        if (fromByteArray.startsWith("ecdsa")) {
            return;
        }
        int t2 = 0;
        while (true) {
            String[] strArr = allowedTypes;
            if (t2 < strArr.length) {
                if (!strArr[t2].equals(this.type)) {
                    t2++;
                } else {
                    return;
                }
            } else {
                throw new IllegalArgumentException("unrecognised public key type " + this.type);
            }
        }
    }

    @Override // java.security.spec.EncodedKeySpec
    public String getFormat() {
        return "OpenSSH";
    }

    public String getType() {
        return this.type;
    }
}
