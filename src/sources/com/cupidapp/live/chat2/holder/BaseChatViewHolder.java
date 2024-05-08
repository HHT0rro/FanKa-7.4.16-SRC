package com.cupidapp.live.chat2.holder;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.chat2.model.ChatGoToProfilePageEvent;
import com.cupidapp.live.chat2.model.ChatMeReadOtherMessageEvent;
import com.cupidapp.live.chat2.model.ChatMessageBindLongClickEvent;
import com.cupidapp.live.chat2.model.ChatMessageModel;
import com.cupidapp.live.chat2.model.ChatTouchMessageListCloseAllPanelEvent;
import com.cupidapp.live.chat2.model.LongClickActionType;
import com.cupidapp.live.chat2.view.ChatMessageStateView;
import com.cupidapp.live.chat2.view.ChatTimeStampView;
import com.cupidapp.live.profile.model.User;
import java.util.ArrayList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;

/* compiled from: BaseChatViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class BaseChatViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f13372c = new a(null);

    /* compiled from: BaseChatViewHolder.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseChatViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    public static final boolean u(BaseChatViewHolder this$0, ChatMessageModel model, View view) {
        s.i(this$0, "this$0");
        s.i(model, "$model");
        ArrayList<LongClickActionType> v2 = this$0.v(model);
        if (!(v2 == null || v2.isEmpty())) {
            EventBus.c().l(new ChatMessageBindLongClickEvent(v2, model));
        }
        return true;
    }

    public static final boolean w(View view, MotionEvent motionEvent) {
        view.performClick();
        if (motionEvent.getAction() != 0) {
            return false;
        }
        EventBus.c().l(new ChatTouchMessageListCloseAllPanelEvent());
        return false;
    }

    @Nullable
    public abstract ImageLoaderView A();

    @Nullable
    public abstract ChatMessageStateView B();

    @Nullable
    public abstract ChatTimeStampView C();

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof ChatMessageModel) {
            this.itemView.setOnTouchListener(new View.OnTouchListener() { // from class: com.cupidapp.live.chat2.holder.b
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean w3;
                    w3 = BaseChatViewHolder.w(view, motionEvent);
                    return w3;
                }
            });
            ChatMessageModel chatMessageModel = (ChatMessageModel) obj;
            if (chatMessageModel.getMine()) {
                z(chatMessageModel);
                ChatMessageStateView B = B();
                if (B != null) {
                    B.a(chatMessageModel);
                }
            } else {
                ImageLoaderView A = A();
                if (A != null) {
                    User sender = chatMessageModel.getSender();
                    ImageLoaderView.g(A, sender != null ? sender.getAvatarImage() : null, null, null, 6, null);
                    y.d(A, new Function1<View, p>() { // from class: com.cupidapp.live.chat2.holder.BaseChatViewHolder$config$2$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ p invoke(View view) {
                            invoke2(view);
                            return p.f51048a;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@Nullable View view) {
                            EventBus.c().l(new ChatGoToProfilePageEvent());
                        }
                    });
                }
                y(chatMessageModel);
            }
            String itemId = chatMessageModel.getItemId();
            if ((itemId == null || itemId.length() == 0) || chatMessageModel.getMine() || !s.d(chatMessageModel.getUnread(), Boolean.TRUE) || chatMessageModel.isSnapMessage()) {
                return;
            }
            EventBus.c().l(new ChatMeReadOtherMessageEvent(chatMessageModel));
        }
    }

    public final void t(@NotNull View view, @NotNull final ChatMessageModel model) {
        s.i(view, "view");
        s.i(model, "model");
        view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.cupidapp.live.chat2.holder.a
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view2) {
                boolean u10;
                u10 = BaseChatViewHolder.u(BaseChatViewHolder.this, model, view2);
                return u10;
            }
        });
    }

    @Nullable
    public abstract ArrayList<LongClickActionType> v(@NotNull ChatMessageModel chatMessageModel);

    public final void x(long j10, long j11) {
        ChatTimeStampView C = C();
        if (C == null) {
            return;
        }
        if (j10 - j11 > TTAdConstant.AD_MAX_EVENT_TIME) {
            C.setVisibility(0);
            C.setTimeStamp(j10);
        } else {
            C.setVisibility(8);
        }
    }

    public abstract void y(@NotNull ChatMessageModel chatMessageModel);

    public abstract void z(@NotNull ChatMessageModel chatMessageModel);
}
