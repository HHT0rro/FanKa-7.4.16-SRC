package com.cupidapp.live.consult.model;

import java.io.Serializable;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConsultLiveModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConsultConnectAgreementModel implements Serializable {

    @NotNull
    private final String content;

    @NotNull
    private final Map<String, String> linkDict;

    public ConsultConnectAgreementModel(@NotNull Map<String, String> linkDict, @NotNull String content) {
        s.i(linkDict, "linkDict");
        s.i(content, "content");
        this.linkDict = linkDict;
        this.content = content;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ConsultConnectAgreementModel copy$default(ConsultConnectAgreementModel consultConnectAgreementModel, Map map, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            map = consultConnectAgreementModel.linkDict;
        }
        if ((i10 & 2) != 0) {
            str = consultConnectAgreementModel.content;
        }
        return consultConnectAgreementModel.copy(map, str);
    }

    @NotNull
    public final Map<String, String> component1() {
        return this.linkDict;
    }

    @NotNull
    public final String component2() {
        return this.content;
    }

    @NotNull
    public final ConsultConnectAgreementModel copy(@NotNull Map<String, String> linkDict, @NotNull String content) {
        s.i(linkDict, "linkDict");
        s.i(content, "content");
        return new ConsultConnectAgreementModel(linkDict, content);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConsultConnectAgreementModel)) {
            return false;
        }
        ConsultConnectAgreementModel consultConnectAgreementModel = (ConsultConnectAgreementModel) obj;
        return s.d(this.linkDict, consultConnectAgreementModel.linkDict) && s.d(this.content, consultConnectAgreementModel.content);
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    @NotNull
    public final Map<String, String> getLinkDict() {
        return this.linkDict;
    }

    public int hashCode() {
        return (this.linkDict.hashCode() * 31) + this.content.hashCode();
    }

    @NotNull
    public String toString() {
        Map<String, String> map = this.linkDict;
        return "ConsultConnectAgreementModel(linkDict=" + ((Object) map) + ", content=" + this.content + ")";
    }
}
