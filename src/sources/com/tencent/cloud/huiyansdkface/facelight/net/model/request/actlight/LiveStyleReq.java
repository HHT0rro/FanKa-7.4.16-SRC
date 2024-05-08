package com.tencent.cloud.huiyansdkface.facelight.net.model.request.actlight;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class LiveStyleReq {
    public String app_id;
    public SelectData select_data;

    public LiveStyleReq(float f10, String str) {
        this.select_data = new SelectData(f10);
        this.app_id = str;
    }
}
