package com.huawei.openalliance.ad.beans.metadata.v3.openrtb;

import com.huawei.openalliance.ad.annotations.DataKeep;
import java.io.Serializable;

@DataKeep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class Data implements Serializable {
    private static final long serialVersionUID = 4120218934780835998L;
    private int len;
    private int type;
    private String value;

    public int Code() {
        return this.type;
    }

    public void Code(int i10) {
        this.type = i10;
    }

    public void Code(String str) {
        this.value = str;
    }

    public int I() {
        return this.len;
    }

    public String V() {
        return this.value;
    }

    public void V(int i10) {
        this.len = i10;
    }
}
