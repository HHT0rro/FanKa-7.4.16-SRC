package com.huawei.appgallery.agd.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;
import com.huawei.appgallery.coreservice.api.IConnectionResult;
import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ConnectionResult implements IConnectionResult {

    /* renamed from: a, reason: collision with root package name */
    private IConnectionResult f27298a;

    public ConnectionResult(IConnectionResult iConnectionResult) {
        this.f27298a = iConnectionResult;
    }

    public boolean equals(Object obj) {
        return this.f27298a.equals(obj);
    }

    @Override // com.huawei.appgallery.coreservice.api.IConnectionResult
    public String getErrorMessage() {
        return this.f27298a.getErrorMessage();
    }

    @Override // com.huawei.appgallery.coreservice.api.IConnectionResult
    public PendingIntent getResolution() {
        return this.f27298a.getResolution();
    }

    @Override // com.huawei.appgallery.coreservice.api.IConnectionResult
    public int getStatusCode() {
        return this.f27298a.getStatusCode();
    }

    @Override // com.huawei.appgallery.coreservice.api.IConnectionResult
    public boolean hasResolution() {
        return this.f27298a.hasResolution();
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f27298a.getStatusCode()), this.f27298a.getResolution(), this.f27298a.getErrorMessage()});
    }

    @Override // com.huawei.appgallery.coreservice.api.IConnectionResult
    public void startResolutionForResult(Activity activity, int i10) throws IntentSender.SendIntentException {
        this.f27298a.startResolutionForResult(activity, i10);
    }
}
