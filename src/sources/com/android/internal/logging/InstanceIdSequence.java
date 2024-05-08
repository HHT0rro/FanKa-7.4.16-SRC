package com.android.internal.logging;

import java.security.SecureRandom;
import java.util.Random;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class InstanceIdSequence {
    protected final int mInstanceIdMax;
    private final Random mRandom = new SecureRandom();

    public InstanceIdSequence(int instanceIdMax) {
        this.mInstanceIdMax = Math.min(Math.max(1, instanceIdMax), 1048576);
    }

    public InstanceId newInstanceId() {
        return newInstanceIdInternal(this.mRandom.nextInt(this.mInstanceIdMax) + 1);
    }

    protected InstanceId newInstanceIdInternal(int id2) {
        return new InstanceId(id2);
    }
}
