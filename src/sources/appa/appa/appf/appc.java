package appa.appa.appf;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.wangmai.appsdkdex.utils.WMAppEnvironment;
import com.wangmai.bean.WmConfigBean;
import com.wangmai.common.utils.GsonUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: LogUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class appc {

    /* renamed from: appa, reason: collision with root package name */
    public static String f1016appa = "WM_LOG==";
    public static boolean appb = false;
    private static WmConfigBean appc;
    private static StringBuffer appd = new StringBuffer();

    public static WmConfigBean appa(Context context) {
        if (appc == null) {
            appc = new WmConfigBean();
            try {
                if (new File(appa()).exists()) {
                    appe.appa("checkConfigInfo", "config start2===");
                    String appb2 = appb(context);
                    appe.appa("checkConfigInfo", "config config===", appb2);
                    if (!TextUtils.isEmpty(appb2)) {
                        appc = (WmConfigBean) GsonUtils.getInstance().fromJson(appb2, WmConfigBean.class);
                        appb = appc.isLogType();
                    }
                    appe.appa("checkConfigInfo", "config end===" + appb);
                } else {
                    appe.appa("checkConfigInfo", "config end===", "file not exist");
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return appc;
    }

    public static String appb(Context context) {
        try {
            StringBuilder sb2 = new StringBuilder();
            if (Environment.getExternalStorageState().equals("mounted")) {
                FileInputStream fileInputStream = new FileInputStream(appa());
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    sb2.append(new String(bArr, 0, read));
                }
                fileInputStream.close();
            }
            return sb2.toString();
        } catch (IOException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void appc(String str, String str2) {
        if (str != null) {
            try {
                if (str.length() != 0 && str2 != null && str2.length() != 0) {
                    if (str2.length() <= 3072) {
                        Log.i(str, str2);
                        return;
                    }
                    while (str2.length() > 3072) {
                        String substring = str2.substring(0, 3072);
                        str2 = str2.replace(substring, "");
                        Log.i(str, substring);
                    }
                    Log.i(str, str2);
                }
            } catch (Throwable th) {
                appd.appe(f1016appa, "LogUtils.i error:" + th.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void appd(String str, String str2) {
        if (str != null) {
            try {
                if (str.length() != 0 && str2 != null && str2.length() != 0) {
                    if (str2.length() <= 3072) {
                        Log.v(str, str2);
                        return;
                    }
                    while (str2.length() > 3072) {
                        String substring = str2.substring(0, 3072);
                        str2 = str2.replace(substring, "");
                        Log.v(str, substring);
                    }
                    Log.v(str, str2);
                }
            } catch (Throwable th) {
                appd.appe(f1016appa, "LogUtils.v error:" + th.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void appe(String str, String str2) {
        if (str != null) {
            try {
                if (str.length() != 0 && str2 != null && str2.length() != 0) {
                    if (str2.length() <= 3072) {
                        Log.w(str, str2);
                        return;
                    }
                    while (str2.length() > 3072) {
                        String substring = str2.substring(0, 3072);
                        str2 = str2.replace(substring, "");
                        Log.w(str, substring);
                    }
                    Log.w(str, str2);
                }
            } catch (Throwable th) {
                appd.appe(f1016appa, "LogUtils.w error:" + th.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void appb(String str, String str2) {
        if (str != null) {
            try {
                if (str.length() != 0 && str2 != null && str2.length() != 0) {
                    if (str2.length() <= 3072) {
                        Log.e(str, str2);
                        return;
                    }
                    while (str2.length() > 3072) {
                        String substring = str2.substring(0, 3072);
                        str2 = str2.replace(substring, "");
                        Log.e(str, substring);
                    }
                    Log.e(str, str2);
                }
            } catch (Throwable th) {
                appd.appe(f1016appa, "LogUtils.e error:" + th.toString());
            }
        }
    }

    public static String appa() {
        return WMAppEnvironment.VERSION_UPDATE_APP_DOWNLOAD_DIR + File.separator + "config.txt";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String appa(boolean z10, String str, Object... objArr) {
        try {
            if (!appb && !z10) {
                appd.setLength(0);
                return appd.toString();
            }
            appd.setLength(0);
            if (!TextUtils.isEmpty(str)) {
                StringBuffer stringBuffer = appd;
                stringBuffer.append(" ====>>");
                stringBuffer.append(str);
            }
            for (Object obj : objArr) {
                StringBuffer stringBuffer2 = appd;
                stringBuffer2.append(" =========>>");
                stringBuffer2.append(obj);
            }
            return appd.toString();
        } catch (Throwable th) {
            appd.appe(f1016appa, "LogUtils.log error:" + th.toString());
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void appa(String str, String str2) {
        if (str != null) {
            try {
                if (str.length() != 0 && str2 != null && str2.length() != 0) {
                    if (str2.length() <= 3072) {
                        Log.d(str, str2);
                        return;
                    }
                    while (str2.length() > 3072) {
                        String substring = str2.substring(0, 3072);
                        str2 = str2.replace(substring, "");
                        Log.d(str, substring);
                    }
                    Log.d(str, str2);
                }
            } catch (Throwable th) {
                appd.appe(f1016appa, "LogUtils.d error:" + th.toString());
            }
        }
    }
}
