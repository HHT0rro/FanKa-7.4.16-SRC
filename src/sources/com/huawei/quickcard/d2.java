package com.huawei.quickcard;

import android.view.ViewGroup;
import android.view.ViewParent;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.framework.inflater.QuickCardInflater;
import com.huawei.quickcard.utils.ViewUtils;
import com.huawei.quickcard.watcher.IWatchConditionCallback;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class d2 implements IWatchConditionCallback {

    /* renamed from: b, reason: collision with root package name */
    private static final String f33585b = "WatchConditionCallback";

    /* renamed from: a, reason: collision with root package name */
    private final ViewGroup f33586a;

    public d2(ViewGroup viewGroup) {
        this.f33586a = viewGroup;
    }

    @Override // com.huawei.quickcard.watcher.IWatchConditionCallback
    public void onUpdate(String str) {
        CardContext cardContext = ViewUtils.getCardContext(this.f33586a);
        if (cardContext == null) {
            CardLogUtils.e(f33585b, "cardContext is null");
            return;
        }
        ViewParent viewParent = this.f33586a;
        if (viewParent instanceof IRecyclerHost) {
            ((IRecyclerHost) viewParent).update(str);
        } else {
            new QuickCardInflater(cardContext).inflateConditionChildren(this.f33586a, str);
        }
    }
}
