package com.kwad.sdk.core.response.model;

import com.ksad.json.annotation.KsJson;
import java.io.Serializable;

@KsJson
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class AdVideoPreCacheConfig extends com.kwad.sdk.core.response.a.a implements Serializable {
    public static final int DEFAULT_PRE_CACHE_SIZE = 800;
    private static final long serialVersionUID = -3793189825357939577L;
    public int adVideoPreCacheSize;
    public boolean continueLoadingAll;

    public AdVideoPreCacheConfig(int i10, boolean z10) {
        this.adVideoPreCacheSize = i10;
        this.continueLoadingAll = z10;
    }

    public int getAdVideoPreCacheSize() {
        return this.adVideoPreCacheSize;
    }

    public boolean isContinueLoadingAll() {
        return this.continueLoadingAll;
    }

    public void setAdVideoPreCacheSize(int i10) {
        this.adVideoPreCacheSize = i10;
    }

    public void setContinueLoadingAll(boolean z10) {
        this.continueLoadingAll = z10;
    }

    public AdVideoPreCacheConfig() {
        this.adVideoPreCacheSize = 800;
    }
}
