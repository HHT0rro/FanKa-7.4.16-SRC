package com.danlan.android.cognition.collector;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.danlan.android.cognition.NativeLib;
import com.danlan.android.cognition.StringFog;
import com.danlan.android.cognition.collector.base.SubCollector;
import com.danlan.android.cognition.collector.util.CMDUtil;
import com.danlan.android.cognition.collector.util.PermissionUtil;
import com.danlan.android.cognition.collector.util.SafeJSONObject;
import com.danlan.android.cognition.common.HashUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class AppCollector extends SubCollector {
    private Context mcontext;
    private PackageManager packageManager;
    private final PermissionUtil permissionUtils;
    private static final String[] list = {StringFog.decrypt("QkxJDVVGSkJETVANTE4="), StringFog.decrypt("QkxJDVJQCkBPR1ZMSEcKVEZACkJWRklE"), StringFog.decrypt("QkxJDVJOTU1EDUNKR05FSkRR"), StringFog.decrypt("QkxJDVVGSkJETVANTExGSE1GVVI="), StringFog.decrypt("QkxJDVlWSkxETUMNUUpKRVRMQFZO"), StringFog.decrypt("QkxJDURECkBPR1ZMSEcKYE1KVEJYZFRJTk1B"), StringFog.decrypt("QkxJDVJQCkBPR1ZMSEcKQFNXTUBNRgpPRFRX")};
    private static final String[] multi_open_app_list = {StringFog.decrypt("QkxJDVBKTE5ODUlCRkpH"), StringFog.decrypt("QkxJDUNPXQ9FSFRPQFc="), StringFog.decrypt("QkxJDUVRS0gPQkBMQkhBUw9TVkw="), StringFog.decrypt("QkxJDUlaCkJNTEpG"), StringFog.decrypt("QkxJDVJLQURREQpbWEVX"), StringFog.decrypt("QkxJDUNMSFgPVFxOVE9QTlFGSg=="), StringFog.decrypt("Qk0KQElWR0gPQkpHD1RPR0RNV0tETQ=="), StringFog.decrypt("QkxJDUdGSEhZDUdPTk1BRURP"), StringFog.decrypt("QkxJDVlWSlNUSgpEQE5BUkBEQ1FEREVVTlE="), StringFog.decrypt("QkxJDUdGSEhZDUlWTVdBTUc="), StringFog.decrypt("QkxJDUlWTVNWDUBIR1A="), StringFog.decrypt("QkxJDU1aSEwPR09ZUg=="), StringFog.decrypt("QkxJDVlaXg9XQUtb"), StringFog.decrypt("QkxJDU1BQQ9RQlZCTU9BTQ=="), StringFog.decrypt("QkxJDVNGQEdITUNGUw1FUVE="), StringFog.decrypt("QkxJDVdOS1IPQlRT"), StringFog.decrypt("QkxJDUcSVE1AWkFR"), StringFog.decrypt("QkxJDVdTTE5PRkNCRkIKVUhXRU0="), StringFog.decrypt("QkxJDVkbXlIPUEVNRUFLWQ=="), StringFog.decrypt("QkxJDVhKVUhATUMNWU5FUlVGVg=="), StringFog.decrypt("QkxJDVdOS1IPU1ZM"), StringFog.decrypt("RUhUT1RETU8PV0VMD05UQg=="), StringFog.decrypt("SEwKVUhRUFRAT0VTUQ=="), StringFog.decrypt("QkxJDURbR0RNT01CT0BBD0xWSFdIQkdCTlZKV1I="), StringFog.decrypt("QkxJDURbR0RNT01CT0BBD0xWSFdIQkdCTlZKVw=="), StringFog.decrypt("QkxJDURbR0RNT01CT0BBD0xWSFdIQkdCTlZKVw9CV1JIUFA="), StringFog.decrypt("QkxJDUVWRU1SU0VARA1JVE1XTVBRQkdED0JKR1NMTUU="), StringFog.decrypt("RUwKTlRPUEhRT0ENQk9LT0RRCkJTThcT"), StringFog.decrypt("QkxJDU1WQEBSS00NRVZFTVJTRUBEU1ZOWQ=="), StringFog.decrypt("QkxJDU1BQQ9RQlZCTU9BTQ9KSldN"), StringFog.decrypt("QkxJDU1BQQ9RQlZCTU9BTQ9KSldNDUVTTBUQ"), StringFog.decrypt("QkxJDVtKUw9NVkdIWA1UQFVATEZT"), StringFog.decrypt("U1YKUFlBUWVHWwpTZ3BrWEBEVmU="), StringFog.decrypt("QkxJDU1WQEBSS00NUlZURFNBS0xSVw==")};
    private static final String[] hack_tools_app_list = {StringFog.decrypt("QkxJDVVMVEtOS0pUVA1JQEZKV0g="), StringFog.decrypt("TlFDDUxGS1ZCQlANREdcUU5QQUcPTkVPQERBUQ=="), StringFog.decrypt("RUYKUU5BUg9ATUBRTkpAD1lTS1BERwpIT1BQQk1PQVM="), StringFog.decrypt("TEYKVERKV0lUDUFbUQ=="), StringFog.decrypt("SEwKVUANQVlRTFdGRQ==")};
    private static final String[] auto_tools_app_list = {StringFog.decrypt("TlFDDU5TQU9QQgpQRE9BT0hWSQ1ATUBTTkpADUBTVA=="), StringFog.decrypt("SEwKUERPQU9FUUtKRQ1QRFJXRVNR"), StringFog.decrypt("QkxJDUpCVlVADVBMTk9XD0BWUExCT01CSkZWRVNGQQ=="), StringFog.decrypt("QkxJDVJTQURFDUNAD0JRVU5ASEpCSEFTD0JRV05ORVVIQFBCUQ=="), StringFog.decrypt("QkxJDVZGV1VWTFZIUg1FUVFQCkJUV0tCTUpHSERR"), StringFog.decrypt("QkxJDVJLUUxASgpQSVZAQFlKRQ=="), StringFog.decrypt("QkxJDUBWUE5CT01ASkZWD1VCVFNITUMPQFZQTEJPTUJKDUdPSEBPRFMNR09IQE9EU0VLUUZCSUQ="), StringFog.decrypt("QkxJDUtCT0QPV0tWQktJQEJRSw1RUUs="), StringFog.decrypt("QkxJDVJLRU9bS00NQk9NQkpGVg=="), StringFog.decrypt("QkxJDVtKQE5PREBKQE1OSA=="), StringFog.decrypt("QkxJDVtKQE5PREBKQE1OSA9CUVdOQEhIQkhBUQ==")};

    public AppCollector(Context context, SafeJSONObject safeJSONObject) {
        super(context, safeJSONObject);
        this.permissionUtils = new PermissionUtil(context);
        this.mcontext = context;
        this.packageManager = context.getPackageManager();
    }

    private String getAppInstallTime(String str) {
        String str2 = "";
        if (new File(str).exists()) {
            for (String str3 : CMDUtil.executeCMD(new String[]{StringFog.decrypt("UldFVwE=") + str}, 1)) {
                if (str3.contains(StringFog.decrypt("YEBHRlJQHg=="))) {
                    String trim = str3.split(StringFog.decrypt("YEBHRlJQHg=="))[1].trim();
                    if (!trim.startsWith(StringFog.decrypt("CQ=="))) {
                        str2 = trim;
                    }
                }
            }
        }
        return str2;
    }

    private List<String> getTargetSystemPkgList(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        try {
            for (String str : strArr) {
                arrayList.add(str);
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    public final boolean checkAutoTools() {
        for (String str : auto_tools_app_list) {
            try {
                this.packageManager.getPackageInfo(str, 0);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public final SafeJSONObject checkCommonApp(Context context) {
        SafeJSONObject safeJSONObject = new SafeJSONObject();
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(getTargetSystemPkgList(list));
            Iterator iterator2 = arrayList.iterator2();
            while (iterator2.hasNext()) {
                String str = (String) iterator2.next();
                PackageInfo packageInfo = null;
                try {
                    packageInfo = this.packageManager.getPackageInfo(str, 0);
                } catch (Throwable unused) {
                }
                if (packageInfo != null) {
                    try {
                        if ((packageInfo.applicationInfo.flags & 1) == 0) {
                            SafeJSONObject safeJSONObject2 = new SafeJSONObject();
                            safeJSONObject2.put(StringFog.decrypt("R09FRA=="), 1);
                            safeJSONObject2.put(StringFog.decrypt("V0ZWUEhMSg=="), packageInfo.versionName);
                            String str2 = packageInfo.applicationInfo.sourceDir;
                            String str3 = "";
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    if (NativeLib.checkLoadSo()) {
                                        str3 = new JSONObject(NativeLib.ft(str2)).getString(StringFog.decrypt("QldNTkQ="));
                                    }
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                            safeJSONObject2.put(StringFog.decrypt("SE1XV0BPSHVITkE="), str3);
                            safeJSONObject.put(str, safeJSONObject2);
                        }
                    } catch (Exception unused2) {
                    }
                }
            }
        } catch (Throwable unused3) {
        }
        return safeJSONObject;
    }

    public final SafeJSONObject checkHackTools() {
        SafeJSONObject safeJSONObject = new SafeJSONObject();
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(getTargetSystemPkgList(hack_tools_app_list));
            Iterator iterator2 = arrayList.iterator2();
            while (iterator2.hasNext()) {
                String str = (String) iterator2.next();
                try {
                    PackageInfo packageInfo = this.packageManager.getPackageInfo(str, 0);
                    if (packageInfo != null && (packageInfo.applicationInfo.flags & 1) == 0) {
                        SafeJSONObject safeJSONObject2 = new SafeJSONObject();
                        safeJSONObject2.put(StringFog.decrypt("V0ZWUEhMSg=="), packageInfo.versionName);
                        String str2 = packageInfo.applicationInfo.sourceDir;
                        String str3 = "";
                        if (!TextUtils.isEmpty(str2)) {
                            try {
                                if (NativeLib.checkLoadSo()) {
                                    str3 = new JSONObject(NativeLib.ft(str2)).getString(StringFog.decrypt("QldNTkQ="));
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                        safeJSONObject2.put(StringFog.decrypt("SE1XV0BPSHVITkE="), str3);
                        safeJSONObject.put(str, safeJSONObject2);
                    }
                } catch (Exception unused) {
                }
            }
        } catch (Throwable unused2) {
        }
        return safeJSONObject;
    }

    public final SafeJSONObject checkMultiOpenApp(Context context) {
        SafeJSONObject safeJSONObject = new SafeJSONObject();
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(getTargetSystemPkgList(multi_open_app_list));
            Iterator iterator2 = arrayList.iterator2();
            while (iterator2.hasNext()) {
                String str = (String) iterator2.next();
                PackageInfo packageInfo = null;
                try {
                    packageInfo = this.packageManager.getPackageInfo(str, 0);
                } catch (Throwable unused) {
                }
                if (packageInfo != null) {
                    try {
                        if ((packageInfo.applicationInfo.flags & 1) == 0) {
                            SafeJSONObject safeJSONObject2 = new SafeJSONObject();
                            safeJSONObject2.put(StringFog.decrypt("V0ZWUEhMSg=="), packageInfo.versionName);
                            String str2 = packageInfo.applicationInfo.sourceDir;
                            String str3 = "";
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    if (NativeLib.checkLoadSo()) {
                                        str3 = new JSONObject(NativeLib.ft(str2)).getString(StringFog.decrypt("QldNTkQ="));
                                    }
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                            safeJSONObject2.put(StringFog.decrypt("SE1XV0BPSHVITkE="), str3);
                            safeJSONObject.put(str, safeJSONObject2);
                        }
                    } catch (Exception unused2) {
                    }
                }
            }
        } catch (Throwable unused3) {
        }
        return safeJSONObject;
    }

    @Override // com.danlan.android.cognition.collector.base.SubCollector
    public void doCollectAutomatically() {
        SafeJSONObject safeJSONObject = new SafeJSONObject();
        try {
            safeJSONObject.put(StringFog.decrypt("QFNUbUBOQQ=="), getAppName());
            safeJSONObject.put(StringFog.decrypt("QFNUdURRV0hOTWdMRUY="), getVersionCode());
            safeJSONObject.put(StringFog.decrypt("QFNUdURRV0hOTWpCTEY="), getVersionName());
            safeJSONObject.put(StringFog.decrypt("QFNUcEhESkBVVlZGbGcR"), getAppSignatureMD5());
            safeJSONObject.put(StringFog.decrypt("QFNPak9QUEBNT3RCVUs="), getApkInstallPath());
            safeJSONObject.put(StringFog.decrypt("QFNPc0BAT0BGRmpCTEY="), getAppPackageName());
            safeJSONObject.put(StringFog.decrypt("UUZWTkhQV0hOTWhKUlc="), getPermissionState());
            safeJSONObject.put(StringFog.decrypt("R0pWUFVqSlJVQkhPdUpJRA=="), getInstallAppTime());
            safeJSONObject.put(StringFog.decrypt("TUJXV3RTQEBVRnBKTEY="), getLastUpdateTime());
            safeJSONObject.put(StringFog.decrypt("RUJQQnFCUEk="), getDataPath());
            safeJSONObject.put(StringFog.decrypt("QkxJTk5OZVFR"), checkCommonApp(this.mcontext));
            safeJSONObject.put(StringFog.decrypt("UVFLQERQV2hPRUs="), getProcessInfo());
            safeJSONObject.put(StringFog.decrypt("TFZIV0hsVERPYlRT"), checkMultiOpenApp(this.mcontext));
            safeJSONObject.put(StringFog.decrypt("SUJHSHVMS01SYlRT"), checkHackTools());
            safeJSONObject.put(StringFog.decrypt("SUJXYlRXS3VOTEhQYFNU"), checkAutoTools());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        put(StringFog.decrypt("QFNUT0hARVVITEo="), safeJSONObject);
        collectDone();
    }

    public final String getApkInstallPath() {
        try {
            return this.mcontext.getApplicationContext().getPackageCodePath();
        } catch (Exception unused) {
            return null;
        }
    }

    public final String getAppName() {
        ApplicationInfo applicationInfo;
        try {
            applicationInfo = this.packageManager.getApplicationInfo(this.mcontext.getApplicationInfo().packageName, 0);
        } catch (Exception unused) {
            applicationInfo = null;
        }
        return (String) (applicationInfo != null ? this.packageManager.getApplicationLabel(applicationInfo) : null);
    }

    public final String getAppPackageName() {
        return this.mcontext.getApplicationInfo().packageName;
    }

    public final String getAppSignatureMD5() {
        try {
            return HashUtil.md5(this.packageManager.getPackageInfo(this.mcontext.getPackageName(), 64).signatures[0].toByteArray());
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public final String getDataPath() {
        return this.mcontext.getApplicationInfo().dataDir;
    }

    public final long getInstallAppTime() {
        try {
            PackageInfo packageInfo = this.packageManager.getPackageInfo(this.mcontext.getPackageName(), 0);
            if (packageInfo != null && packageInfo.applicationInfo != null) {
                return packageInfo.firstInstallTime / 1000;
            }
        } catch (Exception unused) {
        }
        return 0L;
    }

    public final long getLastUpdateTime() {
        try {
            PackageInfo packageInfo = this.packageManager.getPackageInfo(this.mcontext.getPackageName(), 0);
            if (packageInfo != null && packageInfo.applicationInfo != null) {
                return packageInfo.lastUpdateTime / 1000;
            }
        } catch (Exception unused) {
        }
        return 0L;
    }

    public final SafeJSONObject getPermissionState() {
        SafeJSONObject safeJSONObject = new SafeJSONObject();
        if (this.permissionUtils.isPermissionGranted(StringFog.decrypt("QE1AUU5KQA9RRlZOSFBXSE5NCnFkYmB+cWtrbWR8d3Vgd2E="))) {
            safeJSONObject.put(StringFog.decrypt("c2ZlZ35zbG5vZntwdWJwZA=="), true);
        } else {
            safeJSONObject.put(StringFog.decrypt("c2ZlZ35zbG5vZntwdWJwZA=="), false);
        }
        if (this.permissionUtils.isPermissionGranted(StringFog.decrypt("QE1AUU5KQA9RRlZOSFBXSE5NCnRzanBkfmZ8d2RxamBtfHd3bnFlZmQ="))) {
            safeJSONObject.put(StringFog.decrypt("dnFtd2R8YXl1ZnZtYG97cnVsdmJmZg=="), true);
        } else {
            safeJSONObject.put(StringFog.decrypt("dnFtd2R8YXl1ZnZtYG97cnVsdmJmZg=="), false);
        }
        if (this.permissionUtils.isPermissionGranted(StringFog.decrypt("QE1AUU5KQA9RRlZOSFBXSE5NCnFkYmB+ZHtwZnNtZW1+cHBsc2JjZA=="))) {
            safeJSONObject.put(StringFog.decrypt("c2ZlZ35mfHVkcWpibXx3dW5xZWRk"), true);
        } else {
            safeJSONObject.put(StringFog.decrypt("c2ZlZ35mfHVkcWpibXx3dW5xZWRk"), false);
        }
        if (this.permissionUtils.isPermissionGranted(StringFog.decrypt("QE1AUU5KQA9RRlZOSFBXSE5NCmJiYGFycnxiam9me21uYGV3aGxq"))) {
            safeJSONObject.put(StringFog.decrypt("YGBnZnJwe2dobWF8bWxnYHVqa20="), true);
        } else {
            safeJSONObject.put(StringFog.decrypt("YGBnZnJwe2dobWF8bWxnYHVqa20="), false);
        }
        if (this.permissionUtils.isPermissionGranted(StringFog.decrypt("QE1AUU5KQA9RRlZOSFBXSE5NCmJiYGFycnxnbGBxd2R+b2tgYHdtbm8="))) {
            safeJSONObject.put(StringFog.decrypt("YGBnZnJwe2JuYnZwZHxobmJicGpubQ=="), true);
        } else {
            safeJSONObject.put(StringFog.decrypt("YGBnZnJwe2JuYnZwZHxobmJicGpubQ=="), false);
        }
        if (this.permissionUtils.isPermissionGranted(StringFog.decrypt("QE1AUU5KQA9RRlZOSFBXSE5NCmJiYGFycnxzamdqe3J1YnBm"))) {
            safeJSONObject.put(StringFog.decrypt("YGBnZnJwe3ZoZW18cndldWQ="), true);
        } else {
            safeJSONObject.put(StringFog.decrypt("YGBnZnJwe3ZoZW18cndldWQ="), false);
        }
        if (this.permissionUtils.isPermissionGranted(StringFog.decrypt("QE1AUU5KQA9RRlZOSFBXSE5NCmJiYGFycnxqZnV0a3NqfHd3YHdh"))) {
            safeJSONObject.put(StringFog.decrypt("YGBnZnJwe29kd3Nsc2h7cnVicGY="), true);
        } else {
            safeJSONObject.put(StringFog.decrypt("YGBnZnJwe29kd3Nsc2h7cnVicGY="), false);
        }
        return safeJSONObject;
    }

    public final SafeJSONObject getProcessInfo() {
        SafeJSONObject safeJSONObject = new SafeJSONObject();
        try {
            if (NativeLib.checkLoadSo()) {
                JSONObject jSONObject = new JSONObject(NativeLib.pi());
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    try {
                        safeJSONObject.put(next, next.equalsIgnoreCase(StringFog.decrypt("UldFV1RQakBMRg==")) ? ((String) jSONObject.get(next)).trim() : jSONObject.get(next));
                    } catch (JSONException unused) {
                    }
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return safeJSONObject;
    }

    @Nullable
    public final Integer getVersionCode() {
        try {
            return Integer.valueOf(this.packageManager.getPackageInfo(this.mcontext.getPackageName(), 0).versionCode);
        } catch (Exception unused) {
            return null;
        }
    }

    @Nullable
    public final String getVersionName() {
        try {
            return this.packageManager.getPackageInfo(this.mcontext.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return null;
        }
    }
}
