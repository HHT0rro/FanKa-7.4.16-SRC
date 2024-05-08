package com.huawei.flexiblelayout.css.action.impl.focus.within;

import android.view.View;
import com.huawei.flexiblelayout.common.d;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FocusWithInExcutor.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f27981a = "_focus_within_tag_";

    /* compiled from: FocusWithInExcutor.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final a f27982a = new a();

        private b() {
        }
    }

    public static a a() {
        return b.f27982a;
    }

    private com.huawei.flexiblelayout.css.action.impl.focus.within.b d(View view) {
        if (view == null) {
            return null;
        }
        return (com.huawei.flexiblelayout.css.action.impl.focus.within.b) d.a(view, f27981a, com.huawei.flexiblelayout.css.action.impl.focus.within.b.class);
    }

    public FocusWithInAction b(View view) {
        com.huawei.flexiblelayout.css.action.impl.focus.within.b d10 = d(view);
        if (d10 == null) {
            return null;
        }
        return d10.b();
    }

    public void c(View view) {
        com.huawei.flexiblelayout.css.action.impl.focus.within.b d10 = d(view);
        if (d10 != null) {
            d10.c();
        }
    }

    private a() {
    }

    public void a(View view, FocusWithInAction focusWithInAction) {
        if (view != null && d(view) == null) {
            d.a(view, f27981a, new com.huawei.flexiblelayout.css.action.impl.focus.within.b(view, focusWithInAction));
        }
    }

    public void a(View view) {
        com.huawei.flexiblelayout.css.action.impl.focus.within.b d10 = d(view);
        if (d10 != null) {
            d10.a();
        }
    }
}
