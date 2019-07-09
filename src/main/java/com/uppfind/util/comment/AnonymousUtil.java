package com.uppfind.util.comment;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by LAccordeur on 2017/7/17.
 */
public class AnonymousUtil {
    private static List<String> names = new ArrayList<String>();
    //private static int[] marks = new int[30]; //0表示未使用
    private static int iconNum = 16;

    static {
        File file = new File("/usr/local/app/tomcat7/webapps/university-assistant-server/img/icon");
        if (file.exists()) {
            String[] files = file.list();
            iconNum = files.length;
        }
    }

    static {
        names.add("李逵");names.add("林冲");names.add("公孙胜");
        names.add("宋江");names.add("花荣");names.add("柴进");
        names.add("吴用");names.add("鲁智深");names.add("武松");
        names.add("卢俊义");names.add("杨志");names.add("刘唐");
        names.add("孙悟空");names.add("鹿子霖");names.add("白灵");
        names.add("费德勒");names.add("白嘉轩");names.add("二豆");
        names.add("侯亮平");names.add("沙瑞金");names.add("李达康");
        names.add("高育良");names.add("祁同伟");names.add("周迅");
        names.add("彭于晏");names.add("杨颖");names.add("范冰冰");
        names.add("杨幂");names.add("赵丽颖");names.add("林允");
    }

    public static String getAnonymousName() {
        Random random = new Random(System.currentTimeMillis());
        int[] marks = new int[30]; //0表示未使用
        String name = null;
        int failCount = 0;

        /*for (int i = 0; i < 30; i++) {
            marks[i] = 0;
        }*/

        while (true) {
            int index = Math.abs(random.nextInt(30));
            if (marks[index] == 0) {
                name = names.get(index);
                marks[index] = 1;
                break;
            } else {
                failCount++;
            }

            if (failCount > 30) {
                name = "张飞";
                break;
            }
        }

        return name;
    }

    public static int getAnonymousId() {
        Random random = new Random(System.currentTimeMillis());
        return Math.abs(random.nextInt(iconNum));
    }

    public static void main(String[] args) {

        for (int i = 0; i < 1000; i++) {
            System.out.println(AnonymousUtil.getAnonymousName());
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
