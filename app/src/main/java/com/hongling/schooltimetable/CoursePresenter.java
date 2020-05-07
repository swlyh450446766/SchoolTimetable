package com.hongling.schooltimetable;

import android.app.Activity;

public class CoursePresenter {

    private ICourseView courseView;
    private ICourseBiz courseBiz;

    public CoursePresenter(ICourseView courseView) {
        this.courseView = courseView;
        this.courseBiz = new CourseModel();
    }

    public void initView(Activity activity) {
        courseBiz.initView(activity);
    }
}
