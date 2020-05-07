package com.hongling.schooltimetable;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity implements ICourseView {

    private CoursePresenter coursePresenter = new CoursePresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//隐藏状态栏
        coursePresenter.initView(this);
    }

    @Override
    public String getCourse() {
        return null;
    }

    @Override
    public String setCourse() {
        return null;
    }

    @Override
    public void initView(Activity activity) {
        coursePresenter.initView(activity);
    }

    @Override
    public void initData() {

    }

    @Override
    public void showCourseSelectDialog() {

    }
}
