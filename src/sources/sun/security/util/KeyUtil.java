package sun.security.util;

import java.security.Key;
import java.security.interfaces.DSAKey;
import java.security.interfaces.DSAParams;
import java.security.interfaces.ECKey;
import java.security.interfaces.RSAKey;
import java.security.spec.ECParameterSpec;
import javax.crypto.SecretKey;
import javax.crypto.interfaces.DHKey;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class KeyUtil {
    public static final int getKeySize(Key key) {
        int size = -1;
        if (key instanceof Length) {
            try {
                Length ruler = (Length) key;
                size = ruler.length();
            } catch (UnsupportedOperationException e2) {
            }
            if (size >= 0) {
                return size;
            }
        }
        if (key instanceof SecretKey) {
            SecretKey sk = (SecretKey) key;
            String format = sk.getFormat();
            if ("RAW".equals(format) && sk.getEncoded() != null) {
                return sk.getEncoded().length * 8;
            }
            return size;
        }
        if (key instanceof RSAKey) {
            RSAKey pubk = (RSAKey) key;
            return pubk.getModulus().bitLength();
        }
        if (key instanceof ECKey) {
            ECKey pubk2 = (ECKey) key;
            ECParameterSpec params = pubk2.getParams();
            if (params != null) {
                return params.getOrder().bitLength();
            }
            return size;
        }
        if (key instanceof DSAKey) {
            DSAKey pubk3 = (DSAKey) key;
            DSAParams params2 = pubk3.getParams();
            return params2 != null ? params2.getP().bitLength() : -1;
        }
        if (key instanceof DHKey) {
            DHKey pubk4 = (DHKey) key;
            return pubk4.getParams().getP().bitLength();
        }
        return size;
    }
}
