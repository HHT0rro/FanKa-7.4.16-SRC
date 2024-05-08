package java.lang.reflect;

import java.lang.reflect.GenericDeclaration;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface TypeVariable<D extends GenericDeclaration> extends Type {
    Type[] getBounds();

    D getGenericDeclaration();

    String getName();
}
