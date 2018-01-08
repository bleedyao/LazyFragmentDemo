package cn.bleedyao.lazyfragmentdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by yaoluhao on 01/12/2017.
 */

public abstract class LazyFragment extends Fragment {
    private static final String TAG = "LazyFragment";
    private boolean mIsInited;
    private boolean mIsPrepared;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), container, false);
        initView(view);
        mIsPrepared = true;
        return view;
    }

    protected abstract void initView(View view);

    protected abstract int getLayout();

    protected abstract void loadData();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lazyLoad();
    }

    private void lazyLoad() {
        if (getUserVisibleHint() && mIsPrepared && !mIsInited) {
            // 异步初始化，在初始化后显示正常 UI
            loadData();
            mIsInited = true;
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            lazyLoad();
        }
    }
}
