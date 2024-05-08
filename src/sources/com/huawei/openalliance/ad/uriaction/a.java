package com.huawei.openalliance.ad.uriaction;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.kv;
import com.huawei.openalliance.ad.beans.metadata.ApkInfo;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.constant.ae;
import com.huawei.openalliance.ad.constant.u;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.AppInfo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class a extends q {
    private static final String Code = "AppAction";

    public a(Context context, AdContentData adContentData) {
        super(context, adContentData);
    }

    private void Code(Intent intent) {
        String I = com.huawei.openalliance.ad.inter.b.Code().I();
        gl.V(Code, "at is null ? " + TextUtils.isEmpty(I));
        if (TextUtils.isEmpty(I)) {
            return;
        }
        if (!V(intent.getDataString())) {
            gl.V(Code, "isHwPPSUri false.");
        } else if (com.huawei.openalliance.ad.utils.e.Code(this.I)) {
            intent.putExtra(u.cO, I);
        } else {
            gl.V(Code, "isHMSInstalled false.");
        }
    }

    private void Code(Intent intent, String str) {
        if (intent == null || TextUtils.isEmpty(str) || str.indexOf("hwpps") <= 0) {
            return;
        }
        intent.addFlags(268435456);
    }

    private static void Code(final AppInfo appInfo) {
        if (appInfo == null) {
            gl.V(Code, "appInfo is empty.");
        } else {
            com.huawei.openalliance.ad.utils.f.I(new Runnable() { // from class: com.huawei.openalliance.ad.uriaction.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.huawei.openalliance.ad.download.a Code2 = com.huawei.openalliance.ad.download.a.Code();
                    if (Code2 != null) {
                        Code2.Code(AppInfo.this.Code());
                    }
                }
            });
            com.huawei.openalliance.ad.utils.f.I(new Runnable() { // from class: com.huawei.openalliance.ad.uriaction.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.huawei.openalliance.ad.download.a Code2 = com.huawei.openalliance.ad.download.a.Code();
                    if (Code2 != null) {
                        Code2.Code(AppInfo.this);
                    }
                }
            });
        }
    }

    private boolean V(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Uri parse = Uri.parse(str);
            String host = parse.getHost();
            if (TextUtils.equals("hwpps", parse.getScheme())) {
                return TextUtils.equals(u.cQ, host);
            }
            return false;
        } catch (Throwable th) {
            gl.I(Code, "isHwPPSUri exception." + th.getClass().getSimpleName());
            return false;
        }
    }

    private void Z() {
        String str;
        ApkInfo c4;
        try {
            MetaData Z = this.Z.Z();
            boolean z10 = false;
            if (Z != null && (c4 = Z.c()) != null && com.huawei.openalliance.ad.utils.e.V(this.I, c4.Code()) != null) {
                z10 = true;
            }
            kv.Code(this.I, this.Z, ae.D, (Integer) 1, Integer.valueOf(z10 ? 2 : 1));
        } catch (IllegalStateException unused) {
            str = "recordOpenFailEvent IllegalStateException";
            gl.I(Code, str);
        } catch (Exception e2) {
            str = "recordOpenFailEvent " + e2.getClass().getSimpleName();
            gl.I(Code, str);
        }
    }

    @Override // com.huawei.openalliance.ad.uriaction.q
    public boolean Code() {
        String str;
        String i10;
        Intent V;
        gl.V(Code, "handle app action");
        try {
            AppInfo u10 = this.Z.u();
            String Code2 = u10 == null ? null : u10.Code();
            i10 = this.Z.i();
            V = com.huawei.openalliance.ad.utils.e.V(this.I, i10, Code2);
        } catch (ActivityNotFoundException unused) {
            str = "activity not exist";
            gl.I(Code, str);
            Z();
            return V();
        } catch (Exception unused2) {
            str = "handle intent url fail";
            gl.I(Code, str);
            Z();
            return V();
        }
        if (V == null) {
            gl.I(Code, "cannot find target activity");
            Z();
            return V();
        }
        if (!(this.I instanceof Activity)) {
            V.addFlags(268435456);
        }
        Code(V, i10);
        V.setClipData(u.cG);
        Code(V);
        this.I.startActivity(V);
        Code("app");
        Code(this.Z.u());
        kv.Code(this.I, this.Z, "intentSuccess", (Integer) 1, (Integer) null);
        return true;
    }
}
