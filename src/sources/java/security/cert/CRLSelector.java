package java.security.cert;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface CRLSelector extends Cloneable {
    Object clone();

    boolean match(CRL crl);
}
