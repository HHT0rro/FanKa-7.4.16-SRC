package com.cupidapp.live.feed.helper;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import com.cupidapp.live.feed.layout.EditTextSelectable;
import com.cupidapp.live.mentionuser.model.ReplaceAtModel;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: EditTextAtUserHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class f {

    /* renamed from: a */
    @NotNull
    public final EditTextSelectable f14318a;

    /* renamed from: b */
    @Nullable
    public final Function1<Boolean, p> f14319b;

    /* renamed from: c */
    @NotNull
    public final b f14320c;

    /* renamed from: d */
    @NotNull
    public final TextWatcher f14321d;

    /* compiled from: EditTextAtUserHelper.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a implements TextWatcher {

        /* renamed from: b */
        public int f14322b;

        /* renamed from: c */
        public int f14323c;

        /* renamed from: d */
        @Nullable
        public SpannableStringBuilder f14324d;

        /* renamed from: e */
        @Nullable
        public SpannableStringBuilder f14325e;

        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@NotNull Editable editable) {
            Function1<Boolean, p> g3;
            s.i(editable, "editable");
            if (f.this.i(String.valueOf(this.f14324d), String.valueOf(this.f14325e), f.this.h().getSelectionEnd()) && (g3 = f.this.g()) != null) {
                g3.invoke(Boolean.TRUE);
            }
            f.this.h().removeTextChangedListener(this);
            f.this.e(this.f14324d, this.f14325e, editable, this.f14322b, this.f14323c);
            SpannableStringBuilder spannableStringBuilder = this.f14325e;
            int length = spannableStringBuilder != null ? spannableStringBuilder.length() : 0;
            SpannableStringBuilder spannableStringBuilder2 = this.f14324d;
            if (length > (spannableStringBuilder2 != null ? spannableStringBuilder2.length() : 0)) {
                ForegroundColorSpan[] toBeRemovedSpans = (ForegroundColorSpan[]) editable.getSpans(0, editable.length(), ForegroundColorSpan.class);
                s.h(toBeRemovedSpans, "toBeRemovedSpans");
                for (ForegroundColorSpan foregroundColorSpan : toBeRemovedSpans) {
                    if (!(foregroundColorSpan instanceof AtUserForegroundColorSpan)) {
                        editable.removeSpan(foregroundColorSpan);
                    }
                }
            }
            f.this.h().addTextChangedListener(this);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@NotNull CharSequence s2, int i10, int i11, int i12) {
            s.i(s2, "s");
            this.f14324d = new SpannableStringBuilder(s2);
            this.f14322b = f.this.h().getSelectionStart();
            this.f14323c = f.this.h().getSelectionEnd();
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@NotNull CharSequence s2, int i10, int i11, int i12) {
            s.i(s2, "s");
            this.f14325e = new SpannableStringBuilder(s2);
        }
    }

    /* compiled from: EditTextAtUserHelper.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b implements EditTextSelectable.a {
        public b() {
        }

        @Override // com.cupidapp.live.feed.layout.EditTextSelectable.a
        public void a(int i10, int i11) {
            boolean z10;
            Editable text = f.this.h().getText();
            if (text instanceof SpannableStringBuilder) {
                SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) text;
                AtUserForegroundColorSpan[] beforeSpans = (AtUserForegroundColorSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), AtUserForegroundColorSpan.class);
                s.h(beforeSpans, "beforeSpans");
                int i12 = i10;
                int i13 = i11;
                for (AtUserForegroundColorSpan atUserForegroundColorSpan : beforeSpans) {
                    int spanStart = spannableStringBuilder.getSpanStart(atUserForegroundColorSpan);
                    int spanEnd = spannableStringBuilder.getSpanEnd(atUserForegroundColorSpan);
                    boolean z11 = true;
                    if (i10 <= spanStart || i10 >= spanEnd) {
                        z10 = false;
                    } else {
                        i12 = spanStart;
                        z10 = true;
                    }
                    if (i11 >= spanEnd || i11 <= spanStart) {
                        z11 = z10;
                    } else {
                        i13 = spanEnd;
                    }
                    if (z11) {
                        f.this.h().setSelection(i12, i13);
                    }
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(@NotNull EditTextSelectable editText, @Nullable Function1<? super Boolean, p> function1) {
        s.i(editText, "editText");
        this.f14318a = editText;
        this.f14319b = function1;
        b bVar = new b();
        this.f14320c = bVar;
        TextWatcher aVar = new a();
        this.f14321d = aVar;
        editText.addTextChangedListener(aVar);
        editText.a(bVar);
    }

    public static /* synthetic */ void c(f fVar, String str, String str2, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            i10 = -16747822;
        }
        fVar.b(str, str2, z10, i10);
    }

    public static final void d(f this$0, boolean z10, String str, String str2, int i10) {
        String str3;
        s.i(this$0, "this$0");
        this$0.f14318a.removeTextChangedListener(this$0.f14321d);
        if (z10) {
            str3 = String.valueOf(str);
        } else {
            str3 = "@" + str;
        }
        int length = this$0.f14318a.length();
        int max = Math.max(0, this$0.f14318a.getSelectionEnd());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this$0.f14318a.getText());
        spannableStringBuilder.insert(max, (CharSequence) str3);
        AtUserForegroundColorSpan atUserForegroundColorSpan = new AtUserForegroundColorSpan(str, str2, i10);
        if (z10) {
            spannableStringBuilder.setSpan(atUserForegroundColorSpan, max - 1, str3.length() + max, 33);
        } else {
            spannableStringBuilder.setSpan(atUserForegroundColorSpan, max, str3.length() + max, 33);
        }
        this$0.f14318a.setText(spannableStringBuilder.append((CharSequence) " "));
        this$0.f14318a.setSelection((this$0.f14318a.length() - length) + max);
        this$0.f14318a.addTextChangedListener(this$0.f14321d);
        this$0.f14318a.requestFocus();
    }

    public final void b(@Nullable final String str, @Nullable final String str2, final boolean z10, final int i10) {
        if (str == null || str.length() == 0) {
            return;
        }
        if (str2 == null || str2.length() == 0) {
            return;
        }
        this.f14318a.post(new Runnable() { // from class: com.cupidapp.live.feed.helper.e
            @Override // java.lang.Runnable
            public final void run() {
                f.d(f.this, z10, str2, str, i10);
            }
        });
    }

    public final void e(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2, @Nullable Editable editable, int i10, int i11) {
        if (TextUtils.isEmpty(charSequence2) || TextUtils.isEmpty(charSequence) || !(charSequence2 instanceof SpannableStringBuilder) || !(charSequence instanceof SpannableStringBuilder)) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) charSequence;
        if (((SpannableStringBuilder) charSequence2).length() < spannableStringBuilder.length()) {
            AtUserForegroundColorSpan[] beforeSpans = (AtUserForegroundColorSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), AtUserForegroundColorSpan.class);
            s.h(beforeSpans, "beforeSpans");
            for (AtUserForegroundColorSpan atUserForegroundColorSpan : beforeSpans) {
                int spanStart = spannableStringBuilder.getSpanStart(atUserForegroundColorSpan);
                int spanEnd = spannableStringBuilder.getSpanEnd(atUserForegroundColorSpan);
                boolean z10 = true;
                if (i10 != i11 || i11 != spanEnd) {
                    if (i10 <= spanStart && i11 >= spanEnd) {
                        return;
                    }
                    if (i10 > spanStart || i11 <= spanStart) {
                        if (i10 >= spanEnd || i11 < spanEnd) {
                            z10 = false;
                        } else if (editable != null) {
                            editable.delete(spanStart, Math.min(i10, editable.length()));
                        }
                    } else if (editable != null) {
                        editable.delete(i10, Math.min(spanEnd - i11, editable.length()));
                    }
                } else if (editable != null) {
                    editable.delete(spanStart, Math.min(spanEnd - 1, editable.length()));
                }
                if (z10) {
                    spannableStringBuilder.removeSpan(atUserForegroundColorSpan);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public final List<ReplaceAtModel> f() {
        Editable text = this.f14318a.getText();
        if (text == null || !(text instanceof SpannableStringBuilder)) {
            return null;
        }
        int i10 = -1;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i11 = 0;
        int i12 = 0;
        while (i11 < text.length()) {
            int i13 = i12 + 1;
            if (text.charAt(i11) == '@') {
                i10++;
                linkedHashMap.put(Integer.valueOf(i12), Integer.valueOf(i10));
            }
            i11++;
            i12 = i13;
        }
        SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) text;
        Object[] spans = spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), AtUserForegroundColorSpan.class);
        s.h(spans, "text.getSpans(\n         …:class.java\n            )");
        ArrayList arrayList = new ArrayList();
        for (Object obj : spans) {
            AtUserForegroundColorSpan atUserForegroundColorSpan = (AtUserForegroundColorSpan) obj;
            arrayList.add(new ReplaceAtModel(atUserForegroundColorSpan.a(), atUserForegroundColorSpan.b(), (Integer) linkedHashMap.get(Integer.valueOf(spannableStringBuilder.getSpanStart(atUserForegroundColorSpan)))));
        }
        return arrayList;
    }

    @Nullable
    public final Function1<Boolean, p> g() {
        return this.f14319b;
    }

    @NotNull
    public final EditTextSelectable h() {
        return this.f14318a;
    }

    public final boolean i(@NotNull String beforeStr, @NotNull String afterStr, int i10) {
        int i11;
        s.i(beforeStr, "beforeStr");
        s.i(afterStr, "afterStr");
        if (TextUtils.isEmpty(afterStr)) {
            return false;
        }
        return (TextUtils.isEmpty(beforeStr) || afterStr.length() > beforeStr.length()) && (i11 = i10 + (-1)) >= 0 && s.d(afterStr.subSequence(i11, i10), "@");
    }
}
