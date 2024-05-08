package com.wangmai.adIdUtils.utils;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.wangmai.adIdUtils.cnadid.CNAdidHelper;
import com.wangmai.adIdUtils.oaid.DeviceID;
import com.wangmai.adIdUtils.oaid.IGetter;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class IdUtils {
    public static final String TAG = "IdUtils";
    public static String cnAdId = "";
    public static String imei = "";
    public static String miitOaid = "";

    public static String getCnAdid(Context context) {
        System.currentTimeMillis();
        try {
            if (TextUtils.isEmpty(cnAdId)) {
                cnAdId = CNAdidHelper.getInstance().readCNAdid(context);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("getCnAdid-----");
                sb2.append(cnAdId);
                if (TextUtils.isEmpty(cnAdId)) {
                    cnAdId = "";
                }
            }
        } catch (Throwable th) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("getCnAdid error:");
            sb3.append(th.toString());
        }
        return cnAdId;
    }

    public static String getIMEI(Context context) {
        if (!TextUtils.isEmpty(imei)) {
            return imei;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        try {
            try {
                Method method = telephonyManager.getClass().getMethod("getImei", Integer.TYPE);
                String str = (String) method.invoke(telephonyManager, 0);
                String str2 = (String) method.invoke(telephonyManager, 1);
                if (TextUtils.isEmpty(str2)) {
                    imei = str;
                    return str;
                }
                if (TextUtils.isEmpty(str)) {
                    return "";
                }
                if (str.compareTo(str2) <= 0) {
                    imei = str;
                } else {
                    imei = str2;
                }
                return imei;
            } catch (Throwable unused) {
                return "";
            }
        } catch (Throwable unused2) {
            String deviceId = telephonyManager.getDeviceId();
            imei = deviceId;
            return deviceId;
        }
    }

    public static String getOaid(Context context) {
        if (!TextUtils.isEmpty(miitOaid)) {
            return miitOaid;
        }
        try {
            if (TextUtils.isEmpty(miitOaid)) {
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                DeviceID.getOAID(context, new IGetter() { // from class: com.wangmai.adIdUtils.utils.IdUtils.1
                    @Override // com.wangmai.adIdUtils.oaid.IGetter
                    public void onOAIDGetComplete(String str) {
                        String unused = IdUtils.miitOaid = str;
                        CountDownLatch.this.countDown();
                    }

                    @Override // com.wangmai.adIdUtils.oaid.IGetter
                    public void onOAIDGetError(Exception exc) {
                        CountDownLatch.this.countDown();
                        exc.getMessage();
                    }
                });
                try {
                    countDownLatch.await(200L, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
            return miitOaid;
        } catch (Throwable unused) {
            return "";
        }
    }
}
