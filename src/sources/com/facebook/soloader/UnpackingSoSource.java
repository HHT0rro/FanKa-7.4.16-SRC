package com.facebook.soloader;

import android.content.Context;
import android.os.Parcel;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class UnpackingSoSource extends DirectorySoSource {
    private static final String DEPS_FILE_NAME = "dso_deps";
    private static final String LOCK_FILE_NAME = "dso_lock";
    private static final String MANIFEST_FILE_NAME = "dso_manifest";
    private static final byte MANIFEST_VERSION = 1;
    private static final byte STATE_CLEAN = 1;
    private static final byte STATE_DIRTY = 0;
    private static final String STATE_FILE_NAME = "dso_state";
    private static final String TAG = "fb-UnpackingSoSource";
    private String[] mAbis;
    public final Context mContext;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class Dso {
        public final String hash;
        public final String name;

        public Dso(String str, String str2) {
            this.name = str;
            this.hash = str2;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class DsoManifest {
        public final Dso[] dsos;

        public DsoManifest(Dso[] dsoArr) {
            this.dsos = dsoArr;
        }

        public static final DsoManifest read(DataInput dataInput) throws IOException {
            if (dataInput.readByte() == 1) {
                int readInt = dataInput.readInt();
                if (readInt >= 0) {
                    Dso[] dsoArr = new Dso[readInt];
                    for (int i10 = 0; i10 < readInt; i10++) {
                        dsoArr[i10] = new Dso(dataInput.readUTF(), dataInput.readUTF());
                    }
                    return new DsoManifest(dsoArr);
                }
                throw new RuntimeException("illegal number of shared libraries");
            }
            throw new RuntimeException("wrong dso manifest version");
        }

        public final void write(DataOutput dataOutput) throws IOException {
            dataOutput.writeByte(1);
            dataOutput.writeInt(this.dsos.length);
            int i10 = 0;
            while (true) {
                Dso[] dsoArr = this.dsos;
                if (i10 >= dsoArr.length) {
                    return;
                }
                dataOutput.writeUTF(dsoArr[i10].name);
                dataOutput.writeUTF(this.dsos[i10].hash);
                i10++;
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class InputDso implements Closeable {
        public final InputStream content;
        public final Dso dso;

        public InputDso(Dso dso, InputStream inputStream) {
            this.dso = dso;
            this.content = inputStream;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.content.close();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static abstract class InputDsoIterator implements Closeable {
        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        public abstract boolean hasNext();

        public abstract InputDso next() throws IOException;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static abstract class Unpacker implements Closeable {
        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        public abstract DsoManifest getDsoManifest() throws IOException;

        public abstract InputDsoIterator openDsoIterator() throws IOException;
    }

    public UnpackingSoSource(Context context, String str) {
        super(getSoStorePath(context, str), 1);
        this.mContext = context;
    }

    private void deleteUnmentionedFiles(Dso[] dsoArr) throws IOException {
        String[] list = this.soDirectory.list();
        if (list != null) {
            for (String str : list) {
                if (!str.equals(STATE_FILE_NAME) && !str.equals(LOCK_FILE_NAME) && !str.equals(DEPS_FILE_NAME) && !str.equals(MANIFEST_FILE_NAME)) {
                    boolean z10 = false;
                    for (int i10 = 0; !z10 && i10 < dsoArr.length; i10++) {
                        if (dsoArr[i10].name.equals(str)) {
                            z10 = true;
                        }
                    }
                    if (!z10) {
                        File file = new File(this.soDirectory, str);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("deleting unaccounted-for file ");
                        sb2.append((Object) file);
                        SysUtil.dumbDeleteRecursive(file);
                    }
                }
            }
            return;
        }
        throw new IOException("unable to list directory " + ((Object) this.soDirectory));
    }

    private void extractDso(InputDso inputDso, byte[] bArr) throws IOException {
        RandomAccessFile randomAccessFile;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("extracting DSO ");
        sb2.append(inputDso.dso.name);
        if (this.soDirectory.setWritable(true, true)) {
            File file = new File(this.soDirectory, inputDso.dso.name);
            try {
                randomAccessFile = new RandomAccessFile(file, "rw");
            } catch (IOException unused) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("error overwriting ");
                sb3.append((Object) file);
                sb3.append(" trying to delete and start over");
                SysUtil.dumbDeleteRecursive(file);
                randomAccessFile = new RandomAccessFile(file, "rw");
            }
            try {
                int available = inputDso.content.available();
                if (available > 1) {
                    SysUtil.fallocateIfSupported(randomAccessFile.getFD(), available);
                }
                SysUtil.copyBytes(randomAccessFile, inputDso.content, Integer.MAX_VALUE, bArr);
                randomAccessFile.setLength(randomAccessFile.getFilePointer());
                if (file.setExecutable(true, false)) {
                    return;
                }
                throw new IOException("cannot make file executable: " + ((Object) file));
            } finally {
                randomAccessFile.close();
            }
        }
        throw new IOException("cannot make directory writable for us: " + ((Object) this.soDirectory));
    }

    public static File getSoStorePath(Context context, String str) {
        return new File(context.getApplicationInfo().dataDir + "/" + str);
    }

    private boolean refreshLocked(final FileLocker fileLocker, int i10, final byte[] bArr) throws IOException {
        byte b4;
        DsoManifest dsoManifest;
        final File file = new File(this.soDirectory, STATE_FILE_NAME);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        try {
            b4 = randomAccessFile.readByte();
        } catch (EOFException unused) {
        } catch (Throwable th) {
            try {
                throw th;
            } finally {
            }
        }
        if (b4 != 1) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("dso store ");
            sb2.append((Object) this.soDirectory);
            sb2.append(" regeneration interrupted: wiping clean");
            b4 = 0;
        }
        randomAccessFile.close();
        final File file2 = new File(this.soDirectory, DEPS_FILE_NAME);
        randomAccessFile = new RandomAccessFile(file2, "rw");
        try {
            int length = (int) randomAccessFile.length();
            byte[] bArr2 = new byte[length];
            if (randomAccessFile.read(bArr2) != length) {
                b4 = 0;
            }
            if (!Arrays.equals(bArr2, bArr)) {
                b4 = 0;
            }
            if (b4 == 0) {
                writeState(file, (byte) 0);
                Unpacker makeUnpacker = makeUnpacker();
                try {
                    DsoManifest dsoManifest2 = makeUnpacker.getDsoManifest();
                    InputDsoIterator openDsoIterator = makeUnpacker.openDsoIterator();
                    try {
                        regenerate(b4, dsoManifest2, openDsoIterator);
                        if (openDsoIterator != null) {
                            openDsoIterator.close();
                        }
                        makeUnpacker.close();
                        dsoManifest = dsoManifest2;
                    } finally {
                    }
                } finally {
                }
            } else {
                dsoManifest = null;
            }
            randomAccessFile.close();
            if (dsoManifest == null) {
                return false;
            }
            final DsoManifest dsoManifest3 = dsoManifest;
            Runnable runnable = new Runnable() { // from class: com.facebook.soloader.UnpackingSoSource.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        try {
                            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, "rw");
                            try {
                                randomAccessFile2.write(bArr);
                                randomAccessFile2.setLength(randomAccessFile2.getFilePointer());
                                randomAccessFile2.close();
                                randomAccessFile2 = new RandomAccessFile(new File(UnpackingSoSource.this.soDirectory, UnpackingSoSource.MANIFEST_FILE_NAME), "rw");
                                try {
                                    dsoManifest3.write(randomAccessFile2);
                                    randomAccessFile2.close();
                                    SysUtil.fsyncRecursive(UnpackingSoSource.this.soDirectory);
                                    UnpackingSoSource.writeState(file, (byte) 1);
                                } finally {
                                }
                            } finally {
                                try {
                                    throw th;
                                } finally {
                                }
                            }
                        } finally {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("releasing dso store lock for ");
                            sb3.append((Object) UnpackingSoSource.this.soDirectory);
                            sb3.append(" (from syncer thread)");
                            fileLocker.close();
                        }
                    } catch (IOException e2) {
                        throw new RuntimeException(e2);
                    }
                }
            };
            if ((i10 & 1) != 0) {
                new Thread(runnable, "SoSync:" + this.soDirectory.getName()).start();
            } else {
                runnable.run();
            }
            return true;
        } catch (Throwable th2) {
            try {
                throw th2;
            } finally {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004a A[Catch: all -> 0x002d, TRY_LEAVE, TryCatch #5 {all -> 0x002d, blocks: (B:66:0x0028, B:6:0x0033, B:7:0x003a, B:8:0x0044, B:10:0x004a, B:30:0x0090, B:43:0x008d, B:49:0x008a, B:38:0x0081, B:46:0x0085, B:14:0x0052, B:16:0x0057, B:18:0x0065, B:22:0x0076, B:27:0x007d), top: B:65:0x0028, inners: #1, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0033 A[Catch: all -> 0x002d, TRY_ENTER, TryCatch #5 {all -> 0x002d, blocks: (B:66:0x0028, B:6:0x0033, B:7:0x003a, B:8:0x0044, B:10:0x004a, B:30:0x0090, B:43:0x008d, B:49:0x008a, B:38:0x0081, B:46:0x0085, B:14:0x0052, B:16:0x0057, B:18:0x0065, B:22:0x0076, B:27:0x007d), top: B:65:0x0028, inners: #1, #3, #4 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void regenerate(byte r9, com.facebook.soloader.UnpackingSoSource.DsoManifest r10, com.facebook.soloader.UnpackingSoSource.InputDsoIterator r11) throws java.io.IOException {
        /*
            r8 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "regenerating DSO store "
            r0.append(r1)
            java.lang.Class r1 = r8.getClass()
            java.lang.String r1 = r1.getName()
            r0.append(r1)
            java.io.File r0 = new java.io.File
            java.io.File r1 = r8.soDirectory
            java.lang.String r2 = "dso_manifest"
            r0.<init>(r1, r2)
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile
            java.lang.String r2 = "rw"
            r1.<init>(r0, r2)
            r0 = 1
            if (r9 != r0) goto L2f
            com.facebook.soloader.UnpackingSoSource$DsoManifest r9 = com.facebook.soloader.UnpackingSoSource.DsoManifest.read(r1)     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
            goto L30
        L2d:
            r9 = move-exception
            goto L98
        L2f:
            r9 = 0
        L30:
            r2 = 0
            if (r9 != 0) goto L3a
            com.facebook.soloader.UnpackingSoSource$DsoManifest r9 = new com.facebook.soloader.UnpackingSoSource$DsoManifest     // Catch: java.lang.Throwable -> L2d
            com.facebook.soloader.UnpackingSoSource$Dso[] r3 = new com.facebook.soloader.UnpackingSoSource.Dso[r2]     // Catch: java.lang.Throwable -> L2d
            r9.<init>(r3)     // Catch: java.lang.Throwable -> L2d
        L3a:
            com.facebook.soloader.UnpackingSoSource$Dso[] r10 = r10.dsos     // Catch: java.lang.Throwable -> L2d
            r8.deleteUnmentionedFiles(r10)     // Catch: java.lang.Throwable -> L2d
            r10 = 32768(0x8000, float:4.5918E-41)
            byte[] r10 = new byte[r10]     // Catch: java.lang.Throwable -> L2d
        L44:
            boolean r3 = r11.hasNext()     // Catch: java.lang.Throwable -> L2d
            if (r3 == 0) goto L94
            com.facebook.soloader.UnpackingSoSource$InputDso r3 = r11.next()     // Catch: java.lang.Throwable -> L2d
            r4 = 1
            r5 = 0
        L50:
            if (r4 == 0) goto L7b
            com.facebook.soloader.UnpackingSoSource$Dso[] r6 = r9.dsos     // Catch: java.lang.Throwable -> L79
            int r7 = r6.length     // Catch: java.lang.Throwable -> L79
            if (r5 >= r7) goto L7b
            r6 = r6[r5]     // Catch: java.lang.Throwable -> L79
            java.lang.String r6 = r6.name     // Catch: java.lang.Throwable -> L79
            com.facebook.soloader.UnpackingSoSource$Dso r7 = r3.dso     // Catch: java.lang.Throwable -> L79
            java.lang.String r7 = r7.name     // Catch: java.lang.Throwable -> L79
            boolean r6 = r6.equals(r7)     // Catch: java.lang.Throwable -> L79
            if (r6 == 0) goto L76
            com.facebook.soloader.UnpackingSoSource$Dso[] r6 = r9.dsos     // Catch: java.lang.Throwable -> L79
            r6 = r6[r5]     // Catch: java.lang.Throwable -> L79
            java.lang.String r6 = r6.hash     // Catch: java.lang.Throwable -> L79
            com.facebook.soloader.UnpackingSoSource$Dso r7 = r3.dso     // Catch: java.lang.Throwable -> L79
            java.lang.String r7 = r7.hash     // Catch: java.lang.Throwable -> L79
            boolean r6 = r6.equals(r7)     // Catch: java.lang.Throwable -> L79
            if (r6 == 0) goto L76
            r4 = 0
        L76:
            int r5 = r5 + 1
            goto L50
        L79:
            r9 = move-exception
            goto L81
        L7b:
            if (r4 == 0) goto L8e
            r8.extractDso(r3, r10)     // Catch: java.lang.Throwable -> L79
            goto L8e
        L81:
            throw r9     // Catch: java.lang.Throwable -> L82
        L82:
            r10 = move-exception
            if (r3 == 0) goto L8d
            r3.close()     // Catch: java.lang.Throwable -> L89
            goto L8d
        L89:
            r11 = move-exception
            r9.addSuppressed(r11)     // Catch: java.lang.Throwable -> L2d
        L8d:
            throw r10     // Catch: java.lang.Throwable -> L2d
        L8e:
            if (r3 == 0) goto L44
            r3.close()     // Catch: java.lang.Throwable -> L2d
            goto L44
        L94:
            r1.close()
            return
        L98:
            throw r9     // Catch: java.lang.Throwable -> L99
        L99:
            r10 = move-exception
            r1.close()     // Catch: java.lang.Throwable -> L9e
            goto La2
        L9e:
            r11 = move-exception
            r9.addSuppressed(r11)
        La2:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.UnpackingSoSource.regenerate(byte, com.facebook.soloader.UnpackingSoSource$DsoManifest, com.facebook.soloader.UnpackingSoSource$InputDsoIterator):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void writeState(File file, byte b4) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        try {
            randomAccessFile.seek(0L);
            randomAccessFile.write(b4);
            randomAccessFile.setLength(randomAccessFile.getFilePointer());
            randomAccessFile.getFD().sync();
            randomAccessFile.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    randomAccessFile.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    public byte[] getDepsBlock() throws IOException {
        Parcel obtain = Parcel.obtain();
        Unpacker makeUnpacker = makeUnpacker();
        try {
            Dso[] dsoArr = makeUnpacker.getDsoManifest().dsos;
            obtain.writeByte((byte) 1);
            obtain.writeInt(dsoArr.length);
            for (int i10 = 0; i10 < dsoArr.length; i10++) {
                obtain.writeString(dsoArr[i10].name);
                obtain.writeString(dsoArr[i10].hash);
            }
            makeUnpacker.close();
            byte[] marshall = obtain.marshall();
            obtain.recycle();
            return marshall;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (makeUnpacker != null) {
                    try {
                        makeUnpacker.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    @Override // com.facebook.soloader.SoSource
    public String[] getSoSourceAbis() {
        String[] strArr = this.mAbis;
        return strArr == null ? super.getSoSourceAbis() : strArr;
    }

    public abstract Unpacker makeUnpacker() throws IOException;

    @Override // com.facebook.soloader.SoSource
    public void prepare(int i10) throws IOException {
        SysUtil.mkdirOrThrow(this.soDirectory);
        FileLocker lock = FileLocker.lock(new File(this.soDirectory, LOCK_FILE_NAME));
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("locked dso store ");
            sb2.append((Object) this.soDirectory);
            if (refreshLocked(lock, i10, getDepsBlock())) {
                lock = null;
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("dso store is up-to-date: ");
                sb3.append((Object) this.soDirectory);
            }
        } finally {
            if (lock != null) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("releasing dso store lock for ");
                sb4.append((Object) this.soDirectory);
                lock.close();
            } else {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("not releasing dso store lock for ");
                sb5.append((Object) this.soDirectory);
                sb5.append(" (syncer thread started)");
            }
        }
    }

    public void setSoSourceAbis(String[] strArr) {
        this.mAbis = strArr;
    }
}
