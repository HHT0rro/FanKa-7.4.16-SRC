package java.lang;

import java.security.BasicPermission;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class RuntimePermission extends BasicPermission {
    private static final long serialVersionUID = 7399184964622342223L;

    public RuntimePermission(String name) {
        super(name);
    }

    public RuntimePermission(String name, String actions) {
        super(name, actions);
    }
}
