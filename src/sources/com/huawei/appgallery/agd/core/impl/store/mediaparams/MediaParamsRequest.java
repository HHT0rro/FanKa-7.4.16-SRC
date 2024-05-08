package com.huawei.appgallery.agd.core.impl.store.mediaparams;

import androidx.annotation.Nullable;
import com.huawei.appgallery.agd.core.impl.store.base.MasRequestBean;
import com.huawei.appgallery.agd.serverreq.json.annotation.NetworkTransmission;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class MediaParamsRequest extends MasRequestBean {
    public static final String API_METHOD = "client.getMediaParams";
    public static final int TEMPLATE_NEED = 1;
    public static final int TEMPLATE_NONE = 0;

    @NetworkTransmission
    private String cardHashes;

    @NetworkTransmission
    private int needsTemplate;

    public MediaParamsRequest(@Nullable String str, int i10) {
        this.needsTemplate = 1;
        setMethod_(API_METHOD);
        this.cardHashes = str;
        this.needsTemplate = i10;
    }
}
