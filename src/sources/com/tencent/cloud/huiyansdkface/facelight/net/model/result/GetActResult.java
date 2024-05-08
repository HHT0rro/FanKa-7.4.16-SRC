package com.tencent.cloud.huiyansdkface.facelight.net.model.result;

import java.io.Serializable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class GetActResult implements Serializable {
    public String activeType;
    public String bizSeqNo;
    public String code;
    public String colorData;
    public String msg;

    public String toString() {
        return "GetActResult{code='" + this.code + "', msg='" + this.msg + "', bizSeqNo='" + this.bizSeqNo + "', activeType='" + this.activeType + "', colorData='" + this.colorData + "'}";
    }
}
