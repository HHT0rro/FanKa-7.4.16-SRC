package javax.crypto.spec;

import java.security.spec.KeySpec;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class PBEKeySpec implements KeySpec {
    private int iterationCount;
    private int keyLength;
    private char[] password;
    private byte[] salt;

    public PBEKeySpec(char[] password) {
        this.salt = null;
        this.iterationCount = 0;
        this.keyLength = 0;
        if (password == null || password.length == 0) {
            this.password = new char[0];
        } else {
            this.password = (char[]) password.clone();
        }
    }

    public PBEKeySpec(char[] password, byte[] salt, int iterationCount, int keyLength) {
        this.salt = null;
        this.iterationCount = 0;
        this.keyLength = 0;
        if (password == null || password.length == 0) {
            this.password = new char[0];
        } else {
            this.password = (char[]) password.clone();
        }
        if (salt == null) {
            throw new NullPointerException("the salt parameter must be non-null");
        }
        if (salt.length == 0) {
            throw new IllegalArgumentException("the salt parameter must not be empty");
        }
        this.salt = (byte[]) salt.clone();
        if (iterationCount <= 0) {
            throw new IllegalArgumentException("invalid iterationCount value");
        }
        if (keyLength <= 0) {
            throw new IllegalArgumentException("invalid keyLength value");
        }
        this.iterationCount = iterationCount;
        this.keyLength = keyLength;
    }

    public PBEKeySpec(char[] password, byte[] salt, int iterationCount) {
        this.salt = null;
        this.iterationCount = 0;
        this.keyLength = 0;
        if (password == null || password.length == 0) {
            this.password = new char[0];
        } else {
            this.password = (char[]) password.clone();
        }
        if (salt == null) {
            throw new NullPointerException("the salt parameter must be non-null");
        }
        if (salt.length == 0) {
            throw new IllegalArgumentException("the salt parameter must not be empty");
        }
        this.salt = (byte[]) salt.clone();
        if (iterationCount <= 0) {
            throw new IllegalArgumentException("invalid iterationCount value");
        }
        this.iterationCount = iterationCount;
    }

    public final void clearPassword() {
        char[] cArr = this.password;
        if (cArr != null) {
            Arrays.fill(cArr, ' ');
            this.password = null;
        }
    }

    public final char[] getPassword() {
        char[] cArr = this.password;
        if (cArr == null) {
            throw new IllegalStateException("password has been cleared");
        }
        return (char[]) cArr.clone();
    }

    public final byte[] getSalt() {
        byte[] bArr = this.salt;
        if (bArr != null) {
            return (byte[]) bArr.clone();
        }
        return null;
    }

    public final int getIterationCount() {
        return this.iterationCount;
    }

    public final int getKeyLength() {
        return this.keyLength;
    }
}
