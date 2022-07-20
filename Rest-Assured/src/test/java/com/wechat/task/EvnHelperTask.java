package com.wechat.task;

import com.wechat.apiobject.DepartMentObject;

import java.util.ArrayList;

/**
 * @ClassName EvnHelperTask
 * @Description TODO
 * @Author yangfan
 * @Date 2022/6/16 10:13
 */
public class EvnHelperTask {
    public static void clearDpartMentTask(String accessToken) {

        ArrayList<Integer> departmentIds = DepartMentObject.listDepartMent("", accessToken).path("department.id");
        for (int departmentId : departmentIds) {
            if (1 == departmentId)
                continue;
            DepartMentObject.deleteDepartMent(departmentId + "", accessToken);
        }
    }
}
