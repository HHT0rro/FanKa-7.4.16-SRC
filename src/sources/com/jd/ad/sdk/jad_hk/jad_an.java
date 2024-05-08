package com.jd.ad.sdk.jad_hk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_an {
    public static List<String> jad_an(Context context) {
        try {
            ArrayList arrayList = new ArrayList();
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SCREEN_ON");
            Iterator<ResolveInfo> iterator2 = context.getPackageManager().queryBroadcastReceivers(intent, 0).iterator2();
            while (iterator2.hasNext()) {
                arrayList.add(iterator2.next().activityInfo.packageName);
            }
            return arrayList;
        } catch (Exception unused) {
            return null;
        }
    }
}
