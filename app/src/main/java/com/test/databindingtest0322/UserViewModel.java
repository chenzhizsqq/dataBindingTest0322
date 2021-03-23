package com.test.databindingtest0322;

import android.content.Context;
import android.util.Log;
import com.test.databindingtest0322.databinding.ActivityMainBinding;

public class UserViewModel {
    private ActivityMainBinding activityMainBinding;
    public static final String TAG="UserViewModel";
    public User user;
    public UserViewModel(ActivityMainBinding activityMainBinding){
        this.activityMainBinding=activityMainBinding;
    }
    public void init(){
        this.user=new User();
        this.activityMainBinding.setUserViewModel(UserViewModel.this);
    }
    //登录
    public void login(){
        //业务逻辑
        Log.e(TAG,"status:"+user.status.get());
        Log.e(TAG,"username:"+user.userName.get());
        Log.e(TAG,"password:"+user.password.get());
        //权限的校验
        if (findByUser(this.user))
            this.user.status.set("success");
        else
            this.user.status.set("error");
    }

    //模拟数据库
    String [] userArray={"u1:p1","u2:p2"};
    //查找用户
    public boolean findByUser(User user){
        if(user==null)
            throw  new NullPointerException("this user object is null");
        for (int i = 0; i <userArray.length; i++) {
            String  userStr=userArray[i];
            String [] userArray=userStr.split(":");
            String username=userArray[0];
            String password=userArray[1];
            if((user.userName.get()).equals(username)&& (user.password.get()).equals(password)){
                return true;
            }
        }
        return false;
    }
}