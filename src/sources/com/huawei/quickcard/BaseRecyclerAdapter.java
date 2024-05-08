package com.huawei.quickcard;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.framework.IComponentSupport;
import com.huawei.quickcard.framework.condition.ConditionalData;
import com.huawei.quickcard.framework.inflater.QuickCardInflater;
import com.huawei.quickcard.framework.processor.PropertyCacheBean;
import com.huawei.quickcard.utils.ExpressionUtils;
import com.huawei.quickcard.utils.ValueUtils;
import com.huawei.quickcard.views.list.IListItemData;
import com.huawei.quickcard.views.list.ListItemCondition;
import com.huawei.quickcard.views.list.ListItemNormal;
import com.huawei.quickcard.views.list.QRecyclerViewHolder;
import com.huawei.quickcard.watcher.IWatcherManager;
import com.huawei.quickcard.watcher.Watcher;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class BaseRecyclerAdapter<V extends View> extends RecyclerView.Adapter<QRecyclerViewHolder> {

    /* renamed from: a, reason: collision with root package name */
    private static final String f33235a = "BaseRecyclerAdapter";
    public CardContext cardContext;
    public List<IListItemData> childrenElement = new ArrayList();

    /* JADX WARN: Multi-variable type inference failed */
    public QRecyclerViewHolder createViewHolder(IListItemData iListItemData, View view, List<Watcher> list, IWatcherManager iWatcherManager) {
        if (iListItemData instanceof ListItemCondition) {
            ListItemCondition listItemCondition = (ListItemCondition) iListItemData;
            PropertyCacheBean obtainPropertyCacheBeanFromView = ValueUtils.obtainPropertyCacheBeanFromView(view);
            ConditionalData conditionalData = new ConditionalData(listItemCondition.getForCondition(), listItemCondition.getIfCondition(), listItemCondition.getRef());
            conditionalData.setViewHashCode(view.hashCode());
            conditionalData.setConditionalView(view);
            obtainPropertyCacheBeanFromView.setConditionalData(conditionalData);
            conditionalData.setWatchers(list);
            ConditionalData findSuperConditionData = ConditionalData.findSuperConditionData(iWatcherManager, view);
            if (findSuperConditionData != null) {
                findSuperConditionData.addChildWithForCondition(view);
            }
        } else if (iListItemData instanceof ListItemNormal) {
            ConditionalData findSuperConditionData2 = ConditionalData.findSuperConditionData(iWatcherManager, view);
            if (findSuperConditionData2 != null) {
                findSuperConditionData2.getWatchers().addAll(list);
            }
            ((ListItemNormal) iListItemData).setWatchers(list);
        } else {
            CardLogUtils.e(f33235a, "It's not supported item");
        }
        if (view instanceof IComponentSupport) {
            ((IComponentSupport) view).setViewParent(view.getParent());
        }
        ((ViewGroup) view.getParent()).removeView(view);
        return new QRecyclerViewHolder(view);
    }

    public IListItemData getItemByType(int i10) {
        for (int i11 = 0; i11 < this.childrenElement.size(); i11++) {
            if (this.childrenElement.get(i11).getItemType() == i10) {
                return this.childrenElement.get(i11);
            }
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        int i10 = 0;
        for (int i11 = 0; i11 < this.childrenElement.size(); i11++) {
            i10 += this.childrenElement.get(i11).getShowCount();
        }
        return i10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i10) {
        int i11 = 0;
        for (int i12 = 0; i12 < this.childrenElement.size(); i12++) {
            int showCount = this.childrenElement.get(i12).getShowCount();
            if (i10 >= i11 && i10 < i11 + showCount) {
                return this.childrenElement.get(i12).getItemType();
            }
            i11 += showCount;
        }
        return -1;
    }

    public void onDataChanged(String str) {
        IListItemData iListItemData;
        int i10 = 0;
        while (true) {
            if (i10 >= this.childrenElement.size()) {
                iListItemData = null;
                i10 = -1;
                break;
            } else {
                iListItemData = this.childrenElement.get(i10);
                if (TextUtils.equals(str, iListItemData.getRef())) {
                    break;
                } else {
                    i10++;
                }
            }
        }
        if (iListItemData == null) {
            return;
        }
        int showCount = iListItemData.getShowCount();
        iListItemData.update();
        int showCount2 = iListItemData.getShowCount() - showCount;
        if (showCount2 != 0) {
            while (true) {
                i10++;
                if (i10 >= this.childrenElement.size()) {
                    break;
                } else {
                    this.childrenElement.get(i10).updateInsertIndex(showCount2);
                }
            }
        }
        notifyDataSetChanged();
    }

    public void setCardContext(CardContext cardContext) {
        this.cardContext = cardContext;
    }

    public void setDataList(List<IListItemData> list) {
        this.childrenElement = new ArrayList(list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull QRecyclerViewHolder qRecyclerViewHolder, int i10) {
        String str;
        Objects.requireNonNull(this.cardContext, "onBindViewHolder, cardContext is null.");
        int i11 = 0;
        for (int i12 = 0; i12 < this.childrenElement.size(); i12++) {
            IListItemData iListItemData = this.childrenElement.get(i12);
            int showCount = iListItemData.getShowCount();
            if (i10 >= i11 && i10 < i11 + showCount) {
                if (iListItemData instanceof ListItemCondition) {
                    ConditionalData conditionalData = ValueUtils.getConditionalData(qRecyclerViewHolder.itemView);
                    if (conditionalData != null) {
                        ListItemCondition listItemCondition = (ListItemCondition) iListItemData;
                        ConditionalData superConditionalData = conditionalData.getSuperConditionalData();
                        String selfForChains = superConditionalData != null ? superConditionalData.getSelfForChains() : "";
                        j0 forCondition = listItemCondition.getForCondition();
                        if (forCondition != null) {
                            int i13 = i10 - i11;
                            int dataIndexByShowIndex = listItemCondition.getDataIndexByShowIndex(i13);
                            if (listItemCondition.isDataArr()) {
                                str = ExpressionUtils.computeForChains(forCondition, i13, selfForChains);
                            } else {
                                str = ExpressionUtils.computeForChains(forCondition, i12, String.valueOf(listItemCondition.getKeys().get(dataIndexByShowIndex)), selfForChains);
                            }
                        } else {
                            str = selfForChains;
                        }
                        conditionalData.setForChains(selfForChains, str);
                        ExpressionUtils.updateWatcherScript(conditionalData.getWatchers(), str, this.cardContext.getWatcherManager(), true);
                        conditionalData.updateAllChildren(this.cardContext);
                        return;
                    }
                    return;
                }
                if (iListItemData instanceof ListItemNormal) {
                    String forChains = ExpressionUtils.getForChains(qRecyclerViewHolder.itemView);
                    IWatcherManager watcherManager = this.cardContext.getWatcherManager();
                    Collection<Watcher> watchers = ((ListItemNormal) iListItemData).getWatchers();
                    ExpressionUtils.updateWatcherScript(watchers, forChains, this.cardContext.getWatcherManager(), true);
                    watcherManager.updateWatchers(watchers);
                    return;
                }
                return;
            }
            i11 += showCount;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public QRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i10) {
        Objects.requireNonNull(this.cardContext, "onCreateViewHolder, cardContext is null.");
        IListItemData itemByType = getItemByType(i10);
        ArrayList arrayList = new ArrayList();
        IWatcherManager watcherManager = this.cardContext.getWatcherManager();
        watcherManager.collectNewWatchers(arrayList);
        View forceInflateView = new QuickCardInflater(this.cardContext).forceInflateView(itemByType.getCardElement(), viewGroup, -1);
        watcherManager.stopCollectNewWatchers(arrayList);
        return createViewHolder(itemByType, forceInflateView, arrayList, watcherManager);
    }

    public void onDataChanged() {
        for (int i10 = 0; i10 < this.childrenElement.size(); i10++) {
            IListItemData iListItemData = this.childrenElement.get(i10);
            int showCount = iListItemData.getShowCount();
            iListItemData.update();
            int showCount2 = iListItemData.getShowCount() - showCount;
            if (showCount2 != 0) {
                for (int i11 = i10 + 1; i11 < this.childrenElement.size(); i11++) {
                    this.childrenElement.get(i11).updateInsertIndex(showCount2);
                }
            }
        }
        notifyDataSetChanged();
    }
}
