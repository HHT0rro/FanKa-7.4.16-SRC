package com.danlan.android.cognition.collector;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.location.Location;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.os.Environment;
import android.os.IInterface;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.danlan.android.cognition.NativeLib;
import com.danlan.android.cognition.StringFog;
import com.danlan.android.cognition.collector.base.SubCollector;
import com.danlan.android.cognition.collector.util.SafeJSONObject;
import com.danlan.android.cognition.common.Reflection;
import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class RiskCollector extends SubCollector {
    private Context mcontext;

    public RiskCollector(Context context, SafeJSONObject safeJSONObject) {
        super(context, safeJSONObject);
        this.mcontext = context;
    }

    public int checkAmsProxy() {
        try {
            Method declaredMethod = Class.forName(StringFog.decrypt("QE1AUU5KQA9AU1QNYEBQSFdKUFpsQkpARkZWbUBXTVdE")).getDeclaredMethod(StringFog.decrypt("RkZQZ0RFRVRNVw=="), new Class[0]);
            declaredMethod.setAccessible(true);
            return ((IInterface) declaredMethod.invoke(null, new Object[0])) instanceof Proxy ? 1 : 0;
        } catch (Exception unused) {
            return -1;
        }
    }

    public final SafeJSONObject checkApiNative() {
        SafeJSONObject safeJSONObject = new SafeJSONObject();
        safeJSONObject.put(StringFog.decrypt("EQ=="), Reflection.isNative(TelephonyManager.class, StringFog.decrypt("RkZQZ0RVTUJEakA="), new Class[0]) ? 1 : 0);
        safeJSONObject.put(StringFog.decrypt("EA=="), Reflection.isNative(TelephonyManager.class, StringFog.decrypt("RkZQcFRBV0JTSkZGU2pA"), new Class[0]) ? 1 : 0);
        safeJSONObject.put(StringFog.decrypt("Ew=="), Reflection.isNative(TelephonyManager.class, StringFog.decrypt("RkZQcEhOd0RTSkVPb1ZJQ0RR"), new Class[0]) ? 1 : 0);
        safeJSONObject.put(StringFog.decrypt("Eg=="), Reflection.isNative(Location.class, StringFog.decrypt("RkZQb0BXTVVUR0E="), new Class[0]) ? 1 : 0);
        safeJSONObject.put(StringFog.decrypt("FQ=="), Reflection.isNative(Location.class, StringFog.decrypt("RkZQb05NQ0hVVkBG"), new Class[0]) ? 1 : 0);
        if (Build.VERSION.SDK_INT >= 26) {
            safeJSONObject.put(StringFog.decrypt("FA=="), Reflection.isNative(Build.class, StringFog.decrypt("RkZQcERRTUBN"), new Class[0]) ? 1 : 0);
        } else {
            safeJSONObject.put(StringFog.decrypt("FA=="), 0);
        }
        safeJSONObject.put(StringFog.decrypt("Fw=="), Reflection.isNative(WifiInfo.class, StringFog.decrypt("RkZQbkBAZUVFUUFQUg=="), new Class[0]) ? 1 : 0);
        safeJSONObject.put(StringFog.decrypt("Fg=="), Reflection.isNative(WifiInfo.class, StringFog.decrypt("RkZQYXJwbWU="), new Class[0]) ? 1 : 0);
        safeJSONObject.put(StringFog.decrypt("GQ=="), Reflection.isNative(WifiInfo.class, StringFog.decrypt("RkZQcVJQTQ=="), new Class[0]) ? 1 : 0);
        safeJSONObject.put(StringFog.decrypt("GA=="), Reflection.isNative(Class.class, StringFog.decrypt("R0xWbUBOQQ=="), String.class) ? 1 : 0);
        safeJSONObject.put(StringFog.decrypt("EBM="), Reflection.isNative(ActivityManager.class, StringFog.decrypt("RkZQcVRNSkhPRHdGU1VNQkRQ"), Integer.TYPE) ? 1 : 0);
        return safeJSONObject;
    }

    public final JSONArray checkApiRisk() {
        JSONArray jSONArray = new JSONArray();
        try {
            String ac2 = NativeLib.checkLoadSo() ? NativeLib.ac(WifiInfo.class.getDeclaredMethod(StringFog.decrypt("RkZQbkBAZUVFUUFQUg=="), new Class[0])) : null;
            if (ac2 != null) {
                JSONObject jSONObject = new JSONObject(ac2);
                jSONObject.put(StringFog.decrypt("T0JJRg=="), StringFog.decrypt("dkpCSmhNQk4MHUNGVW5FQmBHQFFEUFc="));
                jSONArray.put(jSONObject);
            }
        } catch (NoSuchMethodException | JSONException e2) {
            e2.printStackTrace();
        }
        try {
            String ac3 = NativeLib.checkLoadSo() ? NativeLib.ac(Settings.Secure.class.getDeclaredMethod(StringFog.decrypt("RkZQcFVRTU9G"), ContentResolver.class, String.class)) : null;
            if (ac3 != null) {
                JSONObject jSONObject2 = new JSONObject(ac3);
                jSONObject2.put(StringFog.decrypt("T0JJRg=="), StringFog.decrypt("ckZQV0hNQ1IFcEFAVFFBDB9EQVdyV1ZIT0Q="));
                jSONArray.put(jSONObject2);
            }
        } catch (NoSuchMethodException | JSONException e10) {
            e10.printStackTrace();
        }
        try {
            if (Build.VERSION.SDK_INT < 31) {
                String ac4 = NativeLib.checkLoadSo() ? NativeLib.ac(TelephonyManager.class.getDeclaredMethod(StringFog.decrypt("RkZQZ0RVTUJEakA="), new Class[0])) : null;
                if (ac4 != null) {
                    JSONObject jSONObject3 = new JSONObject(ac4);
                    jSONObject3.put(StringFog.decrypt("T0JJRg=="), StringFog.decrypt("dUZIRlFLS09YbkVNQERBUwwdQ0ZVZ0FXSEBBakU="));
                    jSONArray.put(jSONObject3);
                }
            }
        } catch (NoSuchMethodException | JSONException e11) {
            e11.printStackTrace();
        }
        return jSONArray;
    }

    public boolean checkEmulator2() {
        int i10;
        String str = Build.PRODUCT;
        if (TextUtils.isEmpty(str)) {
            i10 = 0;
        } else {
            i10 = (str.contains(StringFog.decrypt("UkdP")) || str.contains(StringFog.decrypt("YE1AWg==")) || str.contains(StringFog.decrypt("VVdybn5rQFNAREtN")) || str.contains(StringFog.decrypt("RkxLRE1Ge1JFSA==")) || str.contains(StringFog.decrypt("ZVFLSkUXfA==")) || str.contains(StringFog.decrypt("T0xc")) || str.contains(StringFog.decrypt("UkdPfFkbEg==")) || str.contains(StringFog.decrypt("UkdPfEZMS0ZNRg==")) || str.contains(StringFog.decrypt("V0FLWxkVVA==")) || str.contains(StringFog.decrypt("QFFNRlI="))) ? 1 : 0;
            String str2 = Build.MANUFACTURER;
            if (str2.equals(StringFog.decrypt("VE1PTU5USg==")) || str2.equals(StringFog.decrypt("ZkZKWkxMUEhOTQ==")) || str2.contains(StringFog.decrypt("YE1AWg==")) || str2.contains(StringFog.decrypt("bGpw")) || str2.contains(StringFog.decrypt("T0xc")) || str2.contains(StringFog.decrypt("dUpFTVVKRU93bg=="))) {
                i10++;
            }
        }
        String str3 = Build.BRAND;
        if (!TextUtils.isEmpty(str3) && (str3.equals(StringFog.decrypt("RkZKRlNKRw==")) || str3.equals(StringFog.decrypt("RkZKRlNKR35ZGxI=")) || str3.equals(StringFog.decrypt("dXdybg==")) || str3.contains(StringFog.decrypt("YE1AWg==")))) {
            i10++;
        }
        String str4 = Build.DEVICE;
        if (!TextUtils.isEmpty(str4) && (str4.contains(StringFog.decrypt("RkZKRlNKRw==")) || str4.contains(StringFog.decrypt("RkZKRlNKR35ZGxI=")) || str4.contains(StringFog.decrypt("YE1AWg==")) || str4.contains(StringFog.decrypt("VVdybn5rQFNAREtN")) || str4.contains(StringFog.decrypt("ZVFLSkUXfA==")) || str4.contains(StringFog.decrypt("T0xc")) || str4.contains(StringFog.decrypt("RkZKRlNKR35ZGxJ8Fxc=")) || str4.contains(StringFog.decrypt("V0FLWxkVVA==")) || str4.contains(StringFog.decrypt("QFFNRlI=")))) {
            i10++;
        }
        String str5 = Build.MODEL;
        if (!TextUtils.isEmpty(str5) && (str5.equals(StringFog.decrypt("UkdP")) || str5.contains(StringFog.decrypt("ZE5RT0BXS1M=")) || str5.equals(StringFog.decrypt("RkxLRE1Ge1JFSA==")) || str5.contains(StringFog.decrypt("ZVFLSkUXfA==")) || str5.contains(StringFog.decrypt("dUpFTVVKRU93bg==")) || str5.contains(StringFog.decrypt("YE1AWg==")) || str5.equals(StringFog.decrypt("YE1AUU5KQAFyZ28DQ1ZNTVUDQkxTA1wZF3wSFw==")) || str5.equals(StringFog.decrypt("YE1AUU5KQAFyZ28DQ1ZNTVUDQkxTA1wZFw==")))) {
            i10++;
        }
        String str6 = Build.HARDWARE;
        if (!TextUtils.isEmpty(str6) && (str6.equals(StringFog.decrypt("RkxIR0dKV0k=")) || str6.equals(StringFog.decrypt("V0FLWxkV")) || str6.contains(StringFog.decrypt("T0xc")) || str6.contains(StringFog.decrypt("VVdybn5bHBc=")))) {
            i10++;
        }
        String str7 = Build.FINGERPRINT;
        if (!TextUtils.isEmpty(str7) && (str7.contains(StringFog.decrypt("RkZKRlNKRw5SR08MRkZKRFNKRw==")) || str7.contains(StringFog.decrypt("RkZKRlNKR35ZGxIMUkdPflkbEgxGRkpEU0pHfFkbEg==")) || str7.contains(StringFog.decrypt("YE1AWg==")) || str7.contains(StringFog.decrypt("VVdybn5rQFNAREtN")) || str7.contains(StringFog.decrypt("RkZKRlNKR35ZGxJ8Fxc=")) || str7.contains(StringFog.decrypt("RkZKRlNKRw5GTEtETUZ7UkVIC0RETUFTSEA=")) || str7.contains(StringFog.decrypt("V0FLWxkVVA==")) || str7.contains(StringFog.decrypt("RkZKRlNKRw5XQUtbGRVUDldBS1sZFVQ=")))) {
            i10++;
        }
        try {
            if (new File(Environment.getExternalStorageDirectory().toString() + File.separatorChar + StringFog.decrypt("VkpKR05UVw==") + File.separatorChar + StringFog.decrypt("Y1BQcElCVkRFZUtPRUZW")).exists()) {
                i10 += 10;
            }
        } catch (Exception unused) {
        }
        return i10 > 3;
    }

    @Override // com.danlan.android.cognition.collector.base.SubCollector
    public void doCollectAutomatically() {
        SafeJSONObject safeJSONObject = new SafeJSONObject();
        try {
            safeJSONObject.put(StringFog.decrypt("U0xLV2dPRUY="), getRootFlag());
            safeJSONObject.put(StringFog.decrypt("RE5RT0BXS1NnT0VE"), getEmulatorFlag(this.mcontext));
            safeJSONObject.put(StringFog.decrypt("RE5RT0BXS1NnT0VEEw=="), checkEmulator2());
            safeJSONObject.put(StringFog.decrypt("SUxLSGdPRUY="), getHookFlag());
            safeJSONObject.put(StringFog.decrypt("U0pXSGBTTQ=="), checkApiRisk());
            safeJSONObject.put(StringFog.decrypt("QE5Xc1NMXFg="), checkAmsProxy());
            safeJSONObject.put(StringFog.decrypt("QFNNbUBXTVdE"), checkApiNative());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        put(StringFog.decrypt("U0pXSA=="), safeJSONObject);
        collectDone();
    }

    public final SafeJSONObject getEmulatorFlag(Context context) {
        SafeJSONObject safeJSONObject = new SafeJSONObject();
        String ce2 = NativeLib.checkLoadSo() ? NativeLib.ce(context) : null;
        if (ce2 != null) {
            safeJSONObject.put(StringFog.decrypt("R09FRA=="), 1);
            safeJSONObject.put(StringFog.decrypt("U0ZFUE5N"), ce2);
        } else {
            safeJSONObject.put(StringFog.decrypt("R09FRA=="), 0);
            safeJSONObject.put(StringFog.decrypt("U0ZFUE5N"), "");
        }
        return safeJSONObject;
    }

    public final SafeJSONObject getHookFlag() {
        SafeJSONObject safeJSONObject = new SafeJSONObject();
        String ck = NativeLib.checkLoadSo() ? NativeLib.ck() : null;
        if (ck != null) {
            safeJSONObject.put(StringFog.decrypt("R09FRA=="), 1);
            safeJSONObject.put(StringFog.decrypt("U0ZFUE5N"), ck);
        } else {
            safeJSONObject.put(StringFog.decrypt("R09FRA=="), 0);
            safeJSONObject.put(StringFog.decrypt("U0ZFUE5N"), "");
        }
        return safeJSONObject;
    }

    public final SafeJSONObject getRootFlag() {
        SafeJSONObject safeJSONObject = new SafeJSONObject();
        String cr = NativeLib.checkLoadSo() ? NativeLib.cr() : null;
        if (cr != null) {
            safeJSONObject.put(StringFog.decrypt("R09FRA=="), 1);
            safeJSONObject.put(StringFog.decrypt("U0ZFUE5N"), cr);
        } else {
            safeJSONObject.put(StringFog.decrypt("R09FRA=="), 0);
            safeJSONObject.put(StringFog.decrypt("U0ZFUE5N"), "");
        }
        return safeJSONObject;
    }
}
