package com.alibaba.security.realidentity.build;

import android.text.TextUtils;
import android.util.Pair;
import com.alibaba.security.common.utils.CommonUtils;
import com.alibaba.security.common.utils.PackageUtils;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.middletier.ISensorComponent;
import com.huawei.flexiblelayout.card.FLPNode;
import java.util.HashMap;

/* compiled from: RPSecurityGuardManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class gx extends gw {

    /* renamed from: g, reason: collision with root package name */
    private boolean f3790g;

    public gx(gy gyVar) {
        super(gyVar);
    }

    private boolean d(String str) {
        if (!PackageUtils.checkV1Sign(this.f3785c)) {
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            this.f3790g = false;
            return false;
        }
        try {
            ISensorComponent iSensorComponent = (ISensorComponent) SecurityGuardManager.getInstance(this.f3785c).getInterface(ISensorComponent.class);
            if (iSensorComponent == null) {
                c("initSgSensorConfig gSensorComponent is null");
                return false;
            }
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(FLPNode.KEY_CONFIG, str);
            iSensorComponent.init(hashMap);
            this.f3790g = true;
            return true;
        } catch (Throwable th) {
            a("initSgSensorConfig getSgSensorComponent fail", th);
            if (th instanceof SecException) {
                this.f3790g = th.getErrorCode() == 2803;
            } else {
                this.f3790g = false;
            }
            return false;
        }
    }

    private boolean m() {
        if (!PackageUtils.checkV1Sign(this.f3785c) || !this.f3790g) {
            return false;
        }
        try {
            ISensorComponent iSensorComponent = (ISensorComponent) SecurityGuardManager.getInstance(this.f3785c).getInterface(ISensorComponent.class);
            if (iSensorComponent == null) {
                c("sensorStart gSensorComponent is null");
                return false;
            }
            HashMap<String, Object> process = iSensorComponent.process(1);
            if (process.isEmpty()) {
                c("sensorStart empty result");
                return false;
            }
            boolean booleanValue = ((Boolean) process.get("processResult")).booleanValue();
            if (!booleanValue) {
                c("sensorStart processResult false");
            }
            return booleanValue;
        } catch (Throwable th) {
            a("sensorStart getSgSensorComponent fail", th);
            return false;
        }
    }

    private boolean n() {
        if (!PackageUtils.checkV1Sign(this.f3785c) || !this.f3790g) {
            return false;
        }
        try {
            ISensorComponent iSensorComponent = (ISensorComponent) SecurityGuardManager.getInstance(this.f3785c).getInterface(ISensorComponent.class);
            if (iSensorComponent == null) {
                c("sensorStop gSensorComponent is null");
                return false;
            }
            HashMap<String, Object> process = iSensorComponent.process(2);
            if (process.isEmpty()) {
                c("sensorStop empty result");
                return false;
            }
            boolean booleanValue = ((Boolean) process.get("processResult")).booleanValue();
            if (!booleanValue) {
                c("sensorStop processResult false");
            }
            return booleanValue;
        } catch (Throwable th) {
            a("sensorStop getSgSensorComponent fail", th);
            return false;
        }
    }

    private boolean o() {
        if (!PackageUtils.checkV1Sign(this.f3785c) || !this.f3790g) {
            return false;
        }
        try {
            ISensorComponent iSensorComponent = (ISensorComponent) SecurityGuardManager.getInstance(this.f3785c).getInterface(ISensorComponent.class);
            if (iSensorComponent == null) {
                c("sensorReset gSensorComponent is null");
                return false;
            }
            HashMap<String, Object> process = iSensorComponent.process(4);
            if (process.isEmpty()) {
                c("sensorReset empty result");
                return false;
            }
            boolean booleanValue = ((Boolean) process.get("processResult")).booleanValue();
            if (!booleanValue) {
                c("sensorReset processResult false");
            }
            return booleanValue;
        } catch (Throwable th) {
            a("sensorReset getSgSensorComponent fail", th);
            return false;
        }
    }

    private String p() {
        if (!PackageUtils.checkV1Sign(this.f3785c) || !this.f3790g) {
            return null;
        }
        try {
            ISensorComponent iSensorComponent = (ISensorComponent) SecurityGuardManager.getInstance(this.f3785c).getInterface(ISensorComponent.class);
            if (iSensorComponent == null) {
                c("sensorGet gSensorComponent is null");
                return null;
            }
            HashMap<String, Object> process = iSensorComponent.process(3);
            if (process.isEmpty()) {
                c("sensorGet empty result");
                return null;
            }
            return (String) process.get("data");
        } catch (Throwable th) {
            a("sensorGet getSgSensorComponent fail", th);
            return null;
        }
    }

    private static void q() {
    }

    private static void r() {
    }

    private static void s() {
    }

    @Override // com.alibaba.security.realidentity.build.gw
    public final boolean a() {
        return PackageUtils.checkV1Sign(this.f3785c);
    }

    @Override // com.alibaba.security.realidentity.build.gw
    public final byte[] a(byte[] bArr) {
        return bArr;
    }

    @Override // com.alibaba.security.realidentity.build.gw
    public final String k() {
        return "146f";
    }

    public final Pair<Boolean, String> l() {
        String str = "请检查 SecurityBodySDK-**.aar and SecurityGuardSDK-**.aar 是否是SDK里最新版本";
        if (!PackageUtils.checkV1Sign(this.f3785c)) {
            return new Pair<>(Boolean.FALSE, "v1 signature not exist");
        }
        if (!hh.a(this.f3785c, "146f")) {
            return new Pair<>(Boolean.FALSE, "请检查 yw_1222_146f.jpg 是否在 res/drawble 目录下");
        }
        try {
            if (((ISensorComponent) SecurityGuardManager.getInstance(this.f3785c).getInterface(ISensorComponent.class)) == null) {
                return new Pair<>(Boolean.FALSE, "请检查 SecurityBodySDK-**.aar and SecurityGuardSDK-**.aar 是否是SDK里最新版本");
            }
            e();
            return new Pair<>(Boolean.TRUE, "");
        } catch (Throwable th) {
            if (th instanceof SecException) {
                Boolean bool = Boolean.FALSE;
                int errorCode = th.getErrorCode();
                if (errorCode != 113) {
                    if (errorCode == 212) {
                        str = "请检查当前集成的安全图片是否是 SDK 里新下载的图片";
                    } else if (errorCode == 214) {
                        str = "图片和应用平台不匹配，Android和iOS的图片不要混用";
                    } else if (errorCode != 202) {
                        str = errorCode != 203 ? "前置检测失败，错误码为： ".concat(String.valueOf(errorCode)) : "没有找到安全图片文件，请确保图片文件在res/drawable目录下。安卓环境下可能是因为资源优化被优化成了0，请检查APK中的图片";
                    } else {
                        str = "图片文件有问题。一般是获取图片文件时的apk签名和当前程序的apk签名不一致。请使用当前程序的apk重新生成图片。确认获取安全图片的签名和当前正在运行的签名一致";
                    }
                }
                return new Pair<>(bool, str);
            }
            return new Pair<>(Boolean.FALSE, CommonUtils.getStackTrace(th));
        }
    }

    private static String a(int i10) {
        return i10 != 113 ? i10 != 212 ? i10 != 214 ? i10 != 202 ? i10 != 203 ? "前置检测失败，错误码为： ".concat(String.valueOf(i10)) : "没有找到安全图片文件，请确保图片文件在res/drawable目录下。安卓环境下可能是因为资源优化被优化成了0，请检查APK中的图片" : "图片文件有问题。一般是获取图片文件时的apk签名和当前程序的apk签名不一致。请使用当前程序的apk重新生成图片。确认获取安全图片的签名和当前正在运行的签名一致" : "图片和应用平台不匹配，Android和iOS的图片不要混用" : "请检查当前集成的安全图片是否是 SDK 里新下载的图片" : "请检查 SecurityBodySDK-**.aar and SecurityGuardSDK-**.aar 是否是SDK里最新版本";
    }
}
