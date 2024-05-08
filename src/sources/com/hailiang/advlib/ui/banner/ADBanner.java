package com.hailiang.advlib.ui.banner;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.hailiang.advlib.common.b;
import com.hailiang.advlib.common.d;
import com.hailiang.advlib.core.ICliBundle;
import com.hailiang.advlib.core.ICliUtils;
import com.hailiang.advlib.core.IMultiAdObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ADBanner extends LinearLayout implements Banner {
    public Banner _remote_banner;

    public ADBanner(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this._remote_banner = null;
        InitInstance(this);
        OnBannerInit();
    }

    private boolean checkInstancePresent() {
        if (this._remote_banner == null) {
            InitInstance(this);
        }
        if (this._remote_banner != null) {
            return true;
        }
        d.a(getContext(), -1);
        return false;
    }

    public void InitInstance(LinearLayout linearLayout) {
        if (this._remote_banner == null) {
            this._remote_banner = (Banner) b.c().a(Banner.class, linearLayout);
        }
    }

    @Override // com.hailiang.advlib.ui.banner.Banner
    public void OnBannerInit() {
        if (checkInstancePresent()) {
            this._remote_banner.OnBannerInit();
        }
    }

    @Override // com.hailiang.advlib.ui.banner.Banner
    public void UpdateView(ICliBundle iCliBundle) {
        if (checkInstancePresent()) {
            this._remote_banner.UpdateView(iCliBundle);
        }
    }

    @Override // com.hailiang.advlib.ui.banner.Banner
    public void setADStateListener(IMultiAdObject.ADStateListener aDStateListener) {
        if (checkInstancePresent()) {
            try {
                this._remote_banner.setADStateListener(aDStateListener);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.hailiang.advlib.ui.banner.Banner
    public void setPageUniqueId(int i10) {
        if (checkInstancePresent()) {
            try {
                this._remote_banner.setPageUniqueId(i10);
            } catch (AbstractMethodError e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.hailiang.advlib.ui.banner.Banner
    public void setStateListener(ICliUtils.BannerStateListener bannerStateListener) {
        if (checkInstancePresent()) {
            this._remote_banner.setStateListener(bannerStateListener);
        }
    }

    @Override // com.hailiang.advlib.ui.banner.Banner
    public void updateViewWithAds(Object obj) {
        if (checkInstancePresent()) {
            this._remote_banner.updateViewWithAds(obj);
        }
    }

    public ADBanner(Context context) {
        super(context);
        this._remote_banner = null;
        InitInstance(this);
        OnBannerInit();
    }

    public ADBanner(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this._remote_banner = null;
        InitInstance(this);
        OnBannerInit();
    }
}
