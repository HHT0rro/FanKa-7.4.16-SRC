package com.google.mlkit.common.sdkinternal;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.RecentlyNonNull;

/* compiled from: com.google.mlkit:common@@17.1.1 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class l {
    public static void a(@RecentlyNonNull Context context, @RecentlyNonNull String str) {
        Intent intent = new Intent();
        intent.setClassName("com.google.android.gms", "com.google.android.gms.vision.DependencyBroadcastReceiverProxy");
        intent.setAction("com.google.android.gms.vision.DEPENDENCY");
        intent.putExtra("com.google.android.gms.vision.DEPENDENCIES", str);
        context.sendBroadcast(intent);
    }
}
