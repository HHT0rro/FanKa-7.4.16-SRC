package y2;

import com.cupidapp.live.maskparty.model.ItemCardFeaturesItemModel;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MaskPartyItemCardModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final Map<String, ItemCardFeaturesItemModel> f54660a;

    public b(@NotNull Map<String, ItemCardFeaturesItemModel> map) {
        s.i(map, "map");
        this.f54660a = map;
    }

    @NotNull
    public final Map<String, ItemCardFeaturesItemModel> a() {
        return this.f54660a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof b) && s.d(this.f54660a, ((b) obj).f54660a);
    }

    public int hashCode() {
        return this.f54660a.hashCode();
    }

    @NotNull
    public String toString() {
        return "SelectItemCard(map=" + ((Object) this.f54660a) + ")";
    }
}
