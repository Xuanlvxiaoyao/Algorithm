package com.example.algorithm;

/**
 * Created by Administrator on 2017/6/28.
 */

public class Algorithm {
    static int[] a={33,45,6,72,24,66,33};

    public static void main(String[] args) {
        int length=a.length-1;
        selection_sort(a);

        for(int i:a){
            System.out.print(i+"  ");
        }

    }

    /**
     * 冒泡排序  (升序排序)
     * 根据趟数规定比较次数
     * @param a  需要排序的数组
     */
    public static void bubble_sort(int[] a){
        for(int i=0;i<a.length-1;i++){   //趟数
            for(int j=0;j<a.length-i-1;j++){  //比较次数
                if(a[j]>a[j+1]){
                    int temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
    }

    /**
     * 二分查找法，折半算法
     *
     * @param a  数组
     * @param i  查找元素
     */
    public static int binary_search(int[] a,int i){
        int result=-1; //返回的元素下表，如果没有这个元素，返回-1
        int lower=0;
        int higher=a.length-1;
        int middle=(lower+higher)/2;

        while(lower<=higher){
            if(i==a[middle]){
                result=middle;
                higher--;
            }
            if(i>a[middle]){
                lower++;
            }
            if(i<a[middle]){
                higher--;
            }

            if(lower>higher){
                return result;
            }

            middle=(lower+higher)/2;
        }

        return result;
    }

    /**
     * 选择排序
     * {33,45,6,72,24,66,33}
     */
    public static void selection_sort(int[] a){

        int temp;
        for(int j=0;j<a.length;j++){
            int i=j; //记录最小数的下标
            for(int m=j+1;m<a.length;m++){
                if(a[i]>=a[m]){
                 i=m;
                }
            }
            temp=a[j];
            a[j]=a[i];
            System.out.println(i);
            a[i]=temp;
        }
    }


    /**
     * 快速排序
     */
    public static void quick_sort(int[] a,int i,int r){

        if(i<r){
            int m=i;
            int n=r;
            int temp=a[i];
           while (m<n){
               while(m<n&&temp<a[n]){
                   n--;
               }
               if(m<n){
                   a[m]=a[n];
                   m++;
               }
               while(m<n&&temp>=a[m]){
                   m++;
               }
               if(m<n){
                   a[n]=a[m];
                   n--;
               }
           }
            a[m]=temp;
            quick_sort(a,i,m-1);
            quick_sort(a,m+1,r);
        }

    }
}
