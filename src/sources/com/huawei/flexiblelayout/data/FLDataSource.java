package com.huawei.flexiblelayout.data;

import com.huawei.flexiblelayout.FLayout;
import com.huawei.flexiblelayout.card.props.CardSpecHelper;
import com.huawei.flexiblelayout.data.FLDataGroup;
import com.huawei.flexiblelayout.data.changed.FLDataChangedRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class FLDataSource implements c {

    /* renamed from: b, reason: collision with root package name */
    private FLayout f28063b;

    /* renamed from: a, reason: collision with root package name */
    private List<FLDataGroup> f28062a = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private CardSpecHelper.ScreenChangedObserver f28064c = new CardSpecHelper.ScreenChangedObserver() { // from class: com.huawei.flexiblelayout.data.j
        @Override // com.huawei.flexiblelayout.card.props.CardSpecHelper.ScreenChangedObserver
        public final void update() {
            FLDataSource.this.a();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a() {
        Iterator<FLDataGroup> iterator2 = this.f28062a.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().c();
        }
    }

    public static FLDataGroup findDataGroup(FLCardData fLCardData) {
        Object tag;
        do {
            tag = fLCardData.getTag(FLDataGroup.f28042k);
            fLCardData = fLCardData.getParent();
            if (tag != null) {
                break;
            }
        } while (fLCardData != null);
        if (tag instanceof FLDataGroup) {
            return (FLDataGroup) tag;
        }
        return null;
    }

    public void addGroup(FLDataGroup fLDataGroup) {
        fLDataGroup.a(this);
        this.f28062a.add(fLDataGroup);
        fLDataGroup.a();
    }

    public void bindLayout(FLayout fLayout) {
        FLayout fLayout2 = this.f28063b;
        if (fLayout2 != null) {
            fLayout2.getEngine().getCardSpecHelper().unregisterScreenChanged(this.f28064c);
        }
        this.f28063b = fLayout;
        if (fLayout != null) {
            fLayout.getEngine().getCardSpecHelper().registerScreenChanged(this.f28064c);
        }
    }

    public void clear() {
        while (this.f28062a.size() != 0) {
            removeGroup(this.f28062a.get(0));
        }
    }

    public int getAbsolutePosition(FLDataGroup fLDataGroup, int i10) {
        boolean z10;
        Iterator<FLDataGroup> iterator2 = this.f28062a.iterator2();
        while (true) {
            if (!iterator2.hasNext()) {
                z10 = false;
                break;
            }
            FLDataGroup next = iterator2.next();
            if (next == fLDataGroup) {
                z10 = true;
                break;
            }
            i10 += next.getSize();
        }
        if (z10) {
            return i10;
        }
        return -1;
    }

    public FLDataGroup.Cursor getCursor(int i10) {
        int i11 = 0;
        for (FLDataGroup fLDataGroup : this.f28062a) {
            int size = fLDataGroup.getSize();
            i11 += size;
            if (i10 < i11) {
                return fLDataGroup.a(i10 - (i11 - size));
            }
        }
        return null;
    }

    public FLNodeData getData(int i10) {
        FLDataGroup.Cursor cursor = getCursor(i10);
        if (cursor != null) {
            return cursor.current();
        }
        return null;
    }

    public FLDataGroup getDataGroupById(int i10) {
        for (FLDataGroup fLDataGroup : this.f28062a) {
            if (fLDataGroup.getId() == i10) {
                return fLDataGroup;
            }
        }
        return null;
    }

    public FLDataGroup getDataGroupByIndex(int i10) {
        return this.f28062a.get(i10);
    }

    public FLDataGroup getDataGroupByPosition(int i10) {
        FLDataGroup.Cursor cursor = getCursor(i10);
        if (cursor == null) {
            return null;
        }
        return cursor.getDataGroup();
    }

    public int getDataGroupSize() {
        return this.f28062a.size();
    }

    public FLayout getFLayout() {
        return this.f28063b;
    }

    public int getSize() {
        Iterator<FLDataGroup> iterator2 = this.f28062a.iterator2();
        int i10 = 0;
        while (iterator2.hasNext()) {
            i10 += iterator2.next().getSize();
        }
        return i10;
    }

    public void removeGroup(FLDataGroup fLDataGroup) {
        fLDataGroup.b();
        this.f28062a.remove(fLDataGroup);
        fLDataGroup.a((c) null);
    }

    @Override // com.huawei.flexiblelayout.data.c
    public void requestDataChanged(FLDataChangedRequest fLDataChangedRequest) {
        FLayout fLayout = this.f28063b;
        if (fLayout != null) {
            fLayout.requestDataChanged(fLDataChangedRequest);
        }
    }
}
