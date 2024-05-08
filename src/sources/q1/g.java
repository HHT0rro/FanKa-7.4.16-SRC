package q1;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TextViewsWatcher.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class g implements TextWatcher {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final List<TextView> f53016b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public final Function1<Boolean, p> f53017c;

    /* JADX WARN: Multi-variable type inference failed */
    public g(@NotNull List<? extends TextView> editViews, @Nullable Function1<? super Boolean, p> function1) {
        s.i(editViews, "editViews");
        this.f53016b = editViews;
        this.f53017c = function1;
        Iterator iterator2 = editViews.iterator2();
        while (iterator2.hasNext()) {
            ((TextView) iterator2.next()).addTextChangedListener(this);
        }
    }

    public final boolean a() {
        boolean z10;
        Iterator<TextView> iterator2 = this.f53016b.iterator2();
        do {
            z10 = true;
            if (iterator2.hasNext()) {
                if (iterator2.next().getText().toString().length() != 0) {
                    z10 = false;
                }
            } else {
                Function1<Boolean, p> function1 = this.f53017c;
                if (function1 != null) {
                    function1.invoke(Boolean.TRUE);
                }
                return true;
            }
        } while (!z10);
        Function1<Boolean, p> function12 = this.f53017c;
        if (function12 != null) {
            function12.invoke(Boolean.FALSE);
        }
        return false;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(@Nullable Editable editable) {
        a();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(@Nullable CharSequence charSequence, int i10, int i11, int i12) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(@Nullable CharSequence charSequence, int i10, int i11, int i12) {
    }
}
