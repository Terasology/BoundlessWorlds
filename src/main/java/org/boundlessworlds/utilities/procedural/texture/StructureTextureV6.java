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
package org.boundlessworlds.utilities.procedural.texture;

import org.boundlessworlds.utilities.math.Statistics;
import org.boundlessworlds.utilities.random.BitScrampler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.terasology.math.TeraMath;
import org.terasology.utilities.procedural.Noise2D;
import org.terasology.utilities.procedural.Noise3D;
import org.terasology.utilities.random.FastRandom;

/**
 * Deterministic white noise generator
 * @author Esereja
 */
public class StructureTextureV6 implements Noise2D, Noise3D {
	final private int RANDOMS_LENGHT=3465;//27 81 243 729
	
	private int[] randoms;
	private int[] offset;
	
    /**
     * Initialize permutations with a given seed
     *
     * @param seed a seed value used for permutation shuffling
     */
    public StructureTextureV6(long seed) {
       FastRandom rand=new FastRandom(seed);
       randoms=new int[RANDOMS_LENGHT];
       for(int i=0;i<randoms.length;i++){
    	   randoms[i]=rand.nextInt(); 
       }
       offset= new int[4];
       for(int i=0;i<offset.length;i++){
    	   offset[i]=rand.nextInt(); 
       }

    }


    /**
     * 2D semi white noise
     *
     * @param xin the x input coordinate
     * @param yin the y input coordinate
     * @return a noise value in the interval [-1,1]
     */
    @Override
    public float noise(float xin, float yin) {
    	int x=TeraMath.floorToInt(xin);
    	int y=TeraMath.floorToInt(yin);
    	
        double xw = xin - TeraMath.fastFloor(xin);
        double yw = yin - TeraMath.fastFloor(yin);

        double xn = TeraMath.lerp(
        		BitScrampler.subZero(BitScrampler.oaatHash(
        				randoms[
        				        TeraMath.floorToInt(TeraMath.fastAbs(x)%(randoms.length-1) ) 
        				        ]^x
        				,5 )),
        		BitScrampler.subZero(BitScrampler.oaatHash(
        				randoms[
        				        TeraMath.floorToInt(TeraMath.fastAbs(x+1)%(randoms.length-1) ) 
        				        ]^(x+1)
        				,5 ))
        		, xw );
        
        double yn = TeraMath.lerp(
        		BitScrampler.subZero(BitScrampler.oaatHash(
        				randoms[
        				        TeraMath.floorToInt(TeraMath.fastAbs(y)%(randoms.length-1) ) 
        				        ]^y
        				,5 )),
        		BitScrampler.subZero(BitScrampler.oaatHash(
        				randoms[
        				        TeraMath.floorToInt(TeraMath.fastAbs(y+1)%(randoms.length-1) ) 
        				        ]^(y+1)
        				,5 ))
        		, yw );

        double[] array=new double[3];
        array[0]=xn;
        array[1]=yn;
        double mean = Statistics.aritmeticMean(array);
        double variance = Statistics.variance(array, mean);

        double r=0;
        
        if(!(Statistics.sign(xn)^Statistics.sign(yn))){	
        	r+=variance;
        }else{
        	r-=variance;
        }
        
        r*=5;
        
        return (float) (Math.sin(
        		(r)*3.141*2
        		));
    	} 

    /**
     * 3D semi white noise
     *
     * @param xin the x input coordinate
     * @param yin the y input coordinate
     * @param zin the z input coordinate
     * @return a noise value in the interval [-1,1]
     */
    @Override
    public float noise(float xin, float yin, float zin) {
    	int x=TeraMath.floorToInt(xin)+offset[0];
    	int y=TeraMath.floorToInt(yin)+offset[1];
    	int z=TeraMath.floorToInt(zin)+offset[2];
    	
        double xw = xin - TeraMath.fastFloor(xin);
        double yw = yin - TeraMath.fastFloor(yin);
        double zw = zin - TeraMath.fastFloor(zin);

        double xn = TeraMath.lerp(
        		BitScrampler.subZero(BitScrampler.oaatHash(
        				randoms[
        				        TeraMath.floorToInt(TeraMath.fastAbs(x)%(randoms.length-1) ) 
        				        ]^x
        				,5 )),
        		BitScrampler.subZero(BitScrampler.oaatHash(
        				randoms[
        				        TeraMath.floorToInt(TeraMath.fastAbs(x+1)%(randoms.length-1) ) 
        				        ]^(x+1)
        				,5 ))
        		, xw );
        
        double yn = TeraMath.lerp(
        		BitScrampler.subZero(BitScrampler.oaatHash(
        				randoms[
        				        TeraMath.floorToInt(TeraMath.fastAbs(y)%(randoms.length-1) ) 
        				        ]^y
        				,5 )),
        		BitScrampler.subZero(BitScrampler.oaatHash(
        				randoms[
        				        TeraMath.floorToInt(TeraMath.fastAbs(y+1)%(randoms.length-1) ) 
        				        ]^(y+1)
        				,5 ))
        		, yw );

        double zn = TeraMath.lerp(
        		BitScrampler.subZero(BitScrampler.oaatHash(
        				randoms[
        				        TeraMath.floorToInt(TeraMath.fastAbs(z)%(randoms.length-1) ) 
        				        ]^z
        				,5 )),
        		BitScrampler.subZero(BitScrampler.oaatHash(
        				randoms[
        				        TeraMath.floorToInt(TeraMath.fastAbs(z+1)%(randoms.length-1) ) 
        				        ]^(z+1)
        				,5 ))
        		, zw );

        double[] array=new double[3];
        array[0]=xn;
        array[1]=yn;
        array[2]=zn;
        double mean = Statistics.aritmeticMean(array);
        double variance = Statistics.variance(array, mean);

        double r=0;
        
        if(!(Statistics.sign(xn)^Statistics.sign(yn)^Statistics.sign(zn))){	
        	r+=variance;
        }else{
        	r-=variance;
        }
        
        r*=5;
        
        return (float) (Math.sin(
        		(r)*3.141*2
        		));
    	} 


    /**
     * 4D semi white noise
     *
     * @param xin the x input coordinate
     * @param yin the y input coordinate
     * @param zin the z input coordinate
     * @return a noise value in the interval [-1,1]
     */
    public float noise(float xin, float yin, float zin, float win) {
       	int x=TeraMath.floorToInt(xin);
    	int y=TeraMath.floorToInt(yin);
    	int z=TeraMath.floorToInt(zin);
    	int w=TeraMath.floorToInt(win);
    	
        double xw = xin - TeraMath.fastFloor(xin);
        double yw = yin - TeraMath.fastFloor(yin);
        double zw = zin - TeraMath.fastFloor(zin);
        double ww = zin - TeraMath.fastFloor(win);

        double xn = TeraMath.lerp(
        		BitScrampler.subZero(BitScrampler.oaatHash(
        				randoms[
        				        TeraMath.floorToInt(TeraMath.fastAbs(x)%(randoms.length-1) ) 
        				        ]^x
        				,5 )),
        		BitScrampler.subZero(BitScrampler.oaatHash(
        				randoms[
        				        TeraMath.floorToInt(TeraMath.fastAbs(x+1)%(randoms.length-1) ) 
        				        ]^(x+1)
        				,5 ))
        		, xw );
        
        double yn = TeraMath.lerp(
        		BitScrampler.subZero(BitScrampler.oaatHash(
        				randoms[
        				        TeraMath.floorToInt(TeraMath.fastAbs(y)%(randoms.length-1) ) 
        				        ]^y
        				,5 )),
        		BitScrampler.subZero(BitScrampler.oaatHash(
        				randoms[
        				        TeraMath.floorToInt(TeraMath.fastAbs(y+1)%(randoms.length-1) ) 
        				        ]^(y+1)
        				,5 ))
        		, yw );

        double zn = TeraMath.lerp(
        		BitScrampler.subZero(BitScrampler.oaatHash(
        				randoms[
        				        TeraMath.floorToInt(TeraMath.fastAbs(z)%(randoms.length-1) ) 
        				        ]^z
        				,5 )),
        		BitScrampler.subZero(BitScrampler.oaatHash(
        				randoms[
        				        TeraMath.floorToInt(TeraMath.fastAbs(z+1)%(randoms.length-1) ) 
        				        ]^(z+1)
        				,5 ))
        		, zw );
        
        double wn = TeraMath.lerp(
        		BitScrampler.subZero(BitScrampler.oaatHash(
        				randoms[
        				        TeraMath.floorToInt(TeraMath.fastAbs(w)%(randoms.length-1) ) 
        				        ]^w
        				,5 )),
        		BitScrampler.subZero(BitScrampler.oaatHash(
        				randoms[
        				        TeraMath.floorToInt(TeraMath.fastAbs(w+1)%(randoms.length-1) ) 
        				        ]^(w+1)
        				,5 ))
        		, zw );

        double[] array=new double[4];
        array[0]=xn;
        array[1]=yn;
        array[2]=zn;
        array[3]=wn;
        double mean = Statistics.aritmeticMean(array);
        double variance = Statistics.variance(array, mean);

        double r=0;
        
        if(!(Statistics.sign(xn)^Statistics.sign(yn)^Statistics.sign(zn)^Statistics.sign(wn))){
        	r+=variance;
        }else{
        	r-=variance;
        }
        
        r*=5;
        
        return (float) (Math.sin(
        		(r)*3.141*2
        		));
    	} 

}
