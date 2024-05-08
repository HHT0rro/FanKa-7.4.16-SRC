package com.zego.zegoliveroom;

import com.zego.zegoliveroom.entity.ZegoRoomExtraInfo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class ZegoLiveRoomExtraInfoJNI {
    private static volatile IJniZegoRoomExtraInfoCallback sJNIZegoRoomExtraInfoCallback;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface IJniZegoRoomExtraInfoCallback {
        void onRoomExtraInfoUpdated(String str, ZegoRoomExtraInfo[] zegoRoomExtraInfoArr);

        void onSetRoomExtraInfo(int i10, String str, int i11, String str2);
    }

    public static native void enableRoomExtraInfoCallback(boolean z10);

    public static native void logPrint(String str);

    public static void onRoomExtraInfoUpdated(String str, ZegoRoomExtraInfo[] zegoRoomExtraInfoArr) {
        IJniZegoRoomExtraInfoCallback iJniZegoRoomExtraInfoCallback = sJNIZegoRoomExtraInfoCallback;
        if (iJniZegoRoomExtraInfoCallback != null) {
            iJniZegoRoomExtraInfoCallback.onRoomExtraInfoUpdated(str, zegoRoomExtraInfoArr);
        }
    }

    public static void onSetRoomExtraInfo(int i10, String str, int i11, String str2) {
        IJniZegoRoomExtraInfoCallback iJniZegoRoomExtraInfoCallback = sJNIZegoRoomExtraInfoCallback;
        if (iJniZegoRoomExtraInfoCallback != null) {
            iJniZegoRoomExtraInfoCallback.onSetRoomExtraInfo(i10, str, i11, str2);
        }
    }

    public static native int setRoomExtraInfo(String str, String str2, String str3);

    public static void setRoomExtraInfoJNICallback(IJniZegoRoomExtraInfoCallback iJniZegoRoomExtraInfoCallback) {
        sJNIZegoRoomExtraInfoCallback = iJniZegoRoomExtraInfoCallback;
        enableRoomExtraInfoCallback(iJniZegoRoomExtraInfoCallback != null);
    }
}
