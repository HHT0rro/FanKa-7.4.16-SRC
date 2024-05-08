package y2;

import com.cupidapp.live.maskparty.model.RoleType;
import java.util.List;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MaskPartyItemCardModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final Map<String, List<RoleType>> f54661a;

    public c(@NotNull Map<String, List<RoleType>> map) {
        s.i(map, "map");
        this.f54661a = map;
    }

    @NotNull
    public final Map<String, List<RoleType>> a() {
        return this.f54661a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c) && s.d(this.f54661a, ((c) obj).f54661a);
    }

    public int hashCode() {
        return this.f54661a.hashCode();
    }

    @NotNull
    public String toString() {
        return "SelectRoleType(map=" + ((Object) this.f54661a) + ")";
    }
}
