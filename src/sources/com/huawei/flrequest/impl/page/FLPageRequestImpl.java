package com.huawei.flrequest.impl.page;

import android.content.Context;
import com.huawei.flexiblelayout.FLEngine;
import com.huawei.flexiblelayout.json.codec.JsonPacked;
import com.huawei.flrequest.api.FLPageRequest;
import com.huawei.flrequest.api.FLRequestConfigService;
import com.huawei.flrequest.api.FLRequestException;
import com.huawei.flrequest.impl.bean.a;

@a(FLPageResponseImpl.class)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class FLPageRequestImpl extends FLPageRequest {
    private static final int DEFAULT_PAGE_SIZE = 25;
    private static final String METHOD = "layout-execution-service/v1/page-detail";
    private String mCacheId;

    @JsonPacked("pageId")
    private String mPageId;

    @JsonPacked("pageSize")
    private int mPageSize;

    @JsonPacked("referrer")
    private String mReferrer;

    public FLPageRequestImpl(Context context) throws FLRequestException {
        super(context);
        FLRequestConfigService fLRequestConfigService = (FLRequestConfigService) FLEngine.getInstance(context).getService(FLRequestConfigService.class);
        if (fLRequestConfigService != null) {
            int pageSize = fLRequestConfigService.getPageSize();
            this.mPageSize = pageSize;
            if (pageSize <= 0) {
                this.mPageSize = 25;
                return;
            }
            return;
        }
        throw new FLRequestException(-1, "failed to get FLRequestConfigService.");
    }

    @Override // com.huawei.flrequest.impl.bean.RequestBean, com.huawei.serverrequest.api.ServerRequest
    public String getCacheId() {
        if (getCacheExpireTime() <= 0) {
            return "";
        }
        String str = this.mCacheId;
        if (str != null) {
            return str;
        }
        String str2 = getUrl() + c() + b() + a() + getPageId() + getPageSize();
        this.mCacheId = str2;
        return str2;
    }

    @Override // com.huawei.flrequest.impl.bean.RequestBean
    public Object getExtra() {
        return null;
    }

    @Override // com.huawei.flrequest.impl.bean.RequestBean
    public String getMethod() {
        return METHOD;
    }

    @Override // com.huawei.flrequest.api.FLPageRequest
    public String getPageId() {
        return this.mPageId;
    }

    public int getPageSize() {
        return this.mPageSize;
    }

    @Override // com.huawei.flrequest.api.FLPageRequest
    public String getReferrer() {
        return this.mReferrer;
    }

    public void setPageId(String str) {
        this.mPageId = str;
    }

    public void setReferrer(String str) {
        this.mReferrer = str;
    }
}
