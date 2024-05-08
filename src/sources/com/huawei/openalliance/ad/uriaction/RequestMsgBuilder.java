package com.huawei.openalliance.ad.uriaction;

import com.huawei.hag.abilitykit.entities.CallerInfo;
import com.huawei.openalliance.ad.annotations.DataKeep;
import com.huawei.openalliance.ad.constant.u;
import com.huawei.openalliance.ad.fadata.PPSAbilityData;
import com.huawei.openalliance.ad.fadata.PPSAbilityDataContent;
import com.huawei.openalliance.ad.fadata.PPSAbilityResult;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@DataKeep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class RequestMsgBuilder {
    private static final String FA_VERSION = "2.0";
    private List<PPSAbilityResult> abilityInfos;
    private CallerInfo callerInfo;
    private String version;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a {
        private static String Code;
        private static List<PPSAbilityResult> I = new ArrayList(1);
        private static String V;

        public a Code(PPSAbilityDataContent pPSAbilityDataContent) {
            PPSAbilityData pPSAbilityData = new PPSAbilityData();
            pPSAbilityData.Code(u.cC);
            pPSAbilityData.Code(new ArrayList(Arrays.asList(pPSAbilityDataContent)));
            PPSAbilityResult pPSAbilityResult = new PPSAbilityResult();
            pPSAbilityResult.Code("1");
            pPSAbilityResult.Code(new ArrayList<>(Arrays.asList(pPSAbilityData)));
            I.add(0, pPSAbilityResult);
            return this;
        }

        public a Code(String str) {
            Code = str;
            return this;
        }

        public RequestMsgBuilder Code() {
            return new RequestMsgBuilder(this);
        }

        public a V(String str) {
            V = str;
            return this;
        }
    }

    private RequestMsgBuilder(a aVar) {
        CallerInfo callerInfo = new CallerInfo();
        this.version = "2.0";
        callerInfo.setPackageName(a.Code);
        callerInfo.setBusinessPkgName(a.V);
        this.callerInfo = callerInfo;
        this.abilityInfos = a.I;
    }
}
