package com.huawei.openalliance.ad.beans.metadata;

import com.huawei.openalliance.ad.annotations.DataKeep;
import java.util.List;

@DataKeep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ImpEXs {
    private List<ImpEX> impEXs;

    public ImpEXs() {
    }

    public ImpEXs(List<ImpEX> list) {
        this.impEXs = list;
    }

    public List<ImpEX> Code() {
        return this.impEXs;
    }

    public void Code(List<ImpEX> list) {
        this.impEXs = list;
    }
}
