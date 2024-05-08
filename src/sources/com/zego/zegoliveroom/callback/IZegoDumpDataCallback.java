package com.zego.zegoliveroom.callback;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface IZegoDumpDataCallback {
    void onRequestDumpData();

    void onRequestUploadDumpData(String str, boolean z10);

    void onStartDumpData(int i10);

    void onStopDumpData(int i10, String str);

    void onUploadDumpData(int i10);
}
