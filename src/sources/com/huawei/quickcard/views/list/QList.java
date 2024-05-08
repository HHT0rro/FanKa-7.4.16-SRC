package com.huawei.quickcard.views.list;

import android.content.Context;
import androidx.annotation.NonNull;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.framework.ui.Component;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class QList extends Component<QRecyclerView> {
    public QList() {
        ListAttrProcessor listAttrProcessor = new ListAttrProcessor();
        addProcessor("columns", listAttrProcessor);
        addProcessor("flexDirection", listAttrProcessor);
        addProcessor(Attributes.Style.LIST_LAYOUT_TYPE, listAttrProcessor);
        addProcessor(Attributes.Style.LIST_BOUNCE, listAttrProcessor);
        addProcessor(Attributes.Style.LIST_SNAP_MODE, listAttrProcessor);
        addProcessor(Attributes.Style.LIST_SNAP_GRAVITY, listAttrProcessor);
        addProcessor(Attributes.Style.LIST_SNAP_OFFSET, listAttrProcessor);
        addProcessor(Attributes.Style.INDEX, listAttrProcessor);
        addProcessor(Attributes.Style.TABMODE, listAttrProcessor);
        addEventProcessor("scroll", new c());
        addEventProcessor("scrollbottom", new a());
        addEventProcessor(Attributes.Event.LIST_SCROLL_END, new b());
        addEventProcessor("scrolltop", new d());
        addEventProcessor(Attributes.Event.LIST_SCROLL_TOUCHUP, new e());
    }

    @Override // com.huawei.quickcard.framework.ui.Component
    @NonNull
    public String getName() {
        return "list";
    }

    @Override // com.huawei.quickcard.framework.ui.Component
    public QRecyclerView createViewImpl(Context context) {
        return new QRecyclerView(context);
    }
}
