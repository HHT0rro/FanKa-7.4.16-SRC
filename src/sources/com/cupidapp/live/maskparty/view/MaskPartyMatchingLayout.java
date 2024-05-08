package com.cupidapp.live.maskparty.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.view.animation.FKSVGAImageView;
import com.cupidapp.live.maskparty.model.ItemCardFeaturesItemModel;
import com.cupidapp.live.maskparty.model.ItemCardType;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.h0;
import kotlin.collections.r;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.o;
import z0.y;
import z0.z;

/* compiled from: MaskPartyMatchingLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyMatchingLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public k f16422b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final Lazy f16423c;

    /* renamed from: d, reason: collision with root package name */
    public int f16424d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16425e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyMatchingLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f16425e = new LinkedHashMap();
        this.f16423c = kotlin.c.b(MaskPartyMatchingLayout$countDownTimer$2.INSTANCE);
        f();
    }

    private final com.cupidapp.live.base.utils.i getCountDownTimer() {
        return (com.cupidapp.live.base.utils.i) this.f16423c.getValue();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f16425e;
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

    public final void e(@Nullable ImageModel imageModel) {
        ImageLoaderView match_mask_avatar_imageview = (ImageLoaderView) a(R$id.match_mask_avatar_imageview);
        s.h(match_mask_avatar_imageview, "match_mask_avatar_imageview");
        ImageLoaderView.g(match_mask_avatar_imageview, imageModel, null, null, 6, null);
    }

    public final void f() {
        z.a(this, R$layout.layout_mask_party_matching, true);
        setVisibility(8);
        FKSVGAImageView match_animation_imageview = (FKSVGAImageView) a(R$id.match_animation_imageview);
        s.h(match_animation_imageview, "match_animation_imageview");
        y.n(match_animation_imageview, Integer.valueOf(z0.h.l(this)), Integer.valueOf(z0.h.l(this)));
        TextView change_avatar_textview = (TextView) a(R$id.change_avatar_textview);
        s.h(change_avatar_textview, "change_avatar_textview");
        y.d(change_avatar_textview, new Function1<View, p>() { // from class: com.cupidapp.live.maskparty.view.MaskPartyMatchingLayout$initView$1
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
                k kVar;
                kVar = MaskPartyMatchingLayout.this.f16422b;
                if (kVar != null) {
                    kVar.b();
                }
            }
        });
        ImageView stop_match_imageview = (ImageView) a(R$id.stop_match_imageview);
        s.h(stop_match_imageview, "stop_match_imageview");
        y.d(stop_match_imageview, new Function1<View, p>() { // from class: com.cupidapp.live.maskparty.view.MaskPartyMatchingLayout$initView$2
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
                k kVar;
                kVar = MaskPartyMatchingLayout.this.f16422b;
                if (kVar != null) {
                    kVar.c();
                }
            }
        });
    }

    public final void g(boolean z10) {
        int i10;
        setVisibility(0);
        boolean z11 = true;
        if (z10) {
            i10 = R$mipmap.icon_green_circle;
            int i11 = R$id.stop_match_imageview;
            ImageView stop_match_imageview = (ImageView) a(i11);
            s.h(stop_match_imageview, "stop_match_imageview");
            y.i(stop_match_imageview, (r18 & 1) != 0 ? 0.0f : z0.h.c(this, 32.0f), r.e(-13703535), (r18 & 4) != 0 ? GradientDrawable.Orientation.LEFT_RIGHT : null, (r18 & 8) != 0 ? null : null, (r18 & 16) != 0 ? null : null, (r18 & 32) != 0 ? 0.0f : 0.0f, (r18 & 64) != 0 ? 0.0f : 0.0f);
            ImageView stop_match_imageview2 = (ImageView) a(i11);
            s.h(stop_match_imageview2, "stop_match_imageview");
            o.b(stop_match_imageview2, -15066598);
        } else {
            i10 = R$mipmap.icon_colour_circle;
            int i12 = R$id.stop_match_imageview;
            ImageView stop_match_imageview3 = (ImageView) a(i12);
            s.h(stop_match_imageview3, "stop_match_imageview");
            y.i(stop_match_imageview3, (r18 & 1) != 0 ? 0.0f : z0.h.c(this, 32.0f), kotlin.collections.s.m(-9603585, -4954625), (r18 & 4) != 0 ? GradientDrawable.Orientation.LEFT_RIGHT : GradientDrawable.Orientation.TL_BR, (r18 & 8) != 0 ? null : null, (r18 & 16) != 0 ? null : null, (r18 & 32) != 0 ? 0.0f : 0.0f, (r18 & 64) != 0 ? 0.0f : 0.0f);
            ImageView stop_match_imageview4 = (ImageView) a(i12);
            s.h(stop_match_imageview4, "stop_match_imageview");
            o.b(stop_match_imageview4, -1);
        }
        FKSVGAImageView match_animation_imageview = (FKSVGAImageView) a(R$id.match_animation_imageview);
        s.h(match_animation_imageview, "match_animation_imageview");
        match_animation_imageview.G("mask_party_matching.svga", (r23 & 2) != 0 ? null : null, (r23 & 4) != 0 ? -1 : 0, (r23 & 8) != 0 ? false : false, (r23 & 16) != 0 ? null : null, (r23 & 32) != 0 ? null : h0.d(kotlin.f.a("img_15", Integer.valueOf(i10))), (r23 & 64) != 0 ? null : null, (r23 & 128) != 0 ? null : null, (r23 & 256) == 0 ? 0 : 0, (r23 & 512) != 0 ? null : null, (r23 & 1024) == 0 ? null : null);
        final ItemCardFeaturesItemModel N = p1.g.f52734a.N();
        TextView matching_prompt_textview = (TextView) a(R$id.matching_prompt_textview);
        s.h(matching_prompt_textview, "matching_prompt_textview");
        if (N != null && N.getType() != ItemCardType.SpeedUpMatch) {
            z11 = false;
        }
        matching_prompt_textview.setVisibility(z11 ? 4 : 0);
        this.f16424d = 0;
        com.cupidapp.live.base.utils.i.d(getCountDownTimer(), Integer.MAX_VALUE, 1, null, new Function1<Integer, p>() { // from class: com.cupidapp.live.maskparty.view.MaskPartyMatchingLayout$startMatch$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Integer num) {
                invoke(num.intValue());
                return p.f51048a;
            }

            /* JADX WARN: Code restructure failed: missing block: B:8:0x0046, code lost:
            
                r6 = r5.this$0.f16422b;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void invoke(int r6) {
                /*
                    r5 = this;
                    com.cupidapp.live.maskparty.view.MaskPartyMatchingLayout r6 = com.cupidapp.live.maskparty.view.MaskPartyMatchingLayout.this
                    int r0 = com.cupidapp.live.maskparty.view.MaskPartyMatchingLayout.c(r6)
                    r1 = 1
                    int r0 = r0 + r1
                    com.cupidapp.live.maskparty.view.MaskPartyMatchingLayout.d(r6, r0)
                    com.cupidapp.live.maskparty.view.MaskPartyMatchingLayout r6 = com.cupidapp.live.maskparty.view.MaskPartyMatchingLayout.this
                    int r0 = com.cupidapp.live.R$id.matching_textview
                    android.view.View r6 = r6.a(r0)
                    android.widget.TextView r6 = (android.widget.TextView) r6
                    com.cupidapp.live.maskparty.view.MaskPartyMatchingLayout r0 = com.cupidapp.live.maskparty.view.MaskPartyMatchingLayout.this
                    android.content.Context r0 = r0.getContext()
                    if (r0 == 0) goto L34
                    r2 = 2131887588(0x7f1205e4, float:1.9409787E38)
                    java.lang.Object[] r1 = new java.lang.Object[r1]
                    r3 = 0
                    com.cupidapp.live.maskparty.view.MaskPartyMatchingLayout r4 = com.cupidapp.live.maskparty.view.MaskPartyMatchingLayout.this
                    int r4 = com.cupidapp.live.maskparty.view.MaskPartyMatchingLayout.c(r4)
                    java.lang.String r4 = z0.v.g(r4)
                    r1[r3] = r4
                    java.lang.String r0 = r0.getString(r2, r1)
                    goto L35
                L34:
                    r0 = 0
                L35:
                    r6.setText(r0)
                    com.cupidapp.live.maskparty.view.MaskPartyMatchingLayout r6 = com.cupidapp.live.maskparty.view.MaskPartyMatchingLayout.this
                    int r6 = com.cupidapp.live.maskparty.view.MaskPartyMatchingLayout.c(r6)
                    r0 = 10
                    if (r6 != r0) goto L51
                    com.cupidapp.live.maskparty.model.ItemCardFeaturesItemModel r6 = r2
                    if (r6 != 0) goto L51
                    com.cupidapp.live.maskparty.view.MaskPartyMatchingLayout r6 = com.cupidapp.live.maskparty.view.MaskPartyMatchingLayout.this
                    com.cupidapp.live.maskparty.view.k r6 = com.cupidapp.live.maskparty.view.MaskPartyMatchingLayout.b(r6)
                    if (r6 == 0) goto L51
                    r6.a()
                L51:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.maskparty.view.MaskPartyMatchingLayout$startMatch$1.invoke(int):void");
            }
        }, 4, null);
    }

    public final void h() {
        ((FKSVGAImageView) a(R$id.match_animation_imageview)).K();
        getCountDownTimer().g();
        setVisibility(8);
    }

    public final void i(boolean z10) {
        ((ImageView) a(R$id.stop_match_imageview)).setEnabled(z10);
    }

    public final void setListener(@NotNull k listener) {
        s.i(listener, "listener");
        this.f16422b = listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyMatchingLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f16425e = new LinkedHashMap();
        this.f16423c = kotlin.c.b(MaskPartyMatchingLayout$countDownTimer$2.INSTANCE);
        f();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyMatchingLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f16425e = new LinkedHashMap();
        this.f16423c = kotlin.c.b(MaskPartyMatchingLayout$countDownTimer$2.INSTANCE);
        f();
    }
}
