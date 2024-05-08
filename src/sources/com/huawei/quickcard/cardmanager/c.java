package com.huawei.quickcard.cardmanager;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.quickcard.cardmanager.bean.CardBean;
import com.huawei.quickcard.cardmanager.bean.CardMeta;
import com.huawei.quickcard.cardmanager.log.ManagerLogUtil;
import com.huawei.quickcard.cardmanager.storage.ICardStorageManager;
import com.huawei.quickcard.cardmanager.util.CardUriUtils;
import com.huawei.quickcard.cardmanager.util.FileUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class c implements ICardStorageManager {

    /* renamed from: b, reason: collision with root package name */
    private static final String f33533b = "CardStorageManagerImpl";

    /* renamed from: a, reason: collision with root package name */
    private final String f33534a;

    public c(@NonNull Context context) {
        this.f33534a = ((Object) context.getFilesDir()) + "/card/";
    }

    private void a(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            a(listFiles);
        }
    }

    private void b(CardBean cardBean) {
        FileOutputStream fileOutputStream;
        ObjectOutputStream objectOutputStream;
        ObjectOutputStream objectOutputStream2 = null;
        try {
            try {
                File a10 = a(cardBean);
                fileOutputStream = FileUtils.openOutputStream(a10, false);
                try {
                    objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(fileOutputStream));
                    try {
                        objectOutputStream.writeObject(cardBean);
                        objectOutputStream.flush();
                        ManagerLogUtil.i(f33533b, "write card file success: " + a10.getName());
                    } catch (IOException e2) {
                        e = e2;
                        objectOutputStream2 = objectOutputStream;
                        ManagerLogUtil.e(f33533b, "IOException occurred: " + e.getMessage());
                        objectOutputStream = objectOutputStream2;
                        FileUtils.closeQuietly(objectOutputStream);
                        FileUtils.closeQuietly(fileOutputStream);
                    } catch (Exception e10) {
                        e = e10;
                        objectOutputStream2 = objectOutputStream;
                        ManagerLogUtil.e(f33533b, "write file exception occurred: " + e.getMessage());
                        objectOutputStream = objectOutputStream2;
                        FileUtils.closeQuietly(objectOutputStream);
                        FileUtils.closeQuietly(fileOutputStream);
                    } catch (Throwable th) {
                        th = th;
                        objectOutputStream2 = objectOutputStream;
                        FileUtils.closeQuietly(objectOutputStream2);
                        FileUtils.closeQuietly(fileOutputStream);
                        throw th;
                    }
                } catch (IOException e11) {
                    e = e11;
                } catch (Exception e12) {
                    e = e12;
                }
            } catch (IOException e13) {
                e = e13;
                fileOutputStream = null;
            } catch (Exception e14) {
                e = e14;
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
            FileUtils.closeQuietly(objectOutputStream);
            FileUtils.closeQuietly(fileOutputStream);
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private List<CardMeta> c(File file) {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            ManagerLogUtil.w(f33533b, "no card file.");
            return arrayList;
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                arrayList.addAll(c(file2));
            } else {
                CardBean b4 = b(file2);
                if (!TextUtils.isEmpty(b4.getSign())) {
                    arrayList.add(new CardMeta(b4.getCardId(), b4.getMinPlatformVersion(), b4.getVer(), b4.getType(), b4.getSign()));
                }
            }
        }
        return arrayList;
    }

    private List<String> d(File file) {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            ManagerLogUtil.w(f33533b, "no card file.");
            return arrayList;
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                arrayList.addAll(d(file2));
            } else {
                CardBean b4 = b(file2);
                if (!TextUtils.isEmpty(b4.getSign())) {
                    arrayList.add(b4.getSign());
                }
            }
        }
        return arrayList;
    }

    @Override // com.huawei.quickcard.cardmanager.storage.ICardStorageManager
    @Nullable
    public CardBean getCard(@NonNull CardBean cardBean) {
        File a10 = a(cardBean);
        if (a10.exists()) {
            return b(a10);
        }
        ManagerLogUtil.w(f33533b, "card file not exist: " + a10.getName());
        return null;
    }

    @Override // com.huawei.quickcard.cardmanager.storage.ICardStorageManager
    @NonNull
    public List<CardMeta> getCardMetaInfo() {
        return c(new File(this.f33534a));
    }

    @Override // com.huawei.quickcard.cardmanager.storage.ICardStorageManager
    @NonNull
    public List<String> getCardSignList() {
        return d(new File(this.f33534a));
    }

    @Override // com.huawei.quickcard.cardmanager.storage.ICardStorageManager
    public boolean hasCard(@NonNull String str) {
        return a(CardUriUtils.parse(str)).exists();
    }

    @Override // com.huawei.quickcard.cardmanager.storage.ICardStorageManager
    public void putCard(@NonNull CardBean cardBean) {
        b(cardBean);
    }

    @Override // com.huawei.quickcard.cardmanager.storage.ICardStorageManager
    public void removeAllCard() {
        ManagerLogUtil.i(f33533b, "remove all cards");
        a(new File(this.f33534a));
    }

    @Override // com.huawei.quickcard.cardmanager.storage.ICardStorageManager
    public void removeCard(@NonNull String str) {
        ManagerLogUtil.i(f33533b, "removeCard cardUri: " + str);
        File a10 = a(CardUriUtils.parse(str));
        if (a10.exists() && a10.delete()) {
            ManagerLogUtil.i(f33533b, "card file delete success: " + a10.getName());
            return;
        }
        ManagerLogUtil.e(f33533b, "card file not exist: " + a10.getName());
    }

    private File a(CardBean cardBean) {
        return new File(this.f33534a + cardBean.getType(), CardUriUtils.getCardName(cardBean));
    }

    private void a(@NonNull File[] fileArr) {
        for (File file : fileArr) {
            if (file.isDirectory()) {
                a(file);
            } else if (!file.delete()) {
                ManagerLogUtil.e(f33533b, "delete file failed: " + file.getName());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12, types: [java.io.Closeable, java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r7v8 */
    private CardBean b(File file) {
        Throwable th;
        Exception e2;
        IOException e10;
        Closeable closeable;
        ObjectInputStream objectInputStream = null;
        try {
            try {
                file = FileUtils.openInputStream(file);
                try {
                    ObjectInputStream objectInputStream2 = new ObjectInputStream(new BufferedInputStream(file));
                    try {
                        CardBean cardBean = (CardBean) objectInputStream2.readObject();
                        FileUtils.closeQuietly(objectInputStream2);
                        FileUtils.closeQuietly(file);
                        return cardBean;
                    } catch (IOException e11) {
                        e10 = e11;
                        objectInputStream = objectInputStream2;
                        ManagerLogUtil.e(f33533b, "IOException occurred: " + e10.getMessage());
                        closeable = file;
                        FileUtils.closeQuietly(objectInputStream);
                        FileUtils.closeQuietly(closeable);
                        return new CardBean();
                    } catch (Exception e12) {
                        e2 = e12;
                        objectInputStream = objectInputStream2;
                        ManagerLogUtil.e(f33533b, "write file exception occurred: " + e2.getMessage());
                        closeable = file;
                        FileUtils.closeQuietly(objectInputStream);
                        FileUtils.closeQuietly(closeable);
                        return new CardBean();
                    } catch (Throwable th2) {
                        th = th2;
                        objectInputStream = objectInputStream2;
                        FileUtils.closeQuietly(objectInputStream);
                        FileUtils.closeQuietly(file);
                        throw th;
                    }
                } catch (IOException e13) {
                    e10 = e13;
                } catch (Exception e14) {
                    e2 = e14;
                }
            } catch (IOException e15) {
                e10 = e15;
                file = 0;
            } catch (Exception e16) {
                e2 = e16;
                file = 0;
            } catch (Throwable th3) {
                th = th3;
                file = 0;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }
}
