
package net.mcreator.enderx22.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.enderx22.itemgroup.EnderXItemsItemGroup;
import net.mcreator.enderx22.EnderXModElements;

@EnderXModElements.ModElement.Tag
public class EXTitanium_ToolsSwordItem extends EnderXModElements.ModElement {
	@ObjectHolder("enderx22:extitanium_toolssword")
	public static final Item block = null;
	public EXTitanium_ToolsSwordItem(EnderXModElements instance) {
		super(instance, 251);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 2380;
			}

			public float getEfficiency() {
				return 16f;
			}

			public float getAttackDamage() {
				return 8f;
			}

			public int getHarvestLevel() {
				return 10;
			}

			public int getEnchantability() {
				return 70;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(EXTitaniumIngotItem.block, (int) (1)));
			}
		}, 3, -3f, new Item.Properties().group(EnderXItemsItemGroup.tab)) {
		}.setRegistryName("extitanium_toolssword"));
	}
}
