package io.grpc.internal;

import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class InUseStateAggregator<T> {
    private final Set<T> inUseObjects = Collections.newSetFromMap(new IdentityHashMap());

    public final boolean anyObjectInUse(Object... objArr) {
        for (Object obj : objArr) {
            if (this.inUseObjects.contains(obj)) {
                return true;
            }
        }
        return false;
    }

    public abstract void handleInUse();

    public abstract void handleNotInUse();

    public final boolean isInUse() {
        return !this.inUseObjects.isEmpty();
    }

    public final void updateObjectInUse(T t2, boolean z10) {
        int size = this.inUseObjects.size();
        if (z10) {
            this.inUseObjects.add(t2);
            if (size == 0) {
                handleInUse();
                return;
            }
            return;
        }
        if (this.inUseObjects.remove(t2) && size == 1) {
            handleNotInUse();
        }
    }
}
