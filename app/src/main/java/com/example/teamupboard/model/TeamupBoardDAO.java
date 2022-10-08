package com.example.teamupboard.model;

import android.graphics.BitmapFactory;

import androidx.fragment.app.Fragment;

import com.example.teamupboard.R;

import java.util.ArrayList;

public class TeamupBoardDAO {
    private ArrayList<TeamupBoard> teamupBoards = new ArrayList<>();
    private Fragment fragment;
    public TeamupBoardDAO(Fragment fragment){
        this.fragment = fragment;
        initData();
    }
    private void initData(){
        teamupBoards.add(new TeamupBoard(
                10000,
                "舌尖上的中国",
                "甜食是人类最简单最初始的美食体验，蜂蜜的主要成分是果糖和葡萄糖，作为早期人类唯一的甜食，蜂蜜能快速产生热量，补充体力" +
                        "这对我们的祖先至关重要，和人工提炼的蔗糖不同，蜂蜜中的糖，不经过水解，就可以直接被人体吸收。在中国的厨房，无论制作菜肴还是甜点，" +
                        "蜂蜜都是其他糖类无法替代的。\n",
                new String[]{"食物", "美食", "测试"},
                BitmapFactory.decodeResource(fragment.getResources(), R.drawable.cat),
                true
        ));
        teamupBoards.add(new TeamupBoard(
                10001,
                "疯狂星期四",
                "我都懂 我都明白 我是选项E 我是planB 洗衣机流出的泡沫 超市里被捏碎的饼干 是吃腻的奶油 " +
                        "是落寞的城市 是地上的草 我是被踩踏的 是西装的备用扣 是被雨淋湿的小狗  是腐烂的橘子 是过期的" +
                        "牛奶 是断线的风筝，所以能v我80吗，明天是KFC fxxking Crazy Thursday，我想吃两份",
                new String[]{"kfc", "测试"},
                BitmapFactory.decodeResource(fragment.getResources(), R.drawable.cat),
                false
        ));
        teamupBoards.add(new TeamupBoard(
                10002,
                "大炮",
                "为什么大家不保存下来呢？大家不觉" +
                        "得这些句子很好笑吗？是吧，就我一个人这样觉得，算了，没关系反正我的枕头下面全是武器，我没事就拿大炮轰自己。",
                new String[]{"疯狂", "武器", "测试","好笑"},
                BitmapFactory.decodeResource(fragment.getResources(), R.drawable.cat),
                false
        ));
        teamupBoards.add(new TeamupBoard(
                10003,
                "功夫",
                "我的精神挺好的呀 我的神好挺的精呀 挺精呀我的好的 精挺好我的神的呀 我" +
                        "好的精神的呀 的好的呀上勾拳！下勾拳！左勾拳！扫堂腿！回旋踢！蜘蛛吃耳屎，龙卷风摧毁停车场！羚羊蹬，山" +
                        "羊跳！乌鸦坐飞机！老鼠走迷宫！大象踢腿！愤怒的章鱼！巨斧砍大树！彻底疯狂！彻底疯狂！彻底疯狂！彻底疯狂！",
                new String[]{"精神", "上勾拳","武术","测试"},
                BitmapFactory.decodeResource(fragment.getResources(), R.drawable.cat),
                true
        ));
        teamupBoards.add(new TeamupBoard(
                10004,
                "笑一下算了",
                "笑什么笑，你以为你想笑我就想笑吗，你根本不在乎我，你只是为了你开心，为了让我看到你开心，其" +
                        "实你不知道，我本来就非常开心，但是你没有先问我是不是开心，你让我伤心了，你知道吗，但我觉得你知道了你也不会改正，你就是" +
                        "你，你只会这样。",
                new String[]{"乐", "别管了", "测试"},
                BitmapFactory.decodeResource(fragment.getResources(), R.drawable.cat),
                true
        ));
        teamupBoards.add(new TeamupBoard(
                10005,
                "编不下去了",
                "要测试不完了",
                new String[]{"开摆"},
                BitmapFactory.decodeResource(fragment.getResources(), R.drawable.cat),
                true
        ));
        teamupBoards.add(new TeamupBoard(
                100006,
                "阿西",
                "就这样吧",
                new String[]{},
                BitmapFactory.decodeResource(fragment.getResources(), R.drawable.cat),
                true
        ));
    }

    public ArrayList<TeamupBoard> getTeamupBoards() {
        return teamupBoards;
    }

    public ArrayList<TeamupBoard> getTeamupBoards(Boolean num){
        ArrayList<TeamupBoard> list = new ArrayList<>();
        if(num){
            for (TeamupBoard teamupBoard: teamupBoards){
                if(teamupBoard.getTbId() % 2 == 1){
                    list.add(teamupBoard);
                }
            }
        }else {
            for (TeamupBoard teamupBoard: teamupBoards){
                if(teamupBoard.getTbId() % 2 == 0){
                    list.add(teamupBoard);
                }
            }
        }
        return list;
    }

    public ArrayList<TeamupBoard> getTeamupBoards(Boolean num, Boolean online){
        ArrayList<TeamupBoard> list = new ArrayList<>();
        if(online) {
            for (TeamupBoard teamupBoard : teamupBoards) {
                if (teamupBoard.getOnline()) {
                    if (num) {
                        if (teamupBoard.getTbId() % 2 == 1) {
                            list.add(teamupBoard);
                        }
                    } else {
                        if (teamupBoard.getTbId() % 2 == 0) {
                            list.add(teamupBoard);
                        }
                    }
                }
            }
        }
        else {
            for (TeamupBoard teamupBoard: teamupBoards){
                if(!teamupBoard.getOnline()){
                    if(num){
                        if(teamupBoard.getTbId() % 2 == 1){
                            list.add(teamupBoard);
                        }
                    }
                     else {
                        if (teamupBoard.getTbId() % 2 == 0) {
                            list.add(teamupBoard);
                        }
                    }
                }
            }
        }
        return list;
    }
}
