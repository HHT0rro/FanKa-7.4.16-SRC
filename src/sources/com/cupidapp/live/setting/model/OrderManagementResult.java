package com.cupidapp.live.setting.model;

import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: OrderManagementResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class OrderManagementResult implements Serializable {

    @NotNull
    private final String subscriptionDescription;

    @NotNull
    private final String subscriptionRenewUrl;

    public OrderManagementResult(@NotNull String subscriptionRenewUrl, @NotNull String subscriptionDescription) {
        s.i(subscriptionRenewUrl, "subscriptionRenewUrl");
        s.i(subscriptionDescription, "subscriptionDescription");
        this.subscriptionRenewUrl = subscriptionRenewUrl;
        this.subscriptionDescription = subscriptionDescription;
    }

    public static /* synthetic */ OrderManagementResult copy$default(OrderManagementResult orderManagementResult, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = orderManagementResult.subscriptionRenewUrl;
        }
        if ((i10 & 2) != 0) {
            str2 = orderManagementResult.subscriptionDescription;
        }
        return orderManagementResult.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.subscriptionRenewUrl;
    }

    @NotNull
    public final String component2() {
        return this.subscriptionDescription;
    }

    @NotNull
    public final OrderManagementResult copy(@NotNull String subscriptionRenewUrl, @NotNull String subscriptionDescription) {
        s.i(subscriptionRenewUrl, "subscriptionRenewUrl");
        s.i(subscriptionDescription, "subscriptionDescription");
        return new OrderManagementResult(subscriptionRenewUrl, subscriptionDescription);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OrderManagementResult)) {
            return false;
        }
        OrderManagementResult orderManagementResult = (OrderManagementResult) obj;
        return s.d(this.subscriptionRenewUrl, orderManagementResult.subscriptionRenewUrl) && s.d(this.subscriptionDescription, orderManagementResult.subscriptionDescription);
    }

    @NotNull
    public final String getSubscriptionDescription() {
        return this.subscriptionDescription;
    }

    @NotNull
    public final String getSubscriptionRenewUrl() {
        return this.subscriptionRenewUrl;
    }

    public int hashCode() {
        return (this.subscriptionRenewUrl.hashCode() * 31) + this.subscriptionDescription.hashCode();
    }

    @NotNull
    public String toString() {
        return "OrderManagementResult(subscriptionRenewUrl=" + this.subscriptionRenewUrl + ", subscriptionDescription=" + this.subscriptionDescription + ")";
    }
}
