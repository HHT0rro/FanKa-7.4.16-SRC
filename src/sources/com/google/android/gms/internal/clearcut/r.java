package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.q;
import com.google.android.gms.internal.clearcut.r;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class r<MessageType extends q<MessageType, BuilderType>, BuilderType extends r<MessageType, BuilderType>> implements b2 {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.clearcut.b2
    public final /* synthetic */ b2 H(a2 a2Var) {
        if (d().getClass().isInstance(a2Var)) {
            return h((q) a2Var);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }

    public abstract BuilderType h(MessageType messagetype);
}
