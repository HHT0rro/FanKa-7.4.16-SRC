package com.cupidapp.live.profile.model;

import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: User.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ZodiacElfInfoModel implements Serializable {

    @Nullable
    private final String subTitle;

    @Nullable
    private final String title;

    @Nullable
    private final Integer type;

    public ZodiacElfInfoModel(@Nullable Integer num, @Nullable String str, @Nullable String str2) {
        this.type = num;
        this.title = str;
        this.subTitle = str2;
    }

    public static /* synthetic */ ZodiacElfInfoModel copy$default(ZodiacElfInfoModel zodiacElfInfoModel, Integer num, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = zodiacElfInfoModel.type;
        }
        if ((i10 & 2) != 0) {
            str = zodiacElfInfoModel.title;
        }
        if ((i10 & 4) != 0) {
            str2 = zodiacElfInfoModel.subTitle;
        }
        return zodiacElfInfoModel.copy(num, str, str2);
    }

    @Nullable
    public final Integer component1() {
        return this.type;
    }

    @Nullable
    public final String component2() {
        return this.title;
    }

    @Nullable
    public final String component3() {
        return this.subTitle;
    }

    @NotNull
    public final ZodiacElfInfoModel copy(@Nullable Integer num, @Nullable String str, @Nullable String str2) {
        return new ZodiacElfInfoModel(num, str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ZodiacElfInfoModel)) {
            return false;
        }
        ZodiacElfInfoModel zodiacElfInfoModel = (ZodiacElfInfoModel) obj;
        return s.d(this.type, zodiacElfInfoModel.type) && s.d(this.title, zodiacElfInfoModel.title) && s.d(this.subTitle, zodiacElfInfoModel.subTitle);
    }

    @Nullable
    public final String getSubTitle() {
        return this.subTitle;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final Integer getType() {
        return this.type;
    }

    public int hashCode() {
        Integer num = this.type;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.title;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.subTitle;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        Integer num = this.type;
        return "ZodiacElfInfoModel(type=" + ((Object) num) + ", title=" + this.title + ", subTitle=" + this.subTitle + ")";
    }
}
