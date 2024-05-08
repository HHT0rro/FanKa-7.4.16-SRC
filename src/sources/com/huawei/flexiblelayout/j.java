package com.huawei.flexiblelayout;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.b;
import com.huawei.flexiblelayout.card.FLCell;
import com.huawei.flexiblelayout.card.FLNode;
import com.huawei.flexiblelayout.data.FLCardData;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TypeExpression.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class j implements b.a {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final String f28152a;

    public j(@NonNull String str) {
        this.f28152a = str;
    }

    @Override // com.huawei.flexiblelayout.b.a
    @NonNull
    public List<FLCell<?>> a(@NonNull List<FLCell<?>> list) {
        ArrayList arrayList = new ArrayList();
        for (FLCell<?> fLCell : list) {
            if (fLCell instanceof FLNode) {
                FLNode fLNode = (FLNode) fLCell;
                for (int i10 = 0; i10 < fLNode.getChildCount(); i10++) {
                    FLCell<FLCardData> childAt = fLNode.getChildAt(i10);
                    if (TextUtils.equals(this.f28152a, childAt.getType())) {
                        arrayList.add(childAt);
                    }
                }
            }
        }
        return arrayList;
    }
}
