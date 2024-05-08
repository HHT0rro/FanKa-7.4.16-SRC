package com.huawei.flexiblelayout.adapter;

import android.util.SparseArray;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.flexiblelayout.FLContext;
import com.huawei.flexiblelayout.FLayout;
import com.huawei.flexiblelayout.data.FLDataGroup;
import com.huawei.flexiblelayout.data.FLDataSource;
import com.huawei.flexiblelayout.data.FLNodeData;
import com.huawei.flexiblelayout.services.exposure.CardAttachStateListener;
import com.huawei.flexiblelayout.services.exposure.CardAttachStateOwner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class CardAdapter extends RecyclerView.Adapter<ViewHolder> implements CardAttachStateOwner {

    /* renamed from: e, reason: collision with root package name */
    private static Map<String, Integer> f27717e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    private static AtomicInteger f27718f = new AtomicInteger(0);

    /* renamed from: a, reason: collision with root package name */
    private FLDataSource f27719a;

    /* renamed from: b, reason: collision with root package name */
    private final FLContext f27720b;

    /* renamed from: c, reason: collision with root package name */
    private List<CardAttachStateListener> f27721c;

    /* renamed from: d, reason: collision with root package name */
    private SparseArray<FLDataGroup.Cursor> f27722d = new SparseArray<>();

    public CardAdapter(FLDataSource fLDataSource) {
        this.f27719a = fLDataSource;
        FLayout fLayout = fLDataSource.getFLayout();
        this.f27720b = new FLContext(fLayout, fLayout.getView().getContext());
    }

    private int a(String str) {
        Integer num = f27717e.get(str);
        if (num == null) {
            num = Integer.valueOf(f27718f.incrementAndGet());
            f27717e.put(str, num);
        }
        return num.intValue();
    }

    @Override // com.huawei.flexiblelayout.services.exposure.CardAttachStateOwner
    public void addListener(@NonNull CardAttachStateListener cardAttachStateListener) {
        if (this.f27721c == null) {
            this.f27721c = new ArrayList();
        }
        this.f27721c.add(cardAttachStateListener);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f27719a.getSize();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i10) {
        FLDataGroup.Cursor cursor = this.f27719a.getCursor(i10);
        FLNodeData current = cursor != null ? cursor.current() : null;
        int a10 = a(current != null ? current.getReuseIdentifier() : null);
        this.f27722d.put(a10, cursor);
        return a10;
    }

    public void onUnbindViewHolder(ViewHolder viewHolder) {
        viewHolder.unsetData();
    }

    @Override // com.huawei.flexiblelayout.services.exposure.CardAttachStateOwner
    public void removeListener(@NonNull CardAttachStateListener cardAttachStateListener) {
        List<CardAttachStateListener> list = this.f27721c;
        if (list == null) {
            return;
        }
        list.remove(cardAttachStateListener);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(@NonNull ViewHolder viewHolder, int i10, @NonNull List list) {
        onBindViewHolder2(viewHolder, i10, (List<Object>) list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i10) {
        FLDataGroup.Cursor cursor = this.f27722d.get(i10);
        ViewContainer createContainer = cursor.getDataGroup().getGroupLayoutStrategy().createContainer();
        FLContext fLContext = this.f27720b;
        return new ViewHolder(fLContext, createContainer.createView(fLContext, cursor, viewGroup), createContainer);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public boolean onFailedToRecycleView(@NonNull ViewHolder viewHolder) {
        onUnbindViewHolder(viewHolder);
        return super.onFailedToRecycleView((CardAdapter) viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NonNull ViewHolder viewHolder) {
        super.onViewAttachedToWindow((CardAdapter) viewHolder);
        List<CardAttachStateListener> list = this.f27721c;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f27721c.get(size).onViewAttachedToWindow(viewHolder);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(@NonNull ViewHolder viewHolder) {
        super.onViewDetachedFromWindow((CardAdapter) viewHolder);
        List<CardAttachStateListener> list = this.f27721c;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f27721c.get(size).onViewDetachedFromWindow(viewHolder);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(@NonNull ViewHolder viewHolder) {
        onUnbindViewHolder(viewHolder);
        super.onViewRecycled((CardAdapter) viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i10) {
        viewHolder.setData(this.f27719a.getCursor(i10));
    }

    /* renamed from: onBindViewHolder, reason: avoid collision after fix types in other method */
    public void onBindViewHolder2(@NonNull ViewHolder viewHolder, int i10, @NonNull List<Object> list) {
        if (list.size() != 0) {
            viewHolder.unsetData();
            onViewDetachedFromWindow(viewHolder);
            onBindViewHolder(viewHolder, i10);
            onViewAttachedToWindow(viewHolder);
            return;
        }
        onBindViewHolder(viewHolder, i10);
    }
}
