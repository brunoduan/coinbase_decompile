package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Util;

public abstract class BitmapTransformation implements Transformation<Bitmap> {
    protected abstract Bitmap transform(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2);

    public final Resource<Bitmap> transform(Context context, Resource<Bitmap> resource, int outWidth, int outHeight) {
        if (Util.isValidDimensions(outWidth, outHeight)) {
            int targetWidth;
            int targetHeight;
            BitmapPool bitmapPool = Glide.get(context).getBitmapPool();
            Bitmap toTransform = (Bitmap) resource.get();
            if (outWidth == Integer.MIN_VALUE) {
                targetWidth = toTransform.getWidth();
            } else {
                targetWidth = outWidth;
            }
            if (outHeight == Integer.MIN_VALUE) {
                targetHeight = toTransform.getHeight();
            } else {
                targetHeight = outHeight;
            }
            Bitmap transformed = transform(bitmapPool, toTransform, targetWidth, targetHeight);
            if (toTransform.equals(transformed)) {
                return resource;
            }
            return BitmapResource.obtain(transformed, bitmapPool);
        }
        throw new IllegalArgumentException("Cannot apply transformation on width: " + outWidth + " or height: " + outHeight + " less than or equal to zero and not Target.SIZE_ORIGINAL");
    }
}
