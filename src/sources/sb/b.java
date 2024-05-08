package sb;

import android.graphics.Path;
import java.util.Set;
import java.util.StringTokenizer;
import kotlin.jvm.internal.s;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: SVGAPathEntity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f53695a;

    /* renamed from: b, reason: collision with root package name */
    public Path f53696b;

    public b(@NotNull String originValue) {
        s.j(originValue, "originValue");
        this.f53695a = StringsKt__StringsKt.K(originValue, ",", false, 2, null) ? p.A(originValue, ",", " ", false, 4, null) : originValue;
    }

    public final void a(@NotNull Path toPath) {
        Set set;
        s.j(toPath, "toPath");
        Path path = this.f53696b;
        if (path != null) {
            toPath.set(path);
            return;
        }
        Path path2 = new Path();
        StringTokenizer stringTokenizer = new StringTokenizer(this.f53695a, "MLHVCSQRAZmlhvcsqraz", true);
        String str = "";
        while (stringTokenizer.hasMoreTokens()) {
            String segment = stringTokenizer.nextToken();
            s.e(segment, "segment");
            if (!(segment.length() == 0)) {
                set = c.f53697a;
                if (set.contains(segment)) {
                    if (s.d(segment, "Z") || s.d(segment, "z")) {
                        b(path2, segment, new StringTokenizer("", ""));
                    }
                    str = segment;
                } else {
                    b(path2, str, new StringTokenizer(segment, " "));
                }
            }
        }
        this.f53696b = path2;
        toPath.set(path2);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0097  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(android.graphics.Path r16, java.lang.String r17, java.util.StringTokenizer r18) {
        /*
            Method dump skipped, instructions count: 298
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sb.b.b(android.graphics.Path, java.lang.String, java.util.StringTokenizer):void");
    }
}
