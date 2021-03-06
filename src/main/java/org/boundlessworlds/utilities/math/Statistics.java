/*
 * Copyright 2013 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.boundlessworlds.utilities.math;

import java.util.Arrays;

/**
 * Statistical functions.
 * @author Esereja 
 */
public class Statistics {
	
    private Statistics() {
    }
    
    /**
     * true if number bigger than zero
     * @param xin
     * @return
     */
    public static boolean sign(final int xin){
    	if(xin<0){
    		return false;
    	}
    	return true;
    }
    
    /**
     * true if number bigger than zero
     * @param xin
     * @return
     */
    public static boolean sign(final float xin){
    	if(xin<0){
    		return false;
    	}
    	return true;
    }
    
    /**
     * true if number bigger than zero
     * @param xin
     * @return
     */
    public static boolean sign(final double xin){
    	if(xin<0){
    		return false;
    	}
    	return true;
    }
    
    /**
     * true if number bigger than zero
     * @param xin
     * @return
     */
    public static boolean sign(final long xin){
    	if(xin<0){
    		return false;
    	}
    	return true;
    }

    /**
     * finds median of array
     * @param ain
     * @return
     */
    public static float median(final int[] ain){
    	int[] a=ain;
    	Arrays.sort(a);
    	if (a.length % 2 == 0){
    	    return ((float)a[(a.length-1)/2] + (float)a[(a.length-1)/2 - 1])/2;
    	}
    	return (float) a[(a.length-1)/2];
    }
    
    /**
     * finds median of array
     * @param ain
     * @return
     */
    public static float median(final float[] ain){
    	float[] a=ain;
    	Arrays.sort(a);
    	if (a.length % 2 == 0){
    	    return (a[(a.length-1)/2] + a[(a.length-1)/2 - 1])/2;
    	}
    	return a[(a.length-1)/2];
    }
    
    /**
     * finds median of array
     * @param ain
     * @return
     */
    public static double median(final long[] ain){
    	long[] a=ain;
    	Arrays.sort(a);
    	if (a.length % 2 == 0){
    	    return ((double)a[(a.length-1)/2] + (double)a[(a.length-1)/2 - 1])/2;
    	}
    	return (double)a[(a.length-1)/2];
    }
    
    /**
     * finds median of array
     * @param ain
     * @return
     */
    public static double median(final double[] ain){
    	double[] a=ain;
    	Arrays.sort(a);
    	if (a.length % 2 == 0){
    	    return (a[(a.length-1)/2] + a[(a.length-1)/2 - 1])/2;
    	}
    	return a[(a.length-1)/2];
    }
    
    /**
     * 
     * @param ain
     * @return
     */
    public static float aritmeticMean(final int[] ain){
    	int[] a=ain;
    	int r=0;
    	for(int i=0;i<a.length;i++){
    		r+=a[i];
    	}
    	return r/a.length;    	
    }
    
    /**
     * 
     * @param ain
     * @return
     */
    public static float aritmeticMean(final float[] ain){
    	float[] a=ain;
    	float r=0;
    	for(int i=0;i<a.length;i++){
    		r+=a[i];
    	}
    	return r/a.length;    	
    }
    
    /**
     * 
     * @param ain
     * @return
     */
    public static double aritmeticMean(final long[] ain){
    	long[] a=ain;
    	long r=0;
    	for(int i=0;i<a.length;i++){
    		r+=a[i];
    	}
    	return r/a.length;    	
    }
    
    /**
     * 
     * @param ain
     * @return
     */
    public static double aritmeticMean(final double[] ain){
    	double[] a=ain;
    	double r=0;
    	for(int i=0;i<a.length;i++){
    		r+=a[i];
    	}
    	return r/a.length;    	
    }
    
    /**
     * calculates variance
     * from:http://en.wikipedia.org/wiki/Algorithms_for_calculating_variance
     * @param ain
     * @return
     */
    public static float variance(final int[] ain){
    	int[] a=ain;
    	float mean=aritmeticMean(a);
    	float r=0;
    	for(int i=0;i<a.length;i++){
    		r+=((float)a[i]-mean)*((float)a[i]-mean);
    	}
    	return r/(a.length-1);    	
    }
    
    /**
     * calculates variance
     * from:http://en.wikipedia.org/wiki/Algorithms_for_calculating_variance
     * @param ain
     * @return
     */
    public static float variance(final float[] ain){
    	float[] a=ain;
    	float mean=aritmeticMean(a);
    	float r=0;
    	for(int i=0;i<a.length;i++){
    		r+=(a[i]-mean)*(a[i]-mean);
    	}
    	return r/(a.length-1);    	
    }
    
    /**
     * calculates variance
     * from:http://en.wikipedia.org/wiki/Algorithms_for_calculating_variance
     * @param ain
     * @return
     */
    public static float variance(final float[] ain, float mean){
    	float[] a=ain;
    	float r=0;
    	for(int i=0;i<a.length;i++){
    		r+=(a[i]-mean)*(a[i]-mean);
    	}
    	return r/(a.length-1);    	
    }
    
    /**
     * calculates variance
     * from:http://en.wikipedia.org/wiki/Algorithms_for_calculating_variance
     * @param ain
     * @return
     */
    public static double variance(final long[] ain){
    	long[] a=ain;
    	double mean=aritmeticMean(a);
    	double r=0;
    	for(int i=0;i<a.length;i++){
    		r+=((double)a[i]-mean)*((double)a[i]-mean);
    	}
    	return r/(a.length-1);    	
    }
    
    /**
     * calculates variance
     * from:http://en.wikipedia.org/wiki/Algorithms_for_calculating_variance
     * @param ain
     * @return
     */
    public static double variance(final double[] ain){
    	double[] a=ain;
    	double mean=aritmeticMean(a);
    	double r=0;
    	for(int i=0;i<a.length;i++){
    		r+=(a[i]-mean)*(a[i]-mean);
    	}
    	return r/(a.length-1);    	
    }
    
    /**
     * calculates variance
     * from:http://en.wikipedia.org/wiki/Algorithms_for_calculating_variance
     * @param ain
     * @return
     */
    public static double variance(final double[] ain,final double mean){
    	double[] a=ain;
    	double r=0;
    	for(int i=0;i<a.length;i++){
    		r+=(a[i]-mean)*(a[i]-mean);
    	}
    	return r/(a.length-1);    	
    }
    
    /**
     * Greatest common divisor
     * en.wikipedia.org/wiki/Euclidean_algorithm 
     * @param a
     * @param b
     * @return
     */
    public int gcd(int a, int b) {
    	if (b==0) 
    		return a;
    	return gcd(b,a%b);
    }
    
    /**
     * Greatest common divisor
     * en.wikipedia.org/wiki/Euclidean_algorithm 
     * @param a
     * @param b
     * @return
     */
    public long gcd(long a, long b) {
    	if (b==0) 
    		return a;
    	return gcd(b,a%b);
    }
    
    /**
     * 
     * @param ain
     * @return
     */
    public static int min(final int[] ain){
    	int[] a=ain;
    	int r=Integer.MAX_VALUE;
    	for(int i=0;i<a.length;i++){
    		if(a[i]<r){
    			r=a[i];
    		}
    	}
    	return r;    	
    }
    
    /**
     * 
     * @param ain
     * @return
     */
    public static float min(final float[] ain){
    	float[] a=ain;
    	float r=Float.MAX_VALUE;
    	for(int i=0;i<a.length;i++){
    		if(a[i]<r){
    			r=a[i];
    		}
    	}
    	return r;    	
    }
    
    /**
     * 
     * @param ain
     * @return
     */
    public static long min(final long[] ain){
    	long[] a=ain;
    	long r=Long.MAX_VALUE;
    	for(int i=0;i<a.length;i++){
    		if(a[i]<r){
    			r=a[i];
    		}
    	}
    	return r;    	
    }
    
    /**
     * 
     * @param ain
     * @return
     */
    public static double min(final double[] ain){
    	double[] a=ain;
    	double r=Double.MAX_VALUE;
    	for(int i=0;i<a.length;i++){
    		if(a[i]<r){
    			r=a[i];
    		}
    	}
    	return r;    	
    }
    
    /**
     * 
     * @param ain
     * @return
     */
    public static int max(final int[] ain){
    	int[] a=ain;
    	int r=Integer.MIN_VALUE;
    	for(int i=0;i<a.length;i++){
    		if(a[i]>r){
    			r=a[i];
    		}
    	}
    	return r;    	
    }
    
    /**
     * 
     * @param ain
     * @return
     */
    public static float max(final float[] ain){
    	float[] a=ain;
    	float r=Float.MIN_VALUE;
    	for(int i=0;i<a.length;i++){
    		if(a[i]>r){
    			r=a[i];
    		}
    	}
    	return r;    	
    }
    
    /**
     * 
     * @param ain
     * @return
     */
    public static long max(final long[] ain){
    	long[] a=ain;
    	long r=Long.MIN_VALUE;
    	for(int i=0;i<a.length;i++){
    		if(a[i]>r){
    			r=a[i];
    		}
    	}
    	return r;    	
    }
    
    /**
     * 
     * @param ain
     * @return
     */
    public static double max(final double[] ain){
    	double[] a=ain;
    	double r=Double.MIN_VALUE;
    	for(int i=0;i<a.length;i++){
    		if(a[i]>r){
    			r=a[i];
    		}
    	}
    	return r;    	
    }
    
    /**
     * 
     * @param ain
     * @param value
     * @return
     */
    public static int find(final float[] ain,float value){
    	float a[]=ain;
    	int i=0;
    	while(i<a.length){
    		if(a[i]==value)
    			return i;
    		i++;
    	}
    	return -1;
    }
    
    /**
     * add number to array in descending order
     * @param ain
     * @param value
     * @return
     */
    public static float[] sortAdd(final float[] ain,final int i2,final float value){
    	float a[]=ain;
    	int d=a.length+1;
    	int i=0;
    	float o[]=new float[d];
    	while(i<i2){
    		if(a[i]>value)
    			break;
    		o[i]=a[i];
    		i++;
    	}
    	o[i]=value;
    	while(i<i2){
    		o[i+1]=a[i];
    		i++;
    	}
    	return o;
    }
    
   
    
}