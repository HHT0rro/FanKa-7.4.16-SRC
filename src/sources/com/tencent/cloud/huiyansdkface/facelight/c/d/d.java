package com.tencent.cloud.huiyansdkface.facelight.c.d;

import android.content.Context;
import android.hardware.Camera;
import android.view.View;
import com.tencent.cloud.huiyansdkface.a.g.a;
import com.tencent.cloud.huiyansdkface.facelight.c.a.e;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import com.tencent.cloud.huiyansdkface.wejson.WeJson;
import com.tencent.turingcam.TuringFaceBuilder;
import com.tencent.turingcam.TuringFaceDefender;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static final c f40674a = new c() { // from class: com.tencent.cloud.huiyansdkface.facelight.c.d.d.1
        @Override // com.tencent.cloud.huiyansdkface.facelight.c.d.c
        public View a(Context context) {
            return null;
        }

        @Override // com.tencent.cloud.huiyansdkface.facelight.c.d.c
        public e a() {
            WLogger.d("WbDeviceRiskProviders", "get null turing cameraPreview,use system");
            return null;
        }

        @Override // com.tencent.cloud.huiyansdkface.facelight.c.d.c
        public void a(Camera camera) {
        }

        @Override // com.tencent.cloud.huiyansdkface.facelight.c.d.c
        public void a(Camera camera, String str) {
        }

        @Override // com.tencent.cloud.huiyansdkface.facelight.c.d.c
        public void a(a.InterfaceC0616a interfaceC0616a) {
        }

        @Override // com.tencent.cloud.huiyansdkface.facelight.c.d.c
        public void a(byte[] bArr) {
        }

        @Override // com.tencent.cloud.huiyansdkface.facelight.c.d.c
        public boolean b() {
            return false;
        }

        @Override // com.tencent.cloud.huiyansdkface.facelight.c.d.c
        public void c() {
        }
    };

    /* renamed from: b, reason: collision with root package name */
    private static boolean f40675b = true;

    public static c a() {
        return f40675b ? new a() : f40674a;
    }

    public static void a(Context context) {
        if (!f40675b) {
            WLogger.d("WbDeviceRiskProviders", "get null turing sdk");
            return;
        }
        TuringFaceBuilder build = TuringFaceBuilder.build();
        build.setContext(context);
        TuringFaceDefender.init(build);
    }

    public static String b() {
        return f40675b ? TuringFaceDefender.getSDKVersion() : "empty turing face";
    }

    public static String b(Context context) {
        if (!f40675b) {
            WLogger.d("WbDeviceRiskProviders", "get null turing sdk");
            return "";
        }
        JSONObject deviceInfo = TuringFaceDefender.getDeviceInfo(context);
        WLogger.d("WbDeviceRiskProviders", "di:" + deviceInfo.toString());
        try {
            b bVar = (b) new WeJson().fromJsonObj(deviceInfo, b.class);
            return bVar != null ? bVar.toString() : "";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }
}
