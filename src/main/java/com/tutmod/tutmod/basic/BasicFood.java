package com.tutmod.tutmod.basic;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

import com.tutmod.tutmod.MainClass;

public class BasicFood extends ItemFood{
	public Item item;
	public BasicFood(int amount, float saturation, boolean isWolfFood,String name,Item item){
		super(amount, saturation, isWolfFood);	
	       this.setRegistryName(name);
	       this.setCreativeTab(MainClass.tabMain);
	       this.setUnlocalizedName(name);
	       this.item = item;
	 }
	 @Override
	 public void onFoodEaten(ItemStack is, World worldIn, EntityPlayer player) {
	  	ItemStack itemSA = new ItemStack(item);
	  	if (!player.capabilities.isCreativeMode) player.getHeldItem(EnumHand.MAIN_HAND).shrink(1);
	  	if (!player.inventory.addItemStackToInventory(itemSA))
		  player.dropItem(itemSA, false);
	 return;
	}
}
