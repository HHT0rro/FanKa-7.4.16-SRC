package l;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.airbnb.lottie.network.LottieFetchResult;
import java.io.IOException;

/* compiled from: LottieNetworkFetcher.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface c {
    @NonNull
    @WorkerThread
    LottieFetchResult a(@NonNull String str) throws IOException;
}
