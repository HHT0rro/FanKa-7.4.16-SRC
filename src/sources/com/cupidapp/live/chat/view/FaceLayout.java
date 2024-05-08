package com.cupidapp.live.chat.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$styleable;
import com.cupidapp.live.base.view.decoration.FKAddExtraSpacingDecoration;
import com.cupidapp.live.chat.adapter.FaceAdapter;
import com.cupidapp.live.chat.adapter.FaceUiModel;
import com.cupidapp.live.chat.model.CustomEmojiCode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.t;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.z;

/* compiled from: FaceLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FaceLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public Function1<? super CustomEmojiCode, p> f13220b;

    /* renamed from: c, reason: collision with root package name */
    public int f13221c;

    /* renamed from: d, reason: collision with root package name */
    public int f13222d;

    /* renamed from: e, reason: collision with root package name */
    public int f13223e;

    /* renamed from: f, reason: collision with root package name */
    public int f13224f;

    /* renamed from: g, reason: collision with root package name */
    public int f13225g;

    /* renamed from: h, reason: collision with root package name */
    public int f13226h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f13227i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f13228j;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public final Lazy f13229k;

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    public final Lazy f13230l;

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13231m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FaceLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f13231m = new LinkedHashMap();
        this.f13229k = kotlin.c.b(FaceLayout$defaultData$2.INSTANCE);
        this.f13230l = kotlin.c.b(new Function0<FaceAdapter>() { // from class: com.cupidapp.live.chat.view.FaceLayout$faceAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FaceAdapter invoke() {
                FaceAdapter faceAdapter = new FaceAdapter();
                final FaceLayout faceLayout = FaceLayout.this;
                faceAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.chat.view.FaceLayout$faceAdapter$2$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Object obj) {
                        invoke2(obj);
                        return p.f51048a;
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:3:0x0004, code lost:
                    
                        r0 = r1.f13220b;
                     */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final void invoke2(@org.jetbrains.annotations.Nullable java.lang.Object r2) {
                        /*
                            r1 = this;
                            boolean r0 = r2 instanceof com.cupidapp.live.chat.adapter.FaceUiModel
                            if (r0 == 0) goto L15
                            com.cupidapp.live.chat.view.FaceLayout r0 = com.cupidapp.live.chat.view.FaceLayout.this
                            kotlin.jvm.functions.Function1 r0 = com.cupidapp.live.chat.view.FaceLayout.c(r0)
                            if (r0 == 0) goto L15
                            com.cupidapp.live.chat.adapter.FaceUiModel r2 = (com.cupidapp.live.chat.adapter.FaceUiModel) r2
                            com.cupidapp.live.chat.model.CustomEmojiCode r2 = r2.getCustomEmojiCode()
                            r0.invoke(r2)
                        L15:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.chat.view.FaceLayout$faceAdapter$2$1$1.invoke2(java.lang.Object):void");
                    }
                });
                return faceAdapter;
            }
        });
        h(null);
    }

    public static final void g(FaceLayout this$0, List faceKeyList) {
        s.i(this$0, "this$0");
        s.i(faceKeyList, "$faceKeyList");
        RecyclerView.LayoutManager layoutManager = ((RecyclerView) this$0.b(R$id.face_rv)).getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager != null) {
            linearLayoutManager.scrollToPositionWithOffset(faceKeyList.size() / 2, ((h.l(this$0) - this$0.f13221c) - (this$0.f13225g * 2)) / 2);
        }
    }

    private final List<CustomEmojiCode> getDefaultData() {
        return (List) this.f13229k.getValue();
    }

    private final FaceAdapter getFaceAdapter() {
        return (FaceAdapter) this.f13230l.getValue();
    }

    @Nullable
    public View b(int i10) {
        Map<Integer, View> map = this.f13231m;
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

    public final void d() {
        RecyclerView recyclerView = (RecyclerView) b(R$id.face_rv);
        recyclerView.setAdapter(getFaceAdapter());
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
        int i10 = this.f13225g;
        recyclerView.addItemDecoration(new FKAddExtraSpacingDecoration(i10, 0, i10, 0, this.f13226h, 0, 32, null));
    }

    public final void e(int i10, int i11) {
        this.f13221c = i10;
        this.f13222d = i11;
        d();
        if (this.f13228j) {
            f(getDefaultData());
        }
    }

    public final void f(@NotNull final List<? extends CustomEmojiCode> faceKeyList) {
        s.i(faceKeyList, "faceKeyList");
        ArrayList arrayList = new ArrayList(t.t(faceKeyList, 10));
        Iterator<? extends CustomEmojiCode> iterator2 = faceKeyList.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(new FaceUiModel(iterator2.next(), this.f13221c, this.f13222d, this.f13224f, this.f13223e));
        }
        getFaceAdapter().j().clear();
        getFaceAdapter().e(arrayList);
        getFaceAdapter().notifyDataSetChanged();
        if (this.f13227i) {
            ((RecyclerView) b(R$id.face_rv)).post(new Runnable() { // from class: com.cupidapp.live.chat.view.c
                @Override // java.lang.Runnable
                public final void run() {
                    FaceLayout.g(FaceLayout.this, faceKeyList);
                }
            });
        }
    }

    public final int getItemSpacing() {
        return this.f13225g;
    }

    public final void h(AttributeSet attributeSet) {
        z.a(this, R$layout.layout_face, true);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.FaceLayout);
        s.h(obtainStyledAttributes, "context.obtainStyledAttr…, R.styleable.FaceLayout)");
        this.f13221c = obtainStyledAttributes.getDimensionPixelSize(5, h.c(this, 38.0f));
        this.f13222d = obtainStyledAttributes.getDimensionPixelSize(2, h.c(this, 38.0f));
        this.f13223e = obtainStyledAttributes.getDimensionPixelSize(3, h.c(this, 0.0f));
        this.f13224f = obtainStyledAttributes.getResourceId(0, 0);
        this.f13225g = obtainStyledAttributes.getDimensionPixelSize(4, 0);
        this.f13226h = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.f13228j = obtainStyledAttributes.getBoolean(7, true);
        this.f13227i = obtainStyledAttributes.getBoolean(6, true);
        obtainStyledAttributes.recycle();
        if (this.f13221c == 0 || this.f13222d == 0) {
            return;
        }
        d();
        if (this.f13228j) {
            f(getDefaultData());
        }
    }

    public final void setItemClickListener(@NotNull Function1<? super CustomEmojiCode, p> listener) {
        s.i(listener, "listener");
        this.f13220b = listener;
    }

    public final void setItemSpacing(int i10) {
        this.f13225g = i10;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FaceLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f13231m = new LinkedHashMap();
        this.f13229k = kotlin.c.b(FaceLayout$defaultData$2.INSTANCE);
        this.f13230l = kotlin.c.b(new Function0<FaceAdapter>() { // from class: com.cupidapp.live.chat.view.FaceLayout$faceAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FaceAdapter invoke() {
                FaceAdapter faceAdapter = new FaceAdapter();
                final FaceLayout faceLayout = FaceLayout.this;
                faceAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.chat.view.FaceLayout$faceAdapter$2$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Object obj) {
                        invoke2(obj);
                        return p.f51048a;
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
                            boolean r0 = r2 instanceof com.cupidapp.live.chat.adapter.FaceUiModel
                            if (r0 == 0) goto L15
                            com.cupidapp.live.chat.view.FaceLayout r0 = com.cupidapp.live.chat.view.FaceLayout.this
                            kotlin.jvm.functions.Function1 r0 = com.cupidapp.live.chat.view.FaceLayout.c(r0)
                            if (r0 == 0) goto L15
                            com.cupidapp.live.chat.adapter.FaceUiModel r2 = (com.cupidapp.live.chat.adapter.FaceUiModel) r2
                            com.cupidapp.live.chat.model.CustomEmojiCode r2 = r2.getCustomEmojiCode()
                            r0.invoke(r2)
                        L15:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.chat.view.FaceLayout$faceAdapter$2$1$1.invoke2(java.lang.Object):void");
                    }
                });
                return faceAdapter;
            }
        });
        h(attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FaceLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f13231m = new LinkedHashMap();
        this.f13229k = kotlin.c.b(FaceLayout$defaultData$2.INSTANCE);
        this.f13230l = kotlin.c.b(new Function0<FaceAdapter>() { // from class: com.cupidapp.live.chat.view.FaceLayout$faceAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FaceAdapter invoke() {
                FaceAdapter faceAdapter = new FaceAdapter();
                final FaceLayout faceLayout = FaceLayout.this;
                faceAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.chat.view.FaceLayout$faceAdapter$2$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Object obj) {
                        invoke2(obj);
                        return p.f51048a;
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
                            boolean r0 = r2 instanceof com.cupidapp.live.chat.adapter.FaceUiModel
                            if (r0 == 0) goto L15
                            com.cupidapp.live.chat.view.FaceLayout r0 = com.cupidapp.live.chat.view.FaceLayout.this
                            kotlin.jvm.functions.Function1 r0 = com.cupidapp.live.chat.view.FaceLayout.c(r0)
                            if (r0 == 0) goto L15
                            com.cupidapp.live.chat.adapter.FaceUiModel r2 = (com.cupidapp.live.chat.adapter.FaceUiModel) r2
                            com.cupidapp.live.chat.model.CustomEmojiCode r2 = r2.getCustomEmojiCode()
                            r0.invoke(r2)
                        L15:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.chat.view.FaceLayout$faceAdapter$2$1$1.invoke2(java.lang.Object):void");
                    }
                });
                return faceAdapter;
            }
        });
        h(attributeSet);
    }
}
