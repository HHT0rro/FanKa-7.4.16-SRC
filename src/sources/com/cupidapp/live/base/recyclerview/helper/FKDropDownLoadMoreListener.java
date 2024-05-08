package com.cupidapp.live.base.recyclerview.helper;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.base.utils.j;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKDropDownLoadMoreListener.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKDropDownLoadMoreListener extends RecyclerView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final Function1<Boolean, p> f12089a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f12090b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public RecyclerView.OnScrollListener f12091c;

    /* JADX WARN: Multi-variable type inference failed */
    public FKDropDownLoadMoreListener(@NotNull Function1<? super Boolean, p> loadMoreCallBack) {
        s.i(loadMoreCallBack, "loadMoreCallBack");
        this.f12089a = loadMoreCallBack;
    }

    public final void c(boolean z10) {
        this.f12090b = z10;
    }

    public final void d(@Nullable RecyclerView.OnScrollListener onScrollListener) {
        this.f12091c = onScrollListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(@NotNull RecyclerView recyclerView, int i10, int i11) {
        s.i(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i10, i11);
        RecyclerView.OnScrollListener onScrollListener = this.f12091c;
        if (onScrollListener != null) {
            onScrollListener.onScrolled(recyclerView, i10, i11);
        }
        if (!this.f12090b && Math.abs(i11) > 0) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                int itemCount = linearLayoutManager.getItemCount();
                j.a aVar = j.f12332a;
                aVar.a("FKDropDownLoadMoreListener", "dy: " + i11 + " loading: " + this.f12090b);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("firstPosition: ");
                sb2.append(findFirstVisibleItemPosition);
                aVar.a("FKDropDownLoadMoreListener", sb2.toString());
                aVar.a("FKDropDownLoadMoreListener", "lastPosition: " + findLastVisibleItemPosition + " itemCount: " + itemCount);
                if (i11 < 0 && findFirstVisibleItemPosition >= 0 && findFirstVisibleItemPosition <= 3) {
                    this.f12090b = true;
                    this.f12089a.invoke(Boolean.FALSE);
                } else {
                    if (i11 <= 0 || findLastVisibleItemPosition >= itemCount || findLastVisibleItemPosition < itemCount - 3) {
                        return;
                    }
                    this.f12090b = true;
                    this.f12089a.invoke(Boolean.TRUE);
                }
            }
        }
    }
}
