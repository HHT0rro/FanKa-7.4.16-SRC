package com.zego.zegoliveroom.callback.im;

import com.zego.zegoliveroom.entity.ZegoBigRoomMessage;
import com.zego.zegoliveroom.entity.ZegoRoomMessage;
import com.zego.zegoliveroom.entity.ZegoUserState;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface IZegoIMCallback {
    void onRecvBigRoomMessage(String str, ZegoBigRoomMessage[] zegoBigRoomMessageArr);

    void onRecvRoomMessage(String str, ZegoRoomMessage[] zegoRoomMessageArr);

    void onUpdateOnlineCount(String str, int i10);

    void onUserUpdate(ZegoUserState[] zegoUserStateArr, int i10, String str);
}
