package com.cupidapp.live.base.livedata;

import androidx.lifecycle.Observer;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: Event.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class EventObserver<T> implements Observer<Event<? extends T>> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final Function1<T, p> f11864a;

    /* JADX WARN: Multi-variable type inference failed */
    public EventObserver(@NotNull Function1<? super T, p> onEventUnhandledContent) {
        s.i(onEventUnhandledContent, "onEventUnhandledContent");
        this.f11864a = onEventUnhandledContent;
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onChanged(@NotNull Event<? extends T> event) {
        s.i(event, "event");
        T contentIfNotHandled = event.getContentIfNotHandled();
        if (contentIfNotHandled != null) {
            this.f11864a.invoke(contentIfNotHandled);
        }
    }
}
