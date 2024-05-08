package com.kwad.sdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.ServiceState;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.net.InetAddress;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ag {
    private static int aPt;
    private static boolean aPu;

    @Nullable
    public static NetworkInfo cj(Context context) {
        ConnectivityManager connectivityManager;
        if (!SystemUtil.b(context, com.kuaishou.weapon.p0.g.f36116b) || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return null;
        }
        try {
            return connectivityManager.getActiveNetworkInfo();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static int ck(Context context) {
        if (context != null && SystemUtil.b(context, com.kuaishou.weapon.p0.g.f36116b) && SystemUtil.b(context, com.kuaishou.weapon.p0.g.f36117c)) {
            try {
                NetworkInfo cj = cj(context);
                if (!(cj != null && cj.isConnected())) {
                    return 0;
                }
                if (1 == cj.getType()) {
                    return 100;
                }
                TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
                if (telephonyManager != null) {
                    int m10 = m(context, telephonyManager.getNetworkType());
                    if (m10 == 20) {
                        return 5;
                    }
                    switch (m10) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                        case 16:
                            return 2;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            return 3;
                        case 13:
                            return 4;
                        default:
                            return 0;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public static int d(Context context, String str, boolean z10) {
        if (context != null && aPt <= 0 && !aPu) {
            try {
                if (!z10) {
                    String simOperator = ((TelephonyManager) context.getApplicationContext().getSystemService("phone")).getSimOperator();
                    char c4 = 65535;
                    int hashCode = simOperator.hashCode();
                    if (hashCode != 49679502) {
                        switch (hashCode) {
                            case 49679470:
                                if (simOperator.equals("46000")) {
                                    c4 = 0;
                                    break;
                                }
                                break;
                            case 49679471:
                                if (simOperator.equals("46001")) {
                                    c4 = 4;
                                    break;
                                }
                                break;
                            case 49679472:
                                if (simOperator.equals("46002")) {
                                    c4 = 1;
                                    break;
                                }
                                break;
                            case 49679473:
                                if (simOperator.equals("46003")) {
                                    c4 = 7;
                                    break;
                                }
                                break;
                            default:
                                switch (hashCode) {
                                    case 49679475:
                                        if (simOperator.equals("46005")) {
                                            c4 = '\b';
                                            break;
                                        }
                                        break;
                                    case 49679476:
                                        if (simOperator.equals("46006")) {
                                            c4 = 5;
                                            break;
                                        }
                                        break;
                                    case 49679477:
                                        if (simOperator.equals("46007")) {
                                            c4 = 2;
                                            break;
                                        }
                                        break;
                                    case 49679478:
                                        if (simOperator.equals("46008")) {
                                            c4 = 3;
                                            break;
                                        }
                                        break;
                                    case 49679479:
                                        if (simOperator.equals("46009")) {
                                            c4 = 6;
                                            break;
                                        }
                                        break;
                                }
                        }
                    } else if (simOperator.equals("46011")) {
                        c4 = '\t';
                    }
                    switch (c4) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                            aPt = 1;
                            break;
                        case 4:
                        case 5:
                        case 6:
                            aPt = 3;
                            break;
                        case 7:
                        case '\b':
                        case '\t':
                            aPt = 2;
                            break;
                        default:
                            aPt = 0;
                            break;
                    }
                } else {
                    aPt = 0;
                }
                if (aPt == 0 && !TextUtils.isEmpty(str)) {
                    if (!str.startsWith("46000") && !str.startsWith("46002")) {
                        if (str.startsWith("46001")) {
                            aPt = 3;
                        } else if (str.startsWith("46003")) {
                            aPt = 2;
                        }
                    }
                    aPt = 1;
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.e.c.printStackTraceOnly(e2);
            }
            int i10 = aPt;
            aPu = i10 == 0;
            return i10;
        }
        return aPt;
    }

    private static boolean gC(@NonNull String str) {
        return str.contains("nrState=NOT_RESTRICTED") || str.contains("nrState=CONNECTED");
    }

    @WorkerThread
    public static boolean gD(String str) {
        return t(str, 3000);
    }

    public static int getActiveNetworkType(Context context) {
        try {
            NetworkInfo cj = cj(context);
            if (cj == null) {
                return -1;
            }
            return cj.getType();
        } catch (Exception unused) {
            return -1;
        }
    }

    private static int getSubId() {
        if (Build.VERSION.SDK_INT >= 24) {
            return SubscriptionManager.getDefaultDataSubscriptionId();
        }
        return -1;
    }

    public static boolean isMobileConnected(Context context) {
        try {
            NetworkInfo cj = cj(context);
            if (cj != null && cj.isConnected()) {
                if (cj.getType() == 0) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static boolean isNetworkConnected(Context context) {
        try {
            NetworkInfo cj = cj(context);
            if (cj != null) {
                if (cj.isConnected()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean isWifiConnected(Context context) {
        try {
            NetworkInfo cj = cj(context);
            if (cj != null && cj.isConnected()) {
                return 1 == cj.getType();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return false;
    }

    private static int m(Context context, int i10) {
        ServiceState serviceState;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 26 || !SystemUtil.b(context, com.kuaishou.weapon.p0.g.f36116b)) {
            return i10;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return i10;
            }
            int subId = getSubId();
            if (subId == -1) {
                serviceState = telephonyManager.getServiceState();
            } else if (context.getApplicationInfo().targetSdkVersion >= 29 && i11 >= 29) {
                serviceState = telephonyManager.getServiceState();
            } else {
                try {
                    serviceState = (ServiceState) s.callMethod(telephonyManager, "getServiceStateForSubscriber", Integer.valueOf(subId));
                } catch (Throwable unused) {
                    serviceState = telephonyManager.getServiceState();
                }
            }
            if (serviceState == null) {
                return i10;
            }
            if (at.Md()) {
                Integer num = (Integer) s.a("com.huawei.android.telephony.ServiceStateEx", "getConfigRadioTechnology", serviceState);
                return num != null ? num.intValue() : i10;
            }
            if (gC(serviceState.toString())) {
                return 20;
            }
            return i10;
        } catch (Exception unused2) {
            return i10;
        }
    }

    @WorkerThread
    private static boolean t(String str, int i10) {
        try {
            return InetAddress.getByName(str).isReachable(3000);
        } catch (Throwable unused) {
            return false;
        }
    }
}
