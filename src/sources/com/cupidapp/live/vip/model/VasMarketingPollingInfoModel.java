package com.cupidapp.live.vip.model;

import android.content.Context;
import com.cupidapp.live.base.router.j;
import java.util.List;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VasMarketingFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VasMarketingPollingInfoModel {

    @Nullable
    private final String actName;

    @Nullable
    private final List<String> showPlace;

    @Nullable
    private final String subTitle;

    @Nullable
    private final String title;

    @Nullable
    private final Map<String, String> url;

    public VasMarketingPollingInfoModel(@Nullable String str, @Nullable String str2, @Nullable List<String> list, @Nullable Map<String, String> map, @Nullable String str3) {
        this.title = str;
        this.subTitle = str2;
        this.showPlace = list;
        this.url = map;
        this.actName = str3;
    }

    public static /* synthetic */ VasMarketingPollingInfoModel copy$default(VasMarketingPollingInfoModel vasMarketingPollingInfoModel, String str, String str2, List list, Map map, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = vasMarketingPollingInfoModel.title;
        }
        if ((i10 & 2) != 0) {
            str2 = vasMarketingPollingInfoModel.subTitle;
        }
        String str4 = str2;
        if ((i10 & 4) != 0) {
            list = vasMarketingPollingInfoModel.showPlace;
        }
        List list2 = list;
        if ((i10 & 8) != 0) {
            map = vasMarketingPollingInfoModel.url;
        }
        Map map2 = map;
        if ((i10 & 16) != 0) {
            str3 = vasMarketingPollingInfoModel.actName;
        }
        return vasMarketingPollingInfoModel.copy(str, str4, list2, map2, str3);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean canShowBubble(@org.jetbrains.annotations.NotNull com.cupidapp.live.vip.model.VasMarketingShowPlaceType r4) {
        /*
            r3 = this;
            java.lang.String r0 = "type"
            kotlin.jvm.internal.s.i(r4, r0)
            java.util.List<java.lang.String> r0 = r3.showPlace
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L17
            java.lang.String r4 = r4.name()
            boolean r4 = r0.contains(r4)
            if (r4 != r1) goto L17
            r4 = 1
            goto L18
        L17:
            r4 = 0
        L18:
            if (r4 == 0) goto L2f
            java.lang.String r4 = r3.title
            if (r4 == 0) goto L2b
            int r4 = r4.length()
            if (r4 <= 0) goto L26
            r4 = 1
            goto L27
        L26:
            r4 = 0
        L27:
            if (r4 != r1) goto L2b
            r4 = 1
            goto L2c
        L2b:
            r4 = 0
        L2c:
            if (r4 == 0) goto L2f
            goto L30
        L2f:
            r1 = 0
        L30:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.vip.model.VasMarketingPollingInfoModel.canShowBubble(com.cupidapp.live.vip.model.VasMarketingShowPlaceType):boolean");
    }

    @Nullable
    public final String component1() {
        return this.title;
    }

    @Nullable
    public final String component2() {
        return this.subTitle;
    }

    @Nullable
    public final List<String> component3() {
        return this.showPlace;
    }

    @Nullable
    public final Map<String, String> component4() {
        return this.url;
    }

    @Nullable
    public final String component5() {
        return this.actName;
    }

    @NotNull
    public final VasMarketingPollingInfoModel copy(@Nullable String str, @Nullable String str2, @Nullable List<String> list, @Nullable Map<String, String> map, @Nullable String str3) {
        return new VasMarketingPollingInfoModel(str, str2, list, map, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VasMarketingPollingInfoModel)) {
            return false;
        }
        VasMarketingPollingInfoModel vasMarketingPollingInfoModel = (VasMarketingPollingInfoModel) obj;
        return s.d(this.title, vasMarketingPollingInfoModel.title) && s.d(this.subTitle, vasMarketingPollingInfoModel.subTitle) && s.d(this.showPlace, vasMarketingPollingInfoModel.showPlace) && s.d(this.url, vasMarketingPollingInfoModel.url) && s.d(this.actName, vasMarketingPollingInfoModel.actName);
    }

    @Nullable
    public final String getActName() {
        return this.actName;
    }

    @Nullable
    public final List<String> getShowPlace() {
        return this.showPlace;
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
    public final Map<String, String> getUrl() {
        return this.url;
    }

    public final void handleUrl(@Nullable Context context, @NotNull VasMarketingShowPlaceType type, @NotNull Function0<p> failCallback) {
        s.i(type, "type");
        s.i(failCallback, "failCallback");
        Map<String, String> map = this.url;
        String str = map != null ? map.get(type.name()) : null;
        if (str == null || str.length() == 0) {
            failCallback.invoke();
        } else {
            j.a.b(j.f12156c, context, str, null, 4, null);
        }
    }

    public int hashCode() {
        String str = this.title;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.subTitle;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<String> list = this.showPlace;
        int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        Map<String, String> map = this.url;
        int hashCode4 = (hashCode3 + (map == null ? 0 : map.hashCode())) * 31;
        String str3 = this.actName;
        return hashCode4 + (str3 != null ? str3.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        String str = this.title;
        String str2 = this.subTitle;
        List<String> list = this.showPlace;
        Map<String, String> map = this.url;
        return "VasMarketingPollingInfoModel(title=" + str + ", subTitle=" + str2 + ", showPlace=" + ((Object) list) + ", url=" + ((Object) map) + ", actName=" + this.actName + ")";
    }
}
