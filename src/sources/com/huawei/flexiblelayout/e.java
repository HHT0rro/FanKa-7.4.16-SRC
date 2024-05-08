package com.huawei.flexiblelayout;

import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.adapter.Visitor;
import com.huawei.flexiblelayout.b;
import com.huawei.flexiblelayout.card.FLCell;
import com.huawei.flexiblelayout.card.FLNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: AllDescendantsExpression.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class e implements b.a {

    /* renamed from: a, reason: collision with root package name */
    public static final e f28113a = new e();

    /* compiled from: AllDescendantsExpression.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a implements Visitor {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f28114a;

        public a(List list) {
            this.f28114a = list;
        }

        @Override // com.huawei.flexiblelayout.adapter.Visitor
        public boolean onVisitCard(@NonNull FLCell<?> fLCell) {
            if (this.f28114a.contains(fLCell)) {
                return true;
            }
            this.f28114a.add(fLCell);
            return true;
        }

        @Override // com.huawei.flexiblelayout.adapter.Visitor
        public boolean onVisitNode(@NonNull FLNode<?> fLNode) {
            if (this.f28114a.contains(fLNode)) {
                return true;
            }
            this.f28114a.add(fLNode);
            return true;
        }
    }

    @Override // com.huawei.flexiblelayout.b.a
    @NonNull
    public List<FLCell<?>> a(@NonNull List<FLCell<?>> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<FLCell<?>> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().visit(new a(arrayList));
        }
        return arrayList;
    }
}
