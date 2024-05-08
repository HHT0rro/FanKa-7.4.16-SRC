package com.huawei.hms.ads;

import android.content.Context;
import android.os.Bundle;
import com.huawei.hms.ads.ku;
import com.huawei.openalliance.ad.constant.bg;
import com.huawei.openalliance.ad.inter.HiAd;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ky {
    private static final String Code = "TemplateActionProcessor";
    private static ky I;
    private static final byte[] V = new byte[0];
    private String B = null;
    private String C = null;
    private Context Z;

    private ky(Context context) {
        this.Z = context.getApplicationContext();
    }

    public static ky Code(Context context) {
        return V(context);
    }

    private static ky V(Context context) {
        ky kyVar;
        synchronized (V) {
            if (I == null) {
                I = new ky(context);
            }
            kyVar = I;
        }
        return kyVar;
    }

    public void Code(AdContentData adContentData) {
        gl.V(Code, "onPrepare");
        if (HiAd.getInstance(this.Z).getExtensionActionListener() == null || adContentData == null) {
            return;
        }
        HiAd.getInstance(this.Z).getExtensionActionListener().Code(adContentData.T());
    }

    public void Code(AdContentData adContentData, int i10) {
        if (HiAd.getInstance(this.Z).getExtensionActionListener() == null || adContentData == null) {
            return;
        }
        String str = this.C;
        if (str == null || !str.equals(adContentData.T())) {
            gl.V(Code, "onFail");
            this.C = adContentData.T();
            HiAd.getInstance(this.Z).getExtensionActionListener().Code(adContentData.T(), i10);
        }
    }

    public void Code(AdContentData adContentData, Bundle bundle) {
        gl.V(Code, "onEnd");
        kv.Code(this.Z, adContentData, com.huawei.openalliance.ad.constant.ae.L, Long.valueOf(bundle.getLong("startTime")), Long.valueOf(bundle.getLong(bg.e.f32291h)), Integer.valueOf(bundle.getInt(bg.e.f32292i)), Integer.valueOf(bundle.getInt(bg.e.f32293j)));
        V(adContentData);
    }

    public void Code(AdContentData adContentData, String str) {
        gl.V(Code, "onShow");
        ku.a aVar = new ku.a();
        aVar.Code(str);
        kv.Code(this.Z, adContentData, aVar.Code(), com.huawei.openalliance.ad.constant.ae.f32215b);
        if (HiAd.getInstance(this.Z).getExtensionActionListener() == null || adContentData == null) {
            return;
        }
        HiAd.getInstance(this.Z).getExtensionActionListener().I(adContentData.T());
    }

    public boolean Code(Context context, AdContentData adContentData, Bundle bundle, String str) {
        gl.V(Code, "onClick");
        try {
            int i10 = bundle.getInt(bg.e.f32288e);
            int i11 = bundle.getInt(bg.e.f32289f);
            int i12 = bundle.getInt("clickSource");
            com.huawei.openalliance.ad.uriaction.q Code2 = com.huawei.openalliance.ad.uriaction.r.Code(context, adContentData, new HashMap(0));
            if (Code2.Code()) {
                kv.Code(this.Z, adContentData, i10, i11, Code2.I(), i12, (com.huawei.openalliance.ad.inter.data.m) null, str, (int[]) null);
                if (HiAd.getInstance(this.Z).getExtensionActionListener() != null && adContentData != null) {
                    HiAd.getInstance(this.Z).getExtensionActionListener().Z(adContentData.T());
                }
                return true;
            }
        } catch (Throwable th) {
            gl.V(Code, "deal with click err: %s", th.getClass().getSimpleName());
        }
        return false;
    }

    public void I(AdContentData adContentData, Bundle bundle) {
        int i10;
        try {
            i10 = bundle.getInt(bg.e.f32296m);
        } catch (Throwable th) {
            gl.V(Code, "get errCode err: %s", th.getClass().getSimpleName());
            i10 = -1;
        }
        Code(adContentData, i10);
    }

    public void V(AdContentData adContentData) {
        if (HiAd.getInstance(this.Z).getExtensionActionListener() == null || adContentData == null) {
            if (adContentData != null || HiAd.getInstance(this.Z).getExtensionActionListener() == null) {
                return;
            }
            HiAd.getInstance(this.Z).getExtensionActionListener().V(null);
            return;
        }
        String str = this.B;
        if (str == null || !str.equals(adContentData.T())) {
            gl.V(Code, "onDismiss");
            this.B = adContentData.T();
            HiAd.getInstance(this.Z).getExtensionActionListener().V(adContentData.T());
        }
    }

    public void V(AdContentData adContentData, Bundle bundle) {
        gl.V(Code, "onClose");
        kv.Code(this.Z, adContentData, bundle.getInt(bg.e.f32288e), bundle.getInt(bg.e.f32289f), com.huawei.openalliance.ad.constant.ae.f32214a);
        V(adContentData);
    }
}
