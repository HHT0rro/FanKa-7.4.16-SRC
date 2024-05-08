package ad;

import android.content.Context;
import android.os.Build;
import com.wangmai.common.bean.AppConfigReqBean;
import com.wangmai.common.bean.ScreenSize;
import com.wangmai.common.utils.AesUtil;
import com.wangmai.common.utils.ConstantInfo;
import com.wangmai.common.utils.DebugLog;
import com.wangmai.common.utils.PrivateInfoHelper;
import com.wangmai.common.utils.Utils;
import java.util.Locale;

/* compiled from: RequestBeanHelper.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static final String f809a = "dexd";

    public static AppConfigReqBean a(Context context, String str, String str2) {
        System.currentTimeMillis();
        String md5Decode = AesUtil.md5Decode(str2 + str);
        AppConfigReqBean appConfigReqBean = new AppConfigReqBean();
        appConfigReqBean.setSign(md5Decode);
        appConfigReqBean.setApptoken(str);
        AppConfigReqBean.DataBean dataBean = new AppConfigReqBean.DataBean();
        AppConfigReqBean.DataBean.App app = new AppConfigReqBean.DataBean.App();
        app.setAppName(Utils.getAppName(context.getApplicationContext()) + "");
        app.setPkgName(context.getApplicationContext().getPackageName() + "");
        app.setAppVersion(Utils.getVersionName(context) + "");
        dataBean.setApp(app);
        try {
            AppConfigReqBean.DataBean.Device device = new AppConfigReqBean.DataBean.Device();
            device.setTimezone(Utils.getTimeZone());
            device.setOsType(1);
            device.setDeviceType(Utils.getDeviceType(context.getApplicationContext()));
            device.setOsVersion(String.valueOf(Build.VERSION.RELEASE));
            device.setLanguage(Locale.getDefault().getLanguage());
            device.setResolution(Utils.getResolution(context.getApplicationContext(), true));
            device.setMac(PrivateInfoHelper.getMac(context));
            device.setVendor(Build.BRAND);
            device.setModel(Build.MODEL);
            device.setDpi(String.valueOf(Utils.getDensity(context.getApplicationContext())));
            device.setXdpi(String.valueOf(context.getApplicationContext().getResources().getDisplayMetrics().xdpi));
            device.setYdpi(String.valueOf(context.getApplicationContext().getResources().getDisplayMetrics().ydpi));
            device.setAndroidId(PrivateInfoHelper.getAndroidId(context));
            device.setCheckInstalledFlag(ConstantInfo.CHECKINSTALLEDFLAG);
            try {
                if (Build.VERSION.SDK_INT <= 28) {
                    device.setImei(PrivateInfoHelper.getIMEI(context));
                }
            } catch (Throwable th) {
                DebugLog.W(f809a, zc.b.a("ifbeCfbo!JNFJ!fydfqujpo;") + th.toString());
            }
            try {
                device.setOaid(PrivateInfoHelper.getOaid(context));
            } catch (Throwable th2) {
                DebugLog.W(f809a, zc.b.a("ifbeCfbo!PBJE!fydfqujpo;") + th2.toString());
            }
            device.setMeid(PrivateInfoHelper.getMEID(context));
            try {
                device.setFingerprint(ConstantInfo.deviceFingerprint);
                device.setBoot_mark(ConstantInfo.bootMark);
                device.setUpdate_mark(ConstantInfo.updateMark);
                device.setCtzid(ConstantInfo.wmId);
            } catch (Throwable th3) {
                DebugLog.W(f809a, zc.b.a("ifbeCfbo!DoBeje!fydfqujpo;") + th3.toString());
            }
            try {
                device.setPpi((int) Utils.getDensity(context));
            } catch (Throwable th4) {
                DebugLog.W(f809a, zc.b.a("ifbeCfbo!Qqj!fydfqujpo;") + th4.toString());
            }
            try {
                device.setUa(Utils.getUserAgent(context));
            } catch (Throwable th5) {
                DebugLog.W(f809a, zc.b.a("ifbeCfbo!VB!fydfqujpo;") + th5.toString());
            }
            ScreenSize screenSize = new ScreenSize();
            try {
                screenSize.setHeight(Utils.getWindowHeight(context));
                screenSize.setWidth(Utils.getWindowWidth(context));
            } catch (Throwable th6) {
                DebugLog.W(f809a, zc.b.a("ifbeCfbo!tdsffo!tj{f!fydfqujpo;") + th6.toString());
            }
            device.setScreenSize(screenSize);
            device.setOrientation(Utils.getOrientation(context.getApplicationContext()));
            device.setDensity(String.valueOf(Utils.getDensity(context.getApplicationContext())));
            try {
                device.setPxratio(Utils.getDensity(context.getApplicationContext()));
            } catch (Throwable th7) {
                DebugLog.W(f809a, zc.b.a("ifbeCfbo!Qysbujp!fydfqujpo;") + th7.toString());
            }
            dataBean.setDevice(device);
            AppConfigReqBean.DataBean.Networks networks = new AppConfigReqBean.DataBean.Networks();
            networks.setConnectionType(PrivateInfoHelper.getConnectType(context));
            networks.setMcc(PrivateInfoHelper.getMCC(context));
            networks.setMnc(PrivateInfoHelper.getMNC(context));
            networks.setImsi(PrivateInfoHelper.getIMSI(context));
            networks.setOperator(PrivateInfoHelper.getOperator(context));
            networks.setOperatorType(PrivateInfoHelper.getOperatorType(context));
            dataBean.setNetwork(networks);
            try {
                AppConfigReqBean.DataBean.Gps gps = new AppConfigReqBean.DataBean.Gps();
                gps.setLatitude(PrivateInfoHelper.getLatitude(context));
                gps.setLongitude(PrivateInfoHelper.getLongitude(context));
                dataBean.setGps(gps);
            } catch (Throwable th8) {
                DebugLog.W(f809a, zc.b.a("ifbeCfbo!HQT!fssps;") + th8.toString());
            }
        } catch (Throwable th9) {
            DebugLog.W(f809a, zc.b.a("hfuBqqDpogjhSfrCfbo!fssps;") + th9.toString());
        }
        appConfigReqBean.setData(dataBean);
        return appConfigReqBean;
    }
}
