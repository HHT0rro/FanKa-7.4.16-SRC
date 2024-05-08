package com.tencent.cloud.huiyansdkface.facelight.net.model.result;

import java.io.Serializable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class CompareResult implements Serializable {
    public String code;
    public String isRecorded;
    public String liveRate;
    public String msg;
    public String retry;
    public RiskInfo riskInfo;
    public String sign;
    public String similarity;

    public String toString() {
        return "CompareResult{code='" + this.code + "', msg='" + this.msg + "', retry='" + this.retry + "', liveRate='" + this.liveRate + "', similarity='" + this.similarity + "', isRecorded=" + this.isRecorded + ", riskInfo=" + ((Object) this.riskInfo) + '}';
    }
}