package com.android.internal.org.bouncycastle.x509;

import java.util.ArrayList;
import java.util.Collection;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class X509CollectionStoreParameters implements X509StoreParameters {
    private Collection collection;

    public X509CollectionStoreParameters(Collection collection) {
        if (collection == null) {
            throw new NullPointerException("collection cannot be null");
        }
        this.collection = collection;
    }

    public Object clone() {
        return new X509CollectionStoreParameters(this.collection);
    }

    public Collection getCollection() {
        return new ArrayList(this.collection);
    }

    public String toString() {
        StringBuffer sb2 = new StringBuffer();
        sb2.append("X509CollectionStoreParameters: [\n");
        sb2.append("  collection: " + ((Object) this.collection) + "\n");
        sb2.append("]");
        return sb2.toString();
    }
}
