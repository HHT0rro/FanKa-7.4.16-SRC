package com.kwad.sdk.utils;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.fragment.FileProvider;
import java.io.File;
import java.util.Iterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class al {
    public static PendingIntent a(Context context, int i10, @NonNull Intent intent) {
        if (Build.VERSION.SDK_INT >= 31) {
            return PendingIntent.getBroadcast(context, i10, intent, 201326592);
        }
        return PendingIntent.getBroadcast(context, i10, intent, 134217728);
    }

    private static PendingIntent b(Context context, int i10, @NonNull Intent intent) {
        if (Build.VERSION.SDK_INT >= 31) {
            return PendingIntent.getActivity(context, i10, intent, 201326592);
        }
        return PendingIntent.getActivity(context, i10, intent, 134217728);
    }

    private static Uri c(Context context, File file) {
        if (Build.VERSION.SDK_INT >= 24) {
            return FileProvider.getUriForFile(context, context.getPackageName() + ".adFileProvider", file);
        }
        return Uri.fromFile(file);
    }

    @Nullable
    public static PendingIntent d(Context context, String str, int i10) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return null;
        }
        return b(context, i10, launchIntentForPackage);
    }

    private static Intent h(Intent intent) {
        Intent intent2 = new Intent("intent.action.requestInstallPermission");
        intent2.putExtra("fromNotification", true);
        intent2.putExtra(com.huawei.openalliance.ad.download.app.d.f32414d, intent);
        intent2.addFlags(268435456);
        return intent2;
    }

    public static PendingIntent a(Context context, File file, int i10, boolean z10) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435459);
        Uri c4 = c(context, file);
        intent.setDataAndType(c4, "application/vnd.android.package-archive");
        Iterator<ResolveInfo> iterator2 = context.getPackageManager().queryIntentActivities(intent, 65536).iterator2();
        while (iterator2.hasNext()) {
            context.grantUriPermission(iterator2.next().activityInfo.packageName, c4, 3);
        }
        if (z10) {
            com.kwad.sdk.c.xL();
            if (com.kwad.sdk.c.xO()) {
                intent = h(intent);
            }
        }
        return b(context, i10, intent);
    }
}
