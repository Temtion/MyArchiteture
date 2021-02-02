package com.temption.myarchitecture.ext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description:
 * @Author: haoshuaihui
 * @CreateDate: 2021/2/1 17:09
 */
public class Test {
    public static final String TAG = "TestS";

    public static Test getInstance() {
        return new Test();
    }

    public void test() {
        String s = "接到来自#null#的一键咨询订单，是否立即开始服务？订单原计划于##02月-02日 01:00:00##开始";
        String replace = s.replace("##", "%");
        String regex = "#.*?#";
        String regex2 = "%(.*?)%";

        String[] split = replace.split(regex);
        if (split.length > 1){
            for (int i = 0; i < split.length; i++) {
                String s1 = split[i];
                String[] split2 = s1.split(regex2);
                if (split2.length>1){
                    for (int j = 0; j < split2.length; j++) {
                        System.out.println(split2[j]);

                    }
                }else {
                    System.out.println(s1);

                }
            }
        }

    }
}
