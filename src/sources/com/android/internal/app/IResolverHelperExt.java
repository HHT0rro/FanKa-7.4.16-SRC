package com.android.internal.app;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface IResolverHelperExt {
    Drawable getAppInfoDrawable(Context context, Intent intent, ResolveInfo resolveInfo, PackageManager packageManager);

    int getIconScalePx(Context context);

    String getMultiAppAlias(String str);

    boolean hasDevicepolicy(String str);

    boolean hasOplusFeature(String str);

    void sortResolverInfo(Context context, List<ResolveInfo> list, Intent intent, int i10);
}
