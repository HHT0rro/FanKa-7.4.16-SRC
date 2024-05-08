package com.android.internal.org.bouncycastle.util;

import java.util.Collection;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface Store<T> {
    Collection<T> getMatches(Selector<T> selector) throws StoreException;
}
