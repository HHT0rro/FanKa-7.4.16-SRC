package com.huawei.quickcard.views.list;

import com.huawei.quickcard.CardContext;
import com.huawei.quickcard.base.interfaces.CardDataObject;
import com.huawei.quickcard.framework.bean.CardElement;
import com.huawei.quickcard.framework.condition.ConditionalChild;
import com.huawei.quickcard.j0;
import com.huawei.quickcard.p0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ListItemCondition implements IListItemData {

    /* renamed from: a, reason: collision with root package name */
    private CardContext f34566a;

    /* renamed from: b, reason: collision with root package name */
    private ConditionalChild f34567b;

    /* renamed from: c, reason: collision with root package name */
    private int f34568c;

    /* renamed from: e, reason: collision with root package name */
    private boolean f34570e;

    /* renamed from: g, reason: collision with root package name */
    private boolean f34572g;

    /* renamed from: d, reason: collision with root package name */
    private List<Integer> f34569d = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    private List f34571f = new ArrayList();

    public ListItemCondition(CardContext cardContext, ConditionalChild conditionalChild) {
        this.f34566a = cardContext;
        this.f34567b = conditionalChild;
        this.f34568c = conditionalChild.getCardElement().getRef().hashCode();
    }

    @Override // com.huawei.quickcard.views.list.IListItemData
    public CardElement getCardElement() {
        return this.f34567b.getCardElement();
    }

    public int getDataIndexByShowIndex(int i10) {
        return this.f34569d.get(i10).intValue();
    }

    public j0 getForCondition() {
        return this.f34567b.getForCondition();
    }

    public p0 getIfCondition() {
        return this.f34567b.getIfCondition();
    }

    @Override // com.huawei.quickcard.views.list.IListItemData
    public int getInsertIndex() {
        return this.f34567b.getInsertIndex();
    }

    @Override // com.huawei.quickcard.views.list.IListItemData
    public int getItemType() {
        return this.f34568c;
    }

    public List getKeys() {
        return this.f34571f;
    }

    @Override // com.huawei.quickcard.views.list.IListItemData
    public String getRef() {
        return this.f34567b.getCardElement().getRef();
    }

    @Override // com.huawei.quickcard.views.list.IListItemData
    public int getShowCount() {
        if (this.f34567b.getForCondition() != null) {
            return this.f34569d.size();
        }
        return this.f34572g ? 1 : 0;
    }

    public boolean isDataArr() {
        return this.f34570e;
    }

    @Override // com.huawei.quickcard.views.list.IListItemData
    public void update() {
        j0 forCondition = this.f34567b.getForCondition();
        p0 ifCondition = this.f34567b.getIfCondition();
        if (forCondition == null && ifCondition == null) {
            return;
        }
        if (forCondition == null) {
            this.f34572g = ifCondition.a(this.f34566a);
            return;
        }
        this.f34569d.clear();
        Object a10 = forCondition.a(this.f34566a);
        if (a10 instanceof CardDataObject) {
            CardDataObject cardDataObject = (CardDataObject) a10;
            this.f34570e = cardDataObject.isArray();
            this.f34571f = Arrays.asList(cardDataObject.keys());
            for (int i10 = 0; i10 < this.f34571f.size(); i10++) {
                if (ifCondition == null || ifCondition.a(this.f34566a)) {
                    this.f34569d.add(Integer.valueOf(i10));
                }
            }
        }
    }

    @Override // com.huawei.quickcard.views.list.IListItemData
    public void updateInsertIndex(int i10) {
        this.f34567b.updateInsertIndex(i10);
    }
}
