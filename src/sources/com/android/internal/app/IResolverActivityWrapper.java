package com.android.internal.app;

import android.os.UserHandle;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface IResolverActivityWrapper {
    default IResolverActivityExt getResolverActivityExt() {
        return null;
    }

    default String getPersonalTabLabel() {
        return "";
    }

    default String getWorkTabLabel() {
        return "";
    }

    default int getLaunchedFromUid() {
        return UserHandle.myUserId();
    }
}
