package com.cupidapp.live.profile.view;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.R$style;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.sensorslog.PopupButtonName;
import com.cupidapp.live.base.sensorslog.PopupName;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import com.cupidapp.live.profile.view.FriendPraiseEditLayout;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import j1.i;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.y;
import z0.z;

/* compiled from: FriendPraiseEditLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FriendPraiseEditLayout extends BaseLayout {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public static final Companion f17854h = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public String f17855d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public SensorPosition f17856e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public Function0<p> f17857f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17858g;

    /* compiled from: FriendPraiseEditLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static final void d(SensorPosition position, final FriendPraiseEditLayout layout, final Context context, DialogInterface dialogInterface) {
            s.i(position, "$position");
            s.i(layout, "$layout");
            s.i(context, "$context");
            i.g(i.f50236a, PopupName.COMMIT_PRAISE, position, null, 4, null);
            layout.postDelayed(new Runnable() { // from class: com.cupidapp.live.profile.view.d
                @Override // java.lang.Runnable
                public final void run() {
                    FriendPraiseEditLayout.Companion.e(context, layout);
                }
            }, 60L);
        }

        public static final void e(Context context, FriendPraiseEditLayout layout) {
            s.i(context, "$context");
            s.i(layout, "$layout");
            View findViewById = layout.findViewById(R$id.praise_edit_text);
            s.h(findViewById, "layout.findViewById(R.id.praise_edit_text)");
            h.v(context, findViewById);
        }

        public final void c(@NotNull final Context context, @Nullable String str, @NotNull final SensorPosition position) {
            s.i(context, "context");
            s.i(position, "position");
            if (str == null || str.length() == 0) {
                return;
            }
            final FriendPraiseEditLayout friendPraiseEditLayout = new FriendPraiseEditLayout(context);
            final AlertDialog create = z0.b.f54812a.e(context).setView(friendPraiseEditLayout).create();
            friendPraiseEditLayout.k(str, position, new Function0<p>() { // from class: com.cupidapp.live.profile.view.FriendPraiseEditLayout$Companion$show$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    create.dismiss();
                }
            });
            create.setCanceledOnTouchOutside(false);
            create.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.cupidapp.live.profile.view.c
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    FriendPraiseEditLayout.Companion.d(SensorPosition.this, friendPraiseEditLayout, context, dialogInterface);
                }
            });
            create.show();
            Window window = create.getWindow();
            if (window != null) {
                window.setGravity(80);
                window.setBackgroundDrawable(new ColorDrawable(0));
                window.setWindowAnimations(R$style.dialog_translate_anim);
                window.setLayout(-1, -2);
            }
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
            FriendPraiseEditLayout friendPraiseEditLayout = FriendPraiseEditLayout.this;
            CharSequence charSequence = editable;
            if (editable == null) {
                charSequence = "";
            }
            friendPraiseEditLayout.l(charSequence.toString());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FriendPraiseEditLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f17858g = new LinkedHashMap();
        p();
    }

    public static final void o(FriendPraiseEditLayout this$0, CompoundButton compoundButton, boolean z10) {
        s.i(this$0, "this$0");
        ((TextView) this$0.f(R$id.praise_anonymous_submit_text)).setTextColor(z10 ? -16777216 : -5658199);
    }

    @Nullable
    public View f(int i10) {
        Map<Integer, View> map = this.f17858g;
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

    public final void j() {
        ImageView praise_edit_close_btn = (ImageView) f(R$id.praise_edit_close_btn);
        s.h(praise_edit_close_btn, "praise_edit_close_btn");
        y.d(praise_edit_close_btn, new Function1<View, p>() { // from class: com.cupidapp.live.profile.view.FriendPraiseEditLayout$bindClickEvent$1
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
                Function0 function0;
                function0 = FriendPraiseEditLayout.this.f17857f;
                if (function0 != null) {
                    function0.invoke();
                }
            }
        });
        FKUniversalButton praise_edit_submit_btn = (FKUniversalButton) f(R$id.praise_edit_submit_btn);
        s.h(praise_edit_submit_btn, "praise_edit_submit_btn");
        y.d(praise_edit_submit_btn, new Function1<View, p>() { // from class: com.cupidapp.live.profile.view.FriendPraiseEditLayout$bindClickEvent$2
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
                FriendPraiseEditLayout.this.q();
            }
        });
    }

    public final void k(@NotNull String toUserId, @NotNull SensorPosition position, @NotNull Function0<p> executeDismissCallback) {
        s.i(toUserId, "toUserId");
        s.i(position, "position");
        s.i(executeDismissCallback, "executeDismissCallback");
        this.f17855d = toUserId;
        this.f17856e = position;
        this.f17857f = executeDismissCallback;
    }

    public final void l(String str) {
        TextView textView = (TextView) f(R$id.praise_edit_current_word_count_text);
        if (str.length() < 50) {
            textView.setTextColor(com.cupidapp.live.base.utils.h.a(-15066598, 0.3f));
        } else {
            textView.setTextColor(-49088);
        }
        textView.setText(String.valueOf(str.length()));
    }

    public final void m() {
        ((TextView) f(R$id.praise_edit_total_word_count_text)).setText(getContext().getString(R$string.super_liked_success_max_word_count, 50));
        l("");
        int i10 = R$id.praise_edit_text;
        ((EditText) f(i10)).setInputType(262144);
        ((EditText) f(i10)).setSingleLine(false);
        ((EditText) f(i10)).setMaxLines(5);
        ((EditText) f(i10)).setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(50)});
        EditText praise_edit_text = (EditText) f(i10);
        s.h(praise_edit_text, "praise_edit_text");
        praise_edit_text.addTextChangedListener(new a());
        ((CheckBox) f(R$id.praise_anonymous_submit_checkbox)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.cupidapp.live.profile.view.b
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                FriendPraiseEditLayout.o(FriendPraiseEditLayout.this, compoundButton, z10);
            }
        });
    }

    public final void p() {
        z.a(this, R$layout.friend_praise_edit, true);
        m();
        j();
    }

    public final void q() {
        String str = this.f17855d;
        String obj = StringsKt__StringsKt.P0(((EditText) f(R$id.praise_edit_text)).getText().toString()).toString();
        if (str == null || str.length() == 0) {
            return;
        }
        if (obj.length() == 0) {
            com.cupidapp.live.base.view.h.f12779a.k(R$string.input_content);
            return;
        }
        ((FKUniversalButton) f(R$id.praise_edit_submit_btn)).setEnabled(false);
        boolean isChecked = ((CheckBox) f(R$id.praise_anonymous_submit_checkbox)).isChecked();
        i.f50236a.a(PopupName.COMMIT_PRAISE, isChecked ? PopupButtonName.ANONYMOUS_SUBMIT : PopupButtonName.SUBMIT, this.f17856e);
        Disposable disposed = NetworkClient.f11868a.N().I(str, obj, isChecked).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.profile.view.FriendPraiseEditLayout$submitFriendPraise$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj2) {
                invoke2(obj2);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj2) {
                Function0 function0;
                com.cupidapp.live.base.view.h.f12779a.c(FriendPraiseEditLayout.this.getContext(), R$string.submit_friend_praise_success);
                function0 = FriendPraiseEditLayout.this.f17857f;
                if (function0 != null) {
                    function0.invoke();
                }
                ((FKUniversalButton) FriendPraiseEditLayout.this.f(R$id.praise_edit_submit_btn)).setEnabled(true);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.profile.view.FriendPraiseEditLayout$submitFriendPraise$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                ((FKUniversalButton) FriendPraiseEditLayout.this.f(R$id.praise_edit_submit_btn)).setEnabled(true);
                return Boolean.FALSE;
            }
        }, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FriendPraiseEditLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f17858g = new LinkedHashMap();
        p();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FriendPraiseEditLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f17858g = new LinkedHashMap();
        p();
    }
}
