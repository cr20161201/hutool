package com.xiaoleilu.hutool.convert;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import com.xiaoleilu.hutool.convert.impl.ArrayConverter;

/**
 * 类型转换工具单元测试<br>
 * 转换为数组
 * 
 * @author Looly
 *
 */
public class ConvertToArrayTest {

	@Test
	public void toIntArrayTest() {
		String[] b = { "1", "2", "3", "4" };
		
		Integer[] intArray = Convert.toIntArray(b);
		Assert.assertArrayEquals(intArray, new Integer[]{1,2,3,4});
		
		long[] c = {1L,2L,3L,4L,5L};
		Integer[] intArray2 = Convert.toIntArray(c);
		Assert.assertArrayEquals(intArray2, new Integer[]{1,2,3,4,5});
	}
	
	@Test
	public void toLongArrayTest() {
		String[] b = { "1", "2", "3", "4" };
		
		Long[] intArray = Convert.toLongArray(b);
		Assert.assertArrayEquals(intArray, new Long[]{1L,2L,3L,4L});
		
		int[] c = {1,2,3,4,5};
		Long[] intArray2 = Convert.toLongArray(c);
		Assert.assertArrayEquals(intArray2, new Long[]{1L,2L,3L,4L,5L});
	}
	
	@Test
	public void toDoubleArrayTest() {
		String[] b = { "1", "2", "3", "4" };
		
		Double[] intArray = Convert.toDoubleArray(b);
		Assert.assertArrayEquals(intArray, new Double[]{1D,2D,3D,4D});
		
		int[] c = {1,2,3,4,5};
		Double[] intArray2 = Convert.toDoubleArray(c);
		Assert.assertArrayEquals(intArray2, new Double[]{1D,2D,3D,4D,5D});
	}
	
	@Test
	public void toPrimitiveArrayTest(){
		
		//数组转数组测试
		int[] a = new int[]{1,2,3,4};
		long[] result = ConverterRegistry.getInstance().convert(long[].class, a);
		Assert.assertArrayEquals(new long[]{1L, 2L, 3L, 4L}, result);
		
		//字符串转数组
		String arrayStr = "1,2,3,4,5";
		//获取Converter类的方法2，自己实例化相应Converter对象
		ArrayConverter c3 = new ArrayConverter(int.class);
		int[] result3 = (int[]) c3.convert(arrayStr, null);
		Assert.assertArrayEquals(new int[]{1,2,3,4,5}, result3);
	}
	
	@Test
	public void collectionToArrayTest() {
		ArrayList<Object> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		
		String[] result = Convert.toStrArray(list);
		Assert.assertEquals(list.get(0), result[0]);
		Assert.assertEquals(list.get(1), result[1]);
		Assert.assertEquals(list.get(2), result[2]);
	}
	
	@Test
	public void strToCharArrayTest() {
		String testStr = "abcde";
		Character[] array = Convert.toCharArray(testStr);
		
		//包装类型数组
		Assert.assertEquals(new Character('a'), array[0]);
		Assert.assertEquals(new Character('b'), array[1]);
		Assert.assertEquals(new Character('c'), array[2]);
		Assert.assertEquals(new Character('d'), array[3]);
		Assert.assertEquals(new Character('e'), array[4]);
		
		//原始类型数组
		char[] array2 = Convert.convert(char[].class, testStr);
		Assert.assertEquals('a', array2[0]);
		Assert.assertEquals('b', array2[1]);
		Assert.assertEquals('c', array2[2]);
		Assert.assertEquals('d', array2[3]);
		Assert.assertEquals('e', array2[4]);
		
	}
}
