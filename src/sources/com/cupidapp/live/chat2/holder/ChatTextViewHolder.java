package com.cupidapp.live.chat2.holder;

import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import com.cupidapp.live.R$array;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderUtil;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.MessageUiType;
import com.cupidapp.live.chat2.fragment.ChatDetailFragment;
import com.cupidapp.live.chat2.helper.ChatBubbleHelper;
import com.cupidapp.live.chat2.helper.ChatViewHolderFactory;
import com.cupidapp.live.chat2.model.ChatMessageModel;
import com.cupidapp.live.chat2.model.ChatTextType;
import com.cupidapp.live.chat2.model.LongClickActionType;
import com.cupidapp.live.chat2.model.MessageBubbleModel;
import com.cupidapp.live.chat2.view.ChatMessageStateView;
import com.cupidapp.live.chat2.view.ChatTimeStampView;
import com.cupidapp.live.chat2.view.ChatTopicMessageLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.m;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.t;
import z0.z;

/* compiled from: ChatTextViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatTextViewHolder extends BaseChatViewHolder {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f13393e = new a(null);

    /* renamed from: d, reason: collision with root package name */
    public boolean f13394d;

    /* compiled from: ChatTextViewHolder.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a implements ChatViewHolderFactory {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // com.cupidapp.live.chat2.helper.ChatViewHolderFactory
        @NotNull
        public BaseChatViewHolder a(@NotNull ViewGroup parent, boolean z10) {
            s.i(parent, "parent");
            return new ChatTextViewHolder(z.b(parent, z10 ? R$layout.view_holder_chat_text_right : R$layout.view_holder_chat_text_left, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatTextViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    public static final void J(TextView bubbleTextView, List listColor) {
        s.i(bubbleTextView, "$bubbleTextView");
        s.i(listColor, "$listColor");
        bubbleTextView.getPaint().setShader(new LinearGradient(0.0f, 0.0f, bubbleTextView.getWidth(), 0.0f, CollectionsKt___CollectionsKt.w0(listColor), (float[]) null, Shader.TileMode.CLAMP));
        bubbleTextView.setText(bubbleTextView.getText());
    }

    @Override // com.cupidapp.live.chat2.holder.BaseChatViewHolder
    @Nullable
    public ImageLoaderView A() {
        return (ImageLoaderView) this.itemView.findViewById(R$id.left_text_avatar_image);
    }

    @Override // com.cupidapp.live.chat2.holder.BaseChatViewHolder
    @Nullable
    public ChatMessageStateView B() {
        return (ChatMessageStateView) this.itemView.findViewById(R$id.right_text_message_state_view);
    }

    @Override // com.cupidapp.live.chat2.holder.BaseChatViewHolder
    @Nullable
    public ChatTimeStampView C() {
        return (ChatTimeStampView) this.itemView.findViewById(R$id.chat_text_time_stamp_view);
    }

    public final void F(boolean z10, ChatMessageModel chatMessageModel, TextView textView, TextView textView2, ImageView imageView, ChatTopicMessageLayout chatTopicMessageLayout) {
        this.f13394d = false;
        textView.setVisibility(8);
        textView2.setVisibility(8);
        imageView.setVisibility(8);
        chatTopicMessageLayout.setVisibility(8);
        int a10 = w1.a.f54094a.a(chatMessageModel.getText());
        Integer textType = chatMessageModel.getTextType();
        int value = ChatTextType.CHAT_TOPIC.getValue();
        if (textType != null && textType.intValue() == value) {
            chatTopicMessageLayout.setVisibility(0);
            chatTopicMessageLayout.setChatTopicMessageText(chatMessageModel.getText());
            return;
        }
        if (a10 != -1) {
            imageView.setVisibility(0);
            imageView.setImageResource(a10);
        } else if (L(chatMessageModel.getText())) {
            textView2.setVisibility(0);
            textView2.setText(chatMessageModel.getText());
        } else {
            textView.setVisibility(0);
            this.f13394d = true;
            H(z10, textView);
            I(z10, textView, chatMessageModel.getText());
        }
    }

    public final void G(boolean z10, final TextView textView) {
        String str = z10 ? "png/icon_chat_right_text_bubble.png" : "png/icon_chat_left_text_bubble.png";
        ImageLoaderUtil imageLoaderUtil = ImageLoaderUtil.f11832a;
        Context context = this.itemView.getContext();
        s.h(context, "itemView.context");
        imageLoaderUtil.i(context, str, new Function1<Drawable, p>() { // from class: com.cupidapp.live.chat2.holder.ChatTextViewHolder$configDefaultMessageBubble$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Drawable drawable) {
                invoke2(drawable);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Drawable drawable) {
                TextView.this.setBackground(drawable);
            }
        });
    }

    public final void H(final boolean z10, final TextView textView) {
        String str = null;
        if (z10) {
            MessageBubbleModel a10 = ChatDetailFragment.f13305o.a();
            if (a10 != null) {
                str = a10.getIndividuationInboxBubbleConfig();
            }
        } else {
            MessageBubbleModel b4 = ChatDetailFragment.f13305o.b();
            if (b4 != null) {
                str = b4.getIndividuationInboxBubbleConfig();
            }
        }
        if (str == null || str.length() == 0) {
            G(z10, textView);
            return;
        }
        String n10 = ChatBubbleHelper.f13339a.n(str);
        if (n10 == null || n10.length() == 0) {
            G(z10, textView);
            return;
        }
        ImageLoaderUtil imageLoaderUtil = ImageLoaderUtil.f11832a;
        Context context = this.itemView.getContext();
        s.h(context, "itemView.context");
        imageLoaderUtil.j(context, n10, new Function1<Drawable, p>() { // from class: com.cupidapp.live.chat2.holder.ChatTextViewHolder$configMessageBubble$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Drawable drawable) {
                invoke2(drawable);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Drawable drawable) {
                if (drawable == null) {
                    ChatTextViewHolder.this.G(z10, textView);
                } else {
                    textView.setBackground(drawable);
                }
            }
        });
    }

    public final void I(boolean z10, final TextView textView, String str) {
        List<String> textColors;
        if (z10) {
            MessageBubbleModel a10 = ChatDetailFragment.f13305o.a();
            if (a10 != null) {
                textColors = a10.getTextColors();
            }
            textColors = null;
        } else {
            MessageBubbleModel b4 = ChatDetailFragment.f13305o.b();
            if (b4 != null) {
                textColors = b4.getTextColors();
            }
            textColors = null;
        }
        int i10 = z10 ? -1 : -12566464;
        if (textColors == null || textColors.isEmpty()) {
            textView.getPaint().setShader(null);
            textView.setTextColor(i10);
            K(textView, str, Integer.valueOf(i10));
            return;
        }
        if (textColors.size() == 1) {
            textView.getPaint().setShader(null);
            Integer M = M((String) CollectionsKt___CollectionsKt.V(textColors));
            if (M != null) {
                i10 = M.intValue();
            }
            textView.setTextColor(i10);
            K(textView, str, Integer.valueOf(i10));
            return;
        }
        final ArrayList arrayList = new ArrayList();
        Iterator<String> iterator2 = textColors.iterator2();
        while (iterator2.hasNext()) {
            Integer M2 = M(iterator2.next());
            if (M2 != null) {
                arrayList.add(M2);
            }
        }
        if (arrayList.isEmpty()) {
            textView.getPaint().setShader(null);
            textView.setTextColor(i10);
            K(textView, str, Integer.valueOf(i10));
        } else {
            K(textView, str, null);
            textView.post(new Runnable() { // from class: com.cupidapp.live.chat2.holder.e
                @Override // java.lang.Runnable
                public final void run() {
                    ChatTextViewHolder.J(TextView.this, arrayList);
                }
            });
        }
    }

    public final void K(TextView textView, final String str, @ColorInt Integer num) {
        if (str == null || str.length() == 0) {
            return;
        }
        q1.e.f53007a.a(textView, str, num, new Function1<String, p>() { // from class: com.cupidapp.live.chat2.holder.ChatTextViewHolder$handleHyperLink$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(String str2) {
                invoke2(str2);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String url) {
                s.i(url, "url");
                j1.e.f50230a.a(String.this, url, MessageUiType.OnlyText.getValue());
                j.a.b(j.f12156c, this.itemView.getContext(), url, null, 4, null);
            }
        });
    }

    public final boolean L(String str) {
        if (str == null || str.length() > 2 || !t.b(str)) {
            return false;
        }
        String[] stringArray = this.itemView.getContext().getResources().getStringArray(R$array.emoji_face);
        s.h(stringArray, "itemView.context.resourc…Array(R.array.emoji_face)");
        return m.t(stringArray, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0011  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0012 A[Catch: Exception -> 0x000c, TRY_LEAVE, TryCatch #0 {Exception -> 0x000c, blocks: (B:17:0x0003, B:8:0x0012), top: B:16:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Integer M(java.lang.String r3) {
        /*
            r2 = this;
            r0 = 0
            if (r3 == 0) goto Le
            int r1 = r3.length()     // Catch: java.lang.Exception -> Lc
            if (r1 != 0) goto La
            goto Le
        La:
            r1 = 0
            goto Lf
        Lc:
            r3 = move-exception
            goto L1c
        Le:
            r1 = 1
        Lf:
            if (r1 == 0) goto L12
            goto L1f
        L12:
            int r3 = android.graphics.Color.parseColor(r3)     // Catch: java.lang.Exception -> Lc
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Exception -> Lc
            r0 = r3
            goto L1f
        L1c:
            r3.printStackTrace()
        L1f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.chat2.holder.ChatTextViewHolder.M(java.lang.String):java.lang.Integer");
    }

    @Override // com.cupidapp.live.chat2.holder.BaseChatViewHolder
    @Nullable
    public ArrayList<LongClickActionType> v(@NotNull ChatMessageModel model) {
        ArrayList<LongClickActionType> f10;
        s.i(model, "model");
        boolean z10 = true;
        if (model.getMine()) {
            f10 = new ArrayList<>();
            f10.add(LongClickActionType.Copy);
            String itemId = model.getItemId();
            if (itemId != null && itemId.length() != 0) {
                z10 = false;
            }
            if (!z10) {
                if (model.less2Min()) {
                    f10.add(LongClickActionType.Cancel);
                }
                f10.add(LongClickActionType.Delete);
            }
        } else {
            f10 = kotlin.collections.s.f(LongClickActionType.Copy, LongClickActionType.Delete, LongClickActionType.Report);
        }
        if (this.f13394d) {
            f10.add(LongClickActionType.Personal);
        }
        return f10;
    }

    @Override // com.cupidapp.live.chat2.holder.BaseChatViewHolder
    public void y(@NotNull ChatMessageModel model) {
        s.i(model, "model");
        View view = this.itemView;
        int i10 = R$id.left_text_bubble_text_view;
        TextView textView = (TextView) view.findViewById(i10);
        s.h(textView, "itemView.left_text_bubble_text_view");
        TextView textView2 = (TextView) this.itemView.findViewById(R$id.left_text_single_emoji_text);
        s.h(textView2, "itemView.left_text_single_emoji_text");
        ImageView imageView = (ImageView) this.itemView.findViewById(R$id.left_text_emoji_image);
        s.h(imageView, "itemView.left_text_emoji_image");
        ChatTopicMessageLayout chatTopicMessageLayout = (ChatTopicMessageLayout) this.itemView.findViewById(R$id.left_text_topic_msg_layout);
        s.h(chatTopicMessageLayout, "itemView.left_text_topic_msg_layout");
        F(false, model, textView, textView2, imageView, chatTopicMessageLayout);
        FrameLayout frameLayout = (FrameLayout) this.itemView.findViewById(R$id.left_text_content_frame_layout);
        s.h(frameLayout, "itemView.left_text_content_frame_layout");
        t(frameLayout, model);
        TextView textView3 = (TextView) this.itemView.findViewById(i10);
        s.h(textView3, "itemView.left_text_bubble_text_view");
        t(textView3, model);
    }

    @Override // com.cupidapp.live.chat2.holder.BaseChatViewHolder
    public void z(@NotNull ChatMessageModel model) {
        s.i(model, "model");
        View view = this.itemView;
        int i10 = R$id.right_text_bubble_text_view;
        TextView textView = (TextView) view.findViewById(i10);
        s.h(textView, "itemView.right_text_bubble_text_view");
        TextView textView2 = (TextView) this.itemView.findViewById(R$id.right_text_single_emoji_text);
        s.h(textView2, "itemView.right_text_single_emoji_text");
        ImageView imageView = (ImageView) this.itemView.findViewById(R$id.right_text_emoji_image);
        s.h(imageView, "itemView.right_text_emoji_image");
        ChatTopicMessageLayout chatTopicMessageLayout = (ChatTopicMessageLayout) this.itemView.findViewById(R$id.right_text_topic_msg_layout);
        s.h(chatTopicMessageLayout, "itemView.right_text_topic_msg_layout");
        F(true, model, textView, textView2, imageView, chatTopicMessageLayout);
        FrameLayout frameLayout = (FrameLayout) this.itemView.findViewById(R$id.right_text_content_frame_layout);
        s.h(frameLayout, "itemView.right_text_content_frame_layout");
        t(frameLayout, model);
        TextView textView3 = (TextView) this.itemView.findViewById(i10);
        s.h(textView3, "itemView.right_text_bubble_text_view");
        t(textView3, model);
    }
}
