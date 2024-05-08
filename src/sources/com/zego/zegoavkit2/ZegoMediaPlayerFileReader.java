package com.zego.zegoavkit2;

import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface ZegoMediaPlayerFileReader {
    void close(int i10);

    long getSize(int i10);

    int open(String str, int i10);

    ByteBuffer read(int i10, int i11);

    long seek(long j10, int i10, int i11);
}
