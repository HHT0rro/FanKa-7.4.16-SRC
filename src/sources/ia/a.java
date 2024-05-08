package ia;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.appgallery.marketinstallerservice.api.InstallParamSpec;
import com.huawei.appgallery.marketinstallerservice.api.MarketInfo;
import com.huawei.appgallery.marketinstallerservice.internal.framework.storekit.bean.ResponseBean;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.conn.ssl.SSLSocketFactory;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class a extends AsyncTask<Void, Integer, Void> {

    /* renamed from: a, reason: collision with root package name */
    public InterfaceC0750a f49851a;

    /* renamed from: b, reason: collision with root package name */
    public MarketInfo f49852b;

    /* renamed from: c, reason: collision with root package name */
    public String f49853c;

    /* renamed from: d, reason: collision with root package name */
    public String f49854d;

    /* renamed from: e, reason: collision with root package name */
    public String f49855e;

    /* renamed from: f, reason: collision with root package name */
    public String f49856f = null;

    /* renamed from: g, reason: collision with root package name */
    public int f49857g = 0;

    /* renamed from: h, reason: collision with root package name */
    public int f49858h = 0;

    /* renamed from: ia.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface InterfaceC0750a {
        void a(int i10, int i11);

        @NonNull
        Context b();

        void c(MarketInfo marketInfo, int i10, int i11);
    }

    public a(InterfaceC0750a interfaceC0750a, InstallParamSpec installParamSpec) {
        this.f49853c = null;
        this.f49854d = null;
        this.f49855e = null;
        this.f49851a = interfaceC0750a;
        this.f49852b = installParamSpec.getMarketInfo();
        this.f49853c = installParamSpec.getServerUrl();
        this.f49854d = installParamSpec.getSubsystem();
        this.f49855e = installParamSpec.getMarketPkg();
    }

    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Void... voidArr) {
        if (this.f49851a == null) {
            fa.a.c("MarketDownloadTask", "the callback is null error!");
            return null;
        }
        if (this.f49852b == null) {
            fa.a.d("MarketDownloadTask", "start getMarketInfo");
            z9.a newInstance = z9.a.newInstance(this.f49851a.b());
            newInstance.setServiceUrl(this.f49853c);
            newInstance.setSubsystem(this.f49854d);
            newInstance.setMarketPkg(this.f49855e);
            ResponseBean b4 = ba.a.b(newInstance);
            if (!(b4 instanceof z9.b)) {
                fa.a.c("MarketDownloadTask", "getMarketInfo error response is null!");
                this.f49857g = -1;
                publishProgress(0, 0);
                return null;
            }
            this.f49857g = b4.getResponseCode();
            int rtnCode = b4.getRtnCode();
            this.f49858h = rtnCode;
            if (this.f49857g == 0 && rtnCode == 0) {
                z9.b bVar = (z9.b) b4;
                if (bVar.getHiAppInfo() != null) {
                    this.f49852b = bVar.getHiAppInfo();
                    publishProgress(0, 0);
                }
            }
            fa.a.c("MarketDownloadTask", "getMarketInfo error: responseCode:" + this.f49857g + ", returnCode:" + this.f49857g);
            publishProgress(0, 0);
            return null;
        }
        fa.a.d("MarketDownloadTask", "allready has marketinfo!");
        publishProgress(0, 0);
        if (TextUtils.isEmpty(this.f49852b.getPkgName()) || this.f49852b.getFileSize() == 0 || TextUtils.isEmpty(this.f49852b.getSha256()) || TextUtils.isEmpty(this.f49852b.getDownUrl())) {
            fa.a.c("MarketDownloadTask", "getMarketInfo content is error!");
            publishProgress(4, 0);
            return null;
        }
        this.f49856f = y9.b.a(this.f49851a.b());
        if (g()) {
            h();
            return null;
        }
        publishProgress(2, 0);
        return null;
    }

    public final HttpURLConnection b(String str) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setReadTimeout(10000);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
        httpURLConnection.setInstanceFollowRedirects(true);
        if (httpURLConnection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            httpsURLConnection.setSSLSocketFactory(xa.b.b(this.f49851a.b()));
            httpsURLConnection.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        }
        return httpURLConnection;
    }

    @Override // android.os.AsyncTask
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onProgressUpdate(Integer... numArr) {
        if (numArr.length < 2) {
            return;
        }
        int intValue = numArr[0].intValue();
        int intValue2 = numArr[1].intValue();
        if (intValue == 0) {
            this.f49851a.c(this.f49852b, this.f49857g, this.f49858h);
            return;
        }
        if (intValue == 1 || intValue == 2 || intValue == 3 || intValue == 4 || intValue == 5) {
            this.f49851a.a(intValue, intValue2);
        }
    }

    public final boolean d() {
        String b4 = ea.a.b(this.f49856f, "SHA-256");
        if (b4 != null) {
            return b4.equalsIgnoreCase(this.f49852b.getSha256());
        }
        fa.a.e("MarketDownloadTask", "checkDownloadedFile: file hash is null");
        return false;
    }

    public final boolean e(HttpURLConnection httpURLConnection) {
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(new File(this.f49856f)));
            try {
                bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            } catch (IOException unused) {
                bufferedInputStream = null;
            } catch (Throwable th) {
                th = th;
                bufferedInputStream = null;
            }
            try {
                byte[] bArr = new byte[8192];
                long j10 = 0;
                int i10 = 0;
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read == -1) {
                        ea.a.c(bufferedInputStream);
                        ea.a.c(bufferedOutputStream2);
                        return true;
                    }
                    bufferedOutputStream2.write(bArr, 0, read);
                    j10 += read;
                    int fileSize = (int) ((100 * j10) / this.f49852b.getFileSize());
                    if (fileSize != i10) {
                        publishProgress(1, Integer.valueOf(fileSize));
                        i10 = fileSize;
                    }
                }
            } catch (IOException unused2) {
                bufferedOutputStream = bufferedOutputStream2;
                try {
                    fa.a.e("MarketDownloadTask", "AppDownloadTask readStream exception IOException!");
                    ea.a.c(bufferedInputStream);
                    ea.a.c(bufferedOutputStream);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    ea.a.c(bufferedInputStream);
                    ea.a.c(bufferedOutputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedOutputStream = bufferedOutputStream2;
                ea.a.c(bufferedInputStream);
                ea.a.c(bufferedOutputStream);
                throw th;
            }
        } catch (IOException unused3) {
            bufferedInputStream = null;
        } catch (Throwable th4) {
            th = th4;
            bufferedInputStream = null;
        }
    }

    public final HttpURLConnection f() {
        String str;
        try {
            HttpURLConnection b4 = b(this.f49852b.getDownUrl());
            b4.connect();
            int responseCode = b4.getResponseCode();
            if (responseCode == 200) {
                return b4;
            }
            fa.a.e("MarketDownloadTask", "AppDownloadTask responseCode error:" + responseCode);
            return null;
        } catch (IOException unused) {
            str = "AppDownloadTask connect IOException!";
            fa.a.e("MarketDownloadTask", str);
            return null;
        } catch (IllegalAccessException unused2) {
            str = "AppDownloadTask connect IllegalAccessException!";
            fa.a.e("MarketDownloadTask", str);
            return null;
        } catch (KeyManagementException unused3) {
            str = "AppDownloadTask connect KeyManagementException!";
            fa.a.e("MarketDownloadTask", str);
            return null;
        } catch (KeyStoreException unused4) {
            str = "AppDownloadTask connect KeyStoreException!";
            fa.a.e("MarketDownloadTask", str);
            return null;
        } catch (NoSuchAlgorithmException unused5) {
            str = "AppDownloadTask connect NoSuchAlgorithmException!";
            fa.a.e("MarketDownloadTask", str);
            return null;
        } catch (CertificateException unused6) {
            str = "AppDownloadTask connect CertificateException!";
            fa.a.e("MarketDownloadTask", str);
            return null;
        }
    }

    public final boolean g() {
        File file = new File(this.f49856f);
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
            fa.a.c("MarketDownloadTask", "createDownloadFile failed");
            return false;
        }
        if (!file.exists() || file.delete()) {
            return true;
        }
        fa.a.c("MarketDownloadTask", "createDownloadFile failed");
        return false;
    }

    public final void h() {
        HttpURLConnection f10 = f();
        if (f10 == null) {
            publishProgress(2, 0);
            return;
        }
        if (!e(f10)) {
            publishProgress(2, 0);
        } else if (d()) {
            publishProgress(3, 0);
        } else {
            fa.a.e("MarketDownloadTask", "checkDownloadedFile failed");
            publishProgress(5, 0);
        }
    }
}
