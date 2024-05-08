package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ct implements IOAdEventListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ cs f10121a;

    public ct(cs csVar) {
        this.f10121a = csVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            this.f10121a.c((Map<String, Object>) iOAdEvent.getData());
        }
    }
}
