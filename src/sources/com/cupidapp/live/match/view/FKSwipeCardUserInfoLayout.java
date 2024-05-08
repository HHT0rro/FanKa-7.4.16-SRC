package com.cupidapp.live.match.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.feed.holder.OpenFeedDetailEvent;
import com.cupidapp.live.feed.layout.FlowLayout;
import com.cupidapp.live.match.model.Constellation;
import com.cupidapp.live.match.model.MatchCardUserPostModel;
import com.cupidapp.live.match.model.MatchCardUserSpecInfoModel;
import com.cupidapp.live.match.model.SpecialInfoType;
import com.cupidapp.live.profile.model.FKStoryLabelItemModel;
import com.cupidapp.live.profile.model.UserTagModel;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKSwipeCardUserInfoLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKSwipeCardUserInfoLayout extends BaseLayout {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public List<String> f16900d;

    /* renamed from: e, reason: collision with root package name */
    public int f16901e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16902f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKSwipeCardUserInfoLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16902f = new LinkedHashMap();
        this.f16900d = new ArrayList();
        p();
    }

    @Nullable
    public View e(int i10) {
        Map<Integer, View> map = this.f16902f;
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

    public final void f(String str, boolean z10) {
        if (str == null || str.length() == 0) {
            ((TextView) e(R$id.user_description)).setVisibility(8);
            return;
        }
        int i10 = R$id.user_description;
        ((TextView) e(i10)).setVisibility(0);
        ((TextView) e(i10)).setText(z0.t.c(str));
        this.f16900d.add("PERSONAL_SIGNATURE");
    }

    public final void g(List<UserTagModel> list, String str) {
        boolean z10 = true;
        if (list == null || list.isEmpty()) {
            ((FlowLayout) e(R$id.user_tag_flow_layout)).setVisibility(8);
            if (str != null && str.length() != 0) {
                z10 = false;
            }
            if (z10) {
                ((TextView) e(R$id.user_tag_empty_text)).setVisibility(8);
                return;
            }
            int i10 = R$id.user_tag_empty_text;
            ((TextView) e(i10)).setVisibility(0);
            ((TextView) e(i10)).setText(str);
            return;
        }
        ((TextView) e(R$id.user_tag_empty_text)).setVisibility(8);
        int i11 = R$id.user_tag_flow_layout;
        ((FlowLayout) e(i11)).setVisibility(0);
        ((FlowLayout) e(i11)).removeAllViews();
        for (UserTagModel userTagModel : list) {
            int i12 = R$id.user_tag_flow_layout;
            FlowLayout user_tag_flow_layout = (FlowLayout) e(i12);
            kotlin.jvm.internal.s.h(user_tag_flow_layout, "user_tag_flow_layout");
            View b4 = z0.z.b(user_tag_flow_layout, R$layout.item_user_intro, false, 2, null);
            ImageLoaderView imageLoaderView = (ImageLoaderView) b4.findViewById(R$id.item_user_intro_img);
            kotlin.jvm.internal.s.h(imageLoaderView, "tagView.item_user_intro_img");
            ImageLoaderView.g(imageLoaderView, userTagModel.getImage(), null, null, 6, null);
            ((TextView) b4.findViewById(R$id.item_user_intro_txt)).setText(userTagModel.getName());
            ((FlowLayout) e(i12)).addView(b4);
        }
    }

    public final void h(List<String> list) {
        if (list == null || list.isEmpty()) {
            ((LinearLayout) e(R$id.user_mutual_hobby_layout)).setVisibility(8);
            return;
        }
        int i10 = R$id.user_mutual_hobby_layout;
        ((LinearLayout) e(i10)).setVisibility(0);
        ((LinearLayout) e(i10)).removeAllViews();
        for (String str : list) {
            int i11 = R$id.user_mutual_hobby_layout;
            LinearLayout user_mutual_hobby_layout = (LinearLayout) e(i11);
            kotlin.jvm.internal.s.h(user_mutual_hobby_layout, "user_mutual_hobby_layout");
            View b4 = z0.z.b(user_mutual_hobby_layout, R$layout.swipe_card_common_hobby_view, false, 2, null);
            TextView textView = (TextView) b4.findViewById(R$id.common_hobby);
            textView.getPaint().setFakeBoldText(true);
            textView.setText(str);
            ((LinearLayout) e(i11)).addView(b4);
        }
        this.f16900d.add("HOBBY");
    }

    public final void i(List<MatchCardUserPostModel> list, boolean z10) {
        if (list == null || list.isEmpty()) {
            ((LinearLayout) e(R$id.recent_post)).setVisibility(8);
            return;
        }
        ((LinearLayout) e(R$id.recent_post)).setVisibility(0);
        ((LinearLayout) e(R$id.recent_post_layout)).removeAllViews();
        for (final MatchCardUserPostModel matchCardUserPostModel : list) {
            int i10 = R$id.recent_post_layout;
            LinearLayout recent_post_layout = (LinearLayout) e(i10);
            kotlin.jvm.internal.s.h(recent_post_layout, "recent_post_layout");
            View b4 = z0.z.b(recent_post_layout, R$layout.swipe_card_post_item_view, false, 2, null);
            ImageLoaderView imageLoaderView = (ImageLoaderView) b4.findViewById(R$id.post_item_image);
            kotlin.jvm.internal.s.h(imageLoaderView, "postView.post_item_image");
            ImageLoaderView.g(imageLoaderView, matchCardUserPostModel.getImage(), null, null, 6, null);
            z0.y.d(b4, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardUserInfoLayout$configRecentPost$1$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                    invoke2(view);
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable View view) {
                    EventBus.c().l(new OpenFeedDetailEvent(MatchCardUserPostModel.this.getPostId()));
                }
            });
            int l10 = (z0.h.l(this) - z0.h.c(this, 126.0f)) / 4;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(l10, l10);
            layoutParams.setMarginEnd(z0.h.c(layoutParams, 8.0f));
            ((LinearLayout) e(i10)).addView(b4, layoutParams);
        }
        this.f16900d.add("MANY_PHOTOS");
    }

    public final void j(List<MatchCardUserSpecInfoModel> list) {
        int a10;
        int i10 = 0;
        if (list == null || list.isEmpty()) {
            ((LinearLayout) e(R$id.user_special_info_layout)).setVisibility(8);
            return;
        }
        int i11 = R$id.user_special_info_layout;
        ((LinearLayout) e(i11)).setVisibility(0);
        ((LinearLayout) e(i11)).removeAllViews();
        for (MatchCardUserSpecInfoModel matchCardUserSpecInfoModel : list) {
            int i12 = i10 + 1;
            if (i10 < 0) {
                kotlin.collections.s.s();
            }
            MatchCardUserSpecInfoModel matchCardUserSpecInfoModel2 = matchCardUserSpecInfoModel;
            int type = matchCardUserSpecInfoModel2.getType();
            if (type == SpecialInfoType.Hobby.getType()) {
                a10 = R$mipmap.icon_interest;
            } else if (type == SpecialInfoType.Sports.getType()) {
                a10 = R$mipmap.icon_sports;
            } else if (type == SpecialInfoType.Profession.getType()) {
                a10 = R$mipmap.icon_profession;
            } else {
                a10 = type == SpecialInfoType.Industry.getType() ? R$mipmap.icon_industry : Constellation.Companion.a(matchCardUserSpecInfoModel2.getType());
            }
            ((LinearLayout) e(R$id.user_special_info_layout)).addView(o(i10, list.size(), a10, matchCardUserSpecInfoModel2.getValue()));
            i10 = i12;
        }
        this.f16900d.add("PROFILE");
    }

    public final void k(FKStoryLabelItemModel fKStoryLabelItemModel) {
        if (fKStoryLabelItemModel == null) {
            ((ConstraintLayout) e(R$id.story_label_layout)).setVisibility(8);
            return;
        }
        ((ConstraintLayout) e(R$id.story_label_layout)).setVisibility(0);
        ImageLoaderView story_label_icon = (ImageLoaderView) e(R$id.story_label_icon);
        kotlin.jvm.internal.s.h(story_label_icon, "story_label_icon");
        ImageLoaderView.g(story_label_icon, fKStoryLabelItemModel.getIcon(), null, null, 6, null);
        ((TextView) e(R$id.story_label_title)).setText(fKStoryLabelItemModel.getQuestion());
        TextView textView = (TextView) e(R$id.story_label_description);
        String content = fKStoryLabelItemModel.getContent();
        textView.setText(content != null ? z0.t.c(content) : null);
        this.f16900d.add("STORY_TAG");
    }

    public final void l(String str) {
        if (str == null || str.length() == 0) {
            ((TextView) e(R$id.user_basic_info)).setVisibility(8);
            this.f16901e = 0;
        } else {
            int i10 = R$id.user_basic_info;
            ((TextView) e(i10)).setVisibility(0);
            ((TextView) e(i10)).setText(str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m(@org.jetbrains.annotations.NotNull final com.cupidapp.live.match.view.FKSwipeCardUserInfoModel r19, boolean r20, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.p> r21) {
        /*
            Method dump skipped, instructions count: 586
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.match.view.FKSwipeCardUserInfoLayout.m(com.cupidapp.live.match.view.FKSwipeCardUserInfoModel, boolean, kotlin.jvm.functions.Function1):void");
    }

    public final View o(int i10, int i11, int i12, String str) {
        LinearLayout user_mutual_hobby_layout = (LinearLayout) e(R$id.user_mutual_hobby_layout);
        kotlin.jvm.internal.s.h(user_mutual_hobby_layout, "user_mutual_hobby_layout");
        View b4 = z0.z.b(user_mutual_hobby_layout, R$layout.swipe_card_special_info_view, false, 2, null);
        z0.y.m(b4, null, null, null, Integer.valueOf(i10 != i11 + (-1) ? z0.h.c(this, 8.0f) : 0), 7, null);
        TextView createSpecialInfoView$lambda$4 = (TextView) b4.findViewById(R$id.special_info);
        kotlin.jvm.internal.s.h(createSpecialInfoView$lambda$4, "createSpecialInfoView$lambda$4");
        z0.u.e(createSpecialInfoView$lambda$4, i12, 0, 0, 0, 14, null);
        createSpecialInfoView$lambda$4.setText(str);
        return b4;
    }

    public final void p() {
        z0.z.a(this, R$layout.layout_swipe_card_user_info, true);
        ((TextView) e(R$id.swipe_card_user_name)).getPaint().setFakeBoldText(true);
        TextView user_online = (TextView) e(R$id.user_online);
        kotlin.jvm.internal.s.h(user_online, "user_online");
        z0.y.d(user_online, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardUserInfoLayout$initView$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
            }
        });
        ConstraintLayout user_name_layout = (ConstraintLayout) e(R$id.user_name_layout);
        kotlin.jvm.internal.s.h(user_name_layout, "user_name_layout");
        z0.y.d(user_name_layout, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardUserInfoLayout$initView$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
            }
        });
        TextView new_user_tag_txt = (TextView) e(R$id.new_user_tag_txt);
        kotlin.jvm.internal.s.h(new_user_tag_txt, "new_user_tag_txt");
        z0.y.d(new_user_tag_txt, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardUserInfoLayout$initView$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
            }
        });
        ZodiacElfMatchTipsLayout zodiac_elf_match_tips_layout = (ZodiacElfMatchTipsLayout) e(R$id.zodiac_elf_match_tips_layout);
        kotlin.jvm.internal.s.h(zodiac_elf_match_tips_layout, "zodiac_elf_match_tips_layout");
        z0.y.d(zodiac_elf_match_tips_layout, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardUserInfoLayout$initView$4
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKSwipeCardUserInfoLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16902f = new LinkedHashMap();
        this.f16900d = new ArrayList();
        p();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKSwipeCardUserInfoLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16902f = new LinkedHashMap();
        this.f16900d = new ArrayList();
        p();
    }
}
