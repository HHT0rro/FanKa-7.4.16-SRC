package com.cupidapp.live.consult.view;

import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.fragment.EditInputBottomSheetDialog;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.consult.model.ConsultCommentResult;
import com.cupidapp.live.consult.view.ConsultCommentEditTextLayout;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
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
import z0.z;

/* compiled from: ConsultCommentEditTextLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConsultCommentEditTextLayout extends BaseLayout {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public static final Companion f13845h = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public Function0<p> f13846d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public String f13847e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f13848f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13849g;

    /* compiled from: ConsultCommentEditTextLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static final void c(Context context, ConsultCommentEditTextLayout layout, DialogInterface dialogInterface) {
            s.i(context, "$context");
            s.i(layout, "$layout");
            EditText editText = (EditText) layout.f(R$id.consult_comment_edit_text);
            s.h(editText, "layout.consult_comment_edit_text");
            h.v(context, editText);
        }

        public final void b(@NotNull final Context context, @Nullable String str) {
            s.i(context, "context");
            final EditInputBottomSheetDialog editInputBottomSheetDialog = new EditInputBottomSheetDialog(context, true);
            final ConsultCommentEditTextLayout consultCommentEditTextLayout = new ConsultCommentEditTextLayout(context);
            consultCommentEditTextLayout.m(str);
            consultCommentEditTextLayout.setDismissCallback(new Function0<p>() { // from class: com.cupidapp.live.consult.view.ConsultCommentEditTextLayout$Companion$show$1
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
                    EditInputBottomSheetDialog.this.dismiss();
                }
            });
            editInputBottomSheetDialog.setContentView(consultCommentEditTextLayout);
            editInputBottomSheetDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.cupidapp.live.consult.view.c
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    ConsultCommentEditTextLayout.Companion.c(context, consultCommentEditTextLayout, dialogInterface);
                }
            });
            editInputBottomSheetDialog.show();
        }
    }

    /* compiled from: TextView.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence charSequence, int i10, int i11, int i12) {
            if (charSequence != null && StringsKt__StringsKt.K(charSequence, "\n", false, 2, null)) {
                charSequence = kotlin.text.p.A(charSequence.toString(), "\n", " ", false, 4, null);
                ConsultCommentEditTextLayout consultCommentEditTextLayout = ConsultCommentEditTextLayout.this;
                int i13 = R$id.consult_comment_edit_text;
                ((EditText) consultCommentEditTextLayout.f(i13)).setText(charSequence);
                try {
                    ((EditText) ConsultCommentEditTextLayout.this.f(i13)).setSelection(Math.min(i10 + i12, 40));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (charSequence != null && charSequence.length() > 40) {
                ConsultCommentEditTextLayout consultCommentEditTextLayout2 = ConsultCommentEditTextLayout.this;
                int i14 = R$id.consult_comment_edit_text;
                ((EditText) consultCommentEditTextLayout2.f(i14)).setText(charSequence.subSequence(0, 40).toString());
                try {
                    ((EditText) ConsultCommentEditTextLayout.this.f(i14)).setSelection(Math.min(i10 + i12, 40));
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
            ConsultCommentEditTextLayout consultCommentEditTextLayout3 = ConsultCommentEditTextLayout.this;
            consultCommentEditTextLayout3.o(((EditText) consultCommentEditTextLayout3.f(R$id.consult_comment_edit_text)).getText().toString());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsultCommentEditTextLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f13849g = new LinkedHashMap();
        this.f13848f = true;
        q();
    }

    public static final boolean k(ConsultCommentEditTextLayout this$0, TextView textView, int i10, KeyEvent keyEvent) {
        s.i(this$0, "this$0");
        if (i10 != 4) {
            return true;
        }
        this$0.l();
        return true;
    }

    @Nullable
    public View f(int i10) {
        Map<Integer, View> map = this.f13849g;
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
        ((EditText) f(R$id.consult_comment_edit_text)).setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.cupidapp.live.consult.view.b
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i10, KeyEvent keyEvent) {
                boolean k10;
                k10 = ConsultCommentEditTextLayout.k(ConsultCommentEditTextLayout.this, textView, i10, keyEvent);
                return k10;
            }
        });
    }

    public final void l() {
        String str = this.f13847e;
        if (str == null || str.length() == 0) {
            return;
        }
        String obj = StringsKt__StringsKt.P0(((EditText) f(R$id.consult_comment_edit_text)).getText().toString()).toString();
        if (obj.length() == 0) {
            com.cupidapp.live.base.view.h.f12779a.l(getContext(), R$string.no_send_empty_msg);
            return;
        }
        if (this.f13848f) {
            this.f13848f = false;
            Disposable disposed = NetworkClient.f11868a.v().j(str, obj).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ConsultCommentResult, p>() { // from class: com.cupidapp.live.consult.view.ConsultCommentEditTextLayout$checkAndSendMsg$$inlined$handle$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(ConsultCommentResult consultCommentResult) {
                    m2540invoke(consultCommentResult);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2540invoke(ConsultCommentResult consultCommentResult) {
                    Function0 function0;
                    Context context = ConsultCommentEditTextLayout.this.getContext();
                    s.h(context, "context");
                    h.p(context, (EditText) ConsultCommentEditTextLayout.this.f(R$id.consult_comment_edit_text));
                    ConsultCommentEditTextLayout.this.f13848f = true;
                    function0 = ConsultCommentEditTextLayout.this.f13846d;
                    if (function0 != null) {
                        function0.invoke();
                    }
                }
            }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.consult.view.ConsultCommentEditTextLayout$checkAndSendMsg$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull Throwable it) {
                    s.i(it, "it");
                    ConsultCommentEditTextLayout.this.f13848f = true;
                    return Boolean.FALSE;
                }
            }, this)));
            if (disposed != null) {
                s.h(disposed, "disposed");
                H(disposed);
            }
            s.h(disposed, "disposed");
        }
    }

    public final void m(@Nullable String str) {
        this.f13847e = str;
    }

    public final void o(String str) {
        TextView textView = (TextView) f(R$id.comment_edit_current_word_count_text);
        if (str.length() < 40) {
            textView.setTextColor(-3750202);
        } else {
            textView.setTextColor(-49088);
        }
        textView.setText(String.valueOf(str.length()));
    }

    public final void p() {
        ((TextView) f(R$id.comment_edit_total_word_count_text)).setText(getContext().getString(R$string.super_liked_success_max_word_count, 40));
        o("");
        int i10 = R$id.consult_comment_edit_text;
        ((EditText) f(i10)).setInputType(262144);
        ((EditText) f(i10)).setSingleLine(false);
        ((EditText) f(i10)).setMaxLines(5);
        EditText consult_comment_edit_text = (EditText) f(i10);
        s.h(consult_comment_edit_text, "consult_comment_edit_text");
        consult_comment_edit_text.addTextChangedListener(new a());
    }

    public final void q() {
        z.a(this, R$layout.layout_consult_comment_edit_text, true);
        p();
        j();
    }

    public final void setDismissCallback(@NotNull Function0<p> callback) {
        s.i(callback, "callback");
        this.f13846d = callback;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsultCommentEditTextLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f13849g = new LinkedHashMap();
        this.f13848f = true;
        q();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsultCommentEditTextLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f13849g = new LinkedHashMap();
        this.f13848f = true;
        q();
    }
}
