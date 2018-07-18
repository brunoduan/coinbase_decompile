package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

final class zzab implements zzce {
    private /* synthetic */ zzy zzfkg;

    private zzab(zzy com_google_android_gms_common_api_internal_zzy) {
        this.zzfkg = com_google_android_gms_common_api_internal_zzy;
    }

    public final void zzc(ConnectionResult connectionResult) {
        this.zzfkg.zzfke.lock();
        try {
            this.zzfkg.zzfkc = connectionResult;
            this.zzfkg.zzagj();
        } finally {
            this.zzfkg.zzfke.unlock();
        }
    }

    public final void zzf(int i, boolean z) {
        this.zzfkg.zzfke.lock();
        try {
            if (this.zzfkg.zzfkd) {
                this.zzfkg.zzfkd = false;
                this.zzfkg.zze(i, z);
                return;
            }
            this.zzfkg.zzfkd = true;
            this.zzfkg.zzfjv.onConnectionSuspended(i);
            this.zzfkg.zzfke.unlock();
        } finally {
            this.zzfkg.zzfke.unlock();
        }
    }

    public final void zzj(Bundle bundle) {
        this.zzfkg.zzfke.lock();
        try {
            this.zzfkg.zzfkc = ConnectionResult.zzfff;
            this.zzfkg.zzagj();
        } finally {
            this.zzfkg.zzfke.unlock();
        }
    }
}
