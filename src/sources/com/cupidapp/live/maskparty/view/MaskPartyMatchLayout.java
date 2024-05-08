package com.cupidapp.live.maskparty.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.maskparty.model.ItemCardFeaturesItemModel;
import com.cupidapp.live.maskparty.model.MaskPartyConfigModel;
import com.cupidapp.live.maskparty.model.MaskPartyModel;
import com.cupidapp.live.maskparty.model.MaskPartyType;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.r;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.o;
import z0.v;
import z0.y;
import z0.z;

/* compiled from: MaskPartyMatchLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyMatchLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public i f16413b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final List<MaskPartyModel> f16414c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final List<MaskPartyConfigModel> f16415d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final Lazy f16416e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f16417f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16418g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyMatchLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f16418g = new LinkedHashMap();
        this.f16414c = new ArrayList();
        this.f16415d = new ArrayList();
        this.f16416e = kotlin.c.b(MaskPartyMatchLayout$countDownTimer$2.INSTANCE);
        k();
    }

    private final com.cupidapp.live.base.utils.i getCountDownTimer() {
        return (com.cupidapp.live.base.utils.i) this.f16416e.getValue();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f16418g;
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

    public final void f(@Nullable ItemCardFeaturesItemModel itemCardFeaturesItemModel) {
        if (itemCardFeaturesItemModel == null) {
            ImageView item_card_imageview = (ImageView) a(R$id.item_card_imageview);
            s.h(item_card_imageview, "item_card_imageview");
            item_card_imageview.setVisibility(8);
        } else {
            int i10 = R$id.item_card_imageview;
            ImageView item_card_imageview2 = (ImageView) a(i10);
            s.h(item_card_imageview2, "item_card_imageview");
            item_card_imageview2.setVisibility(0);
            ((ImageView) a(i10)).setImageResource(itemCardFeaturesItemModel.getIcon());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [android.widget.LinearLayout, java.lang.Object, android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    public final void g(List<MaskPartyModel> list, List<Integer> list2) {
        final ImageView selectView;
        boolean z10;
        ((LinearLayout) a(R$id.message_party_layout)).removeAllViews();
        this.f16414c.clear();
        boolean z11 = false;
        int i10 = 0;
        for (MaskPartyModel maskPartyModel : list) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                kotlin.collections.s.s();
            }
            final MaskPartyModel maskPartyModel2 = maskPartyModel;
            int i12 = R$id.message_party_layout;
            LinearLayout message_party_layout = (LinearLayout) a(i12);
            s.h(message_party_layout, "message_party_layout");
            final View b4 = z.b(message_party_layout, R$layout.layout_mask_party_item, z11, 2, null);
            ImageLoaderView imageView = (ImageLoaderView) b4.findViewById(R$id.party_item_imageview);
            TextView textView = (TextView) b4.findViewById(R$id.party_item_name_textview);
            TextView textView2 = (TextView) b4.findViewById(R$id.party_item_content_textview);
            TextView newPlayView = (TextView) b4.findViewById(R$id.new_play_textview);
            ImageView imageView2 = (ImageView) b4.findViewById(R$id.party_select_imageview);
            s.h(imageView, "imageView");
            ImageLoaderView.g(imageView, maskPartyModel2.getIcon(), null, null, 6, null);
            textView.getPaint().setFakeBoldText(true);
            textView.setText(maskPartyModel2.getTitle());
            textView2.setText(maskPartyModel2.getDesc());
            s.h(newPlayView, "newPlayView");
            newPlayView.setVisibility(maskPartyModel2.getType() == MaskPartyType.ScriptKill.getType() ? 0 : 8);
            if (list2 != null && list2.contains(Integer.valueOf(maskPartyModel2.getType()))) {
                b4.setSelected(true);
                selectView = imageView2;
                s.h(selectView, "selectView");
                z10 = false;
                selectView.setVisibility(0);
                this.f16414c.add(maskPartyModel2);
            } else {
                selectView = imageView2;
                z10 = false;
                b4.setSelected(false);
                s.h(selectView, "selectView");
                selectView.setVisibility(8);
            }
            y.d(b4, new Function1<View, p>() { // from class: com.cupidapp.live.maskparty.view.MaskPartyMatchLayout$configMessageParty$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    List list3;
                    i iVar;
                    List<MaskPartyModel> list4;
                    List list5;
                    List list6;
                    i iVar2;
                    List<MaskPartyModel> list7;
                    if (View.this.isSelected()) {
                        list5 = this.f16414c;
                        if (list5.size() > 1) {
                            View.this.setSelected(false);
                            ImageView selectView2 = selectView;
                            s.h(selectView2, "selectView");
                            selectView2.setVisibility(8);
                            list6 = this.f16414c;
                            list6.remove(maskPartyModel2);
                            iVar2 = this.f16413b;
                            if (iVar2 != null) {
                                list7 = this.f16414c;
                                iVar2.b(list7);
                                return;
                            }
                            return;
                        }
                        com.cupidapp.live.base.view.h.f12779a.q(R$string.mask_party_select_prompt);
                        return;
                    }
                    View.this.setSelected(true);
                    ImageView selectView3 = selectView;
                    s.h(selectView3, "selectView");
                    selectView3.setVisibility(0);
                    list3 = this.f16414c;
                    list3.add(maskPartyModel2);
                    iVar = this.f16413b;
                    if (iVar != null) {
                        list4 = this.f16414c;
                        iVar.b(list4);
                    }
                }
            });
            if (i10 == 0) {
                y.l(b4, 0, 0, 0, Integer.valueOf(z0.h.c(this, 8.0f)));
            } else if (i10 == list.size() - 1) {
                y.l(b4, 0, Integer.valueOf(z0.h.c(this, 8.0f)), 0, 0);
            } else {
                y.l(b4, 0, Integer.valueOf(z0.h.c(this, 8.0f)), 0, Integer.valueOf(z0.h.c(this, 8.0f)));
            }
            ((LinearLayout) a(i12)).addView(b4);
            i10 = i11;
            z11 = z10;
        }
        if (this.f16414c.isEmpty() && (!list.isEmpty())) {
            ?? message_party_layout2 = (LinearLayout) a(R$id.message_party_layout);
            s.h(message_party_layout2, "message_party_layout");
            int childCount = message_party_layout2.getChildCount();
            for (?? r32 = z11; r32 < childCount; r32++) {
                View childAt = message_party_layout2.getChildAt(r32);
                s.h(childAt, "getChildAt(index)");
                childAt.setSelected(true);
            }
            this.f16414c.addAll(list);
        }
    }

    public final void h(@NotNull List<MaskPartyConfigModel> gameEntrance, @Nullable List<Integer> list) {
        s.i(gameEntrance, "gameEntrance");
        boolean z10 = false;
        setVisibility(0);
        this.f16415d.clear();
        this.f16415d.addAll(gameEntrance);
        int i10 = 0;
        for (MaskPartyConfigModel maskPartyConfigModel : gameEntrance) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                kotlin.collections.s.s();
            }
            MaskPartyConfigModel maskPartyConfigModel2 = maskPartyConfigModel;
            if (i10 == 0) {
                g(maskPartyConfigModel2.getPlayTypeInfo(), list);
            } else if (i10 == 1) {
                i((MaskPartyModel) CollectionsKt___CollectionsKt.V(maskPartyConfigModel2.getPlayTypeInfo()));
            }
            i10 = i11;
        }
        if (list != null && list.contains(Integer.valueOf(MaskPartyType.VoiceChat.getType()))) {
            z10 = true;
        }
        l(z10);
        f(p1.g.f52734a.N());
    }

    public final void i(MaskPartyModel maskPartyModel) {
        int i10 = R$id.voice_party_layout;
        ImageLoaderView imageView = (ImageLoaderView) a(i10).findViewById(R$id.party_imageview);
        TextView textView = (TextView) a(i10).findViewById(R$id.party_name);
        TextView textView2 = (TextView) a(i10).findViewById(R$id.party_content);
        s.h(imageView, "imageView");
        ImageLoaderView.g(imageView, maskPartyModel != null ? maskPartyModel.getIcon() : null, null, null, 6, null);
        textView.setText(maskPartyModel != null ? maskPartyModel.getTitle() : null);
        textView2.setText(maskPartyModel != null ? maskPartyModel.getDesc() : null);
        View voice_party_layout = a(i10);
        s.h(voice_party_layout, "voice_party_layout");
        y.i(voice_party_layout, (r18 & 1) != 0 ? 0.0f : z0.h.c(this, 12.0f), r.e(Integer.valueOf(com.cupidapp.live.base.utils.h.a(-13703535, 0.12f))), (r18 & 4) != 0 ? GradientDrawable.Orientation.LEFT_RIGHT : null, (r18 & 8) != 0 ? null : Integer.valueOf(z0.h.c(this, 2.0f)), (r18 & 16) != 0 ? null : -13703535, (r18 & 32) != 0 ? 0.0f : 0.0f, (r18 & 64) != 0 ? 0.0f : 0.0f);
    }

    @NotNull
    public final List<MaskPartyModel> j(boolean z10) {
        return z10 ? this.f16415d.get(1).getPlayTypeInfo() : this.f16414c;
    }

    public final void k() {
        z.a(this, R$layout.layout_mask_party_match, true);
        setVisibility(8);
        LinearLayout match_button_layout = (LinearLayout) a(R$id.match_button_layout);
        s.h(match_button_layout, "match_button_layout");
        y.d(match_button_layout, new Function1<View, p>() { // from class: com.cupidapp.live.maskparty.view.MaskPartyMatchLayout$initView$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* JADX WARN: Code restructure failed: missing block: B:5:0x0009, code lost:
            
                r1 = r0.this$0.f16413b;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void invoke2(@org.jetbrains.annotations.Nullable android.view.View r1) {
                /*
                    r0 = this;
                    com.cupidapp.live.maskparty.view.MaskPartyMatchLayout r1 = com.cupidapp.live.maskparty.view.MaskPartyMatchLayout.this
                    boolean r1 = com.cupidapp.live.maskparty.view.MaskPartyMatchLayout.c(r1)
                    if (r1 == 0) goto L9
                    return
                L9:
                    com.cupidapp.live.maskparty.view.MaskPartyMatchLayout r1 = com.cupidapp.live.maskparty.view.MaskPartyMatchLayout.this
                    com.cupidapp.live.maskparty.view.i r1 = com.cupidapp.live.maskparty.view.MaskPartyMatchLayout.b(r1)
                    if (r1 == 0) goto L14
                    r1.a()
                L14:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.maskparty.view.MaskPartyMatchLayout$initView$1.invoke2(android.view.View):void");
            }
        });
    }

    public final void l(boolean z10) {
        String str;
        if (z10) {
            str = this.f16415d.get(1).getEnterButtonSubTitle();
            LinearLayout message_party_layout = (LinearLayout) a(R$id.message_party_layout);
            s.h(message_party_layout, "message_party_layout");
            message_party_layout.setVisibility(8);
            View voice_party_layout = a(R$id.voice_party_layout);
            s.h(voice_party_layout, "voice_party_layout");
            voice_party_layout.setVisibility(0);
            LinearLayout match_button_layout = (LinearLayout) a(R$id.match_button_layout);
            s.h(match_button_layout, "match_button_layout");
            y.i(match_button_layout, (r18 & 1) != 0 ? 0.0f : z0.h.c(this, 32.0f), r.e(-13703535), (r18 & 4) != 0 ? GradientDrawable.Orientation.LEFT_RIGHT : null, (r18 & 8) != 0 ? null : null, (r18 & 16) != 0 ? null : null, (r18 & 32) != 0 ? 0.0f : 0.0f, (r18 & 64) != 0 ? 0.0f : 0.0f);
            ImageView match_image = (ImageView) a(R$id.match_image);
            s.h(match_image, "match_image");
            o.b(match_image, -15066598);
            ((TextView) a(R$id.remain_times_text)).setTextColor(-15066598);
        } else {
            String enterButtonSubTitle = this.f16415d.get(0).getEnterButtonSubTitle();
            LinearLayout message_party_layout2 = (LinearLayout) a(R$id.message_party_layout);
            s.h(message_party_layout2, "message_party_layout");
            message_party_layout2.setVisibility(0);
            View voice_party_layout2 = a(R$id.voice_party_layout);
            s.h(voice_party_layout2, "voice_party_layout");
            voice_party_layout2.setVisibility(8);
            LinearLayout match_button_layout2 = (LinearLayout) a(R$id.match_button_layout);
            s.h(match_button_layout2, "match_button_layout");
            y.i(match_button_layout2, (r18 & 1) != 0 ? 0.0f : z0.h.c(this, 32.0f), kotlin.collections.s.m(-9603585, -4954625), (r18 & 4) != 0 ? GradientDrawable.Orientation.LEFT_RIGHT : GradientDrawable.Orientation.TL_BR, (r18 & 8) != 0 ? null : null, (r18 & 16) != 0 ? null : null, (r18 & 32) != 0 ? 0.0f : 0.0f, (r18 & 64) != 0 ? 0.0f : 0.0f);
            ImageView match_image2 = (ImageView) a(R$id.match_image);
            s.h(match_image2, "match_image");
            o.b(match_image2, -1);
            ((TextView) a(R$id.remain_times_text)).setTextColor(-1);
            str = enterButtonSubTitle;
        }
        ((ImageView) a(R$id.match_image)).setImageResource(R$mipmap.icon_start_match);
        ((TextView) a(R$id.remain_times_text)).setText(str);
    }

    public final void m(int i10) {
        this.f16417f = true;
        LinearLayout punish_prompt_layout = (LinearLayout) a(R$id.punish_prompt_layout);
        s.h(punish_prompt_layout, "punish_prompt_layout");
        punish_prompt_layout.setVisibility(0);
        getCountDownTimer().c(Integer.valueOf(i10), 1, new Function0<p>() { // from class: com.cupidapp.live.maskparty.view.MaskPartyMatchLayout$showPunishPrompt$1
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
                MaskPartyMatchLayout.this.f16417f = false;
                ((LinearLayout) MaskPartyMatchLayout.this.a(R$id.punish_prompt_layout)).setVisibility(8);
                MaskPartyMatchLayout.this.n(true);
            }
        }, new Function1<Integer, p>() { // from class: com.cupidapp.live.maskparty.view.MaskPartyMatchLayout$showPunishPrompt$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Integer num) {
                invoke(num.intValue());
                return p.f51048a;
            }

            public final void invoke(int i11) {
                ((TextView) MaskPartyMatchLayout.this.a(R$id.punish_prompt_textview)).setText(MaskPartyMatchLayout.this.getContext().getString(R$string.punish_prompt, v.b(i11)));
            }
        });
    }

    public final void n(boolean z10) {
        ((LinearLayout) a(R$id.match_button_layout)).setEnabled(z10);
    }

    public final void o() {
        if (this.f16417f) {
            getCountDownTimer().g();
        }
    }

    public final void setListener(@NotNull i listener) {
        s.i(listener, "listener");
        this.f16413b = listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyMatchLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f16418g = new LinkedHashMap();
        this.f16414c = new ArrayList();
        this.f16415d = new ArrayList();
        this.f16416e = kotlin.c.b(MaskPartyMatchLayout$countDownTimer$2.INSTANCE);
        k();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyMatchLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f16418g = new LinkedHashMap();
        this.f16414c = new ArrayList();
        this.f16415d = new ArrayList();
        this.f16416e = kotlin.c.b(MaskPartyMatchLayout$countDownTimer$2.INSTANCE);
        k();
    }
}
