package com.irisdt.biz;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Point;
import android.os.Build;
import com.google.protobuf.Any;
import com.google.protobuf.Message;
import com.irisdt.BuildConfig;
import com.irisdt.CommonProtos;
import com.irisdt.StatConfig;
import com.irisdt.util.DeviceUtils;
import com.irisdt.util.NetworkUtils;
import com.irisdt.util.Utils;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class Common {
    private volatile CommonProtos.Common common;
    private final CommonProtos.Common.Builder commonBuilder;
    private volatile boolean rebuild;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class InstanceHolder {
        private static final Common INSTANCE = new Common();

        private InstanceHolder() {
        }
    }

    public static Common getInstance() {
        return InstanceHolder.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getValue(String str) {
        this.rebuild = true;
        return Utils.getStringValue(str);
    }

    private void setDefaultValues() {
        String str;
        Locale locale = Locale.getDefault();
        TimeZone timeZone = TimeZone.getDefault();
        try {
            str = timeZone.getID() + "," + timeZone.getDisplayName(false, 0);
        } catch (AssertionError | Exception unused) {
            str = null;
        }
        Point screenSize = DeviceUtils.getScreenSize(StatConfig.getAppContext());
        this.commonBuilder.setDevice(Utils.getStringValue(DeviceUtils.getDeviceName())).setOsVersion(Utils.getStringValue(Build.VERSION.RELEASE)).setTimezone(Utils.getStringValue(str)).setLanguage(Utils.getStringValue(locale.getLanguage())).setRegion(Utils.getStringValue(locale.getCountry())).setScreenWidth(screenSize == null ? 0 : screenSize.x).setScreenHigh(screenSize != null ? screenSize.y : 0).setAppVersion(Utils.getStringValue(DeviceUtils.getVersionName(StatConfig.getAppContext()))).setAppVersionCode(DeviceUtils.getVersionCode(StatConfig.getAppContext())).setNetOp(Utils.getStringValue(NetworkUtils.getNetworkOperator(StatConfig.getAppContext()))).setNet(Utils.getStringValue(NetworkUtils.getNetworkType(StatConfig.getAppContext()))).setSdkVersionCode(BuildConfig.VERSION_CODE);
        if (StatConfig.getAppContext() != null) {
            StatConfig.getAppContext().registerReceiver(new BroadcastReceiver() { // from class: com.irisdt.biz.Common.1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    Common.this.commonBuilder.setNet(Common.this.getValue(NetworkUtils.getNetworkType(StatConfig.getAppContext()))).setNetOp(Common.this.getValue(NetworkUtils.getNetworkOperator(StatConfig.getAppContext())));
                }
            }, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
        this.rebuild = true;
    }

    public CommonProtos.Common getProtoData() {
        if (this.common == null || this.rebuild) {
            this.common = this.commonBuilder.build();
            this.rebuild = false;
        }
        return this.common;
    }

    public Common setAppVersion(String str) {
        this.rebuild = true;
        this.commonBuilder.setAppVersion(str);
        return this;
    }

    public Common setAppVersionCode(int i10) {
        this.rebuild = true;
        this.commonBuilder.setAppVersionCode(i10);
        return this;
    }

    public Common setChannel(String str) {
        this.commonBuilder.setChannel(getValue(str));
        return this;
    }

    public Common setExtra(Message message) {
        try {
            this.commonBuilder.setExtra(Any.pack(message));
            this.rebuild = true;
        } catch (Exception unused) {
        }
        return this;
    }

    public Common setLat(String str) {
        this.commonBuilder.setLat(getValue(str));
        return this;
    }

    public Common setLon(String str) {
        this.commonBuilder.setLon(getValue(str));
        return this;
    }

    public Common setPlatform(String str) {
        this.commonBuilder.setPlatform(getValue(str));
        return this;
    }

    public Common setShumeiBoxId(String str) {
        this.commonBuilder.setBoxId(getValue(str));
        return this;
    }

    public Common setShumeiId(String str) {
        this.commonBuilder.setSmid(getValue(str));
        return this;
    }

    public Common setShumengId(String str) {
        this.commonBuilder.setDevDna(getValue(str));
        return this;
    }

    public Common setUid(long j10) {
        this.rebuild = true;
        this.commonBuilder.setUid(j10);
        return this;
    }

    public Common setUidStr(String str) {
        this.commonBuilder.setUidStr(getValue(str));
        return this;
    }

    private Common() {
        this.commonBuilder = CommonProtos.Common.newBuilder();
        this.common = null;
        this.rebuild = true;
        setDefaultValues();
    }
}
