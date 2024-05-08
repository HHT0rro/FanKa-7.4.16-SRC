package com.huawei.flexiblelayout;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.b;
import com.huawei.flexiblelayout.card.FLCell;
import com.huawei.flexiblelayout.data.FLCardData;
import java.util.ArrayList;
import java.util.List;

/* compiled from: PropertyPredicate.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class l implements b.InterfaceC0264b {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final String f28185a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    private final String f28186b;

    public l(@NonNull String str, @NonNull String str2) {
        this.f28185a = str;
        this.f28186b = str2;
    }

    @Override // com.huawei.flexiblelayout.b.InterfaceC0264b
    @NonNull
    public List<FLCell<?>> a(@NonNull List<FLCell<?>> list) {
        ArrayList arrayList = new ArrayList();
        for (FLCell<?> fLCell : list) {
            if (fLCell.getData() instanceof FLCardData) {
                FLCardData fLCardData = (FLCardData) fLCell.getData();
                if ("id".equals(this.f28185a) && TextUtils.equals(this.f28186b, fLCardData.getId())) {
                    arrayList.add(fLCell);
                }
            }
        }
        return arrayList;
    }
}
