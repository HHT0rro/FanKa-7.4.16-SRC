package com.huawei.openalliance.ad.inter.data;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class m {
    private Integer Code;
    private String I;
    private Integer V;

    public m() {
    }

    public m(Integer num, Integer num2, String str) {
        this.Code = num;
        this.V = num2;
        this.I = str;
    }

    public Integer Code() {
        return this.Code;
    }

    public String I() {
        return this.I;
    }

    public Integer V() {
        return this.V;
    }

    public String toString() {
        return "MaterialClickInfo{clickX=" + ((Object) this.Code) + ", clickY=" + ((Object) this.V) + ", creativeSize='" + this.I + "'}";
    }
}
