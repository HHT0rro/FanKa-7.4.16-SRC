package com.cupidapp.live.club.viewholder;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.chat2.model.ChatTouchMessageListCloseAllPanelEvent;
import com.cupidapp.live.chat2.model.LongClickActionType;
import com.cupidapp.live.chat2.view.ChatMessageStateView;
import com.cupidapp.live.chat2.view.ChatTimeStampView;
import com.cupidapp.live.club.model.ClubChatAtUserEvent;
import com.cupidapp.live.club.model.ClubChatGoToNearByMiniProfilePageEvent;
import com.cupidapp.live.club.model.ClubChatMsgBindLongClickEvent;
import com.cupidapp.live.club.model.ClubChatMsgModel;
import com.cupidapp.live.club.view.ClubChatLeftUserInfoLayout;
import com.cupidapp.live.profile.model.User;
import java.util.ArrayList;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.y;

/* compiled from: BaseClubChatViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class BaseClubChatViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f13681c = new a(null);

    /* compiled from: BaseClubChatViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseClubChatViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    public static final boolean u(BaseClubChatViewHolder this$0, ClubChatMsgModel model, View view) {
        s.i(this$0, "this$0");
        s.i(model, "$model");
        ArrayList<LongClickActionType> v2 = this$0.v(model);
        if (!(v2 == null || v2.isEmpty())) {
            EventBus.c().l(new ClubChatMsgBindLongClickEvent(v2, model));
        }
        return true;
    }

    public static final boolean w(BaseClubChatViewHolder this$0, View view, MotionEvent motionEvent) {
        s.i(this$0, "this$0");
        view.performClick();
        ImageLoaderView A = this$0.A();
        if (motionEvent.getAction() != 0) {
            return false;
        }
        if (A != null && motionEvent.getX() >= this$0.E(A.getLeft()) && this$0.E((int) motionEvent.getX()) <= A.getRight() && this$0.E((int) motionEvent.getY()) <= A.getBottom() && motionEvent.getY() >= this$0.E(A.getTop())) {
            return false;
        }
        EventBus.c().l(new ChatTouchMessageListCloseAllPanelEvent());
        return false;
    }

    @Nullable
    public abstract ImageLoaderView A();

    @Nullable
    public abstract ClubChatLeftUserInfoLayout B();

    @Nullable
    public abstract ChatMessageStateView C();

    @Nullable
    public abstract ChatTimeStampView D();

    public final int E(int i10) {
        return i10 - h.c(this, 10.0f);
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable final Object obj) {
        if (obj instanceof ClubChatMsgModel) {
            this.itemView.setOnTouchListener(new View.OnTouchListener() { // from class: com.cupidapp.live.club.viewholder.b
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean w3;
                    w3 = BaseClubChatViewHolder.w(BaseClubChatViewHolder.this, view, motionEvent);
                    return w3;
                }
            });
            ClubChatMsgModel clubChatMsgModel = (ClubChatMsgModel) obj;
            if (clubChatMsgModel.getMine()) {
                z(clubChatMsgModel);
                ChatMessageStateView C = C();
                if (C != null) {
                    C.b(clubChatMsgModel);
                    return;
                }
                return;
            }
            ImageLoaderView A = A();
            if (A != null) {
                User sender = clubChatMsgModel.getSender();
                ImageLoaderView.g(A, sender != null ? sender.getAvatarImage() : null, null, null, 6, null);
                y.d(A, new Function1<View, p>() { // from class: com.cupidapp.live.club.viewholder.BaseClubChatViewHolder$config$2$1
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
                        EventBus.c().l(new ClubChatGoToNearByMiniProfilePageEvent(((ClubChatMsgModel) Object.this).getSender()));
                    }
                });
                y.c(A, new Function1<View, p>() { // from class: com.cupidapp.live.club.viewholder.BaseClubChatViewHolder$config$2$2
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
                        EventBus.c().l(new ClubChatAtUserEvent(((ClubChatMsgModel) Object.this).getSender()));
                    }
                });
            }
            ClubChatLeftUserInfoLayout B = B();
            if (B != null) {
                ClubChatLeftUserInfoLayout.e(B, clubChatMsgModel.getSender(), clubChatMsgModel.getMedalIcon(), clubChatMsgModel.getMedalLevel(), false, 8, null);
            }
            y(clubChatMsgModel);
        }
    }

    public final void t(@NotNull View view, @NotNull final ClubChatMsgModel model) {
        s.i(view, "view");
        s.i(model, "model");
        view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.cupidapp.live.club.viewholder.a
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view2) {
                boolean u10;
                u10 = BaseClubChatViewHolder.u(BaseClubChatViewHolder.this, model, view2);
                return u10;
            }
        });
    }

    @Nullable
    public abstract ArrayList<LongClickActionType> v(@NotNull ClubChatMsgModel clubChatMsgModel);

    public final void x(long j10, long j11) {
        ChatTimeStampView D = D();
        if (D == null) {
            return;
        }
        if (j10 - j11 > TTAdConstant.AD_MAX_EVENT_TIME) {
            D.setVisibility(0);
            D.setTimeStamp(j10);
        } else {
            D.setVisibility(8);
        }
    }

    public abstract void y(@NotNull ClubChatMsgModel clubChatMsgModel);

    public abstract void z(@NotNull ClubChatMsgModel clubChatMsgModel);
}
