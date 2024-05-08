package com.cupidapp.live.superboost.model;

import android.content.Context;
import com.cupidapp.live.R$string;
import java.util.Arrays;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.y;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.m;

/* compiled from: RemainAssetsResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class UnLimitRemainsUIModel {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @Nullable
    private final String formattedRemains;

    @Nullable
    private Integer remains;

    /* compiled from: RemainAssetsResult.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final UnLimitRemainsUIModel a(@NotNull Context context, @Nullable Integer num) {
            String format;
            s.i(context, "context");
            if ((num != null ? num.intValue() : 0) <= -100) {
                format = context.getString(R$string.unlimit);
            } else {
                y yVar = y.f51038a;
                String string = context.getString(R$string.numbers_count);
                s.h(string, "context.getString(R.string.numbers_count)");
                Object[] objArr = new Object[1];
                objArr[0] = num != null ? m.d(num.intValue()) : null;
                format = String.format(string, Arrays.copyOf(objArr, 1));
                s.h(format, "format(format, *args)");
            }
            s.h(format, "if ((remains ?: 0) <= -1…          )\n            }");
            return new UnLimitRemainsUIModel(num, format);
        }
    }

    public UnLimitRemainsUIModel(@Nullable Integer num, @Nullable String str) {
        this.remains = num;
        this.formattedRemains = str;
    }

    public static /* synthetic */ UnLimitRemainsUIModel copy$default(UnLimitRemainsUIModel unLimitRemainsUIModel, Integer num, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = unLimitRemainsUIModel.remains;
        }
        if ((i10 & 2) != 0) {
            str = unLimitRemainsUIModel.formattedRemains;
        }
        return unLimitRemainsUIModel.copy(num, str);
    }

    @Nullable
    public final Integer component1() {
        return this.remains;
    }

    @Nullable
    public final String component2() {
        return this.formattedRemains;
    }

    @NotNull
    public final UnLimitRemainsUIModel copy(@Nullable Integer num, @Nullable String str) {
        return new UnLimitRemainsUIModel(num, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UnLimitRemainsUIModel)) {
            return false;
        }
        UnLimitRemainsUIModel unLimitRemainsUIModel = (UnLimitRemainsUIModel) obj;
        return s.d(this.remains, unLimitRemainsUIModel.remains) && s.d(this.formattedRemains, unLimitRemainsUIModel.formattedRemains);
    }

    @Nullable
    public final String getFormattedRemains() {
        return this.formattedRemains;
    }

    @Nullable
    /* renamed from: getRemains, reason: collision with other method in class */
    public final Integer m2820getRemains() {
        return this.remains;
    }

    public final boolean hasRemains() {
        Integer num = this.remains;
        if ((num != null ? num.intValue() : 0) > -100) {
            Integer num2 = this.remains;
            if ((num2 != null ? num2.intValue() : 0) <= 0) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        Integer num = this.remains;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.formattedRemains;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public final void setRemains(@Nullable Integer num) {
        this.remains = num;
    }

    @NotNull
    public String toString() {
        Integer num = this.remains;
        return "UnLimitRemainsUIModel(remains=" + ((Object) num) + ", formattedRemains=" + this.formattedRemains + ")";
    }

    public final int getRemains() {
        Integer num = this.remains;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }
}
