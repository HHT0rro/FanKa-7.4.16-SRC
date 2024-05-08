package wc;

import android.app.Application;
import android.content.Context;
import android.media.MediaDrm;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.huawei.hms.ads.jsb.constant.Constant;
import com.tanx.onlyid.api.OAIDException;
import com.wangmai.common.utils.PrivateInfoHelper;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.UUID;
import xc.l;

/* compiled from: DeviceID.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class a implements c {

    /* renamed from: a, reason: collision with root package name */
    public Application f54325a;

    /* renamed from: b, reason: collision with root package name */
    public String f54326b;

    /* renamed from: c, reason: collision with root package name */
    public String f54327c;

    /* compiled from: DeviceID.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static final a f54328a = new a();
    }

    public static String a() {
        String str = b.f54328a.f54326b;
        return str == null ? "" : str;
    }

    public static String b(Context context) {
        String string;
        return (context == null || (string = Settings.Secure.getString(context.getContentResolver(), "android_id")) == null || "9774d56d682e549c".equals(string)) ? "" : string;
    }

    public static String c(Context context, int i10) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return (String) telephonyManager.getClass().getMethod("getImei", Integer.TYPE).invoke(telephonyManager, Integer.valueOf(i10));
        } catch (Exception e2) {
            f.a(e2);
            return "";
        }
    }

    public static String d(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            byte[] digest = MessageDigest.getInstance(str2).digest(str.getBytes());
            StringBuilder sb2 = new StringBuilder();
            for (byte b4 : digest) {
                sb2.append(String.format("%02x", Byte.valueOf(b4)));
            }
            return sb2.toString();
        } catch (Exception e2) {
            f.a(e2);
            return "";
        }
    }

    public static void e(Application application) {
        if (application == null) {
            return;
        }
        b.f54328a.f54325a = application;
    }

    public static void f(Context context, String str) {
        if (context == null) {
            return;
        }
        File k10 = k(context);
        if (k10 == null) {
            f.a("UUID file in external storage is null");
            return;
        }
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(k10));
            try {
                if (!k10.exists()) {
                    k10.createNewFile();
                }
                bufferedWriter.write(str);
                bufferedWriter.flush();
                f.a("Save uuid to external storage: " + str);
                bufferedWriter.close();
            } finally {
            }
        } catch (Exception e2) {
            f.a(e2);
        }
    }

    public static void g(Context context, c cVar) {
        l.a(context).a(cVar);
    }

    public static String h() {
        return d(a(), "MD5");
    }

    public static String i(Context context) {
        String t2 = t(context);
        if (TextUtils.isEmpty(t2)) {
            t2 = r(context);
        }
        if (TextUtils.isEmpty(t2)) {
            t2 = s(context);
        }
        if (!TextUtils.isEmpty(t2)) {
            return t2;
        }
        String uuid = UUID.randomUUID().toString();
        f.a("Generate uuid by random: " + uuid);
        j(context, uuid);
        l(context, uuid);
        f(context, uuid);
        return uuid;
    }

    public static void j(Context context, String str) {
        if (context == null) {
            return;
        }
        context.getSharedPreferences("GUID", 0).edit().putString(Constant.MAP_KEY_UUID, str).apply();
        f.a("Save uuid to shared preferences: " + str);
    }

    public static File k(Context context) {
        int i10 = Build.VERSION.SDK_INT;
        boolean z10 = true;
        if (i10 >= 23 && (i10 >= 30 || context == null || context.checkSelfPermission(com.kuaishou.weapon.p0.g.f36124j) != 0)) {
            z10 = false;
        }
        if (z10 && "mounted".equals(Environment.getExternalStorageState())) {
            return new File(Environment.getExternalStorageDirectory(), "Android/.GUID_uuid");
        }
        return null;
    }

    public static void l(Context context, String str) {
        if (context == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 23 && !Settings.System.canWrite(context)) {
            f.a("android.permission.WRITE_SETTINGS not granted");
            return;
        }
        try {
            Settings.System.putString(context.getContentResolver(), "GUID_uuid", str);
            f.a("Save uuid to system settings: " + str);
        } catch (Exception e2) {
            f.a(e2);
        }
    }

    public static String m() {
        String str = b.f54328a.f54327c;
        return str == null ? "" : str;
    }

    public static String n(Context context) {
        f.b("OnlyId", "getIMEI");
        if (context == null) {
            return "";
        }
        try {
            String imei = ((TelephonyManager) context.getSystemService("phone")).getImei();
            return TextUtils.isEmpty(imei) ? c(context, 0) : imei;
        } catch (Error e2) {
            f.a(e2);
            return "";
        } catch (Exception e10) {
            f.a(e10);
            return "";
        }
    }

    public static String o() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(Build.BOARD.length() % 10);
        sb2.append(Arrays.deepToString(Build.SUPPORTED_ABIS).length() % 10);
        sb2.append(Build.DEVICE.length() % 10);
        sb2.append(Build.DISPLAY.length() % 10);
        sb2.append(Build.HOST.length() % 10);
        sb2.append(Build.ID.length() % 10);
        sb2.append(Build.MANUFACTURER.length() % 10);
        sb2.append(Build.BRAND.length() % 10);
        sb2.append(Build.MODEL.length() % 10);
        sb2.append(Build.PRODUCT.length() % 10);
        sb2.append(Build.BOOTLOADER.length() % 10);
        sb2.append(Build.HARDWARE.length() % 10);
        sb2.append(Build.TAGS.length() % 10);
        sb2.append(Build.TYPE.length() % 10);
        sb2.append(Build.USER.length() % 10);
        return sb2.toString();
    }

    public static String p(Context context) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 29) {
            f.a("IMEI/MEID not allowed on Android 10+");
            return "";
        }
        if (context == null) {
            return "";
        }
        if (i10 >= 23 && context.checkSelfPermission(com.kuaishou.weapon.p0.g.f36117c) != 0) {
            f.a("android.permission.READ_PHONE_STATE not granted");
            return "";
        }
        return n(context);
    }

    public static String q() {
        try {
            byte[] propertyByteArray = new MediaDrm(new UUID(-1301668207276963122L, -6645017420763422227L)).getPropertyByteArray("deviceUniqueId");
            if (propertyByteArray == null) {
                return "";
            }
            StringBuilder sb2 = new StringBuilder();
            for (byte b4 : propertyByteArray) {
                sb2.append(String.format("%02x", Byte.valueOf(b4)));
            }
            return sb2.toString();
        } catch (Error e2) {
            f.a(e2);
            return "";
        } catch (Exception e10) {
            f.a(e10);
            return "";
        }
    }

    public static String r(Context context) {
        String str = "";
        if (context == null) {
            return "";
        }
        File k10 = k(context);
        if (k10 != null) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(k10));
                try {
                    str = bufferedReader.readLine();
                    bufferedReader.close();
                } finally {
                }
            } catch (Exception e2) {
                f.a(e2);
            }
        }
        f.a("Get uuid from external storage: " + str);
        return str;
    }

    public static String s(Context context) {
        if (context == null) {
            return "";
        }
        String string = context.getSharedPreferences("GUID", 0).getString(Constant.MAP_KEY_UUID, "");
        f.a("Get uuid from shared preferences: " + string);
        return string;
    }

    public static String t(Context context) {
        if (context == null) {
            return "";
        }
        String string = Settings.System.getString(context.getContentResolver(), "GUID_uuid");
        f.a("Get uuid from system settings: " + string);
        return string;
    }

    @Override // wc.c
    public void oaidError(Exception exc) {
        String q10 = q();
        if (!TextUtils.isEmpty(q10)) {
            this.f54326b = q10;
            f.a("Client id is WidevineID: " + this.f54326b);
            return;
        }
        String b4 = b(this.f54325a);
        if (!TextUtils.isEmpty(b4)) {
            this.f54326b = b4;
            f.a("Client id is AndroidID: " + this.f54326b);
            return;
        }
        this.f54326b = i(this.f54325a);
        f.a("Client id is GUID: " + this.f54326b);
    }

    @Override // wc.c
    public void oaidSucc(String str) {
        if (TextUtils.isEmpty(str)) {
            oaidError(new OAIDException("OAID is empty"));
            return;
        }
        this.f54326b = str;
        this.f54327c = str;
        f.a("Client id is OAID/AAID: " + this.f54326b);
        e.d(this.f54325a).e(PrivateInfoHelper.KEY_OAID, this.f54327c);
    }

    public a() {
    }
}
