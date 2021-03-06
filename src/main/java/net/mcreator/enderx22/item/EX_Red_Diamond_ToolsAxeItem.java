
package net.mcreator.enderx22.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.AxeItem;

import net.mcreator.enderx22.EnderXModElements;

@EnderXModElements.ModElement.Tag
public class EX_Red_Diamond_ToolsAxeItem extends EnderXModElements.ModElement {
	@ObjectHolder("enderx22:ex_red_diamond_toolsaxe")
	public static final Item block = null;
	public EX_Red_Diamond_ToolsAxeItem(EnderXModElements instance) {
		super(instance, 293);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 100000;
			}

			public float getEfficiency() {
				return 24f;
			}

			public float getAttackDamage() {
				return 58f;
			}

			public int getHarvestLevel() {
				return 20;
			}

			public int getEnchantability() {
				return 140;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(EXRedDiamondItem.block, (int) (1)));
			}
		}, 1, -3f, new Item.Properties().group(ItemGroup.TOOLS)) {
		}.setRegistryName("ex_red_diamond_toolsaxe"));
	}
}
