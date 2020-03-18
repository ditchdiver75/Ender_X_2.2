
package net.mcreator.enderx22.world.biome;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.BiomeDictionary;

import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.Biome;

import net.mcreator.enderx22.block.EXNetherackBlock;
import net.mcreator.enderx22.EnderXModElements;

@EnderXModElements.ModElement.Tag
public class HelltuckyBiome extends EnderXModElements.ModElement {
	@ObjectHolder("enderx22:helltucky")
	public static final CustomBiome biome = null;
	public HelltuckyBiome(EnderXModElements instance) {
		super(instance, 167);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new CustomBiome());
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.MOUNTAIN);
	}
	static class CustomBiome extends Biome {
		public CustomBiome() {
			super(new Biome.Builder().downfall(0f).depth(0.54f).scale(0.5f).temperature(0.5f).precipitation(Biome.RainType.NONE)
					.category(Biome.Category.NONE).waterColor(4159204).waterFogColor(329011)
					.surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(EXNetherackBlock.block.getDefaultState(),
							EXNetherackBlock.block.getDefaultState(), EXNetherackBlock.block.getDefaultState())));
			setRegistryName("helltucky");
			DefaultBiomeFeatures.addCarvers(this);
			DefaultBiomeFeatures.addStructures(this);
			DefaultBiomeFeatures.addMonsterRooms(this);
			DefaultBiomeFeatures.addOres(this);
		}
	}
}
