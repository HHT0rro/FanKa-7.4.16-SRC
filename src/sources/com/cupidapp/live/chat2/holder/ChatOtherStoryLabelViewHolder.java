package com.cupidapp.live.chat2.holder;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.chat2.model.ChatTouchMessageListCloseAllPanelEvent;
import com.cupidapp.live.profile.model.FKStoryLabelItemModel;
import com.cupidapp.live.setting.activity.FKStoryLabelListActivity;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x0.a;
import z0.h;
import z0.y;
import z0.z;

/* compiled from: ChatOtherStoryLabelViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatOtherStoryLabelViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f13382d = new a(null);

    /* renamed from: c, reason: collision with root package name */
    public boolean f13383c;

    /* compiled from: ChatOtherStoryLabelViewHolder.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ChatOtherStoryLabelViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new ChatOtherStoryLabelViewHolder(z.b(parent, R$layout.view_holder_chat_other_story_label, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatOtherStoryLabelViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    public static final boolean v(View view, MotionEvent motionEvent) {
        view.performClick();
        if (motionEvent.getAction() != 0) {
            return false;
        }
        EventBus.c().l(new ChatTouchMessageListCloseAllPanelEvent());
        return false;
    }

    public static final void w(ChatOtherStoryLabelViewHolder this$0) {
        s.i(this$0, "this$0");
        View view = this$0.itemView;
        int i10 = R$id.other_story_label_content;
        if (((TextView) view.findViewById(i10)).getLineCount() > 2) {
            ((TextView) this$0.itemView.findViewById(i10)).setMaxLines(2);
            ((ImageView) this$0.itemView.findViewById(R$id.other_story_label_icon)).setVisibility(0);
        } else {
            ((ImageView) this$0.itemView.findViewById(R$id.other_story_label_icon)).setVisibility(4);
        }
        ((TextView) this$0.itemView.findViewById(i10)).setVisibility(0);
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof ChatOtherStoryLabelUiModel) {
            this.itemView.setOnTouchListener(new View.OnTouchListener() { // from class: com.cupidapp.live.chat2.holder.c
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean v2;
                    v2 = ChatOtherStoryLabelViewHolder.v(view, motionEvent);
                    return v2;
                }
            });
            a.C0834a c0834a = x0.a.f54353h;
            ConstraintLayout constraintLayout = (ConstraintLayout) this.itemView.findViewById(R$id.other_story_label_container);
            s.h(constraintLayout, "itemView.other_story_label_container");
            c0834a.a(constraintLayout, -1, h.c(this, 12.0f), com.cupidapp.live.base.utils.h.a(-16777216, 0.08f), h.c(this, 5.0f), 0.0f, 0.0f);
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.other_story_label_image);
            s.h(imageLoaderView, "itemView.other_story_label_image");
            ChatOtherStoryLabelUiModel chatOtherStoryLabelUiModel = (ChatOtherStoryLabelUiModel) obj;
            FKStoryLabelItemModel storyLabel = chatOtherStoryLabelUiModel.getStoryLabel();
            ImageLoaderView.g(imageLoaderView, storyLabel != null ? storyLabel.getIcon() : null, null, null, 6, null);
            View view = this.itemView;
            int i10 = R$id.other_story_label_title;
            ((TextView) view.findViewById(i10)).getPaint().setFakeBoldText(true);
            TextView textView = (TextView) this.itemView.findViewById(i10);
            FKStoryLabelItemModel storyLabel2 = chatOtherStoryLabelUiModel.getStoryLabel();
            textView.setText(storyLabel2 != null ? storyLabel2.getQuestion() : null);
            View view2 = this.itemView;
            int i11 = R$id.other_story_label_content;
            TextView textView2 = (TextView) view2.findViewById(i11);
            FKStoryLabelItemModel storyLabel3 = chatOtherStoryLabelUiModel.getStoryLabel();
            textView2.setText(storyLabel3 != null ? storyLabel3.getContent() : null);
            ((TextView) this.itemView.findViewById(i11)).post(new Runnable() { // from class: com.cupidapp.live.chat2.holder.d
                @Override // java.lang.Runnable
                public final void run() {
                    ChatOtherStoryLabelViewHolder.w(ChatOtherStoryLabelViewHolder.this);
                }
            });
            ImageView imageView = (ImageView) this.itemView.findViewById(R$id.other_story_label_icon);
            s.h(imageView, "itemView.other_story_label_icon");
            y.d(imageView, new Function1<View, p>() { // from class: com.cupidapp.live.chat2.holder.ChatOtherStoryLabelViewHolder$config$3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(View view3) {
                    invoke2(view3);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable View view3) {
                    boolean z10;
                    boolean z11;
                    z10 = ChatOtherStoryLabelViewHolder.this.f13383c;
                    if (z10) {
                        ((ImageView) ChatOtherStoryLabelViewHolder.this.itemView.findViewById(R$id.other_story_label_icon)).setRotation(90.0f);
                        ((TextView) ChatOtherStoryLabelViewHolder.this.itemView.findViewById(R$id.other_story_label_content)).setMaxLines(2);
                    } else {
                        ((ImageView) ChatOtherStoryLabelViewHolder.this.itemView.findViewById(R$id.other_story_label_icon)).setRotation(270.0f);
                        ((TextView) ChatOtherStoryLabelViewHolder.this.itemView.findViewById(R$id.other_story_label_content)).setMaxHeight(h.k(ChatOtherStoryLabelViewHolder.this));
                    }
                    ChatOtherStoryLabelViewHolder chatOtherStoryLabelViewHolder = ChatOtherStoryLabelViewHolder.this;
                    z11 = chatOtherStoryLabelViewHolder.f13383c;
                    chatOtherStoryLabelViewHolder.f13383c = !z11;
                }
            });
            if (s.d(chatOtherStoryLabelUiModel.getCanEdit(), Boolean.TRUE)) {
                View view3 = this.itemView;
                int i12 = R$id.other_edit_story_label_layout;
                ((LinearLayout) view3.findViewById(i12)).setVisibility(0);
                ((TextView) this.itemView.findViewById(R$id.chat_fill_story_label)).getPaint().setFakeBoldText(true);
                LinearLayout linearLayout = (LinearLayout) this.itemView.findViewById(i12);
                s.h(linearLayout, "itemView.other_edit_story_label_layout");
                y.d(linearLayout, new Function1<View, p>() { // from class: com.cupidapp.live.chat2.holder.ChatOtherStoryLabelViewHolder$config$4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(View view4) {
                        invoke2(view4);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable View view4) {
                        FKStoryLabelListActivity.f17962r.a(ChatOtherStoryLabelViewHolder.this.itemView.getContext(), SensorPosition.MessageDetail);
                    }
                });
                return;
            }
            ((LinearLayout) this.itemView.findViewById(R$id.other_edit_story_label_layout)).setVisibility(8);
        }
    }
}
