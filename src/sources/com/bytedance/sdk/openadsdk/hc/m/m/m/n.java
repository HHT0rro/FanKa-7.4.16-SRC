package com.bytedance.sdk.openadsdk.hc.m.m.m;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.ej.m.m.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class n implements Bridge {
    private final TTAdNative.NativeExpressAdListener dk;

    /* renamed from: m, reason: collision with root package name */
    private ValueSet f11210m = a.f52238b;

    public n(TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
        this.dk = nativeExpressAdListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        if (this.dk == null) {
            return null;
        }
        switch (i10) {
            case 153101:
                this.dk.onError(valueSet.intValue(0), (String) valueSet.objectValue(1, String.class));
                break;
            case 153102:
                Iterable iterable = (List) valueSet.objectValue(0, List.class);
                if (iterable == null) {
                    iterable = new ArrayList(0);
                }
                ArrayList arrayList = new ArrayList();
                Iterator iterator2 = iterable.iterator2();
                while (iterator2.hasNext()) {
                    arrayList.add(new q((Bridge) iterator2.next()));
                }
                this.dk.onNativeExpressAdLoad(arrayList);
                break;
        }
        m(i10, valueSet, cls);
        return null;
    }

    public void m(int i10, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f11210m;
    }
}
