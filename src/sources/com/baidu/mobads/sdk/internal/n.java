package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class n implements IOAdEventListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f10277a;

    public n(m mVar) {
        this.f10277a = mVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        bg.a(new o(this, iOAdEvent));
    }
}
