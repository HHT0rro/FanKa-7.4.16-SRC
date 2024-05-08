package com.huawei.appgallery.agd.common.utils;

import com.huawei.appgallery.agd.common.CommonLog;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.lang.reflect.InvocationTargetException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class PropertyUtil {
    public static String getProp(String str) {
        CommonLog commonLog;
        StringBuilder sb2;
        String str2;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(cls, str);
        } catch (ClassNotFoundException e2) {
            e = e2;
            commonLog = CommonLog.LOG;
            sb2 = new StringBuilder();
            str2 = "ClassNotFoundException get system properties error! Exception = ";
            sb2.append(str2);
            sb2.append(e);
            commonLog.e("PropertyUtil", sb2.toString());
            return "";
        } catch (IllegalAccessException e10) {
            e = e10;
            commonLog = CommonLog.LOG;
            sb2 = new StringBuilder();
            str2 = "IllegalAccessException get system properties error! Exception = ";
            sb2.append(str2);
            sb2.append(e);
            commonLog.e("PropertyUtil", sb2.toString());
            return "";
        } catch (IllegalArgumentException e11) {
            e = e11;
            commonLog = CommonLog.LOG;
            sb2 = new StringBuilder();
            str2 = "IllegalArgumentException get system properties error! Exception = ";
            sb2.append(str2);
            sb2.append(e);
            commonLog.e("PropertyUtil", sb2.toString());
            return "";
        } catch (NoSuchMethodException e12) {
            e = e12;
            commonLog = CommonLog.LOG;
            sb2 = new StringBuilder();
            str2 = "NoSuchMethodException get system properties error! Exception = ";
            sb2.append(str2);
            sb2.append(e);
            commonLog.e("PropertyUtil", sb2.toString());
            return "";
        } catch (InvocationTargetException e13) {
            e = e13;
            commonLog = CommonLog.LOG;
            sb2 = new StringBuilder();
            str2 = "InvocationTargetException get system properties error! Exception = ";
            sb2.append(str2);
            sb2.append(e);
            commonLog.e("PropertyUtil", sb2.toString());
            return "";
        }
    }
}
