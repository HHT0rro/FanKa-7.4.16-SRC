package com.huawei.flexiblelayout.adapter;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.flexiblelayout.FLContext;
import com.huawei.flexiblelayout.data.FLDataGroup;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ViewHolder extends RecyclerView.ViewHolder implements Visit {

    /* renamed from: a, reason: collision with root package name */
    private final FLContext f27724a;

    /* renamed from: b, reason: collision with root package name */
    private ViewContainer f27725b;

    public ViewHolder(FLContext fLContext, @NonNull View view, ViewContainer viewContainer) {
        super(view);
        this.f27725b = viewContainer;
        this.f27724a = fLContext;
    }

    public void setData(FLDataGroup.Cursor cursor) {
        this.f27725b.setData(this.f27724a, cursor);
    }

    public void unsetData() {
        ViewContainer viewContainer = this.f27725b;
        if (viewContainer != null) {
            viewContainer.unsetData(this.f27724a);
        }
    }

    @Override // com.huawei.flexiblelayout.adapter.Visit
    public void visit(@NonNull Visitor visitor) {
        ViewContainer viewContainer = this.f27725b;
        if (viewContainer instanceof Visit) {
            ((Visit) viewContainer).visit(visitor);
        }
    }
}
