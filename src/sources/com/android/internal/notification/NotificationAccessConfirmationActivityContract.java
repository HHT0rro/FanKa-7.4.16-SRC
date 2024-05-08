package com.android.internal.notification;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class NotificationAccessConfirmationActivityContract {
    public static final String EXTRA_COMPONENT_NAME = "component_name";
    public static final String EXTRA_USER_ID = "user_id";

    public static Intent launcherIntent(Context context, int userId, ComponentName component) {
        return new Intent().setComponent(ComponentName.unflattenFromString(context.getString(17040009))).putExtra(EXTRA_USER_ID, userId).putExtra(EXTRA_COMPONENT_NAME, component);
    }
}
