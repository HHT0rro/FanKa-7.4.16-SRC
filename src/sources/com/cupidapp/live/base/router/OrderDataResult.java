package com.cupidapp.live.base.router;

import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AliypayHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class OrderDataResult {
    private final long balance;

    @NotNull
    private final OrderModel order;

    public OrderDataResult(@NotNull OrderModel order, long j10) {
        s.i(order, "order");
        this.order = order;
        this.balance = j10;
    }

    public static /* synthetic */ OrderDataResult copy$default(OrderDataResult orderDataResult, OrderModel orderModel, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            orderModel = orderDataResult.order;
        }
        if ((i10 & 2) != 0) {
            j10 = orderDataResult.balance;
        }
        return orderDataResult.copy(orderModel, j10);
    }

    @NotNull
    public final OrderModel component1() {
        return this.order;
    }

    public final long component2() {
        return this.balance;
    }

    @NotNull
    public final OrderDataResult copy(@NotNull OrderModel order, long j10) {
        s.i(order, "order");
        return new OrderDataResult(order, j10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OrderDataResult)) {
            return false;
        }
        OrderDataResult orderDataResult = (OrderDataResult) obj;
        return s.d(this.order, orderDataResult.order) && this.balance == orderDataResult.balance;
    }

    public final long getBalance() {
        return this.balance;
    }

    @NotNull
    public final OrderModel getOrder() {
        return this.order;
    }

    public int hashCode() {
        return (this.order.hashCode() * 31) + b2.a.a(this.balance);
    }

    @NotNull
    public String toString() {
        OrderModel orderModel = this.order;
        return "OrderDataResult(order=" + ((Object) orderModel) + ", balance=" + this.balance + ")";
    }
}
