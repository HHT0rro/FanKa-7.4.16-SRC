package com.alimm.tanx.ui;

import android.app.Application;
import com.alimm.tanx.core.TanxInitListener;
import com.alimm.tanx.core.config.TanxConfig;

/* compiled from: TanxSdk.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class tanxu_do implements TanxInitListener {
    public final /* synthetic */ Application tanxu_do;
    public final /* synthetic */ TanxInitListener tanxu_for;
    public final /* synthetic */ TanxConfig tanxu_if;

    public tanxu_do(Application application, TanxConfig tanxConfig, TanxInitListener tanxInitListener) {
        this.tanxu_do = application;
        this.tanxu_if = tanxConfig;
        this.tanxu_for = tanxInitListener;
    }

    @Override // com.alimm.tanx.core.TanxInitListener
    public void error(int i10, String str) {
        this.tanxu_for.error(i10, str);
    }

    @Override // com.alimm.tanx.core.TanxInitListener
    public void succ() {
        tanxu_if tanxu_ifVar;
        tanxu_ifVar = TanxSdk.mInitializer;
        tanxu_ifVar.tanxu_do(this.tanxu_do, this.tanxu_if);
        TanxSdk.mIsInit.set(true);
        this.tanxu_for.succ();
    }
}
