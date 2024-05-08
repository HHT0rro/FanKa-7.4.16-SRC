package com.wangmai.tanx;

import android.app.Application;
import android.text.TextUtils;
import appa.appa.appf.appd;
import com.alimm.tanx.core.TanxInitListener;
import com.alimm.tanx.core.config.TanxConfig;
import com.alimm.tanx.ui.TanxSdk;
import com.huawei.openalliance.ad.constant.u;
import com.wangmai.common.Ilistener.IWMCommonListener;
import com.wangmai.common.utils.ConstantInfo;
import com.wangmai.common.utils.ThreadUtils;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class TanxSdkHelper {
    private static final int INIT_WAIT_TIME = 2000;
    private static final String TAG = "TanxSdkHelper";
    private static volatile boolean initialized = false;
    private static volatile boolean initializing = false;
    static CountDownLatch mCountDownLatch = new CountDownLatch(1);
    private static volatile TanxSdkHelper tanxSdkHelper = null;

    private TanxSdkHelper() {
    }

    private void executeInit(final Application application, final String str, final String str2, final IWMCommonListener iWMCommonListener) {
        ThreadUtils.runOnThreadPool(new Runnable() { // from class: com.wangmai.tanx.TanxSdkHelper.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (!TanxSdkHelper.initializing) {
                        boolean unused = TanxSdkHelper.initializing = true;
                        appd.appa(TanxSdkHelper.TAG, "[xt.mw] sdk init...将要初始化的AppId=" + str);
                        appd.appa(TanxSdkHelper.TAG, "是否允许SDK采集粗略地理位置：" + ConstantInfo.isCanUseLocation());
                        appd.appa(TanxSdkHelper.TAG, "媒体传入的定位信息：" + ((Object) ConstantInfo.getDevWMLocation()));
                        appd.appa(TanxSdkHelper.TAG, "是否允许SDK读取设备硬件信息：" + ConstantInfo.isCanUsePhoneState());
                        appd.appa(TanxSdkHelper.TAG, "媒体传入的IMEI信息：" + ConstantInfo.getDevImei());
                        appd.appa(TanxSdkHelper.TAG, "是否允许SDK采集Oaid：" + ConstantInfo.isCanUseOaid());
                        appd.appa(TanxSdkHelper.TAG, "媒体传入的OAID信息：" + ConstantInfo.getDevOaid());
                        TanxConfig.Builder debug = new TanxConfig.Builder().appName("wm sdk").appId(str).appKey(str2).oaidSwitch(ConstantInfo.isCanUseOaid()).imeiSwitch(ConstantInfo.isCanUsePhoneState()).debug(true);
                        if (ConstantInfo.isCanUsePhoneState() && ConstantInfo.isCanUseOaid()) {
                            debug.idAllSwitch(true);
                        } else if (ConstantInfo.isCanUsePhoneState()) {
                            debug.imeiSwitch(true);
                            debug.oaidSwitch(false);
                            if (!TextUtils.isEmpty(ConstantInfo.getDevOaid())) {
                                debug.oaid(ConstantInfo.getDevOaid());
                            }
                        } else {
                            debug.oaidSwitch(true);
                            debug.imeiSwitch(false);
                            if (!TextUtils.isEmpty(ConstantInfo.getDevImei())) {
                                debug.imei(ConstantInfo.getDevImei());
                            }
                        }
                        TanxSdk.init(application, debug.build(), new TanxInitListener() { // from class: com.wangmai.tanx.TanxSdkHelper.1.1
                            @Override // com.alimm.tanx.core.TanxInitListener
                            public void error(int i10, String str3) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("[xt.mw] sdk初始化失败");
                                sb2.append(u.bD);
                                sb2.append(i10);
                                sb2.append(",");
                                sb2.append(str3);
                                appd.appa(TanxSdkHelper.TAG, sb2.toString());
                                IWMCommonListener iWMCommonListener2 = iWMCommonListener;
                                if (iWMCommonListener2 != null) {
                                    iWMCommonListener2.fail(sb2.toString());
                                }
                                TanxSdkHelper.mCountDownLatch.countDown();
                            }

                            @Override // com.alimm.tanx.core.TanxInitListener
                            public void succ() {
                                appd.appa(TanxSdkHelper.TAG, "[xt.mw] sdk初始化完成");
                                boolean unused2 = TanxSdkHelper.initialized = true;
                                IWMCommonListener iWMCommonListener2 = iWMCommonListener;
                                if (iWMCommonListener2 != null) {
                                    iWMCommonListener2.success();
                                }
                                TanxSdkHelper.mCountDownLatch.countDown();
                            }
                        });
                        return;
                    }
                    TanxSdkHelper.mCountDownLatch.await(2000L, TimeUnit.MILLISECONDS);
                    if (TanxSdkHelper.initialized) {
                        if (iWMCommonListener != null) {
                            iWMCommonListener.success();
                        }
                    } else {
                        if (iWMCommonListener != null) {
                            iWMCommonListener.fail("[xt.mw] sdk初始化失败(time out)");
                        }
                        boolean unused2 = TanxSdkHelper.initializing = false;
                    }
                } catch (Throwable th) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("[xt.mw] sdk初始化失败");
                    sb2.append(u.bD);
                    sb2.append(th.getMessage());
                    appd.appe(TanxSdkHelper.TAG, sb2.toString());
                    IWMCommonListener iWMCommonListener2 = iWMCommonListener;
                    if (iWMCommonListener2 != null) {
                        iWMCommonListener2.fail(sb2.toString());
                    }
                    TanxSdkHelper.mCountDownLatch.countDown();
                }
            }
        });
    }

    public static TanxSdkHelper getInstance() {
        if (tanxSdkHelper == null) {
            synchronized (TanxSdkHelper.class) {
                if (tanxSdkHelper == null) {
                    tanxSdkHelper = new TanxSdkHelper();
                }
            }
        }
        return tanxSdkHelper;
    }

    public void init(Application application, String str, String str2, IWMCommonListener iWMCommonListener) {
        if (!initialized) {
            executeInit(application, str, str2, iWMCommonListener);
            return;
        }
        appd.appc(TAG, "[xt.mw] sdk has been initialized!");
        if (iWMCommonListener != null) {
            iWMCommonListener.success();
        }
    }
}
