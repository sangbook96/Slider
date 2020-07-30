package vn.adt.slider.posters;

import android.os.Parcel;
import android.os.Parcelable;

public class RawVideo extends VideoPoster implements Parcelable {
    private int rawResource;

    public RawVideo(int rawResource){
        this.rawResource = rawResource;
    }

    public int getRawResource() {
        return rawResource;
    }

    protected RawVideo(Parcel in) {
        rawResource = (int) in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(rawResource);
    }

    @SuppressWarnings("unused")
    public static final Creator<RawVideo> CREATOR = new Creator<RawVideo>() {
        @Override
        public RawVideo createFromParcel(Parcel in) {
            return new RawVideo(in);
        }

        @Override
        public RawVideo[] newArray(int size) {
            return new RawVideo[size];
        }
    };


}
