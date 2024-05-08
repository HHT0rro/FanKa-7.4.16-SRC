package bc;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.android.internal.os.PowerProfile;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.huawei.appgallery.agd.common.utils.StringUtils;
import com.huawei.flexiblelayout.n;
import com.inno.innosdk.pb.InnoMain;
import com.nirvana.tools.logger.cache.db.DBHelpTool;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.UnsupportedEncodingException;
import java.net.NetworkInterface;
import java.util.Arrays;
import java.util.Collections;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class b {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a implements cc.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f1461a;

        public a(Context context) {
            this.f1461a = context;
        }

        @Override // cc.b
        public final void onOAIDGetComplete(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            b.J(this.f1461a, str);
        }

        @Override // cc.b
        public final void onOAIDGetError(Exception exc) {
        }
    }

    /* renamed from: bc.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class C0023b {

        /* renamed from: a, reason: collision with root package name */
        public Intent f1462a;

        public /* synthetic */ C0023b(Context context, a aVar) {
            this(context);
        }

        public final int e() {
            return this.f1462a.getIntExtra(DBHelpTool.RecordEntry.COLUMN_NAME_LEVEL, 0);
        }

        public final int f() {
            return this.f1462a.getIntExtra(n.f28264e, 0);
        }

        public final int g() {
            return this.f1462a.getIntExtra("temperature", 0);
        }

        public final int h() {
            return this.f1462a.getIntExtra("voltage", 0);
        }

        public C0023b(Context context) {
            this.f1462a = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        }
    }

    public static String A(Context context) {
        try {
            WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
            return connectionInfo != null ? connectionInfo.getBSSID() : "";
        } catch (SecurityException unused) {
            return "";
        }
    }

    public static void B(Context context) {
    }

    public static boolean C() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public static boolean D() {
        try {
            String u10 = u("ro.build.version.opporom");
            if (TextUtils.isEmpty(u10)) {
                return false;
            }
            String replaceAll = u10.replaceAll("[^\\d.]", "");
            if (TextUtils.isEmpty(replaceAll)) {
                return false;
            }
            return b(replaceAll, "9.0.0") >= 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean E() {
        String a10;
        try {
            a10 = bc.a.a();
        } catch (Exception unused) {
        }
        if (!Arrays.asList("HUAWEI", "OPPO", "VIVO", "XIAOMI").contains(a10)) {
            return false;
        }
        if ("HUAWEI".equals(a10)) {
            return C();
        }
        if ("OPPO".equals(a10)) {
            return D();
        }
        if ("VIVO".equals(a10)) {
            return G();
        }
        if ("XIAOMI".equals(a10)) {
            return I();
        }
        return false;
    }

    public static boolean F(int i10) {
        return i10 > 0;
    }

    public static boolean G() {
        String u10 = u("ro.vivo.os.version");
        return !TextUtils.isEmpty(u10) && b(u10, "7.0") >= 0;
    }

    public static boolean H(int i10) {
        return i10 > 0;
    }

    public static boolean I() {
        try {
            String u10 = u("ro.miui.ui.version.name");
            if (TextUtils.isEmpty(u10)) {
                return false;
            }
            String replaceAll = u10.replaceAll("[^\\d.]", "");
            if (TextUtils.isEmpty(replaceAll)) {
                return false;
            }
            return b(replaceAll, "10") >= 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void J(Context context, String str) {
        bc.a.b(context, "ext_sso", InnoMain.INNO_KEY_OAID, str);
    }

    public static int b(String str, String str2) {
        if (str.equals(str2)) {
            return 0;
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int min = Math.min(split.length, split2.length);
        int i10 = 0;
        int i11 = 0;
        while (i10 < min) {
            i11 = Integer.parseInt(split[i10]) - Integer.parseInt(split2[i10]);
            if (i11 != 0) {
                break;
            }
            i10++;
        }
        if (i11 != 0) {
            return i11 > 0 ? 1 : -1;
        }
        for (int i12 = i10; i12 < split.length; i12++) {
            if (Integer.parseInt(split[i12]) > 0) {
                return 1;
            }
        }
        while (i10 < split2.length) {
            if (Integer.parseInt(split2[i10]) > 0) {
                return -1;
            }
            i10++;
        }
        return 0;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(55:1|2|3|(53:5|6|7|(1:9)|11|12|14|15|(1:17)|18|(1:20)(1:111)|21|(1:23)|24|(1:26)(1:110)|27|(1:29)|30|(1:32)|33|(4:35|(1:37)|38|(1:40))|41|(1:43)|44|(1:46)|47|(1:49)|50|(1:52)|53|(1:55)|56|(1:58)|59|(4:61|(1:63)|64|(1:66))|67|(1:69)|70|(1:72)|73|74|75|(1:77)|78|79|80|81|(3:83|84|(1:86)(1:87))|88|89|(4:(2:97|98)|92|93|(1:95)(1:96))|101|102)|116|11|12|14|15|(0)|18|(0)(0)|21|(0)|24|(0)(0)|27|(0)|30|(0)|33|(0)|41|(0)|44|(0)|47|(0)|50|(0)|53|(0)|56|(0)|59|(0)|67|(0)|70|(0)|73|74|75|(0)|78|79|80|81|(0)|88|89|(0)|101|102|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x013c, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x013d, code lost:
    
        r8.printStackTrace();
        r8 = "";
     */
    /* JADX WARN: Removed duplicated region for block: B:110:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0035 A[Catch: JSONException -> 0x01cb, TryCatch #3 {JSONException -> 0x01cb, blocks: (B:15:0x002b, B:17:0x0035, B:18:0x003a, B:20:0x0040, B:21:0x0046, B:23:0x004c, B:24:0x0051, B:26:0x0057, B:27:0x005d, B:29:0x0063, B:30:0x0068, B:32:0x0072, B:33:0x0077, B:35:0x007d, B:37:0x0087, B:38:0x008c, B:40:0x0096, B:41:0x009b, B:43:0x00a5, B:44:0x00aa, B:46:0x00b4, B:47:0x00b9, B:49:0x00c3, B:50:0x00c8, B:52:0x00d2, B:53:0x00d7, B:55:0x00e1, B:56:0x00e6, B:58:0x00f0, B:59:0x00f5, B:61:0x00fb, B:63:0x0105, B:64:0x010a, B:66:0x0114, B:67:0x0119, B:69:0x0123, B:70:0x0128, B:72:0x0132, B:109:0x013d, B:75:0x0141, B:77:0x0147, B:78:0x014c, B:89:0x01a8, B:92:0x01b3, B:95:0x01bf, B:96:0x01c3, B:101:0x01c6, B:74:0x0137), top: B:14:0x002b, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0040 A[Catch: JSONException -> 0x01cb, TryCatch #3 {JSONException -> 0x01cb, blocks: (B:15:0x002b, B:17:0x0035, B:18:0x003a, B:20:0x0040, B:21:0x0046, B:23:0x004c, B:24:0x0051, B:26:0x0057, B:27:0x005d, B:29:0x0063, B:30:0x0068, B:32:0x0072, B:33:0x0077, B:35:0x007d, B:37:0x0087, B:38:0x008c, B:40:0x0096, B:41:0x009b, B:43:0x00a5, B:44:0x00aa, B:46:0x00b4, B:47:0x00b9, B:49:0x00c3, B:50:0x00c8, B:52:0x00d2, B:53:0x00d7, B:55:0x00e1, B:56:0x00e6, B:58:0x00f0, B:59:0x00f5, B:61:0x00fb, B:63:0x0105, B:64:0x010a, B:66:0x0114, B:67:0x0119, B:69:0x0123, B:70:0x0128, B:72:0x0132, B:109:0x013d, B:75:0x0141, B:77:0x0147, B:78:0x014c, B:89:0x01a8, B:92:0x01b3, B:95:0x01bf, B:96:0x01c3, B:101:0x01c6, B:74:0x0137), top: B:14:0x002b, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004c A[Catch: JSONException -> 0x01cb, TryCatch #3 {JSONException -> 0x01cb, blocks: (B:15:0x002b, B:17:0x0035, B:18:0x003a, B:20:0x0040, B:21:0x0046, B:23:0x004c, B:24:0x0051, B:26:0x0057, B:27:0x005d, B:29:0x0063, B:30:0x0068, B:32:0x0072, B:33:0x0077, B:35:0x007d, B:37:0x0087, B:38:0x008c, B:40:0x0096, B:41:0x009b, B:43:0x00a5, B:44:0x00aa, B:46:0x00b4, B:47:0x00b9, B:49:0x00c3, B:50:0x00c8, B:52:0x00d2, B:53:0x00d7, B:55:0x00e1, B:56:0x00e6, B:58:0x00f0, B:59:0x00f5, B:61:0x00fb, B:63:0x0105, B:64:0x010a, B:66:0x0114, B:67:0x0119, B:69:0x0123, B:70:0x0128, B:72:0x0132, B:109:0x013d, B:75:0x0141, B:77:0x0147, B:78:0x014c, B:89:0x01a8, B:92:0x01b3, B:95:0x01bf, B:96:0x01c3, B:101:0x01c6, B:74:0x0137), top: B:14:0x002b, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0057 A[Catch: JSONException -> 0x01cb, TryCatch #3 {JSONException -> 0x01cb, blocks: (B:15:0x002b, B:17:0x0035, B:18:0x003a, B:20:0x0040, B:21:0x0046, B:23:0x004c, B:24:0x0051, B:26:0x0057, B:27:0x005d, B:29:0x0063, B:30:0x0068, B:32:0x0072, B:33:0x0077, B:35:0x007d, B:37:0x0087, B:38:0x008c, B:40:0x0096, B:41:0x009b, B:43:0x00a5, B:44:0x00aa, B:46:0x00b4, B:47:0x00b9, B:49:0x00c3, B:50:0x00c8, B:52:0x00d2, B:53:0x00d7, B:55:0x00e1, B:56:0x00e6, B:58:0x00f0, B:59:0x00f5, B:61:0x00fb, B:63:0x0105, B:64:0x010a, B:66:0x0114, B:67:0x0119, B:69:0x0123, B:70:0x0128, B:72:0x0132, B:109:0x013d, B:75:0x0141, B:77:0x0147, B:78:0x014c, B:89:0x01a8, B:92:0x01b3, B:95:0x01bf, B:96:0x01c3, B:101:0x01c6, B:74:0x0137), top: B:14:0x002b, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0063 A[Catch: JSONException -> 0x01cb, TryCatch #3 {JSONException -> 0x01cb, blocks: (B:15:0x002b, B:17:0x0035, B:18:0x003a, B:20:0x0040, B:21:0x0046, B:23:0x004c, B:24:0x0051, B:26:0x0057, B:27:0x005d, B:29:0x0063, B:30:0x0068, B:32:0x0072, B:33:0x0077, B:35:0x007d, B:37:0x0087, B:38:0x008c, B:40:0x0096, B:41:0x009b, B:43:0x00a5, B:44:0x00aa, B:46:0x00b4, B:47:0x00b9, B:49:0x00c3, B:50:0x00c8, B:52:0x00d2, B:53:0x00d7, B:55:0x00e1, B:56:0x00e6, B:58:0x00f0, B:59:0x00f5, B:61:0x00fb, B:63:0x0105, B:64:0x010a, B:66:0x0114, B:67:0x0119, B:69:0x0123, B:70:0x0128, B:72:0x0132, B:109:0x013d, B:75:0x0141, B:77:0x0147, B:78:0x014c, B:89:0x01a8, B:92:0x01b3, B:95:0x01bf, B:96:0x01c3, B:101:0x01c6, B:74:0x0137), top: B:14:0x002b, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0072 A[Catch: JSONException -> 0x01cb, TryCatch #3 {JSONException -> 0x01cb, blocks: (B:15:0x002b, B:17:0x0035, B:18:0x003a, B:20:0x0040, B:21:0x0046, B:23:0x004c, B:24:0x0051, B:26:0x0057, B:27:0x005d, B:29:0x0063, B:30:0x0068, B:32:0x0072, B:33:0x0077, B:35:0x007d, B:37:0x0087, B:38:0x008c, B:40:0x0096, B:41:0x009b, B:43:0x00a5, B:44:0x00aa, B:46:0x00b4, B:47:0x00b9, B:49:0x00c3, B:50:0x00c8, B:52:0x00d2, B:53:0x00d7, B:55:0x00e1, B:56:0x00e6, B:58:0x00f0, B:59:0x00f5, B:61:0x00fb, B:63:0x0105, B:64:0x010a, B:66:0x0114, B:67:0x0119, B:69:0x0123, B:70:0x0128, B:72:0x0132, B:109:0x013d, B:75:0x0141, B:77:0x0147, B:78:0x014c, B:89:0x01a8, B:92:0x01b3, B:95:0x01bf, B:96:0x01c3, B:101:0x01c6, B:74:0x0137), top: B:14:0x002b, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007d A[Catch: JSONException -> 0x01cb, TryCatch #3 {JSONException -> 0x01cb, blocks: (B:15:0x002b, B:17:0x0035, B:18:0x003a, B:20:0x0040, B:21:0x0046, B:23:0x004c, B:24:0x0051, B:26:0x0057, B:27:0x005d, B:29:0x0063, B:30:0x0068, B:32:0x0072, B:33:0x0077, B:35:0x007d, B:37:0x0087, B:38:0x008c, B:40:0x0096, B:41:0x009b, B:43:0x00a5, B:44:0x00aa, B:46:0x00b4, B:47:0x00b9, B:49:0x00c3, B:50:0x00c8, B:52:0x00d2, B:53:0x00d7, B:55:0x00e1, B:56:0x00e6, B:58:0x00f0, B:59:0x00f5, B:61:0x00fb, B:63:0x0105, B:64:0x010a, B:66:0x0114, B:67:0x0119, B:69:0x0123, B:70:0x0128, B:72:0x0132, B:109:0x013d, B:75:0x0141, B:77:0x0147, B:78:0x014c, B:89:0x01a8, B:92:0x01b3, B:95:0x01bf, B:96:0x01c3, B:101:0x01c6, B:74:0x0137), top: B:14:0x002b, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a5 A[Catch: JSONException -> 0x01cb, TryCatch #3 {JSONException -> 0x01cb, blocks: (B:15:0x002b, B:17:0x0035, B:18:0x003a, B:20:0x0040, B:21:0x0046, B:23:0x004c, B:24:0x0051, B:26:0x0057, B:27:0x005d, B:29:0x0063, B:30:0x0068, B:32:0x0072, B:33:0x0077, B:35:0x007d, B:37:0x0087, B:38:0x008c, B:40:0x0096, B:41:0x009b, B:43:0x00a5, B:44:0x00aa, B:46:0x00b4, B:47:0x00b9, B:49:0x00c3, B:50:0x00c8, B:52:0x00d2, B:53:0x00d7, B:55:0x00e1, B:56:0x00e6, B:58:0x00f0, B:59:0x00f5, B:61:0x00fb, B:63:0x0105, B:64:0x010a, B:66:0x0114, B:67:0x0119, B:69:0x0123, B:70:0x0128, B:72:0x0132, B:109:0x013d, B:75:0x0141, B:77:0x0147, B:78:0x014c, B:89:0x01a8, B:92:0x01b3, B:95:0x01bf, B:96:0x01c3, B:101:0x01c6, B:74:0x0137), top: B:14:0x002b, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b4 A[Catch: JSONException -> 0x01cb, TryCatch #3 {JSONException -> 0x01cb, blocks: (B:15:0x002b, B:17:0x0035, B:18:0x003a, B:20:0x0040, B:21:0x0046, B:23:0x004c, B:24:0x0051, B:26:0x0057, B:27:0x005d, B:29:0x0063, B:30:0x0068, B:32:0x0072, B:33:0x0077, B:35:0x007d, B:37:0x0087, B:38:0x008c, B:40:0x0096, B:41:0x009b, B:43:0x00a5, B:44:0x00aa, B:46:0x00b4, B:47:0x00b9, B:49:0x00c3, B:50:0x00c8, B:52:0x00d2, B:53:0x00d7, B:55:0x00e1, B:56:0x00e6, B:58:0x00f0, B:59:0x00f5, B:61:0x00fb, B:63:0x0105, B:64:0x010a, B:66:0x0114, B:67:0x0119, B:69:0x0123, B:70:0x0128, B:72:0x0132, B:109:0x013d, B:75:0x0141, B:77:0x0147, B:78:0x014c, B:89:0x01a8, B:92:0x01b3, B:95:0x01bf, B:96:0x01c3, B:101:0x01c6, B:74:0x0137), top: B:14:0x002b, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c3 A[Catch: JSONException -> 0x01cb, TryCatch #3 {JSONException -> 0x01cb, blocks: (B:15:0x002b, B:17:0x0035, B:18:0x003a, B:20:0x0040, B:21:0x0046, B:23:0x004c, B:24:0x0051, B:26:0x0057, B:27:0x005d, B:29:0x0063, B:30:0x0068, B:32:0x0072, B:33:0x0077, B:35:0x007d, B:37:0x0087, B:38:0x008c, B:40:0x0096, B:41:0x009b, B:43:0x00a5, B:44:0x00aa, B:46:0x00b4, B:47:0x00b9, B:49:0x00c3, B:50:0x00c8, B:52:0x00d2, B:53:0x00d7, B:55:0x00e1, B:56:0x00e6, B:58:0x00f0, B:59:0x00f5, B:61:0x00fb, B:63:0x0105, B:64:0x010a, B:66:0x0114, B:67:0x0119, B:69:0x0123, B:70:0x0128, B:72:0x0132, B:109:0x013d, B:75:0x0141, B:77:0x0147, B:78:0x014c, B:89:0x01a8, B:92:0x01b3, B:95:0x01bf, B:96:0x01c3, B:101:0x01c6, B:74:0x0137), top: B:14:0x002b, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00d2 A[Catch: JSONException -> 0x01cb, TryCatch #3 {JSONException -> 0x01cb, blocks: (B:15:0x002b, B:17:0x0035, B:18:0x003a, B:20:0x0040, B:21:0x0046, B:23:0x004c, B:24:0x0051, B:26:0x0057, B:27:0x005d, B:29:0x0063, B:30:0x0068, B:32:0x0072, B:33:0x0077, B:35:0x007d, B:37:0x0087, B:38:0x008c, B:40:0x0096, B:41:0x009b, B:43:0x00a5, B:44:0x00aa, B:46:0x00b4, B:47:0x00b9, B:49:0x00c3, B:50:0x00c8, B:52:0x00d2, B:53:0x00d7, B:55:0x00e1, B:56:0x00e6, B:58:0x00f0, B:59:0x00f5, B:61:0x00fb, B:63:0x0105, B:64:0x010a, B:66:0x0114, B:67:0x0119, B:69:0x0123, B:70:0x0128, B:72:0x0132, B:109:0x013d, B:75:0x0141, B:77:0x0147, B:78:0x014c, B:89:0x01a8, B:92:0x01b3, B:95:0x01bf, B:96:0x01c3, B:101:0x01c6, B:74:0x0137), top: B:14:0x002b, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00e1 A[Catch: JSONException -> 0x01cb, TryCatch #3 {JSONException -> 0x01cb, blocks: (B:15:0x002b, B:17:0x0035, B:18:0x003a, B:20:0x0040, B:21:0x0046, B:23:0x004c, B:24:0x0051, B:26:0x0057, B:27:0x005d, B:29:0x0063, B:30:0x0068, B:32:0x0072, B:33:0x0077, B:35:0x007d, B:37:0x0087, B:38:0x008c, B:40:0x0096, B:41:0x009b, B:43:0x00a5, B:44:0x00aa, B:46:0x00b4, B:47:0x00b9, B:49:0x00c3, B:50:0x00c8, B:52:0x00d2, B:53:0x00d7, B:55:0x00e1, B:56:0x00e6, B:58:0x00f0, B:59:0x00f5, B:61:0x00fb, B:63:0x0105, B:64:0x010a, B:66:0x0114, B:67:0x0119, B:69:0x0123, B:70:0x0128, B:72:0x0132, B:109:0x013d, B:75:0x0141, B:77:0x0147, B:78:0x014c, B:89:0x01a8, B:92:0x01b3, B:95:0x01bf, B:96:0x01c3, B:101:0x01c6, B:74:0x0137), top: B:14:0x002b, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00f0 A[Catch: JSONException -> 0x01cb, TryCatch #3 {JSONException -> 0x01cb, blocks: (B:15:0x002b, B:17:0x0035, B:18:0x003a, B:20:0x0040, B:21:0x0046, B:23:0x004c, B:24:0x0051, B:26:0x0057, B:27:0x005d, B:29:0x0063, B:30:0x0068, B:32:0x0072, B:33:0x0077, B:35:0x007d, B:37:0x0087, B:38:0x008c, B:40:0x0096, B:41:0x009b, B:43:0x00a5, B:44:0x00aa, B:46:0x00b4, B:47:0x00b9, B:49:0x00c3, B:50:0x00c8, B:52:0x00d2, B:53:0x00d7, B:55:0x00e1, B:56:0x00e6, B:58:0x00f0, B:59:0x00f5, B:61:0x00fb, B:63:0x0105, B:64:0x010a, B:66:0x0114, B:67:0x0119, B:69:0x0123, B:70:0x0128, B:72:0x0132, B:109:0x013d, B:75:0x0141, B:77:0x0147, B:78:0x014c, B:89:0x01a8, B:92:0x01b3, B:95:0x01bf, B:96:0x01c3, B:101:0x01c6, B:74:0x0137), top: B:14:0x002b, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00fb A[Catch: JSONException -> 0x01cb, TryCatch #3 {JSONException -> 0x01cb, blocks: (B:15:0x002b, B:17:0x0035, B:18:0x003a, B:20:0x0040, B:21:0x0046, B:23:0x004c, B:24:0x0051, B:26:0x0057, B:27:0x005d, B:29:0x0063, B:30:0x0068, B:32:0x0072, B:33:0x0077, B:35:0x007d, B:37:0x0087, B:38:0x008c, B:40:0x0096, B:41:0x009b, B:43:0x00a5, B:44:0x00aa, B:46:0x00b4, B:47:0x00b9, B:49:0x00c3, B:50:0x00c8, B:52:0x00d2, B:53:0x00d7, B:55:0x00e1, B:56:0x00e6, B:58:0x00f0, B:59:0x00f5, B:61:0x00fb, B:63:0x0105, B:64:0x010a, B:66:0x0114, B:67:0x0119, B:69:0x0123, B:70:0x0128, B:72:0x0132, B:109:0x013d, B:75:0x0141, B:77:0x0147, B:78:0x014c, B:89:0x01a8, B:92:0x01b3, B:95:0x01bf, B:96:0x01c3, B:101:0x01c6, B:74:0x0137), top: B:14:0x002b, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0123 A[Catch: JSONException -> 0x01cb, TryCatch #3 {JSONException -> 0x01cb, blocks: (B:15:0x002b, B:17:0x0035, B:18:0x003a, B:20:0x0040, B:21:0x0046, B:23:0x004c, B:24:0x0051, B:26:0x0057, B:27:0x005d, B:29:0x0063, B:30:0x0068, B:32:0x0072, B:33:0x0077, B:35:0x007d, B:37:0x0087, B:38:0x008c, B:40:0x0096, B:41:0x009b, B:43:0x00a5, B:44:0x00aa, B:46:0x00b4, B:47:0x00b9, B:49:0x00c3, B:50:0x00c8, B:52:0x00d2, B:53:0x00d7, B:55:0x00e1, B:56:0x00e6, B:58:0x00f0, B:59:0x00f5, B:61:0x00fb, B:63:0x0105, B:64:0x010a, B:66:0x0114, B:67:0x0119, B:69:0x0123, B:70:0x0128, B:72:0x0132, B:109:0x013d, B:75:0x0141, B:77:0x0147, B:78:0x014c, B:89:0x01a8, B:92:0x01b3, B:95:0x01bf, B:96:0x01c3, B:101:0x01c6, B:74:0x0137), top: B:14:0x002b, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0132 A[Catch: JSONException -> 0x01cb, TRY_LEAVE, TryCatch #3 {JSONException -> 0x01cb, blocks: (B:15:0x002b, B:17:0x0035, B:18:0x003a, B:20:0x0040, B:21:0x0046, B:23:0x004c, B:24:0x0051, B:26:0x0057, B:27:0x005d, B:29:0x0063, B:30:0x0068, B:32:0x0072, B:33:0x0077, B:35:0x007d, B:37:0x0087, B:38:0x008c, B:40:0x0096, B:41:0x009b, B:43:0x00a5, B:44:0x00aa, B:46:0x00b4, B:47:0x00b9, B:49:0x00c3, B:50:0x00c8, B:52:0x00d2, B:53:0x00d7, B:55:0x00e1, B:56:0x00e6, B:58:0x00f0, B:59:0x00f5, B:61:0x00fb, B:63:0x0105, B:64:0x010a, B:66:0x0114, B:67:0x0119, B:69:0x0123, B:70:0x0128, B:72:0x0132, B:109:0x013d, B:75:0x0141, B:77:0x0147, B:78:0x014c, B:89:0x01a8, B:92:0x01b3, B:95:0x01bf, B:96:0x01c3, B:101:0x01c6, B:74:0x0137), top: B:14:0x002b, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0147 A[Catch: JSONException -> 0x01cb, TryCatch #3 {JSONException -> 0x01cb, blocks: (B:15:0x002b, B:17:0x0035, B:18:0x003a, B:20:0x0040, B:21:0x0046, B:23:0x004c, B:24:0x0051, B:26:0x0057, B:27:0x005d, B:29:0x0063, B:30:0x0068, B:32:0x0072, B:33:0x0077, B:35:0x007d, B:37:0x0087, B:38:0x008c, B:40:0x0096, B:41:0x009b, B:43:0x00a5, B:44:0x00aa, B:46:0x00b4, B:47:0x00b9, B:49:0x00c3, B:50:0x00c8, B:52:0x00d2, B:53:0x00d7, B:55:0x00e1, B:56:0x00e6, B:58:0x00f0, B:59:0x00f5, B:61:0x00fb, B:63:0x0105, B:64:0x010a, B:66:0x0114, B:67:0x0119, B:69:0x0123, B:70:0x0128, B:72:0x0132, B:109:0x013d, B:75:0x0141, B:77:0x0147, B:78:0x014c, B:89:0x01a8, B:92:0x01b3, B:95:0x01bf, B:96:0x01c3, B:101:0x01c6, B:74:0x0137), top: B:14:0x002b, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0191 A[Catch: Exception -> 0x01a8, TRY_LEAVE, TryCatch #2 {Exception -> 0x01a8, blocks: (B:81:0x018b, B:83:0x0191, B:86:0x0199, B:87:0x01a5), top: B:80:0x018b }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String c(android.content.Context r7, int r8, int r9) {
        /*
            Method dump skipped, instructions count: 460
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bc.b.c(android.content.Context, int, int):java.lang.String");
    }

    public static String d(Context context) {
        StringBuilder sb2 = new StringBuilder();
        String packageName = context.getPackageName();
        String str = (TextUtils.isEmpty(packageName) || !packageName.contains("com.sina.weibo")) ? "ssosdk" : "weibo";
        sb2.append(Build.MANUFACTURER);
        sb2.append("-");
        sb2.append(Build.MODEL);
        sb2.append("__");
        sb2.append(str);
        sb2.append("__");
        try {
            sb2.append("2.0".replaceAll("\\s+", "_"));
        } catch (Exception unused) {
            sb2.append("unknown");
        }
        sb2.append("__android__android");
        sb2.append(Build.VERSION.RELEASE);
        return sb2.toString();
    }

    public static String e(Context context) {
        try {
            return Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception unused) {
            return "";
        }
    }

    public static double f(Context context) {
        Object obj;
        try {
            obj = Class.forName("com.android.internal.os.PowerProfile").getConstructor(Context.class).newInstance(context);
        } catch (Exception unused) {
            obj = null;
        }
        try {
            return ((Double) Class.forName("com.android.internal.os.PowerProfile").getMethod("getAveragePower", String.class).invoke(obj, PowerProfile.POWER_BATTERY_CAPACITY)).doubleValue();
        } catch (Exception unused2) {
            return ShadowDrawableWrapper.COS_45;
        }
    }

    public static String g(Context context) {
        String str = "none";
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.getType() == 0) {
                    switch (activeNetworkInfo.getSubtype()) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            str = "2G";
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
                            str = "3G";
                            break;
                        case 13:
                            str = "4G";
                            break;
                    }
                } else if (activeNetworkInfo.getType() == 1) {
                    str = "wifi";
                }
            }
        } catch (Exception unused) {
        }
        return str;
    }

    public static String h() {
        try {
            return Build.CPU_ABI;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String i() {
        try {
            return Build.BRAND;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String j(Context context) {
        try {
            c.c(context);
            return c.a().b("ext_sso-oaid", "");
        } catch (Exception unused) {
            return "";
        }
    }

    public static String k(Context context) {
        return "";
    }

    public static String l(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String m(Context context) {
        return "";
    }

    public static String n(Context context) {
        WifiInfo connectionInfo;
        if (Build.VERSION.SDK_INT >= 23) {
            return o();
        }
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager != null && (connectionInfo = wifiManager.getConnectionInfo()) != null) {
                return connectionInfo.getMacAddress();
            }
        } catch (Exception unused) {
        }
        return "";
    }

    public static String o() {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "";
                    }
                    StringBuilder sb2 = new StringBuilder();
                    for (byte b4 : hardwareAddress) {
                        sb2.append(String.format("%02X:", Byte.valueOf(b4)));
                    }
                    if (sb2.length() > 0) {
                        sb2.deleteCharAt(sb2.length() - 1);
                    }
                    return sb2.toString();
                }
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String p(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String q(Context context, int i10, int i11) {
        try {
            return new String(c(context, i10, i11).getBytes(), "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    public static String r() {
        try {
            return Build.MODEL;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String s() {
        try {
            return "Android " + Build.VERSION.RELEASE;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String t(Context context) {
        c a10;
        try {
            c.c(context);
            a10 = c.a();
        } catch (Exception unused) {
        }
        if ("HUAWEI".equals(bc.a.a())) {
            return a10.b("HUAWEI-oaid", "");
        }
        if ("OPPO".equals(bc.a.a())) {
            return a10.b("OPPO-oaid", "");
        }
        if ("VIVO".equals(bc.a.a())) {
            return a10.b("VIVO-oaid", "");
        }
        if ("XIAOMI".equals(bc.a.a())) {
            return a10.b("XIAOMI-oaid", "");
        }
        return "";
    }

    public static String u(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(cls, str);
        } catch (Exception unused) {
            return "";
        }
    }

    public static String v(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return String.valueOf(displayMetrics.widthPixels) + StringUtils.NO_PRINT_CODE + String.valueOf(displayMetrics.heightPixels);
        } catch (Exception unused) {
            return "";
        }
    }

    public static String w() {
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return Long.toString(statFs.getBlockCount() * statFs.getBlockSize());
        } catch (Exception unused) {
            return "";
        }
    }

    public static String x() {
        if (Build.VERSION.SDK_INT >= 26) {
            return y();
        }
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(cls, "ro.serialno", "unknown");
        } catch (Exception unused) {
            return "";
        }
    }

    public static String y() {
        try {
            return Build.getSerial();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String z(Context context) {
        try {
            WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
            return connectionInfo != null ? connectionInfo.getSSID() : "";
        } catch (Exception unused) {
            return "";
        }
    }
}
