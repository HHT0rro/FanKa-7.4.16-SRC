package com.huawei.flexiblelayout.layoutstrategy;

import com.huawei.flexiblelayout.FLEngine;
import com.huawei.flexiblelayout.adapter.ViewContainer;
import com.huawei.flexiblelayout.card.props.FLCardProps;
import com.huawei.flexiblelayout.data.FLCardData;
import com.huawei.flexiblelayout.layoutstrategy.container.ReactContainer;
import com.huawei.flexiblelayout.layoutstrategy.container.ReactLooseContainer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ReactLayoutStrategy implements GroupLayoutStrategy {

    /* renamed from: a, reason: collision with root package name */
    private final FLEngine f28196a;

    /* renamed from: b, reason: collision with root package name */
    private List<Integer> f28197b;

    /* renamed from: c, reason: collision with root package name */
    private int f28198c;

    /* renamed from: d, reason: collision with root package name */
    private String f28199d;

    /* renamed from: e, reason: collision with root package name */
    private int f28200e;

    /* renamed from: f, reason: collision with root package name */
    private final FLCardProps f28201f;

    /* renamed from: g, reason: collision with root package name */
    private int f28202g;

    /* renamed from: h, reason: collision with root package name */
    private LineBreakMode f28203h;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public enum LineBreakMode {
        loose,
        strict
    }

    public ReactLayoutStrategy(FLEngine fLEngine, FLCardProps fLCardProps) {
        this(fLEngine, fLCardProps, 0);
    }

    @Override // com.huawei.flexiblelayout.layoutstrategy.GroupLayoutStrategy
    public void clear() {
        this.f28197b.clear();
        this.f28198c = 0;
        this.f28199d = null;
        this.f28200e = 0;
    }

    @Override // com.huawei.flexiblelayout.layoutstrategy.GroupLayoutStrategy
    public ViewContainer createContainer() {
        if (this.f28203h == LineBreakMode.strict) {
            return new ReactContainer(this.f28196a.getCardSpecHelper().getCardNumbers(this.f28201f), this.f28202g);
        }
        return new ReactLooseContainer(this.f28196a.getCardSpecHelper().getCardNumbers(this.f28201f), this.f28202g);
    }

    @Override // com.huawei.flexiblelayout.layoutstrategy.GroupLayoutStrategy
    public String getIdentifier() {
        return this.f28201f.toString();
    }

    @Override // com.huawei.flexiblelayout.layoutstrategy.GroupLayoutStrategy
    public int getSize(int i10) {
        return this.f28197b.size();
    }

    @Override // com.huawei.flexiblelayout.layoutstrategy.GroupLayoutStrategy
    public int indexToPosition(int i10) {
        int i11 = 0;
        for (Integer num : this.f28197b) {
            if (num.intValue() == i10) {
                return i11;
            }
            if (num.intValue() > i10) {
                return i11 - 1;
            }
            i11++;
        }
        if (i11 == 0) {
            return 0;
        }
        return i11 - 1;
    }

    @Override // com.huawei.flexiblelayout.layoutstrategy.GroupLayoutStrategy
    public int positionToIndex(int i10) {
        return this.f28197b.get(i10).intValue();
    }

    public ReactLayoutStrategy setLineBreakMode(LineBreakMode lineBreakMode) {
        this.f28203h = lineBreakMode;
        return this;
    }

    @Override // com.huawei.flexiblelayout.layoutstrategy.GroupLayoutStrategy
    public void update(FLCardData fLCardData) {
        String reuseIdentifier = fLCardData.getReuseIdentifier();
        if (this.f28203h == LineBreakMode.strict && !reuseIdentifier.equals(this.f28199d)) {
            this.f28197b.add(Integer.valueOf(this.f28198c));
            this.f28200e = 0;
        } else if (this.f28203h == LineBreakMode.loose && this.f28199d == null) {
            this.f28197b.add(Integer.valueOf(this.f28198c));
        } else {
            int cardNumbers = this.f28196a.getCardSpecHelper().getCardNumbers(this.f28201f);
            if (cardNumbers == 1) {
                this.f28197b.add(Integer.valueOf(this.f28198c));
            } else {
                int i10 = this.f28200e + 1;
                this.f28200e = i10;
                if (i10 == cardNumbers) {
                    this.f28197b.add(Integer.valueOf(this.f28198c));
                    this.f28200e = 0;
                }
            }
        }
        this.f28199d = reuseIdentifier;
        this.f28198c++;
    }

    public ReactLayoutStrategy(FLEngine fLEngine, FLCardProps fLCardProps, int i10) {
        this.f28197b = new ArrayList();
        this.f28198c = 0;
        this.f28199d = null;
        this.f28200e = 0;
        this.f28203h = LineBreakMode.strict;
        this.f28201f = fLCardProps;
        this.f28196a = fLEngine;
        this.f28202g = i10;
    }

    @Override // com.huawei.flexiblelayout.layoutstrategy.GroupLayoutStrategy
    public void update(Collection<FLCardData> collection) {
        Iterator<FLCardData> iterator2 = collection.iterator2();
        while (iterator2.hasNext()) {
            update(iterator2.next());
        }
    }
}
