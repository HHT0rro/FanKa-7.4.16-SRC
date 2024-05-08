package com.wangmai.adIdUtils.oaid;

import android.app.Application;
import android.content.Context;
import android.media.MediaDrm;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.huawei.hms.ads.jsb.constant.Constant;
import com.kuaishou.weapon.p0.g;
import com.wangmai.adIdUtils.oaid.impl.OAIDFactory;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.UUID;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class DeviceID implements IGetter {
    public Application application;
    public String clientId;
    public String oaid;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class Holder {
        public static final DeviceID INSTANCE = new DeviceID();
    }

    public static String calculateHash(String str, String str2) {
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
        } catch (Throwable th) {
            OAIDLog.print(th);
            return "";
        }
    }

    public static String getAndroidID(Context context) {
        String string;
        return (context == null || (string = Settings.Secure.getString(context.getContentResolver(), "android_id")) == null || "9774d56d682e549c".equals(string)) ? "" : string;
    }

    public static String getClientId() {
        String str = Holder.INSTANCE.clientId;
        return str == null ? "" : str;
    }

    public static String getClientIdMD5() {
        return calculateHash(getClientId(), "MD5");
    }

    public static String getClientIdSHA1() {
        return calculateHash(getClientId(), "SHA-1");
    }

    public static String getGUID(Context context) {
        String uuidFromSystemSettings = getUuidFromSystemSettings(context);
        if (TextUtils.isEmpty(uuidFromSystemSettings)) {
            uuidFromSystemSettings = getUuidFromExternalStorage(context);
        }
        if (TextUtils.isEmpty(uuidFromSystemSettings)) {
            uuidFromSystemSettings = getUuidFromSharedPreferences(context);
        }
        if (!TextUtils.isEmpty(uuidFromSystemSettings)) {
            return uuidFromSystemSettings;
        }
        String uuid = UUID.randomUUID().toString();
        OAIDLog.print("Generate uuid by random: " + uuid);
        saveUuidToSharedPreferences(context, uuid);
        saveUuidToSystemSettings(context, uuid);
        saveUuidToExternalStorage(context, uuid);
        return uuid;
    }

    public static File getGuidFile(Context context) {
        int i10 = Build.VERSION.SDK_INT;
        boolean z10 = true;
        if (i10 >= 23 && (i10 >= 30 || context == null || context.checkSelfPermission(g.f36124j) != 0)) {
            z10 = false;
        }
        if (z10 && "mounted".equals(Environment.getExternalStorageState())) {
            return new File(Environment.getExternalStorageDirectory(), "Android/.GUID_uuid");
        }
        return null;
    }

    public static String getIMEI(Context context) {
        if (context == null) {
            return "";
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            String imei = telephonyManager.getImei();
            return TextUtils.isEmpty(imei) ? telephonyManager.getMeid() : imei;
        } catch (Exception e2) {
            OAIDLog.print(e2);
            return "";
        } catch (Throwable th) {
            OAIDLog.print(th);
            return "";
        }
    }

    public static String getOAID() {
        String str = Holder.INSTANCE.oaid;
        return str == null ? "" : str;
    }

    public static String getPseudoID() {
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

    public static String getUniqueID(Context context) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 29) {
            OAIDLog.print("IMEI/MEID not allowed on Android 10+");
            return "";
        }
        if (context == null) {
            return "";
        }
        if (i10 >= 23 && context.checkSelfPermission(g.f36117c) != 0) {
            OAIDLog.print("android.permission.READ_PHONE_STATE not granted");
            return "";
        }
        return getIMEI(context);
    }

    public static String getUuidFromExternalStorage(Context context) {
        String str = "";
        if (context == null) {
            return "";
        }
        File guidFile = getGuidFile(context);
        if (guidFile != null) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(guidFile));
                try {
                    str = bufferedReader.readLine();
                    bufferedReader.close();
                } finally {
                }
            } catch (Throwable th) {
                OAIDLog.print(th);
            }
        }
        OAIDLog.print("Get uuid from external storage: " + str);
        return str;
    }

    public static String getUuidFromSharedPreferences(Context context) {
        if (context == null) {
            return "";
        }
        String string = context.getSharedPreferences("GUID", 0).getString(Constant.MAP_KEY_UUID, "");
        OAIDLog.print("Get uuid from shared preferences: " + string);
        return string;
    }

    public static String getUuidFromSystemSettings(Context context) {
        if (context == null) {
            return "";
        }
        String string = Settings.System.getString(context.getContentResolver(), "GUID_uuid");
        OAIDLog.print("Get uuid from system settings: " + string);
        return string;
    }

    public static String getWidevineID() {
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
        } catch (Exception e2) {
            OAIDLog.print(e2);
            return "";
        } catch (Throwable th) {
            OAIDLog.print(th);
            return "";
        }
    }

    public static void register(Application application) {
        if (application == null) {
            return;
        }
        DeviceID deviceID = Holder.INSTANCE;
        deviceID.application = application;
        String uniqueID = getUniqueID(application);
        if (!TextUtils.isEmpty(uniqueID)) {
            deviceID.clientId = uniqueID;
            OAIDLog.print("Client id is IMEI/MEID: " + deviceID.clientId);
            return;
        }
        getOAID(application, deviceID);
    }

    public static void saveUuidToExternalStorage(Context context, String str) {
        if (context == null) {
            return;
        }
        File guidFile = getGuidFile(context);
        if (guidFile == null) {
            OAIDLog.print("UUID file in external storage is null");
            return;
        }
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(guidFile));
            try {
                if (!guidFile.exists()) {
                    guidFile.createNewFile();
                }
                bufferedWriter.write(str);
                bufferedWriter.flush();
                OAIDLog.print("Save uuid to external storage: " + str);
                bufferedWriter.close();
            } finally {
            }
        } catch (Throwable th) {
            OAIDLog.print(th);
        }
    }

    public static void saveUuidToSharedPreferences(Context context, String str) {
        if (context == null) {
            return;
        }
        context.getSharedPreferences("GUID", 0).edit().putString(Constant.MAP_KEY_UUID, str).apply();
        OAIDLog.print("Save uuid to shared preferences: " + str);
    }

    public static void saveUuidToSystemSettings(Context context, String str) {
        if (context == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 23 && !Settings.System.canWrite(context)) {
            OAIDLog.print("android.permission.WRITE_SETTINGS not granted");
            return;
        }
        try {
            Settings.System.putString(context.getContentResolver(), "GUID_uuid", str);
            OAIDLog.print("Save uuid to system settings: " + str);
        } catch (Throwable th) {
            OAIDLog.print(th);
        }
    }

    public static boolean supportedOAID(Context context) {
        return OAIDFactory.create(context).supported();
    }

    @Override // com.wangmai.adIdUtils.oaid.IGetter
    public void onOAIDGetComplete(String str) {
        if (TextUtils.isEmpty(str)) {
            onOAIDGetError(new OAIDException("OAID is empty"));
            return;
        }
        this.clientId = str;
        this.oaid = str;
        OAIDLog.print("Client id is OAID/AAID: " + this.clientId);
    }

    @Override // com.wangmai.adIdUtils.oaid.IGetter
    public void onOAIDGetError(Exception exc) {
        String widevineID = getWidevineID();
        if (!TextUtils.isEmpty(widevineID)) {
            this.clientId = widevineID;
            OAIDLog.print("Client id is WidevineID: " + this.clientId);
            return;
        }
        String androidID = getAndroidID(this.application);
        if (!TextUtils.isEmpty(androidID)) {
            this.clientId = androidID;
            OAIDLog.print("Client id is AndroidID: " + this.clientId);
            return;
        }
        this.clientId = getGUID(this.application);
        OAIDLog.print("Client id is GUID: " + this.clientId);
    }

    public DeviceID() {
    }

    public static void getOAID(Context context, IGetter iGetter) {
        OAIDFactory.create(context).doGet(iGetter);
    }
}
