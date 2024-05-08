package com.huawei.appgallery.agd.agdpro.impl;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.appgallery.agd.agdpro.impl.reward.RewardController;
import com.huawei.appgallery.agd.base.api.InitProxy;
import com.huawei.appgallery.agd.common.FlavorApi;
import com.huawei.appgallery.agd.common.application.ApplicationWrapper;
import com.huawei.appgallery.agd.common.gcd.DispatchBlock;
import com.huawei.appgallery.agd.common.gcd.DispatchQoS;
import com.huawei.appgallery.agd.common.gcd.DispatchQueue;
import com.huawei.appgallery.agd.common.grs.GrsConfigObtainer;
import com.huawei.appgallery.agd.common.utils.ServerAddrConfig;
import com.huawei.appgallery.agd.core.impl.report.MaintBi;
import com.huawei.appgallery.agd.core.impl.report.MaintData;
import com.huawei.appgallery.agd.core.impl.report.MaintKey;
import com.huawei.appgallery.agd.core.impl.store.mediaparams.MediaParamsResponse;
import com.huawei.appgallery.agd.core.internalapi.CoreApi;
import com.huawei.appgallery.agd.core.internalapi.IQueryMediaParams;
import com.huawei.appgallery.agd.pageframe.api.PageApi;
import com.huawei.flexiblelayout.FLEngine;
import com.huawei.hmf.md.spec.jmessage;
import com.huawei.hmf.repository.ComponentRepository;
import com.huawei.jmessage.api.EventSourceManager;
import com.huawei.qcardsupport.qcard.cardmanager.CardMetadata;
import com.huawei.qcardsupport.qcard.cardmanager.CloudCardProvider;
import e9.e;
import e9.q;
import e9.r;
import e9.s;
import java.util.List;
import org.json.JSONArray;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class InitImpl extends InitProxy {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class b implements IQueryMediaParams.Callback {
        public /* synthetic */ b(a aVar) {
        }

        @Override // com.huawei.appgallery.agd.core.internalapi.IQueryMediaParams.Callback
        public void onFail(int i10, String str) {
            e.f48945d.w("InitImpl", "queryMediaParams fail by " + str + ", errorCode = " + i10);
        }

        @Override // com.huawei.appgallery.agd.core.internalapi.IQueryMediaParams.Callback
        public void onSuccess(final MediaParamsResponse mediaParamsResponse) {
            e eVar = e.f48945d;
            eVar.i("InitImpl", "queryMediaParams Success!");
            if (mediaParamsResponse.getTemplatesJsonArray().length() == 0) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("queryMediaParams failed:");
                final String str = "quick card template is empty";
                sb2.append("quick card template is empty");
                eVar.w("InitImpl", sb2.toString());
                DispatchQueue.GLOBAL.async(DispatchQoS.SERIAL, new DispatchBlock() { // from class: f9.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        MediaParamsResponse mediaParamsResponse2 = MediaParamsResponse.this;
                        MaintBi.report(new MaintData.Builder(MaintKey.EVENT_LOAD_TEMPLATE).setResponseCode(mediaParamsResponse2.getResponseCode()).setErrorCode(mediaParamsResponse2.getRtnCode_()).setMsg(str).build());
                    }
                });
                return;
            }
            PageApi.saveCardTemplate(mediaParamsResponse.getTemplatesJsonArray());
        }
    }

    @Override // com.huawei.appgallery.agd.base.api.InitProxy
    public boolean init(@NonNull Context context) {
        if (!PageApi.init(context, GrsConfigObtainer.getServerUrl(context, ServerAddrConfig.SERVER_STORE, FlavorApi.getGrsServerNameV2()), new s())) {
            return false;
        }
        JSONArray jSONArray = new JSONArray();
        List<CardMetadata> metadataList = CloudCardProvider.getInstance(FLEngine.getInstance(ApplicationWrapper.getInstance().getContext())).getMetadataList();
        int size = metadataList.size();
        e.f48945d.i("InitImpl", "query QuickSDK sign card Num:" + size);
        for (CardMetadata cardMetadata : metadataList) {
            if (!TextUtils.isEmpty(cardMetadata.sign)) {
                jSONArray.put(cardMetadata.sign);
            }
        }
        CoreApi.queryMediaParams(jSONArray.toString(), new b(null));
        PageApi.fetchPresetCardTemplates();
        RewardController.init();
        EventSourceManager eventSourceManager = (EventSourceManager) ComponentRepository.getRepository().lookup(jmessage.name).create(EventSourceManager.class);
        eventSourceManager.register("syncVideoCurrenttime", (String) new r());
        eventSourceManager.register("nofifyVideoCurrenttime", (String) new q());
        return true;
    }
}
