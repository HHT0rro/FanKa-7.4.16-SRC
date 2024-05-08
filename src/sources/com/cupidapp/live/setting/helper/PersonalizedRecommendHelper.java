package com.cupidapp.live.setting.helper;

import com.cupidapp.live.R$string;
import com.cupidapp.live.base.network.model.ConstantsResult;
import kotlin.Lazy;
import kotlin.c;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import p1.g;

/* compiled from: PersonalizedRecommendHelper.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class PersonalizedRecommendHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final PersonalizedRecommendHelper f18179a = new PersonalizedRecommendHelper();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final Lazy f18180b = c.b(new Function0<Boolean>() { // from class: com.cupidapp.live.setting.helper.PersonalizedRecommendHelper$isOpenContentRecommend$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Boolean invoke() {
            Boolean openPersonalizedRecommendation;
            ConstantsResult q10 = g.f52734a.q();
            return Boolean.valueOf((q10 == null || (openPersonalizedRecommendation = q10.getOpenPersonalizedRecommendation()) == null) ? true : openPersonalizedRecommendation.booleanValue());
        }
    });

    public final int a() {
        return e() ? R$string.recommended_live : R$string.featured_live;
    }

    public final int b() {
        return e() ? R$string.discover : R$string.hot;
    }

    public final int c() {
        return e() ? R$string.the_anchors_that_you_maybe_like : R$string.featured_anchor;
    }

    public final int d() {
        return e() ? R$string.recommend : R$string.finka_app_name;
    }

    public final boolean e() {
        return ((Boolean) f18180b.getValue()).booleanValue();
    }
}
