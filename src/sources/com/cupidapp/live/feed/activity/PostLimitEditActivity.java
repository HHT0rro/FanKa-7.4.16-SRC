package com.cupidapp.live.feed.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.constraintlayout.widget.Guideline;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.extension.ImageAttributeModel;
import com.cupidapp.live.base.imageloader.BlurModel;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.livedata.EventObserver;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.base.permission.FKRxPermissionAlertDialog;
import com.cupidapp.live.base.sensorslog.FKSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorsLogFeed;
import com.cupidapp.live.base.utils.p0;
import com.cupidapp.live.base.view.RoundedFrameLayout;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import com.cupidapp.live.base.view.dialog.BgColor;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.base.view.dialog.FKPointerDialog;
import com.cupidapp.live.base.view.dialog.PointerPos;
import com.cupidapp.live.base.view.drag.FKBaseDragLayout;
import com.cupidapp.live.chat.fragment.ConfigChatStateFragment;
import com.cupidapp.live.chat.model.ChatStatusItemModel;
import com.cupidapp.live.chat2.helper.KeyboardStatePopupWindow;
import com.cupidapp.live.chat2.helper.i;
import com.cupidapp.live.feed.event.PostLimitUploadSucEvent;
import com.cupidapp.live.feed.helper.d;
import com.cupidapp.live.feed.layout.CreateTextUiModel;
import com.cupidapp.live.feed.layout.PostLimitCreateTextLayout;
import com.cupidapp.live.feed.layout.PostLimitDragChatStateLayout;
import com.cupidapp.live.feed.layout.PostLimitDragTextLayout;
import com.cupidapp.live.feed.layout.PostLimitFirstHintLayout;
import com.cupidapp.live.feed.layout.PostLimitRainbowView;
import com.cupidapp.live.feed.model.PostLimitPublishModel;
import com.cupidapp.live.feed.viewmodel.PostLimitEditViewModel;
import com.cupidapp.live.mediapicker.helper.FKFireBaseDetectorOptionsKt;
import com.cupidapp.live.mediapicker.model.CameraStartPosition;
import com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPickerFragment;
import com.cupidapp.live.mediapicker.newmediapicker.model.MediaType;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PostLimitEditActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class PostLimitEditActivity extends FKBaseActivity {

    @NotNull
    public static final a E = new a(null);

    @Nullable
    public ChatStatusItemModel A;

    @Nullable
    public FKPointerDialog B;

    @Nullable
    public FKPointerDialog C;

    /* renamed from: q */
    @NotNull
    public final Lazy f14108q;

    /* renamed from: r */
    @Nullable
    public KeyboardStatePopupWindow f14109r;

    /* renamed from: t */
    @Nullable
    public ActivityResultLauncher<Intent> f14111t;

    /* renamed from: v */
    @NotNull
    public final PostLimitBgColorType[] f14113v;

    /* renamed from: w */
    public int f14114w;

    /* renamed from: x */
    @NotNull
    public final List<PostLimitDragTextLayout> f14115x;

    /* renamed from: y */
    public boolean f14116y;

    /* renamed from: z */
    @Nullable
    public PostLimitDragChatStateLayout f14117z;

    @NotNull
    public Map<Integer, View> D = new LinkedHashMap();

    /* renamed from: s */
    @NotNull
    public final Lazy f14110s = kotlin.c.b(new Function0<xb.b>() { // from class: com.cupidapp.live.feed.activity.PostLimitEditActivity$mRxPermissions$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final xb.b invoke() {
            return new xb.b(PostLimitEditActivity.this);
        }
    });

    /* renamed from: u */
    @NotNull
    public final Lazy f14112u = kotlin.c.b(new Function0<FKSensorContext>() { // from class: com.cupidapp.live.feed.activity.PostLimitEditActivity$mSensorContext$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FKSensorContext invoke() {
            SensorPosition sensorPosition;
            Serializable serializableExtra = PostLimitEditActivity.this.getIntent().getSerializableExtra("DATA_SENSOR_CONTEXT");
            FKSensorContext fKSensorContext = serializableExtra instanceof FKSensorContext ? (FKSensorContext) serializableExtra : null;
            if (fKSensorContext == null || (sensorPosition = fKSensorContext.getPosition()) == null) {
                sensorPosition = SensorPosition.Unknown;
            }
            return new FKSensorContext(PostLimitEditActivity.this.Q0(), sensorPosition, fKSensorContext != null ? fKSensorContext.getSource() : null, fKSensorContext != null ? fKSensorContext.getScene() : null);
        }
    });

    /* compiled from: PostLimitEditActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void b(a aVar, Context context, FKSensorContext fKSensorContext, ChatStatusItemModel chatStatusItemModel, int i10, Object obj) {
            if ((i10 & 4) != 0) {
                chatStatusItemModel = null;
            }
            aVar.a(context, fKSensorContext, chatStatusItemModel);
        }

        public final void a(@Nullable Context context, @NotNull FKSensorContext sensorContext, @Nullable ChatStatusItemModel chatStatusItemModel) {
            kotlin.jvm.internal.s.i(sensorContext, "sensorContext");
            if (context == null) {
                return;
            }
            Intent intent = new Intent(context, (Class<?>) PostLimitEditActivity.class);
            intent.putExtra("DATA_SENSOR_CONTEXT", sensorContext);
            if (chatStatusItemModel != null) {
                z0.g.c(intent, chatStatusItemModel);
            }
            context.startActivity(intent);
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    /* compiled from: PostLimitEditActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b implements com.cupidapp.live.feed.layout.r {
        public b() {
        }

        @Override // com.cupidapp.live.feed.layout.r
        public void a(@NotNull CreateTextUiModel model) {
            kotlin.jvm.internal.s.i(model, "model");
            PostLimitEditActivity.this.L1(true);
            PostLimitEditActivity.this.O1(model);
        }
    }

    /* compiled from: PostLimitEditActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class c implements r1.a {

        /* renamed from: b */
        public final /* synthetic */ FKBaseDragLayout f14120b;

        /* renamed from: c */
        public final /* synthetic */ Function0<kotlin.p> f14121c;

        /* renamed from: d */
        public final /* synthetic */ Function0<kotlin.p> f14122d;

        public c(FKBaseDragLayout fKBaseDragLayout, Function0<kotlin.p> function0, Function0<kotlin.p> function02) {
            this.f14120b = fKBaseDragLayout;
            this.f14121c = function0;
            this.f14122d = function02;
        }

        @Override // r1.a
        public void a() {
            ((ImageView) PostLimitEditActivity.this.n1(R$id.limit_edit_delete_btn)).setVisibility(0);
        }

        @Override // r1.a
        public void b() {
            AnimatorSet animatorSet = new AnimatorSet();
            PostLimitEditActivity postLimitEditActivity = PostLimitEditActivity.this;
            int i10 = R$id.limit_edit_delete_btn;
            animatorSet.play(ObjectAnimator.ofFloat((ImageView) postLimitEditActivity.n1(i10), (Property<ImageView, Float>) View.SCALE_X, 1.0f, 1.3f)).with(ObjectAnimator.ofFloat((ImageView) PostLimitEditActivity.this.n1(i10), (Property<ImageView, Float>) View.SCALE_Y, 1.0f, 1.3f)).with(ObjectAnimator.ofFloat(this.f14120b, (Property<FKBaseDragLayout, Float>) View.SCALE_X, 1.0f, 0.3f)).with(ObjectAnimator.ofFloat(this.f14120b, (Property<FKBaseDragLayout, Float>) View.SCALE_Y, 1.0f, 0.3f));
            animatorSet.setDuration(200L);
            animatorSet.start();
        }

        @Override // r1.a
        public void c(boolean z10) {
            if (z10) {
                ((ImageView) PostLimitEditActivity.this.n1(R$id.limit_edit_delete_btn)).setVisibility(8);
            } else {
                this.f14121c.invoke();
            }
        }

        @Override // r1.a
        public void d() {
            this.f14122d.invoke();
        }

        @Override // r1.a
        public void e() {
            AnimatorSet animatorSet = new AnimatorSet();
            PostLimitEditActivity postLimitEditActivity = PostLimitEditActivity.this;
            int i10 = R$id.limit_edit_delete_btn;
            animatorSet.play(ObjectAnimator.ofFloat((ImageView) postLimitEditActivity.n1(i10), (Property<ImageView, Float>) View.SCALE_X, 1.3f, 1.0f)).with(ObjectAnimator.ofFloat((ImageView) PostLimitEditActivity.this.n1(i10), (Property<ImageView, Float>) View.SCALE_Y, 1.3f, 1.0f)).with(ObjectAnimator.ofFloat(this.f14120b, (Property<FKBaseDragLayout, Float>) View.SCALE_X, 0.3f, 1.0f)).with(ObjectAnimator.ofFloat(this.f14120b, (Property<FKBaseDragLayout, Float>) View.SCALE_Y, 0.3f, 1.0f));
            animatorSet.setDuration(200L);
            animatorSet.start();
        }
    }

    /* compiled from: PostLimitEditActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class d implements com.cupidapp.live.chat2.helper.i {
        public d() {
        }

        @Override // com.cupidapp.live.chat2.helper.i
        public void a() {
            ((PostLimitCreateTextLayout) PostLimitEditActivity.this.n1(R$id.limit_create_text_layout)).p();
        }

        @Override // com.cupidapp.live.chat2.helper.i
        public void b(int i10, int i11) {
            i.a.a(this, i10, i11);
        }

        @Override // com.cupidapp.live.chat2.helper.i
        public void c(int i10) {
            i.a.b(this, i10);
        }
    }

    /* compiled from: PostLimitEditActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class e implements ConfigChatStateFragment.a {
        public e() {
        }

        @Override // com.cupidapp.live.chat.fragment.ConfigChatStateFragment.a
        public void a(@NotNull ChatStatusItemModel model) {
            kotlin.jvm.internal.s.i(model, "model");
            PostLimitEditActivity.this.j2(model);
        }

        @Override // com.cupidapp.live.chat.fragment.ConfigChatStateFragment.a
        public void dismiss() {
            ConfigChatStateFragment.a.C0149a.a(this);
        }
    }

    public PostLimitEditActivity() {
        final Function0 function0 = null;
        this.f14108q = new ViewModelLazy(kotlin.jvm.internal.v.b(PostLimitEditViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.feed.activity.PostLimitEditActivity$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ComponentActivity.this.getViewModelStore();
                kotlin.jvm.internal.s.h(viewModelStore, "viewModelStore");
                return viewModelStore;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.cupidapp.live.feed.activity.PostLimitEditActivity$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = ComponentActivity.this.getDefaultViewModelProviderFactory();
                kotlin.jvm.internal.s.h(defaultViewModelProviderFactory, "defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        }, new Function0<CreationExtras>() { // from class: com.cupidapp.live.feed.activity.PostLimitEditActivity$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = Function0.this;
                if (function02 != null && (creationExtras = (CreationExtras) function02.invoke()) != null) {
                    return creationExtras;
                }
                CreationExtras defaultViewModelCreationExtras = this.getDefaultViewModelCreationExtras();
                kotlin.jvm.internal.s.h(defaultViewModelCreationExtras, "this.defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        });
        PostLimitBgColorType[] values = PostLimitBgColorType.values();
        this.f14113v = values;
        this.f14114w = new Random().nextInt(values.length);
        this.f14115x = new ArrayList();
    }

    public static final void Y1(PostLimitEditActivity this$0) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        ChatStatusItemModel chatStatusItemModel = this$0.A;
        if (chatStatusItemModel != null) {
            this$0.j2(chatStatusItemModel);
        }
    }

    public static final void c2(PostLimitEditActivity this$0, ActivityResult activityResult) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        if (activityResult.getResultCode() == -1) {
            Intent data = activityResult.getData();
            this$0.e2(data != null ? data.getStringExtra("POST_LIMIT_EDIT_IMAGE_PATH") : null);
        }
    }

    public static final void g2(PostLimitEditActivity this$0) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        p1.g.f52734a.t3(Boolean.FALSE);
        FKPointerDialog a10 = FKPointerDialog.f12718p.a(this$0);
        String string = this$0.getString(R$string.can_add_multi_text);
        kotlin.jvm.internal.s.h(string, "getString(R.string.can_add_multi_text)");
        this$0.C = a10.n(string).q(PointerPos.TOP_CENTER, BgColor.DEFAULT).m(true).j(Float.valueOf(0.0f));
        int c4 = z0.h.c(this$0, 13.0f) - z0.h.m(this$0);
        FKPointerDialog fKPointerDialog = this$0.C;
        if (fKPointerDialog != null) {
            FKPointerDialog.B(fKPointerDialog, (ImageView) this$0.n1(R$id.limit_edit_create_text_btn), 0, c4, 0, null, 26, null);
        }
    }

    public static final void i2(PostLimitEditActivity this$0) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        FKPointerDialog a10 = FKPointerDialog.f12718p.a(this$0);
        String string = this$0.getString(R$string.try_add_photo);
        kotlin.jvm.internal.s.h(string, "getString(R.string.try_add_photo)");
        this$0.B = a10.n(string).q(PointerPos.BOTTOM_LEFT, BgColor.DEFAULT).m(true).j(Float.valueOf(0.0f));
        ViewGroup.LayoutParams layoutParams = ((Guideline) this$0.n1(R$id.limit_edit_bottom_line)).getLayoutParams();
        ConstraintLayout.LayoutParams layoutParams2 = layoutParams instanceof ConstraintLayout.LayoutParams ? (ConstraintLayout.LayoutParams) layoutParams : null;
        int c4 = layoutParams2 != null ? layoutParams2.guideEnd : z0.h.c(this$0, 80.0f);
        int i10 = R$id.limit_edit_add_photo_btn;
        int height = c4 - ((TextView) this$0.n1(i10)).getHeight();
        FKPointerDialog fKPointerDialog = this$0.B;
        if (fKPointerDialog != null) {
            FKPointerDialog.E(fKPointerDialog, (TextView) this$0.n1(i10), 0, height, 0, null, 18, null);
        }
    }

    public static /* synthetic */ void l2(PostLimitEditActivity postLimitEditActivity, CreateTextUiModel createTextUiModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            createTextUiModel = null;
        }
        postLimitEditActivity.k2(createTextUiModel);
    }

    public final void K1() {
        ImageView limit_edit_back_btn = (ImageView) n1(R$id.limit_edit_back_btn);
        kotlin.jvm.internal.s.h(limit_edit_back_btn, "limit_edit_back_btn");
        z0.y.d(limit_edit_back_btn, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.feed.activity.PostLimitEditActivity$bindClickEvent$1
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
                PostLimitEditActivity.this.onBackPressed();
            }
        });
        ImageView limit_edit_color_bg_btn = (ImageView) n1(R$id.limit_edit_color_bg_btn);
        kotlin.jvm.internal.s.h(limit_edit_color_bg_btn, "limit_edit_color_bg_btn");
        z0.y.d(limit_edit_color_bg_btn, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.feed.activity.PostLimitEditActivity$bindClickEvent$2
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
                int i10;
                PostLimitBgColorType[] postLimitBgColorTypeArr;
                int i11;
                int i12;
                PostLimitEditActivity postLimitEditActivity = PostLimitEditActivity.this;
                i10 = postLimitEditActivity.f14114w;
                postLimitBgColorTypeArr = PostLimitEditActivity.this.f14113v;
                if (i10 == kotlin.collections.m.A(postLimitBgColorTypeArr)) {
                    i12 = 0;
                } else {
                    i11 = PostLimitEditActivity.this.f14114w;
                    i12 = i11 + 1;
                }
                postLimitEditActivity.f14114w = i12;
                PostLimitEditActivity.this.M1();
            }
        });
        ImageView limit_edit_create_text_btn = (ImageView) n1(R$id.limit_edit_create_text_btn);
        kotlin.jvm.internal.s.h(limit_edit_create_text_btn, "limit_edit_create_text_btn");
        z0.y.d(limit_edit_create_text_btn, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.feed.activity.PostLimitEditActivity$bindClickEvent$3
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
                PostLimitEditActivity.l2(PostLimitEditActivity.this, null, 1, null);
            }
        });
        RoundedFrameLayout limit_edit_rounded_view = (RoundedFrameLayout) n1(R$id.limit_edit_rounded_view);
        kotlin.jvm.internal.s.h(limit_edit_rounded_view, "limit_edit_rounded_view");
        z0.y.d(limit_edit_rounded_view, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.feed.activity.PostLimitEditActivity$bindClickEvent$4
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
                PostLimitEditActivity.l2(PostLimitEditActivity.this, null, 1, null);
            }
        });
        ImageView limit_edit_chat_state_btn = (ImageView) n1(R$id.limit_edit_chat_state_btn);
        kotlin.jvm.internal.s.h(limit_edit_chat_state_btn, "limit_edit_chat_state_btn");
        z0.y.d(limit_edit_chat_state_btn, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.feed.activity.PostLimitEditActivity$bindClickEvent$5
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
                PostLimitEditActivity.this.n2();
            }
        });
        TextView limit_edit_add_photo_btn = (TextView) n1(R$id.limit_edit_add_photo_btn);
        kotlin.jvm.internal.s.h(limit_edit_add_photo_btn, "limit_edit_add_photo_btn");
        z0.y.d(limit_edit_add_photo_btn, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.feed.activity.PostLimitEditActivity$bindClickEvent$6
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
                PostLimitEditActivity.this.U1();
                PostLimitEditActivity.this.a2();
            }
        });
        FKUniversalButton limit_edit_publish_btn = (FKUniversalButton) n1(R$id.limit_edit_publish_btn);
        kotlin.jvm.internal.s.h(limit_edit_publish_btn, "limit_edit_publish_btn");
        z0.y.d(limit_edit_publish_btn, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.feed.activity.PostLimitEditActivity$bindClickEvent$7
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
                PostLimitEditActivity.this.U1();
                PostLimitEditActivity.this.o2();
            }
        });
        ((PostLimitCreateTextLayout) n1(R$id.limit_create_text_layout)).setListener(new b());
    }

    public final void L1(boolean z10) {
        if (z10) {
            ((Group) n1(R$id.limit_edit_action_btn_group)).setVisibility(0);
            if (this.f14116y) {
                ((ImageView) n1(R$id.limit_edit_color_bg_btn)).setVisibility(8);
                return;
            }
            return;
        }
        ((Group) n1(R$id.limit_edit_action_btn_group)).setVisibility(8);
    }

    public final void M1() {
        PostLimitBgColorType postLimitBgColorType = this.f14113v[this.f14114w];
        if (postLimitBgColorType == PostLimitBgColorType.RAINBOW) {
            n1(R$id.limit_edit_color_bg_view).setVisibility(8);
            ((PostLimitRainbowView) n1(R$id.limit_edit_rain_bow_view)).setVisibility(0);
        } else {
            int i10 = R$id.limit_edit_color_bg_view;
            n1(i10).setVisibility(0);
            n1(i10).setBackgroundResource(postLimitBgColorType.getBgResId());
            ((PostLimitRainbowView) n1(R$id.limit_edit_rain_bow_view)).setVisibility(8);
        }
        ((ImageView) n1(R$id.limit_edit_color_bg_btn)).setImageResource(postLimitBgColorType.getBtnResId());
        int i11 = R$id.limit_edit_tip_text;
        if (((TextView) n1(i11)).getVisibility() == 0) {
            ((TextView) n1(i11)).setTextColor(ContextCompat.getColor(this, postLimitBgColorType.getTextColorResId()));
        }
    }

    public final void N1() {
        ((TextView) n1(R$id.limit_edit_tip_text)).setVisibility(((this.f14115x.isEmpty() ^ true) || this.f14116y) ? 8 : 0);
    }

    public final void O1(final CreateTextUiModel createTextUiModel) {
        if ((createTextUiModel.getText().length() == 0) && createTextUiModel.getTextLayout() != null) {
            PostLimitDragTextLayout textLayout = createTextUiModel.getTextLayout();
            if (textLayout != null) {
                this.f14115x.remove(textLayout);
            }
            ((RoundedFrameLayout) n1(R$id.limit_edit_rounded_view)).removeView(createTextUiModel.getTextLayout());
            N1();
            return;
        }
        if (createTextUiModel.getText().length() == 0) {
            N1();
            return;
        }
        final PostLimitDragTextLayout textLayout2 = createTextUiModel.getTextLayout();
        if (textLayout2 == null) {
            textLayout2 = new PostLimitDragTextLayout(this);
        }
        textLayout2.h(createTextUiModel);
        S1(textLayout2, new Function0<kotlin.p>() { // from class: com.cupidapp.live.feed.activity.PostLimitEditActivity$createText$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ kotlin.p invoke() {
                invoke2();
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                CreateTextUiModel.this.setTextLayout(textLayout2);
                this.k2(CreateTextUiModel.this);
            }
        }, new Function0<kotlin.p>() { // from class: com.cupidapp.live.feed.activity.PostLimitEditActivity$createText$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ kotlin.p invoke() {
                invoke2();
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                List list;
                list = PostLimitEditActivity.this.f14115x;
                list.remove(textLayout2);
                ((RoundedFrameLayout) PostLimitEditActivity.this.n1(R$id.limit_edit_rounded_view)).removeView(textLayout2);
                PostLimitEditActivity.this.N1();
            }
        });
        if (createTextUiModel.getTextLayout() == null) {
            this.f14115x.add(textLayout2);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            int a10 = PostLimitCreateTextLayout.f14532h.a();
            layoutParams.setMargins(a10, 0, a10, 0);
            ((RoundedFrameLayout) n1(R$id.limit_edit_rounded_view)).addView(textLayout2, layoutParams);
            f2();
        }
        N1();
    }

    public final xb.b P1() {
        return (xb.b) this.f14110s.getValue();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity
    @NotNull
    public SensorPosition Q0() {
        return SensorPosition.PostLimitEdit;
    }

    public final FKSensorContext Q1() {
        return (FKSensorContext) this.f14112u.getValue();
    }

    public final PostLimitEditViewModel R1() {
        return (PostLimitEditViewModel) this.f14108q.getValue();
    }

    public final void S1(FKBaseDragLayout fKBaseDragLayout, Function0<kotlin.p> function0, Function0<kotlin.p> function02) {
        ImageView imageView = (ImageView) n1(R$id.limit_edit_delete_btn);
        int i10 = R$id.limit_edit_rounded_view;
        int left = ((RoundedFrameLayout) n1(i10)).getLeft();
        int top = ((RoundedFrameLayout) n1(i10)).getTop();
        fKBaseDragLayout.setListener(new Rect(imageView.getLeft() + left, imageView.getTop() + top, imageView.getRight() + left, imageView.getBottom() + top), null, true, new c(fKBaseDragLayout, function0, function02));
    }

    public final void T1() {
        FKPointerDialog fKPointerDialog = this.C;
        if (fKPointerDialog != null) {
            fKPointerDialog.g(false);
        }
        this.C = null;
    }

    public final void U1() {
        FKPointerDialog fKPointerDialog = this.B;
        if (fKPointerDialog != null) {
            fKPointerDialog.g(false);
        }
        this.B = null;
    }

    public final void V1() {
        ConstraintLayout limit_edit_root_layout = (ConstraintLayout) n1(R$id.limit_edit_root_layout);
        kotlin.jvm.internal.s.h(limit_edit_root_layout, "limit_edit_root_layout");
        KeyboardStatePopupWindow keyboardStatePopupWindow = new KeyboardStatePopupWindow(this, this, limit_edit_root_layout);
        this.f14109r = keyboardStatePopupWindow;
        keyboardStatePopupWindow.c(new d());
    }

    public final void W1() {
        R1().getPublishResult().observe(this, new EventObserver(new Function1<StateResult<PostLimitPublishModel>, kotlin.p>() { // from class: com.cupidapp.live.feed.activity.PostLimitEditActivity$initObserve$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(StateResult<PostLimitPublishModel> stateResult) {
                invoke2(stateResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull StateResult<PostLimitPublishModel> result) {
                kotlin.jvm.internal.s.i(result, "result");
                if (result instanceof StateResult.b) {
                    com.cupidapp.live.base.view.dialog.h.d(com.cupidapp.live.base.view.dialog.h.f12743a, null, false, 3, null);
                    return;
                }
                if (result instanceof StateResult.c) {
                    PostLimitEditActivity.this.d2(result.getData(), null);
                    EventBus.c().o(new PostLimitUploadSucEvent());
                    com.cupidapp.live.base.view.dialog.h.f12743a.b();
                    com.cupidapp.live.base.view.h.f12779a.l(PostLimitEditActivity.this, R$string.post_limit_publish_success_tip);
                    PostLimitEditActivity.this.finish();
                    return;
                }
                if (result instanceof StateResult.a) {
                    PostLimitEditActivity.this.d2(result.getData(), result.getMessage());
                    com.cupidapp.live.base.view.dialog.h.f12743a.b();
                }
            }
        }));
    }

    public final void X1() {
        ((RoundedFrameLayout) n1(R$id.limit_edit_rounded_view)).setCornerRadius(z0.h.c(this, 8.0f));
        M1();
        Intent intent = getIntent();
        kotlin.jvm.internal.s.h(intent, "intent");
        this.A = (ChatStatusItemModel) z0.g.a(intent, ChatStatusItemModel.class);
        ((ConstraintLayout) n1(R$id.limit_edit_root_layout)).post(new Runnable() { // from class: com.cupidapp.live.feed.activity.b0
            @Override // java.lang.Runnable
            public final void run() {
                PostLimitEditActivity.Y1(PostLimitEditActivity.this);
            }
        });
    }

    public final boolean Z1() {
        return (this.f14115x.isEmpty() ^ true) || this.f14116y || this.f14117z != null;
    }

    public final void a2() {
        FKRxPermissionAlertDialog.f12016a.m(this, P1(), (r16 & 4) != 0 ? null : new Function0<kotlin.p>() { // from class: com.cupidapp.live.feed.activity.PostLimitEditActivity$openAlbum$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ kotlin.p invoke() {
                invoke2();
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ActivityResultLauncher<Intent> activityResultLauncher;
                FKSensorContext Q1;
                activityResultLauncher = PostLimitEditActivity.this.f14111t;
                if (activityResultLauncher != null) {
                    PostLimitEditActivity postLimitEditActivity = PostLimitEditActivity.this;
                    CameraStartPosition cameraStartPosition = CameraStartPosition.FeedPublish;
                    Q1 = postLimitEditActivity.Q1();
                    PostLimitEditAlbumActivity.f14126v.a(postLimitEditActivity, activityResultLauncher, new MediaPickerFragment.Config(MediaType.IMAGE, true, false, false, false, cameraStartPosition, Q1.getPosition(), null, 152, null));
                }
            }
        }, (r16 & 8) != 0 ? null : null, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? R$string.need_access_media_upload_better : 0);
    }

    public final void b2() {
        this.f14111t = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.cupidapp.live.feed.activity.a0
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                PostLimitEditActivity.c2(PostLimitEditActivity.this, (ActivityResult) obj);
            }
        });
    }

    public final void d2(PostLimitPublishModel postLimitPublishModel, String str) {
        SensorsLogFeed.f12208a.J(Q1().getSource(), this.f14116y, !this.f14115x.isEmpty(), this.f14117z != null, str, postLimitPublishModel != null ? postLimitPublishModel.getId() : null);
    }

    public final void e2(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        this.f14116y = true;
        ImageLoaderView limit_edit_blur_img = (ImageLoaderView) n1(R$id.limit_edit_blur_img);
        kotlin.jvm.internal.s.h(limit_edit_blur_img, "limit_edit_blur_img");
        ImageLoaderView.f(limit_edit_blur_img, new com.cupidapp.live.base.imageloader.b(false, str, null, null, null, null, null, 0, 0, null, null, null, new BlurModel(0.0f, 12, 1, null), false, 0, 0, false, null, null, 520189, null), null, 2, null);
        ImageAttributeModel l10 = z0.f.l(this, str);
        int l11 = (z0.h.l(this) * l10.getHeight()) / l10.getWidth();
        int i10 = R$id.limit_edit_real_img;
        ImageLoaderView limit_edit_real_img = (ImageLoaderView) n1(i10);
        kotlin.jvm.internal.s.h(limit_edit_real_img, "limit_edit_real_img");
        z0.y.o(limit_edit_real_img, null, Integer.valueOf(l11), 1, null);
        ImageLoaderView limit_edit_real_img2 = (ImageLoaderView) n1(i10);
        kotlin.jvm.internal.s.h(limit_edit_real_img2, "limit_edit_real_img");
        ImageLoaderView.f(limit_edit_real_img2, new com.cupidapp.live.base.imageloader.b(false, str, null, null, null, null, null, 0, 0, null, null, null, null, false, 0, 0, false, null, null, 524285, null), null, 2, null);
        ((ImageView) n1(R$id.limit_edit_color_bg_btn)).setVisibility(8);
        n1(R$id.limit_edit_color_bg_view).setVisibility(8);
        ((PostLimitRainbowView) n1(R$id.limit_edit_rain_bow_view)).setVisibility(8);
        N1();
    }

    public final void f2() {
        if (kotlin.jvm.internal.s.d(p1.g.f52734a.h1(), Boolean.FALSE) || this.f14115x.size() != 1) {
            return;
        }
        ((ImageView) n1(R$id.limit_edit_create_text_btn)).post(new Runnable() { // from class: com.cupidapp.live.feed.activity.d0
            @Override // java.lang.Runnable
            public final void run() {
                PostLimitEditActivity.g2(PostLimitEditActivity.this);
            }
        });
    }

    public final void h2() {
        if (!this.f14115x.isEmpty()) {
            return;
        }
        ((TextView) n1(R$id.limit_edit_add_photo_btn)).post(new Runnable() { // from class: com.cupidapp.live.feed.activity.c0
            @Override // java.lang.Runnable
            public final void run() {
                PostLimitEditActivity.i2(PostLimitEditActivity.this);
            }
        });
    }

    public final void j2(ChatStatusItemModel chatStatusItemModel) {
        if (this.f14117z == null) {
            this.f14117z = new PostLimitDragChatStateLayout(this);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.bottomMargin = z0.h.c(this, 68.0f);
            ((RoundedFrameLayout) n1(R$id.limit_edit_rounded_view)).addView(this.f14117z, layoutParams);
        }
        final PostLimitDragChatStateLayout postLimitDragChatStateLayout = this.f14117z;
        if (postLimitDragChatStateLayout == null) {
            return;
        }
        this.A = chatStatusItemModel;
        postLimitDragChatStateLayout.h(chatStatusItemModel);
        S1(postLimitDragChatStateLayout, new Function0<kotlin.p>() { // from class: com.cupidapp.live.feed.activity.PostLimitEditActivity$showChatState$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ kotlin.p invoke() {
                invoke2();
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                PostLimitEditActivity.this.n2();
            }
        }, new Function0<kotlin.p>() { // from class: com.cupidapp.live.feed.activity.PostLimitEditActivity$showChatState$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ kotlin.p invoke() {
                invoke2();
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ((RoundedFrameLayout) PostLimitEditActivity.this.n1(R$id.limit_edit_rounded_view)).removeView(postLimitDragChatStateLayout);
                PostLimitEditActivity.this.f14117z = null;
                PostLimitEditActivity.this.A = null;
                PostLimitEditActivity.this.N1();
            }
        });
        N1();
    }

    public final void k2(CreateTextUiModel createTextUiModel) {
        if (createTextUiModel == null && this.f14115x.size() >= 10) {
            String string = getString(R$string.post_limit_can_create_max_text, new Object[]{10});
            kotlin.jvm.internal.s.h(string, "getString(R.string.post_…max_text, MAX_TEXT_COUNT)");
            com.cupidapp.live.base.view.h.f12779a.m(this, string);
        } else {
            U1();
            T1();
            L1(false);
            ((PostLimitCreateTextLayout) n1(R$id.limit_create_text_layout)).t(createTextUiModel, this.f14113v[this.f14114w]);
        }
    }

    public final void m2() {
        PostLimitFirstHintLayout.f14548c.b(this, new Function0<kotlin.p>() { // from class: com.cupidapp.live.feed.activity.PostLimitEditActivity$showPostLimitFirstHintGuide$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ kotlin.p invoke() {
                invoke2();
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                PostLimitEditActivity.this.h2();
            }
        });
    }

    @Nullable
    public View n1(int i10) {
        Map<Integer, View> map = this.D;
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

    public final void n2() {
        ConfigChatStateFragment.f13140j.a(getSupportFragmentManager(), Q1().getPosition(), new e());
    }

    public final void o2() {
        if (!Z1()) {
            com.cupidapp.live.base.view.h.f12779a.l(this, R$string.please_add_content_before_posting);
            return;
        }
        com.cupidapp.live.base.view.dialog.h.d(com.cupidapp.live.base.view.dialog.h.f12743a, null, false, 3, null);
        com.cupidapp.live.feed.helper.d dVar = com.cupidapp.live.feed.helper.d.f14312a;
        Window window = getWindow();
        kotlin.jvm.internal.s.h(window, "window");
        RoundedFrameLayout limit_edit_rounded_view = (RoundedFrameLayout) n1(R$id.limit_edit_rounded_view);
        kotlin.jvm.internal.s.h(limit_edit_rounded_view, "limit_edit_rounded_view");
        dVar.a(this, window, limit_edit_rounded_view, "post_limit", new d.a() { // from class: com.cupidapp.live.feed.activity.PostLimitEditActivity$startPublish$1
            @Override // com.cupidapp.live.feed.helper.d.a
            public void a() {
                com.cupidapp.live.base.view.dialog.h.f12743a.b();
            }

            @Override // com.cupidapp.live.feed.helper.d.a
            public void b(@NotNull final File file) {
                kotlin.jvm.internal.s.i(file, "file");
                PostLimitEditActivity postLimitEditActivity = PostLimitEditActivity.this;
                String path = file.getPath();
                kotlin.jvm.internal.s.h(path, "file.path");
                final PostLimitEditActivity postLimitEditActivity2 = PostLimitEditActivity.this;
                FKFireBaseDetectorOptionsKt.h(postLimitEditActivity, path, new Function1<Boolean, kotlin.p>() { // from class: com.cupidapp.live.feed.activity.PostLimitEditActivity$startPublish$1$convertSuccess$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return kotlin.p.f51048a;
                    }

                    public final void invoke(boolean z10) {
                        List list;
                        PostLimitEditViewModel R1;
                        ChatStatusItemModel chatStatusItemModel;
                        ArrayList arrayList = new ArrayList();
                        list = PostLimitEditActivity.this.f14115x;
                        Iterator<E> iterator2 = list.iterator2();
                        while (iterator2.hasNext()) {
                            arrayList.add(((PostLimitDragTextLayout) iterator2.next()).getTextContent());
                        }
                        R1 = PostLimitEditActivity.this.R1();
                        File file2 = file;
                        chatStatusItemModel = PostLimitEditActivity.this.A;
                        R1.postLimitImgUpload(file2, z10, arrayList, chatStatusItemModel != null ? Integer.valueOf(chatStatusItemModel.getStatusVal()) : null);
                    }
                });
            }
        });
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (Z1()) {
            FKAlertDialog.G(FKAlertDialog.r(FKAlertDialog.w(FKAlertDialog.o(FKAlertDialog.a.c(FKAlertDialog.f12698l, this, false, 2, null).D(R$string.post_limit_edit_give_up_editing_title), R$string.post_limit_edit_give_up_editing_desc, 0, 2, null).j(false), 0, null, new Function0<kotlin.p>() { // from class: com.cupidapp.live.feed.activity.PostLimitEditActivity$onBackPressed$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ kotlin.p invoke() {
                    invoke2();
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    PostLimitEditActivity.this.finish();
                }
            }, 3, null), 0, null, 3, null), null, 1, null);
        } else {
            finish();
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_post_limit_edit);
        p0.c(this, true, 0, 2, null);
        m2();
        b2();
        X1();
        W1();
        K1();
        V1();
        j1.c.b(j1.c.f50228a, Q1().getPosition(), null, Q1().getSource().getValue(), 2, null);
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        U1();
        T1();
    }
}
