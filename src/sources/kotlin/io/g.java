package kotlin.io;

import com.android.internal.accessibility.common.ShortcutConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.t;
import kotlin.jvm.internal.s;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: FilePathComponents.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class g {
    public static final int a(String str) {
        int W;
        int W2 = StringsKt__StringsKt.W(str, File.separatorChar, 0, false, 4, null);
        if (W2 == 0) {
            if (str.length() > 1) {
                char charAt = str.charAt(1);
                char c4 = File.separatorChar;
                if (charAt == c4 && (W = StringsKt__StringsKt.W(str, c4, 2, false, 4, null)) >= 0) {
                    int W3 = StringsKt__StringsKt.W(str, File.separatorChar, W + 1, false, 4, null);
                    return W3 >= 0 ? W3 + 1 : str.length();
                }
            }
            return 1;
        }
        if (W2 > 0 && str.charAt(W2 - 1) == ':') {
            return W2 + 1;
        }
        if (W2 == -1 && StringsKt__StringsKt.N(str, ShortcutConstants.SERVICES_SEPARATOR, false, 2, null)) {
            return str.length();
        }
        return 0;
    }

    @NotNull
    public static final e b(@NotNull File file) {
        List list;
        s.i(file, "<this>");
        String path = file.getPath();
        s.h(path, "path");
        int a10 = a(path);
        String substring = path.substring(0, a10);
        s.h(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        String substring2 = path.substring(a10);
        s.h(substring2, "this as java.lang.String).substring(startIndex)");
        if (substring2.length() == 0) {
            list = kotlin.collections.s.j();
        } else {
            List y02 = StringsKt__StringsKt.y0(substring2, new char[]{File.separatorChar}, false, 0, 6, null);
            ArrayList arrayList = new ArrayList(t.t(y02, 10));
            Iterator<E> iterator2 = y02.iterator2();
            while (iterator2.hasNext()) {
                arrayList.add(new File((String) iterator2.next()));
            }
            list = arrayList;
        }
        return new e(new File(substring), list);
    }
}
