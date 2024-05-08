package com.google.android.datatransport;

import androidx.annotation.Nullable;
import com.alipay.sdk.util.i;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
final class AutoValue_Event<T> extends Event<T> {
    private final Integer code;
    private final T payload;
    private final Priority priority;

    public AutoValue_Event(@Nullable Integer num, T t2, Priority priority) {
        this.code = num;
        Objects.requireNonNull(t2, "Null payload");
        this.payload = t2;
        Objects.requireNonNull(priority, "Null priority");
        this.priority = priority;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Event)) {
            return false;
        }
        Event event = (Event) obj;
        Integer num = this.code;
        if (num != null ? num.equals(event.getCode()) : event.getCode() == null) {
            if (this.payload.equals(event.getPayload()) && this.priority.equals(event.getPriority())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.datatransport.Event
    @Nullable
    public Integer getCode() {
        return this.code;
    }

    @Override // com.google.android.datatransport.Event
    public T getPayload() {
        return this.payload;
    }

    @Override // com.google.android.datatransport.Event
    public Priority getPriority() {
        return this.priority;
    }

    public int hashCode() {
        Integer num = this.code;
        return (((((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003) ^ this.payload.hashCode()) * 1000003) ^ this.priority.hashCode();
    }

    public String toString() {
        return "Event{code=" + ((Object) this.code) + ", payload=" + ((Object) this.payload) + ", priority=" + ((Object) this.priority) + i.f4738d;
    }
}
