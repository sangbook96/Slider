package vn.adt.slider.posters;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public class RemoteVideoPath extends VideoPoster implements Parcelable {
    private Uri uri;

    public RemoteVideoPath(Uri uri) {
        this.uri = uri;
    }

    public Uri getUri() {
        return uri;
    }

    public RemoteVideoPath(Parcel in){
        uri = in.readParcelable(Uri.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(uri,flags);
    }

    @SuppressWarnings("unused")
    public static final Creator<RemoteVideo> CREATOR = new Creator<RemoteVideo>() {
        @Override
        public RemoteVideo createFromParcel(Parcel in) {
            return new RemoteVideo(in);
        }

        @Override
        public RemoteVideo[] newArray(int size) {
            return new RemoteVideo[size];
        }
    };
}
