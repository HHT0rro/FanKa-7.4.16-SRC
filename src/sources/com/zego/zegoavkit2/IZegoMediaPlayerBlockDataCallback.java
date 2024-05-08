package com.zego.zegoavkit2;

import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface IZegoMediaPlayerBlockDataCallback {
    void OnBlockBegin(String str, int i10);

    int OnBlockData(ByteBuffer byteBuffer, int i10);
}
