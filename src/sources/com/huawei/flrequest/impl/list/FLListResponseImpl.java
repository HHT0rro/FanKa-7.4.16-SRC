package com.huawei.flrequest.impl.list;

import com.huawei.flexiblelayout.json.codec.JsonPacked;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.flrequest.api.FLListResponse;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class FLListResponseImpl extends FLListResponse {
    private static final String TAG = "CardListResponse";

    @JsonPacked("dataId")
    private String mDataId;

    @JsonPacked("hasMore")
    private int mHasMore;

    @JsonPacked("layoutData")
    private JSONArray mLayoutData;

    @Override // com.huawei.flrequest.api.FLListResponse
    public String getDataId() {
        if (getResponseJSON() == null) {
            Log.w(TAG, "getDataId error, getResponseJSON() == null");
            return null;
        }
        if (this.mDataId == null) {
            try {
                this.mDataId = getResponseJSON().getString("dataId");
            } catch (JSONException e2) {
                Log.w(TAG, "getDataId error, JSONException: " + e2.getMessage());
            }
        }
        return this.mDataId;
    }

    @Override // com.huawei.flrequest.api.FLListResponse
    public JSONArray getLayoutData() {
        if (getResponseJSON() == null) {
            Log.w(TAG, "getLayoutData error, getResponseJSON() == null");
            return null;
        }
        if (this.mLayoutData == null) {
            try {
                this.mLayoutData = getResponseJSON().getJSONArray("layoutData");
            } catch (JSONException e2) {
                Log.w(TAG, "getLayoutData error, JSONException: " + e2.getMessage());
            }
        }
        return this.mLayoutData;
    }

    @Override // com.huawei.flrequest.api.FLListResponse
    public int hasMore() {
        if (getResponseJSON() == null) {
            Log.w(TAG, "hasMore error, getResponseJSON() == null");
            return 0;
        }
        int optInt = getResponseJSON().optInt("hasMore");
        this.mHasMore = optInt;
        return optInt;
    }
}
