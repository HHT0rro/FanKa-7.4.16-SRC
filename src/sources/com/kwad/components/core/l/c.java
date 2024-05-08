package com.kwad.components.core.l;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.mvp.a;
import com.kwad.sdk.n.l;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class c<T extends com.kwad.sdk.mvp.a> extends KSFrameLayout {
    public T Mu;
    public ViewGroup lD;
    public Presenter mPresenter;

    public c(Context context) {
        this(context, null);
    }

    private void initMVP() {
        this.Mu = kt();
        if (this.mPresenter == null) {
            Presenter onCreatePresenter = onCreatePresenter();
            this.mPresenter = onCreatePresenter;
            onCreatePresenter.G(this.lD);
        }
        this.mPresenter.k(this.Mu);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void ac() {
        super.ac();
        initMVP();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void ad() {
        super.ad();
        T t2 = this.Mu;
        if (t2 != null) {
            t2.release();
        }
        Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.destroy();
        }
    }

    @LayoutRes
    public abstract int getLayoutId();

    public abstract void initData();

    public boolean kp() {
        return false;
    }

    public abstract void kr();

    public abstract T kt();

    public final void oJ() {
        initData();
        this.lD = (ViewGroup) l.inflate(getContext(), getLayoutId(), this);
        kr();
    }

    @NonNull
    public abstract Presenter onCreatePresenter();

    private c(Context context, AttributeSet attributeSet) {
        this(context, null, 0);
    }

    private c(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, 0);
        if (kp()) {
            return;
        }
        oJ();
    }
}
