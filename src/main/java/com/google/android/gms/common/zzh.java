package com.google.android.gms.common;

import java.util.Arrays;

final class zzh extends zzg {
    private final byte[] zzffp;

    zzh(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.zzffp = bArr;
    }

    final byte[] getBytes() {
        return this.zzffp;
    }
}
