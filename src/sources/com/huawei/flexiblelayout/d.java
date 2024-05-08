package com.huawei.flexiblelayout;

import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.adapter.Visitor;
import com.huawei.flexiblelayout.b;
import com.huawei.flexiblelayout.card.FLCell;
import com.huawei.flexiblelayout.card.FLNode;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AllChildrenExpression.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class d implements b.a {

    /* renamed from: a, reason: collision with root package name */
    public static final d f28017a = new d();

    /* compiled from: AllChildrenExpression.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a implements Visitor {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FLCell f28018a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f28019b;

        public a(FLCell fLCell, List list) {
            this.f28018a = fLCell;
            this.f28019b = list;
        }

        @Override // com.huawei.flexiblelayout.adapter.Visitor
        public boolean onVisitCard(@NonNull FLCell<?> fLCell) {
            if (fLCell.getParent() != this.f28018a || this.f28019b.contains(fLCell)) {
                return true;
            }
            this.f28019b.add(fLCell);
            return true;
        }

        @Override // com.huawei.flexiblelayout.adapter.Visitor
        public boolean onVisitNode(@NonNull FLNode<?> fLNode) {
            if (fLNode.getParent() != this.f28018a || this.f28019b.contains(fLNode)) {
                return true;
            }
            this.f28019b.add(fLNode);
            return true;
        }
    }

    @Override // com.huawei.flexiblelayout.b.a
    @NonNull
    public List<FLCell<?>> a(@NonNull List<FLCell<?>> list) {
        ArrayList arrayList = new ArrayList();
        for (FLCell<?> fLCell : list) {
            fLCell.visit(new a(fLCell, arrayList));
        }
        return arrayList;
    }
}
