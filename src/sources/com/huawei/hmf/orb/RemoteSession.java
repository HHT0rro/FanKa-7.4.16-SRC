package com.huawei.hmf.orb;

import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class RemoteSession {
    private static final AtomicInteger sequence = new AtomicInteger(0);
    private HashMap<Long, RemoteTarget> remoteTargetMap = new HashMap<>();

    public static long nextID() {
        return sequence.incrementAndGet();
    }

    public long add(RemoteTarget remoteTarget) {
        long nextID = nextID();
        this.remoteTargetMap.put(Long.valueOf(nextID), remoteTarget);
        return nextID;
    }

    public RemoteTarget get(Long l10) {
        return this.remoteTargetMap.get(l10);
    }

    public void release() {
        Iterator<RemoteTarget> it = this.remoteTargetMap.values().iterator();
        while (it.hasNext()) {
            it.next().release();
        }
    }

    public long add(IndexedObject<? extends RemoteTarget> indexedObject) {
        this.remoteTargetMap.put(Long.valueOf(indexedObject.id()), indexedObject.get());
        return indexedObject.id();
    }
}
