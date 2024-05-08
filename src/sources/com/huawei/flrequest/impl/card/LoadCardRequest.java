package com.huawei.flrequest.impl.card;

import android.content.Context;
import com.huawei.flexiblelayout.json.codec.JsonPacked;
import com.huawei.flrequest.api.FLRequestException;
import com.huawei.flrequest.api.FLRequestType;
import com.huawei.flrequest.impl.bean.RequestBean;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;

@com.huawei.flrequest.impl.bean.a(LoadCardResponse.class)
@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class LoadCardRequest extends RequestBean {
    private static final String METHOD = "layout-execution-service/v1/preload-card-template";

    @JsonPacked("hashes")
    private String mHashes;

    @JsonPacked("pageIds")
    private String mPageIds;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private String f28726a;

        /* renamed from: b, reason: collision with root package name */
        private String f28727b;

        public a a(List<String> list) {
            if (list != null) {
                this.f28727b = new JSONArray((Collection) list).toString();
            }
            return this;
        }

        public a b(List<String> list) {
            if (list != null) {
                this.f28726a = new JSONArray((Collection) list).toString();
            }
            return this;
        }

        public LoadCardRequest a(Context context) throws FLRequestException {
            LoadCardRequest loadCardRequest = new LoadCardRequest(context);
            loadCardRequest.setRequestType(FLRequestType.REQUEST_SERVER);
            loadCardRequest.a(0L);
            loadCardRequest.mPageIds = this.f28726a;
            loadCardRequest.mHashes = this.f28727b;
            return loadCardRequest;
        }
    }

    public LoadCardRequest(Context context) throws FLRequestException {
        super(context);
    }

    public static a builder() {
        return new a();
    }

    @Override // com.huawei.flrequest.impl.bean.RequestBean
    public String getMethod() {
        return METHOD;
    }
}
