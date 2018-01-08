package cn.bleedyao.lazyfragmentdemo;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import static cn.bleedyao.lazyfragmentdemo.MainActivity.TAG;

/**
 * Created by yaoluhao on 08/01/2018.
 */

public class ThirdFragment extends LazyFragment {

    private TextView mText;
    private FragmentActivity mActivity;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.d(TAG, getClass().getSimpleName() + " setUserVisibleHint: " + isVisibleToUser);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (FragmentActivity)context;
        Log.d(TAG, getClass().getSimpleName() + " onAttach: ");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, getClass().getSimpleName() + " onCreate: ");
    }

    @Override
    protected void initView(View view) {
        Log.d(TAG, getClass().getSimpleName() + " onCreateView: ");
        mText = view.findViewById(R.id.textView);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_text;
    }

    @Override
    protected void loadData() {
        new Thread() {
            @Override
            public void run() {
                SystemClock.sleep(3000);
                mActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mText.setText(ThirdFragment.this.getClass().getSimpleName());
                    }
                });
            }
        }.start();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, getClass().getSimpleName() + " onActivityCreated: ");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, getClass().getSimpleName() + " onStart: ");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, getClass().getSimpleName() + " onResume: ");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, getClass().getSimpleName() + " onPause: ");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, getClass().getSimpleName() + " onStop: ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, getClass().getSimpleName() + " onDestroyView: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, getClass().getSimpleName() + " onDestroy: ");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, getClass().getSimpleName() + " onDetach: ");
    }
}
