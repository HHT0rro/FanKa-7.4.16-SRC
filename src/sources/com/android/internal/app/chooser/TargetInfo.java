package com.android.internal.app.chooser;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.UserHandle;
import com.android.internal.app.ResolverActivity;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface TargetInfo {
    TargetInfo cloneFilledIn(Intent intent, int i10);

    List<Intent> getAllSourceIntents();

    Drawable getDisplayIcon(Context context);

    CharSequence getDisplayLabel();

    CharSequence getExtendedInfo();

    ResolveInfo getResolveInfo();

    ComponentName getResolvedComponentName();

    Intent getResolvedIntent();

    boolean isPinned();

    boolean isSuspended();

    boolean start(Activity activity, Bundle bundle);

    boolean startAsCaller(ResolverActivity resolverActivity, Bundle bundle, int i10);

    boolean startAsUser(Activity activity, Bundle bundle, UserHandle userHandle);

    static void prepareIntentForCrossProfileLaunch(Intent intent, int targetUserId) {
        int currentUserId = UserHandle.myUserId();
        if (targetUserId != currentUserId) {
            intent.fixUris(currentUserId);
        }
    }
}
