package com.wangmai.qumeng;

import android.content.Context;
import android.content.pm.PackageInfo;
import appa.appa.appf.appd;
import com.hailiang.advlib.api.AiClkAdManager;
import com.hailiang.advlib.core.IQLocation;
import com.hailiang.advlib.core.QLocation;
import com.hailiang.advlib.core.QMConfig;
import com.hailiang.advlib.core.QMCustomControl;
import com.huawei.openalliance.ad.constant.u;
import com.wangmai.adIdUtils.utils.IdUtils;
import com.wangmai.common.Ilistener.IWMCommonListener;
import com.wangmai.common.utils.ConstantInfo;
import com.wangmai.common.utils.ThreadUtils;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class QuMengSdkInitHelper {
    private static final int INIT_WAIT_TIME = 2000;
    private static final String TAG = "QuMengSdkInitHelper";
    private static volatile boolean initialized = false;
    private static volatile boolean initializing = false;
    static CountDownLatch mCountDownLatch = new CountDownLatch(1);
    private static volatile QuMengSdkInitHelper quMengSdkInitHelper = null;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    static class WMQMCustomController extends QMCustomControl {
        Context context;

        public WMQMCustomController(Context context) {
            this.context = context;
        }

        @Override // com.hailiang.advlib.core.QMCustomControl
        public String getAndroidId() {
            return super.getAndroidId();
        }

        @Override // com.hailiang.advlib.core.QMCustomControl
        public List<PackageInfo> getAppList() {
            return super.getAppList();
        }

        @Override // com.hailiang.advlib.core.QMCustomControl
        public String getDevImei() {
            return ConstantInfo.getDevImei();
        }

        @Override // com.hailiang.advlib.core.QMCustomControl
        public String getDevImsi() {
            return super.getDevImsi();
        }

        @Override // com.hailiang.advlib.core.QMCustomControl
        public String getMacAddress() {
            return ConstantInfo.getDevMacAddress();
        }

        @Override // com.hailiang.advlib.core.QMCustomControl
        public String getOaid() {
            if (ConstantInfo.isCanUseOaid()) {
                return IdUtils.getOaid(this.context);
            }
            return ConstantInfo.getDevOaid();
        }

        @Override // com.hailiang.advlib.core.QMCustomControl
        public IQLocation getQLocation() {
            if (ConstantInfo.getDevWMLocation() != null) {
                return new QLocation(ConstantInfo.getDevWMLocation().getLatitude(), ConstantInfo.getDevWMLocation().getLongitude(), 0);
            }
            return null;
        }

        @Override // com.hailiang.advlib.core.QMCustomControl
        public boolean isCanUseAndroidId() {
            return ConstantInfo.isCanUsePhoneState();
        }

        @Override // com.hailiang.advlib.core.QMCustomControl
        public boolean isCanUseAppList() {
            return ConstantInfo.isCanUseAppList();
        }

        @Override // com.hailiang.advlib.core.QMCustomControl
        public boolean isCanUsePhoneState() {
            return ConstantInfo.isCanUsePhoneState();
        }
    }

    private QuMengSdkInitHelper() {
    }

    private void executeInit(final Context context, String str, final IWMCommonListener iWMCommonListener) {
        ThreadUtils.runOnThreadPool(new Runnable() { // from class: com.wangmai.qumeng.QuMengSdkInitHelper.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (!QuMengSdkInitHelper.initializing) {
                        boolean unused = QuMengSdkInitHelper.initializing = true;
                        appd.appa(QuMengSdkInitHelper.TAG, "[mq.mw] Sdk init...", "是否开启个性化广告推荐：" + ConstantInfo.isEnablePersonalized());
                        appd.appa(QuMengSdkInitHelper.TAG, "是否允许SDK采集粗略地理位置：" + ConstantInfo.isCanUseLocation());
                        appd.appa(QuMengSdkInitHelper.TAG, "媒体传入的定位信息：" + ((Object) ConstantInfo.getDevWMLocation()));
                        appd.appa(QuMengSdkInitHelper.TAG, "是否允许SDK读取设备硬件信息：" + ConstantInfo.isCanUsePhoneState());
                        appd.appa(QuMengSdkInitHelper.TAG, "媒体传入的IMEI信息：" + ConstantInfo.getDevImei());
                        appd.appa(QuMengSdkInitHelper.TAG, "是否允许SDK采集Oaid：" + ConstantInfo.isCanUseOaid());
                        appd.appa(QuMengSdkInitHelper.TAG, "媒体传入的OAID信息：" + ConstantInfo.getDevOaid());
                        appd.appa(QuMengSdkInitHelper.TAG, "是否允许SDK读取WIFI信息：" + ConstantInfo.isCanUseWifiState());
                        appd.appa(QuMengSdkInitHelper.TAG, "媒体传入的Mac地址信息：" + ConstantInfo.getDevMacAddress());
                        appd.appa(QuMengSdkInitHelper.TAG, "是否允许SDK读取网络信息：" + ConstantInfo.isCanUseNetworkState());
                        appd.appa(QuMengSdkInitHelper.TAG, "是否允许SDK读写外部存储：" + ConstantInfo.isCanUseWriteExternal());
                        appd.appa(QuMengSdkInitHelper.TAG, "是否允许SDK读取已安装应用列表：" + ConstantInfo.isCanUseAppList());
                        AiClkAdManager.getInstance().init(new QMConfig.Builder().customControl(new WMQMCustomController(context)).debug(true).build(context));
                        AiClkAdManager.getInstance().setPersonalRecommend(ConstantInfo.isEnablePersonalized());
                        appd.appa(QuMengSdkInitHelper.TAG, "[mq.mw] sdk初始化完成");
                        boolean unused2 = QuMengSdkInitHelper.initialized = true;
                        if (iWMCommonListener != null) {
                            iWMCommonListener.success();
                        }
                        QuMengSdkInitHelper.mCountDownLatch.countDown();
                        return;
                    }
                    QuMengSdkInitHelper.mCountDownLatch.await(2000L, TimeUnit.MILLISECONDS);
                    if (QuMengSdkInitHelper.initialized) {
                        if (iWMCommonListener != null) {
                            iWMCommonListener.success();
                        }
                    } else {
                        if (iWMCommonListener != null) {
                            iWMCommonListener.fail("[mq.mw] sdk初始化失败(time out)");
                        }
                        boolean unused3 = QuMengSdkInitHelper.initializing = false;
                    }
                } catch (Throwable th) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("[mq.mw] sdk初始化失败");
                    sb2.append(u.bD);
                    sb2.append(th.getMessage());
                    appd.appe(QuMengSdkInitHelper.TAG, sb2.toString());
                    IWMCommonListener iWMCommonListener2 = iWMCommonListener;
                    if (iWMCommonListener2 != null) {
                        iWMCommonListener2.fail(sb2.toString());
                    }
                    QuMengSdkInitHelper.mCountDownLatch.countDown();
                }
            }
        });
    }

    public static QuMengSdkInitHelper getInstance() {
        if (quMengSdkInitHelper == null) {
            synchronized (QuMengSdkInitHelper.class) {
                if (quMengSdkInitHelper == null) {
                    quMengSdkInitHelper = new QuMengSdkInitHelper();
                }
            }
        }
        return quMengSdkInitHelper;
    }

    public void init(Context context, String str, IWMCommonListener iWMCommonListener) {
        if (!initialized) {
            executeInit(context, str, iWMCommonListener);
            return;
        }
        appd.appa(TAG, "[mq.mw] sdk has been initialized!" + ((Object) iWMCommonListener));
        if (iWMCommonListener != null) {
            iWMCommonListener.success();
        }
    }
}
