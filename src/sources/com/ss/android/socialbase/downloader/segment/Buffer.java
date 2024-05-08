package com.ss.android.socialbase.downloader.segment;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class Buffer {
    public final byte[] data;
    public Buffer next;
    public IOutput output;
    public int size;

    public Buffer(int i10) {
        this.data = new byte[i10];
    }
}
