package e9;

import com.huawei.appgallery.agd.agdpro.impl.reward.RewardController;
import com.huawei.appgallery.agd.serverreq.bean.ResponseBean;
import com.huawei.appgallery.agd.serverreq.listener.IServerCallbackEx;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class v implements IServerCallbackEx {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f48989a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RewardController f48990b;

    public v(RewardController rewardController, JSONObject jSONObject) {
        this.f48990b = rewardController;
        this.f48989a = jSONObject;
    }

    @Override // com.huawei.appgallery.agd.serverreq.listener.IServerCallbackEx
    public void onFail(int i10, String str) {
        this.f48990b.a(this.f48989a, 2004, "errorCode=" + i10 + "errorMsg=" + str);
    }

    @Override // com.huawei.appgallery.agd.serverreq.listener.IServerCallbackEx
    public void onResponse(ResponseBean responseBean) {
        int responseCode = responseBean.getResponseCode();
        int rtnCode_ = responseBean.getRtnCode_();
        if (responseCode != 0) {
            this.f48990b.a(this.f48989a, 2005, "response code " + responseCode);
            return;
        }
        if (rtnCode_ != 0) {
            this.f48990b.a(this.f48989a, 2006, "rtn code " + rtnCode_);
            return;
        }
        this.f48990b.a(this.f48989a, 0, "Reward verify success");
    }
}
