package com.huawei.quickcard.views.list.listitem;

import android.content.Context;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import com.huawei.quickcard.views.div.DivLayout;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class QListItemView extends DivLayout {

    /* renamed from: f, reason: collision with root package name */
    private ViewParent f34628f;

    public QListItemView(Context context) {
        super(context);
    }

    @Override // com.huawei.quickcard.views.div.DivLayout, com.huawei.quickcard.framework.IComponentSupport
    public ViewParent getViewParent(@NonNull View view) {
        ViewParent viewParent = this.f34628f;
        return viewParent == null ? super.getViewParent(view) : viewParent;
    }

    @Override // com.huawei.quickcard.views.div.CardYogaLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        calculateYogaLayout(View.MeasureSpec.makeMeasureSpec(i12 - i10, 0), View.MeasureSpec.makeMeasureSpec(i13 - i11, 0));
        applyLayoutToView(getYogaNode(), 0.0f, 0.0f);
    }

    @Override // com.huawei.quickcard.views.div.DivLayout, com.huawei.quickcard.framework.IComponentSupport
    public void setViewParent(ViewParent viewParent) {
        this.f34628f = viewParent;
    }
}
