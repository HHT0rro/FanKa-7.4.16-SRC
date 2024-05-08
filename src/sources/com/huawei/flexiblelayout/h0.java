package com.huawei.flexiblelayout;

import android.view.View;
import android.view.ViewGroup;
import com.huawei.flexiblelayout.d0;
import com.huawei.flexiblelayout.log.Log;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DescendantSelector.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class h0 implements f0 {

    /* renamed from: a, reason: collision with root package name */
    private static final String f28143a = "DescendantSelector";

    /* renamed from: b, reason: collision with root package name */
    public static final String f28144b = " ";

    /* compiled from: DescendantSelector.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final h0 f28145a = new h0();

        private b() {
        }
    }

    public static h0 a() {
        return b.f28145a;
    }

    private h0() {
    }

    @Override // com.huawei.flexiblelayout.f0
    public List<d0> a(View view, String str) {
        if (view != null && str != null) {
            ArrayList arrayList = new ArrayList();
            a(view, arrayList, str);
            return arrayList;
        }
        Log.w(f28143a, "startView = " + ((Object) view) + ", selectParam = " + str);
        return null;
    }

    private void a(View view, List<d0> list, String str) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = viewGroup.getChildAt(i10);
                if (str.equals(com.huawei.flexiblelayout.css.e.a(childAt))) {
                    list.add(new d0.b(childAt).a());
                }
                a(childAt, list, str);
            }
        }
    }
}
