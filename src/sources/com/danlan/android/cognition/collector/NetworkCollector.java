package com.danlan.android.cognition.collector;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.CellInfo;
import android.telephony.CellSignalStrength;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.danlan.android.cognition.NativeLib;
import com.danlan.android.cognition.StringFog;
import com.danlan.android.cognition.collector.base.SubCollector;
import com.danlan.android.cognition.collector.util.IpUtil;
import com.danlan.android.cognition.collector.util.PermissionUtil;
import com.danlan.android.cognition.collector.util.SafeJSONObject;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.json.JSONArray;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class NetworkCollector extends SubCollector {
    private static int neigh_size_control = 2;
    private String gatewayMac;
    private Context mcontext;
    private final PermissionUtil permissionUtils;
    private WifiManager wifiManager;

    public NetworkCollector(Context context, SafeJSONObject safeJSONObject) {
        super(context, safeJSONObject);
        this.wifiManager = null;
        this.gatewayMac = "";
        this.mcontext = context;
        this.permissionUtils = new PermissionUtil(context);
    }

    private int getCellSignalStrength(CellInfo cellInfo) {
        if (cellInfo == null) {
            return -1;
        }
        try {
            Method declaredMethod = cellInfo.getClass().getDeclaredMethod(StringFog.decrypt("RkZQYERPSHJIREpCTXBQU0RNQ1dJ"), new Class[0]);
            declaredMethod.setAccessible(true);
            return ((CellSignalStrength) declaredMethod.invoke(cellInfo, new Object[0])).getLevel();
        } catch (Throwable unused) {
            return -1;
        }
    }

    private String intToIp(int i10) {
        return (i10 & 255) + StringFog.decrypt("Dw==") + ((i10 >> 8) & 255) + StringFog.decrypt("Dw==") + ((i10 >> 16) & 255) + StringFog.decrypt("Dw==") + ((i10 >> 24) & 255);
    }

    public int checkVpnState(Context context) {
        NetworkInfo networkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(StringFog.decrypt("QkxKTURAUEhXSlBa"));
            if (connectivityManager != null && (networkInfo = connectivityManager.getNetworkInfo(17)) != null) {
                return networkInfo.isConnectedOrConnecting() ? 1 : 0;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return -1;
    }

    @Override // com.danlan.android.cognition.collector.base.SubCollector
    public void doCollectAutomatically() {
        SafeJSONObject safeJSONObject = new SafeJSONObject();
        try {
            safeJSONObject.put(StringFog.decrypt("SFM="), getIP());
            safeJSONObject.put(StringFog.decrypt("T0ZQVE5RT3VYU0E="), getNetworkType());
            safeJSONObject.put(StringFog.decrypt("T0ZQVE5RT2JNQldQ"), getNetworkClass());
            safeJSONObject.put(StringFog.decrypt("SFBqRlVUS1NKYlJCSE9FQ01G"), isNetworkAvailable());
            safeJSONObject.put(StringFog.decrypt("UlBNRw=="), getSSID());
            safeJSONObject.put(StringFog.decrypt("Q1BXSkU="), getBSSID());
            safeJSONObject.put(StringFog.decrypt("U1BXSg=="), getRSSI());
            safeJSONObject.put(StringFog.decrypt("TUpKSHJTQURF"), getLinkSpeed());
            safeJSONObject.put(StringFog.decrypt("TUpKSHJTQURFdkpKVVA="), StringFog.decrypt("bEFUUA=="));
            safeJSONObject.put(StringFog.decrypt("SFBzSkdKYU9AQUhGRQ=="), isWifiEnabled());
            safeJSONObject.put(StringFog.decrypt("SFBzSkdKZVFuU0FN"), isWifiApOpen());
            safeJSONObject.put(StringFog.decrypt("SFB0UU5bXQ=="), isWifiProxy());
            safeJSONObject.put(StringFog.decrypt("UVFLW1hrS1JV"), getHttpProxyHost());
            safeJSONObject.put(StringFog.decrypt("UVFLW1hzS1NV"), getHttpProxyPort());
            safeJSONObject.put(StringFog.decrypt("T0ZNRElBS1NS"), getNeighborInfo());
            safeJSONObject.put(StringFog.decrypt("RkJQRlZCXWhR"), getGatewayIp());
            safeJSONObject.put(StringFog.decrypt("RkJQRlZCXWxAQA=="), this.gatewayMac);
            safeJSONObject.put(StringFog.decrypt("SFByc28="), checkVpnState(this.mcontext));
        } catch (Throwable th) {
            th.printStackTrace();
        }
        put(StringFog.decrypt("T0ZQVE5RTw=="), safeJSONObject);
        collectDone();
    }

    public final String getBSSID() {
        WifiInfo connectionInfo;
        WifiInfo connectionInfo2;
        try {
            if (Build.VERSION.SDK_INT < 27) {
                if (this.wifiManager == null) {
                    this.wifiManager = (WifiManager) this.mContext.getApplicationContext().getSystemService(StringFog.decrypt("VkpCSg=="));
                }
                WifiManager wifiManager = this.wifiManager;
                return (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) ? "" : connectionInfo.getBSSID();
            }
            if (!this.permissionUtils.isPermissionGranted(StringFog.decrypt("QE1AUU5KQA9RRlZOSFBXSE5NCmJiYGFycnxiam9me21uYGV3aGxq"))) {
                return "";
            }
            if (this.wifiManager == null) {
                this.wifiManager = (WifiManager) this.mContext.getApplicationContext().getSystemService(StringFog.decrypt("VkpCSg=="));
            }
            WifiManager wifiManager2 = this.wifiManager;
            return (wifiManager2 == null || (connectionInfo2 = wifiManager2.getConnectionInfo()) == null) ? "" : connectionInfo2.getBSSID();
        } catch (Exception unused) {
            return "";
        }
    }

    public final String getGatewayIp() {
        try {
            if (this.wifiManager == null) {
                this.wifiManager = (WifiManager) this.mContext.getApplicationContext().getSystemService(StringFog.decrypt("VkpCSg=="));
            }
            return intToIp(this.wifiManager.getDhcpInfo().gateway);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public final String getHttpProxyHost() {
        String property = System.getProperty(StringFog.decrypt("SVdQUw9TVk5ZWmxMUlc="));
        return property == null ? "" : property;
    }

    public final String getHttpProxyPort() {
        String property = System.getProperty(StringFog.decrypt("SVdQUw9TVk5ZWnRMU1c="));
        if (TextUtils.isEmpty(property)) {
            property = StringFog.decrypt("DBI=");
        }
        int parseInt = Integer.parseInt(property);
        return parseInt == -1 ? "" : String.valueOf(parseInt);
    }

    public String getIP() {
        if (this.wifiManager == null) {
            this.wifiManager = (WifiManager) this.mContext.getApplicationContext().getSystemService(StringFog.decrypt("VkpCSg=="));
        }
        WifiInfo connectionInfo = this.wifiManager.getConnectionInfo();
        return connectionInfo != null ? intToIp(connectionInfo.getIpAddress()) : "";
    }

    public final int getLinkSpeed() {
        WifiInfo connectionInfo;
        if (this.wifiManager == null) {
            this.wifiManager = (WifiManager) this.mContext.getApplicationContext().getSystemService(StringFog.decrypt("VkpCSg=="));
        }
        WifiManager wifiManager = this.wifiManager;
        if (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
            return 0;
        }
        return connectionInfo.getLinkSpeed();
    }

    public final JSONArray getNeighborInfo() {
        SafeJSONObject safeJSONObject;
        String decrypt;
        String str;
        JSONArray jSONArray = new JSONArray();
        if (!NativeLib.checkLoadSo()) {
            return jSONArray;
        }
        String[] gn = NativeLib.gn();
        String gatewayIp = getGatewayIp();
        if (gn != null) {
            if (!TextUtils.isEmpty(gatewayIp)) {
                for (String str2 : gn) {
                    if (!TextUtils.isEmpty(str2) && str2.split(" ")[0].equals(gatewayIp)) {
                        this.gatewayMac = str2.split(" ")[4];
                        break;
                    }
                }
            }
            int i10 = 0;
            for (String str3 : gn) {
                if (!TextUtils.isEmpty(str3)) {
                    String[] split = str3.split(" ");
                    String str4 = split[0];
                    if (!IpUtil.ipCheck(str4)) {
                        continue;
                    } else {
                        if (i10 >= neigh_size_control) {
                            break;
                        }
                        String str5 = "c2ZlYGliZm1k";
                        if (!str3.contains(StringFog.decrypt("c2ZlYGliZm1k")) || str4.equals(gatewayIp)) {
                            str5 = "cndlb2Q=";
                            if (str3.contains(StringFog.decrypt("cndlb2Q=")) && !str4.equals(gatewayIp)) {
                                safeJSONObject = new SafeJSONObject();
                                safeJSONObject.put(StringFog.decrypt("SFM="), str4);
                                decrypt = StringFog.decrypt("TEJH");
                                str = split[4];
                            }
                        } else {
                            safeJSONObject = new SafeJSONObject();
                            safeJSONObject.put(StringFog.decrypt("SFM="), str4);
                            decrypt = StringFog.decrypt("TEJH");
                            str = split[4];
                        }
                        safeJSONObject.put(decrypt, str);
                        safeJSONObject.put(StringFog.decrypt("UldFV0Q="), StringFog.decrypt(str5));
                        jSONArray.put(safeJSONObject);
                        i10++;
                    }
                }
            }
        }
        return jSONArray;
    }

    @Nullable
    public final String getNetworkClass() {
        TelephonyManager telephonyManager = (TelephonyManager) this.mcontext.getSystemService(StringFog.decrypt("UUtLTUQ="));
        if (telephonyManager == null) {
            return StringFog.decrypt("VE1PTU5USg==");
        }
        try {
            int networkType = telephonyManager.getNetworkType();
            if (networkType == 20) {
                return StringFog.decrypt("FEQ=");
            }
            switch (networkType) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return StringFog.decrypt("E0Q=");
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return StringFog.decrypt("EkQ=");
                case 13:
                    return StringFog.decrypt("FUQ=");
                default:
                    return StringFog.decrypt("VE1PTU5USg==");
            }
        } catch (Exception unused) {
            return StringFog.decrypt("VE1PTU5USg==");
        }
    }

    @Nullable
    public final String getNetworkType() {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (!this.permissionUtils.isPermissionGranted(StringFog.decrypt("QE1AUU5KQA9RRlZOSFBXSE5NCmJiYGFycnxqZnV0a3NqfHd3YHdh")) || (connectivityManager = (ConnectivityManager) this.mcontext.getSystemService(StringFog.decrypt("QkxKTURAUEhXSlBa"))) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return null;
        }
        if (activeNetworkInfo.getType() == 1 || activeNetworkInfo.getType() == 6) {
            return StringFog.decrypt("VkpCSg==");
        }
        if (activeNetworkInfo.getType() == 0) {
            return activeNetworkInfo.getTypeName();
        }
        return null;
    }

    public final int getRSSI() {
        WifiInfo connectionInfo;
        if (this.wifiManager == null) {
            this.wifiManager = (WifiManager) this.mContext.getApplicationContext().getSystemService(StringFog.decrypt("VkpCSg=="));
        }
        WifiManager wifiManager = this.wifiManager;
        if (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
            return 0;
        }
        return connectionInfo.getRssi();
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String getSSID() {
        /*
            Method dump skipped, instructions count: 297
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.danlan.android.cognition.collector.NetworkCollector.getSSID():java.lang.String");
    }

    @Nullable
    public final Boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager;
        if (!this.permissionUtils.isPermissionGranted(StringFog.decrypt("QE1AUU5KQA9RRlZOSFBXSE5NCmJiYGFycnxqZnV0a3NqfHd3YHdh")) || (connectivityManager = (ConnectivityManager) this.mcontext.getApplicationContext().getSystemService(StringFog.decrypt("QkxKTURAUEhXSlBa"))) == null) {
            return null;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return Boolean.valueOf(activeNetworkInfo != null && activeNetworkInfo.isConnected());
    }

    public final boolean isWifiApOpen() {
        try {
            if (this.wifiManager == null) {
                this.wifiManager = (WifiManager) this.mContext.getApplicationContext().getSystemService(StringFog.decrypt("VkpCSg=="));
            }
            return ((Integer) this.wifiManager.getClass().getDeclaredMethod(StringFog.decrypt("RkZQdEhFTWBRcFBCVUY="), new Class[0]).invoke(this.wifiManager, new Object[0])).intValue() == ((Integer) this.wifiManager.getClass().getDeclaredField(StringFog.decrypt("dmpian5idH5yd2V3ZHxhb2BhaGZl")).get(this.wifiManager)).intValue();
        } catch (IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public final Boolean isWifiEnabled() {
        boolean isWifiEnabled;
        WifiManager wifiManager = (WifiManager) this.mcontext.getSystemService(StringFog.decrypt("VkpCSg=="));
        if (wifiManager != null) {
            try {
                isWifiEnabled = wifiManager.isWifiEnabled();
            } catch (Exception unused) {
            }
            return Boolean.valueOf(isWifiEnabled);
        }
        isWifiEnabled = false;
        return Boolean.valueOf(isWifiEnabled);
    }

    public final boolean isWifiProxy() {
        return !TextUtils.isEmpty(System.getProperty(StringFog.decrypt("SVdQUw9TVk5ZWmxMUlc=")));
    }
}
