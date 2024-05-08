package q1;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.textclassifier.TextClassifier;
import kotlin.jvm.internal.s;
import kotlin.text.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClipboardUtils.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f53005a = new c();

    public final boolean a(@Nullable Context context) {
        return b(context, "");
    }

    public final boolean b(@Nullable Context context, @NotNull String copyStr) {
        Object systemService;
        s.i(copyStr, "copyStr");
        if (context != null) {
            try {
                systemService = context.getSystemService(TextClassifier.WIDGET_TYPE_CLIPBOARD);
            } catch (Exception unused) {
                return false;
            }
        } else {
            systemService = null;
        }
        ClipboardManager clipboardManager = systemService instanceof ClipboardManager ? (ClipboardManager) systemService : null;
        if (clipboardManager == null) {
            return false;
        }
        clipboardManager.setPrimaryClip(ClipData.newPlainText("Label", copyStr));
        return true;
    }

    @NotNull
    public final String c(@Nullable Context context) {
        Object systemService;
        ClipData primaryClip;
        if (context != null) {
            try {
                systemService = context.getSystemService(TextClassifier.WIDGET_TYPE_CLIPBOARD);
            } catch (Exception unused) {
                return "";
            }
        } else {
            systemService = null;
        }
        ClipboardManager clipboardManager = systemService instanceof ClipboardManager ? (ClipboardManager) systemService : null;
        if (clipboardManager == null || (primaryClip = clipboardManager.getPrimaryClip()) == null || primaryClip.getItemCount() <= 0) {
            return "";
        }
        CharSequence text = primaryClip.getItemAt(0).getText();
        if (text != null) {
            return ((text.length() > 0) && (p.t(text) ^ true)) ? text.toString() : "";
        }
        return "";
    }
}
