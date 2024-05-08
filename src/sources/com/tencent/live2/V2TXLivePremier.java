package com.tencent.live2;

import android.content.Context;
import com.tencent.live2.V2TXLiveDef;
import com.tencent.live2.impl.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class V2TXLivePremier {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static abstract class V2TXLivePremierObserver {
        public void onCaptureAudioFrame(V2TXLiveDef.V2TXLiveAudioFrame v2TXLiveAudioFrame) {
        }

        public void onLicenceLoaded(int i10, String str) {
        }

        public void onLog(int i10, String str) {
        }

        public void onPlayoutAudioFrame(V2TXLiveDef.V2TXLiveAudioFrame v2TXLiveAudioFrame) {
        }

        public void onVoiceEarMonitorAudioFrame(V2TXLiveDef.V2TXLiveAudioFrame v2TXLiveAudioFrame) {
        }
    }

    public static int callExperimentalAPI(String str) {
        return a.c(str);
    }

    public static void enableAudioCaptureObserver(boolean z10, V2TXLiveDef.V2TXLiveAudioFrameObserverFormat v2TXLiveAudioFrameObserverFormat) {
        a.a(z10, v2TXLiveAudioFrameObserverFormat);
    }

    public static void enableAudioPlayoutObserver(boolean z10, V2TXLiveDef.V2TXLiveAudioFrameObserverFormat v2TXLiveAudioFrameObserverFormat) {
        a.b(z10, v2TXLiveAudioFrameObserverFormat);
    }

    public static void enableVoiceEarMonitorObserver(boolean z10) {
        a.a(z10);
    }

    public static String getSDKVersionStr() {
        return a.a();
    }

    public static void setEnvironment(String str) {
        a.a(str);
    }

    public static void setLicence(Context context, String str, String str2) {
        a.a(context, str, str2);
    }

    public static void setLogConfig(V2TXLiveDef.V2TXLiveLogConfig v2TXLiveLogConfig) {
        a.a(v2TXLiveLogConfig);
    }

    public static void setObserver(V2TXLivePremierObserver v2TXLivePremierObserver) {
        a.a(v2TXLivePremierObserver);
    }

    public static void setSocks5Proxy(String str, int i10, String str2, String str3, V2TXLiveDef.V2TXLiveSocks5ProxyConfig v2TXLiveSocks5ProxyConfig) {
        a.a(str, i10, str2, str3, v2TXLiveSocks5ProxyConfig);
    }

    public static void setUserId(String str) {
        a.b(str);
    }
}
