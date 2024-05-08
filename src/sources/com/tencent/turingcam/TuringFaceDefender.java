package com.tencent.turingcam;

import android.content.Context;
import android.hardware.Camera;
import com.tencent.turingcam.view.TuringPreviewDisplay;
import com.tencent.turingcam.z5VDt;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class TuringFaceDefender {
    public static JSONObject getDeviceInfo(Context context) {
        return d5HOq.a().a(context);
    }

    public static String getSDKVersion() {
        return "2.0.3";
    }

    public static void init(TuringFaceBuilder turingFaceBuilder) {
        z5VDt z5vdt;
        int i10 = z5VDt.f45497j;
        z5vdt = z5VDt.Bi3eT.f45507a;
        z5vdt.a(turingFaceBuilder);
    }

    public static void processFrame(byte[] bArr) {
        z5VDt z5vdt;
        int i10 = z5VDt.f45497j;
        z5vdt = z5VDt.Bi3eT.f45507a;
        z5vdt.a(bArr);
    }

    public static void setCallback(TuringCallback turingCallback) {
        z5VDt z5vdt;
        z5VDt z5vdt2;
        if (turingCallback == null) {
            int i10 = z5VDt.f45497j;
            z5vdt2 = z5VDt.Bi3eT.f45507a;
            z5vdt2.a((z5VDt.B9LVG) null);
        } else {
            int i11 = z5VDt.f45497j;
            z5vdt = z5VDt.Bi3eT.f45507a;
            z5vdt.a(new F2BEC(turingCallback));
        }
    }

    public static void setPreviewDisplay(Camera camera, TuringPreviewDisplay turingPreviewDisplay) {
        z5VDt z5vdt;
        int i10 = z5VDt.f45497j;
        z5vdt = z5VDt.Bi3eT.f45507a;
        z5vdt.a(camera, turingPreviewDisplay);
    }

    public static void start(Camera camera, String str) {
        z5VDt z5vdt;
        int i10 = z5VDt.f45497j;
        z5vdt = z5VDt.Bi3eT.f45507a;
        z5vdt.a(camera, str);
    }

    public static void startFrameCheck(String str) {
        z5VDt z5vdt;
        int i10 = z5VDt.f45497j;
        z5vdt = z5VDt.Bi3eT.f45507a;
        z5vdt.a(str);
    }
}
