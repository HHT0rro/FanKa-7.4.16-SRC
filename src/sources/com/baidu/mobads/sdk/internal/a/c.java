package com.baidu.mobads.sdk.internal.a;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import com.baidu.mobads.sdk.internal.bs;
import com.baidu.mobads.sdk.internal.concrete.FragmentDelegate;
import com.baidu.mobads.sdk.internal.concrete.FragmentV4Delegate;
import com.baidu.mobads.sdk.internal.concrete.RLRecyclerViewDelegate;
import com.baidu.mobads.sdk.internal.concrete.RVAdapterDelegate;
import com.baidu.mobads.sdk.internal.concrete.RVViewHolderDelegate;
import com.baidu.mobads.sdk.internal.concrete.ViewCompatDelegate;
import com.baidu.mobads.sdk.internal.concrete.ViewPager2Delegate;
import com.baidu.mobads.sdk.internal.widget.ViewPager2;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class c implements com.baidu.mobads.sdk.internal.a.a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f9720a = "ViewPager2";

    /* renamed from: b, reason: collision with root package name */
    public static final String f9721b = "RVAdapter";

    /* renamed from: c, reason: collision with root package name */
    public static final String f9722c = "RVViewHolder";

    /* renamed from: d, reason: collision with root package name */
    public static final String f9723d = "ViewCompat";

    /* renamed from: e, reason: collision with root package name */
    public static final String f9724e = "Fragment";

    /* renamed from: f, reason: collision with root package name */
    public static final String f9725f = "FragmentV4";

    /* renamed from: g, reason: collision with root package name */
    public static final String f9726g = "RLRecyclerView";

    /* renamed from: h, reason: collision with root package name */
    public static final String f9727h = "p_e";

    /* renamed from: i, reason: collision with root package name */
    private static final String f9728i = "p_init";

    /* renamed from: j, reason: collision with root package name */
    private static final String f9729j = "p_set_class";

    /* renamed from: k, reason: collision with root package name */
    private static final String f9730k = "e_t";

    /* renamed from: l, reason: collision with root package name */
    private static final String f9731l = "e_n";

    /* renamed from: m, reason: collision with root package name */
    private static final String f9732m = "e_a";

    /* renamed from: n, reason: collision with root package name */
    private static final String f9733n = "e_r";

    /* renamed from: o, reason: collision with root package name */
    private static final String f9734o = "e_d";

    /* renamed from: p, reason: collision with root package name */
    private final IAdInterListener f9735p;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class a implements IOAdEventListener {
        private com.baidu.mobads.sdk.internal.a.a a(String str, @NonNull IAdInterListener iAdInterListener, Object[] objArr) {
            if (c.f9720a.equals(str) && c.a(objArr, (Class<?>[]) new Class[]{Context.class})) {
                return new ViewPager2Delegate(iAdInterListener, (Context) objArr[0]);
            }
            if (c.f9721b.equals(str)) {
                return new RVAdapterDelegate(iAdInterListener);
            }
            if (c.f9722c.equals(str) && c.a(objArr, (Class<?>[]) new Class[]{View.class})) {
                return new RVViewHolderDelegate(iAdInterListener, (View) objArr[0]);
            }
            if (c.f9723d.equals(str)) {
                return new ViewCompatDelegate(iAdInterListener);
            }
            if (c.f9724e.equals(str)) {
                return new FragmentDelegate().setDispatcher(iAdInterListener);
            }
            if (c.f9725f.equals(str)) {
                return new FragmentV4Delegate().setDispatcher(iAdInterListener);
            }
            if (c.f9726g.equals(str)) {
                return new RLRecyclerViewDelegate(iAdInterListener, objArr);
            }
            return null;
        }

        @Override // com.baidu.mobads.sdk.api.IOAdEventListener
        public void run(IOAdEvent iOAdEvent) {
            Map<String, Object> data;
            com.baidu.mobads.sdk.internal.a.a a10;
            if (iOAdEvent != null) {
                try {
                    if (c.f9727h.equals(iOAdEvent.getType()) && (data = iOAdEvent.getData()) != null && !data.isEmpty()) {
                        Object obj = data.get(c.f9730k);
                        Object obj2 = data.get(c.f9731l);
                        Object obj3 = data.get(c.f9732m);
                        Object[] objArr = obj3 instanceof Object[] ? (Object[]) obj3 : null;
                        if ((obj2 instanceof String) && (obj instanceof String)) {
                            if (c.f9728i.equals((String) obj2)) {
                                Object obj4 = data.get(c.f9734o);
                                if (!(obj4 instanceof IAdInterListener) || (a10 = a((String) obj, (IAdInterListener) obj4, objArr)) == null) {
                                    return;
                                }
                                data.put(c.f9733n, a10);
                                return;
                            }
                            if (c.f9729j.equals((String) obj2) && (obj3 instanceof Map)) {
                                Map map = (Map) obj3;
                                map.put(c.f9720a, ViewPager2.class);
                                map.put(c.f9721b, RecyclerView.Adapter.class);
                                map.put(c.f9722c, RecyclerView.ViewHolder.class);
                            }
                        }
                    }
                } catch (Throwable th) {
                    bs.a().b(th.getMessage());
                }
            }
        }
    }

    private c(@NonNull IAdInterListener iAdInterListener, @NonNull com.baidu.mobads.sdk.internal.a.a aVar) {
        this.f9735p = iAdInterListener;
        iAdInterListener.addEventListener(f9727h, new d(this, aVar));
    }

    public static c a(@NonNull IAdInterListener iAdInterListener, @NonNull com.baidu.mobads.sdk.internal.a.a aVar) {
        return new c(iAdInterListener, aVar);
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public int getCode() {
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Map<String, Object> getData() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    @NonNull
    public IAdInterListener getDelegator() {
        return this.f9735p;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getMessage() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Object getTarget() {
        return this.f9735p;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getType() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    public final Object handleEvent(String str, String str2, Object[] objArr) {
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public void setTarget(Object obj) {
    }

    public final void a(String str) {
        this.f9735p.onAdTaskProcess(str);
    }

    public final Object a(String str, Object... objArr) {
        HashMap hashMap = new HashMap();
        hashMap.put(f9732m, objArr);
        this.f9735p.onAdTaskProcess(str, hashMap);
        return hashMap.get(f9733n);
    }

    public static boolean a(Object[] objArr, Class<?>... clsArr) {
        boolean z10 = objArr == null || objArr.length == 0;
        boolean z11 = clsArr == null || clsArr.length == 0;
        if (z10 && z11) {
            return true;
        }
        if (z10 || z11 || clsArr == null || objArr == null || clsArr.length != objArr.length) {
            return false;
        }
        for (int i10 = 0; i10 < clsArr.length; i10++) {
            if (!clsArr[i10].isInstance(objArr[i10])) {
                return false;
            }
        }
        return true;
    }
}
