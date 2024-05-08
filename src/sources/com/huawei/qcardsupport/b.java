package com.huawei.qcardsupport;

import com.huawei.appgallery.agd.pageframe.api.CardConstants;
import com.huawei.flexiblelayout.FLEngine;
import com.huawei.flexiblelayout.data.FLayoutSpec;
import com.huawei.hmf.services.ApiSet;
import com.huawei.hmf.services.ModuleProvider;
import com.huawei.qcardsupport.cards.QCard;

/* compiled from: QCardSupportDefine.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class b extends ModuleProvider {
    @Override // com.huawei.hmf.services.ModuleProvider
    public void initialize() {
    }

    @Override // com.huawei.hmf.services.ModuleProvider
    public ApiSet register() {
        FLEngine fLEngine = FLEngine.getInstance(getContext());
        FLayoutSpec.FNodeSpec name = FLayoutSpec.node().child(FLayoutSpec.card(QCard.TYPE)).name(CardConstants.VALUE_QLAYOUT);
        fLEngine.register(QCard.TYPE, QCard.class);
        fLEngine.registerNodeSpec(name);
        return super.register();
    }
}
