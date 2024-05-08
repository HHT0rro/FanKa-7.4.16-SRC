package com.cupidapp.live.setting.helper;

import com.cupidapp.live.setting.model.MultiAccountUserIdsModel;
import com.cupidapp.live.setting.model.SwitchAccountUserModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.t;
import kotlin.collections.x;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;

/* compiled from: MultiAccountUserIdManager.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MultiAccountUserIdManager {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final MultiAccountUserIdManager f18178a = new MultiAccountUserIdManager();

    public final void a(@NotNull String userId) {
        List<String> list;
        s.i(userId, "userId");
        if (userId.length() == 0) {
            return;
        }
        g gVar = g.f52734a;
        MultiAccountUserIdsModel p02 = gVar.p0();
        if (p02 != null && (list = p02.getList()) != null && !list.contains(userId)) {
            list.add(userId);
        }
        gVar.Q2(p02);
    }

    public final void b(@Nullable final String str) {
        List<String> list;
        if (str == null || str.length() == 0) {
            return;
        }
        g gVar = g.f52734a;
        MultiAccountUserIdsModel p02 = gVar.p0();
        if (p02 != null && (list = p02.getList()) != null) {
            x.B(list, new Function1<String, Boolean>() { // from class: com.cupidapp.live.setting.helper.MultiAccountUserIdManager$removeUserId$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull String it) {
                    s.i(it, "it");
                    return Boolean.valueOf(s.d(it, String.this));
                }
            });
        }
        gVar.Q2(p02);
    }

    public final void c(@Nullable List<SwitchAccountUserModel> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList(t.t(list, 10));
            Iterator<SwitchAccountUserModel> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                arrayList.add(iterator2.next().getUserId());
            }
            List z02 = CollectionsKt___CollectionsKt.z0(arrayList);
            if (z02 != null) {
                g.f52734a.Q2(new MultiAccountUserIdsModel(z02));
            }
        }
    }
}
