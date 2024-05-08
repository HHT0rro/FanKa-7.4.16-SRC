package com.android.internal.org.bouncycastle.jcajce;

import com.android.internal.org.bouncycastle.util.Selector;
import com.android.internal.org.bouncycastle.util.Store;
import com.android.internal.org.bouncycastle.util.StoreException;
import java.security.cert.Certificate;
import java.util.Collection;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface PKIXCertStore<T extends Certificate> extends Store<T> {
    @Override // com.android.internal.org.bouncycastle.util.Store
    Collection<T> getMatches(Selector<T> selector) throws StoreException;
}
