package com.huawei.openalliance.ad.fadata;

import com.huawei.openalliance.ad.annotations.DataKeep;
import java.util.List;

@DataKeep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class PPSAbilityData {
    private List<PPSAbilityDataContent> abilityDataContent;
    private String displayForm;

    public String Code() {
        return this.displayForm;
    }

    public void Code(String str) {
        this.displayForm = str;
    }

    public void Code(List<PPSAbilityDataContent> list) {
        this.abilityDataContent = list;
    }

    public List<PPSAbilityDataContent> V() {
        return this.abilityDataContent;
    }
}
