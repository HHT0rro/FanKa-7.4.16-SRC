package q1;

import android.content.Context;
import android.view.View;
import com.cupidapp.live.base.utils.j;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClipboardUtils.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f53003a = new b();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static String f53004b = "";

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void e(b bVar, Context context, View view, Function1 function1, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            function1 = null;
        }
        bVar.d(context, view, function1);
    }

    public static final void f(Context context, Function1 function1) {
        String c4 = c.f53005a.c(context);
        int X = StringsKt__StringsKt.X(c4, "##", 0, false, 6, null);
        int d02 = StringsKt__StringsKt.d0(c4, "##", 0, false, 6, null);
        j.a aVar = j.f12332a;
        aVar.a("ClipboardContentManager", "text:" + c4 + "  count:" + c4.length());
        aVar.a("ClipboardContentManager", "start:" + X + "  end:" + d02);
        b bVar = f53003a;
        if (bVar.b(X, c4) && bVar.b(d02, c4) && d02 > "##".length() + X) {
            int length = X + "##".length();
            aVar.a("ClipboardContentManager", "finalStart:" + length + "  end:" + d02);
            String substring = c4.substring(length, d02);
            s.h(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            f53004b = substring;
        }
        aVar.a("ClipboardContentManager", "mClipboardToken:" + f53004b);
        if (!(f53004b.length() > 0) || function1 == null) {
            return;
        }
        function1.invoke(f53004b);
    }

    public final boolean b(int i10, String str) {
        return i10 >= 0 && i10 < str.length();
    }

    public final void c(@NotNull Context context) {
        s.i(context, "context");
        c.f53005a.a(context);
        f53004b = "";
    }

    public final void d(@Nullable final Context context, @Nullable View view, @Nullable final Function1<? super String, p> function1) {
        if (context == null || view == null) {
            return;
        }
        view.post(new Runnable() { // from class: q1.a
            @Override // java.lang.Runnable
            public final void run() {
                b.f(context, function1);
            }
        });
    }
}
