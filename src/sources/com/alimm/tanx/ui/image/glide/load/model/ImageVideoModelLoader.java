package com.alimm.tanx.ui.image.glide.load.model;

import android.os.ParcelFileDescriptor;
import com.alimm.tanx.ui.image.glide.load.data.DataFetcher;
import java.io.InputStream;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ImageVideoModelLoader<A> implements ModelLoader<A, ImageVideoWrapper> {
    public static final String TAG = "IVML";
    public final ModelLoader<A, ParcelFileDescriptor> fileDescriptorLoader;
    public final ModelLoader<A, InputStream> streamLoader;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class ImageVideoFetcher implements DataFetcher<ImageVideoWrapper> {
        public final DataFetcher<ParcelFileDescriptor> fileDescriptorFetcher;
        public final DataFetcher<InputStream> streamFetcher;

        public ImageVideoFetcher(DataFetcher<InputStream> dataFetcher, DataFetcher<ParcelFileDescriptor> dataFetcher2) {
            this.streamFetcher = dataFetcher;
            this.fileDescriptorFetcher = dataFetcher2;
        }

        @Override // com.alimm.tanx.ui.image.glide.load.data.DataFetcher
        public void cancel() {
            DataFetcher<InputStream> dataFetcher = this.streamFetcher;
            if (dataFetcher != null) {
                dataFetcher.cancel();
            }
            DataFetcher<ParcelFileDescriptor> dataFetcher2 = this.fileDescriptorFetcher;
            if (dataFetcher2 != null) {
                dataFetcher2.cancel();
            }
        }

        @Override // com.alimm.tanx.ui.image.glide.load.data.DataFetcher
        public void cleanup() {
            DataFetcher<InputStream> dataFetcher = this.streamFetcher;
            if (dataFetcher != null) {
                dataFetcher.cleanup();
            }
            DataFetcher<ParcelFileDescriptor> dataFetcher2 = this.fileDescriptorFetcher;
            if (dataFetcher2 != null) {
                dataFetcher2.cleanup();
            }
        }

        @Override // com.alimm.tanx.ui.image.glide.load.data.DataFetcher
        public String getId() {
            DataFetcher<InputStream> dataFetcher = this.streamFetcher;
            if (dataFetcher != null) {
                return dataFetcher.getId();
            }
            return this.fileDescriptorFetcher.getId();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Removed duplicated region for block: B:9:0x001e A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // com.alimm.tanx.ui.image.glide.load.data.DataFetcher
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.alimm.tanx.ui.image.glide.load.model.ImageVideoWrapper loadData(com.alimm.tanx.ui.image.glide.Priority r6) throws java.lang.Exception {
            /*
                r5 = this;
                com.alimm.tanx.ui.image.glide.load.data.DataFetcher<java.io.InputStream> r0 = r5.streamFetcher
                r1 = 2
                java.lang.String r2 = "IVML"
                r3 = 0
                if (r0 == 0) goto L19
                java.lang.Object r0 = r0.loadData(r6)     // Catch: java.lang.Exception -> Lf
                java.io.InputStream r0 = (java.io.InputStream) r0     // Catch: java.lang.Exception -> Lf
                goto L1a
            Lf:
                r0 = move-exception
                android.util.Log.isLoggable(r2, r1)
                com.alimm.tanx.ui.image.glide.load.data.DataFetcher<android.os.ParcelFileDescriptor> r4 = r5.fileDescriptorFetcher
                if (r4 == 0) goto L18
                goto L19
            L18:
                throw r0
            L19:
                r0 = r3
            L1a:
                com.alimm.tanx.ui.image.glide.load.data.DataFetcher<android.os.ParcelFileDescriptor> r4 = r5.fileDescriptorFetcher
                if (r4 == 0) goto L2e
                java.lang.Object r6 = r4.loadData(r6)     // Catch: java.lang.Exception -> L26
                android.os.ParcelFileDescriptor r6 = (android.os.ParcelFileDescriptor) r6     // Catch: java.lang.Exception -> L26
                r3 = r6
                goto L2e
            L26:
                r6 = move-exception
                android.util.Log.isLoggable(r2, r1)
                if (r0 == 0) goto L2d
                goto L2e
            L2d:
                throw r6
            L2e:
                com.alimm.tanx.ui.image.glide.load.model.ImageVideoWrapper r6 = new com.alimm.tanx.ui.image.glide.load.model.ImageVideoWrapper
                r6.<init>(r0, r3)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alimm.tanx.ui.image.glide.load.model.ImageVideoModelLoader.ImageVideoFetcher.loadData(com.alimm.tanx.ui.image.glide.Priority):com.alimm.tanx.ui.image.glide.load.model.ImageVideoWrapper");
        }
    }

    public ImageVideoModelLoader(ModelLoader<A, InputStream> modelLoader, ModelLoader<A, ParcelFileDescriptor> modelLoader2) {
        if (modelLoader == null) {
            Objects.requireNonNull(modelLoader2, "At least one of streamLoader and fileDescriptorLoader must be non null");
        }
        this.streamLoader = modelLoader;
        this.fileDescriptorLoader = modelLoader2;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoader
    public DataFetcher<ImageVideoWrapper> getResourceFetcher(A a10, int i10, int i11) {
        ModelLoader<A, InputStream> modelLoader = this.streamLoader;
        DataFetcher<InputStream> resourceFetcher = modelLoader != null ? modelLoader.getResourceFetcher(a10, i10, i11) : null;
        ModelLoader<A, ParcelFileDescriptor> modelLoader2 = this.fileDescriptorLoader;
        DataFetcher<ParcelFileDescriptor> resourceFetcher2 = modelLoader2 != null ? modelLoader2.getResourceFetcher(a10, i10, i11) : null;
        if (resourceFetcher == null && resourceFetcher2 == null) {
            return null;
        }
        return new ImageVideoFetcher(resourceFetcher, resourceFetcher2);
    }
}
