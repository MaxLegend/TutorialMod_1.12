package com.lg.realism.Craft;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.lg.realism.RegItems;

public class RealismCrafts {
	public static void recipesRegister() {
		GameRegistry.addShapedRecipe(new ResourceLocation("rope"), new ResourceLocation("rope"), new ItemStack(RegItems.rope),new Object[]{
			"Y Y",
			" Y ",
			"YHY",
			'Y', RegItems.dryvineitem,
			'H', RegItems.spokes,
			});
		
		GameRegistry.addShapelessRecipe(new ResourceLocation("apple"), new ResourceLocation("apple"), new ItemStack(Items.APPLE), new Ingredient[] {Ingredient.fromItem(Items.STICK),Ingredient.fromItem(Items.APPLE)});
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(Items.REDSTONE, 1), new ItemStack(Items.STICK, 1), 0.2f);
	}
}
