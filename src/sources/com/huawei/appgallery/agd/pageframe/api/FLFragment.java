package com.huawei.appgallery.agd.pageframe.api;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.appgallery.agd.pageframe.R$id;
import com.huawei.appgallery.agd.pageframe.R$layout;
import com.huawei.appgallery.agd.pageframe.layout.FLBaseFragment;
import com.huawei.flexiblelayout.data.primitive.FLMap;
import com.huawei.flexiblelayout.parser.FLDataDelegate;
import org.json.JSONArray;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class FLFragment extends FLBaseFragment {
    public static final String KEY_AD_ID = "ad_id";

    /* renamed from: e, reason: collision with root package name */
    public View f27506e;

    /* renamed from: f, reason: collision with root package name */
    public RewardVideoCallBack f27507f;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface Callback {
        @Nullable
        JSONArray getLayoutData();

        void onParseNode(String str, @NonNull FLMap fLMap);

        void onParseResult(boolean z10, String str);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface RewardVideoCallBack extends Callback {
        void closeVideo();

        boolean isVideoCompleted();
    }

    @Override // com.huawei.appgallery.agd.pageframe.layout.FLBaseFragment
    public ViewGroup getContainView() {
        return (ViewGroup) this.f27506e.findViewById(R$id.app_container);
    }

    @Override // com.huawei.appgallery.agd.pageframe.layout.FLBaseFragment
    public FLDataDelegate getDataDelegate() {
        return new v9.a(this.callback);
    }

    @Override // com.huawei.appgallery.agd.pageframe.layout.FLBaseFragment
    public boolean isPageFinish() {
        RewardVideoCallBack rewardVideoCallBack = this.f27507f;
        if (rewardVideoCallBack != null) {
            return rewardVideoCallBack.isVideoCompleted();
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof Callback) {
            this.callback = (Callback) context;
        }
        if (context instanceof RewardVideoCallBack) {
            this.f27507f = (RewardVideoCallBack) context;
        }
    }

    @Override // com.huawei.appgallery.agd.pageframe.layout.FLBaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.f27506e = (ViewGroup) layoutInflater.inflate(R$layout.agdsdk_fragment_fl, viewGroup, false);
        super.onCreateView(layoutInflater, viewGroup, bundle);
        Callback callback = this.callback;
        if (callback != null) {
            parserLayoutData(callback, true);
        }
        return this.f27506e;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    @Override // com.huawei.appgallery.agd.pageframe.layout.FLBaseFragment
    public void releaseData() {
        RewardVideoCallBack rewardVideoCallBack = this.f27507f;
        if (rewardVideoCallBack != null) {
            rewardVideoCallBack.closeVideo();
        }
    }
}
