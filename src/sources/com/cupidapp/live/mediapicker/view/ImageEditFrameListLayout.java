package com.cupidapp.live.mediapicker.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.view.CustomLayoutManager;
import com.cupidapp.live.base.view.ScrollTo;
import com.cupidapp.live.base.view.decoration.FKAddExtraSpacingDecoration;
import com.cupidapp.live.mediapicker.adapter.MediaEditButtonListAdapter;
import com.cupidapp.live.mediapicker.model.FrameAspectRatio;
import com.cupidapp.live.mediapicker.model.FrameViewModel;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: ImageEditFrameListLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ImageEditFrameListLayout extends CustomAnimationLayout {

    /* renamed from: c */
    @Nullable
    public e f17403c;

    /* renamed from: d */
    @NotNull
    public final MediaEditButtonListAdapter f17404d;

    /* renamed from: e */
    @NotNull
    public Map<Integer, View> f17405e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageEditFrameListLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f17405e = new LinkedHashMap();
        MediaEditButtonListAdapter mediaEditButtonListAdapter = new MediaEditButtonListAdapter();
        mediaEditButtonListAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.mediapicker.view.ImageEditFrameListLayout$frameAdapter$1$1
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
                e eVar;
                if (obj instanceof FrameViewModel) {
                    FrameViewModel frameViewModel = (FrameViewModel) obj;
                    ImageEditFrameListLayout.this.i(frameViewModel.getFrameType(), true);
                    eVar = ImageEditFrameListLayout.this.f17403c;
                    if (eVar != null) {
                        eVar.b(frameViewModel.getFrameType());
                    }
                }
            }
        });
        this.f17404d = mediaEditButtonListAdapter;
        k();
    }

    private final FrameViewModel getDefaultFrameViewModel() {
        return new FrameViewModel(R$string.default_screen, R$mipmap.icon_default, true, FrameAspectRatio.DEFAULT);
    }

    private final List<FrameViewModel> getFrameViewModelList() {
        return kotlin.collections.s.o(new FrameViewModel(R$string.vertical_screen, R$mipmap.icon_vertical_screen, false, FrameAspectRatio.THREE_TO_FOUR), new FrameViewModel(R$string.square_screen, R$mipmap.icon_square_screen, false, FrameAspectRatio.ONE_TO_ONE), new FrameViewModel(R$string.wide_screen, R$mipmap.icon_wide_screen, false, FrameAspectRatio.FOUR_TO_THREE), new FrameViewModel(R$string.extra_wide, R$mipmap.icon_extra_wide, false, FrameAspectRatio.SIXTEEN_TO_NINE));
    }

    public static /* synthetic */ void j(ImageEditFrameListLayout imageEditFrameListLayout, FrameAspectRatio frameAspectRatio, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        imageEditFrameListLayout.i(frameAspectRatio, z10);
    }

    @Override // com.cupidapp.live.mediapicker.view.CustomAnimationLayout
    public void a() {
        Property<View, Float> Y = View.Y;
        s.h(Y, "Y");
        b(Y);
        e eVar = this.f17403c;
        if (eVar != null) {
            eVar.a();
        }
    }

    @Nullable
    public View f(int i10) {
        Map<Integer, View> map = this.f17405e;
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

    /* JADX WARN: Removed duplicated region for block: B:27:0x0093 A[LOOP:1: B:17:0x005f->B:27:0x0093, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0097 A[EDGE_INSN: B:28:0x0097->B:29:0x0097 BREAK  A[LOOP:1: B:17:0x005f->B:27:0x0093], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void i(@org.jetbrains.annotations.Nullable com.cupidapp.live.mediapicker.model.FrameAspectRatio r8, boolean r9) {
        /*
            r7 = this;
            if (r8 != 0) goto L3
            return
        L3:
            java.util.List r0 = r7.getFrameViewModelList()
            java.util.Iterator r1 = r0.iterator2()
        Lb:
            boolean r2 = r1.hasNext()
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3a
            java.lang.Object r2 = r1.next()
            r5 = r2
            com.cupidapp.live.mediapicker.model.FrameViewModel r5 = (com.cupidapp.live.mediapicker.model.FrameViewModel) r5
            com.cupidapp.live.mediapicker.model.FrameAspectRatio r5 = r5.getFrameType()
            float r5 = r5.getRatio()
            float r5 = z0.q.c(r5)
            com.cupidapp.live.mediapicker.model.FrameAspectRatio r6 = com.cupidapp.live.mediapicker.model.FrameAspectRatio.DEFAULT
            float r6 = r6.getRatio()
            float r6 = z0.q.c(r6)
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 != 0) goto L36
            r5 = 1
            goto L37
        L36:
            r5 = 0
        L37:
            if (r5 == 0) goto Lb
            goto L3b
        L3a:
            r2 = 0
        L3b:
            com.cupidapp.live.mediapicker.model.FrameViewModel r2 = (com.cupidapp.live.mediapicker.model.FrameViewModel) r2
            if (r2 != 0) goto L46
            com.cupidapp.live.mediapicker.model.FrameViewModel r1 = r7.getDefaultFrameViewModel()
            r0.add(r4, r1)
        L46:
            com.cupidapp.live.mediapicker.adapter.MediaEditButtonListAdapter r1 = r7.f17404d
            java.util.List r1 = r1.j()
            r1.clear()
            com.cupidapp.live.mediapicker.adapter.MediaEditButtonListAdapter r1 = r7.f17404d
            r1.e(r0)
            com.cupidapp.live.mediapicker.adapter.MediaEditButtonListAdapter r0 = r7.f17404d
            java.util.List r0 = r0.j()
            java.util.Iterator r0 = r0.iterator2()
            r1 = 0
        L5f:
            boolean r2 = r0.hasNext()
            r5 = -1
            if (r2 == 0) goto L96
            java.lang.Object r2 = r0.next()
            boolean r6 = r2 instanceof com.cupidapp.live.mediapicker.model.FrameViewModel
            if (r6 == 0) goto L8f
            com.cupidapp.live.mediapicker.model.FrameViewModel r2 = (com.cupidapp.live.mediapicker.model.FrameViewModel) r2
            com.cupidapp.live.mediapicker.model.FrameAspectRatio r2 = r2.getFrameType()
            float r2 = r2.getRatio()
            float r2 = z0.q.c(r2)
            float r6 = r8.getRatio()
            float r6 = z0.q.c(r6)
            int r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r2 != 0) goto L8a
            r2 = 1
            goto L8b
        L8a:
            r2 = 0
        L8b:
            if (r2 == 0) goto L8f
            r2 = 1
            goto L90
        L8f:
            r2 = 0
        L90:
            if (r2 == 0) goto L93
            goto L97
        L93:
            int r1 = r1 + 1
            goto L5f
        L96:
            r1 = -1
        L97:
            if (r1 != r5) goto L9a
            return
        L9a:
            com.cupidapp.live.mediapicker.adapter.MediaEditButtonListAdapter r8 = r7.f17404d
            java.util.List r8 = r8.j()
            java.util.Iterator r8 = r8.iterator2()
            r0 = 0
        La5:
            boolean r2 = r8.hasNext()
            if (r2 == 0) goto Lc6
            java.lang.Object r2 = r8.next()
            int r5 = r0 + 1
            if (r0 >= 0) goto Lb6
            kotlin.collections.s.s()
        Lb6:
            boolean r6 = r2 instanceof com.cupidapp.live.mediapicker.model.FrameViewModel
            if (r6 == 0) goto Lc4
            com.cupidapp.live.mediapicker.model.FrameViewModel r2 = (com.cupidapp.live.mediapicker.model.FrameViewModel) r2
            if (r0 != r1) goto Lc0
            r0 = 1
            goto Lc1
        Lc0:
            r0 = 0
        Lc1:
            r2.setItemSelected(r0)
        Lc4:
            r0 = r5
            goto La5
        Lc6:
            com.cupidapp.live.mediapicker.adapter.MediaEditButtonListAdapter r8 = r7.f17404d
            r8.notifyDataSetChanged()
            if (r9 == 0) goto Ld9
            int r8 = com.cupidapp.live.R$id.buttonListRecyclerView
            android.view.View r8 = r7.f(r8)
            androidx.recyclerview.widget.RecyclerView r8 = (androidx.recyclerview.widget.RecyclerView) r8
            r8.smoothScrollToPosition(r1)
            goto Le4
        Ld9:
            int r8 = com.cupidapp.live.R$id.buttonListRecyclerView
            android.view.View r8 = r7.f(r8)
            androidx.recyclerview.widget.RecyclerView r8 = (androidx.recyclerview.widget.RecyclerView) r8
            r8.scrollToPosition(r1)
        Le4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.mediapicker.view.ImageEditFrameListLayout.i(com.cupidapp.live.mediapicker.model.FrameAspectRatio, boolean):void");
    }

    public final void k() {
        z.a(this, R$layout.layout_media_edit_button_list, true);
        int i10 = R$id.buttonListRecyclerView;
        ((RecyclerView) f(i10)).setAdapter(this.f17404d);
        RecyclerView recyclerView = (RecyclerView) f(i10);
        Context context = getContext();
        s.h(context, "context");
        recyclerView.setLayoutManager(new CustomLayoutManager(context, 0, ScrollTo.Center, Float.valueOf(1.0f)));
        int c4 = z0.h.c(this, 7.5f);
        ((RecyclerView) f(i10)).addItemDecoration(new FKAddExtraSpacingDecoration(c4, 0, c4, 0, c4, 0, 32, null));
        int i11 = R$id.buttonListSelectLayout;
        ((BottomConfirmAndCancelLayout) f(i11)).setConfirmButtonClickEvent(new Function0<p>() { // from class: com.cupidapp.live.mediapicker.view.ImageEditFrameListLayout$initView$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ p invoke() {
                invoke2();
                return p.f51048a;
            }

            /* JADX WARN: Code restructure failed: missing block: B:15:0x0040, code lost:
            
                r0 = r0.f17403c;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void invoke2() {
                /*
                    r3 = this;
                    com.cupidapp.live.mediapicker.view.ImageEditFrameListLayout r0 = com.cupidapp.live.mediapicker.view.ImageEditFrameListLayout.this
                    android.util.Property<android.view.View, java.lang.Float> r1 = android.view.View.Y
                    java.lang.String r2 = "Y"
                    kotlin.jvm.internal.s.h(r1, r2)
                    r0.b(r1)
                    com.cupidapp.live.mediapicker.view.ImageEditFrameListLayout r0 = com.cupidapp.live.mediapicker.view.ImageEditFrameListLayout.this
                    com.cupidapp.live.mediapicker.adapter.MediaEditButtonListAdapter r0 = com.cupidapp.live.mediapicker.view.ImageEditFrameListLayout.g(r0)
                    java.util.List r0 = r0.j()
                    java.util.Iterator r0 = r0.iterator2()
                L1a:
                    boolean r1 = r0.hasNext()
                    if (r1 == 0) goto L37
                    java.lang.Object r1 = r0.next()
                    boolean r2 = r1 instanceof com.cupidapp.live.mediapicker.model.FrameViewModel
                    if (r2 == 0) goto L33
                    r2 = r1
                    com.cupidapp.live.mediapicker.model.FrameViewModel r2 = (com.cupidapp.live.mediapicker.model.FrameViewModel) r2
                    boolean r2 = r2.getItemSelected()
                    if (r2 == 0) goto L33
                    r2 = 1
                    goto L34
                L33:
                    r2 = 0
                L34:
                    if (r2 == 0) goto L1a
                    goto L38
                L37:
                    r1 = 0
                L38:
                    if (r1 == 0) goto L4f
                    com.cupidapp.live.mediapicker.view.ImageEditFrameListLayout r0 = com.cupidapp.live.mediapicker.view.ImageEditFrameListLayout.this
                    boolean r2 = r1 instanceof com.cupidapp.live.mediapicker.model.FrameViewModel
                    if (r2 == 0) goto L4f
                    com.cupidapp.live.mediapicker.view.e r0 = com.cupidapp.live.mediapicker.view.ImageEditFrameListLayout.h(r0)
                    if (r0 == 0) goto L4f
                    com.cupidapp.live.mediapicker.model.FrameViewModel r1 = (com.cupidapp.live.mediapicker.model.FrameViewModel) r1
                    com.cupidapp.live.mediapicker.model.FrameAspectRatio r1 = r1.getFrameType()
                    r0.c(r1)
                L4f:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.mediapicker.view.ImageEditFrameListLayout$initView$1.invoke2():void");
            }
        });
        ((BottomConfirmAndCancelLayout) f(i11)).setCancelButtonClickEvent(new Function0<p>() { // from class: com.cupidapp.live.mediapicker.view.ImageEditFrameListLayout$initView$2
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
                ImageEditFrameListLayout.this.a();
            }
        });
    }

    public final void setImageEditFrameListListener(@NotNull e listener) {
        s.i(listener, "listener");
        this.f17403c = listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageEditFrameListLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f17405e = new LinkedHashMap();
        MediaEditButtonListAdapter mediaEditButtonListAdapter = new MediaEditButtonListAdapter();
        mediaEditButtonListAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.mediapicker.view.ImageEditFrameListLayout$frameAdapter$1$1
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
                e eVar;
                if (obj instanceof FrameViewModel) {
                    FrameViewModel frameViewModel = (FrameViewModel) obj;
                    ImageEditFrameListLayout.this.i(frameViewModel.getFrameType(), true);
                    eVar = ImageEditFrameListLayout.this.f17403c;
                    if (eVar != null) {
                        eVar.b(frameViewModel.getFrameType());
                    }
                }
            }
        });
        this.f17404d = mediaEditButtonListAdapter;
        k();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageEditFrameListLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f17405e = new LinkedHashMap();
        MediaEditButtonListAdapter mediaEditButtonListAdapter = new MediaEditButtonListAdapter();
        mediaEditButtonListAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.mediapicker.view.ImageEditFrameListLayout$frameAdapter$1$1
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
                e eVar;
                if (obj instanceof FrameViewModel) {
                    FrameViewModel frameViewModel = (FrameViewModel) obj;
                    ImageEditFrameListLayout.this.i(frameViewModel.getFrameType(), true);
                    eVar = ImageEditFrameListLayout.this.f17403c;
                    if (eVar != null) {
                        eVar.b(frameViewModel.getFrameType());
                    }
                }
            }
        });
        this.f17404d = mediaEditButtonListAdapter;
        k();
    }
}
