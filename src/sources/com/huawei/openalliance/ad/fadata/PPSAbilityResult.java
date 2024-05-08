package com.huawei.openalliance.ad.fadata;

import com.huawei.openalliance.ad.annotations.DataKeep;
import java.util.ArrayList;

@DataKeep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class PPSAbilityResult {
    private ArrayList<PPSAbilityData> abilityDatas;
    private String intentSn;

    public String Code() {
        return this.intentSn;
    }

    public void Code(String str) {
        this.intentSn = str;
    }

    public void Code(ArrayList<PPSAbilityData> arrayList) {
        this.abilityDatas = arrayList;
    }

    public ArrayList<PPSAbilityData> V() {
        return this.abilityDatas;
    }
}
