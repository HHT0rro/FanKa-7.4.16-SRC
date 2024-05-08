package com.cupidapp.live.chat2.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.chat2.model.SurveyChatUserInfoModel;
import com.cupidapp.live.profile.model.User;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: SurveyChatTitleLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class SurveyChatTitleLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public k f13460b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13461c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SurveyChatTitleLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f13461c = new LinkedHashMap();
        d();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f13461c;
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

    public final void c(@NotNull SurveyChatUserInfoModel model) {
        s.i(model, "model");
        User sender = model.getSender();
        ImageLoaderView survey_chat_avatar_img = (ImageLoaderView) a(R$id.survey_chat_avatar_img);
        s.h(survey_chat_avatar_img, "survey_chat_avatar_img");
        ImageLoaderView.g(survey_chat_avatar_img, sender.getAvatarImage(), null, null, 6, null);
        ((TextView) a(R$id.survey_chat_name_txt)).setText(sender.getName());
        ((TextView) a(R$id.survey_chat_tips_txt)).setText(model.getTopTips());
    }

    public final void d() {
        z.a(this, R$layout.layout_survey_chat_title, true);
        TextView survey_chat_name_txt = (TextView) a(R$id.survey_chat_name_txt);
        s.h(survey_chat_name_txt, "survey_chat_name_txt");
        u.a(survey_chat_name_txt);
        ImageView survey_chat_back_image = (ImageView) a(R$id.survey_chat_back_image);
        s.h(survey_chat_back_image, "survey_chat_back_image");
        y.d(survey_chat_back_image, new Function1<View, p>() { // from class: com.cupidapp.live.chat2.view.SurveyChatTitleLayout$initView$1
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
                kVar = SurveyChatTitleLayout.this.f13460b;
                if (kVar != null) {
                    kVar.a();
                }
            }
        });
        ImageLoaderView survey_chat_avatar_img = (ImageLoaderView) a(R$id.survey_chat_avatar_img);
        s.h(survey_chat_avatar_img, "survey_chat_avatar_img");
        y.d(survey_chat_avatar_img, new Function1<View, p>() { // from class: com.cupidapp.live.chat2.view.SurveyChatTitleLayout$initView$2
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
                kVar = SurveyChatTitleLayout.this.f13460b;
                if (kVar != null) {
                    kVar.b();
                }
            }
        });
    }

    public final void setListener(@NotNull k listener) {
        s.i(listener, "listener");
        this.f13460b = listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SurveyChatTitleLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f13461c = new LinkedHashMap();
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SurveyChatTitleLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f13461c = new LinkedHashMap();
        d();
    }
}
