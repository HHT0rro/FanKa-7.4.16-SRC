package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class dd implements IOAdEventListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ db f10150a;

    public dd(db dbVar) {
        this.f10150a = dbVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            this.f10150a.z();
        }
    }
}
