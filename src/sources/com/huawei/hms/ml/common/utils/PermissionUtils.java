package com.huawei.hms.ml.common.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class PermissionUtils {
    public static boolean checkPermission(Context context, String str) {
        return checkPermissions(context, Arrays.asList(str)).get(0).booleanValue();
    }

    public static List<Boolean> checkPermissions(Context context, List<String> list) {
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        ArrayList arrayList = new ArrayList();
        Iterator<String> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(Boolean.valueOf(packageManager.checkPermission(iterator2.next(), packageName) != -1));
        }
        return arrayList;
    }
}
