package e9;

import androidx.annotation.NonNull;
import com.huawei.appgallery.agd.core.impl.report.OperationBi;
import com.huawei.appgallery.agd.core.impl.store.carddata.CardDataResponseBean;
import com.huawei.appgallery.agd.core.internalapi.IQueryCardData;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class c implements IQueryCardData.Callback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f48941a;

    public c(d dVar) {
        this.f48941a = dVar;
    }

    @Override // com.huawei.appgallery.agd.core.internalapi.IQueryCardData.Callback
    public void onFail(int i10, String str) {
        OperationBi.reportAdCallBackOperate(OperationBi.ACTION_AD_LOAD_FAILURE, this.f48941a.f48942a.getSlotId());
        this.f48941a.f48943b.onFail(i10, str);
    }

    @Override // com.huawei.appgallery.agd.core.internalapi.IQueryCardData.Callback
    public void onSuccess(@NonNull CardDataResponseBean cardDataResponseBean) {
        this.f48941a.b(cardDataResponseBean);
    }
}
