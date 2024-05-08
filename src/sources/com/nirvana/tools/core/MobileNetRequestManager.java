package com.nirvana.tools.core;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import java.net.InetAddress;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class MobileNetRequestManager {
    public static final int CODE_SWITCH_EXCEPTION = 80801;
    public static final int CODE_SWITCH_TIMEOUT = 80800;
    private static final int DELAY_CHECK = 2500;
    public static final String MSG_SWITCH_EXCEPTION = "WIFI切换异常";
    public static final String MSG_SWITCH_TIMEOUT = "WIFI切换超时";
    private static final String TAG = "MobileNetRequestManager";
    public CountDownLatch countDownLatch;
    private SwitchToMobileListener mSwitchToMobileListener;
    private boolean switchState = false;
    private int mExpiredTime = DELAY_CHECK;
    private ConnectivityManager connectivityManager = null;
    private ConnectivityManager.NetworkCallback myNetCallback = null;
    private long expendTime = 0;
    private long startTime = 0;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface SwitchToMobileListener {
        void onFail(int i10, String str, long j10);

        void onSuccess(Network network, long j10);
    }

    private void destry() {
        ConnectivityManager.NetworkCallback networkCallback;
        ConnectivityManager connectivityManager = this.connectivityManager;
        if (connectivityManager == null || (networkCallback = this.myNetCallback) == null) {
            return;
        }
        try {
            connectivityManager.unregisterNetworkCallback(networkCallback);
        } catch (Throwable unused) {
        }
        this.connectivityManager = null;
    }

    public static String extractAddressFromUrl(String str) {
        int indexOf = str.indexOf("://");
        if (indexOf > 0) {
            str = str.substring(indexOf + 3);
        }
        int indexOf2 = str.indexOf(58);
        if (indexOf2 >= 0) {
            str = str.substring(0, indexOf2);
        }
        int indexOf3 = str.indexOf(47);
        if (indexOf3 >= 0) {
            str = str.substring(0, indexOf3);
        }
        int indexOf4 = str.indexOf(63);
        return indexOf4 >= 0 ? str.substring(0, indexOf4) : str;
    }

    public static int lookupHost(String str) {
        try {
            byte[] address = InetAddress.getByName(str).getAddress();
            return (address[0] & 255) | ((address[3] & 255) << 24) | ((address[2] & 255) << 16) | ((address[1] & 255) << 8);
        } catch (Throwable unused) {
            return -1;
        }
    }

    private void switchToMobileForAboveL(Context context) {
        this.expendTime = 0L;
        this.connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        this.startTime = System.currentTimeMillis();
        NetworkRequest.Builder builder = new NetworkRequest.Builder();
        builder.addCapability(12);
        builder.addTransportType(0);
        NetworkRequest build = builder.build();
        ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback() { // from class: com.nirvana.tools.core.MobileNetRequestManager.1
            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                long currentTimeMillis = System.currentTimeMillis();
                MobileNetRequestManager mobileNetRequestManager = MobileNetRequestManager.this;
                mobileNetRequestManager.expendTime = currentTimeMillis - mobileNetRequestManager.startTime;
                MobileNetRequestManager.this.switchState = true;
                if (MobileNetRequestManager.this.mSwitchToMobileListener != null) {
                    MobileNetRequestManager.this.mSwitchToMobileListener.onSuccess(network, MobileNetRequestManager.this.expendTime);
                }
                if (MobileNetRequestManager.this.connectivityManager != null) {
                    try {
                        MobileNetRequestManager.this.connectivityManager.unregisterNetworkCallback(this);
                        MobileNetRequestManager.this.connectivityManager = null;
                    } catch (Throwable unused) {
                        String unused2 = MobileNetRequestManager.TAG;
                    }
                }
            }
        };
        this.myNetCallback = networkCallback;
        this.connectivityManager.requestNetwork(build, networkCallback);
    }

    private boolean switchToMobileForUnderL(Context context, String str) {
        boolean z10 = false;
        try {
            Class<?> cls = Class.forName("android.net.ConnectivityManager");
            this.expendTime = 0L;
            this.startTime = System.currentTimeMillis();
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            this.connectivityManager = connectivityManager;
            if (connectivityManager.getNetworkInfo(5).getState().compareTo((Enum) NetworkInfo.State.CONNECTED) != 0) {
                cls.getMethod("startUsingNetworkFeature", Integer.TYPE, String.class).invoke(this.connectivityManager, 0, "enableHIPRI");
                for (int i10 = 0; i10 < 5; i10++) {
                    try {
                        if (this.connectivityManager.getNetworkInfo(5).getState().compareTo((Enum) NetworkInfo.State.CONNECTED) == 0) {
                            break;
                        }
                        Thread.sleep(500L);
                    } catch (Throwable unused) {
                    }
                }
            }
            int lookupHost = lookupHost(extractAddressFromUrl(str));
            Class<Integer> cls2 = Integer.TYPE;
            z10 = ((Boolean) cls.getMethod("requestRouteToHost", cls2, cls2).invoke(this.connectivityManager, 5, Integer.valueOf(lookupHost))).booleanValue();
            this.expendTime = System.currentTimeMillis() - this.startTime;
            StringBuilder sb2 = new StringBuilder("Switch network result ： ");
            sb2.append(z10);
            sb2.append(" (4.x) , expendTime ：");
            sb2.append(this.expendTime);
            return z10;
        } catch (Throwable unused2) {
            return z10;
        }
    }

    public boolean switchToMobile_4x(Context context, String str) {
        return switchToMobileForUnderL(context, str);
    }

    public void switchToMobile_L(Context context, int i10, SwitchToMobileListener switchToMobileListener) {
        if (i10 < DELAY_CHECK) {
            this.mExpiredTime = DELAY_CHECK;
        } else {
            this.mExpiredTime = i10;
        }
        this.mSwitchToMobileListener = switchToMobileListener;
        this.countDownLatch = new CountDownLatch(1);
        try {
            switchToMobileForAboveL(context);
            this.countDownLatch.await(this.mExpiredTime, TimeUnit.MILLISECONDS);
        } catch (Throwable unused) {
            this.countDownLatch.countDown();
            SwitchToMobileListener switchToMobileListener2 = this.mSwitchToMobileListener;
            if (switchToMobileListener2 != null) {
                switchToMobileListener2.onFail(CODE_SWITCH_EXCEPTION, MSG_SWITCH_EXCEPTION, -1L);
            }
        }
        if (this.switchState) {
            return;
        }
        SwitchToMobileListener switchToMobileListener3 = this.mSwitchToMobileListener;
        if (switchToMobileListener3 != null) {
            switchToMobileListener3.onFail(CODE_SWITCH_TIMEOUT, MSG_SWITCH_TIMEOUT, 2500L);
        }
        destry();
    }
}
