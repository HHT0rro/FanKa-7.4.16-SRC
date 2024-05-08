package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class dc implements IOAdEventListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ db f10149a;

    public dc(db dbVar) {
        this.f10149a = dbVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            this.f10149a.c((Map<String, Object>) iOAdEvent.getData());
        }
    }
}
