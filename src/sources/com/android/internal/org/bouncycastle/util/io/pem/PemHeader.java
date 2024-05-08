package com.android.internal.org.bouncycastle.util.io.pem;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class PemHeader {
    private String name;
    private String value;

    public PemHeader(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        return getHashCode(this.name) + (getHashCode(this.value) * 31);
    }

    public boolean equals(Object o10) {
        if (!(o10 instanceof PemHeader)) {
            return false;
        }
        PemHeader other = (PemHeader) o10;
        return other == this || (isEqual(this.name, other.name) && isEqual(this.value, other.value));
    }

    private int getHashCode(String s2) {
        if (s2 == null) {
            return 1;
        }
        return s2.hashCode();
    }

    private boolean isEqual(String s12, String s2) {
        if (s12 == s2) {
            return true;
        }
        if (s12 == null || s2 == null) {
            return false;
        }
        return s12.equals(s2);
    }
}
