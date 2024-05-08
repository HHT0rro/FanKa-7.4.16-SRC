package j3;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CloseFriendListModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public final Integer f50296a;

    @Nullable
    public final Integer a() {
        return this.f50296a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && s.d(this.f50296a, ((a) obj).f50296a);
    }

    public int hashCode() {
        Integer num = this.f50296a;
        if (num == null) {
            return 0;
        }
        return num.hashCode();
    }

    @NotNull
    public String toString() {
        return "CloseFriendCount(count=" + ((Object) this.f50296a) + ")";
    }
}
