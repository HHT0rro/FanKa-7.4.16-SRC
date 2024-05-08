package com.cupidapp.live.club.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.club.model.ClubWelcomeConfirmModel;
import com.cupidapp.live.club.model.ClubWelcomeTipModel;
import com.cupidapp.live.club.view.ClubWelcomeDialogLayout;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.track.group.GroupOthersLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: ClubWelcomeTipBarLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubWelcomeTipBarLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13650b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClubWelcomeTipBarLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f13650b = new LinkedHashMap();
        c();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f13650b;
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

    public final void b(@NotNull final String clubId, @NotNull final ClubWelcomeConfirmModel model, @NotNull final SensorPosition position) {
        s.i(clubId, "clubId");
        s.i(model, "model");
        s.i(position, "position");
        ImageLoaderView club_welcome_tip_avatar_img = (ImageLoaderView) a(R$id.club_welcome_tip_avatar_img);
        s.h(club_welcome_tip_avatar_img, "club_welcome_tip_avatar_img");
        User X = p1.g.f52734a.X();
        ImageLoaderView.g(club_welcome_tip_avatar_img, X != null ? X.getAvatarImage() : null, null, null, 6, null);
        TextView textView = (TextView) a(R$id.club_welcome_tip_title_text);
        ClubWelcomeTipModel conciseInfo = model.getConciseInfo();
        textView.setText(conciseInfo != null ? conciseInfo.getTitle() : null);
        TextView textView2 = (TextView) a(R$id.club_welcome_tip_desc_text);
        ClubWelcomeTipModel conciseInfo2 = model.getConciseInfo();
        textView2.setText(conciseInfo2 != null ? conciseInfo2.getBottomMsg() : null);
        ConstraintLayout club_welcome_tip_root_layout = (ConstraintLayout) a(R$id.club_welcome_tip_root_layout);
        s.h(club_welcome_tip_root_layout, "club_welcome_tip_root_layout");
        y.d(club_welcome_tip_root_layout, new Function1<View, p>() { // from class: com.cupidapp.live.club.view.ClubWelcomeTipBarLayout$configData$1
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
                ClubWelcomeDialogLayout.Companion companion = ClubWelcomeDialogLayout.f13647f;
                Context context = ClubWelcomeTipBarLayout.this.getContext();
                s.h(context, "context");
                String str = clubId;
                ClubWelcomeConfirmModel clubWelcomeConfirmModel = model;
                SensorPosition sensorPosition = position;
                final ClubWelcomeTipBarLayout clubWelcomeTipBarLayout = ClubWelcomeTipBarLayout.this;
                companion.b(context, str, clubWelcomeConfirmModel, sensorPosition, new Function0<p>() { // from class: com.cupidapp.live.club.view.ClubWelcomeTipBarLayout$configData$1.1
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
                        ClubWelcomeTipBarLayout.this.setVisibility(8);
                    }
                });
                GroupOthersLog.I(GroupOthersLog.f18702a, "CLUB_SHOULD_KNOW", position, null, null, 8, null);
            }
        });
        GroupOthersLog.L(GroupOthersLog.f18702a, position, "CLUB_SHOULD_KNOW", null, 4, null);
    }

    public final void c() {
        z.a(this, R$layout.layout_club_welcome_tip_bar, true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClubWelcomeTipBarLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f13650b = new LinkedHashMap();
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClubWelcomeTipBarLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f13650b = new LinkedHashMap();
        c();
    }
}