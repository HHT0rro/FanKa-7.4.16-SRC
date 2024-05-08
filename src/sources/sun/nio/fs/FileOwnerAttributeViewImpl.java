package sun.nio.fs;

import com.huawei.appgallery.agd.common.utils.StringUtils;
import com.huawei.openalliance.ad.constant.u;
import java.io.IOException;
import java.nio.file.attribute.AclFileAttributeView;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.UserPrincipal;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
final class FileOwnerAttributeViewImpl implements FileOwnerAttributeView, DynamicFileAttributeView {
    private static final String OWNER_NAME = "owner";
    private final boolean isPosixView = false;
    private final FileAttributeView view;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FileOwnerAttributeViewImpl(PosixFileAttributeView view) {
        this.view = view;
    }

    FileOwnerAttributeViewImpl(AclFileAttributeView view) {
        this.view = view;
    }

    @Override // java.nio.file.attribute.FileOwnerAttributeView, java.nio.file.attribute.AttributeView
    public String name() {
        return OWNER_NAME;
    }

    @Override // sun.nio.fs.DynamicFileAttributeView
    public void setAttribute(String attribute, Object value) throws IOException {
        if (attribute.equals(OWNER_NAME)) {
            setOwner((UserPrincipal) value);
            return;
        }
        throw new IllegalArgumentException("'" + name() + u.bD + attribute + "' not recognized");
    }

    @Override // sun.nio.fs.DynamicFileAttributeView
    public Map<String, Object> readAttributes(String[] attributes) throws IOException {
        Map<String, Object> result = new HashMap<>();
        for (String attribute : attributes) {
            if (attribute.equals(StringUtils.NO_PRINT_CODE) || attribute.equals(OWNER_NAME)) {
                result.put(OWNER_NAME, getOwner());
            } else {
                throw new IllegalArgumentException("'" + name() + u.bD + attribute + "' not recognized");
            }
        }
        return result;
    }

    @Override // java.nio.file.attribute.FileOwnerAttributeView
    public UserPrincipal getOwner() throws IOException {
        if (this.isPosixView) {
            return ((PosixFileAttributeView) this.view).readAttributes().owner();
        }
        return ((AclFileAttributeView) this.view).getOwner();
    }

    @Override // java.nio.file.attribute.FileOwnerAttributeView
    public void setOwner(UserPrincipal owner) throws IOException {
        if (this.isPosixView) {
            ((PosixFileAttributeView) this.view).setOwner(owner);
        } else {
            ((AclFileAttributeView) this.view).setOwner(owner);
        }
    }
}
