package com.huawei.hms.ads;

import android.content.Context;
import android.view.View;
import com.huawei.openalliance.ad.beans.metadata.Om;
import com.iab.omid.library.huawei.Omid;
import com.iab.omid.library.huawei.adsession.AdSession;
import com.iab.omid.library.huawei.adsession.AdSessionConfiguration;
import com.iab.omid.library.huawei.adsession.AdSessionContext;
import com.iab.omid.library.huawei.publisher.AdSessionStatePublisher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class id implements il, iz {
    public static final String Code = "1.2.4";
    private static boolean I = ip.Code(ip.f29310f);
    private static final String V = "AdsessionAgent";
    private Context B;
    private final List<AdSession> Z = new ArrayList();

    private static AdSessionStatePublisher Code(AdSession adSession) {
        if (adSession != null) {
            return adSession.getAdSessionStatePublisher();
        }
        return null;
    }

    private void Code(it itVar, jd jdVar) {
        String str;
        if (jdVar == null) {
            str = "init AdSessionContext failed";
        } else {
            if (!iu.Code()) {
                return;
            }
            AdSessionContext Code2 = new iu(this.B).Code(jdVar, null);
            if (Code2 != null) {
                Code(Code2, itVar);
                return;
            }
            str = "adSessionContext is null";
        }
        gl.V(V, str);
    }

    private void Code(AdSessionContext adSessionContext, it itVar) {
        try {
            if (it.Code() && itVar != null) {
                AdSessionConfiguration V2 = itVar.V();
                if (V2 == null) {
                    gl.V(V, "adSessionConfiguration is null");
                    return;
                }
                gl.V(V, "initAdSession");
                AdSession createAdSession = Code(this.B) ? AdSession.createAdSession(V2, adSessionContext) : null;
                if (createAdSession == null) {
                    gl.V(V, "adSession is null");
                    return;
                } else {
                    this.Z.add(createAdSession);
                    return;
                }
            }
            gl.V(V, "init AdSession failed");
        } catch (Throwable unused) {
            gl.I(V, "initAdSession error");
        }
    }

    private void Code(List<Om> list, it itVar) {
        if (!jd.Code()) {
            gl.V(V, "init VerficationScriptResourceWrapper failed");
            return;
        }
        for (Om om : list) {
            gl.V(V, "Init Verfication Script");
            jd jdVar = new jd();
            jdVar.Code(om);
            Code(itVar, jdVar);
        }
    }

    public static boolean Code() {
        return I;
    }

    private static boolean Code(Context context) {
        Omid.activate(context);
        return true;
    }

    private static String V(AdSession adSession) {
        if (adSession != null) {
            return adSession.getAdSessionId();
        }
        return null;
    }

    @Override // com.huawei.hms.ads.iz
    public void B() {
        if (!this.Z.isEmpty()) {
            try {
                Iterator<AdSession> iterator2 = this.Z.iterator2();
                while (iterator2.hasNext()) {
                    iterator2.next().finish();
                    gl.Code(V, " adSession finish");
                }
            } catch (Throwable unused) {
                gl.V(V, "finish, fail");
            }
        }
        this.Z.clear();
    }

    @Override // com.huawei.hms.ads.iz
    public void C() {
        if (this.Z.isEmpty()) {
            return;
        }
        try {
            Iterator<AdSession> iterator2 = this.Z.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().removeAllFriendlyObstructions();
            }
        } catch (Throwable unused) {
            gl.V(V, "removeAllFriendlyObstructions, fail");
        }
    }

    public void Code(Context context, List<Om> list, it itVar) {
        if (!Code() || context == null || list == null) {
            gl.V(V, "not available, not init");
            return;
        }
        if (list.isEmpty() || itVar == null) {
            gl.V(V, "oms is empty or sessionWrapper is null, not init");
            return;
        }
        gl.V(V, "init");
        this.B = context;
        Code(list, itVar);
    }

    @Override // com.huawei.hms.ads.iz
    public void Code(View view) {
        if (this.Z.isEmpty()) {
            return;
        }
        try {
            Iterator<AdSession> iterator2 = this.Z.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().registerAdView(view);
            }
        } catch (Throwable unused) {
            gl.V(V, "registerAdView, fail");
        }
    }

    @Override // com.huawei.hms.ads.iz
    public void Code(View view, iy iyVar, String str) {
        if (this.Z.isEmpty() || iyVar == null || !iy.Code()) {
            return;
        }
        try {
            Iterator<AdSession> iterator2 = this.Z.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().addFriendlyObstruction(view, iy.Code(iyVar), str);
            }
        } catch (Throwable unused) {
            gl.V(V, "addFriendlyObstruction-f, fail");
        }
    }

    @Override // com.huawei.hms.ads.iz
    public void Code(ix ixVar, String str) {
        if (this.Z.isEmpty() || ixVar == null || !ix.Code()) {
            return;
        }
        try {
            Iterator<AdSession> iterator2 = this.Z.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().error(ix.Code(ixVar), str);
            }
        } catch (Throwable unused) {
            gl.V(V, "error, fail");
        }
    }

    @Override // com.huawei.hms.ads.iz
    public String F() {
        if (this.Z.isEmpty()) {
            return null;
        }
        return V(this.Z.get(0));
    }

    public Context I() {
        return this.B;
    }

    @Override // com.huawei.hms.ads.iz
    public void I(View view) {
        if (this.Z.isEmpty()) {
            return;
        }
        try {
            Iterator<AdSession> iterator2 = this.Z.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().removeFriendlyObstruction(view);
            }
        } catch (Throwable unused) {
            gl.V(V, "addFriendlyObstruction, fail");
        }
    }

    @Override // com.huawei.hms.ads.iz
    public iv S() {
        if (this.Z.isEmpty() || !iv.Code()) {
            return null;
        }
        return new iv(Code(this.Z.get(0)));
    }

    public List<AdSession> V() {
        return this.Z;
    }

    @Override // com.huawei.hms.ads.iz
    public void V(View view) {
    }

    @Override // com.huawei.hms.ads.iz
    public void Z() {
        if (this.Z.isEmpty()) {
            return;
        }
        try {
            for (AdSession adSession : this.Z) {
                gl.Code(V, "adsession start");
                adSession.start();
            }
        } catch (Throwable unused) {
            gl.V(V, "start, fail");
        }
    }
}
