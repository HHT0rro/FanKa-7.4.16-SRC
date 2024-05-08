package com.danlan.android.cognition.collector;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.danlan.android.cognition.StringFog;
import com.danlan.android.cognition.collector.base.SubCollector;
import com.danlan.android.cognition.collector.util.SafeJSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class BatteryCollector extends SubCollector {
    private static final String UNKNOWN = StringFog.decrypt("VE1PTU5USg==");
    private Context mcontext;

    public BatteryCollector(Context context, SafeJSONObject safeJSONObject) {
        super(context, safeJSONObject);
        this.mcontext = context;
    }

    private Intent getBatteryStatusIntent() {
        try {
            return this.mcontext.registerReceiver(null, new IntentFilter(StringFog.decrypt("QE1AUU5KQA9ITVBGT1cKQEJXTUxPDWZgdXdhcXh8Z2lgbWNmZQ==")));
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.danlan.android.cognition.collector.base.SubCollector
    public void doCollectAutomatically() {
        SafeJSONObject safeJSONObject = new SafeJSONObject();
        try {
            safeJSONObject.put(StringFog.decrypt("Q0JQV0RRXXFEUUdGT1c="), getBatteryPercent());
            safeJSONObject.put(StringFog.decrypt("Q0JQV0RRXWlEQkhXSQ=="), getBatteryHealth());
            safeJSONObject.put(StringFog.decrypt("Q0JQV0RRXXVEQExNTk9LRlg="), getBatteryTechnology());
            safeJSONObject.put(StringFog.decrypt("Q0JQV0RRXXVETlRGU0JQVFNG"), getBatteryTemperature());
            safeJSONObject.put(StringFog.decrypt("Q0JQV0RRXXdOT1BCRkY="), getBatteryVoltage());
            safeJSONObject.put(StringFog.decrypt("QktFUUZKSkZyTFFRQkY="), getChargingSource());
            safeJSONObject.put(StringFog.decrypt("SFB0S05NQWJJQlZESE1D"), isPhoneCharging());
            safeJSONObject.put(StringFog.decrypt("SFBmQlVXQVNYc1ZGUkZKVQ=="), isBatteryPresent());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        put(StringFog.decrypt("Q0JQV0RRXQ=="), safeJSONObject);
        collectDone();
    }

    public final String getBatteryHealth() {
        String str;
        Intent batteryStatusIntent = getBatteryStatusIntent();
        if (batteryStatusIntent == null) {
            return UNKNOWN;
        }
        switch (batteryStatusIntent.getIntExtra(StringFog.decrypt("SUZFT1VL"), 0)) {
            case 2:
                str = "RkxLRw==";
                break;
            case 3:
                str = "TlVBUX5LQUBV";
                break;
            case 4:
                str = "RUZFRw==";
                break;
            case 5:
                str = "TlVBUX5VS01VQkNG";
                break;
            case 6:
                str = "VE1XU0RATUdIRkB8R0JNTVRRQQ==";
                break;
            case 7:
                str = "QkxIRw==";
                break;
            default:
                return UNKNOWN;
        }
        return StringFog.decrypt(str);
    }

    public final int getBatteryPercent() {
        Intent batteryStatusIntent = getBatteryStatusIntent();
        if (batteryStatusIntent != null) {
            int intExtra = batteryStatusIntent.getIntExtra(StringFog.decrypt("TUZSRk0="), -1);
            int intExtra2 = batteryStatusIntent.getIntExtra(StringFog.decrypt("UkBFT0Q="), -1);
            if (intExtra >= 0 && intExtra2 > 0) {
                return (intExtra * 100) / intExtra2;
            }
        }
        return -1;
    }

    public final String getBatteryTechnology() {
        Intent batteryStatusIntent = getBatteryStatusIntent();
        return batteryStatusIntent != null ? batteryStatusIntent.getStringExtra(StringFog.decrypt("VUZHS09MSE5GWg==")) : UNKNOWN;
    }

    public final float getBatteryTemperature() {
        if (getBatteryStatusIntent() != null) {
            return (float) (r0.getIntExtra(StringFog.decrypt("VUZJU0RRRVVUUUE="), 0) / 10.0d);
        }
        return -1.0f;
    }

    public final int getBatteryVoltage() {
        if (getBatteryStatusIntent() != null) {
            return getBatteryStatusIntent().getIntExtra(StringFog.decrypt("V0xIV0BEQQ=="), 0);
        }
        return -1;
    }

    public final String getChargingSource() {
        String str;
        Intent batteryStatusIntent = getBatteryStatusIntent();
        if (batteryStatusIntent == null) {
            return UNKNOWN;
        }
        int intExtra = batteryStatusIntent.getIntExtra(StringFog.decrypt("UU9RREZGQA=="), 0);
        if (intExtra == 1) {
            str = "QEA=";
        } else if (intExtra == 2) {
            str = "VFBG";
        } else {
            if (intExtra != 4) {
                return UNKNOWN;
            }
            str = "VkpWRk1GV1I=";
        }
        return StringFog.decrypt(str);
    }

    public final boolean isBatteryPresent() {
        Intent batteryStatusIntent = getBatteryStatusIntent();
        if (batteryStatusIntent != null) {
            return batteryStatusIntent.getBooleanExtra(StringFog.decrypt("UVFBUERNUA=="), false);
        }
        return false;
    }

    public final boolean isPhoneCharging() {
        Intent batteryStatusIntent = getBatteryStatusIntent();
        if (batteryStatusIntent == null) {
            return false;
        }
        int intExtra = batteryStatusIntent.getIntExtra(StringFog.decrypt("UU9RREZGQA=="), 0);
        return intExtra == 1 || intExtra == 2 || intExtra == 4;
    }
}
