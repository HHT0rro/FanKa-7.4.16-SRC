package com.cupidapp.live.chat2.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.utils.r0;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.chat.model.CustomEmojiCode;
import com.cupidapp.live.chat.view.FaceLayout;
import com.cupidapp.live.feed.model.FeedModel;
import com.cupidapp.live.push.model.PushAlertScene;
import com.cupidapp.live.push.model.PushAlertShowModel;
import com.cupidapp.live.setting.activity.CustomPushActivity;
import com.cupidapp.live.track.group.GroupOthersLog;
import com.cupidapp.live.track.group.GroupSocialLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: ChatDetailTipsLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatDetailTipsLayout extends BaseLayout implements DefaultLifecycleObserver {

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public g f13440d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13441e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatDetailTipsLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f13441e = new LinkedHashMap();
        k();
    }

    @Nullable
    public View e(int i10) {
        Map<Integer, View> map = this.f13441e;
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

    public final void g(boolean z10) {
        ((FrameLayout) e(R$id.from_story_label_parent_layout)).setVisibility(z10 ? 0 : 8);
    }

    public final void h(@NotNull final LifecycleOwner lifecycleOwner) {
        s.i(lifecycleOwner, "lifecycleOwner");
        r0.a aVar = r0.f12373a;
        Context context = getContext();
        s.h(context, "context");
        if (aVar.a(context)) {
            ((LinearLayout) e(R$id.open_push_parent_layout)).setVisibility(8);
            return;
        }
        Disposable disposed = NetworkClient.f11868a.F().f(PushAlertScene.ChatDetailScene.getValue()).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<PushAlertShowModel, p>() { // from class: com.cupidapp.live.chat2.view.ChatDetailTipsLayout$configOpenPushTip$$inlined$handle$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(PushAlertShowModel pushAlertShowModel) {
                m2493invoke(pushAlertShowModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2493invoke(PushAlertShowModel pushAlertShowModel) {
                if (pushAlertShowModel.getShow()) {
                    LifecycleOwner.this.getLifecycle().addObserver(this);
                    ((LinearLayout) this.e(R$id.open_push_parent_layout)).setVisibility(0);
                    TextView goto_open_push_btn = (TextView) this.e(R$id.goto_open_push_btn);
                    s.h(goto_open_push_btn, "goto_open_push_btn");
                    final ChatDetailTipsLayout chatDetailTipsLayout = this;
                    y.d(goto_open_push_btn, new Function1<View, p>() { // from class: com.cupidapp.live.chat2.view.ChatDetailTipsLayout$configOpenPushTip$1$1
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
                            GroupOthersLog.p0(GroupOthersLog.f18702a, GroupOthersLog.TipsType.CHAT_OPEN_SPECIAL_ATTENTION_PUSH, null, 2, null);
                            CustomPushActivity.a aVar2 = CustomPushActivity.f17944s;
                            Context context2 = ChatDetailTipsLayout.this.getContext();
                            s.h(context2, "context");
                            aVar2.a(context2);
                        }
                    });
                    return;
                }
                ((LinearLayout) this.e(R$id.open_push_parent_layout)).setVisibility(8);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void i(@NotNull String otherUserId, @Nullable FeedModel feedModel, @Nullable Boolean bool) {
        String string;
        s.i(otherUserId, "otherUserId");
        if (ChatDetailTitleLayout.f13442d.a(otherUserId)) {
            return;
        }
        if (feedModel != null && bool != null) {
            ((ConstraintLayout) e(R$id.private_message_parent_layout)).setVisibility(0);
            ImageLoaderView detail_post_referer_image = (ImageLoaderView) e(R$id.detail_post_referer_image);
            s.h(detail_post_referer_image, "detail_post_referer_image");
            ImageLoaderView.g(detail_post_referer_image, feedModel.getImageListFirst(), null, null, 6, null);
            TextView textView = (TextView) e(R$id.private_message_tip_text);
            if (bool.booleanValue()) {
                string = getContext().getString(R$string.message_visible_only_both_parties);
            } else {
                string = getContext().getString(R$string.private_message_count_limit);
            }
            textView.setText(string);
            return;
        }
        ((ConstraintLayout) e(R$id.private_message_parent_layout)).setVisibility(8);
    }

    public final void j() {
        int i10 = R$id.greet_by_send_emoji_parent_layout;
        if (((ConstraintLayout) e(i10)).getVisibility() != 8) {
            ((ConstraintLayout) e(i10)).setVisibility(8);
        }
    }

    public final void k() {
        z.a(this, R$layout.layout_chat_detail_tips, true);
    }

    public final void l(@NotNull final String userId, @NotNull final SensorPosition position) {
        s.i(userId, "userId");
        s.i(position, "position");
        ((ConstraintLayout) e(R$id.greet_by_send_emoji_parent_layout)).setVisibility(0);
        ((FaceLayout) e(R$id.greet_by_send_emoji_face_layout)).setItemClickListener(new Function1<CustomEmojiCode, p>() { // from class: com.cupidapp.live.chat2.view.ChatDetailTipsLayout$showGreetBySendEmojiTip$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(CustomEmojiCode customEmojiCode) {
                invoke2(customEmojiCode);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull CustomEmojiCode emoji) {
                g gVar;
                s.i(emoji, "emoji");
                gVar = ChatDetailTipsLayout.this.f13440d;
                if (gVar != null) {
                    gVar.a(emoji.getEmojiCNCode());
                }
                GroupSocialLog.f18708a.T(userId, position, emoji.getEmojiEnCode());
            }
        });
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.c.a(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.c.b(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.c.c(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onResume(@NotNull LifecycleOwner owner) {
        s.i(owner, "owner");
        r0.a aVar = r0.f12373a;
        Context context = getContext();
        s.h(context, "context");
        if (aVar.a(context)) {
            ((LinearLayout) e(R$id.open_push_parent_layout)).setVisibility(8);
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.c.e(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.c.f(this, lifecycleOwner);
    }

    public final void setListener(@NotNull g listener) {
        s.i(listener, "listener");
        this.f13440d = listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatDetailTipsLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f13441e = new LinkedHashMap();
        k();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatDetailTipsLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f13441e = new LinkedHashMap();
        k();
    }
}
