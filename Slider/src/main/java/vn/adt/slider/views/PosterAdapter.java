package vn.adt.slider.views;

import android.annotation.SuppressLint;
import android.util.LayoutDirection;

import androidx.annotation.LayoutRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.Collections;
import java.util.List;

import vn.adt.slider.event.IVideoPlayListener;
import vn.adt.slider.posters.Poster;
import vn.adt.slider.views.fragment.EmptyViewFragment;
import vn.adt.slider.views.fragment.PosterFragment;


public class PosterAdapter extends FragmentStatePagerAdapter {

    private List<Poster> posters;
    private boolean isLooping;

    @LayoutRes
    private int emptyView;

    private IVideoPlayListener videoPlayListener;

    
    public PosterAdapter(FragmentManager supportFragmentManager, boolean isLooping, List<Poster> posters) {
        super(supportFragmentManager);
        this.isLooping = isLooping;
        this.posters = posters;
    }

    public PosterAdapter(FragmentManager supportFragmentManager, boolean isLooping, int layoutDirection, List<Poster> posters) {
        super(supportFragmentManager);
        this.isLooping = isLooping;
        this.posters = posters;
        if (layoutDirection== LayoutDirection.RTL){
            Collections.reverse(posters);
        }
    }

    @SuppressLint("ResourceType")
    @Override
    public Fragment getItem(int position) {
        if (posters.isEmpty() && emptyView > 0) {
            return EmptyViewFragment.newInstance(emptyView);
        }
        if (isLooping) {
            if (position == 0) {
                return PosterFragment.newInstance(posters.get(posters.size() - 1),videoPlayListener);
            } else if (position == posters.size() + 1) {
                return PosterFragment.newInstance(posters.get(0),videoPlayListener);
            } else {
                return PosterFragment.newInstance(posters.get(position - 1),videoPlayListener);
            }
        } else {
            return PosterFragment.newInstance(posters.get(position),videoPlayListener);
        }
    }

    @SuppressLint("ResourceType")
    @Override
    public int getCount() {
        if (posters.isEmpty()) {
            if (emptyView > 0) {
                return 1;
            } else {
                return 0;
            }
        }
        if (isLooping) {
            return posters.size() + 2;
        } else {
            return posters.size();
        }
    }

    public void setVideoPlayListener(IVideoPlayListener videoPlayListener) {
        this.videoPlayListener = videoPlayListener;
    }

    public void setEmptyView(int emptyView) {
        this.emptyView = emptyView;
        notifyDataSetChanged();
    }
}
