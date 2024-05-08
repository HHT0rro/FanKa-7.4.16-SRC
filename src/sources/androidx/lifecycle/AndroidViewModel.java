package androidx.lifecycle;

import android.app.Application;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: AndroidViewModel.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class AndroidViewModel extends ViewModel {

    @NotNull
    private final Application application;

    public AndroidViewModel(@NotNull Application application) {
        s.i(application, "application");
        this.application = application;
    }

    @NotNull
    public <T extends Application> T getApplication() {
        T t2 = (T) this.application;
        s.g(t2, "null cannot be cast to non-null type T of androidx.lifecycle.AndroidViewModel.getApplication");
        return t2;
    }
}
