package com.cupidapp.live.feed.layout;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.viewpager2.widget.ViewPager2;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.sensorslog.FKSensorContext;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.base.view.dialog.ActionSheetItemType;
import com.cupidapp.live.base.view.dialog.FKActionSheetDialog;
import com.cupidapp.live.base.view.dialog.FKActionSheetItemModel;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.base.view.indicator.TopIndicatorLayout;
import com.cupidapp.live.feed.adapter.PostLimitPagerAdapter;
import com.cupidapp.live.feed.model.PostLimitDetailModel;
import com.cupidapp.live.profile.model.User;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.i0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PostLimitPagerLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class PostLimitPagerLayout extends ClickChangePageLayout {

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    public p f14550l;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    public j f14551m;

    /* renamed from: n, reason: collision with root package name */
    @Nullable
    public FKSensorContext f14552n;

    /* renamed from: o, reason: collision with root package name */
    public int f14553o;

    /* renamed from: p, reason: collision with root package name */
    @NotNull
    public final Lazy f14554p;

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14555q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostLimitPagerLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14555q = new LinkedHashMap();
        this.f14554p = kotlin.c.b(new Function0<PostLimitPagerAdapter>() { // from class: com.cupidapp.live.feed.layout.PostLimitPagerLayout$adapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final PostLimitPagerAdapter invoke() {
                FKSensorContext fKSensorContext;
                fKSensorContext = PostLimitPagerLayout.this.f14552n;
                PostLimitPagerAdapter postLimitPagerAdapter = new PostLimitPagerAdapter(fKSensorContext);
                final PostLimitPagerLayout postLimitPagerLayout = PostLimitPagerLayout.this;
                postLimitPagerAdapter.l().j(i0.h(kotlin.f.a(Integer.valueOf(R$id.post_viewer_rl), new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.feed.layout.PostLimitPagerLayout$adapter$2$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                        invoke2(obj);
                        return kotlin.p.f51048a;
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:3:0x0004, code lost:
                    
                        r0 = r1.f14550l;
                     */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final void invoke2(@org.jetbrains.annotations.Nullable java.lang.Object r2) {
                        /*
                            r1 = this;
                            boolean r0 = r2 instanceof com.cupidapp.live.feed.model.PostLimitDetailModel
                            if (r0 == 0) goto L15
                            com.cupidapp.live.feed.layout.PostLimitPagerLayout r0 = com.cupidapp.live.feed.layout.PostLimitPagerLayout.this
                            com.cupidapp.live.feed.layout.p r0 = com.cupidapp.live.feed.layout.PostLimitPagerLayout.m(r0)
                            if (r0 == 0) goto L15
                            com.cupidapp.live.feed.model.PostLimitDetailModel r2 = (com.cupidapp.live.feed.model.PostLimitDetailModel) r2
                            java.lang.String r2 = r2.getId()
                            r0.J(r2)
                        L15:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.feed.layout.PostLimitPagerLayout$adapter$2$1$1.invoke2(java.lang.Object):void");
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.post_close_view), new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.feed.layout.PostLimitPagerLayout$adapter$2$1$2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                        invoke2(obj);
                        return kotlin.p.f51048a;
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:3:0x0004, code lost:
                    
                        r1 = r1.f14550l;
                     */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final void invoke2(@org.jetbrains.annotations.Nullable java.lang.Object r1) {
                        /*
                            r0 = this;
                            boolean r1 = r1 instanceof com.cupidapp.live.feed.model.PostLimitDetailModel
                            if (r1 == 0) goto Lf
                            com.cupidapp.live.feed.layout.PostLimitPagerLayout r1 = com.cupidapp.live.feed.layout.PostLimitPagerLayout.this
                            com.cupidapp.live.feed.layout.p r1 = com.cupidapp.live.feed.layout.PostLimitPagerLayout.m(r1)
                            if (r1 == 0) goto Lf
                            r1.q()
                        Lf:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.feed.layout.PostLimitPagerLayout$adapter$2$1$2.invoke2(java.lang.Object):void");
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.viewer_post_more), new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.feed.layout.PostLimitPagerLayout$adapter$2$1$3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                        invoke2(obj);
                        return kotlin.p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Object obj) {
                        if (obj instanceof PostLimitDetailModel) {
                            PostLimitPagerLayout.this.t(((PostLimitDetailModel) obj).getId());
                        }
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.more_img), new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.feed.layout.PostLimitPagerLayout$adapter$2$1$4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                        invoke2(obj);
                        return kotlin.p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Object obj) {
                        if (obj instanceof PostLimitDetailModel) {
                            PostLimitPagerLayout.this.u(((PostLimitDetailModel) obj).getId());
                        }
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.publish_limit_post), new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.feed.layout.PostLimitPagerLayout$adapter$2$1$5
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                        invoke2(obj);
                        return kotlin.p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Object obj) {
                        p pVar;
                        pVar = PostLimitPagerLayout.this.f14550l;
                        if (pVar != null) {
                            pVar.G();
                        }
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.post_concern_button), new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.feed.layout.PostLimitPagerLayout$adapter$2$1$6
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                        invoke2(obj);
                        return kotlin.p.f51048a;
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:3:0x0004, code lost:
                    
                        r0 = r1.f14550l;
                     */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final void invoke2(@org.jetbrains.annotations.Nullable java.lang.Object r2) {
                        /*
                            r1 = this;
                            boolean r0 = r2 instanceof com.cupidapp.live.feed.model.PostLimitDetailModel
                            if (r0 == 0) goto L1d
                            com.cupidapp.live.feed.layout.PostLimitPagerLayout r0 = com.cupidapp.live.feed.layout.PostLimitPagerLayout.this
                            com.cupidapp.live.feed.layout.p r0 = com.cupidapp.live.feed.layout.PostLimitPagerLayout.m(r0)
                            if (r0 == 0) goto L1d
                            com.cupidapp.live.feed.model.PostLimitDetailModel r2 = (com.cupidapp.live.feed.model.PostLimitDetailModel) r2
                            com.cupidapp.live.profile.model.User r2 = r2.getUser()
                            if (r2 == 0) goto L19
                            java.lang.String r2 = r2.userId()
                            goto L1a
                        L19:
                            r2 = 0
                        L1a:
                            r0.O(r2)
                        L1d:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.feed.layout.PostLimitPagerLayout$adapter$2$1$6.invoke2(java.lang.Object):void");
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.post_user_avatar), new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.feed.layout.PostLimitPagerLayout$adapter$2$1$7
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                        invoke2(obj);
                        return kotlin.p.f51048a;
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:3:0x0004, code lost:
                    
                        r0 = r1.f14550l;
                     */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final void invoke2(@org.jetbrains.annotations.Nullable java.lang.Object r2) {
                        /*
                            r1 = this;
                            boolean r0 = r2 instanceof com.cupidapp.live.feed.model.PostLimitDetailModel
                            if (r0 == 0) goto L15
                            com.cupidapp.live.feed.layout.PostLimitPagerLayout r0 = com.cupidapp.live.feed.layout.PostLimitPagerLayout.this
                            com.cupidapp.live.feed.layout.p r0 = com.cupidapp.live.feed.layout.PostLimitPagerLayout.m(r0)
                            if (r0 == 0) goto L15
                            com.cupidapp.live.feed.model.PostLimitDetailModel r2 = (com.cupidapp.live.feed.model.PostLimitDetailModel) r2
                            com.cupidapp.live.profile.model.User r2 = r2.getUser()
                            r0.I(r2)
                        L15:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.feed.layout.PostLimitPagerLayout$adapter$2$1$7.invoke2(java.lang.Object):void");
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.post_user_name), new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.feed.layout.PostLimitPagerLayout$adapter$2$1$8
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                        invoke2(obj);
                        return kotlin.p.f51048a;
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:3:0x0004, code lost:
                    
                        r0 = r1.f14550l;
                     */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final void invoke2(@org.jetbrains.annotations.Nullable java.lang.Object r2) {
                        /*
                            r1 = this;
                            boolean r0 = r2 instanceof com.cupidapp.live.feed.model.PostLimitDetailModel
                            if (r0 == 0) goto L15
                            com.cupidapp.live.feed.layout.PostLimitPagerLayout r0 = com.cupidapp.live.feed.layout.PostLimitPagerLayout.this
                            com.cupidapp.live.feed.layout.p r0 = com.cupidapp.live.feed.layout.PostLimitPagerLayout.m(r0)
                            if (r0 == 0) goto L15
                            com.cupidapp.live.feed.model.PostLimitDetailModel r2 = (com.cupidapp.live.feed.model.PostLimitDetailModel) r2
                            com.cupidapp.live.profile.model.User r2 = r2.getUser()
                            r0.I(r2)
                        L15:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.feed.layout.PostLimitPagerLayout$adapter$2$1$8.invoke2(java.lang.Object):void");
                    }
                })));
                return postLimitPagerAdapter;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PostLimitPagerAdapter getAdapter() {
        return (PostLimitPagerAdapter) this.f14554p.getValue();
    }

    @Override // com.cupidapp.live.feed.layout.ClickChangePageLayout
    public boolean d() {
        j jVar = this.f14551m;
        if (jVar != null) {
            return jVar.a();
        }
        return true;
    }

    @Override // com.cupidapp.live.feed.layout.ClickChangePageLayout
    public boolean e() {
        j jVar = this.f14551m;
        if (jVar != null) {
            return jVar.b();
        }
        return true;
    }

    @Override // com.cupidapp.live.feed.layout.ClickChangePageLayout
    @NotNull
    public TopIndicatorLayout getTopIndicatorLayout() {
        int i10 = R$id.post_top_indicator_layout;
        ((TopIndicatorLayout) k(i10)).setAlpha(1.0f);
        TopIndicatorLayout post_top_indicator_layout = (TopIndicatorLayout) k(i10);
        kotlin.jvm.internal.s.h(post_top_indicator_layout, "post_top_indicator_layout");
        return post_top_indicator_layout;
    }

    @Override // com.cupidapp.live.feed.layout.ClickChangePageLayout
    @NotNull
    public ViewPager2 getViewPager2() {
        ViewPager2 post_limit_pager_view_pager = (ViewPager2) k(R$id.post_limit_pager_view_pager);
        kotlin.jvm.internal.s.h(post_limit_pager_view_pager, "post_limit_pager_view_pager");
        return post_limit_pager_view_pager;
    }

    @Override // com.cupidapp.live.feed.layout.ClickChangePageLayout
    public int i() {
        return R$layout.layout_page_limit_pager;
    }

    @Nullable
    public View k(int i10) {
        Map<Integer, View> map = this.f14555q;
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

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        y0.a.b(y0.a.f54658a, this, null, 2, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        y0.a.f54658a.c(this);
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull SoftKeyboardEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        if (event.getShow()) {
            ((TopIndicatorLayout) k(R$id.post_top_indicator_layout)).setAlpha(0.3f);
        } else {
            ((TopIndicatorLayout) k(R$id.post_top_indicator_layout)).setAlpha(1.0f);
        }
    }

    public final void s(@NotNull List<PostLimitDetailModel> list, @Nullable FKSensorContext fKSensorContext, @Nullable final p pVar, @Nullable j jVar) {
        User user;
        kotlin.jvm.internal.s.i(list, "list");
        Object V = CollectionsKt___CollectionsKt.V(getAdapter().j());
        if (V instanceof PostLimitDetailModel) {
            User user2 = ((PostLimitDetailModel) V).getUser();
            String str = null;
            String userId = user2 != null ? user2.userId() : null;
            PostLimitDetailModel postLimitDetailModel = (PostLimitDetailModel) CollectionsKt___CollectionsKt.V(list);
            if (postLimitDetailModel != null && (user = postLimitDetailModel.getUser()) != null) {
                str = user.userId();
            }
            if (!kotlin.jvm.internal.s.d(userId, str)) {
                this.f14553o = 0;
            }
        }
        this.f14552n = fKSensorContext;
        this.f14551m = jVar;
        this.f14550l = pVar;
        h(new Rect(0, z0.h.c(this, 52.0f), z0.h.l(this), z0.h.k(this) - z0.h.c(this, 80.0f)));
        getViewPager2().setAdapter(getAdapter());
        getAdapter().j().clear();
        getAdapter().j().addAll(list);
        getAdapter().notifyDataSetChanged();
        setPagerSize(list.size());
        getViewPager2().registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.cupidapp.live.feed.layout.PostLimitPagerLayout$configData$1
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i10) {
                PostLimitPagerAdapter adapter;
                p pVar2;
                adapter = PostLimitPagerLayout.this.getAdapter();
                Object W = CollectionsKt___CollectionsKt.W(adapter.j(), i10);
                if ((W instanceof PostLimitDetailModel) && (pVar2 = pVar) != null) {
                    PostLimitDetailModel postLimitDetailModel2 = (PostLimitDetailModel) W;
                    String id2 = postLimitDetailModel2.getId();
                    User user3 = postLimitDetailModel2.getUser();
                    pVar2.U(id2, user3 != null ? user3.userId() : null);
                }
                PostLimitPagerLayout.this.f14553o = i10;
            }
        });
        getViewPager2().setCurrentItem(this.f14553o, false);
    }

    public final void t(final String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new FKActionSheetItemModel(R$string.delete, ActionSheetItemType.Warning, null, null, null, new Function0<kotlin.p>() { // from class: com.cupidapp.live.feed.layout.PostLimitPagerLayout$showMoreAuthorOperate$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ kotlin.p invoke() {
                invoke2();
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                PostLimitPagerLayout.this.v(str);
                SensorsLogKeyButtonClick.PostLimit.DEL_TIME_LIMIT_FEED.click();
            }
        }, 28, null));
        FKActionSheetDialog.f12692f.a(getContext()).f(arrayList).h();
    }

    public final void u(final String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new FKActionSheetItemModel(R$string.report, ActionSheetItemType.Warning, null, null, null, new Function0<kotlin.p>() { // from class: com.cupidapp.live.feed.layout.PostLimitPagerLayout$showMoreViewOperate$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ kotlin.p invoke() {
                invoke2();
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                p pVar;
                pVar = PostLimitPagerLayout.this.f14550l;
                if (pVar != null) {
                    pVar.L(str);
                }
            }
        }, 28, null));
        FKActionSheetDialog.f12692f.a(getContext()).f(arrayList).h();
    }

    public final void v(final String str) {
        FKAlertDialog.G(FKAlertDialog.r(FKAlertDialog.w(FKAlertDialog.o(FKAlertDialog.a.c(FKAlertDialog.f12698l, getContext(), false, 2, null), R$string.confirm_del_post_limit, 0, 2, null), 2131886528, null, new Function0<kotlin.p>() { // from class: com.cupidapp.live.feed.layout.PostLimitPagerLayout$showTwiceDelConfirm$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ kotlin.p invoke() {
                invoke2();
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                p pVar;
                pVar = PostLimitPagerLayout.this.f14550l;
                if (pVar != null) {
                    pVar.c(str);
                }
            }
        }, 2, null), 0, null, 3, null), null, 1, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostLimitPagerLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14555q = new LinkedHashMap();
        this.f14554p = kotlin.c.b(new Function0<PostLimitPagerAdapter>() { // from class: com.cupidapp.live.feed.layout.PostLimitPagerLayout$adapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final PostLimitPagerAdapter invoke() {
                FKSensorContext fKSensorContext;
                fKSensorContext = PostLimitPagerLayout.this.f14552n;
                PostLimitPagerAdapter postLimitPagerAdapter = new PostLimitPagerAdapter(fKSensorContext);
                final PostLimitPagerLayout postLimitPagerLayout = PostLimitPagerLayout.this;
                postLimitPagerAdapter.l().j(i0.h(kotlin.f.a(Integer.valueOf(R$id.post_viewer_rl), new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.feed.layout.PostLimitPagerLayout$adapter$2$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                        invoke2(obj);
                        return kotlin.p.f51048a;
                    }

                    /* renamed from: invoke */
                    public final void invoke2(@Nullable Object obj) {
                        /*  JADX ERROR: Method code generation error
                            java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.IContainer.get(jadx.api.plugins.input.data.attributes.IJadxAttrType)" because "cont" is null
                            	at jadx.core.codegen.RegionGen.declareVars(RegionGen.java:70)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            */
                        /*
                            this = this;
                            boolean r0 = r2 instanceof com.cupidapp.live.feed.model.PostLimitDetailModel
                            if (r0 == 0) goto L15
                            com.cupidapp.live.feed.layout.PostLimitPagerLayout r0 = com.cupidapp.live.feed.layout.PostLimitPagerLayout.this
                            com.cupidapp.live.feed.layout.p r0 = com.cupidapp.live.feed.layout.PostLimitPagerLayout.m(r0)
                            if (r0 == 0) goto L15
                            com.cupidapp.live.feed.model.PostLimitDetailModel r2 = (com.cupidapp.live.feed.model.PostLimitDetailModel) r2
                            java.lang.String r2 = r2.getId()
                            r0.J(r2)
                        L15:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.feed.layout.PostLimitPagerLayout$adapter$2$1$1.invoke2(java.lang.Object):void");
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.post_close_view), new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.feed.layout.PostLimitPagerLayout$adapter$2$1$2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                        invoke2(obj);
                        return kotlin.p.f51048a;
                    }

                    /* renamed from: invoke */
                    public final void invoke2(@Nullable Object obj) {
                        /*  JADX ERROR: Method code generation error
                            java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.IContainer.get(jadx.api.plugins.input.data.attributes.IJadxAttrType)" because "cont" is null
                            	at jadx.core.codegen.RegionGen.declareVars(RegionGen.java:70)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            */
                        /*
                            this = this;
                            boolean r1 = r1 instanceof com.cupidapp.live.feed.model.PostLimitDetailModel
                            if (r1 == 0) goto Lf
                            com.cupidapp.live.feed.layout.PostLimitPagerLayout r1 = com.cupidapp.live.feed.layout.PostLimitPagerLayout.this
                            com.cupidapp.live.feed.layout.p r1 = com.cupidapp.live.feed.layout.PostLimitPagerLayout.m(r1)
                            if (r1 == 0) goto Lf
                            r1.q()
                        Lf:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.feed.layout.PostLimitPagerLayout$adapter$2$1$2.invoke2(java.lang.Object):void");
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.viewer_post_more), new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.feed.layout.PostLimitPagerLayout$adapter$2$1$3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                        invoke2(obj);
                        return kotlin.p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Object obj) {
                        if (obj instanceof PostLimitDetailModel) {
                            PostLimitPagerLayout.this.t(((PostLimitDetailModel) obj).getId());
                        }
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.more_img), new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.feed.layout.PostLimitPagerLayout$adapter$2$1$4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                        invoke2(obj);
                        return kotlin.p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Object obj) {
                        if (obj instanceof PostLimitDetailModel) {
                            PostLimitPagerLayout.this.u(((PostLimitDetailModel) obj).getId());
                        }
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.publish_limit_post), new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.feed.layout.PostLimitPagerLayout$adapter$2$1$5
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                        invoke2(obj);
                        return kotlin.p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Object obj) {
                        p pVar;
                        pVar = PostLimitPagerLayout.this.f14550l;
                        if (pVar != null) {
                            pVar.G();
                        }
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.post_concern_button), new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.feed.layout.PostLimitPagerLayout$adapter$2$1$6
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                        invoke2(obj);
                        return kotlin.p.f51048a;
                    }

                    /* renamed from: invoke */
                    public final void invoke2(@Nullable Object obj) {
                        /*  JADX ERROR: Method code generation error
                            java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.IContainer.get(jadx.api.plugins.input.data.attributes.IJadxAttrType)" because "cont" is null
                            	at jadx.core.codegen.RegionGen.declareVars(RegionGen.java:70)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            */
                        /*
                            this = this;
                            boolean r0 = r2 instanceof com.cupidapp.live.feed.model.PostLimitDetailModel
                            if (r0 == 0) goto L1d
                            com.cupidapp.live.feed.layout.PostLimitPagerLayout r0 = com.cupidapp.live.feed.layout.PostLimitPagerLayout.this
                            com.cupidapp.live.feed.layout.p r0 = com.cupidapp.live.feed.layout.PostLimitPagerLayout.m(r0)
                            if (r0 == 0) goto L1d
                            com.cupidapp.live.feed.model.PostLimitDetailModel r2 = (com.cupidapp.live.feed.model.PostLimitDetailModel) r2
                            com.cupidapp.live.profile.model.User r2 = r2.getUser()
                            if (r2 == 0) goto L19
                            java.lang.String r2 = r2.userId()
                            goto L1a
                        L19:
                            r2 = 0
                        L1a:
                            r0.O(r2)
                        L1d:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.feed.layout.PostLimitPagerLayout$adapter$2$1$6.invoke2(java.lang.Object):void");
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.post_user_avatar), new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.feed.layout.PostLimitPagerLayout$adapter$2$1$7
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                        invoke2(obj);
                        return kotlin.p.f51048a;
                    }

                    /* renamed from: invoke */
                    public final void invoke2(@Nullable Object obj) {
                        /*  JADX ERROR: Method code generation error
                            java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.IContainer.get(jadx.api.plugins.input.data.attributes.IJadxAttrType)" because "cont" is null
                            	at jadx.core.codegen.RegionGen.declareVars(RegionGen.java:70)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            */
                        /*
                            this = this;
                            boolean r0 = r2 instanceof com.cupidapp.live.feed.model.PostLimitDetailModel
                            if (r0 == 0) goto L15
                            com.cupidapp.live.feed.layout.PostLimitPagerLayout r0 = com.cupidapp.live.feed.layout.PostLimitPagerLayout.this
                            com.cupidapp.live.feed.layout.p r0 = com.cupidapp.live.feed.layout.PostLimitPagerLayout.m(r0)
                            if (r0 == 0) goto L15
                            com.cupidapp.live.feed.model.PostLimitDetailModel r2 = (com.cupidapp.live.feed.model.PostLimitDetailModel) r2
                            com.cupidapp.live.profile.model.User r2 = r2.getUser()
                            r0.I(r2)
                        L15:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.feed.layout.PostLimitPagerLayout$adapter$2$1$7.invoke2(java.lang.Object):void");
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.post_user_name), new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.feed.layout.PostLimitPagerLayout$adapter$2$1$8
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                        invoke2(obj);
                        return kotlin.p.f51048a;
                    }

                    /* renamed from: invoke */
                    public final void invoke2(@Nullable Object obj) {
                        /*  JADX ERROR: Method code generation error
                            java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.IContainer.get(jadx.api.plugins.input.data.attributes.IJadxAttrType)" because "cont" is null
                            	at jadx.core.codegen.RegionGen.declareVars(RegionGen.java:70)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            */
                        /*
                            this = this;
                            boolean r0 = r2 instanceof com.cupidapp.live.feed.model.PostLimitDetailModel
                            if (r0 == 0) goto L15
                            com.cupidapp.live.feed.layout.PostLimitPagerLayout r0 = com.cupidapp.live.feed.layout.PostLimitPagerLayout.this
                            com.cupidapp.live.feed.layout.p r0 = com.cupidapp.live.feed.layout.PostLimitPagerLayout.m(r0)
                            if (r0 == 0) goto L15
                            com.cupidapp.live.feed.model.PostLimitDetailModel r2 = (com.cupidapp.live.feed.model.PostLimitDetailModel) r2
                            com.cupidapp.live.profile.model.User r2 = r2.getUser()
                            r0.I(r2)
                        L15:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.feed.layout.PostLimitPagerLayout$adapter$2$1$8.invoke2(java.lang.Object):void");
                    }
                })));
                return postLimitPagerAdapter;
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostLimitPagerLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14555q = new LinkedHashMap();
        this.f14554p = kotlin.c.b(new Function0<PostLimitPagerAdapter>() { // from class: com.cupidapp.live.feed.layout.PostLimitPagerLayout$adapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final PostLimitPagerAdapter invoke() {
                FKSensorContext fKSensorContext;
                fKSensorContext = PostLimitPagerLayout.this.f14552n;
                PostLimitPagerAdapter postLimitPagerAdapter = new PostLimitPagerAdapter(fKSensorContext);
                final PostLimitPagerLayout postLimitPagerLayout = PostLimitPagerLayout.this;
                postLimitPagerAdapter.l().j(i0.h(kotlin.f.a(Integer.valueOf(R$id.post_viewer_rl), new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.feed.layout.PostLimitPagerLayout$adapter$2$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                        invoke2(obj);
                        return kotlin.p.f51048a;
                    }

                    /*  JADX ERROR: Method code generation error
                        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.IContainer.get(jadx.api.plugins.input.data.attributes.IJadxAttrType)" because "cont" is null
                        	at jadx.core.codegen.RegionGen.declareVars(RegionGen.java:70)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                        */
                    /* renamed from: invoke */
                    public final void invoke2(@org.jetbrains.annotations.Nullable java.lang.Object r2) {
                        /*
                            r1 = this;
                            boolean r0 = r2 instanceof com.cupidapp.live.feed.model.PostLimitDetailModel
                            if (r0 == 0) goto L15
                            com.cupidapp.live.feed.layout.PostLimitPagerLayout r0 = com.cupidapp.live.feed.layout.PostLimitPagerLayout.this
                            com.cupidapp.live.feed.layout.p r0 = com.cupidapp.live.feed.layout.PostLimitPagerLayout.m(r0)
                            if (r0 == 0) goto L15
                            com.cupidapp.live.feed.model.PostLimitDetailModel r2 = (com.cupidapp.live.feed.model.PostLimitDetailModel) r2
                            java.lang.String r2 = r2.getId()
                            r0.J(r2)
                        L15:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.feed.layout.PostLimitPagerLayout$adapter$2$1$1.invoke2(java.lang.Object):void");
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.post_close_view), new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.feed.layout.PostLimitPagerLayout$adapter$2$1$2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                        invoke2(obj);
                        return kotlin.p.f51048a;
                    }

                    /*  JADX ERROR: Method code generation error
                        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.IContainer.get(jadx.api.plugins.input.data.attributes.IJadxAttrType)" because "cont" is null
                        	at jadx.core.codegen.RegionGen.declareVars(RegionGen.java:70)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                        */
                    /* renamed from: invoke */
                    public final void invoke2(@org.jetbrains.annotations.Nullable java.lang.Object r1) {
                        /*
                            r0 = this;
                            boolean r1 = r1 instanceof com.cupidapp.live.feed.model.PostLimitDetailModel
                            if (r1 == 0) goto Lf
                            com.cupidapp.live.feed.layout.PostLimitPagerLayout r1 = com.cupidapp.live.feed.layout.PostLimitPagerLayout.this
                            com.cupidapp.live.feed.layout.p r1 = com.cupidapp.live.feed.layout.PostLimitPagerLayout.m(r1)
                            if (r1 == 0) goto Lf
                            r1.q()
                        Lf:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.feed.layout.PostLimitPagerLayout$adapter$2$1$2.invoke2(java.lang.Object):void");
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.viewer_post_more), new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.feed.layout.PostLimitPagerLayout$adapter$2$1$3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                        invoke2(obj);
                        return kotlin.p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Object obj) {
                        if (obj instanceof PostLimitDetailModel) {
                            PostLimitPagerLayout.this.t(((PostLimitDetailModel) obj).getId());
                        }
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.more_img), new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.feed.layout.PostLimitPagerLayout$adapter$2$1$4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                        invoke2(obj);
                        return kotlin.p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Object obj) {
                        if (obj instanceof PostLimitDetailModel) {
                            PostLimitPagerLayout.this.u(((PostLimitDetailModel) obj).getId());
                        }
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.publish_limit_post), new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.feed.layout.PostLimitPagerLayout$adapter$2$1$5
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                        invoke2(obj);
                        return kotlin.p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Object obj) {
                        p pVar;
                        pVar = PostLimitPagerLayout.this.f14550l;
                        if (pVar != null) {
                            pVar.G();
                        }
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.post_concern_button), new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.feed.layout.PostLimitPagerLayout$adapter$2$1$6
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                        invoke2(obj);
                        return kotlin.p.f51048a;
                    }

                    /*  JADX ERROR: Method code generation error
                        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.IContainer.get(jadx.api.plugins.input.data.attributes.IJadxAttrType)" because "cont" is null
                        	at jadx.core.codegen.RegionGen.declareVars(RegionGen.java:70)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                        */
                    /* renamed from: invoke */
                    public final void invoke2(@org.jetbrains.annotations.Nullable java.lang.Object r2) {
                        /*
                            r1 = this;
                            boolean r0 = r2 instanceof com.cupidapp.live.feed.model.PostLimitDetailModel
                            if (r0 == 0) goto L1d
                            com.cupidapp.live.feed.layout.PostLimitPagerLayout r0 = com.cupidapp.live.feed.layout.PostLimitPagerLayout.this
                            com.cupidapp.live.feed.layout.p r0 = com.cupidapp.live.feed.layout.PostLimitPagerLayout.m(r0)
                            if (r0 == 0) goto L1d
                            com.cupidapp.live.feed.model.PostLimitDetailModel r2 = (com.cupidapp.live.feed.model.PostLimitDetailModel) r2
                            com.cupidapp.live.profile.model.User r2 = r2.getUser()
                            if (r2 == 0) goto L19
                            java.lang.String r2 = r2.userId()
                            goto L1a
                        L19:
                            r2 = 0
                        L1a:
                            r0.O(r2)
                        L1d:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.feed.layout.PostLimitPagerLayout$adapter$2$1$6.invoke2(java.lang.Object):void");
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.post_user_avatar), new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.feed.layout.PostLimitPagerLayout$adapter$2$1$7
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                        invoke2(obj);
                        return kotlin.p.f51048a;
                    }

                    /*  JADX ERROR: Method code generation error
                        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.IContainer.get(jadx.api.plugins.input.data.attributes.IJadxAttrType)" because "cont" is null
                        	at jadx.core.codegen.RegionGen.declareVars(RegionGen.java:70)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                        */
                    /* renamed from: invoke */
                    public final void invoke2(@org.jetbrains.annotations.Nullable java.lang.Object r2) {
                        /*
                            r1 = this;
                            boolean r0 = r2 instanceof com.cupidapp.live.feed.model.PostLimitDetailModel
                            if (r0 == 0) goto L15
                            com.cupidapp.live.feed.layout.PostLimitPagerLayout r0 = com.cupidapp.live.feed.layout.PostLimitPagerLayout.this
                            com.cupidapp.live.feed.layout.p r0 = com.cupidapp.live.feed.layout.PostLimitPagerLayout.m(r0)
                            if (r0 == 0) goto L15
                            com.cupidapp.live.feed.model.PostLimitDetailModel r2 = (com.cupidapp.live.feed.model.PostLimitDetailModel) r2
                            com.cupidapp.live.profile.model.User r2 = r2.getUser()
                            r0.I(r2)
                        L15:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.feed.layout.PostLimitPagerLayout$adapter$2$1$7.invoke2(java.lang.Object):void");
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.post_user_name), new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.feed.layout.PostLimitPagerLayout$adapter$2$1$8
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                        invoke2(obj);
                        return kotlin.p.f51048a;
                    }

                    /*  JADX ERROR: Method code generation error
                        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.IContainer.get(jadx.api.plugins.input.data.attributes.IJadxAttrType)" because "cont" is null
                        	at jadx.core.codegen.RegionGen.declareVars(RegionGen.java:70)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                        */
                    /* renamed from: invoke */
                    public final void invoke2(@org.jetbrains.annotations.Nullable java.lang.Object r2) {
                        /*
                            r1 = this;
                            boolean r0 = r2 instanceof com.cupidapp.live.feed.model.PostLimitDetailModel
                            if (r0 == 0) goto L15
                            com.cupidapp.live.feed.layout.PostLimitPagerLayout r0 = com.cupidapp.live.feed.layout.PostLimitPagerLayout.this
                            com.cupidapp.live.feed.layout.p r0 = com.cupidapp.live.feed.layout.PostLimitPagerLayout.m(r0)
                            if (r0 == 0) goto L15
                            com.cupidapp.live.feed.model.PostLimitDetailModel r2 = (com.cupidapp.live.feed.model.PostLimitDetailModel) r2
                            com.cupidapp.live.profile.model.User r2 = r2.getUser()
                            r0.I(r2)
                        L15:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.feed.layout.PostLimitPagerLayout$adapter$2$1$8.invoke2(java.lang.Object):void");
                    }
                })));
                return postLimitPagerAdapter;
            }
        });
    }
}
