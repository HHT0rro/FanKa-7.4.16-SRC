package com.huawei.flexiblelayout;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.huawei.flexiblelayout.d0;
import com.huawei.flexiblelayout.log.Log;
import java.util.ArrayList;
import java.util.List;

/* compiled from: UniversalBrotherSelector.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class i0 implements f0 {

    /* renamed from: a, reason: collision with root package name */
    private static final String f28148a = "UBSelector";

    /* renamed from: b, reason: collision with root package name */
    public static final String f28149b = "~";

    /* compiled from: UniversalBrotherSelector.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final i0 f28150a = new i0();

        private b() {
        }
    }

    public static i0 a() {
        return b.f28150a;
    }

    private i0() {
    }

    @Override // com.huawei.flexiblelayout.f0
    public List<d0> a(View view, String str) {
        if (view != null && str != null) {
            ViewParent parent = view.getParent();
            if (!(parent instanceof ViewGroup)) {
                Log.w(f28148a, "viewParent = " + ((Object) parent));
                return null;
            }
            ArrayList arrayList = new ArrayList();
            ViewGroup viewGroup = (ViewGroup) parent;
            for (int childCount = viewGroup.getChildCount() - 1; childCount > 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt == view) {
                    break;
                }
                if (str.equals(com.huawei.flexiblelayout.css.e.a(childAt))) {
                    arrayList.add(new d0.b(childAt).a());
                }
            }
            return arrayList;
        }
        Log.w(f28148a, "startView = " + ((Object) view) + ", selectParam = " + str);
        return null;
    }
}
