package com.android.internal.org.bouncycastle.jcajce;

import com.android.internal.org.bouncycastle.crypto.PBEParametersGenerator;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class PKCS12Key implements PBKDFKey {
    private final char[] password;
    private final boolean useWrongZeroLengthConversion;

    public PKCS12Key(char[] password) {
        this(password, false);
    }

    public PKCS12Key(char[] password, boolean useWrongZeroLengthConversion) {
        password = password == null ? new char[0] : password;
        char[] cArr = new char[password.length];
        this.password = cArr;
        this.useWrongZeroLengthConversion = useWrongZeroLengthConversion;
        System.arraycopy((Object) password, 0, (Object) cArr, 0, password.length);
    }

    public char[] getPassword() {
        return this.password;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "PKCS12";
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS12";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        if (this.useWrongZeroLengthConversion && this.password.length == 0) {
            return new byte[2];
        }
        return PBEParametersGenerator.PKCS12PasswordToBytes(this.password);
    }
}
