package com.huawei.hms.feature.dynamic;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.huawei.hms.feature.dynamic.LifecycleDelegate;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class DeferredLifecycleHelper<T extends LifecycleDelegate> {
    public static final int STATUS_ONCREATED = 1;
    public static final int STATUS_ONCREATEVIEW = 2;
    public static final int STATUS_ONINFLATE = 0;
    public static final int STATUS_ONRESUME = 5;
    public static final int STATUS_ONSTART = 4;

    /* renamed from: e, reason: collision with root package name */
    public static final String f29789e = "DeferredLifecycleHelper";

    /* renamed from: a, reason: collision with root package name */
    public T f29790a;

    /* renamed from: b, reason: collision with root package name */
    public Bundle f29791b;

    /* renamed from: c, reason: collision with root package name */
    public LinkedList<g> f29792c;

    /* renamed from: d, reason: collision with root package name */
    public OnDelegateCreatedListener<T> f29793d = new a();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a implements OnDelegateCreatedListener<T> {
        public a() {
        }

        @Override // com.huawei.hms.feature.dynamic.OnDelegateCreatedListener
        public void onDelegateCreated(T t2) {
            DeferredLifecycleHelper.this.f29790a = t2;
            Iterator<E> it = DeferredLifecycleHelper.this.f29792c.iterator2();
            while (it.hasNext()) {
                ((g) it.next()).a(DeferredLifecycleHelper.this.f29790a);
            }
            DeferredLifecycleHelper.this.f29792c.clear();
            DeferredLifecycleHelper.this.f29791b = null;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class b implements g {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f29795a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Bundle f29796b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Bundle f29797c;

        public b(Activity activity, Bundle bundle, Bundle bundle2) {
            this.f29795a = activity;
            this.f29796b = bundle;
            this.f29797c = bundle2;
        }

        @Override // com.huawei.hms.feature.dynamic.DeferredLifecycleHelper.g
        public int a() {
            return 0;
        }

        @Override // com.huawei.hms.feature.dynamic.DeferredLifecycleHelper.g
        public void a(LifecycleDelegate lifecycleDelegate) {
            DeferredLifecycleHelper.this.f29790a.onInflate(this.f29795a, this.f29796b, this.f29797c);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class c implements g {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Bundle f29799a;

        public c(Bundle bundle) {
            this.f29799a = bundle;
        }

        @Override // com.huawei.hms.feature.dynamic.DeferredLifecycleHelper.g
        public int a() {
            return 1;
        }

        @Override // com.huawei.hms.feature.dynamic.DeferredLifecycleHelper.g
        public void a(LifecycleDelegate lifecycleDelegate) {
            String unused = DeferredLifecycleHelper.f29789e;
            lifecycleDelegate.onCreate(this.f29799a);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class d implements g {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FrameLayout f29801a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LayoutInflater f29802b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f29803c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Bundle f29804d;

        public d(FrameLayout frameLayout, LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            this.f29801a = frameLayout;
            this.f29802b = layoutInflater;
            this.f29803c = viewGroup;
            this.f29804d = bundle;
        }

        @Override // com.huawei.hms.feature.dynamic.DeferredLifecycleHelper.g
        public int a() {
            return 2;
        }

        @Override // com.huawei.hms.feature.dynamic.DeferredLifecycleHelper.g
        public void a(LifecycleDelegate lifecycleDelegate) {
            this.f29801a.removeAllViews();
            this.f29801a.addView(DeferredLifecycleHelper.this.f29790a.onCreateView(this.f29802b, this.f29803c, this.f29804d));
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class e implements g {
        public e() {
        }

        @Override // com.huawei.hms.feature.dynamic.DeferredLifecycleHelper.g
        public int a() {
            return 4;
        }

        @Override // com.huawei.hms.feature.dynamic.DeferredLifecycleHelper.g
        public void a(LifecycleDelegate lifecycleDelegate) {
            String unused = DeferredLifecycleHelper.f29789e;
            lifecycleDelegate.onStart();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class f implements g {
        public f() {
        }

        @Override // com.huawei.hms.feature.dynamic.DeferredLifecycleHelper.g
        public int a() {
            return 5;
        }

        @Override // com.huawei.hms.feature.dynamic.DeferredLifecycleHelper.g
        public void a(LifecycleDelegate lifecycleDelegate) {
            String unused = DeferredLifecycleHelper.f29789e;
            lifecycleDelegate.onResume();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface g {
        int a();

        void a(LifecycleDelegate lifecycleDelegate);
    }

    private void a(int i10) {
        while (!this.f29792c.isEmpty() && this.f29792c.getLast().a() >= i10) {
            this.f29792c.removeLast();
        }
    }

    private void a(Bundle bundle, g gVar) {
        T t2 = this.f29790a;
        if (t2 != null) {
            gVar.a(t2);
            return;
        }
        if (this.f29792c == null) {
            this.f29792c = new LinkedList<>();
        }
        this.f29792c.add(gVar);
        if (bundle != null) {
            Bundle bundle2 = this.f29791b;
            if (bundle2 == null) {
                Object clone = bundle.clone();
                if (clone != null && (clone instanceof Bundle)) {
                    this.f29791b = (Bundle) clone;
                }
            } else {
                bundle2.putAll(bundle);
            }
        }
        createDelegate(this.f29793d);
    }

    public abstract void createDelegate(OnDelegateCreatedListener<T> onDelegateCreatedListener);

    public T getDelegate() {
        return this.f29790a;
    }

    public void onCreate(Bundle bundle) {
        a(bundle, new c(bundle));
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FrameLayout frameLayout = new FrameLayout(layoutInflater.getContext());
        a(bundle, new d(frameLayout, layoutInflater, viewGroup, bundle));
        return frameLayout;
    }

    public void onDestroy() {
        T t2 = this.f29790a;
        if (t2 != null) {
            t2.onDestroy();
        } else {
            a(0);
        }
    }

    public void onDestroyView() {
        T t2 = this.f29790a;
        if (t2 != null) {
            t2.onDestroyView();
        } else {
            a(1);
        }
    }

    public void onInflate(Activity activity, Bundle bundle, Bundle bundle2) {
        a(bundle2, new b(activity, bundle, bundle2));
    }

    public void onLowMemory() {
        T t2 = this.f29790a;
        if (t2 != null) {
            t2.onLowMemory();
        }
    }

    public void onPause() {
        T t2 = this.f29790a;
        if (t2 != null) {
            t2.onPause();
        } else {
            a(5);
        }
    }

    public void onResume() {
        a((Bundle) null, new f());
    }

    public void onSaveInstanceState(Bundle bundle) {
        T t2 = this.f29790a;
        if (t2 != null) {
            t2.onSaveInstanceState(bundle);
            return;
        }
        Bundle bundle2 = this.f29791b;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
    }

    public void onStart() {
        a((Bundle) null, new e());
    }

    public void onStop() {
        T t2 = this.f29790a;
        if (t2 != null) {
            t2.onStop();
        } else {
            a(4);
        }
    }
}
