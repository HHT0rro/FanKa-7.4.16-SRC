package com.huawei.flrequest.impl.card;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.flexiblelayout.json.codec.JsonPacked;
import com.huawei.flrequest.api.FLRequestException;
import com.huawei.flrequest.api.FLRequestType;
import com.huawei.flrequest.impl.bean.RequestBean;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;

@com.huawei.flrequest.impl.bean.a(CardUrisResponse.class)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class CardUrisRequest extends RequestBean {
    private static final String METHOD = "layout-execution-service/v1/quick-card-uris";

    @JsonPacked("option")
    private String mOption;

    @JsonPacked("pageIds")
    private String mPageIds;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private String f28724a;

        /* renamed from: b, reason: collision with root package name */
        private String f28725b;

        public a a(List<String> list) {
            if (list != null) {
                this.f28724a = new JSONArray((Collection) list).toString();
            }
            return this;
        }

        public a a(String str) {
            if (TextUtils.equals("all", str)) {
                this.f28725b = str;
            }
            return this;
        }

        public CardUrisRequest a(Context context) throws FLRequestException {
            CardUrisRequest cardUrisRequest = new CardUrisRequest(context);
            cardUrisRequest.setRequestType(FLRequestType.REQUEST_SERVER);
            cardUrisRequest.a(0L);
            cardUrisRequest.mPageIds = this.f28724a;
            cardUrisRequest.mOption = this.f28725b;
            return cardUrisRequest;
        }
    }

    public CardUrisRequest(Context context) throws FLRequestException {
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
