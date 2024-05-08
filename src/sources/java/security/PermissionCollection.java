package java.security;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.stream.Stream;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class PermissionCollection implements Serializable {
    public abstract void add(Permission permission);

    public abstract Enumeration<Permission> elements();

    public abstract boolean implies(Permission permission);

    public void setReadOnly() {
    }

    public boolean isReadOnly() {
        return true;
    }

    public Stream<Permission> elementsAsStream() {
        return Stream.empty();
    }
}
