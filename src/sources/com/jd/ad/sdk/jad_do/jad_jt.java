package com.jd.ad.sdk.jad_do;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.jd.ad.sdk.logger.Logger;
import com.kuaishou.weapon.p0.g;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_jt {
    /* JADX WARN: Code restructure failed: missing block: B:19:0x007c, code lost:
    
        if (r6 == null) goto L34;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006b A[Catch: all -> 0x0070, TRY_LEAVE, TryCatch #1 {all -> 0x0070, blocks: (B:11:0x003b, B:15:0x006b, B:35:0x0064), top: B:10:0x003b }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int jad_an(android.content.Context r9, int r10) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 29
            if (r0 < r1) goto L90
            java.lang.String r1 = "android.permission.READ_PHONE_STATE"
            int r1 = r9.checkSelfPermission(r1)
            if (r1 != 0) goto L90
            java.lang.String r1 = "phone"
            java.lang.Object r9 = r9.getSystemService(r1)
            android.telephony.TelephonyManager r9 = (android.telephony.TelephonyManager) r9
            r1 = 24
            r2 = -1
            if (r0 < r1) goto L20
            int r0 = android.telephony.SubscriptionManager.getDefaultDataSubscriptionId()
            goto L21
        L20:
            r0 = -1
        L21:
            if (r0 != r2) goto L24
            goto L7e
        L24:
            r1 = 1
            java.lang.Class[] r2 = new java.lang.Class[r1]
            java.lang.Class<java.lang.Integer> r3 = java.lang.Integer.TYPE
            r4 = 0
            r2[r4] = r3
            java.lang.Object[] r3 = new java.lang.Object[r1]
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r3[r4] = r0
            java.lang.String r0 = "android.telephony.TelephonyManager"
            java.lang.String r5 = "getServiceStateForSubscriber"
            java.lang.reflect.Method r6 = com.jd.ad.sdk.jad_do.jad_iv.jad_an
            r6 = 0
            boolean r7 = com.jd.ad.sdk.jad_do.jad_iv.jad_an()     // Catch: java.lang.Throwable -> L70
            if (r7 == 0) goto L68
            java.lang.reflect.Method r7 = com.jd.ad.sdk.jad_do.jad_iv.jad_an     // Catch: java.lang.Throwable -> L62
            java.lang.Object[] r8 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L62
            r8[r4] = r0     // Catch: java.lang.Throwable -> L62
            java.lang.Object r0 = r7.invoke(r6, r8)     // Catch: java.lang.Throwable -> L62
            java.lang.Class r0 = (java.lang.Class) r0     // Catch: java.lang.Throwable -> L62
            java.lang.reflect.Method r7 = com.jd.ad.sdk.jad_do.jad_iv.jad_bo     // Catch: java.lang.Throwable -> L62
            r8 = 2
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch: java.lang.Throwable -> L62
            r8[r4] = r5     // Catch: java.lang.Throwable -> L62
            r8[r1] = r2     // Catch: java.lang.Throwable -> L62
            java.lang.Object r0 = r7.invoke(r0, r8)     // Catch: java.lang.Throwable -> L62
            java.lang.reflect.Method r0 = (java.lang.reflect.Method) r0     // Catch: java.lang.Throwable -> L62
            r0.setAccessible(r1)     // Catch: java.lang.Throwable -> L60
            goto L69
        L60:
            r1 = move-exception
            goto L64
        L62:
            r1 = move-exception
            r0 = r6
        L64:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L70
            goto L69
        L68:
            r0 = r6
        L69:
            if (r0 == 0) goto L74
            java.lang.Object r0 = r0.invoke(r9, r3)     // Catch: java.lang.Throwable -> L70
            goto L75
        L70:
            r0 = move-exception
            r0.printStackTrace()
        L74:
            r0 = r6
        L75:
            boolean r1 = r0 instanceof android.telephony.ServiceState
            if (r1 == 0) goto L7c
            r6 = r0
            android.telephony.ServiceState r6 = (android.telephony.ServiceState) r6
        L7c:
            if (r6 != 0) goto L82
        L7e:
            android.telephony.ServiceState r6 = r9.getServiceState()
        L82:
            if (r6 == 0) goto L90
            java.lang.String r9 = r6.toString()
            boolean r9 = jad_an(r9)
            if (r9 == 0) goto L90
            r10 = 8
        L90:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_do.jad_jt.jad_an(android.content.Context, int):int");
    }

    public static String jad_an() {
        String hostAddress;
        Matcher matcher;
        Pattern compile = Pattern.compile("(^10\\.(\\d{1}|[1-9]\\d|1\\d{2}|2[0-4]\\d|25\\d)\\.(\\d{1}|[1-9]\\d|1\\d{2}|2[0-4]\\d|25\\d)\\.(\\d{1}|[1-9]\\d|1\\d{2}|2[0-4]\\d|25\\d)$)|(^172\\.(1[6-9]|2\\d|3[0-1])\\.(\\d{1}|[1-9]\\d|1\\d{2}|2[0-4]\\d|25\\d)\\.(\\d{1}|[1-9]\\d|1\\d{2}|2[0-4]\\d|25\\d)$)|(^192\\.168\\.(\\d{1}|[1-9]\\d|1\\d{2}|2[0-4]\\d|25\\d)\\.(\\d{1}|[1-9]\\d|1\\d{2}|2[0-4]\\d|25\\d)$)");
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces != null) {
                if (!networkInterfaces.hasMoreElements()) {
                    return "";
                }
                NetworkInterface nextElement = networkInterfaces.nextElement();
                if (nextElement != null) {
                    Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                    while (inetAddresses != null && inetAddresses.hasMoreElements()) {
                        InetAddress nextElement2 = inetAddresses.nextElement();
                        if (nextElement2 != null && (matcher = compile.matcher((hostAddress = nextElement2.getHostAddress()))) != null && matcher.matches()) {
                            return hostAddress;
                        }
                    }
                }
            }
            return "";
        } catch (Exception e2) {
            StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Exception while get ip: ");
            jad_an.append(e2.getMessage());
            Logger.w(jad_an.toString(), new Object[0]);
            return "";
        }
    }

    public static boolean jad_an(String str) {
        return !TextUtils.isEmpty(str) && (str.contains("nrState=NOT_RESTRICTED") || str.contains("nrState=CONNECTED"));
    }

    public static String jad_bo(@NonNull Context context) {
        TelephonyManager telephonyManager;
        try {
            telephonyManager = (TelephonyManager) context.getSystemService("phone");
        } catch (SecurityException e2) {
            e2.printStackTrace();
            telephonyManager = null;
        }
        if (telephonyManager == null) {
            return "";
        }
        int simState = telephonyManager.getSimState();
        if (!((simState == 0 || simState == 1) ? false : true)) {
            return "";
        }
        String networkOperatorName = telephonyManager.getNetworkOperatorName();
        return !TextUtils.isEmpty(networkOperatorName) ? networkOperatorName.contains("移动") ? "mobile" : networkOperatorName.contains("联通") ? "unicom" : networkOperatorName.contains("电信") ? "telecom" : "" : "";
    }

    public static int jad_an(Context context) {
        ConnectivityManager connectivityManager;
        int i10 = 0;
        if (context == null || ContextCompat.checkSelfPermission(context, g.f36116b) == -1) {
            return 0;
        }
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (SecurityException e2) {
            e2.printStackTrace();
            connectivityManager = null;
        }
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        if (activeNetworkInfo != null) {
            int type = activeNetworkInfo.getType();
            if (type != 0) {
                if (type != 1) {
                    if (type == 9) {
                        i10 = 2;
                    }
                    i10 = 1;
                } else {
                    i10 = 3;
                }
            } else if (Build.VERSION.SDK_INT < 30 || ContextCompat.checkSelfPermission(context, g.f36117c) != -1) {
                int networkType = ((TelephonyManager) context.getSystemService("phone")).getNetworkType();
                if (networkType != 20) {
                    switch (networkType) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            i10 = 5;
                            break;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            i10 = 6;
                            break;
                        case 13:
                            try {
                                i10 = jad_an(context, 7);
                                break;
                            } catch (Throwable unused) {
                            }
                        case 16:
                        case 17:
                            i10 = 7;
                            break;
                        default:
                            i10 = 4;
                            break;
                    }
                } else {
                    i10 = 8;
                }
            } else {
                i10 = 1;
            }
        }
        return com.jd.ad.sdk.jad_jt.jad_fs.jad_an(i10 != 0 ? i10 : 1);
    }
}
