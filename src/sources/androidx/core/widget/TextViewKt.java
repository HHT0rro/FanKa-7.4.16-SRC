package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yd.n;

/* compiled from: TextView.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class TextViewKt {
    @NotNull
    public static final TextWatcher addTextChangedListener(@NotNull TextView textView, @NotNull n<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, p> beforeTextChanged, @NotNull n<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, p> onTextChanged, @NotNull Function1<? super Editable, p> afterTextChanged) {
        s.i(textView, "<this>");
        s.i(beforeTextChanged, "beforeTextChanged");
        s.i(onTextChanged, "onTextChanged");
        s.i(afterTextChanged, "afterTextChanged");
        TextViewKt$addTextChangedListener$textWatcher$1 textViewKt$addTextChangedListener$textWatcher$1 = new TextViewKt$addTextChangedListener$textWatcher$1(afterTextChanged, beforeTextChanged, onTextChanged);
        textView.addTextChangedListener(textViewKt$addTextChangedListener$textWatcher$1);
        return textViewKt$addTextChangedListener$textWatcher$1;
    }

    public static /* synthetic */ TextWatcher addTextChangedListener$default(TextView textView, n beforeTextChanged, n onTextChanged, Function1 afterTextChanged, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            beforeTextChanged = new n<CharSequence, Integer, Integer, Integer, p>() { // from class: androidx.core.widget.TextViewKt$addTextChangedListener$1
                @Override // yd.n
                public /* bridge */ /* synthetic */ p invoke(CharSequence charSequence, Integer num, Integer num2, Integer num3) {
                    invoke(charSequence, num.intValue(), num2.intValue(), num3.intValue());
                    return p.f51048a;
                }

                public final void invoke(@Nullable CharSequence charSequence, int i11, int i12, int i13) {
                }
            };
        }
        if ((i10 & 2) != 0) {
            onTextChanged = new n<CharSequence, Integer, Integer, Integer, p>() { // from class: androidx.core.widget.TextViewKt$addTextChangedListener$2
                @Override // yd.n
                public /* bridge */ /* synthetic */ p invoke(CharSequence charSequence, Integer num, Integer num2, Integer num3) {
                    invoke(charSequence, num.intValue(), num2.intValue(), num3.intValue());
                    return p.f51048a;
                }

                public final void invoke(@Nullable CharSequence charSequence, int i11, int i12, int i13) {
                }
            };
        }
        if ((i10 & 4) != 0) {
            afterTextChanged = new Function1<Editable, p>() { // from class: androidx.core.widget.TextViewKt$addTextChangedListener$3
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Editable editable) {
                    invoke2(editable);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Editable editable) {
                }
            };
        }
        s.i(textView, "<this>");
        s.i(beforeTextChanged, "beforeTextChanged");
        s.i(onTextChanged, "onTextChanged");
        s.i(afterTextChanged, "afterTextChanged");
        TextViewKt$addTextChangedListener$textWatcher$1 textViewKt$addTextChangedListener$textWatcher$1 = new TextViewKt$addTextChangedListener$textWatcher$1(afterTextChanged, beforeTextChanged, onTextChanged);
        textView.addTextChangedListener(textViewKt$addTextChangedListener$textWatcher$1);
        return textViewKt$addTextChangedListener$textWatcher$1;
    }

    @NotNull
    public static final TextWatcher doAfterTextChanged(@NotNull TextView textView, @NotNull final Function1<? super Editable, p> action) {
        s.i(textView, "<this>");
        s.i(action, "action");
        TextWatcher textWatcher = new TextWatcher() { // from class: androidx.core.widget.TextViewKt$doAfterTextChanged$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(@Nullable Editable editable) {
                Function1.this.invoke(editable);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@Nullable CharSequence charSequence, int i10, int i11, int i12) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@Nullable CharSequence charSequence, int i10, int i11, int i12) {
            }
        };
        textView.addTextChangedListener(textWatcher);
        return textWatcher;
    }

    @NotNull
    public static final TextWatcher doBeforeTextChanged(@NotNull TextView textView, @NotNull final n<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, p> action) {
        s.i(textView, "<this>");
        s.i(action, "action");
        TextWatcher textWatcher = new TextWatcher() { // from class: androidx.core.widget.TextViewKt$doBeforeTextChanged$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(@Nullable Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@Nullable CharSequence charSequence, int i10, int i11, int i12) {
                n.this.invoke(charSequence, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12));
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@Nullable CharSequence charSequence, int i10, int i11, int i12) {
            }
        };
        textView.addTextChangedListener(textWatcher);
        return textWatcher;
    }

    @NotNull
    public static final TextWatcher doOnTextChanged(@NotNull TextView textView, @NotNull final n<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, p> action) {
        s.i(textView, "<this>");
        s.i(action, "action");
        TextWatcher textWatcher = new TextWatcher() { // from class: androidx.core.widget.TextViewKt$doOnTextChanged$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(@Nullable Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@Nullable CharSequence charSequence, int i10, int i11, int i12) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@Nullable CharSequence charSequence, int i10, int i11, int i12) {
                n.this.invoke(charSequence, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12));
            }
        };
        textView.addTextChangedListener(textWatcher);
        return textWatcher;
    }
}
