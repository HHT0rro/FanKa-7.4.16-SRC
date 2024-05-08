package com.tencent.cloud.huiyansdkface.facelight.provider;

import com.tencent.cloud.huiyansdkface.facelight.process.d;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class WbFaceModeProviders {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f40873a;

    /* renamed from: b, reason: collision with root package name */
    private static WbFaceModeInterface f40874b;

    /* renamed from: c, reason: collision with root package name */
    private static WbFaceModeInterface f40875c = new WbFaceLiveImpl();

    static {
        try {
            Class.forName("com.tencent.cloud.huiyansdkface.wbwillexpressionsdk.WbFaceWillImpl");
            f40873a = true;
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
            f40873a = false;
        }
    }

    public static WbFaceModeInterface faceMode() {
        if (!d.z().x().T() || !f40873a) {
            return f40875c;
        }
        try {
            WbFaceModeInterface wbFaceModeInterface = f40874b;
            if (wbFaceModeInterface != null) {
                return wbFaceModeInterface;
            }
            WbFaceModeInterface wbFaceModeInterface2 = (WbFaceModeInterface) Class.forName("com.tencent.cloud.huiyansdkface.wbwillexpressionsdk.WbFaceWillImpl").getConstructor(WbFaceModeInterface.class).newInstance(f40875c);
            f40874b = wbFaceModeInterface2;
            return wbFaceModeInterface2;
        } catch (Exception e2) {
            e2.printStackTrace();
            throw new RuntimeException("can't load WbWillExpressionHelper!");
        }
    }

    public static boolean isUseWillSdk() {
        boolean z10 = d.z().x().T() && f40873a;
        WLogger.d("WbFaceModeProviders", "hasWbIntentionSdk:" + f40873a + ";isUseWillSdk =" + z10);
        return z10;
    }
}
