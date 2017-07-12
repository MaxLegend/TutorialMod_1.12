package com.tutmod.tutmod.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import com.tutmod.tutmod.basic.block.BasicBlockFalling;

public class BlockReg {
	
	public static Block testblock = new BasicBlockFalling(Material.GROUND, "testblock", 10F, 10F, "pickaxe", 1, SoundType.PLANT);

	public static void register() {
		registerBlock(testblock);
	}
	public static void registerRender() {
		registerRenderBlock(testblock);
	}
	public static void registerBlock(Block block) {
		ForgeRegistries.BLOCKS.register(block);
		ForgeRegistries.ITEMS.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}
	public static void registerRenderBlock(Block block) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
	}
}