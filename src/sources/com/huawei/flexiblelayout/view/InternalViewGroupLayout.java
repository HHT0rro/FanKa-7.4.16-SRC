package com.huawei.flexiblelayout.view;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.adapter.CardAdapter;
import com.huawei.flexiblelayout.adapter.ViewHolder;
import com.huawei.flexiblelayout.adapter.Visit;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.flexiblelayout.services.exposure.CardAttachStateOwner;
import com.huawei.flexiblelayout.services.exposure.impl.CardAttachStateOwnerImpl;
import com.huawei.flexiblelayout.services.exposure.impl.ExposureContainer;
import java.util.Collections;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class InternalViewGroupLayout extends ViewGroupLayout implements ExposureContainer {
    public InternalViewGroupLayout(ViewGroup viewGroup) {
        super(viewGroup);
    }

    @Override // com.huawei.flexiblelayout.services.exposure.impl.ExposureContainer
    @NonNull
    public CardAttachStateOwner getAttachStateOwner() {
        CardAdapter cardAdapter = this.mCardAdapter;
        if (cardAdapter != null) {
            return cardAdapter;
        }
        Log.e("InternalViewGroupLayout", "mCardAdapter is null");
        return new CardAttachStateOwnerImpl();
    }

    @Override // com.huawei.flexiblelayout.services.exposure.impl.ExposureContainer
    @NonNull
    public List<Visit> getExposureItems() {
        ViewHolder viewHolder = this.mViewHolder;
        if (viewHolder != null) {
            return Collections.singletonList(viewHolder);
        }
        return Collections.emptyList();
    }
}
