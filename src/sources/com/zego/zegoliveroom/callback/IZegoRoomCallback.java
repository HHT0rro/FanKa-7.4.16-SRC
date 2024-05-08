package com.zego.zegoliveroom.callback;

import com.zego.zegoliveroom.entity.ZegoRoomInfo;
import com.zego.zegoliveroom.entity.ZegoStreamInfo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface IZegoRoomCallback {
    void onDisconnect(int i10, String str);

    void onFatalError(int i10);

    void onKickOut(int i10, String str, String str2);

    void onNetworkQuality(String str, int i10, int i11);

    void onReconnect(int i10, String str);

    void onRecvCustomCommand(String str, String str2, String str3, String str4);

    void onRoomInfoUpdated(ZegoRoomInfo zegoRoomInfo, String str);

    void onStreamExtraInfoUpdated(ZegoStreamInfo[] zegoStreamInfoArr, String str);

    void onStreamUpdated(int i10, ZegoStreamInfo[] zegoStreamInfoArr, String str);

    void onTempBroken(int i10, String str);

    void onTokenWillExpired(String str, int i10);
}
