package javax.crypto.interfaces;

import javax.crypto.SecretKey;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface PBEKey extends SecretKey {
    public static final long serialVersionUID = -1430015993304333921L;

    int getIterationCount();

    char[] getPassword();

    byte[] getSalt();
}
