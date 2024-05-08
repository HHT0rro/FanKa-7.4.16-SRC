package java.security;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class GuardedObject implements Serializable {
    private static final long serialVersionUID = -5240450096227834308L;
    private Guard guard;
    private Object object;

    public GuardedObject(Object object, Guard guard) {
        this.guard = guard;
        this.object = object;
    }

    public Object getObject() throws SecurityException {
        Guard guard = this.guard;
        if (guard != null) {
            guard.checkGuard(this.object);
        }
        return this.object;
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        Guard guard = this.guard;
        if (guard != null) {
            guard.checkGuard(this.object);
        }
        oos.defaultWriteObject();
    }
}
