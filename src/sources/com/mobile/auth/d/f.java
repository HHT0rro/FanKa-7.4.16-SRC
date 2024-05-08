package com.mobile.auth.d;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.huawei.hianalytics.core.transport.net.Response;
import com.mobile.auth.gatewayauth.ExceptionProcessor;
import com.tencent.connect.common.Constants;
import java.lang.reflect.Method;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class f {
    private static int a(int i10) {
        int i11 = Response.Code.INTERNET_PERMISSION_ERROR;
        if (i10 != -101) {
            i11 = -1;
            if (i10 != -1) {
                switch (i10) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                    case 16:
                        return 1;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                    case 17:
                        return 2;
                    case 13:
                    case 18:
                    case 19:
                        return 3;
                    default:
                        return i10;
                }
            }
        }
        return i11;
    }

    public static NetworkInfo a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public static boolean b(Context context) {
        try {
            NetworkInfo a10 = a(context);
            if (a10 != null) {
                return a10.isAvailable();
            }
            return false;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return false;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return false;
            }
        }
    }

    public static boolean c(Context context) {
        try {
            NetworkInfo a10 = a(context);
            if (a10 != null) {
                if (a10.getType() == 0) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return false;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return false;
            }
        }
    }

    public static boolean d(Context context) {
        if (context == null) {
            return true;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
            Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(connectivityManager, new Object[0])).booleanValue();
        } catch (Throwable th) {
            try {
                com.mobile.auth.a.a.a("NetUtil", "isMobileEnable error ", th);
                return true;
            } catch (Throwable th2) {
                try {
                    ExceptionProcessor.processException(th2);
                    return false;
                } catch (Throwable th3) {
                    ExceptionProcessor.processException(th3);
                    return false;
                }
            }
        }
    }

    public static String e(Context context) {
        try {
            int h10 = h(context);
            return h10 != -101 ? (h10 == -1 || h10 == 0) ? "null" : h10 != 1 ? h10 != 2 ? h10 != 3 ? Integer.toString(h10) : "4G" : "3G" : "2G" : "WIFI";
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public static String f(Context context) {
        try {
            String e2 = e(context);
            if (e2 != null && e2.equals("WIFI")) {
                if (d(context)) {
                    return "BOTH";
                }
            }
            return e2;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public static String g(Context context) {
        try {
            String f10 = f(context);
            if (!TextUtils.isEmpty(f10) && !f10.equals("null")) {
                if (f10.equals("2G")) {
                    return "10";
                }
                if (f10.equals("3G")) {
                    return "11";
                }
                if (f10.equals("4G")) {
                    return Constants.VIA_REPORT_TYPE_SET_AVATAR;
                }
                if (f10.equals("WIFI")) {
                    return Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                }
                if (f10.equals("BOTH")) {
                    return Constants.VIA_REPORT_TYPE_MAKE_FRIEND;
                }
            }
            return "15";
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    private static int h(Context context) {
        int i10 = 0;
        try {
            try {
                NetworkInfo a10 = a(context);
                if (a10 != null && a10.isAvailable() && a10.isConnected()) {
                    int type = a10.getType();
                    if (type == 1) {
                        i10 = Response.Code.INTERNET_PERMISSION_ERROR;
                    } else if (type == 0) {
                        try {
                            i10 = ((TelephonyManager) context.getSystemService("phone")).getNetworkType();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        if (i10 == 0) {
                            i10 = a10.getSubtype();
                        }
                    }
                } else {
                    i10 = -1;
                }
            } catch (NullPointerException e10) {
                e10.printStackTrace();
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            return a(i10);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return -1;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return -1;
            }
        }
    }
}
