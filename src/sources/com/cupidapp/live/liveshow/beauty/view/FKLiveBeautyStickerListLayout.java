package com.cupidapp.live.liveshow.beauty.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.view.decoration.FKAddExtraSpacingDecoration;
import com.cupidapp.live.base.view.h;
import com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum;
import com.cupidapp.live.liveshow.model.LiveStickerModel;
import com.cupidapp.live.mediapicker.view.BottomConfirmAndCancelLayout;
import com.cupidapp.live.mediapicker.view.CustomAnimationLayout;
import com.cupidapp.live.track.group.GroupLiveLog;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r2.i;
import z0.z;

/* compiled from: FKLiveBeautyStickerListLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveBeautyStickerListLayout extends CustomAnimationLayout {

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public LiveStickerModel f14894c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final Lazy f14895d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14896e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveBeautyStickerListLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f14896e = new LinkedHashMap();
        this.f14895d = kotlin.c.b(new Function0<FKLiveStickerAdapter>() { // from class: com.cupidapp.live.liveshow.beauty.view.FKLiveBeautyStickerListLayout$stickerAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FKLiveStickerAdapter invoke() {
                final FKLiveStickerAdapter fKLiveStickerAdapter = new FKLiveStickerAdapter();
                final FKLiveBeautyStickerListLayout fKLiveBeautyStickerListLayout = FKLiveBeautyStickerListLayout.this;
                fKLiveStickerAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.beauty.view.FKLiveBeautyStickerListLayout$stickerAdapter$2$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        if (obj instanceof LiveStickerModel) {
                            LiveStickerModel liveStickerModel = (LiveStickerModel) obj;
                            if (liveStickerModel.isLight() != 0) {
                                if (liveStickerModel.isSelected()) {
                                    return;
                                }
                                for (Object obj2 : FKLiveStickerAdapter.this.j()) {
                                    if (obj2 instanceof LiveStickerModel) {
                                        LiveStickerModel liveStickerModel2 = (LiveStickerModel) obj2;
                                        liveStickerModel2.setSelected(s.d(liveStickerModel.getResourcePath(), liveStickerModel2.getResourcePath()));
                                    }
                                }
                                FKLiveStickerAdapter.this.notifyDataSetChanged();
                                fKLiveBeautyStickerListLayout.setLiveSticker(liveStickerModel.getResourcePath());
                                return;
                            }
                            h.f12779a.q(R$string.sticker_useless_prompt);
                        }
                    }
                });
                return fKLiveStickerAdapter;
            }
        });
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LiveStickerModel getCurrentSelectedSticker() {
        List<Object> j10 = getStickerAdapter().j();
        ArrayList<LiveStickerModel> arrayList = new ArrayList();
        for (Object obj : j10) {
            if (obj instanceof LiveStickerModel) {
                arrayList.add(obj);
            }
        }
        for (LiveStickerModel liveStickerModel : arrayList) {
            if (liveStickerModel.isSelected()) {
                return liveStickerModel;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    private final FKLiveStickerAdapter getStickerAdapter() {
        return (FKLiveStickerAdapter) this.f14895d.getValue();
    }

    @Override // com.cupidapp.live.mediapicker.view.CustomAnimationLayout
    public void a() {
        LiveStickerModel liveStickerModel = this.f14894c;
        setLiveSticker(liveStickerModel != null ? liveStickerModel.getResourcePath() : null);
        Property<View, Float> ALPHA = View.ALPHA;
        s.h(ALPHA, "ALPHA");
        b(ALPHA);
    }

    @Nullable
    public View f(int i10) {
        Map<Integer, View> map = this.f14896e;
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

    @Nullable
    public final LiveStickerModel getCurrentSticker() {
        return this.f14894c;
    }

    public final void h() {
        final BottomConfirmAndCancelLayout bottomConfirmAndCancelLayout = (BottomConfirmAndCancelLayout) f(R$id.stickerConfirmAndCancelLayout);
        bottomConfirmAndCancelLayout.setConfirmButtonClickEvent(new Function0<p>() { // from class: com.cupidapp.live.liveshow.beauty.view.FKLiveBeautyStickerListLayout$bindClickEvent$1$1
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
                LiveStickerModel currentSelectedSticker;
                FKLiveBeautyStickerListLayout fKLiveBeautyStickerListLayout = FKLiveBeautyStickerListLayout.this;
                currentSelectedSticker = fKLiveBeautyStickerListLayout.getCurrentSelectedSticker();
                fKLiveBeautyStickerListLayout.setCurrentSticker(currentSelectedSticker);
                FKLiveBeautyStickerListLayout fKLiveBeautyStickerListLayout2 = FKLiveBeautyStickerListLayout.this;
                LiveStickerModel currentSticker = fKLiveBeautyStickerListLayout2.getCurrentSticker();
                fKLiveBeautyStickerListLayout2.setLiveSticker(currentSticker != null ? currentSticker.getResourcePath() : null);
                FKLiveBeautyStickerListLayout fKLiveBeautyStickerListLayout3 = FKLiveBeautyStickerListLayout.this;
                Property<View, Float> ALPHA = View.ALPHA;
                s.h(ALPHA, "ALPHA");
                fKLiveBeautyStickerListLayout3.b(ALPHA);
                GroupLiveLog groupLiveLog = GroupLiveLog.f18698a;
                String string = bottomConfirmAndCancelLayout.getContext().getString(FKLiveBeautyButtonEnum.Sticker.typeName());
                s.h(string, "context.getString(FKLive…nEnum.Sticker.typeName())");
                LiveStickerModel currentSticker2 = FKLiveBeautyStickerListLayout.this.getCurrentSticker();
                groupLiveLog.h(string, currentSticker2 != null ? currentSticker2.getPrivilegesName() : null);
            }
        });
        bottomConfirmAndCancelLayout.setCancelButtonClickEvent(new Function0<p>() { // from class: com.cupidapp.live.liveshow.beauty.view.FKLiveBeautyStickerListLayout$bindClickEvent$1$2
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
                FKLiveBeautyStickerListLayout.this.d();
            }
        });
    }

    public final void i(@NotNull List<LiveStickerModel> stickers) {
        s.i(stickers, "stickers");
        if (this.f14894c == null) {
            this.f14894c = (LiveStickerModel) CollectionsKt___CollectionsKt.T(stickers);
        }
        getStickerAdapter().j().clear();
        for (LiveStickerModel liveStickerModel : stickers) {
            String resourcePath = liveStickerModel.getResourcePath();
            LiveStickerModel liveStickerModel2 = this.f14894c;
            liveStickerModel.setSelected(s.d(resourcePath, liveStickerModel2 != null ? liveStickerModel2.getResourcePath() : null));
        }
        getStickerAdapter().e(stickers);
        getStickerAdapter().notifyDataSetChanged();
    }

    public final void j() {
        z.a(this, R$layout.layout_live_beauty_sticker_list, true);
        RecyclerView initView$lambda$0 = (RecyclerView) f(R$id.stickerRecyclerView);
        initView$lambda$0.setAdapter(getStickerAdapter());
        initView$lambda$0.setLayoutManager(new LinearLayoutManager(initView$lambda$0.getContext(), 0, false));
        s.h(initView$lambda$0, "initView$lambda$0");
        int c4 = z0.h.c(initView$lambda$0, 7.5f);
        initView$lambda$0.addItemDecoration(new FKAddExtraSpacingDecoration(c4, c4, c4, 0, c4, 0, 32, null));
        h();
    }

    public final void setCurrentSticker(@Nullable LiveStickerModel liveStickerModel) {
        this.f14894c = liveStickerModel;
    }

    public final void setLiveSticker(@Nullable String str) {
        i.f53231b.K(str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveBeautyStickerListLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f14896e = new LinkedHashMap();
        this.f14895d = kotlin.c.b(new Function0<FKLiveStickerAdapter>() { // from class: com.cupidapp.live.liveshow.beauty.view.FKLiveBeautyStickerListLayout$stickerAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FKLiveStickerAdapter invoke() {
                final FKLiveStickerAdapter fKLiveStickerAdapter = new FKLiveStickerAdapter();
                final FKLiveBeautyStickerListLayout fKLiveBeautyStickerListLayout = FKLiveBeautyStickerListLayout.this;
                fKLiveStickerAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.beauty.view.FKLiveBeautyStickerListLayout$stickerAdapter$2$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        if (obj instanceof LiveStickerModel) {
                            LiveStickerModel liveStickerModel = (LiveStickerModel) obj;
                            if (liveStickerModel.isLight() != 0) {
                                if (liveStickerModel.isSelected()) {
                                    return;
                                }
                                for (Object obj2 : FKLiveStickerAdapter.this.j()) {
                                    if (obj2 instanceof LiveStickerModel) {
                                        LiveStickerModel liveStickerModel2 = (LiveStickerModel) obj2;
                                        liveStickerModel2.setSelected(s.d(liveStickerModel.getResourcePath(), liveStickerModel2.getResourcePath()));
                                    }
                                }
                                FKLiveStickerAdapter.this.notifyDataSetChanged();
                                fKLiveBeautyStickerListLayout.setLiveSticker(liveStickerModel.getResourcePath());
                                return;
                            }
                            h.f12779a.q(R$string.sticker_useless_prompt);
                        }
                    }
                });
                return fKLiveStickerAdapter;
            }
        });
        j();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveBeautyStickerListLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f14896e = new LinkedHashMap();
        this.f14895d = kotlin.c.b(new Function0<FKLiveStickerAdapter>() { // from class: com.cupidapp.live.liveshow.beauty.view.FKLiveBeautyStickerListLayout$stickerAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FKLiveStickerAdapter invoke() {
                final FKLiveStickerAdapter fKLiveStickerAdapter = new FKLiveStickerAdapter();
                final FKLiveBeautyStickerListLayout fKLiveBeautyStickerListLayout = FKLiveBeautyStickerListLayout.this;
                fKLiveStickerAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.beauty.view.FKLiveBeautyStickerListLayout$stickerAdapter$2$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        if (obj instanceof LiveStickerModel) {
                            LiveStickerModel liveStickerModel = (LiveStickerModel) obj;
                            if (liveStickerModel.isLight() != 0) {
                                if (liveStickerModel.isSelected()) {
                                    return;
                                }
                                for (Object obj2 : FKLiveStickerAdapter.this.j()) {
                                    if (obj2 instanceof LiveStickerModel) {
                                        LiveStickerModel liveStickerModel2 = (LiveStickerModel) obj2;
                                        liveStickerModel2.setSelected(s.d(liveStickerModel.getResourcePath(), liveStickerModel2.getResourcePath()));
                                    }
                                }
                                FKLiveStickerAdapter.this.notifyDataSetChanged();
                                fKLiveBeautyStickerListLayout.setLiveSticker(liveStickerModel.getResourcePath());
                                return;
                            }
                            h.f12779a.q(R$string.sticker_useless_prompt);
                        }
                    }
                });
                return fKLiveStickerAdapter;
            }
        });
        j();
    }
}
