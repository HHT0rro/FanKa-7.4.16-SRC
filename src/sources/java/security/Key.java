package java.security;

import java.io.Serializable;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface Key extends Serializable {

    @Deprecated
    public static final long serialVersionUID = 6603384152749567654L;

    String getAlgorithm();

    byte[] getEncoded();

    String getFormat();
}
