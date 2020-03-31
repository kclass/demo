package com.ttxs.utils;

/**
 * @author kai.hu
 * @date 2020/3/30 11:40
 */
public class DateUtil {
    public static void main(String[] args) {
        //定义cards
        String[] color = new String[] {"♠", "♦", "♥", "♣"};
        String[] serial = new String[] {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] extra = new String[] {"joker", "JOKER"};

        //产生随机数
        int cardNum = 54;
        int[] cardArr = new int[cardNum];
        for (int i = 0;;) {
            int index = (int) Math.ceil(Math.random() * cardNum);
            if (!hasValue(cardArr, index)) {
                cardArr[i] = index;
                i++;
            }

            if (i == 54) {
                break;
            }
        }

        //打印卡牌
        for (int i = 0; i < cardArr.length; i++) {
            //打印player
            if (i == 0) {
                System.out.println("farmer1:");
            } else if (i == 17) {
                System.out.println("farmer2:");
            } else if (i == 34) {
                System.out.println("landowner:");
            }

            //打印card
            int index = cardArr[i];
        }



    }

    public static boolean hasValue(int [] arr, int num) {
        for (int value : arr) {
            if (value == num) {
                return true;
            }
        }
        return false;
    }
}
