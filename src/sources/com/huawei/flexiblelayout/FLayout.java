package com.huawei.flexiblelayout;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.flexiblelayout.adapter.AdapterBuilder;
import com.huawei.flexiblelayout.common.Lazy;
import com.huawei.flexiblelayout.data.FLDataSource;
import com.huawei.flexiblelayout.data.changed.FLDataChangedRequest;
import com.huawei.flexiblelayout.script.IScriptService;
import com.huawei.flexiblelayout.script.ScriptServiceManager;
import com.huawei.flexiblelayout.services.ServiceTokenProvider;
import com.huawei.flexiblelayout.view.InternalViewGroupLayout;
import com.huawei.flexiblelayout.view.LayoutView;
import com.huawei.flexiblelayout.view.RecyclerViewLayout;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class FLayout implements LifecycleOwner, ServiceTokenProvider {

    /* renamed from: a, reason: collision with root package name */
    private final FLEngine f27700a;

    /* renamed from: b, reason: collision with root package name */
    private FLayoutDelegate f27701b;

    /* renamed from: c, reason: collision with root package name */
    private FLDataSource f27702c;

    /* renamed from: d, reason: collision with root package name */
    private LayoutView f27703d;

    /* renamed from: e, reason: collision with root package name */
    private Lazy<IScriptService> f27704e;

    /* renamed from: f, reason: collision with root package name */
    private Object f27705f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f27706g;

    /* renamed from: h, reason: collision with root package name */
    private final LifecycleRegistry f27707h;

    /* renamed from: i, reason: collision with root package name */
    private com.huawei.flexiblelayout.services.a f27708i;

    public FLayout(FLEngine fLEngine) {
        this(fLEngine, null);
    }

    public static LayoutView recyclerView(RecyclerView recyclerView, AdapterBuilder adapterBuilder) {
        return new RecyclerViewLayout(recyclerView, adapterBuilder);
    }

    public static LayoutView viewGroup(ViewGroup viewGroup) {
        return new InternalViewGroupLayout(viewGroup);
    }

    public IScriptService a() {
        Lazy<IScriptService> lazy = this.f27704e;
        if (lazy != null) {
            return lazy.get();
        }
        return ScriptServiceManager.getInstance().createService(this.f27703d.getView().getContext());
    }

    public void bind(RecyclerView recyclerView) {
        bind(recyclerView(recyclerView, null));
    }

    public final FLayout createChildFLayout() {
        FLayout fLayout = new FLayout(this.f27700a, this.f27704e);
        fLayout.enableAutoManage(this);
        fLayout.a(new com.huawei.flexiblelayout.services.a(getServiceToken(), String.valueOf(fLayout.hashCode())));
        return fLayout;
    }

    public void destroy() {
        this.f27706g = true;
        unbind();
        setDataSource(null);
        this.f27701b = null;
        this.f27704e = null;
        this.f27705f = null;
        this.f27707h.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    }

    public void enableAutoManage(LifecycleOwner lifecycleOwner) {
        if (lifecycleOwner != null) {
            lifecycleOwner.getLifecycle().addObserver(new LifecycleObserver() { // from class: com.huawei.flexiblelayout.FLayout.1
                @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                public void onDestroy(LifecycleOwner lifecycleOwner2) {
                    if (lifecycleOwner2 != null) {
                        lifecycleOwner2.getLifecycle().removeObserver(this);
                    }
                    FLayout.this.destroy();
                }
            });
        }
    }

    public FLDataSource getDataSource() {
        return this.f27702c;
    }

    public FLEngine getEngine() {
        return this.f27700a;
    }

    public FLayoutDelegate getLayoutDelegate() {
        return this.f27701b;
    }

    public LayoutView getLayoutView() {
        return this.f27703d;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NonNull
    public Lifecycle getLifecycle() {
        return this.f27707h;
    }

    public LayoutView.ScrollDirection getScrollDirection() {
        LayoutView layoutView = this.f27703d;
        if (layoutView != null) {
            return layoutView.getScrollDirection();
        }
        return LayoutView.ScrollDirection.VERTICAL;
    }

    @Override // com.huawei.flexiblelayout.services.ServiceTokenProvider
    public com.huawei.flexiblelayout.services.a getServiceToken() {
        if (this.f27708i == null) {
            this.f27708i = new com.huawei.flexiblelayout.services.a(null, String.valueOf(hashCode()));
        }
        return this.f27708i;
    }

    public Object getTag() {
        return this.f27705f;
    }

    public View getView() {
        LayoutView layoutView = this.f27703d;
        if (layoutView != null) {
            return layoutView.getView();
        }
        return null;
    }

    public boolean isDestroyed() {
        return this.f27706g;
    }

    public void registerLayoutDelegate(FLayoutDelegate fLayoutDelegate) {
        this.f27701b = fLayoutDelegate;
    }

    public void requestDataChanged(FLDataChangedRequest fLDataChangedRequest) {
        LayoutView layoutView = this.f27703d;
        if (layoutView != null) {
            layoutView.requestDataChanged(fLDataChangedRequest);
        }
    }

    public void setDataSource(FLDataSource fLDataSource) {
        boolean z10;
        FLDataSource fLDataSource2 = this.f27702c;
        if (fLDataSource2 != null) {
            fLDataSource2.bindLayout(null);
            z10 = true;
        } else {
            z10 = false;
        }
        this.f27702c = fLDataSource;
        if (fLDataSource != null) {
            fLDataSource.bindLayout(this);
        }
        LayoutView layoutView = this.f27703d;
        if (layoutView != null) {
            if (z10) {
                layoutView.onDataSourceChanged();
            } else {
                layoutView.mount(this);
            }
        }
    }

    public void setTag(Object obj) {
        this.f27705f = obj;
    }

    public void unbind() {
        LayoutView layoutView = this.f27703d;
        if (layoutView != null) {
            layoutView.mount(null);
            this.f27703d = null;
        }
    }

    public FLayout(FLEngine fLEngine, Lazy<IScriptService> lazy) {
        this.f27706g = false;
        LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);
        this.f27707h = lifecycleRegistry;
        this.f27700a = fLEngine;
        this.f27704e = lazy;
        lifecycleRegistry.markState(Lifecycle.State.CREATED);
    }

    public void bind(LayoutView layoutView) {
        this.f27703d = layoutView;
        layoutView.mount(this);
    }

    private void a(com.huawei.flexiblelayout.services.a aVar) {
        this.f27708i = aVar;
    }
}
