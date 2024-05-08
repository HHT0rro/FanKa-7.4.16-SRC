package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class ez {
    public Context Code;
    private ez I;
    private a V;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface a {
        void Code(com.huawei.openalliance.ad.inter.data.AppInfo appInfo);

        void V(com.huawei.openalliance.ad.inter.data.AppInfo appInfo);
    }

    public ez(Context context) {
        this.Code = context;
    }

    public Context Code() {
        return this.Code;
    }

    public void Code(a aVar) {
        this.V = aVar;
    }

    public void Code(ez ezVar) {
        this.I = ezVar;
    }

    public void Code(com.huawei.openalliance.ad.inter.data.AppInfo appInfo) {
        a aVar = this.V;
        if (aVar != null) {
            aVar.Code(appInfo);
        }
    }

    public abstract void Code(com.huawei.openalliance.ad.inter.data.AppInfo appInfo, AdContentData adContentData, long j10);

    public void V(com.huawei.openalliance.ad.inter.data.AppInfo appInfo) {
        a aVar = this.V;
        if (aVar != null) {
            aVar.V(appInfo);
        }
    }

    public void V(com.huawei.openalliance.ad.inter.data.AppInfo appInfo, AdContentData adContentData, long j10) {
        ez ezVar = this.I;
        if (ezVar == null) {
            V(appInfo);
        } else {
            ezVar.Code(this.V);
            this.I.Code(appInfo, adContentData, j10);
        }
    }
}
