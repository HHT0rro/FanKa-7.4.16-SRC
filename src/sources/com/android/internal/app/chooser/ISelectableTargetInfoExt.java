package com.android.internal.app.chooser;

import com.android.internal.app.IResolverActivityExt;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface ISelectableTargetInfoExt {
    default boolean shouldPrepareIntentForCrossProfileLaunch(IResolverActivityExt resolverActivityExt) {
        return true;
    }
}
