package com.cupidapp.live.liveshow.beauty.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.view.decoration.FKAddExtraSpacingDecoration;
import com.cupidapp.live.liveshow.beauty.adapter.FKLiveBeautyEditButtonListAdapter;
import com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum;
import com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyEditCacheModel;
import com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyEditItemModel;
import com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyFilterEditItemModel;
import com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyStickerEditItemModel;
import com.cupidapp.live.liveshow.model.LiveStickerModel;
import com.cupidapp.live.mediapicker.view.CustomAnimationLayout;
import com.cupidapp.live.track.group.GroupLiveLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.i0;
import kotlin.f;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;
import r2.i;
import z0.h;
import z0.y;
import z0.z;

/* compiled from: FKLiveBeautyLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveBeautyLayout extends CustomAnimationLayout {

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public static final a f14885i = new a(null);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final FKLiveBeautyFilterEditItemModel f14886c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final Map<String, FKLiveBeautyEditItemModel> f14887d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final List<LiveStickerModel> f14888e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public com.cupidapp.live.liveshow.beauty.view.a f14889f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public final FKLiveBeautyEditButtonListAdapter f14890g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14891h;

    /* compiled from: FKLiveBeautyLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final Float a(@NotNull FKLiveBeautyButtonEnum effect) {
            Map<String, Float> map;
            Map<String, Float> map2;
            s.i(effect, "effect");
            g gVar = g.f52734a;
            FKLiveBeautyEditCacheModel c4 = gVar.S().c();
            if ((c4 == null || (map2 = c4.getMap()) == null || !map2.containsKey(effect.getEffectId())) ? false : true) {
                return c(effect.getEffectId());
            }
            if (c4 != null && (map = c4.getMap()) != null) {
                map.put(effect.getEffectId(), Float.valueOf(effect.defaultValue()));
            }
            gVar.S().d(c4);
            return Float.valueOf(effect.defaultValue());
        }

        @Nullable
        public final FKLiveFilterViewModel b() {
            FKLiveBeautyEditCacheModel c4 = g.f52734a.S().c();
            if (c4 != null) {
                return c4.getFilter();
            }
            return null;
        }

        public final Float c(String str) {
            Map<String, Float> map;
            FKLiveBeautyEditCacheModel c4 = g.f52734a.S().c();
            if (c4 == null || (map = c4.getMap()) == null) {
                return null;
            }
            return map.get(str);
        }
    }

    /* compiled from: FKLiveBeautyLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b implements d {
        public b() {
        }

        @Override // com.cupidapp.live.liveshow.beauty.view.d
        public void a() {
        }

        @Override // com.cupidapp.live.liveshow.beauty.view.d
        public void b(@Nullable FKLiveBeautyEditItemModel fKLiveBeautyEditItemModel, @Nullable FKLiveFilterViewModel fKLiveFilterViewModel) {
            Map<String, Float> map;
            if ((fKLiveBeautyEditItemModel != null ? fKLiveBeautyEditItemModel.getCacheValue() : null) != null) {
                FKLiveBeautyEditItemModel fKLiveBeautyEditItemModel2 = (FKLiveBeautyEditItemModel) FKLiveBeautyLayout.this.f14887d.get(fKLiveBeautyEditItemModel.getButtonType().getEffectId());
                if (fKLiveBeautyEditItemModel2 != null) {
                    fKLiveBeautyEditItemModel2.setCacheValue(fKLiveBeautyEditItemModel.getCacheValue());
                }
                g gVar = g.f52734a;
                FKLiveBeautyEditCacheModel c4 = gVar.S().c();
                if (c4 != null && (map = c4.getMap()) != null) {
                    String effectId = fKLiveBeautyEditItemModel.getButtonType().getEffectId();
                    Float cacheValue = fKLiveBeautyEditItemModel.getCacheValue();
                    s.f(cacheValue);
                    map.put(effectId, cacheValue);
                }
                gVar.S().d(c4);
            }
            if (fKLiveBeautyEditItemModel != null) {
                FKLiveBeautyLayout fKLiveBeautyLayout = FKLiveBeautyLayout.this;
                GroupLiveLog groupLiveLog = GroupLiveLog.f18698a;
                String string = fKLiveBeautyLayout.getContext().getString(fKLiveBeautyEditItemModel.getButtonType().typeName());
                s.h(string, "context.getString(model.buttonType.typeName())");
                GroupLiveLog.i(groupLiveLog, string, null, 2, null);
            }
        }
    }

    /* compiled from: FKLiveBeautyLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class c implements com.cupidapp.live.liveshow.beauty.view.b {
        public c() {
        }

        @Override // com.cupidapp.live.liveshow.beauty.view.b
        public void a() {
            ((FKLiveBeautyFilterListLayout) FKLiveBeautyLayout.this.f(R$id.imageEditFilterListLayout)).p(FKLiveBeautyLayout.this.f14886c.getFilterModel());
        }

        @Override // com.cupidapp.live.liveshow.beauty.view.b
        public void b(@NotNull FKLiveFilterViewModel model) {
            s.i(model, "model");
            FKLiveBeautyLayout.this.f14886c.setFilterModel(model);
            g gVar = g.f52734a;
            FKLiveBeautyEditCacheModel c4 = gVar.S().c();
            if (c4 != null) {
                c4.setFilter(model);
            }
            gVar.S().d(c4);
            i.f53231b.E(model.getFilterResource(), model.getFilterIntensity());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveBeautyLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f14891h = new LinkedHashMap();
        FKLiveBeautyButtonEnum fKLiveBeautyButtonEnum = FKLiveBeautyButtonEnum.Filter;
        a aVar = f14885i;
        this.f14886c = new FKLiveBeautyFilterEditItemModel(fKLiveBeautyButtonEnum, aVar.b());
        FKLiveBeautyButtonEnum fKLiveBeautyButtonEnum2 = FKLiveBeautyButtonEnum.BlurBg;
        FKLiveBeautyButtonEnum fKLiveBeautyButtonEnum3 = FKLiveBeautyButtonEnum.Whitening;
        FKLiveBeautyButtonEnum fKLiveBeautyButtonEnum4 = FKLiveBeautyButtonEnum.GrindingSkin;
        FKLiveBeautyButtonEnum fKLiveBeautyButtonEnum5 = FKLiveBeautyButtonEnum.Sharp;
        FKLiveBeautyButtonEnum fKLiveBeautyButtonEnum6 = FKLiveBeautyButtonEnum.ThinFace;
        FKLiveBeautyButtonEnum fKLiveBeautyButtonEnum7 = FKLiveBeautyButtonEnum.NarrowFace;
        FKLiveBeautyButtonEnum fKLiveBeautyButtonEnum8 = FKLiveBeautyButtonEnum.SmallFace;
        FKLiveBeautyButtonEnum fKLiveBeautyButtonEnum9 = FKLiveBeautyButtonEnum.Eye;
        FKLiveBeautyButtonEnum fKLiveBeautyButtonEnum10 = FKLiveBeautyButtonEnum.ThinCheek;
        FKLiveBeautyButtonEnum fKLiveBeautyButtonEnum11 = FKLiveBeautyButtonEnum.ThinNose;
        FKLiveBeautyButtonEnum fKLiveBeautyButtonEnum12 = FKLiveBeautyButtonEnum.Chin;
        FKLiveBeautyButtonEnum fKLiveBeautyButtonEnum13 = FKLiveBeautyButtonEnum.Forehead;
        FKLiveBeautyButtonEnum fKLiveBeautyButtonEnum14 = FKLiveBeautyButtonEnum.RemovePouch;
        FKLiveBeautyButtonEnum fKLiveBeautyButtonEnum15 = FKLiveBeautyButtonEnum.SmileFolds;
        FKLiveBeautyButtonEnum fKLiveBeautyButtonEnum16 = FKLiveBeautyButtonEnum.Clarity;
        FKLiveBeautyButtonEnum fKLiveBeautyButtonEnum17 = FKLiveBeautyButtonEnum.Contrast;
        FKLiveBeautyButtonEnum fKLiveBeautyButtonEnum18 = FKLiveBeautyButtonEnum.Saturation;
        FKLiveBeautyButtonEnum fKLiveBeautyButtonEnum19 = FKLiveBeautyButtonEnum.Brightness;
        this.f14887d = i0.h(f.a(fKLiveBeautyButtonEnum2.getEffectId(), new FKLiveBeautyEditItemModel(fKLiveBeautyButtonEnum2, aVar.a(fKLiveBeautyButtonEnum2))), f.a(fKLiveBeautyButtonEnum3.getEffectId(), new FKLiveBeautyEditItemModel(fKLiveBeautyButtonEnum3, aVar.a(fKLiveBeautyButtonEnum3))), f.a(fKLiveBeautyButtonEnum4.getEffectId(), new FKLiveBeautyEditItemModel(fKLiveBeautyButtonEnum4, aVar.a(fKLiveBeautyButtonEnum4))), f.a(fKLiveBeautyButtonEnum5.getEffectId(), new FKLiveBeautyEditItemModel(fKLiveBeautyButtonEnum5, aVar.a(fKLiveBeautyButtonEnum5))), f.a(fKLiveBeautyButtonEnum6.getEffectId(), new FKLiveBeautyEditItemModel(fKLiveBeautyButtonEnum6, aVar.a(fKLiveBeautyButtonEnum6))), f.a(fKLiveBeautyButtonEnum7.getEffectId(), new FKLiveBeautyEditItemModel(fKLiveBeautyButtonEnum7, aVar.a(fKLiveBeautyButtonEnum7))), f.a(fKLiveBeautyButtonEnum8.getEffectId(), new FKLiveBeautyEditItemModel(fKLiveBeautyButtonEnum8, aVar.a(fKLiveBeautyButtonEnum8))), f.a(fKLiveBeautyButtonEnum9.getEffectId(), new FKLiveBeautyEditItemModel(fKLiveBeautyButtonEnum9, aVar.a(fKLiveBeautyButtonEnum9))), f.a(fKLiveBeautyButtonEnum10.getEffectId(), new FKLiveBeautyEditItemModel(fKLiveBeautyButtonEnum10, aVar.a(fKLiveBeautyButtonEnum10))), f.a(fKLiveBeautyButtonEnum11.getEffectId(), new FKLiveBeautyEditItemModel(fKLiveBeautyButtonEnum11, aVar.a(fKLiveBeautyButtonEnum11))), f.a(fKLiveBeautyButtonEnum12.getEffectId(), new FKLiveBeautyEditItemModel(fKLiveBeautyButtonEnum12, aVar.a(fKLiveBeautyButtonEnum12))), f.a(fKLiveBeautyButtonEnum13.getEffectId(), new FKLiveBeautyEditItemModel(fKLiveBeautyButtonEnum13, aVar.a(fKLiveBeautyButtonEnum13))), f.a(fKLiveBeautyButtonEnum14.getEffectId(), new FKLiveBeautyEditItemModel(fKLiveBeautyButtonEnum14, aVar.a(fKLiveBeautyButtonEnum14))), f.a(fKLiveBeautyButtonEnum15.getEffectId(), new FKLiveBeautyEditItemModel(fKLiveBeautyButtonEnum15, aVar.a(fKLiveBeautyButtonEnum15))), f.a(fKLiveBeautyButtonEnum16.getEffectId(), new FKLiveBeautyEditItemModel(fKLiveBeautyButtonEnum16, aVar.a(fKLiveBeautyButtonEnum16))), f.a(fKLiveBeautyButtonEnum17.getEffectId(), new FKLiveBeautyEditItemModel(fKLiveBeautyButtonEnum17, aVar.a(fKLiveBeautyButtonEnum17))), f.a(fKLiveBeautyButtonEnum18.getEffectId(), new FKLiveBeautyEditItemModel(fKLiveBeautyButtonEnum18, aVar.a(fKLiveBeautyButtonEnum18))), f.a(fKLiveBeautyButtonEnum19.getEffectId(), new FKLiveBeautyEditItemModel(fKLiveBeautyButtonEnum19, aVar.a(fKLiveBeautyButtonEnum19))));
        String string = getContext().getString(R$string.normal);
        s.h(string, "context.getString(R.string.normal)");
        this.f14888e = kotlin.collections.s.o(new LiveStickerModel(string, 1, null, null, null, null, Integer.valueOf(R$mipmap.ban_black), true, 60, null));
        FKLiveBeautyEditButtonListAdapter fKLiveBeautyEditButtonListAdapter = new FKLiveBeautyEditButtonListAdapter();
        fKLiveBeautyEditButtonListAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.beauty.view.FKLiveBeautyLayout$beautyEditAdapter$1$1
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
                List<LiveStickerModel> list;
                if (obj instanceof FKLiveBeautyEditItemModel) {
                    FKLiveBeautyLayout fKLiveBeautyLayout = FKLiveBeautyLayout.this;
                    int i10 = R$id.streamerBeautySeekBarLayout;
                    FKLiveSingleSeekBarLayout fKLiveSingleSeekBarLayout = (FKLiveSingleSeekBarLayout) fKLiveBeautyLayout.f(i10);
                    if (fKLiveSingleSeekBarLayout != null) {
                        fKLiveSingleSeekBarLayout.u((FKLiveBeautyEditItemModel) obj);
                    }
                    FKLiveSingleSeekBarLayout fKLiveSingleSeekBarLayout2 = (FKLiveSingleSeekBarLayout) FKLiveBeautyLayout.this.f(i10);
                    if (fKLiveSingleSeekBarLayout2 != null) {
                        Property<View, Float> ALPHA = View.ALPHA;
                        s.h(ALPHA, "ALPHA");
                        fKLiveSingleSeekBarLayout2.e(ALPHA);
                    }
                    FKLiveBeautyLayout fKLiveBeautyLayout2 = FKLiveBeautyLayout.this;
                    String string2 = fKLiveBeautyLayout2.getContext().getString(((FKLiveBeautyEditItemModel) obj).getButtonType().typeName());
                    s.h(string2, "context.getString(model.buttonType.typeName())");
                    fKLiveBeautyLayout2.k(string2);
                    return;
                }
                if (obj instanceof FKLiveBeautyFilterEditItemModel) {
                    FKLiveBeautyLayout fKLiveBeautyLayout3 = FKLiveBeautyLayout.this;
                    int i11 = R$id.imageEditFilterListLayout;
                    FKLiveBeautyFilterListLayout fKLiveBeautyFilterListLayout = (FKLiveBeautyFilterListLayout) fKLiveBeautyLayout3.f(i11);
                    if (fKLiveBeautyFilterListLayout != null) {
                        fKLiveBeautyFilterListLayout.l(((FKLiveBeautyFilterEditItemModel) obj).getFilterModel());
                    }
                    FKLiveBeautyFilterListLayout fKLiveBeautyFilterListLayout2 = (FKLiveBeautyFilterListLayout) FKLiveBeautyLayout.this.f(i11);
                    if (fKLiveBeautyFilterListLayout2 != null) {
                        Property<View, Float> ALPHA2 = View.ALPHA;
                        s.h(ALPHA2, "ALPHA");
                        fKLiveBeautyFilterListLayout2.e(ALPHA2);
                    }
                    FKLiveBeautyLayout fKLiveBeautyLayout4 = FKLiveBeautyLayout.this;
                    String string3 = fKLiveBeautyLayout4.getContext().getString(((FKLiveBeautyFilterEditItemModel) obj).getButtonType().typeName());
                    s.h(string3, "context.getString(model.buttonType.typeName())");
                    fKLiveBeautyLayout4.k(string3);
                    return;
                }
                if (obj instanceof FKLiveBeautyStickerEditItemModel) {
                    FKLiveBeautyLayout fKLiveBeautyLayout5 = FKLiveBeautyLayout.this;
                    int i12 = R$id.liveStickerListLayout;
                    FKLiveBeautyStickerListLayout fKLiveBeautyStickerListLayout = (FKLiveBeautyStickerListLayout) fKLiveBeautyLayout5.f(i12);
                    if (fKLiveBeautyStickerListLayout != null) {
                        list = FKLiveBeautyLayout.this.f14888e;
                        fKLiveBeautyStickerListLayout.i(list);
                    }
                    FKLiveBeautyStickerListLayout fKLiveBeautyStickerListLayout2 = (FKLiveBeautyStickerListLayout) FKLiveBeautyLayout.this.f(i12);
                    if (fKLiveBeautyStickerListLayout2 != null) {
                        Property<View, Float> ALPHA3 = View.ALPHA;
                        s.h(ALPHA3, "ALPHA");
                        fKLiveBeautyStickerListLayout2.e(ALPHA3);
                    }
                    FKLiveBeautyLayout fKLiveBeautyLayout6 = FKLiveBeautyLayout.this;
                    String string4 = fKLiveBeautyLayout6.getContext().getString(((FKLiveBeautyStickerEditItemModel) obj).getButtonType().typeName());
                    s.h(string4, "context.getString(model.buttonType.typeName())");
                    fKLiveBeautyLayout6.k(string4);
                }
            }
        });
        this.f14890g = fKLiveBeautyEditButtonListAdapter;
        p();
    }

    @Override // com.cupidapp.live.mediapicker.view.CustomAnimationLayout
    public void a() {
        if (((FKLiveSingleSeekBarLayout) f(R$id.streamerBeautySeekBarLayout)).d() || ((FKLiveBeautyFilterListLayout) f(R$id.imageEditFilterListLayout)).d() || ((FKLiveBeautyStickerListLayout) f(R$id.liveStickerListLayout)).d()) {
            return;
        }
        com.cupidapp.live.liveshow.beauty.view.a aVar = this.f14889f;
        if (aVar != null) {
            aVar.a();
        }
        Property<View, Float> ALPHA = View.ALPHA;
        s.h(ALPHA, "ALPHA");
        b(ALPHA);
    }

    @Nullable
    public View f(int i10) {
        Map<Integer, View> map = this.f14891h;
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

    public final void k(String str) {
        GroupLiveLog.f18698a.j(str);
    }

    public final void l() {
        View buttonListCloseLayout = f(R$id.buttonListCloseLayout);
        s.h(buttonListCloseLayout, "buttonListCloseLayout");
        y.d(buttonListCloseLayout, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.beauty.view.FKLiveBeautyLayout$bindClick$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                FKLiveBeautyLayout.this.d();
            }
        });
        FKLiveSingleSeekBarLayout fKLiveSingleSeekBarLayout = (FKLiveSingleSeekBarLayout) f(R$id.streamerBeautySeekBarLayout);
        if (fKLiveSingleSeekBarLayout != null) {
            fKLiveSingleSeekBarLayout.setSingleSeekBarListener(new b());
        }
        ((FKLiveBeautyFilterListLayout) f(R$id.imageEditFilterListLayout)).setMediaEditFilterListListener(new c());
    }

    public final void m(@NotNull List<LiveStickerModel> stickers) {
        s.i(stickers, "stickers");
        if (stickers.isEmpty()) {
            return;
        }
        this.f14888e.addAll(stickers);
        List<Object> j10 = this.f14890g.j();
        ArrayList arrayList = new ArrayList();
        for (Object obj : j10) {
            if (obj instanceof FKLiveBeautyStickerEditItemModel) {
                arrayList.add(obj);
            }
        }
        if (((FKLiveBeautyStickerEditItemModel) CollectionsKt___CollectionsKt.V(arrayList)) == null) {
            this.f14890g.j().add(1, new FKLiveBeautyStickerEditItemModel(FKLiveBeautyButtonEnum.Sticker));
            this.f14890g.notifyItemInserted(1);
        }
    }

    public final void o() {
        this.f14890g.d(this.f14886c);
        this.f14890g.e(CollectionsKt___CollectionsKt.x0(this.f14887d.values()));
        this.f14890g.notifyDataSetChanged();
    }

    public final void p() {
        z.a(this, R$layout.layout_live_beauty_edit_button_list, true);
        int i10 = R$id.buttonListRecyclerView;
        ((RecyclerView) f(i10)).setAdapter(this.f14890g);
        ((RecyclerView) f(i10)).setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        int c4 = h.c(this, 7.5f);
        ((RecyclerView) f(i10)).addItemDecoration(new FKAddExtraSpacingDecoration(c4, 0, c4, 0, c4, 0, 32, null));
        o();
        l();
    }

    public final void setListener(@NotNull com.cupidapp.live.liveshow.beauty.view.a listener) {
        s.i(listener, "listener");
        this.f14889f = listener;
    }

    public final void setLiveSticker(@Nullable String str) {
        LiveStickerModel liveStickerModel;
        Iterator<LiveStickerModel> iterator2 = this.f14888e.iterator2();
        while (true) {
            if (!iterator2.hasNext()) {
                liveStickerModel = null;
                break;
            } else {
                liveStickerModel = iterator2.next();
                if (s.d(liveStickerModel.getResourcePath(), str)) {
                    break;
                }
            }
        }
        LiveStickerModel liveStickerModel2 = liveStickerModel;
        int i10 = R$id.liveStickerListLayout;
        ((FKLiveBeautyStickerListLayout) f(i10)).setCurrentSticker(liveStickerModel2);
        ((FKLiveBeautyStickerListLayout) f(i10)).setLiveSticker(liveStickerModel2 != null ? liveStickerModel2.getResourcePath() : null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveBeautyLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f14891h = new LinkedHashMap();
        FKLiveBeautyButtonEnum fKLiveBeautyButtonEnum = FKLiveBeautyButtonEnum.Filter;
        a aVar = f14885i;
        this.f14886c = new FKLiveBeautyFilterEditItemModel(fKLiveBeautyButtonEnum, aVar.b());
        FKLiveBeautyButtonEnum fKLiveBeautyButtonEnum2 = FKLiveBeautyButtonEnum.BlurBg;
        FKLiveBeautyButtonEnum fKLiveBeautyButtonEnum3 = FKLiveBeautyButtonEnum.Whitening;
        FKLiveBeautyButtonEnum fKLiveBeautyButtonEnum4 = FKLiveBeautyButtonEnum.GrindingSkin;
        FKLiveBeautyButtonEnum fKLiveBeautyButtonEnum5 = FKLiveBeautyButtonEnum.Sharp;
        FKLiveBeautyButtonEnum fKLiveBeautyButtonEnum6 = FKLiveBeautyButtonEnum.ThinFace;
        FKLiveBeautyButtonEnum fKLiveBeautyButtonEnum7 = FKLiveBeautyButtonEnum.NarrowFace;
        FKLiveBeautyButtonEnum fKLiveBeautyButtonEnum8 = FKLiveBeautyButtonEnum.SmallFace;
        FKLiveBeautyButtonEnum fKLiveBeautyButtonEnum9 = FKLiveBeautyButtonEnum.Eye;
        FKLiveBeautyButtonEnum fKLiveBeautyButtonEnum10 = FKLiveBeautyButtonEnum.ThinCheek;
        FKLiveBeautyButtonEnum fKLiveBeautyButtonEnum11 = FKLiveBeautyButtonEnum.ThinNose;
        FKLiveBeautyButtonEnum fKLiveBeautyButtonEnum12 = FKLiveBeautyButtonEnum.Chin;
        FKLiveBeautyButtonEnum fKLiveBeautyButtonEnum13 = FKLiveBeautyButtonEnum.Forehead;
        FKLiveBeautyButtonEnum fKLiveBeautyButtonEnum14 = FKLiveBeautyButtonEnum.RemovePouch;
        FKLiveBeautyButtonEnum fKLiveBeautyButtonEnum15 = FKLiveBeautyButtonEnum.SmileFolds;
        FKLiveBeautyButtonEnum fKLiveBeautyButtonEnum16 = FKLiveBeautyButtonEnum.Clarity;
        FKLiveBeautyButtonEnum fKLiveBeautyButtonEnum17 = FKLiveBeautyButtonEnum.Contrast;
        FKLiveBeautyButtonEnum fKLiveBeautyButtonEnum18 = FKLiveBeautyButtonEnum.Saturation;
        FKLiveBeautyButtonEnum fKLiveBeautyButtonEnum19 = FKLiveBeautyButtonEnum.Brightness;
        this.f14887d = i0.h(f.a(fKLiveBeautyButtonEnum2.getEffectId(), new FKLiveBeautyEditItemModel(fKLiveBeautyButtonEnum2, aVar.a(fKLiveBeautyButtonEnum2))), f.a(fKLiveBeautyButtonEnum3.getEffectId(), new FKLiveBeautyEditItemModel(fKLiveBeautyButtonEnum3, aVar.a(fKLiveBeautyButtonEnum3))), f.a(fKLiveBeautyButtonEnum4.getEffectId(), new FKLiveBeautyEditItemModel(fKLiveBeautyButtonEnum4, aVar.a(fKLiveBeautyButtonEnum4))), f.a(fKLiveBeautyButtonEnum5.getEffectId(), new FKLiveBeautyEditItemModel(fKLiveBeautyButtonEnum5, aVar.a(fKLiveBeautyButtonEnum5))), f.a(fKLiveBeautyButtonEnum6.getEffectId(), new FKLiveBeautyEditItemModel(fKLiveBeautyButtonEnum6, aVar.a(fKLiveBeautyButtonEnum6))), f.a(fKLiveBeautyButtonEnum7.getEffectId(), new FKLiveBeautyEditItemModel(fKLiveBeautyButtonEnum7, aVar.a(fKLiveBeautyButtonEnum7))), f.a(fKLiveBeautyButtonEnum8.getEffectId(), new FKLiveBeautyEditItemModel(fKLiveBeautyButtonEnum8, aVar.a(fKLiveBeautyButtonEnum8))), f.a(fKLiveBeautyButtonEnum9.getEffectId(), new FKLiveBeautyEditItemModel(fKLiveBeautyButtonEnum9, aVar.a(fKLiveBeautyButtonEnum9))), f.a(fKLiveBeautyButtonEnum10.getEffectId(), new FKLiveBeautyEditItemModel(fKLiveBeautyButtonEnum10, aVar.a(fKLiveBeautyButtonEnum10))), f.a(fKLiveBeautyButtonEnum11.getEffectId(), new FKLiveBeautyEditItemModel(fKLiveBeautyButtonEnum11, aVar.a(fKLiveBeautyButtonEnum11))), f.a(fKLiveBeautyButtonEnum12.getEffectId(), new FKLiveBeautyEditItemModel(fKLiveBeautyButtonEnum12, aVar.a(fKLiveBeautyButtonEnum12))), f.a(fKLiveBeautyButtonEnum13.getEffectId(), new FKLiveBeautyEditItemModel(fKLiveBeautyButtonEnum13, aVar.a(fKLiveBeautyButtonEnum13))), f.a(fKLiveBeautyButtonEnum14.getEffectId(), new FKLiveBeautyEditItemModel(fKLiveBeautyButtonEnum14, aVar.a(fKLiveBeautyButtonEnum14))), f.a(fKLiveBeautyButtonEnum15.getEffectId(), new FKLiveBeautyEditItemModel(fKLiveBeautyButtonEnum15, aVar.a(fKLiveBeautyButtonEnum15))), f.a(fKLiveBeautyButtonEnum16.getEffectId(), new FKLiveBeautyEditItemModel(fKLiveBeautyButtonEnum16, aVar.a(fKLiveBeautyButtonEnum16))), f.a(fKLiveBeautyButtonEnum17.getEffectId(), new FKLiveBeautyEditItemModel(fKLiveBeautyButtonEnum17, aVar.a(fKLiveBeautyButtonEnum17))), f.a(fKLiveBeautyButtonEnum18.getEffectId(), new FKLiveBeautyEditItemModel(fKLiveBeautyButtonEnum18, aVar.a(fKLiveBeautyButtonEnum18))), f.a(fKLiveBeautyButtonEnum19.getEffectId(), new FKLiveBeautyEditItemModel(fKLiveBeautyButtonEnum19, aVar.a(fKLiveBeautyButtonEnum19))));
        String string = getContext().getString(R$string.normal);
        s.h(string, "context.getString(R.string.normal)");
        this.f14888e = kotlin.collections.s.o(new LiveStickerModel(string, 1, null, null, null, null, Integer.valueOf(R$mipmap.ban_black), true, 60, null));
        FKLiveBeautyEditButtonListAdapter fKLiveBeautyEditButtonListAdapter = new FKLiveBeautyEditButtonListAdapter();
        fKLiveBeautyEditButtonListAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.beauty.view.FKLiveBeautyLayout$beautyEditAdapter$1$1
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
                List<LiveStickerModel> list;
                if (obj instanceof FKLiveBeautyEditItemModel) {
                    FKLiveBeautyLayout fKLiveBeautyLayout = FKLiveBeautyLayout.this;
                    int i10 = R$id.streamerBeautySeekBarLayout;
                    FKLiveSingleSeekBarLayout fKLiveSingleSeekBarLayout = (FKLiveSingleSeekBarLayout) fKLiveBeautyLayout.f(i10);
                    if (fKLiveSingleSeekBarLayout != null) {
                        fKLiveSingleSeekBarLayout.u((FKLiveBeautyEditItemModel) obj);
                    }
                    FKLiveSingleSeekBarLayout fKLiveSingleSeekBarLayout2 = (FKLiveSingleSeekBarLayout) FKLiveBeautyLayout.this.f(i10);
                    if (fKLiveSingleSeekBarLayout2 != null) {
                        Property<View, Float> ALPHA = View.ALPHA;
                        s.h(ALPHA, "ALPHA");
                        fKLiveSingleSeekBarLayout2.e(ALPHA);
                    }
                    FKLiveBeautyLayout fKLiveBeautyLayout2 = FKLiveBeautyLayout.this;
                    String string2 = fKLiveBeautyLayout2.getContext().getString(((FKLiveBeautyEditItemModel) obj).getButtonType().typeName());
                    s.h(string2, "context.getString(model.buttonType.typeName())");
                    fKLiveBeautyLayout2.k(string2);
                    return;
                }
                if (obj instanceof FKLiveBeautyFilterEditItemModel) {
                    FKLiveBeautyLayout fKLiveBeautyLayout3 = FKLiveBeautyLayout.this;
                    int i11 = R$id.imageEditFilterListLayout;
                    FKLiveBeautyFilterListLayout fKLiveBeautyFilterListLayout = (FKLiveBeautyFilterListLayout) fKLiveBeautyLayout3.f(i11);
                    if (fKLiveBeautyFilterListLayout != null) {
                        fKLiveBeautyFilterListLayout.l(((FKLiveBeautyFilterEditItemModel) obj).getFilterModel());
                    }
                    FKLiveBeautyFilterListLayout fKLiveBeautyFilterListLayout2 = (FKLiveBeautyFilterListLayout) FKLiveBeautyLayout.this.f(i11);
                    if (fKLiveBeautyFilterListLayout2 != null) {
                        Property<View, Float> ALPHA2 = View.ALPHA;
                        s.h(ALPHA2, "ALPHA");
                        fKLiveBeautyFilterListLayout2.e(ALPHA2);
                    }
                    FKLiveBeautyLayout fKLiveBeautyLayout4 = FKLiveBeautyLayout.this;
                    String string3 = fKLiveBeautyLayout4.getContext().getString(((FKLiveBeautyFilterEditItemModel) obj).getButtonType().typeName());
                    s.h(string3, "context.getString(model.buttonType.typeName())");
                    fKLiveBeautyLayout4.k(string3);
                    return;
                }
                if (obj instanceof FKLiveBeautyStickerEditItemModel) {
                    FKLiveBeautyLayout fKLiveBeautyLayout5 = FKLiveBeautyLayout.this;
                    int i12 = R$id.liveStickerListLayout;
                    FKLiveBeautyStickerListLayout fKLiveBeautyStickerListLayout = (FKLiveBeautyStickerListLayout) fKLiveBeautyLayout5.f(i12);
                    if (fKLiveBeautyStickerListLayout != null) {
                        list = FKLiveBeautyLayout.this.f14888e;
                        fKLiveBeautyStickerListLayout.i(list);
                    }
                    FKLiveBeautyStickerListLayout fKLiveBeautyStickerListLayout2 = (FKLiveBeautyStickerListLayout) FKLiveBeautyLayout.this.f(i12);
                    if (fKLiveBeautyStickerListLayout2 != null) {
                        Property<View, Float> ALPHA3 = View.ALPHA;
                        s.h(ALPHA3, "ALPHA");
                        fKLiveBeautyStickerListLayout2.e(ALPHA3);
                    }
                    FKLiveBeautyLayout fKLiveBeautyLayout6 = FKLiveBeautyLayout.this;
                    String string4 = fKLiveBeautyLayout6.getContext().getString(((FKLiveBeautyStickerEditItemModel) obj).getButtonType().typeName());
                    s.h(string4, "context.getString(model.buttonType.typeName())");
                    fKLiveBeautyLayout6.k(string4);
                }
            }
        });
        this.f14890g = fKLiveBeautyEditButtonListAdapter;
        p();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveBeautyLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f14891h = new LinkedHashMap();
        FKLiveBeautyButtonEnum fKLiveBeautyButtonEnum = FKLiveBeautyButtonEnum.Filter;
        a aVar = f14885i;
        this.f14886c = new FKLiveBeautyFilterEditItemModel(fKLiveBeautyButtonEnum, aVar.b());
        FKLiveBeautyButtonEnum fKLiveBeautyButtonEnum2 = FKLiveBeautyButtonEnum.BlurBg;
        FKLiveBeautyButtonEnum fKLiveBeautyButtonEnum3 = FKLiveBeautyButtonEnum.Whitening;
        FKLiveBeautyButtonEnum fKLiveBeautyButtonEnum4 = FKLiveBeautyButtonEnum.GrindingSkin;
        FKLiveBeautyButtonEnum fKLiveBeautyButtonEnum5 = FKLiveBeautyButtonEnum.Sharp;
        FKLiveBeautyButtonEnum fKLiveBeautyButtonEnum6 = FKLiveBeautyButtonEnum.ThinFace;
        FKLiveBeautyButtonEnum fKLiveBeautyButtonEnum7 = FKLiveBeautyButtonEnum.NarrowFace;
        FKLiveBeautyButtonEnum fKLiveBeautyButtonEnum8 = FKLiveBeautyButtonEnum.SmallFace;
        FKLiveBeautyButtonEnum fKLiveBeautyButtonEnum9 = FKLiveBeautyButtonEnum.Eye;
        FKLiveBeautyButtonEnum fKLiveBeautyButtonEnum10 = FKLiveBeautyButtonEnum.ThinCheek;
        FKLiveBeautyButtonEnum fKLiveBeautyButtonEnum11 = FKLiveBeautyButtonEnum.ThinNose;
        FKLiveBeautyButtonEnum fKLiveBeautyButtonEnum12 = FKLiveBeautyButtonEnum.Chin;
        FKLiveBeautyButtonEnum fKLiveBeautyButtonEnum13 = FKLiveBeautyButtonEnum.Forehead;
        FKLiveBeautyButtonEnum fKLiveBeautyButtonEnum14 = FKLiveBeautyButtonEnum.RemovePouch;
        FKLiveBeautyButtonEnum fKLiveBeautyButtonEnum15 = FKLiveBeautyButtonEnum.SmileFolds;
        FKLiveBeautyButtonEnum fKLiveBeautyButtonEnum16 = FKLiveBeautyButtonEnum.Clarity;
        FKLiveBeautyButtonEnum fKLiveBeautyButtonEnum17 = FKLiveBeautyButtonEnum.Contrast;
        FKLiveBeautyButtonEnum fKLiveBeautyButtonEnum18 = FKLiveBeautyButtonEnum.Saturation;
        FKLiveBeautyButtonEnum fKLiveBeautyButtonEnum19 = FKLiveBeautyButtonEnum.Brightness;
        this.f14887d = i0.h(f.a(fKLiveBeautyButtonEnum2.getEffectId(), new FKLiveBeautyEditItemModel(fKLiveBeautyButtonEnum2, aVar.a(fKLiveBeautyButtonEnum2))), f.a(fKLiveBeautyButtonEnum3.getEffectId(), new FKLiveBeautyEditItemModel(fKLiveBeautyButtonEnum3, aVar.a(fKLiveBeautyButtonEnum3))), f.a(fKLiveBeautyButtonEnum4.getEffectId(), new FKLiveBeautyEditItemModel(fKLiveBeautyButtonEnum4, aVar.a(fKLiveBeautyButtonEnum4))), f.a(fKLiveBeautyButtonEnum5.getEffectId(), new FKLiveBeautyEditItemModel(fKLiveBeautyButtonEnum5, aVar.a(fKLiveBeautyButtonEnum5))), f.a(fKLiveBeautyButtonEnum6.getEffectId(), new FKLiveBeautyEditItemModel(fKLiveBeautyButtonEnum6, aVar.a(fKLiveBeautyButtonEnum6))), f.a(fKLiveBeautyButtonEnum7.getEffectId(), new FKLiveBeautyEditItemModel(fKLiveBeautyButtonEnum7, aVar.a(fKLiveBeautyButtonEnum7))), f.a(fKLiveBeautyButtonEnum8.getEffectId(), new FKLiveBeautyEditItemModel(fKLiveBeautyButtonEnum8, aVar.a(fKLiveBeautyButtonEnum8))), f.a(fKLiveBeautyButtonEnum9.getEffectId(), new FKLiveBeautyEditItemModel(fKLiveBeautyButtonEnum9, aVar.a(fKLiveBeautyButtonEnum9))), f.a(fKLiveBeautyButtonEnum10.getEffectId(), new FKLiveBeautyEditItemModel(fKLiveBeautyButtonEnum10, aVar.a(fKLiveBeautyButtonEnum10))), f.a(fKLiveBeautyButtonEnum11.getEffectId(), new FKLiveBeautyEditItemModel(fKLiveBeautyButtonEnum11, aVar.a(fKLiveBeautyButtonEnum11))), f.a(fKLiveBeautyButtonEnum12.getEffectId(), new FKLiveBeautyEditItemModel(fKLiveBeautyButtonEnum12, aVar.a(fKLiveBeautyButtonEnum12))), f.a(fKLiveBeautyButtonEnum13.getEffectId(), new FKLiveBeautyEditItemModel(fKLiveBeautyButtonEnum13, aVar.a(fKLiveBeautyButtonEnum13))), f.a(fKLiveBeautyButtonEnum14.getEffectId(), new FKLiveBeautyEditItemModel(fKLiveBeautyButtonEnum14, aVar.a(fKLiveBeautyButtonEnum14))), f.a(fKLiveBeautyButtonEnum15.getEffectId(), new FKLiveBeautyEditItemModel(fKLiveBeautyButtonEnum15, aVar.a(fKLiveBeautyButtonEnum15))), f.a(fKLiveBeautyButtonEnum16.getEffectId(), new FKLiveBeautyEditItemModel(fKLiveBeautyButtonEnum16, aVar.a(fKLiveBeautyButtonEnum16))), f.a(fKLiveBeautyButtonEnum17.getEffectId(), new FKLiveBeautyEditItemModel(fKLiveBeautyButtonEnum17, aVar.a(fKLiveBeautyButtonEnum17))), f.a(fKLiveBeautyButtonEnum18.getEffectId(), new FKLiveBeautyEditItemModel(fKLiveBeautyButtonEnum18, aVar.a(fKLiveBeautyButtonEnum18))), f.a(fKLiveBeautyButtonEnum19.getEffectId(), new FKLiveBeautyEditItemModel(fKLiveBeautyButtonEnum19, aVar.a(fKLiveBeautyButtonEnum19))));
        String string = getContext().getString(R$string.normal);
        s.h(string, "context.getString(R.string.normal)");
        this.f14888e = kotlin.collections.s.o(new LiveStickerModel(string, 1, null, null, null, null, Integer.valueOf(R$mipmap.ban_black), true, 60, null));
        FKLiveBeautyEditButtonListAdapter fKLiveBeautyEditButtonListAdapter = new FKLiveBeautyEditButtonListAdapter();
        fKLiveBeautyEditButtonListAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.beauty.view.FKLiveBeautyLayout$beautyEditAdapter$1$1
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
                List<LiveStickerModel> list;
                if (obj instanceof FKLiveBeautyEditItemModel) {
                    FKLiveBeautyLayout fKLiveBeautyLayout = FKLiveBeautyLayout.this;
                    int i102 = R$id.streamerBeautySeekBarLayout;
                    FKLiveSingleSeekBarLayout fKLiveSingleSeekBarLayout = (FKLiveSingleSeekBarLayout) fKLiveBeautyLayout.f(i102);
                    if (fKLiveSingleSeekBarLayout != null) {
                        fKLiveSingleSeekBarLayout.u((FKLiveBeautyEditItemModel) obj);
                    }
                    FKLiveSingleSeekBarLayout fKLiveSingleSeekBarLayout2 = (FKLiveSingleSeekBarLayout) FKLiveBeautyLayout.this.f(i102);
                    if (fKLiveSingleSeekBarLayout2 != null) {
                        Property<View, Float> ALPHA = View.ALPHA;
                        s.h(ALPHA, "ALPHA");
                        fKLiveSingleSeekBarLayout2.e(ALPHA);
                    }
                    FKLiveBeautyLayout fKLiveBeautyLayout2 = FKLiveBeautyLayout.this;
                    String string2 = fKLiveBeautyLayout2.getContext().getString(((FKLiveBeautyEditItemModel) obj).getButtonType().typeName());
                    s.h(string2, "context.getString(model.buttonType.typeName())");
                    fKLiveBeautyLayout2.k(string2);
                    return;
                }
                if (obj instanceof FKLiveBeautyFilterEditItemModel) {
                    FKLiveBeautyLayout fKLiveBeautyLayout3 = FKLiveBeautyLayout.this;
                    int i11 = R$id.imageEditFilterListLayout;
                    FKLiveBeautyFilterListLayout fKLiveBeautyFilterListLayout = (FKLiveBeautyFilterListLayout) fKLiveBeautyLayout3.f(i11);
                    if (fKLiveBeautyFilterListLayout != null) {
                        fKLiveBeautyFilterListLayout.l(((FKLiveBeautyFilterEditItemModel) obj).getFilterModel());
                    }
                    FKLiveBeautyFilterListLayout fKLiveBeautyFilterListLayout2 = (FKLiveBeautyFilterListLayout) FKLiveBeautyLayout.this.f(i11);
                    if (fKLiveBeautyFilterListLayout2 != null) {
                        Property<View, Float> ALPHA2 = View.ALPHA;
                        s.h(ALPHA2, "ALPHA");
                        fKLiveBeautyFilterListLayout2.e(ALPHA2);
                    }
                    FKLiveBeautyLayout fKLiveBeautyLayout4 = FKLiveBeautyLayout.this;
                    String string3 = fKLiveBeautyLayout4.getContext().getString(((FKLiveBeautyFilterEditItemModel) obj).getButtonType().typeName());
                    s.h(string3, "context.getString(model.buttonType.typeName())");
                    fKLiveBeautyLayout4.k(string3);
                    return;
                }
                if (obj instanceof FKLiveBeautyStickerEditItemModel) {
                    FKLiveBeautyLayout fKLiveBeautyLayout5 = FKLiveBeautyLayout.this;
                    int i12 = R$id.liveStickerListLayout;
                    FKLiveBeautyStickerListLayout fKLiveBeautyStickerListLayout = (FKLiveBeautyStickerListLayout) fKLiveBeautyLayout5.f(i12);
                    if (fKLiveBeautyStickerListLayout != null) {
                        list = FKLiveBeautyLayout.this.f14888e;
                        fKLiveBeautyStickerListLayout.i(list);
                    }
                    FKLiveBeautyStickerListLayout fKLiveBeautyStickerListLayout2 = (FKLiveBeautyStickerListLayout) FKLiveBeautyLayout.this.f(i12);
                    if (fKLiveBeautyStickerListLayout2 != null) {
                        Property<View, Float> ALPHA3 = View.ALPHA;
                        s.h(ALPHA3, "ALPHA");
                        fKLiveBeautyStickerListLayout2.e(ALPHA3);
                    }
                    FKLiveBeautyLayout fKLiveBeautyLayout6 = FKLiveBeautyLayout.this;
                    String string4 = fKLiveBeautyLayout6.getContext().getString(((FKLiveBeautyStickerEditItemModel) obj).getButtonType().typeName());
                    s.h(string4, "context.getString(model.buttonType.typeName())");
                    fKLiveBeautyLayout6.k(string4);
                }
            }
        });
        this.f14890g = fKLiveBeautyEditButtonListAdapter;
        p();
    }
}
