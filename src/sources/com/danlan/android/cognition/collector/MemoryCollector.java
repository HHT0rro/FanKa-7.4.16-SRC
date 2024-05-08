package com.danlan.android.cognition.collector;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.danlan.android.cognition.NativeLib;
import com.danlan.android.cognition.StringFog;
import com.danlan.android.cognition.collector.base.SubCollector;
import com.danlan.android.cognition.collector.util.SafeJSONObject;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class MemoryCollector extends SubCollector {
    private static String android_ctime = "";
    private static String android_mtime = "";
    private static String data_ctime = "";
    private static String data_mtime = "";
    private static String dicm_ctime = "";
    private static String dicm_mtime = "";
    private static String[] ext_root_dirs = {StringFog.decrypt("DlBQTFNCQ0QORklWTUJQREUMFA=="), StringFog.decrypt("DlBAQEBRQA=="), StringFog.decrypt("DlBQTFNCQ0QOUEBAQFFA")};
    private static String sdcard_ctime = "";
    private static String sdcard_mtime = "";
    private Context mcontext;

    public MemoryCollector(Context context, SafeJSONObject safeJSONObject) {
        super(context, safeJSONObject);
        this.mcontext = context;
    }

    private void getAndroidCreateTime() {
        try {
            if (NativeLib.checkLoadSo()) {
                for (String str : ext_root_dirs) {
                    JSONObject jSONObject = new JSONObject(NativeLib.ft(str + StringFog.decrypt("DmJKR1NMTUU=")));
                    android_ctime = jSONObject.getString(StringFog.decrypt("QldNTkQ="));
                    android_mtime = jSONObject.getString(StringFog.decrypt("TFdNTkQ="));
                    if (!TextUtils.isEmpty(android_ctime)) {
                        break;
                    }
                }
                if (TextUtils.isEmpty(android_ctime)) {
                    String externalStoragePath = getExternalStoragePath();
                    if (TextUtils.isEmpty(externalStoragePath)) {
                        return;
                    }
                    JSONObject jSONObject2 = new JSONObject(NativeLib.ft(externalStoragePath + StringFog.decrypt("DmJKR1NMTUU=")));
                    android_ctime = jSONObject2.getString(StringFog.decrypt("QldNTkQ="));
                    android_mtime = jSONObject2.getString(StringFog.decrypt("TFdNTkQ="));
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void getDCIMCreateTime() {
        try {
            if (NativeLib.checkLoadSo()) {
                for (String str : ext_root_dirs) {
                    JSONObject jSONObject = new JSONObject(NativeLib.ft(str + StringFog.decrypt("Dmdnamw=")));
                    dicm_ctime = jSONObject.getString(StringFog.decrypt("QldNTkQ="));
                    dicm_mtime = jSONObject.getString(StringFog.decrypt("TFdNTkQ="));
                    if (!TextUtils.isEmpty(dicm_ctime)) {
                        break;
                    }
                }
                if (TextUtils.isEmpty(dicm_ctime)) {
                    String externalStoragePath = getExternalStoragePath();
                    if (TextUtils.isEmpty(externalStoragePath)) {
                        return;
                    }
                    JSONObject jSONObject2 = new JSONObject(NativeLib.ft(externalStoragePath + StringFog.decrypt("Dmdnamw=")));
                    dicm_ctime = jSONObject2.getString(StringFog.decrypt("QldNTkQ="));
                    dicm_mtime = jSONObject2.getString(StringFog.decrypt("TFdNTkQ="));
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void getDataCreateTime() {
        try {
            if (NativeLib.checkLoadSo()) {
                JSONObject jSONObject = new JSONObject(NativeLib.ft(StringFog.decrypt(Build.VERSION.SDK_INT < 30 ? "DkdFV0AMQEBVQg==" : "UkdHQlNHC2BPR1ZMSEcLRUBXRQ==")));
                data_ctime = jSONObject.getString(StringFog.decrypt("QldNTkQ="));
                data_mtime = jSONObject.getString(StringFog.decrypt("TFdNTkQ="));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void getSdcardCreateTime() {
        try {
            if (NativeLib.checkLoadSo()) {
                for (String str : ext_root_dirs) {
                    JSONObject jSONObject = new JSONObject(NativeLib.ft(str));
                    sdcard_ctime = jSONObject.getString(StringFog.decrypt("QldNTkQ="));
                    sdcard_mtime = jSONObject.getString(StringFog.decrypt("TFdNTkQ="));
                    if (!TextUtils.isEmpty(sdcard_ctime)) {
                        break;
                    }
                }
                if (TextUtils.isEmpty(sdcard_ctime)) {
                    String externalStoragePath = getExternalStoragePath();
                    if (TextUtils.isEmpty(externalStoragePath)) {
                        return;
                    }
                    JSONObject jSONObject2 = new JSONObject(NativeLib.ft(externalStoragePath));
                    sdcard_ctime = jSONObject2.getString(StringFog.decrypt("QldNTkQ="));
                    sdcard_mtime = jSONObject2.getString(StringFog.decrypt("TFdNTkQ="));
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void collectSystemDirCreateTime() {
        getAndroidCreateTime();
        getDCIMCreateTime();
        getSdcardCreateTime();
        getDataCreateTime();
    }

    @Override // com.danlan.android.cognition.collector.base.SubCollector
    public void doCollectAutomatically() {
        SafeJSONObject safeJSONObject = new SafeJSONObject();
        try {
            safeJSONObject.put(StringFog.decrypt("VUxQQk1xZWw="), getTotalRAM());
            safeJSONObject.put(StringFog.decrypt("SUJXZllXQVNPQkhwZWBFU0U="), hasExternalSDCard());
            safeJSONObject.put(StringFog.decrypt("VUxQQk1qSlVEUUpCTW5BTE5RXXBIWUE="), getTotalInternalMemorySize());
            safeJSONObject.put(StringFog.decrypt("VUxQQk1mXFVEUUpCTW5BTE5RXXBIWUE="), getTotalExternalMemorySize());
            safeJSONObject.put(StringFog.decrypt("QFVFSk1CRk1EakpXRFFKQE1uQU5OUV1ySFlB"), getAvailableInternalMemorySize());
            safeJSONObject.put(StringFog.decrypt("QFVFSk1CRk1EZlxXRFFKQE1uQU5OUV1ySFlB"), getAvailableExternalMemorySize());
            safeJSONObject.put(StringFog.decrypt("RFtQRlNNRU1yV0tRQERBcUBXTA=="), getExternalStoragePath());
            collectSystemDirCreateTime();
            safeJSONObject.put(StringFog.decrypt("QE1AUU5KQH5CV01ORA=="), android_ctime);
            safeJSONObject.put(StringFog.decrypt("QE1AUU5KQH5MV01ORA=="), android_mtime);
            safeJSONObject.put(StringFog.decrypt("RUpHTn5AUEhMRg=="), dicm_ctime);
            safeJSONObject.put(StringFog.decrypt("RUpHTn5OUEhMRg=="), dicm_mtime);
            safeJSONObject.put(StringFog.decrypt("UkdHQlNHe0JVSklG"), sdcard_ctime);
            safeJSONObject.put(StringFog.decrypt("UkdHQlNHe0xVSklG"), sdcard_mtime);
            safeJSONObject.put(StringFog.decrypt("RUJQQn5AUEhMRg=="), data_ctime);
            safeJSONObject.put(StringFog.decrypt("RUJQQn5OUEhMRg=="), data_mtime);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        put(StringFog.decrypt("TEZJTFNa"), safeJSONObject);
        collectDone();
    }

    public final long getAvailableExternalMemorySize() {
        if (!hasExternalSDCard()) {
            return 0L;
        }
        try {
            StatFs statFs = Build.VERSION.SDK_INT < 30 ? new StatFs(Environment.getExternalStorageDirectory().getPath()) : new StatFs(this.mcontext.getExternalFilesDir("").getAbsolutePath());
            return statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong();
        } catch (Exception unused) {
            return 0L;
        }
    }

    public final long getAvailableInternalMemorySize() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong();
        } catch (Exception unused) {
            return 0L;
        }
    }

    public final String getExternalStoragePath() {
        try {
            return Environment.getExternalStorageDirectory().getPath();
        } catch (Exception unused) {
            return "";
        }
    }

    public final long getTotalExternalMemorySize() {
        if (!hasExternalSDCard()) {
            return 0L;
        }
        try {
            StatFs statFs = Build.VERSION.SDK_INT < 30 ? new StatFs(Environment.getExternalStorageDirectory().getPath()) : new StatFs(this.mcontext.getExternalFilesDir("").getAbsolutePath());
            return statFs.getBlockCountLong() * statFs.getBlockSizeLong();
        } catch (Exception unused) {
            return 0L;
        }
    }

    public final long getTotalInternalMemorySize() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getBlockCountLong() * statFs.getBlockSizeLong();
        } catch (Exception unused) {
            return 0L;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:1|2|(5:4|5|6|7|8)|14|5|6|7|8) */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x004b, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x004c, code lost:
    
        r2.printStackTrace();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Long getTotalRAM() {
        /*
            r6 = this;
            android.app.ActivityManager$MemoryInfo r0 = new android.app.ActivityManager$MemoryInfo     // Catch: java.lang.Exception -> L1b
            r0.<init>()     // Catch: java.lang.Exception -> L1b
            android.content.Context r1 = r6.mcontext     // Catch: java.lang.Exception -> L1b
            java.lang.String r2 = "QEBQSldKUFg="
            java.lang.String r2 = com.danlan.android.cognition.StringFog.decrypt(r2)     // Catch: java.lang.Exception -> L1b
            java.lang.Object r1 = r1.getSystemService(r2)     // Catch: java.lang.Exception -> L1b
            android.app.ActivityManager r1 = (android.app.ActivityManager) r1     // Catch: java.lang.Exception -> L1b
            if (r1 == 0) goto L1f
            r1.getMemoryInfo(r0)     // Catch: java.lang.Exception -> L1b
            long r0 = r0.totalMem     // Catch: java.lang.Exception -> L1b
            goto L21
        L1b:
            r0 = move-exception
            r0.printStackTrace()
        L1f:
            r0 = 0
        L21:
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile     // Catch: java.lang.Exception -> L4b
            java.lang.String r3 = "DlNWTEIMSURMSkpFTg=="
            java.lang.String r3 = com.danlan.android.cognition.StringFog.decrypt(r3)     // Catch: java.lang.Exception -> L4b
            java.lang.String r4 = "Uw=="
            java.lang.String r4 = com.danlan.android.cognition.StringFog.decrypt(r4)     // Catch: java.lang.Exception -> L4b
            r2.<init>(r3, r4)     // Catch: java.lang.Exception -> L4b
            java.lang.String r3 = r2.readLine()     // Catch: java.lang.Exception -> L4b
            java.lang.String r4 = "fWcP"
            java.lang.String r4 = com.danlan.android.cognition.StringFog.decrypt(r4)     // Catch: java.lang.Exception -> L4b
            java.lang.String r5 = ""
            java.lang.String r3 = r3.replaceAll(r4, r5)     // Catch: java.lang.Exception -> L4b
            int r0 = java.lang.Integer.parseInt(r3)     // Catch: java.lang.Exception -> L4b
            long r0 = (long) r0     // Catch: java.lang.Exception -> L4b
            r2.close()     // Catch: java.lang.Exception -> L4b
            goto L4f
        L4b:
            r2 = move-exception
            r2.printStackTrace()
        L4f:
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.danlan.android.cognition.collector.MemoryCollector.getTotalRAM():java.lang.Long");
    }

    public final boolean hasExternalSDCard() {
        try {
            return Environment.getExternalStorageState().equals(StringFog.decrypt("TExRTVVGQA=="));
        } catch (Exception unused) {
            return false;
        }
    }
}
