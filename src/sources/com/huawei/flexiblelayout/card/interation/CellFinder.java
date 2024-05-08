package com.huawei.flexiblelayout.card.interation;

import android.text.TextUtils;
import android.util.LruCache;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.flexiblelayout.b;
import com.huawei.flexiblelayout.card.FLCell;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.flexiblelayout.parser.expr.ExprException;
import java.util.Collections;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class CellFinder {

    /* renamed from: b, reason: collision with root package name */
    private static final String f27850b = "CellFinder";

    /* renamed from: c, reason: collision with root package name */
    private static final LruCache<String, b> f27851c = new LruCache<>(10);

    /* renamed from: a, reason: collision with root package name */
    private final FLCell<?> f27852a;

    public CellFinder(FLCell<?> fLCell) {
        if (fLCell != null) {
            this.f27852a = fLCell;
            return;
        }
        throw new IllegalArgumentException("Expected non-null FLCell params");
    }

    @NonNull
    public List<FLCell<?>> findAllByXPath(@NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            return Collections.emptyList();
        }
        LruCache<String, b> lruCache = f27851c;
        b bVar = lruCache.get(str);
        if (bVar == null) {
            bVar = new b(str);
            lruCache.put(str, bVar);
        }
        try {
            return bVar.a(Collections.singletonList(this.f27852a));
        } catch (ExprException e2) {
            Log.e(f27850b, "findAllByXPath failed, e = " + e2.getMessage());
            return Collections.emptyList();
        }
    }

    @Nullable
    public FLCell<?> findByXPath(@NonNull String str) {
        List<FLCell<?>> findAllByXPath = findAllByXPath(str);
        if (findAllByXPath.isEmpty()) {
            return null;
        }
        return findAllByXPath.get(0);
    }
}
