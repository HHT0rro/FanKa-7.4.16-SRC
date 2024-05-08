package com.huawei.flexiblelayout.view.recyclerview.layoutmanager;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.huawei.flexiblelayout.services.recyclerview.LayoutManagerExt;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: FLLayoutManagerFactroy.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, FLLayoutManager> f28660a;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        f28660a = linkedHashMap;
        linkedHashMap.put(GridLayoutManager.class.getName(), new c());
        linkedHashMap.put(LinearLayoutManager.class.getName(), new e());
        linkedHashMap.put(StaggeredGridLayoutManager.class.getName(), new f());
        linkedHashMap.put(LayoutManagerExt.class.getName(), new d());
    }

    public static FLLayoutManager a(@NonNull RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        FLLayoutManager fLLayoutManager = null;
        if (layoutManager != null) {
            Class<?> cls = layoutManager.getClass();
            String name = cls.getName();
            while (!RecyclerView.LayoutManager.class.getName().equals(name) && (fLLayoutManager = f28660a.get(name)) == null) {
                cls = cls.getSuperclass();
                name = cls.getName();
            }
        }
        return (fLLayoutManager == null && (recyclerView instanceof LayoutManagerExt)) ? f28660a.get(LayoutManagerExt.class.getName()) : fLLayoutManager;
    }
}
