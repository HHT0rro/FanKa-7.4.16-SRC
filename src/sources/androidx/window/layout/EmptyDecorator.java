package androidx.window.layout;

import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: WindowInfoTracker.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
final class EmptyDecorator implements WindowInfoTrackerDecorator {

    @NotNull
    public static final EmptyDecorator INSTANCE = new EmptyDecorator();

    private EmptyDecorator() {
    }

    @Override // androidx.window.layout.WindowInfoTrackerDecorator
    @NotNull
    public WindowInfoTracker decorate(@NotNull WindowInfoTracker tracker) {
        s.i(tracker, "tracker");
        return tracker;
    }
}
