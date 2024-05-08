package com.android.internal.org.bouncycastle.jcajce.provider.asymmetric.util;

import com.android.internal.org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import com.android.internal.org.bouncycastle.crypto.params.DHParameters;
import com.android.internal.org.bouncycastle.crypto.params.DHPrivateKeyParameters;
import com.android.internal.org.bouncycastle.crypto.params.DHPublicKeyParameters;
import com.android.internal.org.bouncycastle.jcajce.provider.asymmetric.dh.BCDHPublicKey;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class DHUtil {
    public static AsymmetricKeyParameter generatePublicKeyParameter(PublicKey key) throws InvalidKeyException {
        if (key instanceof BCDHPublicKey) {
            return ((BCDHPublicKey) key).engineGetKeyParameters();
        }
        if (key instanceof DHPublicKey) {
            DHPublicKey k10 = (DHPublicKey) key;
            return new DHPublicKeyParameters(k10.getY(), new DHParameters(k10.getParams().getP(), k10.getParams().getG(), null, k10.getParams().getL()));
        }
        throw new InvalidKeyException("can't identify DH public key.");
    }

    public static AsymmetricKeyParameter generatePrivateKeyParameter(PrivateKey key) throws InvalidKeyException {
        if (key instanceof DHPrivateKey) {
            DHPrivateKey k10 = (DHPrivateKey) key;
            return new DHPrivateKeyParameters(k10.getX(), new DHParameters(k10.getParams().getP(), k10.getParams().getG(), null, k10.getParams().getL()));
        }
        throw new InvalidKeyException("can't identify DH private key.");
    }
}
