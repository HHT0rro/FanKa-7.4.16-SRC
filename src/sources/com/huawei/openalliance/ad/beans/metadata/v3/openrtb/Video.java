package com.huawei.openalliance.ad.beans.metadata.v3.openrtb;

import com.huawei.openalliance.ad.annotations.DataKeep;
import com.huawei.openalliance.ad.annotations.c;
import java.io.Serializable;

@DataKeep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class Video implements Serializable {
    private static final long serialVersionUID = -9078513959338975690L;
    private int checkSHA256Flag;
    private long duration;
    private String format;

    @c(Code = "H")
    private int height;
    private String localPath;
    private String sha256;
    private long size;
    private String url;

    @c(Code = "W")
    private int width;

    public long B() {
        return this.size;
    }

    public String C() {
        return this.sha256;
    }

    public String Code() {
        return this.url;
    }

    public void Code(int i10) {
        this.width = i10;
    }

    public void Code(long j10) {
        this.duration = j10;
    }

    public void Code(String str) {
        this.url = str;
    }

    public String D() {
        return this.localPath;
    }

    public int F() {
        return this.checkSHA256Flag;
    }

    public int I() {
        return this.height;
    }

    public void I(int i10) {
        this.checkSHA256Flag = i10;
    }

    public void I(String str) {
        this.format = str;
    }

    public String S() {
        return this.format;
    }

    public int V() {
        return this.width;
    }

    public void V(int i10) {
        this.height = i10;
    }

    public void V(long j10) {
        this.size = j10;
    }

    public void V(String str) {
        this.sha256 = str;
    }

    public long Z() {
        return this.duration;
    }

    public void Z(String str) {
        this.localPath = str;
    }
}
