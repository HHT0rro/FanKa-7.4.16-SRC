package l;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.airbnb.lottie.network.DefaultLottieFetchResult;
import com.airbnb.lottie.network.LottieFetchResult;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: DefaultLottieNetworkFetcher.java */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class a implements c {
    @Override // l.c
    @NonNull
    public LottieFetchResult a(@NonNull String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.connect();
        return new DefaultLottieFetchResult(httpURLConnection);
    }
}
