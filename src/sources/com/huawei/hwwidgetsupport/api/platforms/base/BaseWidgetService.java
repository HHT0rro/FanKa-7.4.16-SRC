package com.huawei.hwwidgetsupport.api.platforms.base;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.hwwidgetsupport.api.HwWidgetCreator;
import com.huawei.hwwidgetsupport.api.HwWidgetService;
import com.huawei.hwwidgetsupport.b;
import com.huawei.hwwidgetsupport.d;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class BaseWidgetService implements HwWidgetService {

    /* renamed from: a, reason: collision with root package name */
    public final Map<Class<?>, HwWidgetCreator<?>> f31990a = new HashMap();

    public BaseWidgetService() {
        a();
    }

    public void a() {
        try {
            registerCreator(Class.forName(b.f31999a), new d(BaseViewPager.class));
        } catch (ClassNotFoundException unused) {
        }
    }

    @Override // com.huawei.hwwidgetsupport.api.HwWidgetService
    @NonNull
    public <T> T createWidget(@NonNull Class<T> cls, @NonNull Context context) {
        return a(cls).createWidget(context);
    }

    @Override // com.huawei.hwwidgetsupport.api.HwWidgetService
    public <T> void registerCreator(@NonNull Class<T> cls, @NonNull HwWidgetCreator<? extends T> hwWidgetCreator) {
        this.f31990a.put(cls, hwWidgetCreator);
    }

    @Override // com.huawei.hwwidgetsupport.api.HwWidgetService
    @NonNull
    public <T> T createWidget(@NonNull Class<T> cls, @NonNull Context context, @Nullable AttributeSet attributeSet) {
        return a(cls).createWidget(context, attributeSet);
    }

    @NonNull
    public <T> HwWidgetCreator<T> a(@NonNull Class<T> cls) {
        HwWidgetCreator<T> hwWidgetCreator = (HwWidgetCreator) this.f31990a.get(cls);
        if (hwWidgetCreator != null) {
            return hwWidgetCreator;
        }
        d dVar = new d(cls);
        this.f31990a.put(cls, dVar);
        return dVar;
    }

    @Override // com.huawei.hwwidgetsupport.api.HwWidgetService
    @NonNull
    public <T> T createWidget(@NonNull Class<T> cls, @NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        return a(cls).createWidget(context, attributeSet, i10);
    }

    @Override // com.huawei.hwwidgetsupport.api.HwWidgetService
    @NonNull
    public <T> T createWidget(@NonNull Class<T> cls, @NonNull Context context, @Nullable AttributeSet attributeSet, int i10, int i11) {
        return a(cls).createWidget(context, attributeSet, i10, i11);
    }
}
