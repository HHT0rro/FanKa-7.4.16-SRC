package com.huawei.openalliance.ad.inter.data;

import android.text.TextUtils;
import com.huawei.openalliance.ad.beans.metadata.ImageInfo;
import com.huawei.openalliance.ad.constant.bq;
import java.io.Serializable;

@com.huawei.openalliance.ad.annotations.b
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class k implements Serializable {
    private static final long Code = 30414300;
    private int B;
    private int C;
    private String D;
    private boolean F;
    private String I;
    private String S;
    private String V;
    private int Z;

    @com.huawei.openalliance.ad.annotations.b
    public k() {
        this.Z = 0;
        this.B = 0;
    }

    public k(ImageInfo imageInfo) {
        this.Z = 0;
        this.B = 0;
        if (imageInfo != null) {
            this.V = imageInfo.I();
            String I = imageInfo.I();
            this.I = I;
            if (!TextUtils.isEmpty(I) && !this.I.startsWith(bq.HTTP.toString()) && !this.I.startsWith(bq.HTTPS.toString())) {
                this.I = imageInfo.F();
            }
            this.Z = imageInfo.Z();
            this.B = imageInfo.B();
            this.S = imageInfo.Code();
            this.D = imageInfo.V();
            this.C = imageInfo.C();
            this.F = imageInfo.S() == 0;
        }
    }

    @com.huawei.openalliance.ad.annotations.b
    public int B() {
        return this.B;
    }

    @com.huawei.openalliance.ad.annotations.b
    public int C() {
        return this.Z;
    }

    public void Code(String str) {
        this.I = str;
    }

    public boolean Code() {
        String str = this.V;
        return str != null && str.startsWith(bq.CONTENT.toString());
    }

    @com.huawei.openalliance.ad.annotations.b
    public String D() {
        return this.I;
    }

    @com.huawei.openalliance.ad.annotations.b
    public int F() {
        return this.C;
    }

    @com.huawei.openalliance.ad.annotations.b
    public String I() {
        return this.S;
    }

    @com.huawei.openalliance.ad.annotations.b
    public boolean S() {
        return this.F;
    }

    @com.huawei.openalliance.ad.annotations.b
    public String V() {
        return this.D;
    }

    @com.huawei.openalliance.ad.annotations.b
    public String Z() {
        return this.V;
    }
}
