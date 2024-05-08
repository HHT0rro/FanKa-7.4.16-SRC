package com.cupidapp.live.superlike.view;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.R$style;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.network.model.SwipeCardUserLikeResult;
import com.cupidapp.live.base.sensorslog.PopupButtonName;
import com.cupidapp.live.base.sensorslog.PopupName;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.base.view.animation.FKLottieAnimationView;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import com.cupidapp.live.base.view.dialog.FKLoadingLayout;
import com.cupidapp.live.chat2.model.ChatMessageResult;
import com.cupidapp.live.superboost.model.UnLimitRemainsUIModel;
import com.cupidapp.live.superlike.model.FollowType;
import com.cupidapp.live.superlike.model.SuperLikeNumModel;
import com.cupidapp.live.vip.PurchaseDialogManager;
import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x2.a;
import z0.y;
import z0.z;

/* compiled from: SuperLikeDialogLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SuperLikeDialogLayout extends BaseLayout {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public static final Companion f18632h = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public AlertDialog f18633d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public Pair<Boolean, SwipeCardUserLikeResult> f18634e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public Disposable f18635f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18636g;

    /* compiled from: SuperLikeDialogLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a(@NotNull final Context context, @NotNull final Lifecycle lifecycle, @NotNull final VipPurchaseEntranceType entranceType, @NotNull final Function1<? super Integer, p> hasNumberCallBack) {
            s.i(context, "context");
            s.i(lifecycle, "lifecycle");
            s.i(entranceType, "entranceType");
            s.i(hasNumberCallBack, "hasNumberCallBack");
            Observable<Result<SuperLikeNumModel>> U = NetworkClient.f11868a.N().U();
            com.cupidapp.live.base.network.g gVar = context instanceof com.cupidapp.live.base.network.g ? (com.cupidapp.live.base.network.g) context : null;
            Disposable disposed = U.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<SuperLikeNumModel, p>() { // from class: com.cupidapp.live.superlike.view.SuperLikeDialogLayout$Companion$checkSuperLikeRemains$$inlined$handleByContext$default$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(SuperLikeNumModel superLikeNumModel) {
                    m2825invoke(superLikeNumModel);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2825invoke(SuperLikeNumModel superLikeNumModel) {
                    UnLimitRemainsUIModel a10 = UnLimitRemainsUIModel.Companion.a(context, Integer.valueOf(superLikeNumModel.getNums()));
                    if (a10.hasRemains()) {
                        hasNumberCallBack.invoke(Integer.valueOf(a10.getRemains()));
                    } else {
                        new PurchaseDialogManager(context, lifecycle).m(entranceType);
                    }
                }
            }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, gVar)));
            if (disposed != null) {
                s.h(disposed, "disposed");
                if (gVar != null) {
                    gVar.H(disposed);
                }
            }
            s.h(disposed, "disposed");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void b(@NotNull final Context context, @NotNull final Lifecycle lifecycle, @NotNull final String userId, @Nullable final String str, @Nullable final String str2, @NotNull final VipPurchaseEntranceType entranceType, @Nullable final String str3, @NotNull final SensorPosition position, final int i10, @NotNull final Function1<? super SwipeCardUserLikeResult, p> successCallback, @Nullable final Function1<? super SwipeCardUserLikeResult, p> function1) {
            s.i(context, "context");
            s.i(lifecycle, "lifecycle");
            s.i(userId, "userId");
            s.i(entranceType, "entranceType");
            s.i(position, "position");
            s.i(successCallback, "successCallback");
            Observable<Result<SuperLikeNumModel>> U = NetworkClient.f11868a.N().U();
            com.cupidapp.live.base.network.g gVar = context instanceof com.cupidapp.live.base.network.g ? (com.cupidapp.live.base.network.g) context : null;
            Disposable disposed = U.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<SuperLikeNumModel, p>() { // from class: com.cupidapp.live.superlike.view.SuperLikeDialogLayout$Companion$superLikeBtnClick$$inlined$handleByContext$default$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(SuperLikeNumModel superLikeNumModel) {
                    m2826invoke(superLikeNumModel);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2826invoke(SuperLikeNumModel superLikeNumModel) {
                    if (UnLimitRemainsUIModel.Companion.a(context, Integer.valueOf(superLikeNumModel.getNums())).hasRemains()) {
                        new SuperLikeDialogLayout(context).G(userId, str, str2, position, str3, i10, successCallback, function1);
                    } else {
                        new PurchaseDialogManager(context, lifecycle).m(entranceType);
                    }
                }
            }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, gVar)));
            if (disposed != null) {
                s.h(disposed, "disposed");
                if (gVar != null) {
                    gVar.H(disposed);
                }
            }
            s.h(disposed, "disposed");
        }
    }

    /* compiled from: TextView.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable editable) {
            SuperLikeDialogLayout superLikeDialogLayout = SuperLikeDialogLayout.this;
            CharSequence charSequence = editable;
            if (editable == null) {
                charSequence = "";
            }
            superLikeDialogLayout.C(charSequence.toString());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuperLikeDialogLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f18636g = new LinkedHashMap();
        D();
    }

    public static final void I(SensorPosition position, final SuperLikeDialogLayout this$0, DialogInterface dialogInterface) {
        s.i(position, "$position");
        s.i(this$0, "this$0");
        j1.i.g(j1.i.f50236a, PopupName.SEND_SUPER_LIKE, position, null, 4, null);
        AppApplication.f11612d.h().j().postDelayed(new Runnable() { // from class: com.cupidapp.live.superlike.view.e
            @Override // java.lang.Runnable
            public final void run() {
                SuperLikeDialogLayout.J(SuperLikeDialogLayout.this);
            }
        }, 100L);
    }

    public static final void J(SuperLikeDialogLayout this$0) {
        s.i(this$0, "this$0");
        Context context = this$0.getContext();
        s.h(context, "context");
        EditText super_like_dialog_edit_text = (EditText) this$0.k(R$id.super_like_dialog_edit_text);
        s.h(super_like_dialog_edit_text, "super_like_dialog_edit_text");
        z0.h.v(context, super_like_dialog_edit_text);
    }

    public static final boolean K(SensorPosition position, SuperLikeDialogLayout this$0, String userId, int i10, Function1 successCallback, TextView textView, int i11, KeyEvent keyEvent) {
        s.i(position, "$position");
        s.i(this$0, "this$0");
        s.i(userId, "$userId");
        s.i(successCallback, "$successCallback");
        if (i11 != 4) {
            return true;
        }
        j1.i.f50236a.a(PopupName.SEND_SUPER_LIKE, PopupButtonName.SuperLikeAndSendMessage, position);
        this$0.z(userId, i10, successCallback);
        return true;
    }

    public static final void L(SuperLikeDialogLayout this$0, int i10) {
        s.i(this$0, "this$0");
        this$0.B(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setSuperLikeBtnEnabled(boolean z10) {
        ((FKUniversalButton) k(R$id.super_like_dialog_send_message_btn)).setEnabled(z10);
        ((TextView) k(R$id.only_super_like_btn)).setEnabled(z10);
    }

    public static final boolean x(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    public static final void y(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void A(int i10) {
        ((ImageView) k(R$id.super_like_dialog_bg)).setImageResource(h.f18669a.a(i10));
    }

    public final void B(int i10) {
        String d10 = h.f18669a.d(i10);
        if (d10 != null) {
            int i11 = R$id.super_like_bg_lottie;
            FKLottieAnimationView fKLottieAnimationView = (FKLottieAnimationView) k(i11);
            if (fKLottieAnimationView != null) {
                fKLottieAnimationView.setLottieAnimation(d10);
            }
            FKLottieAnimationView fKLottieAnimationView2 = (FKLottieAnimationView) k(i11);
            if (fKLottieAnimationView2 != null) {
                fKLottieAnimationView2.L();
            }
            FKLottieAnimationView fKLottieAnimationView3 = (FKLottieAnimationView) k(i11);
            if (fKLottieAnimationView3 == null) {
                return;
            }
            fKLottieAnimationView3.setVisibility(0);
            return;
        }
        FKLottieAnimationView fKLottieAnimationView4 = (FKLottieAnimationView) k(R$id.super_like_bg_lottie);
        if (fKLottieAnimationView4 == null) {
            return;
        }
        fKLottieAnimationView4.setVisibility(8);
    }

    public final void C(String str) {
        TextView textView = (TextView) k(R$id.send_message_current_word_count_text);
        if (str.length() < 20) {
            textView.setTextColor(-3750202);
        } else {
            textView.setTextColor(-49088);
        }
        textView.setText(String.valueOf(str.length()));
    }

    public final void D() {
        z.a(this, R$layout.layout_super_like_dialog, true);
        ((TextView) k(R$id.send_message_total_word_count_text)).setText(getContext().getString(R$string.super_liked_success_max_word_count, 20));
        C("");
        int i10 = R$id.super_like_dialog_edit_text;
        ((EditText) k(i10)).setInputType(262144);
        ((EditText) k(i10)).setSingleLine(false);
        ((EditText) k(i10)).setMaxLines(5);
        ((EditText) k(i10)).setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(20)});
        EditText super_like_dialog_edit_text = (EditText) k(i10);
        s.h(super_like_dialog_edit_text, "super_like_dialog_edit_text");
        super_like_dialog_edit_text.addTextChangedListener(new a());
        FrameLayout super_like_root_layout = (FrameLayout) k(R$id.super_like_root_layout);
        s.h(super_like_root_layout, "super_like_root_layout");
        y.d(super_like_root_layout, new Function1<View, p>() { // from class: com.cupidapp.live.superlike.view.SuperLikeDialogLayout$initView$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
            }
        });
    }

    public final void E(String str, String str2, final Function0<p> function0) {
        if (str2.length() == 0) {
            return;
        }
        if (str.length() == 0) {
            return;
        }
        Observable<Result<ChatMessageResult>> x10 = NetworkClient.f11868a.h().x(str2, str, null, Long.valueOf(System.currentTimeMillis()), null, null);
        Object context = getContext();
        Function1<Throwable, Boolean> function1 = new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.superlike.view.SuperLikeDialogLayout$sendMessage$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                SuperLikeDialogLayout.this.setSuperLikeBtnEnabled(true);
                return Boolean.FALSE;
            }
        };
        com.cupidapp.live.base.network.g gVar = context instanceof com.cupidapp.live.base.network.g ? (com.cupidapp.live.base.network.g) context : null;
        Disposable disposed = x10.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ChatMessageResult, p>() { // from class: com.cupidapp.live.superlike.view.SuperLikeDialogLayout$sendMessage$$inlined$handleByContext$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ChatMessageResult chatMessageResult) {
                m2827invoke(chatMessageResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2827invoke(ChatMessageResult chatMessageResult) {
                Function0.this.invoke();
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(function1, gVar)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            if (gVar != null) {
                gVar.H(disposed);
            }
        }
        s.h(disposed, "disposed");
    }

    public final void F(String str, Function1<? super SwipeCardUserLikeResult, p> function1) {
        SwipeCardUserLikeResult second;
        Pair<Boolean, SwipeCardUserLikeResult> pair = this.f18634e;
        if (pair != null && pair.getFirst().booleanValue()) {
            com.cupidapp.live.base.view.h.f12779a.d(getContext(), str);
            Pair<Boolean, SwipeCardUserLikeResult> pair2 = this.f18634e;
            if (pair2 == null || (second = pair2.getSecond()) == null) {
                return;
            }
            function1.invoke(second);
        }
    }

    public final void G(final String str, String str2, String str3, final SensorPosition sensorPosition, String str4, final int i10, final Function1<? super SwipeCardUserLikeResult, p> function1, Function1<? super SwipeCardUserLikeResult, p> function12) {
        Window window;
        int i11 = R$id.super_like_dialog_title_text;
        ((SuperLikeTagView) k(i11)).setCustomTagBg(0);
        ((SuperLikeTagView) k(i11)).c(Integer.valueOf(i10));
        A(i10);
        M(str, str2, str3, str4, i10, function12);
        z0.b bVar = z0.b.f54812a;
        AlertDialog create = bVar.e(getContext()).setView(this).create();
        this.f18633d = create;
        if (create != null) {
            create.setCancelable(false);
        }
        AlertDialog alertDialog = this.f18633d;
        if (alertDialog != null) {
            alertDialog.setCanceledOnTouchOutside(false);
        }
        AlertDialog alertDialog2 = this.f18633d;
        if (alertDialog2 != null) {
            alertDialog2.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.cupidapp.live.superlike.view.a
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    SuperLikeDialogLayout.I(SensorPosition.this, this, dialogInterface);
                }
            });
        }
        z0.b.c(bVar, this.f18633d, false, 2, null);
        AlertDialog alertDialog3 = this.f18633d;
        if (alertDialog3 != null) {
            alertDialog3.show();
        }
        AlertDialog alertDialog4 = this.f18633d;
        if (alertDialog4 != null && (window = alertDialog4.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setWindowAnimations(R$style.dialog_translate_anim);
            window.setLayout(-1, -2);
        }
        setSuperLikeBtnEnabled(true);
        FKUniversalButton super_like_dialog_send_message_btn = (FKUniversalButton) k(R$id.super_like_dialog_send_message_btn);
        s.h(super_like_dialog_send_message_btn, "super_like_dialog_send_message_btn");
        y.d(super_like_dialog_send_message_btn, new Function1<View, p>() { // from class: com.cupidapp.live.superlike.view.SuperLikeDialogLayout$showSuperLikeDialog$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                SuperLikeDialogLayout.this.setSuperLikeBtnEnabled(false);
                j1.i.f50236a.a(PopupName.SEND_SUPER_LIKE, PopupButtonName.SuperLikeAndSendMessage, sensorPosition);
                SuperLikeDialogLayout.this.z(str, i10, function1);
            }
        });
        TextView only_super_like_btn = (TextView) k(R$id.only_super_like_btn);
        s.h(only_super_like_btn, "only_super_like_btn");
        y.d(only_super_like_btn, new Function1<View, p>() { // from class: com.cupidapp.live.superlike.view.SuperLikeDialogLayout$showSuperLikeDialog$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                SuperLikeDialogLayout.this.setSuperLikeBtnEnabled(false);
                j1.i.f50236a.a(PopupName.SEND_SUPER_LIKE, PopupButtonName.OnlySuperLike, sensorPosition);
                SuperLikeDialogLayout superLikeDialogLayout = SuperLikeDialogLayout.this;
                kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f51038a;
                String string = superLikeDialogLayout.getContext().getString(R$string.super_like_success);
                s.h(string, "context.getString(R.string.super_like_success)");
                String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(i10)}, 1));
                s.h(format, "format(format, *args)");
                superLikeDialogLayout.w(format, function1);
            }
        });
        ((EditText) k(R$id.super_like_dialog_edit_text)).setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.cupidapp.live.superlike.view.b
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i12, KeyEvent keyEvent) {
                boolean K;
                K = SuperLikeDialogLayout.K(SensorPosition.this, this, str, i10, function1, textView, i12, keyEvent);
                return K;
            }
        });
        postDelayed(new Runnable() { // from class: com.cupidapp.live.superlike.view.f
            @Override // java.lang.Runnable
            public final void run() {
                SuperLikeDialogLayout.L(SuperLikeDialogLayout.this, i10);
            }
        }, 300L);
    }

    public final void M(String str, String str2, String str3, String str4, int i10, final Function1<? super SwipeCardUserLikeResult, p> function1) {
        Observable o10 = a.C0836a.o(NetworkClient.f11868a.N(), str, str2, null, str3, FollowType.SuperLike.getValue(), str4, Integer.valueOf(i10), null, 132, null);
        Object context = getContext();
        Function1<Throwable, Boolean> function12 = new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.superlike.view.SuperLikeDialogLayout$superLike$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                SuperLikeDialogLayout superLikeDialogLayout = SuperLikeDialogLayout.this;
                Boolean bool = Boolean.FALSE;
                superLikeDialogLayout.f18634e = new Pair(bool, null);
                return bool;
            }
        };
        com.cupidapp.live.base.network.g gVar = context instanceof com.cupidapp.live.base.network.g ? (com.cupidapp.live.base.network.g) context : null;
        Disposable disposed = o10.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<SwipeCardUserLikeResult, p>() { // from class: com.cupidapp.live.superlike.view.SuperLikeDialogLayout$superLike$$inlined$handleByContext$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
                m2828invoke(swipeCardUserLikeResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2828invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
                SwipeCardUserLikeResult swipeCardUserLikeResult2 = swipeCardUserLikeResult;
                SuperLikeDialogLayout.this.f18634e = new Pair(Boolean.TRUE, swipeCardUserLikeResult2);
                Function1 function13 = function1;
                if (function13 != null) {
                    function13.invoke(swipeCardUserLikeResult2);
                }
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(function12, gVar)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            if (gVar != null) {
                gVar.H(disposed);
            }
        }
        s.h(disposed, "disposed");
    }

    @Nullable
    public View k(int i10) {
        Map<Integer, View> map = this.f18636g;
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

    public final void w(final String str, final Function1<? super SwipeCardUserLikeResult, p> function1) {
        if (this.f18634e != null) {
            F(str, function1);
            AlertDialog alertDialog = this.f18633d;
            if (alertDialog != null) {
                alertDialog.dismiss();
                return;
            }
            return;
        }
        int i10 = R$id.super_like_loading;
        ((FKLoadingLayout) k(i10)).setVisibility(0);
        ((FKLoadingLayout) k(i10)).f();
        Observable<Long> observeOn = Observable.interval(300L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread());
        final Function1<Long, Boolean> function12 = new Function1<Long, Boolean>() { // from class: com.cupidapp.live.superlike.view.SuperLikeDialogLayout$checkAndDismiss$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Long it) {
                Pair pair;
                s.i(it, "it");
                pair = SuperLikeDialogLayout.this.f18634e;
                return Boolean.valueOf(pair != null);
            }
        };
        Maybe<Long> firstElement = observeOn.filter(new Predicate() { // from class: com.cupidapp.live.superlike.view.d
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean x10;
                x10 = SuperLikeDialogLayout.x(Function1.this, obj);
                return x10;
            }
        }).firstElement();
        final Function1<Long, p> function13 = new Function1<Long, p>() { // from class: com.cupidapp.live.superlike.view.SuperLikeDialogLayout$checkAndDismiss$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Long l10) {
                invoke2(l10);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Long l10) {
                Disposable disposable;
                AlertDialog alertDialog2;
                SuperLikeDialogLayout superLikeDialogLayout = SuperLikeDialogLayout.this;
                int i11 = R$id.super_like_loading;
                ((FKLoadingLayout) superLikeDialogLayout.k(i11)).c();
                ((FKLoadingLayout) SuperLikeDialogLayout.this.k(i11)).setVisibility(4);
                disposable = SuperLikeDialogLayout.this.f18635f;
                if (disposable != null) {
                    disposable.dispose();
                }
                SuperLikeDialogLayout.this.F(str, function1);
                alertDialog2 = SuperLikeDialogLayout.this.f18633d;
                if (alertDialog2 != null) {
                    alertDialog2.dismiss();
                }
            }
        };
        this.f18635f = firstElement.subscribe(new Consumer() { // from class: com.cupidapp.live.superlike.view.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SuperLikeDialogLayout.y(Function1.this, obj);
            }
        });
    }

    public final void z(String str, final int i10, final Function1<? super SwipeCardUserLikeResult, p> function1) {
        int i11 = R$id.super_like_dialog_edit_text;
        String obj = StringsKt__StringsKt.P0(((EditText) k(i11)).getText().toString()).toString();
        if (obj.length() == 0) {
            setSuperLikeBtnEnabled(true);
            com.cupidapp.live.base.view.h.f12779a.r(getContext(), R$string.no_send_empty_msg);
        } else {
            Context context = getContext();
            s.h(context, "context");
            z0.h.p(context, (EditText) k(i11));
            E(str, obj, new Function0<p>() { // from class: com.cupidapp.live.superlike.view.SuperLikeDialogLayout$checkAndSendMsg$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
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
                    SuperLikeDialogLayout superLikeDialogLayout = SuperLikeDialogLayout.this;
                    kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f51038a;
                    String string = superLikeDialogLayout.getContext().getString(R$string.private_message_and_super_like_suc);
                    s.h(string, "context.getString(R.stri…ssage_and_super_like_suc)");
                    String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(i10)}, 1));
                    s.h(format, "format(format, *args)");
                    superLikeDialogLayout.w(format, function1);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuperLikeDialogLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f18636g = new LinkedHashMap();
        D();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuperLikeDialogLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f18636g = new LinkedHashMap();
        D();
    }
}
