package com.huawei.appgallery.agd.pageframe.layout;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.huawei.appgallery.agd.pageframe.PageFrameLog;
import com.huawei.appgallery.agd.pageframe.api.FLFragment;
import com.huawei.appgallery.agd.pageframe.carddata.BaseDataKeys;
import com.huawei.flexiblelayout.FLEngine;
import com.huawei.flexiblelayout.FLayout;
import com.huawei.flexiblelayout.data.FLDataSource;
import com.huawei.flexiblelayout.parser.DataKeys;
import com.huawei.flexiblelayout.parser.FLDataDelegate;
import com.huawei.flexiblelayout.parser.FLDataParser;
import com.huawei.flexiblelayout.parser.FLDataStream;
import com.huawei.flexiblelayout.parser.cardmanager.LocalCardProvider;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.Task;
import com.huawei.qcardsupport.qcard.cardmanager.CloudCardProvider;
import java.lang.ref.WeakReference;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class FLBaseFragment extends Fragment {

    /* renamed from: b, reason: collision with root package name */
    public Context f27512b;

    /* renamed from: c, reason: collision with root package name */
    public FLayout f27513c;
    public FLFragment.Callback callback;

    /* renamed from: d, reason: collision with root package name */
    public boolean f27514d = false;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class a implements OnSuccessListener<FLDataStream>, OnFailureListener {

        /* renamed from: a, reason: collision with root package name */
        public WeakReference<FLBaseFragment> f27515a;

        /* renamed from: b, reason: collision with root package name */
        public FLFragment.Callback f27516b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f27517c;

        public a(FLBaseFragment fLBaseFragment, FLFragment.Callback callback, boolean z10) {
            this.f27515a = new WeakReference<>(fLBaseFragment);
            this.f27516b = callback;
            this.f27517c = z10;
        }

        @Override // com.huawei.hmf.tasks.OnSuccessListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(FLDataStream fLDataStream) {
            FLBaseFragment fLBaseFragment;
            if (this.f27516b == null) {
                PageFrameLog.LOG.w("FLBaseFragment", "onSuccess#callback is null ");
                return;
            }
            WeakReference<FLBaseFragment> weakReference = this.f27515a;
            if (weakReference != null && (fLBaseFragment = weakReference.get()) != null) {
                FLDataSource dataSource = fLBaseFragment.f27513c.getDataSource();
                if (dataSource == null) {
                    PageFrameLog.LOG.w("FLBaseFragment", "onSuccess#DataSource is null");
                    return;
                }
                fLDataStream.apply(dataSource);
                boolean z10 = (dataSource.getDataGroupSize() == 0 || dataSource.getSize() == 0) ? false : true;
                if (this.f27517c) {
                    this.f27516b.onParseResult(z10, "dataGroup size");
                    return;
                }
                return;
            }
            PageFrameLog.LOG.w("FLBaseFragment", "onSuccess#flBaseFragment does not exits");
        }

        @Override // com.huawei.hmf.tasks.OnFailureListener
        public void onFailure(Exception exc) {
            FLFragment.Callback callback = this.f27516b;
            if (callback == null) {
                PageFrameLog.LOG.w("FLBaseFragment", "onFailure#callback is null ");
            } else if (this.f27517c) {
                callback.onParseResult(false, "task fail");
            }
        }
    }

    public final void O0() {
        PageFrameLog pageFrameLog = PageFrameLog.LOG;
        pageFrameLog.i("FLBaseFragment", "initFLEngine#init FlLayout");
        FLayout fLayout = new FLayout(FLEngine.getInstance(this.f27512b));
        this.f27513c = fLayout;
        fLayout.enableAutoManage(getActivity());
        this.f27513c.enableAutoManage(this);
        if (this.f27513c.getDataSource() != null) {
            this.f27513c.getDataSource().clear();
        }
        this.f27513c.setDataSource(new FLDataSource());
        if (getContainView() == null) {
            pageFrameLog.e("FLBaseFragment", "viewGroup is null, stop load FLFragment");
        } else {
            this.f27513c.bind(FLayout.viewGroup(getContainView()));
        }
    }

    public abstract ViewGroup getContainView();

    public FLDataDelegate getDataDelegate() {
        return null;
    }

    public DataKeys getDataKeys() {
        return new BaseDataKeys();
    }

    public abstract boolean isPageFinish();

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        PageFrameLog pageFrameLog = PageFrameLog.LOG;
        pageFrameLog.i("FLBaseFragment", "onConfigurationChanged#orientation is " + configuration.orientation);
        if (this.callback == null) {
            pageFrameLog.w("FLBaseFragment", "onConfigurationChanged#callback is null");
            return;
        }
        if (!this.f27514d && !isPageFinish()) {
            releaseData();
            FLayout fLayout = this.f27513c;
            if (fLayout != null) {
                fLayout.unbind();
                this.f27513c = null;
                pageFrameLog.w("FLBaseFragment", "onConfigurationChanged#mLayout non null, need to unbind");
            }
            O0();
            parserLayoutData(this.callback, false);
            this.f27514d = true;
            return;
        }
        pageFrameLog.w("FLBaseFragment", "onConfigurationChanged#don't need to rebind layout");
        this.f27514d = true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.f27512b = getActivity();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        PageFrameLog.LOG.i("FLBaseFragment", "onCreateView#init rootView");
        O0();
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void parserLayoutData(@NonNull FLFragment.Callback callback, boolean z10) {
        PageFrameLog pageFrameLog = PageFrameLog.LOG;
        pageFrameLog.i("FLBaseFragment", "parserLayoutData#parser DataSource");
        FLEngine fLEngine = FLEngine.getInstance(this.f27512b);
        FLDataParser.Builder addCardProvider = FLDataParser.builder(fLEngine).setDataKeys(getDataKeys()).addCardProvider(LocalCardProvider.getInstance(fLEngine)).addCardProvider(CloudCardProvider.getInstance(fLEngine));
        if (getDataDelegate() != null) {
            addCardProvider.setDataDelegate(getDataDelegate());
        }
        FLDataParser build = addCardProvider.build();
        if (callback.getLayoutData() == null) {
            callback.onParseResult(false, "layout data empty");
            return;
        }
        pageFrameLog.i("FLBaseFragment", "parserLayoutData#parse layout data");
        Task<FLDataStream> parse = build.parse(callback.getLayoutData());
        a aVar = new a(this, callback, z10);
        parse.addOnSuccessListener(aVar);
        parse.addOnFailureListener(aVar);
    }

    public abstract void releaseData();
}
