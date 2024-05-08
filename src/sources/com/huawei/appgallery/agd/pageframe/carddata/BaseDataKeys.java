package com.huawei.appgallery.agd.pageframe.carddata;

import com.huawei.appgallery.agd.pageframe.api.CardConstants;
import com.huawei.flexiblelayout.parser.DataKeys;
import com.huawei.flexiblelayout.parser.cardmanager.d;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class BaseDataKeys extends DataKeys {
    @Override // com.huawei.flexiblelayout.parser.DataKeys
    public String children() {
        return null;
    }

    @Override // com.huawei.flexiblelayout.parser.DataKeys
    public String data() {
        return CardConstants.KEY_DATA_LIST;
    }

    @Override // com.huawei.flexiblelayout.parser.DataKeys
    public String groupId() {
        return CardConstants.KEY_LAYOUT_ID;
    }

    @Override // com.huawei.flexiblelayout.parser.DataKeys
    public String link() {
        return d.f28337g;
    }

    public String name() {
        return "layoutName";
    }

    @Override // com.huawei.flexiblelayout.parser.DataKeys
    public String style() {
        return "style";
    }

    @Override // com.huawei.flexiblelayout.parser.DataKeys
    public String type() {
        return "layoutName";
    }

    @Override // com.huawei.flexiblelayout.parser.DataKeys
    public String uri() {
        return CardConstants.KEY_QUICK_URI;
    }
}
