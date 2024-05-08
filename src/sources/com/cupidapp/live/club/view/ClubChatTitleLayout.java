package com.cupidapp.live.club.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.club.model.ClubInfoDetailModel;
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

/* compiled from: ClubChatTitleLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubChatTitleLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public i f13642b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13643c;

    /* compiled from: ClubChatTitleLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13644a;

        static {
            int[] iArr = new int[ClubChatTitleTabType.values().length];
            try {
                iArr[ClubChatTitleTabType.CHAT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ClubChatTitleTabType.ACTIVITY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f13644a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClubChatTitleLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f13643c = new LinkedHashMap();
        g();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f13643c;
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
        ImageView club_chat_back_btn = (ImageView) a(R$id.club_chat_back_btn);
        s.h(club_chat_back_btn, "club_chat_back_btn");
        y.d(club_chat_back_btn, new Function1<View, p>() { // from class: com.cupidapp.live.club.view.ClubChatTitleLayout$bindClickEvent$1
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
                i iVar;
                iVar = ClubChatTitleLayout.this.f13642b;
                if (iVar != null) {
                    iVar.a();
                }
            }
        });
        ImageView club_chat_more_btn = (ImageView) a(R$id.club_chat_more_btn);
        s.h(club_chat_more_btn, "club_chat_more_btn");
        y.d(club_chat_more_btn, new Function1<View, p>() { // from class: com.cupidapp.live.club.view.ClubChatTitleLayout$bindClickEvent$2
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
                i iVar;
                iVar = ClubChatTitleLayout.this.f13642b;
                if (iVar != null) {
                    iVar.b();
                }
            }
        });
        TextView club_chat_chat_tab_btn = (TextView) a(R$id.club_chat_chat_tab_btn);
        s.h(club_chat_chat_tab_btn, "club_chat_chat_tab_btn");
        y.d(club_chat_chat_tab_btn, new Function1<View, p>() { // from class: com.cupidapp.live.club.view.ClubChatTitleLayout$bindClickEvent$3
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
                i iVar;
                ClubChatTitleLayout.this.e(ClubChatTitleTabType.CHAT);
                iVar = ClubChatTitleLayout.this.f13642b;
                if (iVar != null) {
                    iVar.d();
                }
            }
        });
        TextView club_chat_activity_tab_btn = (TextView) a(R$id.club_chat_activity_tab_btn);
        s.h(club_chat_activity_tab_btn, "club_chat_activity_tab_btn");
        y.d(club_chat_activity_tab_btn, new Function1<View, p>() { // from class: com.cupidapp.live.club.view.ClubChatTitleLayout$bindClickEvent$4
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
                i iVar;
                ClubChatTitleLayout.this.e(ClubChatTitleTabType.ACTIVITY);
                iVar = ClubChatTitleLayout.this.f13642b;
                if (iVar != null) {
                    iVar.c();
                }
            }
        });
    }

    public final void e(ClubChatTitleTabType clubChatTitleTabType) {
        int i10 = R$id.club_chat_chat_tab_btn;
        ((TextView) a(i10)).setBackgroundResource(0);
        int i11 = R$id.club_chat_activity_tab_btn;
        ((TextView) a(i11)).setBackgroundResource(0);
        int i12 = a.f13644a[clubChatTitleTabType.ordinal()];
        if (i12 == 1) {
            ((TextView) a(i10)).setBackgroundResource(R$drawable.rect_cor_8_sd_fdf0e5);
        } else {
            if (i12 != 2) {
                return;
            }
            ((TextView) a(i11)).setBackgroundResource(R$drawable.rect_cor_8_sd_fdf0e5);
            a(R$id.club_chat_activity_btn_red_dot).setVisibility(8);
        }
    }

    public final void f(@NotNull final ClubInfoDetailModel model) {
        s.i(model, "model");
        ImageLoaderView club_chat_avatar_img = (ImageLoaderView) a(R$id.club_chat_avatar_img);
        s.h(club_chat_avatar_img, "club_chat_avatar_img");
        ImageLoaderView.g(club_chat_avatar_img, model.getAvatarImage(), null, null, 6, null);
        ((TextView) a(R$id.club_chat_name_text)).setText(getContext().getString(R$string.club_name_and_count, model.getName(), model.getMemberCount()));
        View a10 = a(R$id.club_chat_more_btn_red_dot);
        Boolean newApplyRedDot = model.getNewApplyRedDot();
        Boolean bool = Boolean.TRUE;
        a10.setVisibility(s.d(newApplyRedDot, bool) ? 0 : 8);
        a(R$id.club_chat_activity_btn_red_dot).setVisibility(s.d(model.getActivityRedDot(), bool) ? 0 : 8);
        ImageLoaderView club_chat_level_tab_img = (ImageLoaderView) a(R$id.club_chat_level_tab_img);
        s.h(club_chat_level_tab_img, "club_chat_level_tab_img");
        ImageLoaderView.g(club_chat_level_tab_img, model.getGroupLevelIcon(), null, null, 6, null);
        LinearLayout club_chat_level_tab = (LinearLayout) a(R$id.club_chat_level_tab);
        s.h(club_chat_level_tab, "club_chat_level_tab");
        y.d(club_chat_level_tab, new Function1<View, p>() { // from class: com.cupidapp.live.club.view.ClubChatTitleLayout$configTitleData$1
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
                j.a.b(com.cupidapp.live.base.router.j.f12156c, ClubChatTitleLayout.this.getContext(), model.getGroupLevelUrl(), null, 4, null);
            }
        });
    }

    public final void g() {
        z.a(this, R$layout.layout_club_chat_title, true);
        TextView club_chat_name_text = (TextView) a(R$id.club_chat_name_text);
        s.h(club_chat_name_text, "club_chat_name_text");
        u.a(club_chat_name_text);
        d();
    }

    public final void h() {
        a(R$id.club_chat_more_btn_red_dot).setVisibility(0);
    }

    public final void setListener(@NotNull i listener) {
        s.i(listener, "listener");
        this.f13642b = listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClubChatTitleLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f13643c = new LinkedHashMap();
        g();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClubChatTitleLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f13643c = new LinkedHashMap();
        g();
    }
}
