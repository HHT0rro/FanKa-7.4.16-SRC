package com.huawei.flexiblelayout;

import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.card.FLCell;
import com.huawei.flexiblelayout.parser.expr.ExprException;
import java.util.Collections;
import java.util.List;

/* compiled from: XPath.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final c f27726a;

    /* compiled from: XPath.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface a {
        @NonNull
        List<FLCell<?>> a(@NonNull List<FLCell<?>> list);
    }

    /* compiled from: XPath.java */
    /* renamed from: com.huawei.flexiblelayout.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface InterfaceC0264b {
        @NonNull
        List<FLCell<?>> a(@NonNull List<FLCell<?>> list);
    }

    public b(@NonNull String str) {
        this.f27726a = new c(str);
    }

    @NonNull
    public List<FLCell<?>> a(@NonNull List<FLCell<?>> list) throws ExprException {
        for (a aVar : this.f27726a.a()) {
            if (!list.isEmpty()) {
                list = aVar.a(list);
            } else {
                return Collections.emptyList();
            }
        }
        return list;
    }
}
