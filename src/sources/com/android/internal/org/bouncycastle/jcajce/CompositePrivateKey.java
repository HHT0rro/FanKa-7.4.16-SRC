package com.android.internal.org.bouncycastle.jcajce;

import com.android.internal.org.bouncycastle.asn1.ASN1EncodableVector;
import com.android.internal.org.bouncycastle.asn1.ASN1Encoding;
import com.android.internal.org.bouncycastle.asn1.DERSequence;
import com.android.internal.org.bouncycastle.asn1.misc.MiscObjectIdentifiers;
import com.android.internal.org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import com.android.internal.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import java.io.IOException;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class CompositePrivateKey implements PrivateKey {
    private final List<PrivateKey> keys;

    public CompositePrivateKey(PrivateKey... keys) {
        if (keys == null || keys.length == 0) {
            throw new IllegalArgumentException("at least one public key must be provided");
        }
        List<PrivateKey> keyList = new ArrayList<>(keys.length);
        for (int i10 = 0; i10 != keys.length; i10++) {
            keyList.add(keys[i10]);
        }
        this.keys = Collections.unmodifiableList(keyList);
    }

    public List<PrivateKey> getPrivateKeys() {
        return this.keys;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "Composite";
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        ASN1EncodableVector v2 = new ASN1EncodableVector();
        for (int i10 = 0; i10 != this.keys.size(); i10++) {
            v2.add(PrivateKeyInfo.getInstance(this.keys.get(i10).getEncoded()));
        }
        try {
            return new PrivateKeyInfo(new AlgorithmIdentifier(MiscObjectIdentifiers.id_alg_composite), new DERSequence(v2)).getEncoded(ASN1Encoding.DER);
        } catch (IOException e2) {
            throw new IllegalStateException("unable to encode composite key: " + e2.getMessage());
        }
    }

    public int hashCode() {
        return this.keys.hashCode();
    }

    public boolean equals(Object o10) {
        if (o10 == this) {
            return true;
        }
        if (o10 instanceof CompositePrivateKey) {
            return this.keys.equals(((CompositePrivateKey) o10).keys);
        }
        return false;
    }
}
