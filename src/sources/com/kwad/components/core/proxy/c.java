package com.kwad.components.core.proxy;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import com.kwad.components.core.s.l;
import com.kwad.sdk.api.proxy.IActivityProxy;
import com.kwad.sdk.k;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class c extends IActivityProxy implements com.kwad.components.core.proxy.a.c {
    private static final String FRAGMENTS_TAG = "android:fragments";
    public static final String KEY_START_TIME = "key_start_time";
    public Context mContext;
    private boolean mHasCallFinish;
    public View mRootView;
    private final com.kwad.components.core.proxy.a.a mPageMonitor = new com.kwad.components.core.proxy.a.a(this);
    private final com.kwad.sdk.m.a.a mBackPressDelete = new com.kwad.sdk.m.a.a();

    private void disableFragmentRestore(Bundle bundle) {
        if (bundle == null || !k.zd().yp()) {
            return;
        }
        bundle.remove(FRAGMENTS_TAG);
    }

    public void addBackPressable(com.kwad.sdk.m.a.b bVar) {
        this.mBackPressDelete.addBackPressable(bVar);
    }

    public boolean checkIntentData(@Nullable Intent intent) {
        return true;
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    @CallSuper
    public <T extends View> T findViewById(int i10) {
        T t2 = (T) this.mRootView.findViewById(i10);
        return t2 != null ? t2 : (T) super.findViewById(i10);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    @CallSuper
    public void finish() {
        if (this.mHasCallFinish) {
            return;
        }
        this.mHasCallFinish = true;
        super.finish();
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    @CallSuper
    public Intent getIntent() {
        Intent intent = super.getIntent();
        l.c(intent);
        return intent;
    }

    @LayoutRes
    public abstract int getLayoutId();

    public abstract String getPageName();

    public abstract void initData();

    public abstract void initView();

    public boolean needAdaptionScreen() {
        return false;
    }

    @CallSuper
    public void onActivityCreate() {
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    @CallSuper
    public void onBackPressed() {
        if (this.mBackPressDelete.onBackPressed()) {
            return;
        }
        super.onBackPressed();
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    @CallSuper
    public void onCreate(@Nullable Bundle bundle) {
        try {
        } catch (Throwable th) {
            onCreateCaughtException(th);
            this.mPageMonitor.a(PageCreateStage.ERROR_CAUGHT_EXCEPTION);
            if (k.zd().yp()) {
                com.kwad.components.core.d.a.reportSdkCaughtException(th);
                finish();
            } else {
                throw th;
            }
        }
        if (!k.zd().ys()) {
            this.mPageMonitor.a(PageCreateStage.ERROR_SDK_NOT_INIT);
            finish();
            return;
        }
        this.mPageMonitor.a(PageCreateStage.START_ON_CREATE);
        super.onCreate(bundle);
        getActivity().setTheme(16973838);
        this.mContext = com.kwad.sdk.n.l.wrapContextIfNeed(getActivity());
        Intent intent = getIntent();
        this.mPageMonitor.a(PageCreateStage.START_CHECK_INTENT);
        if (!checkIntentData(intent)) {
            this.mPageMonitor.a(PageCreateStage.ERROR_CHECK_INTENT);
            finish();
            return;
        }
        getWindow().setFlags(16777216, 16777216);
        long longExtra = intent != null ? intent.getLongExtra("key_start_time", 0L) : 0L;
        this.mPageMonitor.av(getPageName());
        this.mPageMonitor.F(longExtra);
        int layoutId = getLayoutId();
        this.mPageMonitor.a(PageCreateStage.START_SET_CONTENT_VIEW);
        if (layoutId != 0) {
            setContentView(layoutId);
        }
        this.mPageMonitor.a(PageCreateStage.START_INIT_DATA);
        initData();
        this.mPageMonitor.a(PageCreateStage.START_INIT_VIEW);
        initView();
        this.mPageMonitor.a(PageCreateStage.END_INIT_VIEW);
        h.qg().a(this, bundle);
        onActivityCreate();
        this.mPageMonitor.a(PageCreateStage.END_ON_CREATE);
    }

    public void onCreateCaughtException(Throwable th) {
    }

    public void onCreateStageChange(PageCreateStage pageCreateStage) {
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        try {
            super.onDestroy();
            h.qg().g(this);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        try {
            super.onPause();
            h.qg().f(this);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    @CallSuper
    public void onPreCreate(@Nullable Bundle bundle) {
        try {
            this.mPageMonitor.a(PageCreateStage.START_ON_PRE_CREATE);
            super.onPreCreate(bundle);
            try {
                if (!k.zd().yp() && needAdaptionScreen() && Build.VERSION.SDK_INT <= 27) {
                    com.kwad.components.core.s.d.a(getActivity(), 0, true, false);
                }
            } catch (Throwable th) {
                com.kwad.components.core.d.a.reportSdkCaughtException(th);
            }
            disableFragmentRestore(bundle);
            this.mPageMonitor.a(PageCreateStage.END_ON_PRE_CREATE);
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    @CallSuper
    public void onResume() {
        try {
            super.onResume();
            com.kwad.components.core.proxy.a.a aVar = this.mPageMonitor;
            getActivity();
            aVar.qh();
            h.qg().e(this);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    @CallSuper
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        disableFragmentRestore(bundle);
    }

    public void removeBackPressable(com.kwad.sdk.m.a.b bVar) {
        this.mBackPressDelete.removeBackPressable(bVar);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    @CallSuper
    public void setContentView(int i10) {
        View inflate = com.kwad.sdk.n.l.inflate(this.mContext, i10, null);
        this.mRootView = inflate;
        super.setContentView(inflate);
    }

    public void addBackPressable(com.kwad.sdk.m.a.b bVar, int i10) {
        this.mBackPressDelete.addBackPressable(bVar, i10);
    }
}
