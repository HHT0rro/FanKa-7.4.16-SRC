package org.apache.commons.collections4.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class AbstractPropertiesFactory<T extends Properties> {
    public abstract T createProperties();

    public T load(ClassLoader classLoader, String str) throws IOException {
        InputStream resourceAsStream = classLoader.getResourceAsStream(str);
        try {
            T load = load(resourceAsStream);
            if (resourceAsStream != null) {
                resourceAsStream.close();
            }
            return load;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (resourceAsStream != null) {
                    try {
                        resourceAsStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public T load(File file) throws FileNotFoundException, IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            T load = load(fileInputStream);
            fileInputStream.close();
            return load;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    fileInputStream.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    public T load(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        T createProperties = createProperties();
        createProperties.load(inputStream);
        return createProperties;
    }

    public T load(Path path) throws IOException {
        InputStream newInputStream = Files.newInputStream(path, new OpenOption[0]);
        try {
            T load = load(newInputStream);
            if (newInputStream != null) {
                newInputStream.close();
            }
            return load;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (newInputStream != null) {
                    try {
                        newInputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public T load(Reader reader) throws IOException {
        T createProperties = createProperties();
        createProperties.load(reader);
        return createProperties;
    }

    public T load(String str) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(str);
        try {
            T load = load(fileInputStream);
            fileInputStream.close();
            return load;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    fileInputStream.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    public T load(URI uri) throws IOException {
        return load(Paths.get(uri));
    }

    public T load(URL url) throws IOException {
        InputStream openStream = url.openStream();
        try {
            T load = load(openStream);
            if (openStream != null) {
                openStream.close();
            }
            return load;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (openStream != null) {
                    try {
                        openStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }
}
