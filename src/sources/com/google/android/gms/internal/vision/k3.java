package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.k3;
import com.google.android.gms.internal.vision.l3;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class k3<MessageType extends l3<MessageType, BuilderType>, BuilderType extends k3<MessageType, BuilderType>> implements f6 {
    public abstract BuilderType c(MessageType messagetype);

    public abstract BuilderType d(byte[] bArr, int i10, int i11, l4 l4Var) throws zzjk;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.vision.f6
    public final /* synthetic */ f6 f(c6 c6Var) {
        if (zzr().getClass().isInstance(c6Var)) {
            return c((l3) c6Var);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
