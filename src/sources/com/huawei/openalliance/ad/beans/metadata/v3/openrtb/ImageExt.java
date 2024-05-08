package com.huawei.openalliance.ad.beans.metadata.v3.openrtb;

import com.huawei.openalliance.ad.annotations.DataKeep;
import java.io.Serializable;

@DataKeep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ImageExt implements Serializable {
    private static final long serialVersionUID = 9185694573603472901L;
    private int checkSHA256Flag;
    private String format;
    private String sha256;
    private long size;

    public long Code() {
        return this.size;
    }

    public void Code(int i10) {
        this.checkSHA256Flag = i10;
    }

    public void Code(long j10) {
        this.size = j10;
    }

    public void Code(String str) {
        this.sha256 = str;
    }

    public String I() {
        return this.format;
    }

    public String V() {
        return this.sha256;
    }

    public void V(String str) {
        this.format = str;
    }

    public int Z() {
        return this.checkSHA256Flag;
    }
}
