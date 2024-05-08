package com.android.internal.org.bouncycastle.crypto;

import com.android.internal.org.bouncycastle.util.Strings;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public abstract class PBEParametersGenerator {
    protected int iterationCount;
    protected byte[] password;
    protected byte[] salt;

    public abstract CipherParameters generateDerivedMacParameters(int i10);

    public abstract CipherParameters generateDerivedParameters(int i10);

    public abstract CipherParameters generateDerivedParameters(int i10, int i11);

    public void init(byte[] password, byte[] salt, int iterationCount) {
        this.password = password;
        this.salt = salt;
        this.iterationCount = iterationCount;
    }

    public byte[] getPassword() {
        return this.password;
    }

    public byte[] getSalt() {
        return this.salt;
    }

    public int getIterationCount() {
        return this.iterationCount;
    }

    public static byte[] PKCS5PasswordToBytes(char[] password) {
        if (password != null) {
            byte[] bytes = new byte[password.length];
            for (int i10 = 0; i10 != bytes.length; i10++) {
                bytes[i10] = (byte) password[i10];
            }
            return bytes;
        }
        return new byte[0];
    }

    public static byte[] PKCS5PasswordToUTF8Bytes(char[] password) {
        if (password != null) {
            return Strings.toUTF8ByteArray(password);
        }
        return new byte[0];
    }

    public static byte[] PKCS12PasswordToBytes(char[] password) {
        if (password != null && password.length > 0) {
            byte[] bytes = new byte[(password.length + 1) * 2];
            for (int i10 = 0; i10 != password.length; i10++) {
                bytes[i10 * 2] = (byte) (password[i10] >>> '\b');
                bytes[(i10 * 2) + 1] = (byte) password[i10];
            }
            return bytes;
        }
        return new byte[0];
    }
}
