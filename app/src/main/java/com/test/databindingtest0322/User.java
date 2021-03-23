package com.test.databindingtest0322;

import androidx.databinding.ObservableField;
//ObservableField,“被封装”。就是访问值得时候，可以使用 get set 方法。

public class User {
    //用户名
    public ObservableField<String > userName=new ObservableField<>();
    //密码
    public ObservableField<String >password=new ObservableField<>();
    //反馈
    public ObservableField<String >status=new ObservableField<>();

    public User() {
    }
}