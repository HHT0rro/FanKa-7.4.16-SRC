package com.huawei.flexiblelayout.css.action.impl.focus.within;

import android.view.View;
import com.huawei.flexiblelayout.log.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FocusWithInView.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class b {

    /* renamed from: d, reason: collision with root package name */
    private static final String f27983d = "FocusWithInView";

    /* renamed from: a, reason: collision with root package name */
    private View f27984a;

    /* renamed from: b, reason: collision with root package name */
    private FocusWithInAction f27985b;

    /* renamed from: c, reason: collision with root package name */
    private a f27986c = a.INIT;

    /* compiled from: FocusWithInView.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public enum a {
        INIT,
        RENDERED
    }

    public b(View view, FocusWithInAction focusWithInAction) {
        this.f27984a = view;
        this.f27985b = focusWithInAction;
    }

    private boolean d() {
        return this.f27986c == a.RENDERED;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        if (this.f27984a.findFocus() == null) {
            this.f27985b.b();
            this.f27986c = a.INIT;
        }
    }

    public void a() {
        FocusWithInAction focusWithInAction;
        if (d()) {
            return;
        }
        if (this.f27984a != null && (focusWithInAction = this.f27985b) != null) {
            focusWithInAction.a();
            this.f27986c = a.RENDERED;
            return;
        }
        Log.w(f27983d, "doAction, mView = " + ((Object) this.f27984a) + ", action = " + ((Object) this.f27985b));
    }

    public FocusWithInAction b() {
        return this.f27985b;
    }

    public void c() {
        if (d()) {
            View view = this.f27984a;
            if (view != null && this.f27985b != null) {
                view.post(new Runnable() { // from class: com.huawei.flexiblelayout.css.action.impl.focus.within.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.this.e();
                    }
                });
                return;
            }
            Log.w(f27983d, "reset, mView = " + ((Object) this.f27984a) + ", action = " + ((Object) this.f27985b));
        }
    }
}
