package io.reactivex.disposables;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Action;
import io.reactivex.internal.util.ExceptionHelper;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class ActionDisposable extends ReferenceDisposable<Action> {
    private static final long serialVersionUID = -8219729196779211169L;

    public ActionDisposable(Action action) {
        super(action);
    }

    @Override // io.reactivex.disposables.ReferenceDisposable
    public void onDisposed(@NonNull Action action) {
        try {
            action.run();
        } catch (Throwable th) {
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }
}
