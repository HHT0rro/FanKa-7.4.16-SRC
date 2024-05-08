package com.huawei.hms.push;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.alimm.tanx.ui.image.glide.load.model.ResourceLoader;
import com.huawei.hms.support.log.HMSLog;
import java.lang.reflect.Field;

/* compiled from: ResourceLoader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class s {
    public static int a(Context context, String str, String str2) {
        try {
            int identifier = context.getResources().getIdentifier(str2, str, context.getPackageName());
            if (identifier == 0) {
                Field field = Class.forName(context.getPackageName() + ".R$" + str).getField(str2);
                identifier = Integer.parseInt(field.get(field.getName()).toString());
                if (identifier == 0) {
                    HMSLog.i(ResourceLoader.TAG, "Error-resourceType=" + str + "--resourceName=" + str2 + "--resourceId =" + identifier);
                }
            }
            return identifier;
        } catch (ClassNotFoundException e2) {
            HMSLog.e(ResourceLoader.TAG, "!!!! ResourceLoader: ClassNotFoundException-resourceType=" + str + "--resourceName=" + str2, e2);
            return 0;
        } catch (IllegalAccessException e10) {
            HMSLog.e(ResourceLoader.TAG, "!!!! ResourceLoader: IllegalAccessException-resourceType=" + str + "--resourceName=" + str2, e10);
            return 0;
        } catch (NoSuchFieldException e11) {
            HMSLog.e(ResourceLoader.TAG, "!!!! ResourceLoader: NoSuchFieldException-resourceType=" + str + "--resourceName=" + str2, e11);
            return 0;
        } catch (NumberFormatException e12) {
            HMSLog.e(ResourceLoader.TAG, "!!!! ResourceLoader: NumberFormatException-resourceType=" + str + "--resourceName=" + str2, e12);
            return 0;
        } catch (IllegalArgumentException e13) {
            HMSLog.e(ResourceLoader.TAG, "!!!! ResourceLoader: IllegalArgumentException-resourceType=" + str + "--resourceName=" + str2, e13);
            return 0;
        }
    }

    public static int a(Context context, String str) {
        Bundle bundle;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                return 0;
            }
            return bundle.getInt(str);
        } catch (PackageManager.NameNotFoundException unused) {
            HMSLog.w(ResourceLoader.TAG, "load meta data resource failed.");
            return 0;
        }
    }
}
