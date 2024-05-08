package com.huawei.openalliance.ad.beans.metadata.v3;

import com.huawei.openalliance.ad.annotations.DataKeep;
import java.io.Serializable;
import java.util.List;

@DataKeep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class TemplateData implements Serializable {
    private static final long serialVersionUID = 4943303525973528850L;
    private List<MotionData> motionData;
    private String motions;
    private String templateContext;

    public TemplateData() {
    }

    public TemplateData(String str, String str2, List<MotionData> list) {
        this.templateContext = str;
        this.motions = str2;
        this.motionData = list;
    }

    public String Code() {
        return this.templateContext;
    }

    public void Code(String str) {
        this.templateContext = str;
    }

    public void Code(List<MotionData> list) {
        this.motionData = list;
    }

    public List<MotionData> I() {
        return this.motionData;
    }

    public String V() {
        return this.motions;
    }

    public void V(String str) {
        this.motions = str;
    }
}
