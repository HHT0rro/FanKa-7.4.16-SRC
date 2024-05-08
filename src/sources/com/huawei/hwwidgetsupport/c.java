package com.huawei.hwwidgetsupport;

import androidx.annotation.NonNull;
import com.huawei.hwwidgetsupport.api.HwWidgetCreator;
import com.huawei.hwwidgetsupport.api.platforms.base.BaseWidgetService;

/* compiled from: PlatformWidgetService.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class c extends BaseWidgetService {
    @NonNull
    public abstract String a(@NonNull String str);

    @Override // com.huawei.hwwidgetsupport.api.platforms.base.BaseWidgetService
    public void a() {
        super.a();
        try {
            Class<?> cls = Class.forName(b.f31999a);
            Class.forName(a(b.f31999a));
            registerCreator(cls, new d(b()));
        } catch (ClassNotFoundException unused) {
        }
    }

    @NonNull
    public abstract Class<?> b();

    @Override // com.huawei.hwwidgetsupport.api.platforms.base.BaseWidgetService
    @NonNull
    public <T> HwWidgetCreator<T> a(@NonNull Class<T> cls) {
        if (!this.f31990a.containsKey(cls)) {
            String name = cls.getName();
            if (b.e(name)) {
                try {
                    registerCreator(cls, new d(Class.forName(a(name))));
                } catch (ClassNotFoundException unused) {
                }
            }
        }
        return super.a(cls);
    }
}
