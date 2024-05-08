package com.android.internal.org.bouncycastle.jce.interfaces;

import com.android.internal.org.bouncycastle.math.ec.ECPoint;
import java.security.PublicKey;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface ECPublicKey extends ECKey, PublicKey {
    ECPoint getQ();
}
