package com.huawei.hms.ads;

import com.huawei.openalliance.ad.beans.metadata.Om;
import com.iab.omid.library.huawei.adsession.VerificationScriptResource;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class jd implements ja {
    private static final String Code = "VerficationScriptResourceWrapper";
    private static boolean V = ip.Code(ip.f29321q);
    private List<VerificationScriptResource> I = new ArrayList();

    private URL Code(String str) {
        if (str == null) {
            return null;
        }
        try {
            return new URL(str);
        } catch (MalformedURLException e2) {
            gl.I(Code, "parseURL: " + com.huawei.openalliance.ad.utils.bc.Code(e2.getMessage()));
            return null;
        }
    }

    public static boolean Code() {
        return V;
    }

    public void Code(Om om) {
        if (om == null || !V) {
            gl.V(Code, "om is not avalible");
            return;
        }
        String Code2 = om.Code();
        URL Code3 = Code(om.V());
        String I = om.I();
        if (Code2 == null || Code3 == null || I == null) {
            gl.V(Code, "Parameters is null");
            return;
        }
        VerificationScriptResource createVerificationScriptResourceWithParameters = VerificationScriptResource.createVerificationScriptResourceWithParameters(Code2, Code3, I);
        if (createVerificationScriptResourceWithParameters == null) {
            gl.V(Code, "Create verificationScriptResource failed");
        } else {
            this.I.add(createVerificationScriptResourceWithParameters);
        }
    }

    public List<VerificationScriptResource> V() {
        return this.I;
    }
}
