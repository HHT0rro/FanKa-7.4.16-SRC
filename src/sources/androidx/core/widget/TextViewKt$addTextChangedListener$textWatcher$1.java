package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;
import kotlin.jvm.functions.Function1;
import kotlin.p;
import org.jetbrains.annotations.Nullable;
import yd.n;

/* compiled from: TextView.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class TextViewKt$addTextChangedListener$textWatcher$1 implements TextWatcher {
    public final /* synthetic */ Function1<Editable, p> $afterTextChanged;
    public final /* synthetic */ n<CharSequence, Integer, Integer, Integer, p> $beforeTextChanged;
    public final /* synthetic */ n<CharSequence, Integer, Integer, Integer, p> $onTextChanged;

    /* JADX WARN: Multi-variable type inference failed */
    public TextViewKt$addTextChangedListener$textWatcher$1(Function1<? super Editable, p> function1, n<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, p> nVar, n<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, p> nVar2) {
        this.$afterTextChanged = function1;
        this.$beforeTextChanged = nVar;
        this.$onTextChanged = nVar2;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(@Nullable Editable editable) {
        this.$afterTextChanged.invoke(editable);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(@Nullable CharSequence charSequence, int i10, int i11, int i12) {
        this.$beforeTextChanged.invoke(charSequence, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12));
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(@Nullable CharSequence charSequence, int i10, int i11, int i12) {
        this.$onTextChanged.invoke(charSequence, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12));
    }
}
