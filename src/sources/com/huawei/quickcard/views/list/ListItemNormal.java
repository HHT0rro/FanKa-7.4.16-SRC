package com.huawei.quickcard.views.list;

import com.huawei.quickcard.framework.bean.CardElement;
import com.huawei.quickcard.watcher.Watcher;
import java.util.Collection;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ListItemNormal implements IListItemData {

    /* renamed from: a, reason: collision with root package name */
    private CardElement f34573a;

    /* renamed from: b, reason: collision with root package name */
    private String f34574b;

    /* renamed from: c, reason: collision with root package name */
    private int f34575c;

    /* renamed from: d, reason: collision with root package name */
    private int f34576d;

    /* renamed from: e, reason: collision with root package name */
    private Collection<Watcher> f34577e;

    public ListItemNormal(CardElement cardElement, int i10) {
        this.f34573a = cardElement;
        this.f34576d = i10;
        String ref = cardElement.getRef();
        this.f34574b = ref;
        this.f34575c = ref.hashCode();
    }

    @Override // com.huawei.quickcard.views.list.IListItemData
    public CardElement getCardElement() {
        return this.f34573a;
    }

    @Override // com.huawei.quickcard.views.list.IListItemData
    public int getInsertIndex() {
        return this.f34576d;
    }

    @Override // com.huawei.quickcard.views.list.IListItemData
    public int getItemType() {
        return this.f34575c;
    }

    @Override // com.huawei.quickcard.views.list.IListItemData
    public String getRef() {
        return this.f34574b;
    }

    @Override // com.huawei.quickcard.views.list.IListItemData
    public int getShowCount() {
        return 1;
    }

    public Collection<Watcher> getWatchers() {
        return this.f34577e;
    }

    public void setWatchers(Collection<Watcher> collection) {
        this.f34577e = collection;
    }

    @Override // com.huawei.quickcard.views.list.IListItemData
    public void update() {
    }

    @Override // com.huawei.quickcard.views.list.IListItemData
    public void updateInsertIndex(int i10) {
        this.f34576d += i10;
    }
}
