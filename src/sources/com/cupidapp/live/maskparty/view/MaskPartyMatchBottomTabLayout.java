package com.cupidapp.live.maskparty.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.maskparty.model.MaskPartyConfigModel;
import com.cupidapp.live.maskparty.model.MaskPartyType;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: MaskPartyMatchBottomTabLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyMatchBottomTabLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public Function1<? super Boolean, p> f16409b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final List<MaskPartyConfigModel> f16410c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f16411d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16412e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyMatchBottomTabLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f16412e = new LinkedHashMap();
        this.f16410c = new ArrayList();
        g();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f16412e;
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

    public final void e() {
        MaskPartyConfigModel maskPartyConfigModel = this.f16410c.get(0);
        MaskPartyConfigModel maskPartyConfigModel2 = this.f16410c.get(1);
        if (this.f16411d) {
            View a10 = a(R$id.voice_chat_layout);
            int i10 = R$id.chat_tab_imageview;
            ImageLoaderView chat_tab_imageview = (ImageLoaderView) a10.findViewById(i10);
            s.h(chat_tab_imageview, "chat_tab_imageview");
            ImageLoaderView.g(chat_tab_imageview, maskPartyConfigModel2.getIcon(), null, null, 6, null);
            int i11 = R$id.chat_tab_textview;
            TextView textView = (TextView) a10.findViewById(i11);
            textView.setTextColor(-1);
            textView.setText(maskPartyConfigModel2.getTitle());
            int i12 = R$id.chat_tab_remains_text;
            ((TextView) a10.findViewById(i12)).setVisibility(4);
            View a11 = a(R$id.message_chat_layout);
            ImageLoaderView chat_tab_imageview2 = (ImageLoaderView) a11.findViewById(i10);
            s.h(chat_tab_imageview2, "chat_tab_imageview");
            ImageLoaderView.g(chat_tab_imageview2, maskPartyConfigModel.getSecondaryIcon(), null, null, 6, null);
            TextView textView2 = (TextView) a11.findViewById(i11);
            textView2.setTextColor(com.cupidapp.live.base.utils.h.a(-1, 0.5f));
            textView2.setText(maskPartyConfigModel.getTitle());
            TextView textView3 = (TextView) a11.findViewById(i12);
            textView3.setVisibility(0);
            Context context = textView3.getContext();
            s.h(context, "context");
            textView3.setText(maskPartyConfigModel.formatRemains(context));
            return;
        }
        View a12 = a(R$id.message_chat_layout);
        int i13 = R$id.chat_tab_imageview;
        ImageLoaderView chat_tab_imageview3 = (ImageLoaderView) a12.findViewById(i13);
        s.h(chat_tab_imageview3, "chat_tab_imageview");
        ImageLoaderView.g(chat_tab_imageview3, maskPartyConfigModel.getIcon(), null, null, 6, null);
        int i14 = R$id.chat_tab_textview;
        TextView textView4 = (TextView) a12.findViewById(i14);
        textView4.setTextColor(-1);
        textView4.setText(maskPartyConfigModel.getTitle());
        int i15 = R$id.chat_tab_remains_text;
        ((TextView) a12.findViewById(i15)).setVisibility(4);
        View a13 = a(R$id.voice_chat_layout);
        ImageLoaderView chat_tab_imageview4 = (ImageLoaderView) a13.findViewById(i13);
        s.h(chat_tab_imageview4, "chat_tab_imageview");
        ImageLoaderView.g(chat_tab_imageview4, maskPartyConfigModel2.getSecondaryIcon(), null, null, 6, null);
        TextView textView5 = (TextView) a13.findViewById(i14);
        textView5.setTextColor(com.cupidapp.live.base.utils.h.a(-1, 0.5f));
        textView5.setText(maskPartyConfigModel2.getTitle());
        TextView textView6 = (TextView) a13.findViewById(i15);
        textView6.setVisibility(0);
        Context context2 = textView6.getContext();
        s.h(context2, "context");
        textView6.setText(maskPartyConfigModel2.formatRemains(context2));
    }

    public final void f(@NotNull List<MaskPartyConfigModel> gameEntrance, @Nullable List<Integer> list) {
        s.i(gameEntrance, "gameEntrance");
        this.f16410c.clear();
        this.f16410c.addAll(gameEntrance);
        if (gameEntrance.size() > 1) {
            setVisibility(0);
            this.f16411d = list != null && list.contains(Integer.valueOf(MaskPartyType.VoiceChat.getType()));
            e();
            ImageView new_corner_imageview = (ImageView) a(R$id.new_corner_imageview);
            s.h(new_corner_imageview, "new_corner_imageview");
            new_corner_imageview.setVisibility(!this.f16411d && s.d(p1.g.f52734a.r1(), Boolean.TRUE) ? 0 : 8);
            return;
        }
        setVisibility(8);
    }

    public final void g() {
        z.a(this, R$layout.layout_mask_party_match_bottom_tab, true);
        setVisibility(8);
        View initView$lambda$0 = a(R$id.message_chat_layout);
        int i10 = R$id.chat_tab_textview;
        ((TextView) initView$lambda$0.findViewById(i10)).getPaint().setFakeBoldText(true);
        s.h(initView$lambda$0, "initView$lambda$0");
        y.d(initView$lambda$0, new Function1<View, p>() { // from class: com.cupidapp.live.maskparty.view.MaskPartyMatchBottomTabLayout$initView$1$1
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
                boolean z10;
                z10 = MaskPartyMatchBottomTabLayout.this.f16411d;
                if (z10) {
                    MaskPartyMatchBottomTabLayout.this.f16411d = false;
                    MaskPartyMatchBottomTabLayout.this.e();
                    Function1<Boolean, p> changeTab = MaskPartyMatchBottomTabLayout.this.getChangeTab();
                    if (changeTab != null) {
                        changeTab.invoke(Boolean.FALSE);
                    }
                }
            }
        });
        View initView$lambda$1 = a(R$id.voice_chat_layout);
        ((TextView) initView$lambda$1.findViewById(i10)).getPaint().setFakeBoldText(true);
        s.h(initView$lambda$1, "initView$lambda$1");
        y.d(initView$lambda$1, new Function1<View, p>() { // from class: com.cupidapp.live.maskparty.view.MaskPartyMatchBottomTabLayout$initView$2$1
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
                boolean z10;
                z10 = MaskPartyMatchBottomTabLayout.this.f16411d;
                if (z10) {
                    return;
                }
                MaskPartyMatchBottomTabLayout.this.f16411d = true;
                MaskPartyMatchBottomTabLayout.this.e();
                MaskPartyMatchBottomTabLayout maskPartyMatchBottomTabLayout = MaskPartyMatchBottomTabLayout.this;
                int i11 = R$id.new_corner_imageview;
                ImageView imageView = (ImageView) maskPartyMatchBottomTabLayout.a(i11);
                s.h(imageView, "this@MaskPartyMatchBotto…yout.new_corner_imageview");
                if (imageView.getVisibility() == 0) {
                    ImageView imageView2 = (ImageView) MaskPartyMatchBottomTabLayout.this.a(i11);
                    s.h(imageView2, "this@MaskPartyMatchBotto…yout.new_corner_imageview");
                    imageView2.setVisibility(8);
                    p1.g.f52734a.B3(Boolean.FALSE);
                }
                Function1<Boolean, p> changeTab = MaskPartyMatchBottomTabLayout.this.getChangeTab();
                if (changeTab != null) {
                    changeTab.invoke(Boolean.TRUE);
                }
            }
        });
    }

    @Nullable
    public final Function1<Boolean, p> getChangeTab() {
        return this.f16409b;
    }

    public final void setChangeTab(@Nullable Function1<? super Boolean, p> function1) {
        this.f16409b = function1;
    }

    public final void setChatTabVisible(boolean z10) {
        if (this.f16410c.size() <= 1) {
            z10 = false;
        }
        setVisibility(z10 ? 0 : 8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyMatchBottomTabLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f16412e = new LinkedHashMap();
        this.f16410c = new ArrayList();
        g();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyMatchBottomTabLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f16412e = new LinkedHashMap();
        this.f16410c = new ArrayList();
        g();
    }
}
