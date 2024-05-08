package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class cz implements IOAdEventListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ cy f10135a;

    public cz(cy cyVar) {
        this.f10135a = cyVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        bg.a(new da(this, iOAdEvent));
    }
}
