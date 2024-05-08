package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.beans.metadata.Om;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ie {
    private static final String Code = "AdSessionAgentFactory";

    public static iz Code(Context context, AdContentData adContentData, hy hyVar, boolean z10) {
        it Code2;
        if (adContentData == null || context == null) {
            return new ih();
        }
        if (z10 && (hyVar == null || hyVar.getOpenMeasureView() == null)) {
            gl.V(Code, "MeasureView is null");
            return new ih();
        }
        if (!id.Code()) {
            return new ih();
        }
        gl.Code(Code, "AdSessionAgent is avalible");
        id idVar = new id();
        List<Om> ae2 = adContentData.ae();
        if (ae2 == null) {
            gl.V(Code, "Oms is null");
            return idVar;
        }
        if (adContentData.p() != null || (adContentData.q() != null && com.huawei.openalliance.ad.constant.bb.Code.equals(adContentData.q().Code()))) {
            gl.V(Code, "Video adsession");
            iw iwVar = iw.VIDEO;
            jb jbVar = jb.VIEWABLE;
            jc jcVar = jc.NATIVE;
            Code2 = it.Code(iwVar, jbVar, jcVar, jcVar, false);
        } else {
            Code2 = it.Code(iw.NATIVE_DISPLAY, jb.VIEWABLE, jc.NATIVE, jc.NONE, false);
        }
        if (Code2 == null) {
            return idVar;
        }
        gl.V(Code, "init adSessionAgent");
        idVar.Code(context, ae2, Code2);
        if (z10) {
            idVar.Code(hyVar.getOpenMeasureView());
        }
        return idVar;
    }
}
