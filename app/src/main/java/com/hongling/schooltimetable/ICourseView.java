package com.hongling.schooltimetable;

import android.app.Activity;
import android.content.Context;

public interface ICourseView {
    String getCourse();

    String setCourse();

    void initView(Activity activity);

    void initData();

    void showCourseSelectDialog();
}
