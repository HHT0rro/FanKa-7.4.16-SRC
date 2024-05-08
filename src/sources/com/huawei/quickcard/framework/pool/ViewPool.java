package com.huawei.quickcard.framework.pool;

import android.content.Context;
import android.view.View;
import com.huawei.quickcard.Cleanable;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.base.utils.CardThreadUtils;
import com.huawei.quickcard.framework.ui.Component;
import com.huawei.quickcard.framework.ui.ComponentRegistry;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Vector;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ViewPool implements Cleanable {

    /* renamed from: d, reason: collision with root package name */
    private static final a[] f33855d = {new a(Attributes.Component.DIV, 4), new a("text", 4), new a(Attributes.Component.IMAGE, 2)};

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, Queue<View>> f33856a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final Vector<String> f33857b = new Vector<>(5);

    /* renamed from: c, reason: collision with root package name */
    private final Context f33858c;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f33859a;

        /* renamed from: b, reason: collision with root package name */
        public int f33860b;

        public a(String str, int i10) {
            this.f33859a = str;
            this.f33860b = i10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final Context f33861a;

        /* renamed from: b, reason: collision with root package name */
        private final String f33862b;

        public b(Context context, String str) {
            this.f33861a = context;
            this.f33862b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            while (ViewPool.this.b(this.f33862b) < ViewPool.f(this.f33862b)) {
                ViewPool viewPool = ViewPool.this;
                String str = this.f33862b;
                viewPool.a(str, ViewPool.b(this.f33861a, str));
            }
            ViewPool.this.f33857b.remove(this.f33862b);
        }
    }

    public ViewPool(Context context) {
        this.f33858c = context;
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(String str) {
        Queue<View> queue = this.f33856a.get(str);
        if (queue != null) {
            return queue.size();
        }
        return 0;
    }

    private View c(String str) {
        Queue<View> queue = this.f33856a.get(str);
        if (queue != null) {
            return queue.poll();
        }
        return null;
    }

    private boolean d(String str) {
        for (a aVar : f33855d) {
            if (aVar.f33859a.equals(str)) {
                return true;
            }
        }
        return false;
    }

    private void e(String str) {
        if (this.f33857b.contains(str)) {
            return;
        }
        this.f33857b.add(str);
        CardThreadUtils.get().worker().execute(new b(this.f33858c, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int f(String str) {
        for (a aVar : f33855d) {
            if (aVar.f33859a.equals(str)) {
                return aVar.f33860b;
            }
        }
        return 0;
    }

    public View getView(String str) {
        if (!d(str)) {
            return b(this.f33858c, str);
        }
        if (b(str) < f(str) / 2) {
            e(str);
        }
        View c4 = c(str);
        return c4 != null ? c4 : b(this.f33858c, str);
    }

    @Override // com.huawei.quickcard.Cleanable
    public void release() {
        Iterator<Map.Entry<String, Queue<View>>> iterator2 = this.f33856a.entrySet().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().getValue().clear();
        }
        this.f33856a.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static View b(Context context, String str) {
        Component component = ComponentRegistry.get(str);
        if (component == null && (component = ComponentRegistry.get(Attributes.Component.DIV)) == null) {
            return new View(context);
        }
        return component.createView(context);
    }

    private void a() {
        for (a aVar : f33855d) {
            String str = aVar.f33859a;
            this.f33856a.put(str, new ConcurrentLinkedQueue());
            e(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, View view) {
        Queue<View> queue = this.f33856a.get(str);
        if (queue == null) {
            queue = new LinkedList<>();
            this.f33856a.put(str, queue);
        }
        queue.add(view);
    }
}
