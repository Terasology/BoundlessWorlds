/*
 * Copyright 2014 MovingBlocks
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
package org.boundlessworlds.world.generator.facetProviders;

import org.boundlessworlds.world.generation.facets.InfiniteGenFacet;
import org.terasology.math.geom.Vector3f;
import org.terasology.utilities.procedural.BrownianNoise3D;
import org.terasology.utilities.procedural.PerlinNoise;
import org.terasology.world.generation.Facet;
import org.terasology.world.generation.FacetProvider;
import org.terasology.world.generation.Updates;
/**
 * 
 * @author esereja
 */
@Updates(@Facet(InfiniteGenFacet.class))
public class Perlin3DTerainProvider extends Noise3DTerainProvider implements
		FacetProvider {

	private int octaves;
	private int seedOffset;

	/**
	 * 
	 * @param seedOffset
	 * @param zoom
	 * @param octaves
	 * @param frequency
	 * @param multificator
	 * @param increase
	 */
	public Perlin3DTerainProvider(int seedOffset, Vector3f zoom, int octaves,
			double frequency, double multificator, double increase) {
		super(zoom, frequency, multificator, increase);
		this.octaves = octaves;
		this.seedOffset = seedOffset;
	}

	@Override
	public void setSeed(long seed) {
		this.setSurfaceNoise(new BrownianNoise3D(new PerlinNoise(seed
				+ seedOffset), this.octaves));
	}

}
