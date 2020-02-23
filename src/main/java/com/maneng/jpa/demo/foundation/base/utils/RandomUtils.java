package com.maneng.jpa.demo.foundation.base.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 随机字符或者数字组合,用来验证码,口令等 <p> Created by lijingyao on 16/5/3 17:43.
 */
public class RandomUtils {

  // 26个字母中,去掉 i,o,l (容易和0,1混淆)
  private static final char[] alpha = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'm', 'n', 'p', 'q',
      'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '2', '3', '4', '5', '6', '7', '8', '9'};

  private static final int size = alpha.length;

  /**
   * 获取所有可能的 {@link RandomUtils#alpha} 的排列组合,shuffle后输出
   *
   * @param length 需要组成的组合字符的长度
   */
  public static List<String> getAllRandomPermutations(final int length) {
    if (length < 2) {
      throw new IllegalArgumentException("Random Permutations need at least 2 length.");
    }
    List<String> list = new ArrayList<>();
    char[] resultChars = new char[length];
    getCombination(list, alpha, length, 0, resultChars, 0);
    return list;

  }

  public static void getCombination(List<String> result, char[] source, int length, int begin, char[] resultChars,
      int index) {

    if (length == 0) {
      getAllPermutation(result, resultChars, 0);//得到b的全排列
      return;
    }

    for (int i = begin; i < source.length; i++) {
      resultChars[index] = source[i];
      getCombination(result, source, length - 1, i + 1, resultChars, index + 1);
    }

  }

  public static void getAllPermutation(List<String> result, char[] resultChars, int index) {

    if (index == resultChars.length - 1) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < resultChars.length; i++) {
        sb.append(resultChars[i]);
      }
      result.add(sb.toString());
      return;
    }

    for (int i = index; i < resultChars.length; i++) {

      swap(resultChars, index, i);
      getAllPermutation(result, resultChars, index + 1);
      swap(resultChars, index, i);
    }
  }

  private static void swap(char[] a, int i, int j) {
    char temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  /**
   * 生成包含字母和数字混合的,无序的字符串 字符中过滤了(0,1,i,l,o)
   *
   * @param length 需要的字符串的长度(建议一般4位或者6位)
   */
  public static String generateRandomAlpha(final int length) {

    StringBuilder sb = new StringBuilder();
    Random rand = new Random();

    for (int i = 0; i < length; i++) {
      int index = rand.nextInt(size);
      sb.append(alpha[index]);
    }
    return sb.toString();
  }


  /**
   * 生成纯数字的字符串组合,数字区间 0~9
   *
   * @param length 需要的字符串的长度(建议一般4位或者6位)
   */
  public static String generateRandomData(final int length) {
    StringBuilder sb = new StringBuilder();
    Random rand = new Random();
    for (int i = 0; i < length; i++) {
      sb.append(rand.nextInt(10));
    }
    return sb.toString();
  }


}
