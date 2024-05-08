package com.huawei.quickcard;

import androidx.annotation.NonNull;
import com.huawei.quickcard.framework.IVirtualViewParent;
import com.huawei.quickcard.watcher.IVirtualViewWatchCallback;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class z1 implements IVirtualViewWatchCallback {

    /* renamed from: a, reason: collision with root package name */
    private final IVirtualViewParent f34759a;

    public z1(@NonNull IVirtualViewParent iVirtualViewParent) {
        this.f34759a = iVirtualViewParent;
    }

    @Override // com.huawei.quickcard.watcher.IVirtualViewWatchCallback
    public void onUpdate(String str, String str2, String str3, Object obj) {
        this.f34759a.updateChildren(str, str2, str3, obj);
    }
}
