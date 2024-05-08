package com.huawei.openalliance.ad.inter.data;

import com.huawei.openalliance.ad.annotations.DataKeep;
import com.huawei.openalliance.ad.utils.au;
import java.io.Serializable;

@DataKeep
@com.huawei.openalliance.ad.annotations.b
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class RewardItem implements Serializable {
    private static final long serialVersionUID = 30424300;
    public int amount;
    public String type;

    public RewardItem(String str, int i10) {
        this.type = au.V(str);
        this.amount = i10;
    }

    @com.huawei.openalliance.ad.annotations.b
    public String Code() {
        return this.type;
    }

    public void Code(int i10) {
        this.amount = i10;
    }

    public void Code(String str) {
        this.type = str;
    }

    @com.huawei.openalliance.ad.annotations.b
    public int V() {
        return this.amount;
    }
}
