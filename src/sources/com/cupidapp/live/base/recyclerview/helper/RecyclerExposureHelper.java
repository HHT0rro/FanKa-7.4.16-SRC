package com.cupidapp.live.base.recyclerview.helper;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.recyclerview.helper.RecyclerExposureHelper;
import com.cupidapp.live.base.utils.j;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: RecyclerExposureHelper.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class RecyclerExposureHelper {

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public static final a f12092j = new a(null);

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public static final EnumMap<ExposureScene, Integer> f12093k = new EnumMap<>(ExposureScene.class);

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final ExposureScene f12094a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final RecyclerView f12095b;

    /* renamed from: c, reason: collision with root package name */
    public final float f12096c;

    /* renamed from: d, reason: collision with root package name */
    public final long f12097d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public final String f12098e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final Function1<List<h1.a>, p> f12099f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public final List<h1.a> f12100g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public final List<h1.a> f12101h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public final List<String> f12102i;

    /* compiled from: RecyclerExposureHelper.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ boolean b(a aVar, View view, boolean z10, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                z10 = false;
            }
            return aVar.a(view, z10);
        }

        public final boolean a(@NotNull View view, boolean z10) {
            s.i(view, "view");
            if (view.getGlobalVisibleRect(new Rect())) {
                if (z10) {
                    if (r0.width() >= view.getMeasuredWidth() * 0.5f) {
                        j.f12332a.a("RecyclerExposureHelper", "达到曝光条件");
                        return true;
                    }
                } else if (r0.height() >= view.getMeasuredHeight() * 0.5f) {
                    j.f12332a.a("RecyclerExposureHelper", "达到曝光条件");
                    return true;
                }
            }
            j.f12332a.a("RecyclerExposureHelper", "未达到曝光条件");
            return false;
        }

        public final void c(@NotNull ExposureScene scene) {
            s.i(scene, "scene");
            RecyclerExposureHelper.f12093k.remove(scene);
        }

        public final void d(@NotNull ExposureScene scene) {
            s.i(scene, "scene");
            Integer num = (Integer) RecyclerExposureHelper.f12093k.get(scene);
            if (num == null) {
                num = 0;
            }
            RecyclerExposureHelper.f12093k.put((EnumMap) scene, (ExposureScene) Integer.valueOf(num.intValue() + 1));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RecyclerExposureHelper(@NotNull ExposureScene exposureScene, @NotNull RecyclerView recyclerView, float f10, long j10, @Nullable String str, @NotNull Function1<? super List<h1.a>, p> callback) {
        s.i(exposureScene, "exposureScene");
        s.i(recyclerView, "recyclerView");
        s.i(callback, "callback");
        this.f12094a = exposureScene;
        this.f12095b = recyclerView;
        this.f12096c = f10;
        this.f12097d = j10;
        this.f12098e = str;
        this.f12099f = callback;
        this.f12100g = new ArrayList();
        this.f12101h = new ArrayList();
        this.f12102i = new ArrayList();
        f12092j.d(exposureScene);
        recyclerView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: h1.b
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                RecyclerExposureHelper.b(RecyclerExposureHelper.this, view, i10, i11, i12, i13, i14, i15, i16, i17);
            }
        });
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.cupidapp.live.base.recyclerview.helper.RecyclerExposureHelper.2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NotNull RecyclerView recyclerView2, int i10) {
                s.i(recyclerView2, "recyclerView");
                if (i10 == 0) {
                    RecyclerExposureHelper.this.d();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NotNull RecyclerView recyclerView2, int i10, int i11) {
                s.i(recyclerView2, "recyclerView");
                RecyclerExposureHelper.this.j();
                if (i10 == 0 && i11 == 0) {
                    RecyclerExposureHelper.this.d();
                }
            }
        });
    }

    public static final void b(RecyclerExposureHelper this$0, View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        s.i(this$0, "this$0");
        this$0.j();
        this$0.d();
    }

    public final void d() {
        List<h1.a> f10 = f();
        if (!f10.isEmpty()) {
            this.f12099f.invoke(f10);
        }
    }

    public final boolean e(h1.a aVar) {
        Rect rect = new Rect();
        View c4 = aVar.c();
        if (c4 == null || !c4.getGlobalVisibleRect(rect)) {
            return false;
        }
        return h(this.f12095b.getLayoutManager()) ? ((float) rect.width()) >= ((float) c4.getMeasuredWidth()) * this.f12096c : ((float) rect.height()) >= ((float) c4.getMeasuredHeight()) * this.f12096c;
    }

    public final List<h1.a> f() {
        ArrayList arrayList = new ArrayList();
        Iterator<h1.a> iterator2 = this.f12101h.iterator2();
        while (iterator2.hasNext()) {
            h1.a next = iterator2.next();
            if (next.b() != 0) {
                if (next.b() - next.e() >= this.f12097d) {
                    g(arrayList, next);
                }
                iterator2.remove();
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - next.e() >= this.f12097d) {
                    next.g(currentTimeMillis);
                    g(arrayList, next);
                    iterator2.remove();
                }
            }
        }
        return arrayList;
    }

    public final void g(List<h1.a> list, h1.a aVar) {
        String str;
        Integer num = f12093k.get(this.f12094a);
        if (num == null) {
            num = 0;
        }
        int intValue = num.intValue();
        String str2 = this.f12098e;
        if (str2 == null || str2.length() == 0) {
            str = aVar.d() + "_" + intValue;
        } else {
            str = aVar.d() + "_" + intValue + "_" + this.f12098e;
        }
        if (this.f12102i.contains(str)) {
            return;
        }
        list.add(aVar);
        this.f12102i.add(str);
    }

    public final boolean h(RecyclerView.LayoutManager layoutManager) {
        return ((layoutManager instanceof LinearLayoutManager) && ((LinearLayoutManager) layoutManager).getOrientation() == 0) || ((layoutManager instanceof StaggeredGridLayoutManager) && ((StaggeredGridLayoutManager) layoutManager).getOrientation() == 0);
    }

    public final void i() {
        j();
        d();
    }

    public final void j() {
        Iterator<h1.a> iterator2 = this.f12100g.iterator2();
        while (iterator2.hasNext()) {
            h1.a next = iterator2.next();
            if (e(next)) {
                if (next.e() == 0) {
                    next.j(System.currentTimeMillis());
                }
                this.f12101h.add(next);
                iterator2.remove();
            }
        }
    }

    public final void k(@NotNull FKBaseRecyclerViewHolder holder) {
        s.i(holder, "holder");
        h1.a aVar = new h1.a();
        aVar.h(holder.itemView);
        aVar.i(holder.getBindingAdapterPosition());
        aVar.f(holder.o());
        this.f12100g.add(aVar);
        if (e(aVar)) {
            aVar.j(System.currentTimeMillis());
        }
    }

    public final void l(@NotNull FKBaseRecyclerViewHolder holder) {
        s.i(holder, "holder");
        Iterator<h1.a> iterator2 = this.f12100g.iterator2();
        while (iterator2.hasNext()) {
            h1.a next = iterator2.next();
            if (holder.getBindingAdapterPosition() == next.d() && s.d(holder.itemView, next.c())) {
                iterator2.remove();
            }
        }
        for (h1.a aVar : this.f12101h) {
            if (holder.getBindingAdapterPosition() == aVar.d() && s.d(holder.itemView, aVar.c())) {
                aVar.g(System.currentTimeMillis());
            }
        }
    }

    public /* synthetic */ RecyclerExposureHelper(ExposureScene exposureScene, RecyclerView recyclerView, float f10, long j10, String str, Function1 function1, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(exposureScene, recyclerView, (i10 & 4) != 0 ? 0.5f : f10, (i10 & 8) != 0 ? 0L : j10, (i10 & 16) != 0 ? "" : str, function1);
    }
}
