package com.huawei.quickcard.views.list.listitem;

import android.content.Context;
import androidx.annotation.NonNull;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.views.div.Div;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class QListItem extends Div {
    @Override // com.huawei.quickcard.views.div.Div, com.huawei.quickcard.framework.ui.Component
    @NonNull
    public String getName() {
        return Attributes.Component.LIST_ITEM;
    }

    @Override // com.huawei.quickcard.views.div.Div, com.huawei.quickcard.framework.ui.Component
    public QListItemView createViewImpl(Context context) {
        return new QListItemView(context);
    }
}
