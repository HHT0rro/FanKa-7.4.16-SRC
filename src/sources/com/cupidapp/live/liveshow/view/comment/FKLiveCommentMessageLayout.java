package com.cupidapp.live.liveshow.view.comment;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.sensorslog.SensorsLogMatch;
import com.cupidapp.live.base.view.h;
import com.cupidapp.live.liveshow.adapter.FKLiveCommentMessageViewModel;
import com.cupidapp.live.liveshow.model.CommentModel;
import com.cupidapp.live.liveshow.view.miniprofile.ShowLiveMiniProfileViewModel;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.track.group.GroupSocialLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: FKLiveCommentMessageLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveCommentMessageLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    public boolean f15364b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f15365c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f15366d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public FKLiveCommentMessageViewModel f15367e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15368f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveCommentMessageLayout(@NotNull Context context, boolean z10) {
        super(context);
        s.i(context, "context");
        this.f15368f = new LinkedHashMap();
        this.f15365c = true;
        e(z10);
    }

    public static /* synthetic */ void f(FKLiveCommentMessageLayout fKLiveCommentMessageLayout, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        fKLiveCommentMessageLayout.e(z10);
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f15368f;
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

    public final void b() {
        ConstraintLayout commentMessageContainerLayout = (ConstraintLayout) a(R$id.commentMessageContainerLayout);
        s.h(commentMessageContainerLayout, "commentMessageContainerLayout");
        y.d(commentMessageContainerLayout, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.comment.FKLiveCommentMessageLayout$bindClickEvent$1
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
                User user;
                FKLiveCommentMessageViewModel commentMessageModel = FKLiveCommentMessageLayout.this.getCommentMessageModel();
                if (commentMessageModel == null || (user = commentMessageModel.getCommentModel().getUser()) == null) {
                    return;
                }
                GroupSocialLog.f18708a.u(SensorScene.Live.getValue(), user.userId(), (r13 & 4) != 0 ? null : null, (r13 & 8) != 0 ? false : false, (r13 & 16) != 0 ? null : null);
                EventBus.c().l(new ShowLiveMiniProfileViewModel(user.userId(), SensorsLogMatch.AlohaGetPosition.Comment, commentMessageModel.getCommentModel().getReportData(), false, false, false, 56, null));
            }
        });
        ImageView commentWarnImage = (ImageView) a(R$id.commentWarnImage);
        s.h(commentWarnImage, "commentWarnImage");
        y.d(commentWarnImage, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.comment.FKLiveCommentMessageLayout$bindClickEvent$2
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
                h.f12779a.r(FKLiveCommentMessageLayout.this.getContext(), R$string.live_show_comment_warn_prompt);
            }
        });
    }

    public final void c(CommentModel commentModel, boolean z10) {
        int c4;
        int i10 = R$id.commentWarnImage;
        ((ImageView) a(i10)).setVisibility(z10 ? 0 : 8);
        if (((ImageView) a(i10)).getVisibility() == 0) {
            if (commentModel.getRightTopImage() == null && commentModel.getRightBottomImage() == null) {
                c4 = z0.h.c(this, 27.0f);
            } else {
                c4 = z0.h.c(this, 50.0f);
            }
        } else if (commentModel.getRightTopImage() == null && commentModel.getRightBottomImage() == null) {
            c4 = z0.h.c(this, 0.0f);
        } else {
            c4 = z0.h.c(this, 28.0f);
        }
        ConstraintLayout commentMessageContainerLayout = (ConstraintLayout) a(R$id.commentMessageContainerLayout);
        s.h(commentMessageContainerLayout, "commentMessageContainerLayout");
        y.m(commentMessageContainerLayout, null, null, Integer.valueOf(c4), null, 11, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x02b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void d(com.cupidapp.live.liveshow.model.CommentModel r26, boolean r27) {
        /*
            Method dump skipped, instructions count: 757
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.liveshow.view.comment.FKLiveCommentMessageLayout.d(com.cupidapp.live.liveshow.model.CommentModel, boolean):void");
    }

    public final void e(boolean z10) {
        this.f15364b = z10;
        z.a(this, R$layout.recycler_item_comment, true);
        b();
    }

    public final boolean g() {
        return this.f15365c;
    }

    @Nullable
    public final FKLiveCommentMessageViewModel getCommentMessageModel() {
        return this.f15367e;
    }

    public final void setAnimation(boolean z10) {
        this.f15365c = z10;
    }

    public final void setBarrage(boolean z10) {
        this.f15366d = z10;
    }

    public final void setCommentMessageModel(@Nullable FKLiveCommentMessageViewModel fKLiveCommentMessageViewModel) {
        this.f15367e = fKLiveCommentMessageViewModel;
        if (fKLiveCommentMessageViewModel != null) {
            d(fKLiveCommentMessageViewModel.getCommentModel(), fKLiveCommentMessageViewModel.getCommentInvalid());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveCommentMessageLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15368f = new LinkedHashMap();
        this.f15365c = true;
        f(this, false, 1, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveCommentMessageLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15368f = new LinkedHashMap();
        this.f15365c = true;
        f(this, false, 1, null);
    }
}
