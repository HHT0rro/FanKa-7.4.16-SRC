package com.cupidapp.live.chat2.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.cupidapp.live.R$anim;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.grpc.CuConnectorOuterClass;
import com.cupidapp.live.base.grpc.GrpcMessageRouter;
import com.cupidapp.live.base.grpc.IGrpcMessageListener;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.download.SnapFileDownloader;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.utils.o;
import com.cupidapp.live.base.utils.p0;
import com.cupidapp.live.base.view.h;
import com.cupidapp.live.chat2.model.ChatLookSnapImgInsertScreenShotNoticeEvent;
import com.cupidapp.live.chat2.model.ChatMessageModel;
import com.cupidapp.live.chat2.model.ChatMessageResult;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.push.FKPushModel;
import com.cupidapp.live.push.FKPushType;
import com.cupidapp.live.push.util.PushExtraData;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import j1.k;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;

/* compiled from: ChatLookSnapImageActivity.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatLookSnapImageActivity extends FKBaseActivity implements IGrpcMessageListener {

    /* renamed from: x, reason: collision with root package name */
    @NotNull
    public static final a f13280x = new a(null);

    /* renamed from: y, reason: collision with root package name */
    @Nullable
    public static ChatMessageModel f13281y;

    /* renamed from: r, reason: collision with root package name */
    public boolean f13283r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f13284s;

    /* renamed from: t, reason: collision with root package name */
    public ChatMessageModel f13285t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f13286u;

    /* renamed from: v, reason: collision with root package name */
    @Nullable
    public o f13287v;

    /* renamed from: w, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13288w = new LinkedHashMap();

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public final SnapFileDownloader f13282q = new SnapFileDownloader();

    /* compiled from: ChatLookSnapImageActivity.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a() {
            ChatLookSnapImageActivity.f13281y = null;
        }

        public final void b(@Nullable Context context, @NotNull ChatMessageModel model) {
            s.i(model, "model");
            if (context == null) {
                return;
            }
            ChatLookSnapImageActivity.f13281y = model;
            context.startActivity(new Intent(context, (Class<?>) ChatLookSnapImageActivity.class));
        }
    }

    /* compiled from: ChatLookSnapImageActivity.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b implements SnapFileDownloader.c {
        public b() {
        }

        @Override // com.cupidapp.live.base.network.download.SnapFileDownloader.c
        public void a(@NotNull String url) {
            s.i(url, "url");
            ChatLookSnapImageActivity.this.f13283r = true;
        }
    }

    /* compiled from: ChatLookSnapImageActivity.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class c implements o.c {
        public c() {
        }

        @Override // com.cupidapp.live.base.utils.o.c
        public void a(long j10) {
            o.c.a.a(this, j10);
        }

        @Override // com.cupidapp.live.base.utils.o.c
        public void b(@NotNull String imageUriString, boolean z10) {
            s.i(imageUriString, "imageUriString");
            k.f50238a.c(SensorPosition.SnapImage, "BURN_AFTER_READING", null, z10);
            ChatLookSnapImageActivity.this.F1();
        }
    }

    public static final boolean w1(ChatLookSnapImageActivity this$0, View view, MotionEvent motionEvent) {
        s.i(this$0, "this$0");
        view.performClick();
        if (motionEvent.getAction() == 1) {
            this$0.A1();
            if (!this$0.f13286u) {
                this$0.finish();
            }
            this$0.f13286u = false;
        }
        return false;
    }

    public static final boolean x1(ChatLookSnapImageActivity this$0, View view) {
        s.i(this$0, "this$0");
        this$0.f13286u = true;
        if (this$0.f13284s) {
            this$0.z1();
        } else {
            this$0.y1();
            this$0.B1();
        }
        return true;
    }

    public final void A1() {
        ((ImageLoaderView) l1(R$id.chat_look_snap_blur_thumb_img)).setVisibility(0);
        ((Group) l1(R$id.chat_look_snap_img_tip_group)).setVisibility(0);
        ((ImageLoaderView) l1(R$id.chat_look_snap_img)).setVisibility(8);
        ((ProgressBar) l1(R$id.chat_decrypt_snap_img_progress_bar)).setVisibility(8);
    }

    public final void B1() {
        ChatMessageModel chatMessageModel = this.f13285t;
        ChatMessageModel chatMessageModel2 = null;
        if (chatMessageModel == null) {
            s.A("mMessage");
            chatMessageModel = null;
        }
        String itemId = chatMessageModel.getItemId();
        ChatMessageModel chatMessageModel3 = this.f13285t;
        if (chatMessageModel3 == null) {
            s.A("mMessage");
            chatMessageModel3 = null;
        }
        if (chatMessageModel3.passwordIsNullOrEmpty()) {
            if (!(itemId == null || itemId.length() == 0)) {
                Disposable disposed = NetworkClient.f11868a.h().a(itemId).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<ChatMessageResult, p>() { // from class: com.cupidapp.live.chat2.activity.ChatLookSnapImageActivity$decryptImageMessage$$inlined$handle$default$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(ChatMessageResult chatMessageResult) {
                        m2490invoke(chatMessageResult);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m2490invoke(ChatMessageResult chatMessageResult) {
                        ChatMessageModel chatMessageModel4;
                        ChatMessageModel chatMessageModel5;
                        ChatMessageResult chatMessageResult2 = chatMessageResult;
                        List<ChatMessageModel> list = chatMessageResult2.getList();
                        if (list == null || list.isEmpty()) {
                            return;
                        }
                        ChatMessageModel chatMessageModel6 = chatMessageResult2.getList().get(0);
                        chatMessageModel4 = ChatLookSnapImageActivity.this.f13285t;
                        ChatMessageModel chatMessageModel7 = null;
                        if (chatMessageModel4 == null) {
                            s.A("mMessage");
                            chatMessageModel4 = null;
                        }
                        chatMessageModel4.setPassword(chatMessageModel6.getPassword());
                        chatMessageModel4.setCountdownLeftSeconds(chatMessageModel6.getCountdownLeftSeconds());
                        ChatLookSnapImageActivity chatLookSnapImageActivity = ChatLookSnapImageActivity.this;
                        chatMessageModel5 = chatLookSnapImageActivity.f13285t;
                        if (chatMessageModel5 == null) {
                            s.A("mMessage");
                        } else {
                            chatMessageModel7 = chatMessageModel5;
                        }
                        final ChatLookSnapImageActivity chatLookSnapImageActivity2 = ChatLookSnapImageActivity.this;
                        chatLookSnapImageActivity.D1(chatMessageModel7, new Function0<p>() { // from class: com.cupidapp.live.chat2.activity.ChatLookSnapImageActivity$decryptImageMessage$1$2
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
                                ChatMessageModel chatMessageModel8;
                                chatMessageModel8 = ChatLookSnapImageActivity.this.f13285t;
                                if (chatMessageModel8 == null) {
                                    s.A("mMessage");
                                    chatMessageModel8 = null;
                                }
                                chatMessageModel8.startSnapCountDown();
                            }
                        });
                    }
                }), new e(new ObservableExtensionKt$handle$disposed$2(null, this)));
                if (disposed != null) {
                    s.h(disposed, "disposed");
                    H(disposed);
                }
                s.h(disposed, "disposed");
                return;
            }
        }
        ChatMessageModel chatMessageModel4 = this.f13285t;
        if (chatMessageModel4 == null) {
            s.A("mMessage");
        } else {
            chatMessageModel2 = chatMessageModel4;
        }
        D1(chatMessageModel2, new Function0<p>() { // from class: com.cupidapp.live.chat2.activity.ChatLookSnapImageActivity$decryptImageMessage$2
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
                ChatMessageModel chatMessageModel5;
                chatMessageModel5 = ChatLookSnapImageActivity.this.f13285t;
                if (chatMessageModel5 == null) {
                    s.A("mMessage");
                    chatMessageModel5 = null;
                }
                chatMessageModel5.startSnapCountDown();
            }
        });
    }

    public final void C1() {
        ImageLoaderView chat_look_snap_blur_thumb_img = (ImageLoaderView) l1(R$id.chat_look_snap_blur_thumb_img);
        s.h(chat_look_snap_blur_thumb_img, "chat_look_snap_blur_thumb_img");
        ChatMessageModel chatMessageModel = this.f13285t;
        if (chatMessageModel == null) {
            s.A("mMessage");
            chatMessageModel = null;
        }
        ChatMessageModel chatMessageModel2 = null;
        ImageLoaderView.f(chat_look_snap_blur_thumb_img, new com.cupidapp.live.base.imageloader.b(false, chatMessageModel.getSnapImageThumbUrl(), null, null, null, null, null, 0, 0, null, null, null, null, false, 0, 0, false, null, null, 524285, null), null, 2, null);
        ChatMessageModel chatMessageModel3 = this.f13285t;
        if (chatMessageModel3 == null) {
            s.A("mMessage");
        } else {
            chatMessageModel2 = chatMessageModel3;
        }
        this.f13282q.f(chatMessageModel2.getSnapImageLargeUrl(), new b());
    }

    public final void D1(ChatMessageModel chatMessageModel, final Function0<p> function0) {
        final String snapImageLargeUrl = chatMessageModel.getSnapImageLargeUrl();
        String completePassword = chatMessageModel.getCompletePassword(this);
        if (snapImageLargeUrl == null || snapImageLargeUrl.length() == 0) {
            return;
        }
        if ((completePassword == null || completePassword.length() == 0) || !this.f13283r || this.f13284s) {
            return;
        }
        this.f13282q.g(snapImageLargeUrl, completePassword, new Function1<Bitmap, p>() { // from class: com.cupidapp.live.chat2.activity.ChatLookSnapImageActivity$loadDecryptedBitmap$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Bitmap bitmap) {
                invoke2(bitmap);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Bitmap bitmap) {
                SnapFileDownloader snapFileDownloader;
                boolean z10;
                if (bitmap != null) {
                    ChatLookSnapImageActivity.this.f13284s = true;
                    ImageLoaderView chat_look_snap_img = (ImageLoaderView) ChatLookSnapImageActivity.this.l1(R$id.chat_look_snap_img);
                    s.h(chat_look_snap_img, "chat_look_snap_img");
                    ImageLoaderView.f(chat_look_snap_img, new com.cupidapp.live.base.imageloader.b(false, null, null, null, null, null, bitmap, 0, 0, null, null, null, null, false, 0, 0, false, null, null, 524223, null), null, 2, null);
                    z10 = ChatLookSnapImageActivity.this.f13286u;
                    if (z10) {
                        ChatLookSnapImageActivity.this.z1();
                    }
                    Function0<p> function02 = function0;
                    if (function02 != null) {
                        function02.invoke();
                        return;
                    }
                    return;
                }
                h.f12779a.r(ChatLookSnapImageActivity.this, R$string.image_get_failed_try_later);
                snapFileDownloader = ChatLookSnapImageActivity.this.f13282q;
                snapFileDownloader.e(snapImageLargeUrl);
            }
        });
    }

    public final boolean E1(Integer num) {
        return num == null || num.intValue() <= 0;
    }

    public final void F1() {
        ChatMessageModel chatMessageModel = this.f13285t;
        if (chatMessageModel == null) {
            s.A("mMessage");
            chatMessageModel = null;
        }
        User sender = chatMessageModel.getSender();
        final String userId = sender != null ? sender.userId() : null;
        if (userId == null || userId.length() == 0) {
            return;
        }
        NetworkClient networkClient = NetworkClient.f11868a;
        Disposable disposed = networkClient.h().t(userId).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<ChatMessageResult, p>() { // from class: com.cupidapp.live.chat2.activity.ChatLookSnapImageActivity$sendScreenCaptureCallback$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ChatMessageResult chatMessageResult) {
                m2491invoke(chatMessageResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2491invoke(ChatMessageResult chatMessageResult) {
                ChatMessageModel chatMessageModel2;
                List<ChatMessageModel> list = chatMessageResult.getList();
                if (list == null || (chatMessageModel2 = (ChatMessageModel) CollectionsKt___CollectionsKt.V(list)) == null) {
                    return;
                }
                EventBus.c().o(new ChatLookSnapImgInsertScreenShotNoticeEvent(String.this, chatMessageModel2));
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
        ChatMessageModel chatMessageModel2 = this.f13285t;
        if (chatMessageModel2 == null) {
            s.A("mMessage");
            chatMessageModel2 = null;
        }
        String itemId = chatMessageModel2.getItemId();
        if (this.f13284s) {
            if (itemId == null || itemId.length() == 0) {
                return;
            }
            Disposable disposed2 = networkClient.h().i(userId, itemId, userId).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.chat2.activity.ChatLookSnapImageActivity$sendScreenCaptureCallback$$inlined$handle$default$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Object obj) {
                    invoke2(obj);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object obj) {
                }
            }), new e(new ObservableExtensionKt$handle$disposed$2(null, this)));
            if (disposed2 != null) {
                s.h(disposed2, "disposed");
                H(disposed2);
            }
            s.h(disposed2, "disposed");
        }
    }

    public final void G1() {
        o c4 = o.f12354i.c(this);
        this.f13287v = c4;
        if (c4 != null) {
            c4.l(new c());
        }
    }

    @Nullable
    public View l1(int i10) {
        Map<Integer, View> map = this.f13288w;
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

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_chat_look_snap_image);
        p0.a(this);
        d1(R$anim.anim_activity_nothing, null);
        ChatMessageModel chatMessageModel = f13281y;
        if (chatMessageModel != null && !E1(chatMessageModel.getCountdownLeftSeconds())) {
            this.f13285t = chatMessageModel;
            chatMessageModel.setMProgressCallback(new Function1<Float, p>() { // from class: com.cupidapp.live.chat2.activity.ChatLookSnapImageActivity$onCreate$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Float f10) {
                    invoke(f10.floatValue());
                    return p.f51048a;
                }

                public final void invoke(float f10) {
                    if (f10 == 0.0f) {
                        ChatLookSnapImageActivity.this.finish();
                        return;
                    }
                    ChatLookSnapImageActivity chatLookSnapImageActivity = ChatLookSnapImageActivity.this;
                    int i10 = R$id.chat_look_snap_img_count_down_view;
                    if (chatLookSnapImageActivity.l1(i10).getVisibility() != 0) {
                        ChatLookSnapImageActivity.this.l1(i10).setVisibility(0);
                    }
                    int l10 = (int) (f10 * z0.h.l(ChatLookSnapImageActivity.this));
                    if (l10 > 0) {
                        View chat_look_snap_img_count_down_view = ChatLookSnapImageActivity.this.l1(i10);
                        s.h(chat_look_snap_img_count_down_view, "chat_look_snap_img_count_down_view");
                        y.o(chat_look_snap_img_count_down_view, Integer.valueOf(l10), null, 2, null);
                    }
                }
            });
            C1();
            v1();
            G1();
            GrpcMessageRouter.INSTANCE.addIGrpcMessageListener(this);
            return;
        }
        finish();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        ChatMessageModel chatMessageModel = this.f13285t;
        if (chatMessageModel != null) {
            if (chatMessageModel == null) {
                s.A("mMessage");
                chatMessageModel = null;
            }
            chatMessageModel.setMProgressCallback(null);
        }
        GrpcMessageRouter.INSTANCE.removeIGrpcMessageListener(this);
        super.onDestroy();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        o oVar = this.f13287v;
        if (oVar != null) {
            oVar.n();
        }
    }

    @Override // com.cupidapp.live.base.grpc.IGrpcMessageListener
    public void onReceiveGrpcMessage(@NotNull CuConnectorOuterClass.MessageType type, @NotNull Object model) {
        s.i(type, "type");
        s.i(model, "model");
        if (type == CuConnectorOuterClass.MessageType.PushMessage && (model instanceof FKPushModel)) {
            FKPushModel fKPushModel = (FKPushModel) model;
            PushExtraData a10 = PushExtraData.Companion.a(fKPushModel.getPushMessageModel().getData());
            ChatMessageModel chatMessageModel = null;
            String sessionId = a10 != null ? a10.getSessionId() : null;
            if (sessionId == null || sessionId.length() == 0) {
                return;
            }
            String sessionId2 = a10 != null ? a10.getSessionId() : null;
            ChatMessageModel chatMessageModel2 = this.f13285t;
            if (chatMessageModel2 == null) {
                s.A("mMessage");
                chatMessageModel2 = null;
            }
            User sender = chatMessageModel2.getSender();
            if (s.d(sessionId2, sender != null ? sender.userId() : null)) {
                String messageId = a10 != null ? a10.getMessageId() : null;
                if (messageId == null || messageId.length() == 0) {
                    return;
                }
                String messageId2 = a10 != null ? a10.getMessageId() : null;
                ChatMessageModel chatMessageModel3 = this.f13285t;
                if (chatMessageModel3 == null) {
                    s.A("mMessage");
                } else {
                    chatMessageModel = chatMessageModel3;
                }
                if (s.d(messageId2, chatMessageModel.getItemId()) && fKPushModel.getPushMessageModel().getPushType() == FKPushType.MessageDestory) {
                    h.f12779a.l(this, R$string.destroyed_the_time_limited_picture);
                    finish();
                }
            }
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        o oVar = this.f13287v;
        if (oVar != null) {
            oVar.m();
        }
    }

    public final void v1() {
        int i10 = R$id.chat_look_snap_img_root_layout;
        ((ConstraintLayout) l1(i10)).setOnTouchListener(new View.OnTouchListener() { // from class: com.cupidapp.live.chat2.activity.b
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean w12;
                w12 = ChatLookSnapImageActivity.w1(ChatLookSnapImageActivity.this, view, motionEvent);
                return w12;
            }
        });
        ((ConstraintLayout) l1(i10)).setOnLongClickListener(new View.OnLongClickListener() { // from class: com.cupidapp.live.chat2.activity.a
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean x12;
                x12 = ChatLookSnapImageActivity.x1(ChatLookSnapImageActivity.this, view);
                return x12;
            }
        });
    }

    public final void y1() {
        ((ImageLoaderView) l1(R$id.chat_look_snap_blur_thumb_img)).setVisibility(0);
        ((ProgressBar) l1(R$id.chat_decrypt_snap_img_progress_bar)).setVisibility(0);
        ((ImageLoaderView) l1(R$id.chat_look_snap_img)).setVisibility(8);
        ((Group) l1(R$id.chat_look_snap_img_tip_group)).setVisibility(8);
    }

    public final void z1() {
        ((ImageLoaderView) l1(R$id.chat_look_snap_img)).setVisibility(0);
        ((ImageLoaderView) l1(R$id.chat_look_snap_blur_thumb_img)).setVisibility(8);
        ((Group) l1(R$id.chat_look_snap_img_tip_group)).setVisibility(8);
        ((ProgressBar) l1(R$id.chat_decrypt_snap_img_progress_bar)).setVisibility(8);
    }
}
