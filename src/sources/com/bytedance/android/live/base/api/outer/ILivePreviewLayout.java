package com.bytedance.android.live.base.api.outer;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.bytedance.android.live.base.api.ILiveBorderAnimController;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface ILivePreviewLayout {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class Builder {
        private final Context context;
        private ILiveBorderAnimController liveBorderAnimController = null;
        private final Bundle arguments = new Bundle();
        private boolean showTopList = false;
        private boolean showTopListAtOnce = false;
        private boolean enablePullToRefresh = true;
        private boolean smoothEnterEnable = false;
        private boolean autoEnterEnable = false;
        private boolean canShowDislike = true;

        public Builder(Context context) {
            this.context = context;
        }

        public Bundle getArguments() {
            return this.arguments;
        }

        public Context getContext() {
            return this.context;
        }

        public ILiveBorderAnimController getLiveBorderAnimController() {
            return this.liveBorderAnimController;
        }

        public boolean isAutoEnterEnable() {
            return this.autoEnterEnable;
        }

        public boolean isCanShowDislike() {
            return this.canShowDislike;
        }

        public boolean isEnablePullToRefresh() {
            return this.enablePullToRefresh;
        }

        public boolean isShowTopList() {
            return this.showTopList;
        }

        public boolean isShowTopListAtOnce() {
            return this.showTopListAtOnce;
        }

        public boolean isSmoothEnterEnable() {
            return this.smoothEnterEnable;
        }

        public Builder setArguments(Bundle bundle) {
            if (bundle != null) {
                this.arguments.putAll(bundle);
            }
            return this;
        }

        public Builder setAutoEnterEnable(boolean z10) {
            this.autoEnterEnable = z10;
            return this;
        }

        public Builder setCanShowDislike(boolean z10) {
            this.canShowDislike = z10;
            return this;
        }

        public Builder setEnablePullToRefresh(boolean z10) {
            this.enablePullToRefresh = z10;
            return this;
        }

        public Builder setLiveBorderAnimController(ILiveBorderAnimController iLiveBorderAnimController) {
            this.liveBorderAnimController = iLiveBorderAnimController;
            return this;
        }

        public Builder setShowTopList(boolean z10) {
            this.showTopList = z10;
            return this;
        }

        public Builder setShowTopListAtOnce(boolean z10) {
            this.showTopListAtOnce = z10;
            return this;
        }

        public Builder setSmoothEnterEnable(boolean z10) {
            this.smoothEnterEnable = z10;
            return this;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface OnRefreshListener {
        void onError(String str);

        void onSuccess();
    }

    View getView();

    void onPlay();

    void onPullRefresh();

    void onRelease();

    void onStop();

    void setRefreshListener(OnRefreshListener onRefreshListener);
}
