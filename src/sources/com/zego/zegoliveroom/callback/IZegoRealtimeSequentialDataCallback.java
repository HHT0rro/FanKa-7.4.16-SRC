package com.zego.zegoliveroom.callback;

import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface IZegoRealtimeSequentialDataCallback {
    void onRecvRealtimeSequentialData(ByteBuffer byteBuffer, String str);

    void onSendRealtimeSequentialData(int i10, int i11);
}
