package com.android.internal.app;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.UserHandle;
import android.util.Log;
import com.android.internal.app.ResolverActivity;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface IResolverListAdapterExt {
    public static final IResolverListAdapterExt DEFAULT = new IResolverListAdapterExt() { // from class: com.android.internal.app.IResolverListAdapterExt.1
    };

    default void setPlaceholderResolveList(List infos) {
    }

    default boolean sortComponentsNull(List sortedComponents, boolean originShow) {
        return originShow;
    }

    default boolean isOriginUi() {
        return true;
    }

    default ResolveInfo getResolveInfo(Intent ii, PackageManager mPm) {
        ActivityInfo ai = ii.resolveActivityInfo(mPm, 0);
        if (ai == null) {
            Log.w("IResolverListAdapter", "No activity found for " + ((Object) ii));
            return null;
        }
        ResolveInfo ri = new ResolveInfo();
        ri.activityInfo = ai;
        return ri;
    }

    default void addMultiAppResolveInfoIfNeed(List sortedComponents, List<Intent> intents, List multiResolveInfoList, PackageManager packageManager, List displayList) {
    }

    default List getPlaceholderResolveList() {
        return null;
    }

    default boolean hasCustomFlag(int flag) {
        return false;
    }

    default ResolveInfo getExternalResolvedInfo(Context context, List multiResolveInfoList, List<Intent> intents, List<ResolverActivity.ResolvedComponentInfo> currentResolveList, UserHandle userHandle) {
        return null;
    }
}
