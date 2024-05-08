package com.android.internal.policy;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface IDecorViewWrapper {
    default IDecorViewExt getExtImpl() {
        return new IDecorViewExt() { // from class: com.android.internal.policy.IDecorViewWrapper.1
        };
    }

    default PhoneWindow getWindow() {
        return null;
    }
}
