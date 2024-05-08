package com.bef.effectsdk;

import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class EffectSDKBuildConfig {
    private static int ENABLE_AUDIO_EFFECT;
    private static int ENABLE_BORINGSSL;
    private static int ENABLE_BYTEBENCH;
    private static int ENABLE_FFMPEG;
    private static int ENABLE_IES_APPLOGGER;
    private static int ENABLE_JAZZ;
    private static int ENABLE_LENS;
    private static int ENABLE_SPEECH_ASR;
    private static int ENABLE_SPEECH_CAPT;
    private static int ENABLE_VC0;

    public static String getAarVersion() {
        return BuildConfig.FULL_VERSION;
    }

    public static List<String> getEffectLibs() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("c++_shared");
        if (ENABLE_BYTEBENCH == 1) {
            arrayList.add("bytebench");
        }
        if (ENABLE_BORINGSSL == 1 || ENABLE_FFMPEG == 1) {
            arrayList.add("ttcrypto");
            arrayList.add("ttboringssl");
        }
        if (ENABLE_FFMPEG == 1) {
            arrayList.add("ttffmpeg");
        }
        if (ENABLE_IES_APPLOGGER == 1) {
            arrayList.add("iesapplogger");
        }
        arrayList.add("bytenn");
        if (ENABLE_AUDIO_EFFECT == 1) {
            arrayList.add("audioeffect");
        }
        if (ENABLE_SPEECH_CAPT == 1 || ENABLE_SPEECH_ASR == 1) {
            arrayList.add("speechsdk");
        }
        arrayList.add("gaia_lib");
        arrayList.add("AGFX");
        if (ENABLE_LENS == 1) {
            arrayList.add("lens");
        }
        if (ENABLE_JAZZ == 1) {
            arrayList.add("napi");
            arrayList.add("quick");
            arrayList.add("jazz");
        }
        if (ENABLE_VC0 == 1) {
            arrayList.add("bytevc0");
        }
        arrayList.add("effect");
        return arrayList;
    }

    public static String getSdkVersion() {
        return BuildConfig.VERSION_NAME;
    }
}
