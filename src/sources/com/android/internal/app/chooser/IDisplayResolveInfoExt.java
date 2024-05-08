package com.android.internal.app.chooser;

import android.app.Activity;
import android.content.Intent;
import com.android.internal.app.IResolverActivityExt;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface IDisplayResolveInfoExt {
    default void setIsMultiApp(boolean isMultiApp) {
    }

    default int changeUserIdIfNeed(IResolverActivityExt activityext, Intent intent, int userId) {
        return userId;
    }

    default boolean shouldPrepareIntentForCrossProfileLaunch(IResolverActivityExt resolverActivityExt) {
        return true;
    }

    default boolean shouldPrepareIntentForCrossProfileLaunch(Activity activity, Intent intent) {
        return true;
    }
}
