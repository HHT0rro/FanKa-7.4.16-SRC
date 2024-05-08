package java.security.cert;

import java.util.Iterator;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface PolicyNode {
    Iterator<? extends PolicyNode> getChildren();

    int getDepth();

    Set<String> getExpectedPolicies();

    PolicyNode getParent();

    Set<? extends PolicyQualifierInfo> getPolicyQualifiers();

    String getValidPolicy();

    boolean isCritical();
}
