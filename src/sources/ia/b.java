package ia;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInstaller;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import androidx.core.content.FileProvider;
import com.huawei.appgallery.marketinstallerservice.api.InstallParamSpec;
import com.huawei.appgallery.marketinstallerservice.impl.download.MarketInstallReceiver;
import com.huawei.appgallery.marketinstallerservice.ui.MarketDownloadActivity;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class b extends AsyncTask<Void, Void, Boolean> {

    /* renamed from: a, reason: collision with root package name */
    public a f49859a;

    /* renamed from: b, reason: collision with root package name */
    public InstallParamSpec f49860b;

    /* renamed from: c, reason: collision with root package name */
    public String f49861c;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface a {
        void a(boolean z10);

        Context b();
    }

    public b(a aVar) {
        this.f49860b = null;
        this.f49861c = "";
        this.f49859a = aVar;
    }

    public b(a aVar, InstallParamSpec installParamSpec, String str) {
        this.f49859a = aVar;
        this.f49860b = installParamSpec;
        this.f49861c = str;
    }

    public static Intent a(Context context) {
        Intent intent = new Intent("android.intent.action.VIEW");
        String a10 = y9.b.a(context);
        if (Build.VERSION.SDK_INT >= 24) {
            intent.setDataAndType(FileProvider.getUriForFile(context, context.getPackageName() + ".marketinstall.fileprovider", new File(a10)), "application/vnd.android.package-archive");
            intent.addFlags(1);
        } else {
            intent.setDataAndType(Uri.fromFile(new File(a10)), "application/vnd.android.package-archive");
        }
        intent.putExtra("android.intent.extra.NOT_UNKNOWN_SOURCE", true);
        intent.putExtra("android.intent.extra.RETURN_RESULT", true);
        return intent;
    }

    public static boolean f(Context context) {
        try {
        } catch (Exception unused) {
            fa.a.d("MarketInstallTask", "has not silent install permission Exception!");
        }
        if (context.getPackageManager().checkPermission("android.permission.INSTALL_PACKAGES", context.getPackageName()) == 0) {
            return true;
        }
        fa.a.d("MarketInstallTask", "has not silent install permission!");
        return false;
    }

    @Override // android.os.AsyncTask
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Boolean doInBackground(Void... voidArr) {
        PendingIntent activity;
        a aVar = this.f49859a;
        if (aVar == null) {
            fa.a.c("MarketInstallTask", "callback is null!");
        } else {
            File file = new File(y9.b.a(aVar.b()));
            if (file.exists()) {
                PackageInstaller.SessionParams sessionParams = new PackageInstaller.SessionParams(1);
                PackageInstaller packageInstaller = this.f49859a.b().getPackageManager().getPackageInstaller();
                PackageInstaller.Session session = null;
                try {
                    try {
                        int createSession = packageInstaller.createSession(sessionParams);
                        session = packageInstaller.openSession(createSession);
                        boolean e2 = e(file, session);
                        if (e2) {
                            InstallParamSpec installParamSpec = this.f49860b;
                            if (installParamSpec == null || !installParamSpec.isSilentDownload()) {
                                activity = PendingIntent.getActivity(this.f49859a.b(), createSession, new Intent(this.f49859a.b(), (Class<?>) MarketDownloadActivity.class), 134217728);
                            } else {
                                Intent intent = new Intent(this.f49859a.b(), (Class<?>) MarketInstallReceiver.class);
                                intent.putExtra("callback_key", this.f49861c);
                                activity = PendingIntent.getBroadcast(this.f49859a.b(), createSession, intent, 134217728);
                            }
                            session.commit(activity.getIntentSender());
                        }
                        Boolean valueOf = Boolean.valueOf(e2);
                        if (session != null) {
                            session.close();
                        }
                        return valueOf;
                    } catch (Exception unused) {
                        fa.a.c("MarketInstallTask", "start install Exception!");
                        Boolean bool = Boolean.FALSE;
                        if (session != null) {
                            session.close();
                        }
                        return bool;
                    }
                } catch (Throwable th) {
                    if (session != null) {
                        session.close();
                    }
                    throw th;
                }
            }
            fa.a.d("MarketInstallTask", "download file is empty!");
        }
        return Boolean.FALSE;
    }

    public final void c(InputStream inputStream, OutputStream outputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
                fa.a.d("MarketInstallTask", "fis close Exception");
            }
        }
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException unused2) {
                fa.a.d("MarketInstallTask", "fos close Exception");
            }
        }
    }

    @Override // android.os.AsyncTask
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Boolean bool) {
        super.onPostExecute(bool);
        fa.a.d("MarketInstallTask", "start install task result:" + ((Object) bool));
        a aVar = this.f49859a;
        if (aVar != null) {
            aVar.a(bool.booleanValue());
        }
    }

    public final boolean e(File file, PackageInstaller.Session session) {
        OutputStream outputStream;
        byte[] bArr = new byte[131072];
        FileInputStream fileInputStream = null;
        r2 = null;
        OutputStream outputStream2 = null;
        fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                outputStream2 = session.openWrite("MarketInstallService", 0L, file.length());
                while (true) {
                    int read = fileInputStream2.read(bArr);
                    if (read == -1) {
                        session.fsync(outputStream2);
                        c(fileInputStream2, outputStream2);
                        return true;
                    }
                    outputStream2.write(bArr, 0, read);
                }
            } catch (IOException e2) {
                e = e2;
                outputStream = outputStream2;
                fileInputStream = fileInputStream2;
                try {
                    fa.a.b("MarketInstallTask", "copyApk apk error", e);
                    c(fileInputStream, outputStream);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    c(fileInputStream, outputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                outputStream = outputStream2;
                fileInputStream = fileInputStream2;
                c(fileInputStream, outputStream);
                throw th;
            }
        } catch (IOException e10) {
            e = e10;
            outputStream = null;
        } catch (Throwable th3) {
            th = th3;
            outputStream = null;
        }
    }
}
