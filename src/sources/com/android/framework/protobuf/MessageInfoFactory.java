package com.android.framework.protobuf;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
@CheckReturnValue
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
interface MessageInfoFactory {
    boolean isSupported(Class<?> cls);

    MessageInfo messageInfoFor(Class<?> cls);
}
