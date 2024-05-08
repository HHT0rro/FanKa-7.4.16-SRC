package com.cupidapp.live.base.livedata;

import kotlin.d;
import org.jetbrains.annotations.Nullable;

/* compiled from: Event.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class Event<T> {
    private final T content;
    private boolean hasBeenHandled;

    public Event(T t2) {
        this.content = t2;
    }

    public static /* synthetic */ void getHasBeenHandled$annotations() {
    }

    @Nullable
    public final T getContentIfNotHandled() {
        if (this.hasBeenHandled) {
            return null;
        }
        this.hasBeenHandled = true;
        return this.content;
    }

    public final boolean getHasBeenHandled() {
        return this.hasBeenHandled;
    }

    public final T peekContent() {
        return this.content;
    }
}
