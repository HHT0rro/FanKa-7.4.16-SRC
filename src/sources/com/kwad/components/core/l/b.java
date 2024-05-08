package com.kwad.components.core.l;

import androidx.annotation.CallSuper;
import com.kwad.components.core.l.a;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.service.ServiceProvider;
import java.util.Iterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class b<T extends a> extends com.kwad.components.core.proxy.c {
    public T mCallerContext;
    public Presenter mPresenter;

    private void notifyOnCreate() {
        T t2 = this.mCallerContext;
        if (t2 == null) {
            return;
        }
        Iterator<com.kwad.components.core.l.a.a> iterator2 = t2.Ms.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().fP();
        }
    }

    private void notifyOnDestroy() {
        T t2 = this.mCallerContext;
        if (t2 == null) {
            return;
        }
        Iterator<com.kwad.components.core.l.a.a> iterator2 = t2.Ms.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().fQ();
        }
    }

    private void notifyOnPause() {
        T t2 = this.mCallerContext;
        if (t2 == null) {
            return;
        }
        Iterator<com.kwad.components.core.l.a.a> iterator2 = t2.Ms.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().d(this);
        }
    }

    private void notifyOnResume() {
        T t2 = this.mCallerContext;
        if (t2 == null) {
            return;
        }
        Iterator<com.kwad.components.core.l.a.a> iterator2 = t2.Ms.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().c(this);
        }
    }

    public void initMVP() {
        this.mCallerContext = onCreateCallerContext();
        if (this.mPresenter == null) {
            Presenter onCreatePresenter = onCreatePresenter();
            this.mPresenter = onCreatePresenter;
            onCreatePresenter.G(this.mRootView);
        }
        this.mPresenter.k(this.mCallerContext);
    }

    @Override // com.kwad.components.core.proxy.c
    @CallSuper
    public void onActivityCreate() {
        try {
            super.onActivityCreate();
            initMVP();
            notifyOnCreate();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public abstract T onCreateCallerContext();

    public abstract Presenter onCreatePresenter();

    @Override // com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    @CallSuper
    public void onDestroy() {
        try {
            super.onDestroy();
            notifyOnDestroy();
            T t2 = this.mCallerContext;
            if (t2 != null) {
                t2.release();
            }
            Presenter presenter = this.mPresenter;
            if (presenter != null) {
                presenter.destroy();
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    @CallSuper
    public void onPause() {
        try {
            super.onPause();
            notifyOnPause();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    @CallSuper
    public void onResume() {
        try {
            super.onResume();
            notifyOnResume();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
