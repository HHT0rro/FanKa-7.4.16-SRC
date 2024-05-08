package com.huawei.flrequest.impl.list;

import android.content.Context;
import com.huawei.flexiblelayout.FLEngine;
import com.huawei.flexiblelayout.json.codec.JsonPacked;
import com.huawei.flrequest.api.FLListRequest;
import com.huawei.flrequest.api.FLRequestConfigService;
import com.huawei.flrequest.api.FLRequestException;
import com.huawei.flrequest.impl.bean.a;

@a(FLListResponseImpl.class)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class FLListRequestImpl extends FLListRequest {
    private static final int DEFAULT_PAGE_SIZE = 25;
    private static final String METHOD = "layout-execution-service/v1/card-list";

    @JsonPacked("dataId")
    private String mDataId;

    @JsonPacked("pageNum")
    private int mPageNum;

    @JsonPacked("pageSize")
    private int mPageSize;

    @JsonPacked("referrer")
    private String mReferrer;

    public FLListRequestImpl(Context context) throws FLRequestException {
        super(context);
        this.mPageSize = 25;
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
        throw new FLRequestException(-1, "FLCardListRequest failed to get FLRequestConfigService.");
    }

    @Override // com.huawei.flrequest.api.FLListRequest
    public String getDataId() {
        return this.mDataId;
    }

    @Override // com.huawei.flrequest.impl.bean.RequestBean
    public String getMethod() {
        return METHOD;
    }

    @Override // com.huawei.flrequest.api.FLListRequest
    public int getPageNum() {
        return this.mPageNum;
    }

    @Override // com.huawei.flrequest.api.FLListRequest
    public String getReferrer() {
        return this.mReferrer;
    }

    public void setDataId(String str) {
        this.mDataId = str;
    }

    public void setPageNum(int i10) {
        this.mPageNum = i10;
    }

    public void setReferrer(String str) {
        this.mReferrer = str;
    }
}
