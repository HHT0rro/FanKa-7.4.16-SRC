package com.cupidapp.live.liveshow.view.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$color;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.utils.l;
import com.cupidapp.live.liveshow.model.LiveFunctionMenuListModel;
import com.cupidapp.live.liveshow.model.LiveFunctionMenuModel;
import com.cupidapp.live.liveshow.model.LiveFunctionMenuType;
import com.cupidapp.live.liveshow.view.menu.LiveFunctionMenuLayout;
import com.cupidapp.live.track.group.GroupLiveLog;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.c;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: LiveFunctionMenuLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveFunctionMenuLayout extends FrameLayout {

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public static final a f15734g = new a(null);

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public static LiveFunctionMenuLayout f15735h;

    /* renamed from: i, reason: collision with root package name */
    public static boolean f15736i;

    /* renamed from: b, reason: collision with root package name */
    public boolean f15737b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final Lazy f15738c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final Lazy f15739d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final Lazy f15740e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15741f;

    /* compiled from: LiveFunctionMenuLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a() {
            LiveFunctionMenuLayout liveFunctionMenuLayout = LiveFunctionMenuLayout.f15735h;
            if (liveFunctionMenuLayout != null) {
                liveFunctionMenuLayout.l();
            }
        }

        public final void b(@Nullable Context context, @Nullable View view, boolean z10, @NotNull List<LiveFunctionMenuListModel> menuList) {
            s.i(menuList, "menuList");
            if (context == null || view == null || LiveFunctionMenuLayout.f15736i) {
                return;
            }
            LiveFunctionMenuLayout.f15736i = true;
            LiveFunctionMenuLayout liveFunctionMenuLayout = new LiveFunctionMenuLayout(context);
            liveFunctionMenuLayout.k(menuList, z10);
            LiveFunctionMenuLayout.f15735h = liveFunctionMenuLayout;
            LiveFunctionMenuLayout liveFunctionMenuLayout2 = LiveFunctionMenuLayout.f15735h;
            if (liveFunctionMenuLayout2 != null) {
                liveFunctionMenuLayout2.o(view);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveFunctionMenuLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15741f = new LinkedHashMap();
        this.f15738c = c.b(new Function0<LiveFunctionMenuAdapter>() { // from class: com.cupidapp.live.liveshow.view.menu.LiveFunctionMenuLayout$menuAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LiveFunctionMenuAdapter invoke() {
                LiveFunctionMenuAdapter liveFunctionMenuAdapter = new LiveFunctionMenuAdapter();
                final LiveFunctionMenuLayout liveFunctionMenuLayout = LiveFunctionMenuLayout.this;
                liveFunctionMenuAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.view.menu.LiveFunctionMenuLayout$menuAdapter$2$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Object obj) {
                        invoke2(obj);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Object obj) {
                        if (obj instanceof LiveFunctionMenuModel) {
                            LiveFunctionMenuLayout.this.l();
                            LiveFunctionMenuModel liveFunctionMenuModel = (LiveFunctionMenuModel) obj;
                            j.a.b(j.f12156c, LiveFunctionMenuLayout.this.getContext(), liveFunctionMenuModel.getPath(), null, 4, null);
                            LiveFunctionMenuLayout.this.j(liveFunctionMenuModel.getPoint());
                        }
                    }
                });
                liveFunctionMenuAdapter.y(new Function1<LiveFunctionMenuModel, p>() { // from class: com.cupidapp.live.liveshow.view.menu.LiveFunctionMenuLayout$menuAdapter$2$1$2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(LiveFunctionMenuModel liveFunctionMenuModel) {
                        invoke2(liveFunctionMenuModel);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull LiveFunctionMenuModel model) {
                        s.i(model, "model");
                        LiveFunctionMenuLayout.this.l();
                        j.a.b(j.f12156c, LiveFunctionMenuLayout.this.getContext(), model.getPath(), null, 4, null);
                        LiveFunctionMenuLayout.this.j(model.getPoint());
                    }
                });
                return liveFunctionMenuAdapter;
            }
        });
        this.f15739d = c.b(LiveFunctionMenuLayout$popupWindowWrapper$2.INSTANCE);
        this.f15740e = c.b(new Function0<View>() { // from class: com.cupidapp.live.liveshow.view.menu.LiveFunctionMenuLayout$alphaBgView$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final View invoke() {
                View view = new View(LiveFunctionMenuLayout.this.getContext());
                view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                view.setBackgroundResource(R$color.app_black_45_alpha);
                return view;
            }
        });
        m();
    }

    private final View getAlphaBgView() {
        return (View) this.f15740e.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LiveFunctionMenuAdapter getMenuAdapter() {
        return (LiveFunctionMenuAdapter) this.f15738c.getValue();
    }

    private final l getPopupWindowWrapper() {
        return (l) this.f15739d.getValue();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f15741f;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public final void j(String str) {
        if (this.f15737b) {
            GroupLiveLog.f18698a.s(str);
        } else {
            GroupLiveLog.f18698a.p(str);
        }
    }

    public final void k(List<LiveFunctionMenuListModel> list, boolean z10) {
        this.f15737b = z10;
        getMenuAdapter().j().clear();
        for (LiveFunctionMenuListModel liveFunctionMenuListModel : list) {
            String title = liveFunctionMenuListModel.getTitle();
            if (!(title == null || title.length() == 0)) {
                getMenuAdapter().d(new MenuTitleModel(liveFunctionMenuListModel.getTitle()));
            }
            String type = liveFunctionMenuListModel.getType();
            if (s.d(type, LiveFunctionMenuType.RectangleType.getType())) {
                getMenuAdapter().d(liveFunctionMenuListModel);
            } else if (s.d(type, LiveFunctionMenuType.SquareType.getType())) {
                getMenuAdapter().e(liveFunctionMenuListModel.getMenus());
            }
        }
        getMenuAdapter().notifyDataSetChanged();
    }

    public final void l() {
        getPopupWindowWrapper().d();
    }

    public final void m() {
        z.a(this, R$layout.layout_live_function_menu, true);
        RecyclerView recyclerView = (RecyclerView) a(R$id.menu_recyclerview);
        recyclerView.setAdapter(getMenuAdapter());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(recyclerView.getContext(), getMenuAdapter().v());
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.cupidapp.live.liveshow.view.menu.LiveFunctionMenuLayout$initView$1$1$1
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i10) {
                LiveFunctionMenuAdapter menuAdapter;
                menuAdapter = LiveFunctionMenuLayout.this.getMenuAdapter();
                return menuAdapter.u(i10);
            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0034, code lost:
    
        if ((r2.indexOfChild(getAlphaBgView()) != -1) == true) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void n(boolean r11, int r12) {
        /*
            r10 = this;
            android.content.Context r0 = r10.getContext()
            boolean r1 = r0 instanceof android.app.Activity
            r2 = 0
            if (r1 == 0) goto Lc
            android.app.Activity r0 = (android.app.Activity) r0
            goto Ld
        Lc:
            r0 = r2
        Ld:
            if (r0 == 0) goto L1a
            android.view.Window r0 = r0.getWindow()
            if (r0 == 0) goto L1a
            android.view.View r0 = r0.getDecorView()
            goto L1b
        L1a:
            r0 = r2
        L1b:
            boolean r1 = r0 instanceof android.view.ViewGroup
            if (r1 == 0) goto L22
            r2 = r0
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
        L22:
            r0 = 1
            r1 = 0
            if (r2 == 0) goto L37
            android.view.View r3 = r10.getAlphaBgView()
            int r3 = r2.indexOfChild(r3)
            r4 = -1
            if (r3 == r4) goto L33
            r3 = 1
            goto L34
        L33:
            r3 = 0
        L34:
            if (r3 != r0) goto L37
            goto L38
        L37:
            r0 = 0
        L38:
            if (r0 == 0) goto L41
            android.view.View r0 = r10.getAlphaBgView()
            r2.removeView(r0)
        L41:
            if (r11 == 0) goto L5d
            if (r2 == 0) goto L4c
            android.view.View r11 = r10.getAlphaBgView()
            r2.addView(r11)
        L4c:
            android.view.View r3 = r10.getAlphaBgView()
            r4 = 0
            java.lang.Integer r5 = java.lang.Integer.valueOf(r12)
            r6 = 0
            r7 = 0
            r8 = 13
            r9 = 0
            z0.y.m(r3, r4, r5, r6, r7, r8, r9)
        L5d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.liveshow.view.menu.LiveFunctionMenuLayout.n(boolean, int):void");
    }

    public final void o(@NotNull View anchorView) {
        s.i(anchorView, "anchorView");
        final int height = anchorView.getHeight();
        getPopupWindowWrapper().e(this, -1, -2).h(new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.menu.LiveFunctionMenuLayout$showMenuLayout$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ p invoke() {
                invoke2();
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                LiveFunctionMenuLayout.a aVar = LiveFunctionMenuLayout.f15734g;
                LiveFunctionMenuLayout.f15736i = false;
                LiveFunctionMenuLayout.this.n(false, height);
            }
        }).i(anchorView, 0, 0);
        n(true, height);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveFunctionMenuLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15741f = new LinkedHashMap();
        this.f15738c = c.b(new Function0<LiveFunctionMenuAdapter>() { // from class: com.cupidapp.live.liveshow.view.menu.LiveFunctionMenuLayout$menuAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LiveFunctionMenuAdapter invoke() {
                LiveFunctionMenuAdapter liveFunctionMenuAdapter = new LiveFunctionMenuAdapter();
                final LiveFunctionMenuLayout liveFunctionMenuLayout = LiveFunctionMenuLayout.this;
                liveFunctionMenuAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.view.menu.LiveFunctionMenuLayout$menuAdapter$2$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Object obj) {
                        invoke2(obj);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Object obj) {
                        if (obj instanceof LiveFunctionMenuModel) {
                            LiveFunctionMenuLayout.this.l();
                            LiveFunctionMenuModel liveFunctionMenuModel = (LiveFunctionMenuModel) obj;
                            j.a.b(j.f12156c, LiveFunctionMenuLayout.this.getContext(), liveFunctionMenuModel.getPath(), null, 4, null);
                            LiveFunctionMenuLayout.this.j(liveFunctionMenuModel.getPoint());
                        }
                    }
                });
                liveFunctionMenuAdapter.y(new Function1<LiveFunctionMenuModel, p>() { // from class: com.cupidapp.live.liveshow.view.menu.LiveFunctionMenuLayout$menuAdapter$2$1$2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(LiveFunctionMenuModel liveFunctionMenuModel) {
                        invoke2(liveFunctionMenuModel);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull LiveFunctionMenuModel model) {
                        s.i(model, "model");
                        LiveFunctionMenuLayout.this.l();
                        j.a.b(j.f12156c, LiveFunctionMenuLayout.this.getContext(), model.getPath(), null, 4, null);
                        LiveFunctionMenuLayout.this.j(model.getPoint());
                    }
                });
                return liveFunctionMenuAdapter;
            }
        });
        this.f15739d = c.b(LiveFunctionMenuLayout$popupWindowWrapper$2.INSTANCE);
        this.f15740e = c.b(new Function0<View>() { // from class: com.cupidapp.live.liveshow.view.menu.LiveFunctionMenuLayout$alphaBgView$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final View invoke() {
                View view = new View(LiveFunctionMenuLayout.this.getContext());
                view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                view.setBackgroundResource(R$color.app_black_45_alpha);
                return view;
            }
        });
        m();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveFunctionMenuLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15741f = new LinkedHashMap();
        this.f15738c = c.b(new Function0<LiveFunctionMenuAdapter>() { // from class: com.cupidapp.live.liveshow.view.menu.LiveFunctionMenuLayout$menuAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LiveFunctionMenuAdapter invoke() {
                LiveFunctionMenuAdapter liveFunctionMenuAdapter = new LiveFunctionMenuAdapter();
                final LiveFunctionMenuLayout liveFunctionMenuLayout = LiveFunctionMenuLayout.this;
                liveFunctionMenuAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.view.menu.LiveFunctionMenuLayout$menuAdapter$2$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Object obj) {
                        invoke2(obj);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Object obj) {
                        if (obj instanceof LiveFunctionMenuModel) {
                            LiveFunctionMenuLayout.this.l();
                            LiveFunctionMenuModel liveFunctionMenuModel = (LiveFunctionMenuModel) obj;
                            j.a.b(j.f12156c, LiveFunctionMenuLayout.this.getContext(), liveFunctionMenuModel.getPath(), null, 4, null);
                            LiveFunctionMenuLayout.this.j(liveFunctionMenuModel.getPoint());
                        }
                    }
                });
                liveFunctionMenuAdapter.y(new Function1<LiveFunctionMenuModel, p>() { // from class: com.cupidapp.live.liveshow.view.menu.LiveFunctionMenuLayout$menuAdapter$2$1$2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(LiveFunctionMenuModel liveFunctionMenuModel) {
                        invoke2(liveFunctionMenuModel);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull LiveFunctionMenuModel model) {
                        s.i(model, "model");
                        LiveFunctionMenuLayout.this.l();
                        j.a.b(j.f12156c, LiveFunctionMenuLayout.this.getContext(), model.getPath(), null, 4, null);
                        LiveFunctionMenuLayout.this.j(model.getPoint());
                    }
                });
                return liveFunctionMenuAdapter;
            }
        });
        this.f15739d = c.b(LiveFunctionMenuLayout$popupWindowWrapper$2.INSTANCE);
        this.f15740e = c.b(new Function0<View>() { // from class: com.cupidapp.live.liveshow.view.menu.LiveFunctionMenuLayout$alphaBgView$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final View invoke() {
                View view = new View(LiveFunctionMenuLayout.this.getContext());
                view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                view.setBackgroundResource(R$color.app_black_45_alpha);
                return view;
            }
        });
        m();
    }
}
