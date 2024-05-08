package j1;

import android.content.Context;
import com.cupidapp.live.profile.model.User;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SensorsDataHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f50226a = new a();

    public final void a(@Nullable Context context) {
        if (context == null) {
            return;
        }
        z3.c.f54829a.i(context);
        b();
    }

    public final void b() {
        User X = p1.g.f52734a.X();
        String userId = X != null ? X.userId() : null;
        if (userId == null || userId.length() == 0) {
            return;
        }
        z3.c cVar = z3.c.f54829a;
        cVar.k(userId);
        cVar.m(userId);
        cVar.b();
    }

    public final void c(@Nullable String str) {
        z3.c.f54829a.c(str);
    }
}
