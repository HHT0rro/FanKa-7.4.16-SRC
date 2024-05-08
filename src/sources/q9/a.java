package q9;

import androidx.annotation.NonNull;
import com.huawei.appgallery.agd.common.utils.StringUtils;
import com.huawei.appgallery.agd.core.api.AdSlot;
import com.huawei.appgallery.agd.core.api.AgdAdApi;
import com.huawei.appgallery.agd.core.api.RequestConfig;
import com.huawei.appgallery.agd.core.impl.store.carddata.CardDataRequestBean;
import com.huawei.appgallery.agd.core.impl.store.carddata.CardDataResponseBean;
import com.huawei.appgallery.agd.core.internalapi.IQueryCardData;
import com.huawei.appgallery.agd.serverreq.ServerAgent;
import com.huawei.appgallery.agd.serverreq.bean.ResponseBean;
import com.huawei.appgallery.agd.serverreq.listener.IServerCallbackEx;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class a {

    /* renamed from: q9.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class C0809a implements IServerCallbackEx {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IQueryCardData.Callback f53182a;

        public C0809a(IQueryCardData.Callback callback) {
            this.f53182a = callback;
        }

        @Override // com.huawei.appgallery.agd.serverreq.listener.IServerCallbackEx
        public void onFail(int i10, String str) {
            this.f53182a.onFail(1, "StartUp fail with code: " + i10 + ", msg: " + str);
        }

        @Override // com.huawei.appgallery.agd.serverreq.listener.IServerCallbackEx
        public void onResponse(ResponseBean responseBean) {
            a.e(responseBean, this.f53182a);
        }
    }

    public static String a(@NonNull JSONObject jSONObject, String str) {
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        return optJSONObject == null ? "" : optJSONObject.toString();
    }

    public static void b(@NonNull AdSlot adSlot, @NonNull IQueryCardData.Callback callback) {
        CardDataRequestBean cardDataRequestBean = new CardDataRequestBean();
        cardDataRequestBean.setSlotId(adSlot.getSlotId());
        c(cardDataRequestBean, adSlot);
        cardDataRequestBean.setReferrer(StringUtils.isBlank(adSlot.getReferrer()) ? adSlot.getSlotId() : adSlot.getReferrer());
        cardDataRequestBean.setChannelId(adSlot.getChannelId());
        cardDataRequestBean.setAdCount(adSlot.getAdCount());
        cardDataRequestBean.setChildProtection(AgdAdApi.getRequestConfig().getTagForChildProtection());
        ServerAgent.invokeServerEx(cardDataRequestBean, new C0809a(callback));
    }

    public static void c(CardDataRequestBean cardDataRequestBean, AdSlot adSlot) {
        if (cardDataRequestBean != null && adSlot != null) {
            JSONObject mediaExtra = adSlot.getMediaExtra();
            if (mediaExtra != null) {
                cardDataRequestBean.setUserProfile(a(mediaExtra, "userProfile"));
                cardDataRequestBean.setContextIntent(a(mediaExtra, "contextIntent"));
                cardDataRequestBean.setPersonalize(mediaExtra.optJSONObject(RequestConfig.PersonalizeConstant.KEY_PERSONALIZE));
                return;
            }
            n9.a.f52175d.w("CardDataManager", "addMediaExtraParam extraObj null");
            return;
        }
        n9.a.f52175d.e("CardDataManager", "addMediaExtraParam requestBean or adSlot null");
    }

    public static void e(ResponseBean responseBean, @NonNull IQueryCardData.Callback callback) {
        if (!(responseBean instanceof CardDataResponseBean)) {
            callback.onFail(2, "Failed to load the response");
            return;
        }
        CardDataResponseBean cardDataResponseBean = (CardDataResponseBean) responseBean;
        if (cardDataResponseBean.getResponseCode() == 0 && cardDataResponseBean.getRtnCode_() == 0) {
            callback.onSuccess(cardDataResponseBean);
            return;
        }
        if (cardDataResponseBean.getResponseCode() == 3) {
            callback.onFail(5, "rtnCode: " + cardDataResponseBean.getRtnCode_() + ", responseCode: " + cardDataResponseBean.getResponseCode() + ", rtnDesc: " + cardDataResponseBean.getRtnDesc());
            return;
        }
        callback.onFail(3, "rtnCode: " + cardDataResponseBean.getRtnCode_() + ", responseCode: " + cardDataResponseBean.getResponseCode() + ", rtnDesc: " + cardDataResponseBean.getRtnDesc());
    }
}
