package com.android.internal.org.bouncycastle.asn1;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class OIDTokenizer {
    private int index = 0;
    private String oid;

    public OIDTokenizer(String oid) {
        this.oid = oid;
    }

    public boolean hasMoreTokens() {
        return this.index != -1;
    }

    public String nextToken() {
        int i10 = this.index;
        if (i10 == -1) {
            return null;
        }
        int end = this.oid.indexOf(46, i10);
        if (end == -1) {
            String token = this.oid.substring(this.index);
            this.index = -1;
            return token;
        }
        String token2 = this.oid.substring(this.index, end);
        this.index = end + 1;
        return token2;
    }
}
