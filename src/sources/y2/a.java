package y2;

import com.cupidapp.live.maskparty.model.RoleType;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MaskPartyItemCardModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final Map<String, RoleType> f54659a;

    @NotNull
    public final Map<String, RoleType> a() {
        return this.f54659a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && s.d(this.f54659a, ((a) obj).f54659a);
    }

    public int hashCode() {
        return this.f54659a.hashCode();
    }

    @NotNull
    public String toString() {
        return "OldSelectRoleType(map=" + ((Object) this.f54659a) + ")";
    }
}
