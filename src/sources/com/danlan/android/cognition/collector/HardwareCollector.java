package com.danlan.android.cognition.collector;

import android.content.Context;
import android.nfc.NfcAdapter;
import android.telephony.TelephonyManager;
import androidx.annotation.Nullable;
import com.danlan.android.cognition.NativeLib;
import com.danlan.android.cognition.StringFog;
import com.danlan.android.cognition.collector.base.SubCollector;
import com.danlan.android.cognition.collector.util.PermissionUtil;
import com.danlan.android.cognition.collector.util.SafeJSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class HardwareCollector extends SubCollector {
    private Context mcontext;
    private final PermissionUtil permissionUtils;

    public HardwareCollector(Context context, SafeJSONObject safeJSONObject) {
        super(context, safeJSONObject);
        this.mcontext = context;
        this.permissionUtils = new PermissionUtil(context);
    }

    public static final String getBuildBrand() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("U0wKU1NMQFRCVwpBU0JKRQ=="), StringFog.decrypt("VE1PTU5USg==")) : StringFog.decrypt("VE1PTU5USg==");
    }

    public static final String getModel() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("U0wKU1NMQFRCVwpOTkdBTQ=="), StringFog.decrypt("VE1PTU5USg==")) : StringFog.decrypt("VE1PTU5USg==");
    }

    @Override // com.danlan.android.cognition.collector.base.SubCollector
    public void doCollectAutomatically() {
        SafeJSONObject safeJSONObject = new SafeJSONObject();
        try {
            safeJSONObject.put(StringFog.decrypt("TExARk0="), getModel());
            safeJSONObject.put(StringFog.decrypt("UVFLR1RAUA=="), getProduct());
            safeJSONObject.put(StringFog.decrypt("Q1FFTUU="), getBuildBrand());
            safeJSONObject.put(StringFog.decrypt("TEJKVkdCR1VUUUFR"), getManufacturer());
            safeJSONObject.put(StringFog.decrypt("SUJWR1ZCVkQ="), getHardware());
            safeJSONObject.put(StringFog.decrypt("U0JASk51QVNSSktN"), getRadioVer());
            safeJSONObject.put(StringFog.decrypt("Q0xFUUVzSEBVRUtRTA=="), getBoardPlatform());
            safeJSONObject.put(StringFog.decrypt("UkZWSkBP"), getSerial());
            safeJSONObject.put(StringFog.decrypt("RUpXU01CXXdEUVdKTk0="), getDisplayVersion());
            safeJSONObject.put(StringFog.decrypt("RUZSSkJG"), getDevice());
            safeJSONObject.put(StringFog.decrypt("SFBqRUJzVkRSRkpX"), isNfcPresent());
            safeJSONObject.put(StringFog.decrypt("SFBqRUJmSkBDT0FH"), isNfcEnabled());
            safeJSONObject.put(StringFog.decrypt("SFBiSk9EQVNyVlRTTlFQ"), isFingerSupport());
            safeJSONObject.put(StringFog.decrypt("SFBmT1RGUE5OV0xwVFNUTlNX"), isBluetoothSupport());
            safeJSONObject.put(StringFog.decrypt("SFB3V0RTZ05UTVBGU3BRUVFMVlc="), isStepCounterSupport());
            safeJSONObject.put(StringFog.decrypt("SFBrU0RNY21kcHdWUVNLU1U="), isOpenGLESSupport());
            safeJSONObject.put(StringFog.decrypt("TEJHak9FSw=="), getMacInfo2());
            safeJSONObject.put(StringFog.decrypt("SE5BSg=="), "");
            safeJSONObject.put(StringFog.decrypt("UUtLTUR3XVFE"), getPhoneType());
            safeJSONObject.put(StringFog.decrypt("VFBGcFVCUEQ="), getUsbState());
            safeJSONObject.put(StringFog.decrypt("Q0JXRkNCSkU="), getBaseband());
            safeJSONObject.put(StringFog.decrypt("RlBJcVNPckRTUE1MTw=="), getGsmRilVersion());
            safeJSONObject.put(StringFog.decrypt("SFB3VlFTS1NVd0FPRHNMTk9a"), isSupportTelePhony());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        put(StringFog.decrypt("SUJWR1ZCVkQ="), safeJSONObject);
        collectDone();
    }

    public final String getBaseband() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("U0wKQUBQQUNATUA="), StringFog.decrypt("VE1PTU5USg==")) : StringFog.decrypt("VE1PTU5USg==");
    }

    public final String getBoardPlatform() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("U0wKQU5CVkUPU0hCVUVLU0w="), StringFog.decrypt("VE1PTU5USg==")) : StringFog.decrypt("VE1PTU5USg==");
    }

    public final String getDevice() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("U0wKU1NMQFRCVwpHRFVNQkQ="), StringFog.decrypt("VE1PTU5USg==")) : StringFog.decrypt("VE1PTU5USg==");
    }

    public final String getDisplayVersion() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("U0wKQVRKSEUPR01QUU9FWA9KQA=="), StringFog.decrypt("VE1PTU5USg==")) : StringFog.decrypt("VE1PTU5USg==");
    }

    public final String getGsmRilVersion() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("RlBJDVdGVlJITEoNU0pIDEhOVE8="), StringFog.decrypt("VE1PTU5USg==")) : StringFog.decrypt("VE1PTU5USg==");
    }

    public final String getHardware() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("U0wKS0BRQFZAUUE="), StringFog.decrypt("VE1PTU5USg==")) : StringFog.decrypt("VE1PTU5USg==");
    }

    @Nullable
    public final String getIMEI() {
        TelephonyManager telephonyManager;
        if (!this.permissionUtils.isPermissionGranted(StringFog.decrypt("QE1AUU5KQA9RRlZOSFBXSE5NCnFkYmB+cWtrbWR8d3Vgd2E=")) || (telephonyManager = (TelephonyManager) this.mcontext.getSystemService(StringFog.decrypt("UUtLTUQ="))) == null) {
            return null;
        }
        try {
            return telephonyManager.getDeviceId();
        } catch (Exception unused) {
            return "";
        }
    }

    public final JSONArray getMacInfo2() {
        JSONArray jSONArray = new JSONArray();
        try {
            JSONArray jSONArray2 = new JSONArray(NativeLib.checkLoadSo() ? NativeLib.gm() : "");
            for (int i10 = 0; i10 < jSONArray2.length(); i10++) {
                jSONArray.put((JSONObject) jSONArray2.get(i10));
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONArray;
    }

    public final String getManufacturer() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("U0wKU1NMQFRCVwpOQE1RR0BAUFZTRlY="), StringFog.decrypt("VE1PTU5USg==")) : StringFog.decrypt("VE1PTU5USg==");
    }

    public final String getPhoneType() {
        TelephonyManager telephonyManager = (TelephonyManager) this.mcontext.getSystemService(StringFog.decrypt("UUtLTUQ="));
        int phoneType = telephonyManager != null ? telephonyManager.getPhoneType() : 0;
        return StringFog.decrypt(phoneType != 1 ? phoneType != 2 ? "VE1PTU5USg==" : "QkdJQg==" : "RlBJ");
    }

    public final String getProduct() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("U0wKU1NMQFRCVwpNQE5B"), StringFog.decrypt("VE1PTU5USg==")) : StringFog.decrypt("VE1PTU5USg==");
    }

    public final String getRadioVer() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("RlBJDVdGVlJITEoNQ0JXRENCSkc="), StringFog.decrypt("VE1PTU5USg==")) : StringFog.decrypt("VE1PTU5USg==");
    }

    public final String getSerial() {
        return this.permissionUtils.isPermissionGranted(StringFog.decrypt("QE1AUU5KQA9RRlZOSFBXSE5NCnFkYmB+cWtrbWR8d3Vgd2E=")) ? StringFog.decrypt("VE1PTU5USg==") : StringFog.decrypt("VE1PTU5USg==");
    }

    public final String getUsbState() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("UlpXDVRQRg9SV0VXRA=="), StringFog.decrypt("VE1PTU5USg==")) : StringFog.decrypt("VE1PTU5USg==");
    }

    public final boolean isBluetoothSupport() {
        try {
            return this.mcontext.getPackageManager().hasSystemFeature(StringFog.decrypt("QE1AUU5KQA9JQlZHVkJWRA9BSFZEV0tOVUs="));
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean isFingerSupport() {
        return this.mcontext.getPackageManager().hasSystemFeature(StringFog.decrypt("QE1AUU5KQA9JQlZHVkJWRA9NQkA="));
    }

    @Nullable
    public final Boolean isNfcEnabled() {
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(this.mcontext);
        return Boolean.valueOf(defaultAdapter != null && defaultAdapter.isEnabled());
    }

    @Nullable
    public final Boolean isNfcPresent() {
        return Boolean.valueOf(NfcAdapter.getDefaultAdapter(this.mcontext) != null);
    }

    public final boolean isOpenGLESSupport() {
        return this.mcontext.getPackageManager().hasSystemFeature(StringFog.decrypt("QE1AUU5KQA9JQlZHVkJWRA9MVEZPREhEUg1FRlE="));
    }

    public final boolean isStepCounterSupport() {
        return this.mcontext.getPackageManager().hasSystemFeature(StringFog.decrypt("QE1AUU5KQA9JQlZHVkJWRA9QQU1STFYPUldBU0JMUU9VRlY="));
    }

    public int isSupportTelePhony() {
        try {
            return this.mContext.getPackageManager().hasSystemFeature(StringFog.decrypt("QE1AUU5KQA9JQlZHVkJWRA9XQU9EU0xOT1o=")) ? 1 : 0;
        } catch (Exception unused) {
            return -1;
        }
    }
}
