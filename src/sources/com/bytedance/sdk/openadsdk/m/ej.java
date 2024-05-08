package com.bytedance.sdk.openadsdk.m;

import android.app.Application;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.m.m;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ej implements Bridge {

    /* renamed from: m, reason: collision with root package name */
    private static volatile ej f11224m;
    private dk dk;
    private m ej = new m();

    private ej() {
    }

    public static ej m() {
        if (f11224m == null) {
            synchronized (ej.class) {
                if (f11224m == null) {
                    f11224m = new ej();
                }
            }
        }
        return f11224m;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        Bridge m10;
        switch (i10) {
            case 2:
                return (T) this.ej.m();
            case 3:
                return (T) TTAppContextHolder.getContext();
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                dk dkVar = this.dk;
                if (dkVar == null || (m10 = dkVar.m(4)) == null) {
                    return null;
                }
                return (T) m10.call(i10, valueSet, cls);
            case 9:
                Object objectValue = valueSet.objectValue(0, Object.class);
                if (objectValue instanceof EventListener) {
                    m((EventListener) objectValue);
                }
                return null;
            case 10:
                dk dkVar2 = this.dk;
                if (dkVar2 == null) {
                    return null;
                }
                return (T) dkVar2.m(valueSet.intValue(0));
            default:
                return null;
        }
    }

    public Application.ActivityLifecycleCallbacks dk() {
        return this.ej;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return a.b().f(10000, 5).a();
    }

    public void m(dk dkVar) {
        this.dk = dkVar;
    }

    private void m(final EventListener eventListener) {
        this.ej.m(new m.InterfaceC0131m() { // from class: com.bytedance.sdk.openadsdk.m.ej.1
            @Override // com.bytedance.sdk.openadsdk.m.m.InterfaceC0131m
            public void dk() {
                eventListener.onEvent(1, null);
            }

            @Override // com.bytedance.sdk.openadsdk.m.m.InterfaceC0131m
            public void m() {
                eventListener.onEvent(0, null);
            }
        });
    }
}
