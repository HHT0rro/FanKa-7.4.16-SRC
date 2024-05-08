package com.google.common.io;

import com.google.common.base.p;
import java.io.File;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
enum Files$FilePredicate implements p<File> {
    IS_DIRECTORY { // from class: com.google.common.io.Files$FilePredicate.1
        @Override // java.lang.Enum
        public String toString() {
            return "Files.isDirectory()";
        }

        @Override // com.google.common.io.Files$FilePredicate, com.google.common.base.p
        public boolean apply(File file) {
            return file.isDirectory();
        }
    },
    IS_FILE { // from class: com.google.common.io.Files$FilePredicate.2
        @Override // java.lang.Enum
        public String toString() {
            return "Files.isFile()";
        }

        @Override // com.google.common.io.Files$FilePredicate, com.google.common.base.p
        public boolean apply(File file) {
            return file.isFile();
        }
    };

    @Override // com.google.common.base.p
    public abstract /* synthetic */ boolean apply(File file);

    /* synthetic */ Files$FilePredicate(b bVar) {
        this();
    }
}
