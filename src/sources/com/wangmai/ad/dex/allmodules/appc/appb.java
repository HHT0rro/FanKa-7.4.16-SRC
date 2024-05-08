package com.wangmai.ad.dex.allmodules.appc;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.google.gson.reflect.TypeToken;
import com.wangmai.ad.dex.allmodules.bean.ApiBean;
import com.wangmai.ad.dex.allmodules.bean.RequestBean;
import com.wangmai.ad.dex.allmodules.utils.appf;
import com.wangmai.ad.dex.allmodules.utils.appr;
import com.wangmai.common.runnable.HasReturnRunnable;
import com.wangmai.common.runnable.HasTypeRunnable;
import com.wangmai.common.utils.AesUtil;
import com.wangmai.common.utils.CacheInfoUtil;
import com.wangmai.common.utils.ConstantInfo;
import com.wangmai.common.utils.GZIPUtils;
import com.wangmai.common.utils.GsonUtils;
import com.wangmai.common.utils.SharedPreferencesHelper;
import com.wangmai.okhttp.OkHttp;
import com.wangmai.okhttp.callback.ByteCallback;
import com.wangmai.okhttp.callback.StringCallback;
import com.wangmai.okhttp.model.Response;
import com.wangmai.okhttp.request.PostRequest;
import java.util.Arrays;
import java.util.Map;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: WMApiAdHelper.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class appb {

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: WMApiAdHelper.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    class appa extends ByteCallback {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ String f46718appa;
        final /* synthetic */ String appb;
        final /* synthetic */ HasTypeRunnable appc;

        appa(String str, String str2, HasTypeRunnable hasTypeRunnable) {
            this.f46718appa = str;
            this.appb = str2;
            this.appc = hasTypeRunnable;
        }

        @Override // com.wangmai.okhttp.callback.AbsCallback, com.wangmai.okhttp.callback.Callback
        public void onError(Response<byte[]> response) {
            Throwable exception = response.getException();
            appa.appa.appf.appd.appe(this.f46718appa, "Api fetchAdTwo error:" + exception.toString());
            if (exception != null) {
                appb.appb(this.appc, this.f46718appa, "Api fetchAdTwo error:" + exception.toString());
            }
        }

        @Override // com.wangmai.okhttp.callback.Callback
        public void onSuccess(Response<byte[]> response) {
            try {
                byte[] body = response.body();
                if (body == null || body.length <= 0) {
                    appb.appb(this.appc, this.f46718appa, "Api fetchAdTwo response为空");
                    return;
                }
                String unZipStringToByte = GZIPUtils.unZipStringToByte(AesUtil.decryptToByte(body, ConstantInfo.getAppToken()));
                appa.appa.appf.appd.appa(this.f46718appa, "Api 【getAdTwo<——response】:" + appf.appp + this.appb + ".api", "responseJson:" + unZipStringToByte);
                if (!TextUtils.isEmpty(unZipStringToByte) && !"{}".equals(unZipStringToByte)) {
                    this.appc.run((ApiBean) GsonUtils.getInstance().fromJson(unZipStringToByte, ApiBean.class));
                    return;
                }
                appb.appb(this.appc, this.f46718appa, "Api fetchAdTwo response为空");
            } catch (Throwable th) {
                appb.appb(this.appc, this.f46718appa, "Api fetchAdTwo response解析异常", response.toString(), th.getMessage());
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: WMApiAdHelper.java */
    /* renamed from: com.wangmai.ad.dex.allmodules.appc.appb$appb, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    class C0679appb implements HasReturnRunnable<String> {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ Context f46719appa;

        C0679appb(Context context) {
            this.f46719appa = context;
        }

        @Override // com.wangmai.common.runnable.HasReturnRunnable
        public String run() {
            return SharedPreferencesHelper.getInstance(this.f46719appa).getPreferencesString("WMApiAdHelper");
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: WMApiAdHelper.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    class appc extends StringCallback {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ Context f46720appa;

        appc(Context context) {
            this.f46720appa = context;
        }

        @Override // com.wangmai.okhttp.callback.AbsCallback, com.wangmai.okhttp.callback.Callback
        public void onError(Response<String> response) {
            appa.appa.appf.appd.appb("WMApiAdHelper", "请求失败:" + response.getException().toString());
        }

        @Override // com.wangmai.okhttp.callback.Callback
        public void onSuccess(Response<String> response) {
            try {
                String body = response.body();
                appa.appa.appf.appd.appa("WMApiAdHelper", body);
                if (TextUtils.isEmpty(body)) {
                    return;
                }
                SharedPreferencesHelper.getInstance(this.f46720appa).savePreferencesString("WMApiAdHelper", body);
            } catch (Throwable th) {
                appa.appa.appf.appd.appb("WMApiAdHelper", "数据解析失败:" + th.toString());
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: WMApiAdHelper.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    class appd extends TypeToken<Map<Integer, ApiBean.Permission>> {
        appd() {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: WMApiAdHelper.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    class appe extends ByteCallback {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ HasTypeRunnable f46721appa;

        appe(HasTypeRunnable hasTypeRunnable) {
            this.f46721appa = hasTypeRunnable;
        }

        @Override // com.wangmai.okhttp.callback.AbsCallback, com.wangmai.okhttp.callback.Callback
        public void onError(Response<byte[]> response) {
            appb.appb(this.f46721appa, "getMediaBidPrice onError:" + response.getException().toString());
        }

        @Override // com.wangmai.okhttp.callback.Callback
        public void onSuccess(Response<byte[]> response) {
            try {
                byte[] body = response.body();
                if (body == null || body.length <= 0) {
                    appb.appb(this.f46721appa, "WMApiAdHelper", "getMediaBidPrice response为空");
                    return;
                }
                String unZipStringToByte = GZIPUtils.unZipStringToByte(AesUtil.decryptToByte(body, ConstantInfo.getAppToken()));
                appa.appa.appf.appd.appa("获取媒体结算价", "【getMediaBidPrice<——response】:" + appf.appt, "responseJson:" + unZipStringToByte);
                if (!TextUtils.isEmpty(unZipStringToByte) && !"{}".equals(unZipStringToByte)) {
                    double optDouble = new JSONObject(unZipStringToByte).optDouble("mediaBidPrice", ShadowDrawableWrapper.COS_45);
                    if (optDouble > ShadowDrawableWrapper.COS_45) {
                        this.f46721appa.run(Integer.valueOf((int) Math.round(optDouble * 100.0d)));
                        return;
                    }
                    appb.appb(this.f46721appa, "WMApiAdHelper", "媒体结算价无效：" + unZipStringToByte);
                    return;
                }
                appb.appb(this.f46721appa, "WMApiAdHelper", "getMediaBidPrice response为空");
            } catch (Throwable th) {
                appb.appb(this.f46721appa, "getMediaBidPrice onError:" + th.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> void appb(HasTypeRunnable<T> hasTypeRunnable, String... strArr) {
        appa.appa.appf.appd.appe("WMApiAdHelper", Arrays.toString(strArr));
        hasTypeRunnable.run(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void appa(Context context, String str, String str2, String str3, HasTypeRunnable<ApiBean> hasTypeRunnable) {
        try {
            if (TextUtils.isEmpty(str3)) {
                appa.appa.appf.appd.appb(str, "requestId不可为空");
                return;
            }
            System.currentTimeMillis();
            RequestBean appa2 = new appr().appa(context, str2);
            appa.appa.appf.appd.appa(str, "Api 【getAdTwo——>request】:" + appf.appp + str3 + ".api", "AppToken:" + ConstantInfo.getAppToken(), "data:" + GsonUtils.getInstance().toJson(appa2));
            byte[] encryptByt = AesUtil.encryptByt(GsonUtils.getInstance().toJson(appa2), ConstantInfo.getAppToken());
            System.currentTimeMillis();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(appf.appp);
            sb2.append(str3);
            sb2.append(".api");
            ((PostRequest) OkHttp.post(sb2.toString()).headers("Content-Type", "application/json")).upBytes(encryptByt).execute(new appa(str, str3, hasTypeRunnable));
        } catch (Throwable unused) {
            appb(hasTypeRunnable, str, "Api 网络请求出现异常，请联系我们");
        }
    }

    public static Map<Integer, ApiBean.Permission> appa(Context context) {
        String info = CacheInfoUtil.getInfo(context, "WMApiAdHelper", "WMApiAdHelper", 43200L, new C0679appb(context));
        try {
            if (TextUtils.isEmpty(info)) {
                appa.appa.appf.appd.appe("WMApiAdHelper", "getPermissionData 缓存无效，发起请求");
                OkHttp.post(appf.appz).execute(new appc(context));
                info = "{\"1\":{\"permissionValue\":\"android.permission.ACCESS_CHECKIN_PROPERTIES\",\"title\":\"访问登记属性\",\"description\":\"读取或写入登记check-in数据库属性表的权限\",\"id\":1,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"2\":{\"permissionValue\":\"android.permission.ACCESS_COARSE_LOCATION\",\"title\":\"获取粗略位置\",\"description\":\"通过WiFi或移动基站的方式获取用户粗略的经纬度信息,定位精度大概误差在30~1500米\",\"id\":2,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"3\":{\"permissionValue\":\"android.permission.ACCESS_FINE_LOCATION\",\"title\":\"获取精确位置\",\"description\":\"通过GPS芯片接收卫星的定位信息,定位精度达10米以内\",\"id\":3,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"4\":{\"permissionValue\":\"android.permission.ACCESS_LOCATION_EXTRA_COMMANDS\",\"title\":\"访问定位额外命令\",\"description\":\"允许程序访问额外的定位提供者指令\",\"id\":4,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"5\":{\"permissionValue\":\"android.permission.ACCESS_MOCK_LOCATION\",\"title\":\"获取模拟定位信息\",\"description\":\"获取模拟定位信息,一般用于帮助开发者调试应用\",\"id\":5,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"6\":{\"permissionValue\":\"android.permission.ACCESS_NETWORK_STATE\",\"title\":\"获取网络状态\",\"description\":\"获取网络信息状态,如当前的网络连接是否有效\",\"id\":6,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"7\":{\"permissionValue\":\"android.permission.ACCESS_SURFACE_FLINGER\",\"title\":\"访问Surface\",\"description\":\"Flinger\",\"id\":7,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"8\":{\"permissionValue\":\"android.permission.ACCESS_WIFI_STATE\",\"title\":\"获取WiFi状态\",\"description\":\"获取当前WiFi接入的状态以及WLAN热点的信息\",\"id\":8,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"9\":{\"permissionValue\":\"android.permission.ACCOUNT_MANAGER\",\"title\":\"账户管理\",\"description\":\"获取账户验证信息,主要为GMail账户信息,只有系统级进程才能访问的权限\",\"id\":9,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"10\":{\"permissionValue\":\"android.permission.AUTHENTICATE_ACCOUNTS\",\"title\":\"验证账户\",\"description\":\"允许一个程序通过账户验证方式访问账户管理ACCOUNT_MANAGER相关信息\",\"id\":10,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"11\":{\"permissionValue\":\"android.permission.BATTERY_STATS\",\"title\":\"电量统计\",\"description\":\"获取电池电量统计信息\",\"id\":11,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"12\":{\"permissionValue\":\"android.permission.BIND_APPWIDGET\",\"title\":\"绑定小插件\",\"description\":\"允许一个程序告诉appWidget服务需要访问小插件的数据库,只有非常少的应用才用到此权限\",\"id\":12,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"13\":{\"permissionValue\":\"android.permission.BIND_DEVICE_ADMIN\",\"title\":\"绑定设备管理\",\"description\":\"请求系统管理员接收者receiver,只有系统才能使用\",\"id\":13,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"14\":{\"permissionValue\":\"android.permission.BIND_INPUT_METHOD\",\"title\":\"绑定输入法\",\"description\":\"请求InputMethodService服务,只有系统才能使用\",\"id\":14,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"15\":{\"permissionValue\":\"android.permission.BIND_REMOTEVIEWS\",\"title\":\"绑定RemoteView\",\"description\":\"必须通过RemoteViewsService服务来请求,只有系统才能用\",\"id\":15,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"16\":{\"permissionValue\":\"android.permission.BIND_WALLPAPER\",\"title\":\"绑定壁纸\",\"description\":\"必须通过WallpaperService服务来请求,只有系统才能用\",\"id\":16,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"17\":{\"permissionValue\":\"android.permission.BLUETOOTH\",\"title\":\"使用蓝牙\",\"description\":\"允许程序连接配对过的蓝牙设备\",\"id\":17,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"18\":{\"permissionValue\":\"android.permission.BLUETOOTH_ADMIN\",\"title\":\"蓝牙管理\",\"description\":\"允许程序进行发现和配对新的蓝牙设备\",\"id\":18,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"19\":{\"permissionValue\":\"android.permission.BRICK\",\"title\":\"变成砖头\",\"description\":\"能够禁用手机,非常危险,顾名思义就是让手机变成砖头\",\"id\":19,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"20\":{\"permissionValue\":\"android.permission.BROADCAST_PACKAGE_REMOVED\",\"title\":\"应用删除时广播\",\"description\":\"当一个应用在删除时触发一个广播\",\"id\":20,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"21\":{\"permissionValue\":\"android.permission.BROADCAST_SMS\",\"title\":\"收到短信时广播\",\"description\":\"当收到短信时触发一个广播\",\"id\":21,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"22\":{\"permissionValue\":\"android.permission.BROADCAST_STICKY\",\"title\":\"连续广播\",\"description\":\"允许一个程序收到广播后快速收到下一个广播\",\"id\":22,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"23\":{\"permissionValue\":\"android.permission.BROADCAST_WAP_PUSH\",\"title\":\"WAP\",\"description\":\"PUSH广播\",\"id\":23,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"24\":{\"permissionValue\":\"android.permission.CALL_PHONE\",\"title\":\"拨打电话\",\"description\":\"允许程序从非系统拨号器里输入电话号码\",\"id\":24,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"25\":{\"permissionValue\":\"android.permission.CALL_PRIVILEGED\",\"title\":\"通话权限\",\"description\":\"允许程序拨打电话,替换系统的拨号器界面\",\"id\":25,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"26\":{\"permissionValue\":\"android.permission.CAMERA\",\"title\":\"拍照权限\",\"description\":\"允许访问摄像头进行拍照\",\"id\":26,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"27\":{\"permissionValue\":\"android.permission.CHANGE_COMPONENT_ENABLED_STATE\",\"title\":\"改变组件状态\",\"description\":\"改变组件是否启用状态\",\"id\":27,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"28\":{\"permissionValue\":\"android.permission.CHANGE_CONFIGURATION\",\"title\":\"改变配置\",\"description\":\"允许当前应用改变配置,如定位\",\"id\":28,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"29\":{\"permissionValue\":\"android.permission.CHANGE_NETWORK_STATE\",\"title\":\"改变网络状态\",\"description\":\"改变网络状态如是否能联网\",\"id\":29,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"30\":{\"permissionValue\":\"android.permission.CHANGE_WIFI_MULTICAST_STATE\",\"title\":\"改变WiFi多播状态\",\"description\":\"改变WiFi多播状态\",\"id\":30,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"31\":{\"permissionValue\":\"android.permission.CHANGE_WIFI_STATE\",\"title\":\"改变WiFi状态\",\"description\":\"改变WiFi状态\",\"id\":31,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"32\":{\"permissionValue\":\"android.permission.CLEAR_APP_CACHE\",\"title\":\"清除应用缓存\",\"description\":\"清除应用缓存\",\"id\":32,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"33\":{\"permissionValue\":\"android.permission.CLEAR_APP_USER_DATA\",\"title\":\"清除用户数据\",\"description\":\"清除应用的用户数据\",\"id\":33,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"34\":{\"permissionValue\":\"android.permission.CWJ_GROUP\",\"title\":\"底层访问权限\",\"description\":\"允许CWJ账户组访问底层信息\",\"id\":34,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"35\":{\"permissionValue\":\"android.permission.CELL_PHONE_MASTER_EX\",\"title\":\"手机优化大师扩展权限\",\"description\":\"手机优化大师扩展权限\",\"id\":35,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"36\":{\"permissionValue\":\"android.permission.CONTROL_LOCATION_UPDATES\",\"title\":\"控制定位更新\",\"description\":\"允许获得移动网络定位信息改变\",\"id\":36,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"37\":{\"permissionValue\":\"android.permission.DELETE_CACHE_FILES\",\"title\":\"删除缓存文件\",\"description\":\"允许应用删除缓存文件\",\"id\":37,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"38\":{\"permissionValue\":\"android.permission.DELETE_PACKAGES\",\"title\":\"删除应用\",\"description\":\"允许程序删除应用\",\"id\":38,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"39\":{\"permissionValue\":\"android.permission.DEVICE_POWER\",\"title\":\"电源管理\",\"description\":\"允许访问底层电源管理\",\"id\":39,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"40\":{\"permissionValue\":\"android.permission.DIAGNOSTIC\",\"title\":\"应用诊断\",\"description\":\"允许程序到RW到诊断资源\",\"id\":40,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"41\":{\"permissionValue\":\"android.permission.DISABLE_KEYGUARD\",\"title\":\"禁用键盘锁\",\"description\":\"允许程序禁用键盘锁\",\"id\":41,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"42\":{\"permissionValue\":\"android.permission.DUMP\",\"title\":\"转存系统信息\",\"description\":\"允许程序获取系统dump信息从系统服务\",\"id\":42,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"43\":{\"permissionValue\":\"android.permission.EXPAND_STATUS_BAR\",\"title\":\"状态栏控制\",\"description\":\"允许程序扩展或收缩状态栏\",\"id\":43,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"44\":{\"permissionValue\":\"android.permission.FACTORY_TEST\",\"title\":\"工厂测试模式\",\"description\":\"允许程序运行工厂测试模式\",\"id\":44,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"45\":{\"permissionValue\":\"android.permission.FLASHLIGHT\",\"title\":\"使用闪光灯\",\"description\":\"允许访问闪光灯\",\"id\":45,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"46\":{\"permissionValue\":\"android.permission.FORCE_BACK\",\"title\":\"强制后退\",\"description\":\"允许程序强制使用back后退按键,无论Activity是否在顶层\",\"id\":46,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"47\":{\"permissionValue\":\"android.permission.GET_ACCOUNTS\",\"title\":\"访问账户Gmail列表\",\"description\":\"访问GMail账户列表\",\"id\":47,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"48\":{\"permissionValue\":\"android.permission.GET_PACKAGE_SIZE\",\"title\":\"获取应用大小\",\"description\":\"获取应用的文件大小\",\"id\":48,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"49\":{\"permissionValue\":\"android.permission.GET_TASKS\",\"title\":\"获取任务信息\",\"description\":\"允许程序获取当前或最近运行的应用\",\"id\":49,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"50\":{\"permissionValue\":\"android.permission.GLOBAL_SEARCH\",\"title\":\"允许全局搜索\",\"description\":\"允许程序使用全局搜索功能\",\"id\":50,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"51\":{\"permissionValue\":\"android.permission.HARDWARE_TEST\",\"title\":\"硬件测试\",\"description\":\"访问硬件辅助设备,用于硬件测试\",\"id\":51,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"52\":{\"permissionValue\":\"android.permission.INJECT_EVENTS\",\"title\":\"注射事件\",\"description\":\"允许访问本程序的底层事件,获取按键、轨迹球的事件流\",\"id\":52,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"53\":{\"permissionValue\":\"android.permission.INSTALL_LOCATION_PROVIDER\",\"title\":\"安装定位提供\",\"description\":\"安装定位提供\",\"id\":53,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"54\":{\"permissionValue\":\"android.permission.INSTALL_PACKAGES\",\"title\":\"安装应用程序\",\"description\":\"允许程序安装应用\",\"id\":54,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"55\":{\"permissionValue\":\"android.permission.INTERNAL_SYSTEM_WINDOW\",\"title\":\"内部系统窗口\",\"description\":\"允许程序打开内部窗口,不对第三方应用程序开放此权限\",\"id\":55,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"56\":{\"permissionValue\":\"android.permission.INTERNET\",\"title\":\"访问网络\",\"description\":\"访问网络连接,可能产生GPRS流量\",\"id\":56,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"57\":{\"permissionValue\":\"android.permission.KILL_BACKGROUND_PROCESSES\",\"title\":\"结束后台进程\",\"description\":\"允许程序调用killBackgroundProcesses(String).方法结束后台进程\",\"id\":57,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"58\":{\"permissionValue\":\"android.permission.MANAGE_ACCOUNTS\",\"title\":\"管理账户\",\"description\":\"允许程序管理AccountManager中的账户列表\",\"id\":58,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"59\":{\"permissionValue\":\"android.permission.MANAGE_APP_TOKENS\",\"title\":\"管理程序引用\",\"description\":\"管理创建、摧毁、Z轴顺序,仅用于系统\",\"id\":59,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"60\":{\"permissionValue\":\"android.permission.MTWEAK_USER\",\"title\":\"高级权限\",\"description\":\"允许mTweak用户访问高级系统权限\",\"id\":60,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"61\":{\"permissionValue\":\"android.permission.MTWEAK_FORUM\",\"title\":\"社区权限\",\"description\":\"允许使用mTweak社区权限\",\"id\":61,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"62\":{\"permissionValue\":\"android.permission.MASTER_CLEAR\",\"title\":\"软格式化\",\"description\":\"允许程序执行软格式化,删除系统配置信息\",\"id\":62,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"63\":{\"permissionValue\":\"android.permission.MODIFY_AUDIO_SETTINGS\",\"title\":\"修改声音设置\",\"description\":\"修改声音设置信息\",\"id\":63,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"64\":{\"permissionValue\":\"android.permission.MODIFY_PHONE_STATE\",\"title\":\"修改电话状态\",\"description\":\"修改电话状态,如飞行模式,但不包含替换系统拨号器界面\",\"id\":64,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"65\":{\"permissionValue\":\"android.permission.MOUNT_FORMAT_FILESYSTEMS\",\"title\":\"格式化文件系统\",\"description\":\"格式化可移动文件系统,比如格式化清空SD卡\",\"id\":65,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"66\":{\"permissionValue\":\"android.permission.MOUNT_UNMOUNT_FILESYSTEMS\",\"title\":\"挂载文件系统\",\"description\":\"挂载、反挂载外部文件系统\",\"id\":66,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"67\":{\"permissionValue\":\"android.permission.NFC\",\"title\":\"允许NFC通讯\",\"description\":\"允许程序执行NFC近距离通讯操作,用于移动支持\",\"id\":67,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"68\":{\"permissionValue\":\"android.permission.PERSISTENT_ACTIVITY\",\"title\":\"永久Activity\",\"description\":\"创建一个永久的Activity,该功能标记为将来将被移除\",\"id\":68,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"69\":{\"permissionValue\":\"android.permission.PROCESS_OUTGOING_CALLS\",\"title\":\"处理拨出电话\",\"description\":\"允许程序监视,修改或放弃播出电话\",\"id\":69,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"70\":{\"permissionValue\":\"android.permission.READ_CALENDAR\",\"title\":\"读取日程提醒\",\"description\":\"允许程序读取用户的日程信息\",\"id\":70,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"71\":{\"permissionValue\":\"android.permission.READ_CONTACTS\",\"title\":\"读取联系人\",\"description\":\"允许应用访问联系人通讯录信息\",\"id\":71,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"72\":{\"permissionValue\":\"android.permission.READ_FRAME_BUFFER\",\"title\":\"屏幕截图\",\"description\":\"读取帧缓存用于屏幕截图\",\"id\":72,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"73\":{\"permissionValue\":\"com.android.browser.permission.READ_HISTORY_BOOKMARKS\",\"title\":\"读取收藏夹和历史记录\",\"description\":\"读取浏览器收藏夹和历史记录\",\"id\":73,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"74\":{\"permissionValue\":\"android.permission.READ_INPUT_STATE\",\"title\":\"读取输入状态\",\"description\":\"读取当前键的输入状态,仅用于系统\",\"id\":74,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"75\":{\"permissionValue\":\"android.permission.READ_LOGS\",\"title\":\"读取系统日志\",\"description\":\"读取系统底层日志\",\"id\":75,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"76\":{\"permissionValue\":\"android.permission.READ_PHONE_STATE\",\"title\":\"读取电话状态\",\"description\":\"访问电话状态\",\"id\":76,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"77\":{\"permissionValue\":\"android.permission.READ_SMS\",\"title\":\"读取短信内容\",\"description\":\"读取短信内容\",\"id\":77,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"78\":{\"permissionValue\":\"android.permission.READ_SYNC_SETTINGS\",\"title\":\"读取同步设置\",\"description\":\"读取同步设置,读取Google在线同步设置\",\"id\":78,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"79\":{\"permissionValue\":\"android.permission.READ_SYNC_STATS\",\"title\":\"读取同步状态\",\"description\":\"读取同步状态,获得Google在线同步状态\",\"id\":79,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"80\":{\"permissionValue\":\"android.permission.REBOOT\",\"title\":\"重启设备\",\"description\":\"允许程序重新启动设备\",\"id\":80,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"81\":{\"permissionValue\":\"android.permission.RECEIVE_BOOT_COMPLETED\",\"title\":\"开机自动允许\",\"description\":\"允许程序开机自动运行\",\"id\":81,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"82\":{\"permissionValue\":\"android.permission.RECEIVE_MMS\",\"title\":\"接收彩信\",\"description\":\"接收彩信\",\"id\":82,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"83\":{\"permissionValue\":\"android.permission.RECEIVE_SMS\",\"title\":\"接收短信\",\"description\":\"接收短信\",\"id\":83,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"84\":{\"permissionValue\":\"android.permission.RECEIVE_WAP_PUSH\",\"title\":\"接收Wap\",\"description\":\"Push\",\"id\":84,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"85\":{\"permissionValue\":\"android.permission.RECORD_AUDIO\",\"title\":\"录音\",\"description\":\"录制声音通过手机或耳机的麦克\",\"id\":85,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"86\":{\"permissionValue\":\"android.permission.REORDER_TASKS\",\"title\":\"排序系统任务\",\"description\":\"重新排序系统Z轴运行中的任务\",\"id\":86,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"87\":{\"permissionValue\":\"android.permission.RESTART_PACKAGES\",\"title\":\"结束系统任务\",\"description\":\"结束任务通过restartPackage(String)方法,该方式将在外来放弃\",\"id\":87,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"88\":{\"permissionValue\":\"android.permission.SEND_SMS\",\"title\":\"发送短信\",\"description\":\"发送短信\",\"id\":88,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"89\":{\"permissionValue\":\"android.permission.SET_ACTIVITY_WATCHER\",\"title\":\"设置Activity观察其\",\"description\":\"设置Activity观察器一般用于monkey测试\",\"id\":89,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"90\":{\"permissionValue\":\"com.android.alarm.permission.SET_ALARM\",\"title\":\"设置闹铃提醒\",\"description\":\"设置闹铃提醒\",\"id\":90,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"91\":{\"permissionValue\":\"android.permission.SET_ALWAYS_FINISH\",\"title\":\"设置总是退出\",\"description\":\"设置程序在后台是否总是退出\",\"id\":91,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"92\":{\"permissionValue\":\"android.permission.SET_ANIMATION_SCALE\",\"title\":\"设置动画缩放\",\"description\":\"设置全局动画缩放\",\"id\":92,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"93\":{\"permissionValue\":\"android.permission.SET_DEBUG_APP\",\"title\":\"设置调试程序\",\"description\":\"设置调试程序,一般用于开发\",\"id\":93,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"94\":{\"permissionValue\":\"android.permission.SET_ORIENTATION\",\"title\":\"设置屏幕方向\",\"description\":\"设置屏幕方向为横屏或标准方式显示,不用于普通应用\",\"id\":94,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"95\":{\"permissionValue\":\"android.permission.SET_PREFERRED_APPLICATIONS\",\"title\":\"设置应用参数\",\"description\":\"设置应用的参数,已不再工作具体查看addPackageToPreferred(String)介绍\",\"id\":95,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"96\":{\"permissionValue\":\"android.permission.SET_PROCESS_LIMIT\",\"title\":\"设置进程限制\",\"description\":\"允许程序设置最大的进程数量的限制\",\"id\":96,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"97\":{\"permissionValue\":\"android.permission.SET_TIME\",\"title\":\"设置系统时间\",\"description\":\"设置系统时间\",\"id\":97,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"98\":{\"permissionValue\":\"android.permission.SET_TIME_ZONE\",\"title\":\"设置系统时区\",\"description\":\"设置系统时区\",\"id\":98,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"99\":{\"permissionValue\":\"android.permission.SET_WALLPAPER\",\"title\":\"设置桌面壁纸\",\"description\":\"设置桌面壁纸\",\"id\":99,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"100\":{\"permissionValue\":\"android.permission.SET_WALLPAPER_HINTS\",\"title\":\"设置壁纸建议\",\"description\":\"设置壁纸建议\",\"id\":100,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"101\":{\"permissionValue\":\"android.permission.SIGNAL_PERSISTENT_PROCESSES\",\"title\":\"发送永久进程信号\",\"description\":\"发送一个永久的进程信号\",\"id\":101,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"102\":{\"permissionValue\":\"android.permission.STATUS_BAR\",\"title\":\"状态栏控制\",\"description\":\"允许程序打开、关闭、禁用状态栏\",\"id\":102,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"103\":{\"permissionValue\":\"android.permission.SUBSCRIBED_FEEDS_READ\",\"title\":\"访问订阅内容\",\"description\":\"访问订阅信息的数据库\",\"id\":103,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"104\":{\"permissionValue\":\"android.permission.SUBSCRIBED_FEEDS_WRITE\",\"title\":\"写入订阅内容\",\"description\":\"写入或修改订阅内容的数据库\",\"id\":104,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"105\":{\"permissionValue\":\"android.permission.SYSTEM_ALERT_WINDOW\",\"title\":\"显示系统窗口\",\"description\":\"显示系统窗口\",\"id\":105,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"106\":{\"permissionValue\":\"android.permission.UPDATE_DEVICE_STATS\",\"title\":\"更新设备状态\",\"description\":\"更新设备状态\",\"id\":106,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"107\":{\"permissionValue\":\"android.permission.USE_CREDENTIALS\",\"title\":\"使用证书\",\"description\":\"允许程序请求验证从AccountManager\",\"id\":107,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"108\":{\"permissionValue\":\"android.permission.USE_SIP\",\"title\":\"使用SIP视频\",\"description\":\"允许程序使用SIP视频服务\",\"id\":108,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"109\":{\"permissionValue\":\"android.permission.VIBRATE\",\"title\":\"使用振动\",\"description\":\"允许振动\",\"id\":109,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"110\":{\"permissionValue\":\"android.permission.WAKE_LOCK\",\"title\":\"唤醒锁定\",\"description\":\"允许程序在手机屏幕关闭后后台进程仍然运行\",\"id\":110,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"111\":{\"permissionValue\":\"android.permission.WRITE_APN_SETTINGS\",\"title\":\"写入GPRS接入点设置\",\"description\":\"写入网络GPRS接入点设置\",\"id\":111,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"112\":{\"permissionValue\":\"android.permission.WRITE_CALENDAR\",\"title\":\"写入日程提醒\",\"description\":\"写入日程,但不可读取\",\"id\":112,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"113\":{\"permissionValue\":\"android.permission.WRITE_CONTACTS\",\"title\":\"写入联系人\",\"description\":\"写入联系人,但不可读取\",\"id\":113,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"114\":{\"permissionValue\":\"android.permission.WRITE_EXTERNAL_STORAGE\",\"title\":\"写入外部存储\",\"description\":\"允许程序写入外部存储,如SD卡上写文件\",\"id\":114,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"115\":{\"permissionValue\":\"android.permission.WRITE_GSERVICES\",\"title\":\"写入Google地图数据\",\"description\":\"允许程序写入Google\",\"id\":115,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"116\":{\"permissionValue\":\"com.android.browser.permission.WRITE_HISTORY_BOOKMARKS\",\"title\":\"写入收藏夹和历史记录\",\"description\":\"写入浏览器历史记录或收藏夹,但不可读取\",\"id\":116,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"117\":{\"permissionValue\":\"android.permission.WRITE_SECURE_SETTINGS\",\"title\":\"读写系统敏感设置\",\"description\":\"允许程序读写系统安全敏感的设置项\",\"id\":117,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"118\":{\"permissionValue\":\"android.permission.WRITE_SETTINGS\",\"title\":\"读写系统设置\",\"description\":\"允许读写系统设置项\",\"id\":118,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"},\"119\":{\"permissionValue\":\"android.permission.WRITE_SMS\",\"title\":\"编写短信\",\"description\":\"允许编写短信\",\"id\":119,\"flag\":0,\"createTime\":\"Aug 31, 2021 3:25:17 PM\",\"updateTime\":\"Aug 31, 2021 3:25:17 PM\",\"receivedTime\":\"Sep 6, 2021 2:00:23 PM\"}}";
            }
        } catch (Throwable th) {
            appa.appa.appf.appd.appb("WMApiAdHelper", "请求失败:" + th.toString());
        }
        return (Map) GsonUtils.getInstance().fromJson(info, new appd());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void appa(String str, int i10, double d10, HasTypeRunnable<Integer> hasTypeRunnable) {
        try {
            String appToken = ConstantInfo.getAppToken();
            String json = GsonUtils.getInstance().toJson(appf.appa(str, i10, d10));
            byte[] encryptByt = AesUtil.encryptByt(GZIPUtils.compress(json, "utf-8"), appToken);
            appa.appa.appf.appd.appa("获取媒体结算价", "【getMediaBidPrice——>request】:url=" + appf.appt, "bean=" + json, Thread.currentThread().getName());
            ((PostRequest) OkHttp.post(appf.appt).headers("Content-Type", "application/json")).upBytes(encryptByt).execute(new appe(hasTypeRunnable));
        } catch (Throwable th) {
            appb(hasTypeRunnable, "getMediaBidPrice e:" + th.toString());
        }
    }
}
