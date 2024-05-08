package androidx.core.content;

import android.content.SharedPreferences;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: SharedPreferences.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class SharedPreferencesKt {
    public static final void edit(@NotNull SharedPreferences sharedPreferences, boolean z10, @NotNull Function1<? super SharedPreferences.Editor, kotlin.p> action) {
        kotlin.jvm.internal.s.i(sharedPreferences, "<this>");
        kotlin.jvm.internal.s.i(action, "action");
        SharedPreferences.Editor editor = sharedPreferences.edit();
        kotlin.jvm.internal.s.h(editor, "editor");
        action.invoke(editor);
        if (z10) {
            editor.commit();
        } else {
            editor.apply();
        }
    }

    public static /* synthetic */ void edit$default(SharedPreferences sharedPreferences, boolean z10, Function1 action, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        kotlin.jvm.internal.s.i(sharedPreferences, "<this>");
        kotlin.jvm.internal.s.i(action, "action");
        SharedPreferences.Editor editor = sharedPreferences.edit();
        kotlin.jvm.internal.s.h(editor, "editor");
        action.invoke(editor);
        if (z10) {
            editor.commit();
        } else {
            editor.apply();
        }
    }
}
