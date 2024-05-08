package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class af implements IOAdEventListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ae f9766a;

    public af(ae aeVar) {
        this.f9766a = aeVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            this.f9766a.c((Map<String, Object>) iOAdEvent.getData());
        }
    }
}
